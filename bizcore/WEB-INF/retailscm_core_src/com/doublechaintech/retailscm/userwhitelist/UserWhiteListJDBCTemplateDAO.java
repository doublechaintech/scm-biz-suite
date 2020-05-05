
package com.doublechaintech.retailscm.userwhitelist;

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


import com.doublechaintech.retailscm.userdomain.UserDomain;

import com.doublechaintech.retailscm.userdomain.UserDomainDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class UserWhiteListJDBCTemplateDAO extends RetailscmBaseDAOImpl implements UserWhiteListDAO{

	protected UserDomainDAO userDomainDAO;
	public void setUserDomainDAO(UserDomainDAO userDomainDAO){
 	
 		if(userDomainDAO == null){
 			throw new IllegalStateException("Do not try to set userDomainDAO to null.");
 		}
	 	this.userDomainDAO = userDomainDAO;
 	}
 	public UserDomainDAO getUserDomainDAO(){
 		if(this.userDomainDAO == null){
 			throw new IllegalStateException("The userDomainDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userDomainDAO;
 	}	

	
	/*
	protected UserWhiteList load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUserWhiteList(accessKey, options);
	}
	*/
	
	public SmartList<UserWhiteList> loadAll() {
	    return this.loadAll(getUserWhiteListMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public UserWhiteList load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUserWhiteList(UserWhiteListTable.withId(id), options);
	}
	
	
	
	public UserWhiteList save(UserWhiteList userWhiteList,Map<String,Object> options){
		
		String methodName="save(UserWhiteList userWhiteList,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(userWhiteList, methodName, "userWhiteList");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUserWhiteList(userWhiteList,options);
	}
	public UserWhiteList clone(String userWhiteListId, Map<String,Object> options) throws Exception{
	
		return clone(UserWhiteListTable.withId(userWhiteListId),options);
	}
	
	protected UserWhiteList clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userWhiteListId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		UserWhiteList newUserWhiteList = loadInternalUserWhiteList(accessKey, options);
		newUserWhiteList.setVersion(0);
		
		

		
		saveInternalUserWhiteList(newUserWhiteList,options);
		
		return newUserWhiteList;
	}
	
	
	
	

	protected void throwIfHasException(String userWhiteListId,int version,int count) throws Exception{
		if (count == 1) {
			throw new UserWhiteListVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserWhiteListNotFoundException(
					"The " + this.getTableName() + "(" + userWhiteListId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String userWhiteListId, int version) throws Exception{
	
		String methodName="delete(String userWhiteListId, int version)";
		assertMethodArgumentNotNull(userWhiteListId, methodName, "userWhiteListId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userWhiteListId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userWhiteListId,version);
		}
		
	
	}
	
	
	
	
	

	public UserWhiteList disconnectFromAll(String userWhiteListId, int version) throws Exception{
	
		
		UserWhiteList userWhiteList = loadInternalUserWhiteList(UserWhiteListTable.withId(userWhiteListId), emptyOptions());
		userWhiteList.clearFromAll();
		this.saveUserWhiteList(userWhiteList);
		return userWhiteList;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return UserWhiteListTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user_white_list";
	}
	@Override
	protected String getBeanName() {
		
		return "userWhiteList";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserWhiteListTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractDomainEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserWhiteListTokens.DOMAIN);
 	}

 	protected boolean isSaveDomainEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserWhiteListTokens.DOMAIN);
 	}
 	

 	
 
		

	

	protected UserWhiteListMapper getUserWhiteListMapper(){
		return new UserWhiteListMapper();
	}

	
	
	protected UserWhiteList extractUserWhiteList(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			UserWhiteList userWhiteList = loadSingleObject(accessKey, getUserWhiteListMapper());
			return userWhiteList;
		}catch(EmptyResultDataAccessException e){
			throw new UserWhiteListNotFoundException("UserWhiteList("+accessKey+") is not found!");
		}

	}

	
	

	protected UserWhiteList loadInternalUserWhiteList(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		UserWhiteList userWhiteList = extractUserWhiteList(accessKey, loadOptions);
 	
 		if(isExtractDomainEnabled(loadOptions)){
	 		extractDomain(userWhiteList, loadOptions);
 		}
 
		
		return userWhiteList;
		
	}

	 

 	protected UserWhiteList extractDomain(UserWhiteList userWhiteList, Map<String,Object> options) throws Exception{

		if(userWhiteList.getDomain() == null){
			return userWhiteList;
		}
		String domainId = userWhiteList.getDomain().getId();
		if( domainId == null){
			return userWhiteList;
		}
		UserDomain domain = getUserDomainDAO().load(domainId,options);
		if(domain != null){
			userWhiteList.setDomain(domain);
		}
		
 		
 		return userWhiteList;
 	}
 		
 
		
		
  	
 	public SmartList<UserWhiteList> findUserWhiteListByDomain(String userDomainId,Map<String,Object> options){
 	
  		SmartList<UserWhiteList> resultList = queryWith(UserWhiteListTable.COLUMN_DOMAIN, userDomainId, options, getUserWhiteListMapper());
		// analyzeUserWhiteListByDomain(resultList, userDomainId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<UserWhiteList> findUserWhiteListByDomain(String userDomainId, int start, int count,Map<String,Object> options){
 		
 		SmartList<UserWhiteList> resultList =  queryWithRange(UserWhiteListTable.COLUMN_DOMAIN, userDomainId, options, getUserWhiteListMapper(), start, count);
 		//analyzeUserWhiteListByDomain(resultList, userDomainId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserWhiteListByDomain(SmartList<UserWhiteList> resultList, String userDomainId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countUserWhiteListByDomain(String userDomainId,Map<String,Object> options){

 		return countWith(UserWhiteListTable.COLUMN_DOMAIN, userDomainId, options);
 	}
 	@Override
	public Map<String, Integer> countUserWhiteListByDomainIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserWhiteListTable.COLUMN_DOMAIN, ids, options);
	}
 	
 	
		
		
		

	

	protected UserWhiteList saveUserWhiteList(UserWhiteList  userWhiteList){
		
		if(!userWhiteList.isChanged()){
			return userWhiteList;
		}
		
		
		String SQL=this.getSaveUserWhiteListSQL(userWhiteList);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserWhiteListParameters(userWhiteList);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		userWhiteList.incVersion();
		return userWhiteList;
	
	}
	public SmartList<UserWhiteList> saveUserWhiteListList(SmartList<UserWhiteList> userWhiteListList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserWhiteListList(userWhiteListList);
		
		batchUserWhiteListCreate((List<UserWhiteList>)lists[CREATE_LIST_INDEX]);
		
		batchUserWhiteListUpdate((List<UserWhiteList>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(UserWhiteList userWhiteList:userWhiteListList){
			if(userWhiteList.isChanged()){
				userWhiteList.incVersion();
			}
			
		
		}
		
		
		return userWhiteListList;
	}

	public SmartList<UserWhiteList> removeUserWhiteListList(SmartList<UserWhiteList> userWhiteListList,Map<String,Object> options){
		
		
		super.removeList(userWhiteListList, options);
		
		return userWhiteListList;
		
		
	}
	
	protected List<Object[]> prepareUserWhiteListBatchCreateArgs(List<UserWhiteList> userWhiteListList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserWhiteList userWhiteList:userWhiteListList ){
			Object [] parameters = prepareUserWhiteListCreateParameters(userWhiteList);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserWhiteListBatchUpdateArgs(List<UserWhiteList> userWhiteListList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserWhiteList userWhiteList:userWhiteListList ){
			if(!userWhiteList.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserWhiteListUpdateParameters(userWhiteList);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserWhiteListCreate(List<UserWhiteList> userWhiteListList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserWhiteListBatchCreateArgs(userWhiteListList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserWhiteListUpdate(List<UserWhiteList> userWhiteListList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserWhiteListBatchUpdateArgs(userWhiteListList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserWhiteListList(List<UserWhiteList> userWhiteListList){
		
		List<UserWhiteList> userWhiteListCreateList=new ArrayList<UserWhiteList>();
		List<UserWhiteList> userWhiteListUpdateList=new ArrayList<UserWhiteList>();
		
		for(UserWhiteList userWhiteList: userWhiteListList){
			if(isUpdateRequest(userWhiteList)){
				userWhiteListUpdateList.add( userWhiteList);
				continue;
			}
			userWhiteListCreateList.add(userWhiteList);
		}
		
		return new Object[]{userWhiteListCreateList,userWhiteListUpdateList};
	}
	
	protected boolean isUpdateRequest(UserWhiteList userWhiteList){
 		return userWhiteList.getVersion() > 0;
 	}
 	protected String getSaveUserWhiteListSQL(UserWhiteList userWhiteList){
 		if(isUpdateRequest(userWhiteList)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserWhiteListParameters(UserWhiteList userWhiteList){
 		if(isUpdateRequest(userWhiteList) ){
 			return prepareUserWhiteListUpdateParameters(userWhiteList);
 		}
 		return prepareUserWhiteListCreateParameters(userWhiteList);
 	}
 	protected Object[] prepareUserWhiteListUpdateParameters(UserWhiteList userWhiteList){
 		Object[] parameters = new Object[6];
 
 		
 		parameters[0] = userWhiteList.getUserIdentity();
 		
 		
 		parameters[1] = userWhiteList.getUserSpecialFunctions();
 		 	
 		if(userWhiteList.getDomain() != null){
 			parameters[2] = userWhiteList.getDomain().getId();
 		}
 		
 		parameters[3] = userWhiteList.nextVersion();
 		parameters[4] = userWhiteList.getId();
 		parameters[5] = userWhiteList.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserWhiteListCreateParameters(UserWhiteList userWhiteList){
		Object[] parameters = new Object[4];
		String newUserWhiteListId=getNextId();
		userWhiteList.setId(newUserWhiteListId);
		parameters[0] =  userWhiteList.getId();
 
 		
 		parameters[1] = userWhiteList.getUserIdentity();
 		
 		
 		parameters[2] = userWhiteList.getUserSpecialFunctions();
 		 	
 		if(userWhiteList.getDomain() != null){
 			parameters[3] = userWhiteList.getDomain().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected UserWhiteList saveInternalUserWhiteList(UserWhiteList userWhiteList, Map<String,Object> options){
		
		saveUserWhiteList(userWhiteList);
 	
 		if(isSaveDomainEnabled(options)){
	 		saveDomain(userWhiteList, options);
 		}
 
		
		return userWhiteList;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected UserWhiteList saveDomain(UserWhiteList userWhiteList, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userWhiteList.getDomain() == null){
 			return userWhiteList;//do nothing when it is null
 		}
 		
 		getUserDomainDAO().save(userWhiteList.getDomain(),options);
 		return userWhiteList;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public UserWhiteList present(UserWhiteList userWhiteList,Map<String, Object> options){
	

		return userWhiteList;
	
	}
		

	

	protected String getTableName(){
		return UserWhiteListTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<UserWhiteList> userWhiteListList) {		
		this.enhanceListInternal(userWhiteListList, this.getUserWhiteListMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<UserWhiteList> userWhiteListList = ownerEntity.collectRefsWithType(UserWhiteList.INTERNAL_TYPE);
		this.enhanceList(userWhiteListList);
		
	}
	
	@Override
	public SmartList<UserWhiteList> findUserWhiteListWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getUserWhiteListMapper());

	}
	@Override
	public int countUserWhiteListWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countUserWhiteListWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<UserWhiteList> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getUserWhiteListMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateUserWhiteList executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateUserWhiteList result = new CandidateUserWhiteList();
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


