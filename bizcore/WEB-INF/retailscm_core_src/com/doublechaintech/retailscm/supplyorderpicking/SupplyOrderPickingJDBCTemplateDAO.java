
package com.doublechaintech.retailscm.supplyorderpicking;

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


import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderPickingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SupplyOrderPickingDAO{


			
		
	
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
	protected SupplyOrderPicking load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderPicking(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplyOrderPicking load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderPicking(SupplyOrderPickingTable.withId(id), options);
	}
	
	
	
	public SupplyOrderPicking save(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options){
		
		String methodName="save(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderPicking, methodName, "supplyOrderPicking");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderPicking(supplyOrderPicking,options);
	}
	public SupplyOrderPicking clone(String supplyOrderPickingId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderPickingTable.withId(supplyOrderPickingId),options);
	}
	
	protected SupplyOrderPicking clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderPickingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderPicking newSupplyOrderPicking = loadInternalSupplyOrderPicking(accessKey, options);
		newSupplyOrderPicking.setVersion(0);
		
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newSupplyOrderPicking.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrderPicking(newSupplyOrderPicking,options);
		
		return newSupplyOrderPicking;
	}
	
	
	
	

	protected void throwIfHasException(String supplyOrderPickingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderPickingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderPickingNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderPickingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplyOrderPickingId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderPickingId, int version)";
		assertMethodArgumentNotNull(supplyOrderPickingId, methodName, "supplyOrderPickingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderPickingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderPickingId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplyOrderPicking disconnectFromAll(String supplyOrderPickingId, int version) throws Exception{
	
		
		SupplyOrderPicking supplyOrderPicking = loadInternalSupplyOrderPicking(SupplyOrderPickingTable.withId(supplyOrderPickingId), emptyOptions());
		supplyOrderPicking.clearFromAll();
		this.saveSupplyOrderPicking(supplyOrderPicking);
		return supplyOrderPicking;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderPickingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_picking";
	}
	@Override
	protected String getBeanName() {
		
		return "supplyOrderPicking";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderPickingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderPickingTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderPickingTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderPickingMapper getSupplyOrderPickingMapper(){
		return new SupplyOrderPickingMapper();
	}

	
	
	protected SupplyOrderPicking extractSupplyOrderPicking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderPicking supplyOrderPicking = loadSingleObject(accessKey, getSupplyOrderPickingMapper());
			return supplyOrderPicking;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderPickingNotFoundException("SupplyOrderPicking("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderPicking loadInternalSupplyOrderPicking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderPicking supplyOrderPicking = extractSupplyOrderPicking(accessKey, loadOptions);

		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(supplyOrderPicking, loadOptions);
 		}		
		
		return supplyOrderPicking;
		
	}



	
	
	
		
	protected void enhanceSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected SupplyOrderPicking extractSupplyOrderList(SupplyOrderPicking supplyOrderPicking, Map<String,Object> options){
		
		
		if(supplyOrderPicking == null){
			return null;
		}
		if(supplyOrderPicking.getId() == null){
			return supplyOrderPicking;
		}

		
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByPicking(supplyOrderPicking.getId(),options);
		if(supplyOrderList != null){
			enhanceSupplyOrderList(supplyOrderList,options);
			supplyOrderPicking.setSupplyOrderList(supplyOrderList);
		}
		
		return supplyOrderPicking;
	
	}	
		
		
 	
		
		
		

	

	protected SupplyOrderPicking saveSupplyOrderPicking(SupplyOrderPicking  supplyOrderPicking){
		
		if(!supplyOrderPicking.isChanged()){
			return supplyOrderPicking;
		}
		
		
		String SQL=this.getSaveSupplyOrderPickingSQL(supplyOrderPicking);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderPickingParameters(supplyOrderPicking);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderPicking.incVersion();
		return supplyOrderPicking;
	
	}
	public SmartList<SupplyOrderPicking> saveSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderPickingList(supplyOrderPickingList);
		
		batchSupplyOrderPickingCreate((List<SupplyOrderPicking>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderPickingUpdate((List<SupplyOrderPicking>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderPicking supplyOrderPicking:supplyOrderPickingList){
			if(supplyOrderPicking.isChanged()){
				supplyOrderPicking.incVersion();
			}
			
		
		}
		
		
		return supplyOrderPickingList;
	}

	public SmartList<SupplyOrderPicking> removeSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderPickingList, options);
		
		return supplyOrderPickingList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderPickingBatchCreateArgs(List<SupplyOrderPicking> supplyOrderPickingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderPicking supplyOrderPicking:supplyOrderPickingList ){
			Object [] parameters = prepareSupplyOrderPickingCreateParameters(supplyOrderPicking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderPickingBatchUpdateArgs(List<SupplyOrderPicking> supplyOrderPickingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderPicking supplyOrderPicking:supplyOrderPickingList ){
			if(!supplyOrderPicking.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderPickingUpdateParameters(supplyOrderPicking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderPickingCreate(List<SupplyOrderPicking> supplyOrderPickingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderPickingBatchCreateArgs(supplyOrderPickingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderPickingUpdate(List<SupplyOrderPicking> supplyOrderPickingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderPickingBatchUpdateArgs(supplyOrderPickingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderPickingList(List<SupplyOrderPicking> supplyOrderPickingList){
		
		List<SupplyOrderPicking> supplyOrderPickingCreateList=new ArrayList<SupplyOrderPicking>();
		List<SupplyOrderPicking> supplyOrderPickingUpdateList=new ArrayList<SupplyOrderPicking>();
		
		for(SupplyOrderPicking supplyOrderPicking: supplyOrderPickingList){
			if(isUpdateRequest(supplyOrderPicking)){
				supplyOrderPickingUpdateList.add( supplyOrderPicking);
				continue;
			}
			supplyOrderPickingCreateList.add(supplyOrderPicking);
		}
		
		return new Object[]{supplyOrderPickingCreateList,supplyOrderPickingUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderPicking supplyOrderPicking){
 		return supplyOrderPicking.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderPickingSQL(SupplyOrderPicking supplyOrderPicking){
 		if(isUpdateRequest(supplyOrderPicking)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderPickingParameters(SupplyOrderPicking supplyOrderPicking){
 		if(isUpdateRequest(supplyOrderPicking) ){
 			return prepareSupplyOrderPickingUpdateParameters(supplyOrderPicking);
 		}
 		return prepareSupplyOrderPickingCreateParameters(supplyOrderPicking);
 	}
 	protected Object[] prepareSupplyOrderPickingUpdateParameters(SupplyOrderPicking supplyOrderPicking){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = supplyOrderPicking.getWho();
 		parameters[1] = supplyOrderPicking.getProcessTime();		
 		parameters[2] = supplyOrderPicking.nextVersion();
 		parameters[3] = supplyOrderPicking.getId();
 		parameters[4] = supplyOrderPicking.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderPickingCreateParameters(SupplyOrderPicking supplyOrderPicking){
		Object[] parameters = new Object[3];
		String newSupplyOrderPickingId=getNextId();
		supplyOrderPicking.setId(newSupplyOrderPickingId);
		parameters[0] =  supplyOrderPicking.getId();
 
 		parameters[1] = supplyOrderPicking.getWho();
 		parameters[2] = supplyOrderPicking.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderPicking saveInternalSupplyOrderPicking(SupplyOrderPicking supplyOrderPicking, Map<String,Object> options){
		
		saveSupplyOrderPicking(supplyOrderPicking);

		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(supplyOrderPicking, options);
	 		//removeSupplyOrderList(supplyOrderPicking, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplyOrderPicking;
		
	}
	
	
	
	//======================================================================================
	

	
	public SupplyOrderPicking planToRemoveSupplyOrderList(SupplyOrderPicking supplyOrderPicking, String supplyOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PICKING_PROPERTY, supplyOrderPicking.getId());
		key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderPicking;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderPicking;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){

			supplyOrder.clearFromAll();
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderPicking;	
	
	}


	//disconnect SupplyOrderPicking with buyer in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithBuyer(SupplyOrderPicking supplyOrderPicking, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PICKING_PROPERTY, supplyOrderPicking.getId());
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderPicking;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderPicking;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearBuyer();
			supplyOrder.clearPicking();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderPicking;
	}
	
	public int countSupplyOrderListWithBuyer(String supplyOrderPickingId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PICKING_PROPERTY, supplyOrderPickingId);
		key.put(SupplyOrder.BUYER_PROPERTY, buyerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	//disconnect SupplyOrderPicking with seller in SupplyOrder
	public SupplyOrderPicking planToRemoveSupplyOrderListWithSeller(SupplyOrderPicking supplyOrderPicking, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PICKING_PROPERTY, supplyOrderPicking.getId());
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return supplyOrderPicking;
		}
		if(externalSupplyOrderList.isEmpty()){
			return supplyOrderPicking;
		}
		
		for(SupplyOrder supplyOrder: externalSupplyOrderList){
			supplyOrder.clearSeller();
			supplyOrder.clearPicking();
			
		}
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();		
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return supplyOrderPicking;
	}
	
	public int countSupplyOrderListWithSeller(String supplyOrderPickingId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.PICKING_PROPERTY, supplyOrderPickingId);
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);
		
		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	

		
	protected SupplyOrderPicking saveSupplyOrderList(SupplyOrderPicking supplyOrderPicking, Map<String,Object> options){
		
		
		
		
		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();
		if(supplyOrderList == null){
			//null list means nothing
			return supplyOrderPicking;
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
		
		
		return supplyOrderPicking;
	
	}
	
	protected SupplyOrderPicking removeSupplyOrderList(SupplyOrderPicking supplyOrderPicking, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();
		if(supplyOrderList == null){
			return supplyOrderPicking;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return supplyOrderPicking;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return supplyOrderPicking;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return supplyOrderPicking;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplyOrderPicking present(SupplyOrderPicking supplyOrderPicking,Map<String, Object> options){
	
		presentSupplyOrderList(supplyOrderPicking,options);

		return supplyOrderPicking;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplyOrderPicking presentSupplyOrderList(
			SupplyOrderPicking supplyOrderPicking,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = supplyOrderPicking.getSupplyOrderList();		
				SmartList<SupplyOrder> newList= presentSubList(supplyOrderPicking.getId(),
				supplyOrderList,
				options,
				getSupplyOrderDAO()::countSupplyOrderByPicking,
				getSupplyOrderDAO()::findSupplyOrderByPicking
				);

		
		supplyOrderPicking.setSupplyOrderList(newList);
		

		return supplyOrderPicking;
	}			
		

	
    public SmartList<SupplyOrderPicking> requestCandidateSupplyOrderPickingForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplyOrderPickingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSupplyOrderPickingMapper());
    }
		

	protected String getTableName(){
		return SupplyOrderPickingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrderPicking> supplyOrderPickingList) {		
		this.enhanceListInternal(supplyOrderPickingList, this.getSupplyOrderPickingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderPicking> supplyOrderPickingList = ownerEntity.collectRefsWithType(SupplyOrderPicking.INTERNAL_TYPE);
		this.enhanceList(supplyOrderPickingList);
		
	}
	
	@Override
	public SmartList<SupplyOrderPicking> findSupplyOrderPickingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplyOrderPickingMapper());

	}
	@Override
	public int countSupplyOrderPickingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderPickingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplyOrderPicking> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderPickingMapper());
	}
}


