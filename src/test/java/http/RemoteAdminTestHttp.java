package http;

import java.util.concurrent.TimeUnit;

import uol.simple.httpclient.SimpleHttpClient;
import uol.simple.httpclient.SimpleHttpRequest;
import uol.simple.httpclient.SimpleHttpResponse;
import config.ConfigTest;

public class RemoteAdminTestHttp {

    private static final String REMOTE_ADMIN_TEST_DOMAIN = ConfigTest.ADMANAGER_DOMAIN;
    private static final Integer REQUEST_TIMEOUT = ConfigTest.REQUEST_TIMEOUT;

    public static SimpleHttpResponse cat(String filePath) throws Exception {
        final SimpleHttpRequest catRequest = SimpleHttpClient
                .newGetRequest(REMOTE_ADMIN_TEST_DOMAIN, "cat")
                .addQueryParam("file", filePath);

        return SimpleHttpClient.execute(catRequest, REQUEST_TIMEOUT, TimeUnit.SECONDS);
    }

    public static SimpleHttpResponse shell(String domain, String command) throws Exception {
        return executeShell(domain, command);
    }

    public static SimpleHttpResponse shell(String command) throws Exception {
        return executeShell(REMOTE_ADMIN_TEST_DOMAIN, command);
    }

    private static SimpleHttpResponse executeShell(String domain, String command) throws Exception {
        final SimpleHttpRequest shellRequest = SimpleHttpClient
                .newGetRequest(domain, "shell")
                .addQueryParam("command", command)
                .addQueryParam("timeout", REQUEST_TIMEOUT.toString());

        return SimpleHttpClient.execute(shellRequest, REQUEST_TIMEOUT, TimeUnit.SECONDS);
    }

    public static SimpleHttpResponse telnet(String server, String port, String command, String timeout) throws Exception {
        final SimpleHttpRequest telnetRequest = SimpleHttpClient.
                newGetRequest(REMOTE_ADMIN_TEST_DOMAIN, "telnet")
                .addQueryParam("server", server)
                .addQueryParam("port", port)
                .addQueryParam("command", command)
                .addQueryParam("timeout", timeout);

        return SimpleHttpClient.execute(telnetRequest, REQUEST_TIMEOUT, TimeUnit.SECONDS);
    }
}
