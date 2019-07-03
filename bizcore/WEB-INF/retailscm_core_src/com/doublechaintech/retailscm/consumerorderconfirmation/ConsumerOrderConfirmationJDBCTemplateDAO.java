
package com.doublechaintech.retailscm.consumerorderconfirmation;

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


public class ConsumerOrderConfirmationJDBCTemplateDAO extends RetailscmNamingServiceDAO implements ConsumerOrderConfirmationDAO{


			
		

	
	/*
	protected ConsumerOrderConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderConfirmation(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%08d";
	}
	
	public ConsumerOrderConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderConfirmation(ConsumerOrderConfirmationTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderConfirmation save(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderConfirmation, methodName, "consumerOrderConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderConfirmation(consumerOrderConfirmation,options);
	}
	public ConsumerOrderConfirmation clone(String consumerOrderConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderConfirmationTable.withId(consumerOrderConfirmationId),options);
	}
	
	protected ConsumerOrderConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderConfirmation newConsumerOrderConfirmation = loadInternalConsumerOrderConfirmation(accessKey, options);
		newConsumerOrderConfirmation.setVersion(0);
		
		

		
		saveInternalConsumerOrderConfirmation(newConsumerOrderConfirmation,options);
		
		return newConsumerOrderConfirmation;
	}
	
	
	
	

	protected void throwIfHasException(String consumerOrderConfirmationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ConsumerOrderConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String consumerOrderConfirmationId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderConfirmationId, int version)";
		assertMethodArgumentNotNull(consumerOrderConfirmationId, methodName, "consumerOrderConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderConfirmationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderConfirmationId,version);
		}
		
	
	}
	
	
	
	
	

	public ConsumerOrderConfirmation disconnectFromAll(String consumerOrderConfirmationId, int version) throws Exception{
	
		
		ConsumerOrderConfirmation consumerOrderConfirmation = loadInternalConsumerOrderConfirmation(ConsumerOrderConfirmationTable.withId(consumerOrderConfirmationId), emptyOptions());
		consumerOrderConfirmation.clearFromAll();
		this.saveConsumerOrderConfirmation(consumerOrderConfirmation);
		return consumerOrderConfirmation;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ConsumerOrderConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_confirmation";
	}
	@Override
	protected String getBeanName() {
		
		return "consumerOrderConfirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ConsumerOrderConfirmationMapper getConsumerOrderConfirmationMapper(){
		return new ConsumerOrderConfirmationMapper();
	}

	
	
	protected ConsumerOrderConfirmation extractConsumerOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ConsumerOrderConfirmation consumerOrderConfirmation = loadSingleObject(accessKey, getConsumerOrderConfirmationMapper());
			return consumerOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderConfirmationNotFoundException("ConsumerOrderConfirmation("+accessKey+") is not found!");
		}

	}

	
	

	protected ConsumerOrderConfirmation loadInternalConsumerOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderConfirmation consumerOrderConfirmation = extractConsumerOrderConfirmation(accessKey, loadOptions);

		
		return consumerOrderConfirmation;
		
	}

	
		
		
 	
		
		
		

	

	protected ConsumerOrderConfirmation saveConsumerOrderConfirmation(ConsumerOrderConfirmation  consumerOrderConfirmation){
		
		if(!consumerOrderConfirmation.isChanged()){
			return consumerOrderConfirmation;
		}
		
		
		String SQL=this.getSaveConsumerOrderConfirmationSQL(consumerOrderConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderConfirmationParameters(consumerOrderConfirmation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderConfirmation.incVersion();
		return consumerOrderConfirmation;
	
	}
	public SmartList<ConsumerOrderConfirmation> saveConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderConfirmationList(consumerOrderConfirmationList);
		
		batchConsumerOrderConfirmationCreate((List<ConsumerOrderConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderConfirmationUpdate((List<ConsumerOrderConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderConfirmation consumerOrderConfirmation:consumerOrderConfirmationList){
			if(consumerOrderConfirmation.isChanged()){
				consumerOrderConfirmation.incVersion();
			}
			
		
		}
		
		
		return consumerOrderConfirmationList;
	}

	public SmartList<ConsumerOrderConfirmation> removeConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderConfirmationList, options);
		
		return consumerOrderConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderConfirmationBatchCreateArgs(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderConfirmation consumerOrderConfirmation:consumerOrderConfirmationList ){
			Object [] parameters = prepareConsumerOrderConfirmationCreateParameters(consumerOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderConfirmationBatchUpdateArgs(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderConfirmation consumerOrderConfirmation:consumerOrderConfirmationList ){
			if(!consumerOrderConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderConfirmationUpdateParameters(consumerOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderConfirmationCreate(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderConfirmationBatchCreateArgs(consumerOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderConfirmationUpdate(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderConfirmationBatchUpdateArgs(consumerOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderConfirmationList(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		
		List<ConsumerOrderConfirmation> consumerOrderConfirmationCreateList=new ArrayList<ConsumerOrderConfirmation>();
		List<ConsumerOrderConfirmation> consumerOrderConfirmationUpdateList=new ArrayList<ConsumerOrderConfirmation>();
		
		for(ConsumerOrderConfirmation consumerOrderConfirmation: consumerOrderConfirmationList){
			if(isUpdateRequest(consumerOrderConfirmation)){
				consumerOrderConfirmationUpdateList.add( consumerOrderConfirmation);
				continue;
			}
			consumerOrderConfirmationCreateList.add(consumerOrderConfirmation);
		}
		
		return new Object[]{consumerOrderConfirmationCreateList,consumerOrderConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderConfirmation consumerOrderConfirmation){
 		return consumerOrderConfirmation.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderConfirmationSQL(ConsumerOrderConfirmation consumerOrderConfirmation){
 		if(isUpdateRequest(consumerOrderConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderConfirmationParameters(ConsumerOrderConfirmation consumerOrderConfirmation){
 		if(isUpdateRequest(consumerOrderConfirmation) ){
 			return prepareConsumerOrderConfirmationUpdateParameters(consumerOrderConfirmation);
 		}
 		return prepareConsumerOrderConfirmationCreateParameters(consumerOrderConfirmation);
 	}
 	protected Object[] prepareConsumerOrderConfirmationUpdateParameters(ConsumerOrderConfirmation consumerOrderConfirmation){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = consumerOrderConfirmation.getWho();
 		parameters[1] = consumerOrderConfirmation.getConfirmTime();		
 		parameters[2] = consumerOrderConfirmation.nextVersion();
 		parameters[3] = consumerOrderConfirmation.getId();
 		parameters[4] = consumerOrderConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderConfirmationCreateParameters(ConsumerOrderConfirmation consumerOrderConfirmation){
		Object[] parameters = new Object[3];
		String newConsumerOrderConfirmationId=getNextId();
		consumerOrderConfirmation.setId(newConsumerOrderConfirmationId);
		parameters[0] =  consumerOrderConfirmation.getId();
 
 		parameters[1] = consumerOrderConfirmation.getWho();
 		parameters[2] = consumerOrderConfirmation.getConfirmTime();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderConfirmation saveInternalConsumerOrderConfirmation(ConsumerOrderConfirmation consumerOrderConfirmation, Map<String,Object> options){
		
		saveConsumerOrderConfirmation(consumerOrderConfirmation);

		
		return consumerOrderConfirmation;
		
	}
	
	
	
	//======================================================================================
	

	

		

	public ConsumerOrderConfirmation present(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String, Object> options){
	

		return consumerOrderConfirmation;
	
	}
		

	

	protected String getTableName(){
		return ConsumerOrderConfirmationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ConsumerOrderConfirmation> consumerOrderConfirmationList) {		
		this.enhanceListInternal(consumerOrderConfirmationList, this.getConsumerOrderConfirmationMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ConsumerOrderConfirmation> consumerOrderConfirmationList = ownerEntity.collectRefsWithType(ConsumerOrderConfirmation.INTERNAL_TYPE);
		this.enhanceList(consumerOrderConfirmationList);
		
	}
	
	@Override
	public SmartList<ConsumerOrderConfirmation> findConsumerOrderConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getConsumerOrderConfirmationMapper());

	}
	@Override
	public int countConsumerOrderConfirmationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countConsumerOrderConfirmationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ConsumerOrderConfirmation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getConsumerOrderConfirmationMapper());
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


