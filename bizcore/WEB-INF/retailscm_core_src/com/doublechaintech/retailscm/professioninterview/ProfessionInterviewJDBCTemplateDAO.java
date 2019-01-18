
package com.doublechaintech.retailscm.professioninterview;

import java.util.List;
import java.util.ArrayList;
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



import org.springframework.dao.EmptyResultDataAccessException;

public class ProfessionInterviewJDBCTemplateDAO extends RetailscmNamingServiceDAO implements ProfessionInterviewDAO{


			
		
	
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
	protected ProfessionInterview load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProfessionInterview(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ProfessionInterview load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProfessionInterview(ProfessionInterviewTable.withId(id), options);
	}
	
	
	
	public ProfessionInterview save(ProfessionInterview professionInterview,Map<String,Object> options){
		
		String methodName="save(ProfessionInterview professionInterview,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(professionInterview, methodName, "professionInterview");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProfessionInterview(professionInterview,options);
	}
	public ProfessionInterview clone(String professionInterviewId, Map<String,Object> options) throws Exception{
	
		return clone(ProfessionInterviewTable.withId(professionInterviewId),options);
	}
	
	protected ProfessionInterview clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String professionInterviewId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ProfessionInterview newProfessionInterview = loadInternalProfessionInterview(accessKey, options);
		newProfessionInterview.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newProfessionInterview.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProfessionInterview(newProfessionInterview,options);
		
