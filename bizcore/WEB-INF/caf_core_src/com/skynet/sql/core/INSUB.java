package com.skynet.sql.core;

public class INSUB implements Criteria {

    private DBQueryBuilder sub;

    private String property;

    public INSUB(String pProperty, DBQueryBuilder pSub) {
        sub = pSub;
        property = pProperty;
    }

    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {
        return "(" + pDBQueryBuilder.name(property) + " in (" + sub.sql() + "))";
    }
}
