package com.terapico.utils;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class MySqlDBQuerier implements DBQuerier {
    private DataSource dataSource;
    private JdbcTemplate jdbc = null;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

    }
    protected JdbcTemplate jdbc() {
        if (jdbc != null) {
            return jdbc;
        }
        this.jdbc = new JdbcTemplate(this.dataSource);

        jdbc.setFetchSize(1000);
        jdbc.setMaxRows(1000);
        jdbc.setQueryTimeout(10);
        return jdbc;
    }
    @Override
    public boolean isTableExists(String tableName) throws Exception {
        String sql = "select count(*) from " + tableName;
        try {
            jdbc().queryForObject(sql, Integer.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isFieldExists(String tableName, String fieldName) throws Exception {
        String sql = "select " + fieldName + " from " + tableName + " limit 1";
        try {
            jdbc().execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isFieldSame(String tableName, String fieldName, String fieldType) throws Exception {
        int pos = fieldType.toUpperCase().indexOf("CHARACTER SET");
        if ( pos > 0) {
            fieldType = fieldType.substring(0, pos).trim();
        }
        if (fieldType.toLowerCase().startsWith("numeric(")){
            fieldType = "decimal" + fieldType.substring(fieldType.indexOf('('));
        }
        String sql = String.format("show fields from %s where field='%s'", tableName, fieldName);
        Map<String, Object> fdInfo = jdbc().queryForMap(sql, new Object[]{});
        String type = DataTypeUtil.getString(fdInfo.get("Type"));
        System.out.println(tableName+"."+fieldName+" query TYPE="+type+", wants TYPE=" + fieldType);
        if (type.trim().equalsIgnoreCase(fieldType.trim())){
            return true;
        }
        if (fieldType.equalsIgnoreCase("int") && type.matches("int\\(\\d{2}\\)")){
            return true;
        }
        if (fieldType.toLowerCase().startsWith("tinyint") && type.toLowerCase().startsWith("tinyint")){
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> queryForMap(String sql, Object[] params) {
        return jdbc().queryForMap(sql, params);
    }
    @Override
    public List<Map<String, Object>> queryForMapList(String sql, Object[] params) {
        return jdbc().queryForList(sql, params);
    }
}



