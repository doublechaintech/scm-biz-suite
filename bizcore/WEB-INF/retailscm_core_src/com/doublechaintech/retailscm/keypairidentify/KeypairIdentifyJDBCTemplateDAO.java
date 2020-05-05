
package com.doublechaintech.retailscm.keypairidentify;

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
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class KeypairIdentifyJDBCTemplateDAO extends RetailscmBaseDAOImpl implements KeypairIdentifyDAO{

	protected PublicKeyTypeDAO publicKeyTypeDAO;
	public void setPublicKeyTypeDAO(PublicKeyTypeDAO publicKeyTypeDAO){
 	
 		if(publicKeyTypeDAO == null){
 			throw new IllegalStateException("Do not try to set publicKeyTypeDAO to null.");
 		}
	 	this.publicKeyTypeDAO = publicKeyTypeDAO;
 	}
 	public PublicKeyTypeDAO getPublicKeyTypeDAO(){
 		if(this.publicKeyTypeDAO == null){
 			throw new IllegalStateException("The publicKeyTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.publicKeyTypeDAO;
 	}	

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
	protected KeypairIdentify load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalKeypairIdentify(accessKey, options);
	}
	*/
	
	public SmartList<KeypairIdentify> loadAll() {
	    return this.loadAll(getKeypairIdentifyMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public KeypairIdentify load(String id,Map<String,Object> options) throws Exception{
		return loadInternalKeypairIdentify(KeypairIdentifyTable.withId(id), options);
	}
	
	
	
	public KeypairIdentify save(KeypairIdentify keypairIdentify,Map<String,Object> options){
		
		String methodName="save(KeypairIdentify keypairIdentify,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(keypairIdentify, methodName, "keypairIdentify");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalKeypairIdentify(keypairIdentify,options);
	}
	public KeypairIdentify clone(String keypairIdentifyId, Map<String,Object> options) throws Exception{
	
		return clone(KeypairIdentifyTable.withId(keypairIdentifyId),options);
	}
	
	protected KeypairIdentify clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String keypairIdentifyId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		KeypairIdentify newKeypairIdentify = loadInternalKeypairIdentify(accessKey, options);
		newKeypairIdentify.setVersion(0);
		
		

		
		saveInternalKeypairIdentify(newKeypairIdentify,options);
		
		return newKeypairIdentify;
	}
	
	
	
	

	protected void throwIfHasException(String keypairIdentifyId,int version,int count) throws Exception{
		if (count == 1) {
			throw new KeypairIdentifyVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new KeypairIdentifyNotFoundException(
					"The " + this.getTableName() + "(" + keypairIdentifyId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String keypairIdentifyId, int version) throws Exception{
	
		String methodName="delete(String keypairIdentifyId, int version)";
		assertMethodArgumentNotNull(keypairIdentifyId, methodName, "keypairIdentifyId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{keypairIdentifyId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(keypairIdentifyId,version);
		}
		
	
	}
	
	
	
	
	

	public KeypairIdentify disconnectFromAll(String keypairIdentifyId, int version) throws Exception{
	
		
		KeypairIdentify keypairIdentify = loadInternalKeypairIdentify(KeypairIdentifyTable.withId(keypairIdentifyId), emptyOptions());
		keypairIdentify.clearFromAll();
		this.saveKeypairIdentify(keypairIdentify);
		return keypairIdentify;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return KeypairIdentifyTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "keypair_identify";
	}
	@Override
	protected String getBeanName() {
		
		return "keypairIdentify";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return KeypairIdentifyTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractKeyTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, KeypairIdentifyTokens.KEYTYPE);
 	}

 	protected boolean isSaveKeyTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, KeypairIdentifyTokens.KEYTYPE);
 	}
 	

 	
  

 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, KeypairIdentifyTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, KeypairIdentifyTokens.SECUSER);
 	}
 	

 	
 
		

	

	protected KeypairIdentifyMapper getKeypairIdentifyMapper(){
		return new KeypairIdentifyMapper();
	}

	
	
	protected KeypairIdentify extractKeypairIdentify(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			KeypairIdentify keypairIdentify = loadSingleObject(accessKey, getKeypairIdentifyMapper());
			return keypairIdentify;
		}catch(EmptyResultDataAccessException e){
			throw new KeypairIdentifyNotFoundException("KeypairIdentify("+accessKey+") is not found!");
		}

	}

	
	

	protected KeypairIdentify loadInternalKeypairIdentify(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		KeypairIdentify keypairIdentify = extractKeypairIdentify(accessKey, loadOptions);
 	
 		if(isExtractKeyTypeEnabled(loadOptions)){
	 		extractKeyType(keypairIdentify, loadOptions);
 		}
  	
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(keypairIdentify, loadOptions);
 		}
 
		
		return keypairIdentify;
		
	}

	 

 	protected KeypairIdentify extractKeyType(KeypairIdentify keypairIdentify, Map<String,Object> options) throws Exception{

		if(keypairIdentify.getKeyType() == null){
			return keypairIdentify;
		}
		String keyTypeId = keypairIdentify.getKeyType().getId();
		if( keyTypeId == null){
			return keypairIdentify;
		}
		PublicKeyType keyType = getPublicKeyTypeDAO().load(keyTypeId,options);
		if(keyType != null){
			keypairIdentify.setKeyType(keyType);
		}
		
 		
 		return keypairIdentify;
 	}
 		
  

 	protected KeypairIdentify extractSecUser(KeypairIdentify keypairIdentify, Map<String,Object> options) throws Exception{

		if(keypairIdentify.getSecUser() == null){
			return keypairIdentify;
		}
		String secUserId = keypairIdentify.getSecUser().getId();
		if( secUserId == null){
			return keypairIdentify;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			keypairIdentify.setSecUser(secUser);
		}
		
 		
 		return keypairIdentify;
 	}
 		
 
		
		
  	
 	public SmartList<KeypairIdentify> findKeypairIdentifyByKeyType(String publicKeyTypeId,Map<String,Object> options){
 	
  		SmartList<KeypairIdentify> resultList = queryWith(KeypairIdentifyTable.COLUMN_KEY_TYPE, publicKeyTypeId, options, getKeypairIdentifyMapper());
		// analyzeKeypairIdentifyByKeyType(resultList, publicKeyTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<KeypairIdentify> findKeypairIdentifyByKeyType(String publicKeyTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<KeypairIdentify> resultList =  queryWithRange(KeypairIdentifyTable.COLUMN_KEY_TYPE, publicKeyTypeId, options, getKeypairIdentifyMapper(), start, count);
 		//analyzeKeypairIdentifyByKeyType(resultList, publicKeyTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeKeypairIdentifyByKeyType(SmartList<KeypairIdentify> resultList, String publicKeyTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(KeypairIdentify.KEY_TYPE_PROPERTY, publicKeyTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//KeypairIdentify.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("密钥对识别");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(KeypairIdentify.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(KeypairIdentify.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countKeypairIdentifyByKeyType(String publicKeyTypeId,Map<String,Object> options){

 		return countWith(KeypairIdentifyTable.COLUMN_KEY_TYPE, publicKeyTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countKeypairIdentifyByKeyTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(KeypairIdentifyTable.COLUMN_KEY_TYPE, ids, options);
	}
 	
  	
 	public SmartList<KeypairIdentify> findKeypairIdentifyBySecUser(String secUserId,Map<String,Object> options){
 	
  		SmartList<KeypairIdentify> resultList = queryWith(KeypairIdentifyTable.COLUMN_SEC_USER, secUserId, options, getKeypairIdentifyMapper());
		// analyzeKeypairIdentifyBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<KeypairIdentify> findKeypairIdentifyBySecUser(String secUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<KeypairIdentify> resultList =  queryWithRange(KeypairIdentifyTable.COLUMN_SEC_USER, secUserId, options, getKeypairIdentifyMapper(), start, count);
 		//analyzeKeypairIdentifyBySecUser(resultList, secUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeKeypairIdentifyBySecUser(SmartList<KeypairIdentify> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(KeypairIdentify.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//KeypairIdentify.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("密钥对识别");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(KeypairIdentify.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(KeypairIdentify.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countKeypairIdentifyBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(KeypairIdentifyTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countKeypairIdentifyBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(KeypairIdentifyTable.COLUMN_SEC_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected KeypairIdentify saveKeypairIdentify(KeypairIdentify  keypairIdentify){
		
		if(!keypairIdentify.isChanged()){
			return keypairIdentify;
		}
		
		
		String SQL=this.getSaveKeypairIdentifySQL(keypairIdentify);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveKeypairIdentifyParameters(keypairIdentify);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		keypairIdentify.incVersion();
		return keypairIdentify;
	
	}
	public SmartList<KeypairIdentify> saveKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitKeypairIdentifyList(keypairIdentifyList);
		
		batchKeypairIdentifyCreate((List<KeypairIdentify>)lists[CREATE_LIST_INDEX]);
		
		batchKeypairIdentifyUpdate((List<KeypairIdentify>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(KeypairIdentify keypairIdentify:keypairIdentifyList){
			if(keypairIdentify.isChanged()){
				keypairIdentify.incVersion();
			}
			
		
		}
		
		
		return keypairIdentifyList;
	}

	public SmartList<KeypairIdentify> removeKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList,Map<String,Object> options){
		
		
		super.removeList(keypairIdentifyList, options);
		
		return keypairIdentifyList;
		
		
	}
	
	protected List<Object[]> prepareKeypairIdentifyBatchCreateArgs(List<KeypairIdentify> keypairIdentifyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(KeypairIdentify keypairIdentify:keypairIdentifyList ){
			Object [] parameters = prepareKeypairIdentifyCreateParameters(keypairIdentify);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareKeypairIdentifyBatchUpdateArgs(List<KeypairIdentify> keypairIdentifyList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(KeypairIdentify keypairIdentify:keypairIdentifyList ){
			if(!keypairIdentify.isChanged()){
				continue;
			}
			Object [] parameters = prepareKeypairIdentifyUpdateParameters(keypairIdentify);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchKeypairIdentifyCreate(List<KeypairIdentify> keypairIdentifyList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareKeypairIdentifyBatchCreateArgs(keypairIdentifyList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchKeypairIdentifyUpdate(List<KeypairIdentify> keypairIdentifyList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareKeypairIdentifyBatchUpdateArgs(keypairIdentifyList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitKeypairIdentifyList(List<KeypairIdentify> keypairIdentifyList){
		
		List<KeypairIdentify> keypairIdentifyCreateList=new ArrayList<KeypairIdentify>();
		List<KeypairIdentify> keypairIdentifyUpdateList=new ArrayList<KeypairIdentify>();
		
		for(KeypairIdentify keypairIdentify: keypairIdentifyList){
			if(isUpdateRequest(keypairIdentify)){
				keypairIdentifyUpdateList.add( keypairIdentify);
				continue;
			}
			keypairIdentifyCreateList.add(keypairIdentify);
		}
		
		return new Object[]{keypairIdentifyCreateList,keypairIdentifyUpdateList};
	}
	
	protected boolean isUpdateRequest(KeypairIdentify keypairIdentify){
 		return keypairIdentify.getVersion() > 0;
 	}
 	protected String getSaveKeypairIdentifySQL(KeypairIdentify keypairIdentify){
 		if(isUpdateRequest(keypairIdentify)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveKeypairIdentifyParameters(KeypairIdentify keypairIdentify){
 		if(isUpdateRequest(keypairIdentify) ){
 			return prepareKeypairIdentifyUpdateParameters(keypairIdentify);
 		}
 		return prepareKeypairIdentifyCreateParameters(keypairIdentify);
 	}
 	protected Object[] prepareKeypairIdentifyUpdateParameters(KeypairIdentify keypairIdentify){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = keypairIdentify.getPublicKey();
 		 	
 		if(keypairIdentify.getKeyType() != null){
 			parameters[1] = keypairIdentify.getKeyType().getId();
 		}
  	
 		if(keypairIdentify.getSecUser() != null){
 			parameters[2] = keypairIdentify.getSecUser().getId();
 		}
 
 		
 		parameters[3] = keypairIdentify.getCreateTime();
 				
 		parameters[4] = keypairIdentify.nextVersion();
 		parameters[5] = keypairIdentify.getId();
 		parameters[6] = keypairIdentify.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareKeypairIdentifyCreateParameters(KeypairIdentify keypairIdentify){
		Object[] parameters = new Object[5];
		String newKeypairIdentifyId=getNextId();
		keypairIdentify.setId(newKeypairIdentifyId);
		parameters[0] =  keypairIdentify.getId();
 
 		
 		parameters[1] = keypairIdentify.getPublicKey();
 		 	
 		if(keypairIdentify.getKeyType() != null){
 			parameters[2] = keypairIdentify.getKeyType().getId();
 		
 		}
 		 	
 		if(keypairIdentify.getSecUser() != null){
 			parameters[3] = keypairIdentify.getSecUser().getId();
 		
 		}
 		
 		
 		parameters[4] = keypairIdentify.getCreateTime();
 				
 				
 		return parameters;
 	}
 	
	protected KeypairIdentify saveInternalKeypairIdentify(KeypairIdentify keypairIdentify, Map<String,Object> options){
		
		saveKeypairIdentify(keypairIdentify);
 	
 		if(isSaveKeyTypeEnabled(options)){
	 		saveKeyType(keypairIdentify, options);
 		}
  	
 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(keypairIdentify, options);
 		}
 
		
		return keypairIdentify;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected KeypairIdentify saveKeyType(KeypairIdentify keypairIdentify, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(keypairIdentify.getKeyType() == null){
 			return keypairIdentify;//do nothing when it is null
 		}
 		
 		getPublicKeyTypeDAO().save(keypairIdentify.getKeyType(),options);
 		return keypairIdentify;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected KeypairIdentify saveSecUser(KeypairIdentify keypairIdentify, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(keypairIdentify.getSecUser() == null){
 			return keypairIdentify;//do nothing when it is null
 		}
 		
 		getSecUserDAO().save(keypairIdentify.getSecUser(),options);
 		return keypairIdentify;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public KeypairIdentify present(KeypairIdentify keypairIdentify,Map<String, Object> options){
	

		return keypairIdentify;
	
	}
		

	

	protected String getTableName(){
		return KeypairIdentifyTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<KeypairIdentify> keypairIdentifyList) {		
		this.enhanceListInternal(keypairIdentifyList, this.getKeypairIdentifyMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<KeypairIdentify> keypairIdentifyList = ownerEntity.collectRefsWithType(KeypairIdentify.INTERNAL_TYPE);
		this.enhanceList(keypairIdentifyList);
		
	}
	
	@Override
	public SmartList<KeypairIdentify> findKeypairIdentifyWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getKeypairIdentifyMapper());

	}
	@Override
	public int countKeypairIdentifyWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countKeypairIdentifyWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<KeypairIdentify> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getKeypairIdentifyMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateKeypairIdentify executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateKeypairIdentify result = new CandidateKeypairIdentify();
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


