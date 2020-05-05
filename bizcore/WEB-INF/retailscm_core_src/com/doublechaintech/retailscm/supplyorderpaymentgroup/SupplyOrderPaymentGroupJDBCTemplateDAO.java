
package com.doublechaintech.retailscm.supplyorderpaymentgroup;

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


import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class SupplyOrderPaymentGroupJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SupplyOrderPaymentGroupDAO{

	protected SupplyOrderDAO supplyOrderDAO;
	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
 	
 		if(supplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}	

	
	/*
	protected SupplyOrderPaymentGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderPaymentGroup(accessKey, options);
	}
	*/
	
	public SmartList<SupplyOrderPaymentGroup> loadAll() {
	    return this.loadAll(getSupplyOrderPaymentGroupMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplyOrderPaymentGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderPaymentGroup(SupplyOrderPaymentGroupTable.withId(id), options);
	}
	
	
	
	public SupplyOrderPaymentGroup save(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object> options){
		
		String methodName="save(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderPaymentGroup, methodName, "supplyOrderPaymentGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderPaymentGroup(supplyOrderPaymentGroup,options);
	}
	public SupplyOrderPaymentGroup clone(String supplyOrderPaymentGroupId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderPaymentGroupTable.withId(supplyOrderPaymentGroupId),options);
	}
	
	protected SupplyOrderPaymentGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderPaymentGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderPaymentGroup newSupplyOrderPaymentGroup = loadInternalSupplyOrderPaymentGroup(accessKey, options);
		newSupplyOrderPaymentGroup.setVersion(0);
		
		

		
		saveInternalSupplyOrderPaymentGroup(newSupplyOrderPaymentGroup,options);
		
		return newSupplyOrderPaymentGroup;
	}
	
	
	
	

	protected void throwIfHasException(String supplyOrderPaymentGroupId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderPaymentGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderPaymentGroupNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderPaymentGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplyOrderPaymentGroupId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderPaymentGroupId, int version)";
		assertMethodArgumentNotNull(supplyOrderPaymentGroupId, methodName, "supplyOrderPaymentGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderPaymentGroupId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderPaymentGroupId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplyOrderPaymentGroup disconnectFromAll(String supplyOrderPaymentGroupId, int version) throws Exception{
	
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadInternalSupplyOrderPaymentGroup(SupplyOrderPaymentGroupTable.withId(supplyOrderPaymentGroupId), emptyOptions());
		supplyOrderPaymentGroup.clearFromAll();
		this.saveSupplyOrderPaymentGroup(supplyOrderPaymentGroup);
		return supplyOrderPaymentGroup;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderPaymentGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_payment_group";
	}
	@Override
	protected String getBeanName() {
		
		return "supplyOrderPaymentGroup";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderPaymentGroupTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderPaymentGroupTokens.BIZORDER);
 	}

 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderPaymentGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected SupplyOrderPaymentGroupMapper getSupplyOrderPaymentGroupMapper(){
		return new SupplyOrderPaymentGroupMapper();
	}

	
	
	protected SupplyOrderPaymentGroup extractSupplyOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSingleObject(accessKey, getSupplyOrderPaymentGroupMapper());
			return supplyOrderPaymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderPaymentGroupNotFoundException("SupplyOrderPaymentGroup("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderPaymentGroup loadInternalSupplyOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = extractSupplyOrderPaymentGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(supplyOrderPaymentGroup, loadOptions);
 		}
 
		
		return supplyOrderPaymentGroup;
		
	}

	 

 	protected SupplyOrderPaymentGroup extractBizOrder(SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object> options) throws Exception{

		if(supplyOrderPaymentGroup.getBizOrder() == null){
			return supplyOrderPaymentGroup;
		}
		String bizOrderId = supplyOrderPaymentGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return supplyOrderPaymentGroup;
		}
		SupplyOrder bizOrder = getSupplyOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			supplyOrderPaymentGroup.setBizOrder(bizOrder);
		}
		
 		
 		return supplyOrderPaymentGroup;
 	}
 		
 
		
		
  	
 	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupByBizOrder(String supplyOrderId,Map<String,Object> options){
 	
  		SmartList<SupplyOrderPaymentGroup> resultList = queryWith(SupplyOrderPaymentGroupTable.COLUMN_BIZ_ORDER, supplyOrderId, options, getSupplyOrderPaymentGroupMapper());
		// analyzeSupplyOrderPaymentGroupByBizOrder(resultList, supplyOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupByBizOrder(String supplyOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrderPaymentGroup> resultList =  queryWithRange(SupplyOrderPaymentGroupTable.COLUMN_BIZ_ORDER, supplyOrderId, options, getSupplyOrderPaymentGroupMapper(), start, count);
 		//analyzeSupplyOrderPaymentGroupByBizOrder(resultList, supplyOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderPaymentGroupByBizOrder(SmartList<SupplyOrderPaymentGroup> resultList, String supplyOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countSupplyOrderPaymentGroupByBizOrder(String supplyOrderId,Map<String,Object> options){

 		return countWith(SupplyOrderPaymentGroupTable.COLUMN_BIZ_ORDER, supplyOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderPaymentGroupByBizOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderPaymentGroupTable.COLUMN_BIZ_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroup(SupplyOrderPaymentGroup  supplyOrderPaymentGroup){
		
		if(!supplyOrderPaymentGroup.isChanged()){
			return supplyOrderPaymentGroup;
		}
		
		
		String SQL=this.getSaveSupplyOrderPaymentGroupSQL(supplyOrderPaymentGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderPaymentGroupParameters(supplyOrderPaymentGroup);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderPaymentGroup.incVersion();
		return supplyOrderPaymentGroup;
	
	}
	public SmartList<SupplyOrderPaymentGroup> saveSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderPaymentGroupList(supplyOrderPaymentGroupList);
		
		batchSupplyOrderPaymentGroupCreate((List<SupplyOrderPaymentGroup>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderPaymentGroupUpdate((List<SupplyOrderPaymentGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList){
			if(supplyOrderPaymentGroup.isChanged()){
				supplyOrderPaymentGroup.incVersion();
			}
			
		
		}
		
		
		return supplyOrderPaymentGroupList;
	}

	public SmartList<SupplyOrderPaymentGroup> removeSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderPaymentGroupList, options);
		
		return supplyOrderPaymentGroupList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderPaymentGroupBatchCreateArgs(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList ){
			Object [] parameters = prepareSupplyOrderPaymentGroupCreateParameters(supplyOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderPaymentGroupBatchUpdateArgs(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList ){
			if(!supplyOrderPaymentGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderPaymentGroupUpdateParameters(supplyOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderPaymentGroupCreate(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderPaymentGroupBatchCreateArgs(supplyOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderPaymentGroupUpdate(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderPaymentGroupBatchUpdateArgs(supplyOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderPaymentGroupList(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		
		List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupCreateList=new ArrayList<SupplyOrderPaymentGroup>();
		List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupUpdateList=new ArrayList<SupplyOrderPaymentGroup>();
		
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup: supplyOrderPaymentGroupList){
			if(isUpdateRequest(supplyOrderPaymentGroup)){
				supplyOrderPaymentGroupUpdateList.add( supplyOrderPaymentGroup);
				continue;
			}
			supplyOrderPaymentGroupCreateList.add(supplyOrderPaymentGroup);
		}
		
		return new Object[]{supplyOrderPaymentGroupCreateList,supplyOrderPaymentGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
 		return supplyOrderPaymentGroup.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderPaymentGroupSQL(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
 		if(isUpdateRequest(supplyOrderPaymentGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderPaymentGroupParameters(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
 		if(isUpdateRequest(supplyOrderPaymentGroup) ){
 			return prepareSupplyOrderPaymentGroupUpdateParameters(supplyOrderPaymentGroup);
 		}
 		return prepareSupplyOrderPaymentGroupCreateParameters(supplyOrderPaymentGroup);
 	}
 	protected Object[] prepareSupplyOrderPaymentGroupUpdateParameters(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
 		Object[] parameters = new Object[6];
 
 		
 		parameters[0] = supplyOrderPaymentGroup.getName();
 		 	
 		if(supplyOrderPaymentGroup.getBizOrder() != null){
 			parameters[1] = supplyOrderPaymentGroup.getBizOrder().getId();
 		}
 
 		
 		parameters[2] = supplyOrderPaymentGroup.getCardNumber();
 				
 		parameters[3] = supplyOrderPaymentGroup.nextVersion();
 		parameters[4] = supplyOrderPaymentGroup.getId();
 		parameters[5] = supplyOrderPaymentGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderPaymentGroupCreateParameters(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
		Object[] parameters = new Object[4];
		String newSupplyOrderPaymentGroupId=getNextId();
		supplyOrderPaymentGroup.setId(newSupplyOrderPaymentGroupId);
		parameters[0] =  supplyOrderPaymentGroup.getId();
 
 		
 		parameters[1] = supplyOrderPaymentGroup.getName();
 		 	
 		if(supplyOrderPaymentGroup.getBizOrder() != null){
 			parameters[2] = supplyOrderPaymentGroup.getBizOrder().getId();
 		
 		}
 		
 		
 		parameters[3] = supplyOrderPaymentGroup.getCardNumber();
 				
 				
 		return parameters;
 	}
 	
	protected SupplyOrderPaymentGroup saveInternalSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object> options){
		
		saveSupplyOrderPaymentGroup(supplyOrderPaymentGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(supplyOrderPaymentGroup, options);
 		}
 
		
		return supplyOrderPaymentGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplyOrderPaymentGroup saveBizOrder(SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrderPaymentGroup.getBizOrder() == null){
 			return supplyOrderPaymentGroup;//do nothing when it is null
 		}
 		
 		getSupplyOrderDAO().save(supplyOrderPaymentGroup.getBizOrder(),options);
 		return supplyOrderPaymentGroup;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public SupplyOrderPaymentGroup present(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String, Object> options){
	

		return supplyOrderPaymentGroup;
	
	}
		

	

	protected String getTableName(){
		return SupplyOrderPaymentGroupTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList) {		
		this.enhanceListInternal(supplyOrderPaymentGroupList, this.getSupplyOrderPaymentGroupMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = ownerEntity.collectRefsWithType(SupplyOrderPaymentGroup.INTERNAL_TYPE);
		this.enhanceList(supplyOrderPaymentGroupList);
		
	}
	
	@Override
	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplyOrderPaymentGroupMapper());

	}
	@Override
	public int countSupplyOrderPaymentGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderPaymentGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplyOrderPaymentGroup> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderPaymentGroupMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSupplyOrderPaymentGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSupplyOrderPaymentGroup result = new CandidateSupplyOrderPaymentGroup();
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


