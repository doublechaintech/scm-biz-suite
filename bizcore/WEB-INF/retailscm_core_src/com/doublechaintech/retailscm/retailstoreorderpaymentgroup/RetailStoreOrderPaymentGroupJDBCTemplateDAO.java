
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

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


public class RetailStoreOrderPaymentGroupJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreOrderPaymentGroupDAO{

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
	protected RetailStoreOrderPaymentGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderPaymentGroup(accessKey, options);
	}
	*/
	
	public SmartList<RetailStoreOrderPaymentGroup> loadAll() {
	    return this.loadAll(getRetailStoreOrderPaymentGroupMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreOrderPaymentGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroupTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderPaymentGroup save(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderPaymentGroup, methodName, "retailStoreOrderPaymentGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup,options);
	}
	public RetailStoreOrderPaymentGroup clone(String retailStoreOrderPaymentGroupId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderPaymentGroupTable.withId(retailStoreOrderPaymentGroupId),options);
	}
	
	protected RetailStoreOrderPaymentGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderPaymentGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderPaymentGroup newRetailStoreOrderPaymentGroup = loadInternalRetailStoreOrderPaymentGroup(accessKey, options);
		newRetailStoreOrderPaymentGroup.setVersion(0);
		
		

		
		saveInternalRetailStoreOrderPaymentGroup(newRetailStoreOrderPaymentGroup,options);
		
		return newRetailStoreOrderPaymentGroup;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreOrderPaymentGroupId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreOrderPaymentGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderPaymentGroupNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderPaymentGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreOrderPaymentGroupId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderPaymentGroupId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderPaymentGroupId, methodName, "retailStoreOrderPaymentGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderPaymentGroupId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderPaymentGroupId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreOrderPaymentGroup disconnectFromAll(String retailStoreOrderPaymentGroupId, int version) throws Exception{
	
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadInternalRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroupTable.withId(retailStoreOrderPaymentGroupId), emptyOptions());
		retailStoreOrderPaymentGroup.clearFromAll();
		this.saveRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup);
		return retailStoreOrderPaymentGroup;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreOrderPaymentGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_payment_group";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreOrderPaymentGroup";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderPaymentGroupTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderPaymentGroupTokens.BIZORDER);
 	}

 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderPaymentGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected RetailStoreOrderPaymentGroupMapper getRetailStoreOrderPaymentGroupMapper(){
		return new RetailStoreOrderPaymentGroupMapper();
	}

	
	
	protected RetailStoreOrderPaymentGroup extractRetailStoreOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = loadSingleObject(accessKey, getRetailStoreOrderPaymentGroupMapper());
			return retailStoreOrderPaymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderPaymentGroupNotFoundException("RetailStoreOrderPaymentGroup("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreOrderPaymentGroup loadInternalRetailStoreOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = extractRetailStoreOrderPaymentGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(retailStoreOrderPaymentGroup, loadOptions);
 		}
 
		
		return retailStoreOrderPaymentGroup;
		
	}

	 

 	protected RetailStoreOrderPaymentGroup extractBizOrder(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options) throws Exception{

		if(retailStoreOrderPaymentGroup.getBizOrder() == null){
			return retailStoreOrderPaymentGroup;
		}
		String bizOrderId = retailStoreOrderPaymentGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return retailStoreOrderPaymentGroup;
		}
		RetailStoreOrder bizOrder = getRetailStoreOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			retailStoreOrderPaymentGroup.setBizOrder(bizOrder);
		}
		
 		
 		return retailStoreOrderPaymentGroup;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId,Map<String,Object> options){
 	
  		SmartList<RetailStoreOrderPaymentGroup> resultList = queryWith(RetailStoreOrderPaymentGroupTable.COLUMN_BIZ_ORDER, retailStoreOrderId, options, getRetailStoreOrderPaymentGroupMapper());
		// analyzeRetailStoreOrderPaymentGroupByBizOrder(resultList, retailStoreOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreOrderPaymentGroup> resultList =  queryWithRange(RetailStoreOrderPaymentGroupTable.COLUMN_BIZ_ORDER, retailStoreOrderId, options, getRetailStoreOrderPaymentGroupMapper(), start, count);
 		//analyzeRetailStoreOrderPaymentGroupByBizOrder(resultList, retailStoreOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreOrderPaymentGroupByBizOrder(SmartList<RetailStoreOrderPaymentGroup> resultList, String retailStoreOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId,Map<String,Object> options){

 		return countWith(RetailStoreOrderPaymentGroupTable.COLUMN_BIZ_ORDER, retailStoreOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreOrderPaymentGroupByBizOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreOrderPaymentGroupTable.COLUMN_BIZ_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup  retailStoreOrderPaymentGroup){
		
		if(!retailStoreOrderPaymentGroup.isChanged()){
			return retailStoreOrderPaymentGroup;
		}
		
		
		String SQL=this.getSaveRetailStoreOrderPaymentGroupSQL(retailStoreOrderPaymentGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderPaymentGroupParameters(retailStoreOrderPaymentGroup);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderPaymentGroup.incVersion();
		return retailStoreOrderPaymentGroup;
	
	}
	public SmartList<RetailStoreOrderPaymentGroup> saveRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderPaymentGroupList(retailStoreOrderPaymentGroupList);
		
		batchRetailStoreOrderPaymentGroupCreate((List<RetailStoreOrderPaymentGroup>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderPaymentGroupUpdate((List<RetailStoreOrderPaymentGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList){
			if(retailStoreOrderPaymentGroup.isChanged()){
				retailStoreOrderPaymentGroup.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderPaymentGroupList;
	}

	public SmartList<RetailStoreOrderPaymentGroup> removeRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderPaymentGroupList, options);
		
		return retailStoreOrderPaymentGroupList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderPaymentGroupBatchCreateArgs(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList ){
			Object [] parameters = prepareRetailStoreOrderPaymentGroupCreateParameters(retailStoreOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderPaymentGroupBatchUpdateArgs(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList ){
			if(!retailStoreOrderPaymentGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderPaymentGroupUpdateParameters(retailStoreOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderPaymentGroupCreate(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderPaymentGroupBatchCreateArgs(retailStoreOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderPaymentGroupUpdate(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderPaymentGroupBatchUpdateArgs(retailStoreOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderPaymentGroupList(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		
		List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupCreateList=new ArrayList<RetailStoreOrderPaymentGroup>();
		List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupUpdateList=new ArrayList<RetailStoreOrderPaymentGroup>();
		
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup: retailStoreOrderPaymentGroupList){
			if(isUpdateRequest(retailStoreOrderPaymentGroup)){
				retailStoreOrderPaymentGroupUpdateList.add( retailStoreOrderPaymentGroup);
				continue;
			}
			retailStoreOrderPaymentGroupCreateList.add(retailStoreOrderPaymentGroup);
		}
		
		return new Object[]{retailStoreOrderPaymentGroupCreateList,retailStoreOrderPaymentGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
 		return retailStoreOrderPaymentGroup.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderPaymentGroupSQL(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
 		if(isUpdateRequest(retailStoreOrderPaymentGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderPaymentGroupParameters(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
 		if(isUpdateRequest(retailStoreOrderPaymentGroup) ){
 			return prepareRetailStoreOrderPaymentGroupUpdateParameters(retailStoreOrderPaymentGroup);
 		}
 		return prepareRetailStoreOrderPaymentGroupCreateParameters(retailStoreOrderPaymentGroup);
 	}
 	protected Object[] prepareRetailStoreOrderPaymentGroupUpdateParameters(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
 		Object[] parameters = new Object[6];
 
 		
 		parameters[0] = retailStoreOrderPaymentGroup.getName();
 		 	
 		if(retailStoreOrderPaymentGroup.getBizOrder() != null){
 			parameters[1] = retailStoreOrderPaymentGroup.getBizOrder().getId();
 		}
 
 		
 		parameters[2] = retailStoreOrderPaymentGroup.getCardNumber();
 				
 		parameters[3] = retailStoreOrderPaymentGroup.nextVersion();
 		parameters[4] = retailStoreOrderPaymentGroup.getId();
 		parameters[5] = retailStoreOrderPaymentGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderPaymentGroupCreateParameters(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
		Object[] parameters = new Object[4];
		String newRetailStoreOrderPaymentGroupId=getNextId();
		retailStoreOrderPaymentGroup.setId(newRetailStoreOrderPaymentGroupId);
		parameters[0] =  retailStoreOrderPaymentGroup.getId();
 
 		
 		parameters[1] = retailStoreOrderPaymentGroup.getName();
 		 	
 		if(retailStoreOrderPaymentGroup.getBizOrder() != null){
 			parameters[2] = retailStoreOrderPaymentGroup.getBizOrder().getId();
 		
 		}
 		
 		
 		parameters[3] = retailStoreOrderPaymentGroup.getCardNumber();
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderPaymentGroup saveInternalRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options){
		
		saveRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(retailStoreOrderPaymentGroup, options);
 		}
 
		
		return retailStoreOrderPaymentGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreOrderPaymentGroup saveBizOrder(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrderPaymentGroup.getBizOrder() == null){
 			return retailStoreOrderPaymentGroup;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderDAO().save(retailStoreOrderPaymentGroup.getBizOrder(),options);
 		return retailStoreOrderPaymentGroup;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public RetailStoreOrderPaymentGroup present(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String, Object> options){
	

		return retailStoreOrderPaymentGroup;
	
	}
		

	

	protected String getTableName(){
		return RetailStoreOrderPaymentGroupTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList) {		
		this.enhanceListInternal(retailStoreOrderPaymentGroupList, this.getRetailStoreOrderPaymentGroupMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = ownerEntity.collectRefsWithType(RetailStoreOrderPaymentGroup.INTERNAL_TYPE);
		this.enhanceList(retailStoreOrderPaymentGroupList);
		
	}
	
	@Override
	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreOrderPaymentGroupMapper());

	}
	@Override
	public int countRetailStoreOrderPaymentGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreOrderPaymentGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreOrderPaymentGroup> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreOrderPaymentGroupMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreOrderPaymentGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreOrderPaymentGroup result = new CandidateRetailStoreOrderPaymentGroup();
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


