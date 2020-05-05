package com.skynet.infrastructure;

import com.terapico.utils.TextUtil;

public class AliyunServiceConfiguration {
	public static final String REGION_CN_SHENZHEN = "cn-shenzhen";
	public static final String REGION_CN_BEIJING = "cn-beijing";
	public static final String STS_API_VERSION = "2015-04-01";
	
	protected String ossBucket =  "xubai-public";
	protected String accessKeyId = null;
	protected String accessKeySecret = null;
	protected String roleArn = "acs:ram::1258829570663551:role/fileuploader";
	protected String policy = "{\n" 
			+ "  \"Statement\": [\n" 
			+ "    {\n" 
			+ "      \"Action\": [\n"
			+ "        \"oss:PutObject\"\n" 
			+ "      ],\n" 
			+ "      \"Effect\": \"Allow\",\n"
			+ "      \"Resource\": [\"acs:oss:*:*:BUCKET_ID/USER_HOME/*\"]\n" 
			+ "    }\n" 
			+ "  ],\n"
			+ "  \"Version\": \"1\"\n" 
			+ "}";
	protected String endpoint = "oss-cn-beijing.aliyuncs.com";
	protected String region = REGION_CN_BEIJING;
	protected String stsVersion = STS_API_VERSION;
	protected long durationSeconds = 3600;

	protected String signName ="Art0X";
	protected String product = "Dysmsapi";
	protected String domain = "dysmsapi.aliyuncs.com";

	public String getSignName() {
		return signName;
	}

	public void setSignName(String pSignName) {
		signName = pSignName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String pProduct) {
		product = pProduct;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String pDomain) {
		domain = pDomain;
	}

	protected String getValueByConfig(String cfgValue) {
		if (TextUtil.isBlank(cfgValue)) {
			return null;
		}
		if (cfgValue.trim().toLowerCase().startsWith("env:")) {
			String key = cfgValue.trim().substring(4).trim();
			return TextUtil.getExtVariable(key, null);
		}
		return cfgValue.trim();
	}
	
	public String getOssBucket() {
		return ossBucket;
	}
	public void setOssBucket(String ossBucket) {
		this.ossBucket = ossBucket;
	}
	public String getAccessKeyId() {
		String val = getValueByConfig(accessKeyId);
		if (val != null) {
			return val;
		}
		return TextUtil.getExtVariable("ALIYUN_ACCESS_KEY_ID", accessKeyId);
	}
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}
	public String getAccessKeySecret() {
		String val = getValueByConfig(accessKeySecret);
		if (val != null) {
			return val;
		}
		return TextUtil.getExtVariable("ALIYUN_ACCESS_KEY_SECRET", accessKeySecret);
	}
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}
	public String getRoleArn() {
		String val = getValueByConfig(roleArn);
		if (val != null) {
			return val;
		}
		return TextUtil.getExtVariable("ALIYUN_ROLE_ARN", roleArn);
	}
	public void setRoleArn(String roleArn) {
		this.roleArn = roleArn;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStsVersion() {
		return stsVersion;
	}
	public void setStsVersion(String stsVersion) {
		this.stsVersion = stsVersion;
	}
	public long getDurationSeconds() {
		return durationSeconds;
	}
	public void setDurationSeconds(long durationSeconds) {
		this.durationSeconds = durationSeconds;
	}
	
	
	
}
