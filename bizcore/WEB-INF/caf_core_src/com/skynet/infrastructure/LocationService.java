package com.skynet.infrastructure;

public interface LocationService {
    /** IP 地址转换为地理位置信息 */
    LocationInfo ipToLocation(String ipAddress) throws Exception;
}
