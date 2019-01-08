
package com.doublechaintech.retailscm.secuserblocking;

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


import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.SecUserDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class SecUserBlockingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SecUserBlockingDAO{


			
		
	
  	private  SecUserDAO  secUserDAO;
 	public void setSecUserDAO(SecUserDAO pSecUserDAO){
 	
 		if(pSecUserDAO == null){
 			throw new IllegalStateException("Do not try to set secUserDAO to null.");
 		}
	 	this.secUserDAO = pSecUserDAO;
 	}
 	public SecUserDAO getSecUserDAO(){
 		if(this.secUserDAO == null){
 			throw new IllegalStateException("The secUserDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.secUserDAO;
 	}	
 	
			
		

	
	/*
	protected SecUserBlocking load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSecUserBlocking(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SecUserBlocking load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSecUserBlocking(SecUserBlockingTable.withId(id), options);
	}
	
	
	
	public SecUserBlocking save(SecUserBlocking secUserBlocking,Map<String,Object> options){
		
		String methodName="save(SecUserBlocking secUserBlocking,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(secUserBlocking, methodName, "secUserBlocking");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSecUserBlocking(secUserBlocking,options);
	}
	public SecUserBlocking clone(String secUserBlockingId, Map<String,Object> options) throws Exception{
	
		return clone(SecUserBlockingTable.withId(secUserBlockingId),options);
	}
	
	protected SecUserBlocking clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String secUserBlockingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SecUserBlocking newSecUserBlocking = loadInternalSecUserBlocking(accessKey, options);
		newSecUserBlocking.setVersion(0);
		
		
 		
 		if(isSaveSecUserListEnabled(options)){
 			for(SecUser item: newSecUserBlocking.getSecUserList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSecUserBlocking(newSecUserBlocking,options);
		
		return newSecUserBlocking;
	}
	
	
	
	

	protected void throwIfHasException(String secUserBlockingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SecUserBlockingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SecUserBlockingNotFoundException(
					"The " + this.getTableName() + "(" + secUserBlockingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String secUserBlockingId, int version) throws Exception{
	
		String methodName="delete(String secUserBlockingId, int version)";
		assertMethodArgumentNotNull(secUserBlockingId, methodName, "secUserBlockingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{secUserBlockingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(secUserBlockingId,version);
		}
		
	
	}
	
	
	
	
	

	public SecUserBlocking disconnectFromAll(String secUserBlockingId, int version) throws Exception{
	
		
		SecUserBlocking secUserBlocking = loadInternalSecUserBlocking(SecUserBlockingTable.withId(secUserBlockingId), emptyOptions());
		secUserBlocking.clearFromAll();
		this.saveSecUserBlocking(secUserBlocking);
		return secUserBlocking;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SecUserBlockingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "sec_user_blocking";
	}
	@Override
	protected String getBeanName() {
		
		return "secUserBlocking";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SecUserBlockingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractSecUserListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SecUserBlockingTokens.SEC_USER_LIST);
 	}
 	protected boolean isAnalyzeSecUserListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SecUserBlockingTokens.SEC_USER_LIST+".analyze");
 	}

	protected boolean isSaveSecUserListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserBlockingTokens.SEC_USER_LIST);
		
 	}
 	
		

	

	protected SecUserBlockingMapper getSecUserBlockingMapper(){
		return new SecUserBlockingMapper();
	}

	
	
	protected SecUserBlocking extractSecUserBlocking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SecUserBlocking secUserBlocking = loadSingleObject(accessKey, getSecUserBlockingMapper());
			return secUserBlocking;
		}catch(EmptyResultDataAccessException e){
			throw new SecUserBlockingNotFoundException("SecUserBlocking("+accessKey+") is not found!");
		}

	}

	
	

	protected SecUserBlocking loadInternalSecUserBlocking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SecUserBlocking secUserBlocking = extractSecUserBlocking(accessKey, loadOptions);

		
		if(isExtractSecUserListEnabled(loadOptions)){
	 		extractSecUserList(secUserBlocking, loadOptions);
 		}	
 		if(isAnalyzeSecUserListEnabled(loadOptions)){
	 		// analyzeSecUserList(secUserBlocking, loadOptions);
 		}
 		
		
		return secUserBlocking;
		
	}

	
		
	protected void enhanceSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SecUserBlocking extractSecUserList(SecUserBlocking secUserBlocking, Map<String,Object> options){
		
		
		if(secUserBlocking == null){
			return null;
		}
		if(secUserBlocking.getId() == null){
			return secUserBlocking;
		}

		
		
		SmartList<SecUser> secUserList = getSecUserDAO().findSecUserByBlocking(secUserBlocking.getId(),options);
		if(secUserList != null){
			enhanceSecUserList(secUserList,options);
			secUserBlocking.setSecUserList(secUserList);
		}
		
		return secUserBlocking;
	
	}	
	
	protected SecUserBlocking analyzeSecUserList(SecUserBlocking secUserBlocking, Map<String,Object> options){
		
		
		if(secUserBlocking == null){
			return null;
		}
		if(secUserBlocking.getId() == null){
			return secUserBlocking;
		}

		
		
		SmartList<SecUser> secUserList = secUserBlocking.getSecUserList();
		if(secUserList != null){
			getSecUserDAO().analyzeSecUserByBlocking(secUserList, secUserBlocking.getId(), options);
			
		}
		
		return secUserBlocking;
	
	}	
	
		
		
 	
		
		
		

	

	protected SecUserBlocking saveSecUserBlocking(SecUserBlocking  secUserBlocking){
		
		if(!secUserBlocking.isChanged()){
			return secUserBlocking;
		}
		
		
		String SQL=this.getSaveSecUserBlockingSQL(secUserBlocking);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSecUserBlockingParameters(secUserBlocking);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		secUserBlocking.incVersion();
		return secUserBlocking;
	
	}
	public SmartList<SecUserBlocking> saveSecUserBlockingList(SmartList<SecUserBlocking> secUserBlockingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSecUserBlockingList(secUserBlockingList);
		
		batchSecUserBlockingCreate((List<SecUserBlocking>)lists[CREATE_LIST_INDEX]);
		
		batchSecUserBlockingUpdate((List<SecUserBlocking>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SecUserBlocking secUserBlocking:secUserBlockingList){
			if(secUserBlocking.isChanged()){
				secUserBlocking.incVersion();
			}
			
		
		}
		
		
		return secUserBlockingList;
	}

	public SmartList<SecUserBlocking> removeSecUserBlockingList(SmartList<SecUserBlocking> secUserBlockingList,Map<String,Object> options){
		
		
		super.removeList(secUserBlockingList, options);
		
		return secUserBlockingList;
		
		
	}
	
	protected List<Object[]> prepareSecUserBlockingBatchCreateArgs(List<SecUserBlocking> secUserBlockingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SecUserBlocking secUserBlocking:secUserBlockingList ){
			Object [] parameters = prepareSecUserBlockingCreateParameters(secUserBlocking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSecUserBlockingBatchUpdateArgs(List<SecUserBlocking> secUserBlockingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SecUserBlocking secUserBlocking:secUserBlockingList ){
			if(!secUserBlocking.isChanged()){
				continue;
			}
			Object [] parameters = prepareSecUserBlockingUpdateParameters(secUserBlocking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSecUserBlockingCreate(List<SecUserBlocking> secUserBlockingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSecUserBlockingBatchCreateArgs(secUserBlockingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSecUserBlockingUpdate(List<SecUserBlocking> secUserBlockingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSecUserBlockingBatchUpdateArgs(secUserBlockingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSecUserBlockingList(List<SecUserBlocking> secUserBlockingList){
		
		List<SecUserBlocking> secUserBlockingCreateList=new ArrayList<SecUserBlocking>();
		List<SecUserBlocking> secUserBlockingUpdateList=new ArrayList<SecUserBlocking>();
		
		for(SecUserBlocking secUserBlocking: secUserBlockingList){
			if(isUpdateRequest(secUserBlocking)){
				secUserBlockingUpdateList.add( secUserBlocking);
				continue;
			}
			secUserBlockingCreateList.add(secUserBlocking);
		}
		
		return new Object[]{secUserBlockingCreateList,secUserBlockingUpdateList};
	}
	
	protected boolean isUpdateRequest(SecUserBlocking secUserBlocking){
 		return secUserBlocking.getVersion() > 0;
 	}
 	protected String getSaveSecUserBlockingSQL(SecUserBlocking secUserBlocking){
 		if(isUpdateRequest(secUserBlocking)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSecUserBlockingParameters(SecUserBlocking secUserBlocking){
 		if(isUpdateRequest(secUserBlocking) ){
 			return prepareSecUserBlockingUpdateParameters(secUserBlocking);
 		}
 		return prepareSecUserBlockingCreateParameters(secUserBlocking);
 	}
 	protected Object[] prepareSecUserBlockingUpdateParameters(SecUserBlocking secUserBlocking){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = secUserBlocking.getWho();
 		parameters[1] = secUserBlocking.getBlockTime();
 		parameters[2] = secUserBlocking.getComments();		
 		parameters[3] = secUserBlocking.nextVersion();
 		parameters[4] = secUserBlocking.getId();
 		parameters[5] = secUserBlocking.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSecUserBlockingCreateParameters(SecUserBlocking secUserBlocking){
		Object[] parameters = new Object[4];
		String newSecUserBlockingId=getNextId();
		secUserBlocking.setId(newSecUserBlockingId);
		parameters[0] =  secUserBlocking.getId();
 
 		parameters[1] = secUserBlocking.getWho();
 		parameters[2] = secUserBlocking.getBlockTime();
 		parameters[3] = secUserBlocking.getComments();		
 				
 		return parameters;
 	}
 	
	protected SecUserBlocking saveInternalSecUserBlocking(SecUserBlocking secUserBlocking, Map<String,Object> options){
		
		saveSecUserBlocking(secUserBlocking);

		
		if(isSaveSecUserListEnabled(options)){
	 		saveSecUserList(secUserBlocking, options);
	 		//removeSecUserList(secUserBlocking, options);
	 		//Not delete the record
	 		
 		}		
		
		return secUserBlocking;
		
	}
	
	
	
	//======================================================================================
	

	
	public SecUserBlocking planToRemoveSecUserList(SecUserBlocking secUserBlocking, String secUserIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SecUser.BLOCKING_PROPERTY, secUserBlocking.getId());
		key.put(SecUser.ID_PROPERTY, secUserIds);
		
		SmartList<SecUser> externalSecUserList = getSecUserDAO().
				findSecUserWithKey(key, options);
		if(externalSecUserList == null){
			return secUserBlocking;
		}
		if(externalSecUserList.isEmpty()){
			return secUserBlocking;
		}
		
		for(SecUser secUser: externalSecUserList){

			secUser.clearFromAll();
		}
		
		
		SmartList<SecUser> secUserList = secUserBlocking.getSecUserList();		
		secUserList.addAllToRemoveList(externalSecUserList);
		return secUserBlocking;	
	
	}


	//disconnect SecUserBlocking with domain in SecUser
	public SecUserBlocking planToRemoveSecUserListWithDomain(SecUserBlocking secUserBlocking, String domainId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SecUser.BLOCKING_PROPERTY, secUserBlocking.getId());
		key.put(SecUser.DOMAIN_PROPERTY, domainId);
		
		SmartList<SecUser> externalSecUserList = getSecUserDAO().
				findSecUserWithKey(key, options);
		if(externalSecUserList == null){
			return secUserBlocking;
		}
		if(externalSecUserList.isEmpty()){
			return secUserBlocking;
		}
		
		for(SecUser secUser: externalSecUserList){
			secUser.clearDomain();
			secUser.clearBlocking();
			
		}
		
		
		SmartList<SecUser> secUserList = secUserBlocking.getSecUserList();		
		secUserList.addAllToRemoveList(externalSecUserList);
		return secUserBlocking;
	}
	
	public int countSecUserListWithDomain(String secUserBlockingId, String domainId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SecUser.BLOCKING_PROPERTY, secUserBlockingId);
		key.put(SecUser.DOMAIN_PROPERTY, domainId);
		
		int count = getSecUserDAO().countSecUserWithKey(key, options);
		return count;
	}
	

		
	protected SecUserBlocking saveSecUserList(SecUserBlocking secUserBlocking, Map<String,Object> options){
		
		
		
		
		SmartList<SecUser> secUserList = secUserBlocking.getSecUserList();
		if(secUserList == null){
			//null list means nothing
			return secUserBlocking;
		}
		SmartList<SecUser> mergedUpdateSecUserList = new SmartList<SecUser>();
		
		
		mergedUpdateSecUserList.addAll(secUserList); 
		if(secUserList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSecUserList.addAll(secUserList.getToRemoveList());
			secUserList.removeAll(secUserList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSecUserDAO().saveSecUserList(mergedUpdateSecUserList,options);
		
		if(secUserList.getToRemoveList() != null){
			secUserList.removeAll(secUserList.getToRemoveList());
		}
		
		
		return secUserBlocking;
	
	}
	
	protected SecUserBlocking removeSecUserList(SecUserBlocking secUserBlocking, Map<String,Object> options){
	
	
		SmartList<SecUser> secUserList = secUserBlocking.getSecUserList();
		if(secUserList == null){
			return secUserBlocking;
		}	
	
		SmartList<SecUser> toRemoveSecUserList = secUserList.getToRemoveList();
		
		if(toRemoveSecUserList == null){
			return secUserBlocking;
		}
		if(toRemoveSecUserList.isEmpty()){
			return secUserBlocking;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSecUserDAO().removeSecUserList(toRemoveSecUserList,options);
		
		return secUserBlocking;
	
	}
	
	

 	
 	
	
	
	
		

	public SecUserBlocking present(SecUserBlocking secUserBlocking,Map<String, Object> options){
	
		presentSecUserList(secUserBlocking,options);

		return secUserBlocking;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SecUserBlocking presentSecUserList(
			SecUserBlocking secUserBlocking,
			Map<String, Object> options) {

		SmartList<SecUser> secUserList = secUserBlocking.getSecUserList();		
				SmartList<SecUser> newList= presentSubList(secUserBlocking.getId(),
				secUserList,
				options,
				getSecUserDAO()::countSecUserByBlocking,
				getSecUserDAO()::findSecUserByBlocking
				);

		
		secUserBlocking.setSecUserList(newList);
		

		return secUserBlocking;
	}			
		

	
    public SmartList<SecUserBlocking> requestCandidateSecUserBlockingForSecUser(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SecUserBlockingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getSecUserBlockingMapper());
    }
		

	protected String getTableName(){
		return SecUserBlockingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SecUserBlocking> secUserBlockingList) {		
		this.enhanceListInternal(secUserBlockingList, this.getSecUserBlockingMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SecUserBlocking> secUserBlockingList = ownerEntity.collectRefsWithType(SecUserBlocking.INTERNAL_TYPE);
		this.enhanceList(secUserBlockingList);
		
	}
	
	@Override
	public SmartList<SecUserBlocking> findSecUserBlockingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSecUserBlockingMapper());

	}
	@Override
	public int countSecUserBlockingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSecUserBlockingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SecUserBlocking> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSecUserBlockingMapper());
	}
}


