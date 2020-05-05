package com.skynet.infrastructure.graphservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skynet.infrastructure.ConversionService;
import com.skynet.infrastructure.GraphService;
import com.terapico.utils.DateTimeUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.*;


public class GraphServiceImpl implements GraphService{


	public String getProtocol() {
		return protocol;
	}
	private String protocol = "http";
	private int port = 8480;
	private String host = "localhost";

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}



	public  boolean addNode(String projectName, String nodeType, String nodeKey) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			HttpHost host = new HttpHost(getHost(), getPort(), getProtocol());
			HttpGet getRequest = new HttpGet(
					"/addNode/" +withProjectName(projectName) + nodeType + "/" + nodeKey);
			httpResponse = httpClient.execute(host, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				ObjectMapper om = new ObjectMapper();
				String result = EntityUtils.toString(entity);
				Map map = om.readValue(result, Map.class);
				if (map.get("key") != null) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(httpClient, httpResponse);
		}
	}



	public  boolean deleteNode(String projectName, String nodeType, String nodeKey) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			HttpHost host = new HttpHost(getHost(), getPort(), getProtocol());
			HttpGet getRequest = new HttpGet(
					"/deleteNode/" +withProjectName(projectName) + nodeType + "/" + nodeKey);
			httpResponse = httpClient.execute(host, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				
				ObjectMapper om = new ObjectMapper();
				String result = EntityUtils.toString(entity);
				if (result == null || result.isEmpty()) {
					return true;
				}
				Map map = om.readValue(result, Map.class);
				if (map.get("status") != null) {
					return false;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(httpClient, httpResponse);
		}
	}

	public  boolean addEdge0(String projectName, String edgeType, String fromType, String toType, String from, String to) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			HttpHost host = new HttpHost(getHost(), getPort(), getProtocol());
			HttpGet getRequest = new HttpGet(
					"/addEdge/" +withProjectName(projectName) + edgeType + "/" + fromType + "/" + toType + "/" + from + "/" + to);
			httpResponse = httpClient.execute(host, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				ObjectMapper om = new ObjectMapper();
				String result = EntityUtils.toString(entity);
				Map map = om.readValue(result, Map.class);
				if (map.get("key") != null) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(httpClient, httpResponse);
		}
	}
	public  boolean deleteEdge0(String projectName, String edgeType, String from, String to) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			HttpHost host = new HttpHost(getHost(), getPort(), getProtocol());
			HttpGet getRequest = new HttpGet(
					"/deleteEdge/" +withProjectName(projectName) + edgeType + "/" + from + "/" + to);
			httpResponse = httpClient.execute(host, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				ObjectMapper om = new ObjectMapper();
				String result = EntityUtils.toString(entity);
				if (result == null || result.isEmpty()) {
					return true;
				}
				Map map = om.readValue(result, Map.class);
				if (map.get("status") != null) {
					return false;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(httpClient, httpResponse);
		}
	}
	public  boolean batchInsertNode0(String projectName, Map<String, List<String>> batchData) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			HttpHost host = new HttpHost(getHost(), getPort(), getProtocol());
			HttpPost postRequest = new HttpPost("/batchInsertNode/" + appendProjectName(projectName));
			postRequest.setHeader("Content-type", "application/json; charset=utf-8");
			ObjectMapper om = new ObjectMapper();
			String jsonData = om.writeValueAsString(batchData);
			StringEntity entity = new StringEntity(jsonData, Charset.forName("UTF-8"));
			entity.setContentEncoding("UTF-8");
	        entity.setContentType("application/json");
	        postRequest.setEntity(entity);
			System.out.println(jsonData);
			httpResponse = httpClient.execute(host, postRequest);
			HttpEntity responsEntity = httpResponse.getEntity();
			if (responsEntity != null) {
				String result = EntityUtils.toString(responsEntity);
				if ("success".equals(result)) {
					return true;
				}
				Map map = om.readValue(result, Map.class);
				if (map.get("status") != null) {
					return false;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(httpClient, httpResponse);
		}
	}
	public  boolean batchInsertEdge0(String projectName, Map<String, List<EdgeValueInstance>> batchEdgeData) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			HttpHost host = new HttpHost(getHost(), getPort(), getProtocol());
			HttpPost postRequest = new HttpPost("/batchInsertEdge/" + appendProjectName(projectName));
			postRequest.setHeader("Content-type", "application/json; charset=utf-8");
			ObjectMapper om = new ObjectMapper();
			String jsonData = om.writeValueAsString(batchEdgeData);
			StringEntity entity = new StringEntity(jsonData, Charset.forName("UTF-8"));
			entity.setContentEncoding("UTF-8");
	        entity.setContentType("application/json");
	        postRequest.setEntity(entity);
			System.out.println(jsonData);
			httpResponse = httpClient.execute(host, postRequest);
			HttpEntity responsEntity = httpResponse.getEntity();
			if (responsEntity != null) {
				String result = EntityUtils.toString(responsEntity);
				if ("successEdge".equals(result)) {
					return true;
				}
				Map map = om.readValue(result, Map.class);
				if (map.get("status") != null) {
					return false;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(httpClient, httpResponse);
		}
	}

	private  void close(CloseableHttpClient httpClient,
			CloseableHttpResponse httpResponse) {
		if (httpResponse != null) {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (httpClient != null) {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private  static void close1(CloseableHttpClient httpClient,
			CloseableHttpResponse httpResponse) {
		if (httpResponse != null) {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (httpClient != null) {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	protected String withProjectName(String projectName ) {
		return projectName +        "/";
	}
	public List<String[]> relationsOf(String projectName, String fromLabel, String fromId,
			String toLable, String toId) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			HttpHost host = new HttpHost(getHost(), getPort(), getProtocol());
			HttpGet getRequest = new HttpGet(
					"/relationsOf/" +withProjectName(projectName) + fromLabel + "/" + fromId + "/" + toLable + "/" + toId);
//			HttpGet getRequest = new HttpGet(
//					"/relationsOf/" + fromLabel + "/" + fromId + "/" + toLable + "/" + toId);
			httpResponse = httpClient.execute(host, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				ObjectMapper om = new ObjectMapper();
				String result = EntityUtils.toString(entity);
				if (result.startsWith("[")) {
					List<List> relationsList = om.readValue(result, List.class);
					if (relationsList != null && !relationsList.isEmpty()) {
						List<String[]> relations = new ArrayList<String[]>();
						for (List<String> list : relationsList) {							
							relations.add((String[])list.toArray(new String[0]));
						}
						return relations;
					} else {
						return new ArrayList<String[]>();
					}
				} else {
					return null;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close(httpClient, httpResponse);
		}
	}
	public boolean truncateAndImportAllData(String projectName) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		try {
			HttpHost host = new HttpHost(getHost(), getPort(), getProtocol());
			HttpGet getRequest = new HttpGet("/truncateAndImportAllData/" + appendProjectName(projectName));
			httpResponse = httpClient.execute(host, getRequest);
			HttpEntity entity = httpResponse.getEntity();
			if (entity != null) {
				ObjectMapper om = new ObjectMapper();
				String result = EntityUtils.toString(entity);
				System.out.println("result:" + result);
				if (result.isEmpty()) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(httpClient, httpResponse);
		}
	}

	protected String appendProjectName(String projectName) {
		
		return projectName;
	}


	@Override
	public <T> ResultList<T> query(BaseQuery query, Class<T> clazz) throws Exception {
		long t = System.currentTimeMillis();

		RestTemplate restTemplate = new RestTemplate();
		String uri = new HttpHost(getHost(), getPort(), getProtocol()).toURI() + "/search/{projectName}";
		query.returnType(clazz);
		Map map = restTemplate.postForObject(uri, new QueryImpl(query), Map.class, query.getProject());
		System.out.println(	System.currentTimeMillis() - t);

		List current = (List) map.get("current");

		//Type -> (Id -> Entity, entity is map)
		Map<String, Map<String, Object>> allData = collect(current);

		//Type -> (Id -> Entity, entity is the base entity)
		Map<String, Map<String, Object>> objectTree  = createObjectTree(allData, query);

		mergeData(objectTree, allData, query);

		Map<String, Object> itemMap = objectTree.get(clazz.getSimpleName());
		if (itemMap == null) {
			ResultList resultList = new ResultList();
			resultList.setTotal(0);
			return resultList;
		}
		ResultList resultList = new ResultList(itemMap.values());
		resultList.setTotal((int) map.get("count"));
		System.out.println(	System.currentTimeMillis() - t);
		return resultList;
	}

	private void mergeData(Map<String, Map<String, Object>> pObjTree, Map<String, Map<String, Object>> pAllData, BaseQuery pQuery) {

		for (Map.Entry<String, Map<String, Object>> e : pAllData.entrySet()) {
			String type = e.getKey();
			Class clazz = pQuery.findClass(type);
			if (clazz == null) {
				continue;
			}

			Map<String, Object> finalObjectM = pObjTree.get(clazz.getSimpleName());
			if (finalObjectM == null){
				continue;
			}

			Map<String, Object> objectMap = e.getValue();

			if (objectMap == null){
				continue;
			}

			for (Map.Entry<String, Object> entry: objectMap.entrySet()){
				String id = entry.getKey();
				Object o = finalObjectM.get(id);

				//object there
				if (o == null){
					continue;
				}

				merge(pObjTree, o, (Map<String, Object>) entry.getValue());
			}
		}


	}

	private void merge(Map<String, Map<String, Object>> pObjTree, Object item, Map<String, Object> pValue) {
		BeanWrapper target = new BeanWrapperImpl(item);

		pValue.entrySet().stream().filter(e->!e.getKey().startsWith("_")).forEach(
				e -> {
					try {
						//find this property refer object
						String innerId = (String) target.getPropertyValue(e.getKey() + ".id");
						String type = target.getPropertyType(e.getKey()).getSimpleName();

						//check the refer obj
						Object refer = pObjTree.get(type).get(innerId);
						if (refer == null){
							return;
						}

						//we need add the obj in the refer list
						Method m = null;

						try{
							m = refer.getClass().getMethod("add" + item.getClass().getSimpleName(), item.getClass());
						}catch (Exception exx){
							m = refer.getClass().getMethod("add" + item.getClass().getSimpleName() + "As" + StringUtils.capitalize(e.getKey()), item.getClass());
						}

						if (m != null){
							m.invoke(refer, item);
						}

					}catch (Exception ex){

					}
				}
		);
	}

	private Map<String, Map<String, Object>> createObjectTree(Map<String, Map<String, Object>> pAllData, BaseQuery pQuery) throws Exception{
		Map<String, Map<String, Object>> result = new HashMap<>();


		for (Map.Entry<String, Map<String, Object>> e : pAllData.entrySet()) {
			String type = e.getKey();
			Class clazz = pQuery.findClass(type);
			if (clazz == null) {
				continue;
			}

			Map<String, Object> finalObjectM = result.get(clazz.getSimpleName());
			if (finalObjectM == null){
				finalObjectM = new LinkedHashMap<>();
				result.put(clazz.getSimpleName(), finalObjectM );
			}

			Map<String, Object> objectMap = e.getValue();

			if (objectMap == null){
				continue;
			}

			for (Map.Entry<String, Object> entry: objectMap.entrySet()){
				String id = entry.getKey();
				Object o = finalObjectM.get(id);

				//object there
				if (o != null){
					continue;
				}

				//create all obj
				o = clazz.newInstance();
				copyBasic(o, (Map<String, Object>) entry.getValue());
				finalObjectM.put(id, o);
			}
		}

		return result;
	}

	private void copyBasic(Object entity, Map<String, Object> item) {
		BeanWrapper target = new BeanWrapperImpl(entity);
		DefaultConversionService conversionService = new ConversionService();
		conversionService.addConverter(String.class, Date.class, DateTimeUtil::parseInputDateTime);

		target.setConversionService(conversionService);

		item.entrySet().stream().filter(e->!e.getKey().startsWith("_")).forEach(
			e -> {
				String p = e.getKey();
				target.setPropertyValue(p, String.valueOf(e.getValue()));
			}
		);
	}


	private Map<String, Map<String, Object>> collect(List pResults) {
		Map<String, Map<String, Object>> allData = new LinkedHashMap<>();
		pResults.stream().forEach(
				o ->{
					Map<String, Object> m = (Map<String, Object>) o;

					m.entrySet().stream().forEach(e -> {
						String type = e.getKey();

						Map<String, Object> typeMap = allData.get(type);
						if (typeMap == null){
							typeMap = new LinkedHashMap<>();
							allData.put(type, typeMap);
						}

						Map<String, Object> item = (Map<String, Object>) e.getValue();
						String id = (String) item.get("id");
						typeMap.put(id, item);
					});
				}
		);
		return allData;
	}

}
