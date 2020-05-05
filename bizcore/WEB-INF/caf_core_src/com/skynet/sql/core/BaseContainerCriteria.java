package com.skynet.sql.core;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseContainerCriteria implements ContainerCriteria{
    protected List<Criteria> inners;

    @Override
    public BaseContainerCriteria append(Criteria pCriteria) {
        if (pCriteria == null){
            return this;
        }
        if (inners == null){
            inners = new ArrayList<>();
        }
        inners.add(pCriteria);
        return this;
    }

    public  boolean isEmpty(){
        return  inners == null || inners.size() == 0;
    }
}
