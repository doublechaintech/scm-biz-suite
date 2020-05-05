package com.skynet.sql.core;

public class LESS implements Criteria{

    private String name;
    private Object value;

    public LESS(String pName, Object pValue) {
        name = pName;
        value = pValue;
    }

    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {

        //set parameter
        pDBQueryBuilder.parameter(value);

        //generate sql
        return "(" + pDBQueryBuilder.name(name) + " < ?"  + ")";
    }
}
