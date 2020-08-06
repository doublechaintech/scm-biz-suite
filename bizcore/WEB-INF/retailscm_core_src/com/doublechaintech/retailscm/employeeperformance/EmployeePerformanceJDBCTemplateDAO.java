
package com.doublechaintech.retailscm.employeeperformance;

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
import java.util.stream.Stream;

public class EmployeePerformanceJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeePerformanceDAO{

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
	protected EmployeePerformance load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeePerformance(accessKey, options);
	}
	*/

	public SmartList<EmployeePerformance> loadAll() {
	    return this.loadAll(getEmployeePerformanceMapper());
	}

  public Stream<EmployeePerformance> loadAllAsStream() {
      return this.loadAllAsStream(getEmployeePerformanceMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public EmployeePerformance load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeePerformance(EmployeePerformanceTable.withId(id), options);
	}

	

	public EmployeePerformance save(EmployeePerformance employeePerformance,Map<String,Object> options){

		String methodName="save(EmployeePerformance employeePerformance,Map<String,Object> options)";

		assertMethodArgumentNotNull(employeePerformance, methodName, "employeePerformance");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalEmployeePerformance(employeePerformance,options);
	}
	public EmployeePerformance clone(String employeePerformanceId, Map<String,Object> options) throws Exception{

		return clone(EmployeePerformanceTable.withId(employeePerformanceId),options);
	}

	protected EmployeePerformance clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String employeePerformanceId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		EmployeePerformance newEmployeePerformance = loadInternalEmployeePerformance(accessKey, options);
		newEmployeePerformance.setVersion(0);
		
		


		saveInternalEmployeePerformance(newEmployeePerformance,options);

		return newEmployeePerformance;
	}

	



	protected void throwIfHasException(String employeePerformanceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeePerformanceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeePerformanceNotFoundException(
					"The " + this.getTableName() + "(" + employeePerformanceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String employeePerformanceId, int version) throws Exception{

		String methodName="delete(String employeePerformanceId, int version)";
		assertMethodArgumentNotNull(employeePerformanceId, methodName, "employeePerformanceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeePerformanceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeePerformanceId,version);
		}


	}






	public EmployeePerformance disconnectFromAll(String employeePerformanceId, int version) throws Exception{


		EmployeePerformance employeePerformance = loadInternalEmployeePerformance(EmployeePerformanceTable.withId(employeePerformanceId), emptyOptions());
		employeePerformance.clearFromAll();
		this.saveEmployeePerformance(employeePerformance);
		return employeePerformance;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return EmployeePerformanceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "employee_performance";
	}
	@Override
	protected String getBeanName() {

		return "employeePerformance";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeePerformanceTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeePerformanceTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeePerformanceTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeePerformanceMapper getEmployeePerformanceMapper(){
		return new EmployeePerformanceMapper();
	}

	
	
	protected EmployeePerformance extractEmployeePerformance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeePerformance employeePerformance = loadSingleObject(accessKey, getEmployeePerformanceMapper());
			return employeePerformance;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeePerformanceNotFoundException("EmployeePerformance("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeePerformance loadInternalEmployeePerformance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeePerformance employeePerformance = extractEmployeePerformance(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeePerformance, loadOptions);
 		}
 
		
		return employeePerformance;
		
	}

	 

 	protected EmployeePerformance extractEmployee(EmployeePerformance employeePerformance, Map<String,Object> options) throws Exception{

		if(employeePerformance.getEmployee() == null){
			return employeePerformance;
		}
		String employeeId = employeePerformance.getEmployee().getId();
		if( employeeId == null){
			return employeePerformance;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeePerformance.setEmployee(employee);
		}
		
 		
 		return employeePerformance;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeePerformance> findEmployeePerformanceByEmployee(String employeeId,Map<String,Object> options){
 	
  		SmartList<EmployeePerformance> resultList = queryWith(EmployeePerformanceTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeePerformanceMapper());
		// analyzeEmployeePerformanceByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeePerformance> findEmployeePerformanceByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeePerformance> resultList =  queryWithRange(EmployeePerformanceTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeePerformanceMapper(), start, count);
 		//analyzeEmployeePerformanceByEmployee(resultList, employeeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeePerformanceByEmployee(SmartList<EmployeePerformance> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countEmployeePerformanceByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeePerformanceTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeePerformanceByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeePerformanceTable.COLUMN_EMPLOYEE, ids, options);
	}
 	
 	
		
		
		

	

	protected EmployeePerformance saveEmployeePerformance(EmployeePerformance  employeePerformance){
		
		if(!employeePerformance.isChanged()){
			return employeePerformance;
		}
		

		String SQL=this.getSaveEmployeePerformanceSQL(employeePerformance);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeePerformanceParameters(employeePerformance);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		employeePerformance.incVersion();
		return employeePerformance;

	}
	public SmartList<EmployeePerformance> saveEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeePerformanceList(employeePerformanceList);

		batchEmployeePerformanceCreate((List<EmployeePerformance>)lists[CREATE_LIST_INDEX]);

		batchEmployeePerformanceUpdate((List<EmployeePerformance>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(EmployeePerformance employeePerformance:employeePerformanceList){
			if(employeePerformance.isChanged()){
				employeePerformance.incVersion();
			}


		}


		return employeePerformanceList;
	}

	public SmartList<EmployeePerformance> removeEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList,Map<String,Object> options){


		super.removeList(employeePerformanceList, options);

		return employeePerformanceList;


	}

	protected List<Object[]> prepareEmployeePerformanceBatchCreateArgs(List<EmployeePerformance> employeePerformanceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeePerformance employeePerformance:employeePerformanceList ){
			Object [] parameters = prepareEmployeePerformanceCreateParameters(employeePerformance);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareEmployeePerformanceBatchUpdateArgs(List<EmployeePerformance> employeePerformanceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeePerformance employeePerformance:employeePerformanceList ){
			if(!employeePerformance.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeePerformanceUpdateParameters(employeePerformance);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchEmployeePerformanceCreate(List<EmployeePerformance> employeePerformanceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeePerformanceBatchCreateArgs(employeePerformanceList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchEmployeePerformanceUpdate(List<EmployeePerformance> employeePerformanceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeePerformanceBatchUpdateArgs(employeePerformanceList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitEmployeePerformanceList(List<EmployeePerformance> employeePerformanceList){

		List<EmployeePerformance> employeePerformanceCreateList=new ArrayList<EmployeePerformance>();
		List<EmployeePerformance> employeePerformanceUpdateList=new ArrayList<EmployeePerformance>();

		for(EmployeePerformance employeePerformance: employeePerformanceList){
			if(isUpdateRequest(employeePerformance)){
				employeePerformanceUpdateList.add( employeePerformance);
				continue;
			}
			employeePerformanceCreateList.add(employeePerformance);
		}

		return new Object[]{employeePerformanceCreateList,employeePerformanceUpdateList};
	}

	protected boolean isUpdateRequest(EmployeePerformance employeePerformance){
 		return employeePerformance.getVersion() > 0;
 	}
 	protected String getSaveEmployeePerformanceSQL(EmployeePerformance employeePerformance){
 		if(isUpdateRequest(employeePerformance)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveEmployeePerformanceParameters(EmployeePerformance employeePerformance){
 		if(isUpdateRequest(employeePerformance) ){
 			return prepareEmployeePerformanceUpdateParameters(employeePerformance);
 		}
 		return prepareEmployeePerformanceCreateParameters(employeePerformance);
 	}
 	protected Object[] prepareEmployeePerformanceUpdateParameters(EmployeePerformance employeePerformance){
 		Object[] parameters = new Object[5];
 
 		if(employeePerformance.getEmployee() != null){
 			parameters[0] = employeePerformance.getEmployee().getId();
 		}
 
 		
 		parameters[1] = employeePerformance.getPerformanceComment();
 		
 		parameters[2] = employeePerformance.nextVersion();
 		parameters[3] = employeePerformance.getId();
 		parameters[4] = employeePerformance.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareEmployeePerformanceCreateParameters(EmployeePerformance employeePerformance){
		Object[] parameters = new Object[3];
        if(employeePerformance.getId() == null){
          String newEmployeePerformanceId=getNextId();
          employeePerformance.setId(newEmployeePerformanceId);
        }
		parameters[0] =  employeePerformance.getId();
 
 		if(employeePerformance.getEmployee() != null){
 			parameters[1] = employeePerformance.getEmployee().getId();

 		}
 		
 		
 		parameters[2] = employeePerformance.getPerformanceComment();
 		

 		return parameters;
 	}

	protected EmployeePerformance saveInternalEmployeePerformance(EmployeePerformance employeePerformance, Map<String,Object> options){

		saveEmployeePerformance(employeePerformance);

 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeePerformance, options);
 		}
 
		
		return employeePerformance;

	}



	//======================================================================================
	

 	protected EmployeePerformance saveEmployee(EmployeePerformance employeePerformance, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeePerformance.getEmployee() == null){
 			return employeePerformance;//do nothing when it is null
 		}

 		getEmployeeDAO().save(employeePerformance.getEmployee(),options);
 		return employeePerformance;

 	}





 

	

		

	public EmployeePerformance present(EmployeePerformance employeePerformance,Map<String, Object> options){
	

		return employeePerformance;
	
	}
		

	

	protected String getTableName(){
		return EmployeePerformanceTable.TABLE_NAME;
	}



	public void enhanceList(List<EmployeePerformance> employeePerformanceList) {
		this.enhanceListInternal(employeePerformanceList, this.getEmployeePerformanceMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeePerformance> employeePerformanceList = ownerEntity.collectRefsWithType(EmployeePerformance.INTERNAL_TYPE);
		this.enhanceList(employeePerformanceList);

	}

	@Override
	public SmartList<EmployeePerformance> findEmployeePerformanceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getEmployeePerformanceMapper());

	}
	@Override
	public int countEmployeePerformanceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeePerformanceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<EmployeePerformance> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeePerformanceMapper());
	}

  @Override
  public Stream<EmployeePerformance> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEmployeePerformanceMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeePerformance executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeePerformance result = new CandidateEmployeePerformance();
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


