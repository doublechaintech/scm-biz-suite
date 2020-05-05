
package com.doublechaintech.retailscm.retailstorememberaddress;

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


import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class RetailStoreMemberAddressJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreMemberAddressDAO{

	protected RetailStoreMemberDAO retailStoreMemberDAO;
	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
 	
 		if(retailStoreMemberDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberDAO to null.");
 		}
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
 		if(this.retailStoreMemberDAO == null){
 			throw new IllegalStateException("The retailStoreMemberDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberDAO;
 	}	

	
	/*
	protected RetailStoreMemberAddress load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberAddress(accessKey, options);
	}
	*/
	
	public SmartList<RetailStoreMemberAddress> loadAll() {
	    return this.loadAll(getRetailStoreMemberAddressMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreMemberAddress load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberAddress(RetailStoreMemberAddressTable.withId(id), options);
	}
	
	
	
	public RetailStoreMemberAddress save(RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object> options){
		
		String methodName="save(RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreMemberAddress, methodName, "retailStoreMemberAddress");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreMemberAddress(retailStoreMemberAddress,options);
	}
	public RetailStoreMemberAddress clone(String retailStoreMemberAddressId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreMemberAddressTable.withId(retailStoreMemberAddressId),options);
	}
	
	protected RetailStoreMemberAddress clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreMemberAddressId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreMemberAddress newRetailStoreMemberAddress = loadInternalRetailStoreMemberAddress(accessKey, options);
		newRetailStoreMemberAddress.setVersion(0);
		
		

		
		saveInternalRetailStoreMemberAddress(newRetailStoreMemberAddress,options);
		
		return newRetailStoreMemberAddress;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreMemberAddressId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreMemberAddressVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreMemberAddressNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreMemberAddressId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreMemberAddressId, int version) throws Exception{
	
		String methodName="delete(String retailStoreMemberAddressId, int version)";
		assertMethodArgumentNotNull(retailStoreMemberAddressId, methodName, "retailStoreMemberAddressId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreMemberAddressId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreMemberAddressId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreMemberAddress disconnectFromAll(String retailStoreMemberAddressId, int version) throws Exception{
	
		
		RetailStoreMemberAddress retailStoreMemberAddress = loadInternalRetailStoreMemberAddress(RetailStoreMemberAddressTable.withId(retailStoreMemberAddressId), emptyOptions());
		retailStoreMemberAddress.clearFromAll();
		this.saveRetailStoreMemberAddress(retailStoreMemberAddress);
		return retailStoreMemberAddress;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreMemberAddressTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_member_address";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreMemberAddress";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreMemberAddressTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreMemberAddressTokens.OWNER);
 	}

 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreMemberAddressTokens.OWNER);
 	}
 	

 	
 
		

	

	protected RetailStoreMemberAddressMapper getRetailStoreMemberAddressMapper(){
		return new RetailStoreMemberAddressMapper();
	}

	
	
	protected RetailStoreMemberAddress extractRetailStoreMemberAddress(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreMemberAddress retailStoreMemberAddress = loadSingleObject(accessKey, getRetailStoreMemberAddressMapper());
			return retailStoreMemberAddress;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberAddressNotFoundException("RetailStoreMemberAddress("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreMemberAddress loadInternalRetailStoreMemberAddress(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreMemberAddress retailStoreMemberAddress = extractRetailStoreMemberAddress(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(retailStoreMemberAddress, loadOptions);
 		}
 
		
		return retailStoreMemberAddress;
		
	}

	 

 	protected RetailStoreMemberAddress extractOwner(RetailStoreMemberAddress retailStoreMemberAddress, Map<String,Object> options) throws Exception{

		if(retailStoreMemberAddress.getOwner() == null){
			return retailStoreMemberAddress;
		}
		String ownerId = retailStoreMemberAddress.getOwner().getId();
		if( ownerId == null){
			return retailStoreMemberAddress;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			retailStoreMemberAddress.setOwner(owner);
		}
		
 		
 		return retailStoreMemberAddress;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
  		SmartList<RetailStoreMemberAddress> resultList = queryWith(RetailStoreMemberAddressTable.COLUMN_OWNER, retailStoreMemberId, options, getRetailStoreMemberAddressMapper());
		// analyzeRetailStoreMemberAddressByOwner(resultList, retailStoreMemberId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreMemberAddress> resultList =  queryWithRange(RetailStoreMemberAddressTable.COLUMN_OWNER, retailStoreMemberId, options, getRetailStoreMemberAddressMapper(), start, count);
 		//analyzeRetailStoreMemberAddressByOwner(resultList, retailStoreMemberId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreMemberAddressByOwner(SmartList<RetailStoreMemberAddress> resultList, String retailStoreMemberId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countRetailStoreMemberAddressByOwner(String retailStoreMemberId,Map<String,Object> options){

 		return countWith(RetailStoreMemberAddressTable.COLUMN_OWNER, retailStoreMemberId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreMemberAddressByOwnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreMemberAddressTable.COLUMN_OWNER, ids, options);
	}
 	
 	
		
		
		

	

	protected RetailStoreMemberAddress saveRetailStoreMemberAddress(RetailStoreMemberAddress  retailStoreMemberAddress){
		
		if(!retailStoreMemberAddress.isChanged()){
			return retailStoreMemberAddress;
		}
		
		
		String SQL=this.getSaveRetailStoreMemberAddressSQL(retailStoreMemberAddress);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreMemberAddressParameters(retailStoreMemberAddress);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreMemberAddress.incVersion();
		return retailStoreMemberAddress;
	
	}
	public SmartList<RetailStoreMemberAddress> saveRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreMemberAddressList(retailStoreMemberAddressList);
		
		batchRetailStoreMemberAddressCreate((List<RetailStoreMemberAddress>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreMemberAddressUpdate((List<RetailStoreMemberAddress>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList){
			if(retailStoreMemberAddress.isChanged()){
				retailStoreMemberAddress.incVersion();
			}
			
		
		}
		
		
		return retailStoreMemberAddressList;
	}

	public SmartList<RetailStoreMemberAddress> removeRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options){
		
		
		super.removeList(retailStoreMemberAddressList, options);
		
		return retailStoreMemberAddressList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreMemberAddressBatchCreateArgs(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList ){
			Object [] parameters = prepareRetailStoreMemberAddressCreateParameters(retailStoreMemberAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreMemberAddressBatchUpdateArgs(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList ){
			if(!retailStoreMemberAddress.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreMemberAddressUpdateParameters(retailStoreMemberAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreMemberAddressCreate(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreMemberAddressBatchCreateArgs(retailStoreMemberAddressList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreMemberAddressUpdate(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreMemberAddressBatchUpdateArgs(retailStoreMemberAddressList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreMemberAddressList(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		
		List<RetailStoreMemberAddress> retailStoreMemberAddressCreateList=new ArrayList<RetailStoreMemberAddress>();
		List<RetailStoreMemberAddress> retailStoreMemberAddressUpdateList=new ArrayList<RetailStoreMemberAddress>();
		
		for(RetailStoreMemberAddress retailStoreMemberAddress: retailStoreMemberAddressList){
			if(isUpdateRequest(retailStoreMemberAddress)){
				retailStoreMemberAddressUpdateList.add( retailStoreMemberAddress);
				continue;
			}
			retailStoreMemberAddressCreateList.add(retailStoreMemberAddress);
		}
		
		return new Object[]{retailStoreMemberAddressCreateList,retailStoreMemberAddressUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreMemberAddress retailStoreMemberAddress){
 		return retailStoreMemberAddress.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreMemberAddressSQL(RetailStoreMemberAddress retailStoreMemberAddress){
 		if(isUpdateRequest(retailStoreMemberAddress)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreMemberAddressParameters(RetailStoreMemberAddress retailStoreMemberAddress){
 		if(isUpdateRequest(retailStoreMemberAddress) ){
 			return prepareRetailStoreMemberAddressUpdateParameters(retailStoreMemberAddress);
 		}
 		return prepareRetailStoreMemberAddressCreateParameters(retailStoreMemberAddress);
 	}
 	protected Object[] prepareRetailStoreMemberAddressUpdateParameters(RetailStoreMemberAddress retailStoreMemberAddress){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = retailStoreMemberAddress.getName();
 		 	
 		if(retailStoreMemberAddress.getOwner() != null){
 			parameters[1] = retailStoreMemberAddress.getOwner().getId();
 		}
 
 		
 		parameters[2] = retailStoreMemberAddress.getMobilePhone();
 		
 		
 		parameters[3] = retailStoreMemberAddress.getAddress();
 				
 		parameters[4] = retailStoreMemberAddress.nextVersion();
 		parameters[5] = retailStoreMemberAddress.getId();
 		parameters[6] = retailStoreMemberAddress.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreMemberAddressCreateParameters(RetailStoreMemberAddress retailStoreMemberAddress){
		Object[] parameters = new Object[5];
		String newRetailStoreMemberAddressId=getNextId();
		retailStoreMemberAddress.setId(newRetailStoreMemberAddressId);
		parameters[0] =  retailStoreMemberAddress.getId();
 
 		
 		parameters[1] = retailStoreMemberAddress.getName();
 		 	
 		if(retailStoreMemberAddress.getOwner() != null){
 			parameters[2] = retailStoreMemberAddress.getOwner().getId();
 		
 		}
 		
 		
 		parameters[3] = retailStoreMemberAddress.getMobilePhone();
 		
 		
 		parameters[4] = retailStoreMemberAddress.getAddress();
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreMemberAddress saveInternalRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress, Map<String,Object> options){
		
		saveRetailStoreMemberAddress(retailStoreMemberAddress);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(retailStoreMemberAddress, options);
 		}
 
		
		return retailStoreMemberAddress;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreMemberAddress saveOwner(RetailStoreMemberAddress retailStoreMemberAddress, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreMemberAddress.getOwner() == null){
 			return retailStoreMemberAddress;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(retailStoreMemberAddress.getOwner(),options);
 		return retailStoreMemberAddress;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public RetailStoreMemberAddress present(RetailStoreMemberAddress retailStoreMemberAddress,Map<String, Object> options){
	

		return retailStoreMemberAddress;
	
	}
		

	

	protected String getTableName(){
		return RetailStoreMemberAddressTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreMemberAddress> retailStoreMemberAddressList) {		
		this.enhanceListInternal(retailStoreMemberAddressList, this.getRetailStoreMemberAddressMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreMemberAddress> retailStoreMemberAddressList = ownerEntity.collectRefsWithType(RetailStoreMemberAddress.INTERNAL_TYPE);
		this.enhanceList(retailStoreMemberAddressList);
		
	}
	
	@Override
	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreMemberAddressMapper());

	}
	@Override
	public int countRetailStoreMemberAddressWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreMemberAddressWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreMemberAddress> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreMemberAddressMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreMemberAddress executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreMemberAddress result = new CandidateRetailStoreMemberAddress();
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


