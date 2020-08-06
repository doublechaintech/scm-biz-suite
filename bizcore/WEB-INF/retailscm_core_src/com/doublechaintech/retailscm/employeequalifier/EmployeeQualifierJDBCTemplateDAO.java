
package com.doublechaintech.retailscm.employeequalifier;

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

public class EmployeeQualifierJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeQualifierDAO{

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
	protected EmployeeQualifier load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeQualifier(accessKey, options);
	}
	*/

	public SmartList<EmployeeQualifier> loadAll() {
	    return this.loadAll(getEmployeeQualifierMapper());
	}

  public Stream<EmployeeQualifier> loadAllAsStream() {
      return this.loadAllAsStream(getEmployeeQualifierMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public EmployeeQualifier load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeQualifier(EmployeeQualifierTable.withId(id), options);
	}

	

	public EmployeeQualifier save(EmployeeQualifier employeeQualifier,Map<String,Object> options){

		String methodName="save(EmployeeQualifier employeeQualifier,Map<String,Object> options)";

		assertMethodArgumentNotNull(employeeQualifier, methodName, "employeeQualifier");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalEmployeeQualifier(employeeQualifier,options);
	}
	public EmployeeQualifier clone(String employeeQualifierId, Map<String,Object> options) throws Exception{

		return clone(EmployeeQualifierTable.withId(employeeQualifierId),options);
	}

	protected EmployeeQualifier clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String employeeQualifierId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		EmployeeQualifier newEmployeeQualifier = loadInternalEmployeeQualifier(accessKey, options);
		newEmployeeQualifier.setVersion(0);
		
		


		saveInternalEmployeeQualifier(newEmployeeQualifier,options);

		return newEmployeeQualifier;
	}

	



	protected void throwIfHasException(String employeeQualifierId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeQualifierVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeQualifierNotFoundException(
					"The " + this.getTableName() + "(" + employeeQualifierId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String employeeQualifierId, int version) throws Exception{

		String methodName="delete(String employeeQualifierId, int version)";
		assertMethodArgumentNotNull(employeeQualifierId, methodName, "employeeQualifierId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeQualifierId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeQualifierId,version);
		}


	}






	public EmployeeQualifier disconnectFromAll(String employeeQualifierId, int version) throws Exception{


		EmployeeQualifier employeeQualifier = loadInternalEmployeeQualifier(EmployeeQualifierTable.withId(employeeQualifierId), emptyOptions());
		employeeQualifier.clearFromAll();
		this.saveEmployeeQualifier(employeeQualifier);
		return employeeQualifier;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeQualifierTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "employee_qualifier";
	}
	@Override
	protected String getBeanName() {

		return "employeeQualifier";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeQualifierTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeQualifierTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeQualifierTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeeQualifierMapper getEmployeeQualifierMapper(){
		return new EmployeeQualifierMapper();
	}

	
	
	protected EmployeeQualifier extractEmployeeQualifier(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeQualifier employeeQualifier = loadSingleObject(accessKey, getEmployeeQualifierMapper());
			return employeeQualifier;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeQualifierNotFoundException("EmployeeQualifier("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeeQualifier loadInternalEmployeeQualifier(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeQualifier employeeQualifier = extractEmployeeQualifier(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeQualifier, loadOptions);
 		}
 
		
		return employeeQualifier;
		
	}

	 

 	protected EmployeeQualifier extractEmployee(EmployeeQualifier employeeQualifier, Map<String,Object> options) throws Exception{

		if(employeeQualifier.getEmployee() == null){
			return employeeQualifier;
		}
		String employeeId = employeeQualifier.getEmployee().getId();
		if( employeeId == null){
			return employeeQualifier;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeQualifier.setEmployee(employee);
		}
		
 		
 		return employeeQualifier;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeQualifier> findEmployeeQualifierByEmployee(String employeeId,Map<String,Object> options){
 	
  		SmartList<EmployeeQualifier> resultList = queryWith(EmployeeQualifierTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeQualifierMapper());
		// analyzeEmployeeQualifierByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeQualifier> findEmployeeQualifierByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeQualifier> resultList =  queryWithRange(EmployeeQualifierTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeQualifierMapper(), start, count);
 		//analyzeEmployeeQualifierByEmployee(resultList, employeeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeQualifierByEmployee(SmartList<EmployeeQualifier> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countEmployeeQualifierByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeQualifierTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeQualifierByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeQualifierTable.COLUMN_EMPLOYEE, ids, options);
	}
 	
 	
		
		
		

	

	protected EmployeeQualifier saveEmployeeQualifier(EmployeeQualifier  employeeQualifier){
		
		if(!employeeQualifier.isChanged()){
			return employeeQualifier;
		}
		

		String SQL=this.getSaveEmployeeQualifierSQL(employeeQualifier);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeQualifierParameters(employeeQualifier);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		employeeQualifier.incVersion();
		return employeeQualifier;

	}
	public SmartList<EmployeeQualifier> saveEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeQualifierList(employeeQualifierList);

		batchEmployeeQualifierCreate((List<EmployeeQualifier>)lists[CREATE_LIST_INDEX]);

		batchEmployeeQualifierUpdate((List<EmployeeQualifier>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(EmployeeQualifier employeeQualifier:employeeQualifierList){
			if(employeeQualifier.isChanged()){
				employeeQualifier.incVersion();
			}


		}


		return employeeQualifierList;
	}

	public SmartList<EmployeeQualifier> removeEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList,Map<String,Object> options){


		super.removeList(employeeQualifierList, options);

		return employeeQualifierList;


	}

	protected List<Object[]> prepareEmployeeQualifierBatchCreateArgs(List<EmployeeQualifier> employeeQualifierList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeQualifier employeeQualifier:employeeQualifierList ){
			Object [] parameters = prepareEmployeeQualifierCreateParameters(employeeQualifier);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareEmployeeQualifierBatchUpdateArgs(List<EmployeeQualifier> employeeQualifierList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeQualifier employeeQualifier:employeeQualifierList ){
			if(!employeeQualifier.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeQualifierUpdateParameters(employeeQualifier);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchEmployeeQualifierCreate(List<EmployeeQualifier> employeeQualifierList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeQualifierBatchCreateArgs(employeeQualifierList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchEmployeeQualifierUpdate(List<EmployeeQualifier> employeeQualifierList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeQualifierBatchUpdateArgs(employeeQualifierList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitEmployeeQualifierList(List<EmployeeQualifier> employeeQualifierList){

		List<EmployeeQualifier> employeeQualifierCreateList=new ArrayList<EmployeeQualifier>();
		List<EmployeeQualifier> employeeQualifierUpdateList=new ArrayList<EmployeeQualifier>();

		for(EmployeeQualifier employeeQualifier: employeeQualifierList){
			if(isUpdateRequest(employeeQualifier)){
				employeeQualifierUpdateList.add( employeeQualifier);
				continue;
			}
			employeeQualifierCreateList.add(employeeQualifier);
		}

		return new Object[]{employeeQualifierCreateList,employeeQualifierUpdateList};
	}

	protected boolean isUpdateRequest(EmployeeQualifier employeeQualifier){
 		return employeeQualifier.getVersion() > 0;
 	}
 	protected String getSaveEmployeeQualifierSQL(EmployeeQualifier employeeQualifier){
 		if(isUpdateRequest(employeeQualifier)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveEmployeeQualifierParameters(EmployeeQualifier employeeQualifier){
 		if(isUpdateRequest(employeeQualifier) ){
 			return prepareEmployeeQualifierUpdateParameters(employeeQualifier);
 		}
 		return prepareEmployeeQualifierCreateParameters(employeeQualifier);
 	}
 	protected Object[] prepareEmployeeQualifierUpdateParameters(EmployeeQualifier employeeQualifier){
 		Object[] parameters = new Object[8];
 
 		if(employeeQualifier.getEmployee() != null){
 			parameters[0] = employeeQualifier.getEmployee().getId();
 		}
 
 		
 		parameters[1] = employeeQualifier.getQualifiedTime();
 		
 		
 		parameters[2] = employeeQualifier.getType();
 		
 		
 		parameters[3] = employeeQualifier.getLevel();
 		
 		
 		parameters[4] = employeeQualifier.getRemark();
 		
 		parameters[5] = employeeQualifier.nextVersion();
 		parameters[6] = employeeQualifier.getId();
 		parameters[7] = employeeQualifier.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareEmployeeQualifierCreateParameters(EmployeeQualifier employeeQualifier){
		Object[] parameters = new Object[6];
        if(employeeQualifier.getId() == null){
          String newEmployeeQualifierId=getNextId();
          employeeQualifier.setId(newEmployeeQualifierId);
        }
		parameters[0] =  employeeQualifier.getId();
 
 		if(employeeQualifier.getEmployee() != null){
 			parameters[1] = employeeQualifier.getEmployee().getId();

 		}
 		
 		
 		parameters[2] = employeeQualifier.getQualifiedTime();
 		
 		
 		parameters[3] = employeeQualifier.getType();
 		
 		
 		parameters[4] = employeeQualifier.getLevel();
 		
 		
 		parameters[5] = employeeQualifier.getRemark();
 		

 		return parameters;
 	}

	protected EmployeeQualifier saveInternalEmployeeQualifier(EmployeeQualifier employeeQualifier, Map<String,Object> options){

		saveEmployeeQualifier(employeeQualifier);

 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeQualifier, options);
 		}
 
		
		return employeeQualifier;

	}



	//======================================================================================
	

 	protected EmployeeQualifier saveEmployee(EmployeeQualifier employeeQualifier, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeQualifier.getEmployee() == null){
 			return employeeQualifier;//do nothing when it is null
 		}

 		getEmployeeDAO().save(employeeQualifier.getEmployee(),options);
 		return employeeQualifier;

 	}





 

	

		

	public EmployeeQualifier present(EmployeeQualifier employeeQualifier,Map<String, Object> options){
	

		return employeeQualifier;
	
	}
		

	

	protected String getTableName(){
		return EmployeeQualifierTable.TABLE_NAME;
	}



	public void enhanceList(List<EmployeeQualifier> employeeQualifierList) {
		this.enhanceListInternal(employeeQualifierList, this.getEmployeeQualifierMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeQualifier> employeeQualifierList = ownerEntity.collectRefsWithType(EmployeeQualifier.INTERNAL_TYPE);
		this.enhanceList(employeeQualifierList);

	}

	@Override
	public SmartList<EmployeeQualifier> findEmployeeQualifierWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getEmployeeQualifierMapper());

	}
	@Override
	public int countEmployeeQualifierWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeQualifierWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<EmployeeQualifier> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeQualifierMapper());
	}

  @Override
  public Stream<EmployeeQualifier> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEmployeeQualifierMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeQualifier executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeQualifier result = new CandidateEmployeeQualifier();
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


