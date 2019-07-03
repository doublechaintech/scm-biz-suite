
package com.doublechaintech.retailscm.consumerorderdelivery;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
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






import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ConsumerOrderDeliveryJDBCTemplateDAO extends RetailscmNamingServiceDAO implements ConsumerOrderDeliveryDAO{


			
		

	
	/*
	protected ConsumerOrderDelivery load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderDelivery(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%08d";
	}
	
	public ConsumerOrderDelivery load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderDelivery(ConsumerOrderDeliveryTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderDelivery save(ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderDelivery, methodName, "consumerOrderDelivery");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderDelivery(consumerOrderDelivery,options);
	}
	public ConsumerOrderDelivery clone(String consumerOrderDeliveryId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderDeliveryTable.withId(consumerOrderDeliveryId),options);
	}
	
	protected ConsumerOrderDelivery clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderDeliveryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderDelivery newConsumerOrderDelivery = loadInternalConsumerOrderDelivery(accessKey, options);
		newConsumerOrderDelivery.setVersion(0);
		
		

		
		saveInternalConsumerOrderDelivery(newConsumerOrderDelivery,options);
		
		return newConsumerOrderDelivery;
	}
	
	
	
	

	protected void throwIfHasException(String consumerOrderDeliveryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ConsumerOrderDeliveryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderDeliveryNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderDeliveryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String consumerOrderDeliveryId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderDeliveryId, int version)";
		assertMethodArgumentNotNull(consumerOrderDeliveryId, methodName, "consumerOrderDeliveryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderDeliveryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderDeliveryId,version);
		}
		
	
	}
	
	
	
	
	

	public ConsumerOrderDelivery disconnectFromAll(String consumerOrderDeliveryId, int version) throws Exception{
	
		
		ConsumerOrderDelivery consumerOrderDelivery = loadInternalConsumerOrderDelivery(ConsumerOrderDeliveryTable.withId(consumerOrderDeliveryId), emptyOptions());
		consumerOrderDelivery.clearFromAll();
		this.saveConsumerOrderDelivery(consumerOrderDelivery);
		return consumerOrderDelivery;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ConsumerOrderDeliveryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_delivery";
	}
	@Override
	protected String getBeanName() {
		
		return "consumerOrderDelivery";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderDeliveryTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ConsumerOrderDeliveryMapper getConsumerOrderDeliveryMapper(){
		return new ConsumerOrderDeliveryMapper();
	}

	
	
	protected ConsumerOrderDelivery extractConsumerOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ConsumerOrderDelivery consumerOrderDelivery = loadSingleObject(accessKey, getConsumerOrderDeliveryMapper());
			return consumerOrderDelivery;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderDeliveryNotFoundException("ConsumerOrderDelivery("+accessKey+") is not found!");
		}

	}

	
	

	protected ConsumerOrderDelivery loadInternalConsumerOrderDelivery(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderDelivery consumerOrderDelivery = extractConsumerOrderDelivery(accessKey, loadOptions);

		
		return consumerOrderDelivery;
		
	}

	
		
		
 	
		
		
		

	

	protected ConsumerOrderDelivery saveConsumerOrderDelivery(ConsumerOrderDelivery  consumerOrderDelivery){
		
		if(!consumerOrderDelivery.isChanged()){
			return consumerOrderDelivery;
		}
		
		
		String SQL=this.getSaveConsumerOrderDeliverySQL(consumerOrderDelivery);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderDeliveryParameters(consumerOrderDelivery);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderDelivery.incVersion();
		return consumerOrderDelivery;
	
	}
	public SmartList<ConsumerOrderDelivery> saveConsumerOrderDeliveryList(SmartList<ConsumerOrderDelivery> consumerOrderDeliveryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderDeliveryList(consumerOrderDeliveryList);
		
		batchConsumerOrderDeliveryCreate((List<ConsumerOrderDelivery>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderDeliveryUpdate((List<ConsumerOrderDelivery>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderDelivery consumerOrderDelivery:consumerOrderDeliveryList){
			if(consumerOrderDelivery.isChanged()){
				consumerOrderDelivery.incVersion();
			}
			
		
		}
		
		
		return consumerOrderDeliveryList;
	}

	public SmartList<ConsumerOrderDelivery> removeConsumerOrderDeliveryList(SmartList<ConsumerOrderDelivery> consumerOrderDeliveryList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderDeliveryList, options);
		
		return consumerOrderDeliveryList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderDeliveryBatchCreateArgs(List<ConsumerOrderDelivery> consumerOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderDelivery consumerOrderDelivery:consumerOrderDeliveryList ){
			Object [] parameters = prepareConsumerOrderDeliveryCreateParameters(consumerOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderDeliveryBatchUpdateArgs(List<ConsumerOrderDelivery> consumerOrderDeliveryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderDelivery consumerOrderDelivery:consumerOrderDeliveryList ){
			if(!consumerOrderDelivery.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderDeliveryUpdateParameters(consumerOrderDelivery);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderDeliveryCreate(List<ConsumerOrderDelivery> consumerOrderDeliveryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderDeliveryBatchCreateArgs(consumerOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderDeliveryUpdate(List<ConsumerOrderDelivery> consumerOrderDeliveryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderDeliveryBatchUpdateArgs(consumerOrderDeliveryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderDeliveryList(List<ConsumerOrderDelivery> consumerOrderDeliveryList){
		
		List<ConsumerOrderDelivery> consumerOrderDeliveryCreateList=new ArrayList<ConsumerOrderDelivery>();
		List<ConsumerOrderDelivery> consumerOrderDeliveryUpdateList=new ArrayList<ConsumerOrderDelivery>();
		
		for(ConsumerOrderDelivery consumerOrderDelivery: consumerOrderDeliveryList){
			if(isUpdateRequest(consumerOrderDelivery)){
				consumerOrderDeliveryUpdateList.add( consumerOrderDelivery);
				continue;
			}
			consumerOrderDeliveryCreateList.add(consumerOrderDelivery);
		}
		
		return new Object[]{consumerOrderDeliveryCreateList,consumerOrderDeliveryUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderDelivery consumerOrderDelivery){
 		return consumerOrderDelivery.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderDeliverySQL(ConsumerOrderDelivery consumerOrderDelivery){
 		if(isUpdateRequest(consumerOrderDelivery)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderDeliveryParameters(ConsumerOrderDelivery consumerOrderDelivery){
 		if(isUpdateRequest(consumerOrderDelivery) ){
 			return prepareConsumerOrderDeliveryUpdateParameters(consumerOrderDelivery);
 		}
 		return prepareConsumerOrderDeliveryCreateParameters(consumerOrderDelivery);
 	}
 	protected Object[] prepareConsumerOrderDeliveryUpdateParameters(ConsumerOrderDelivery consumerOrderDelivery){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = consumerOrderDelivery.getWho();
 		parameters[1] = consumerOrderDelivery.getDeliveryTime();		
 		parameters[2] = consumerOrderDelivery.nextVersion();
 		parameters[3] = consumerOrderDelivery.getId();
 		parameters[4] = consumerOrderDelivery.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderDeliveryCreateParameters(ConsumerOrderDelivery consumerOrderDelivery){
		Object[] parameters = new Object[3];
		String newConsumerOrderDeliveryId=getNextId();
		consumerOrderDelivery.setId(newConsumerOrderDeliveryId);
		parameters[0] =  consumerOrderDelivery.getId();
 
 		parameters[1] = consumerOrderDelivery.getWho();
 		parameters[2] = consumerOrderDelivery.getDeliveryTime();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderDelivery saveInternalConsumerOrderDelivery(ConsumerOrderDelivery consumerOrderDelivery, Map<String,Object> options){
		
		saveConsumerOrderDelivery(consumerOrderDelivery);

		
		return consumerOrderDelivery;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public ConsumerOrderDelivery present(ConsumerOrderDelivery consumerOrderDelivery,Map<String, Object> options){
	

		return consumerOrderDelivery;
	
	}
		

	

	protected String getTableName(){
		return ConsumerOrderDeliveryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ConsumerOrderDelivery> consumerOrderDeliveryList) {		
		this.enhanceListInternal(consumerOrderDeliveryList, this.getConsumerOrderDeliveryMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ConsumerOrderDelivery> consumerOrderDeliveryList = ownerEntity.collectRefsWithType(ConsumerOrderDelivery.INTERNAL_TYPE);
		this.enhanceList(consumerOrderDeliveryList);
		
	}
	
	@Override
	public SmartList<ConsumerOrderDelivery> findConsumerOrderDeliveryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getConsumerOrderDeliveryMapper());

	}
	@Override
	public int countConsumerOrderDeliveryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countConsumerOrderDeliveryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ConsumerOrderDelivery> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getConsumerOrderDeliveryMapper());
	}
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


