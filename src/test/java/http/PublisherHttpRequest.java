package http;

import java.util.concurrent.TimeUnit;

import org.apache.http.entity.StringEntity;

import uol.simple.httpclient.SimpleHttpClient;
import uol.simple.httpclient.SimpleHttpRequest;
import uol.simple.httpclient.SimpleHttpResponse;
import config.ConfigTest;

public class PublisherHttpRequest {

	public static SimpleHttpResponse publishXml(String xml) throws Exception {

		String pathBase = ConfigTest.PUBLISHER_DOMAIN;
		SimpleHttpRequest request = SimpleHttpClient.newPutRequest(pathBase);
		request.setEntity(new StringEntity(xml));
		
		return SimpleHttpClient.executeAvoidingSSL(request, ConfigTest.REQUEST_TIMEOUT, TimeUnit.SECONDS);

	}

}
