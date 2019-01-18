
package com.doublechaintech.retailscm.supplyorderprocessing;

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


import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderProcessingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SupplyOrderProcessingDAO{


			
		
	
  	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO pConsumerOrderDAO){
 	
 		if(pConsumerOrderDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
 		}
	 	this.consumerOrderDAO = pConsumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
 		if(this.consumerOrderDAO == null){
 			throw new IllegalStateException("The consumerOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderDAO;
 	}	
 	
			
		
	
  	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO pSupplyOrderDAO){
 	
 		if(pSupplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = pSupplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}	
 	
			
		

	
	/*
	protected SupplyOrderProcessing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderProcessing(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplyOrderProcessing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderProcessing(SupplyOrderProcessingTable.withId(id), options);
	}
	
	
	
	public SupplyOrderProcessing save(SupplyOrderProcessing supplyOrderProcessing,Map<String,Object> options){
		
		String methodName="save(SupplyOrderProcessing supplyOrderProcessing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderProcessing, methodName, "supplyOrderProcessing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderProcessing(supplyOrderProcessing,options);
	}
	public SupplyOrderProcessing clone(String supplyOrderProcessingId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderProcessingTable.withId(supplyOrderProcessingId),options);
	}
	
	protected SupplyOrderProcessing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderProcessingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderProcessing newSupplyOrderProcessing = loadInternalSupplyOrderProcessing(accessKey, options);
		newSupplyOrderProcessing.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderProcessing.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderProcessing.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderProcessing(newSupplyOrderProcessing,options);
		
		return newSupplyOrderProcessing;
	}
	
	
	
	

	protected void throwIfHasException(String supplyOrderProcessingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderProcessingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderProcessingNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderProcessingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplyOrderProcessingId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderProcessingId, int version)";
		assertMethodArgumentNotNull(supplyOrderProcessingId, methodName, "supplyOrderProcessingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderProcessingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderProcessingId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplyOrderProcessing disconnectFromAll(String supplyOrderProcessingId, int version) throws Exception{
	
		
		SupplyOrderProcessing supplyOrderProcessing = loadInternalSupplyOrderProcessing(SupplyOrderProcessingTable.withId(supplyOrderProcessingId), emptyOptions());
		supplyOrderProcessing.clearFromAll();
		this.saveSupplyOrderProcessing(supplyOrderProcessing);
		return supplyOrderProcessing;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderProcessingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_processing";
	}
	@Override
	protected String getBeanName() {
		
		return "supplyOrderProcessing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderProcessingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderProcessingTokens.CONSUMER_ORDER_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,SupplyOrderProcessingTokens.CONSUMER_ORDER_LIST+".analyze");
 	}
	
	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderProcessingTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderProcessingTokens.SUPPLY_ORDER_LIST);
 	}
 	protected boolean isAnalyzeSupplyOrderListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,SupplyOrderProcessingTokens.SUPPLY_ORDER_LIST+".analyze");
 	}
	
	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderProcessingTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
		

	

	protected SupplyOrderProcessingMapper getSupplyOrderProcessingMapper(){
		return new SupplyOrderProcessingMapper();
	}

	
	
	protected SupplyOrderProcessing extractSupplyOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderProcessing supplyOrderProcessing = loadSingleObject(accessKey, getSupplyOrderProcessingMapper());
			return supplyOrderProcessing;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderProcessingNotFoundException("SupplyOrderProcessing("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderProcessing loadInternalSupplyOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderProcessing supplyOrderProcessing = extractSupplyOrderProcessing(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderProcessing, loadOptions);
 		}	
 		if(isAnalyzeConsumerOrderListEnabled(loadOptions)){
	 		analyzeConsumerOrderList(supplyOrderProcessing, loadOptions);
 		}
 		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderProcessing, loadOptions);
 		}	
 		if(isAnalyzeSupplyOrderListEnabled(loadOptions)){
	 		analyzeSupplyOrderList(supplyOrderProcessing, loadOptions);
 		}
 		
		
		return supplyOrderProcessing;
		
	}

	
		
	protected void enhanceConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplyOrderProcessing extractConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		
		if(supplyOrderProcessing == null){
			return null;
		}
		if(supplyOrderProcessing.getId() == null){
			return supplyOrderProcessing;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByProcessing(supplyOrderProcessing.getId(),options);
		if(consumerOrderList != null){
			enhanceConsumerOrderList(consumerOrderList,options);
			supplyOrderProcessing.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderProcessing;
	
	}	
	
	protected SupplyOrderProcessing analyzeConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		
		if(supplyOrderProcessing == null){
			return null;
		}
		if(supplyOrderProcessing.getId() == null){
			return supplyOrderProcessing;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();
		if(consumerOrderList != null){
			getConsumerOrderDAO().analyzeConsumerOrderByProcessing(consumerOrderList, supplyOrderProcessing.getId(), options);
			
		}
		
		return supplyOrderProcessing;
	
	}	
	
		
	protected void enhanceSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplyOrderProcessing extractSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		
		if(supplyOrderProcessing == null){
			return null;
		}
		if(supplyOrderProcessing.getId() == null){
			return supplyOrderProcessing;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByProcessing(supplyOrderProcessing.getId(),options);
		if(supplyOrderList != null){
			enhanceSupplyOrderList(supplyOrderList,options);
			supplyOrderProcessing.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderProcessing;
	
	}	
	
	protected SupplyOrderProcessing analyzeSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		
		if(supplyOrderProcessing == null){
			return null;
		}
		if(supplyOrderProcessing.getId() == null){
			return supplyOrderProcessing;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();
		if(supplyOrderList != null){
			getSupplyOrderDAO().analyzeSupplyOrderByProcessing(supplyOrderList, supplyOrderProcessing.getId(), options);
			
		}
		
		return supplyOrderProcessing;
	
	}	
	
		
		
 	
		
		
		

	

	protected SupplyOrderProcessing saveSupplyOrderProcessing(SupplyOrderProcessing  supplyOrderProcessing){
		
		if(!supplyOrderProcessing.isChanged()){
			return supplyOrderProcessing;
		}
		
		
		String SQL=this.getSaveSupplyOrderProcessingSQL(supplyOrderProcessing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderProcessingParameters(supplyOrderProcessing);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderProcessing.incVersion();
		return supplyOrderProcessing;
	
	}
	public SmartList<SupplyOrderProcessing> saveSupplyOrderProcessingList(SmartList<SupplyOrderProcessing> supplyOrderProcessingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderProcessingList(supplyOrderProcessingList);
		
		batchSupplyOrderProcessingCreate((List<SupplyOrderProcessing>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderProcessingUpdate((List<SupplyOrderProcessing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderProcessing supplyOrderProcessing:supplyOrderProcessingList){
			if(supplyOrderProcessing.isChanged()){
				supplyOrderProcessing.incVersion();
			}
			
		
		}
		
		
		return supplyOrderProcessingList;
	}

	public SmartList<SupplyOrderProcessing> removeSupplyOrderProcessingList(SmartList<SupplyOrderProcessing> supplyOrderProcessingList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderProcessingList, options);
		
		return supplyOrderProcessingList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderProcessingBatchCreateArgs(List<SupplyOrderProcessing> supplyOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderProcessing supplyOrderProcessing:supplyOrderProcessingList ){
			Object [] parameters = prepareSupplyOrderProcessingCreateParameters(supplyOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderProcessingBatchUpdateArgs(List<SupplyOrderProcessing> supplyOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderProcessing supplyOrderProcessing:supplyOrderProcessingList ){
			if(!supplyOrderProcessing.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderProcessingUpdateParameters(supplyOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderProcessingCreate(List<SupplyOrderProcessing> supplyOrderProcessingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderProcessingBatchCreateArgs(supplyOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderProcessingUpdate(List<SupplyOrderProcessing> supplyOrderProcessingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderProcessingBatchUpdateArgs(supplyOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderProcessingList(List<SupplyOrderProcessing> supplyOrderProcessingList){
		
		List<SupplyOrderProcessing> supplyOrderProcessingCreateList=new ArrayList<SupplyOrderProcessing>();
		List<SupplyOrderProcessing> supplyOrderProcessingUpdateList=new ArrayList<SupplyOrderProcessing>();
		
		for(SupplyOrderProcessing supplyOrderProcessing: supplyOrderProcessingList){
			if(isUpdateRequest(supplyOrderProcessing)){
				supplyOrderProcessingUpdateList.add( supplyOrderProcessing);
				continue;
			}
			supplyOrderProcessingCreateList.add(supplyOrderProcessing);
		}
		
		return new Object[]{supplyOrderProcessingCreateList,supplyOrderProcessingUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderProcessing supplyOrderProcessing){
 		return supplyOrderProcessing.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderProcessingSQL(SupplyOrderProcessing supplyOrderProcessing){
 		if(isUpdateRequest(supplyOrderProcessing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderProcessingParameters(SupplyOrderProcessing supplyOrderProcessing){
 		if(isUpdateRequest(supplyOrderProcessing) ){
 			return prepareSupplyOrderProcessingUpdateParameters(supplyOrderProcessing);
 		}
 		return prepareSupplyOrderProcessingCreateParameters(supplyOrderProcessing);
 	}
 	protected Object[] prepareSupplyOrderProcessingUpdateParameters(SupplyOrderProcessing supplyOrderProcessing){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = supplyOrderProcessing.getWho();
 		parameters[1] = supplyOrderProcessing.getProcessTime();		
 		parameters[2] = supplyOrderProcessing.nextVersion();
 		parameters[3] = supplyOrderProcessing.getId();
 		parameters[4] = supplyOrderProcessing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderProcessingCreateParameters(SupplyOrderProcessing supplyOrderProcessing){
		Object[] parameters = new Object[3];
		String newSupplyOrderProcessingId=getNextId();
		supplyOrderProcessing.setId(newSupplyOrderProcessingId);
		parameters[0] =  supplyOrderProcessing.getId();
 
 		parameters[1] = supplyOrderProcessing.getWho();
 		parameters[2] = supplyOrderProcessing.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderProcessing saveInternalSupplyOrderProcessing(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		saveSupplyOrderProcessing(supplyOrderProcessing);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderProcessing, options);
	 		//removeConsumerOrderList(supplyOrderProcessing, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderProcessing, options);
	 		//removeSupplyOrderList(supplyOrderProcessing, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplyOrderProcessing;
		
	}
	
	
	
	//======================================================================================
	

	
	public SupplyOrderProcessing planToRemoveConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, String consumerOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.PROCESSING_PROPERTY, supplyOrderProcessing.getId());
		key.put(ConsumerOrder.ID_PROPERTY, consumerOrderIds);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderProcessing;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderProcessing;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){

			consumerOrder.clearFromAll();
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderProcessing;	
	
	}


	//disconnect SupplyOrderProcessing with consumer in ConsumerOrder
	public SupplyOrderProcessing planToRemoveConsumerOrderListWithConsumer(SupplyOrderProcessing supplyOrderProcessing, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.PROCESSING_PROPERTY, supplyOrderProcessing.getId());
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderProcessing;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderProcessing;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearConsumer();
			consumerOrder.clearProcessing();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderProcessing;
	}
	
	public int countConsumerOrderListWithConsumer(String supplyOrderProcessingId, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.PROCESSING_PROPERTY, supplyOrderProcessingId);
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderProcessing with store in ConsumerOrder
	public SupplyOrderProcessing planToRemoveConsumerOrderListWithStore(SupplyOrderProcessing supplyOrderProcessing, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.PROCESSING_PROPERTY, supplyOrderProcessing.getId());
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderProcessing;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderProcessing;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearStore();
			consumerOrder.clearProcessing();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderProcessing;
	}
	
	public int countConsumerOrderListWithStore(String supplyOrderProcessingId, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.PROCESSING_PROPERTY, supplyOrderProcessingId);
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	public SupplyOrderProcessing planToRemoveSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, String supplyOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PROCESSING_PROPERTY, supplyOrderProcessing.getId());
		key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderProcessing;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderProcessing;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){

			supplyOrder.clearFromAll();
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderProcessing;	
	
	}


	//disconnect SupplyOrderProcessing with buyer in SupplyOrder
	public SupplyOrderProcessing planToRemoveSupplyOrderListWithBuyer(SupplyOrderProcessing supplyOrderProcessing, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PROCESSING_PROPERTY, supplyOrderProcessing.getId());
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderProcessing;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderProcessing;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearBuyer();
			supplyOrder.clearProcessing();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderProcessing;
	}
	
	public int countSupplyOrderListWithBuyer(String supplyOrderProcessingId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PROCESSING_PROPERTY, supplyOrderProcessingId);
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderProcessing with seller in SupplyOrder
	public SupplyOrderProcessing planToRemoveSupplyOrderListWithSeller(SupplyOrderProcessing supplyOrderProcessing, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PROCESSING_PROPERTY, supplyOrderProcessing.getId());
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderProcessing;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderProcessing;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearSeller();
			supplyOrder.clearProcessing();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderProcessing;
	}
	
	public int countSupplyOrderListWithSeller(String supplyOrderProcessingId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PROCESSING_PROPERTY, supplyOrderProcessingId);
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	

		
	protected SupplyOrderProcessing saveConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();
		if(consumerOrderList == null){
			//null list means nothing
			return supplyOrderProcessing;
		}
		SmartList<ConsumerOrder> mergedUpdateConsumerOrderList = new SmartList<ConsumerOrder>();
		
		
		mergedUpdateConsumerOrderList.addAll(consumerOrderList); 
		if(consumerOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateConsumerOrderList.addAll(consumerOrderList.getToRemoveList());
			consumerOrderList.removeAll(consumerOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getConsumerOrderDAO().saveConsumerOrderList(mergedUpdateConsumerOrderList,options);
		
		if(consumerOrderList.getToRemoveList() != null){
			consumerOrderList.removeAll(consumerOrderList.getToRemoveList());
		}
		
		
		return supplyOrderProcessing;
	
	}
	
	protected SupplyOrderProcessing removeConsumerOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderProcessing;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderProcessing;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderProcessing;
	
	}
	
	

 	
 	
	
	
	
		
	protected SupplyOrderProcessing saveSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
		
		
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();
		if(supplyOrderList == null){
			//null list means nothing
			return supplyOrderProcessing;
		}
		SmartList<SupplyOrder> mergedUpdateSupplyOrderList = new SmartList<SupplyOrder>();
		
		
		mergedUpdateSupplyOrderList.addAll(supplyOrderList); 
		if(supplyOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSupplyOrderList.addAll(supplyOrderList.getToRemoveList());
			supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSupplyOrderDAO().saveSupplyOrderList(mergedUpdateSupplyOrderList,options);
		
		if(supplyOrderList.getToRemoveList() != null){
			supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
		}
		
		
		return supplyOrderProcessing;
	
	}
	
	protected SupplyOrderProcessing removeSupplyOrderList(SupplyOrderProcessing supplyOrderProcessing, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderProcessing;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderProcessing;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderProcessing;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplyOrderProcessing present(SupplyOrderProcessing supplyOrderProcessing,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderProcessing,options);
		presentSupplyOrderList(supplyOrderProcessing,options);

		return supplyOrderProcessing;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderProcessing presentConsumerOrderList(
			SupplyOrderProcessing supplyOrderProcessing,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderProcessing.getConsumerOrderList();		
				SmartList<ConsumerOrder> newList= presentSubList(supplyOrderProcessing.getId(),
				consumerOrderList,
				options,
				getConsumerOrderDAO()::countConsumerOrderByProcessing,
				getConsumerOrderDAO()::findConsumerOrderByProcessing
				);

		
		supplyOrderProcessing.setConsumerOrderList(newList);
		

		return supplyOrderProcessing;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderProcessing presentSupplyOrderList(
			SupplyOrderProcessing supplyOrderProcessing,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderProcessing.getSupplyOrderList();		
				SmartList<SupplyOrder> newList= presentSubList(supplyOrderProcessing.getId(),
				supplyOrderList,
				options,
				getSupplyOrderDAO()::countSupplyOrderByProcessing,
				getSupplyOrderDAO()::findSupplyOrderByProcessing
				);

		
		supplyOrderProcessing.setSupplyOrderList(newList);
		

		return supplyOrderProcessing;
	}			
		

	
    public SmartList<SupplyOrderProcessing> requestCandidateSupplyOrderProcessingForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderProcessingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderProcessingMapper());
    }
		
    public SmartList<SupplyOrderProcessing> requestCandidateSupplyOrderProcessingForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderProcessingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderProcessingMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderProcessingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrderProcessing> supplyOrderProcessingList) {		
		this.enhanceListInternal(supplyOrderProcessingList, this.getSupplyOrderProcessingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderProcessing> supplyOrderProcessingList = ownerEntity.collectRefsWithType(SupplyOrderProcessing.INTERNAL_TYPE);
		this.enhanceList(supplyOrderProcessingList);
		
	}
	
	@Override
	public SmartList<SupplyOrderProcessing> findSupplyOrderProcessingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplyOrderProcessingMapper());

	}
	@Override
	public int countSupplyOrderProcessingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderProcessingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplyOrderProcessing> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderProcessingMapper());
	}
}


