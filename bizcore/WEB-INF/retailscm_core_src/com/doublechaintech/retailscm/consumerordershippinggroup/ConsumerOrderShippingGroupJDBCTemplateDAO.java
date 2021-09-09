
package com.doublechaintech.retailscm.consumerordershippinggroup;

import com.doublechaintech.retailscm.Beans;
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


import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ConsumerOrderShippingGroupJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ConsumerOrderShippingGroupDAO{

	protected ConsumerOrderDAO consumerOrderDAO;
	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){

 		if(consumerOrderDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
 		}
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
 		if(this.consumerOrderDAO == null){
 			throw new IllegalStateException("The consumerOrderDAO is not configured yet, please config it some where.");
 		}

	 	return this.consumerOrderDAO;
 	}



	/*
	protected ConsumerOrderShippingGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderShippingGroup(accessKey, options);
	}
	*/

	public SmartList<ConsumerOrderShippingGroup> loadAll() {
	    return this.loadAll(getConsumerOrderShippingGroupMapper());
	}

  public Stream<ConsumerOrderShippingGroup> loadAllAsStream() {
      return this.loadAllAsStream(getConsumerOrderShippingGroupMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ConsumerOrderShippingGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderShippingGroup(ConsumerOrderShippingGroupTable.withId(id), options);
	}

	

	public ConsumerOrderShippingGroup save(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object> options){

		String methodName="save(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object> options)";

		assertMethodArgumentNotNull(consumerOrderShippingGroup, methodName, "consumerOrderShippingGroup");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalConsumerOrderShippingGroup(consumerOrderShippingGroup,options);
	}
	public ConsumerOrderShippingGroup clone(String consumerOrderShippingGroupId, Map<String,Object> options) throws Exception{

		return clone(ConsumerOrderShippingGroupTable.withId(consumerOrderShippingGroupId),options);
	}

	protected ConsumerOrderShippingGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String consumerOrderShippingGroupId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ConsumerOrderShippingGroup newConsumerOrderShippingGroup = loadInternalConsumerOrderShippingGroup(accessKey, options);
		newConsumerOrderShippingGroup.setVersion(0);
		
		


		saveInternalConsumerOrderShippingGroup(newConsumerOrderShippingGroup,options);

		return newConsumerOrderShippingGroup;
	}

	



	protected void throwIfHasException(String consumerOrderShippingGroupId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ConsumerOrderShippingGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderShippingGroupNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderShippingGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String consumerOrderShippingGroupId, int version) throws Exception{

		String methodName="delete(String consumerOrderShippingGroupId, int version)";
		assertMethodArgumentNotNull(consumerOrderShippingGroupId, methodName, "consumerOrderShippingGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderShippingGroupId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderShippingGroupId,version);
		}


	}






	public ConsumerOrderShippingGroup disconnectFromAll(String consumerOrderShippingGroupId, int version) throws Exception{


		ConsumerOrderShippingGroup consumerOrderShippingGroup = loadInternalConsumerOrderShippingGroup(ConsumerOrderShippingGroupTable.withId(consumerOrderShippingGroupId), emptyOptions());
		consumerOrderShippingGroup.clearFromAll();
		this.saveConsumerOrderShippingGroup(consumerOrderShippingGroup);
		return consumerOrderShippingGroup;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ConsumerOrderShippingGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "consumer_order_shipping_group";
	}
	@Override
	protected String getBeanName() {

		return "consumerOrderShippingGroup";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return ConsumerOrderShippingGroupTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){

	 	return checkOptions(options, ConsumerOrderShippingGroupTokens.BIZORDER);
 	}

 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){

 		return checkOptions(options, ConsumerOrderShippingGroupTokens.BIZORDER);
 	}



 
		

	

	protected ConsumerOrderShippingGroupMapper getConsumerOrderShippingGroupMapper(){
		return new ConsumerOrderShippingGroupMapper();
	}



	protected ConsumerOrderShippingGroup extractConsumerOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ConsumerOrderShippingGroup consumerOrderShippingGroup = loadSingleObject(accessKey, getConsumerOrderShippingGroupMapper());
			return consumerOrderShippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderShippingGroupNotFoundException("ConsumerOrderShippingGroup("+accessKey+") is not found!");
		}

	}




	protected ConsumerOrderShippingGroup loadInternalConsumerOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		ConsumerOrderShippingGroup consumerOrderShippingGroup = extractConsumerOrderShippingGroup(accessKey, loadOptions);

 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(consumerOrderShippingGroup, loadOptions);
 		}
 
		
		return consumerOrderShippingGroup;

	}

	

 	protected ConsumerOrderShippingGroup extractBizOrder(ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options) throws Exception{
  

		if(consumerOrderShippingGroup.getBizOrder() == null){
			return consumerOrderShippingGroup;
		}
		String bizOrderId = consumerOrderShippingGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return consumerOrderShippingGroup;
		}
		ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			consumerOrderShippingGroup.setBizOrder(bizOrder);
		}


 		return consumerOrderShippingGroup;
 	}

 
		

 
 	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupByBizOrder(String consumerOrderId,Map<String,Object> options){

  		SmartList<ConsumerOrderShippingGroup> resultList = queryWith(ConsumerOrderShippingGroupTable.COLUMN_BIZ_ORDER, consumerOrderId, options, getConsumerOrderShippingGroupMapper());
		// analyzeConsumerOrderShippingGroupByBizOrder(resultList, consumerOrderId, options);
		return resultList;
 	}
 	

 	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupByBizOrder(String consumerOrderId, int start, int count,Map<String,Object> options){

 		SmartList<ConsumerOrderShippingGroup> resultList =  queryWithRange(ConsumerOrderShippingGroupTable.COLUMN_BIZ_ORDER, consumerOrderId, options, getConsumerOrderShippingGroupMapper(), start, count);
 		//analyzeConsumerOrderShippingGroupByBizOrder(resultList, consumerOrderId, options);
 		return resultList;

 	}
 	public void analyzeConsumerOrderShippingGroupByBizOrder(SmartList<ConsumerOrderShippingGroup> resultList, String consumerOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countConsumerOrderShippingGroupByBizOrder(String consumerOrderId,Map<String,Object> options){

 		return countWith(ConsumerOrderShippingGroupTable.COLUMN_BIZ_ORDER, consumerOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderShippingGroupByBizOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderShippingGroupTable.COLUMN_BIZ_ORDER, ids, options);
	}

 




	

	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(ConsumerOrderShippingGroup  consumerOrderShippingGroup){
    

		
		if(!consumerOrderShippingGroup.isChanged()){
			return consumerOrderShippingGroup;
		}
		

    Beans.dbUtil().cacheCleanUp(consumerOrderShippingGroup);
		String SQL=this.getSaveConsumerOrderShippingGroupSQL(consumerOrderShippingGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderShippingGroupParameters(consumerOrderShippingGroup);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		consumerOrderShippingGroup.incVersion();
		consumerOrderShippingGroup.afterSave();
		return consumerOrderShippingGroup;

	}
	public SmartList<ConsumerOrderShippingGroup> saveConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderShippingGroupList(consumerOrderShippingGroupList);

		batchConsumerOrderShippingGroupCreate((List<ConsumerOrderShippingGroup>)lists[CREATE_LIST_INDEX]);

		batchConsumerOrderShippingGroupUpdate((List<ConsumerOrderShippingGroup>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList){
			if(consumerOrderShippingGroup.isChanged()){
				consumerOrderShippingGroup.incVersion();
				consumerOrderShippingGroup.afterSave();
			}


		}


		return consumerOrderShippingGroupList;
	}

	public SmartList<ConsumerOrderShippingGroup> removeConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options){


		super.removeList(consumerOrderShippingGroupList, options);

		return consumerOrderShippingGroupList;


	}

	protected List<Object[]> prepareConsumerOrderShippingGroupBatchCreateArgs(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList ){
			Object [] parameters = prepareConsumerOrderShippingGroupCreateParameters(consumerOrderShippingGroup);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareConsumerOrderShippingGroupBatchUpdateArgs(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList ){
			if(!consumerOrderShippingGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderShippingGroupUpdateParameters(consumerOrderShippingGroup);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchConsumerOrderShippingGroupCreate(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderShippingGroupBatchCreateArgs(consumerOrderShippingGroupList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchConsumerOrderShippingGroupUpdate(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderShippingGroupBatchUpdateArgs(consumerOrderShippingGroupList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitConsumerOrderShippingGroupList(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){

		List<ConsumerOrderShippingGroup> consumerOrderShippingGroupCreateList=new ArrayList<ConsumerOrderShippingGroup>();
		List<ConsumerOrderShippingGroup> consumerOrderShippingGroupUpdateList=new ArrayList<ConsumerOrderShippingGroup>();

		for(ConsumerOrderShippingGroup consumerOrderShippingGroup: consumerOrderShippingGroupList){
			if(isUpdateRequest(consumerOrderShippingGroup)){
				consumerOrderShippingGroupUpdateList.add( consumerOrderShippingGroup);
				continue;
			}
			consumerOrderShippingGroupCreateList.add(consumerOrderShippingGroup);
		}

		return new Object[]{consumerOrderShippingGroupCreateList,consumerOrderShippingGroupUpdateList};
	}

	protected boolean isUpdateRequest(ConsumerOrderShippingGroup consumerOrderShippingGroup){
 		return consumerOrderShippingGroup.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderShippingGroupSQL(ConsumerOrderShippingGroup consumerOrderShippingGroup){
 		if(isUpdateRequest(consumerOrderShippingGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveConsumerOrderShippingGroupParameters(ConsumerOrderShippingGroup consumerOrderShippingGroup){
 		if(isUpdateRequest(consumerOrderShippingGroup) ){
 			return prepareConsumerOrderShippingGroupUpdateParameters(consumerOrderShippingGroup);
 		}
 		return prepareConsumerOrderShippingGroupCreateParameters(consumerOrderShippingGroup);
 	}
 	protected Object[] prepareConsumerOrderShippingGroupUpdateParameters(ConsumerOrderShippingGroup consumerOrderShippingGroup){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = consumerOrderShippingGroup.getName();
 		
 		if(consumerOrderShippingGroup.getBizOrder() != null){
 			parameters[1] = consumerOrderShippingGroup.getBizOrder().getId();
 		}
    
 		parameters[2] = consumerOrderShippingGroup.getAmount();
 		
 		parameters[3] = consumerOrderShippingGroup.nextVersion();
 		parameters[4] = consumerOrderShippingGroup.getId();
 		parameters[5] = consumerOrderShippingGroup.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderShippingGroupCreateParameters(ConsumerOrderShippingGroup consumerOrderShippingGroup){
		Object[] parameters = new Object[4];
        if(consumerOrderShippingGroup.getId() == null){
          String newConsumerOrderShippingGroupId=getNextId();
          consumerOrderShippingGroup.setId(newConsumerOrderShippingGroupId);
        }
		parameters[0] =  consumerOrderShippingGroup.getId();
 
 		parameters[1] = consumerOrderShippingGroup.getName();
 		
 		if(consumerOrderShippingGroup.getBizOrder() != null){
 			parameters[2] = consumerOrderShippingGroup.getBizOrder().getId();
 		}
 		
 		parameters[3] = consumerOrderShippingGroup.getAmount();
 		

 		return parameters;
 	}

	protected ConsumerOrderShippingGroup saveInternalConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options){

 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(consumerOrderShippingGroup, options);
 		}
 
   saveConsumerOrderShippingGroup(consumerOrderShippingGroup);
		
		return consumerOrderShippingGroup;

	}



	//======================================================================================
	

 	protected ConsumerOrderShippingGroup saveBizOrder(ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(consumerOrderShippingGroup.getBizOrder() == null){
 			return consumerOrderShippingGroup;//do nothing when it is null
 		}

 		getConsumerOrderDAO().save(consumerOrderShippingGroup.getBizOrder(),options);
 		return consumerOrderShippingGroup;

 	}
 

	

		

	public ConsumerOrderShippingGroup present(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String, Object> options){


		return consumerOrderShippingGroup;

	}
		

	

	protected String getTableName(){
		return ConsumerOrderShippingGroupTable.TABLE_NAME;
	}



	public void enhanceList(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList) {
		this.enhanceListInternal(consumerOrderShippingGroupList, this.getConsumerOrderShippingGroupMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = ownerEntity.collectRefsWithType(ConsumerOrderShippingGroup.INTERNAL_TYPE);
		this.enhanceList(consumerOrderShippingGroupList);

	}

	@Override
	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getConsumerOrderShippingGroupMapper());

	}
	@Override
	public int countConsumerOrderShippingGroupWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countConsumerOrderShippingGroupWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ConsumerOrderShippingGroup> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getConsumerOrderShippingGroupMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<ConsumerOrderShippingGroup> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getConsumerOrderShippingGroupMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateConsumerOrderShippingGroup executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateConsumerOrderShippingGroup result = new CandidateConsumerOrderShippingGroup();
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

	

  @Override
  public List<ConsumerOrderShippingGroup> search(ConsumerOrderShippingGroupRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected ConsumerOrderShippingGroupMapper mapper() {
    return getConsumerOrderShippingGroupMapper();
  }
}


