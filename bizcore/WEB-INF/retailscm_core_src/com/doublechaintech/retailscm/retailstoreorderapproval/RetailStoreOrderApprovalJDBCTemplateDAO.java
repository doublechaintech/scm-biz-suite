
package com.doublechaintech.retailscm.retailstoreorderapproval;

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

public class RetailStoreOrderApprovalJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreOrderApprovalDAO{


			
		
	
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
	protected RetailStoreOrderApproval load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderApproval(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreOrderApproval load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderApproval(RetailStoreOrderApprovalTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderApproval save(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderApproval, methodName, "retailStoreOrderApproval");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderApproval(retailStoreOrderApproval,options);
	}
	public RetailStoreOrderApproval clone(String retailStoreOrderApprovalId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderApprovalTable.withId(retailStoreOrderApprovalId),options);
	}
	
	protected RetailStoreOrderApproval clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderApprovalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderApproval newRetailStoreOrderApproval = loadInternalRetailStoreOrderApproval(accessKey, options);
		newRetailStoreOrderApproval.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderApproval.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderApproval(newRetailStoreOrderApproval,options);
		
		return newRetailStoreOrderApproval;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreOrderApprovalId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderApprovalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderApprovalNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderApprovalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreOrderApprovalId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderApprovalId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderApprovalId, methodName, "retailStoreOrderApprovalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderApprovalId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderApprovalId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreOrderApproval disconnectFromAll(String retailStoreOrderApprovalId, int version) throws Exception{
	
		
		RetailStoreOrderApproval retailStoreOrderApproval = loadInternalRetailStoreOrderApproval(RetailStoreOrderApprovalTable.withId(retailStoreOrderApprovalId), emptyOptions());
		retailStoreOrderApproval.clearFromAll();
		this.saveRetailStoreOrderApproval(retailStoreOrderApproval);
		return retailStoreOrderApproval;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderApprovalTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_approval";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreOrderApproval";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderApprovalTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreOrderApprovalTokens.RETAIL_STORE_ORDER_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreOrderListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,RetailStoreOrderApprovalTokens.RETAIL_STORE_ORDER_LIST+".analyze");
 	}
	
	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderApprovalTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
		

	

	protected RetailStoreOrderApprovalMapper getRetailStoreOrderApprovalMapper(){
		return new RetailStoreOrderApprovalMapper();
	}

	
	
	protected RetailStoreOrderApproval extractRetailStoreOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrderApproval retailStoreOrderApproval = loadSingleObject(accessKey, getRetailStoreOrderApprovalMapper());
			return retailStoreOrderApproval;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderApprovalNotFoundException("RetailStoreOrderApproval("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreOrderApproval loadInternalRetailStoreOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderApproval retailStoreOrderApproval = extractRetailStoreOrderApproval(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderApproval, loadOptions);
 		}	
 		if(isAnalyzeRetailStoreOrderListEnabled(loadOptions)){
	 		analyzeRetailStoreOrderList(retailStoreOrderApproval, loadOptions);
 		}
 		
		
		return retailStoreOrderApproval;
		
	}

	
		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStoreOrderApproval extractRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
		
		
		if(retailStoreOrderApproval == null){
			return null;
		}
		if(retailStoreOrderApproval.getId() == null){
			return retailStoreOrderApproval;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByApproval(retailStoreOrderApproval.getId(),options);
		if(retailStoreOrderList != null){
			enhanceRetailStoreOrderList(retailStoreOrderList,options);
			retailStoreOrderApproval.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderApproval;
	
	}	
	
	protected RetailStoreOrderApproval analyzeRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
		
		
		if(retailStoreOrderApproval == null){
			return null;
		}
		if(retailStoreOrderApproval.getId() == null){
			return retailStoreOrderApproval;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();
		if(retailStoreOrderList != null){
			getRetailStoreOrderDAO().analyzeRetailStoreOrderByApproval(retailStoreOrderList, retailStoreOrderApproval.getId(), options);
			
		}
		
		return retailStoreOrderApproval;
	
	}	
	
		
		
 	
		
		
		

	

	protected RetailStoreOrderApproval saveRetailStoreOrderApproval(RetailStoreOrderApproval  retailStoreOrderApproval){
		
		if(!retailStoreOrderApproval.isChanged()){
			return retailStoreOrderApproval;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderApprovalSQL(retailStoreOrderApproval);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderApprovalParameters(retailStoreOrderApproval);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderApproval.incVersion();
		return retailStoreOrderApproval;
	
	}
	public SmartList<RetailStoreOrderApproval> saveRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderApprovalList(retailStoreOrderApprovalList);
		
		batchRetailStoreOrderApprovalCreate((List<RetailStoreOrderApproval>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderApprovalUpdate((List<RetailStoreOrderApproval>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderApproval retailStoreOrderApproval:retailStoreOrderApprovalList){
			if(retailStoreOrderApproval.isChanged()){
				retailStoreOrderApproval.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderApprovalList;
	}

	public SmartList<RetailStoreOrderApproval> removeRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderApprovalList, options);
		
		return retailStoreOrderApprovalList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderApprovalBatchCreateArgs(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderApproval retailStoreOrderApproval:retailStoreOrderApprovalList ){
			Object [] parameters = prepareRetailStoreOrderApprovalCreateParameters(retailStoreOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderApprovalBatchUpdateArgs(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderApproval retailStoreOrderApproval:retailStoreOrderApprovalList ){
			if(!retailStoreOrderApproval.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderApprovalUpdateParameters(retailStoreOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderApprovalCreate(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderApprovalBatchCreateArgs(retailStoreOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderApprovalUpdate(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderApprovalBatchUpdateArgs(retailStoreOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderApprovalList(List<RetailStoreOrderApproval> retailStoreOrderApprovalList){
		
		List<RetailStoreOrderApproval> retailStoreOrderApprovalCreateList=new ArrayList<RetailStoreOrderApproval>();
		List<RetailStoreOrderApproval> retailStoreOrderApprovalUpdateList=new ArrayList<RetailStoreOrderApproval>();
		
		for(RetailStoreOrderApproval retailStoreOrderApproval: retailStoreOrderApprovalList){
			if(isUpdateRequest(retailStoreOrderApproval)){
				retailStoreOrderApprovalUpdateList.add( retailStoreOrderApproval);
				continue;
			}
			retailStoreOrderApprovalCreateList.add(retailStoreOrderApproval);
		}
		
		return new Object[]{retailStoreOrderApprovalCreateList,retailStoreOrderApprovalUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderApproval retailStoreOrderApproval){
 		return retailStoreOrderApproval.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderApprovalSQL(RetailStoreOrderApproval retailStoreOrderApproval){
 		if(isUpdateRequest(retailStoreOrderApproval)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderApprovalParameters(RetailStoreOrderApproval retailStoreOrderApproval){
 		if(isUpdateRequest(retailStoreOrderApproval) ){
 			return prepareRetailStoreOrderApprovalUpdateParameters(retailStoreOrderApproval);
 		}
 		return prepareRetailStoreOrderApprovalCreateParameters(retailStoreOrderApproval);
 	}
 	protected Object[] prepareRetailStoreOrderApprovalUpdateParameters(RetailStoreOrderApproval retailStoreOrderApproval){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreOrderApproval.getWho();
 		parameters[1] = retailStoreOrderApproval.getApproveTime();		
 		parameters[2] = retailStoreOrderApproval.nextVersion();
 		parameters[3] = retailStoreOrderApproval.getId();
 		parameters[4] = retailStoreOrderApproval.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderApprovalCreateParameters(RetailStoreOrderApproval retailStoreOrderApproval){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderApprovalId=getNextId();
		retailStoreOrderApproval.setId(newRetailStoreOrderApprovalId);
		parameters[0] =  retailStoreOrderApproval.getId();
 
 		parameters[1] = retailStoreOrderApproval.getWho();
 		parameters[2] = retailStoreOrderApproval.getApproveTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderApproval saveInternalRetailStoreOrderApproval(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
		
		saveRetailStoreOrderApproval(retailStoreOrderApproval);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderApproval, options);
	 		//removeRetailStoreOrderList(retailStoreOrderApproval, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreOrderApproval;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, String retailStoreOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.APPROVAL_PROPERTY, retailStoreOrderApproval.getId());
		key.put(RetailStoreOrder.ID_PROPERTY, retailStoreOrderIds);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderApproval;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderApproval;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){

			retailStoreOrder.clearFromAll();
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderApproval;	
	
	}


	//disconnect RetailStoreOrderApproval with buyer in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderApproval retailStoreOrderApproval, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.APPROVAL_PROPERTY, retailStoreOrderApproval.getId());
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderApproval;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderApproval;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearBuyer();
			retailStoreOrder.clearApproval();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderApproval;
	}
	
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderApprovalId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.APPROVAL_PROPERTY, retailStoreOrderApprovalId);
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrderApproval with seller in RetailStoreOrder
	public RetailStoreOrderApproval planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderApproval retailStoreOrderApproval, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.APPROVAL_PROPERTY, retailStoreOrderApproval.getId());
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderApproval;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderApproval;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearSeller();
			retailStoreOrder.clearApproval();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderApproval;
	}
	
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderApprovalId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.APPROVAL_PROPERTY, retailStoreOrderApprovalId);
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreOrderApproval saveRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			//null list means nothing
			return retailStoreOrderApproval;
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
		
		
		return retailStoreOrderApproval;
	
	}
	
	protected RetailStoreOrderApproval removeRetailStoreOrderList(RetailStoreOrderApproval retailStoreOrderApproval, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderApproval;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderApproval;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderApproval;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreOrderApproval present(RetailStoreOrderApproval retailStoreOrderApproval,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderApproval,options);

		return retailStoreOrderApproval;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrderApproval presentRetailStoreOrderList(
			RetailStoreOrderApproval retailStoreOrderApproval,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderApproval.getRetailStoreOrderList();		
				SmartList<RetailStoreOrder> newList= presentSubList(retailStoreOrderApproval.getId(),
				retailStoreOrderList,
				options,
				getRetailStoreOrderDAO()::countRetailStoreOrderByApproval,
				getRetailStoreOrderDAO()::findRetailStoreOrderByApproval
				);

		
		retailStoreOrderApproval.setRetailStoreOrderList(newList);
		

		return retailStoreOrderApproval;
	}			
		

	
    public SmartList<RetailStoreOrderApproval> requestCandidateRetailStoreOrderApprovalForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderApprovalTable.COLUMN_WHO, filterKey, pageNo, pageSize, getRetailStoreOrderApprovalMapper());
    }
		

	protected String getTableName(){
		return RetailStoreOrderApprovalTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrderApproval> retailStoreOrderApprovalList) {		
		this.enhanceListInternal(retailStoreOrderApprovalList, this.getRetailStoreOrderApprovalMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreOrderApproval> retailStoreOrderApprovalList = ownerEntity.collectRefsWithType(RetailStoreOrderApproval.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderApprovalList);
		
	}
	
	@Override
	public SmartList<RetailStoreOrderApproval> findRetailStoreOrderApprovalWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreOrderApprovalMapper());

	}
	@Override
	public int countRetailStoreOrderApprovalWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreOrderApproval> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderApprovalMapper());
	}
}


