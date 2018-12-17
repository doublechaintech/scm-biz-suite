
package com.doublechaintech.retailscm.retailstoreorderprocessing;

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

public class RetailStoreOrderProcessingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreOrderProcessingDAO{


			
		
	
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
	protected RetailStoreOrderProcessing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderProcessing(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreOrderProcessing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderProcessing(RetailStoreOrderProcessingTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderProcessing save(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderProcessing, methodName, "retailStoreOrderProcessing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderProcessing(retailStoreOrderProcessing,options);
	}
	public RetailStoreOrderProcessing clone(String retailStoreOrderProcessingId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderProcessingTable.withId(retailStoreOrderProcessingId),options);
	}
	
	protected RetailStoreOrderProcessing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderProcessingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderProcessing newRetailStoreOrderProcessing = loadInternalRetailStoreOrderProcessing(accessKey, options);
		newRetailStoreOrderProcessing.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderProcessing.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderProcessing(newRetailStoreOrderProcessing,options);
		
		return newRetailStoreOrderProcessing;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreOrderProcessingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderProcessingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderProcessingNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderProcessingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreOrderProcessingId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderProcessingId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderProcessingId, methodName, "retailStoreOrderProcessingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderProcessingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderProcessingId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreOrderProcessing disconnectFromAll(String retailStoreOrderProcessingId, int version) throws Exception{
	
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = loadInternalRetailStoreOrderProcessing(RetailStoreOrderProcessingTable.withId(retailStoreOrderProcessingId), emptyOptions());
		retailStoreOrderProcessing.clearFromAll();
		this.saveRetailStoreOrderProcessing(retailStoreOrderProcessing);
		return retailStoreOrderProcessing;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderProcessingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_processing";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreOrderProcessing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderProcessingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderProcessingTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderProcessingTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderProcessingMapper getRetailStoreOrderProcessingMapper(){
		return new RetailStoreOrderProcessingMapper();
	}

	
	
	protected RetailStoreOrderProcessing extractRetailStoreOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrderProcessing retailStoreOrderProcessing = loadSingleObject(accessKey, getRetailStoreOrderProcessingMapper());
			return retailStoreOrderProcessing;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderProcessingNotFoundException("RetailStoreOrderProcessing("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreOrderProcessing loadInternalRetailStoreOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderProcessing retailStoreOrderProcessing = extractRetailStoreOrderProcessing(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderProcessing, loadOptions);
 		}		
		
