
package com.doublechaintech.retailscm.retailstoreorderlineitem;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
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


public class RetailStoreOrderLineItemJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreOrderLineItemDAO{

	protected RetailStoreOrderDAO retailStoreOrderDAO;
	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
 	
 		if(retailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The retailStoreOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDAO;
 	}	

	
	/*
	protected RetailStoreOrderLineItem load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderLineItem(accessKey, options);
	}
	*/
	
	public SmartList<RetailStoreOrderLineItem> loadAll() {
	    return this.loadAll(getRetailStoreOrderLineItemMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreOrderLineItem load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderLineItem(RetailStoreOrderLineItemTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderLineItem save(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderLineItem, methodName, "retailStoreOrderLineItem");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderLineItem(retailStoreOrderLineItem,options);
	}
	public RetailStoreOrderLineItem clone(String retailStoreOrderLineItemId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderLineItemTable.withId(retailStoreOrderLineItemId),options);
	}
	
	protected RetailStoreOrderLineItem clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderLineItemId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderLineItem newRetailStoreOrderLineItem = loadInternalRetailStoreOrderLineItem(accessKey, options);
		newRetailStoreOrderLineItem.setVersion(0);
		
		

		
		saveInternalRetailStoreOrderLineItem(newRetailStoreOrderLineItem,options);
		
		return newRetailStoreOrderLineItem;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreOrderLineItemId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderLineItemVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderLineItemNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderLineItemId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreOrderLineItemId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderLineItemId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderLineItemId, methodName, "retailStoreOrderLineItemId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderLineItemId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderLineItemId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreOrderLineItem disconnectFromAll(String retailStoreOrderLineItemId, int version) throws Exception{
	
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = loadInternalRetailStoreOrderLineItem(RetailStoreOrderLineItemTable.withId(retailStoreOrderLineItemId), emptyOptions());
		retailStoreOrderLineItem.clearFromAll();
		this.saveRetailStoreOrderLineItem(retailStoreOrderLineItem);
		return retailStoreOrderLineItem;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderLineItemTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_line_item";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreOrderLineItem";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderLineItemTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderLineItemTokens.BIZORDER);
 	}

 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderLineItemTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected RetailStoreOrderLineItemMapper getRetailStoreOrderLineItemMapper(){
		return new RetailStoreOrderLineItemMapper();
	}

	
	
	protected RetailStoreOrderLineItem extractRetailStoreOrderLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrderLineItem retailStoreOrderLineItem = loadSingleObject(accessKey, getRetailStoreOrderLineItemMapper());
			return retailStoreOrderLineItem;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderLineItemNotFoundException("RetailStoreOrderLineItem("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreOrderLineItem loadInternalRetailStoreOrderLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = extractRetailStoreOrderLineItem(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(retailStoreOrderLineItem, loadOptions);
 		}
 
		
		return retailStoreOrderLineItem;
		
	}

	 

 	protected RetailStoreOrderLineItem extractBizOrder(RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object> options) throws Exception{

		if(retailStoreOrderLineItem.getBizOrder() == null){
			return retailStoreOrderLineItem;
		}
		String bizOrderId = retailStoreOrderLineItem.getBizOrder().getId();
		if( bizOrderId == null){
			return retailStoreOrderLineItem;
		}
		RetailStoreOrder bizOrder = getRetailStoreOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			retailStoreOrderLineItem.setBizOrder(bizOrder);
		}
		
 		
 		return retailStoreOrderLineItem;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrderLineItem> resultList = queryWith(RetailStoreOrderLineItemTable.COLUMN_BIZ_ORDER, retailStoreOrderId, options, getRetailStoreOrderLineItemMapper());
		// analyzeRetailStoreOrderLineItemByBizOrder(resultList, retailStoreOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrderLineItem> resultList =  queryWithRange(RetailStoreOrderLineItemTable.COLUMN_BIZ_ORDER, retailStoreOrderId, options, getRetailStoreOrderLineItemMapper(), start, count);
 		//analyzeRetailStoreOrderLineItemByBizOrder(resultList, retailStoreOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderLineItemByBizOrder(SmartList<RetailStoreOrderLineItem> resultList, String retailStoreOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId,Map<String,Object> options){

 		return countWith(RetailStoreOrderLineItemTable.COLUMN_BIZ_ORDER, retailStoreOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderLineItemByBizOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderLineItemTable.COLUMN_BIZ_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItem(RetailStoreOrderLineItem  retailStoreOrderLineItem){
		
		if(!retailStoreOrderLineItem.isChanged()){
			return retailStoreOrderLineItem;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderLineItemSQL(retailStoreOrderLineItem);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderLineItemParameters(retailStoreOrderLineItem);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderLineItem.incVersion();
		return retailStoreOrderLineItem;
	
	}
	public SmartList<RetailStoreOrderLineItem> saveRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderLineItemList(retailStoreOrderLineItemList);
		
		batchRetailStoreOrderLineItemCreate((List<RetailStoreOrderLineItem>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderLineItemUpdate((List<RetailStoreOrderLineItem>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList){
			if(retailStoreOrderLineItem.isChanged()){
				retailStoreOrderLineItem.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderLineItemList;
	}

	public SmartList<RetailStoreOrderLineItem> removeRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderLineItemList, options);
		
		return retailStoreOrderLineItemList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderLineItemBatchCreateArgs(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList ){
			Object [] parameters = prepareRetailStoreOrderLineItemCreateParameters(retailStoreOrderLineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderLineItemBatchUpdateArgs(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList ){
			if(!retailStoreOrderLineItem.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderLineItemUpdateParameters(retailStoreOrderLineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderLineItemCreate(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderLineItemBatchCreateArgs(retailStoreOrderLineItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderLineItemUpdate(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderLineItemBatchUpdateArgs(retailStoreOrderLineItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderLineItemList(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		
		List<RetailStoreOrderLineItem> retailStoreOrderLineItemCreateList=new ArrayList<RetailStoreOrderLineItem>();
		List<RetailStoreOrderLineItem> retailStoreOrderLineItemUpdateList=new ArrayList<RetailStoreOrderLineItem>();
		
		for(RetailStoreOrderLineItem retailStoreOrderLineItem: retailStoreOrderLineItemList){
			if(isUpdateRequest(retailStoreOrderLineItem)){
				retailStoreOrderLineItemUpdateList.add( retailStoreOrderLineItem);
				continue;
			}
			retailStoreOrderLineItemCreateList.add(retailStoreOrderLineItem);
		}
		
		return new Object[]{retailStoreOrderLineItemCreateList,retailStoreOrderLineItemUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderLineItem retailStoreOrderLineItem){
 		return retailStoreOrderLineItem.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderLineItemSQL(RetailStoreOrderLineItem retailStoreOrderLineItem){
 		if(isUpdateRequest(retailStoreOrderLineItem)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderLineItemParameters(RetailStoreOrderLineItem retailStoreOrderLineItem){
 		if(isUpdateRequest(retailStoreOrderLineItem) ){
 			return prepareRetailStoreOrderLineItemUpdateParameters(retailStoreOrderLineItem);
 		}
 		return prepareRetailStoreOrderLineItemCreateParameters(retailStoreOrderLineItem);
 	}
 	protected Object[] prepareRetailStoreOrderLineItemUpdateParameters(RetailStoreOrderLineItem retailStoreOrderLineItem){
 		Object[] parameters = new Object[9];
  	
 		if(retailStoreOrderLineItem.getBizOrder() != null){
 			parameters[0] = retailStoreOrderLineItem.getBizOrder().getId();
 		}
 
 		
 		parameters[1] = retailStoreOrderLineItem.getSkuId();
 		
 		
 		parameters[2] = retailStoreOrderLineItem.getSkuName();
 		
 		
 		parameters[3] = retailStoreOrderLineItem.getAmount();
 		
 		
 		parameters[4] = retailStoreOrderLineItem.getQuantity();
 		
 		
 		parameters[5] = retailStoreOrderLineItem.getUnitOfMeasurement();
 				
 		parameters[6] = retailStoreOrderLineItem.nextVersion();
 		parameters[7] = retailStoreOrderLineItem.getId();
 		parameters[8] = retailStoreOrderLineItem.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderLineItemCreateParameters(RetailStoreOrderLineItem retailStoreOrderLineItem){
		Object[] parameters = new Object[7];
		String newRetailStoreOrderLineItemId=getNextId();
		retailStoreOrderLineItem.setId(newRetailStoreOrderLineItemId);
		parameters[0] =  retailStoreOrderLineItem.getId();
  	
 		if(retailStoreOrderLineItem.getBizOrder() != null){
 			parameters[1] = retailStoreOrderLineItem.getBizOrder().getId();
 		
 		}
 		
 		
 		parameters[2] = retailStoreOrderLineItem.getSkuId();
 		
 		
 		parameters[3] = retailStoreOrderLineItem.getSkuName();
 		
 		
 		parameters[4] = retailStoreOrderLineItem.getAmount();
 		
 		
 		parameters[5] = retailStoreOrderLineItem.getQuantity();
 		
 		
 		parameters[6] = retailStoreOrderLineItem.getUnitOfMeasurement();
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderLineItem saveInternalRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object> options){
		
		saveRetailStoreOrderLineItem(retailStoreOrderLineItem);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(retailStoreOrderLineItem, options);
 		}
 
		
		return retailStoreOrderLineItem;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreOrderLineItem saveBizOrder(RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrderLineItem.getBizOrder() == null){
 			return retailStoreOrderLineItem;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderDAO().save(retailStoreOrderLineItem.getBizOrder(),options);
 		return retailStoreOrderLineItem;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public RetailStoreOrderLineItem present(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String, Object> options){
	

		return retailStoreOrderLineItem;
	
	}
		

	

	protected String getTableName(){
		return RetailStoreOrderLineItemTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList) {		
		this.enhanceListInternal(retailStoreOrderLineItemList, this.getRetailStoreOrderLineItemMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreOrderLineItem> retailStoreOrderLineItemList = ownerEntity.collectRefsWithType(RetailStoreOrderLineItem.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderLineItemList);
		
	}
	
	@Override
	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreOrderLineItemMapper());

	}
	@Override
	public int countRetailStoreOrderLineItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderLineItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreOrderLineItem> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderLineItemMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreOrderLineItem executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreOrderLineItem result = new CandidateRetailStoreOrderLineItem();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}
	
	

}


