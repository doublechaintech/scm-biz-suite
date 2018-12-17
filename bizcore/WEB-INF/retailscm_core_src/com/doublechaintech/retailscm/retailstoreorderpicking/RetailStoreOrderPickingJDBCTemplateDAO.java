
package com.doublechaintech.retailscm.retailstoreorderpicking;

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

public class RetailStoreOrderPickingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreOrderPickingDAO{


			
		
	
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
	protected RetailStoreOrderPicking load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderPicking(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreOrderPicking load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderPicking(RetailStoreOrderPickingTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderPicking save(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderPicking, methodName, "retailStoreOrderPicking");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderPicking(retailStoreOrderPicking,options);
	}
	public RetailStoreOrderPicking clone(String retailStoreOrderPickingId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderPickingTable.withId(retailStoreOrderPickingId),options);
	}
	
	protected RetailStoreOrderPicking clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderPickingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderPicking newRetailStoreOrderPicking = loadInternalRetailStoreOrderPicking(accessKey, options);
		newRetailStoreOrderPicking.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderPicking.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderPicking(newRetailStoreOrderPicking,options);
		
		return newRetailStoreOrderPicking;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreOrderPickingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderPickingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderPickingNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderPickingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreOrderPickingId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderPickingId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderPickingId, methodName, "retailStoreOrderPickingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderPickingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderPickingId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreOrderPicking disconnectFromAll(String retailStoreOrderPickingId, int version) throws Exception{
	
		
		RetailStoreOrderPicking retailStoreOrderPicking = loadInternalRetailStoreOrderPicking(RetailStoreOrderPickingTable.withId(retailStoreOrderPickingId), emptyOptions());
		retailStoreOrderPicking.clearFromAll();
		this.saveRetailStoreOrderPicking(retailStoreOrderPicking);
		return retailStoreOrderPicking;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderPickingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_picking";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreOrderPicking";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderPickingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderPickingTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderPickingTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderPickingMapper getRetailStoreOrderPickingMapper(){
		return new RetailStoreOrderPickingMapper();
	}

	
	
	protected RetailStoreOrderPicking extractRetailStoreOrderPicking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrderPicking retailStoreOrderPicking = loadSingleObject(accessKey, getRetailStoreOrderPickingMapper());
			return retailStoreOrderPicking;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderPickingNotFoundException("RetailStoreOrderPicking("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreOrderPicking loadInternalRetailStoreOrderPicking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderPicking retailStoreOrderPicking = extractRetailStoreOrderPicking(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderPicking, loadOptions);
 		}		
		
