
package com.doublechaintech.retailscm.retailstoreorderpicking;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
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



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


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
		return getShortName(this.getName())+"%08d";
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
 	protected boolean isAnalyzeRetailStoreOrderListEnabled(Map<String,Object> options){		 		
 		return RetailStoreOrderPickingTokens.of(options).analyzeRetailStoreOrderListEnabled();
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
 		if(isAnalyzeRetailStoreOrderListEnabled(loadOptions)){
	 		analyzeRetailStoreOrderList(retailStoreOrderPicking, loadOptions);
 		}
 		
		
		return retailStoreOrderPicking;
		
	}

	
		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
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
	
	protected RetailStoreOrderPicking analyzeRetailStoreOrderList(RetailStoreOrderPicking retailStoreOrderPicking, Map<String,Object> options){
		
		
		if(retailStoreOrderPicking == null){
			return null;
		}
		if(retailStoreOrderPicking.getId() == null){
			return retailStoreOrderPicking;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderPicking.getRetailStoreOrderList();
		if(retailStoreOrderList != null){
			getRetailStoreOrderDAO().analyzeRetailStoreOrderByPicking(retailStoreOrderList, retailStoreOrderPicking.getId(), options);
			
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
		
		for(RetailStoreOrder retailStoreOrderItem: externalRetailStoreOrderList){

			retailStoreOrderItem.clearFromAll();
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
		
		for(RetailStoreOrder retailStoreOrderItem: externalRetailStoreOrderList){
			retailStoreOrderItem.clearBuyer();
			retailStoreOrderItem.clearPicking();
			
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
		
		for(RetailStoreOrder retailStoreOrderItem: externalRetailStoreOrderList){
			retailStoreOrderItem.clearSeller();
			retailStoreOrderItem.clearPicking();
			
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
	
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的picking的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(RetailscmUserContext userContext, List<RetailStoreOrderPicking> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.PICKING_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreOrder> loadedObjs = userContext.getDAOGroup().getRetailStoreOrderDAO().findRetailStoreOrderWithKey(key, options);
		Map<String, List<RetailStoreOrder>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPicking().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreOrder> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreOrder> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreOrderList(loadedSmartList);
		});
		return loadedObjs;
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
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


