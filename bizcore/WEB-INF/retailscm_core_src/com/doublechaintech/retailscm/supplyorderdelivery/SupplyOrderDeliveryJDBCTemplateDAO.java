
package com.doublechaintech.retailscm.supplyorderdelivery;

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

public class SupplyOrderDeliveryJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SupplyOrderDeliveryDAO{


			
		
	
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
	protected SupplyOrderDelivery load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderDelivery(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplyOrderDelivery load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderDelivery(SupplyOrderDeliveryTable.withId(id), options);
	}
	
	
	
	public SupplyOrderDelivery save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options){
		
		String methodName="save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderDelivery, methodName, "supplyOrderDelivery");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderDelivery(supplyOrderDelivery,options);
	}
	public SupplyOrderDelivery clone(String supplyOrderDeliveryId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderDeliveryTable.withId(supplyOrderDeliveryId),options);
	}
	
	protected SupplyOrderDelivery clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderDeliveryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderDelivery newSupplyOrderDelivery = loadInternalSupplyOrderDelivery(accessKey, options);
		newSupplyOrderDelivery.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderDelivery.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderDelivery.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderDelivery(newSupplyOrderDelivery,options);
		
		return newSupplyOrderDelivery;
	}
	
	
	
	

	protected void throwIfHasException(String supplyOrderDeliveryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderDeliveryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderDeliveryNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderDeliveryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplyOrderDeliveryId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderDeliveryId, int version)";
		assertMethodArgumentNotNull(supplyOrderDeliveryId, methodName, "supplyOrderDeliveryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderDeliveryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderDeliveryId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplyOrderDelivery disconnectFromAll(String supplyOrderDeliveryId, int version) throws Exception{
	
		
		SupplyOrderDelivery supplyOrderDelivery = loadInternalSupplyOrderDelivery(SupplyOrderDeliveryTable.withId(supplyOrderDeliveryId), emptyOptions());
		supplyOrderDelivery.clearFromAll();
		this.saveSupplyOrderDelivery(supplyOrderDelivery);
		return supplyOrderDelivery;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderDeliveryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_delivery";
	}
	@Override
	protected String getBeanName() {
		
		return "supplyOrderDelivery";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderDeliveryTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderDeliveryTokens.CONSUMER_ORDER_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,SupplyOrderDeliveryTokens.CONSUMER_ORDER_LIST+".analyze");
 	}
	
	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderDeliveryTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplyOrderDeliveryTokens.SUPPLY_ORDER_LIST);
 	}
 	protected boolean isAnalyzeSupplyOrderListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,SupplyOrderDeliveryTokens.SUPPLY_ORDER_LIST+".analyze");
 	}
	
	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderDeliveryTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
		

	

	protected SupplyOrderDeliveryMapper getSupplyOrderDeliveryMapper(){
		return new SupplyOrderDeliveryMapper();
	}

	
	
	protected SupplyOrderDelivery extractSupplyOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderDelivery supplyOrderDelivery = loadSingleObject(accessKey, getSupplyOrderDeliveryMapper());
			return supplyOrderDelivery;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderDeliveryNotFoundException("SupplyOrderDelivery("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderDelivery loadInternalSupplyOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderDelivery supplyOrderDelivery = extractSupplyOrderDelivery(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderDelivery, loadOptions);
 		}	
 		if(isAnalyzeConsumerOrderListEnabled(loadOptions)){
	 		analyzeConsumerOrderList(supplyOrderDelivery, loadOptions);
 		}
 		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderDelivery, loadOptions);
 		}	
 		if(isAnalyzeSupplyOrderListEnabled(loadOptions)){
	 		analyzeSupplyOrderList(supplyOrderDelivery, loadOptions);
 		}
 		
		
		return supplyOrderDelivery;
		
	}

	
		
	protected void enhanceConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplyOrderDelivery extractConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		if(supplyOrderDelivery == null){
			return null;
		}
		if(supplyOrderDelivery.getId() == null){
			return supplyOrderDelivery;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByDelivery(supplyOrderDelivery.getId(),options);
		if(consumerOrderList != null){
			enhanceConsumerOrderList(consumerOrderList,options);
			supplyOrderDelivery.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderDelivery;
	
	}	
	
	protected SupplyOrderDelivery analyzeConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		if(supplyOrderDelivery == null){
			return null;
		}
		if(supplyOrderDelivery.getId() == null){
			return supplyOrderDelivery;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();
		if(consumerOrderList != null){
			getConsumerOrderDAO().analyzeConsumerOrderByDelivery(consumerOrderList, supplyOrderDelivery.getId(), options);
			
		}
		
		return supplyOrderDelivery;
	
	}	
	
		
	protected void enhanceSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplyOrderDelivery extractSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		if(supplyOrderDelivery == null){
			return null;
		}
		if(supplyOrderDelivery.getId() == null){
			return supplyOrderDelivery;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByDelivery(supplyOrderDelivery.getId(),options);
		if(supplyOrderList != null){
			enhanceSupplyOrderList(supplyOrderList,options);
			supplyOrderDelivery.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderDelivery;
	
	}	
	
	protected SupplyOrderDelivery analyzeSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		if(supplyOrderDelivery == null){
			return null;
		}
		if(supplyOrderDelivery.getId() == null){
			return supplyOrderDelivery;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();
		if(supplyOrderList != null){
			getSupplyOrderDAO().analyzeSupplyOrderByDelivery(supplyOrderList, supplyOrderDelivery.getId(), options);
			
		}
		
		return supplyOrderDelivery;
	
	}	
	
		
		
 	
		
		
		

	

	protected SupplyOrderDelivery saveSupplyOrderDelivery(SupplyOrderDelivery  supplyOrderDelivery){
		
		if(!supplyOrderDelivery.isChanged()){
			return supplyOrderDelivery;
		}
		
		
		String SQL=this.getSaveSupplyOrderDeliverySQL(supplyOrderDelivery);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderDeliveryParameters(supplyOrderDelivery);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderDelivery.incVersion();
		return supplyOrderDelivery;
	
	}
	public SmartList<SupplyOrderDelivery> saveSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderDeliveryList(supplyOrderDeliveryList);
		
		batchSupplyOrderDeliveryCreate((List<SupplyOrderDelivery>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderDeliveryUpdate((List<SupplyOrderDelivery>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList){
			if(supplyOrderDelivery.isChanged()){
				supplyOrderDelivery.incVersion();
			}
			
		
		}
		
		
		return supplyOrderDeliveryList;
	}

	public SmartList<SupplyOrderDelivery> removeSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderDeliveryList, options);
		
		return supplyOrderDeliveryList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderDeliveryBatchCreateArgs(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList ){
			Object [] parameters = prepareSupplyOrderDeliveryCreateParameters(supplyOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderDeliveryBatchUpdateArgs(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderDelivery supplyOrderDelivery:supplyOrderDeliveryList ){
			if(!supplyOrderDelivery.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderDeliveryUpdateParameters(supplyOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderDeliveryCreate(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderDeliveryBatchCreateArgs(supplyOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderDeliveryUpdate(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderDeliveryBatchUpdateArgs(supplyOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderDeliveryList(List<SupplyOrderDelivery> supplyOrderDeliveryList){
		
		List<SupplyOrderDelivery> supplyOrderDeliveryCreateList=new ArrayList<SupplyOrderDelivery>();
		List<SupplyOrderDelivery> supplyOrderDeliveryUpdateList=new ArrayList<SupplyOrderDelivery>();
		
		for(SupplyOrderDelivery supplyOrderDelivery: supplyOrderDeliveryList){
			if(isUpdateRequest(supplyOrderDelivery)){
				supplyOrderDeliveryUpdateList.add( supplyOrderDelivery);
				continue;
			}
			supplyOrderDeliveryCreateList.add(supplyOrderDelivery);
		}
		
		return new Object[]{supplyOrderDeliveryCreateList,supplyOrderDeliveryUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderDelivery supplyOrderDelivery){
 		return supplyOrderDelivery.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderDeliverySQL(SupplyOrderDelivery supplyOrderDelivery){
 		if(isUpdateRequest(supplyOrderDelivery)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderDeliveryParameters(SupplyOrderDelivery supplyOrderDelivery){
 		if(isUpdateRequest(supplyOrderDelivery) ){
 			return prepareSupplyOrderDeliveryUpdateParameters(supplyOrderDelivery);
 		}
 		return prepareSupplyOrderDeliveryCreateParameters(supplyOrderDelivery);
 	}
 	protected Object[] prepareSupplyOrderDeliveryUpdateParameters(SupplyOrderDelivery supplyOrderDelivery){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = supplyOrderDelivery.getWho();
 		parameters[1] = supplyOrderDelivery.getDeliveryTime();		
 		parameters[2] = supplyOrderDelivery.nextVersion();
 		parameters[3] = supplyOrderDelivery.getId();
 		parameters[4] = supplyOrderDelivery.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderDeliveryCreateParameters(SupplyOrderDelivery supplyOrderDelivery){
		Object[] parameters = new Object[3];
		String newSupplyOrderDeliveryId=getNextId();
		supplyOrderDelivery.setId(newSupplyOrderDeliveryId);
		parameters[0] =  supplyOrderDelivery.getId();
 
 		parameters[1] = supplyOrderDelivery.getWho();
 		parameters[2] = supplyOrderDelivery.getDeliveryTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderDelivery saveInternalSupplyOrderDelivery(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		saveSupplyOrderDelivery(supplyOrderDelivery);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderDelivery, options);
	 		//removeConsumerOrderList(supplyOrderDelivery, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderDelivery, options);
	 		//removeSupplyOrderList(supplyOrderDelivery, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplyOrderDelivery;
		
	}
	
	
	
	//======================================================================================
	

	
	public SupplyOrderDelivery planToRemoveConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, String consumerOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.ID_PROPERTY, consumerOrderIds);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){

			consumerOrder.clearFromAll();
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;	
	
	}


	//disconnect SupplyOrderDelivery with consumer in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithConsumer(SupplyOrderDelivery supplyOrderDelivery, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearConsumer();
			consumerOrder.clearDelivery();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;
	}
	
	public int countConsumerOrderListWithConsumer(String supplyOrderDeliveryId, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with store in ConsumerOrder
	public SupplyOrderDelivery planToRemoveConsumerOrderListWithStore(SupplyOrderDelivery supplyOrderDelivery, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearStore();
			consumerOrder.clearDelivery();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderDelivery;
	}
	
	public int countConsumerOrderListWithStore(String supplyOrderDeliveryId, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	public SupplyOrderDelivery planToRemoveSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, String supplyOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){

			supplyOrder.clearFromAll();
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;	
	
	}


	//disconnect SupplyOrderDelivery with buyer in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithBuyer(SupplyOrderDelivery supplyOrderDelivery, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearBuyer();
			supplyOrder.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithBuyer(String supplyOrderDeliveryId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderDelivery with seller in SupplyOrder
	public SupplyOrderDelivery planToRemoveSupplyOrderListWithSeller(SupplyOrderDelivery supplyOrderDelivery, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDelivery.getId());
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearSeller();
			supplyOrder.clearDelivery();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderDelivery;
	}
	
	public int countSupplyOrderListWithSeller(String supplyOrderDeliveryId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.DELIVERY_PROPERTY, supplyOrderDeliveryId);
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	

		
	protected SupplyOrderDelivery saveConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();
		if(consumerOrderList == null){
			//null list means nothing
			return supplyOrderDelivery;
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
		
		
		return supplyOrderDelivery;
	
	}
	
	protected SupplyOrderDelivery removeConsumerOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderDelivery;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderDelivery;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderDelivery;
	
	}
	
	

 	
 	
	
	
	
		
	protected SupplyOrderDelivery saveSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
		
		
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();
		if(supplyOrderList == null){
			//null list means nothing
			return supplyOrderDelivery;
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
		
		
		return supplyOrderDelivery;
	
	}
	
	protected SupplyOrderDelivery removeSupplyOrderList(SupplyOrderDelivery supplyOrderDelivery, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderDelivery;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderDelivery;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderDelivery;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplyOrderDelivery present(SupplyOrderDelivery supplyOrderDelivery,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderDelivery,options);
		presentSupplyOrderList(supplyOrderDelivery,options);

		return supplyOrderDelivery;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderDelivery presentConsumerOrderList(
			SupplyOrderDelivery supplyOrderDelivery,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderDelivery.getConsumerOrderList();		
				SmartList<ConsumerOrder> newList= presentSubList(supplyOrderDelivery.getId(),
				consumerOrderList,
				options,
				getConsumerOrderDAO()::countConsumerOrderByDelivery,
				getConsumerOrderDAO()::findConsumerOrderByDelivery
				);

		
		supplyOrderDelivery.setConsumerOrderList(newList);
		

		return supplyOrderDelivery;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderDelivery presentSupplyOrderList(
			SupplyOrderDelivery supplyOrderDelivery,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderDelivery.getSupplyOrderList();		
				SmartList<SupplyOrder> newList= presentSubList(supplyOrderDelivery.getId(),
				supplyOrderList,
				options,
				getSupplyOrderDAO()::countSupplyOrderByDelivery,
				getSupplyOrderDAO()::findSupplyOrderByDelivery
				);

		
		supplyOrderDelivery.setSupplyOrderList(newList);
		

		return supplyOrderDelivery;
	}			
		

	
    public SmartList<SupplyOrderDelivery> requestCandidateSupplyOrderDeliveryForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderDeliveryTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderDeliveryMapper());
    }
		
    public SmartList<SupplyOrderDelivery> requestCandidateSupplyOrderDeliveryForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderDeliveryTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderDeliveryMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderDeliveryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrderDelivery> supplyOrderDeliveryList) {		
		this.enhanceListInternal(supplyOrderDeliveryList, this.getSupplyOrderDeliveryMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderDelivery> supplyOrderDeliveryList = ownerEntity.collectRefsWithType(SupplyOrderDelivery.INTERNAL_TYPE);
		this.enhanceList(supplyOrderDeliveryList);
		
	}
	
	@Override
	public SmartList<SupplyOrderDelivery> findSupplyOrderDeliveryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplyOrderDeliveryMapper());

	}
	@Override
	public int countSupplyOrderDeliveryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplyOrderDelivery> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderDeliveryMapper());
	}
}


