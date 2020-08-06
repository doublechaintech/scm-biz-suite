package com.skynet.infrastructure;

public class AliyunBaseService {
    public String getAccessKeyId() {
		return System.getenv("ALIYUN_ACCESS_KEY_ID");
	}
	
	public String getAccessKeySecret() {
		return System.getenv("ALIYUN_ACCESS_KEY_SECRET");
	}
	
	
}
