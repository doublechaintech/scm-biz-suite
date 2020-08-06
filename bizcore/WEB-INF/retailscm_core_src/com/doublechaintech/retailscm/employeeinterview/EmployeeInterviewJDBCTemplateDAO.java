
package com.doublechaintech.retailscm.employeeinterview;

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
import com.doublechaintech.retailscm.interviewtype.InterviewType;

import com.doublechaintech.retailscm.interviewtype.InterviewTypeDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class EmployeeInterviewJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeInterviewDAO{

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

	protected InterviewTypeDAO interviewTypeDAO;
	public void setInterviewTypeDAO(InterviewTypeDAO interviewTypeDAO){
 	
 		if(interviewTypeDAO == null){
 			throw new IllegalStateException("Do not try to set interviewTypeDAO to null.");
 		}
	 	this.interviewTypeDAO = interviewTypeDAO;
 	}
 	public InterviewTypeDAO getInterviewTypeDAO(){
 		if(this.interviewTypeDAO == null){
 			throw new IllegalStateException("The interviewTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.interviewTypeDAO;
 	}	


	/*
	protected EmployeeInterview load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeInterview(accessKey, options);
	}
	*/

	public SmartList<EmployeeInterview> loadAll() {
	    return this.loadAll(getEmployeeInterviewMapper());
	}

  public Stream<EmployeeInterview> loadAllAsStream() {
      return this.loadAllAsStream(getEmployeeInterviewMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public EmployeeInterview load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeInterview(EmployeeInterviewTable.withId(id), options);
	}

	

	public EmployeeInterview save(EmployeeInterview employeeInterview,Map<String,Object> options){

		String methodName="save(EmployeeInterview employeeInterview,Map<String,Object> options)";

		assertMethodArgumentNotNull(employeeInterview, methodName, "employeeInterview");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalEmployeeInterview(employeeInterview,options);
	}
	public EmployeeInterview clone(String employeeInterviewId, Map<String,Object> options) throws Exception{

		return clone(EmployeeInterviewTable.withId(employeeInterviewId),options);
	}

	protected EmployeeInterview clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String employeeInterviewId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		EmployeeInterview newEmployeeInterview = loadInternalEmployeeInterview(accessKey, options);
		newEmployeeInterview.setVersion(0);
		
		


		saveInternalEmployeeInterview(newEmployeeInterview,options);

		return newEmployeeInterview;
	}

	



	protected void throwIfHasException(String employeeInterviewId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeInterviewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeInterviewNotFoundException(
					"The " + this.getTableName() + "(" + employeeInterviewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String employeeInterviewId, int version) throws Exception{

		String methodName="delete(String employeeInterviewId, int version)";
		assertMethodArgumentNotNull(employeeInterviewId, methodName, "employeeInterviewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeInterviewId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeInterviewId,version);
		}


	}






	public EmployeeInterview disconnectFromAll(String employeeInterviewId, int version) throws Exception{


		EmployeeInterview employeeInterview = loadInternalEmployeeInterview(EmployeeInterviewTable.withId(employeeInterviewId), emptyOptions());
		employeeInterview.clearFromAll();
		this.saveEmployeeInterview(employeeInterview);
		return employeeInterview;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeInterviewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "employee_interview";
	}
	@Override
	protected String getBeanName() {

		return "employeeInterview";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeInterviewTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeInterviewTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeInterviewTokens.EMPLOYEE);
 	}
 	

 	
  

 	protected boolean isExtractInterviewTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeInterviewTokens.INTERVIEWTYPE);
 	}

 	protected boolean isSaveInterviewTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeInterviewTokens.INTERVIEWTYPE);
 	}
 	

 	
 
		

	

	protected EmployeeInterviewMapper getEmployeeInterviewMapper(){
		return new EmployeeInterviewMapper();
	}

	
	
	protected EmployeeInterview extractEmployeeInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeInterview employeeInterview = loadSingleObject(accessKey, getEmployeeInterviewMapper());
			return employeeInterview;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeInterviewNotFoundException("EmployeeInterview("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeeInterview loadInternalEmployeeInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeInterview employeeInterview = extractEmployeeInterview(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeInterview, loadOptions);
 		}
  	
 		if(isExtractInterviewTypeEnabled(loadOptions)){
	 		extractInterviewType(employeeInterview, loadOptions);
 		}
 
		
		return employeeInterview;
		
	}

	 

 	protected EmployeeInterview extractEmployee(EmployeeInterview employeeInterview, Map<String,Object> options) throws Exception{

		if(employeeInterview.getEmployee() == null){
			return employeeInterview;
		}
		String employeeId = employeeInterview.getEmployee().getId();
		if( employeeId == null){
			return employeeInterview;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeInterview.setEmployee(employee);
		}
		
 		
 		return employeeInterview;
 	}
 		
  

 	protected EmployeeInterview extractInterviewType(EmployeeInterview employeeInterview, Map<String,Object> options) throws Exception{

		if(employeeInterview.getInterviewType() == null){
			return employeeInterview;
		}
		String interviewTypeId = employeeInterview.getInterviewType().getId();
		if( interviewTypeId == null){
			return employeeInterview;
		}
		InterviewType interviewType = getInterviewTypeDAO().load(interviewTypeId,options);
		if(interviewType != null){
			employeeInterview.setInterviewType(interviewType);
		}
		
 		
 		return employeeInterview;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeInterview> findEmployeeInterviewByEmployee(String employeeId,Map<String,Object> options){
 	
  		SmartList<EmployeeInterview> resultList = queryWith(EmployeeInterviewTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeInterviewMapper());
		// analyzeEmployeeInterviewByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeInterview> findEmployeeInterviewByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeInterview> resultList =  queryWithRange(EmployeeInterviewTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeInterviewMapper(), start, count);
 		//analyzeEmployeeInterviewByEmployee(resultList, employeeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeInterviewByEmployee(SmartList<EmployeeInterview> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeInterview.EMPLOYEE_PROPERTY, employeeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeInterviewByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeInterviewTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeInterviewByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeInterviewTable.COLUMN_EMPLOYEE, ids, options);
	}
 	
  	
 	public SmartList<EmployeeInterview> findEmployeeInterviewByInterviewType(String interviewTypeId,Map<String,Object> options){
 	
  		SmartList<EmployeeInterview> resultList = queryWith(EmployeeInterviewTable.COLUMN_INTERVIEW_TYPE, interviewTypeId, options, getEmployeeInterviewMapper());
		// analyzeEmployeeInterviewByInterviewType(resultList, interviewTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeInterview> findEmployeeInterviewByInterviewType(String interviewTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeInterview> resultList =  queryWithRange(EmployeeInterviewTable.COLUMN_INTERVIEW_TYPE, interviewTypeId, options, getEmployeeInterviewMapper(), start, count);
 		//analyzeEmployeeInterviewByInterviewType(resultList, interviewTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeInterviewByInterviewType(SmartList<EmployeeInterview> resultList, String interviewTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, interviewTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeInterviewByInterviewType(String interviewTypeId,Map<String,Object> options){

 		return countWith(EmployeeInterviewTable.COLUMN_INTERVIEW_TYPE, interviewTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeInterviewByInterviewTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeInterviewTable.COLUMN_INTERVIEW_TYPE, ids, options);
	}
 	
 	
		
		
		

	

	protected EmployeeInterview saveEmployeeInterview(EmployeeInterview  employeeInterview){
		
		if(!employeeInterview.isChanged()){
			return employeeInterview;
		}
		

		String SQL=this.getSaveEmployeeInterviewSQL(employeeInterview);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeInterviewParameters(employeeInterview);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		employeeInterview.incVersion();
		return employeeInterview;

	}
	public SmartList<EmployeeInterview> saveEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeInterviewList(employeeInterviewList);

		batchEmployeeInterviewCreate((List<EmployeeInterview>)lists[CREATE_LIST_INDEX]);

		batchEmployeeInterviewUpdate((List<EmployeeInterview>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(EmployeeInterview employeeInterview:employeeInterviewList){
			if(employeeInterview.isChanged()){
				employeeInterview.incVersion();
			}


		}


		return employeeInterviewList;
	}

	public SmartList<EmployeeInterview> removeEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options){


		super.removeList(employeeInterviewList, options);

		return employeeInterviewList;


	}

	protected List<Object[]> prepareEmployeeInterviewBatchCreateArgs(List<EmployeeInterview> employeeInterviewList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeInterview employeeInterview:employeeInterviewList ){
			Object [] parameters = prepareEmployeeInterviewCreateParameters(employeeInterview);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareEmployeeInterviewBatchUpdateArgs(List<EmployeeInterview> employeeInterviewList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeInterview employeeInterview:employeeInterviewList ){
			if(!employeeInterview.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeInterviewUpdateParameters(employeeInterview);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchEmployeeInterviewCreate(List<EmployeeInterview> employeeInterviewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeInterviewBatchCreateArgs(employeeInterviewList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchEmployeeInterviewUpdate(List<EmployeeInterview> employeeInterviewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeInterviewBatchUpdateArgs(employeeInterviewList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitEmployeeInterviewList(List<EmployeeInterview> employeeInterviewList){

		List<EmployeeInterview> employeeInterviewCreateList=new ArrayList<EmployeeInterview>();
		List<EmployeeInterview> employeeInterviewUpdateList=new ArrayList<EmployeeInterview>();

		for(EmployeeInterview employeeInterview: employeeInterviewList){
			if(isUpdateRequest(employeeInterview)){
				employeeInterviewUpdateList.add( employeeInterview);
				continue;
			}
			employeeInterviewCreateList.add(employeeInterview);
		}

		return new Object[]{employeeInterviewCreateList,employeeInterviewUpdateList};
	}

	protected boolean isUpdateRequest(EmployeeInterview employeeInterview){
 		return employeeInterview.getVersion() > 0;
 	}
 	protected String getSaveEmployeeInterviewSQL(EmployeeInterview employeeInterview){
 		if(isUpdateRequest(employeeInterview)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveEmployeeInterviewParameters(EmployeeInterview employeeInterview){
 		if(isUpdateRequest(employeeInterview) ){
 			return prepareEmployeeInterviewUpdateParameters(employeeInterview);
 		}
 		return prepareEmployeeInterviewCreateParameters(employeeInterview);
 	}
 	protected Object[] prepareEmployeeInterviewUpdateParameters(EmployeeInterview employeeInterview){
 		Object[] parameters = new Object[6];
 
 		if(employeeInterview.getEmployee() != null){
 			parameters[0] = employeeInterview.getEmployee().getId();
 		}
 
 		if(employeeInterview.getInterviewType() != null){
 			parameters[1] = employeeInterview.getInterviewType().getId();
 		}
 
 		
 		parameters[2] = employeeInterview.getRemark();
 		
 		parameters[3] = employeeInterview.nextVersion();
 		parameters[4] = employeeInterview.getId();
 		parameters[5] = employeeInterview.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareEmployeeInterviewCreateParameters(EmployeeInterview employeeInterview){
		Object[] parameters = new Object[4];
        if(employeeInterview.getId() == null){
          String newEmployeeInterviewId=getNextId();
          employeeInterview.setId(newEmployeeInterviewId);
        }
		parameters[0] =  employeeInterview.getId();
 
 		if(employeeInterview.getEmployee() != null){
 			parameters[1] = employeeInterview.getEmployee().getId();

 		}
 		
 		if(employeeInterview.getInterviewType() != null){
 			parameters[2] = employeeInterview.getInterviewType().getId();

 		}
 		
 		
 		parameters[3] = employeeInterview.getRemark();
 		

 		return parameters;
 	}

	protected EmployeeInterview saveInternalEmployeeInterview(EmployeeInterview employeeInterview, Map<String,Object> options){

		saveEmployeeInterview(employeeInterview);

 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeInterview, options);
 		}
 
 		if(isSaveInterviewTypeEnabled(options)){
	 		saveInterviewType(employeeInterview, options);
 		}
 
		
		return employeeInterview;

	}



	//======================================================================================
	

 	protected EmployeeInterview saveEmployee(EmployeeInterview employeeInterview, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeInterview.getEmployee() == null){
 			return employeeInterview;//do nothing when it is null
 		}

 		getEmployeeDAO().save(employeeInterview.getEmployee(),options);
 		return employeeInterview;

 	}





 

 	protected EmployeeInterview saveInterviewType(EmployeeInterview employeeInterview, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeInterview.getInterviewType() == null){
 			return employeeInterview;//do nothing when it is null
 		}

 		getInterviewTypeDAO().save(employeeInterview.getInterviewType(),options);
 		return employeeInterview;

 	}





 

	

		

	public EmployeeInterview present(EmployeeInterview employeeInterview,Map<String, Object> options){
	

		return employeeInterview;
	
	}
		

	

	protected String getTableName(){
		return EmployeeInterviewTable.TABLE_NAME;
	}



	public void enhanceList(List<EmployeeInterview> employeeInterviewList) {
		this.enhanceListInternal(employeeInterviewList, this.getEmployeeInterviewMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeInterview> employeeInterviewList = ownerEntity.collectRefsWithType(EmployeeInterview.INTERNAL_TYPE);
		this.enhanceList(employeeInterviewList);

	}

	@Override
	public SmartList<EmployeeInterview> findEmployeeInterviewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getEmployeeInterviewMapper());

	}
	@Override
	public int countEmployeeInterviewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeInterviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<EmployeeInterview> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeInterviewMapper());
	}

  @Override
  public Stream<EmployeeInterview> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEmployeeInterviewMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeInterview executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeInterview result = new CandidateEmployeeInterview();
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


