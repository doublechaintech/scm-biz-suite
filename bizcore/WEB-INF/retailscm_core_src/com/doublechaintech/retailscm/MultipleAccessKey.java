package com.doublechaintech.retailscm;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class MultipleAccessKey extends BaseEntity {
	
	
	
	private Map<String, Object> internalMap ;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sql ;
	private Object [] params;
	
	public String sql(){
		
		prepareSqlAndParams();
		return sql;
		
	}
	public boolean isEmpty(){
		if(internalMap==null){
			return true;
		}
		return this.calcLength(internalMap.entrySet())==0;
	}
	
	protected void prepareSQL(Set<Map.Entry<String, Object>> entrySet){
		if(entrySet.isEmpty()){
			return ;
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append('(');//char is better than string here
		int index = 0;
		
		
		
		for(Map.Entry<String, Object> entry: entrySet){
			
			
			if(entry.getValue()==null){
				continue;
			}
			if(index > 0){
				stringBuilder.append(" and ");
			}
			if(!entry.getValue().getClass().isArray()){
				stringBuilder.append(mapToInternalColumn(entry.getKey()));
				stringBuilder.append('=');
				stringBuilder.append('?');
				index++;
				continue;
			}
			//if this is array, the find the nested object
			
			Object [] values =(Object []) entry.getValue();
			if(values.length==0){
				continue;
			}
			int inerIndex = 0;
			stringBuilder.append('(');
			for(Object value: values){
				if(inerIndex > 0){
					stringBuilder.append(" or ");
				}
				stringBuilder.append(mapToInternalColumn(entry.getKey()));
				stringBuilder.append('=');
				stringBuilder.append('?');
				inerIndex++;
				
			}
			stringBuilder.append(')');
			
			index++;
		}
		stringBuilder.append(')');//char is better than string here
		
		this.sql = stringBuilder.toString();
		
	}
	protected int calcLength(Set<Map.Entry<String, Object>> entrySet){
		
		int length = 0;
		for(Map.Entry<String, Object> entry: entrySet){
			if(entry.getValue() == null){
				continue;
			}
			if(!entry.getValue().getClass().isArray()){
				length += 1;
				continue;
			}
			Object [] values =(Object []) entry.getValue();
			
			length += values.length;
			//Arrays.
			
		}
		return length;
		
		
		
	}
	protected void prepareParameters(Set<Map.Entry<String, Object>> entrySet){
		
		if(entrySet.isEmpty()){
			return ;
		}
		int length = calcLength(entrySet);
		
		params = new Object[length];
		int index = 0;
		for(Map.Entry<String, Object> entry: entrySet){
			if(entry.getValue() == null){
				continue;
			}
			if(!entry.getValue().getClass().isArray()){
				params[index] = entry.getValue();
				index ++;
				continue;
			}
			Object [] values =(Object []) entry.getValue();
			if(values.length==0){
				continue;
			}
			System.arraycopy(values, 0, params, index, values.length);
			index += values.length;
		}
		
		
	}
	public Object put(String key, Object value) {
		if(key == null){
			return null;
		}
		if(value==null){
			return null;
		}
		ensureInternalMap();
		return internalMap.put(key, value);
	}
	
	protected void ensureInternalMap(){
		if(internalMap !=  null){
			return;
		}
		
		internalMap = new HashMap<String, Object>();
		
		
	}
	
	protected void prepareSqlAndParams(){
		if(sql != null){
			return ;
		}
		
		
		Set<Map.Entry<String, Object>> entrySet = internalMap.entrySet();
		prepareSQL(entrySet);
		prepareParameters(entrySet);

	}
	public Object[] params(){
		prepareSqlAndParams();
		return this.params;
	}
	
	
	
}

















