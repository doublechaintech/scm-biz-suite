
package com.doublechaintech.retailscm.employeeattendance;

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


import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class EmployeeAttendanceJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeAttendanceDAO{

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
	protected EmployeeAttendance load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeAttendance(accessKey, options);
	}
	*/

	public SmartList<EmployeeAttendance> loadAll() {
	    return this.loadAll(getEmployeeAttendanceMapper());
	}

  public Stream<EmployeeAttendance> loadAllAsStream() {
      return this.loadAllAsStream(getEmployeeAttendanceMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public EmployeeAttendance load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeAttendance(EmployeeAttendanceTable.withId(id), options);
	}

	

	public EmployeeAttendance save(EmployeeAttendance employeeAttendance,Map<String,Object> options){

		String methodName="save(EmployeeAttendance employeeAttendance,Map<String,Object> options)";

		assertMethodArgumentNotNull(employeeAttendance, methodName, "employeeAttendance");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalEmployeeAttendance(employeeAttendance,options);
	}
	public EmployeeAttendance clone(String employeeAttendanceId, Map<String,Object> options) throws Exception{

		return clone(EmployeeAttendanceTable.withId(employeeAttendanceId),options);
	}

	protected EmployeeAttendance clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String employeeAttendanceId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		EmployeeAttendance newEmployeeAttendance = loadInternalEmployeeAttendance(accessKey, options);
		newEmployeeAttendance.setVersion(0);
		
		


		saveInternalEmployeeAttendance(newEmployeeAttendance,options);

		return newEmployeeAttendance;
	}

	



	protected void throwIfHasException(String employeeAttendanceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeAttendanceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeAttendanceNotFoundException(
					"The " + this.getTableName() + "(" + employeeAttendanceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String employeeAttendanceId, int version) throws Exception{

		String methodName="delete(String employeeAttendanceId, int version)";
		assertMethodArgumentNotNull(employeeAttendanceId, methodName, "employeeAttendanceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeAttendanceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeAttendanceId,version);
		}


	}






	public EmployeeAttendance disconnectFromAll(String employeeAttendanceId, int version) throws Exception{


		EmployeeAttendance employeeAttendance = loadInternalEmployeeAttendance(EmployeeAttendanceTable.withId(employeeAttendanceId), emptyOptions());
		employeeAttendance.clearFromAll();
		this.saveEmployeeAttendance(employeeAttendance);
		return employeeAttendance;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeAttendanceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "employee_attendance";
	}
	@Override
	protected String getBeanName() {

		return "employeeAttendance";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return EmployeeAttendanceTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){

	 	return checkOptions(options, EmployeeAttendanceTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){

 		return checkOptions(options, EmployeeAttendanceTokens.EMPLOYEE);
 	}



 
		

	

	protected EmployeeAttendanceMapper getEmployeeAttendanceMapper(){
		return new EmployeeAttendanceMapper();
	}



	protected EmployeeAttendance extractEmployeeAttendance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeAttendance employeeAttendance = loadSingleObject(accessKey, getEmployeeAttendanceMapper());
			return employeeAttendance;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeAttendanceNotFoundException("EmployeeAttendance("+accessKey+") is not found!");
		}

	}




	protected EmployeeAttendance loadInternalEmployeeAttendance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		EmployeeAttendance employeeAttendance = extractEmployeeAttendance(accessKey, loadOptions);

 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeAttendance, loadOptions);
 		}
 
		
		return employeeAttendance;

	}

	

 	protected EmployeeAttendance extractEmployee(EmployeeAttendance employeeAttendance, Map<String,Object> options) throws Exception{
  

		if(employeeAttendance.getEmployee() == null){
			return employeeAttendance;
		}
		String employeeId = employeeAttendance.getEmployee().getId();
		if( employeeId == null){
			return employeeAttendance;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeAttendance.setEmployee(employee);
		}


 		return employeeAttendance;
 	}

 
		

 
 	public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(String employeeId,Map<String,Object> options){

  		SmartList<EmployeeAttendance> resultList = queryWith(EmployeeAttendanceTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeAttendanceMapper());
		// analyzeEmployeeAttendanceByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	

 	public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(String employeeId, int start, int count,Map<String,Object> options){

 		SmartList<EmployeeAttendance> resultList =  queryWithRange(EmployeeAttendanceTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeAttendanceMapper(), start, count);
 		//analyzeEmployeeAttendanceByEmployee(resultList, employeeId, options);
 		return resultList;

 	}
 	public void analyzeEmployeeAttendanceByEmployee(SmartList<EmployeeAttendance> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countEmployeeAttendanceByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeAttendanceTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeAttendanceByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeAttendanceTable.COLUMN_EMPLOYEE, ids, options);
	}

 




	

	protected EmployeeAttendance saveEmployeeAttendance(EmployeeAttendance  employeeAttendance){
    

		
		if(!employeeAttendance.isChanged()){
			return employeeAttendance;
		}
		

    Beans.dbUtil().cacheCleanUp(employeeAttendance);
		String SQL=this.getSaveEmployeeAttendanceSQL(employeeAttendance);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeAttendanceParameters(employeeAttendance);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		employeeAttendance.incVersion();
		employeeAttendance.afterSave();
		return employeeAttendance;

	}
	public SmartList<EmployeeAttendance> saveEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeAttendanceList(employeeAttendanceList);

		batchEmployeeAttendanceCreate((List<EmployeeAttendance>)lists[CREATE_LIST_INDEX]);

		batchEmployeeAttendanceUpdate((List<EmployeeAttendance>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(EmployeeAttendance employeeAttendance:employeeAttendanceList){
			if(employeeAttendance.isChanged()){
				employeeAttendance.incVersion();
				employeeAttendance.afterSave();
			}


		}


		return employeeAttendanceList;
	}

	public SmartList<EmployeeAttendance> removeEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList,Map<String,Object> options){


		super.removeList(employeeAttendanceList, options);

		return employeeAttendanceList;


	}

	protected List<Object[]> prepareEmployeeAttendanceBatchCreateArgs(List<EmployeeAttendance> employeeAttendanceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeAttendance employeeAttendance:employeeAttendanceList ){
			Object [] parameters = prepareEmployeeAttendanceCreateParameters(employeeAttendance);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareEmployeeAttendanceBatchUpdateArgs(List<EmployeeAttendance> employeeAttendanceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeAttendance employeeAttendance:employeeAttendanceList ){
			if(!employeeAttendance.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeAttendanceUpdateParameters(employeeAttendance);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchEmployeeAttendanceCreate(List<EmployeeAttendance> employeeAttendanceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeAttendanceBatchCreateArgs(employeeAttendanceList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchEmployeeAttendanceUpdate(List<EmployeeAttendance> employeeAttendanceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeAttendanceBatchUpdateArgs(employeeAttendanceList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitEmployeeAttendanceList(List<EmployeeAttendance> employeeAttendanceList){

		List<EmployeeAttendance> employeeAttendanceCreateList=new ArrayList<EmployeeAttendance>();
		List<EmployeeAttendance> employeeAttendanceUpdateList=new ArrayList<EmployeeAttendance>();

		for(EmployeeAttendance employeeAttendance: employeeAttendanceList){
			if(isUpdateRequest(employeeAttendance)){
				employeeAttendanceUpdateList.add( employeeAttendance);
				continue;
			}
			employeeAttendanceCreateList.add(employeeAttendance);
		}

		return new Object[]{employeeAttendanceCreateList,employeeAttendanceUpdateList};
	}

	protected boolean isUpdateRequest(EmployeeAttendance employeeAttendance){
 		return employeeAttendance.getVersion() > 0;
 	}
 	protected String getSaveEmployeeAttendanceSQL(EmployeeAttendance employeeAttendance){
 		if(isUpdateRequest(employeeAttendance)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveEmployeeAttendanceParameters(EmployeeAttendance employeeAttendance){
 		if(isUpdateRequest(employeeAttendance) ){
 			return prepareEmployeeAttendanceUpdateParameters(employeeAttendance);
 		}
 		return prepareEmployeeAttendanceCreateParameters(employeeAttendance);
 	}
 	protected Object[] prepareEmployeeAttendanceUpdateParameters(EmployeeAttendance employeeAttendance){
 		Object[] parameters = new Object[8];
 
 		if(employeeAttendance.getEmployee() != null){
 			parameters[0] = employeeAttendance.getEmployee().getId();
 		}
    
 		parameters[1] = employeeAttendance.getEnterTime();
 		
 		parameters[2] = employeeAttendance.getLeaveTime();
 		
 		parameters[3] = employeeAttendance.getDurationHours();
 		
 		parameters[4] = employeeAttendance.getRemark();
 		
 		parameters[5] = employeeAttendance.nextVersion();
 		parameters[6] = employeeAttendance.getId();
 		parameters[7] = employeeAttendance.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareEmployeeAttendanceCreateParameters(EmployeeAttendance employeeAttendance){
		Object[] parameters = new Object[6];
        if(employeeAttendance.getId() == null){
          String newEmployeeAttendanceId=getNextId();
          employeeAttendance.setId(newEmployeeAttendanceId);
        }
		parameters[0] =  employeeAttendance.getId();
 
 		if(employeeAttendance.getEmployee() != null){
 			parameters[1] = employeeAttendance.getEmployee().getId();
 		}
 		
 		parameters[2] = employeeAttendance.getEnterTime();
 		
 		parameters[3] = employeeAttendance.getLeaveTime();
 		
 		parameters[4] = employeeAttendance.getDurationHours();
 		
 		parameters[5] = employeeAttendance.getRemark();
 		

 		return parameters;
 	}

	protected EmployeeAttendance saveInternalEmployeeAttendance(EmployeeAttendance employeeAttendance, Map<String,Object> options){

 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeAttendance, options);
 		}
 
   saveEmployeeAttendance(employeeAttendance);
		
		return employeeAttendance;

	}



	//======================================================================================
	

 	protected EmployeeAttendance saveEmployee(EmployeeAttendance employeeAttendance, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(employeeAttendance.getEmployee() == null){
 			return employeeAttendance;//do nothing when it is null
 		}

 		getEmployeeDAO().save(employeeAttendance.getEmployee(),options);
 		return employeeAttendance;

 	}
 

	

		

	public EmployeeAttendance present(EmployeeAttendance employeeAttendance,Map<String, Object> options){


		return employeeAttendance;

	}
		

	

	protected String getTableName(){
		return EmployeeAttendanceTable.TABLE_NAME;
	}



	public void enhanceList(List<EmployeeAttendance> employeeAttendanceList) {
		this.enhanceListInternal(employeeAttendanceList, this.getEmployeeAttendanceMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeAttendance> employeeAttendanceList = ownerEntity.collectRefsWithType(EmployeeAttendance.INTERNAL_TYPE);
		this.enhanceList(employeeAttendanceList);

	}

	@Override
	public SmartList<EmployeeAttendance> findEmployeeAttendanceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getEmployeeAttendanceMapper());

	}
	@Override
	public int countEmployeeAttendanceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeAttendanceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<EmployeeAttendance> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeAttendanceMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<EmployeeAttendance> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEmployeeAttendanceMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeAttendance executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeAttendance result = new CandidateEmployeeAttendance();
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
  public List<EmployeeAttendance> search(EmployeeAttendanceRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected EmployeeAttendanceMapper mapper() {
    return getEmployeeAttendanceMapper();
  }
}


