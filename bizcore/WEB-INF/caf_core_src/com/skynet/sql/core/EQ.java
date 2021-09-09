package com.skynet.sql.core;

public class EQ implements Criteria{

    private String name;
    private Object value;

    public EQ(String pName, Object pValue) {
        name = pName;
        value = pValue;
    }

    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {

        //set parameter
        pDBQueryBuilder.parameter(value);

        //generate sql
        return "(" + pDBQueryBuilder.name(name) + " = ?"  + ")";
    }
}