		return newProfessionInterview;
	}
	
	
	
	

	protected void throwIfHasException(String professionInterviewId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProfessionInterviewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProfessionInterviewNotFoundException(
					"The " + this.getTableName() + "(" + professionInterviewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String professionInterviewId, int version) throws Exception{
	
		String methodName="delete(String professionInterviewId, int version)";
		assertMethodArgumentNotNull(professionInterviewId, methodName, "professionInterviewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{professionInterviewId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(professionInterviewId,version);
		}
		
	
	}
	
	
	
	
	

	public ProfessionInterview disconnectFromAll(String professionInterviewId, int version) throws Exception{
	
		
		ProfessionInterview professionInterview = loadInternalProfessionInterview(ProfessionInterviewTable.withId(professionInterviewId), emptyOptions());
		professionInterview.clearFromAll();
		this.saveProfessionInterview(professionInterview);
		return professionInterview;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ProfessionInterviewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "profession_interview";
	}
	@Override
	protected String getBeanName() {
		
		return "professionInterview";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProfessionInterviewTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProfessionInterviewTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,ProfessionInterviewTokens.EMPLOYEE_LIST+".analyze");
 	}
	
	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, ProfessionInterviewTokens.EMPLOYEE_LIST);
		
 	}
 	
		

	

	protected ProfessionInterviewMapper getProfessionInterviewMapper(){
		return new ProfessionInterviewMapper();
	}

	
	
	protected ProfessionInterview extractProfessionInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ProfessionInterview professionInterview = loadSingleObject(accessKey, getProfessionInterviewMapper());
			return professionInterview;
		}catch(EmptyResultDataAccessException e){
			throw new ProfessionInterviewNotFoundException("ProfessionInterview("+accessKey+") is not found!");
		}

	}

	
	

	protected ProfessionInterview loadInternalProfessionInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ProfessionInterview professionInterview = extractProfessionInterview(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(professionInterview, loadOptions);
 		}	
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(professionInterview, loadOptions);
 		}
 		
		
		return professionInterview;
		
	}

	
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ProfessionInterview extractEmployeeList(ProfessionInterview professionInterview, Map<String,Object> options){
		
		
		if(professionInterview == null){
			return null;
		}
		if(professionInterview.getId() == null){
			return professionInterview;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByProfessionInterview(professionInterview.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			professionInterview.setEmployeeList(employeeList);
		}
		
		return professionInterview;
	
	}	
	
	protected ProfessionInterview analyzeEmployeeList(ProfessionInterview professionInterview, Map<String,Object> options){
		
		
		if(professionInterview == null){
			return null;
		}
		if(professionInterview.getId() == null){
			return professionInterview;
		}

		
		
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByProfessionInterview(employeeList, professionInterview.getId(), options);
			
		}
		
		return professionInterview;
	
	}	
	
		
		
 	
		
		
		

	

	protected ProfessionInterview saveProfessionInterview(ProfessionInterview  professionInterview){
		
		if(!professionInterview.isChanged()){
			return professionInterview;
		}
		
		
		String SQL=this.getSaveProfessionInterviewSQL(professionInterview);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProfessionInterviewParameters(professionInterview);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		professionInterview.incVersion();
		return professionInterview;
	
	}
	public SmartList<ProfessionInterview> saveProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProfessionInterviewList(professionInterviewList);
		
		batchProfessionInterviewCreate((List<ProfessionInterview>)lists[CREATE_LIST_INDEX]);
		
		batchProfessionInterviewUpdate((List<ProfessionInterview>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ProfessionInterview professionInterview:professionInterviewList){
			if(professionInterview.isChanged()){
				professionInterview.incVersion();
			}
			
		
		}
		
		
		return professionInterviewList;
	}

	public SmartList<ProfessionInterview> removeProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options){
		
		
		super.removeList(professionInterviewList, options);
		
		return professionInterviewList;
		
		
	}
	
	protected List<Object[]> prepareProfessionInterviewBatchCreateArgs(List<ProfessionInterview> professionInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProfessionInterview professionInterview:professionInterviewList ){
			Object [] parameters = prepareProfessionInterviewCreateParameters(professionInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProfessionInterviewBatchUpdateArgs(List<ProfessionInterview> professionInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProfessionInterview professionInterview:professionInterviewList ){
			if(!professionInterview.isChanged()){
				continue;
			}
			Object [] parameters = prepareProfessionInterviewUpdateParameters(professionInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProfessionInterviewCreate(List<ProfessionInterview> professionInterviewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProfessionInterviewBatchCreateArgs(professionInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProfessionInterviewUpdate(List<ProfessionInterview> professionInterviewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProfessionInterviewBatchUpdateArgs(professionInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProfessionInterviewList(List<ProfessionInterview> professionInterviewList){
		
		List<ProfessionInterview> professionInterviewCreateList=new ArrayList<ProfessionInterview>();
		List<ProfessionInterview> professionInterviewUpdateList=new ArrayList<ProfessionInterview>();
		
		for(ProfessionInterview professionInterview: professionInterviewList){
			if(isUpdateRequest(professionInterview)){
				professionInterviewUpdateList.add( professionInterview);
				continue;
			}
			professionInterviewCreateList.add(professionInterview);
		}
		
		return new Object[]{professionInterviewCreateList,professionInterviewUpdateList};
	}
	
	protected boolean isUpdateRequest(ProfessionInterview professionInterview){
 		return professionInterview.getVersion() > 0;
 	}
 	protected String getSaveProfessionInterviewSQL(ProfessionInterview professionInterview){
 		if(isUpdateRequest(professionInterview)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProfessionInterviewParameters(ProfessionInterview professionInterview){
 		if(isUpdateRequest(professionInterview) ){
 			return prepareProfessionInterviewUpdateParameters(professionInterview);
 		}
 		return prepareProfessionInterviewCreateParameters(professionInterview);
 	}
 	protected Object[] prepareProfessionInterviewUpdateParameters(ProfessionInterview professionInterview){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = professionInterview.getWho();
 		parameters[1] = professionInterview.getInterviewTime();
 		parameters[2] = professionInterview.getComments();		
 		parameters[3] = professionInterview.nextVersion();
 		parameters[4] = professionInterview.getId();
 		parameters[5] = professionInterview.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProfessionInterviewCreateParameters(ProfessionInterview professionInterview){
		Object[] parameters = new Object[4];
		String newProfessionInterviewId=getNextId();
		professionInterview.setId(newProfessionInterviewId);
		parameters[0] =  professionInterview.getId();
 
 		parameters[1] = professionInterview.getWho();
 		parameters[2] = professionInterview.getInterviewTime();
 		parameters[3] = professionInterview.getComments();		
 				
 		return parameters;
 	}
 	
	protected ProfessionInterview saveInternalProfessionInterview(ProfessionInterview professionInterview, Map<String,Object> options){
		
		saveProfessionInterview(professionInterview);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(professionInterview, options);
	 		//removeEmployeeList(professionInterview, options);
	 		//Not delete the record
	 		
 		}		
		
		return professionInterview;
		
	}
	
	
	
	//======================================================================================
	

	
	public ProfessionInterview planToRemoveEmployeeList(ProfessionInterview professionInterview, String employeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterview.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return professionInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return professionInterview;
		}
		
		for(Employee employee: externalEmployeeList){

			employee.clearFromAll();
		}
		
		
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return professionInterview;	
	
	}


	//disconnect ProfessionInterview with company in Employee
	public ProfessionInterview planToRemoveEmployeeListWithCompany(ProfessionInterview professionInterview, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterview.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return professionInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return professionInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCompany();
			employee.clearProfessionInterview();
			
		}
		
		
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return professionInterview;
	}
	
	public int countEmployeeListWithCompany(String professionInterviewId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterviewId);
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect ProfessionInterview with department in Employee
	public ProfessionInterview planToRemoveEmployeeListWithDepartment(ProfessionInterview professionInterview, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterview.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return professionInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return professionInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearDepartment();
			employee.clearProfessionInterview();
			
		}
		
		
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return professionInterview;
	}
	
	public int countEmployeeListWithDepartment(String professionInterviewId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterviewId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect ProfessionInterview with occupation in Employee
	public ProfessionInterview planToRemoveEmployeeListWithOccupation(ProfessionInterview professionInterview, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterview.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return professionInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return professionInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearOccupation();
			employee.clearProfessionInterview();
			
		}
		
		
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return professionInterview;
	}
	
	public int countEmployeeListWithOccupation(String professionInterviewId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterviewId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect ProfessionInterview with responsible_for in Employee
	public ProfessionInterview planToRemoveEmployeeListWithResponsibleFor(ProfessionInterview professionInterview, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterview.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return professionInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return professionInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearResponsibleFor();
			employee.clearProfessionInterview();
			
		}
		
		
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return professionInterview;
	}
	
	public int countEmployeeListWithResponsibleFor(String professionInterviewId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterviewId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect ProfessionInterview with current_salary_grade in Employee
	public ProfessionInterview planToRemoveEmployeeListWithCurrentSalaryGrade(ProfessionInterview professionInterview, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterview.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return professionInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return professionInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCurrentSalaryGrade();
			employee.clearProfessionInterview();
			
		}
		
		
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return professionInterview;
	}
	
	public int countEmployeeListWithCurrentSalaryGrade(String professionInterviewId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.PROFESSION_INTERVIEW_PROPERTY, professionInterviewId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected ProfessionInterview saveEmployeeList(ProfessionInterview professionInterview, Map<String,Object> options){
		
		
		
		
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return professionInterview;
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
		
		
		return professionInterview;
	
	}
	
	protected ProfessionInterview removeEmployeeList(ProfessionInterview professionInterview, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = professionInterview.getEmployeeList();
		if(employeeList == null){
			return professionInterview;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return professionInterview;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return professionInterview;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return professionInterview;
	
	}
	
	

 	
 	
	
	
	
		

	public ProfessionInterview present(ProfessionInterview professionInterview,Map<String, Object> options){
	
		presentEmployeeList(professionInterview,options);

		return professionInterview;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ProfessionInterview presentEmployeeList(
			ProfessionInterview professionInterview,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = professionInterview.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(professionInterview.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByProfessionInterview,
				getEmployeeDAO()::findEmployeeByProfessionInterview
				);

		
		professionInterview.setEmployeeList(newList);
		

		return professionInterview;
	}			
		

	
    public SmartList<ProfessionInterview> requestCandidateProfessionInterviewForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProfessionInterviewTable.COLUMN_WHO, filterKey, pageNo, pageSize, getProfessionInterviewMapper());
    }
		

	protected String getTableName(){
		return ProfessionInterviewTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ProfessionInterview> professionInterviewList) {		
		this.enhanceListInternal(professionInterviewList, this.getProfessionInterviewMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ProfessionInterview> professionInterviewList = ownerEntity.collectRefsWithType(ProfessionInterview.INTERNAL_TYPE);
		this.enhanceList(professionInterviewList);
		
	}
	
	@Override
	public SmartList<ProfessionInterview> findProfessionInterviewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getProfessionInterviewMapper());

	}
	@Override
	public int countProfessionInterviewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countProfessionInterviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ProfessionInterview> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProfessionInterviewMapper());
	}
}


