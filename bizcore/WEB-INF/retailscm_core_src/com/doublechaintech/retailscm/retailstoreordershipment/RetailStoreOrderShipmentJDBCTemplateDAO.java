
package com.doublechaintech.retailscm.retailstoreordershipment;

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

public class RetailStoreOrderShipmentJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreOrderShipmentDAO{


			
		
	
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
	protected RetailStoreOrderShipment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderShipment(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreOrderShipment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderShipment(RetailStoreOrderShipmentTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderShipment save(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderShipment, methodName, "retailStoreOrderShipment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderShipment(retailStoreOrderShipment,options);
	}
	public RetailStoreOrderShipment clone(String retailStoreOrderShipmentId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderShipmentTable.withId(retailStoreOrderShipmentId),options);
	}
	
	protected RetailStoreOrderShipment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderShipmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderShipment newRetailStoreOrderShipment = loadInternalRetailStoreOrderShipment(accessKey, options);
		newRetailStoreOrderShipment.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreOrderShipment.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrderShipment(newRetailStoreOrderShipment,options);
		
		return newRetailStoreOrderShipment;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreOrderShipmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderShipmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderShipmentNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderShipmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreOrderShipmentId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderShipmentId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderShipmentId, methodName, "retailStoreOrderShipmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderShipmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderShipmentId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreOrderShipment disconnectFromAll(String retailStoreOrderShipmentId, int version) throws Exception{
	
		
		RetailStoreOrderShipment retailStoreOrderShipment = loadInternalRetailStoreOrderShipment(RetailStoreOrderShipmentTable.withId(retailStoreOrderShipmentId), emptyOptions());
		retailStoreOrderShipment.clearFromAll();
		this.saveRetailStoreOrderShipment(retailStoreOrderShipment);
		return retailStoreOrderShipment;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderShipmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_shipment";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreOrderShipment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderShipmentTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderShipmentTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderShipmentTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderShipmentMapper getRetailStoreOrderShipmentMapper(){
		return new RetailStoreOrderShipmentMapper();
	}

	
	
