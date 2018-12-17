
package com.doublechaintech.retailscm.retailstoreorderconfirmation;

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

public class RetailStoreOrderConfirmationJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreOrderConfirmationDAO{


			
		
	
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
	protected RetailStoreOrderConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderConfirmation(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreOrderConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderConfirmation(RetailStoreOrderConfirmationTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderConfirmation save(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderConfirmation, methodName, "retailStoreOrderConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderConfirmation(retailStoreOrderConfirmation,options);
	}
	public RetailStoreOrderConfirmation clone(String retailStoreOrderConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderConfirmationTable.withId(retailStoreOrderConfirmationId),options);
	}
	
	protected RetailStoreOrderConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderConfirmation newRetailStoreOrderConfirmation = loadInternalRetailStoreOrderConfirmation(accessKey, options);
		newRetailStoreOrderConfirmation.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderConfirmation.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderConfirmation(newRetailStoreOrderConfirmation,options);
		
		return newRetailStoreOrderConfirmation;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreOrderConfirmationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreOrderConfirmationId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderConfirmationId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderConfirmationId, methodName, "retailStoreOrderConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderConfirmationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderConfirmationId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreOrderConfirmation disconnectFromAll(String retailStoreOrderConfirmationId, int version) throws Exception{
	
		
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadInternalRetailStoreOrderConfirmation(RetailStoreOrderConfirmationTable.withId(retailStoreOrderConfirmationId), emptyOptions());
		retailStoreOrderConfirmation.clearFromAll();
		this.saveRetailStoreOrderConfirmation(retailStoreOrderConfirmation);
		return retailStoreOrderConfirmation;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_confirmation";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreOrderConfirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderConfirmationTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderConfirmationTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderConfirmationMapper getRetailStoreOrderConfirmationMapper(){
		return new RetailStoreOrderConfirmationMapper();
	}

	
	
	protected RetailStoreOrderConfirmation extractRetailStoreOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrderConfirmation retailStoreOrderConfirmation = loadSingleObject(accessKey, getRetailStoreOrderConfirmationMapper());
			return retailStoreOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderConfirmationNotFoundException("RetailStoreOrderConfirmation("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreOrderConfirmation loadInternalRetailStoreOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = extractRetailStoreOrderConfirmation(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderConfirmation, loadOptions);
 		}		
		
