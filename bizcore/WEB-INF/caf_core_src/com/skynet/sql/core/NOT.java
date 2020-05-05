package com.skynet.sql.core;

public class NOT implements Criteria {

    Criteria inner;

    public NOT(Criteria pInner) {
        inner = pInner;

        if (inner == null){
            inner = new AND();
        }
    }

    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {
        return "( not " + inner.toSql(pDBQueryBuilder)+ ")";
    }
}
