
package com.doublechaintech.retailscm.leavetype;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;

import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class LeaveTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements LeaveTypeDAO{

	protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;
	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){

 		if(retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
 		}
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
 		if(this.retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCountryCenterDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreCountryCenterDAO;
 	}

	protected EmployeeLeaveDAO employeeLeaveDAO;
	public void setEmployeeLeaveDAO(EmployeeLeaveDAO employeeLeaveDAO){

 		if(employeeLeaveDAO == null){
 			throw new IllegalStateException("Do not try to set employeeLeaveDAO to null.");
 		}
	 	this.employeeLeaveDAO = employeeLeaveDAO;
 	}
 	public EmployeeLeaveDAO getEmployeeLeaveDAO(){
 		if(this.employeeLeaveDAO == null){
 			throw new IllegalStateException("The employeeLeaveDAO is not configured yet, please config it some where.");
 		}

	 	return this.employeeLeaveDAO;
 	}



	/*
	protected LeaveType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLeaveType(accessKey, options);
	}
	*/

	public SmartList<LeaveType> loadAll() {
	    return this.loadAll(getLeaveTypeMapper());
	}

  public Stream<LeaveType> loadAllAsStream() {
      return this.loadAllAsStream(getLeaveTypeMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public LeaveType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLeaveType(LeaveTypeTable.withId(id), options);
	}

	

	public LeaveType save(LeaveType leaveType,Map<String,Object> options){

		String methodName="save(LeaveType leaveType,Map<String,Object> options)";

		assertMethodArgumentNotNull(leaveType, methodName, "leaveType");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalLeaveType(leaveType,options);
	}
	public LeaveType clone(String leaveTypeId, Map<String,Object> options) throws Exception{

		return clone(LeaveTypeTable.withId(leaveTypeId),options);
	}

	protected LeaveType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String leaveTypeId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		LeaveType newLeaveType = loadInternalLeaveType(accessKey, options);
		newLeaveType.setVersion(0);
		
		

 		if(isSaveEmployeeLeaveListEnabled(options)){
 			for(EmployeeLeave item: newLeaveType.getEmployeeLeaveList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalLeaveType(newLeaveType,options);

		return newLeaveType;
	}

	



	protected void throwIfHasException(String leaveTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LeaveTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LeaveTypeNotFoundException(
					"The " + this.getTableName() + "(" + leaveTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String leaveTypeId, int version) throws Exception{

		String methodName="delete(String leaveTypeId, int version)";
		assertMethodArgumentNotNull(leaveTypeId, methodName, "leaveTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{leaveTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(leaveTypeId,version);
		}


	}






	public LeaveType disconnectFromAll(String leaveTypeId, int version) throws Exception{


		LeaveType leaveType = loadInternalLeaveType(LeaveTypeTable.withId(leaveTypeId), emptyOptions());
		leaveType.clearFromAll();
		this.saveLeaveType(leaveType);
		return leaveType;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return LeaveTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "leave_type";
	}
	@Override
	protected String getBeanName() {

		return "leaveType";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return LeaveTypeTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){

	 	return checkOptions(options, LeaveTypeTokens.COMPANY);
 	}

 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){

 		return checkOptions(options, LeaveTypeTokens.COMPANY);
 	}



 
		

	protected boolean isExtractEmployeeLeaveListEnabled(Map<String,Object> options){
 		return checkOptions(options,LeaveTypeTokens.EMPLOYEE_LEAVE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeLeaveListEnabled(Map<String,Object> options){
 		return LeaveTypeTokens.of(options).analyzeEmployeeLeaveListEnabled();
 	}

	protected boolean isSaveEmployeeLeaveListEnabled(Map<String,Object> options){
		return checkOptions(options, LeaveTypeTokens.EMPLOYEE_LEAVE_LIST);

 	}

		

	

	protected LeaveTypeMapper getLeaveTypeMapper(){
		return new LeaveTypeMapper();
	}



	protected LeaveType extractLeaveType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LeaveType leaveType = loadSingleObject(accessKey, getLeaveTypeMapper());
			return leaveType;
		}catch(EmptyResultDataAccessException e){
			throw new LeaveTypeNotFoundException("LeaveType("+accessKey+") is not found!");
		}

	}




	protected LeaveType loadInternalLeaveType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		LeaveType leaveType = extractLeaveType(accessKey, loadOptions);

 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(leaveType, loadOptions);
 		}
 
		
		if(isExtractEmployeeLeaveListEnabled(loadOptions)){
	 		extractEmployeeLeaveList(leaveType, loadOptions);
 		}

 		
 		if(isAnalyzeEmployeeLeaveListEnabled(loadOptions)){
	 		analyzeEmployeeLeaveList(leaveType, loadOptions);
 		}
 		
		
		return leaveType;

	}

	

 	protected LeaveType extractCompany(LeaveType leaveType, Map<String,Object> options) throws Exception{
  

		if(leaveType.getCompany() == null){
			return leaveType;
		}
		String companyId = leaveType.getCompany().getId();
		if( companyId == null){
			return leaveType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			leaveType.setCompany(company);
		}


 		return leaveType;
 	}

 
		
	protected void enhanceEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected LeaveType extractEmployeeLeaveList(LeaveType leaveType, Map<String,Object> options){
    

		if(leaveType == null){
			return null;
		}
		if(leaveType.getId() == null){
			return leaveType;
		}



		SmartList<EmployeeLeave> employeeLeaveList = getEmployeeLeaveDAO().findEmployeeLeaveByType(leaveType.getId(),options);
		if(employeeLeaveList != null){
			enhanceEmployeeLeaveList(employeeLeaveList,options);
			leaveType.setEmployeeLeaveList(employeeLeaveList);
		}

		return leaveType;
  
	}

	protected LeaveType analyzeEmployeeLeaveList(LeaveType leaveType, Map<String,Object> options){
     
		if(leaveType == null){
			return null;
		}
		if(leaveType.getId() == null){
			return leaveType;
		}



		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
		if(employeeLeaveList != null){
			getEmployeeLeaveDAO().analyzeEmployeeLeaveByType(employeeLeaveList, leaveType.getId(), options);

		}

		return leaveType;
    
	}

		

 
 	public SmartList<LeaveType> findLeaveTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

  		SmartList<LeaveType> resultList = queryWith(LeaveTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getLeaveTypeMapper());
		// analyzeLeaveTypeByCompany(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	

 	public SmartList<LeaveType> findLeaveTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){

 		SmartList<LeaveType> resultList =  queryWithRange(LeaveTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getLeaveTypeMapper(), start, count);
 		//analyzeLeaveTypeByCompany(resultList, retailStoreCountryCenterId, options);
 		return resultList;

 	}
 	public void analyzeLeaveTypeByCompany(SmartList<LeaveType> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countLeaveTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(LeaveTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countLeaveTypeByCompanyIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LeaveTypeTable.COLUMN_COMPANY, ids, options);
	}

 




	

	protected LeaveType saveLeaveType(LeaveType  leaveType){
    

		
		if(!leaveType.isChanged()){
			return leaveType;
		}
		

    Beans.dbUtil().cacheCleanUp(leaveType);
		String SQL=this.getSaveLeaveTypeSQL(leaveType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLeaveTypeParameters(leaveType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		leaveType.incVersion();
		leaveType.afterSave();
		return leaveType;

	}
	public SmartList<LeaveType> saveLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLeaveTypeList(leaveTypeList);

		batchLeaveTypeCreate((List<LeaveType>)lists[CREATE_LIST_INDEX]);

		batchLeaveTypeUpdate((List<LeaveType>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(LeaveType leaveType:leaveTypeList){
			if(leaveType.isChanged()){
				leaveType.incVersion();
				leaveType.afterSave();
			}


		}


		return leaveTypeList;
	}

	public SmartList<LeaveType> removeLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options){


		super.removeList(leaveTypeList, options);

		return leaveTypeList;


	}

	protected List<Object[]> prepareLeaveTypeBatchCreateArgs(List<LeaveType> leaveTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LeaveType leaveType:leaveTypeList ){
			Object [] parameters = prepareLeaveTypeCreateParameters(leaveType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareLeaveTypeBatchUpdateArgs(List<LeaveType> leaveTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LeaveType leaveType:leaveTypeList ){
			if(!leaveType.isChanged()){
				continue;
			}
			Object [] parameters = prepareLeaveTypeUpdateParameters(leaveType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchLeaveTypeCreate(List<LeaveType> leaveTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLeaveTypeBatchCreateArgs(leaveTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchLeaveTypeUpdate(List<LeaveType> leaveTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLeaveTypeBatchUpdateArgs(leaveTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitLeaveTypeList(List<LeaveType> leaveTypeList){

		List<LeaveType> leaveTypeCreateList=new ArrayList<LeaveType>();
		List<LeaveType> leaveTypeUpdateList=new ArrayList<LeaveType>();

		for(LeaveType leaveType: leaveTypeList){
			if(isUpdateRequest(leaveType)){
				leaveTypeUpdateList.add( leaveType);
				continue;
			}
			leaveTypeCreateList.add(leaveType);
		}

		return new Object[]{leaveTypeCreateList,leaveTypeUpdateList};
	}

	protected boolean isUpdateRequest(LeaveType leaveType){
 		return leaveType.getVersion() > 0;
 	}
 	protected String getSaveLeaveTypeSQL(LeaveType leaveType){
 		if(isUpdateRequest(leaveType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveLeaveTypeParameters(LeaveType leaveType){
 		if(isUpdateRequest(leaveType) ){
 			return prepareLeaveTypeUpdateParameters(leaveType);
 		}
 		return prepareLeaveTypeCreateParameters(leaveType);
 	}
 	protected Object[] prepareLeaveTypeUpdateParameters(LeaveType leaveType){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = leaveType.getCode();
 		
 		if(leaveType.getCompany() != null){
 			parameters[1] = leaveType.getCompany().getId();
 		}
    
 		parameters[2] = leaveType.getDescription();
 		
 		parameters[3] = leaveType.getDetailDescription();
 		
 		parameters[4] = leaveType.nextVersion();
 		parameters[5] = leaveType.getId();
 		parameters[6] = leaveType.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareLeaveTypeCreateParameters(LeaveType leaveType){
		Object[] parameters = new Object[5];
        if(leaveType.getId() == null){
          String newLeaveTypeId=getNextId();
          leaveType.setId(newLeaveTypeId);
        }
		parameters[0] =  leaveType.getId();
 
 		parameters[1] = leaveType.getCode();
 		
 		if(leaveType.getCompany() != null){
 			parameters[2] = leaveType.getCompany().getId();
 		}
 		
 		parameters[3] = leaveType.getDescription();
 		
 		parameters[4] = leaveType.getDetailDescription();
 		

 		return parameters;
 	}

	protected LeaveType saveInternalLeaveType(LeaveType leaveType, Map<String,Object> options){

 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(leaveType, options);
 		}
 
   saveLeaveType(leaveType);
		
		if(isSaveEmployeeLeaveListEnabled(options)){
	 		saveEmployeeLeaveList(leaveType, options);
	 		//removeEmployeeLeaveList(leaveType, options);
	 		//Not delete the record

 		}
		
		return leaveType;

	}



	//======================================================================================
	

 	protected LeaveType saveCompany(LeaveType leaveType, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(leaveType.getCompany() == null){
 			return leaveType;//do nothing when it is null
 		}

 		getRetailStoreCountryCenterDAO().save(leaveType.getCompany(),options);
 		return leaveType;

 	}
 

	
	public LeaveType planToRemoveEmployeeLeaveList(LeaveType leaveType, String employeeLeaveIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeLeave.TYPE_PROPERTY, leaveType.getId());
		key.put(EmployeeLeave.ID_PROPERTY, employeeLeaveIds);

		SmartList<EmployeeLeave> externalEmployeeLeaveList = getEmployeeLeaveDAO().
				findEmployeeLeaveWithKey(key, options);
		if(externalEmployeeLeaveList == null){
			return leaveType;
		}
		if(externalEmployeeLeaveList.isEmpty()){
			return leaveType;
		}

		for(EmployeeLeave employeeLeaveItem: externalEmployeeLeaveList){

			employeeLeaveItem.clearFromAll();
		}


		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
		employeeLeaveList.addAllToRemoveList(externalEmployeeLeaveList);
		return leaveType;

	}


	//disconnect LeaveType with who in EmployeeLeave
	public LeaveType planToRemoveEmployeeLeaveListWithWho(LeaveType leaveType, String whoId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeLeave.TYPE_PROPERTY, leaveType.getId());
		key.put(EmployeeLeave.WHO_PROPERTY, whoId);

		SmartList<EmployeeLeave> externalEmployeeLeaveList = getEmployeeLeaveDAO().
				findEmployeeLeaveWithKey(key, options);
		if(externalEmployeeLeaveList == null){
			return leaveType;
		}
		if(externalEmployeeLeaveList.isEmpty()){
			return leaveType;
		}

		for(EmployeeLeave employeeLeaveItem: externalEmployeeLeaveList){
			employeeLeaveItem.clearWho();
			employeeLeaveItem.clearType();

		}


		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
		employeeLeaveList.addAllToRemoveList(externalEmployeeLeaveList);
		return leaveType;
	}

	public int countEmployeeLeaveListWithWho(String leaveTypeId, String whoId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeLeave.TYPE_PROPERTY, leaveTypeId);
		key.put(EmployeeLeave.WHO_PROPERTY, whoId);

		int count = getEmployeeLeaveDAO().countEmployeeLeaveWithKey(key, options);
		return count;
	}
	

		
	protected LeaveType saveEmployeeLeaveList(LeaveType leaveType, Map<String,Object> options){
    



		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
		if(employeeLeaveList == null){
			//null list means nothing
			return leaveType;
		}
		SmartList<EmployeeLeave> mergedUpdateEmployeeLeaveList = new SmartList<EmployeeLeave>();


		mergedUpdateEmployeeLeaveList.addAll(employeeLeaveList);
		if(employeeLeaveList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEmployeeLeaveList.addAll(employeeLeaveList.getToRemoveList());
			employeeLeaveList.removeAll(employeeLeaveList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getEmployeeLeaveDAO().saveEmployeeLeaveList(mergedUpdateEmployeeLeaveList,options);

		if(employeeLeaveList.getToRemoveList() != null){
			employeeLeaveList.removeAll(employeeLeaveList.getToRemoveList());
		}


		return leaveType;

	}

	protected LeaveType removeEmployeeLeaveList(LeaveType leaveType, Map<String,Object> options){


		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
		if(employeeLeaveList == null){
			return leaveType;
		}

		SmartList<EmployeeLeave> toRemoveEmployeeLeaveList = employeeLeaveList.getToRemoveList();

		if(toRemoveEmployeeLeaveList == null){
			return leaveType;
		}
		if(toRemoveEmployeeLeaveList.isEmpty()){
			return leaveType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getEmployeeLeaveDAO().removeEmployeeLeaveList(toRemoveEmployeeLeaveList,options);

		return leaveType;

	}








		

	public LeaveType present(LeaveType leaveType,Map<String, Object> options){

		presentEmployeeLeaveList(leaveType,options);

		return leaveType;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected LeaveType presentEmployeeLeaveList(
			LeaveType leaveType,
			Map<String, Object> options) {
    
		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
				SmartList<EmployeeLeave> newList= presentSubList(leaveType.getId(),
				employeeLeaveList,
				options,
				getEmployeeLeaveDAO()::countEmployeeLeaveByType,
				getEmployeeLeaveDAO()::findEmployeeLeaveByType
				);


		leaveType.setEmployeeLeaveList(newList);


		return leaveType;
	}
		

	
    public SmartList<LeaveType> requestCandidateLeaveTypeForEmployeeLeave(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LeaveTypeTable.COLUMN_CODE, LeaveTypeTable.COLUMN_COMPANY, filterKey, pageNo, pageSize, getLeaveTypeMapper());
    }
		

	protected String getTableName(){
		return LeaveTypeTable.TABLE_NAME;
	}



	public void enhanceList(List<LeaveType> leaveTypeList) {
		this.enhanceListInternal(leaveTypeList, this.getLeaveTypeMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:EmployeeLeave的type的EmployeeLeaveList
	public SmartList<EmployeeLeave> loadOurEmployeeLeaveList(RetailscmUserContext userContext, List<LeaveType> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeLeave.TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<EmployeeLeave> loadedObjs = userContext.getDAOGroup().getEmployeeLeaveDAO().findEmployeeLeaveWithKey(key, options);
		Map<String, List<EmployeeLeave>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getType().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<EmployeeLeave> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<EmployeeLeave> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setEmployeeLeaveList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LeaveType> leaveTypeList = ownerEntity.collectRefsWithType(LeaveType.INTERNAL_TYPE);
		this.enhanceList(leaveTypeList);

	}

	@Override
	public SmartList<LeaveType> findLeaveTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getLeaveTypeMapper());

	}
	@Override
	public int countLeaveTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countLeaveTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<LeaveType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLeaveTypeMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<LeaveType> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getLeaveTypeMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateLeaveType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateLeaveType result = new CandidateLeaveType();
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
  public List<LeaveType> search(LeaveTypeRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected LeaveTypeMapper mapper() {
    return getLeaveTypeMapper();
  }
}


