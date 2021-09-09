package com.skynet.infrastructure;

public class LocationInfo {
    protected String ipAddress;
    protected String mainInfo;
    protected String subInfo;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(String mainInfo) {
        this.mainInfo = mainInfo;
    }

    public String getSubInfo() {
        return subInfo;
    }

    public void setSubInfo(String subInfo) {
        this.subInfo = subInfo;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "ipAddress='" + ipAddress + '\'' +
                ", mainInfo='" + mainInfo + '\'' +
                ", subInfo='" + subInfo + '\'' +
                '}';
    }
}
