package com.skynet.infrastructure.graphservice;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skynet.infrastructure.GraphService;


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

	public  boolean addEdge(String projectName, String edgeType, String fromType, String toType, String from, String to) {
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
	public  boolean deleteEdge(String projectName, String edgeType, String from, String to) {
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
	public  boolean batchInsertNode(String projectName, Map<String, List<String>> batchData) {
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
	public  boolean batchInsertEdge(String projectName, Map<String, List<EdgeValueInstance>> batchEdgeData) {
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
	public static void main(String[] args)
			throws ClientProtocolException, IOException {
		//test batch node
//		Map<String, List<String>> batchData = new HashMap<String, List<String>>();
//		List<String> list1 = new ArrayList<String>();
//		List<String> list2 = new ArrayList<String>();
//		list1.add("0000001");
//		list1.add("0000002");
//		list1.add("0000003");
//		list1.add("0000004");
//		list2.add("0000005");
//		list2.add("0000006");
//		batchData.put("AccountingDocument", list1);
//		batchData.put("AccountingDocumentAuditing", list2);
		//test batchEdge
//		Map<String, List<EdgeValueInstance>> batchEdgeData = new HashMap<String, List<EdgeValueInstance>>();
//		List<EdgeValueInstance> list1 = new ArrayList<EdgeValueInstance>();
//		List<EdgeValueInstance> list2 = new ArrayList<EdgeValueInstance>();
//		EdgeValueInstance e1 = new EdgeValueInstance("AD000163", "ADT000009");
//		EdgeValueInstance e2 = new EdgeValueInstance("AD000358", "ADT000018");
//		EdgeValueInstance e3 = new EdgeValueInstance("AD000281", "ADT000015");
//		list1.add(e1);list1.add(e2);list1.add(e3);
//		batchEdgeData.put("AccountingDocument_AccountingDocumentType", list1);
//		EdgeValueInstance e4 = new EdgeValueInstance("AD000110", "AP000006");
//		EdgeValueInstance e5 = new EdgeValueInstance("AD000118", "AP000006");
//		EdgeValueInstance e6 = new EdgeValueInstance("AD000163", "AP000016");
//		list2.add(e4);list2.add(e5);list2.add(e6);
//		batchEdgeData.put("AccountingDocument_AccountingPeriod", list2);
//		System.out.println(batchInsertEdge(batchEdgeData));
		//relationsOf1("PotentialCustomerContactPerson","111c","CityPartner", "CP000001");
		//System.out.println(relationsOf1("ServiceVehicleMovementM2m","SVMM000073","City","C000003"));
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
}
