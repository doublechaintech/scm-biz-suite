
package com.doublechaintech.retailscm.wechatworkappidentify;

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


public class WechatWorkappIdentifyJDBCTemplateDAO extends RetailscmBaseDAOImpl implements WechatWorkappIdentifyDAO{

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
	protected WechatWorkappIdentify load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWechatWorkappIdentify(accessKey, options);
	}
	*/
	
	public SmartList<WechatWorkappIdentify> loadAll() {
	    return this.loadAll(getWechatWorkappIdentifyMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public WechatWorkappIdentify load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWechatWorkappIdentify(WechatWorkappIdentifyTable.withId(id), options);
	}
	
	
	
	public WechatWorkappIdentify save(WechatWorkappIdentify wechatWorkappIdentify,Map<String,Object> options){
		
		String methodName="save(WechatWorkappIdentify wechatWorkappIdentify,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(wechatWorkappIdentify, methodName, "wechatWorkappIdentify");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalWechatWorkappIdentify(wechatWorkappIdentify,options);
	}
	public WechatWorkappIdentify clone(String wechatWorkappIdentifyId, Map<String,Object> options) throws Exception{
	
		return clone(WechatWorkappIdentifyTable.withId(wechatWorkappIdentifyId),options);
	}
	
	protected WechatWorkappIdentify clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String wechatWorkappIdentifyId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		WechatWorkappIdentify newWechatWorkappIdentify = loadInternalWechatWorkappIdentify(accessKey, options);
		newWechatWorkappIdentify.setVersion(0);
		
		

		
		saveInternalWechatWorkappIdentify(newWechatWorkappIdentify,options);
		
		return newWechatWorkappIdentify;
	}
	
	
	
	

	protected void throwIfHasException(String wechatWorkappIdentifyId,int version,int count) throws Exception{
		if (count == 1) {
			throw new WechatWorkappIdentifyVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WechatWorkappIdentifyNotFoundException(
					"The " + this.getTableName() + "(" + wechatWorkappIdentifyId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String wechatWorkappIdentifyId, int version) throws Exception{
	
		String methodName="delete(String wechatWorkappIdentifyId, int version)";
		assertMethodArgumentNotNull(wechatWorkappIdentifyId, methodName, "wechatWorkappIdentifyId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{wechatWorkappIdentifyId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(wechatWorkappIdentifyId,version);
		}
		
	
	}
	
	
	
	
	

	public WechatWorkappIdentify disconnectFromAll(String wechatWorkappIdentifyId, int version) throws Exception{
	
		
		WechatWorkappIdentify wechatWorkappIdentify = loadInternalWechatWorkappIdentify(WechatWorkappIdentifyTable.withId(wechatWorkappIdentifyId), emptyOptions());
		wechatWorkappIdentify.clearFromAll();
		this.saveWechatWorkappIdentify(wechatWorkappIdentify);
		return wechatWorkappIdentify;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return WechatWorkappIdentifyTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "wechat_workapp_identify";
	}
	@Override
	protected String getBeanName() {
		
		return "wechatWorkappIdentify";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return WechatWorkappIdentifyTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, WechatWorkappIdentifyTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, WechatWorkappIdentifyTokens.SECUSER);
 	}
 	

 	
 
		

	

	protected WechatWorkappIdentifyMapper getWechatWorkappIdentifyMapper(){
		return new WechatWorkappIdentifyMapper();
	}

	
	
	protected WechatWorkappIdentify extractWechatWorkappIdentify(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			WechatWorkappIdentify wechatWorkappIdentify = loadSingleObject(accessKey, getWechatWorkappIdentifyMapper());
			return wechatWorkappIdentify;
		}catch(EmptyResultDataAccessException e){
			throw new WechatWorkappIdentifyNotFoundException("WechatWorkappIdentify("+accessKey+") is not found!");
		}

	}

	
	

	protected WechatWorkappIdentify loadInternalWechatWorkappIdentify(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		WechatWorkappIdentify wechatWorkappIdentify = extractWechatWorkappIdentify(accessKey, loadOptions);
 	
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(wechatWorkappIdentify, loadOptions);
 		}
 
		
		return wechatWorkappIdentify;
		
	}

	 

 	protected WechatWorkappIdentify extractSecUser(WechatWorkappIdentify wechatWorkappIdentify, Map<String,Object> options) throws Exception{

		if(wechatWorkappIdentify.getSecUser() == null){
			return wechatWorkappIdentify;
		}
		String secUserId = wechatWorkappIdentify.getSecUser().getId();
		if( secUserId == null){
			return wechatWorkappIdentify;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			wechatWorkappIdentify.setSecUser(secUser);
		}
		
 		
 		return wechatWorkappIdentify;
 	}
 		
 
		
		
  	
 	public SmartList<WechatWorkappIdentify> findWechatWorkappIdentifyBySecUser(String secUserId,Map<String,Object> options){
 	
  		SmartList<WechatWorkappIdentify> resultList = queryWith(WechatWorkappIdentifyTable.COLUMN_SEC_USER, secUserId, options, getWechatWorkappIdentifyMapper());
		// analyzeWechatWorkappIdentifyBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<WechatWorkappIdentify> findWechatWorkappIdentifyBySecUser(String secUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<WechatWorkappIdentify> resultList =  queryWithRange(WechatWorkappIdentifyTable.COLUMN_SEC_USER, secUserId, options, getWechatWorkappIdentifyMapper(), start, count);
 		//analyzeWechatWorkappIdentifyBySecUser(resultList, secUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeWechatWorkappIdentifyBySecUser(SmartList<WechatWorkappIdentify> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(WechatWorkappIdentify.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//WechatWorkappIdentify.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("微信Workapp识别");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(WechatWorkappIdentify.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(WechatWorkappIdentify.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countWechatWorkappIdentifyBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(WechatWorkappIdentifyTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countWechatWorkappIdentifyBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(WechatWorkappIdentifyTable.COLUMN_SEC_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected WechatWorkappIdentify saveWechatWorkappIdentify(WechatWorkappIdentify  wechatWorkappIdentify){
		
		if(!wechatWorkappIdentify.isChanged()){
			return wechatWorkappIdentify;
		}
		
		
		String SQL=this.getSaveWechatWorkappIdentifySQL(wechatWorkappIdentify);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWechatWorkappIdentifyParameters(wechatWorkappIdentify);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		wechatWorkappIdentify.incVersion();
		return wechatWorkappIdentify;
	
	}
	public SmartList<WechatWorkappIdentify> saveWechatWorkappIdentifyList(SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWechatWorkappIdentifyList(wechatWorkappIdentifyList);
		
		batchWechatWorkappIdentifyCreate((List<WechatWorkappIdentify>)lists[CREATE_LIST_INDEX]);
		
		batchWechatWorkappIdentifyUpdate((List<WechatWorkappIdentify>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(WechatWorkappIdentify wechatWorkappIdentify:wechatWorkappIdentifyList){
			if(wechatWorkappIdentify.isChanged()){
				wechatWorkappIdentify.incVersion();
			}
			
		
		}
		
		
		return wechatWorkappIdentifyList;
	}

	public SmartList<WechatWorkappIdentify> removeWechatWorkappIdentifyList(SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList,Map<String,Object> options){
		
		
		super.removeList(wechatWorkappIdentifyList, options);
		
		return wechatWorkappIdentifyList;
		
		
	}
	
	protected List<Object[]> prepareWechatWorkappIdentifyBatchCreateArgs(List<WechatWorkappIdentify> wechatWorkappIdentifyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatWorkappIdentify wechatWorkappIdentify:wechatWorkappIdentifyList ){
			Object [] parameters = prepareWechatWorkappIdentifyCreateParameters(wechatWorkappIdentify);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareWechatWorkappIdentifyBatchUpdateArgs(List<WechatWorkappIdentify> wechatWorkappIdentifyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatWorkappIdentify wechatWorkappIdentify:wechatWorkappIdentifyList ){
			if(!wechatWorkappIdentify.isChanged()){
				continue;
			}
			Object [] parameters = prepareWechatWorkappIdentifyUpdateParameters(wechatWorkappIdentify);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchWechatWorkappIdentifyCreate(List<WechatWorkappIdentify> wechatWorkappIdentifyList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWechatWorkappIdentifyBatchCreateArgs(wechatWorkappIdentifyList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchWechatWorkappIdentifyUpdate(List<WechatWorkappIdentify> wechatWorkappIdentifyList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWechatWorkappIdentifyBatchUpdateArgs(wechatWorkappIdentifyList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitWechatWorkappIdentifyList(List<WechatWorkappIdentify> wechatWorkappIdentifyList){
		
		List<WechatWorkappIdentify> wechatWorkappIdentifyCreateList=new ArrayList<WechatWorkappIdentify>();
		List<WechatWorkappIdentify> wechatWorkappIdentifyUpdateList=new ArrayList<WechatWorkappIdentify>();
		
		for(WechatWorkappIdentify wechatWorkappIdentify: wechatWorkappIdentifyList){
			if(isUpdateRequest(wechatWorkappIdentify)){
				wechatWorkappIdentifyUpdateList.add( wechatWorkappIdentify);
				continue;
			}
			wechatWorkappIdentifyCreateList.add(wechatWorkappIdentify);
		}
		
		return new Object[]{wechatWorkappIdentifyCreateList,wechatWorkappIdentifyUpdateList};
	}
	
	protected boolean isUpdateRequest(WechatWorkappIdentify wechatWorkappIdentify){
 		return wechatWorkappIdentify.getVersion() > 0;
 	}
 	protected String getSaveWechatWorkappIdentifySQL(WechatWorkappIdentify wechatWorkappIdentify){
 		if(isUpdateRequest(wechatWorkappIdentify)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveWechatWorkappIdentifyParameters(WechatWorkappIdentify wechatWorkappIdentify){
 		if(isUpdateRequest(wechatWorkappIdentify) ){
 			return prepareWechatWorkappIdentifyUpdateParameters(wechatWorkappIdentify);
 		}
 		return prepareWechatWorkappIdentifyCreateParameters(wechatWorkappIdentify);
 	}
 	protected Object[] prepareWechatWorkappIdentifyUpdateParameters(WechatWorkappIdentify wechatWorkappIdentify){
 		Object[] parameters = new Object[8];
 
 		
 		parameters[0] = wechatWorkappIdentify.getCorpId();
 		
 		
 		parameters[1] = wechatWorkappIdentify.getUserId();
 		 	
 		if(wechatWorkappIdentify.getSecUser() != null){
 			parameters[2] = wechatWorkappIdentify.getSecUser().getId();
 		}
 
 		
 		parameters[3] = wechatWorkappIdentify.getCreateTime();
 		
 		
 		parameters[4] = wechatWorkappIdentify.getLastLoginTime();
 				
 		parameters[5] = wechatWorkappIdentify.nextVersion();
 		parameters[6] = wechatWorkappIdentify.getId();
 		parameters[7] = wechatWorkappIdentify.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareWechatWorkappIdentifyCreateParameters(WechatWorkappIdentify wechatWorkappIdentify){
		Object[] parameters = new Object[6];
		String newWechatWorkappIdentifyId=getNextId();
		wechatWorkappIdentify.setId(newWechatWorkappIdentifyId);
		parameters[0] =  wechatWorkappIdentify.getId();
 
 		
 		parameters[1] = wechatWorkappIdentify.getCorpId();
 		
 		
 		parameters[2] = wechatWorkappIdentify.getUserId();
 		 	
 		if(wechatWorkappIdentify.getSecUser() != null){
 			parameters[3] = wechatWorkappIdentify.getSecUser().getId();
 		
 		}
 		
 		
 		parameters[4] = wechatWorkappIdentify.getCreateTime();
 		
 		
 		parameters[5] = wechatWorkappIdentify.getLastLoginTime();
 				
 				
 		return parameters;
 	}
 	
	protected WechatWorkappIdentify saveInternalWechatWorkappIdentify(WechatWorkappIdentify wechatWorkappIdentify, Map<String,Object> options){
		
		saveWechatWorkappIdentify(wechatWorkappIdentify);
 	
 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(wechatWorkappIdentify, options);
 		}
 
		
		return wechatWorkappIdentify;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected WechatWorkappIdentify saveSecUser(WechatWorkappIdentify wechatWorkappIdentify, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(wechatWorkappIdentify.getSecUser() == null){
 			return wechatWorkappIdentify;//do nothing when it is null
 		}
 		
 		getSecUserDAO().save(wechatWorkappIdentify.getSecUser(),options);
 		return wechatWorkappIdentify;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public WechatWorkappIdentify present(WechatWorkappIdentify wechatWorkappIdentify,Map<String, Object> options){
	

		return wechatWorkappIdentify;
	
	}
		

	

	protected String getTableName(){
		return WechatWorkappIdentifyTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<WechatWorkappIdentify> wechatWorkappIdentifyList) {		
		this.enhanceListInternal(wechatWorkappIdentifyList, this.getWechatWorkappIdentifyMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<WechatWorkappIdentify> wechatWorkappIdentifyList = ownerEntity.collectRefsWithType(WechatWorkappIdentify.INTERNAL_TYPE);
		this.enhanceList(wechatWorkappIdentifyList);
		
	}
	
	@Override
	public SmartList<WechatWorkappIdentify> findWechatWorkappIdentifyWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getWechatWorkappIdentifyMapper());

	}
	@Override
	public int countWechatWorkappIdentifyWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countWechatWorkappIdentifyWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<WechatWorkappIdentify> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getWechatWorkappIdentifyMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateWechatWorkappIdentify executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateWechatWorkappIdentify result = new CandidateWechatWorkappIdentify();
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


