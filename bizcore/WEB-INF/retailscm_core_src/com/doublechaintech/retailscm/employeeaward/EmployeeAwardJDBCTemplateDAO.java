
package com.doublechaintech.retailscm.employeeaward;

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


import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class EmployeeAwardJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeAwardDAO{

	protected EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO employeeDAO){
 	
 		if(employeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The employeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}	

	
	/*
	protected EmployeeAward load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeAward(accessKey, options);
	}
	*/
	
	public SmartList<EmployeeAward> loadAll() {
	    return this.loadAll(getEmployeeAwardMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public EmployeeAward load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeAward(EmployeeAwardTable.withId(id), options);
	}
	
	
	
	public EmployeeAward save(EmployeeAward employeeAward,Map<String,Object> options){
		
		String methodName="save(EmployeeAward employeeAward,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeAward, methodName, "employeeAward");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeAward(employeeAward,options);
	}
	public EmployeeAward clone(String employeeAwardId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeAwardTable.withId(employeeAwardId),options);
	}
	
	protected EmployeeAward clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeAwardId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeAward newEmployeeAward = loadInternalEmployeeAward(accessKey, options);
		newEmployeeAward.setVersion(0);
		
		

		
		saveInternalEmployeeAward(newEmployeeAward,options);
		
		return newEmployeeAward;
	}
	
	
	
	

	protected void throwIfHasException(String employeeAwardId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeAwardVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeAwardNotFoundException(
					"The " + this.getTableName() + "(" + employeeAwardId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String employeeAwardId, int version) throws Exception{
	
		String methodName="delete(String employeeAwardId, int version)";
		assertMethodArgumentNotNull(employeeAwardId, methodName, "employeeAwardId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeAwardId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeAwardId,version);
		}
		
	
	}
	
	
	
	
	

	public EmployeeAward disconnectFromAll(String employeeAwardId, int version) throws Exception{
	
		
		EmployeeAward employeeAward = loadInternalEmployeeAward(EmployeeAwardTable.withId(employeeAwardId), emptyOptions());
		employeeAward.clearFromAll();
		this.saveEmployeeAward(employeeAward);
		return employeeAward;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeAwardTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_award";
	}
	@Override
	protected String getBeanName() {
		
		return "employeeAward";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeAwardTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeAwardTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeAwardTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeeAwardMapper getEmployeeAwardMapper(){
		return new EmployeeAwardMapper();
	}

	
	
	protected EmployeeAward extractEmployeeAward(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeAward employeeAward = loadSingleObject(accessKey, getEmployeeAwardMapper());
			return employeeAward;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeAwardNotFoundException("EmployeeAward("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeeAward loadInternalEmployeeAward(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeAward employeeAward = extractEmployeeAward(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeAward, loadOptions);
 		}
 
		
		return employeeAward;
		
	}

	 

 	protected EmployeeAward extractEmployee(EmployeeAward employeeAward, Map<String,Object> options) throws Exception{

		if(employeeAward.getEmployee() == null){
			return employeeAward;
		}
		String employeeId = employeeAward.getEmployee().getId();
		if( employeeId == null){
			return employeeAward;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeAward.setEmployee(employee);
		}
		
 		
 		return employeeAward;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId,Map<String,Object> options){
 	
  		SmartList<EmployeeAward> resultList = queryWith(EmployeeAwardTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeAwardMapper());
		// analyzeEmployeeAwardByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeAward> resultList =  queryWithRange(EmployeeAwardTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeAwardMapper(), start, count);
 		//analyzeEmployeeAwardByEmployee(resultList, employeeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeAwardByEmployee(SmartList<EmployeeAward> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countEmployeeAwardByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeAwardTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeAwardByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeAwardTable.COLUMN_EMPLOYEE, ids, options);
	}
 	
 	
		
		
		

	

	protected EmployeeAward saveEmployeeAward(EmployeeAward  employeeAward){
		
		if(!employeeAward.isChanged()){
			return employeeAward;
		}
		
		
		String SQL=this.getSaveEmployeeAwardSQL(employeeAward);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeAwardParameters(employeeAward);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeAward.incVersion();
		return employeeAward;
	
	}
	public SmartList<EmployeeAward> saveEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeAwardList(employeeAwardList);
		
		batchEmployeeAwardCreate((List<EmployeeAward>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeAwardUpdate((List<EmployeeAward>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeAward employeeAward:employeeAwardList){
			if(employeeAward.isChanged()){
				employeeAward.incVersion();
			}
			
		
		}
		
		
		return employeeAwardList;
	}

	public SmartList<EmployeeAward> removeEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options){
		
		
		super.removeList(employeeAwardList, options);
		
		return employeeAwardList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeAwardBatchCreateArgs(List<EmployeeAward> employeeAwardList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeAward employeeAward:employeeAwardList ){
			Object [] parameters = prepareEmployeeAwardCreateParameters(employeeAward);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeAwardBatchUpdateArgs(List<EmployeeAward> employeeAwardList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeAward employeeAward:employeeAwardList ){
			if(!employeeAward.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeAwardUpdateParameters(employeeAward);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeAwardCreate(List<EmployeeAward> employeeAwardList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeAwardBatchCreateArgs(employeeAwardList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeAwardUpdate(List<EmployeeAward> employeeAwardList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeAwardBatchUpdateArgs(employeeAwardList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeAwardList(List<EmployeeAward> employeeAwardList){
		
		List<EmployeeAward> employeeAwardCreateList=new ArrayList<EmployeeAward>();
		List<EmployeeAward> employeeAwardUpdateList=new ArrayList<EmployeeAward>();
		
		for(EmployeeAward employeeAward: employeeAwardList){
			if(isUpdateRequest(employeeAward)){
				employeeAwardUpdateList.add( employeeAward);
				continue;
			}
			employeeAwardCreateList.add(employeeAward);
		}
		
		return new Object[]{employeeAwardCreateList,employeeAwardUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeAward employeeAward){
 		return employeeAward.getVersion() > 0;
 	}
 	protected String getSaveEmployeeAwardSQL(EmployeeAward employeeAward){
 		if(isUpdateRequest(employeeAward)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeAwardParameters(EmployeeAward employeeAward){
 		if(isUpdateRequest(employeeAward) ){
 			return prepareEmployeeAwardUpdateParameters(employeeAward);
 		}
 		return prepareEmployeeAwardCreateParameters(employeeAward);
 	}
 	protected Object[] prepareEmployeeAwardUpdateParameters(EmployeeAward employeeAward){
 		Object[] parameters = new Object[7];
  	
 		if(employeeAward.getEmployee() != null){
 			parameters[0] = employeeAward.getEmployee().getId();
 		}
 
 		
 		parameters[1] = employeeAward.getCompleteTime();
 		
 		
 		parameters[2] = employeeAward.getType();
 		
 		
 		parameters[3] = employeeAward.getRemark();
 				
 		parameters[4] = employeeAward.nextVersion();
 		parameters[5] = employeeAward.getId();
 		parameters[6] = employeeAward.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeAwardCreateParameters(EmployeeAward employeeAward){
		Object[] parameters = new Object[5];
		String newEmployeeAwardId=getNextId();
		employeeAward.setId(newEmployeeAwardId);
		parameters[0] =  employeeAward.getId();
  	
 		if(employeeAward.getEmployee() != null){
 			parameters[1] = employeeAward.getEmployee().getId();
 		
 		}
 		
 		
 		parameters[2] = employeeAward.getCompleteTime();
 		
 		
 		parameters[3] = employeeAward.getType();
 		
 		
 		parameters[4] = employeeAward.getRemark();
 				
 				
 		return parameters;
 	}
 	
	protected EmployeeAward saveInternalEmployeeAward(EmployeeAward employeeAward, Map<String,Object> options){
		
		saveEmployeeAward(employeeAward);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeAward, options);
 		}
 
		
		return employeeAward;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeAward saveEmployee(EmployeeAward employeeAward, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeAward.getEmployee() == null){
 			return employeeAward;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeAward.getEmployee(),options);
 		return employeeAward;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public EmployeeAward present(EmployeeAward employeeAward,Map<String, Object> options){
	

		return employeeAward;
	
	}
		

	

	protected String getTableName(){
		return EmployeeAwardTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<EmployeeAward> employeeAwardList) {		
		this.enhanceListInternal(employeeAwardList, this.getEmployeeAwardMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeAward> employeeAwardList = ownerEntity.collectRefsWithType(EmployeeAward.INTERNAL_TYPE);
		this.enhanceList(employeeAwardList);
		
	}
	
	@Override
	public SmartList<EmployeeAward> findEmployeeAwardWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getEmployeeAwardMapper());

	}
	@Override
	public int countEmployeeAwardWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeAwardWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<EmployeeAward> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeAwardMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeAward executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeAward result = new CandidateEmployeeAward();
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


