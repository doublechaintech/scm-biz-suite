
package com.doublechaintech.retailscm.consumerordershipment;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.RetailscmNamingServiceDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;






import org.springframework.dao.EmptyResultDataAccessException;

public class ConsumerOrderShipmentJDBCTemplateDAO extends RetailscmNamingServiceDAO implements ConsumerOrderShipmentDAO{


			
		

	
	/*
	protected ConsumerOrderShipment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderShipment(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ConsumerOrderShipment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderShipment(ConsumerOrderShipmentTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderShipment save(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderShipment, methodName, "consumerOrderShipment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderShipment(consumerOrderShipment,options);
	}
	public ConsumerOrderShipment clone(String consumerOrderShipmentId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderShipmentTable.withId(consumerOrderShipmentId),options);
	}
	
	protected ConsumerOrderShipment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderShipmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderShipment newConsumerOrderShipment = loadInternalConsumerOrderShipment(accessKey, options);
		newConsumerOrderShipment.setVersion(0);
		
		

		
		saveInternalConsumerOrderShipment(newConsumerOrderShipment,options);
		
		return newConsumerOrderShipment;
	}
	
	
	
	

	protected void throwIfHasException(String consumerOrderShipmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ConsumerOrderShipmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderShipmentNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderShipmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String consumerOrderShipmentId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderShipmentId, int version)";
		assertMethodArgumentNotNull(consumerOrderShipmentId, methodName, "consumerOrderShipmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderShipmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderShipmentId,version);
		}
		
	
	}
	
	
	
	
	

	public ConsumerOrderShipment disconnectFromAll(String consumerOrderShipmentId, int version) throws Exception{
	
		
		ConsumerOrderShipment consumerOrderShipment = loadInternalConsumerOrderShipment(ConsumerOrderShipmentTable.withId(consumerOrderShipmentId), emptyOptions());
		consumerOrderShipment.clearFromAll();
		this.saveConsumerOrderShipment(consumerOrderShipment);
		return consumerOrderShipment;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ConsumerOrderShipmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_shipment";
	}
	@Override
	protected String getBeanName() {
		
		return "consumerOrderShipment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderShipmentTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ConsumerOrderShipmentMapper getConsumerOrderShipmentMapper(){
		return new ConsumerOrderShipmentMapper();
	}

	
	
	protected ConsumerOrderShipment extractConsumerOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ConsumerOrderShipment consumerOrderShipment = loadSingleObject(accessKey, getConsumerOrderShipmentMapper());
			return consumerOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderShipmentNotFoundException("ConsumerOrderShipment("+accessKey+") is not found!");
		}

	}

	
	

	protected ConsumerOrderShipment loadInternalConsumerOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderShipment consumerOrderShipment = extractConsumerOrderShipment(accessKey, loadOptions);

		
		return consumerOrderShipment;
		
	}



	
	
	
		
		
 	
		
		
		

	

	protected ConsumerOrderShipment saveConsumerOrderShipment(ConsumerOrderShipment  consumerOrderShipment){
		
		if(!consumerOrderShipment.isChanged()){
			return consumerOrderShipment;
		}
		
		
		String SQL=this.getSaveConsumerOrderShipmentSQL(consumerOrderShipment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderShipmentParameters(consumerOrderShipment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderShipment.incVersion();
		return consumerOrderShipment;
	
	}
	public SmartList<ConsumerOrderShipment> saveConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderShipmentList(consumerOrderShipmentList);
		
		batchConsumerOrderShipmentCreate((List<ConsumerOrderShipment>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderShipmentUpdate((List<ConsumerOrderShipment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderShipment consumerOrderShipment:consumerOrderShipmentList){
			if(consumerOrderShipment.isChanged()){
				consumerOrderShipment.incVersion();
			}
			
		
		}
		
		
		return consumerOrderShipmentList;
	}

	public SmartList<ConsumerOrderShipment> removeConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderShipmentList, options);
		
		return consumerOrderShipmentList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderShipmentBatchCreateArgs(List<ConsumerOrderShipment> consumerOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderShipment consumerOrderShipment:consumerOrderShipmentList ){
			Object [] parameters = prepareConsumerOrderShipmentCreateParameters(consumerOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderShipmentBatchUpdateArgs(List<ConsumerOrderShipment> consumerOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderShipment consumerOrderShipment:consumerOrderShipmentList ){
			if(!consumerOrderShipment.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderShipmentUpdateParameters(consumerOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderShipmentCreate(List<ConsumerOrderShipment> consumerOrderShipmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderShipmentBatchCreateArgs(consumerOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderShipmentUpdate(List<ConsumerOrderShipment> consumerOrderShipmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderShipmentBatchUpdateArgs(consumerOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderShipmentList(List<ConsumerOrderShipment> consumerOrderShipmentList){
		
		List<ConsumerOrderShipment> consumerOrderShipmentCreateList=new ArrayList<ConsumerOrderShipment>();
		List<ConsumerOrderShipment> consumerOrderShipmentUpdateList=new ArrayList<ConsumerOrderShipment>();
		
		for(ConsumerOrderShipment consumerOrderShipment: consumerOrderShipmentList){
			if(isUpdateRequest(consumerOrderShipment)){
				consumerOrderShipmentUpdateList.add( consumerOrderShipment);
				continue;
			}
			consumerOrderShipmentCreateList.add(consumerOrderShipment);
		}
		
		return new Object[]{consumerOrderShipmentCreateList,consumerOrderShipmentUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderShipment consumerOrderShipment){
 		return consumerOrderShipment.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderShipmentSQL(ConsumerOrderShipment consumerOrderShipment){
 		if(isUpdateRequest(consumerOrderShipment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderShipmentParameters(ConsumerOrderShipment consumerOrderShipment){
 		if(isUpdateRequest(consumerOrderShipment) ){
 			return prepareConsumerOrderShipmentUpdateParameters(consumerOrderShipment);
 		}
 		return prepareConsumerOrderShipmentCreateParameters(consumerOrderShipment);
 	}
 	protected Object[] prepareConsumerOrderShipmentUpdateParameters(ConsumerOrderShipment consumerOrderShipment){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = consumerOrderShipment.getWho();
 		parameters[1] = consumerOrderShipment.getShipTime();		
 		parameters[2] = consumerOrderShipment.nextVersion();
 		parameters[3] = consumerOrderShipment.getId();
 		parameters[4] = consumerOrderShipment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderShipmentCreateParameters(ConsumerOrderShipment consumerOrderShipment){
		Object[] parameters = new Object[3];
		String newConsumerOrderShipmentId=getNextId();
		consumerOrderShipment.setId(newConsumerOrderShipmentId);
		parameters[0] =  consumerOrderShipment.getId();
 
 		parameters[1] = consumerOrderShipment.getWho();
 		parameters[2] = consumerOrderShipment.getShipTime();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderShipment saveInternalConsumerOrderShipment(ConsumerOrderShipment consumerOrderShipment, Map<String,Object> options){
		
		saveConsumerOrderShipment(consumerOrderShipment);

		
		return consumerOrderShipment;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public ConsumerOrderShipment present(ConsumerOrderShipment consumerOrderShipment,Map<String, Object> options){
	

		return consumerOrderShipment;
	
	}
		

	

	protected String getTableName(){
		return ConsumerOrderShipmentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ConsumerOrderShipment> consumerOrderShipmentList) {		
		this.enhanceListInternal(consumerOrderShipmentList, this.getConsumerOrderShipmentMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ConsumerOrderShipment> consumerOrderShipmentList = ownerEntity.collectRefsWithType(ConsumerOrderShipment.INTERNAL_TYPE);
		this.enhanceList(consumerOrderShipmentList);
		
	}
	
	@Override
	public SmartList<ConsumerOrderShipment> findConsumerOrderShipmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getConsumerOrderShipmentMapper());

	}
	@Override
	public int countConsumerOrderShipmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countConsumerOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ConsumerOrderShipment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getConsumerOrderShipmentMapper());
	}
}


