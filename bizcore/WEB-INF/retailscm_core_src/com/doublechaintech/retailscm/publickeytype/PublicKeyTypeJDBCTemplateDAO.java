
package com.doublechaintech.retailscm.publickeytype;

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


import com.doublechaintech.retailscm.keypairidentity.KeypairIdentity;
import com.doublechaintech.retailscm.userdomain.UserDomain;

import com.doublechaintech.retailscm.userdomain.UserDomainDAO;
import com.doublechaintech.retailscm.keypairidentity.KeypairIdentityDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class PublicKeyTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements PublicKeyTypeDAO{

	protected UserDomainDAO userDomainDAO;
	public void setUserDomainDAO(UserDomainDAO userDomainDAO){
 	
 		if(userDomainDAO == null){
 			throw new IllegalStateException("Do not try to set userDomainDAO to null.");
 		}
	 	this.userDomainDAO = userDomainDAO;
 	}
 	public UserDomainDAO getUserDomainDAO(){
 		if(this.userDomainDAO == null){
 			throw new IllegalStateException("The userDomainDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userDomainDAO;
 	}	

	protected KeypairIdentityDAO keypairIdentityDAO;
	public void setKeypairIdentityDAO(KeypairIdentityDAO keypairIdentityDAO){
 	
 		if(keypairIdentityDAO == null){
 			throw new IllegalStateException("Do not try to set keypairIdentityDAO to null.");
 		}
	 	this.keypairIdentityDAO = keypairIdentityDAO;
 	}
 	public KeypairIdentityDAO getKeypairIdentityDAO(){
 		if(this.keypairIdentityDAO == null){
 			throw new IllegalStateException("The keypairIdentityDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.keypairIdentityDAO;
 	}	


	/*
	protected PublicKeyType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPublicKeyType(accessKey, options);
	}
	*/

	public SmartList<PublicKeyType> loadAll() {
	    return this.loadAll(getPublicKeyTypeMapper());
	}

  public Stream<PublicKeyType> loadAllAsStream() {
      return this.loadAllAsStream(getPublicKeyTypeMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public PublicKeyType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPublicKeyType(PublicKeyTypeTable.withId(id), options);
	}

	

	public PublicKeyType save(PublicKeyType publicKeyType,Map<String,Object> options){

		String methodName="save(PublicKeyType publicKeyType,Map<String,Object> options)";

		assertMethodArgumentNotNull(publicKeyType, methodName, "publicKeyType");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalPublicKeyType(publicKeyType,options);
	}
	public PublicKeyType clone(String publicKeyTypeId, Map<String,Object> options) throws Exception{

		return clone(PublicKeyTypeTable.withId(publicKeyTypeId),options);
	}

	protected PublicKeyType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String publicKeyTypeId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		PublicKeyType newPublicKeyType = loadInternalPublicKeyType(accessKey, options);
		newPublicKeyType.setVersion(0);
		
		
 		
 		if(isSaveKeypairIdentityListEnabled(options)){
 			for(KeypairIdentity item: newPublicKeyType.getKeypairIdentityList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalPublicKeyType(newPublicKeyType,options);

		return newPublicKeyType;
	}

	



	protected void throwIfHasException(String publicKeyTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PublicKeyTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PublicKeyTypeNotFoundException(
					"The " + this.getTableName() + "(" + publicKeyTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String publicKeyTypeId, int version) throws Exception{

		String methodName="delete(String publicKeyTypeId, int version)";
		assertMethodArgumentNotNull(publicKeyTypeId, methodName, "publicKeyTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{publicKeyTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(publicKeyTypeId,version);
		}


	}






	public PublicKeyType disconnectFromAll(String publicKeyTypeId, int version) throws Exception{


		PublicKeyType publicKeyType = loadInternalPublicKeyType(PublicKeyTypeTable.withId(publicKeyTypeId), emptyOptions());
		publicKeyType.clearFromAll();
		this.savePublicKeyType(publicKeyType);
		return publicKeyType;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return PublicKeyTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "public_key_type";
	}
	@Override
	protected String getBeanName() {

		return "publicKeyType";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PublicKeyTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractDomainEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PublicKeyTypeTokens.DOMAIN);
 	}

 	protected boolean isSaveDomainEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PublicKeyTypeTokens.DOMAIN);
 	}
 	

 	
 
		
	
	protected boolean isExtractKeypairIdentityListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PublicKeyTypeTokens.KEYPAIR_IDENTITY_LIST);
 	}
 	protected boolean isAnalyzeKeypairIdentityListEnabled(Map<String,Object> options){		 		
 		return PublicKeyTypeTokens.of(options).analyzeKeypairIdentityListEnabled();
 	}
	
	protected boolean isSaveKeypairIdentityListEnabled(Map<String,Object> options){
		return checkOptions(options, PublicKeyTypeTokens.KEYPAIR_IDENTITY_LIST);
		
 	}
 	
		

	

	protected PublicKeyTypeMapper getPublicKeyTypeMapper(){
		return new PublicKeyTypeMapper();
	}

	
	
	protected PublicKeyType extractPublicKeyType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			PublicKeyType publicKeyType = loadSingleObject(accessKey, getPublicKeyTypeMapper());
			return publicKeyType;
		}catch(EmptyResultDataAccessException e){
			throw new PublicKeyTypeNotFoundException("PublicKeyType("+accessKey+") is not found!");
		}

	}

	
	

	protected PublicKeyType loadInternalPublicKeyType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PublicKeyType publicKeyType = extractPublicKeyType(accessKey, loadOptions);
 	
 		if(isExtractDomainEnabled(loadOptions)){
	 		extractDomain(publicKeyType, loadOptions);
 		}
 
		
		if(isExtractKeypairIdentityListEnabled(loadOptions)){
	 		extractKeypairIdentityList(publicKeyType, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeKeypairIdentityListEnabled(loadOptions)){
	 		analyzeKeypairIdentityList(publicKeyType, loadOptions);
 		}
 		
		
		return publicKeyType;
		
	}

	 

 	protected PublicKeyType extractDomain(PublicKeyType publicKeyType, Map<String,Object> options) throws Exception{

		if(publicKeyType.getDomain() == null){
			return publicKeyType;
		}
		String domainId = publicKeyType.getDomain().getId();
		if( domainId == null){
			return publicKeyType;
		}
		UserDomain domain = getUserDomainDAO().load(domainId,options);
		if(domain != null){
			publicKeyType.setDomain(domain);
		}
		
 		
 		return publicKeyType;
 	}
 		
 
		
	protected void enhanceKeypairIdentityList(SmartList<KeypairIdentity> keypairIdentityList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected PublicKeyType extractKeypairIdentityList(PublicKeyType publicKeyType, Map<String,Object> options){
		
		
		if(publicKeyType == null){
			return null;
		}
		if(publicKeyType.getId() == null){
			return publicKeyType;
		}

		
		
		SmartList<KeypairIdentity> keypairIdentityList = getKeypairIdentityDAO().findKeypairIdentityByKeyType(publicKeyType.getId(),options);
		if(keypairIdentityList != null){
			enhanceKeypairIdentityList(keypairIdentityList,options);
			publicKeyType.setKeypairIdentityList(keypairIdentityList);
		}
		
		return publicKeyType;
	
	}	
	
	protected PublicKeyType analyzeKeypairIdentityList(PublicKeyType publicKeyType, Map<String,Object> options){
		
		
		if(publicKeyType == null){
			return null;
		}
		if(publicKeyType.getId() == null){
			return publicKeyType;
		}

		
		
		SmartList<KeypairIdentity> keypairIdentityList = publicKeyType.getKeypairIdentityList();
		if(keypairIdentityList != null){
			getKeypairIdentityDAO().analyzeKeypairIdentityByKeyType(keypairIdentityList, publicKeyType.getId(), options);
			
		}
		
		return publicKeyType;
	
	}	
	
		
		
  	
 	public SmartList<PublicKeyType> findPublicKeyTypeByDomain(String userDomainId,Map<String,Object> options){
 	
  		SmartList<PublicKeyType> resultList = queryWith(PublicKeyTypeTable.COLUMN_DOMAIN, userDomainId, options, getPublicKeyTypeMapper());
		// analyzePublicKeyTypeByDomain(resultList, userDomainId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PublicKeyType> findPublicKeyTypeByDomain(String userDomainId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PublicKeyType> resultList =  queryWithRange(PublicKeyTypeTable.COLUMN_DOMAIN, userDomainId, options, getPublicKeyTypeMapper(), start, count);
 		//analyzePublicKeyTypeByDomain(resultList, userDomainId, options);
 		return resultList;
 		
 	}
 	public void analyzePublicKeyTypeByDomain(SmartList<PublicKeyType> resultList, String userDomainId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countPublicKeyTypeByDomain(String userDomainId,Map<String,Object> options){

 		return countWith(PublicKeyTypeTable.COLUMN_DOMAIN, userDomainId, options);
 	}
 	@Override
	public Map<String, Integer> countPublicKeyTypeByDomainIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PublicKeyTypeTable.COLUMN_DOMAIN, ids, options);
	}
 	
 	
		
		
		

	

	protected PublicKeyType savePublicKeyType(PublicKeyType  publicKeyType){
		
		if(!publicKeyType.isChanged()){
			return publicKeyType;
		}
		

		String SQL=this.getSavePublicKeyTypeSQL(publicKeyType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePublicKeyTypeParameters(publicKeyType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		publicKeyType.incVersion();
		return publicKeyType;

	}
	public SmartList<PublicKeyType> savePublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPublicKeyTypeList(publicKeyTypeList);

		batchPublicKeyTypeCreate((List<PublicKeyType>)lists[CREATE_LIST_INDEX]);

		batchPublicKeyTypeUpdate((List<PublicKeyType>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(PublicKeyType publicKeyType:publicKeyTypeList){
			if(publicKeyType.isChanged()){
				publicKeyType.incVersion();
			}


		}


		return publicKeyTypeList;
	}

	public SmartList<PublicKeyType> removePublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList,Map<String,Object> options){


		super.removeList(publicKeyTypeList, options);

		return publicKeyTypeList;


	}

	protected List<Object[]> preparePublicKeyTypeBatchCreateArgs(List<PublicKeyType> publicKeyTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PublicKeyType publicKeyType:publicKeyTypeList ){
			Object [] parameters = preparePublicKeyTypeCreateParameters(publicKeyType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> preparePublicKeyTypeBatchUpdateArgs(List<PublicKeyType> publicKeyTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PublicKeyType publicKeyType:publicKeyTypeList ){
			if(!publicKeyType.isChanged()){
				continue;
			}
			Object [] parameters = preparePublicKeyTypeUpdateParameters(publicKeyType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchPublicKeyTypeCreate(List<PublicKeyType> publicKeyTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePublicKeyTypeBatchCreateArgs(publicKeyTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchPublicKeyTypeUpdate(List<PublicKeyType> publicKeyTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePublicKeyTypeBatchUpdateArgs(publicKeyTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitPublicKeyTypeList(List<PublicKeyType> publicKeyTypeList){

		List<PublicKeyType> publicKeyTypeCreateList=new ArrayList<PublicKeyType>();
		List<PublicKeyType> publicKeyTypeUpdateList=new ArrayList<PublicKeyType>();

		for(PublicKeyType publicKeyType: publicKeyTypeList){
			if(isUpdateRequest(publicKeyType)){
				publicKeyTypeUpdateList.add( publicKeyType);
				continue;
			}
			publicKeyTypeCreateList.add(publicKeyType);
		}

		return new Object[]{publicKeyTypeCreateList,publicKeyTypeUpdateList};
	}

	protected boolean isUpdateRequest(PublicKeyType publicKeyType){
 		return publicKeyType.getVersion() > 0;
 	}
 	protected String getSavePublicKeyTypeSQL(PublicKeyType publicKeyType){
 		if(isUpdateRequest(publicKeyType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSavePublicKeyTypeParameters(PublicKeyType publicKeyType){
 		if(isUpdateRequest(publicKeyType) ){
 			return preparePublicKeyTypeUpdateParameters(publicKeyType);
 		}
 		return preparePublicKeyTypeCreateParameters(publicKeyType);
 	}
 	protected Object[] preparePublicKeyTypeUpdateParameters(PublicKeyType publicKeyType){
 		Object[] parameters = new Object[6];
 
 		
 		parameters[0] = publicKeyType.getName();
 		
 		
 		parameters[1] = publicKeyType.getCode();
 		
 		if(publicKeyType.getDomain() != null){
 			parameters[2] = publicKeyType.getDomain().getId();
 		}
 
 		parameters[3] = publicKeyType.nextVersion();
 		parameters[4] = publicKeyType.getId();
 		parameters[5] = publicKeyType.getVersion();

 		return parameters;
 	}
 	protected Object[] preparePublicKeyTypeCreateParameters(PublicKeyType publicKeyType){
		Object[] parameters = new Object[4];
        if(publicKeyType.getId() == null){
          String newPublicKeyTypeId=getNextId();
          publicKeyType.setId(newPublicKeyTypeId);
        }
		parameters[0] =  publicKeyType.getId();
 
 		
 		parameters[1] = publicKeyType.getName();
 		
 		
 		parameters[2] = publicKeyType.getCode();
 		
 		if(publicKeyType.getDomain() != null){
 			parameters[3] = publicKeyType.getDomain().getId();

 		}
 		

 		return parameters;
 	}

	protected PublicKeyType saveInternalPublicKeyType(PublicKeyType publicKeyType, Map<String,Object> options){

		savePublicKeyType(publicKeyType);

 		if(isSaveDomainEnabled(options)){
	 		saveDomain(publicKeyType, options);
 		}
 
		
		if(isSaveKeypairIdentityListEnabled(options)){
	 		saveKeypairIdentityList(publicKeyType, options);
	 		//removeKeypairIdentityList(publicKeyType, options);
	 		//Not delete the record

 		}
		
		return publicKeyType;

	}



	//======================================================================================
	

 	protected PublicKeyType saveDomain(PublicKeyType publicKeyType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(publicKeyType.getDomain() == null){
 			return publicKeyType;//do nothing when it is null
 		}

 		getUserDomainDAO().save(publicKeyType.getDomain(),options);
 		return publicKeyType;

 	}





 

	
	public PublicKeyType planToRemoveKeypairIdentityList(PublicKeyType publicKeyType, String keypairIdentityIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(KeypairIdentity.KEY_TYPE_PROPERTY, publicKeyType.getId());
		key.put(KeypairIdentity.ID_PROPERTY, keypairIdentityIds);

		SmartList<KeypairIdentity> externalKeypairIdentityList = getKeypairIdentityDAO().
				findKeypairIdentityWithKey(key, options);
		if(externalKeypairIdentityList == null){
			return publicKeyType;
		}
		if(externalKeypairIdentityList.isEmpty()){
			return publicKeyType;
		}

		for(KeypairIdentity keypairIdentityItem: externalKeypairIdentityList){

			keypairIdentityItem.clearFromAll();
		}


		SmartList<KeypairIdentity> keypairIdentityList = publicKeyType.getKeypairIdentityList();
		keypairIdentityList.addAllToRemoveList(externalKeypairIdentityList);
		return publicKeyType;

	}


	//disconnect PublicKeyType with sec_user in KeypairIdentity
	public PublicKeyType planToRemoveKeypairIdentityListWithSecUser(PublicKeyType publicKeyType, String secUserId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(KeypairIdentity.KEY_TYPE_PROPERTY, publicKeyType.getId());
		key.put(KeypairIdentity.SEC_USER_PROPERTY, secUserId);

		SmartList<KeypairIdentity> externalKeypairIdentityList = getKeypairIdentityDAO().
				findKeypairIdentityWithKey(key, options);
		if(externalKeypairIdentityList == null){
			return publicKeyType;
		}
		if(externalKeypairIdentityList.isEmpty()){
			return publicKeyType;
		}

		for(KeypairIdentity keypairIdentityItem: externalKeypairIdentityList){
			keypairIdentityItem.clearSecUser();
			keypairIdentityItem.clearKeyType();

		}


		SmartList<KeypairIdentity> keypairIdentityList = publicKeyType.getKeypairIdentityList();
		keypairIdentityList.addAllToRemoveList(externalKeypairIdentityList);
		return publicKeyType;
	}

	public int countKeypairIdentityListWithSecUser(String publicKeyTypeId, String secUserId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(KeypairIdentity.KEY_TYPE_PROPERTY, publicKeyTypeId);
		key.put(KeypairIdentity.SEC_USER_PROPERTY, secUserId);

		int count = getKeypairIdentityDAO().countKeypairIdentityWithKey(key, options);
		return count;
	}
	

		
	protected PublicKeyType saveKeypairIdentityList(PublicKeyType publicKeyType, Map<String,Object> options){




		SmartList<KeypairIdentity> keypairIdentityList = publicKeyType.getKeypairIdentityList();
		if(keypairIdentityList == null){
			//null list means nothing
			return publicKeyType;
		}
		SmartList<KeypairIdentity> mergedUpdateKeypairIdentityList = new SmartList<KeypairIdentity>();


		mergedUpdateKeypairIdentityList.addAll(keypairIdentityList);
		if(keypairIdentityList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateKeypairIdentityList.addAll(keypairIdentityList.getToRemoveList());
			keypairIdentityList.removeAll(keypairIdentityList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getKeypairIdentityDAO().saveKeypairIdentityList(mergedUpdateKeypairIdentityList,options);

		if(keypairIdentityList.getToRemoveList() != null){
			keypairIdentityList.removeAll(keypairIdentityList.getToRemoveList());
		}


		return publicKeyType;

	}

	protected PublicKeyType removeKeypairIdentityList(PublicKeyType publicKeyType, Map<String,Object> options){


		SmartList<KeypairIdentity> keypairIdentityList = publicKeyType.getKeypairIdentityList();
		if(keypairIdentityList == null){
			return publicKeyType;
		}

		SmartList<KeypairIdentity> toRemoveKeypairIdentityList = keypairIdentityList.getToRemoveList();

		if(toRemoveKeypairIdentityList == null){
			return publicKeyType;
		}
		if(toRemoveKeypairIdentityList.isEmpty()){
			return publicKeyType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getKeypairIdentityDAO().removeKeypairIdentityList(toRemoveKeypairIdentityList,options);

		return publicKeyType;

	}








		

	public PublicKeyType present(PublicKeyType publicKeyType,Map<String, Object> options){
	
		presentKeypairIdentityList(publicKeyType,options);

		return publicKeyType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected PublicKeyType presentKeypairIdentityList(
			PublicKeyType publicKeyType,
			Map<String, Object> options) {

		SmartList<KeypairIdentity> keypairIdentityList = publicKeyType.getKeypairIdentityList();		
				SmartList<KeypairIdentity> newList= presentSubList(publicKeyType.getId(),
				keypairIdentityList,
				options,
				getKeypairIdentityDAO()::countKeypairIdentityByKeyType,
				getKeypairIdentityDAO()::findKeypairIdentityByKeyType
				);

		
		publicKeyType.setKeypairIdentityList(newList);
		

		return publicKeyType;
	}			
		

	
    public SmartList<PublicKeyType> requestCandidatePublicKeyTypeForKeypairIdentity(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PublicKeyTypeTable.COLUMN_NAME, PublicKeyTypeTable.COLUMN_DOMAIN, filterKey, pageNo, pageSize, getPublicKeyTypeMapper());
    }
		

	protected String getTableName(){
		return PublicKeyTypeTable.TABLE_NAME;
	}



	public void enhanceList(List<PublicKeyType> publicKeyTypeList) {
		this.enhanceListInternal(publicKeyTypeList, this.getPublicKeyTypeMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:KeypairIdentity的keyType的KeypairIdentityList
	public SmartList<KeypairIdentity> loadOurKeypairIdentityList(RetailscmUserContext userContext, List<PublicKeyType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(KeypairIdentity.KEY_TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<KeypairIdentity> loadedObjs = userContext.getDAOGroup().getKeypairIdentityDAO().findKeypairIdentityWithKey(key, options);
		Map<String, List<KeypairIdentity>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getKeyType().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<KeypairIdentity> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<KeypairIdentity> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setKeypairIdentityList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<PublicKeyType> publicKeyTypeList = ownerEntity.collectRefsWithType(PublicKeyType.INTERNAL_TYPE);
		this.enhanceList(publicKeyTypeList);

	}

	@Override
	public SmartList<PublicKeyType> findPublicKeyTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getPublicKeyTypeMapper());

	}
	@Override
	public int countPublicKeyTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countPublicKeyTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<PublicKeyType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPublicKeyTypeMapper());
	}

  @Override
  public Stream<PublicKeyType> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getPublicKeyTypeMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidatePublicKeyType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidatePublicKeyType result = new CandidatePublicKeyType();
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


