package com.terapico.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUtil {
	private static CloseableHttpClient httpclient = null;

	private static String getResponseAsString(CloseableHttpResponse response) throws IOException {
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity, StandardCharsets.UTF_8);
		return content;
	}

	public static Object remoteGetObject(String sessionId, String url, Class<?> clazz)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = getHttpClient();
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("Accept", "application/json");
		getRequest.addHeader("Cookie", sessionId);
		getRequest.addHeader("X-Auth", sessionId);

		HttpResponse response = httpClient.execute(getRequest);
		
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		
		Object responseObj = mapper.readValue(br, clazz);
		
		return responseObj;
		
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
	
	public static String postXml(String url, String xml,String encoding) throws  IOException{
        String body = "";

        CloseableHttpClient client = getHttpClient();

        HttpPost httpPost = new HttpPost(url);
        
        httpPost.setHeader("Content-Type", "text/xml; charset=UTF-8");
        StringEntity entityParams = new StringEntity(xml, encoding);
        httpPost.setEntity(entityParams);
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        response.close();
        return body;
    }


	public static String postJson(String url, String json) throws Exception{
		String body = "";

		CloseableHttpClient client = getHttpClient();

		HttpPost httpPost = new HttpPost(url);

		StringEntity entityParams = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		try{
			entityParams = new StringEntity(json);
			httpPost.setEntity(entityParams);
			response = client.execute(httpPost);
			entity = response.getEntity();
			if (entity != null) {
				body = EntityUtils.toString(entity);
			}
		}
		catch(Exception e){

		}finally {
			EntityUtils.consume(entity);
			if (response != null){
				response.close();
			}
		}

		return body;
	}
}
