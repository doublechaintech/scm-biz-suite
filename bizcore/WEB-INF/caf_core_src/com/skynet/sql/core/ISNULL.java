package com.skynet.sql.core;

public class ISNULL implements Criteria {

    private String name;

    public ISNULL(String pName) {
        name = pName;
    }

    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {
        return "(" + pDBQueryBuilder.name(name) + " is null)";
    }
}