		return retailStoreOrderProcessing;
		
	}



	
	
	
		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected RetailStoreOrderProcessing extractRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options){
		
		
		if(retailStoreOrderProcessing == null){
			return null;
		}
		if(retailStoreOrderProcessing.getId() == null){
			return retailStoreOrderProcessing;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByProcessing(retailStoreOrderProcessing.getId(),options);
		if(retailStoreOrderList != null){
			enhanceRetailStoreOrderList(retailStoreOrderList,options);
			retailStoreOrderProcessing.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderProcessing;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderProcessing saveRetailStoreOrderProcessing(RetailStoreOrderProcessing  retailStoreOrderProcessing){
		
		if(!retailStoreOrderProcessing.isChanged()){
			return retailStoreOrderProcessing;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderProcessingSQL(retailStoreOrderProcessing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderProcessingParameters(retailStoreOrderProcessing);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderProcessing.incVersion();
		return retailStoreOrderProcessing;
	
	}
	public SmartList<RetailStoreOrderProcessing> saveRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderProcessingList(retailStoreOrderProcessingList);
		
		batchRetailStoreOrderProcessingCreate((List<RetailStoreOrderProcessing>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderProcessingUpdate((List<RetailStoreOrderProcessing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderProcessing retailStoreOrderProcessing:retailStoreOrderProcessingList){
			if(retailStoreOrderProcessing.isChanged()){
				retailStoreOrderProcessing.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderProcessingList;
	}

	public SmartList<RetailStoreOrderProcessing> removeRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderProcessingList, options);
		
		return retailStoreOrderProcessingList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderProcessingBatchCreateArgs(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderProcessing retailStoreOrderProcessing:retailStoreOrderProcessingList ){
			Object [] parameters = prepareRetailStoreOrderProcessingCreateParameters(retailStoreOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderProcessingBatchUpdateArgs(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderProcessing retailStoreOrderProcessing:retailStoreOrderProcessingList ){
			if(!retailStoreOrderProcessing.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderProcessingUpdateParameters(retailStoreOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderProcessingCreate(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderProcessingBatchCreateArgs(retailStoreOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderProcessingUpdate(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderProcessingBatchUpdateArgs(retailStoreOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderProcessingList(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList){
		
		List<RetailStoreOrderProcessing> retailStoreOrderProcessingCreateList=new ArrayList<RetailStoreOrderProcessing>();
		List<RetailStoreOrderProcessing> retailStoreOrderProcessingUpdateList=new ArrayList<RetailStoreOrderProcessing>();
		
		for(RetailStoreOrderProcessing retailStoreOrderProcessing: retailStoreOrderProcessingList){
			if(isUpdateRequest(retailStoreOrderProcessing)){
				retailStoreOrderProcessingUpdateList.add( retailStoreOrderProcessing);
				continue;
			}
			retailStoreOrderProcessingCreateList.add(retailStoreOrderProcessing);
		}
		
		return new Object[]{retailStoreOrderProcessingCreateList,retailStoreOrderProcessingUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderProcessing retailStoreOrderProcessing){
 		return retailStoreOrderProcessing.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderProcessingSQL(RetailStoreOrderProcessing retailStoreOrderProcessing){
 		if(isUpdateRequest(retailStoreOrderProcessing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderProcessingParameters(RetailStoreOrderProcessing retailStoreOrderProcessing){
 		if(isUpdateRequest(retailStoreOrderProcessing) ){
 			return prepareRetailStoreOrderProcessingUpdateParameters(retailStoreOrderProcessing);
 		}
 		return prepareRetailStoreOrderProcessingCreateParameters(retailStoreOrderProcessing);
 	}
 	protected Object[] prepareRetailStoreOrderProcessingUpdateParameters(RetailStoreOrderProcessing retailStoreOrderProcessing){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreOrderProcessing.getWho();
 		parameters[1] = retailStoreOrderProcessing.getProcessTime();		
 		parameters[2] = retailStoreOrderProcessing.nextVersion();
 		parameters[3] = retailStoreOrderProcessing.getId();
 		parameters[4] = retailStoreOrderProcessing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderProcessingCreateParameters(RetailStoreOrderProcessing retailStoreOrderProcessing){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderProcessingId=getNextId();
		retailStoreOrderProcessing.setId(newRetailStoreOrderProcessingId);
		parameters[0] =  retailStoreOrderProcessing.getId();
 
 		parameters[1] = retailStoreOrderProcessing.getWho();
 		parameters[2] = retailStoreOrderProcessing.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderProcessing saveInternalRetailStoreOrderProcessing(RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options){
		
		saveRetailStoreOrderProcessing(retailStoreOrderProcessing);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderProcessing, options);
	 		//removeRetailStoreOrderList(retailStoreOrderProcessing, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreOrderProcessing;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, String retailStoreOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PROCESSING_PROPERTY, retailStoreOrderProcessing.getId());
		key.put(RetailStoreOrder.ID_PROPERTY, retailStoreOrderIds);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderProcessing;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderProcessing;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){

			retailStoreOrder.clearFromAll();
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderProcessing;	
	
	}


	//disconnect RetailStoreOrderProcessing with buyer in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderProcessing retailStoreOrderProcessing, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PROCESSING_PROPERTY, retailStoreOrderProcessing.getId());
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderProcessing;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderProcessing;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearBuyer();
			retailStoreOrder.clearProcessing();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderProcessing;
	}
	
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderProcessingId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PROCESSING_PROPERTY, retailStoreOrderProcessingId);
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrderProcessing with seller in RetailStoreOrder
	public RetailStoreOrderProcessing planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderProcessing retailStoreOrderProcessing, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PROCESSING_PROPERTY, retailStoreOrderProcessing.getId());
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderProcessing;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderProcessing;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearSeller();
			retailStoreOrder.clearProcessing();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderProcessing;
	}
	
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderProcessingId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PROCESSING_PROPERTY, retailStoreOrderProcessingId);
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreOrderProcessing saveRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			//null list means nothing
			return retailStoreOrderProcessing;
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
		
		
		return retailStoreOrderProcessing;
	
	}
	
	protected RetailStoreOrderProcessing removeRetailStoreOrderList(RetailStoreOrderProcessing retailStoreOrderProcessing, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderProcessing;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderProcessing;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderProcessing;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderProcessing;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreOrderProcessing present(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderProcessing,options);

		return retailStoreOrderProcessing;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrderProcessing presentRetailStoreOrderList(
			RetailStoreOrderProcessing retailStoreOrderProcessing,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderProcessing.getRetailStoreOrderList();		
				SmartList<RetailStoreOrder> newList= presentSubList(retailStoreOrderProcessing.getId(),
				retailStoreOrderList,
				options,
				getRetailStoreOrderDAO()::countRetailStoreOrderByProcessing,
				getRetailStoreOrderDAO()::findRetailStoreOrderByProcessing
				);

		
		retailStoreOrderProcessing.setRetailStoreOrderList(newList);
		

		return retailStoreOrderProcessing;
	}			
		

	
    public SmartList<RetailStoreOrderProcessing> requestCandidateRetailStoreOrderProcessingForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderProcessingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getRetailStoreOrderProcessingMapper());
    }
		

	protected String getTableName(){
		return RetailStoreOrderProcessingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrderProcessing> retailStoreOrderProcessingList) {		
		this.enhanceListInternal(retailStoreOrderProcessingList, this.getRetailStoreOrderProcessingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreOrderProcessing> retailStoreOrderProcessingList = ownerEntity.collectRefsWithType(RetailStoreOrderProcessing.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderProcessingList);
		
	}
	
	@Override
	public SmartList<RetailStoreOrderProcessing> findRetailStoreOrderProcessingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreOrderProcessingMapper());

	}
	@Override
	public int countRetailStoreOrderProcessingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderProcessingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreOrderProcessing> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderProcessingMapper());
	}
}


