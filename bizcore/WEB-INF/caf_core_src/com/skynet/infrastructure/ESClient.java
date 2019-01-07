package com.skynet.infrastructure;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public interface ESClient {
	RestHighLevelClient getRestClient() throws Exception;
	
	RestHighLevelClient getRestClientOfHighLevel() throws Exception;

	RestClient getRestClientOfLowLevel() throws Exception;

}
