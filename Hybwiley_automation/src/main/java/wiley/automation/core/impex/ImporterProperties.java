package wiley.automation.core.impex;

public class ImporterProperties {
    private static final String DEFAULT_SESSION_KEY = "JSESSIONID";
    private static final int DEFAULT_IMPORT_TIMEOUT = 30000;
    private String user;
    private String password;
    private String url;
    private String sessionKey = "JSESSIONID";
    private int importTimeout = 30000;

    public ImporterProperties() {
    }

    public String getUser() {
        return this.user;
    }

    public ImporterProperties setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public ImporterProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public ImporterProperties setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSessionKey() {
        return this.sessionKey;
    }

    public ImporterProperties setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    public int getImportTimeout() {
        return this.importTimeout;
    }

    public ImporterProperties setImportTimeout(int importTimeout) {
        this.importTimeout = importTimeout;
        return this;
    }
}