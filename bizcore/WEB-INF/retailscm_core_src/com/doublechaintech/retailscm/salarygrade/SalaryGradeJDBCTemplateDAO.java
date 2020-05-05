
package com.doublechaintech.retailscm.salarygrade;

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
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class SalaryGradeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SalaryGradeDAO{

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

	protected EmployeeSalarySheetDAO employeeSalarySheetDAO;
	public void setEmployeeSalarySheetDAO(EmployeeSalarySheetDAO employeeSalarySheetDAO){
 	
 		if(employeeSalarySheetDAO == null){
 			throw new IllegalStateException("Do not try to set employeeSalarySheetDAO to null.");
 		}
	 	this.employeeSalarySheetDAO = employeeSalarySheetDAO;
 	}
 	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO(){
 		if(this.employeeSalarySheetDAO == null){
 			throw new IllegalStateException("The employeeSalarySheetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeSalarySheetDAO;
 	}	

	
	/*
	protected SalaryGrade load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSalaryGrade(accessKey, options);
	}
	*/
	
	public SmartList<SalaryGrade> loadAll() {
	    return this.loadAll(getSalaryGradeMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SalaryGrade load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSalaryGrade(SalaryGradeTable.withId(id), options);
	}
	
	
	
	public SalaryGrade save(SalaryGrade salaryGrade,Map<String,Object> options){
		
		String methodName="save(SalaryGrade salaryGrade,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(salaryGrade, methodName, "salaryGrade");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSalaryGrade(salaryGrade,options);
	}
	public SalaryGrade clone(String salaryGradeId, Map<String,Object> options) throws Exception{
	
		return clone(SalaryGradeTable.withId(salaryGradeId),options);
	}
	
	protected SalaryGrade clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String salaryGradeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SalaryGrade newSalaryGrade = loadInternalSalaryGrade(accessKey, options);
		newSalaryGrade.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newSalaryGrade.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeSalarySheetListEnabled(options)){
 			for(EmployeeSalarySheet item: newSalaryGrade.getEmployeeSalarySheetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSalaryGrade(newSalaryGrade,options);
		
		return newSalaryGrade;
	}
	
	
	
	

	protected void throwIfHasException(String salaryGradeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SalaryGradeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SalaryGradeNotFoundException(
					"The " + this.getTableName() + "(" + salaryGradeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String salaryGradeId, int version) throws Exception{
	
		String methodName="delete(String salaryGradeId, int version)";
		assertMethodArgumentNotNull(salaryGradeId, methodName, "salaryGradeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{salaryGradeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(salaryGradeId,version);
		}
		
	
	}
	
	
	
	
	

	public SalaryGrade disconnectFromAll(String salaryGradeId, int version) throws Exception{
	
		
		SalaryGrade salaryGrade = loadInternalSalaryGrade(SalaryGradeTable.withId(salaryGradeId), emptyOptions());
		salaryGrade.clearFromAll();
		this.saveSalaryGrade(salaryGrade);
		return salaryGrade;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SalaryGradeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "salary_grade";
	}
	@Override
	protected String getBeanName() {
		
		return "salaryGrade";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SalaryGradeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SalaryGradeTokens.COMPANY);
 	}

 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SalaryGradeTokens.COMPANY);
 	}
 	

 	
 
		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SalaryGradeTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){		 		
 		return SalaryGradeTokens.of(options).analyzeEmployeeListEnabled();
 	}
	
	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, SalaryGradeTokens.EMPLOYEE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractEmployeeSalarySheetListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SalaryGradeTokens.EMPLOYEE_SALARY_SHEET_LIST);
 	}
 	protected boolean isAnalyzeEmployeeSalarySheetListEnabled(Map<String,Object> options){		 		
 		return SalaryGradeTokens.of(options).analyzeEmployeeSalarySheetListEnabled();
 	}
	
	protected boolean isSaveEmployeeSalarySheetListEnabled(Map<String,Object> options){
		return checkOptions(options, SalaryGradeTokens.EMPLOYEE_SALARY_SHEET_LIST);
		
 	}
 	
		

	

	protected SalaryGradeMapper getSalaryGradeMapper(){
		return new SalaryGradeMapper();
	}

	
	
	protected SalaryGrade extractSalaryGrade(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SalaryGrade salaryGrade = loadSingleObject(accessKey, getSalaryGradeMapper());
			return salaryGrade;
		}catch(EmptyResultDataAccessException e){
			throw new SalaryGradeNotFoundException("SalaryGrade("+accessKey+") is not found!");
		}

	}

	
	

	protected SalaryGrade loadInternalSalaryGrade(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SalaryGrade salaryGrade = extractSalaryGrade(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(salaryGrade, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(salaryGrade, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(salaryGrade, loadOptions);
 		}
 		
		
		if(isExtractEmployeeSalarySheetListEnabled(loadOptions)){
	 		extractEmployeeSalarySheetList(salaryGrade, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeEmployeeSalarySheetListEnabled(loadOptions)){
	 		analyzeEmployeeSalarySheetList(salaryGrade, loadOptions);
 		}
 		
		
		return salaryGrade;
		
	}

	 

 	protected SalaryGrade extractCompany(SalaryGrade salaryGrade, Map<String,Object> options) throws Exception{

		if(salaryGrade.getCompany() == null){
			return salaryGrade;
		}
		String companyId = salaryGrade.getCompany().getId();
		if( companyId == null){
			return salaryGrade;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			salaryGrade.setCompany(company);
		}
		
 		
 		return salaryGrade;
 	}
 		
 
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SalaryGrade extractEmployeeList(SalaryGrade salaryGrade, Map<String,Object> options){
		
		
		if(salaryGrade == null){
			return null;
		}
		if(salaryGrade.getId() == null){
			return salaryGrade;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByCurrentSalaryGrade(salaryGrade.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			salaryGrade.setEmployeeList(employeeList);
		}
		
		return salaryGrade;
	
	}	
	
	protected SalaryGrade analyzeEmployeeList(SalaryGrade salaryGrade, Map<String,Object> options){
		
		
		if(salaryGrade == null){
			return null;
		}
		if(salaryGrade.getId() == null){
			return salaryGrade;
		}

		
		
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByCurrentSalaryGrade(employeeList, salaryGrade.getId(), options);
			
		}
		
		return salaryGrade;
	
	}	
	
		
	protected void enhanceEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SalaryGrade extractEmployeeSalarySheetList(SalaryGrade salaryGrade, Map<String,Object> options){
		
		
		if(salaryGrade == null){
			return null;
		}
		if(salaryGrade.getId() == null){
			return salaryGrade;
		}

		
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = getEmployeeSalarySheetDAO().findEmployeeSalarySheetByCurrentSalaryGrade(salaryGrade.getId(),options);
		if(employeeSalarySheetList != null){
			enhanceEmployeeSalarySheetList(employeeSalarySheetList,options);
			salaryGrade.setEmployeeSalarySheetList(employeeSalarySheetList);
		}
		
		return salaryGrade;
	
	}	
	
	protected SalaryGrade analyzeEmployeeSalarySheetList(SalaryGrade salaryGrade, Map<String,Object> options){
		
		
		if(salaryGrade == null){
			return null;
		}
		if(salaryGrade.getId() == null){
			return salaryGrade;
		}

		
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();
		if(employeeSalarySheetList != null){
			getEmployeeSalarySheetDAO().analyzeEmployeeSalarySheetByCurrentSalaryGrade(employeeSalarySheetList, salaryGrade.getId(), options);
			
		}
		
		return salaryGrade;
	
	}	
	
		
		
  	
 	public SmartList<SalaryGrade> findSalaryGradeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<SalaryGrade> resultList = queryWith(SalaryGradeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getSalaryGradeMapper());
		// analyzeSalaryGradeByCompany(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SalaryGrade> findSalaryGradeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SalaryGrade> resultList =  queryWithRange(SalaryGradeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getSalaryGradeMapper(), start, count);
 		//analyzeSalaryGradeByCompany(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeSalaryGradeByCompany(SmartList<SalaryGrade> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countSalaryGradeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(SalaryGradeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countSalaryGradeByCompanyIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SalaryGradeTable.COLUMN_COMPANY, ids, options);
	}
 	
 	
		
		
		

	

	protected SalaryGrade saveSalaryGrade(SalaryGrade  salaryGrade){
		
		if(!salaryGrade.isChanged()){
			return salaryGrade;
		}
		
		
		String SQL=this.getSaveSalaryGradeSQL(salaryGrade);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSalaryGradeParameters(salaryGrade);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		salaryGrade.incVersion();
		return salaryGrade;
	
	}
	public SmartList<SalaryGrade> saveSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSalaryGradeList(salaryGradeList);
		
		batchSalaryGradeCreate((List<SalaryGrade>)lists[CREATE_LIST_INDEX]);
		
		batchSalaryGradeUpdate((List<SalaryGrade>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SalaryGrade salaryGrade:salaryGradeList){
			if(salaryGrade.isChanged()){
				salaryGrade.incVersion();
			}
			
		
		}
		
		
		return salaryGradeList;
	}

	public SmartList<SalaryGrade> removeSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options){
		
		
		super.removeList(salaryGradeList, options);
		
		return salaryGradeList;
		
		
	}
	
	protected List<Object[]> prepareSalaryGradeBatchCreateArgs(List<SalaryGrade> salaryGradeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SalaryGrade salaryGrade:salaryGradeList ){
			Object [] parameters = prepareSalaryGradeCreateParameters(salaryGrade);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSalaryGradeBatchUpdateArgs(List<SalaryGrade> salaryGradeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SalaryGrade salaryGrade:salaryGradeList ){
			if(!salaryGrade.isChanged()){
				continue;
			}
			Object [] parameters = prepareSalaryGradeUpdateParameters(salaryGrade);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSalaryGradeCreate(List<SalaryGrade> salaryGradeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSalaryGradeBatchCreateArgs(salaryGradeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSalaryGradeUpdate(List<SalaryGrade> salaryGradeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSalaryGradeBatchUpdateArgs(salaryGradeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSalaryGradeList(List<SalaryGrade> salaryGradeList){
		
		List<SalaryGrade> salaryGradeCreateList=new ArrayList<SalaryGrade>();
		List<SalaryGrade> salaryGradeUpdateList=new ArrayList<SalaryGrade>();
		
		for(SalaryGrade salaryGrade: salaryGradeList){
			if(isUpdateRequest(salaryGrade)){
				salaryGradeUpdateList.add( salaryGrade);
				continue;
			}
			salaryGradeCreateList.add(salaryGrade);
		}
		
		return new Object[]{salaryGradeCreateList,salaryGradeUpdateList};
	}
	
	protected boolean isUpdateRequest(SalaryGrade salaryGrade){
 		return salaryGrade.getVersion() > 0;
 	}
 	protected String getSaveSalaryGradeSQL(SalaryGrade salaryGrade){
 		if(isUpdateRequest(salaryGrade)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSalaryGradeParameters(SalaryGrade salaryGrade){
 		if(isUpdateRequest(salaryGrade) ){
 			return prepareSalaryGradeUpdateParameters(salaryGrade);
 		}
 		return prepareSalaryGradeCreateParameters(salaryGrade);
 	}
 	protected Object[] prepareSalaryGradeUpdateParameters(SalaryGrade salaryGrade){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = salaryGrade.getCode();
 		 	
 		if(salaryGrade.getCompany() != null){
 			parameters[1] = salaryGrade.getCompany().getId();
 		}
 
 		
 		parameters[2] = salaryGrade.getName();
 		
 		
 		parameters[3] = salaryGrade.getDetailDescription();
 				
 		parameters[4] = salaryGrade.nextVersion();
 		parameters[5] = salaryGrade.getId();
 		parameters[6] = salaryGrade.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSalaryGradeCreateParameters(SalaryGrade salaryGrade){
		Object[] parameters = new Object[5];
		String newSalaryGradeId=getNextId();
		salaryGrade.setId(newSalaryGradeId);
		parameters[0] =  salaryGrade.getId();
 
 		
 		parameters[1] = salaryGrade.getCode();
 		 	
 		if(salaryGrade.getCompany() != null){
 			parameters[2] = salaryGrade.getCompany().getId();
 		
 		}
 		
 		
 		parameters[3] = salaryGrade.getName();
 		
 		
 		parameters[4] = salaryGrade.getDetailDescription();
 				
 				
 		return parameters;
 	}
 	
	protected SalaryGrade saveInternalSalaryGrade(SalaryGrade salaryGrade, Map<String,Object> options){
		
		saveSalaryGrade(salaryGrade);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(salaryGrade, options);
 		}
 
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(salaryGrade, options);
	 		//removeEmployeeList(salaryGrade, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveEmployeeSalarySheetListEnabled(options)){
	 		saveEmployeeSalarySheetList(salaryGrade, options);
	 		//removeEmployeeSalarySheetList(salaryGrade, options);
	 		//Not delete the record
	 		
 		}		
		
		return salaryGrade;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SalaryGrade saveCompany(SalaryGrade salaryGrade, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(salaryGrade.getCompany() == null){
 			return salaryGrade;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(salaryGrade.getCompany(),options);
 		return salaryGrade;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public SalaryGrade planToRemoveEmployeeList(SalaryGrade salaryGrade, String employeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGrade.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return salaryGrade;
		}
		if(externalEmployeeList.isEmpty()){
			return salaryGrade;
		}
		
		for(Employee employeeItem: externalEmployeeList){

			employeeItem.clearFromAll();
		}
		
		
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return salaryGrade;	
	
	}


	//disconnect SalaryGrade with company in Employee
	public SalaryGrade planToRemoveEmployeeListWithCompany(SalaryGrade salaryGrade, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGrade.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return salaryGrade;
		}
		if(externalEmployeeList.isEmpty()){
			return salaryGrade;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCompany();
			employeeItem.clearCurrentSalaryGrade();
			
		}
		
		
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return salaryGrade;
	}
	
	public int countEmployeeListWithCompany(String salaryGradeId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGradeId);
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect SalaryGrade with department in Employee
	public SalaryGrade planToRemoveEmployeeListWithDepartment(SalaryGrade salaryGrade, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGrade.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return salaryGrade;
		}
		if(externalEmployeeList.isEmpty()){
			return salaryGrade;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearDepartment();
			employeeItem.clearCurrentSalaryGrade();
			
		}
		
		
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return salaryGrade;
	}
	
	public int countEmployeeListWithDepartment(String salaryGradeId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGradeId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect SalaryGrade with occupation in Employee
	public SalaryGrade planToRemoveEmployeeListWithOccupation(SalaryGrade salaryGrade, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGrade.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return salaryGrade;
		}
		if(externalEmployeeList.isEmpty()){
			return salaryGrade;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearOccupation();
			employeeItem.clearCurrentSalaryGrade();
			
		}
		
		
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return salaryGrade;
	}
	
	public int countEmployeeListWithOccupation(String salaryGradeId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGradeId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect SalaryGrade with responsible_for in Employee
	public SalaryGrade planToRemoveEmployeeListWithResponsibleFor(SalaryGrade salaryGrade, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGrade.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return salaryGrade;
		}
		if(externalEmployeeList.isEmpty()){
			return salaryGrade;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearResponsibleFor();
			employeeItem.clearCurrentSalaryGrade();
			
		}
		
		
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return salaryGrade;
	}
	
	public int countEmployeeListWithResponsibleFor(String salaryGradeId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGradeId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	public SalaryGrade planToRemoveEmployeeSalarySheetList(SalaryGrade salaryGrade, String employeeSalarySheetIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, salaryGrade.getId());
		key.put(EmployeeSalarySheet.ID_PROPERTY, employeeSalarySheetIds);
		
		SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList = getEmployeeSalarySheetDAO().
				findEmployeeSalarySheetWithKey(key, options);
		if(externalEmployeeSalarySheetList == null){
			return salaryGrade;
		}
		if(externalEmployeeSalarySheetList.isEmpty()){
			return salaryGrade;
		}
		
		for(EmployeeSalarySheet employeeSalarySheetItem: externalEmployeeSalarySheetList){

			employeeSalarySheetItem.clearFromAll();
		}
		
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();		
		employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
		return salaryGrade;	
	
	}


	//disconnect SalaryGrade with employee in EmployeeSalarySheet
	public SalaryGrade planToRemoveEmployeeSalarySheetListWithEmployee(SalaryGrade salaryGrade, String employeeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, salaryGrade.getId());
		key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeId);
		
		SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList = getEmployeeSalarySheetDAO().
				findEmployeeSalarySheetWithKey(key, options);
		if(externalEmployeeSalarySheetList == null){
			return salaryGrade;
		}
		if(externalEmployeeSalarySheetList.isEmpty()){
			return salaryGrade;
		}
		
		for(EmployeeSalarySheet employeeSalarySheetItem: externalEmployeeSalarySheetList){
			employeeSalarySheetItem.clearEmployee();
			employeeSalarySheetItem.clearCurrentSalaryGrade();
			
		}
		
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();		
		employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
		return salaryGrade;
	}
	
	public int countEmployeeSalarySheetListWithEmployee(String salaryGradeId, String employeeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, salaryGradeId);
		key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeId);
		
		int count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetWithKey(key, options);
		return count;
	}
	
	//disconnect SalaryGrade with paying_off in EmployeeSalarySheet
	public SalaryGrade planToRemoveEmployeeSalarySheetListWithPayingOff(SalaryGrade salaryGrade, String payingOffId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, salaryGrade.getId());
		key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOffId);
		
		SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList = getEmployeeSalarySheetDAO().
				findEmployeeSalarySheetWithKey(key, options);
		if(externalEmployeeSalarySheetList == null){
			return salaryGrade;
		}
		if(externalEmployeeSalarySheetList.isEmpty()){
			return salaryGrade;
		}
		
		for(EmployeeSalarySheet employeeSalarySheetItem: externalEmployeeSalarySheetList){
			employeeSalarySheetItem.clearPayingOff();
			employeeSalarySheetItem.clearCurrentSalaryGrade();
			
		}
		
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();		
		employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
		return salaryGrade;
	}
	
	public int countEmployeeSalarySheetListWithPayingOff(String salaryGradeId, String payingOffId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, salaryGradeId);
		key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOffId);
		
		int count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetWithKey(key, options);
		return count;
	}
	

		
	protected SalaryGrade saveEmployeeList(SalaryGrade salaryGrade, Map<String,Object> options){
		
		
		
		
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return salaryGrade;
		}
		SmartList<Employee> mergedUpdateEmployeeList = new SmartList<Employee>();
		
		
		mergedUpdateEmployeeList.addAll(employeeList); 
		if(employeeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEmployeeList.addAll(employeeList.getToRemoveList());
			employeeList.removeAll(employeeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getEmployeeDAO().saveEmployeeList(mergedUpdateEmployeeList,options);
		
		if(employeeList.getToRemoveList() != null){
			employeeList.removeAll(employeeList.getToRemoveList());
		}
		
		
		return salaryGrade;
	
	}
	
	protected SalaryGrade removeEmployeeList(SalaryGrade salaryGrade, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();
		if(employeeList == null){
			return salaryGrade;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return salaryGrade;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return salaryGrade;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return salaryGrade;
	
	}
	
	

 	
 	
	
	
	
		
	protected SalaryGrade saveEmployeeSalarySheetList(SalaryGrade salaryGrade, Map<String,Object> options){
		
		
		
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();
		if(employeeSalarySheetList == null){
			//null list means nothing
			return salaryGrade;
		}
		SmartList<EmployeeSalarySheet> mergedUpdateEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();
		
		
		mergedUpdateEmployeeSalarySheetList.addAll(employeeSalarySheetList); 
		if(employeeSalarySheetList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEmployeeSalarySheetList.addAll(employeeSalarySheetList.getToRemoveList());
			employeeSalarySheetList.removeAll(employeeSalarySheetList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getEmployeeSalarySheetDAO().saveEmployeeSalarySheetList(mergedUpdateEmployeeSalarySheetList,options);
		
		if(employeeSalarySheetList.getToRemoveList() != null){
			employeeSalarySheetList.removeAll(employeeSalarySheetList.getToRemoveList());
		}
		
		
		return salaryGrade;
	
	}
	
	protected SalaryGrade removeEmployeeSalarySheetList(SalaryGrade salaryGrade, Map<String,Object> options){
	
	
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();
		if(employeeSalarySheetList == null){
			return salaryGrade;
		}	
	
		SmartList<EmployeeSalarySheet> toRemoveEmployeeSalarySheetList = employeeSalarySheetList.getToRemoveList();
		
		if(toRemoveEmployeeSalarySheetList == null){
			return salaryGrade;
		}
		if(toRemoveEmployeeSalarySheetList.isEmpty()){
			return salaryGrade;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeSalarySheetDAO().removeEmployeeSalarySheetList(toRemoveEmployeeSalarySheetList,options);
		
		return salaryGrade;
	
	}
	
	

 	
 	
	
	
	
		

	public SalaryGrade present(SalaryGrade salaryGrade,Map<String, Object> options){
	
		presentEmployeeList(salaryGrade,options);
		presentEmployeeSalarySheetList(salaryGrade,options);

		return salaryGrade;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SalaryGrade presentEmployeeList(
			SalaryGrade salaryGrade,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(salaryGrade.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByCurrentSalaryGrade,
				getEmployeeDAO()::findEmployeeByCurrentSalaryGrade
				);

		
		salaryGrade.setEmployeeList(newList);
		

		return salaryGrade;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SalaryGrade presentEmployeeSalarySheetList(
			SalaryGrade salaryGrade,
			Map<String, Object> options) {

		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();		
				SmartList<EmployeeSalarySheet> newList= presentSubList(salaryGrade.getId(),
				employeeSalarySheetList,
				options,
				getEmployeeSalarySheetDAO()::countEmployeeSalarySheetByCurrentSalaryGrade,
				getEmployeeSalarySheetDAO()::findEmployeeSalarySheetByCurrentSalaryGrade
				);

		
		salaryGrade.setEmployeeSalarySheetList(newList);
		

		return salaryGrade;
	}			
		

	
    public SmartList<SalaryGrade> requestCandidateSalaryGradeForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SalaryGradeTable.COLUMN_CODE, SalaryGradeTable.COLUMN_COMPANY, filterKey, pageNo, pageSize, getSalaryGradeMapper());
    }
		
    public SmartList<SalaryGrade> requestCandidateSalaryGradeForEmployeeSalarySheet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SalaryGradeTable.COLUMN_CODE, SalaryGradeTable.COLUMN_COMPANY, filterKey, pageNo, pageSize, getSalaryGradeMapper());
    }
		

	protected String getTableName(){
		return SalaryGradeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SalaryGrade> salaryGradeList) {		
		this.enhanceListInternal(salaryGradeList, this.getSalaryGradeMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Employee的currentSalaryGrade的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<SalaryGrade> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Employee> loadedObjs = userContext.getDAOGroup().getEmployeeDAO().findEmployeeWithKey(key, options);
		Map<String, List<Employee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCurrentSalaryGrade().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Employee> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Employee> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setEmployeeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeSalarySheet的currentSalaryGrade的EmployeeSalarySheetList
	public SmartList<EmployeeSalarySheet> loadOurEmployeeSalarySheetList(RetailscmUserContext userContext, List<SalaryGrade> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<EmployeeSalarySheet> loadedObjs = userContext.getDAOGroup().getEmployeeSalarySheetDAO().findEmployeeSalarySheetWithKey(key, options);
		Map<String, List<EmployeeSalarySheet>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCurrentSalaryGrade().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<EmployeeSalarySheet> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<EmployeeSalarySheet> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setEmployeeSalarySheetList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SalaryGrade> salaryGradeList = ownerEntity.collectRefsWithType(SalaryGrade.INTERNAL_TYPE);
		this.enhanceList(salaryGradeList);
		
	}
	
	@Override
	public SmartList<SalaryGrade> findSalaryGradeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSalaryGradeMapper());

	}
	@Override
	public int countSalaryGradeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSalaryGradeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SalaryGrade> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSalaryGradeMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSalaryGrade executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSalaryGrade result = new CandidateSalaryGrade();
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


