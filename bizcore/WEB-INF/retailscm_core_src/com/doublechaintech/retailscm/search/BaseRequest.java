package com.doublechaintech.retailscm.search;

import com.doublechaintech.retailscm.BaseEntity;
import java.util.*;

public abstract class BaseRequest<T> {
    private Set<String> selects = new LinkedHashSet<>();
    private List<SearchCriteria> searchCriteriaList = new ArrayList<>();
    private Map<String, BaseRequest> parentSelects = new LinkedHashMap<>();
    private Map<String, BaseRequest> childrenSelects = new LinkedHashMap<>();
    private SimpleOrderBy orderBy = new SimpleOrderBy();
    private int offset;
    private int size = 1000;
    private Object userContext;

    public Object getUserContext() {
      return userContext;
    }

    public void setUserContext(Object pUserContext) {
      userContext = pUserContext;
    }

    public abstract String getInternalType();

    public void doAddSearchCriteria(SearchCriteria pSearchCriteria) {
        searchCriteriaList.add(pSearchCriteria);
    }

    public BaseRequest<T> select(String... names) {
        if (names == null){
          return this;
        }
        selects.addAll(Arrays.asList(names));
        return this;
    }

    public void selectParent(String name, BaseRequest request) {
        select(name);
        parentSelects.put(name, request);
    }

    public void selectChild(String name, BaseRequest request) {
      childrenSelects.put(request.getInternalType() + name, request);
    }

    public BaseRequest<T> unselect(String... name) {
        if (name == null) {
          return this;
        }
        selects.removeAll(Arrays.asList(name));
        return this;
      }

    public void unselectParent(String name) {
        unselect(name);
        parentSelects.remove(name);
    }

    public <R extends BaseEntity> void unselectChild(String name, Class<R> childClass) {
      childrenSelects.remove(childClass.getSimpleName() + name);
    }

    public List<SearchCriteria> getSearchCriteriaList() {
        return searchCriteriaList;
    }

    public void setSearchCriteriaList(List<SearchCriteria> pSearchCriteriaList) {
        searchCriteriaList = pSearchCriteriaList;
    }

    public int getOffset() {
      return offset;
    }

    public void setOffset(int pOffset) {
      offset = pOffset;
    }

    public int getSize() {
      return size;
    }

    public void setSize(int pSize) {
      size = pSize;
    }

    public Set<String> getSelects() {
      return selects;
    }

    public void setSelects(Set<String> pSelects) {
      selects = pSelects;
    }

    public Map<String, BaseRequest> getParentSelects() {
      return parentSelects;
    }

    public void setParentSelects(Map<String, BaseRequest> pParentSelects) {
      parentSelects = pParentSelects;
    }

    public Map<String, BaseRequest> getChildrenSelects() {
      return childrenSelects;
    }

    public void setChildrenSelects(Map<String, BaseRequest> pChildrenSelects) {
      childrenSelects = pChildrenSelects;
    }

    public void addOrderBy(String property, boolean asc){
      orderBy.addOrderBy(property, asc);
    }

    public SimpleOrderBy getOrderBy() {
      return orderBy;
    }

    public void setOrderBy(SimpleOrderBy pOrderBy) {
      orderBy = pOrderBy;
    }
}


