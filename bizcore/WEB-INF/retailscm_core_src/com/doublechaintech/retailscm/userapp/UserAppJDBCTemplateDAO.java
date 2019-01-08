
package com.doublechaintech.retailscm.userapp;

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


import com.doublechaintech.retailscm.objectaccess.ObjectAccess;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.listaccess.ListAccessDAO;
import com.doublechaintech.retailscm.objectaccess.ObjectAccessDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class UserAppJDBCTemplateDAO extends RetailscmNamingServiceDAO implements UserAppDAO{
 
 	
 	private  SecUserDAO  secUserDAO;
 	public void setSecUserDAO(SecUserDAO secUserDAO){
	 	this.secUserDAO = secUserDAO;
 	}
 	public SecUserDAO getSecUserDAO(){
	 	return this.secUserDAO;
 	}


			
		
	
  	private  ListAccessDAO  listAccessDAO;
 	public void setListAccessDAO(ListAccessDAO pListAccessDAO){
 	
 		if(pListAccessDAO == null){
 			throw new IllegalStateException("Do not try to set listAccessDAO to null.");
 		}
	 	this.listAccessDAO = pListAccessDAO;
 	}
 	public ListAccessDAO getListAccessDAO(){
 		if(this.listAccessDAO == null){
 			throw new IllegalStateException("The listAccessDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.listAccessDAO;
 	}	
 	
			
		
	
  	private  ObjectAccessDAO  objectAccessDAO;
 	public void setObjectAccessDAO(ObjectAccessDAO pObjectAccessDAO){
 	
 		if(pObjectAccessDAO == null){
 			throw new IllegalStateException("Do not try to set objectAccessDAO to null.");
 		}
	 	this.objectAccessDAO = pObjectAccessDAO;
 	}
 	public ObjectAccessDAO getObjectAccessDAO(){
 		if(this.objectAccessDAO == null){
 			throw new IllegalStateException("The objectAccessDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.objectAccessDAO;
 	}	
 	
			
		

	
	/*
	protected UserApp load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUserApp(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public UserApp load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUserApp(UserAppTable.withId(id), options);
	}
	
	
	
	public UserApp save(UserApp userApp,Map<String,Object> options){
		
		String methodName="save(UserApp userApp,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(userApp, methodName, "userApp");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUserApp(userApp,options);
	}
	public UserApp clone(String userAppId, Map<String,Object> options) throws Exception{
	
		return clone(UserAppTable.withId(userAppId),options);
	}
	
	protected UserApp clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userAppId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		UserApp newUserApp = loadInternalUserApp(accessKey, options);
		newUserApp.setVersion(0);
		
		
 		
 		if(isSaveListAccessListEnabled(options)){
 			for(ListAccess item: newUserApp.getListAccessList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveObjectAccessListEnabled(options)){
 			for(ObjectAccess item: newUserApp.getObjectAccessList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalUserApp(newUserApp,options);
		
		return newUserApp;
	}
	
	
	
	

	protected void throwIfHasException(String userAppId,int version,int count) throws Exception{
		if (count == 1) {
			throw new UserAppVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserAppNotFoundException(
					"The " + this.getTableName() + "(" + userAppId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String userAppId, int version) throws Exception{
	
		String methodName="delete(String userAppId, int version)";
		assertMethodArgumentNotNull(userAppId, methodName, "userAppId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userAppId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userAppId,version);
		}
		
	
	}
	
	
	
	
	

	public UserApp disconnectFromAll(String userAppId, int version) throws Exception{
	
		
		UserApp userApp = loadInternalUserApp(UserAppTable.withId(userAppId), emptyOptions());
		userApp.clearFromAll();
		this.saveUserApp(userApp);
		return userApp;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return UserAppTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user_app";
	}
	@Override
	protected String getBeanName() {
		
		return "userApp";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserAppTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserAppTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserAppTokens.SECUSER);
 	}
 	

 	
 
		
	
	protected boolean isExtractListAccessListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserAppTokens.LIST_ACCESS_LIST);
 	}
 	protected boolean isAnalyzeListAccessListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserAppTokens.LIST_ACCESS_LIST+".analyze");
 	}

	protected boolean isSaveListAccessListEnabled(Map<String,Object> options){
		return checkOptions(options, UserAppTokens.LIST_ACCESS_LIST);
		
 	}
 	
		
	
	protected boolean isExtractObjectAccessListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserAppTokens.OBJECT_ACCESS_LIST);
 	}
 	protected boolean isAnalyzeObjectAccessListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserAppTokens.OBJECT_ACCESS_LIST+".analyze");
 	}

	protected boolean isSaveObjectAccessListEnabled(Map<String,Object> options){
		return checkOptions(options, UserAppTokens.OBJECT_ACCESS_LIST);
		
 	}
 	
		

	

	protected UserAppMapper getUserAppMapper(){
		return new UserAppMapper();
	}

	
	
	protected UserApp extractUserApp(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			UserApp userApp = loadSingleObject(accessKey, getUserAppMapper());
			return userApp;
		}catch(EmptyResultDataAccessException e){
			throw new UserAppNotFoundException("UserApp("+accessKey+") is not found!");
		}

	}

	
	

	protected UserApp loadInternalUserApp(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		UserApp userApp = extractUserApp(accessKey, loadOptions);
 	
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(userApp, loadOptions);
 		}
 
		
		if(isExtractListAccessListEnabled(loadOptions)){
	 		extractListAccessList(userApp, loadOptions);
 		}	
 		if(isAnalyzeListAccessListEnabled(loadOptions)){
	 		// analyzeListAccessList(userApp, loadOptions);
 		}
 		
		
		if(isExtractObjectAccessListEnabled(loadOptions)){
	 		extractObjectAccessList(userApp, loadOptions);
 		}	
 		if(isAnalyzeObjectAccessListEnabled(loadOptions)){
	 		// analyzeObjectAccessList(userApp, loadOptions);
 		}
 		
		
		return userApp;
		
	}

	 

 	protected UserApp extractSecUser(UserApp userApp, Map<String,Object> options) throws Exception{

		if(userApp.getSecUser() == null){
			return userApp;
		}
		String secUserId = userApp.getSecUser().getId();
		if( secUserId == null){
			return userApp;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			userApp.setSecUser(secUser);
		}
		
 		
 		return userApp;
 	}
 		
 
		
	protected void enhanceListAccessList(SmartList<ListAccess> listAccessList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserApp extractListAccessList(UserApp userApp, Map<String,Object> options){
		
		
		if(userApp == null){
			return null;
		}
		if(userApp.getId() == null){
			return userApp;
		}

		
		
		SmartList<ListAccess> listAccessList = getListAccessDAO().findListAccessByApp(userApp.getId(),options);
		if(listAccessList != null){
			enhanceListAccessList(listAccessList,options);
			userApp.setListAccessList(listAccessList);
		}
		
		return userApp;
	
	}	
	
	protected UserApp analyzeListAccessList(UserApp userApp, Map<String,Object> options){
		
		
		if(userApp == null){
			return null;
		}
		if(userApp.getId() == null){
			return userApp;
		}

		
		
		SmartList<ListAccess> listAccessList = userApp.getListAccessList();
		if(listAccessList != null){
			getListAccessDAO().analyzeListAccessByApp(listAccessList, userApp.getId(), options);
			
		}
		
		return userApp;
	
	}	
	
		
	protected void enhanceObjectAccessList(SmartList<ObjectAccess> objectAccessList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserApp extractObjectAccessList(UserApp userApp, Map<String,Object> options){
		
		
		if(userApp == null){
			return null;
		}
		if(userApp.getId() == null){
			return userApp;
		}

		
		
		SmartList<ObjectAccess> objectAccessList = getObjectAccessDAO().findObjectAccessByApp(userApp.getId(),options);
		if(objectAccessList != null){
			enhanceObjectAccessList(objectAccessList,options);
			userApp.setObjectAccessList(objectAccessList);
		}
		
		return userApp;
	
	}	
	
	protected UserApp analyzeObjectAccessList(UserApp userApp, Map<String,Object> options){
		
		
		if(userApp == null){
			return null;
		}
		if(userApp.getId() == null){
			return userApp;
		}

		
		
		SmartList<ObjectAccess> objectAccessList = userApp.getObjectAccessList();
		if(objectAccessList != null){
			getObjectAccessDAO().analyzeObjectAccessByApp(objectAccessList, userApp.getId(), options);
			
		}
		
		return userApp;
	
	}	
	
		
		
  	
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId,Map<String,Object> options){
 	
  		SmartList<UserApp> resultList = queryWith(UserAppTable.COLUMN_SEC_USER, secUserId, options, getUserAppMapper());
		// analyzeUserAppBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<UserApp> resultList =  queryWithRange(UserAppTable.COLUMN_SEC_USER, secUserId, options, getUserAppMapper(), start, count);
 		//analyzeUserAppBySecUser(resultList, secUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserAppBySecUser(SmartList<UserApp> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countUserAppBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(UserAppTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countUserAppBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserAppTable.COLUMN_SEC_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected UserApp saveUserApp(UserApp  userApp){
		
		if(!userApp.isChanged()){
			return userApp;
		}
		
		
		String SQL=this.getSaveUserAppSQL(userApp);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserAppParameters(userApp);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		userApp.incVersion();
		return userApp;
	
	}
	public SmartList<UserApp> saveUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserAppList(userAppList);
		
		batchUserAppCreate((List<UserApp>)lists[CREATE_LIST_INDEX]);
		
		batchUserAppUpdate((List<UserApp>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(UserApp userApp:userAppList){
			if(userApp.isChanged()){
				userApp.incVersion();
			}
			
		
		}
		
		
		return userAppList;
	}

	public SmartList<UserApp> removeUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options){
		
		
		super.removeList(userAppList, options);
		
		return userAppList;
		
		
	}
	
	protected List<Object[]> prepareUserAppBatchCreateArgs(List<UserApp> userAppList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserApp userApp:userAppList ){
			Object [] parameters = prepareUserAppCreateParameters(userApp);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserAppBatchUpdateArgs(List<UserApp> userAppList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserApp userApp:userAppList ){
			if(!userApp.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserAppUpdateParameters(userApp);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserAppCreate(List<UserApp> userAppList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserAppBatchCreateArgs(userAppList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserAppUpdate(List<UserApp> userAppList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserAppBatchUpdateArgs(userAppList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserAppList(List<UserApp> userAppList){
		
		List<UserApp> userAppCreateList=new ArrayList<UserApp>();
		List<UserApp> userAppUpdateList=new ArrayList<UserApp>();
		
		for(UserApp userApp: userAppList){
			if(isUpdateRequest(userApp)){
				userAppUpdateList.add( userApp);
				continue;
			}
			userAppCreateList.add(userApp);
		}
		
		return new Object[]{userAppCreateList,userAppUpdateList};
	}
	
	protected boolean isUpdateRequest(UserApp userApp){
 		return userApp.getVersion() > 0;
 	}
 	protected String getSaveUserAppSQL(UserApp userApp){
 		if(isUpdateRequest(userApp)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserAppParameters(UserApp userApp){
 		if(isUpdateRequest(userApp) ){
 			return prepareUserAppUpdateParameters(userApp);
 		}
 		return prepareUserAppCreateParameters(userApp);
 	}
 	protected Object[] prepareUserAppUpdateParameters(UserApp userApp){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = userApp.getTitle(); 	
 		if(userApp.getSecUser() != null){
 			parameters[1] = userApp.getSecUser().getId();
 		}
 
 		parameters[2] = userApp.getAppIcon();
 		parameters[3] = userApp.getFullAccess();
 		parameters[4] = userApp.getPermission();
 		parameters[5] = userApp.getObjectType();
 		parameters[6] = userApp.getObjectId();
 		parameters[7] = userApp.getLocation();		
 		parameters[8] = userApp.nextVersion();
 		parameters[9] = userApp.getId();
 		parameters[10] = userApp.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserAppCreateParameters(UserApp userApp){
		Object[] parameters = new Object[9];
		String newUserAppId=getNextId();
		userApp.setId(newUserAppId);
		parameters[0] =  userApp.getId();
 
 		parameters[1] = userApp.getTitle(); 	
 		if(userApp.getSecUser() != null){
 			parameters[2] = userApp.getSecUser().getId();
 		
 		}
 		
 		parameters[3] = userApp.getAppIcon();
 		parameters[4] = userApp.getFullAccess();
 		parameters[5] = userApp.getPermission();
 		parameters[6] = userApp.getObjectType();
 		parameters[7] = userApp.getObjectId();
 		parameters[8] = userApp.getLocation();		
 				
 		return parameters;
 	}
 	
	protected UserApp saveInternalUserApp(UserApp userApp, Map<String,Object> options){
		
		saveUserApp(userApp);
 	
 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(userApp, options);
 		}
 
		
		if(isSaveListAccessListEnabled(options)){
	 		saveListAccessList(userApp, options);
	 		//removeListAccessList(userApp, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveObjectAccessListEnabled(options)){
	 		saveObjectAccessList(userApp, options);
	 		//removeObjectAccessList(userApp, options);
	 		//Not delete the record
	 		
 		}		
		
		return userApp;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected UserApp saveSecUser(UserApp userApp, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userApp.getSecUser() == null){
 			return userApp;//do nothing when it is null
 		}
 		
 		getSecUserDAO().save(userApp.getSecUser(),options);
 		return userApp;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public UserApp planToRemoveListAccessList(UserApp userApp, String listAccessIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ListAccess.APP_PROPERTY, userApp.getId());
		key.put(ListAccess.ID_PROPERTY, listAccessIds);
		
		SmartList<ListAccess> externalListAccessList = getListAccessDAO().
				findListAccessWithKey(key, options);
		if(externalListAccessList == null){
			return userApp;
		}
		if(externalListAccessList.isEmpty()){
			return userApp;
		}
		
		for(ListAccess listAccess: externalListAccessList){

			listAccess.clearFromAll();
		}
		
		
		SmartList<ListAccess> listAccessList = userApp.getListAccessList();		
		listAccessList.addAllToRemoveList(externalListAccessList);
		return userApp;	
	
	}


	public UserApp planToRemoveObjectAccessList(UserApp userApp, String objectAccessIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ObjectAccess.APP_PROPERTY, userApp.getId());
		key.put(ObjectAccess.ID_PROPERTY, objectAccessIds);
		
		SmartList<ObjectAccess> externalObjectAccessList = getObjectAccessDAO().
				findObjectAccessWithKey(key, options);
		if(externalObjectAccessList == null){
			return userApp;
		}
		if(externalObjectAccessList.isEmpty()){
			return userApp;
		}
		
		for(ObjectAccess objectAccess: externalObjectAccessList){

			objectAccess.clearFromAll();
		}
		
		
		SmartList<ObjectAccess> objectAccessList = userApp.getObjectAccessList();		
		objectAccessList.addAllToRemoveList(externalObjectAccessList);
		return userApp;	
	
	}



		
	protected UserApp saveListAccessList(UserApp userApp, Map<String,Object> options){
		
		
		
		
		SmartList<ListAccess> listAccessList = userApp.getListAccessList();
		if(listAccessList == null){
			//null list means nothing
			return userApp;
		}
		SmartList<ListAccess> mergedUpdateListAccessList = new SmartList<ListAccess>();
		
		
		mergedUpdateListAccessList.addAll(listAccessList); 
		if(listAccessList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateListAccessList.addAll(listAccessList.getToRemoveList());
			listAccessList.removeAll(listAccessList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getListAccessDAO().saveListAccessList(mergedUpdateListAccessList,options);
		
		if(listAccessList.getToRemoveList() != null){
			listAccessList.removeAll(listAccessList.getToRemoveList());
		}
		
		
		return userApp;
	
	}
	
	protected UserApp removeListAccessList(UserApp userApp, Map<String,Object> options){
	
	
		SmartList<ListAccess> listAccessList = userApp.getListAccessList();
		if(listAccessList == null){
			return userApp;
		}	
	
		SmartList<ListAccess> toRemoveListAccessList = listAccessList.getToRemoveList();
		
		if(toRemoveListAccessList == null){
			return userApp;
		}
		if(toRemoveListAccessList.isEmpty()){
			return userApp;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getListAccessDAO().removeListAccessList(toRemoveListAccessList,options);
		
		return userApp;
	
	}
	
	

 	
 	
	
	
	
		
	protected UserApp saveObjectAccessList(UserApp userApp, Map<String,Object> options){
		
		
		
		
		SmartList<ObjectAccess> objectAccessList = userApp.getObjectAccessList();
		if(objectAccessList == null){
			//null list means nothing
			return userApp;
		}
		SmartList<ObjectAccess> mergedUpdateObjectAccessList = new SmartList<ObjectAccess>();
		
		
		mergedUpdateObjectAccessList.addAll(objectAccessList); 
		if(objectAccessList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateObjectAccessList.addAll(objectAccessList.getToRemoveList());
			objectAccessList.removeAll(objectAccessList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getObjectAccessDAO().saveObjectAccessList(mergedUpdateObjectAccessList,options);
		
		if(objectAccessList.getToRemoveList() != null){
			objectAccessList.removeAll(objectAccessList.getToRemoveList());
		}
		
		
		return userApp;
	
	}
	
	protected UserApp removeObjectAccessList(UserApp userApp, Map<String,Object> options){
	
	
		SmartList<ObjectAccess> objectAccessList = userApp.getObjectAccessList();
		if(objectAccessList == null){
			return userApp;
		}	
	
		SmartList<ObjectAccess> toRemoveObjectAccessList = objectAccessList.getToRemoveList();
		
		if(toRemoveObjectAccessList == null){
			return userApp;
		}
		if(toRemoveObjectAccessList.isEmpty()){
			return userApp;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getObjectAccessDAO().removeObjectAccessList(toRemoveObjectAccessList,options);
		
		return userApp;
	
	}
	
	

 	
 	
	
	
	
		

	public UserApp present(UserApp userApp,Map<String, Object> options){
	
		presentListAccessList(userApp,options);
		presentObjectAccessList(userApp,options);

		return userApp;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected UserApp presentListAccessList(
			UserApp userApp,
			Map<String, Object> options) {

		SmartList<ListAccess> listAccessList = userApp.getListAccessList();		
				SmartList<ListAccess> newList= presentSubList(userApp.getId(),
				listAccessList,
				options,
				getListAccessDAO()::countListAccessByApp,
				getListAccessDAO()::findListAccessByApp
				);

		
		userApp.setListAccessList(newList);
		

		return userApp;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected UserApp presentObjectAccessList(
			UserApp userApp,
			Map<String, Object> options) {

		SmartList<ObjectAccess> objectAccessList = userApp.getObjectAccessList();		
				SmartList<ObjectAccess> newList= presentSubList(userApp.getId(),
				objectAccessList,
				options,
				getObjectAccessDAO()::countObjectAccessByApp,
				getObjectAccessDAO()::findObjectAccessByApp
				);

		
		userApp.setObjectAccessList(newList);
		

		return userApp;
	}			
		

	
    public SmartList<UserApp> requestCandidateUserAppForListAccess(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserAppTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getUserAppMapper());
    }
		
    public SmartList<UserApp> requestCandidateUserAppForObjectAccess(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserAppTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getUserAppMapper());
    }
		

	protected String getTableName(){
		return UserAppTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<UserApp> userAppList) {		
		this.enhanceListInternal(userAppList, this.getUserAppMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<UserApp> userAppList = ownerEntity.collectRefsWithType(UserApp.INTERNAL_TYPE);
		this.enhanceList(userAppList);
		
	}
	
	@Override
	public SmartList<UserApp> findUserAppWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getUserAppMapper());

	}
	@Override
	public int countUserAppWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countUserAppWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<UserApp> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getUserAppMapper());
	}
}


