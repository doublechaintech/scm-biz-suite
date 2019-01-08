
package com.doublechaintech.retailscm.jobapplication;

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

public class JobApplicationJDBCTemplateDAO extends RetailscmNamingServiceDAO implements JobApplicationDAO{


			
		
	
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
	protected JobApplication load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalJobApplication(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public JobApplication load(String id,Map<String,Object> options) throws Exception{
		return loadInternalJobApplication(JobApplicationTable.withId(id), options);
	}
	
	
	
	public JobApplication save(JobApplication jobApplication,Map<String,Object> options){
		
		String methodName="save(JobApplication jobApplication,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(jobApplication, methodName, "jobApplication");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalJobApplication(jobApplication,options);
	}
	public JobApplication clone(String jobApplicationId, Map<String,Object> options) throws Exception{
	
		return clone(JobApplicationTable.withId(jobApplicationId),options);
	}
	
	protected JobApplication clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String jobApplicationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		JobApplication newJobApplication = loadInternalJobApplication(accessKey, options);
		newJobApplication.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newJobApplication.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalJobApplication(newJobApplication,options);
		
		return newJobApplication;
	}
	
	
	
	

	protected void throwIfHasException(String jobApplicationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new JobApplicationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new JobApplicationNotFoundException(
					"The " + this.getTableName() + "(" + jobApplicationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String jobApplicationId, int version) throws Exception{
	
		String methodName="delete(String jobApplicationId, int version)";
		assertMethodArgumentNotNull(jobApplicationId, methodName, "jobApplicationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{jobApplicationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(jobApplicationId,version);
		}
		
	
	}
	
	
	
	
	

	public JobApplication disconnectFromAll(String jobApplicationId, int version) throws Exception{
	
		
		JobApplication jobApplication = loadInternalJobApplication(JobApplicationTable.withId(jobApplicationId), emptyOptions());
		jobApplication.clearFromAll();
		this.saveJobApplication(jobApplication);
		return jobApplication;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return JobApplicationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "job_application";
	}
	@Override
	protected String getBeanName() {
		
		return "jobApplication";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return JobApplicationTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,JobApplicationTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,JobApplicationTokens.EMPLOYEE_LIST+".analyze");
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, JobApplicationTokens.EMPLOYEE_LIST);
		
 	}
 	
		

	

	protected JobApplicationMapper getJobApplicationMapper(){
		return new JobApplicationMapper();
	}

	
	
	protected JobApplication extractJobApplication(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			JobApplication jobApplication = loadSingleObject(accessKey, getJobApplicationMapper());
			return jobApplication;
		}catch(EmptyResultDataAccessException e){
			throw new JobApplicationNotFoundException("JobApplication("+accessKey+") is not found!");
		}

	}

	
	

	protected JobApplication loadInternalJobApplication(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		JobApplication jobApplication = extractJobApplication(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(jobApplication, loadOptions);
 		}	
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		// analyzeEmployeeList(jobApplication, loadOptions);
 		}
 		
		
		return jobApplication;
		
	}

	
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected JobApplication extractEmployeeList(JobApplication jobApplication, Map<String,Object> options){
		
		
		if(jobApplication == null){
			return null;
		}
		if(jobApplication.getId() == null){
			return jobApplication;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByJobApplication(jobApplication.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			jobApplication.setEmployeeList(employeeList);
		}
		
		return jobApplication;
	
	}	
	
	protected JobApplication analyzeEmployeeList(JobApplication jobApplication, Map<String,Object> options){
		
		
		if(jobApplication == null){
			return null;
		}
		if(jobApplication.getId() == null){
			return jobApplication;
		}

		
		
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByJobApplication(employeeList, jobApplication.getId(), options);
			
		}
		
		return jobApplication;
	
	}	
	
		
		
 	
		
		
		

	

	protected JobApplication saveJobApplication(JobApplication  jobApplication){
		
		if(!jobApplication.isChanged()){
			return jobApplication;
		}
		
		
		String SQL=this.getSaveJobApplicationSQL(jobApplication);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveJobApplicationParameters(jobApplication);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		jobApplication.incVersion();
		return jobApplication;
	
	}
	public SmartList<JobApplication> saveJobApplicationList(SmartList<JobApplication> jobApplicationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitJobApplicationList(jobApplicationList);
		
		batchJobApplicationCreate((List<JobApplication>)lists[CREATE_LIST_INDEX]);
		
		batchJobApplicationUpdate((List<JobApplication>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(JobApplication jobApplication:jobApplicationList){
			if(jobApplication.isChanged()){
				jobApplication.incVersion();
			}
			
		
		}
		
		
		return jobApplicationList;
	}

	public SmartList<JobApplication> removeJobApplicationList(SmartList<JobApplication> jobApplicationList,Map<String,Object> options){
		
		
		super.removeList(jobApplicationList, options);
		
		return jobApplicationList;
		
		
	}
	
	protected List<Object[]> prepareJobApplicationBatchCreateArgs(List<JobApplication> jobApplicationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(JobApplication jobApplication:jobApplicationList ){
			Object [] parameters = prepareJobApplicationCreateParameters(jobApplication);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareJobApplicationBatchUpdateArgs(List<JobApplication> jobApplicationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(JobApplication jobApplication:jobApplicationList ){
			if(!jobApplication.isChanged()){
				continue;
			}
			Object [] parameters = prepareJobApplicationUpdateParameters(jobApplication);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchJobApplicationCreate(List<JobApplication> jobApplicationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareJobApplicationBatchCreateArgs(jobApplicationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchJobApplicationUpdate(List<JobApplication> jobApplicationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareJobApplicationBatchUpdateArgs(jobApplicationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitJobApplicationList(List<JobApplication> jobApplicationList){
		
		List<JobApplication> jobApplicationCreateList=new ArrayList<JobApplication>();
		List<JobApplication> jobApplicationUpdateList=new ArrayList<JobApplication>();
		
		for(JobApplication jobApplication: jobApplicationList){
			if(isUpdateRequest(jobApplication)){
				jobApplicationUpdateList.add( jobApplication);
				continue;
			}
			jobApplicationCreateList.add(jobApplication);
		}
		
		return new Object[]{jobApplicationCreateList,jobApplicationUpdateList};
	}
	
	protected boolean isUpdateRequest(JobApplication jobApplication){
 		return jobApplication.getVersion() > 0;
 	}
 	protected String getSaveJobApplicationSQL(JobApplication jobApplication){
 		if(isUpdateRequest(jobApplication)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveJobApplicationParameters(JobApplication jobApplication){
 		if(isUpdateRequest(jobApplication) ){
 			return prepareJobApplicationUpdateParameters(jobApplication);
 		}
 		return prepareJobApplicationCreateParameters(jobApplication);
 	}
 	protected Object[] prepareJobApplicationUpdateParameters(JobApplication jobApplication){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = jobApplication.getApplicationTime();
 		parameters[1] = jobApplication.getWho();
 		parameters[2] = jobApplication.getComments();		
 		parameters[3] = jobApplication.nextVersion();
 		parameters[4] = jobApplication.getId();
 		parameters[5] = jobApplication.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareJobApplicationCreateParameters(JobApplication jobApplication){
		Object[] parameters = new Object[4];
		String newJobApplicationId=getNextId();
		jobApplication.setId(newJobApplicationId);
		parameters[0] =  jobApplication.getId();
 
 		parameters[1] = jobApplication.getApplicationTime();
 		parameters[2] = jobApplication.getWho();
 		parameters[3] = jobApplication.getComments();		
 				
 		return parameters;
 	}
 	
	protected JobApplication saveInternalJobApplication(JobApplication jobApplication, Map<String,Object> options){
		
		saveJobApplication(jobApplication);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(jobApplication, options);
	 		//removeEmployeeList(jobApplication, options);
	 		//Not delete the record
	 		
 		}		
		
		return jobApplication;
		
	}
	
	
	
	//======================================================================================
	

	
	public JobApplication planToRemoveEmployeeList(JobApplication jobApplication, String employeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplication.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return jobApplication;
		}
		if(externalEmployeeList.isEmpty()){
			return jobApplication;
		}
		
		for(Employee employee: externalEmployeeList){

			employee.clearFromAll();
		}
		
		
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return jobApplication;	
	
	}


	//disconnect JobApplication with company in Employee
	public JobApplication planToRemoveEmployeeListWithCompany(JobApplication jobApplication, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplication.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return jobApplication;
		}
		if(externalEmployeeList.isEmpty()){
			return jobApplication;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCompany();
			employee.clearJobApplication();
			
		}
		
		
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return jobApplication;
	}
	
	public int countEmployeeListWithCompany(String jobApplicationId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplicationId);
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect JobApplication with department in Employee
	public JobApplication planToRemoveEmployeeListWithDepartment(JobApplication jobApplication, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplication.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return jobApplication;
		}
		if(externalEmployeeList.isEmpty()){
			return jobApplication;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearDepartment();
			employee.clearJobApplication();
			
		}
		
		
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return jobApplication;
	}
	
	public int countEmployeeListWithDepartment(String jobApplicationId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplicationId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect JobApplication with occupation in Employee
	public JobApplication planToRemoveEmployeeListWithOccupation(JobApplication jobApplication, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplication.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return jobApplication;
		}
		if(externalEmployeeList.isEmpty()){
			return jobApplication;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearOccupation();
			employee.clearJobApplication();
			
		}
		
		
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return jobApplication;
	}
	
	public int countEmployeeListWithOccupation(String jobApplicationId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplicationId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect JobApplication with responsible_for in Employee
	public JobApplication planToRemoveEmployeeListWithResponsibleFor(JobApplication jobApplication, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplication.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return jobApplication;
		}
		if(externalEmployeeList.isEmpty()){
			return jobApplication;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearResponsibleFor();
			employee.clearJobApplication();
			
		}
		
		
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return jobApplication;
	}
	
	public int countEmployeeListWithResponsibleFor(String jobApplicationId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplicationId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect JobApplication with current_salary_grade in Employee
	public JobApplication planToRemoveEmployeeListWithCurrentSalaryGrade(JobApplication jobApplication, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplication.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return jobApplication;
		}
		if(externalEmployeeList.isEmpty()){
			return jobApplication;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCurrentSalaryGrade();
			employee.clearJobApplication();
			
		}
		
		
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return jobApplication;
	}
	
	public int countEmployeeListWithCurrentSalaryGrade(String jobApplicationId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.JOB_APPLICATION_PROPERTY, jobApplicationId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected JobApplication saveEmployeeList(JobApplication jobApplication, Map<String,Object> options){
		
		
		
		
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return jobApplication;
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
		
		
		return jobApplication;
	
	}
	
	protected JobApplication removeEmployeeList(JobApplication jobApplication, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = jobApplication.getEmployeeList();
		if(employeeList == null){
			return jobApplication;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return jobApplication;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return jobApplication;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return jobApplication;
	
	}
	
	

 	
 	
	
	
	
		

	public JobApplication present(JobApplication jobApplication,Map<String, Object> options){
	
		presentEmployeeList(jobApplication,options);

		return jobApplication;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected JobApplication presentEmployeeList(
			JobApplication jobApplication,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = jobApplication.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(jobApplication.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByJobApplication,
				getEmployeeDAO()::findEmployeeByJobApplication
				);

		
		jobApplication.setEmployeeList(newList);
		

		return jobApplication;
	}			
		

	
    public SmartList<JobApplication> requestCandidateJobApplicationForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(JobApplicationTable.COLUMN_APPLICATION_TIME, filterKey, pageNo, pageSize, getJobApplicationMapper());
    }
		

	protected String getTableName(){
		return JobApplicationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<JobApplication> jobApplicationList) {		
		this.enhanceListInternal(jobApplicationList, this.getJobApplicationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<JobApplication> jobApplicationList = ownerEntity.collectRefsWithType(JobApplication.INTERNAL_TYPE);
		this.enhanceList(jobApplicationList);
		
	}
	
	@Override
	public SmartList<JobApplication> findJobApplicationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getJobApplicationMapper());

	}
	@Override
	public int countJobApplicationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countJobApplicationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<JobApplication> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getJobApplicationMapper());
	}
}


