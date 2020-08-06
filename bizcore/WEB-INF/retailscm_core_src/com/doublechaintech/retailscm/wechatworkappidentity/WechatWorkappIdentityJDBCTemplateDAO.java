
package com.doublechaintech.retailscm.wechatworkappidentity;

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

public class WechatWorkappIdentityJDBCTemplateDAO extends RetailscmBaseDAOImpl implements WechatWorkappIdentityDAO{

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
	protected WechatWorkappIdentity load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWechatWorkappIdentity(accessKey, options);
	}
	*/

	public SmartList<WechatWorkappIdentity> loadAll() {
	    return this.loadAll(getWechatWorkappIdentityMapper());
	}

  public Stream<WechatWorkappIdentity> loadAllAsStream() {
      return this.loadAllAsStream(getWechatWorkappIdentityMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public WechatWorkappIdentity load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWechatWorkappIdentity(WechatWorkappIdentityTable.withId(id), options);
	}

	

	public WechatWorkappIdentity save(WechatWorkappIdentity wechatWorkappIdentity,Map<String,Object> options){

		String methodName="save(WechatWorkappIdentity wechatWorkappIdentity,Map<String,Object> options)";

		assertMethodArgumentNotNull(wechatWorkappIdentity, methodName, "wechatWorkappIdentity");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalWechatWorkappIdentity(wechatWorkappIdentity,options);
	}
	public WechatWorkappIdentity clone(String wechatWorkappIdentityId, Map<String,Object> options) throws Exception{

		return clone(WechatWorkappIdentityTable.withId(wechatWorkappIdentityId),options);
	}

	protected WechatWorkappIdentity clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String wechatWorkappIdentityId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		WechatWorkappIdentity newWechatWorkappIdentity = loadInternalWechatWorkappIdentity(accessKey, options);
		newWechatWorkappIdentity.setVersion(0);
		
		


		saveInternalWechatWorkappIdentity(newWechatWorkappIdentity,options);

		return newWechatWorkappIdentity;
	}

	



	protected void throwIfHasException(String wechatWorkappIdentityId,int version,int count) throws Exception{
		if (count == 1) {
			throw new WechatWorkappIdentityVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WechatWorkappIdentityNotFoundException(
					"The " + this.getTableName() + "(" + wechatWorkappIdentityId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String wechatWorkappIdentityId, int version) throws Exception{

		String methodName="delete(String wechatWorkappIdentityId, int version)";
		assertMethodArgumentNotNull(wechatWorkappIdentityId, methodName, "wechatWorkappIdentityId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{wechatWorkappIdentityId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(wechatWorkappIdentityId,version);
		}


	}






	public WechatWorkappIdentity disconnectFromAll(String wechatWorkappIdentityId, int version) throws Exception{


		WechatWorkappIdentity wechatWorkappIdentity = loadInternalWechatWorkappIdentity(WechatWorkappIdentityTable.withId(wechatWorkappIdentityId), emptyOptions());
		wechatWorkappIdentity.clearFromAll();
		this.saveWechatWorkappIdentity(wechatWorkappIdentity);
		return wechatWorkappIdentity;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return WechatWorkappIdentityTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "wechat_workapp_identity";
	}
	@Override
	protected String getBeanName() {

		return "wechatWorkappIdentity";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return WechatWorkappIdentityTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, WechatWorkappIdentityTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, WechatWorkappIdentityTokens.SECUSER);
 	}
 	

 	
 
		

	

	protected WechatWorkappIdentityMapper getWechatWorkappIdentityMapper(){
		return new WechatWorkappIdentityMapper();
	}

	
	
	protected WechatWorkappIdentity extractWechatWorkappIdentity(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			WechatWorkappIdentity wechatWorkappIdentity = loadSingleObject(accessKey, getWechatWorkappIdentityMapper());
			return wechatWorkappIdentity;
		}catch(EmptyResultDataAccessException e){
			throw new WechatWorkappIdentityNotFoundException("WechatWorkappIdentity("+accessKey+") is not found!");
		}

	}

	
	

	protected WechatWorkappIdentity loadInternalWechatWorkappIdentity(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		WechatWorkappIdentity wechatWorkappIdentity = extractWechatWorkappIdentity(accessKey, loadOptions);
 	
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(wechatWorkappIdentity, loadOptions);
 		}
 
		
		return wechatWorkappIdentity;
		
	}

	 

 	protected WechatWorkappIdentity extractSecUser(WechatWorkappIdentity wechatWorkappIdentity, Map<String,Object> options) throws Exception{

		if(wechatWorkappIdentity.getSecUser() == null){
			return wechatWorkappIdentity;
		}
		String secUserId = wechatWorkappIdentity.getSecUser().getId();
		if( secUserId == null){
			return wechatWorkappIdentity;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			wechatWorkappIdentity.setSecUser(secUser);
		}
		
 		
 		return wechatWorkappIdentity;
 	}
 		
 
		
		
  	
 	public SmartList<WechatWorkappIdentity> findWechatWorkappIdentityBySecUser(String secUserId,Map<String,Object> options){
 	
  		SmartList<WechatWorkappIdentity> resultList = queryWith(WechatWorkappIdentityTable.COLUMN_SEC_USER, secUserId, options, getWechatWorkappIdentityMapper());
		// analyzeWechatWorkappIdentityBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<WechatWorkappIdentity> findWechatWorkappIdentityBySecUser(String secUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<WechatWorkappIdentity> resultList =  queryWithRange(WechatWorkappIdentityTable.COLUMN_SEC_USER, secUserId, options, getWechatWorkappIdentityMapper(), start, count);
 		//analyzeWechatWorkappIdentityBySecUser(resultList, secUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeWechatWorkappIdentityBySecUser(SmartList<WechatWorkappIdentity> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(WechatWorkappIdentity.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//WechatWorkappIdentity.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("微信企业号认证");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(WechatWorkappIdentity.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(WechatWorkappIdentity.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countWechatWorkappIdentityBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(WechatWorkappIdentityTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countWechatWorkappIdentityBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(WechatWorkappIdentityTable.COLUMN_SEC_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected WechatWorkappIdentity saveWechatWorkappIdentity(WechatWorkappIdentity  wechatWorkappIdentity){
		
		if(!wechatWorkappIdentity.isChanged()){
			return wechatWorkappIdentity;
		}
		

		String SQL=this.getSaveWechatWorkappIdentitySQL(wechatWorkappIdentity);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWechatWorkappIdentityParameters(wechatWorkappIdentity);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		wechatWorkappIdentity.incVersion();
		return wechatWorkappIdentity;

	}
	public SmartList<WechatWorkappIdentity> saveWechatWorkappIdentityList(SmartList<WechatWorkappIdentity> wechatWorkappIdentityList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWechatWorkappIdentityList(wechatWorkappIdentityList);

		batchWechatWorkappIdentityCreate((List<WechatWorkappIdentity>)lists[CREATE_LIST_INDEX]);

		batchWechatWorkappIdentityUpdate((List<WechatWorkappIdentity>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(WechatWorkappIdentity wechatWorkappIdentity:wechatWorkappIdentityList){
			if(wechatWorkappIdentity.isChanged()){
				wechatWorkappIdentity.incVersion();
			}


		}


		return wechatWorkappIdentityList;
	}

	public SmartList<WechatWorkappIdentity> removeWechatWorkappIdentityList(SmartList<WechatWorkappIdentity> wechatWorkappIdentityList,Map<String,Object> options){


		super.removeList(wechatWorkappIdentityList, options);

		return wechatWorkappIdentityList;


	}

	protected List<Object[]> prepareWechatWorkappIdentityBatchCreateArgs(List<WechatWorkappIdentity> wechatWorkappIdentityList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatWorkappIdentity wechatWorkappIdentity:wechatWorkappIdentityList ){
			Object [] parameters = prepareWechatWorkappIdentityCreateParameters(wechatWorkappIdentity);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareWechatWorkappIdentityBatchUpdateArgs(List<WechatWorkappIdentity> wechatWorkappIdentityList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatWorkappIdentity wechatWorkappIdentity:wechatWorkappIdentityList ){
			if(!wechatWorkappIdentity.isChanged()){
				continue;
			}
			Object [] parameters = prepareWechatWorkappIdentityUpdateParameters(wechatWorkappIdentity);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchWechatWorkappIdentityCreate(List<WechatWorkappIdentity> wechatWorkappIdentityList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWechatWorkappIdentityBatchCreateArgs(wechatWorkappIdentityList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchWechatWorkappIdentityUpdate(List<WechatWorkappIdentity> wechatWorkappIdentityList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWechatWorkappIdentityBatchUpdateArgs(wechatWorkappIdentityList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitWechatWorkappIdentityList(List<WechatWorkappIdentity> wechatWorkappIdentityList){

		List<WechatWorkappIdentity> wechatWorkappIdentityCreateList=new ArrayList<WechatWorkappIdentity>();
		List<WechatWorkappIdentity> wechatWorkappIdentityUpdateList=new ArrayList<WechatWorkappIdentity>();

		for(WechatWorkappIdentity wechatWorkappIdentity: wechatWorkappIdentityList){
			if(isUpdateRequest(wechatWorkappIdentity)){
				wechatWorkappIdentityUpdateList.add( wechatWorkappIdentity);
				continue;
			}
			wechatWorkappIdentityCreateList.add(wechatWorkappIdentity);
		}

		return new Object[]{wechatWorkappIdentityCreateList,wechatWorkappIdentityUpdateList};
	}

	protected boolean isUpdateRequest(WechatWorkappIdentity wechatWorkappIdentity){
 		return wechatWorkappIdentity.getVersion() > 0;
 	}
 	protected String getSaveWechatWorkappIdentitySQL(WechatWorkappIdentity wechatWorkappIdentity){
 		if(isUpdateRequest(wechatWorkappIdentity)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveWechatWorkappIdentityParameters(WechatWorkappIdentity wechatWorkappIdentity){
 		if(isUpdateRequest(wechatWorkappIdentity) ){
 			return prepareWechatWorkappIdentityUpdateParameters(wechatWorkappIdentity);
 		}
 		return prepareWechatWorkappIdentityCreateParameters(wechatWorkappIdentity);
 	}
 	protected Object[] prepareWechatWorkappIdentityUpdateParameters(WechatWorkappIdentity wechatWorkappIdentity){
 		Object[] parameters = new Object[8];
 
 		
 		parameters[0] = wechatWorkappIdentity.getCorpId();
 		
 		
 		parameters[1] = wechatWorkappIdentity.getUserId();
 		
 		if(wechatWorkappIdentity.getSecUser() != null){
 			parameters[2] = wechatWorkappIdentity.getSecUser().getId();
 		}
 
 		
 		parameters[3] = wechatWorkappIdentity.getCreateTime();
 		
 		
 		parameters[4] = wechatWorkappIdentity.getLastLoginTime();
 		
 		parameters[5] = wechatWorkappIdentity.nextVersion();
 		parameters[6] = wechatWorkappIdentity.getId();
 		parameters[7] = wechatWorkappIdentity.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareWechatWorkappIdentityCreateParameters(WechatWorkappIdentity wechatWorkappIdentity){
		Object[] parameters = new Object[6];
        if(wechatWorkappIdentity.getId() == null){
          String newWechatWorkappIdentityId=getNextId();
          wechatWorkappIdentity.setId(newWechatWorkappIdentityId);
        }
		parameters[0] =  wechatWorkappIdentity.getId();
 
 		
 		parameters[1] = wechatWorkappIdentity.getCorpId();
 		
 		
 		parameters[2] = wechatWorkappIdentity.getUserId();
 		
 		if(wechatWorkappIdentity.getSecUser() != null){
 			parameters[3] = wechatWorkappIdentity.getSecUser().getId();

 		}
 		
 		
 		parameters[4] = wechatWorkappIdentity.getCreateTime();
 		
 		
 		parameters[5] = wechatWorkappIdentity.getLastLoginTime();
 		

 		return parameters;
 	}

	protected WechatWorkappIdentity saveInternalWechatWorkappIdentity(WechatWorkappIdentity wechatWorkappIdentity, Map<String,Object> options){

		saveWechatWorkappIdentity(wechatWorkappIdentity);

 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(wechatWorkappIdentity, options);
 		}
 
		
		return wechatWorkappIdentity;

	}



	//======================================================================================
	

 	protected WechatWorkappIdentity saveSecUser(WechatWorkappIdentity wechatWorkappIdentity, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(wechatWorkappIdentity.getSecUser() == null){
 			return wechatWorkappIdentity;//do nothing when it is null
 		}

 		getSecUserDAO().save(wechatWorkappIdentity.getSecUser(),options);
 		return wechatWorkappIdentity;

 	}





 

	

		

	public WechatWorkappIdentity present(WechatWorkappIdentity wechatWorkappIdentity,Map<String, Object> options){
	

		return wechatWorkappIdentity;
	
	}
		

	

	protected String getTableName(){
		return WechatWorkappIdentityTable.TABLE_NAME;
	}



	public void enhanceList(List<WechatWorkappIdentity> wechatWorkappIdentityList) {
		this.enhanceListInternal(wechatWorkappIdentityList, this.getWechatWorkappIdentityMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<WechatWorkappIdentity> wechatWorkappIdentityList = ownerEntity.collectRefsWithType(WechatWorkappIdentity.INTERNAL_TYPE);
		this.enhanceList(wechatWorkappIdentityList);

	}

	@Override
	public SmartList<WechatWorkappIdentity> findWechatWorkappIdentityWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getWechatWorkappIdentityMapper());

	}
	@Override
	public int countWechatWorkappIdentityWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countWechatWorkappIdentityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<WechatWorkappIdentity> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getWechatWorkappIdentityMapper());
	}

  @Override
  public Stream<WechatWorkappIdentity> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getWechatWorkappIdentityMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateWechatWorkappIdentity executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateWechatWorkappIdentity result = new CandidateWechatWorkappIdentity();
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


