
package com.doublechaintech.retailscm.consumerorderlineitem;

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

public class ConsumerOrderLineItemJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ConsumerOrderLineItemDAO{

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
	protected ConsumerOrderLineItem load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderLineItem(accessKey, options);
	}
	*/

	public SmartList<ConsumerOrderLineItem> loadAll() {
	    return this.loadAll(getConsumerOrderLineItemMapper());
	}

  public Stream<ConsumerOrderLineItem> loadAllAsStream() {
      return this.loadAllAsStream(getConsumerOrderLineItemMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ConsumerOrderLineItem load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderLineItem(ConsumerOrderLineItemTable.withId(id), options);
	}

	

	public ConsumerOrderLineItem save(ConsumerOrderLineItem consumerOrderLineItem,Map<String,Object> options){

		String methodName="save(ConsumerOrderLineItem consumerOrderLineItem,Map<String,Object> options)";

		assertMethodArgumentNotNull(consumerOrderLineItem, methodName, "consumerOrderLineItem");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalConsumerOrderLineItem(consumerOrderLineItem,options);
	}
	public ConsumerOrderLineItem clone(String consumerOrderLineItemId, Map<String,Object> options) throws Exception{

		return clone(ConsumerOrderLineItemTable.withId(consumerOrderLineItemId),options);
	}

	protected ConsumerOrderLineItem clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String consumerOrderLineItemId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ConsumerOrderLineItem newConsumerOrderLineItem = loadInternalConsumerOrderLineItem(accessKey, options);
		newConsumerOrderLineItem.setVersion(0);
		
		


		saveInternalConsumerOrderLineItem(newConsumerOrderLineItem,options);

		return newConsumerOrderLineItem;
	}

	



	protected void throwIfHasException(String consumerOrderLineItemId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ConsumerOrderLineItemVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderLineItemNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderLineItemId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String consumerOrderLineItemId, int version) throws Exception{

		String methodName="delete(String consumerOrderLineItemId, int version)";
		assertMethodArgumentNotNull(consumerOrderLineItemId, methodName, "consumerOrderLineItemId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderLineItemId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderLineItemId,version);
		}


	}






	public ConsumerOrderLineItem disconnectFromAll(String consumerOrderLineItemId, int version) throws Exception{


		ConsumerOrderLineItem consumerOrderLineItem = loadInternalConsumerOrderLineItem(ConsumerOrderLineItemTable.withId(consumerOrderLineItemId), emptyOptions());
		consumerOrderLineItem.clearFromAll();
		this.saveConsumerOrderLineItem(consumerOrderLineItem);
		return consumerOrderLineItem;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ConsumerOrderLineItemTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "consumer_order_line_item";
	}
	@Override
	protected String getBeanName() {

		return "consumerOrderLineItem";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderLineItemTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderLineItemTokens.BIZORDER);
 	}

 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderLineItemTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected ConsumerOrderLineItemMapper getConsumerOrderLineItemMapper(){
		return new ConsumerOrderLineItemMapper();
	}

	
	
	protected ConsumerOrderLineItem extractConsumerOrderLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ConsumerOrderLineItem consumerOrderLineItem = loadSingleObject(accessKey, getConsumerOrderLineItemMapper());
			return consumerOrderLineItem;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderLineItemNotFoundException("ConsumerOrderLineItem("+accessKey+") is not found!");
		}

	}

	
	

	protected ConsumerOrderLineItem loadInternalConsumerOrderLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderLineItem consumerOrderLineItem = extractConsumerOrderLineItem(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(consumerOrderLineItem, loadOptions);
 		}
 
		
		return consumerOrderLineItem;
		
	}

	 

 	protected ConsumerOrderLineItem extractBizOrder(ConsumerOrderLineItem consumerOrderLineItem, Map<String,Object> options) throws Exception{

		if(consumerOrderLineItem.getBizOrder() == null){
			return consumerOrderLineItem;
		}
		String bizOrderId = consumerOrderLineItem.getBizOrder().getId();
		if( bizOrderId == null){
			return consumerOrderLineItem;
		}
		ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			consumerOrderLineItem.setBizOrder(bizOrder);
		}
		
 		
 		return consumerOrderLineItem;
 	}
 		
 
		
		
  	
 	public SmartList<ConsumerOrderLineItem> findConsumerOrderLineItemByBizOrder(String consumerOrderId,Map<String,Object> options){
 	
  		SmartList<ConsumerOrderLineItem> resultList = queryWith(ConsumerOrderLineItemTable.COLUMN_BIZ_ORDER, consumerOrderId, options, getConsumerOrderLineItemMapper());
		// analyzeConsumerOrderLineItemByBizOrder(resultList, consumerOrderId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ConsumerOrderLineItem> findConsumerOrderLineItemByBizOrder(String consumerOrderId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ConsumerOrderLineItem> resultList =  queryWithRange(ConsumerOrderLineItemTable.COLUMN_BIZ_ORDER, consumerOrderId, options, getConsumerOrderLineItemMapper(), start, count);
 		//analyzeConsumerOrderLineItemByBizOrder(resultList, consumerOrderId, options);
 		return resultList;
 		
 	}
 	public void analyzeConsumerOrderLineItemByBizOrder(SmartList<ConsumerOrderLineItem> resultList, String consumerOrderId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, consumerOrderId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("消费者订单行项目");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countConsumerOrderLineItemByBizOrder(String consumerOrderId,Map<String,Object> options){

 		return countWith(ConsumerOrderLineItemTable.COLUMN_BIZ_ORDER, consumerOrderId, options);
 	}
 	@Override
	public Map<String, Integer> countConsumerOrderLineItemByBizOrderIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ConsumerOrderLineItemTable.COLUMN_BIZ_ORDER, ids, options);
	}
 	
 	
		
		
		

	

	protected ConsumerOrderLineItem saveConsumerOrderLineItem(ConsumerOrderLineItem  consumerOrderLineItem){
		
		if(!consumerOrderLineItem.isChanged()){
			return consumerOrderLineItem;
		}
		

		String SQL=this.getSaveConsumerOrderLineItemSQL(consumerOrderLineItem);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderLineItemParameters(consumerOrderLineItem);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		consumerOrderLineItem.incVersion();
		return consumerOrderLineItem;

	}
	public SmartList<ConsumerOrderLineItem> saveConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderLineItemList(consumerOrderLineItemList);

		batchConsumerOrderLineItemCreate((List<ConsumerOrderLineItem>)lists[CREATE_LIST_INDEX]);

		batchConsumerOrderLineItemUpdate((List<ConsumerOrderLineItem>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList){
			if(consumerOrderLineItem.isChanged()){
				consumerOrderLineItem.incVersion();
			}


		}


		return consumerOrderLineItemList;
	}

	public SmartList<ConsumerOrderLineItem> removeConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList,Map<String,Object> options){


		super.removeList(consumerOrderLineItemList, options);

		return consumerOrderLineItemList;


	}

	protected List<Object[]> prepareConsumerOrderLineItemBatchCreateArgs(List<ConsumerOrderLineItem> consumerOrderLineItemList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList ){
			Object [] parameters = prepareConsumerOrderLineItemCreateParameters(consumerOrderLineItem);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareConsumerOrderLineItemBatchUpdateArgs(List<ConsumerOrderLineItem> consumerOrderLineItemList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList ){
			if(!consumerOrderLineItem.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderLineItemUpdateParameters(consumerOrderLineItem);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchConsumerOrderLineItemCreate(List<ConsumerOrderLineItem> consumerOrderLineItemList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderLineItemBatchCreateArgs(consumerOrderLineItemList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchConsumerOrderLineItemUpdate(List<ConsumerOrderLineItem> consumerOrderLineItemList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderLineItemBatchUpdateArgs(consumerOrderLineItemList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitConsumerOrderLineItemList(List<ConsumerOrderLineItem> consumerOrderLineItemList){

		List<ConsumerOrderLineItem> consumerOrderLineItemCreateList=new ArrayList<ConsumerOrderLineItem>();
		List<ConsumerOrderLineItem> consumerOrderLineItemUpdateList=new ArrayList<ConsumerOrderLineItem>();

		for(ConsumerOrderLineItem consumerOrderLineItem: consumerOrderLineItemList){
			if(isUpdateRequest(consumerOrderLineItem)){
				consumerOrderLineItemUpdateList.add( consumerOrderLineItem);
				continue;
			}
			consumerOrderLineItemCreateList.add(consumerOrderLineItem);
		}

		return new Object[]{consumerOrderLineItemCreateList,consumerOrderLineItemUpdateList};
	}

	protected boolean isUpdateRequest(ConsumerOrderLineItem consumerOrderLineItem){
 		return consumerOrderLineItem.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderLineItemSQL(ConsumerOrderLineItem consumerOrderLineItem){
 		if(isUpdateRequest(consumerOrderLineItem)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveConsumerOrderLineItemParameters(ConsumerOrderLineItem consumerOrderLineItem){
 		if(isUpdateRequest(consumerOrderLineItem) ){
 			return prepareConsumerOrderLineItemUpdateParameters(consumerOrderLineItem);
 		}
 		return prepareConsumerOrderLineItemCreateParameters(consumerOrderLineItem);
 	}
 	protected Object[] prepareConsumerOrderLineItemUpdateParameters(ConsumerOrderLineItem consumerOrderLineItem){
 		Object[] parameters = new Object[10];
 
 		if(consumerOrderLineItem.getBizOrder() != null){
 			parameters[0] = consumerOrderLineItem.getBizOrder().getId();
 		}
 
 		
 		parameters[1] = consumerOrderLineItem.getSkuId();
 		
 		
 		parameters[2] = consumerOrderLineItem.getSkuName();
 		
 		
 		parameters[3] = consumerOrderLineItem.getPrice();
 		
 		
 		parameters[4] = consumerOrderLineItem.getQuantity();
 		
 		
 		parameters[5] = consumerOrderLineItem.getAmount();
 		
 		
 		parameters[6] = consumerOrderLineItem.getLastUpdateTime();
 		
 		parameters[7] = consumerOrderLineItem.nextVersion();
 		parameters[8] = consumerOrderLineItem.getId();
 		parameters[9] = consumerOrderLineItem.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderLineItemCreateParameters(ConsumerOrderLineItem consumerOrderLineItem){
		Object[] parameters = new Object[8];
        if(consumerOrderLineItem.getId() == null){
          String newConsumerOrderLineItemId=getNextId();
          consumerOrderLineItem.setId(newConsumerOrderLineItemId);
        }
		parameters[0] =  consumerOrderLineItem.getId();
 
 		if(consumerOrderLineItem.getBizOrder() != null){
 			parameters[1] = consumerOrderLineItem.getBizOrder().getId();

 		}
 		
 		
 		parameters[2] = consumerOrderLineItem.getSkuId();
 		
 		
 		parameters[3] = consumerOrderLineItem.getSkuName();
 		
 		
 		parameters[4] = consumerOrderLineItem.getPrice();
 		
 		
 		parameters[5] = consumerOrderLineItem.getQuantity();
 		
 		
 		parameters[6] = consumerOrderLineItem.getAmount();
 		
 		
 		parameters[7] = consumerOrderLineItem.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected ConsumerOrderLineItem saveInternalConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem, Map<String,Object> options){

		saveConsumerOrderLineItem(consumerOrderLineItem);

 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(consumerOrderLineItem, options);
 		}
 
		
		return consumerOrderLineItem;

	}



	//======================================================================================
	

 	protected ConsumerOrderLineItem saveBizOrder(ConsumerOrderLineItem consumerOrderLineItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrderLineItem.getBizOrder() == null){
 			return consumerOrderLineItem;//do nothing when it is null
 		}

 		getConsumerOrderDAO().save(consumerOrderLineItem.getBizOrder(),options);
 		return consumerOrderLineItem;

 	}





 

	

		

	public ConsumerOrderLineItem present(ConsumerOrderLineItem consumerOrderLineItem,Map<String, Object> options){
	

		return consumerOrderLineItem;
	
	}
		

	

	protected String getTableName(){
		return ConsumerOrderLineItemTable.TABLE_NAME;
	}



	public void enhanceList(List<ConsumerOrderLineItem> consumerOrderLineItemList) {
		this.enhanceListInternal(consumerOrderLineItemList, this.getConsumerOrderLineItemMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ConsumerOrderLineItem> consumerOrderLineItemList = ownerEntity.collectRefsWithType(ConsumerOrderLineItem.INTERNAL_TYPE);
		this.enhanceList(consumerOrderLineItemList);

	}

	@Override
	public SmartList<ConsumerOrderLineItem> findConsumerOrderLineItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getConsumerOrderLineItemMapper());

	}
	@Override
	public int countConsumerOrderLineItemWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countConsumerOrderLineItemWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ConsumerOrderLineItem> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getConsumerOrderLineItemMapper());
	}

  @Override
  public Stream<ConsumerOrderLineItem> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getConsumerOrderLineItemMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateConsumerOrderLineItem executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateConsumerOrderLineItem result = new CandidateConsumerOrderLineItem();
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


