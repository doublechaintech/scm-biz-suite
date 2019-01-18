
package com.doublechaintech.retailscm.userdomain;

import java.util.List;
import java.util.ArrayList;
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


import com.doublechaintech.retailscm.userwhitelist.UserWhiteList;
import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.userwhitelist.UserWhiteListDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class UserDomainJDBCTemplateDAO extends RetailscmNamingServiceDAO implements UserDomainDAO{


			
		
	
  	private  UserWhiteListDAO  userWhiteListDAO;
 	public void setUserWhiteListDAO(UserWhiteListDAO pUserWhiteListDAO){
 	
 		if(pUserWhiteListDAO == null){
 			throw new IllegalStateException("Do not try to set userWhiteListDAO to null.");
 		}
	 	this.userWhiteListDAO = pUserWhiteListDAO;
 	}
 	public UserWhiteListDAO getUserWhiteListDAO(){
 		if(this.userWhiteListDAO == null){
 			throw new IllegalStateException("The userWhiteListDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userWhiteListDAO;
 	}	
 	
			
		
	
  	private  SecUserDAO  secUserDAO;
 	public void setSecUserDAO(SecUserDAO pSecUserDAO){
 	
 		if(pSecUserDAO == null){
 			throw new IllegalStateException("Do not try to set secUserDAO to null.");
 		}
	 	this.secUserDAO = pSecUserDAO;
 	}
 	public SecUserDAO getSecUserDAO(){
 		if(this.secUserDAO == null){
 			throw new IllegalStateException("The secUserDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.secUserDAO;
 	}	
 	
			
		

	
	/*
	protected UserDomain load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUserDomain(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public UserDomain load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUserDomain(UserDomainTable.withId(id), options);
	}
	
	
	
	public UserDomain save(UserDomain userDomain,Map<String,Object> options){
		
		String methodName="save(UserDomain userDomain,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(userDomain, methodName, "userDomain");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUserDomain(userDomain,options);
	}
	public UserDomain clone(String userDomainId, Map<String,Object> options) throws Exception{
	
		return clone(UserDomainTable.withId(userDomainId),options);
	}
	
	protected UserDomain clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userDomainId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		UserDomain newUserDomain = loadInternalUserDomain(accessKey, options);
		newUserDomain.setVersion(0);
		
		
 		
 		if(isSaveUserWhiteListListEnabled(options)){
 			for(UserWhiteList item: newUserDomain.getUserWhiteListList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSecUserListEnabled(options)){
 			for(SecUser item: newUserDomain.getSecUserList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalUserDomain(newUserDomain,options);
		
		return newUserDomain;
	}
	
	
	
	

	protected void throwIfHasException(String userDomainId,int version,int count) throws Exception{
		if (count == 1) {
			throw new UserDomainVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserDomainNotFoundException(
					"The " + this.getTableName() + "(" + userDomainId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String userDomainId, int version) throws Exception{
	
		String methodName="delete(String userDomainId, int version)";
		assertMethodArgumentNotNull(userDomainId, methodName, "userDomainId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userDomainId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userDomainId,version);
		}
		
	
	}
	
	
	
	
	

	public UserDomain disconnectFromAll(String userDomainId, int version) throws Exception{
	
		
		UserDomain userDomain = loadInternalUserDomain(UserDomainTable.withId(userDomainId), emptyOptions());
		userDomain.clearFromAll();
		this.saveUserDomain(userDomain);
		return userDomain;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return UserDomainTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user_domain";
	}
	@Override
	protected String getBeanName() {
		
		return "userDomain";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserDomainTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractUserWhiteListListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserDomainTokens.USER_WHITE_LIST_LIST);
 	}
 	protected boolean isAnalyzeUserWhiteListListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,UserDomainTokens.USER_WHITE_LIST_LIST+".analyze");
 	}
	
	protected boolean isSaveUserWhiteListListEnabled(Map<String,Object> options){
		return checkOptions(options, UserDomainTokens.USER_WHITE_LIST_LIST);
		
 	}
 	
		
	
	protected boolean isExtractSecUserListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserDomainTokens.SEC_USER_LIST);
 	}
 	protected boolean isAnalyzeSecUserListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,UserDomainTokens.SEC_USER_LIST+".analyze");
 	}
	
	protected boolean isSaveSecUserListEnabled(Map<String,Object> options){
		return checkOptions(options, UserDomainTokens.SEC_USER_LIST);
		
 	}
 	
		

	

	protected UserDomainMapper getUserDomainMapper(){
		return new UserDomainMapper();
	}

	
	
	protected UserDomain extractUserDomain(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			UserDomain userDomain = loadSingleObject(accessKey, getUserDomainMapper());
			return userDomain;
		}catch(EmptyResultDataAccessException e){
			throw new UserDomainNotFoundException("UserDomain("+accessKey+") is not found!");
		}

	}

	
	

	protected UserDomain loadInternalUserDomain(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		UserDomain userDomain = extractUserDomain(accessKey, loadOptions);

		
		if(isExtractUserWhiteListListEnabled(loadOptions)){
	 		extractUserWhiteListList(userDomain, loadOptions);
 		}	
 		if(isAnalyzeUserWhiteListListEnabled(loadOptions)){
	 		analyzeUserWhiteListList(userDomain, loadOptions);
 		}
 		
		
		if(isExtractSecUserListEnabled(loadOptions)){
	 		extractSecUserList(userDomain, loadOptions);
 		}	
 		if(isAnalyzeSecUserListEnabled(loadOptions)){
	 		analyzeSecUserList(userDomain, loadOptions);
 		}
 		
		
		return userDomain;
		
	}

	
		
	protected void enhanceUserWhiteListList(SmartList<UserWhiteList> userWhiteListList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserDomain extractUserWhiteListList(UserDomain userDomain, Map<String,Object> options){
		
		
		if(userDomain == null){
			return null;
		}
		if(userDomain.getId() == null){
			return userDomain;
		}

		
		
		SmartList<UserWhiteList> userWhiteListList = getUserWhiteListDAO().findUserWhiteListByDomain(userDomain.getId(),options);
		if(userWhiteListList != null){
			enhanceUserWhiteListList(userWhiteListList,options);
			userDomain.setUserWhiteListList(userWhiteListList);
		}
		
		return userDomain;
	
	}	
	
	protected UserDomain analyzeUserWhiteListList(UserDomain userDomain, Map<String,Object> options){
		
		
		if(userDomain == null){
			return null;
		}
		if(userDomain.getId() == null){
			return userDomain;
		}

		
		
		SmartList<UserWhiteList> userWhiteListList = userDomain.getUserWhiteListList();
		if(userWhiteListList != null){
			getUserWhiteListDAO().analyzeUserWhiteListByDomain(userWhiteListList, userDomain.getId(), options);
			
		}
		
		return userDomain;
	
	}	
	
		
	protected void enhanceSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserDomain extractSecUserList(UserDomain userDomain, Map<String,Object> options){
		
		
		if(userDomain == null){
			return null;
		}
		if(userDomain.getId() == null){
			return userDomain;
		}

		
		
		SmartList<SecUser> secUserList = getSecUserDAO().findSecUserByDomain(userDomain.getId(),options);
		if(secUserList != null){
			enhanceSecUserList(secUserList,options);
			userDomain.setSecUserList(secUserList);
		}
		
		return userDomain;
	
	}	
	
	protected UserDomain analyzeSecUserList(UserDomain userDomain, Map<String,Object> options){
		
		
		if(userDomain == null){
			return null;
		}
		if(userDomain.getId() == null){
			return userDomain;
		}

		
		
		SmartList<SecUser> secUserList = userDomain.getSecUserList();
		if(secUserList != null){
			getSecUserDAO().analyzeSecUserByDomain(secUserList, userDomain.getId(), options);
			
		}
		
		return userDomain;
	
	}	
	
		
		
 	
		
		
		

	

	protected UserDomain saveUserDomain(UserDomain  userDomain){
		
		if(!userDomain.isChanged()){
			return userDomain;
		}
		
		
		String SQL=this.getSaveUserDomainSQL(userDomain);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserDomainParameters(userDomain);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		userDomain.incVersion();
		return userDomain;
	
	}
	public SmartList<UserDomain> saveUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserDomainList(userDomainList);
		
		batchUserDomainCreate((List<UserDomain>)lists[CREATE_LIST_INDEX]);
		
		batchUserDomainUpdate((List<UserDomain>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(UserDomain userDomain:userDomainList){
			if(userDomain.isChanged()){
				userDomain.incVersion();
			}
			
		
		}
		
		
		return userDomainList;
	}

	public SmartList<UserDomain> removeUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options){
		
		
		super.removeList(userDomainList, options);
		
		return userDomainList;
		
		
	}
	
	protected List<Object[]> prepareUserDomainBatchCreateArgs(List<UserDomain> userDomainList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserDomain userDomain:userDomainList ){
			Object [] parameters = prepareUserDomainCreateParameters(userDomain);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserDomainBatchUpdateArgs(List<UserDomain> userDomainList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserDomain userDomain:userDomainList ){
			if(!userDomain.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserDomainUpdateParameters(userDomain);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserDomainCreate(List<UserDomain> userDomainList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserDomainBatchCreateArgs(userDomainList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserDomainUpdate(List<UserDomain> userDomainList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserDomainBatchUpdateArgs(userDomainList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserDomainList(List<UserDomain> userDomainList){
		
		List<UserDomain> userDomainCreateList=new ArrayList<UserDomain>();
		List<UserDomain> userDomainUpdateList=new ArrayList<UserDomain>();
		
		for(UserDomain userDomain: userDomainList){
			if(isUpdateRequest(userDomain)){
				userDomainUpdateList.add( userDomain);
				continue;
			}
			userDomainCreateList.add(userDomain);
		}
		
		return new Object[]{userDomainCreateList,userDomainUpdateList};
	}
	
	protected boolean isUpdateRequest(UserDomain userDomain){
 		return userDomain.getVersion() > 0;
 	}
 	protected String getSaveUserDomainSQL(UserDomain userDomain){
 		if(isUpdateRequest(userDomain)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserDomainParameters(UserDomain userDomain){
 		if(isUpdateRequest(userDomain) ){
 			return prepareUserDomainUpdateParameters(userDomain);
 		}
 		return prepareUserDomainCreateParameters(userDomain);
 	}
 	protected Object[] prepareUserDomainUpdateParameters(UserDomain userDomain){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = userDomain.getName();		
 		parameters[1] = userDomain.nextVersion();
 		parameters[2] = userDomain.getId();
 		parameters[3] = userDomain.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserDomainCreateParameters(UserDomain userDomain){
		Object[] parameters = new Object[2];
		String newUserDomainId=getNextId();
		userDomain.setId(newUserDomainId);
		parameters[0] =  userDomain.getId();
 
 		parameters[1] = userDomain.getName();		
 				
 		return parameters;
 	}
 	
	protected UserDomain saveInternalUserDomain(UserDomain userDomain, Map<String,Object> options){
		
		saveUserDomain(userDomain);

		
		if(isSaveUserWhiteListListEnabled(options)){
	 		saveUserWhiteListList(userDomain, options);
	 		//removeUserWhiteListList(userDomain, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSecUserListEnabled(options)){
	 		saveSecUserList(userDomain, options);
	 		//removeSecUserList(userDomain, options);
	 		//Not delete the record
	 		
 		}		
		
		return userDomain;
		
	}
	
	
	
	//======================================================================================
	

	
	public UserDomain planToRemoveUserWhiteListList(UserDomain userDomain, String userWhiteListIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserWhiteList.DOMAIN_PROPERTY, userDomain.getId());
		key.put(UserWhiteList.ID_PROPERTY, userWhiteListIds);
		
		SmartList<UserWhiteList> externalUserWhiteListList = getUserWhiteListDAO().
				findUserWhiteListWithKey(key, options);
		if(externalUserWhiteListList == null){
			return userDomain;
		}
		if(externalUserWhiteListList.isEmpty()){
			return userDomain;
		}
		
		for(UserWhiteList userWhiteList: externalUserWhiteListList){

			userWhiteList.clearFromAll();
		}
		
		
		SmartList<UserWhiteList> userWhiteListList = userDomain.getUserWhiteListList();		
		userWhiteListList.addAllToRemoveList(externalUserWhiteListList);
		return userDomain;	
	
	}


	public UserDomain planToRemoveSecUserList(UserDomain userDomain, String secUserIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SecUser.DOMAIN_PROPERTY, userDomain.getId());
		key.put(SecUser.ID_PROPERTY, secUserIds);
		
		SmartList<SecUser> externalSecUserList = getSecUserDAO().
				findSecUserWithKey(key, options);
		if(externalSecUserList == null){
			return userDomain;
		}
		if(externalSecUserList.isEmpty()){
			return userDomain;
		}
		
		for(SecUser secUser: externalSecUserList){

			secUser.clearFromAll();
		}
		
		
		SmartList<SecUser> secUserList = userDomain.getSecUserList();		
		secUserList.addAllToRemoveList(externalSecUserList);
		return userDomain;	
	
	}



		
	protected UserDomain saveUserWhiteListList(UserDomain userDomain, Map<String,Object> options){
		
		
		
		
		SmartList<UserWhiteList> userWhiteListList = userDomain.getUserWhiteListList();
		if(userWhiteListList == null){
			//null list means nothing
			return userDomain;
		}
		SmartList<UserWhiteList> mergedUpdateUserWhiteListList = new SmartList<UserWhiteList>();
		
		
		mergedUpdateUserWhiteListList.addAll(userWhiteListList); 
		if(userWhiteListList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserWhiteListList.addAll(userWhiteListList.getToRemoveList());
			userWhiteListList.removeAll(userWhiteListList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserWhiteListDAO().saveUserWhiteListList(mergedUpdateUserWhiteListList,options);
		
		if(userWhiteListList.getToRemoveList() != null){
			userWhiteListList.removeAll(userWhiteListList.getToRemoveList());
		}
		
		
		return userDomain;
	
	}
	
	protected UserDomain removeUserWhiteListList(UserDomain userDomain, Map<String,Object> options){
	
	
		SmartList<UserWhiteList> userWhiteListList = userDomain.getUserWhiteListList();
		if(userWhiteListList == null){
			return userDomain;
		}	
	
		SmartList<UserWhiteList> toRemoveUserWhiteListList = userWhiteListList.getToRemoveList();
		
		if(toRemoveUserWhiteListList == null){
			return userDomain;
		}
		if(toRemoveUserWhiteListList.isEmpty()){
			return userDomain;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserWhiteListDAO().removeUserWhiteListList(toRemoveUserWhiteListList,options);
		
		return userDomain;
	
	}
	
	

 	
 	
	
	
	
		
	protected UserDomain saveSecUserList(UserDomain userDomain, Map<String,Object> options){
		
		
		
		
		SmartList<SecUser> secUserList = userDomain.getSecUserList();
		if(secUserList == null){
			//null list means nothing
			return userDomain;
		}
		SmartList<SecUser> mergedUpdateSecUserList = new SmartList<SecUser>();
		
		
		mergedUpdateSecUserList.addAll(secUserList); 
		if(secUserList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSecUserList.addAll(secUserList.getToRemoveList());
			secUserList.removeAll(secUserList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSecUserDAO().saveSecUserList(mergedUpdateSecUserList,options);
		
		if(secUserList.getToRemoveList() != null){
			secUserList.removeAll(secUserList.getToRemoveList());
		}
		
		
		return userDomain;
	
	}
	
	protected UserDomain removeSecUserList(UserDomain userDomain, Map<String,Object> options){
	
	
		SmartList<SecUser> secUserList = userDomain.getSecUserList();
		if(secUserList == null){
			return userDomain;
		}	
	
		SmartList<SecUser> toRemoveSecUserList = secUserList.getToRemoveList();
		
		if(toRemoveSecUserList == null){
			return userDomain;
		}
		if(toRemoveSecUserList.isEmpty()){
			return userDomain;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSecUserDAO().removeSecUserList(toRemoveSecUserList,options);
		
		return userDomain;
	
	}
	
	

 	
 	
	
	
	
		

	public UserDomain present(UserDomain userDomain,Map<String, Object> options){
	
		presentUserWhiteListList(userDomain,options);
		presentSecUserList(userDomain,options);

		return userDomain;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected UserDomain presentUserWhiteListList(
			UserDomain userDomain,
			Map<String, Object> options) {

		SmartList<UserWhiteList> userWhiteListList = userDomain.getUserWhiteListList();		
				SmartList<UserWhiteList> newList= presentSubList(userDomain.getId(),
				userWhiteListList,
				options,
				getUserWhiteListDAO()::countUserWhiteListByDomain,
				getUserWhiteListDAO()::findUserWhiteListByDomain
				);

		
		userDomain.setUserWhiteListList(newList);
		

		return userDomain;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected UserDomain presentSecUserList(
			UserDomain userDomain,
			Map<String, Object> options) {

		SmartList<SecUser> secUserList = userDomain.getSecUserList();		
				SmartList<SecUser> newList= presentSubList(userDomain.getId(),
				secUserList,
				options,
				getSecUserDAO()::countSecUserByDomain,
				getSecUserDAO()::findSecUserByDomain
				);

		
		userDomain.setSecUserList(newList);
		

		return userDomain;
	}			
		

	
    public SmartList<UserDomain> requestCandidateUserDomainForUserWhiteList(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserDomainTable.COLUMN_NAME, filterKey, pageNo, pageSize, getUserDomainMapper());
    }
		
    public SmartList<UserDomain> requestCandidateUserDomainForSecUser(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserDomainTable.COLUMN_NAME, filterKey, pageNo, pageSize, getUserDomainMapper());
    }
		

	protected String getTableName(){
		return UserDomainTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<UserDomain> userDomainList) {		
		this.enhanceListInternal(userDomainList, this.getUserDomainMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<UserDomain> userDomainList = ownerEntity.collectRefsWithType(UserDomain.INTERNAL_TYPE);
		this.enhanceList(userDomainList);
		
	}
	
	@Override
	public SmartList<UserDomain> findUserDomainWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getUserDomainMapper());

	}
	@Override
	public int countUserDomainWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countUserDomainWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<UserDomain> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getUserDomainMapper());
	}
}


