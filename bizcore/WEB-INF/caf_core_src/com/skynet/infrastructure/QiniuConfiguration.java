package com.skynet.infrastructure;

public class QiniuConfiguration {
    String accessKey = "oAra_ydd00vRbNLVU1Jq6SSMvgDD381uMHut5NIw";
    String secretKey = "ceqcur-3hIhfy-zaxnub";
    String bucket = "doublechain";

    int timeout = 1800;
    //additional parameters
    String uploadPrefix = "http://upload-z2.qiniup.com";
    String downloadPrefix = "http://q02t08ijf.bkt.clouddn.com";

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String pAccessKey) {
        accessKey = pAccessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String pSecretKey) {
        secretKey = pSecretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String pBucket) {
        bucket = pBucket;
    }

    public String getUploadPrefix() {
        return uploadPrefix;
    }

    public void setUploadPrefix(String pUploadPrefix) {
        uploadPrefix = pUploadPrefix;
    }

    public String getDownloadPrefix() {
        return downloadPrefix;
    }

    public void setDownloadPrefix(String pDownloadPrefix) {
        downloadPrefix = pDownloadPrefix;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int pTimeout) {
        timeout = pTimeout;
    }
}
