
package com.doublechaintech.retailscm.wechatminiappidentity;

import com.doublechaintech.retailscm.Beans;
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

public class WechatMiniappIdentityJDBCTemplateDAO extends RetailscmBaseDAOImpl implements WechatMiniappIdentityDAO{

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
	protected WechatMiniappIdentity load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWechatMiniappIdentity(accessKey, options);
	}
	*/

	public SmartList<WechatMiniappIdentity> loadAll() {
	    return this.loadAll(getWechatMiniappIdentityMapper());
	}

  public Stream<WechatMiniappIdentity> loadAllAsStream() {
      return this.loadAllAsStream(getWechatMiniappIdentityMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public WechatMiniappIdentity load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWechatMiniappIdentity(WechatMiniappIdentityTable.withId(id), options);
	}

	

	public WechatMiniappIdentity save(WechatMiniappIdentity wechatMiniappIdentity,Map<String,Object> options){

		String methodName="save(WechatMiniappIdentity wechatMiniappIdentity,Map<String,Object> options)";

		assertMethodArgumentNotNull(wechatMiniappIdentity, methodName, "wechatMiniappIdentity");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalWechatMiniappIdentity(wechatMiniappIdentity,options);
	}
	public WechatMiniappIdentity clone(String wechatMiniappIdentityId, Map<String,Object> options) throws Exception{

		return clone(WechatMiniappIdentityTable.withId(wechatMiniappIdentityId),options);
	}

	protected WechatMiniappIdentity clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String wechatMiniappIdentityId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		WechatMiniappIdentity newWechatMiniappIdentity = loadInternalWechatMiniappIdentity(accessKey, options);
		newWechatMiniappIdentity.setVersion(0);
		
		


		saveInternalWechatMiniappIdentity(newWechatMiniappIdentity,options);

		return newWechatMiniappIdentity;
	}

	



	protected void throwIfHasException(String wechatMiniappIdentityId,int version,int count) throws Exception{
		if (count == 1) {
			throw new WechatMiniappIdentityVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WechatMiniappIdentityNotFoundException(
					"The " + this.getTableName() + "(" + wechatMiniappIdentityId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String wechatMiniappIdentityId, int version) throws Exception{

		String methodName="delete(String wechatMiniappIdentityId, int version)";
		assertMethodArgumentNotNull(wechatMiniappIdentityId, methodName, "wechatMiniappIdentityId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{wechatMiniappIdentityId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(wechatMiniappIdentityId,version);
		}


	}






	public WechatMiniappIdentity disconnectFromAll(String wechatMiniappIdentityId, int version) throws Exception{


		WechatMiniappIdentity wechatMiniappIdentity = loadInternalWechatMiniappIdentity(WechatMiniappIdentityTable.withId(wechatMiniappIdentityId), emptyOptions());
		wechatMiniappIdentity.clearFromAll();
		this.saveWechatMiniappIdentity(wechatMiniappIdentity);
		return wechatMiniappIdentity;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return WechatMiniappIdentityTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "wechat_miniapp_identity";
	}
	@Override
	protected String getBeanName() {

		return "wechatMiniappIdentity";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return WechatMiniappIdentityTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){

	 	return checkOptions(options, WechatMiniappIdentityTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){

 		return checkOptions(options, WechatMiniappIdentityTokens.SECUSER);
 	}



 
		

	

	protected WechatMiniappIdentityMapper getWechatMiniappIdentityMapper(){
		return new WechatMiniappIdentityMapper();
	}



	protected WechatMiniappIdentity extractWechatMiniappIdentity(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			WechatMiniappIdentity wechatMiniappIdentity = loadSingleObject(accessKey, getWechatMiniappIdentityMapper());
			return wechatMiniappIdentity;
		}catch(EmptyResultDataAccessException e){
			throw new WechatMiniappIdentityNotFoundException("WechatMiniappIdentity("+accessKey+") is not found!");
		}

	}




	protected WechatMiniappIdentity loadInternalWechatMiniappIdentity(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		WechatMiniappIdentity wechatMiniappIdentity = extractWechatMiniappIdentity(accessKey, loadOptions);

 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(wechatMiniappIdentity, loadOptions);
 		}
 
		
		return wechatMiniappIdentity;

	}

	

 	protected WechatMiniappIdentity extractSecUser(WechatMiniappIdentity wechatMiniappIdentity, Map<String,Object> options) throws Exception{
  

		if(wechatMiniappIdentity.getSecUser() == null){
			return wechatMiniappIdentity;
		}
		String secUserId = wechatMiniappIdentity.getSecUser().getId();
		if( secUserId == null){
			return wechatMiniappIdentity;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			wechatMiniappIdentity.setSecUser(secUser);
		}


 		return wechatMiniappIdentity;
 	}

 
		

 
 	public SmartList<WechatMiniappIdentity> findWechatMiniappIdentityBySecUser(String secUserId,Map<String,Object> options){

  		SmartList<WechatMiniappIdentity> resultList = queryWith(WechatMiniappIdentityTable.COLUMN_SEC_USER, secUserId, options, getWechatMiniappIdentityMapper());
		// analyzeWechatMiniappIdentityBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	

 	public SmartList<WechatMiniappIdentity> findWechatMiniappIdentityBySecUser(String secUserId, int start, int count,Map<String,Object> options){

 		SmartList<WechatMiniappIdentity> resultList =  queryWithRange(WechatMiniappIdentityTable.COLUMN_SEC_USER, secUserId, options, getWechatMiniappIdentityMapper(), start, count);
 		//analyzeWechatMiniappIdentityBySecUser(resultList, secUserId, options);
 		return resultList;

 	}
 	public void analyzeWechatMiniappIdentityBySecUser(SmartList<WechatMiniappIdentity> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(WechatMiniappIdentity.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem createTimeStatsItem = new StatsItem();
		//WechatMiniappIdentity.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("微信小程序认证");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(WechatMiniappIdentity.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(WechatMiniappIdentity.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countWechatMiniappIdentityBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(WechatMiniappIdentityTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countWechatMiniappIdentityBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(WechatMiniappIdentityTable.COLUMN_SEC_USER, ids, options);
	}

 




	

	protected WechatMiniappIdentity saveWechatMiniappIdentity(WechatMiniappIdentity  wechatMiniappIdentity){
    

		
		if(!wechatMiniappIdentity.isChanged()){
			return wechatMiniappIdentity;
		}
		

    Beans.dbUtil().cacheCleanUp(wechatMiniappIdentity);
		String SQL=this.getSaveWechatMiniappIdentitySQL(wechatMiniappIdentity);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWechatMiniappIdentityParameters(wechatMiniappIdentity);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		wechatMiniappIdentity.incVersion();
		wechatMiniappIdentity.afterSave();
		return wechatMiniappIdentity;

	}
	public SmartList<WechatMiniappIdentity> saveWechatMiniappIdentityList(SmartList<WechatMiniappIdentity> wechatMiniappIdentityList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWechatMiniappIdentityList(wechatMiniappIdentityList);

		batchWechatMiniappIdentityCreate((List<WechatMiniappIdentity>)lists[CREATE_LIST_INDEX]);

		batchWechatMiniappIdentityUpdate((List<WechatMiniappIdentity>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(WechatMiniappIdentity wechatMiniappIdentity:wechatMiniappIdentityList){
			if(wechatMiniappIdentity.isChanged()){
				wechatMiniappIdentity.incVersion();
				wechatMiniappIdentity.afterSave();
			}


		}


		return wechatMiniappIdentityList;
	}

	public SmartList<WechatMiniappIdentity> removeWechatMiniappIdentityList(SmartList<WechatMiniappIdentity> wechatMiniappIdentityList,Map<String,Object> options){


		super.removeList(wechatMiniappIdentityList, options);

		return wechatMiniappIdentityList;


	}

	protected List<Object[]> prepareWechatMiniappIdentityBatchCreateArgs(List<WechatMiniappIdentity> wechatMiniappIdentityList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatMiniappIdentity wechatMiniappIdentity:wechatMiniappIdentityList ){
			Object [] parameters = prepareWechatMiniappIdentityCreateParameters(wechatMiniappIdentity);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareWechatMiniappIdentityBatchUpdateArgs(List<WechatMiniappIdentity> wechatMiniappIdentityList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatMiniappIdentity wechatMiniappIdentity:wechatMiniappIdentityList ){
			if(!wechatMiniappIdentity.isChanged()){
				continue;
			}
			Object [] parameters = prepareWechatMiniappIdentityUpdateParameters(wechatMiniappIdentity);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchWechatMiniappIdentityCreate(List<WechatMiniappIdentity> wechatMiniappIdentityList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWechatMiniappIdentityBatchCreateArgs(wechatMiniappIdentityList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchWechatMiniappIdentityUpdate(List<WechatMiniappIdentity> wechatMiniappIdentityList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWechatMiniappIdentityBatchUpdateArgs(wechatMiniappIdentityList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitWechatMiniappIdentityList(List<WechatMiniappIdentity> wechatMiniappIdentityList){

		List<WechatMiniappIdentity> wechatMiniappIdentityCreateList=new ArrayList<WechatMiniappIdentity>();
		List<WechatMiniappIdentity> wechatMiniappIdentityUpdateList=new ArrayList<WechatMiniappIdentity>();

		for(WechatMiniappIdentity wechatMiniappIdentity: wechatMiniappIdentityList){
			if(isUpdateRequest(wechatMiniappIdentity)){
				wechatMiniappIdentityUpdateList.add( wechatMiniappIdentity);
				continue;
			}
			wechatMiniappIdentityCreateList.add(wechatMiniappIdentity);
		}

		return new Object[]{wechatMiniappIdentityCreateList,wechatMiniappIdentityUpdateList};
	}

	protected boolean isUpdateRequest(WechatMiniappIdentity wechatMiniappIdentity){
 		return wechatMiniappIdentity.getVersion() > 0;
 	}
 	protected String getSaveWechatMiniappIdentitySQL(WechatMiniappIdentity wechatMiniappIdentity){
 		if(isUpdateRequest(wechatMiniappIdentity)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveWechatMiniappIdentityParameters(WechatMiniappIdentity wechatMiniappIdentity){
 		if(isUpdateRequest(wechatMiniappIdentity) ){
 			return prepareWechatMiniappIdentityUpdateParameters(wechatMiniappIdentity);
 		}
 		return prepareWechatMiniappIdentityCreateParameters(wechatMiniappIdentity);
 	}
 	protected Object[] prepareWechatMiniappIdentityUpdateParameters(WechatMiniappIdentity wechatMiniappIdentity){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = wechatMiniappIdentity.getOpenId();
 		
 		parameters[1] = wechatMiniappIdentity.getAppId();
 		
 		parameters[2] = wechatMiniappIdentity.getUnionId();
 		
 		if(wechatMiniappIdentity.getSecUser() != null){
 			parameters[3] = wechatMiniappIdentity.getSecUser().getId();
 		}
    
 		parameters[4] = wechatMiniappIdentity.getCreateTime();
 		
 		parameters[5] = wechatMiniappIdentity.getLastLoginTime();
 		
 		parameters[6] = wechatMiniappIdentity.nextVersion();
 		parameters[7] = wechatMiniappIdentity.getId();
 		parameters[8] = wechatMiniappIdentity.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareWechatMiniappIdentityCreateParameters(WechatMiniappIdentity wechatMiniappIdentity){
		Object[] parameters = new Object[7];
        if(wechatMiniappIdentity.getId() == null){
          String newWechatMiniappIdentityId=getNextId();
          wechatMiniappIdentity.setId(newWechatMiniappIdentityId);
        }
		parameters[0] =  wechatMiniappIdentity.getId();
 
 		parameters[1] = wechatMiniappIdentity.getOpenId();
 		
 		parameters[2] = wechatMiniappIdentity.getAppId();
 		
 		parameters[3] = wechatMiniappIdentity.getUnionId();
 		
 		if(wechatMiniappIdentity.getSecUser() != null){
 			parameters[4] = wechatMiniappIdentity.getSecUser().getId();
 		}
 		
 		parameters[5] = wechatMiniappIdentity.getCreateTime();
 		
 		parameters[6] = wechatMiniappIdentity.getLastLoginTime();
 		

 		return parameters;
 	}

	protected WechatMiniappIdentity saveInternalWechatMiniappIdentity(WechatMiniappIdentity wechatMiniappIdentity, Map<String,Object> options){

 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(wechatMiniappIdentity, options);
 		}
 
   saveWechatMiniappIdentity(wechatMiniappIdentity);
		
		return wechatMiniappIdentity;

	}



	//======================================================================================
	

 	protected WechatMiniappIdentity saveSecUser(WechatMiniappIdentity wechatMiniappIdentity, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(wechatMiniappIdentity.getSecUser() == null){
 			return wechatMiniappIdentity;//do nothing when it is null
 		}

 		getSecUserDAO().save(wechatMiniappIdentity.getSecUser(),options);
 		return wechatMiniappIdentity;

 	}
 

	

		

	public WechatMiniappIdentity present(WechatMiniappIdentity wechatMiniappIdentity,Map<String, Object> options){


		return wechatMiniappIdentity;

	}
		

	

	protected String getTableName(){
		return WechatMiniappIdentityTable.TABLE_NAME;
	}



	public void enhanceList(List<WechatMiniappIdentity> wechatMiniappIdentityList) {
		this.enhanceListInternal(wechatMiniappIdentityList, this.getWechatMiniappIdentityMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<WechatMiniappIdentity> wechatMiniappIdentityList = ownerEntity.collectRefsWithType(WechatMiniappIdentity.INTERNAL_TYPE);
		this.enhanceList(wechatMiniappIdentityList);

	}

	@Override
	public SmartList<WechatMiniappIdentity> findWechatMiniappIdentityWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getWechatMiniappIdentityMapper());

	}
	@Override
	public int countWechatMiniappIdentityWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countWechatMiniappIdentityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<WechatMiniappIdentity> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getWechatMiniappIdentityMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<WechatMiniappIdentity> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getWechatMiniappIdentityMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateWechatMiniappIdentity executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateWechatMiniappIdentity result = new CandidateWechatMiniappIdentity();
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

	

  @Override
  public List<WechatMiniappIdentity> search(WechatMiniappIdentityRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected WechatMiniappIdentityMapper mapper() {
    return getWechatMiniappIdentityMapper();
  }
}


