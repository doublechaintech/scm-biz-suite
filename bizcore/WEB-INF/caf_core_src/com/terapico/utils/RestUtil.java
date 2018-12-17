package com.terapico.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUtil {
	private static CloseableHttpClient httpclient = null;

	private static String getResponseAsString(CloseableHttpResponse response) throws IOException {
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity, StandardCharsets.UTF_8);
		return content;
	}

	private static CloseableHttpClient getHttpClient() {
		if (httpclient != null) {
			return httpclient;
		}
		httpclient = HttpClients.createDefault();
		return httpclient;
	}

	public static Map<String, Object> getForJson(URI uri) throws URISyntaxException, IOException {
		CloseableHttpClient client = getHttpClient();
		HttpGet httpget = new HttpGet(uri);

		CloseableHttpResponse response = client.execute(httpget);
		StatusLine resLine = response.getStatusLine();
		String content = getResponseAsString(response);
		System.out.println(new Date() + " http-get got: " + content);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> responseObj = mapper.readValue(content, Map.class);
		responseObj.put("__response", MapUtil.newMap(MapUtil.$("code", resLine.getStatusCode()),
				MapUtil.$("reason", resLine.getReasonPhrase())));
		return responseObj;
	}

	public static URI buildUri(String requestSchema, String requestHost, int requestPort, String requestPath,
			List<NameValuePair> requestParameters) throws URISyntaxException {
		URIBuilder builder = new URIBuilder();
		builder.setScheme(requestSchema);
		builder.setHost(requestHost);
		if (requestPort > 0) {
			builder.setPort(requestPort);
		}
		if (requestPath != null) {
			builder.setPath(requestPath);
		}
		if (requestParameters != null) {
			builder.setParameters(requestParameters);
		}
		URI uri = builder.build();
		return uri;
	}
	
}
