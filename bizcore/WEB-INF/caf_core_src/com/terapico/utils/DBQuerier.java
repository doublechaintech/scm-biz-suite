package com.terapico.utils;

import java.util.List;
import java.util.Map;

public interface DBQuerier {
    boolean isTableExists(String tableName) throws Exception;
    boolean isFieldExists(String tableName, String fieldName) throws Exception;
    boolean isFieldSame(String tableName, String fieldName, String fieldType) throws Exception;

    Map<String, Object> queryForMap(String sql, Object[] objects);
    List<Map<String, Object>> queryForMapList(String sql, Object[] objects);
}
