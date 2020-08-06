
package com.doublechaintech.retailscm.retailstoremembercoupon;

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
import java.util.stream.Stream;

public class RetailStoreMemberCouponJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreMemberCouponDAO{

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
	protected RetailStoreMemberCoupon load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberCoupon(accessKey, options);
	}
	*/

	public SmartList<RetailStoreMemberCoupon> loadAll() {
	    return this.loadAll(getRetailStoreMemberCouponMapper());
	}

  public Stream<RetailStoreMemberCoupon> loadAllAsStream() {
      return this.loadAllAsStream(getRetailStoreMemberCouponMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public RetailStoreMemberCoupon load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberCoupon(RetailStoreMemberCouponTable.withId(id), options);
	}

	

	public RetailStoreMemberCoupon save(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object> options){

		String methodName="save(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object> options)";

		assertMethodArgumentNotNull(retailStoreMemberCoupon, methodName, "retailStoreMemberCoupon");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalRetailStoreMemberCoupon(retailStoreMemberCoupon,options);
	}
	public RetailStoreMemberCoupon clone(String retailStoreMemberCouponId, Map<String,Object> options) throws Exception{

		return clone(RetailStoreMemberCouponTable.withId(retailStoreMemberCouponId),options);
	}

	protected RetailStoreMemberCoupon clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String retailStoreMemberCouponId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		RetailStoreMemberCoupon newRetailStoreMemberCoupon = loadInternalRetailStoreMemberCoupon(accessKey, options);
		newRetailStoreMemberCoupon.setVersion(0);
		
		


		saveInternalRetailStoreMemberCoupon(newRetailStoreMemberCoupon,options);

		return newRetailStoreMemberCoupon;
	}

	



	protected void throwIfHasException(String retailStoreMemberCouponId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreMemberCouponVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreMemberCouponNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreMemberCouponId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String retailStoreMemberCouponId, int version) throws Exception{

		String methodName="delete(String retailStoreMemberCouponId, int version)";
		assertMethodArgumentNotNull(retailStoreMemberCouponId, methodName, "retailStoreMemberCouponId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreMemberCouponId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreMemberCouponId,version);
		}


	}






	public RetailStoreMemberCoupon disconnectFromAll(String retailStoreMemberCouponId, int version) throws Exception{


		RetailStoreMemberCoupon retailStoreMemberCoupon = loadInternalRetailStoreMemberCoupon(RetailStoreMemberCouponTable.withId(retailStoreMemberCouponId), emptyOptions());
		retailStoreMemberCoupon.clearFromAll();
		this.saveRetailStoreMemberCoupon(retailStoreMemberCoupon);
		return retailStoreMemberCoupon;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreMemberCouponTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "retail_store_member_coupon";
	}
	@Override
	protected String getBeanName() {

		return "retailStoreMemberCoupon";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreMemberCouponTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreMemberCouponTokens.OWNER);
 	}

 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreMemberCouponTokens.OWNER);
 	}
 	

 	
 
		

	

	protected RetailStoreMemberCouponMapper getRetailStoreMemberCouponMapper(){
		return new RetailStoreMemberCouponMapper();
	}

	
	
	protected RetailStoreMemberCoupon extractRetailStoreMemberCoupon(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreMemberCoupon retailStoreMemberCoupon = loadSingleObject(accessKey, getRetailStoreMemberCouponMapper());
			return retailStoreMemberCoupon;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberCouponNotFoundException("RetailStoreMemberCoupon("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreMemberCoupon loadInternalRetailStoreMemberCoupon(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = extractRetailStoreMemberCoupon(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(retailStoreMemberCoupon, loadOptions);
 		}
 
		
		return retailStoreMemberCoupon;
		
	}

	 

 	protected RetailStoreMemberCoupon extractOwner(RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object> options) throws Exception{

		if(retailStoreMemberCoupon.getOwner() == null){
			return retailStoreMemberCoupon;
		}
		String ownerId = retailStoreMemberCoupon.getOwner().getId();
		if( ownerId == null){
			return retailStoreMemberCoupon;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			retailStoreMemberCoupon.setOwner(owner);
		}
		
 		
 		return retailStoreMemberCoupon;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
  		SmartList<RetailStoreMemberCoupon> resultList = queryWith(RetailStoreMemberCouponTable.COLUMN_OWNER, retailStoreMemberId, options, getRetailStoreMemberCouponMapper());
		// analyzeRetailStoreMemberCouponByOwner(resultList, retailStoreMemberId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreMemberCoupon> resultList =  queryWithRange(RetailStoreMemberCouponTable.COLUMN_OWNER, retailStoreMemberId, options, getRetailStoreMemberCouponMapper(), start, count);
 		//analyzeRetailStoreMemberCouponByOwner(resultList, retailStoreMemberId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreMemberCouponByOwner(SmartList<RetailStoreMemberCoupon> resultList, String retailStoreMemberId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreMemberCoupon.OWNER_PROPERTY, retailStoreMemberId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("生超会员优惠券");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreMemberCouponByOwner(String retailStoreMemberId,Map<String,Object> options){

 		return countWith(RetailStoreMemberCouponTable.COLUMN_OWNER, retailStoreMemberId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreMemberCouponByOwnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreMemberCouponTable.COLUMN_OWNER, ids, options);
	}
 	
 	
		
		
		

	

	protected RetailStoreMemberCoupon saveRetailStoreMemberCoupon(RetailStoreMemberCoupon  retailStoreMemberCoupon){
		
		if(!retailStoreMemberCoupon.isChanged()){
			return retailStoreMemberCoupon;
		}
		

		String SQL=this.getSaveRetailStoreMemberCouponSQL(retailStoreMemberCoupon);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreMemberCouponParameters(retailStoreMemberCoupon);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		retailStoreMemberCoupon.incVersion();
		return retailStoreMemberCoupon;

	}
	public SmartList<RetailStoreMemberCoupon> saveRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreMemberCouponList(retailStoreMemberCouponList);

		batchRetailStoreMemberCouponCreate((List<RetailStoreMemberCoupon>)lists[CREATE_LIST_INDEX]);

		batchRetailStoreMemberCouponUpdate((List<RetailStoreMemberCoupon>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList){
			if(retailStoreMemberCoupon.isChanged()){
				retailStoreMemberCoupon.incVersion();
			}


		}


		return retailStoreMemberCouponList;
	}

	public SmartList<RetailStoreMemberCoupon> removeRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options){


		super.removeList(retailStoreMemberCouponList, options);

		return retailStoreMemberCouponList;


	}

	protected List<Object[]> prepareRetailStoreMemberCouponBatchCreateArgs(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList ){
			Object [] parameters = prepareRetailStoreMemberCouponCreateParameters(retailStoreMemberCoupon);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareRetailStoreMemberCouponBatchUpdateArgs(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList ){
			if(!retailStoreMemberCoupon.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreMemberCouponUpdateParameters(retailStoreMemberCoupon);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchRetailStoreMemberCouponCreate(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreMemberCouponBatchCreateArgs(retailStoreMemberCouponList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchRetailStoreMemberCouponUpdate(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreMemberCouponBatchUpdateArgs(retailStoreMemberCouponList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitRetailStoreMemberCouponList(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){

		List<RetailStoreMemberCoupon> retailStoreMemberCouponCreateList=new ArrayList<RetailStoreMemberCoupon>();
		List<RetailStoreMemberCoupon> retailStoreMemberCouponUpdateList=new ArrayList<RetailStoreMemberCoupon>();

		for(RetailStoreMemberCoupon retailStoreMemberCoupon: retailStoreMemberCouponList){
			if(isUpdateRequest(retailStoreMemberCoupon)){
				retailStoreMemberCouponUpdateList.add( retailStoreMemberCoupon);
				continue;
			}
			retailStoreMemberCouponCreateList.add(retailStoreMemberCoupon);
		}

		return new Object[]{retailStoreMemberCouponCreateList,retailStoreMemberCouponUpdateList};
	}

	protected boolean isUpdateRequest(RetailStoreMemberCoupon retailStoreMemberCoupon){
 		return retailStoreMemberCoupon.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreMemberCouponSQL(RetailStoreMemberCoupon retailStoreMemberCoupon){
 		if(isUpdateRequest(retailStoreMemberCoupon)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveRetailStoreMemberCouponParameters(RetailStoreMemberCoupon retailStoreMemberCoupon){
 		if(isUpdateRequest(retailStoreMemberCoupon) ){
 			return prepareRetailStoreMemberCouponUpdateParameters(retailStoreMemberCoupon);
 		}
 		return prepareRetailStoreMemberCouponCreateParameters(retailStoreMemberCoupon);
 	}
 	protected Object[] prepareRetailStoreMemberCouponUpdateParameters(RetailStoreMemberCoupon retailStoreMemberCoupon){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = retailStoreMemberCoupon.getName();
 		
 		if(retailStoreMemberCoupon.getOwner() != null){
 			parameters[1] = retailStoreMemberCoupon.getOwner().getId();
 		}
 
 		
 		parameters[2] = retailStoreMemberCoupon.getNumber();
 		
 		
 		parameters[3] = retailStoreMemberCoupon.getLastUpdateTime();
 		
 		parameters[4] = retailStoreMemberCoupon.nextVersion();
 		parameters[5] = retailStoreMemberCoupon.getId();
 		parameters[6] = retailStoreMemberCoupon.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareRetailStoreMemberCouponCreateParameters(RetailStoreMemberCoupon retailStoreMemberCoupon){
		Object[] parameters = new Object[5];
        if(retailStoreMemberCoupon.getId() == null){
          String newRetailStoreMemberCouponId=getNextId();
          retailStoreMemberCoupon.setId(newRetailStoreMemberCouponId);
        }
		parameters[0] =  retailStoreMemberCoupon.getId();
 
 		
 		parameters[1] = retailStoreMemberCoupon.getName();
 		
 		if(retailStoreMemberCoupon.getOwner() != null){
 			parameters[2] = retailStoreMemberCoupon.getOwner().getId();

 		}
 		
 		
 		parameters[3] = retailStoreMemberCoupon.getNumber();
 		
 		
 		parameters[4] = retailStoreMemberCoupon.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected RetailStoreMemberCoupon saveInternalRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object> options){

		saveRetailStoreMemberCoupon(retailStoreMemberCoupon);

 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(retailStoreMemberCoupon, options);
 		}
 
		
		return retailStoreMemberCoupon;

	}



	//======================================================================================
	

 	protected RetailStoreMemberCoupon saveOwner(RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreMemberCoupon.getOwner() == null){
 			return retailStoreMemberCoupon;//do nothing when it is null
 		}

 		getRetailStoreMemberDAO().save(retailStoreMemberCoupon.getOwner(),options);
 		return retailStoreMemberCoupon;

 	}





 

	

		

	public RetailStoreMemberCoupon present(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String, Object> options){
	

		return retailStoreMemberCoupon;
	
	}
		

	

	protected String getTableName(){
		return RetailStoreMemberCouponTable.TABLE_NAME;
	}



	public void enhanceList(List<RetailStoreMemberCoupon> retailStoreMemberCouponList) {
		this.enhanceListInternal(retailStoreMemberCouponList, this.getRetailStoreMemberCouponMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreMemberCoupon> retailStoreMemberCouponList = ownerEntity.collectRefsWithType(RetailStoreMemberCoupon.INTERNAL_TYPE);
		this.enhanceList(retailStoreMemberCouponList);

	}

	@Override
	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getRetailStoreMemberCouponMapper());

	}
	@Override
	public int countRetailStoreMemberCouponWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreMemberCouponWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<RetailStoreMemberCoupon> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreMemberCouponMapper());
	}

  @Override
  public Stream<RetailStoreMemberCoupon> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreMemberCouponMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreMemberCoupon executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreMemberCoupon result = new CandidateRetailStoreMemberCoupon();
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


