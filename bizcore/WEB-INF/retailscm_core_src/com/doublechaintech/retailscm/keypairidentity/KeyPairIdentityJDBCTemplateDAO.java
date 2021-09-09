
package com.doublechaintech.retailscm.keypairidentity;

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
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class KeyPairIdentityJDBCTemplateDAO extends RetailscmBaseDAOImpl implements KeyPairIdentityDAO{

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
	protected KeyPairIdentity load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalKeyPairIdentity(accessKey, options);
	}
	*/

	public SmartList<KeyPairIdentity> loadAll() {
	    return this.loadAll(getKeyPairIdentityMapper());
	}

  public Stream<KeyPairIdentity> loadAllAsStream() {
      return this.loadAllAsStream(getKeyPairIdentityMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public KeyPairIdentity load(String id,Map<String,Object> options) throws Exception{
		return loadInternalKeyPairIdentity(KeyPairIdentityTable.withId(id), options);
	}

	

	public KeyPairIdentity save(KeyPairIdentity keyPairIdentity,Map<String,Object> options){

		String methodName="save(KeyPairIdentity keyPairIdentity,Map<String,Object> options)";

		assertMethodArgumentNotNull(keyPairIdentity, methodName, "keyPairIdentity");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalKeyPairIdentity(keyPairIdentity,options);
	}
	public KeyPairIdentity clone(String keyPairIdentityId, Map<String,Object> options) throws Exception{

		return clone(KeyPairIdentityTable.withId(keyPairIdentityId),options);
	}

	protected KeyPairIdentity clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String keyPairIdentityId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		KeyPairIdentity newKeyPairIdentity = loadInternalKeyPairIdentity(accessKey, options);
		newKeyPairIdentity.setVersion(0);
		
		


		saveInternalKeyPairIdentity(newKeyPairIdentity,options);

		return newKeyPairIdentity;
	}

	



	protected void throwIfHasException(String keyPairIdentityId,int version,int count) throws Exception{
		if (count == 1) {
			throw new KeyPairIdentityVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new KeyPairIdentityNotFoundException(
					"The " + this.getTableName() + "(" + keyPairIdentityId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String keyPairIdentityId, int version) throws Exception{

		String methodName="delete(String keyPairIdentityId, int version)";
		assertMethodArgumentNotNull(keyPairIdentityId, methodName, "keyPairIdentityId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{keyPairIdentityId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(keyPairIdentityId,version);
		}


	}






	public KeyPairIdentity disconnectFromAll(String keyPairIdentityId, int version) throws Exception{


		KeyPairIdentity keyPairIdentity = loadInternalKeyPairIdentity(KeyPairIdentityTable.withId(keyPairIdentityId), emptyOptions());
		keyPairIdentity.clearFromAll();
		this.saveKeyPairIdentity(keyPairIdentity);
		return keyPairIdentity;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return KeyPairIdentityTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "key_pair_identity";
	}
	@Override
	protected String getBeanName() {

		return "keyPairIdentity";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return KeyPairIdentityTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractKeyTypeEnabled(Map<String,Object> options){

	 	return checkOptions(options, KeyPairIdentityTokens.KEYTYPE);
 	}

 	protected boolean isSaveKeyTypeEnabled(Map<String,Object> options){

 		return checkOptions(options, KeyPairIdentityTokens.KEYTYPE);
 	}



 

 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){

	 	return checkOptions(options, KeyPairIdentityTokens.SECUSER);
 	}

 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){

 		return checkOptions(options, KeyPairIdentityTokens.SECUSER);
 	}



 
		

	

	protected KeyPairIdentityMapper getKeyPairIdentityMapper(){
		return new KeyPairIdentityMapper();
	}



	protected KeyPairIdentity extractKeyPairIdentity(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			KeyPairIdentity keyPairIdentity = loadSingleObject(accessKey, getKeyPairIdentityMapper());
			return keyPairIdentity;
		}catch(EmptyResultDataAccessException e){
			throw new KeyPairIdentityNotFoundException("KeyPairIdentity("+accessKey+") is not found!");
		}

	}




	protected KeyPairIdentity loadInternalKeyPairIdentity(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		KeyPairIdentity keyPairIdentity = extractKeyPairIdentity(accessKey, loadOptions);

 		if(isExtractKeyTypeEnabled(loadOptions)){
	 		extractKeyType(keyPairIdentity, loadOptions);
 		}
 
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(keyPairIdentity, loadOptions);
 		}
 
		
		return keyPairIdentity;

	}

	

 	protected KeyPairIdentity extractKeyType(KeyPairIdentity keyPairIdentity, Map<String,Object> options) throws Exception{
  

		if(keyPairIdentity.getKeyType() == null){
			return keyPairIdentity;
		}
		String keyTypeId = keyPairIdentity.getKeyType().getId();
		if( keyTypeId == null){
			return keyPairIdentity;
		}
		PublicKeyType keyType = getPublicKeyTypeDAO().load(keyTypeId,options);
		if(keyType != null){
			keyPairIdentity.setKeyType(keyType);
		}


 		return keyPairIdentity;
 	}

 

 	protected KeyPairIdentity extractSecUser(KeyPairIdentity keyPairIdentity, Map<String,Object> options) throws Exception{
  

		if(keyPairIdentity.getSecUser() == null){
			return keyPairIdentity;
		}
		String secUserId = keyPairIdentity.getSecUser().getId();
		if( secUserId == null){
			return keyPairIdentity;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			keyPairIdentity.setSecUser(secUser);
		}


 		return keyPairIdentity;
 	}

 
		

 
 	public SmartList<KeyPairIdentity> findKeyPairIdentityByKeyType(String publicKeyTypeId,Map<String,Object> options){

  		SmartList<KeyPairIdentity> resultList = queryWith(KeyPairIdentityTable.COLUMN_KEY_TYPE, publicKeyTypeId, options, getKeyPairIdentityMapper());
		// analyzeKeyPairIdentityByKeyType(resultList, publicKeyTypeId, options);
		return resultList;
 	}
 	

 	public SmartList<KeyPairIdentity> findKeyPairIdentityByKeyType(String publicKeyTypeId, int start, int count,Map<String,Object> options){

 		SmartList<KeyPairIdentity> resultList =  queryWithRange(KeyPairIdentityTable.COLUMN_KEY_TYPE, publicKeyTypeId, options, getKeyPairIdentityMapper(), start, count);
 		//analyzeKeyPairIdentityByKeyType(resultList, publicKeyTypeId, options);
 		return resultList;

 	}
 	public void analyzeKeyPairIdentityByKeyType(SmartList<KeyPairIdentity> resultList, String publicKeyTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(KeyPairIdentity.KEY_TYPE_PROPERTY, publicKeyTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem createTimeStatsItem = new StatsItem();
		//KeyPairIdentity.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("秘钥对认证");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(KeyPairIdentity.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(KeyPairIdentity.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countKeyPairIdentityByKeyType(String publicKeyTypeId,Map<String,Object> options){

 		return countWith(KeyPairIdentityTable.COLUMN_KEY_TYPE, publicKeyTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countKeyPairIdentityByKeyTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(KeyPairIdentityTable.COLUMN_KEY_TYPE, ids, options);
	}

 
 	public SmartList<KeyPairIdentity> findKeyPairIdentityBySecUser(String secUserId,Map<String,Object> options){

  		SmartList<KeyPairIdentity> resultList = queryWith(KeyPairIdentityTable.COLUMN_SEC_USER, secUserId, options, getKeyPairIdentityMapper());
		// analyzeKeyPairIdentityBySecUser(resultList, secUserId, options);
		return resultList;
 	}
 	

 	public SmartList<KeyPairIdentity> findKeyPairIdentityBySecUser(String secUserId, int start, int count,Map<String,Object> options){

 		SmartList<KeyPairIdentity> resultList =  queryWithRange(KeyPairIdentityTable.COLUMN_SEC_USER, secUserId, options, getKeyPairIdentityMapper(), start, count);
 		//analyzeKeyPairIdentityBySecUser(resultList, secUserId, options);
 		return resultList;

 	}
 	public void analyzeKeyPairIdentityBySecUser(SmartList<KeyPairIdentity> resultList, String secUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(KeyPairIdentity.SEC_USER_PROPERTY, secUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();

 		StatsInfo info = new StatsInfo();

 
		StatsItem createTimeStatsItem = new StatsItem();
		//KeyPairIdentity.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("秘钥对认证");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(KeyPairIdentity.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(KeyPairIdentity.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 		
 		resultList.setStatsInfo(info);



 	}
 	@Override
 	public int countKeyPairIdentityBySecUser(String secUserId,Map<String,Object> options){

 		return countWith(KeyPairIdentityTable.COLUMN_SEC_USER, secUserId, options);
 	}
 	@Override
	public Map<String, Integer> countKeyPairIdentityBySecUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(KeyPairIdentityTable.COLUMN_SEC_USER, ids, options);
	}

 




	

	protected KeyPairIdentity saveKeyPairIdentity(KeyPairIdentity  keyPairIdentity){
    

		
		if(!keyPairIdentity.isChanged()){
			return keyPairIdentity;
		}
		

    Beans.dbUtil().cacheCleanUp(keyPairIdentity);
		String SQL=this.getSaveKeyPairIdentitySQL(keyPairIdentity);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveKeyPairIdentityParameters(keyPairIdentity);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		keyPairIdentity.incVersion();
		keyPairIdentity.afterSave();
		return keyPairIdentity;

	}
	public SmartList<KeyPairIdentity> saveKeyPairIdentityList(SmartList<KeyPairIdentity> keyPairIdentityList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitKeyPairIdentityList(keyPairIdentityList);

		batchKeyPairIdentityCreate((List<KeyPairIdentity>)lists[CREATE_LIST_INDEX]);

		batchKeyPairIdentityUpdate((List<KeyPairIdentity>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(KeyPairIdentity keyPairIdentity:keyPairIdentityList){
			if(keyPairIdentity.isChanged()){
				keyPairIdentity.incVersion();
				keyPairIdentity.afterSave();
			}


		}


		return keyPairIdentityList;
	}

	public SmartList<KeyPairIdentity> removeKeyPairIdentityList(SmartList<KeyPairIdentity> keyPairIdentityList,Map<String,Object> options){


		super.removeList(keyPairIdentityList, options);

		return keyPairIdentityList;


	}

	protected List<Object[]> prepareKeyPairIdentityBatchCreateArgs(List<KeyPairIdentity> keyPairIdentityList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(KeyPairIdentity keyPairIdentity:keyPairIdentityList ){
			Object [] parameters = prepareKeyPairIdentityCreateParameters(keyPairIdentity);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareKeyPairIdentityBatchUpdateArgs(List<KeyPairIdentity> keyPairIdentityList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(KeyPairIdentity keyPairIdentity:keyPairIdentityList ){
			if(!keyPairIdentity.isChanged()){
				continue;
			}
			Object [] parameters = prepareKeyPairIdentityUpdateParameters(keyPairIdentity);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchKeyPairIdentityCreate(List<KeyPairIdentity> keyPairIdentityList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareKeyPairIdentityBatchCreateArgs(keyPairIdentityList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchKeyPairIdentityUpdate(List<KeyPairIdentity> keyPairIdentityList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareKeyPairIdentityBatchUpdateArgs(keyPairIdentityList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitKeyPairIdentityList(List<KeyPairIdentity> keyPairIdentityList){

		List<KeyPairIdentity> keyPairIdentityCreateList=new ArrayList<KeyPairIdentity>();
		List<KeyPairIdentity> keyPairIdentityUpdateList=new ArrayList<KeyPairIdentity>();

		for(KeyPairIdentity keyPairIdentity: keyPairIdentityList){
			if(isUpdateRequest(keyPairIdentity)){
				keyPairIdentityUpdateList.add( keyPairIdentity);
				continue;
			}
			keyPairIdentityCreateList.add(keyPairIdentity);
		}

		return new Object[]{keyPairIdentityCreateList,keyPairIdentityUpdateList};
	}

	protected boolean isUpdateRequest(KeyPairIdentity keyPairIdentity){
 		return keyPairIdentity.getVersion() > 0;
 	}
 	protected String getSaveKeyPairIdentitySQL(KeyPairIdentity keyPairIdentity){
 		if(isUpdateRequest(keyPairIdentity)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveKeyPairIdentityParameters(KeyPairIdentity keyPairIdentity){
 		if(isUpdateRequest(keyPairIdentity) ){
 			return prepareKeyPairIdentityUpdateParameters(keyPairIdentity);
 		}
 		return prepareKeyPairIdentityCreateParameters(keyPairIdentity);
 	}
 	protected Object[] prepareKeyPairIdentityUpdateParameters(KeyPairIdentity keyPairIdentity){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = keyPairIdentity.getPublicKey();
 		
 		if(keyPairIdentity.getKeyType() != null){
 			parameters[1] = keyPairIdentity.getKeyType().getId();
 		}
    
 		if(keyPairIdentity.getSecUser() != null){
 			parameters[2] = keyPairIdentity.getSecUser().getId();
 		}
    
 		parameters[3] = keyPairIdentity.getCreateTime();
 		
 		parameters[4] = keyPairIdentity.nextVersion();
 		parameters[5] = keyPairIdentity.getId();
 		parameters[6] = keyPairIdentity.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareKeyPairIdentityCreateParameters(KeyPairIdentity keyPairIdentity){
		Object[] parameters = new Object[5];
        if(keyPairIdentity.getId() == null){
          String newKeyPairIdentityId=getNextId();
          keyPairIdentity.setId(newKeyPairIdentityId);
        }
		parameters[0] =  keyPairIdentity.getId();
 
 		parameters[1] = keyPairIdentity.getPublicKey();
 		
 		if(keyPairIdentity.getKeyType() != null){
 			parameters[2] = keyPairIdentity.getKeyType().getId();
 		}
 		
 		if(keyPairIdentity.getSecUser() != null){
 			parameters[3] = keyPairIdentity.getSecUser().getId();
 		}
 		
 		parameters[4] = keyPairIdentity.getCreateTime();
 		

 		return parameters;
 	}

	protected KeyPairIdentity saveInternalKeyPairIdentity(KeyPairIdentity keyPairIdentity, Map<String,Object> options){

 		if(isSaveKeyTypeEnabled(options)){
	 		saveKeyType(keyPairIdentity, options);
 		}
 
 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(keyPairIdentity, options);
 		}
 
   saveKeyPairIdentity(keyPairIdentity);
		
		return keyPairIdentity;

	}



	//======================================================================================
	

 	protected KeyPairIdentity saveKeyType(KeyPairIdentity keyPairIdentity, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(keyPairIdentity.getKeyType() == null){
 			return keyPairIdentity;//do nothing when it is null
 		}

 		getPublicKeyTypeDAO().save(keyPairIdentity.getKeyType(),options);
 		return keyPairIdentity;

 	}
 

 	protected KeyPairIdentity saveSecUser(KeyPairIdentity keyPairIdentity, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(keyPairIdentity.getSecUser() == null){
 			return keyPairIdentity;//do nothing when it is null
 		}

 		getSecUserDAO().save(keyPairIdentity.getSecUser(),options);
 		return keyPairIdentity;

 	}
 

	

		

	public KeyPairIdentity present(KeyPairIdentity keyPairIdentity,Map<String, Object> options){


		return keyPairIdentity;

	}
		

	

	protected String getTableName(){
		return KeyPairIdentityTable.TABLE_NAME;
	}



	public void enhanceList(List<KeyPairIdentity> keyPairIdentityList) {
		this.enhanceListInternal(keyPairIdentityList, this.getKeyPairIdentityMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<KeyPairIdentity> keyPairIdentityList = ownerEntity.collectRefsWithType(KeyPairIdentity.INTERNAL_TYPE);
		this.enhanceList(keyPairIdentityList);

	}

	@Override
	public SmartList<KeyPairIdentity> findKeyPairIdentityWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getKeyPairIdentityMapper());

	}
	@Override
	public int countKeyPairIdentityWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countKeyPairIdentityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<KeyPairIdentity> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getKeyPairIdentityMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<KeyPairIdentity> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getKeyPairIdentityMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateKeyPairIdentity executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateKeyPairIdentity result = new CandidateKeyPairIdentity();
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
  public List<KeyPairIdentity> search(KeyPairIdentityRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected KeyPairIdentityMapper mapper() {
    return getKeyPairIdentityMapper();
  }
}


