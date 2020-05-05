package com.skynet.sql.core;

public class LE implements Criteria {

    private String name;
    private Object value;
    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {

        //set parameter
        pDBQueryBuilder.parameter(value);

        //generate sql
        return "(" + pDBQueryBuilder.name(name) + " <= ?"  + ")";
    }
}
