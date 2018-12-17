
package com.doublechaintech.retailscm.hrinterview;

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

public class HrInterviewJDBCTemplateDAO extends RetailscmNamingServiceDAO implements HrInterviewDAO{


			
		
	
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
	protected HrInterview load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalHrInterview(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public HrInterview load(String id,Map<String,Object> options) throws Exception{
		return loadInternalHrInterview(HrInterviewTable.withId(id), options);
	}
	
	
	
	public HrInterview save(HrInterview hrInterview,Map<String,Object> options){
		
		String methodName="save(HrInterview hrInterview,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(hrInterview, methodName, "hrInterview");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalHrInterview(hrInterview,options);
	}
	public HrInterview clone(String hrInterviewId, Map<String,Object> options) throws Exception{
	
		return clone(HrInterviewTable.withId(hrInterviewId),options);
	}
	
	protected HrInterview clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String hrInterviewId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		HrInterview newHrInterview = loadInternalHrInterview(accessKey, options);
		newHrInterview.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newHrInterview.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalHrInterview(newHrInterview,options);
		
		return newHrInterview;
	}
	
	
	
	

	protected void throwIfHasException(String hrInterviewId,int version,int count) throws Exception{
		if (count == 1) {
			throw new HrInterviewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new HrInterviewNotFoundException(
					"The " + this.getTableName() + "(" + hrInterviewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String hrInterviewId, int version) throws Exception{
	
		String methodName="delete(String hrInterviewId, int version)";
		assertMethodArgumentNotNull(hrInterviewId, methodName, "hrInterviewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{hrInterviewId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(hrInterviewId,version);
		}
		
	
	}
	
	
	
	
	

	public HrInterview disconnectFromAll(String hrInterviewId, int version) throws Exception{
	
		
		HrInterview hrInterview = loadInternalHrInterview(HrInterviewTable.withId(hrInterviewId), emptyOptions());
		hrInterview.clearFromAll();
		this.saveHrInterview(hrInterview);
		return hrInterview;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return HrInterviewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "hr_interview";
	}
	@Override
	protected String getBeanName() {
		
		return "hrInterview";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return HrInterviewTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,HrInterviewTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, HrInterviewTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected HrInterviewMapper getHrInterviewMapper(){
		return new HrInterviewMapper();
	}

	
	
	protected HrInterview extractHrInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			HrInterview hrInterview = loadSingleObject(accessKey, getHrInterviewMapper());
			return hrInterview;
		}catch(EmptyResultDataAccessException e){
			throw new HrInterviewNotFoundException("HrInterview("+accessKey+") is not found!");
		}

	}

	
	

	protected HrInterview loadInternalHrInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		HrInterview hrInterview = extractHrInterview(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(hrInterview, loadOptions);
 		}		
		
		return hrInterview;
		
	}



	
	
	
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected HrInterview extractEmployeeList(HrInterview hrInterview, Map<String,Object> options){
		
		
		if(hrInterview == null){
			return null;
		}
		if(hrInterview.getId() == null){
			return hrInterview;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByHrInterview(hrInterview.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			hrInterview.setEmployeeList(employeeList);
		}
		
		return hrInterview;
	
	}	
		
		
 	
		
		
		

	

	protected HrInterview saveHrInterview(HrInterview  hrInterview){
		
		if(!hrInterview.isChanged()){
			return hrInterview;
		}
		
		
		String SQL=this.getSaveHrInterviewSQL(hrInterview);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveHrInterviewParameters(hrInterview);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		hrInterview.incVersion();
		return hrInterview;
	
	}
	public SmartList<HrInterview> saveHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitHrInterviewList(hrInterviewList);
		
		batchHrInterviewCreate((List<HrInterview>)lists[CREATE_LIST_INDEX]);
		
		batchHrInterviewUpdate((List<HrInterview>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(HrInterview hrInterview:hrInterviewList){
			if(hrInterview.isChanged()){
				hrInterview.incVersion();
			}
			
		
		}
		
		
		return hrInterviewList;
	}

	public SmartList<HrInterview> removeHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options){
		
		
		super.removeList(hrInterviewList, options);
		
		return hrInterviewList;
		
		
	}
	
	protected List<Object[]> prepareHrInterviewBatchCreateArgs(List<HrInterview> hrInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(HrInterview hrInterview:hrInterviewList ){
			Object [] parameters = prepareHrInterviewCreateParameters(hrInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareHrInterviewBatchUpdateArgs(List<HrInterview> hrInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(HrInterview hrInterview:hrInterviewList ){
			if(!hrInterview.isChanged()){
				continue;
			}
			Object [] parameters = prepareHrInterviewUpdateParameters(hrInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchHrInterviewCreate(List<HrInterview> hrInterviewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareHrInterviewBatchCreateArgs(hrInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchHrInterviewUpdate(List<HrInterview> hrInterviewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareHrInterviewBatchUpdateArgs(hrInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitHrInterviewList(List<HrInterview> hrInterviewList){
		
		List<HrInterview> hrInterviewCreateList=new ArrayList<HrInterview>();
		List<HrInterview> hrInterviewUpdateList=new ArrayList<HrInterview>();
		
		for(HrInterview hrInterview: hrInterviewList){
			if(isUpdateRequest(hrInterview)){
				hrInterviewUpdateList.add( hrInterview);
				continue;
			}
			hrInterviewCreateList.add(hrInterview);
		}
		
		return new Object[]{hrInterviewCreateList,hrInterviewUpdateList};
	}
	
	protected boolean isUpdateRequest(HrInterview hrInterview){
 		return hrInterview.getVersion() > 0;
 	}
 	protected String getSaveHrInterviewSQL(HrInterview hrInterview){
 		if(isUpdateRequest(hrInterview)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveHrInterviewParameters(HrInterview hrInterview){
 		if(isUpdateRequest(hrInterview) ){
 			return prepareHrInterviewUpdateParameters(hrInterview);
 		}
 		return prepareHrInterviewCreateParameters(hrInterview);
 	}
 	protected Object[] prepareHrInterviewUpdateParameters(HrInterview hrInterview){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = hrInterview.getWho();
 		parameters[1] = hrInterview.getInterviewTime();
 		parameters[2] = hrInterview.getComments();		
 		parameters[3] = hrInterview.nextVersion();
 		parameters[4] = hrInterview.getId();
 		parameters[5] = hrInterview.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareHrInterviewCreateParameters(HrInterview hrInterview){
		Object[] parameters = new Object[4];
		String newHrInterviewId=getNextId();
		hrInterview.setId(newHrInterviewId);
		parameters[0] =  hrInterview.getId();
 
 		parameters[1] = hrInterview.getWho();
 		parameters[2] = hrInterview.getInterviewTime();
 		parameters[3] = hrInterview.getComments();		
 				
 		return parameters;
 	}
 	
	protected HrInterview saveInternalHrInterview(HrInterview hrInterview, Map<String,Object> options){
		
		saveHrInterview(hrInterview);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(hrInterview, options);
	 		//removeEmployeeList(hrInterview, options);
	 		//Not delete the record
	 		
 		}		
		
		return hrInterview;
		
	}
	
	
	
	//======================================================================================
	

	
	public HrInterview planToRemoveEmployeeList(HrInterview hrInterview, String employeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterview.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return hrInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return hrInterview;
		}
		
		for(Employee employee: externalEmployeeList){

			employee.clearFromAll();
		}
		
		
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return hrInterview;	
	
	}


	//disconnect HrInterview with company in Employee
	public HrInterview planToRemoveEmployeeListWithCompany(HrInterview hrInterview, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterview.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return hrInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return hrInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCompany();
			employee.clearHrInterview();
			
		}
		
		
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return hrInterview;
	}
	
	public int countEmployeeListWithCompany(String hrInterviewId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterviewId);
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect HrInterview with department in Employee
	public HrInterview planToRemoveEmployeeListWithDepartment(HrInterview hrInterview, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterview.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return hrInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return hrInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearDepartment();
			employee.clearHrInterview();
			
		}
		
		
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return hrInterview;
	}
	
	public int countEmployeeListWithDepartment(String hrInterviewId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterviewId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect HrInterview with occupation in Employee
	public HrInterview planToRemoveEmployeeListWithOccupation(HrInterview hrInterview, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterview.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return hrInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return hrInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearOccupation();
			employee.clearHrInterview();
			
		}
		
		
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return hrInterview;
	}
	
	public int countEmployeeListWithOccupation(String hrInterviewId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterviewId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect HrInterview with responsible_for in Employee
	public HrInterview planToRemoveEmployeeListWithResponsibleFor(HrInterview hrInterview, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterview.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return hrInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return hrInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearResponsibleFor();
			employee.clearHrInterview();
			
		}
		
		
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return hrInterview;
	}
	
	public int countEmployeeListWithResponsibleFor(String hrInterviewId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterviewId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect HrInterview with current_salary_grade in Employee
	public HrInterview planToRemoveEmployeeListWithCurrentSalaryGrade(HrInterview hrInterview, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterview.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return hrInterview;
		}
		if(externalEmployeeList.isEmpty()){
			return hrInterview;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCurrentSalaryGrade();
			employee.clearHrInterview();
			
		}
		
		
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return hrInterview;
	}
	
	public int countEmployeeListWithCurrentSalaryGrade(String hrInterviewId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.HR_INTERVIEW_PROPERTY, hrInterviewId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected HrInterview saveEmployeeList(HrInterview hrInterview, Map<String,Object> options){
		
		
		
		
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return hrInterview;
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
		
		
		return hrInterview;
	
	}
	
	protected HrInterview removeEmployeeList(HrInterview hrInterview, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = hrInterview.getEmployeeList();
		if(employeeList == null){
			return hrInterview;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return hrInterview;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return hrInterview;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return hrInterview;
	
	}
	
	

 	
 	
	
	
	
		

	public HrInterview present(HrInterview hrInterview,Map<String, Object> options){
	
		presentEmployeeList(hrInterview,options);

		return hrInterview;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected HrInterview presentEmployeeList(
			HrInterview hrInterview,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = hrInterview.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(hrInterview.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByHrInterview,
				getEmployeeDAO()::findEmployeeByHrInterview
				);

		
		hrInterview.setEmployeeList(newList);
		

		return hrInterview;
	}			
		

	
    public SmartList<HrInterview> requestCandidateHrInterviewForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(HrInterviewTable.COLUMN_WHO, filterKey, pageNo, pageSize, getHrInterviewMapper());
    }
		

	protected String getTableName(){
		return HrInterviewTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<HrInterview> hrInterviewList) {		
		this.enhanceListInternal(hrInterviewList, this.getHrInterviewMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<HrInterview> hrInterviewList = ownerEntity.collectRefsWithType(HrInterview.INTERNAL_TYPE);
		this.enhanceList(hrInterviewList);
		
	}
	
	@Override
	public SmartList<HrInterview> findHrInterviewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getHrInterviewMapper());

	}
	@Override
	public int countHrInterviewWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countHrInterviewWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<HrInterview> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getHrInterviewMapper());
	}
}


