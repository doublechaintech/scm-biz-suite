package com.skynet.sql.core;

import java.util.stream.Collectors;

public class OR extends BaseContainerCriteria {

    @Override
    public String toSql(DBQueryBuilder pDBQueryBuilder) {
        if (inners == null){
            return "(1 = 1)";
        }

        if (inners.size() == 1){
            return inners.get(0).toSql(pDBQueryBuilder);
        }

        return inners.stream().map( c -> {return  c.toSql(pDBQueryBuilder) ;})
                .collect(Collectors.joining(" or ", "(", ")"));
    }
}
