package com.skynet.sql.core;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IN implements Criteria {

    private String name;
    private Object[] values;

    public IN(String pName, Object[] pValues) {
        name = pName;
        values = pValues;
    }

    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {
        pDBQueryBuilder.parameters(values);
        return "(" + pDBQueryBuilder.name(name) + " in "
                + IntStream.rangeClosed(1, values.length).mapToObj(n->"?")
                .collect(Collectors.joining(",", "(", ")")) + ")";
    }
}
