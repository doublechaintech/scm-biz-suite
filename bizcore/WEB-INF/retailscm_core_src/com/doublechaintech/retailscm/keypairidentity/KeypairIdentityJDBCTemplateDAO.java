
package com.doublechaintech.retailscm.keypairidentity;

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
import java.util.stream.Stream;

public class KeypairIdentityJDBCTemplateDAO extends RetailscmBaseDAOImpl implements KeypairIdentityDAO{

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
	protected KeypairIdentity load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalKeypairIdentity(accessKey, options);
	}
	*/

	public SmartList<KeypairIdentity> loadAll() {
	    return this.loadAll(getKeypairIdentityMapper());
	}

  public Stream<KeypairIdentity> loadAllAsStream() {
      return this.loadAllAsStream(getKeypairIdentityMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public KeypairIdentity load(String id,Map<String,Object> options) throws Exception{
		return loadInternalKeypairIdentity(KeypairIdentityTable.withId(id), options);
	}

	

	public KeypairIdentity save(KeypairIdentity keypairIdentity,Map<String,Object> options){

		String methodName="save(KeypairIdentity keypairIdentity,Map<String,Object> options)";

		assertMethodArgumentNotNull(keypairIdentity, methodName, "keypairIdentity");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalKeypairIdentity(keypairIdentity,options);
	}
	public KeypairIdentity clone(String keypairIdentityId, Map<String,Object> options) throws Exception{

		return clone(KeypairIdentityTable.withId(keypairIdentityId),options);
	}

	protected KeypairIdentity clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String keypairIdentityId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		KeypairIdentity newKeypairIdentity = loadInternalKeypairIdentity(accessKey, options);
		newKeypairIdentity.setVersion(0);
		
		


		saveInternalKeypairIdentity(newKeypairIdentity,options);

		return newKeypairIdentity;
	}

	



	protected void throwIfHasException(String keypairIdentityId,int version,int count) throws Exception{
		if (count == 1) {
			throw new KeypairIdentityVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new KeypairIdentityNotFoundException(
					"The " + this.getTableName() + "(" + keypairIdentityId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String keypairIdentityId, int version) throws Exception{

		String methodName="delete(String keypairIdentityId, int version)";
		assertMethodArgumentNotNull(keypairIdentityId, methodName, "keypairIdentityId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{keypairIdentityId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(keypairIdentityId,version);
		}


	}






	public KeypairIdentity disconnectFromAll(String keypairIdentityId, int version) throws Exception{


		KeypairIdentity keypairIdentity = loadInternalKeypairIdentity(KeypairIdentityTable.withId(keypairIdentityId), emptyOptions());
		keypairIdentity.clearFromAll();
		this.saveKeypairIdentity(keypairIdentity);
		return keypairIdentity;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return KeypairIdentityTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "keypair_identity";
	}
	@Override
	protected String getBeanName() {

		return "keypairIdentity";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return KeypairIdentityTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractKeyTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, KeypairIdentityTokens.KEYTYPE);
 	}

 	protected boolean isSaveKeyTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, KeypairIdentityTokens.KEYTYPE);
 	}
 	

 	
  

 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, KeypairIdentityTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, KeypairIdentityTokens.SECUSER);
 	}
 	

 	
 
		

	

	protected KeypairIdentityMapper getKeypairIdentityMapper(){
		return new KeypairIdentityMapper();
	}

	
	
	protected KeypairIdentity extractKeypairIdentity(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			KeypairIdentity keypairIdentity = loadSingleObject(accessKey, getKeypairIdentityMapper());
			return keypairIdentity;
		}catch(EmptyResultDataAccessException e){
			throw new KeypairIdentityNotFoundException("KeypairIdentity("+accessKey+") is not found!");
		}

	}

	
	

	protected KeypairIdentity loadInternalKeypairIdentity(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		KeypairIdentity keypairIdentity = extractKeypairIdentity(accessKey, loadOptions);
 	
 		if(isExtractKeyTypeEnabled(loadOptions)){
	 		extractKeyType(keypairIdentity, loadOptions);
 		}
  	
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(keypairIdentity, loadOptions);
 		}
 
		
		return keypairIdentity;
		
	}

	 

 	protected KeypairIdentity extractKeyType(KeypairIdentity keypairIdentity, Map<String,Object> options) throws Exception{

		if(keypairIdentity.getKeyType() == null){
			return keypairIdentity;
		}
		String keyTypeId = keypairIdentity.getKeyType().getId();
		if( keyTypeId == null){
			return keypairIdentity;
		}
		PublicKeyType keyType = getPublicKeyTypeDAO().load(keyTypeId,options);
		if(keyType != null){
			keypairIdentity.setKeyType(keyType);
		}
		
 		
 		return keypairIdentity;
 	}
 		
  

 	protected KeypairIdentity extractSecUser(KeypairIdentity keypairIdentity, Map<String,Object> options) throws Exception{

		if(keypairIdentity.getSecUser() == null){
			return keypairIdentity;
		}
		String secUserId = keypairIdentity.getSecUser().getId();
		if( secUserId == null){
			return keypairIdentity;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			keypairIdentity.setSecUser(secUser);
		}
		
 		
 		return keypairIdentity;
 	}
 		
 
		
		
  	
 	public SmartList<KeypairIdentity> findKeypairIdentityByKeyType(String publicKeyTypeId,Map<String,Object> options){
 	
  		SmartList<KeypairIdentity> resultList = queryWith(KeypairIdentityTable.COLUMN_KEY_TYPE, publicKeyTypeId, options, getKeypairIdentityMapper());
		// analyzeKeypairIdentityByKeyType(resultList, publicKeyTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<KeypairIdentity> findKeypairIdentityByKeyType(String publicKeyTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<KeypairIdentity> resultList =  queryWithRange(KeypairIdentityTable.COLUMN_KEY_TYPE, publicKeyTypeId, options, getKeypairIdentityMapper(), start, count);
 		//analyzeKeypairIdentityByKeyType(resultList, publicKeyTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeKeypairIdentityByKeyType(SmartList<KeypairIdentity> resultList, String publicKeyTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(KeypairIdentity.KEY_TYPE_PROPERTY, publicKeyTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//KeypairIdentity.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("密钥对身份");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(KeypairIdentity.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(KeypairIdentity.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countKeypairIdentityByKeyType(String publicKeyTypeId,Map<String,Object> options){

 		return countWith(KeypairIdentityTable.COLUMN_KEY_TYPE, publicKeyTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countKeypairIdentityByKeyTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(KeypairIdentityTable.COLUMN_KEY_TYPE, ids, options);
	}
 	
  	
 	public SmartList<KeypairIdentity> findKeypairIdentityBySecUser(String secUserId,Map<String,Object> options){
 	
  		SmartList<KeypairIdentity> resultList = queryWith(KeypairIdentityTable.COLUMN_SEC_USER, secUserId, options, getKeypairIdentityMapper());
		// analyzeKeypairIdentityBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<KeypairIdentity> findKeypairIdentityBySecUser(String secUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<KeypairIdentity> resultList =  queryWithRange(KeypairIdentityTable.COLUMN_SEC_USER, secUserId, options, getKeypairIdentityMapper(), start, count);
 		//analyzeKeypairIdentityBySecUser(resultList, secUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeKeypairIdentityBySecUser(SmartList<KeypairIdentity> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(KeypairIdentity.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//KeypairIdentity.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("密钥对身份");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(KeypairIdentity.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(KeypairIdentity.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countKeypairIdentityBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(KeypairIdentityTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countKeypairIdentityBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(KeypairIdentityTable.COLUMN_SEC_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected KeypairIdentity saveKeypairIdentity(KeypairIdentity  keypairIdentity){
		
		if(!keypairIdentity.isChanged()){
			return keypairIdentity;
		}
		

		String SQL=this.getSaveKeypairIdentitySQL(keypairIdentity);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveKeypairIdentityParameters(keypairIdentity);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		keypairIdentity.incVersion();
		return keypairIdentity;

	}
	public SmartList<KeypairIdentity> saveKeypairIdentityList(SmartList<KeypairIdentity> keypairIdentityList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitKeypairIdentityList(keypairIdentityList);

		batchKeypairIdentityCreate((List<KeypairIdentity>)lists[CREATE_LIST_INDEX]);

		batchKeypairIdentityUpdate((List<KeypairIdentity>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(KeypairIdentity keypairIdentity:keypairIdentityList){
			if(keypairIdentity.isChanged()){
				keypairIdentity.incVersion();
			}


		}


		return keypairIdentityList;
	}

	public SmartList<KeypairIdentity> removeKeypairIdentityList(SmartList<KeypairIdentity> keypairIdentityList,Map<String,Object> options){


		super.removeList(keypairIdentityList, options);

		return keypairIdentityList;


	}

	protected List<Object[]> prepareKeypairIdentityBatchCreateArgs(List<KeypairIdentity> keypairIdentityList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(KeypairIdentity keypairIdentity:keypairIdentityList ){
			Object [] parameters = prepareKeypairIdentityCreateParameters(keypairIdentity);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareKeypairIdentityBatchUpdateArgs(List<KeypairIdentity> keypairIdentityList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(KeypairIdentity keypairIdentity:keypairIdentityList ){
			if(!keypairIdentity.isChanged()){
				continue;
			}
			Object [] parameters = prepareKeypairIdentityUpdateParameters(keypairIdentity);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchKeypairIdentityCreate(List<KeypairIdentity> keypairIdentityList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareKeypairIdentityBatchCreateArgs(keypairIdentityList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchKeypairIdentityUpdate(List<KeypairIdentity> keypairIdentityList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareKeypairIdentityBatchUpdateArgs(keypairIdentityList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitKeypairIdentityList(List<KeypairIdentity> keypairIdentityList){

		List<KeypairIdentity> keypairIdentityCreateList=new ArrayList<KeypairIdentity>();
		List<KeypairIdentity> keypairIdentityUpdateList=new ArrayList<KeypairIdentity>();

		for(KeypairIdentity keypairIdentity: keypairIdentityList){
			if(isUpdateRequest(keypairIdentity)){
				keypairIdentityUpdateList.add( keypairIdentity);
				continue;
			}
			keypairIdentityCreateList.add(keypairIdentity);
		}

		return new Object[]{keypairIdentityCreateList,keypairIdentityUpdateList};
	}

	protected boolean isUpdateRequest(KeypairIdentity keypairIdentity){
 		return keypairIdentity.getVersion() > 0;
 	}
 	protected String getSaveKeypairIdentitySQL(KeypairIdentity keypairIdentity){
 		if(isUpdateRequest(keypairIdentity)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveKeypairIdentityParameters(KeypairIdentity keypairIdentity){
 		if(isUpdateRequest(keypairIdentity) ){
 			return prepareKeypairIdentityUpdateParameters(keypairIdentity);
 		}
 		return prepareKeypairIdentityCreateParameters(keypairIdentity);
 	}
 	protected Object[] prepareKeypairIdentityUpdateParameters(KeypairIdentity keypairIdentity){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = keypairIdentity.getPublicKey();
 		
 		if(keypairIdentity.getKeyType() != null){
 			parameters[1] = keypairIdentity.getKeyType().getId();
 		}
 
 		if(keypairIdentity.getSecUser() != null){
 			parameters[2] = keypairIdentity.getSecUser().getId();
 		}
 
 		
 		parameters[3] = keypairIdentity.getCreateTime();
 		
 		parameters[4] = keypairIdentity.nextVersion();
 		parameters[5] = keypairIdentity.getId();
 		parameters[6] = keypairIdentity.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareKeypairIdentityCreateParameters(KeypairIdentity keypairIdentity){
		Object[] parameters = new Object[5];
        if(keypairIdentity.getId() == null){
          String newKeypairIdentityId=getNextId();
          keypairIdentity.setId(newKeypairIdentityId);
        }
		parameters[0] =  keypairIdentity.getId();
 
 		
 		parameters[1] = keypairIdentity.getPublicKey();
 		
 		if(keypairIdentity.getKeyType() != null){
 			parameters[2] = keypairIdentity.getKeyType().getId();

 		}
 		
 		if(keypairIdentity.getSecUser() != null){
 			parameters[3] = keypairIdentity.getSecUser().getId();

 		}
 		
 		
 		parameters[4] = keypairIdentity.getCreateTime();
 		

 		return parameters;
 	}

	protected KeypairIdentity saveInternalKeypairIdentity(KeypairIdentity keypairIdentity, Map<String,Object> options){

		saveKeypairIdentity(keypairIdentity);

 		if(isSaveKeyTypeEnabled(options)){
	 		saveKeyType(keypairIdentity, options);
 		}
 
 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(keypairIdentity, options);
 		}
 
		
		return keypairIdentity;

	}



	//======================================================================================
	

 	protected KeypairIdentity saveKeyType(KeypairIdentity keypairIdentity, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(keypairIdentity.getKeyType() == null){
 			return keypairIdentity;//do nothing when it is null
 		}

 		getPublicKeyTypeDAO().save(keypairIdentity.getKeyType(),options);
 		return keypairIdentity;

 	}





 

 	protected KeypairIdentity saveSecUser(KeypairIdentity keypairIdentity, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(keypairIdentity.getSecUser() == null){
 			return keypairIdentity;//do nothing when it is null
 		}

 		getSecUserDAO().save(keypairIdentity.getSecUser(),options);
 		return keypairIdentity;

 	}





 

	

		

	public KeypairIdentity present(KeypairIdentity keypairIdentity,Map<String, Object> options){
	

		return keypairIdentity;
	
	}
		

	

	protected String getTableName(){
		return KeypairIdentityTable.TABLE_NAME;
	}



	public void enhanceList(List<KeypairIdentity> keypairIdentityList) {
		this.enhanceListInternal(keypairIdentityList, this.getKeypairIdentityMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<KeypairIdentity> keypairIdentityList = ownerEntity.collectRefsWithType(KeypairIdentity.INTERNAL_TYPE);
		this.enhanceList(keypairIdentityList);

	}

	@Override
	public SmartList<KeypairIdentity> findKeypairIdentityWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getKeypairIdentityMapper());

	}
	@Override
	public int countKeypairIdentityWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countKeypairIdentityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<KeypairIdentity> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getKeypairIdentityMapper());
	}

  @Override
  public Stream<KeypairIdentity> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getKeypairIdentityMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateKeypairIdentity executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateKeypairIdentity result = new CandidateKeypairIdentity();
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


