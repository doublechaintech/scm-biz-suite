package com.doublechaintech.retailscm;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public abstract class BaseJsonSerializer<T extends BaseEntity> extends JsonSerializer<T> {
	
	protected void writeStringField(JsonGenerator jgen, String fieldName, String value) throws IOException {
		if(value == null){
			return;
		}
		jgen.writeStringField(fieldName, value);
		
	}
	protected void writeNumberField(JsonGenerator jgen, String fieldName, int value) throws IOException {
		jgen.writeNumberField(fieldName, value);
		
	}
	protected void writeNumberField(JsonGenerator jgen, String fieldName, long value) throws IOException {
		jgen.writeNumberField(fieldName, value);
		
	}
	protected void writeNumberField(JsonGenerator jgen, String fieldName, float value) throws IOException {
		jgen.writeNumberField(fieldName, value);
		
	}

	protected void writeNumberField(JsonGenerator jgen, String fieldName, BigDecimal value) throws IOException {
		jgen.writeNumberField(fieldName, value);
		
	}
	protected<E extends BaseEntity> void writeCountOfList(JsonGenerator jgen, String fieldName, SmartList<E> list) throws IOException {
		
		if(list==null){
			return ;
		}
		if(list.getTotalCount()<=0){
			return;
		}
		
		jgen.writeNumberField(fieldName, list.getTotalCount());
		
	}
	
	protected<E extends BaseEntity> void writeCurrentPageOfList(JsonGenerator jgen, String fieldName, SmartList<E> list) throws IOException {
		
		if(list==null){
			return ;
		}
		if(list.getCurrentPageNumber()<=0){
			return;
		}
		
		jgen.writeNumberField(fieldName, list.getCurrentPageNumber());
		
	}
	protected void writeNumberField(JsonGenerator jgen, String fieldName, double value) throws IOException {
		jgen.writeNumberField(fieldName, value);
		
	}
	protected void writeBooleanField(JsonGenerator jgen, String fieldName, boolean value) throws IOException{
		jgen.writeBooleanField(fieldName, value);
		
	}


	protected void writeDateField(JsonGenerator jgen, String fieldName, Date value) throws IOException{
		if(value == null){
			return;
		}
		this.writeNumberField(jgen, fieldName, value.getTime());;
		
	}
	protected void writeDateTimeField(JsonGenerator jgen, String fieldName, Date value) throws IOException{
		if(value == null){
			return;
		}
		//jgen.writeObjectField(fieldName, value);
		this.writeNumberField(jgen, fieldName, value.getTime());;
		
	}
	@Override
	public void serialize(BaseEntity baseEntity, JsonGenerator jgen,
			SerializerProvider serialierProvider) throws IOException,
			JsonProcessingException {
		//the method must stay here for compiling
	}
	
	private static final String CLASS = "class";
	
	
	protected void writeStartObject(BaseEntity baseEntity, JsonGenerator jgen,SerializerProvider provider)throws IOException,JsonProcessingException{
		jgen.writeStartObject();
		writeClassField(CLASS,baseEntity,jgen,provider);
        this.writeStringField(jgen, "displayName", baseEntity.getDisplayName());
	}
	
	
	protected void writeEndObject(BaseEntity baseEntity, JsonGenerator jgen,SerializerProvider provider)throws IOException,JsonProcessingException{
		
		//writeActionList(ACTION_LIST,baseEntity,jgen,provider);
		//writeMessageList(MESSAGE_LIST,baseEntity,jgen,provider);
		jgen.writeEndObject();
	}
	protected void writeClassField(String fieldName, BaseEntity baseEntity,
			JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		if(baseEntity == null){
			return; //do nothing when base entity is null
		}
		
		jgen.writeStringField(fieldName,baseEntity.getClass().getName());
		
	}
	protected void writeClassField(String fieldName, BaseEntity baseEntity,
			JsonGenerator jgen)
			throws IOException, JsonProcessingException {
		
		if(baseEntity == null){
			return; //do nothing when base entity is null
		}
		
		jgen.writeStringField(fieldName,baseEntity.getClass().getName());
		
	}
	
		private Set<Object> serializedSet ;
	
	
	protected boolean hasDone(Object object) {
		if(serializedSet==null) {
			return false;
		}
		return serializedSet.contains(object);
		
	}
	protected void markDone(Object object) {
		if(serializedSet == null) {
			serializedSet = new HashSet<Object>();
			
		}
		if(serializedSet.contains(object)) {
			return;
		}
		serializedSet.add(object);
		
	}
	
	
	protected void writeList(JsonGenerator jgen, String fieldName, SmartList<? extends BaseEntity> targetEntityList,SerializerProvider provider) throws IOException {
		
		if(targetEntityList==null) {
			return;
		}
		
		
		/*
		 * writeCountOfList(jgen, "workPackageCount",workPackageList);
		writeCurrentPageOfList(jgen, "workPackageCurrentPageNumber",workPackageList);
		writeAccessibleOfList(jgen, "workPackageAccessiable",workPackageList);//Spell Issue for old version
		writeAccessibleOfList(jgen, "workPackageAccessible",workPackageList);
		
		 * */
		
		if(targetEntityList.isEmpty()) {
			return;
		}
		if(fieldName!=null&&!fieldName.isEmpty()) {
			jgen.writeFieldName(fieldName);
		}
		jgen.writeStartArray();
		
		for(BaseEntity entity:targetEntityList) {
			this.writeBaseEntityField(jgen, null, entity, provider);
		}
		jgen.writeEndArray();
		
	}
	
	
	protected void writeBaseEntityField(JsonGenerator jgen, String fieldName, BaseEntity baseEntity,SerializerProvider provider) throws IOException{

		if(baseEntity==null) {
			return;
		}

		if(fieldName!=null&&!fieldName.isEmpty()) {
			jgen.writeFieldName(fieldName);
		}
		if(this.hasDone(baseEntity)) {
			extractFields(jgen, fieldName, baseEntity, provider,false);
			return;	
		}
		
		
		this.markDone(baseEntity);
		
		extractFields(jgen, fieldName, baseEntity, provider,true);
		
	}
	protected void extractFields(JsonGenerator jgen, String fieldName, BaseEntity baseEntity,
			SerializerProvider provider, boolean extractList) throws IOException, JsonProcessingException {
		List<KeyValuePair> pairs = baseEntity.keyValuePairOf();
		writeStartObject(baseEntity,jgen,provider);
		for(KeyValuePair pair: pairs) {
			
			if(!extractList) {
				
				if("id".equals(pair.getKey())) {
					this.writeField(jgen, pair.getKey(), pair.getValue(), provider);
				}
				if("version".equals(pair.getKey())) {
					this.writeField(jgen, pair.getKey(), pair.getValue(), provider);
				}
				if("displayName".equals(pair.getKey())) {
					this.writeField(jgen, pair.getKey(), pair.getValue(), provider);
				}
				
				continue;
				/*
				if(pair.getValue() instanceof SmartList) {
					continue;
				}
				if(pair.getValue() instanceof List) {
					continue;
				}*/
				
			}
			
			this.writeField(jgen, pair.getKey(), pair.getValue(), provider);

		}
		
		writeEndObject(baseEntity,jgen,provider);
	}
	
	protected void writeField(JsonGenerator jgen, String fieldName, Object value,SerializerProvider provider) throws IOException {
		
		if(value==null){
			return;
		}
		
		if(value instanceof String) {
			this.writeStringField(jgen, fieldName, (String)value);
			return;
		}
		if(value instanceof BigDecimal) {
			this.writeNumberField(jgen, fieldName, (BigDecimal)value);
			return;
		}
		if(value instanceof Integer) {
			this.writeNumberField(jgen, fieldName, (Integer)value);
			return;
		}
		if(value instanceof Float) {
			this.writeNumberField(jgen, fieldName, (Float)value);
			return;
		}
		if(value instanceof Double) {
			this.writeNumberField(jgen, fieldName, (Double)value);
			return;
		}
		if(value instanceof Long) {
			this.writeNumberField(jgen, fieldName, (Long)value);
			return;
		}
		if(value instanceof Boolean) {
			this.writeBooleanField(jgen, fieldName, (Boolean)value);
			return;
		}
		if(value instanceof SmartList) {
			
			 SmartList<? extends BaseEntity> targetEntityList = (SmartList<? extends BaseEntity>)value;
			 this.writeBaseEntityField(jgen, fieldName+"MetaInfo", targetEntityList.getMetaInfo(),provider);
			 
			 if(targetEntityList.isEmpty()) {
				 return;
			 }
			 this.writeList(jgen, fieldName, targetEntityList,provider);
			 //this.writeObjectField(jgen, fieldName+"StatsInfo", targetEntityList.getStatsInfo());
			 jgen.writeObjectField( fieldName+"StatsInfo", targetEntityList.getStatsInfo());
			 //System.out.println("--------------------size: " + targetEntityList.size());
			 return;
		}
		if(value instanceof BaseEntity) {
			this.writeBaseEntityField(jgen, fieldName, (BaseEntity)value,provider);
			return;
		}
		
		if(value instanceof Object) {
			jgen.writeObjectField(fieldName, value);
			return;
			
		}
		//going to here is impossible in java :)
		
		throw new IllegalArgumentException("The type of "+ value.getClass().getName()+" is not handled by writeField");
	}
	

}
















