package com.doublechaintech.retailscm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CommonTokens {

	protected static final String ALL_LISTS_ANALYZE = "allSubLists.analyze";
	
	protected Map <String,Object> options;
	public Map <String,Object> done()
	{
		return this.options();
	}
	public Map <String,Object> options()
	{
		ensureOptions();
		return options;
	}

	protected boolean isViewGroupOneOf(String viewGroupName, String candiatesViewGroups[]){
		return isOneOf(viewGroupName,candiatesViewGroups);
	}

	protected boolean isOneOf(String value, String candiates[]){
		if(value==null){
			return false;
		}
		if(candiates==null){
			return false;
		}
		for(String candidate:candiates){
		  if(value.equals(candidate)){
			  return true;
		  	}
	  	}
	  	return false;
	}

	public CommonTokens merge(CommonTokens tokens){
		Set<Entry<String, Object>> entrySet = tokens.options.entrySet();
		
		Iterator<Entry<String, Object>> it = entrySet.iterator();
		while(it.hasNext()){
			Entry<String, Object> entry = it.next();
			addMapOptions(entry.getKey(), entry.getValue());
		}
		return this;
	}
	public Map <String,Object> initWithArray(String [] tokensExpr)
	{
		return this.parseTokens(tokensExpr);
	}
	protected void addSimpleOptions(String key){
		ensureOptions();
		options.put(key, key);
	}
	protected void addSearchOptions(String key, String field, String verb, String value){
		ensureOptions();
		
		options.put(key+".searchField", field);
		options.put(key+".searchVerb", verb);
		options.put(key+".searchValue", value);
		
	}
	protected void addSortOptions(String key, String field, String descOrAsc){
		ensureOptions();
		
		options.put(key+".orderBy", field);
		options.put(key+".descOrAsc", descOrAsc);

	}
	protected void addSortMoreOptions(String key, int index, String field, String descOrAsc){
		ensureOptions();
		
		options.put(key+".orderBy"+"."+index, field);
		options.put(key+".descOrAsc"+"."+index, descOrAsc);

	}
	protected void addSearchMoreOptions(String key,int index,  String field, String verb, String value){
		ensureOptions();
		
		options.put(key+".searchField"+"."+index, field);
		options.put(key+".searchVerb"+"."+index, verb);
		options.put(key+".searchValue"+"."+index, value);
		
	}
	protected void addSimpleOptions(String key,Object value){
		ensureOptions();
		options.put(key, value);
	}

	static final String OWNER="$owner";
	protected static String getOwnerObjectKey(){
		
		return OWNER;
		
	}
	protected void addMapOptions(String key, Object value){
		ensureOptions();
		options.put(key, value);
		
	}
	
	protected int getIntValue(String key, int maxValue, int defaultValue){
		ensureOptions();
		try{
			String valueExpr =(String) options.get(key);
			int value = Integer.parseInt(valueExpr);
			
			if(value > maxValue){
				return maxValue;
			}
			return value;
			
		}catch(Exception e){
			return defaultValue;
		}
		
		
	}
	protected void ensureOptions()
	{
		if(options == null){
			options = new HashMap<String,Object>();
		}
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		ensureOptions();
		//Map<String,Object> options = options;
		if(tokensExpr ==  null){
			return options;
		}
		if(tokensExpr.length ==  0){
			return options;
		}
		
		for(String element: tokensExpr){
			if(element.indexOf('=')<=0){
				//options.put(element, element);
				addMapOptions(element, element);
				continue;
			}
			String pair[] = element.split("=");
			//options.put(pair[0], );
			addMapOptions(pair[0], pair[1]);
		}

		return options;
	}
	
	public String toString(){
		
		ensureOptions();
		Set<Entry<String, Object>> entrySet = options.entrySet();
		
		Iterator<Entry<String, Object>> it = entrySet.iterator();
		
		StringBuilder sb=new StringBuilder();
		while(it.hasNext()){
			Entry<String, Object> entry = it.next();
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
		}
		return sb.toString();
	}
	public String[] toArray(){
		
		ensureOptions();
		Set<Entry<String, Object>> entrySet = options.entrySet();
		String [] ret = new String[entrySet.size()];
		Iterator<Entry<String, Object>> it = entrySet.iterator();
		
		
		int index = 0;
		while(it.hasNext()){
			StringBuilder sb=new StringBuilder(40);
			Entry<String, Object> entry = it.next();
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
			ret[index] = sb.toString();
			index ++;
		}
		return ret;
	}
	//the way to implement this is with withLineItemList().withShippingGroupList().
	
	public String is() {
		return "is";
	}
	
	
	public String not() {
		return "not";
	}
	
	public String eq() {
		return "eq";
	}
	public String equals() {
		return eq() ;
	}
	public String gt() {
		return "gt";
	}
	public String gte() {
		return "gte";
	}
	public String lessThan() {
		return lt();
	}
	public String lt() {
		return "lt";
	}
	public String lte() {
		return "lte";
	}
	public String lessThanOrEquals() {
		return lte();
	}
	public String contains() {
		return "contains";
	}
	
	public String endsWith() {
		return "endsWith";
	}
	public String startsWith() {
		return "startsWith";
	}
	public String sortDesc() {
		return "desc";
	}
	public String sortAsc() {
		return "asc";
	}
	public String range() {
		return "range";
	}
	public String between() {
		return "between";
	}
	public String oneOf() {
		return "oneof";
	}
	public String noneof() {
		return "noneof";
	}
	public String thisWeekExpr() {
		return "thisweek";
	}
	public String thisMonthExpr() {
		return "thismonth";
	}
	public String thisYearExpr() {
		return "thisyear";
	}
	public String todayExpr() {
		return "today";
	}
	public String pastExpr() {
		return "past";
	}
	
	
	
}



























