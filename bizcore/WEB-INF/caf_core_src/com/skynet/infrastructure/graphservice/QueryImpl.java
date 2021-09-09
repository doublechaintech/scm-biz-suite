package com.skynet.infrastructure.graphservice;

import org.springframework.util.LinkedMultiValueMap;

import com.terapico.utils.DateTimeUtil;

import java.time.ZoneId;
import java.util.*;

public class QueryImpl implements Query {
    private String startType;
    private List<String> startIds;
    private List<String> relations;
    private LinkedMultiValueMap<String, String> paths = new LinkedMultiValueMap();
    private String filter;
    private Map<String, Object> parameters = new HashMap<>();
    private String targetType;
    private List<String> enhancements = new ArrayList<>();
    private String sort;
    private int startNo;
    private int size = -1;

    public QueryImpl(String pStartType, String... pStartIds) {
        startType = pStartType;

        if (pStartIds != null){
            startIds = new ArrayList<>(Arrays.asList(pStartIds));
        }
    }

    public QueryImpl(Query pQuery){
        setStartType(pQuery.getStartType());
        setStartIds(pQuery.getStartIds());
        setRelations(pQuery.getRelations());
        setFilter(pQuery.getFilter());
        setParameters(pQuery.getParameters());
        setTargetType(pQuery.getTargetType());
        setEnhancements(pQuery.getEnhancements());
        setSort(pQuery.getSort());
        setStartNo(pQuery.getStartNo());
        setSize(pQuery.getSize());
        setPaths(pQuery.getPaths());
    }

    @Override
    public String getStartType() {
        return startType;
    }

    public void setStartType(String pStartType) {
        startType = pStartType;
    }

    @Override
    public List<String> getStartIds() {
        return startIds;
    }

    public void setStartIds(List<String> pStartIds) {
        startIds = pStartIds;
    }

    @Override
    public List<String> getRelations() {
        return relations;
    }

    public void setRelations(List<String> pRelations) {
        relations = pRelations;
    }

    @Override
    public String getFilter() {
        return filter;
    }

    public void setFilter(String pFilter) {
        filter = pFilter;
    }

    @Override
    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> pParameters) {
        parameters = pParameters;
    }

    @Override
    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String pTargetType) {
        targetType = pTargetType;
    }

    @Override
    public List<String> getEnhancements() {
        return enhancements;
    }

    public void setEnhancements(List<String> pEnhancements) {
        enhancements = pEnhancements;
    }

    @Override
    public String getSort() {
        return sort;
    }

    public void setSort(String pSort) {
        sort = pSort;
    }

    @Override
    public int getStartNo() {
        return startNo;
    }

    public void setStartNo(int pStartNo) {
        startNo = pStartNo;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int pSize) {
        size = pSize;
    }


    public QueryImpl want(Class... pClasses){
//    	enhancements = new ArrayList<>();
        if (pClasses != null){
            for (Class c: pClasses){
                enhancements.add(c.getSimpleName());
            }
        }
        return this;
    }


    public  QueryImpl want(String relation){
        enhancements.add(relation);
        return this;
    }

    public QueryImpl returnType(Class t){
        setTargetType(t.getSimpleName());
        return this;
    }

    public QueryImpl addRelation(String relation){

        if (relation == null){
            return this;
        }

        if (getRelations() == null){
            relations = new ArrayList<>();
        }


        if (!relations.contains(relation)){
            relations.add(relation);
        }

        return this;
    }

    public QueryImpl limit(int pStartNo, int pSize){
        setStartNo(pStartNo);
        setSize(pSize);
        return this;
    }

    public QueryImpl limit(int pSize){
        setStartNo(0);
        setSize(pSize);
        return this;
    }

    public QueryImpl parameter(String key, Object value){
    		value = convertParamValue(value);
        parameters.put(key, value);
        return this;
    }

    private Object convertParamValue(Object value) {
    	if (value instanceof Date) {
			return DateTimeUtil.DAY_TIME_FORMAT_SS
					.format(((Date) value).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    	}
    	if (value instanceof List) {
    		List<Object> rstList = new ArrayList<>();
    		for(Object v : (List)value) {
    			rstList.add(convertParamValue(v));
    		}
    		return rstList;
    	}
		return value;
	}

	public QueryImpl filter(String pFilter){
        setFilter(pFilter);
        return this;
    }

    public QueryImpl sort(String pSort){
        setSort(pSort);
        return this;
    }

    public LinkedMultiValueMap getPaths() {
        return paths;
    }

    public void setPaths(LinkedMultiValueMap pPaths) {
        paths = pPaths;
    }
}
