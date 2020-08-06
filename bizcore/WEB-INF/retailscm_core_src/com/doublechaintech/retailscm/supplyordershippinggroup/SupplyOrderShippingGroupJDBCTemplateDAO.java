
package com.doublechaintech.retailscm.supplyordershippinggroup;

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
import java.util.stream.Stream;

public class SupplyOrderShippingGroupJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SupplyOrderShippingGroupDAO{

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
	protected SupplyOrderShippingGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderShippingGroup(accessKey, options);
	}
	*/

	public SmartList<SupplyOrderShippingGroup> loadAll() {
	    return this.loadAll(getSupplyOrderShippingGroupMapper());
	}

  public Stream<SupplyOrderShippingGroup> loadAllAsStream() {
      return this.loadAllAsStream(getSupplyOrderShippingGroupMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public SupplyOrderShippingGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderShippingGroup(SupplyOrderShippingGroupTable.withId(id), options);
	}

	

	public SupplyOrderShippingGroup save(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object> options){

		String methodName="save(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object> options)";

		assertMethodArgumentNotNull(supplyOrderShippingGroup, methodName, "supplyOrderShippingGroup");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalSupplyOrderShippingGroup(supplyOrderShippingGroup,options);
	}
	public SupplyOrderShippingGroup clone(String supplyOrderShippingGroupId, Map<String,Object> options) throws Exception{

		return clone(SupplyOrderShippingGroupTable.withId(supplyOrderShippingGroupId),options);
	}

	protected SupplyOrderShippingGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String supplyOrderShippingGroupId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		SupplyOrderShippingGroup newSupplyOrderShippingGroup = loadInternalSupplyOrderShippingGroup(accessKey, options);
		newSupplyOrderShippingGroup.setVersion(0);
		
		


		saveInternalSupplyOrderShippingGroup(newSupplyOrderShippingGroup,options);

		return newSupplyOrderShippingGroup;
	}

	



	protected void throwIfHasException(String supplyOrderShippingGroupId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplyOrderShippingGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderShippingGroupNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderShippingGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String supplyOrderShippingGroupId, int version) throws Exception{

		String methodName="delete(String supplyOrderShippingGroupId, int version)";
		assertMethodArgumentNotNull(supplyOrderShippingGroupId, methodName, "supplyOrderShippingGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderShippingGroupId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderShippingGroupId,version);
		}


	}






	public SupplyOrderShippingGroup disconnectFromAll(String supplyOrderShippingGroupId, int version) throws Exception{


		SupplyOrderShippingGroup supplyOrderShippingGroup = loadInternalSupplyOrderShippingGroup(SupplyOrderShippingGroupTable.withId(supplyOrderShippingGroupId), emptyOptions());
		supplyOrderShippingGroup.clearFromAll();
		this.saveSupplyOrderShippingGroup(supplyOrderShippingGroup);
		return supplyOrderShippingGroup;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return SupplyOrderShippingGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "supply_order_shipping_group";
	}
	@Override
	protected String getBeanName() {

		return "supplyOrderShippingGroup";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderShippingGroupTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderShippingGroupTokens.BIZORDER);
 	}

 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderShippingGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected SupplyOrderShippingGroupMapper getSupplyOrderShippingGroupMapper(){
		return new SupplyOrderShippingGroupMapper();
	}

	
	
	protected SupplyOrderShippingGroup extractSupplyOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplyOrderShippingGroup supplyOrderShippingGroup = loadSingleObject(accessKey, getSupplyOrderShippingGroupMapper());
			return supplyOrderShippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderShippingGroupNotFoundException("SupplyOrderShippingGroup("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplyOrderShippingGroup loadInternalSupplyOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = extractSupplyOrderShippingGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(supplyOrderShippingGroup, loadOptions);
 		}
 
		
		return supplyOrderShippingGroup;
		
	}

	 

 	protected SupplyOrderShippingGroup extractBizOrder(SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object> options) throws Exception{

		if(supplyOrderShippingGroup.getBizOrder() == null){
			return supplyOrderShippingGroup;
		}
		String bizOrderId = supplyOrderShippingGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return supplyOrderShippingGroup;
		}
		SupplyOrder bizOrder = getSupplyOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			supplyOrderShippingGroup.setBizOrder(bizOrder);
		}
		
 		
 		return supplyOrderShippingGroup;
 	}
 		
 
		
		
  	
 	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(String supplyOrderId,Map<String,Object> options){
 	
  		SmartList<SupplyOrderShippingGroup> resultList = queryWith(SupplyOrderShippingGroupTable.COLUMN_BIZ_ORDER, supplyOrderId, options, getSupplyOrderShippingGroupMapper());
		// analyzeSupplyOrderShippingGroupByBizOrder(resultList, supplyOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(String supplyOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplyOrderShippingGroup> resultList =  queryWithRange(SupplyOrderShippingGroupTable.COLUMN_BIZ_ORDER, supplyOrderId, options, getSupplyOrderShippingGroupMapper(), start, count);
 		//analyzeSupplyOrderShippingGroupByBizOrder(resultList, supplyOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplyOrderShippingGroupByBizOrder(SmartList<SupplyOrderShippingGroup> resultList, String supplyOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countSupplyOrderShippingGroupByBizOrder(String supplyOrderId,Map<String,Object> options){

 		return countWith(SupplyOrderShippingGroupTable.COLUMN_BIZ_ORDER, supplyOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplyOrderShippingGroupByBizOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplyOrderShippingGroupTable.COLUMN_BIZ_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected SupplyOrderShippingGroup saveSupplyOrderShippingGroup(SupplyOrderShippingGroup  supplyOrderShippingGroup){
		
		if(!supplyOrderShippingGroup.isChanged()){
			return supplyOrderShippingGroup;
		}
		

		String SQL=this.getSaveSupplyOrderShippingGroupSQL(supplyOrderShippingGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderShippingGroupParameters(supplyOrderShippingGroup);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		supplyOrderShippingGroup.incVersion();
		return supplyOrderShippingGroup;

	}
	public SmartList<SupplyOrderShippingGroup> saveSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderShippingGroupList(supplyOrderShippingGroupList);

		batchSupplyOrderShippingGroupCreate((List<SupplyOrderShippingGroup>)lists[CREATE_LIST_INDEX]);

		batchSupplyOrderShippingGroupUpdate((List<SupplyOrderShippingGroup>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList){
			if(supplyOrderShippingGroup.isChanged()){
				supplyOrderShippingGroup.incVersion();
			}


		}


		return supplyOrderShippingGroupList;
	}

	public SmartList<SupplyOrderShippingGroup> removeSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options){


		super.removeList(supplyOrderShippingGroupList, options);

		return supplyOrderShippingGroupList;


	}

	protected List<Object[]> prepareSupplyOrderShippingGroupBatchCreateArgs(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList ){
			Object [] parameters = prepareSupplyOrderShippingGroupCreateParameters(supplyOrderShippingGroup);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareSupplyOrderShippingGroupBatchUpdateArgs(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList ){
			if(!supplyOrderShippingGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderShippingGroupUpdateParameters(supplyOrderShippingGroup);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchSupplyOrderShippingGroupCreate(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderShippingGroupBatchCreateArgs(supplyOrderShippingGroupList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchSupplyOrderShippingGroupUpdate(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderShippingGroupBatchUpdateArgs(supplyOrderShippingGroupList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitSupplyOrderShippingGroupList(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){

		List<SupplyOrderShippingGroup> supplyOrderShippingGroupCreateList=new ArrayList<SupplyOrderShippingGroup>();
		List<SupplyOrderShippingGroup> supplyOrderShippingGroupUpdateList=new ArrayList<SupplyOrderShippingGroup>();

		for(SupplyOrderShippingGroup supplyOrderShippingGroup: supplyOrderShippingGroupList){
			if(isUpdateRequest(supplyOrderShippingGroup)){
				supplyOrderShippingGroupUpdateList.add( supplyOrderShippingGroup);
				continue;
			}
			supplyOrderShippingGroupCreateList.add(supplyOrderShippingGroup);
		}

		return new Object[]{supplyOrderShippingGroupCreateList,supplyOrderShippingGroupUpdateList};
	}

	protected boolean isUpdateRequest(SupplyOrderShippingGroup supplyOrderShippingGroup){
 		return supplyOrderShippingGroup.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderShippingGroupSQL(SupplyOrderShippingGroup supplyOrderShippingGroup){
 		if(isUpdateRequest(supplyOrderShippingGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveSupplyOrderShippingGroupParameters(SupplyOrderShippingGroup supplyOrderShippingGroup){
 		if(isUpdateRequest(supplyOrderShippingGroup) ){
 			return prepareSupplyOrderShippingGroupUpdateParameters(supplyOrderShippingGroup);
 		}
 		return prepareSupplyOrderShippingGroupCreateParameters(supplyOrderShippingGroup);
 	}
 	protected Object[] prepareSupplyOrderShippingGroupUpdateParameters(SupplyOrderShippingGroup supplyOrderShippingGroup){
 		Object[] parameters = new Object[6];
 
 		
 		parameters[0] = supplyOrderShippingGroup.getName();
 		
 		if(supplyOrderShippingGroup.getBizOrder() != null){
 			parameters[1] = supplyOrderShippingGroup.getBizOrder().getId();
 		}
 
 		
 		parameters[2] = supplyOrderShippingGroup.getAmount();
 		
 		parameters[3] = supplyOrderShippingGroup.nextVersion();
 		parameters[4] = supplyOrderShippingGroup.getId();
 		parameters[5] = supplyOrderShippingGroup.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderShippingGroupCreateParameters(SupplyOrderShippingGroup supplyOrderShippingGroup){
		Object[] parameters = new Object[4];
        if(supplyOrderShippingGroup.getId() == null){
          String newSupplyOrderShippingGroupId=getNextId();
          supplyOrderShippingGroup.setId(newSupplyOrderShippingGroupId);
        }
		parameters[0] =  supplyOrderShippingGroup.getId();
 
 		
 		parameters[1] = supplyOrderShippingGroup.getName();
 		
 		if(supplyOrderShippingGroup.getBizOrder() != null){
 			parameters[2] = supplyOrderShippingGroup.getBizOrder().getId();

 		}
 		
 		
 		parameters[3] = supplyOrderShippingGroup.getAmount();
 		

 		return parameters;
 	}

	protected SupplyOrderShippingGroup saveInternalSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object> options){

		saveSupplyOrderShippingGroup(supplyOrderShippingGroup);

 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(supplyOrderShippingGroup, options);
 		}
 
		
		return supplyOrderShippingGroup;

	}



	//======================================================================================
	

 	protected SupplyOrderShippingGroup saveBizOrder(SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrderShippingGroup.getBizOrder() == null){
 			return supplyOrderShippingGroup;//do nothing when it is null
 		}

 		getSupplyOrderDAO().save(supplyOrderShippingGroup.getBizOrder(),options);
 		return supplyOrderShippingGroup;

 	}





 

	

		

	public SupplyOrderShippingGroup present(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String, Object> options){
	

		return supplyOrderShippingGroup;
	
	}
		

	

	protected String getTableName(){
		return SupplyOrderShippingGroupTable.TABLE_NAME;
	}



	public void enhanceList(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList) {
		this.enhanceListInternal(supplyOrderShippingGroupList, this.getSupplyOrderShippingGroupMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplyOrderShippingGroup> supplyOrderShippingGroupList = ownerEntity.collectRefsWithType(SupplyOrderShippingGroup.INTERNAL_TYPE);
		this.enhanceList(supplyOrderShippingGroupList);

	}

	@Override
	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getSupplyOrderShippingGroupMapper());

	}
	@Override
	public int countSupplyOrderShippingGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplyOrderShippingGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<SupplyOrderShippingGroup> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplyOrderShippingGroupMapper());
	}

  @Override
  public Stream<SupplyOrderShippingGroup> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getSupplyOrderShippingGroupMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSupplyOrderShippingGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSupplyOrderShippingGroup result = new CandidateSupplyOrderShippingGroup();
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


