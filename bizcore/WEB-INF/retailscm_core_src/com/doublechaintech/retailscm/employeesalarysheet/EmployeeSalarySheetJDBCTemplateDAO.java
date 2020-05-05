
package com.doublechaintech.retailscm.employeesalarysheet;

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
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;

import com.doublechaintech.retailscm.salarygrade.SalaryGradeDAO;
import com.doublechaintech.retailscm.payingoff.PayingOffDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class EmployeeSalarySheetJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeSalarySheetDAO{

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

	protected SalaryGradeDAO salaryGradeDAO;
	public void setSalaryGradeDAO(SalaryGradeDAO salaryGradeDAO){
 	
 		if(salaryGradeDAO == null){
 			throw new IllegalStateException("Do not try to set salaryGradeDAO to null.");
 		}
	 	this.salaryGradeDAO = salaryGradeDAO;
 	}
 	public SalaryGradeDAO getSalaryGradeDAO(){
 		if(this.salaryGradeDAO == null){
 			throw new IllegalStateException("The salaryGradeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.salaryGradeDAO;
 	}	

	protected PayingOffDAO payingOffDAO;
	public void setPayingOffDAO(PayingOffDAO payingOffDAO){
 	
 		if(payingOffDAO == null){
 			throw new IllegalStateException("Do not try to set payingOffDAO to null.");
 		}
	 	this.payingOffDAO = payingOffDAO;
 	}
 	public PayingOffDAO getPayingOffDAO(){
 		if(this.payingOffDAO == null){
 			throw new IllegalStateException("The payingOffDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.payingOffDAO;
 	}	

	
	/*
	protected EmployeeSalarySheet load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeSalarySheet(accessKey, options);
	}
	*/
	
	public SmartList<EmployeeSalarySheet> loadAll() {
	    return this.loadAll(getEmployeeSalarySheetMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public EmployeeSalarySheet load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeSalarySheet(EmployeeSalarySheetTable.withId(id), options);
	}
	
	
	
	public EmployeeSalarySheet save(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options){
		
		String methodName="save(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeSalarySheet, methodName, "employeeSalarySheet");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeSalarySheet(employeeSalarySheet,options);
	}
	public EmployeeSalarySheet clone(String employeeSalarySheetId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeSalarySheetTable.withId(employeeSalarySheetId),options);
	}
	
	protected EmployeeSalarySheet clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeSalarySheetId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeSalarySheet newEmployeeSalarySheet = loadInternalEmployeeSalarySheet(accessKey, options);
		newEmployeeSalarySheet.setVersion(0);
		
		

		
		saveInternalEmployeeSalarySheet(newEmployeeSalarySheet,options);
		
		return newEmployeeSalarySheet;
	}
	
	
	
	

	protected void throwIfHasException(String employeeSalarySheetId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeSalarySheetVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeSalarySheetNotFoundException(
					"The " + this.getTableName() + "(" + employeeSalarySheetId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String employeeSalarySheetId, int version) throws Exception{
	
		String methodName="delete(String employeeSalarySheetId, int version)";
		assertMethodArgumentNotNull(employeeSalarySheetId, methodName, "employeeSalarySheetId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeSalarySheetId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeSalarySheetId,version);
		}
		
	
	}
	
	
	
	
	

	public EmployeeSalarySheet disconnectFromAll(String employeeSalarySheetId, int version) throws Exception{
	
		
		EmployeeSalarySheet employeeSalarySheet = loadInternalEmployeeSalarySheet(EmployeeSalarySheetTable.withId(employeeSalarySheetId), emptyOptions());
		employeeSalarySheet.clearFromAll();
		this.saveEmployeeSalarySheet(employeeSalarySheet);
		return employeeSalarySheet;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeSalarySheetTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_salary_sheet";
	}
	@Override
	protected String getBeanName() {
		
		return "employeeSalarySheet";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeSalarySheetTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSalarySheetTokens.EMPLOYEE);
 	}

 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSalarySheetTokens.EMPLOYEE);
 	}
 	

 	
  

 	protected boolean isExtractCurrentSalaryGradeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSalarySheetTokens.CURRENTSALARYGRADE);
 	}

 	protected boolean isSaveCurrentSalaryGradeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSalarySheetTokens.CURRENTSALARYGRADE);
 	}
 	

 	
  

 	protected boolean isExtractPayingOffEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSalarySheetTokens.PAYINGOFF);
 	}

 	protected boolean isSavePayingOffEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSalarySheetTokens.PAYINGOFF);
 	}
 	

 	
 
		

	

	protected EmployeeSalarySheetMapper getEmployeeSalarySheetMapper(){
		return new EmployeeSalarySheetMapper();
	}

	
	
	protected EmployeeSalarySheet extractEmployeeSalarySheet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeSalarySheet employeeSalarySheet = loadSingleObject(accessKey, getEmployeeSalarySheetMapper());
			return employeeSalarySheet;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeSalarySheetNotFoundException("EmployeeSalarySheet("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeeSalarySheet loadInternalEmployeeSalarySheet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeSalarySheet employeeSalarySheet = extractEmployeeSalarySheet(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeSalarySheet, loadOptions);
 		}
  	
 		if(isExtractCurrentSalaryGradeEnabled(loadOptions)){
	 		extractCurrentSalaryGrade(employeeSalarySheet, loadOptions);
 		}
  	
 		if(isExtractPayingOffEnabled(loadOptions)){
	 		extractPayingOff(employeeSalarySheet, loadOptions);
 		}
 
		
		return employeeSalarySheet;
		
	}

	 

 	protected EmployeeSalarySheet extractEmployee(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options) throws Exception{

		if(employeeSalarySheet.getEmployee() == null){
			return employeeSalarySheet;
		}
		String employeeId = employeeSalarySheet.getEmployee().getId();
		if( employeeId == null){
			return employeeSalarySheet;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeSalarySheet.setEmployee(employee);
		}
		
 		
 		return employeeSalarySheet;
 	}
 		
  

 	protected EmployeeSalarySheet extractCurrentSalaryGrade(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options) throws Exception{

		if(employeeSalarySheet.getCurrentSalaryGrade() == null){
			return employeeSalarySheet;
		}
		String currentSalaryGradeId = employeeSalarySheet.getCurrentSalaryGrade().getId();
		if( currentSalaryGradeId == null){
			return employeeSalarySheet;
		}
		SalaryGrade currentSalaryGrade = getSalaryGradeDAO().load(currentSalaryGradeId,options);
		if(currentSalaryGrade != null){
			employeeSalarySheet.setCurrentSalaryGrade(currentSalaryGrade);
		}
		
 		
 		return employeeSalarySheet;
 	}
 		
  

 	protected EmployeeSalarySheet extractPayingOff(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options) throws Exception{

		if(employeeSalarySheet.getPayingOff() == null){
			return employeeSalarySheet;
		}
		String payingOffId = employeeSalarySheet.getPayingOff().getId();
		if( payingOffId == null){
			return employeeSalarySheet;
		}
		PayingOff payingOff = getPayingOffDAO().load(payingOffId,options);
		if(payingOff != null){
			employeeSalarySheet.setPayingOff(payingOff);
		}
		
 		
 		return employeeSalarySheet;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId,Map<String,Object> options){
 	
  		SmartList<EmployeeSalarySheet> resultList = queryWith(EmployeeSalarySheetTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeSalarySheetMapper());
		// analyzeEmployeeSalarySheetByEmployee(resultList, employeeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeSalarySheet> resultList =  queryWithRange(EmployeeSalarySheetTable.COLUMN_EMPLOYEE, employeeId, options, getEmployeeSalarySheetMapper(), start, count);
 		//analyzeEmployeeSalarySheetByEmployee(resultList, employeeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeSalarySheetByEmployee(SmartList<EmployeeSalarySheet> resultList, String employeeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeSalarySheetByEmployee(String employeeId,Map<String,Object> options){

 		return countWith(EmployeeSalarySheetTable.COLUMN_EMPLOYEE, employeeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeSalarySheetByEmployeeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeSalarySheetTable.COLUMN_EMPLOYEE, ids, options);
	}
 	
  	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId,Map<String,Object> options){
 	
  		SmartList<EmployeeSalarySheet> resultList = queryWith(EmployeeSalarySheetTable.COLUMN_CURRENT_SALARY_GRADE, salaryGradeId, options, getEmployeeSalarySheetMapper());
		// analyzeEmployeeSalarySheetByCurrentSalaryGrade(resultList, salaryGradeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeSalarySheet> resultList =  queryWithRange(EmployeeSalarySheetTable.COLUMN_CURRENT_SALARY_GRADE, salaryGradeId, options, getEmployeeSalarySheetMapper(), start, count);
 		//analyzeEmployeeSalarySheetByCurrentSalaryGrade(resultList, salaryGradeId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeSalarySheetByCurrentSalaryGrade(SmartList<EmployeeSalarySheet> resultList, String salaryGradeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, salaryGradeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId,Map<String,Object> options){

 		return countWith(EmployeeSalarySheetTable.COLUMN_CURRENT_SALARY_GRADE, salaryGradeId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeSalarySheetByCurrentSalaryGradeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeSalarySheetTable.COLUMN_CURRENT_SALARY_GRADE, ids, options);
	}
 	
  	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId,Map<String,Object> options){
 	
  		SmartList<EmployeeSalarySheet> resultList = queryWith(EmployeeSalarySheetTable.COLUMN_PAYING_OFF, payingOffId, options, getEmployeeSalarySheetMapper());
		// analyzeEmployeeSalarySheetByPayingOff(resultList, payingOffId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId, int start, int count,Map<String,Object> options){
 		
 		SmartList<EmployeeSalarySheet> resultList =  queryWithRange(EmployeeSalarySheetTable.COLUMN_PAYING_OFF, payingOffId, options, getEmployeeSalarySheetMapper(), start, count);
 		//analyzeEmployeeSalarySheetByPayingOff(resultList, payingOffId, options);
 		return resultList;
 		
 	}
 	public void analyzeEmployeeSalarySheetByPayingOff(SmartList<EmployeeSalarySheet> resultList, String payingOffId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOffId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countEmployeeSalarySheetByPayingOff(String payingOffId,Map<String,Object> options){

 		return countWith(EmployeeSalarySheetTable.COLUMN_PAYING_OFF, payingOffId, options);
 	}
 	@Override
	public Map<String, Integer> countEmployeeSalarySheetByPayingOffIds(String[] ids, Map<String, Object> options) {
		return countWithIds(EmployeeSalarySheetTable.COLUMN_PAYING_OFF, ids, options);
	}
 	
 	
		
		
		

	

	protected EmployeeSalarySheet saveEmployeeSalarySheet(EmployeeSalarySheet  employeeSalarySheet){
		
		if(!employeeSalarySheet.isChanged()){
			return employeeSalarySheet;
		}
		
		
		String SQL=this.getSaveEmployeeSalarySheetSQL(employeeSalarySheet);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeSalarySheetParameters(employeeSalarySheet);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeSalarySheet.incVersion();
		return employeeSalarySheet;
	
	}
	public SmartList<EmployeeSalarySheet> saveEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeSalarySheetList(employeeSalarySheetList);
		
		batchEmployeeSalarySheetCreate((List<EmployeeSalarySheet>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeSalarySheetUpdate((List<EmployeeSalarySheet>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			if(employeeSalarySheet.isChanged()){
				employeeSalarySheet.incVersion();
			}
			
		
		}
		
		
		return employeeSalarySheetList;
	}

	public SmartList<EmployeeSalarySheet> removeEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options){
		
		
		super.removeList(employeeSalarySheetList, options);
		
		return employeeSalarySheetList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeSalarySheetBatchCreateArgs(List<EmployeeSalarySheet> employeeSalarySheetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList ){
			Object [] parameters = prepareEmployeeSalarySheetCreateParameters(employeeSalarySheet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeSalarySheetBatchUpdateArgs(List<EmployeeSalarySheet> employeeSalarySheetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList ){
			if(!employeeSalarySheet.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeSalarySheetUpdateParameters(employeeSalarySheet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeSalarySheetCreate(List<EmployeeSalarySheet> employeeSalarySheetList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeSalarySheetBatchCreateArgs(employeeSalarySheetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeSalarySheetUpdate(List<EmployeeSalarySheet> employeeSalarySheetList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeSalarySheetBatchUpdateArgs(employeeSalarySheetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeSalarySheetList(List<EmployeeSalarySheet> employeeSalarySheetList){
		
		List<EmployeeSalarySheet> employeeSalarySheetCreateList=new ArrayList<EmployeeSalarySheet>();
		List<EmployeeSalarySheet> employeeSalarySheetUpdateList=new ArrayList<EmployeeSalarySheet>();
		
		for(EmployeeSalarySheet employeeSalarySheet: employeeSalarySheetList){
			if(isUpdateRequest(employeeSalarySheet)){
				employeeSalarySheetUpdateList.add( employeeSalarySheet);
				continue;
			}
			employeeSalarySheetCreateList.add(employeeSalarySheet);
		}
		
		return new Object[]{employeeSalarySheetCreateList,employeeSalarySheetUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeSalarySheet employeeSalarySheet){
 		return employeeSalarySheet.getVersion() > 0;
 	}
 	protected String getSaveEmployeeSalarySheetSQL(EmployeeSalarySheet employeeSalarySheet){
 		if(isUpdateRequest(employeeSalarySheet)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeSalarySheetParameters(EmployeeSalarySheet employeeSalarySheet){
 		if(isUpdateRequest(employeeSalarySheet) ){
 			return prepareEmployeeSalarySheetUpdateParameters(employeeSalarySheet);
 		}
 		return prepareEmployeeSalarySheetCreateParameters(employeeSalarySheet);
 	}
 	protected Object[] prepareEmployeeSalarySheetUpdateParameters(EmployeeSalarySheet employeeSalarySheet){
 		Object[] parameters = new Object[13];
  	
 		if(employeeSalarySheet.getEmployee() != null){
 			parameters[0] = employeeSalarySheet.getEmployee().getId();
 		}
  	
 		if(employeeSalarySheet.getCurrentSalaryGrade() != null){
 			parameters[1] = employeeSalarySheet.getCurrentSalaryGrade().getId();
 		}
 
 		
 		parameters[2] = employeeSalarySheet.getBaseSalary();
 		
 		
 		parameters[3] = employeeSalarySheet.getBonus();
 		
 		
 		parameters[4] = employeeSalarySheet.getReward();
 		
 		
 		parameters[5] = employeeSalarySheet.getPersonalTax();
 		
 		
 		parameters[6] = employeeSalarySheet.getSocialSecurity();
 		
 		
 		parameters[7] = employeeSalarySheet.getHousingFound();
 		
 		
 		parameters[8] = employeeSalarySheet.getJobInsurance();
 		 	
 		if(employeeSalarySheet.getPayingOff() != null){
 			parameters[9] = employeeSalarySheet.getPayingOff().getId();
 		}
 		
 		parameters[10] = employeeSalarySheet.nextVersion();
 		parameters[11] = employeeSalarySheet.getId();
 		parameters[12] = employeeSalarySheet.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeSalarySheetCreateParameters(EmployeeSalarySheet employeeSalarySheet){
		Object[] parameters = new Object[11];
		String newEmployeeSalarySheetId=getNextId();
		employeeSalarySheet.setId(newEmployeeSalarySheetId);
		parameters[0] =  employeeSalarySheet.getId();
  	
 		if(employeeSalarySheet.getEmployee() != null){
 			parameters[1] = employeeSalarySheet.getEmployee().getId();
 		
 		}
 		 	
 		if(employeeSalarySheet.getCurrentSalaryGrade() != null){
 			parameters[2] = employeeSalarySheet.getCurrentSalaryGrade().getId();
 		
 		}
 		
 		
 		parameters[3] = employeeSalarySheet.getBaseSalary();
 		
 		
 		parameters[4] = employeeSalarySheet.getBonus();
 		
 		
 		parameters[5] = employeeSalarySheet.getReward();
 		
 		
 		parameters[6] = employeeSalarySheet.getPersonalTax();
 		
 		
 		parameters[7] = employeeSalarySheet.getSocialSecurity();
 		
 		
 		parameters[8] = employeeSalarySheet.getHousingFound();
 		
 		
 		parameters[9] = employeeSalarySheet.getJobInsurance();
 		 	
 		if(employeeSalarySheet.getPayingOff() != null){
 			parameters[10] = employeeSalarySheet.getPayingOff().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected EmployeeSalarySheet saveInternalEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options){
		
		saveEmployeeSalarySheet(employeeSalarySheet);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeSalarySheet, options);
 		}
  	
 		if(isSaveCurrentSalaryGradeEnabled(options)){
	 		saveCurrentSalaryGrade(employeeSalarySheet, options);
 		}
  	
 		if(isSavePayingOffEnabled(options)){
	 		savePayingOff(employeeSalarySheet, options);
 		}
 
		
		return employeeSalarySheet;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeSalarySheet saveEmployee(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSalarySheet.getEmployee() == null){
 			return employeeSalarySheet;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeSalarySheet.getEmployee(),options);
 		return employeeSalarySheet;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeSalarySheet saveCurrentSalaryGrade(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSalarySheet.getCurrentSalaryGrade() == null){
 			return employeeSalarySheet;//do nothing when it is null
 		}
 		
 		getSalaryGradeDAO().save(employeeSalarySheet.getCurrentSalaryGrade(),options);
 		return employeeSalarySheet;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeSalarySheet savePayingOff(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSalarySheet.getPayingOff() == null){
 			return employeeSalarySheet;//do nothing when it is null
 		}
 		
 		getPayingOffDAO().save(employeeSalarySheet.getPayingOff(),options);
 		return employeeSalarySheet;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public EmployeeSalarySheet present(EmployeeSalarySheet employeeSalarySheet,Map<String, Object> options){
	

		return employeeSalarySheet;
	
	}
		

	

	protected String getTableName(){
		return EmployeeSalarySheetTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<EmployeeSalarySheet> employeeSalarySheetList) {		
		this.enhanceListInternal(employeeSalarySheetList, this.getEmployeeSalarySheetMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeSalarySheet> employeeSalarySheetList = ownerEntity.collectRefsWithType(EmployeeSalarySheet.INTERNAL_TYPE);
		this.enhanceList(employeeSalarySheetList);
		
	}
	
	@Override
	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getEmployeeSalarySheetMapper());

	}
	@Override
	public int countEmployeeSalarySheetWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeSalarySheetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<EmployeeSalarySheet> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeSalarySheetMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateEmployeeSalarySheet executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateEmployeeSalarySheet result = new CandidateEmployeeSalarySheet();
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


