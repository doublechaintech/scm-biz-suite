package com.skynet.sql.core;

public class Exists implements Criteria {

    private DBQueryBuilder subQuery;

    public Exists(DBQueryBuilder pSubQuery) {
        subQuery = pSubQuery;
    }

    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {
        return "(exists(" + subQuery.sql() + "))";
    }
}
