
package com.doublechaintech.retailscm.memberrewardpointredemption;

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


public class MemberRewardPointRedemptionJDBCTemplateDAO extends RetailscmBaseDAOImpl implements MemberRewardPointRedemptionDAO{

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
	protected MemberRewardPointRedemption load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMemberRewardPointRedemption(accessKey, options);
	}
	*/
	
	public SmartList<MemberRewardPointRedemption> loadAll() {
	    return this.loadAll(getMemberRewardPointRedemptionMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public MemberRewardPointRedemption load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMemberRewardPointRedemption(MemberRewardPointRedemptionTable.withId(id), options);
	}
	
	
	
	public MemberRewardPointRedemption save(MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object> options){
		
		String methodName="save(MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(memberRewardPointRedemption, methodName, "memberRewardPointRedemption");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalMemberRewardPointRedemption(memberRewardPointRedemption,options);
	}
	public MemberRewardPointRedemption clone(String memberRewardPointRedemptionId, Map<String,Object> options) throws Exception{
	
		return clone(MemberRewardPointRedemptionTable.withId(memberRewardPointRedemptionId),options);
	}
	
	protected MemberRewardPointRedemption clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String memberRewardPointRedemptionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		MemberRewardPointRedemption newMemberRewardPointRedemption = loadInternalMemberRewardPointRedemption(accessKey, options);
		newMemberRewardPointRedemption.setVersion(0);
		
		

		
		saveInternalMemberRewardPointRedemption(newMemberRewardPointRedemption,options);
		
		return newMemberRewardPointRedemption;
	}
	
	
	
	

	protected void throwIfHasException(String memberRewardPointRedemptionId,int version,int count) throws Exception{
		if (count == 1) {
			throw new MemberRewardPointRedemptionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MemberRewardPointRedemptionNotFoundException(
					"The " + this.getTableName() + "(" + memberRewardPointRedemptionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String memberRewardPointRedemptionId, int version) throws Exception{
	
		String methodName="delete(String memberRewardPointRedemptionId, int version)";
		assertMethodArgumentNotNull(memberRewardPointRedemptionId, methodName, "memberRewardPointRedemptionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{memberRewardPointRedemptionId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(memberRewardPointRedemptionId,version);
		}
		
	
	}
	
	
	
	
	

	public MemberRewardPointRedemption disconnectFromAll(String memberRewardPointRedemptionId, int version) throws Exception{
	
		
		MemberRewardPointRedemption memberRewardPointRedemption = loadInternalMemberRewardPointRedemption(MemberRewardPointRedemptionTable.withId(memberRewardPointRedemptionId), emptyOptions());
		memberRewardPointRedemption.clearFromAll();
		this.saveMemberRewardPointRedemption(memberRewardPointRedemption);
		return memberRewardPointRedemption;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return MemberRewardPointRedemptionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "member_reward_point_redemption";
	}
	@Override
	protected String getBeanName() {
		
		return "memberRewardPointRedemption";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return MemberRewardPointRedemptionTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MemberRewardPointRedemptionTokens.OWNER);
 	}

 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MemberRewardPointRedemptionTokens.OWNER);
 	}
 	

 	
 
		

	

	protected MemberRewardPointRedemptionMapper getMemberRewardPointRedemptionMapper(){
		return new MemberRewardPointRedemptionMapper();
	}

	
	
	protected MemberRewardPointRedemption extractMemberRewardPointRedemption(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			MemberRewardPointRedemption memberRewardPointRedemption = loadSingleObject(accessKey, getMemberRewardPointRedemptionMapper());
			return memberRewardPointRedemption;
		}catch(EmptyResultDataAccessException e){
			throw new MemberRewardPointRedemptionNotFoundException("MemberRewardPointRedemption("+accessKey+") is not found!");
		}

	}

	
	

	protected MemberRewardPointRedemption loadInternalMemberRewardPointRedemption(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		MemberRewardPointRedemption memberRewardPointRedemption = extractMemberRewardPointRedemption(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(memberRewardPointRedemption, loadOptions);
 		}
 
		
		return memberRewardPointRedemption;
		
	}

	 

 	protected MemberRewardPointRedemption extractOwner(MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object> options) throws Exception{

		if(memberRewardPointRedemption.getOwner() == null){
			return memberRewardPointRedemption;
		}
		String ownerId = memberRewardPointRedemption.getOwner().getId();
		if( ownerId == null){
			return memberRewardPointRedemption;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			memberRewardPointRedemption.setOwner(owner);
		}
		
 		
 		return memberRewardPointRedemption;
 	}
 		
 
		
		
  	
 	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
  		SmartList<MemberRewardPointRedemption> resultList = queryWith(MemberRewardPointRedemptionTable.COLUMN_OWNER, retailStoreMemberId, options, getMemberRewardPointRedemptionMapper());
		// analyzeMemberRewardPointRedemptionByOwner(resultList, retailStoreMemberId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 		
 		SmartList<MemberRewardPointRedemption> resultList =  queryWithRange(MemberRewardPointRedemptionTable.COLUMN_OWNER, retailStoreMemberId, options, getMemberRewardPointRedemptionMapper(), start, count);
 		//analyzeMemberRewardPointRedemptionByOwner(resultList, retailStoreMemberId, options);
 		return resultList;
 		
 	}
 	public void analyzeMemberRewardPointRedemptionByOwner(SmartList<MemberRewardPointRedemption> resultList, String retailStoreMemberId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countMemberRewardPointRedemptionByOwner(String retailStoreMemberId,Map<String,Object> options){

 		return countWith(MemberRewardPointRedemptionTable.COLUMN_OWNER, retailStoreMemberId, options);
 	}
 	@Override
	public Map<String, Integer> countMemberRewardPointRedemptionByOwnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(MemberRewardPointRedemptionTable.COLUMN_OWNER, ids, options);
	}
 	
 	
		
		
		

	

	protected MemberRewardPointRedemption saveMemberRewardPointRedemption(MemberRewardPointRedemption  memberRewardPointRedemption){
		
		if(!memberRewardPointRedemption.isChanged()){
			return memberRewardPointRedemption;
		}
		
		
		String SQL=this.getSaveMemberRewardPointRedemptionSQL(memberRewardPointRedemption);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMemberRewardPointRedemptionParameters(memberRewardPointRedemption);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		memberRewardPointRedemption.incVersion();
		return memberRewardPointRedemption;
	
	}
	public SmartList<MemberRewardPointRedemption> saveMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMemberRewardPointRedemptionList(memberRewardPointRedemptionList);
		
		batchMemberRewardPointRedemptionCreate((List<MemberRewardPointRedemption>)lists[CREATE_LIST_INDEX]);
		
		batchMemberRewardPointRedemptionUpdate((List<MemberRewardPointRedemption>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList){
			if(memberRewardPointRedemption.isChanged()){
				memberRewardPointRedemption.incVersion();
			}
			
		
		}
		
		
		return memberRewardPointRedemptionList;
	}

	public SmartList<MemberRewardPointRedemption> removeMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options){
		
		
		super.removeList(memberRewardPointRedemptionList, options);
		
		return memberRewardPointRedemptionList;
		
		
	}
	
	protected List<Object[]> prepareMemberRewardPointRedemptionBatchCreateArgs(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList ){
			Object [] parameters = prepareMemberRewardPointRedemptionCreateParameters(memberRewardPointRedemption);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareMemberRewardPointRedemptionBatchUpdateArgs(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList ){
			if(!memberRewardPointRedemption.isChanged()){
				continue;
			}
			Object [] parameters = prepareMemberRewardPointRedemptionUpdateParameters(memberRewardPointRedemption);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchMemberRewardPointRedemptionCreate(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMemberRewardPointRedemptionBatchCreateArgs(memberRewardPointRedemptionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchMemberRewardPointRedemptionUpdate(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMemberRewardPointRedemptionBatchUpdateArgs(memberRewardPointRedemptionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitMemberRewardPointRedemptionList(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		
		List<MemberRewardPointRedemption> memberRewardPointRedemptionCreateList=new ArrayList<MemberRewardPointRedemption>();
		List<MemberRewardPointRedemption> memberRewardPointRedemptionUpdateList=new ArrayList<MemberRewardPointRedemption>();
		
		for(MemberRewardPointRedemption memberRewardPointRedemption: memberRewardPointRedemptionList){
			if(isUpdateRequest(memberRewardPointRedemption)){
				memberRewardPointRedemptionUpdateList.add( memberRewardPointRedemption);
				continue;
			}
			memberRewardPointRedemptionCreateList.add(memberRewardPointRedemption);
		}
		
		return new Object[]{memberRewardPointRedemptionCreateList,memberRewardPointRedemptionUpdateList};
	}
	
	protected boolean isUpdateRequest(MemberRewardPointRedemption memberRewardPointRedemption){
 		return memberRewardPointRedemption.getVersion() > 0;
 	}
 	protected String getSaveMemberRewardPointRedemptionSQL(MemberRewardPointRedemption memberRewardPointRedemption){
 		if(isUpdateRequest(memberRewardPointRedemption)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveMemberRewardPointRedemptionParameters(MemberRewardPointRedemption memberRewardPointRedemption){
 		if(isUpdateRequest(memberRewardPointRedemption) ){
 			return prepareMemberRewardPointRedemptionUpdateParameters(memberRewardPointRedemption);
 		}
 		return prepareMemberRewardPointRedemptionCreateParameters(memberRewardPointRedemption);
 	}
 	protected Object[] prepareMemberRewardPointRedemptionUpdateParameters(MemberRewardPointRedemption memberRewardPointRedemption){
 		Object[] parameters = new Object[6];
 
 		
 		parameters[0] = memberRewardPointRedemption.getName();
 		
 		
 		parameters[1] = memberRewardPointRedemption.getPoint();
 		 	
 		if(memberRewardPointRedemption.getOwner() != null){
 			parameters[2] = memberRewardPointRedemption.getOwner().getId();
 		}
 		
 		parameters[3] = memberRewardPointRedemption.nextVersion();
 		parameters[4] = memberRewardPointRedemption.getId();
 		parameters[5] = memberRewardPointRedemption.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareMemberRewardPointRedemptionCreateParameters(MemberRewardPointRedemption memberRewardPointRedemption){
		Object[] parameters = new Object[4];
		String newMemberRewardPointRedemptionId=getNextId();
		memberRewardPointRedemption.setId(newMemberRewardPointRedemptionId);
		parameters[0] =  memberRewardPointRedemption.getId();
 
 		
 		parameters[1] = memberRewardPointRedemption.getName();
 		
 		
 		parameters[2] = memberRewardPointRedemption.getPoint();
 		 	
 		if(memberRewardPointRedemption.getOwner() != null){
 			parameters[3] = memberRewardPointRedemption.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected MemberRewardPointRedemption saveInternalMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object> options){
		
		saveMemberRewardPointRedemption(memberRewardPointRedemption);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(memberRewardPointRedemption, options);
 		}
 
		
		return memberRewardPointRedemption;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected MemberRewardPointRedemption saveOwner(MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(memberRewardPointRedemption.getOwner() == null){
 			return memberRewardPointRedemption;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(memberRewardPointRedemption.getOwner(),options);
 		return memberRewardPointRedemption;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public MemberRewardPointRedemption present(MemberRewardPointRedemption memberRewardPointRedemption,Map<String, Object> options){
	

		return memberRewardPointRedemption;
	
	}
		

	

	protected String getTableName(){
		return MemberRewardPointRedemptionTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<MemberRewardPointRedemption> memberRewardPointRedemptionList) {		
		this.enhanceListInternal(memberRewardPointRedemptionList, this.getMemberRewardPointRedemptionMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<MemberRewardPointRedemption> memberRewardPointRedemptionList = ownerEntity.collectRefsWithType(MemberRewardPointRedemption.INTERNAL_TYPE);
		this.enhanceList(memberRewardPointRedemptionList);
		
	}
	
	@Override
	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getMemberRewardPointRedemptionMapper());

	}
	@Override
	public int countMemberRewardPointRedemptionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countMemberRewardPointRedemptionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<MemberRewardPointRedemption> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getMemberRewardPointRedemptionMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateMemberRewardPointRedemption executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateMemberRewardPointRedemption result = new CandidateMemberRewardPointRedemption();
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


