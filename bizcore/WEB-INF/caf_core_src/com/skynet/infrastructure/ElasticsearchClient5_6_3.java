package com.skynet.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ElasticsearchClient5_6_3 implements ESClient {
	protected String clusterHostList;
	protected RestClient lowLevelRestClient = null;
	protected RestHighLevelClient highLevelRestClient = null;
	protected int clusterHostPort = 9200;
	
	
	public String getClusterHostList() {
		return clusterHostList;
	}


	public void setClusterHostList(String clusterHostList) {
		this.clusterHostList = clusterHostList;
	}


	public RestClient getLowLevelRestClient() {
		return lowLevelRestClient;
	}


	public void setLowLevelRestClient(RestClient lowLevelRestClient) {
		this.lowLevelRestClient = lowLevelRestClient;
	}


	public RestHighLevelClient getHighLevelRestClient() {
		return highLevelRestClient;
	}


	public void setHighLevelRestClient(RestHighLevelClient highLevelRestClient) {
		this.highLevelRestClient = highLevelRestClient;
	}


	public int getClusterHostPort() {
		return clusterHostPort;
	}


	public void setClusterHostPort(int clusterHostPort) {
		this.clusterHostPort = clusterHostPort;
	}


	protected void ensureESClientInitialized() throws Exception {
		if (lowLevelRestClient != null && highLevelRestClient != null) {
			return;
		}
		synchronized (this) {
			if (lowLevelRestClient != null && highLevelRestClient != null) {
				return;
			}
			List<HttpHost> hosts = parseHosts(getClusterHostList(), getClusterHostPort());
			lowLevelRestClient = RestClient.builder(hosts.toArray(new HttpHost[0])).build();
			highLevelRestClient = new RestHighLevelClient(lowLevelRestClient);
		}
	}
	
	
	@Override
	public RestHighLevelClient getRestClient() throws Exception {
		return getRestClientOfHighLevel();
	}


	@Override
	public RestHighLevelClient getRestClientOfHighLevel() throws Exception {
		ensureESClientInitialized();
		return getHighLevelRestClient();
	}
	@Override
	public RestClient getRestClientOfLowLevel() throws Exception {
		ensureESClientInitialized();
		return getLowLevelRestClient();
	}

	public static List<HttpHost> parseHosts(String clusterHostList, int clusterPort) {
		String[] hosts = clusterHostList.trim().split("\\s*,\\s*");
		List<HttpHost> result = new ArrayList<HttpHost>();
		for (String host : hosts) {
			if (host.indexOf(':') < 0) {
				result.add(new HttpHost(host, clusterPort));
				continue;
			}
			String[] hostInfo = host.split(":");
			result.add(new HttpHost(hostInfo[0], Integer.parseInt(hostInfo[1])));
		}
		return result;
	}
}