	protected RetailStoreOrderShipment extractRetailStoreOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrderShipment retailStoreOrderShipment = loadSingleObject(accessKey, getRetailStoreOrderShipmentMapper());
			return retailStoreOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderShipmentNotFoundException("RetailStoreOrderShipment("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreOrderShipment loadInternalRetailStoreOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderShipment retailStoreOrderShipment = extractRetailStoreOrderShipment(accessKey, loadOptions);

		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreOrderShipment, loadOptions);
 		}		
		
		return retailStoreOrderShipment;
		
	}



	
	
	
		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected RetailStoreOrderShipment extractRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options){
		
		
		if(retailStoreOrderShipment == null){
			return null;
		}
		if(retailStoreOrderShipment.getId() == null){
			return retailStoreOrderShipment;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByShipment(retailStoreOrderShipment.getId(),options);
		if(retailStoreOrderList != null){
			enhanceRetailStoreOrderList(retailStoreOrderList,options);
			retailStoreOrderShipment.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreOrderShipment;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreOrderShipment saveRetailStoreOrderShipment(RetailStoreOrderShipment  retailStoreOrderShipment){
		
		if(!retailStoreOrderShipment.isChanged()){
			return retailStoreOrderShipment;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderShipmentSQL(retailStoreOrderShipment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderShipmentParameters(retailStoreOrderShipment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderShipment.incVersion();
		return retailStoreOrderShipment;
	
	}
	public SmartList<RetailStoreOrderShipment> saveRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderShipmentList(retailStoreOrderShipmentList);
		
		batchRetailStoreOrderShipmentCreate((List<RetailStoreOrderShipment>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderShipmentUpdate((List<RetailStoreOrderShipment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderShipment retailStoreOrderShipment:retailStoreOrderShipmentList){
			if(retailStoreOrderShipment.isChanged()){
				retailStoreOrderShipment.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderShipmentList;
	}

	public SmartList<RetailStoreOrderShipment> removeRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderShipmentList, options);
		
		return retailStoreOrderShipmentList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderShipmentBatchCreateArgs(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderShipment retailStoreOrderShipment:retailStoreOrderShipmentList ){
			Object [] parameters = prepareRetailStoreOrderShipmentCreateParameters(retailStoreOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderShipmentBatchUpdateArgs(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderShipment retailStoreOrderShipment:retailStoreOrderShipmentList ){
			if(!retailStoreOrderShipment.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderShipmentUpdateParameters(retailStoreOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderShipmentCreate(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderShipmentBatchCreateArgs(retailStoreOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderShipmentUpdate(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderShipmentBatchUpdateArgs(retailStoreOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderShipmentList(List<RetailStoreOrderShipment> retailStoreOrderShipmentList){
		
		List<RetailStoreOrderShipment> retailStoreOrderShipmentCreateList=new ArrayList<RetailStoreOrderShipment>();
		List<RetailStoreOrderShipment> retailStoreOrderShipmentUpdateList=new ArrayList<RetailStoreOrderShipment>();
		
		for(RetailStoreOrderShipment retailStoreOrderShipment: retailStoreOrderShipmentList){
			if(isUpdateRequest(retailStoreOrderShipment)){
				retailStoreOrderShipmentUpdateList.add( retailStoreOrderShipment);
				continue;
			}
			retailStoreOrderShipmentCreateList.add(retailStoreOrderShipment);
		}
		
		return new Object[]{retailStoreOrderShipmentCreateList,retailStoreOrderShipmentUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderShipment retailStoreOrderShipment){
 		return retailStoreOrderShipment.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderShipmentSQL(RetailStoreOrderShipment retailStoreOrderShipment){
 		if(isUpdateRequest(retailStoreOrderShipment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderShipmentParameters(RetailStoreOrderShipment retailStoreOrderShipment){
 		if(isUpdateRequest(retailStoreOrderShipment) ){
 			return prepareRetailStoreOrderShipmentUpdateParameters(retailStoreOrderShipment);
 		}
 		return prepareRetailStoreOrderShipmentCreateParameters(retailStoreOrderShipment);
 	}
 	protected Object[] prepareRetailStoreOrderShipmentUpdateParameters(RetailStoreOrderShipment retailStoreOrderShipment){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreOrderShipment.getWho();
 		parameters[1] = retailStoreOrderShipment.getShipTime();		
 		parameters[2] = retailStoreOrderShipment.nextVersion();
 		parameters[3] = retailStoreOrderShipment.getId();
 		parameters[4] = retailStoreOrderShipment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderShipmentCreateParameters(RetailStoreOrderShipment retailStoreOrderShipment){
		Object[] parameters = new Object[3];
		String newRetailStoreOrderShipmentId=getNextId();
		retailStoreOrderShipment.setId(newRetailStoreOrderShipmentId);
		parameters[0] =  retailStoreOrderShipment.getId();
 
 		parameters[1] = retailStoreOrderShipment.getWho();
 		parameters[2] = retailStoreOrderShipment.getShipTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderShipment saveInternalRetailStoreOrderShipment(RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options){
		
		saveRetailStoreOrderShipment(retailStoreOrderShipment);

		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreOrderShipment, options);
	 		//removeRetailStoreOrderList(retailStoreOrderShipment, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreOrderShipment;
		
	}
	
	
	
	//======================================================================================
	

	
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, String retailStoreOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SHIPMENT_PROPERTY, retailStoreOrderShipment.getId());
		key.put(RetailStoreOrder.ID_PROPERTY, retailStoreOrderIds);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderShipment;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderShipment;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){

			retailStoreOrder.clearFromAll();
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderShipment;	
	
	}


	//disconnect RetailStoreOrderShipment with buyer in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithBuyer(RetailStoreOrderShipment retailStoreOrderShipment, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SHIPMENT_PROPERTY, retailStoreOrderShipment.getId());
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderShipment;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderShipment;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearBuyer();
			retailStoreOrder.clearShipment();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderShipment;
	}
	
	public int countRetailStoreOrderListWithBuyer(String retailStoreOrderShipmentId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SHIPMENT_PROPERTY, retailStoreOrderShipmentId);
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreOrderShipment with seller in RetailStoreOrder
	public RetailStoreOrderShipment planToRemoveRetailStoreOrderListWithSeller(RetailStoreOrderShipment retailStoreOrderShipment, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SHIPMENT_PROPERTY, retailStoreOrderShipment.getId());
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreOrderShipment;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreOrderShipment;
		}
		
		for(RetailStoreOrder retailStoreOrder: externalRetailStoreOrderList){
			retailStoreOrder.clearSeller();
			retailStoreOrder.clearShipment();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreOrderShipment;
	}
	
	public int countRetailStoreOrderListWithSeller(String retailStoreOrderShipmentId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SHIPMENT_PROPERTY, retailStoreOrderShipmentId);
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreOrderShipment saveRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			//null list means nothing
			return retailStoreOrderShipment;
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
		
		
		return retailStoreOrderShipment;
	
	}
	
	protected RetailStoreOrderShipment removeRetailStoreOrderList(RetailStoreOrderShipment retailStoreOrderShipment, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreOrderShipment;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreOrderShipment;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreOrderShipment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreOrderShipment;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreOrderShipment present(RetailStoreOrderShipment retailStoreOrderShipment,Map<String, Object> options){
	
		presentRetailStoreOrderList(retailStoreOrderShipment,options);

		return retailStoreOrderShipment;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreOrderShipment presentRetailStoreOrderList(
			RetailStoreOrderShipment retailStoreOrderShipment,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreOrderShipment.getRetailStoreOrderList();		
				SmartList<RetailStoreOrder> newList= presentSubList(retailStoreOrderShipment.getId(),
				retailStoreOrderList,
				options,
				getRetailStoreOrderDAO()::countRetailStoreOrderByShipment,
				getRetailStoreOrderDAO()::findRetailStoreOrderByShipment
				);

		
		retailStoreOrderShipment.setRetailStoreOrderList(newList);
		

		return retailStoreOrderShipment;
	}			
		

	
    public SmartList<RetailStoreOrderShipment> requestCandidateRetailStoreOrderShipmentForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreOrderShipmentTable.COLUMN_WHO, filterKey, pageNo, pageSize, getRetailStoreOrderShipmentMapper());
    }
		

	protected String getTableName(){
		return RetailStoreOrderShipmentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrderShipment> retailStoreOrderShipmentList) {		
		this.enhanceListInternal(retailStoreOrderShipmentList, this.getRetailStoreOrderShipmentMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreOrderShipment> retailStoreOrderShipmentList = ownerEntity.collectRefsWithType(RetailStoreOrderShipment.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderShipmentList);
		
	}
	
	@Override
	public SmartList<RetailStoreOrderShipment> findRetailStoreOrderShipmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreOrderShipmentMapper());

	}
	@Override
	public int countRetailStoreOrderShipmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderShipmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreOrderShipment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderShipmentMapper());
	}
}


