
package com.doublechaintech.retailscm.secuser;

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


import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.secuserblocking.SecUserBlocking;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;

import com.doublechaintech.retailscm.userdomain.UserDomainDAO;
import com.doublechaintech.retailscm.secuserblocking.SecUserBlockingDAO;
import com.doublechaintech.retailscm.userapp.UserAppDAO;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class SecUserJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SecUserDAO{
 
 	
 	private  SecUserBlockingDAO  secUserBlockingDAO;
 	public void setSecUserBlockingDAO(SecUserBlockingDAO secUserBlockingDAO){
	 	this.secUserBlockingDAO = secUserBlockingDAO;
 	}
 	public SecUserBlockingDAO getSecUserBlockingDAO(){
	 	return this.secUserBlockingDAO;
 	}
 
 	
 	private  UserDomainDAO  userDomainDAO;
 	public void setUserDomainDAO(UserDomainDAO userDomainDAO){
	 	this.userDomainDAO = userDomainDAO;
 	}
 	public UserDomainDAO getUserDomainDAO(){
	 	return this.userDomainDAO;
 	}


			
		
	
  	private  UserAppDAO  userAppDAO;
 	public void setUserAppDAO(UserAppDAO pUserAppDAO){
 	
 		if(pUserAppDAO == null){
 			throw new IllegalStateException("Do not try to set userAppDAO to null.");
 		}
	 	this.userAppDAO = pUserAppDAO;
 	}
 	public UserAppDAO getUserAppDAO(){
 		if(this.userAppDAO == null){
 			throw new IllegalStateException("The userAppDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAppDAO;
 	}	
 	
			
		
	
  	private  LoginHistoryDAO  loginHistoryDAO;
 	public void setLoginHistoryDAO(LoginHistoryDAO pLoginHistoryDAO){
 	
 		if(pLoginHistoryDAO == null){
 			throw new IllegalStateException("Do not try to set loginHistoryDAO to null.");
 		}
	 	this.loginHistoryDAO = pLoginHistoryDAO;
 	}
 	public LoginHistoryDAO getLoginHistoryDAO(){
 		if(this.loginHistoryDAO == null){
 			throw new IllegalStateException("The loginHistoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.loginHistoryDAO;
 	}	
 	
			
		

	
	/*
	protected SecUser load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SecUser load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withId(id), options);
	}
	
	
	
	public SecUser loadByLogin(String login,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withLogin( login), options);
	}
	
	
	public SecUser loadByEmail(String email,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withEmail( email), options);
	}
	
	
	public SecUser loadByMobile(String mobile,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withMobile( mobile), options);
	}
	
	
	public SecUser save(SecUser secUser,Map<String,Object> options){
		
		String methodName="save(SecUser secUser,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(secUser, methodName, "secUser");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSecUser(secUser,options);
	}
	public SecUser clone(String secUserId, Map<String,Object> options) throws Exception{
	
		return clone(SecUserTable.withId(secUserId),options);
	}
	
	protected SecUser clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String secUserId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SecUser newSecUser = loadInternalSecUser(accessKey, options);
		newSecUser.setVersion(0);
		
		
 		
 		if(isSaveUserAppListEnabled(options)){
 			for(UserApp item: newSecUser.getUserAppList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveLoginHistoryListEnabled(options)){
 			for(LoginHistory item: newSecUser.getLoginHistoryList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSecUser(newSecUser,options);
		
		return newSecUser;
	}
	
	
	
	public SecUser cloneByLogin(String login,Map<String,Object> options) throws Exception{
		return clone(SecUserTable.withLogin( login), options);
	}
	
	
	public SecUser cloneByEmail(String email,Map<String,Object> options) throws Exception{
		return clone(SecUserTable.withEmail( email), options);
	}
	
	
	public SecUser cloneByMobile(String mobile,Map<String,Object> options) throws Exception{
		return clone(SecUserTable.withMobile( mobile), options);
	}
	
	
	

	protected void throwIfHasException(String secUserId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SecUserVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SecUserNotFoundException(
					"The " + this.getTableName() + "(" + secUserId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String secUserId, int version) throws Exception{
	
		String methodName="delete(String secUserId, int version)";
		assertMethodArgumentNotNull(secUserId, methodName, "secUserId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{secUserId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(secUserId,version);
		}
		
	
	}
	
	
	
	
	

	public SecUser disconnectFromAll(String secUserId, int version) throws Exception{
	
		
		SecUser secUser = loadInternalSecUser(SecUserTable.withId(secUserId), emptyOptions());
		secUser.clearFromAll();
		this.saveSecUser(secUser);
		return secUser;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SecUserTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "sec_user";
	}
	@Override
	protected String getBeanName() {
		
		return "secUser";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SecUserTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractDomainEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SecUserTokens.DOMAIN);
 	}

 	protected boolean isSaveDomainEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SecUserTokens.DOMAIN);
 	}
 	

 	
  

 	protected boolean isExtractBlockingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SecUserTokens.BLOCKING);
 	}

 	protected boolean isSaveBlockingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SecUserTokens.BLOCKING);
 	}
 	

 	
 
		
	
	protected boolean isExtractUserAppListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SecUserTokens.USER_APP_LIST);
		
 	}

	protected boolean isSaveUserAppListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserTokens.USER_APP_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractLoginHistoryListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SecUserTokens.LOGIN_HISTORY_LIST);
		
 	}

	protected boolean isSaveLoginHistoryListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserTokens.LOGIN_HISTORY_LIST);
		
 	}
 	
 	
			
		

	

	protected SecUserMapper getSecUserMapper(){
		return new SecUserMapper();
	}

	
	
	protected SecUser extractSecUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SecUser secUser = loadSingleObject(accessKey, getSecUserMapper());
			return secUser;
		}catch(EmptyResultDataAccessException e){
			throw new SecUserNotFoundException("SecUser("+accessKey+") is not found!");
		}

	}

	
	

	protected SecUser loadInternalSecUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SecUser secUser = extractSecUser(accessKey, loadOptions);
 	
 		if(isExtractDomainEnabled(loadOptions)){
	 		extractDomain(secUser, loadOptions);
 		}
  	
 		if(isExtractBlockingEnabled(loadOptions)){
	 		extractBlocking(secUser, loadOptions);
 		}
 
		
		if(isExtractUserAppListEnabled(loadOptions)){
	 		extractUserAppList(secUser, loadOptions);
 		}		
		
		if(isExtractLoginHistoryListEnabled(loadOptions)){
	 		extractLoginHistoryList(secUser, loadOptions);
 		}		
		
		return secUser;
		
	}



	
	
	 

 	protected SecUser extractDomain(SecUser secUser, Map<String,Object> options) throws Exception{

		if(secUser.getDomain() == null){
			return secUser;
		}
		String domainId = secUser.getDomain().getId();
		if( domainId == null){
			return secUser;
		}
		UserDomain domain = getUserDomainDAO().load(domainId,options);
		if(domain != null){
			secUser.setDomain(domain);
		}
		
 		
 		return secUser;
 	}
 		
  

 	protected SecUser extractBlocking(SecUser secUser, Map<String,Object> options) throws Exception{

		if(secUser.getBlocking() == null){
			return secUser;
		}
		String blockingId = secUser.getBlocking().getId();
		if( blockingId == null){
			return secUser;
		}
		SecUserBlocking blocking = getSecUserBlockingDAO().load(blockingId,options);
		if(blocking != null){
			secUser.setBlocking(blocking);
		}
		
 		
 		return secUser;
 	}
 		
 
		
	protected void enhanceUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected SecUser extractUserAppList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<UserApp> userAppList = getUserAppDAO().findUserAppBySecUser(secUser.getId(),options);
		if(userAppList != null){
			enhanceUserAppList(userAppList,options);
			secUser.setUserAppList(userAppList);
		}
		
		return secUser;
	
	}	
		
	protected void enhanceLoginHistoryList(SmartList<LoginHistory> loginHistoryList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected SecUser extractLoginHistoryList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<LoginHistory> loginHistoryList = getLoginHistoryDAO().findLoginHistoryBySecUser(secUser.getId(),options);
		if(loginHistoryList != null){
			enhanceLoginHistoryList(loginHistoryList,options);
			secUser.setLoginHistoryList(loginHistoryList);
		}
		
		return secUser;
	
	}	
		
		
  	
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId,Map<String,Object> options){
 	
  		SmartList<SecUser> resultList = queryWith(SecUserTable.COLUMN_DOMAIN, userDomainId, options, getSecUserMapper());
		analyzeSecUserByDomain(resultList, userDomainId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SecUser> resultList =  queryWithRange(SecUserTable.COLUMN_DOMAIN, userDomainId, options, getSecUserMapper(), start, count);
 		analyzeSecUserByDomain(resultList, userDomainId, options);
 		return resultList;
 		
 	}
 	public void analyzeSecUserByDomain(SmartList<SecUser> resultList, String userDomainId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SecUser.DOMAIN_PROPERTY, userDomainId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem verificationCodeExpireStatsItem = new StatsItem();
		//SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY
		verificationCodeExpireStatsItem.setDisplayName("SEC的用户");
		verificationCodeExpireStatsItem.setInternalName(formatKeyForDateLine(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY));
		verificationCodeExpireStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY),filterKey,emptyOptions));
		info.addItem(verificationCodeExpireStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countSecUserByDomain(String userDomainId,Map<String,Object> options){

 		return countWith(SecUserTable.COLUMN_DOMAIN, userDomainId, options);
 	}
 	@Override
	public Map<String, Integer> countSecUserByDomainIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SecUserTable.COLUMN_DOMAIN, ids, options);
	}
 	
  	
 	public SmartList<SecUser> findSecUserByBlocking(String secUserBlockingId,Map<String,Object> options){
 	
  		SmartList<SecUser> resultList = queryWith(SecUserTable.COLUMN_BLOCKING, secUserBlockingId, options, getSecUserMapper());
		analyzeSecUserByBlocking(resultList, secUserBlockingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SecUser> findSecUserByBlocking(String secUserBlockingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SecUser> resultList =  queryWithRange(SecUserTable.COLUMN_BLOCKING, secUserBlockingId, options, getSecUserMapper(), start, count);
 		analyzeSecUserByBlocking(resultList, secUserBlockingId, options);
 		return resultList;
 		
 	}
 	public void analyzeSecUserByBlocking(SmartList<SecUser> resultList, String secUserBlockingId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SecUser.BLOCKING_PROPERTY, secUserBlockingId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem verificationCodeExpireStatsItem = new StatsItem();
		//SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY
		verificationCodeExpireStatsItem.setDisplayName("SEC的用户");
		verificationCodeExpireStatsItem.setInternalName(formatKeyForDateLine(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY));
		verificationCodeExpireStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY),filterKey,emptyOptions));
		info.addItem(verificationCodeExpireStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countSecUserByBlocking(String secUserBlockingId,Map<String,Object> options){

 		return countWith(SecUserTable.COLUMN_BLOCKING, secUserBlockingId, options);
 	}
 	@Override
	public Map<String, Integer> countSecUserByBlockingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SecUserTable.COLUMN_BLOCKING, ids, options);
	}
 	
 	
		
		
		

	

	protected SecUser saveSecUser(SecUser  secUser){
		
		if(!secUser.isChanged()){
			return secUser;
		}
		
		
		String SQL=this.getSaveSecUserSQL(secUser);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSecUserParameters(secUser);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		secUser.incVersion();
		return secUser;
	
	}
	public SmartList<SecUser> saveSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSecUserList(secUserList);
		
		batchSecUserCreate((List<SecUser>)lists[CREATE_LIST_INDEX]);
		
		batchSecUserUpdate((List<SecUser>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SecUser secUser:secUserList){
			if(secUser.isChanged()){
				secUser.incVersion();
			}
			
		
		}
		
		
		return secUserList;
	}

	public SmartList<SecUser> removeSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options){
		
		
		super.removeList(secUserList, options);
		
		return secUserList;
		
		
	}
	
	protected List<Object[]> prepareSecUserBatchCreateArgs(List<SecUser> secUserList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SecUser secUser:secUserList ){
			Object [] parameters = prepareSecUserCreateParameters(secUser);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSecUserBatchUpdateArgs(List<SecUser> secUserList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SecUser secUser:secUserList ){
			if(!secUser.isChanged()){
				continue;
			}
			Object [] parameters = prepareSecUserUpdateParameters(secUser);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSecUserCreate(List<SecUser> secUserList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSecUserBatchCreateArgs(secUserList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSecUserUpdate(List<SecUser> secUserList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSecUserBatchUpdateArgs(secUserList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSecUserList(List<SecUser> secUserList){
		
		List<SecUser> secUserCreateList=new ArrayList<SecUser>();
		List<SecUser> secUserUpdateList=new ArrayList<SecUser>();
		
		for(SecUser secUser: secUserList){
			if(isUpdateRequest(secUser)){
				secUserUpdateList.add( secUser);
				continue;
			}
			secUserCreateList.add(secUser);
		}
		
		return new Object[]{secUserCreateList,secUserUpdateList};
	}
	
	protected boolean isUpdateRequest(SecUser secUser){
 		return secUser.getVersion() > 0;
 	}
 	protected String getSaveSecUserSQL(SecUser secUser){
 		if(isUpdateRequest(secUser)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSecUserParameters(SecUser secUser){
 		if(isUpdateRequest(secUser) ){
 			return prepareSecUserUpdateParameters(secUser);
 		}
 		return prepareSecUserCreateParameters(secUser);
 	}
 	protected Object[] prepareSecUserUpdateParameters(SecUser secUser){
 		Object[] parameters = new Object[13];
 
 		parameters[0] = secUser.getLogin();
 		parameters[1] = secUser.getMobile();
 		parameters[2] = secUser.getEmail();
 		parameters[3] = secUser.getPwd();
 		parameters[4] = secUser.getVerificationCode();
 		parameters[5] = secUser.getVerificationCodeExpire();
 		parameters[6] = secUser.getLastLoginTime(); 	
 		if(secUser.getDomain() != null){
 			parameters[7] = secUser.getDomain().getId();
 		}
  	
 		if(secUser.getBlocking() != null){
 			parameters[8] = secUser.getBlocking().getId();
 		}
 
 		parameters[9] = secUser.getCurrentStatus();		
 		parameters[10] = secUser.nextVersion();
 		parameters[11] = secUser.getId();
 		parameters[12] = secUser.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSecUserCreateParameters(SecUser secUser){
		Object[] parameters = new Object[11];
		String newSecUserId=getNextId();
		secUser.setId(newSecUserId);
		parameters[0] =  secUser.getId();
 
 		parameters[1] = secUser.getLogin();
 		parameters[2] = secUser.getMobile();
 		parameters[3] = secUser.getEmail();
 		parameters[4] = secUser.getPwd();
 		parameters[5] = secUser.getVerificationCode();
 		parameters[6] = secUser.getVerificationCodeExpire();
 		parameters[7] = secUser.getLastLoginTime(); 	
 		if(secUser.getDomain() != null){
 			parameters[8] = secUser.getDomain().getId();
 		
 		}
 		 	
 		if(secUser.getBlocking() != null){
 			parameters[9] = secUser.getBlocking().getId();
 		
 		}
 		
 		parameters[10] = secUser.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected SecUser saveInternalSecUser(SecUser secUser, Map<String,Object> options){
		
		saveSecUser(secUser);
 	
 		if(isSaveDomainEnabled(options)){
	 		saveDomain(secUser, options);
 		}
  	
 		if(isSaveBlockingEnabled(options)){
	 		saveBlocking(secUser, options);
 		}
 
		
		if(isSaveUserAppListEnabled(options)){
	 		saveUserAppList(secUser, options);
	 		//removeUserAppList(secUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveLoginHistoryListEnabled(options)){
	 		saveLoginHistoryList(secUser, options);
	 		//removeLoginHistoryList(secUser, options);
	 		//Not delete the record
	 		
 		}		
		
		return secUser;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SecUser saveDomain(SecUser secUser, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(secUser.getDomain() == null){
 			return secUser;//do nothing when it is null
 		}
 		
 		getUserDomainDAO().save(secUser.getDomain(),options);
 		return secUser;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SecUser saveBlocking(SecUser secUser, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(secUser.getBlocking() == null){
 			return secUser;//do nothing when it is null
 		}
 		
 		getSecUserBlockingDAO().save(secUser.getBlocking(),options);
 		return secUser;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public SecUser planToRemoveUserAppList(SecUser secUser, String userAppIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.ID_PROPERTY, userAppIds);
		
		SmartList<UserApp> externalUserAppList = getUserAppDAO().
				findUserAppWithKey(key, options);
		if(externalUserAppList == null){
			return secUser;
		}
		if(externalUserAppList.isEmpty()){
			return secUser;
		}
		
		for(UserApp userApp: externalUserAppList){

			userApp.clearFromAll();
		}
		
		
		SmartList<UserApp> userAppList = secUser.getUserAppList();		
		userAppList.addAllToRemoveList(externalUserAppList);
		return secUser;	
	
	}


	//disconnect SecUser with object_id in UserApp
	public SecUser planToRemoveUserAppListWithObjectId(SecUser secUser, String objectIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_ID_PROPERTY, objectIdId);
		
		SmartList<UserApp> externalUserAppList = getUserAppDAO().
				findUserAppWithKey(key, options);
		if(externalUserAppList == null){
			return secUser;
		}
		if(externalUserAppList.isEmpty()){
			return secUser;
		}
		
		for(UserApp userApp: externalUserAppList){
			userApp.clearObjectId();
			userApp.clearSecUser();
			
		}
		
		
		SmartList<UserApp> userAppList = secUser.getUserAppList();		
		userAppList.addAllToRemoveList(externalUserAppList);
		return secUser;
	}
	
	public int countUserAppListWithObjectId(String secUserId, String objectIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUserId);
		key.put(UserApp.OBJECT_ID_PROPERTY, objectIdId);
		
		int count = getUserAppDAO().countUserAppWithKey(key, options);
		return count;
	}
	
	public SecUser planToRemoveLoginHistoryList(SecUser secUser, String loginHistoryIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LoginHistory.SEC_USER_PROPERTY, secUser.getId());
		key.put(LoginHistory.ID_PROPERTY, loginHistoryIds);
		
		SmartList<LoginHistory> externalLoginHistoryList = getLoginHistoryDAO().
				findLoginHistoryWithKey(key, options);
		if(externalLoginHistoryList == null){
			return secUser;
		}
		if(externalLoginHistoryList.isEmpty()){
			return secUser;
		}
		
		for(LoginHistory loginHistory: externalLoginHistoryList){

			loginHistory.clearFromAll();
		}
		
		
		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();		
		loginHistoryList.addAllToRemoveList(externalLoginHistoryList);
		return secUser;	
	
	}



		
	protected SecUser saveUserAppList(SecUser secUser, Map<String,Object> options){
		
		
		
		
		SmartList<UserApp> userAppList = secUser.getUserAppList();
		if(userAppList == null){
			//null list means nothing
			return secUser;
		}
		SmartList<UserApp> mergedUpdateUserAppList = new SmartList<UserApp>();
		
		
		mergedUpdateUserAppList.addAll(userAppList); 
		if(userAppList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserAppList.addAll(userAppList.getToRemoveList());
			userAppList.removeAll(userAppList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserAppDAO().saveUserAppList(mergedUpdateUserAppList,options);
		
		if(userAppList.getToRemoveList() != null){
			userAppList.removeAll(userAppList.getToRemoveList());
		}
		
		
		return secUser;
	
	}
	
	protected SecUser removeUserAppList(SecUser secUser, Map<String,Object> options){
	
	
		SmartList<UserApp> userAppList = secUser.getUserAppList();
		if(userAppList == null){
			return secUser;
		}	
	
		SmartList<UserApp> toRemoveUserAppList = userAppList.getToRemoveList();
		
		if(toRemoveUserAppList == null){
			return secUser;
		}
		if(toRemoveUserAppList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserAppDAO().removeUserAppList(toRemoveUserAppList,options);
		
		return secUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected SecUser saveLoginHistoryList(SecUser secUser, Map<String,Object> options){
		
		
		
		
		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();
		if(loginHistoryList == null){
			//null list means nothing
			return secUser;
		}
		SmartList<LoginHistory> mergedUpdateLoginHistoryList = new SmartList<LoginHistory>();
		
		
		mergedUpdateLoginHistoryList.addAll(loginHistoryList); 
		if(loginHistoryList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLoginHistoryList.addAll(loginHistoryList.getToRemoveList());
			loginHistoryList.removeAll(loginHistoryList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLoginHistoryDAO().saveLoginHistoryList(mergedUpdateLoginHistoryList,options);
		
		if(loginHistoryList.getToRemoveList() != null){
			loginHistoryList.removeAll(loginHistoryList.getToRemoveList());
		}
		
		
		return secUser;
	
	}
	
	protected SecUser removeLoginHistoryList(SecUser secUser, Map<String,Object> options){
	
	
		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();
		if(loginHistoryList == null){
			return secUser;
		}	
	
		SmartList<LoginHistory> toRemoveLoginHistoryList = loginHistoryList.getToRemoveList();
		
		if(toRemoveLoginHistoryList == null){
			return secUser;
		}
		if(toRemoveLoginHistoryList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLoginHistoryDAO().removeLoginHistoryList(toRemoveLoginHistoryList,options);
		
		return secUser;
	
	}
	
	

 	
 	
	
	
	
		

	public SecUser present(SecUser secUser,Map<String, Object> options){
	
		presentUserAppList(secUser,options);
		presentLoginHistoryList(secUser,options);

		return secUser;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SecUser presentUserAppList(
			SecUser secUser,
			Map<String, Object> options) {

		SmartList<UserApp> userAppList = secUser.getUserAppList();		
				SmartList<UserApp> newList= presentSubList(secUser.getId(),
				userAppList,
				options,
				getUserAppDAO()::countUserAppBySecUser,
				getUserAppDAO()::findUserAppBySecUser
				);

		
		secUser.setUserAppList(newList);
		

		return secUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SecUser presentLoginHistoryList(
			SecUser secUser,
			Map<String, Object> options) {

		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();		
				SmartList<LoginHistory> newList= presentSubList(secUser.getId(),
				loginHistoryList,
				options,
				getLoginHistoryDAO()::countLoginHistoryBySecUser,
				getLoginHistoryDAO()::findLoginHistoryBySecUser
				);

		
		secUser.setLoginHistoryList(newList);
		

		return secUser;
	}			
		

	
    public SmartList<SecUser> requestCandidateSecUserForUserApp(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SecUserTable.COLUMN_LOGIN, filterKey, pageNo, pageSize, getSecUserMapper());
    }
		
    public SmartList<SecUser> requestCandidateSecUserForLoginHistory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SecUserTable.COLUMN_LOGIN, filterKey, pageNo, pageSize, getSecUserMapper());
    }
		

	protected String getTableName(){
		return SecUserTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SecUser> secUserList) {		
		this.enhanceListInternal(secUserList, this.getSecUserMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SecUser> secUserList = ownerEntity.collectRefsWithType(SecUser.INTERNAL_TYPE);
		this.enhanceList(secUserList);
		
	}
	
	@Override
	public SmartList<SecUser> findSecUserWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSecUserMapper());

	}
	@Override
	public int countSecUserWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSecUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SecUser> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSecUserMapper());
	}
}


