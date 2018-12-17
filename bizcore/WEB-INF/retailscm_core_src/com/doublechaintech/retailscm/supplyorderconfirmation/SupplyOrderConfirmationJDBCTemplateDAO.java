
package com.doublechaintech.retailscm.supplyorderconfirmation;

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

public class SupplyOrderConfirmationJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SupplyOrderConfirmationDAO{


			
		
	
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
	protected SupplyOrderConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderConfirmation(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplyOrderConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderConfirmation(SupplyOrderConfirmationTable.withId(id), options);
	}
	
	
	
	public SupplyOrderConfirmation save(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options){
		
		String methodName="save(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderConfirmation, methodName, "supplyOrderConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderConfirmation(supplyOrderConfirmation,options);
	}
	public SupplyOrderConfirmation clone(String supplyOrderConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderConfirmationTable.withId(supplyOrderConfirmationId),options);
	}
	
	protected SupplyOrderConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderConfirmation newSupplyOrderConfirmation = loadInternalSupplyOrderConfirmation(accessKey, options);
		newSupplyOrderConfirmation.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newSupplyOrderConfirmation.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderConfirmation.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderConfirmation(newSupplyOrderConfirmation,options);
		
		return newSupplyOrderConfirmation;
	}
	
	
	
	

	protected void throwIfHasException(String supplyOrderConfirmationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplyOrderConfirmationId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderConfirmationId, int version)";
		assertMethodArgumentNotNull(supplyOrderConfirmationId, methodName, "supplyOrderConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderConfirmationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderConfirmationId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplyOrderConfirmation disconnectFromAll(String supplyOrderConfirmationId, int version) throws Exception{
	
		
		SupplyOrderConfirmation supplyOrderConfirmation = loadInternalSupplyOrderConfirmation(SupplyOrderConfirmationTable.withId(supplyOrderConfirmationId), emptyOptions());
		supplyOrderConfirmation.clearFromAll();
		this.saveSupplyOrderConfirmation(supplyOrderConfirmation);
		return supplyOrderConfirmation;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_confirmation";
	}
	@Override
	protected String getBeanName() {
		
		return "supplyOrderConfirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderConfirmationTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderConfirmationTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderConfirmationTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderConfirmationTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderConfirmationMapper getSupplyOrderConfirmationMapper(){
		return new SupplyOrderConfirmationMapper();
	}

	
	
	protected SupplyOrderConfirmation extractSupplyOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderConfirmation supplyOrderConfirmation = loadSingleObject(accessKey, getSupplyOrderConfirmationMapper());
			return supplyOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderConfirmationNotFoundException("SupplyOrderConfirmation("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderConfirmation loadInternalSupplyOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderConfirmation supplyOrderConfirmation = extractSupplyOrderConfirmation(accessKey, loadOptions);

		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(supplyOrderConfirmation, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderConfirmation, loadOptions);
 		}		
		
		return supplyOrderConfirmation;
		
	}



	
	
	
		
	protected void enhanceConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected SupplyOrderConfirmation extractConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		
		
		if(supplyOrderConfirmation == null){
			return null;
		}
		if(supplyOrderConfirmation.getId() == null){
			return supplyOrderConfirmation;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByConfirmation(supplyOrderConfirmation.getId(),options);
		if(consumerOrderList != null){
			enhanceConsumerOrderList(consumerOrderList,options);
			supplyOrderConfirmation.setConsumerOrderList(consumerOrderList);
		}
		
		return supplyOrderConfirmation;
	
	}	
		
	protected void enhanceSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected SupplyOrderConfirmation extractSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		
		
		if(supplyOrderConfirmation == null){
			return null;
		}
		if(supplyOrderConfirmation.getId() == null){
			return supplyOrderConfirmation;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByConfirmation(supplyOrderConfirmation.getId(),options);
		if(supplyOrderList != null){
			enhanceSupplyOrderList(supplyOrderList,options);
			supplyOrderConfirmation.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderConfirmation;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderConfirmation saveSupplyOrderConfirmation(SupplyOrderConfirmation  supplyOrderConfirmation){
		
		if(!supplyOrderConfirmation.isChanged()){
			return supplyOrderConfirmation;
		}
		
		
		String SQL=this.getSaveSupplyOrderConfirmationSQL(supplyOrderConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderConfirmationParameters(supplyOrderConfirmation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderConfirmation.incVersion();
		return supplyOrderConfirmation;
	
	}
	public SmartList<SupplyOrderConfirmation> saveSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderConfirmationList(supplyOrderConfirmationList);
		
		batchSupplyOrderConfirmationCreate((List<SupplyOrderConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderConfirmationUpdate((List<SupplyOrderConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderConfirmation supplyOrderConfirmation:supplyOrderConfirmationList){
			if(supplyOrderConfirmation.isChanged()){
				supplyOrderConfirmation.incVersion();
			}
			
		
		}
		
		
		return supplyOrderConfirmationList;
	}

	public SmartList<SupplyOrderConfirmation> removeSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderConfirmationList, options);
		
		return supplyOrderConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderConfirmationBatchCreateArgs(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderConfirmation supplyOrderConfirmation:supplyOrderConfirmationList ){
			Object [] parameters = prepareSupplyOrderConfirmationCreateParameters(supplyOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderConfirmationBatchUpdateArgs(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderConfirmation supplyOrderConfirmation:supplyOrderConfirmationList ){
			if(!supplyOrderConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderConfirmationUpdateParameters(supplyOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderConfirmationCreate(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderConfirmationBatchCreateArgs(supplyOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderConfirmationUpdate(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderConfirmationBatchUpdateArgs(supplyOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderConfirmationList(List<SupplyOrderConfirmation> supplyOrderConfirmationList){
		
		List<SupplyOrderConfirmation> supplyOrderConfirmationCreateList=new ArrayList<SupplyOrderConfirmation>();
		List<SupplyOrderConfirmation> supplyOrderConfirmationUpdateList=new ArrayList<SupplyOrderConfirmation>();
		
		for(SupplyOrderConfirmation supplyOrderConfirmation: supplyOrderConfirmationList){
			if(isUpdateRequest(supplyOrderConfirmation)){
				supplyOrderConfirmationUpdateList.add( supplyOrderConfirmation);
				continue;
			}
			supplyOrderConfirmationCreateList.add(supplyOrderConfirmation);
		}
		
		return new Object[]{supplyOrderConfirmationCreateList,supplyOrderConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderConfirmation supplyOrderConfirmation){
 		return supplyOrderConfirmation.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderConfirmationSQL(SupplyOrderConfirmation supplyOrderConfirmation){
 		if(isUpdateRequest(supplyOrderConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderConfirmationParameters(SupplyOrderConfirmation supplyOrderConfirmation){
 		if(isUpdateRequest(supplyOrderConfirmation) ){
 			return prepareSupplyOrderConfirmationUpdateParameters(supplyOrderConfirmation);
 		}
 		return prepareSupplyOrderConfirmationCreateParameters(supplyOrderConfirmation);
 	}
 	protected Object[] prepareSupplyOrderConfirmationUpdateParameters(SupplyOrderConfirmation supplyOrderConfirmation){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = supplyOrderConfirmation.getWho();
 		parameters[1] = supplyOrderConfirmation.getConfirmTime();		
 		parameters[2] = supplyOrderConfirmation.nextVersion();
 		parameters[3] = supplyOrderConfirmation.getId();
 		parameters[4] = supplyOrderConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderConfirmationCreateParameters(SupplyOrderConfirmation supplyOrderConfirmation){
		Object[] parameters = new Object[3];
		String newSupplyOrderConfirmationId=getNextId();
		supplyOrderConfirmation.setId(newSupplyOrderConfirmationId);
		parameters[0] =  supplyOrderConfirmation.getId();
 
 		parameters[1] = supplyOrderConfirmation.getWho();
 		parameters[2] = supplyOrderConfirmation.getConfirmTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderConfirmation saveInternalSupplyOrderConfirmation(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		
		saveSupplyOrderConfirmation(supplyOrderConfirmation);

		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(supplyOrderConfirmation, options);
	 		//removeConsumerOrderList(supplyOrderConfirmation, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderConfirmation, options);
	 		//removeSupplyOrderList(supplyOrderConfirmation, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplyOrderConfirmation;
		
	}
	
	
	
	//======================================================================================
	

	
	public SupplyOrderConfirmation planToRemoveConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, String consumerOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmation.getId());
		key.put(ConsumerOrder.ID_PROPERTY, consumerOrderIds);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderConfirmation;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderConfirmation;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){

			consumerOrder.clearFromAll();
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderConfirmation;	
	
	}


	//disconnect SupplyOrderConfirmation with consumer in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithConsumer(SupplyOrderConfirmation supplyOrderConfirmation, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmation.getId());
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderConfirmation;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderConfirmation;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearConsumer();
			consumerOrder.clearConfirmation();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderConfirmation;
	}
	
	public int countConsumerOrderListWithConsumer(String supplyOrderConfirmationId, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmationId);
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderConfirmation with store in ConsumerOrder
	public SupplyOrderConfirmation planToRemoveConsumerOrderListWithStore(SupplyOrderConfirmation supplyOrderConfirmation, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmation.getId());
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return supplyOrderConfirmation;
		}
		if(externalConsumerOrderList.isEmpty()){
			return supplyOrderConfirmation;
		}
		
		for(ConsumerOrder consumerOrder: externalConsumerOrderList){
			consumerOrder.clearStore();
			consumerOrder.clearConfirmation();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return supplyOrderConfirmation;
	}
	
	public int countConsumerOrderListWithStore(String supplyOrderConfirmationId, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmationId);
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	public SupplyOrderConfirmation planToRemoveSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, String supplyOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmation.getId());
		key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderConfirmation;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderConfirmation;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){

			supplyOrder.clearFromAll();
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderConfirmation;	
	
	}


	//disconnect SupplyOrderConfirmation with buyer in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithBuyer(SupplyOrderConfirmation supplyOrderConfirmation, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmation.getId());
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderConfirmation;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderConfirmation;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearBuyer();
			supplyOrder.clearConfirmation();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderConfirmation;
	}
	
	public int countSupplyOrderListWithBuyer(String supplyOrderConfirmationId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmationId);
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderConfirmation with seller in SupplyOrder
	public SupplyOrderConfirmation planToRemoveSupplyOrderListWithSeller(SupplyOrderConfirmation supplyOrderConfirmation, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmation.getId());
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderConfirmation;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderConfirmation;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearSeller();
			supplyOrder.clearConfirmation();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderConfirmation;
	}
	
	public int countSupplyOrderListWithSeller(String supplyOrderConfirmationId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.CONFIRMATION_PROPERTY, supplyOrderConfirmationId);
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	

		
	protected SupplyOrderConfirmation saveConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();
		if(consumerOrderList == null){
			//null list means nothing
			return supplyOrderConfirmation;
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
		
		
		return supplyOrderConfirmation;
	
	}
	
	protected SupplyOrderConfirmation removeConsumerOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();
		if(consumerOrderList == null){
			return supplyOrderConfirmation;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return supplyOrderConfirmation;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return supplyOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return supplyOrderConfirmation;
	
	}
	
	

 	
 	
	
	
	
		
	protected SupplyOrderConfirmation saveSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
		
		
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();
		if(supplyOrderList == null){
			//null list means nothing
			return supplyOrderConfirmation;
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
		
		
		return supplyOrderConfirmation;
	
	}
	
	protected SupplyOrderConfirmation removeSupplyOrderList(SupplyOrderConfirmation supplyOrderConfirmation, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderConfirmation;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderConfirmation;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderConfirmation;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplyOrderConfirmation present(SupplyOrderConfirmation supplyOrderConfirmation,Map<String, Object> options){
	
		presentConsumerOrderList(supplyOrderConfirmation,options);
		presentSupplyOrderList(supplyOrderConfirmation,options);

		return supplyOrderConfirmation;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderConfirmation presentConsumerOrderList(
			SupplyOrderConfirmation supplyOrderConfirmation,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = supplyOrderConfirmation.getConsumerOrderList();		
				SmartList<ConsumerOrder> newList= presentSubList(supplyOrderConfirmation.getId(),
				consumerOrderList,
				options,
				getConsumerOrderDAO()::countConsumerOrderByConfirmation,
				getConsumerOrderDAO()::findConsumerOrderByConfirmation
				);

		
		supplyOrderConfirmation.setConsumerOrderList(newList);
		

		return supplyOrderConfirmation;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderConfirmation presentSupplyOrderList(
			SupplyOrderConfirmation supplyOrderConfirmation,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderConfirmation.getSupplyOrderList();		
				SmartList<SupplyOrder> newList= presentSubList(supplyOrderConfirmation.getId(),
				supplyOrderList,
				options,
				getSupplyOrderDAO()::countSupplyOrderByConfirmation,
				getSupplyOrderDAO()::findSupplyOrderByConfirmation
				);

		
		supplyOrderConfirmation.setSupplyOrderList(newList);
		

		return supplyOrderConfirmation;
	}			
		

	
    public SmartList<SupplyOrderConfirmation> requestCandidateSupplyOrderConfirmationForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderConfirmationTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderConfirmationMapper());
    }
		
    public SmartList<SupplyOrderConfirmation> requestCandidateSupplyOrderConfirmationForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderConfirmationTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderConfirmationMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderConfirmationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrderConfirmation> supplyOrderConfirmationList) {		
		this.enhanceListInternal(supplyOrderConfirmationList, this.getSupplyOrderConfirmationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderConfirmation> supplyOrderConfirmationList = ownerEntity.collectRefsWithType(SupplyOrderConfirmation.INTERNAL_TYPE);
		this.enhanceList(supplyOrderConfirmationList);
		
	}
	
	@Override
	public SmartList<SupplyOrderConfirmation> findSupplyOrderConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplyOrderConfirmationMapper());

	}
	@Override
	public int countSupplyOrderConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplyOrderConfirmation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderConfirmationMapper());
	}
}


