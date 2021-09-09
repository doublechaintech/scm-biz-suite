package com.skynet.sql.core;

public interface Criteria {
    String toSql(DBQueryBuilder pDBQueryBuilder);
}