		return retailStoreOrderPicking;
		
	}



	
	
	
		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected RetailStoreOrderPicking extractRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
		
		
		if(retailStoreOrderPicking == null){
			return null;
		}
		if(retailStoreOrderPicking.getId() == null){
			return retailStoreOrderPicking;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByPicking(retailStoreOrderPicking.getId(),options);
		if(retailStoreOrderList != null){
			enhanceRetailStoreOrderList(retailStoreOrderList,options);
			retailStoreOrderPicking.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderPicking;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderPicking saveRetailStoreOrderPicking(RetailStoreOrderPicking  retailStoreOrderPicking){
		
		if(!retailStoreOrderPicking.isChanged()){
			return retailStoreOrderPicking;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderPickingSQL(retailStoreOrderPicking);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderPickingParameters(retailStoreOrderPicking);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderPicking.incVersion();
		return retailStoreOrderPicking;
	
	}
	public SmartList<RetailStoreOrderPicking> saveRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderPickingList(retailStoreOrderPickingList);
		
		batchRetailStoreOrderPickingCreate((List<RetailStoreOrderPicking>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderPickingUpdate((List<RetailStoreOrderPicking>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderPicking retailStoreOrderPicking:retailStoreOrderPickingList){
			if(retailStoreOrderPicking.isChanged()){
				retailStoreOrderPicking.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderPickingList;
	}

	public SmartList<RetailStoreOrderPicking> removeRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderPickingList, options);
		
		return retailStoreOrderPickingList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderPickingBatchCreateArgs(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderPicking retailStoreOrderPicking:retailStoreOrderPickingList ){
			Object [] parameters = prepareRetailStoreOrderPickingCreateParameters(retailStoreOrderPicking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderPickingBatchUpdateArgs(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderPicking retailStoreOrderPicking:retailStoreOrderPickingList ){
			if(!retailStoreOrderPicking.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderPickingUpdateParameters(retailStoreOrderPicking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderPickingCreate(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderPickingBatchCreateArgs(retailStoreOrderPickingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderPickingUpdate(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderPickingBatchUpdateArgs(retailStoreOrderPickingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderPickingList(List<RetailStoreOrderPicking> retailStoreOrderPickingList){
		
		List<RetailStoreOrderPicking> retailStoreOrderPickingCreateList=new ArrayList<RetailStoreOrderPicking>();
		List<RetailStoreOrderPicking> retailStoreOrderPickingUpdateList=new ArrayList<RetailStoreOrderPicking>();
		
		for(RetailStoreOrderPicking retailStoreOrderPicking: retailStoreOrderPickingList){
			if(isUpdateRequest(retailStoreOrderPicking)){
				retailStoreOrderPickingUpdateList.add( retailStoreOrderPicking);
				continue;
			}
			retailStoreOrderPickingCreateList.add(retailStoreOrderPicking);
		}
		
		return new Object[]{retailStoreOrderPickingCreateList,retailStoreOrderPickingUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderPicking retailStoreOrderPicking){
 		return retailStoreOrderPicking.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderPickingSQL(RetailStoreOrderPicking retailStoreOrderPicking){
 		if(isUpdateRequest(retailStoreOrderPicking)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderPickingParameters(RetailStoreOrderPicking retailStoreOrderPicking){
 		if(isUpdateRequest(retailStoreOrderPicking) ){
 			return prepareRetailStoreOrderPickingUpdateParameters(retailStoreOrderPicking);
 		}
 		return prepareRetailStoreOrderPickingCreateParameters(retailStoreOrderPicking);
 	}
 	protected Object[] prepareRetailStoreOrderPickingUpdateParameters(RetailStoreOrderPicking retailStoreOrderPicking){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreOrderPicking.getWho();
 		parameters[1] = retailStoreOrderPicking.getProcessTime();		
 		parameters[2] = retailStoreOrderPicking.nextVersion();
 		parameters[3] = retailStoreOrderPicking.getId();
 		parameters[4] = retailStoreOrderPicking.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderPickingCreateParameters(RetailStoreOrderPicking retailStoreOrderPicking){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderPickingId=getNextId();
		retailStoreOrderPicking.setId(newRetailStoreOrderPickingId);
		parameters[0] =  retailStoreOrderPicking.getId();
 
 		parameters[1] = retailStoreOrderPicking.getWho();
 		parameters[2] = retailStoreOrderPicking.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderPicking saveInternalRetailStoreOrderPicking(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
		
		saveRetailStoreOrderPicking(retailStoreOrderPicking);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderPicking, options);
	 		//removeRetailStoreOrderList(retailStoreOrderPicking, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreOrderPicking;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, String retailStoreOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PICKING_PROPERTY, retailStoreOrderPicking.getId());
		key.put(RetailStoreOrder.ID_PROPERTY, retailStoreOrderIds);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderPicking;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderPicking;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){

			retailStoreOrder.clearFromAll();
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderPicking;	
	
	}


	//disconnect RetailStoreOrderPicking with buyer in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderPicking retailStoreOrderPicking, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PICKING_PROPERTY, retailStoreOrderPicking.getId());
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderPicking;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderPicking;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearBuyer();
			retailStoreOrder.clearPicking();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderPicking;
	}
	
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderPickingId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PICKING_PROPERTY, retailStoreOrderPickingId);
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrderPicking with seller in RetailStoreOrder
	public RetailStoreOrderPicking planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderPicking retailStoreOrderPicking, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PICKING_PROPERTY, retailStoreOrderPicking.getId());
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderPicking;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderPicking;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearSeller();
			retailStoreOrder.clearPicking();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderPicking;
	}
	
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderPickingId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PICKING_PROPERTY, retailStoreOrderPickingId);
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreOrderPicking saveRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			//null list means nothing
			return retailStoreOrderPicking;
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
		
		
		return retailStoreOrderPicking;
	
	}
	
	protected RetailStoreOrderPicking removeRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderPicking;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderPicking;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderPicking;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderPicking;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreOrderPicking present(RetailStoreOrderPicking retailStoreOrderPicking,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderPicking,options);

		return retailStoreOrderPicking;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrderPicking presentRetailStoreOrderList(
			RetailStoreOrderPicking retailStoreOrderPicking,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();		
				SmartList<RetailStoreOrder> newList= presentSubList(retailStoreOrderPicking.getId(),
				retailStoreOrderList,
				options,
				getRetailStoreOrderDAO()::countRetailStoreOrderByPicking,
				getRetailStoreOrderDAO()::findRetailStoreOrderByPicking
				);

		
		retailStoreOrderPicking.setRetailStoreOrderList(newList);
		

		return retailStoreOrderPicking;
	}			
		

	
    public SmartList<RetailStoreOrderPicking> requestCandidateRetailStoreOrderPickingForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderPickingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getRetailStoreOrderPickingMapper());
    }
		

	protected String getTableName(){
		return RetailStoreOrderPickingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrderPicking> retailStoreOrderPickingList) {		
		this.enhanceListInternal(retailStoreOrderPickingList, this.getRetailStoreOrderPickingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreOrderPicking> retailStoreOrderPickingList = ownerEntity.collectRefsWithType(RetailStoreOrderPicking.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderPickingList);
		
	}
	
	@Override
	public SmartList<RetailStoreOrderPicking> findRetailStoreOrderPickingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreOrderPickingMapper());

	}
	@Override
	public int countRetailStoreOrderPickingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderPickingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreOrderPicking> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderPickingMapper());
	}
}


