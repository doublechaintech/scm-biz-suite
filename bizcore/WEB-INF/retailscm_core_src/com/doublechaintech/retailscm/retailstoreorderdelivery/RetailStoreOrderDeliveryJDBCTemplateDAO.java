
package com.doublechaintech.retailscm.retailstoreorderdelivery;

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


import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreOrderDeliveryJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreOrderDeliveryDAO{


			
		
	
  	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO pRetailStoreOrderDAO){
 	
 		if(pRetailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = pRetailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The retailStoreOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreOrderDelivery load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderDelivery(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreOrderDelivery load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderDelivery(RetailStoreOrderDeliveryTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderDelivery save(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderDelivery, methodName, "retailStoreOrderDelivery");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderDelivery(retailStoreOrderDelivery,options);
	}
	public RetailStoreOrderDelivery clone(String retailStoreOrderDeliveryId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderDeliveryTable.withId(retailStoreOrderDeliveryId),options);
	}
	
	protected RetailStoreOrderDelivery clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderDeliveryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderDelivery newRetailStoreOrderDelivery = loadInternalRetailStoreOrderDelivery(accessKey, options);
		newRetailStoreOrderDelivery.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderDelivery.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderDelivery(newRetailStoreOrderDelivery,options);
		
		return newRetailStoreOrderDelivery;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreOrderDeliveryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderDeliveryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderDeliveryNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderDeliveryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreOrderDeliveryId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderDeliveryId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderDeliveryId, methodName, "retailStoreOrderDeliveryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderDeliveryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderDeliveryId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreOrderDelivery disconnectFromAll(String retailStoreOrderDeliveryId, int version) throws Exception{
	
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = loadInternalRetailStoreOrderDelivery(RetailStoreOrderDeliveryTable.withId(retailStoreOrderDeliveryId), emptyOptions());
		retailStoreOrderDelivery.clearFromAll();
		this.saveRetailStoreOrderDelivery(retailStoreOrderDelivery);
		return retailStoreOrderDelivery;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderDeliveryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_delivery";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreOrderDelivery";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderDeliveryTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreOrderDeliveryTokens.RETAIL_STORE_ORDER_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreOrderDeliveryTokens.RETAIL_STORE_ORDER_LIST+".analyze");
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderDeliveryTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
		

	

	protected RetailStoreOrderDeliveryMapper getRetailStoreOrderDeliveryMapper(){
		return new RetailStoreOrderDeliveryMapper();
	}

	
	
	protected RetailStoreOrderDelivery extractRetailStoreOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrderDelivery retailStoreOrderDelivery = loadSingleObject(accessKey, getRetailStoreOrderDeliveryMapper());
			return retailStoreOrderDelivery;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderDeliveryNotFoundException("RetailStoreOrderDelivery("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreOrderDelivery loadInternalRetailStoreOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderDelivery retailStoreOrderDelivery = extractRetailStoreOrderDelivery(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderDelivery, loadOptions);
 		}	
 		if(isAnalyzeRetailStoreOrderListEnabled(loadOptions)){
	 		// analyzeRetailStoreOrderList(retailStoreOrderDelivery, loadOptions);
 		}
 		
		
		return retailStoreOrderDelivery;
		
	}

	
		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStoreOrderDelivery extractRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
		
		
		if(retailStoreOrderDelivery == null){
			return null;
		}
		if(retailStoreOrderDelivery.getId() == null){
			return retailStoreOrderDelivery;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByDelivery(retailStoreOrderDelivery.getId(),options);
		if(retailStoreOrderList != null){
			enhanceRetailStoreOrderList(retailStoreOrderList,options);
			retailStoreOrderDelivery.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderDelivery;
	
	}	
	
	protected RetailStoreOrderDelivery analyzeRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
		
		
		if(retailStoreOrderDelivery == null){
			return null;
		}
		if(retailStoreOrderDelivery.getId() == null){
			return retailStoreOrderDelivery;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();
		if(retailStoreOrderList != null){
			getRetailStoreOrderDAO().analyzeRetailStoreOrderByDelivery(retailStoreOrderList, retailStoreOrderDelivery.getId(), options);
			
		}
		
		return retailStoreOrderDelivery;
	
	}	
	
		
		
 	
		
		
		

	

	protected RetailStoreOrderDelivery saveRetailStoreOrderDelivery(RetailStoreOrderDelivery  retailStoreOrderDelivery){
		
		if(!retailStoreOrderDelivery.isChanged()){
			return retailStoreOrderDelivery;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderDeliverySQL(retailStoreOrderDelivery);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderDeliveryParameters(retailStoreOrderDelivery);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderDelivery.incVersion();
		return retailStoreOrderDelivery;
	
	}
	public SmartList<RetailStoreOrderDelivery> saveRetailStoreOrderDeliveryList(SmartList<RetailStoreOrderDelivery> retailStoreOrderDeliveryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderDeliveryList(retailStoreOrderDeliveryList);
		
		batchRetailStoreOrderDeliveryCreate((List<RetailStoreOrderDelivery>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderDeliveryUpdate((List<RetailStoreOrderDelivery>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderDelivery retailStoreOrderDelivery:retailStoreOrderDeliveryList){
			if(retailStoreOrderDelivery.isChanged()){
				retailStoreOrderDelivery.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderDeliveryList;
	}

	public SmartList<RetailStoreOrderDelivery> removeRetailStoreOrderDeliveryList(SmartList<RetailStoreOrderDelivery> retailStoreOrderDeliveryList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderDeliveryList, options);
		
		return retailStoreOrderDeliveryList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderDeliveryBatchCreateArgs(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderDelivery retailStoreOrderDelivery:retailStoreOrderDeliveryList ){
			Object [] parameters = prepareRetailStoreOrderDeliveryCreateParameters(retailStoreOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderDeliveryBatchUpdateArgs(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderDelivery retailStoreOrderDelivery:retailStoreOrderDeliveryList ){
			if(!retailStoreOrderDelivery.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderDeliveryUpdateParameters(retailStoreOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderDeliveryCreate(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderDeliveryBatchCreateArgs(retailStoreOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderDeliveryUpdate(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderDeliveryBatchUpdateArgs(retailStoreOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderDeliveryList(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList){
		
		List<RetailStoreOrderDelivery> retailStoreOrderDeliveryCreateList=new ArrayList<RetailStoreOrderDelivery>();
		List<RetailStoreOrderDelivery> retailStoreOrderDeliveryUpdateList=new ArrayList<RetailStoreOrderDelivery>();
		
		for(RetailStoreOrderDelivery retailStoreOrderDelivery: retailStoreOrderDeliveryList){
			if(isUpdateRequest(retailStoreOrderDelivery)){
				retailStoreOrderDeliveryUpdateList.add( retailStoreOrderDelivery);
				continue;
			}
			retailStoreOrderDeliveryCreateList.add(retailStoreOrderDelivery);
		}
		
		return new Object[]{retailStoreOrderDeliveryCreateList,retailStoreOrderDeliveryUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderDelivery retailStoreOrderDelivery){
 		return retailStoreOrderDelivery.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderDeliverySQL(RetailStoreOrderDelivery retailStoreOrderDelivery){
 		if(isUpdateRequest(retailStoreOrderDelivery)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderDeliveryParameters(RetailStoreOrderDelivery retailStoreOrderDelivery){
 		if(isUpdateRequest(retailStoreOrderDelivery) ){
 			return prepareRetailStoreOrderDeliveryUpdateParameters(retailStoreOrderDelivery);
 		}
 		return prepareRetailStoreOrderDeliveryCreateParameters(retailStoreOrderDelivery);
 	}
 	protected Object[] prepareRetailStoreOrderDeliveryUpdateParameters(RetailStoreOrderDelivery retailStoreOrderDelivery){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreOrderDelivery.getWho();
 		parameters[1] = retailStoreOrderDelivery.getDeliveryTime();		
 		parameters[2] = retailStoreOrderDelivery.nextVersion();
 		parameters[3] = retailStoreOrderDelivery.getId();
 		parameters[4] = retailStoreOrderDelivery.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderDeliveryCreateParameters(RetailStoreOrderDelivery retailStoreOrderDelivery){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderDeliveryId=getNextId();
		retailStoreOrderDelivery.setId(newRetailStoreOrderDeliveryId);
		parameters[0] =  retailStoreOrderDelivery.getId();
 
 		parameters[1] = retailStoreOrderDelivery.getWho();
 		parameters[2] = retailStoreOrderDelivery.getDeliveryTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderDelivery saveInternalRetailStoreOrderDelivery(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
		
		saveRetailStoreOrderDelivery(retailStoreOrderDelivery);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderDelivery, options);
	 		//removeRetailStoreOrderList(retailStoreOrderDelivery, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreOrderDelivery;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, String retailStoreOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.DELIVERY_PROPERTY, retailStoreOrderDelivery.getId());
		key.put(RetailStoreOrder.ID_PROPERTY, retailStoreOrderIds);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderDelivery;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderDelivery;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){

			retailStoreOrder.clearFromAll();
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderDelivery;	
	
	}


	//disconnect RetailStoreOrderDelivery with buyer in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderDelivery retailStoreOrderDelivery, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.DELIVERY_PROPERTY, retailStoreOrderDelivery.getId());
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderDelivery;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderDelivery;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearBuyer();
			retailStoreOrder.clearDelivery();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderDelivery;
	}
	
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderDeliveryId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.DELIVERY_PROPERTY, retailStoreOrderDeliveryId);
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrderDelivery with seller in RetailStoreOrder
	public RetailStoreOrderDelivery planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderDelivery retailStoreOrderDelivery, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.DELIVERY_PROPERTY, retailStoreOrderDelivery.getId());
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderDelivery;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderDelivery;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearSeller();
			retailStoreOrder.clearDelivery();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderDelivery;
	}
	
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderDeliveryId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.DELIVERY_PROPERTY, retailStoreOrderDeliveryId);
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreOrderDelivery saveRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			//null list means nothing
			return retailStoreOrderDelivery;
		}
		SmartList<RetailStoreOrder> mergedUpdateRetailStoreOrderList = new SmartList<RetailStoreOrder>();
		
		
		mergedUpdateRetailStoreOrderList.addAll(retailStoreOrderList); 
		if(retailStoreOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreOrderList.addAll(retailStoreOrderList.getToRemoveList());
			retailStoreOrderList.removeAll(retailStoreOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRetailStoreOrderDAO().saveRetailStoreOrderList(mergedUpdateRetailStoreOrderList,options);
		
		if(retailStoreOrderList.getToRemoveList() != null){
			retailStoreOrderList.removeAll(retailStoreOrderList.getToRemoveList());
		}
		
		
		return retailStoreOrderDelivery;
	
	}
	
	protected RetailStoreOrderDelivery removeRetailStoreOrderList(RetailStoreOrderDelivery retailStoreOrderDelivery, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderDelivery;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderDelivery;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderDelivery;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderDelivery;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreOrderDelivery present(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderDelivery,options);

		return retailStoreOrderDelivery;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrderDelivery presentRetailStoreOrderList(
			RetailStoreOrderDelivery retailStoreOrderDelivery,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderDelivery.getRetailStoreOrderList();		
				SmartList<RetailStoreOrder> newList= presentSubList(retailStoreOrderDelivery.getId(),
				retailStoreOrderList,
				options,
				getRetailStoreOrderDAO()::countRetailStoreOrderByDelivery,
				getRetailStoreOrderDAO()::findRetailStoreOrderByDelivery
				);

		
		retailStoreOrderDelivery.setRetailStoreOrderList(newList);
		

		return retailStoreOrderDelivery;
	}			
		

	
    public SmartList<RetailStoreOrderDelivery> requestCandidateRetailStoreOrderDeliveryForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderDeliveryTable.COLUMN_WHO, filterKey, pageNo, pageSize, getRetailStoreOrderDeliveryMapper());
    }
		

	protected String getTableName(){
		return RetailStoreOrderDeliveryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList) {		
		this.enhanceListInternal(retailStoreOrderDeliveryList, this.getRetailStoreOrderDeliveryMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreOrderDelivery> retailStoreOrderDeliveryList = ownerEntity.collectRefsWithType(RetailStoreOrderDelivery.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderDeliveryList);
		
	}
	
	@Override
	public SmartList<RetailStoreOrderDelivery> findRetailStoreOrderDeliveryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreOrderDeliveryMapper());

	}
	@Override
	public int countRetailStoreOrderDeliveryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreOrderDelivery> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderDeliveryMapper());
	}
}


