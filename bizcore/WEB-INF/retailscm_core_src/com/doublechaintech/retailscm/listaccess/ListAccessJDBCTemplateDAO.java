
package com.doublechaintech.retailscm.listaccess;

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


import com.doublechaintech.retailscm.userapp.UserApp;

import com.doublechaintech.retailscm.userapp.UserAppDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ListAccessJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ListAccessDAO{

	protected UserAppDAO userAppDAO;
	public void setUserAppDAO(UserAppDAO userAppDAO){
 	
 		if(userAppDAO == null){
 			throw new IllegalStateException("Do not try to set userAppDAO to null.");
 		}
	 	this.userAppDAO = userAppDAO;
 	}
 	public UserAppDAO getUserAppDAO(){
 		if(this.userAppDAO == null){
 			throw new IllegalStateException("The userAppDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAppDAO;
 	}	


	/*
	protected ListAccess load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalListAccess(accessKey, options);
	}
	*/

	public SmartList<ListAccess> loadAll() {
	    return this.loadAll(getListAccessMapper());
	}

  public Stream<ListAccess> loadAllAsStream() {
      return this.loadAllAsStream(getListAccessMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ListAccess load(String id,Map<String,Object> options) throws Exception{
		return loadInternalListAccess(ListAccessTable.withId(id), options);
	}

	

	public ListAccess save(ListAccess listAccess,Map<String,Object> options){

		String methodName="save(ListAccess listAccess,Map<String,Object> options)";

		assertMethodArgumentNotNull(listAccess, methodName, "listAccess");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalListAccess(listAccess,options);
	}
	public ListAccess clone(String listAccessId, Map<String,Object> options) throws Exception{

		return clone(ListAccessTable.withId(listAccessId),options);
	}

	protected ListAccess clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String listAccessId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ListAccess newListAccess = loadInternalListAccess(accessKey, options);
		newListAccess.setVersion(0);
		
		


		saveInternalListAccess(newListAccess,options);

		return newListAccess;
	}

	



	protected void throwIfHasException(String listAccessId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ListAccessVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ListAccessNotFoundException(
					"The " + this.getTableName() + "(" + listAccessId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String listAccessId, int version) throws Exception{

		String methodName="delete(String listAccessId, int version)";
		assertMethodArgumentNotNull(listAccessId, methodName, "listAccessId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{listAccessId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(listAccessId,version);
		}


	}






	public ListAccess disconnectFromAll(String listAccessId, int version) throws Exception{


		ListAccess listAccess = loadInternalListAccess(ListAccessTable.withId(listAccessId), emptyOptions());
		listAccess.clearFromAll();
		this.saveListAccess(listAccess);
		return listAccess;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ListAccessTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "list_access";
	}
	@Override
	protected String getBeanName() {

		return "listAccess";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ListAccessTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractAppEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ListAccessTokens.APP);
 	}

 	protected boolean isSaveAppEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ListAccessTokens.APP);
 	}
 	

 	
 
		

	

	protected ListAccessMapper getListAccessMapper(){
		return new ListAccessMapper();
	}

	
	
	protected ListAccess extractListAccess(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ListAccess listAccess = loadSingleObject(accessKey, getListAccessMapper());
			return listAccess;
		}catch(EmptyResultDataAccessException e){
			throw new ListAccessNotFoundException("ListAccess("+accessKey+") is not found!");
		}

	}

	
	

	protected ListAccess loadInternalListAccess(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ListAccess listAccess = extractListAccess(accessKey, loadOptions);
 	
 		if(isExtractAppEnabled(loadOptions)){
	 		extractApp(listAccess, loadOptions);
 		}
 
		
		return listAccess;
		
	}

	 

 	protected ListAccess extractApp(ListAccess listAccess, Map<String,Object> options) throws Exception{

		if(listAccess.getApp() == null){
			return listAccess;
		}
		String appId = listAccess.getApp().getId();
		if( appId == null){
			return listAccess;
		}
		UserApp app = getUserAppDAO().load(appId,options);
		if(app != null){
			listAccess.setApp(app);
		}
		
 		
 		return listAccess;
 	}
 		
 
		
		
  	
 	public SmartList<ListAccess> findListAccessByApp(String userAppId,Map<String,Object> options){
 	
  		SmartList<ListAccess> resultList = queryWith(ListAccessTable.COLUMN_APP, userAppId, options, getListAccessMapper());
		// analyzeListAccessByApp(resultList, userAppId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ListAccess> findListAccessByApp(String userAppId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ListAccess> resultList =  queryWithRange(ListAccessTable.COLUMN_APP, userAppId, options, getListAccessMapper(), start, count);
 		//analyzeListAccessByApp(resultList, userAppId, options);
 		return resultList;
 		
 	}
 	public void analyzeListAccessByApp(SmartList<ListAccess> resultList, String userAppId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countListAccessByApp(String userAppId,Map<String,Object> options){

 		return countWith(ListAccessTable.COLUMN_APP, userAppId, options);
 	}
 	@Override
	public Map<String, Integer> countListAccessByAppIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ListAccessTable.COLUMN_APP, ids, options);
	}
 	
 	
		
		
		

	

	protected ListAccess saveListAccess(ListAccess  listAccess){
		
		if(!listAccess.isChanged()){
			return listAccess;
		}
		

		String SQL=this.getSaveListAccessSQL(listAccess);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveListAccessParameters(listAccess);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		listAccess.incVersion();
		return listAccess;

	}
	public SmartList<ListAccess> saveListAccessList(SmartList<ListAccess> listAccessList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitListAccessList(listAccessList);

		batchListAccessCreate((List<ListAccess>)lists[CREATE_LIST_INDEX]);

		batchListAccessUpdate((List<ListAccess>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ListAccess listAccess:listAccessList){
			if(listAccess.isChanged()){
				listAccess.incVersion();
			}


		}


		return listAccessList;
	}

	public SmartList<ListAccess> removeListAccessList(SmartList<ListAccess> listAccessList,Map<String,Object> options){


		super.removeList(listAccessList, options);

		return listAccessList;


	}

	protected List<Object[]> prepareListAccessBatchCreateArgs(List<ListAccess> listAccessList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ListAccess listAccess:listAccessList ){
			Object [] parameters = prepareListAccessCreateParameters(listAccess);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareListAccessBatchUpdateArgs(List<ListAccess> listAccessList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ListAccess listAccess:listAccessList ){
			if(!listAccess.isChanged()){
				continue;
			}
			Object [] parameters = prepareListAccessUpdateParameters(listAccess);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchListAccessCreate(List<ListAccess> listAccessList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareListAccessBatchCreateArgs(listAccessList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchListAccessUpdate(List<ListAccess> listAccessList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareListAccessBatchUpdateArgs(listAccessList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitListAccessList(List<ListAccess> listAccessList){

		List<ListAccess> listAccessCreateList=new ArrayList<ListAccess>();
		List<ListAccess> listAccessUpdateList=new ArrayList<ListAccess>();

		for(ListAccess listAccess: listAccessList){
			if(isUpdateRequest(listAccess)){
				listAccessUpdateList.add( listAccess);
				continue;
			}
			listAccessCreateList.add(listAccess);
		}

		return new Object[]{listAccessCreateList,listAccessUpdateList};
	}

	protected boolean isUpdateRequest(ListAccess listAccess){
 		return listAccess.getVersion() > 0;
 	}
 	protected String getSaveListAccessSQL(ListAccess listAccess){
 		if(isUpdateRequest(listAccess)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveListAccessParameters(ListAccess listAccess){
 		if(isUpdateRequest(listAccess) ){
 			return prepareListAccessUpdateParameters(listAccess);
 		}
 		return prepareListAccessCreateParameters(listAccess);
 	}
 	protected Object[] prepareListAccessUpdateParameters(ListAccess listAccess){
 		Object[] parameters = new Object[11];
 
 		
 		parameters[0] = listAccess.getName();
 		
 		
 		parameters[1] = listAccess.getInternalName();
 		
 		
 		parameters[2] = listAccess.getReadPermission();
 		
 		
 		parameters[3] = listAccess.getCreatePermission();
 		
 		
 		parameters[4] = listAccess.getDeletePermission();
 		
 		
 		parameters[5] = listAccess.getUpdatePermission();
 		
 		
 		parameters[6] = listAccess.getExecutionPermission();
 		
 		if(listAccess.getApp() != null){
 			parameters[7] = listAccess.getApp().getId();
 		}
 
 		parameters[8] = listAccess.nextVersion();
 		parameters[9] = listAccess.getId();
 		parameters[10] = listAccess.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareListAccessCreateParameters(ListAccess listAccess){
		Object[] parameters = new Object[9];
        if(listAccess.getId() == null){
          String newListAccessId=getNextId();
          listAccess.setId(newListAccessId);
        }
		parameters[0] =  listAccess.getId();
 
 		
 		parameters[1] = listAccess.getName();
 		
 		
 		parameters[2] = listAccess.getInternalName();
 		
 		
 		parameters[3] = listAccess.getReadPermission();
 		
 		
 		parameters[4] = listAccess.getCreatePermission();
 		
 		
 		parameters[5] = listAccess.getDeletePermission();
 		
 		
 		parameters[6] = listAccess.getUpdatePermission();
 		
 		
 		parameters[7] = listAccess.getExecutionPermission();
 		
 		if(listAccess.getApp() != null){
 			parameters[8] = listAccess.getApp().getId();

 		}
 		

 		return parameters;
 	}

	protected ListAccess saveInternalListAccess(ListAccess listAccess, Map<String,Object> options){

		saveListAccess(listAccess);

 		if(isSaveAppEnabled(options)){
	 		saveApp(listAccess, options);
 		}
 
		
		return listAccess;

	}



	//======================================================================================
	

 	protected ListAccess saveApp(ListAccess listAccess, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(listAccess.getApp() == null){
 			return listAccess;//do nothing when it is null
 		}

 		getUserAppDAO().save(listAccess.getApp(),options);
 		return listAccess;

 	}





 

	

		

	public ListAccess present(ListAccess listAccess,Map<String, Object> options){
	

		return listAccess;
	
	}
		

	

	protected String getTableName(){
		return ListAccessTable.TABLE_NAME;
	}



	public void enhanceList(List<ListAccess> listAccessList) {
		this.enhanceListInternal(listAccessList, this.getListAccessMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ListAccess> listAccessList = ownerEntity.collectRefsWithType(ListAccess.INTERNAL_TYPE);
		this.enhanceList(listAccessList);

	}

	@Override
	public SmartList<ListAccess> findListAccessWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getListAccessMapper());

	}
	@Override
	public int countListAccessWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countListAccessWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ListAccess> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getListAccessMapper());
	}

  @Override
  public Stream<ListAccess> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getListAccessMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateListAccess executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateListAccess result = new CandidateListAccess();
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


