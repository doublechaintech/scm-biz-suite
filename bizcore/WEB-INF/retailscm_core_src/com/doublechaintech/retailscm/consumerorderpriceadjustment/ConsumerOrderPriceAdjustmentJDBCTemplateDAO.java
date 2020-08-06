
package com.doublechaintech.retailscm.consumerorderpriceadjustment;

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

public class ConsumerOrderPriceAdjustmentJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ConsumerOrderPriceAdjustmentDAO{

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
	protected ConsumerOrderPriceAdjustment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderPriceAdjustment(accessKey, options);
	}
	*/

	public SmartList<ConsumerOrderPriceAdjustment> loadAll() {
	    return this.loadAll(getConsumerOrderPriceAdjustmentMapper());
	}

  public Stream<ConsumerOrderPriceAdjustment> loadAllAsStream() {
      return this.loadAllAsStream(getConsumerOrderPriceAdjustmentMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ConsumerOrderPriceAdjustment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustmentTable.withId(id), options);
	}

	

	public ConsumerOrderPriceAdjustment save(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object> options){

		String methodName="save(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object> options)";

		assertMethodArgumentNotNull(consumerOrderPriceAdjustment, methodName, "consumerOrderPriceAdjustment");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment,options);
	}
	public ConsumerOrderPriceAdjustment clone(String consumerOrderPriceAdjustmentId, Map<String,Object> options) throws Exception{

		return clone(ConsumerOrderPriceAdjustmentTable.withId(consumerOrderPriceAdjustmentId),options);
	}

	protected ConsumerOrderPriceAdjustment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String consumerOrderPriceAdjustmentId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ConsumerOrderPriceAdjustment newConsumerOrderPriceAdjustment = loadInternalConsumerOrderPriceAdjustment(accessKey, options);
		newConsumerOrderPriceAdjustment.setVersion(0);
		
		


		saveInternalConsumerOrderPriceAdjustment(newConsumerOrderPriceAdjustment,options);

		return newConsumerOrderPriceAdjustment;
	}

	



	protected void throwIfHasException(String consumerOrderPriceAdjustmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ConsumerOrderPriceAdjustmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderPriceAdjustmentNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderPriceAdjustmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String consumerOrderPriceAdjustmentId, int version) throws Exception{

		String methodName="delete(String consumerOrderPriceAdjustmentId, int version)";
		assertMethodArgumentNotNull(consumerOrderPriceAdjustmentId, methodName, "consumerOrderPriceAdjustmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderPriceAdjustmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderPriceAdjustmentId,version);
		}


	}






	public ConsumerOrderPriceAdjustment disconnectFromAll(String consumerOrderPriceAdjustmentId, int version) throws Exception{


		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadInternalConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustmentTable.withId(consumerOrderPriceAdjustmentId), emptyOptions());
		consumerOrderPriceAdjustment.clearFromAll();
		this.saveConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment);
		return consumerOrderPriceAdjustment;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ConsumerOrderPriceAdjustmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "consumer_order_price_adjustment";
	}
	@Override
	protected String getBeanName() {

		return "consumerOrderPriceAdjustment";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderPriceAdjustmentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderPriceAdjustmentTokens.BIZORDER);
 	}

 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderPriceAdjustmentTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected ConsumerOrderPriceAdjustmentMapper getConsumerOrderPriceAdjustmentMapper(){
		return new ConsumerOrderPriceAdjustmentMapper();
	}

	
	
	protected ConsumerOrderPriceAdjustment extractConsumerOrderPriceAdjustment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = loadSingleObject(accessKey, getConsumerOrderPriceAdjustmentMapper());
			return consumerOrderPriceAdjustment;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderPriceAdjustmentNotFoundException("ConsumerOrderPriceAdjustment("+accessKey+") is not found!");
		}

	}

	
	

	protected ConsumerOrderPriceAdjustment loadInternalConsumerOrderPriceAdjustment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = extractConsumerOrderPriceAdjustment(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(consumerOrderPriceAdjustment, loadOptions);
 		}
 
		
		return consumerOrderPriceAdjustment;
		
	}

	 

 	protected ConsumerOrderPriceAdjustment extractBizOrder(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options) throws Exception{

		if(consumerOrderPriceAdjustment.getBizOrder() == null){
			return consumerOrderPriceAdjustment;
		}
		String bizOrderId = consumerOrderPriceAdjustment.getBizOrder().getId();
		if( bizOrderId == null){
			return consumerOrderPriceAdjustment;
		}
		ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			consumerOrderPriceAdjustment.setBizOrder(bizOrder);
		}
		
 		
 		return consumerOrderPriceAdjustment;
 	}
 		
 
		
		
  	
 	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrderPriceAdjustment> resultList = queryWith(ConsumerOrderPriceAdjustmentTable.COLUMN_BIZ_ORDER, consumerOrderId, options, getConsumerOrderPriceAdjustmentMapper());
		// analyzeConsumerOrderPriceAdjustmentByBizOrder(resultList, consumerOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrderPriceAdjustment> resultList =  queryWithRange(ConsumerOrderPriceAdjustmentTable.COLUMN_BIZ_ORDER, consumerOrderId, options, getConsumerOrderPriceAdjustmentMapper(), start, count);
 		//analyzeConsumerOrderPriceAdjustmentByBizOrder(resultList, consumerOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderPriceAdjustmentByBizOrder(SmartList<ConsumerOrderPriceAdjustment> resultList, String consumerOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId,Map<String,Object> options){

 		return countWith(ConsumerOrderPriceAdjustmentTable.COLUMN_BIZ_ORDER, consumerOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderPriceAdjustmentByBizOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderPriceAdjustmentTable.COLUMN_BIZ_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment  consumerOrderPriceAdjustment){
		
		if(!consumerOrderPriceAdjustment.isChanged()){
			return consumerOrderPriceAdjustment;
		}
		

		String SQL=this.getSaveConsumerOrderPriceAdjustmentSQL(consumerOrderPriceAdjustment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderPriceAdjustmentParameters(consumerOrderPriceAdjustment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		consumerOrderPriceAdjustment.incVersion();
		return consumerOrderPriceAdjustment;

	}
	public SmartList<ConsumerOrderPriceAdjustment> saveConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderPriceAdjustmentList(consumerOrderPriceAdjustmentList);

		batchConsumerOrderPriceAdjustmentCreate((List<ConsumerOrderPriceAdjustment>)lists[CREATE_LIST_INDEX]);

		batchConsumerOrderPriceAdjustmentUpdate((List<ConsumerOrderPriceAdjustment>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList){
			if(consumerOrderPriceAdjustment.isChanged()){
				consumerOrderPriceAdjustment.incVersion();
			}


		}


		return consumerOrderPriceAdjustmentList;
	}

	public SmartList<ConsumerOrderPriceAdjustment> removeConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options){


		super.removeList(consumerOrderPriceAdjustmentList, options);

		return consumerOrderPriceAdjustmentList;


	}

	protected List<Object[]> prepareConsumerOrderPriceAdjustmentBatchCreateArgs(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList ){
			Object [] parameters = prepareConsumerOrderPriceAdjustmentCreateParameters(consumerOrderPriceAdjustment);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareConsumerOrderPriceAdjustmentBatchUpdateArgs(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList ){
			if(!consumerOrderPriceAdjustment.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderPriceAdjustmentUpdateParameters(consumerOrderPriceAdjustment);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchConsumerOrderPriceAdjustmentCreate(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderPriceAdjustmentBatchCreateArgs(consumerOrderPriceAdjustmentList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchConsumerOrderPriceAdjustmentUpdate(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderPriceAdjustmentBatchUpdateArgs(consumerOrderPriceAdjustmentList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitConsumerOrderPriceAdjustmentList(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){

		List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentCreateList=new ArrayList<ConsumerOrderPriceAdjustment>();
		List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentUpdateList=new ArrayList<ConsumerOrderPriceAdjustment>();

		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment: consumerOrderPriceAdjustmentList){
			if(isUpdateRequest(consumerOrderPriceAdjustment)){
				consumerOrderPriceAdjustmentUpdateList.add( consumerOrderPriceAdjustment);
				continue;
			}
			consumerOrderPriceAdjustmentCreateList.add(consumerOrderPriceAdjustment);
		}

		return new Object[]{consumerOrderPriceAdjustmentCreateList,consumerOrderPriceAdjustmentUpdateList};
	}

	protected boolean isUpdateRequest(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
 		return consumerOrderPriceAdjustment.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderPriceAdjustmentSQL(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
 		if(isUpdateRequest(consumerOrderPriceAdjustment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveConsumerOrderPriceAdjustmentParameters(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
 		if(isUpdateRequest(consumerOrderPriceAdjustment) ){
 			return prepareConsumerOrderPriceAdjustmentUpdateParameters(consumerOrderPriceAdjustment);
 		}
 		return prepareConsumerOrderPriceAdjustmentCreateParameters(consumerOrderPriceAdjustment);
 	}
 	protected Object[] prepareConsumerOrderPriceAdjustmentUpdateParameters(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = consumerOrderPriceAdjustment.getName();
 		
 		if(consumerOrderPriceAdjustment.getBizOrder() != null){
 			parameters[1] = consumerOrderPriceAdjustment.getBizOrder().getId();
 		}
 
 		
 		parameters[2] = consumerOrderPriceAdjustment.getAmount();
 		
 		
 		parameters[3] = consumerOrderPriceAdjustment.getProvider();
 		
 		parameters[4] = consumerOrderPriceAdjustment.nextVersion();
 		parameters[5] = consumerOrderPriceAdjustment.getId();
 		parameters[6] = consumerOrderPriceAdjustment.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderPriceAdjustmentCreateParameters(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
		Object[] parameters = new Object[5];
        if(consumerOrderPriceAdjustment.getId() == null){
          String newConsumerOrderPriceAdjustmentId=getNextId();
          consumerOrderPriceAdjustment.setId(newConsumerOrderPriceAdjustmentId);
        }
		parameters[0] =  consumerOrderPriceAdjustment.getId();
 
 		
 		parameters[1] = consumerOrderPriceAdjustment.getName();
 		
 		if(consumerOrderPriceAdjustment.getBizOrder() != null){
 			parameters[2] = consumerOrderPriceAdjustment.getBizOrder().getId();

 		}
 		
 		
 		parameters[3] = consumerOrderPriceAdjustment.getAmount();
 		
 		
 		parameters[4] = consumerOrderPriceAdjustment.getProvider();
 		

 		return parameters;
 	}

	protected ConsumerOrderPriceAdjustment saveInternalConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options){

		saveConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment);

 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(consumerOrderPriceAdjustment, options);
 		}
 
		
		return consumerOrderPriceAdjustment;

	}



	//======================================================================================
	

 	protected ConsumerOrderPriceAdjustment saveBizOrder(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrderPriceAdjustment.getBizOrder() == null){
 			return consumerOrderPriceAdjustment;//do nothing when it is null
 		}

 		getConsumerOrderDAO().save(consumerOrderPriceAdjustment.getBizOrder(),options);
 		return consumerOrderPriceAdjustment;

 	}





 

	

		

	public ConsumerOrderPriceAdjustment present(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String, Object> options){
	

		return consumerOrderPriceAdjustment;
	
	}
		

	

	protected String getTableName(){
		return ConsumerOrderPriceAdjustmentTable.TABLE_NAME;
	}



	public void enhanceList(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList) {
		this.enhanceListInternal(consumerOrderPriceAdjustmentList, this.getConsumerOrderPriceAdjustmentMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = ownerEntity.collectRefsWithType(ConsumerOrderPriceAdjustment.INTERNAL_TYPE);
		this.enhanceList(consumerOrderPriceAdjustmentList);

	}

	@Override
	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getConsumerOrderPriceAdjustmentMapper());

	}
	@Override
	public int countConsumerOrderPriceAdjustmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countConsumerOrderPriceAdjustmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ConsumerOrderPriceAdjustment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getConsumerOrderPriceAdjustmentMapper());
	}

  @Override
  public Stream<ConsumerOrderPriceAdjustment> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getConsumerOrderPriceAdjustmentMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateConsumerOrderPriceAdjustment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateConsumerOrderPriceAdjustment result = new CandidateConsumerOrderPriceAdjustment();
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


