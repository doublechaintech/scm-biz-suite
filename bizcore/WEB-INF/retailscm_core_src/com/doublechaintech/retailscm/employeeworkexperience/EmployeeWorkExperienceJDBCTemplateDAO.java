
package com.doublechaintech.retailscm.employeeworkexperience;

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

public class EmployeeWorkExperienceJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeWorkExperienceDAO{

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
	protected EmployeeWorkExperience load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeWorkExperience(accessKey, options);
	}
	*/

	public SmartList<EmployeeWorkExperience> loadAll() {
	    return this.loadAll(getEmployeeWorkExperienceMapper());
	}

  public Stream<EmployeeWorkExperience> loadAllAsStream() {
      return this.loadAllAsStream(getEmployeeWorkExperienceMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public EmployeeWorkExperience load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeWorkExperience(EmployeeWorkExperienceTable.withId(id), options);
	}

	

	public EmployeeWorkExperience save(EmployeeWorkExperience employeeWorkExperience,Map<String,Object> options){

		String methodName="save(EmployeeWorkExperience employeeWorkExperience,Map<String,Object> options)";

		assertMethodArgumentNotNull(employeeWorkExperience, methodName, "employeeWorkExperience");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalEmployeeWorkExperience(employeeWorkExperience,options);
	}
	public EmployeeWorkExperience clone(String employeeWorkExperienceId, Map<String,Object> options) throws Exception{

		return clone(EmployeeWorkExperienceTable.withId(employeeWorkExperienceId),options);
	}

	protected EmployeeWorkExperience clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String employeeWorkExperienceId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		EmployeeWorkExperience newEmployeeWorkExperience = loadInternalEmployeeWorkExperience(accessKey, options);
		newEmployeeWorkExperience.setVersion(0);
		
		


		saveInternalEmployeeWorkExperience(newEmployeeWorkExperience,options);

		return newEmployeeWorkExperience;
	}

	



	protected void throwIfHasException(String employeeWorkExperienceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeWorkExperienceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeWorkExperienceNotFoundException(
					"The " + this.getTableName() + "(" + employeeWorkExperienceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String employeeWorkExperienceId, int version) throws Exception{

		String methodName="delete(String employeeWorkExperienceId, int version)";
		assertMethodArgumentNotNull(employeeWorkExperienceId, methodName, "employeeWorkExperienceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeWorkExperienceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeWorkExperienceId,version);
		}


	}






	public EmployeeWorkExperience disconnectFromAll(String employeeWorkExperienceId, int version) throws Exception{


		EmployeeWorkExperience employeeWorkExperience = loadInternalEmployeeWorkExperience(EmployeeWorkExperienceTable.withId(employeeWorkExperienceId), emptyOptions());
		employeeWorkExperience.clearFromAll();
		this.saveEmployeeWorkExperience(employeeWorkExperience);
		return employeeWorkExperience;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeWorkExperienceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "employee_work_experience";
	}
	@Override
	protected String getBeanName() {

		return "employeeWorkExperience";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeWorkExperienceTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeWorkExperienceTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeWorkExperienceTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeeWorkExperienceMapper getEmployeeWorkExperienceMapper(){
		return new EmployeeWorkExperienceMapper();
	}

	
	
	protected EmployeeWorkExperience extractEmployeeWorkExperience(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeWorkExperience employeeWorkExperience = loadSingleObject(accessKey, getEmployeeWorkExperienceMapper());
			return employeeWorkExperience;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeWorkExperienceNotFoundException("EmployeeWorkExperience("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeeWorkExperience loadInternalEmployeeWorkExperience(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeWorkExperience employeeWorkExperience = extractEmployeeWorkExperience(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeWorkExperience, loadOptions);
 		}
 
		
		return employeeWorkExperience;
		
	}

	 

 	protected EmployeeWorkExperience extractEmployee(EmployeeWorkExperience employeeWorkExperience, Map<String,Object> options) throws Exception{

		if(employeeWorkExperience.getEmployee() == null){
			return employeeWorkExperience;
		}
		String employeeId = employeeWorkExperience.getEmployee().getId();
		if( employeeId == null){
			return employeeWorkExperience;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeWorkExperience.setEmployee(employee);
		}
		
 		
 		return employeeWorkExperience;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(String employeeId,Map<String,Object> options){
 	
  		SmartList<EmployeeWorkExperience> resultList = queryWith(EmployeeWorkExperienceTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeWorkExperienceMapper());
		// analyzeEmployeeWorkExperienceByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeWorkExperience> resultList =  queryWithRange(EmployeeWorkExperienceTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeWorkExperienceMapper(), start, count);
 		//analyzeEmployeeWorkExperienceByEmployee(resultList, employeeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeWorkExperienceByEmployee(SmartList<EmployeeWorkExperience> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countEmployeeWorkExperienceByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeWorkExperienceTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeWorkExperienceByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeWorkExperienceTable.COLUMN_EMPLOYEE, ids, options);
	}
 	
 	
		
		
		

	

	protected EmployeeWorkExperience saveEmployeeWorkExperience(EmployeeWorkExperience  employeeWorkExperience){
		
		if(!employeeWorkExperience.isChanged()){
			return employeeWorkExperience;
		}
		

		String SQL=this.getSaveEmployeeWorkExperienceSQL(employeeWorkExperience);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeWorkExperienceParameters(employeeWorkExperience);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		employeeWorkExperience.incVersion();
		return employeeWorkExperience;

	}
	public SmartList<EmployeeWorkExperience> saveEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeWorkExperienceList(employeeWorkExperienceList);

		batchEmployeeWorkExperienceCreate((List<EmployeeWorkExperience>)lists[CREATE_LIST_INDEX]);

		batchEmployeeWorkExperienceUpdate((List<EmployeeWorkExperience>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList){
			if(employeeWorkExperience.isChanged()){
				employeeWorkExperience.incVersion();
			}


		}


		return employeeWorkExperienceList;
	}

	public SmartList<EmployeeWorkExperience> removeEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList,Map<String,Object> options){


		super.removeList(employeeWorkExperienceList, options);

		return employeeWorkExperienceList;


	}

	protected List<Object[]> prepareEmployeeWorkExperienceBatchCreateArgs(List<EmployeeWorkExperience> employeeWorkExperienceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList ){
			Object [] parameters = prepareEmployeeWorkExperienceCreateParameters(employeeWorkExperience);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareEmployeeWorkExperienceBatchUpdateArgs(List<EmployeeWorkExperience> employeeWorkExperienceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList ){
			if(!employeeWorkExperience.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeWorkExperienceUpdateParameters(employeeWorkExperience);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchEmployeeWorkExperienceCreate(List<EmployeeWorkExperience> employeeWorkExperienceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeWorkExperienceBatchCreateArgs(employeeWorkExperienceList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchEmployeeWorkExperienceUpdate(List<EmployeeWorkExperience> employeeWorkExperienceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeWorkExperienceBatchUpdateArgs(employeeWorkExperienceList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitEmployeeWorkExperienceList(List<EmployeeWorkExperience> employeeWorkExperienceList){

		List<EmployeeWorkExperience> employeeWorkExperienceCreateList=new ArrayList<EmployeeWorkExperience>();
		List<EmployeeWorkExperience> employeeWorkExperienceUpdateList=new ArrayList<EmployeeWorkExperience>();

		for(EmployeeWorkExperience employeeWorkExperience: employeeWorkExperienceList){
			if(isUpdateRequest(employeeWorkExperience)){
				employeeWorkExperienceUpdateList.add( employeeWorkExperience);
				continue;
			}
			employeeWorkExperienceCreateList.add(employeeWorkExperience);
		}

		return new Object[]{employeeWorkExperienceCreateList,employeeWorkExperienceUpdateList};
	}

	protected boolean isUpdateRequest(EmployeeWorkExperience employeeWorkExperience){
 		return employeeWorkExperience.getVersion() > 0;
 	}
 	protected String getSaveEmployeeWorkExperienceSQL(EmployeeWorkExperience employeeWorkExperience){
 		if(isUpdateRequest(employeeWorkExperience)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveEmployeeWorkExperienceParameters(EmployeeWorkExperience employeeWorkExperience){
 		if(isUpdateRequest(employeeWorkExperience) ){
 			return prepareEmployeeWorkExperienceUpdateParameters(employeeWorkExperience);
 		}
 		return prepareEmployeeWorkExperienceCreateParameters(employeeWorkExperience);
 	}
 	protected Object[] prepareEmployeeWorkExperienceUpdateParameters(EmployeeWorkExperience employeeWorkExperience){
 		Object[] parameters = new Object[8];
 
 		if(employeeWorkExperience.getEmployee() != null){
 			parameters[0] = employeeWorkExperience.getEmployee().getId();
 		}
 
 		
 		parameters[1] = employeeWorkExperience.getStart();
 		
 		
 		parameters[2] = employeeWorkExperience.getEnd();
 		
 		
 		parameters[3] = employeeWorkExperience.getCompany();
 		
 		
 		parameters[4] = employeeWorkExperience.getDescription();
 		
 		parameters[5] = employeeWorkExperience.nextVersion();
 		parameters[6] = employeeWorkExperience.getId();
 		parameters[7] = employeeWorkExperience.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareEmployeeWorkExperienceCreateParameters(EmployeeWorkExperience employeeWorkExperience){
		Object[] parameters = new Object[6];
        if(employeeWorkExperience.getId() == null){
          String newEmployeeWorkExperienceId=getNextId();
          employeeWorkExperience.setId(newEmployeeWorkExperienceId);
        }
		parameters[0] =  employeeWorkExperience.getId();
 
 		if(employeeWorkExperience.getEmployee() != null){
 			parameters[1] = employeeWorkExperience.getEmployee().getId();

 		}
 		
 		
 		parameters[2] = employeeWorkExperience.getStart();
 		
 		
 		parameters[3] = employeeWorkExperience.getEnd();
 		
 		
 		parameters[4] = employeeWorkExperience.getCompany();
 		
 		
 		parameters[5] = employeeWorkExperience.getDescription();
 		

 		return parameters;
 	}

	protected EmployeeWorkExperience saveInternalEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience, Map<String,Object> options){

		saveEmployeeWorkExperience(employeeWorkExperience);

 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeWorkExperience, options);
 		}
 
		
		return employeeWorkExperience;

	}



	//======================================================================================
	

 	protected EmployeeWorkExperience saveEmployee(EmployeeWorkExperience employeeWorkExperience, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeWorkExperience.getEmployee() == null){
 			return employeeWorkExperience;//do nothing when it is null
 		}

 		getEmployeeDAO().save(employeeWorkExperience.getEmployee(),options);
 		return employeeWorkExperience;

 	}





 

	

		

	public EmployeeWorkExperience present(EmployeeWorkExperience employeeWorkExperience,Map<String, Object> options){
	

		return employeeWorkExperience;
	
	}
		

	

	protected String getTableName(){
		return EmployeeWorkExperienceTable.TABLE_NAME;
	}



	public void enhanceList(List<EmployeeWorkExperience> employeeWorkExperienceList) {
		this.enhanceListInternal(employeeWorkExperienceList, this.getEmployeeWorkExperienceMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeWorkExperience> employeeWorkExperienceList = ownerEntity.collectRefsWithType(EmployeeWorkExperience.INTERNAL_TYPE);
		this.enhanceList(employeeWorkExperienceList);

	}

	@Override
	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getEmployeeWorkExperienceMapper());

	}
	@Override
	public int countEmployeeWorkExperienceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeWorkExperienceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<EmployeeWorkExperience> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeWorkExperienceMapper());
	}

  @Override
  public Stream<EmployeeWorkExperience> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEmployeeWorkExperienceMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeWorkExperience executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeWorkExperience result = new CandidateEmployeeWorkExperience();
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


