package wiley.automation.core.hybris;

import wiley.automation.core.hybris.PropertiesReader;
import wiley.automation.core.util.EnvUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.config.SessionConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HybrisRequestor {
    private static final int IMPORT_RETRY_COUNT = 3;
    private static final int importTimeout = 50000;

    private static StopWatch timer = new StopWatch();
    private static final Logger LOG = LoggerFactory.getLogger(HybrisRequestor.class);

    private static String username;
    private static String password;
    private static String url;
    private static String sessionKey;
    private static String data;

    private static RequestSpecification requestSpecification = null;
    private static String _csrf = null;

    static {
        username = EnvUtil.getProperty("hybris.hac.username");
        password = EnvUtil.getProperty("hybris.hac.password");
        sessionKey = EnvUtil.getProperty("hybris.hac.sessionKey");
        url =  EnvUtil.getProperty("webdriver.base.url.hac");
        data=EnvUtil.getProperty("WEL_STOREFRONT_URL_UAT");

        refreshRequestSpecification();
    }

    private static void refreshRequestSpecification(){
        requestSpecification = (new RequestSpecBuilder()).setConfig(RestAssuredConfig.newConfig()
                .sessionConfig((new SessionConfig()).sessionIdName(sessionKey)).sslConfig((new SSLConfig()).relaxedHTTPSValidation())).setBaseUri(url).build();

        LOG.info("Make authorization request");
        Response response = RestAssured.given(requestSpecification).get("/navigation.jsp");
        String csrf = response.body().htmlPath().getString("html.head.meta.find { it.@name == \'_csrf\' }.@content");
        LOG.debug("CSRF token for authorization is {}", csrf);
        requestSpecification.sessionId(response.getSessionId() == null ? "no-session" : response.getSessionId());
        response = RestAssured.given(requestSpecification).contentType(ContentType.URLENC).formParam("_csrf", csrf).formParam("j_username", username).formParam("j_password", password).post("/j_spring_security_check");
        requestSpecification.sessionId(response.getSessionId() == null ? "no-session" : response.getSessionId());
        LOG.debug("Authorized session is {}", response.getSessionId());

        response = RestAssured.given(requestSpecification).get("/console/impex/import");
        _csrf = response.body().htmlPath().getString("html.head.meta.find { it.@name == \'_csrf\' }.@content");
    }

    public static void runImport(String scriptContent){
        LOG.info("Make import request");

        for(int i = 0; i < IMPORT_RETRY_COUNT;i++) {
            timer.start();

            do {
                RequestSpecification importRequest = (new RequestSpecBuilder()).
                        addRequestSpecification(requestSpecification).addParam("_csrf", _csrf).
                        addParam("scriptContent", scriptContent).
                        addParam("validationEnum", "IMPORT_STRICT").
                        addParam("maxThreads", "1").
                        addParam("encoding", "UTF-8").
                        addParam("_legacyMode", "on").
                        addParam("enableCodeExecution", "true").
                        addParam("_enableCodeExecution", "on")
                        .build();

                if (runRequest(importRequest, "/console/impex/import").getStatusCode() == 200) {
                    LOG.info("Import done. It took {} ms", timer.getTime());
                    timer.reset();
                    return;
                }
            } while (timer.getTime() <= (long) importTimeout);

            timer.reset();
        }

        throw new IllegalStateException(String.format("Failed to perform import more than %d ms", importTimeout));
    }

    public static void runScripting(String script, int repeatCount){
        LOG.info("Make import request");

        for(int i = 0; i < IMPORT_RETRY_COUNT;i++) {
            timer.start();

            do {
                RequestSpecification importRequest = (new RequestSpecBuilder()).
                        addRequestSpecification(requestSpecification).
                        addFormParam("_csrf", _csrf).
                        addFormParam("MIME Type", "application/x-www-form-urlencoded").
                        addFormParam("script", script).
                        addFormParam("scriptType", "groovy").
                        addFormParam("commit", new Object[]{"true"}).build();
                Response res = null;
                for(int j = 0; j < repeatCount;j++){
                    res = runRequest(importRequest, "/console/scripting/execute");
                    if(res.getBody().asString().contains("MissingMethodException")) {
                        LOG.error(res.getBody().asString());
                        break;
                    }
                }
                if (res.getStatusCode() == 200) {
                    res.getBody().print();
                    LOG.info("Import done. It took {} ms", timer.getTime());
                    timer.reset();
                    return;
                }
            } while (timer.getTime() <= (long) importTimeout);

            timer.reset();
        }

        throw new IllegalStateException(String.format("Failed to perform import more than %d ms", importTimeout));
    }

    private static Response runRequest(RequestSpecification importRequest, String url){
        Response response = RestAssured.given(importRequest).post(url);
        if(response.getStatusCode() == 403){
            sessionKey = sessionKey.equals("JSESSIONID") ? "WJSESSIONID":"JSESSIONID";
            refreshRequestSpecification();
        }
        LOG.debug(response.statusLine());
        return response;
    }
}
