package com.skynet.sql.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Criterias {
    public static Criteria with(String propertyName, Object... values) {

        List<Object> finalV = new ArrayList<>();
        if (values != null){
            for (Object o : values){
                if (o == null){
                    continue;
                }

                if (o.getClass().isArray()){
                    int len = Array.getLength(o);
                    for (int i =0 ;i < len; i++){
                        finalV.add(Array.get(o, i));
                    }
                } else if (o instanceof Collection){
                    Collection collection = (Collection) o;
                    finalV.addAll(collection);
                }else {
                    finalV.add(o);

                }


            }
        }

        values = finalV.toArray();

        if (values == null || values.length == 0) {
            return new ISNULL(propertyName);
        } else if (values.length == 1) {
            return new EQ(propertyName, values[0]);
        } else {
            return new IN(propertyName, values);
        }
    }

    public static Criteria not(Criteria c) {
        return new NOT(c);
    }

    public static Criteria and(Criteria... pCriteria) {
        AND and = new AND();
        if (pCriteria != null) {
            for (Criteria c : pCriteria) {
                and.append(c);
            }
        }
        return and;
    }

    public static Criteria or(Criteria... pCriteria) {
        OR or = new OR();
        if (pCriteria != null) {
            for (Criteria c : pCriteria) {
                or.append(c);
            }
        }
        return or;
    }

    public static Criteria in(DBQueryBuilder builder){
        return new Exists(builder);
    }
}
