package com.skynet.sql.core;

import java.util.Arrays;

public class Query {
    String sql;
    Object[] parameters;

    public Query(String pSql, Object[] pParameters) {
        sql = pSql;
        parameters = pParameters;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String pSql) {
        sql = pSql;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] pParameters) {
        parameters = pParameters;
    }

    @Override
    public String toString() {
        return "Query{" +
                "sql='" + sql + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }
}
