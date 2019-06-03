package wiley.automation.core.impex;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.config.SessionConfig;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ImpexImporter {
    private static final int STEP_TIMEOUT = 6000;
    private static final int IMPORT_RETRY_COUNT = 3;
    public static int importTimeout = 50000;
    private static String username;
    private static String password;
    private static String currentSessionKey = "";
    private static RequestSpecification request = null;
    private static StopWatch timer = new StopWatch();
    private static final Logger LOG = LoggerFactory.getLogger(ImpexImporter.class);

    private ImpexImporter() {
    }

    public static void setParameters(ImporterProperties properties) {
        username = properties.getUser();
        password = properties.getPassword();
        importTimeout = properties.getImportTimeout();
        buildBaseRequest(properties.getSessionKey(), properties.getUrl());
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static void setCredentials(String user, String pass) {
        username = user;
        password = pass;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static void setParameters(String url, String sessionKey) {
        Pattern pattern = Pattern.compile("(http(s|)://.+?)(/|$)");
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find()) {
            throw new IllegalStateException("Failed to extract URL for import");
        } else {
            String uri = String.format("%s/hac", new Object[]{matcher.group(1)});
            LOG.info("Using {} URI for impex upload", uri);
            LOG.debug("Using {} key for session", sessionKey);
            buildBaseRequest(sessionKey, uri);
        }
    }

    private static void buildBaseRequest(String sessionKey, String uri) {
        currentSessionKey = sessionKey;
        request = (new RequestSpecBuilder()).setConfig(RestAssuredConfig.newConfig()
                .sessionConfig((new SessionConfig()).sessionIdName(sessionKey)).sslConfig((new SSLConfig()).relaxedHTTPSValidation())).setBaseUri(uri).build();
    }

    @Deprecated
    public static void makeAuthorizationRequest() {
        LOG.info("Make authorization request");
        Response response = (Response) RestAssured.given(request).get("/navigation.jsp", new Object[0]);
        String csrf = response.body().htmlPath().getString("html.head.meta.find { it.@name == \'_csrf\' }.@content");
        LOG.debug("CSRF token for authorization is {}", csrf);
        request.sessionId(response.getSessionId() == null ? "no-session" : response.getSessionId());
        response = (Response) RestAssured.given(request).contentType(ContentType.URLENC).formParam("_csrf", new Object[]{csrf}).formParam("j_username", new Object[]{username}).formParam("j_password", new Object[]{password}).post("/j_spring_security_check", new Object[0]);
        request.sessionId(response.getSessionId() == null ? "no-session" : response.getSessionId());
        LOG.debug("Authorized session is {}", response.getSessionId());
    }

    private static void waitABit(long milliseconds) {
        try {
            LOG.debug("Wait {} milliseconds and retry", Long.valueOf(milliseconds));
            Thread.sleep(milliseconds);
        } catch (InterruptedException var3) {
            LOG.error("Import process was interrupted. {}", var3.getLocalizedMessage());
        }

    }

    private static String getCsrf(){
        Response response = (Response) RestAssured.given(request).get("/console/impex/import", new Object[0]);
        return response.body().htmlPath().getString("html.head.meta.find { it.@name == \'_csrf\' }.@content");
    }

    private static String getCsrf2(){
        Response response = (Response) RestAssured.given(request).get("/console/scripting", new Object[0]);
        return response.body().htmlPath().getString("html.head.meta.find { it.@name == \'_csrf\' }.@content");
    }

    private static Response runRequest(RequestSpecification importRequest, String url){
        Response response = (Response) RestAssured.given(importRequest).post(url, new Object[0]);
        if(response.getStatusCode() == 403){
            buildBaseRequest(currentSessionKey.equals("JSESSIONID") ? "WJSESSIONID":"JSESSIONID", ((RequestSpecificationImpl) request).getBaseUri());
            makeAuthorizationRequest();
        }
        LOG.debug(response.statusLine());

        waitABit(1000L);
        return response;
    }

    @Deprecated
    public static void runImport(String impexString) {
        LOG.info("Make import request");

        for(int i = 0; i < IMPORT_RETRY_COUNT;i++) {
            timer.start();

            do {
                RequestSpecification importRequest = (new RequestSpecBuilder()).
                        addRequestSpecification(request).addParam("_csrf", new Object[]{getCsrf()}).
                        addParam("scriptContent", new Object[]{impexString}).
                        addParam("validationEnum", new Object[]{"IMPORT_STRICT"}).
                        addParam("maxThreads", new Object[]{"1"}).
                        addParam("encoding", new Object[]{"UTF-8"}).
                        addParam("_legacyMode", new Object[]{"on"}).
                        addParam("enableCodeExecution", new Object[]{"true"}).
                        addParam("_enableCodeExecution", new Object[]{"on"}).build();

                if (runRequest(importRequest, "/console/impex/import").getStatusCode() == 200) {
                    LOG.info("Import done. It took {} ms", Long.valueOf(timer.getTime()));
                    timer.reset();
                    return;
                }
            } while (timer.getTime() <= (long) importTimeout);

            timer.reset();
        }

        throw new IllegalStateException(String.format("Failed to perform import more than %d ms", new Object[]{Integer.valueOf(importTimeout)}));
    }

    @Deprecated
    public static void runScripting(String impexString) {
        LOG.info("Make import request");

        for(int i = 0; i < IMPORT_RETRY_COUNT;i++) {
            timer.start();

            do {
                RequestSpecification importRequest = (new RequestSpecBuilder()).
                        addRequestSpecification(request).
                        addFormParam("_csrf", new Object[]{getCsrf2()}).
                        addFormParam("MIME Type", "application/x-www-form-urlencoded").
                        addFormParam("script", new Object[]{impexString}).
                        addFormParam("scriptType", new Object[]{"groovy"}).
                        addFormParam("commit", new Object[]{"true"}).build();
                Response res = null;
                for(int j = 0; j < 5;j++){
                     res = runRequest(importRequest, "/console/scripting/execute");
                     if(res.getBody().asString().contains("MissingMethodException")) {
                         LOG.error(res.getBody().asString());
                         break;
                     }
                }
                if (res.getStatusCode() == 200) {
                    res.getBody().print();
                    LOG.info("Import done. It took {} ms", Long.valueOf(timer.getTime()));
                    timer.reset();
                    return;
                }
            } while (timer.getTime() <= (long) importTimeout);

            timer.reset();
        }

        throw new IllegalStateException(String.format("Failed to perform import more than %d ms", new Object[]{Integer.valueOf(importTimeout)}));
    }
}