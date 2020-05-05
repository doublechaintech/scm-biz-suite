package com.skynet.sql.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DBQueryBuilder {

    private String tableName;

    private ContainerCriteria criteria;

    private List<Object> parameters;

    private List<String> selects;

    private String sortOption = "DESC";
    private List<String> sorts;

    private long limitStart;
    private long limitSize = -1;

    public DBQueryBuilder(String pTableName) {
        tableName = pTableName;
        criteria = new AND();
        parameters = new ArrayList<>();
        selects = new ArrayList<>();
    }

    public DBQueryBuilder subQuery(String pTableName) {
        DBQueryBuilder subQuery = new DBQueryBuilder(pTableName);
        subQuery.parameters = this.parameters;

        //default select id
        subQuery.select("id");
        return subQuery;
    }

    public Query toQuery() {
        return new Query(selects() + " from " + getTableName() + " where " + criteria.toSql(this) + sortSql() + limitSql(), parameters.toArray());
    }

    public String sql() {
        return toQuery().sql;
    }

    private String selects() {

        if (selects.isEmpty()) {
            return "select " + getTableName() + ".*";
        }

        return selects.stream().map(p -> getTableName() + "." + p)
                .collect(Collectors.joining(",", "select ", ""));
    }

    public DBQueryBuilder select(String... select) {
        selects = new ArrayList<>();
        selects.addAll(Arrays.asList(select));
        return this;
    }

    public DBQueryBuilder sort(String... sort) {
        sorts = new ArrayList<>();
        sorts.addAll(Arrays.asList(sort));
        return this;
    }

    public DBQueryBuilder sortOption(String pSortOption) {
        this.sortOption = pSortOption;
        return this;
    }

    private String sortSql() {
        if (sortOption == null || sorts == null || sorts.isEmpty()) {
            return "";
        }

        return " order by " + sorts.stream().collect(Collectors.joining(",")) + " " + sortOption;
    }

    public DBQueryBuilder limit(long start, long size) {
        this.limitStart = start;
        this.limitSize = size;
        return this;
    }

    public DBQueryBuilder limit(long size) {
        return limit(0L, size);
    }

    private String limitSql() {
        if (limitSize == -1) {
            return "";
        }
        return " limit " + limitStart + "," + limitSize;
    }

    /**
     * entity class to table name
     *
     * @return
     */
    public String getTableName() {
        return tableName;
    }

    public DBQueryBuilder withCriteria(Criteria c) {
        criteria.append(c);
        return this;
    }


    public DBQueryBuilder with(String propertyName, Object... values) {
        return withCriteria(Criterias.with(propertyName, values));
    }

    public DBQueryBuilder without(String propertyName, Object... values) {
        return withCriteria(Criterias.not(Criterias.with(propertyName, values)));
    }

    public DBQueryBuilder optional(String propertyName, Object... values) {
        if (values == null) {
            return this;
        }
        return with(propertyName, values);
    }

    public DBQueryBuilder inSub(String name, DBQueryBuilder pSub) {
        if (pSub == null) {
            return this;
        }
        pSub.parameters = this.parameters;
        return withCriteria(new INSUB(name, pSub));
    }

    public DBQueryBuilder existed(DBQueryBuilder pSub) {
        return withCriteria(new Exists(pSub));
    }

    public String name(String pName) {
        return getTableName() + "." + pName;
    }

    public void parameter(Object pValue) {
        parameters.add(pValue);
    }

    public void parameters(Object... pValues) {
        for (Object v : pValues) {
            parameters.add(v);
        }
    }

    public static void main(String[] args) {


    }

    public static DBQueryBuilder userInWarehouse(DBQueryBuilder mainQuery, String userId, String warehouseId) {
        DBQueryBuilder subQuery = mainQuery.subQuery("user_warehouse_re")
                .with("userid", userId).with("warehouseid", warehouseId);

        mainQuery.existed(subQuery);
        return subQuery;
    }
}
