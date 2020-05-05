
package com.doublechaintech.retailscm.wechatminiappidentify;

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


public class WechatMiniappIdentifyJDBCTemplateDAO extends RetailscmBaseDAOImpl implements WechatMiniappIdentifyDAO{

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
	protected WechatMiniappIdentify load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWechatMiniappIdentify(accessKey, options);
	}
	*/
	
	public SmartList<WechatMiniappIdentify> loadAll() {
	    return this.loadAll(getWechatMiniappIdentifyMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public WechatMiniappIdentify load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWechatMiniappIdentify(WechatMiniappIdentifyTable.withId(id), options);
	}
	
	
	
	public WechatMiniappIdentify save(WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object> options){
		
		String methodName="save(WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(wechatMiniappIdentify, methodName, "wechatMiniappIdentify");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalWechatMiniappIdentify(wechatMiniappIdentify,options);
	}
	public WechatMiniappIdentify clone(String wechatMiniappIdentifyId, Map<String,Object> options) throws Exception{
	
		return clone(WechatMiniappIdentifyTable.withId(wechatMiniappIdentifyId),options);
	}
	
	protected WechatMiniappIdentify clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String wechatMiniappIdentifyId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		WechatMiniappIdentify newWechatMiniappIdentify = loadInternalWechatMiniappIdentify(accessKey, options);
		newWechatMiniappIdentify.setVersion(0);
		
		

		
		saveInternalWechatMiniappIdentify(newWechatMiniappIdentify,options);
		
		return newWechatMiniappIdentify;
	}
	
	
	
	

	protected void throwIfHasException(String wechatMiniappIdentifyId,int version,int count) throws Exception{
		if (count == 1) {
			throw new WechatMiniappIdentifyVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WechatMiniappIdentifyNotFoundException(
					"The " + this.getTableName() + "(" + wechatMiniappIdentifyId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String wechatMiniappIdentifyId, int version) throws Exception{
	
		String methodName="delete(String wechatMiniappIdentifyId, int version)";
		assertMethodArgumentNotNull(wechatMiniappIdentifyId, methodName, "wechatMiniappIdentifyId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{wechatMiniappIdentifyId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(wechatMiniappIdentifyId,version);
		}
		
	
	}
	
	
	
	
	

	public WechatMiniappIdentify disconnectFromAll(String wechatMiniappIdentifyId, int version) throws Exception{
	
		
		WechatMiniappIdentify wechatMiniappIdentify = loadInternalWechatMiniappIdentify(WechatMiniappIdentifyTable.withId(wechatMiniappIdentifyId), emptyOptions());
		wechatMiniappIdentify.clearFromAll();
		this.saveWechatMiniappIdentify(wechatMiniappIdentify);
		return wechatMiniappIdentify;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return WechatMiniappIdentifyTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "wechat_miniapp_identify";
	}
	@Override
	protected String getBeanName() {
		
		return "wechatMiniappIdentify";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return WechatMiniappIdentifyTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, WechatMiniappIdentifyTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, WechatMiniappIdentifyTokens.SECUSER);
 	}
 	

 	
 
		

	

	protected WechatMiniappIdentifyMapper getWechatMiniappIdentifyMapper(){
		return new WechatMiniappIdentifyMapper();
	}

	
	
	protected WechatMiniappIdentify extractWechatMiniappIdentify(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			WechatMiniappIdentify wechatMiniappIdentify = loadSingleObject(accessKey, getWechatMiniappIdentifyMapper());
			return wechatMiniappIdentify;
		}catch(EmptyResultDataAccessException e){
			throw new WechatMiniappIdentifyNotFoundException("WechatMiniappIdentify("+accessKey+") is not found!");
		}

	}

	
	

	protected WechatMiniappIdentify loadInternalWechatMiniappIdentify(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		WechatMiniappIdentify wechatMiniappIdentify = extractWechatMiniappIdentify(accessKey, loadOptions);
 	
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(wechatMiniappIdentify, loadOptions);
 		}
 
		
		return wechatMiniappIdentify;
		
	}

	 

 	protected WechatMiniappIdentify extractSecUser(WechatMiniappIdentify wechatMiniappIdentify, Map<String,Object> options) throws Exception{

		if(wechatMiniappIdentify.getSecUser() == null){
			return wechatMiniappIdentify;
		}
		String secUserId = wechatMiniappIdentify.getSecUser().getId();
		if( secUserId == null){
			return wechatMiniappIdentify;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			wechatMiniappIdentify.setSecUser(secUser);
		}
		
 		
 		return wechatMiniappIdentify;
 	}
 		
 
		
		
  	
 	public SmartList<WechatMiniappIdentify> findWechatMiniappIdentifyBySecUser(String secUserId,Map<String,Object> options){
 	
  		SmartList<WechatMiniappIdentify> resultList = queryWith(WechatMiniappIdentifyTable.COLUMN_SEC_USER, secUserId, options, getWechatMiniappIdentifyMapper());
		// analyzeWechatMiniappIdentifyBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<WechatMiniappIdentify> findWechatMiniappIdentifyBySecUser(String secUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<WechatMiniappIdentify> resultList =  queryWithRange(WechatMiniappIdentifyTable.COLUMN_SEC_USER, secUserId, options, getWechatMiniappIdentifyMapper(), start, count);
 		//analyzeWechatMiniappIdentifyBySecUser(resultList, secUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeWechatMiniappIdentifyBySecUser(SmartList<WechatMiniappIdentify> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(WechatMiniappIdentify.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//WechatMiniappIdentify.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("微信Miniapp识别");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(WechatMiniappIdentify.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(WechatMiniappIdentify.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countWechatMiniappIdentifyBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(WechatMiniappIdentifyTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countWechatMiniappIdentifyBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(WechatMiniappIdentifyTable.COLUMN_SEC_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected WechatMiniappIdentify saveWechatMiniappIdentify(WechatMiniappIdentify  wechatMiniappIdentify){
		
		if(!wechatMiniappIdentify.isChanged()){
			return wechatMiniappIdentify;
		}
		
		
		String SQL=this.getSaveWechatMiniappIdentifySQL(wechatMiniappIdentify);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWechatMiniappIdentifyParameters(wechatMiniappIdentify);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		wechatMiniappIdentify.incVersion();
		return wechatMiniappIdentify;
	
	}
	public SmartList<WechatMiniappIdentify> saveWechatMiniappIdentifyList(SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWechatMiniappIdentifyList(wechatMiniappIdentifyList);
		
		batchWechatMiniappIdentifyCreate((List<WechatMiniappIdentify>)lists[CREATE_LIST_INDEX]);
		
		batchWechatMiniappIdentifyUpdate((List<WechatMiniappIdentify>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(WechatMiniappIdentify wechatMiniappIdentify:wechatMiniappIdentifyList){
			if(wechatMiniappIdentify.isChanged()){
				wechatMiniappIdentify.incVersion();
			}
			
		
		}
		
		
		return wechatMiniappIdentifyList;
	}

	public SmartList<WechatMiniappIdentify> removeWechatMiniappIdentifyList(SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList,Map<String,Object> options){
		
		
		super.removeList(wechatMiniappIdentifyList, options);
		
		return wechatMiniappIdentifyList;
		
		
	}
	
	protected List<Object[]> prepareWechatMiniappIdentifyBatchCreateArgs(List<WechatMiniappIdentify> wechatMiniappIdentifyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatMiniappIdentify wechatMiniappIdentify:wechatMiniappIdentifyList ){
			Object [] parameters = prepareWechatMiniappIdentifyCreateParameters(wechatMiniappIdentify);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareWechatMiniappIdentifyBatchUpdateArgs(List<WechatMiniappIdentify> wechatMiniappIdentifyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatMiniappIdentify wechatMiniappIdentify:wechatMiniappIdentifyList ){
			if(!wechatMiniappIdentify.isChanged()){
				continue;
			}
			Object [] parameters = prepareWechatMiniappIdentifyUpdateParameters(wechatMiniappIdentify);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchWechatMiniappIdentifyCreate(List<WechatMiniappIdentify> wechatMiniappIdentifyList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWechatMiniappIdentifyBatchCreateArgs(wechatMiniappIdentifyList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchWechatMiniappIdentifyUpdate(List<WechatMiniappIdentify> wechatMiniappIdentifyList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWechatMiniappIdentifyBatchUpdateArgs(wechatMiniappIdentifyList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitWechatMiniappIdentifyList(List<WechatMiniappIdentify> wechatMiniappIdentifyList){
		
		List<WechatMiniappIdentify> wechatMiniappIdentifyCreateList=new ArrayList<WechatMiniappIdentify>();
		List<WechatMiniappIdentify> wechatMiniappIdentifyUpdateList=new ArrayList<WechatMiniappIdentify>();
		
		for(WechatMiniappIdentify wechatMiniappIdentify: wechatMiniappIdentifyList){
			if(isUpdateRequest(wechatMiniappIdentify)){
				wechatMiniappIdentifyUpdateList.add( wechatMiniappIdentify);
				continue;
			}
			wechatMiniappIdentifyCreateList.add(wechatMiniappIdentify);
		}
		
		return new Object[]{wechatMiniappIdentifyCreateList,wechatMiniappIdentifyUpdateList};
	}
	
	protected boolean isUpdateRequest(WechatMiniappIdentify wechatMiniappIdentify){
 		return wechatMiniappIdentify.getVersion() > 0;
 	}
 	protected String getSaveWechatMiniappIdentifySQL(WechatMiniappIdentify wechatMiniappIdentify){
 		if(isUpdateRequest(wechatMiniappIdentify)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveWechatMiniappIdentifyParameters(WechatMiniappIdentify wechatMiniappIdentify){
 		if(isUpdateRequest(wechatMiniappIdentify) ){
 			return prepareWechatMiniappIdentifyUpdateParameters(wechatMiniappIdentify);
 		}
 		return prepareWechatMiniappIdentifyCreateParameters(wechatMiniappIdentify);
 	}
 	protected Object[] prepareWechatMiniappIdentifyUpdateParameters(WechatMiniappIdentify wechatMiniappIdentify){
 		Object[] parameters = new Object[8];
 
 		
 		parameters[0] = wechatMiniappIdentify.getOpenId();
 		
 		
 		parameters[1] = wechatMiniappIdentify.getAppId();
 		 	
 		if(wechatMiniappIdentify.getSecUser() != null){
 			parameters[2] = wechatMiniappIdentify.getSecUser().getId();
 		}
 
 		
 		parameters[3] = wechatMiniappIdentify.getCreateTime();
 		
 		
 		parameters[4] = wechatMiniappIdentify.getLastLoginTime();
 				
 		parameters[5] = wechatMiniappIdentify.nextVersion();
 		parameters[6] = wechatMiniappIdentify.getId();
 		parameters[7] = wechatMiniappIdentify.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareWechatMiniappIdentifyCreateParameters(WechatMiniappIdentify wechatMiniappIdentify){
		Object[] parameters = new Object[6];
		String newWechatMiniappIdentifyId=getNextId();
		wechatMiniappIdentify.setId(newWechatMiniappIdentifyId);
		parameters[0] =  wechatMiniappIdentify.getId();
 
 		
 		parameters[1] = wechatMiniappIdentify.getOpenId();
 		
 		
 		parameters[2] = wechatMiniappIdentify.getAppId();
 		 	
 		if(wechatMiniappIdentify.getSecUser() != null){
 			parameters[3] = wechatMiniappIdentify.getSecUser().getId();
 		
 		}
 		
 		
 		parameters[4] = wechatMiniappIdentify.getCreateTime();
 		
 		
 		parameters[5] = wechatMiniappIdentify.getLastLoginTime();
 				
 				
 		return parameters;
 	}
 	
	protected WechatMiniappIdentify saveInternalWechatMiniappIdentify(WechatMiniappIdentify wechatMiniappIdentify, Map<String,Object> options){
		
		saveWechatMiniappIdentify(wechatMiniappIdentify);
 	
 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(wechatMiniappIdentify, options);
 		}
 
		
		return wechatMiniappIdentify;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected WechatMiniappIdentify saveSecUser(WechatMiniappIdentify wechatMiniappIdentify, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(wechatMiniappIdentify.getSecUser() == null){
 			return wechatMiniappIdentify;//do nothing when it is null
 		}
 		
 		getSecUserDAO().save(wechatMiniappIdentify.getSecUser(),options);
 		return wechatMiniappIdentify;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public WechatMiniappIdentify present(WechatMiniappIdentify wechatMiniappIdentify,Map<String, Object> options){
	

		return wechatMiniappIdentify;
	
	}
		

	

	protected String getTableName(){
		return WechatMiniappIdentifyTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<WechatMiniappIdentify> wechatMiniappIdentifyList) {		
		this.enhanceListInternal(wechatMiniappIdentifyList, this.getWechatMiniappIdentifyMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<WechatMiniappIdentify> wechatMiniappIdentifyList = ownerEntity.collectRefsWithType(WechatMiniappIdentify.INTERNAL_TYPE);
		this.enhanceList(wechatMiniappIdentifyList);
		
	}
	
	@Override
	public SmartList<WechatMiniappIdentify> findWechatMiniappIdentifyWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getWechatMiniappIdentifyMapper());

	}
	@Override
	public int countWechatMiniappIdentifyWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countWechatMiniappIdentifyWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<WechatMiniappIdentify> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getWechatMiniappIdentifyMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateWechatMiniappIdentify executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateWechatMiniappIdentify result = new CandidateWechatMiniappIdentify();
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


