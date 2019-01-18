
package com.doublechaintech.retailscm.offerapproval;

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

public class OfferApprovalJDBCTemplateDAO extends RetailscmNamingServiceDAO implements OfferApprovalDAO{


			
		
	
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
	protected OfferApproval load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOfferApproval(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public OfferApproval load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOfferApproval(OfferApprovalTable.withId(id), options);
	}
	
	
	
	public OfferApproval save(OfferApproval offerApproval,Map<String,Object> options){
		
		String methodName="save(OfferApproval offerApproval,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(offerApproval, methodName, "offerApproval");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOfferApproval(offerApproval,options);
	}
	public OfferApproval clone(String offerApprovalId, Map<String,Object> options) throws Exception{
	
		return clone(OfferApprovalTable.withId(offerApprovalId),options);
	}
	
	protected OfferApproval clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String offerApprovalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OfferApproval newOfferApproval = loadInternalOfferApproval(accessKey, options);
		newOfferApproval.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newOfferApproval.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOfferApproval(newOfferApproval,options);
		
		return newOfferApproval;
	}
	
	
	
	

	protected void throwIfHasException(String offerApprovalId,int version,int count) throws Exception{
		if (count == 1) {
			throw new OfferApprovalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OfferApprovalNotFoundException(
					"The " + this.getTableName() + "(" + offerApprovalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String offerApprovalId, int version) throws Exception{
	
		String methodName="delete(String offerApprovalId, int version)";
		assertMethodArgumentNotNull(offerApprovalId, methodName, "offerApprovalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{offerApprovalId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(offerApprovalId,version);
		}
		
	
	}
	
	
	
	
	

	public OfferApproval disconnectFromAll(String offerApprovalId, int version) throws Exception{
	
		
		OfferApproval offerApproval = loadInternalOfferApproval(OfferApprovalTable.withId(offerApprovalId), emptyOptions());
		offerApproval.clearFromAll();
		this.saveOfferApproval(offerApproval);
		return offerApproval;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return OfferApprovalTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "offer_approval";
	}
	@Override
	protected String getBeanName() {
		
		return "offerApproval";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OfferApprovalTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,OfferApprovalTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,OfferApprovalTokens.EMPLOYEE_LIST+".analyze");
 	}
	
	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, OfferApprovalTokens.EMPLOYEE_LIST);
		
 	}
 	
		

	

	protected OfferApprovalMapper getOfferApprovalMapper(){
		return new OfferApprovalMapper();
	}

	
	
	protected OfferApproval extractOfferApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			OfferApproval offerApproval = loadSingleObject(accessKey, getOfferApprovalMapper());
			return offerApproval;
		}catch(EmptyResultDataAccessException e){
			throw new OfferApprovalNotFoundException("OfferApproval("+accessKey+") is not found!");
		}

	}

	
	

	protected OfferApproval loadInternalOfferApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OfferApproval offerApproval = extractOfferApproval(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(offerApproval, loadOptions);
 		}	
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(offerApproval, loadOptions);
 		}
 		
		
		return offerApproval;
		
	}

	
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected OfferApproval extractEmployeeList(OfferApproval offerApproval, Map<String,Object> options){
		
		
		if(offerApproval == null){
			return null;
		}
		if(offerApproval.getId() == null){
			return offerApproval;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByOfferApproval(offerApproval.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			offerApproval.setEmployeeList(employeeList);
		}
		
		return offerApproval;
	
	}	
	
	protected OfferApproval analyzeEmployeeList(OfferApproval offerApproval, Map<String,Object> options){
		
		
		if(offerApproval == null){
			return null;
		}
		if(offerApproval.getId() == null){
			return offerApproval;
		}

		
		
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByOfferApproval(employeeList, offerApproval.getId(), options);
			
		}
		
		return offerApproval;
	
	}	
	
		
		
 	
		
		
		

	

	protected OfferApproval saveOfferApproval(OfferApproval  offerApproval){
		
		if(!offerApproval.isChanged()){
			return offerApproval;
		}
		
		
		String SQL=this.getSaveOfferApprovalSQL(offerApproval);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOfferApprovalParameters(offerApproval);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		offerApproval.incVersion();
		return offerApproval;
	
	}
	public SmartList<OfferApproval> saveOfferApprovalList(SmartList<OfferApproval> offerApprovalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOfferApprovalList(offerApprovalList);
		
		batchOfferApprovalCreate((List<OfferApproval>)lists[CREATE_LIST_INDEX]);
		
		batchOfferApprovalUpdate((List<OfferApproval>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OfferApproval offerApproval:offerApprovalList){
			if(offerApproval.isChanged()){
				offerApproval.incVersion();
			}
			
		
		}
		
		
		return offerApprovalList;
	}

	public SmartList<OfferApproval> removeOfferApprovalList(SmartList<OfferApproval> offerApprovalList,Map<String,Object> options){
		
		
		super.removeList(offerApprovalList, options);
		
		return offerApprovalList;
		
		
	}
	
	protected List<Object[]> prepareOfferApprovalBatchCreateArgs(List<OfferApproval> offerApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OfferApproval offerApproval:offerApprovalList ){
			Object [] parameters = prepareOfferApprovalCreateParameters(offerApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOfferApprovalBatchUpdateArgs(List<OfferApproval> offerApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OfferApproval offerApproval:offerApprovalList ){
			if(!offerApproval.isChanged()){
				continue;
			}
			Object [] parameters = prepareOfferApprovalUpdateParameters(offerApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOfferApprovalCreate(List<OfferApproval> offerApprovalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOfferApprovalBatchCreateArgs(offerApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOfferApprovalUpdate(List<OfferApproval> offerApprovalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOfferApprovalBatchUpdateArgs(offerApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOfferApprovalList(List<OfferApproval> offerApprovalList){
		
		List<OfferApproval> offerApprovalCreateList=new ArrayList<OfferApproval>();
		List<OfferApproval> offerApprovalUpdateList=new ArrayList<OfferApproval>();
		
		for(OfferApproval offerApproval: offerApprovalList){
			if(isUpdateRequest(offerApproval)){
				offerApprovalUpdateList.add( offerApproval);
				continue;
			}
			offerApprovalCreateList.add(offerApproval);
		}
		
		return new Object[]{offerApprovalCreateList,offerApprovalUpdateList};
	}
	
	protected boolean isUpdateRequest(OfferApproval offerApproval){
 		return offerApproval.getVersion() > 0;
 	}
 	protected String getSaveOfferApprovalSQL(OfferApproval offerApproval){
 		if(isUpdateRequest(offerApproval)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOfferApprovalParameters(OfferApproval offerApproval){
 		if(isUpdateRequest(offerApproval) ){
 			return prepareOfferApprovalUpdateParameters(offerApproval);
 		}
 		return prepareOfferApprovalCreateParameters(offerApproval);
 	}
 	protected Object[] prepareOfferApprovalUpdateParameters(OfferApproval offerApproval){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = offerApproval.getWho();
 		parameters[1] = offerApproval.getApproveTime();
 		parameters[2] = offerApproval.getComments();		
 		parameters[3] = offerApproval.nextVersion();
 		parameters[4] = offerApproval.getId();
 		parameters[5] = offerApproval.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOfferApprovalCreateParameters(OfferApproval offerApproval){
		Object[] parameters = new Object[4];
		String newOfferApprovalId=getNextId();
		offerApproval.setId(newOfferApprovalId);
		parameters[0] =  offerApproval.getId();
 
 		parameters[1] = offerApproval.getWho();
 		parameters[2] = offerApproval.getApproveTime();
 		parameters[3] = offerApproval.getComments();		
 				
 		return parameters;
 	}
 	
	protected OfferApproval saveInternalOfferApproval(OfferApproval offerApproval, Map<String,Object> options){
		
		saveOfferApproval(offerApproval);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(offerApproval, options);
	 		//removeEmployeeList(offerApproval, options);
	 		//Not delete the record
	 		
 		}		
		
		return offerApproval;
		
	}
	
	
	
	//======================================================================================
	

	
	public OfferApproval planToRemoveEmployeeList(OfferApproval offerApproval, String employeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApproval.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerApproval;
		}
		if(externalEmployeeList.isEmpty()){
			return offerApproval;
		}
		
		for(Employee employee: externalEmployeeList){

			employee.clearFromAll();
		}
		
		
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerApproval;	
	
	}


	//disconnect OfferApproval with company in Employee
	public OfferApproval planToRemoveEmployeeListWithCompany(OfferApproval offerApproval, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApproval.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerApproval;
		}
		if(externalEmployeeList.isEmpty()){
			return offerApproval;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCompany();
			employee.clearOfferApproval();
			
		}
		
		
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerApproval;
	}
	
	public int countEmployeeListWithCompany(String offerApprovalId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApprovalId);
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OfferApproval with department in Employee
	public OfferApproval planToRemoveEmployeeListWithDepartment(OfferApproval offerApproval, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApproval.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerApproval;
		}
		if(externalEmployeeList.isEmpty()){
			return offerApproval;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearDepartment();
			employee.clearOfferApproval();
			
		}
		
		
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerApproval;
	}
	
	public int countEmployeeListWithDepartment(String offerApprovalId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApprovalId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OfferApproval with occupation in Employee
	public OfferApproval planToRemoveEmployeeListWithOccupation(OfferApproval offerApproval, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApproval.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerApproval;
		}
		if(externalEmployeeList.isEmpty()){
			return offerApproval;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearOccupation();
			employee.clearOfferApproval();
			
		}
		
		
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerApproval;
	}
	
	public int countEmployeeListWithOccupation(String offerApprovalId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApprovalId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OfferApproval with responsible_for in Employee
	public OfferApproval planToRemoveEmployeeListWithResponsibleFor(OfferApproval offerApproval, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApproval.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerApproval;
		}
		if(externalEmployeeList.isEmpty()){
			return offerApproval;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearResponsibleFor();
			employee.clearOfferApproval();
			
		}
		
		
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerApproval;
	}
	
	public int countEmployeeListWithResponsibleFor(String offerApprovalId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApprovalId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OfferApproval with current_salary_grade in Employee
	public OfferApproval planToRemoveEmployeeListWithCurrentSalaryGrade(OfferApproval offerApproval, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApproval.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerApproval;
		}
		if(externalEmployeeList.isEmpty()){
			return offerApproval;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCurrentSalaryGrade();
			employee.clearOfferApproval();
			
		}
		
		
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerApproval;
	}
	
	public int countEmployeeListWithCurrentSalaryGrade(String offerApprovalId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_APPROVAL_PROPERTY, offerApprovalId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected OfferApproval saveEmployeeList(OfferApproval offerApproval, Map<String,Object> options){
		
		
		
		
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return offerApproval;
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
		
		
		return offerApproval;
	
	}
	
	protected OfferApproval removeEmployeeList(OfferApproval offerApproval, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = offerApproval.getEmployeeList();
		if(employeeList == null){
			return offerApproval;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return offerApproval;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return offerApproval;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return offerApproval;
	
	}
	
	

 	
 	
	
	
	
		

	public OfferApproval present(OfferApproval offerApproval,Map<String, Object> options){
	
		presentEmployeeList(offerApproval,options);

		return offerApproval;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected OfferApproval presentEmployeeList(
			OfferApproval offerApproval,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = offerApproval.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(offerApproval.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByOfferApproval,
				getEmployeeDAO()::findEmployeeByOfferApproval
				);

		
		offerApproval.setEmployeeList(newList);
		

		return offerApproval;
	}			
		

	
    public SmartList<OfferApproval> requestCandidateOfferApprovalForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(OfferApprovalTable.COLUMN_WHO, filterKey, pageNo, pageSize, getOfferApprovalMapper());
    }
		

	protected String getTableName(){
		return OfferApprovalTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<OfferApproval> offerApprovalList) {		
		this.enhanceListInternal(offerApprovalList, this.getOfferApprovalMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<OfferApproval> offerApprovalList = ownerEntity.collectRefsWithType(OfferApproval.INTERNAL_TYPE);
		this.enhanceList(offerApprovalList);
		
	}
	
	@Override
	public SmartList<OfferApproval> findOfferApprovalWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getOfferApprovalMapper());

	}
	@Override
	public int countOfferApprovalWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countOfferApprovalWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<OfferApproval> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getOfferApprovalMapper());
	}
}


