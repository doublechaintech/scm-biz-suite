
package com.doublechaintech.retailscm.employeeboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.RetailscmNamingServiceDAO;
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


public class EmployeeBoardingJDBCTemplateDAO extends RetailscmNamingServiceDAO implements EmployeeBoardingDAO{


			
		
	
  	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO pEmployeeDAO){
 	
 		if(pEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = pEmployeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The employeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}	
 	
			
		

	
	/*
	protected EmployeeBoarding load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeBoarding(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%08d";
	}
	
	public EmployeeBoarding load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeBoarding(EmployeeBoardingTable.withId(id), options);
	}
	
	
	
	public EmployeeBoarding save(EmployeeBoarding employeeBoarding,Map<String,Object> options){
		
		String methodName="save(EmployeeBoarding employeeBoarding,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeBoarding, methodName, "employeeBoarding");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeBoarding(employeeBoarding,options);
	}
	public EmployeeBoarding clone(String employeeBoardingId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeBoardingTable.withId(employeeBoardingId),options);
	}
	
	protected EmployeeBoarding clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeBoardingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeBoarding newEmployeeBoarding = loadInternalEmployeeBoarding(accessKey, options);
		newEmployeeBoarding.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newEmployeeBoarding.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalEmployeeBoarding(newEmployeeBoarding,options);
		
		return newEmployeeBoarding;
	}
	
	
	
	

	protected void throwIfHasException(String employeeBoardingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new EmployeeBoardingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeBoardingNotFoundException(
					"The " + this.getTableName() + "(" + employeeBoardingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String employeeBoardingId, int version) throws Exception{
	
		String methodName="delete(String employeeBoardingId, int version)";
		assertMethodArgumentNotNull(employeeBoardingId, methodName, "employeeBoardingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeBoardingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeBoardingId,version);
		}
		
	
	}
	
	
	
	
	

	public EmployeeBoarding disconnectFromAll(String employeeBoardingId, int version) throws Exception{
	
		
		EmployeeBoarding employeeBoarding = loadInternalEmployeeBoarding(EmployeeBoardingTable.withId(employeeBoardingId), emptyOptions());
		employeeBoarding.clearFromAll();
		this.saveEmployeeBoarding(employeeBoarding);
		return employeeBoarding;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return EmployeeBoardingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_boarding";
	}
	@Override
	protected String getBeanName() {
		
		return "employeeBoarding";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeBoardingTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,EmployeeBoardingTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){		 		
 		return EmployeeBoardingTokens.of(options).analyzeEmployeeListEnabled();
 	}
	
	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, EmployeeBoardingTokens.EMPLOYEE_LIST);
		
 	}
 	
		

	

	protected EmployeeBoardingMapper getEmployeeBoardingMapper(){
		return new EmployeeBoardingMapper();
	}

	
	
	protected EmployeeBoarding extractEmployeeBoarding(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			EmployeeBoarding employeeBoarding = loadSingleObject(accessKey, getEmployeeBoardingMapper());
			return employeeBoarding;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeBoardingNotFoundException("EmployeeBoarding("+accessKey+") is not found!");
		}

	}

	
	

	protected EmployeeBoarding loadInternalEmployeeBoarding(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeBoarding employeeBoarding = extractEmployeeBoarding(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(employeeBoarding, loadOptions);
 		}	
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(employeeBoarding, loadOptions);
 		}
 		
		
		return employeeBoarding;
		
	}

	
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected EmployeeBoarding extractEmployeeList(EmployeeBoarding employeeBoarding, Map<String,Object> options){
		
		
		if(employeeBoarding == null){
			return null;
		}
		if(employeeBoarding.getId() == null){
			return employeeBoarding;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByEmployeeBoarding(employeeBoarding.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			employeeBoarding.setEmployeeList(employeeList);
		}
		
		return employeeBoarding;
	
	}	
	
	protected EmployeeBoarding analyzeEmployeeList(EmployeeBoarding employeeBoarding, Map<String,Object> options){
		
		
		if(employeeBoarding == null){
			return null;
		}
		if(employeeBoarding.getId() == null){
			return employeeBoarding;
		}

		
		
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByEmployeeBoarding(employeeList, employeeBoarding.getId(), options);
			
		}
		
		return employeeBoarding;
	
	}	
	
		
		
 	
		
		
		

	

	protected EmployeeBoarding saveEmployeeBoarding(EmployeeBoarding  employeeBoarding){
		
		if(!employeeBoarding.isChanged()){
			return employeeBoarding;
		}
		
		
		String SQL=this.getSaveEmployeeBoardingSQL(employeeBoarding);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeBoardingParameters(employeeBoarding);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeBoarding.incVersion();
		return employeeBoarding;
	
	}
	public SmartList<EmployeeBoarding> saveEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeBoardingList(employeeBoardingList);
		
		batchEmployeeBoardingCreate((List<EmployeeBoarding>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeBoardingUpdate((List<EmployeeBoarding>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeBoarding employeeBoarding:employeeBoardingList){
			if(employeeBoarding.isChanged()){
				employeeBoarding.incVersion();
			}
			
		
		}
		
		
		return employeeBoardingList;
	}

	public SmartList<EmployeeBoarding> removeEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options){
		
		
		super.removeList(employeeBoardingList, options);
		
		return employeeBoardingList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeBoardingBatchCreateArgs(List<EmployeeBoarding> employeeBoardingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeBoarding employeeBoarding:employeeBoardingList ){
			Object [] parameters = prepareEmployeeBoardingCreateParameters(employeeBoarding);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeBoardingBatchUpdateArgs(List<EmployeeBoarding> employeeBoardingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeBoarding employeeBoarding:employeeBoardingList ){
			if(!employeeBoarding.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeBoardingUpdateParameters(employeeBoarding);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeBoardingCreate(List<EmployeeBoarding> employeeBoardingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeBoardingBatchCreateArgs(employeeBoardingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeBoardingUpdate(List<EmployeeBoarding> employeeBoardingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeBoardingBatchUpdateArgs(employeeBoardingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeBoardingList(List<EmployeeBoarding> employeeBoardingList){
		
		List<EmployeeBoarding> employeeBoardingCreateList=new ArrayList<EmployeeBoarding>();
		List<EmployeeBoarding> employeeBoardingUpdateList=new ArrayList<EmployeeBoarding>();
		
		for(EmployeeBoarding employeeBoarding: employeeBoardingList){
			if(isUpdateRequest(employeeBoarding)){
				employeeBoardingUpdateList.add( employeeBoarding);
				continue;
			}
			employeeBoardingCreateList.add(employeeBoarding);
		}
		
		return new Object[]{employeeBoardingCreateList,employeeBoardingUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeBoarding employeeBoarding){
 		return employeeBoarding.getVersion() > 0;
 	}
 	protected String getSaveEmployeeBoardingSQL(EmployeeBoarding employeeBoarding){
 		if(isUpdateRequest(employeeBoarding)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeBoardingParameters(EmployeeBoarding employeeBoarding){
 		if(isUpdateRequest(employeeBoarding) ){
 			return prepareEmployeeBoardingUpdateParameters(employeeBoarding);
 		}
 		return prepareEmployeeBoardingCreateParameters(employeeBoarding);
 	}
 	protected Object[] prepareEmployeeBoardingUpdateParameters(EmployeeBoarding employeeBoarding){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = employeeBoarding.getWho();
 		parameters[1] = employeeBoarding.getEmployTime();
 		parameters[2] = employeeBoarding.getComments();		
 		parameters[3] = employeeBoarding.nextVersion();
 		parameters[4] = employeeBoarding.getId();
 		parameters[5] = employeeBoarding.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeBoardingCreateParameters(EmployeeBoarding employeeBoarding){
		Object[] parameters = new Object[4];
		String newEmployeeBoardingId=getNextId();
		employeeBoarding.setId(newEmployeeBoardingId);
		parameters[0] =  employeeBoarding.getId();
 
 		parameters[1] = employeeBoarding.getWho();
 		parameters[2] = employeeBoarding.getEmployTime();
 		parameters[3] = employeeBoarding.getComments();		
 				
 		return parameters;
 	}
 	
	protected EmployeeBoarding saveInternalEmployeeBoarding(EmployeeBoarding employeeBoarding, Map<String,Object> options){
		
		saveEmployeeBoarding(employeeBoarding);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(employeeBoarding, options);
	 		//removeEmployeeList(employeeBoarding, options);
	 		//Not delete the record
	 		
 		}		
		
		return employeeBoarding;
		
	}
	
	
	
	//======================================================================================
	

	
	public EmployeeBoarding planToRemoveEmployeeList(EmployeeBoarding employeeBoarding, String employeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoarding.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return employeeBoarding;
		}
		if(externalEmployeeList.isEmpty()){
			return employeeBoarding;
		}
		
		for(Employee employeeItem: externalEmployeeList){

			employeeItem.clearFromAll();
		}
		
		
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return employeeBoarding;	
	
	}


	//disconnect EmployeeBoarding with company in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithCompany(EmployeeBoarding employeeBoarding, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoarding.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return employeeBoarding;
		}
		if(externalEmployeeList.isEmpty()){
			return employeeBoarding;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCompany();
			employeeItem.clearEmployeeBoarding();
			
		}
		
		
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return employeeBoarding;
	}
	
	public int countEmployeeListWithCompany(String employeeBoardingId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoardingId);
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect EmployeeBoarding with department in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithDepartment(EmployeeBoarding employeeBoarding, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoarding.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return employeeBoarding;
		}
		if(externalEmployeeList.isEmpty()){
			return employeeBoarding;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearDepartment();
			employeeItem.clearEmployeeBoarding();
			
		}
		
		
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return employeeBoarding;
	}
	
	public int countEmployeeListWithDepartment(String employeeBoardingId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoardingId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect EmployeeBoarding with occupation in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithOccupation(EmployeeBoarding employeeBoarding, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoarding.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return employeeBoarding;
		}
		if(externalEmployeeList.isEmpty()){
			return employeeBoarding;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearOccupation();
			employeeItem.clearEmployeeBoarding();
			
		}
		
		
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return employeeBoarding;
	}
	
	public int countEmployeeListWithOccupation(String employeeBoardingId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoardingId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect EmployeeBoarding with responsible_for in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithResponsibleFor(EmployeeBoarding employeeBoarding, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoarding.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return employeeBoarding;
		}
		if(externalEmployeeList.isEmpty()){
			return employeeBoarding;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearResponsibleFor();
			employeeItem.clearEmployeeBoarding();
			
		}
		
		
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return employeeBoarding;
	}
	
	public int countEmployeeListWithResponsibleFor(String employeeBoardingId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoardingId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect EmployeeBoarding with current_salary_grade in Employee
	public EmployeeBoarding planToRemoveEmployeeListWithCurrentSalaryGrade(EmployeeBoarding employeeBoarding, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoarding.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return employeeBoarding;
		}
		if(externalEmployeeList.isEmpty()){
			return employeeBoarding;
		}
		
		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCurrentSalaryGrade();
			employeeItem.clearEmployeeBoarding();
			
		}
		
		
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return employeeBoarding;
	}
	
	public int countEmployeeListWithCurrentSalaryGrade(String employeeBoardingId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, employeeBoardingId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected EmployeeBoarding saveEmployeeList(EmployeeBoarding employeeBoarding, Map<String,Object> options){
		
		
		
		
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return employeeBoarding;
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
		
		
		return employeeBoarding;
	
	}
	
	protected EmployeeBoarding removeEmployeeList(EmployeeBoarding employeeBoarding, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();
		if(employeeList == null){
			return employeeBoarding;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return employeeBoarding;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return employeeBoarding;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return employeeBoarding;
	
	}
	
	

 	
 	
	
	
	
		

	public EmployeeBoarding present(EmployeeBoarding employeeBoarding,Map<String, Object> options){
	
		presentEmployeeList(employeeBoarding,options);

		return employeeBoarding;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected EmployeeBoarding presentEmployeeList(
			EmployeeBoarding employeeBoarding,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = employeeBoarding.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(employeeBoarding.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByEmployeeBoarding,
				getEmployeeDAO()::findEmployeeByEmployeeBoarding
				);

		
		employeeBoarding.setEmployeeList(newList);
		

		return employeeBoarding;
	}			
		

	
    public SmartList<EmployeeBoarding> requestCandidateEmployeeBoardingForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(EmployeeBoardingTable.COLUMN_WHO, filterKey, pageNo, pageSize, getEmployeeBoardingMapper());
    }
		

	protected String getTableName(){
		return EmployeeBoardingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<EmployeeBoarding> employeeBoardingList) {		
		this.enhanceListInternal(employeeBoardingList, this.getEmployeeBoardingMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Employee的employeeBoarding的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<EmployeeBoarding> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.EMPLOYEE_BOARDING_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Employee> loadedObjs = userContext.getDAOGroup().getEmployeeDAO().findEmployeeWithKey(key, options);
		Map<String, List<Employee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getEmployeeBoarding().getId()));
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
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<EmployeeBoarding> employeeBoardingList = ownerEntity.collectRefsWithType(EmployeeBoarding.INTERNAL_TYPE);
		this.enhanceList(employeeBoardingList);
		
	}
	
	@Override
	public SmartList<EmployeeBoarding> findEmployeeBoardingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getEmployeeBoardingMapper());

	}
	@Override
	public int countEmployeeBoardingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countEmployeeBoardingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<EmployeeBoarding> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getEmployeeBoardingMapper());
	}
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


