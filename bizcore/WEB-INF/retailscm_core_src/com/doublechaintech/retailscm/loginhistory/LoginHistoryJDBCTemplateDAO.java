
package com.doublechaintech.retailscm.loginhistory;

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


import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.SecUserDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class LoginHistoryJDBCTemplateDAO extends RetailscmBaseDAOImpl implements LoginHistoryDAO{

	protected SecUserDAO secUserDAO;
	public void setSecUserDAO(SecUserDAO secUserDAO){
 	
 		if(secUserDAO == null){
 			throw new IllegalStateException("Do not try to set secUserDAO to null.");
 		}
	 	this.secUserDAO = secUserDAO;
 	}
 	public SecUserDAO getSecUserDAO(){
 		if(this.secUserDAO == null){
 			throw new IllegalStateException("The secUserDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.secUserDAO;
 	}	


	/*
	protected LoginHistory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLoginHistory(accessKey, options);
	}
	*/

	public SmartList<LoginHistory> loadAll() {
	    return this.loadAll(getLoginHistoryMapper());
	}

  public Stream<LoginHistory> loadAllAsStream() {
      return this.loadAllAsStream(getLoginHistoryMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public LoginHistory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLoginHistory(LoginHistoryTable.withId(id), options);
	}

	

	public LoginHistory save(LoginHistory loginHistory,Map<String,Object> options){

		String methodName="save(LoginHistory loginHistory,Map<String,Object> options)";

		assertMethodArgumentNotNull(loginHistory, methodName, "loginHistory");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalLoginHistory(loginHistory,options);
	}
	public LoginHistory clone(String loginHistoryId, Map<String,Object> options) throws Exception{

		return clone(LoginHistoryTable.withId(loginHistoryId),options);
	}

	protected LoginHistory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String loginHistoryId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		LoginHistory newLoginHistory = loadInternalLoginHistory(accessKey, options);
		newLoginHistory.setVersion(0);
		
		


		saveInternalLoginHistory(newLoginHistory,options);

		return newLoginHistory;
	}

	



	protected void throwIfHasException(String loginHistoryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LoginHistoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LoginHistoryNotFoundException(
					"The " + this.getTableName() + "(" + loginHistoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String loginHistoryId, int version) throws Exception{

		String methodName="delete(String loginHistoryId, int version)";
		assertMethodArgumentNotNull(loginHistoryId, methodName, "loginHistoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{loginHistoryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(loginHistoryId,version);
		}


	}






	public LoginHistory disconnectFromAll(String loginHistoryId, int version) throws Exception{


		LoginHistory loginHistory = loadInternalLoginHistory(LoginHistoryTable.withId(loginHistoryId), emptyOptions());
		loginHistory.clearFromAll();
		this.saveLoginHistory(loginHistory);
		return loginHistory;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return LoginHistoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "login_history";
	}
	@Override
	protected String getBeanName() {

		return "loginHistory";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LoginHistoryTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LoginHistoryTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LoginHistoryTokens.SECUSER);
 	}
 	

 	
 
		

	

	protected LoginHistoryMapper getLoginHistoryMapper(){
		return new LoginHistoryMapper();
	}

	
	
	protected LoginHistory extractLoginHistory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LoginHistory loginHistory = loadSingleObject(accessKey, getLoginHistoryMapper());
			return loginHistory;
		}catch(EmptyResultDataAccessException e){
			throw new LoginHistoryNotFoundException("LoginHistory("+accessKey+") is not found!");
		}

	}

	
	

	protected LoginHistory loadInternalLoginHistory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LoginHistory loginHistory = extractLoginHistory(accessKey, loadOptions);
 	
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(loginHistory, loadOptions);
 		}
 
		
		return loginHistory;
		
	}

	 

 	protected LoginHistory extractSecUser(LoginHistory loginHistory, Map<String,Object> options) throws Exception{

		if(loginHistory.getSecUser() == null){
			return loginHistory;
		}
		String secUserId = loginHistory.getSecUser().getId();
		if( secUserId == null){
			return loginHistory;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			loginHistory.setSecUser(secUser);
		}
		
 		
 		return loginHistory;
 	}
 		
 
		
		
  	
 	public SmartList<LoginHistory> findLoginHistoryBySecUser(String secUserId,Map<String,Object> options){
 	
  		SmartList<LoginHistory> resultList = queryWith(LoginHistoryTable.COLUMN_SEC_USER, secUserId, options, getLoginHistoryMapper());
		// analyzeLoginHistoryBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LoginHistory> findLoginHistoryBySecUser(String secUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LoginHistory> resultList =  queryWithRange(LoginHistoryTable.COLUMN_SEC_USER, secUserId, options, getLoginHistoryMapper(), start, count);
 		//analyzeLoginHistoryBySecUser(resultList, secUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeLoginHistoryBySecUser(SmartList<LoginHistory> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(LoginHistory.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem loginTimeStatsItem = new StatsItem();
		//LoginHistory.LOGIN_TIME_PROPERTY
		loginTimeStatsItem.setDisplayName("登录历史");
		loginTimeStatsItem.setInternalName(formatKeyForDateLine(LoginHistory.LOGIN_TIME_PROPERTY));
		loginTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(LoginHistory.LOGIN_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(loginTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countLoginHistoryBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(LoginHistoryTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countLoginHistoryBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LoginHistoryTable.COLUMN_SEC_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected LoginHistory saveLoginHistory(LoginHistory  loginHistory){
		
		if(!loginHistory.isChanged()){
			return loginHistory;
		}
		

		String SQL=this.getSaveLoginHistorySQL(loginHistory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLoginHistoryParameters(loginHistory);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		loginHistory.incVersion();
		return loginHistory;

	}
	public SmartList<LoginHistory> saveLoginHistoryList(SmartList<LoginHistory> loginHistoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLoginHistoryList(loginHistoryList);

		batchLoginHistoryCreate((List<LoginHistory>)lists[CREATE_LIST_INDEX]);

		batchLoginHistoryUpdate((List<LoginHistory>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(LoginHistory loginHistory:loginHistoryList){
			if(loginHistory.isChanged()){
				loginHistory.incVersion();
			}


		}


		return loginHistoryList;
	}

	public SmartList<LoginHistory> removeLoginHistoryList(SmartList<LoginHistory> loginHistoryList,Map<String,Object> options){


		super.removeList(loginHistoryList, options);

		return loginHistoryList;


	}

	protected List<Object[]> prepareLoginHistoryBatchCreateArgs(List<LoginHistory> loginHistoryList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LoginHistory loginHistory:loginHistoryList ){
			Object [] parameters = prepareLoginHistoryCreateParameters(loginHistory);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareLoginHistoryBatchUpdateArgs(List<LoginHistory> loginHistoryList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LoginHistory loginHistory:loginHistoryList ){
			if(!loginHistory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLoginHistoryUpdateParameters(loginHistory);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchLoginHistoryCreate(List<LoginHistory> loginHistoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLoginHistoryBatchCreateArgs(loginHistoryList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchLoginHistoryUpdate(List<LoginHistory> loginHistoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLoginHistoryBatchUpdateArgs(loginHistoryList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitLoginHistoryList(List<LoginHistory> loginHistoryList){

		List<LoginHistory> loginHistoryCreateList=new ArrayList<LoginHistory>();
		List<LoginHistory> loginHistoryUpdateList=new ArrayList<LoginHistory>();

		for(LoginHistory loginHistory: loginHistoryList){
			if(isUpdateRequest(loginHistory)){
				loginHistoryUpdateList.add( loginHistory);
				continue;
			}
			loginHistoryCreateList.add(loginHistory);
		}

		return new Object[]{loginHistoryCreateList,loginHistoryUpdateList};
	}

	protected boolean isUpdateRequest(LoginHistory loginHistory){
 		return loginHistory.getVersion() > 0;
 	}
 	protected String getSaveLoginHistorySQL(LoginHistory loginHistory){
 		if(isUpdateRequest(loginHistory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveLoginHistoryParameters(LoginHistory loginHistory){
 		if(isUpdateRequest(loginHistory) ){
 			return prepareLoginHistoryUpdateParameters(loginHistory);
 		}
 		return prepareLoginHistoryCreateParameters(loginHistory);
 	}
 	protected Object[] prepareLoginHistoryUpdateParameters(LoginHistory loginHistory){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = loginHistory.getLoginTime();
 		
 		
 		parameters[1] = loginHistory.getFromIp();
 		
 		
 		parameters[2] = loginHistory.getDescription();
 		
 		if(loginHistory.getSecUser() != null){
 			parameters[3] = loginHistory.getSecUser().getId();
 		}
 
 		parameters[4] = loginHistory.nextVersion();
 		parameters[5] = loginHistory.getId();
 		parameters[6] = loginHistory.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareLoginHistoryCreateParameters(LoginHistory loginHistory){
		Object[] parameters = new Object[5];
        if(loginHistory.getId() == null){
          String newLoginHistoryId=getNextId();
          loginHistory.setId(newLoginHistoryId);
        }
		parameters[0] =  loginHistory.getId();
 
 		
 		parameters[1] = loginHistory.getLoginTime();
 		
 		
 		parameters[2] = loginHistory.getFromIp();
 		
 		
 		parameters[3] = loginHistory.getDescription();
 		
 		if(loginHistory.getSecUser() != null){
 			parameters[4] = loginHistory.getSecUser().getId();

 		}
 		

 		return parameters;
 	}

	protected LoginHistory saveInternalLoginHistory(LoginHistory loginHistory, Map<String,Object> options){

		saveLoginHistory(loginHistory);

 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(loginHistory, options);
 		}
 
		
		return loginHistory;

	}



	//======================================================================================
	

 	protected LoginHistory saveSecUser(LoginHistory loginHistory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(loginHistory.getSecUser() == null){
 			return loginHistory;//do nothing when it is null
 		}

 		getSecUserDAO().save(loginHistory.getSecUser(),options);
 		return loginHistory;

 	}





 

	

		

	public LoginHistory present(LoginHistory loginHistory,Map<String, Object> options){
	

		return loginHistory;
	
	}
		

	

	protected String getTableName(){
		return LoginHistoryTable.TABLE_NAME;
	}



	public void enhanceList(List<LoginHistory> loginHistoryList) {
		this.enhanceListInternal(loginHistoryList, this.getLoginHistoryMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LoginHistory> loginHistoryList = ownerEntity.collectRefsWithType(LoginHistory.INTERNAL_TYPE);
		this.enhanceList(loginHistoryList);

	}

	@Override
	public SmartList<LoginHistory> findLoginHistoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getLoginHistoryMapper());

	}
	@Override
	public int countLoginHistoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countLoginHistoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<LoginHistory> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLoginHistoryMapper());
	}

  @Override
  public Stream<LoginHistory> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getLoginHistoryMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateLoginHistory executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateLoginHistory result = new CandidateLoginHistory();
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