		return retailStoreOrderConfirmation;
		
	}



	
	
	
		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected RetailStoreOrderConfirmation extractRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object> options){
		
		
		if(retailStoreOrderConfirmation == null){
			return null;
		}
		if(retailStoreOrderConfirmation.getId() == null){
			return retailStoreOrderConfirmation;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByConfirmation(retailStoreOrderConfirmation.getId(),options);
		if(retailStoreOrderList != null){
			enhanceRetailStoreOrderList(retailStoreOrderList,options);
			retailStoreOrderConfirmation.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderConfirmation;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderConfirmation saveRetailStoreOrderConfirmation(RetailStoreOrderConfirmation  retailStoreOrderConfirmation){
		
		if(!retailStoreOrderConfirmation.isChanged()){
			return retailStoreOrderConfirmation;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderConfirmationSQL(retailStoreOrderConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderConfirmationParameters(retailStoreOrderConfirmation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderConfirmation.incVersion();
		return retailStoreOrderConfirmation;
	
	}
	public SmartList<RetailStoreOrderConfirmation> saveRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderConfirmationList(retailStoreOrderConfirmationList);
		
		batchRetailStoreOrderConfirmationCreate((List<RetailStoreOrderConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderConfirmationUpdate((List<RetailStoreOrderConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderConfirmation retailStoreOrderConfirmation:retailStoreOrderConfirmationList){
			if(retailStoreOrderConfirmation.isChanged()){
				retailStoreOrderConfirmation.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderConfirmationList;
	}

	public SmartList<RetailStoreOrderConfirmation> removeRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderConfirmationList, options);
		
		return retailStoreOrderConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderConfirmationBatchCreateArgs(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderConfirmation retailStoreOrderConfirmation:retailStoreOrderConfirmationList ){
			Object [] parameters = prepareRetailStoreOrderConfirmationCreateParameters(retailStoreOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderConfirmationBatchUpdateArgs(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderConfirmation retailStoreOrderConfirmation:retailStoreOrderConfirmationList ){
			if(!retailStoreOrderConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderConfirmationUpdateParameters(retailStoreOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderConfirmationCreate(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderConfirmationBatchCreateArgs(retailStoreOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderConfirmationUpdate(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderConfirmationBatchUpdateArgs(retailStoreOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderConfirmationList(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList){
		
		List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationCreateList=new ArrayList<RetailStoreOrderConfirmation>();
		List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationUpdateList=new ArrayList<RetailStoreOrderConfirmation>();
		
		for(RetailStoreOrderConfirmation retailStoreOrderConfirmation: retailStoreOrderConfirmationList){
			if(isUpdateRequest(retailStoreOrderConfirmation)){
				retailStoreOrderConfirmationUpdateList.add( retailStoreOrderConfirmation);
				continue;
			}
			retailStoreOrderConfirmationCreateList.add(retailStoreOrderConfirmation);
		}
		
		return new Object[]{retailStoreOrderConfirmationCreateList,retailStoreOrderConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
 		return retailStoreOrderConfirmation.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderConfirmationSQL(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
 		if(isUpdateRequest(retailStoreOrderConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderConfirmationParameters(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
 		if(isUpdateRequest(retailStoreOrderConfirmation) ){
 			return prepareRetailStoreOrderConfirmationUpdateParameters(retailStoreOrderConfirmation);
 		}
 		return prepareRetailStoreOrderConfirmationCreateParameters(retailStoreOrderConfirmation);
 	}
 	protected Object[] prepareRetailStoreOrderConfirmationUpdateParameters(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreOrderConfirmation.getWho();
 		parameters[1] = retailStoreOrderConfirmation.getConfirmTime();		
 		parameters[2] = retailStoreOrderConfirmation.nextVersion();
 		parameters[3] = retailStoreOrderConfirmation.getId();
 		parameters[4] = retailStoreOrderConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderConfirmationCreateParameters(RetailStoreOrderConfirmation retailStoreOrderConfirmation){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderConfirmationId=getNextId();
		retailStoreOrderConfirmation.setId(newRetailStoreOrderConfirmationId);
		parameters[0] =  retailStoreOrderConfirmation.getId();
 
 		parameters[1] = retailStoreOrderConfirmation.getWho();
 		parameters[2] = retailStoreOrderConfirmation.getConfirmTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderConfirmation saveInternalRetailStoreOrderConfirmation(RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object> options){
		
		saveRetailStoreOrderConfirmation(retailStoreOrderConfirmation);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderConfirmation, options);
	 		//removeRetailStoreOrderList(retailStoreOrderConfirmation, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreOrderConfirmation;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String retailStoreOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.CONFIRMATION_PROPERTY, retailStoreOrderConfirmation.getId());
		key.put(RetailStoreOrder.ID_PROPERTY, retailStoreOrderIds);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderConfirmation;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderConfirmation;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){

			retailStoreOrder.clearFromAll();
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderConfirmation;	
	
	}


	//disconnect RetailStoreOrderConfirmation with buyer in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.CONFIRMATION_PROPERTY, retailStoreOrderConfirmation.getId());
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderConfirmation;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderConfirmation;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearBuyer();
			retailStoreOrder.clearConfirmation();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderConfirmation;
	}
	
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderConfirmationId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.CONFIRMATION_PROPERTY, retailStoreOrderConfirmationId);
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrderConfirmation with seller in RetailStoreOrder
	public RetailStoreOrderConfirmation planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderConfirmation retailStoreOrderConfirmation, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.CONFIRMATION_PROPERTY, retailStoreOrderConfirmation.getId());
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderConfirmation;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderConfirmation;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearSeller();
			retailStoreOrder.clearConfirmation();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderConfirmation;
	}
	
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderConfirmationId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.CONFIRMATION_PROPERTY, retailStoreOrderConfirmationId);
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreOrderConfirmation saveRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			//null list means nothing
			return retailStoreOrderConfirmation;
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
		
		
		return retailStoreOrderConfirmation;
	
	}
	
	protected RetailStoreOrderConfirmation removeRetailStoreOrderList(RetailStoreOrderConfirmation retailStoreOrderConfirmation, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderConfirmation;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderConfirmation;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderConfirmation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderConfirmation;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreOrderConfirmation present(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderConfirmation,options);

		return retailStoreOrderConfirmation;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrderConfirmation presentRetailStoreOrderList(
			RetailStoreOrderConfirmation retailStoreOrderConfirmation,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderConfirmation.getRetailStoreOrderList();		
				SmartList<RetailStoreOrder> newList= presentSubList(retailStoreOrderConfirmation.getId(),
				retailStoreOrderList,
				options,
				getRetailStoreOrderDAO()::countRetailStoreOrderByConfirmation,
				getRetailStoreOrderDAO()::findRetailStoreOrderByConfirmation
				);

		
		retailStoreOrderConfirmation.setRetailStoreOrderList(newList);
		

		return retailStoreOrderConfirmation;
	}			
		

	
    public SmartList<RetailStoreOrderConfirmation> requestCandidateRetailStoreOrderConfirmationForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderConfirmationTable.COLUMN_WHO, filterKey, pageNo, pageSize, getRetailStoreOrderConfirmationMapper());
    }
		

	protected String getTableName(){
		return RetailStoreOrderConfirmationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList) {		
		this.enhanceListInternal(retailStoreOrderConfirmationList, this.getRetailStoreOrderConfirmationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList = ownerEntity.collectRefsWithType(RetailStoreOrderConfirmation.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderConfirmationList);
		
	}
	
	@Override
	public SmartList<RetailStoreOrderConfirmation> findRetailStoreOrderConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreOrderConfirmationMapper());

	}
	@Override
	public int countRetailStoreOrderConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreOrderConfirmation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderConfirmationMapper());
	}
}


