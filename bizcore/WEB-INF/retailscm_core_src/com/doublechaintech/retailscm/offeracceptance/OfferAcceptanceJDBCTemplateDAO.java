
package com.doublechaintech.retailscm.offeracceptance;

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

public class OfferAcceptanceJDBCTemplateDAO extends RetailscmNamingServiceDAO implements OfferAcceptanceDAO{


			
		
	
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
	protected OfferAcceptance load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOfferAcceptance(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public OfferAcceptance load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOfferAcceptance(OfferAcceptanceTable.withId(id), options);
	}
	
	
	
	public OfferAcceptance save(OfferAcceptance offerAcceptance,Map<String,Object> options){
		
		String methodName="save(OfferAcceptance offerAcceptance,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(offerAcceptance, methodName, "offerAcceptance");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOfferAcceptance(offerAcceptance,options);
	}
	public OfferAcceptance clone(String offerAcceptanceId, Map<String,Object> options) throws Exception{
	
		return clone(OfferAcceptanceTable.withId(offerAcceptanceId),options);
	}
	
	protected OfferAcceptance clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String offerAcceptanceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OfferAcceptance newOfferAcceptance = loadInternalOfferAcceptance(accessKey, options);
		newOfferAcceptance.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newOfferAcceptance.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOfferAcceptance(newOfferAcceptance,options);
		
		return newOfferAcceptance;
	}
	
	
	
	

	protected void throwIfHasException(String offerAcceptanceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new OfferAcceptanceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OfferAcceptanceNotFoundException(
					"The " + this.getTableName() + "(" + offerAcceptanceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String offerAcceptanceId, int version) throws Exception{
	
		String methodName="delete(String offerAcceptanceId, int version)";
		assertMethodArgumentNotNull(offerAcceptanceId, methodName, "offerAcceptanceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{offerAcceptanceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(offerAcceptanceId,version);
		}
		
	
	}
	
	
	
	
	

	public OfferAcceptance disconnectFromAll(String offerAcceptanceId, int version) throws Exception{
	
		
		OfferAcceptance offerAcceptance = loadInternalOfferAcceptance(OfferAcceptanceTable.withId(offerAcceptanceId), emptyOptions());
		offerAcceptance.clearFromAll();
		this.saveOfferAcceptance(offerAcceptance);
		return offerAcceptance;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return OfferAcceptanceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "offer_acceptance";
	}
	@Override
	protected String getBeanName() {
		
		return "offerAcceptance";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OfferAcceptanceTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,OfferAcceptanceTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,OfferAcceptanceTokens.EMPLOYEE_LIST+".analyze");
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, OfferAcceptanceTokens.EMPLOYEE_LIST);
		
 	}
 	
		

	

	protected OfferAcceptanceMapper getOfferAcceptanceMapper(){
		return new OfferAcceptanceMapper();
	}

	
	
	protected OfferAcceptance extractOfferAcceptance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			OfferAcceptance offerAcceptance = loadSingleObject(accessKey, getOfferAcceptanceMapper());
			return offerAcceptance;
		}catch(EmptyResultDataAccessException e){
			throw new OfferAcceptanceNotFoundException("OfferAcceptance("+accessKey+") is not found!");
		}

	}

	
	

	protected OfferAcceptance loadInternalOfferAcceptance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OfferAcceptance offerAcceptance = extractOfferAcceptance(accessKey, loadOptions);

		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(offerAcceptance, loadOptions);
 		}	
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		// analyzeEmployeeList(offerAcceptance, loadOptions);
 		}
 		
		
		return offerAcceptance;
		
	}

	
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected OfferAcceptance extractEmployeeList(OfferAcceptance offerAcceptance, Map<String,Object> options){
		
		
		if(offerAcceptance == null){
			return null;
		}
		if(offerAcceptance.getId() == null){
			return offerAcceptance;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByOfferAcceptance(offerAcceptance.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			offerAcceptance.setEmployeeList(employeeList);
		}
		
		return offerAcceptance;
	
	}	
	
	protected OfferAcceptance analyzeEmployeeList(OfferAcceptance offerAcceptance, Map<String,Object> options){
		
		
		if(offerAcceptance == null){
			return null;
		}
		if(offerAcceptance.getId() == null){
			return offerAcceptance;
		}

		
		
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByOfferAcceptance(employeeList, offerAcceptance.getId(), options);
			
		}
		
		return offerAcceptance;
	
	}	
	
		
		
 	
		
		
		

	

	protected OfferAcceptance saveOfferAcceptance(OfferAcceptance  offerAcceptance){
		
		if(!offerAcceptance.isChanged()){
			return offerAcceptance;
		}
		
		
		String SQL=this.getSaveOfferAcceptanceSQL(offerAcceptance);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOfferAcceptanceParameters(offerAcceptance);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		offerAcceptance.incVersion();
		return offerAcceptance;
	
	}
	public SmartList<OfferAcceptance> saveOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOfferAcceptanceList(offerAcceptanceList);
		
		batchOfferAcceptanceCreate((List<OfferAcceptance>)lists[CREATE_LIST_INDEX]);
		
		batchOfferAcceptanceUpdate((List<OfferAcceptance>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OfferAcceptance offerAcceptance:offerAcceptanceList){
			if(offerAcceptance.isChanged()){
				offerAcceptance.incVersion();
			}
			
		
		}
		
		
		return offerAcceptanceList;
	}

	public SmartList<OfferAcceptance> removeOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options){
		
		
		super.removeList(offerAcceptanceList, options);
		
		return offerAcceptanceList;
		
		
	}
	
	protected List<Object[]> prepareOfferAcceptanceBatchCreateArgs(List<OfferAcceptance> offerAcceptanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OfferAcceptance offerAcceptance:offerAcceptanceList ){
			Object [] parameters = prepareOfferAcceptanceCreateParameters(offerAcceptance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOfferAcceptanceBatchUpdateArgs(List<OfferAcceptance> offerAcceptanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OfferAcceptance offerAcceptance:offerAcceptanceList ){
			if(!offerAcceptance.isChanged()){
				continue;
			}
			Object [] parameters = prepareOfferAcceptanceUpdateParameters(offerAcceptance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOfferAcceptanceCreate(List<OfferAcceptance> offerAcceptanceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOfferAcceptanceBatchCreateArgs(offerAcceptanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOfferAcceptanceUpdate(List<OfferAcceptance> offerAcceptanceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOfferAcceptanceBatchUpdateArgs(offerAcceptanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOfferAcceptanceList(List<OfferAcceptance> offerAcceptanceList){
		
		List<OfferAcceptance> offerAcceptanceCreateList=new ArrayList<OfferAcceptance>();
		List<OfferAcceptance> offerAcceptanceUpdateList=new ArrayList<OfferAcceptance>();
		
		for(OfferAcceptance offerAcceptance: offerAcceptanceList){
			if(isUpdateRequest(offerAcceptance)){
				offerAcceptanceUpdateList.add( offerAcceptance);
				continue;
			}
			offerAcceptanceCreateList.add(offerAcceptance);
		}
		
		return new Object[]{offerAcceptanceCreateList,offerAcceptanceUpdateList};
	}
	
	protected boolean isUpdateRequest(OfferAcceptance offerAcceptance){
 		return offerAcceptance.getVersion() > 0;
 	}
 	protected String getSaveOfferAcceptanceSQL(OfferAcceptance offerAcceptance){
 		if(isUpdateRequest(offerAcceptance)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOfferAcceptanceParameters(OfferAcceptance offerAcceptance){
 		if(isUpdateRequest(offerAcceptance) ){
 			return prepareOfferAcceptanceUpdateParameters(offerAcceptance);
 		}
 		return prepareOfferAcceptanceCreateParameters(offerAcceptance);
 	}
 	protected Object[] prepareOfferAcceptanceUpdateParameters(OfferAcceptance offerAcceptance){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = offerAcceptance.getWho();
 		parameters[1] = offerAcceptance.getAcceptTime();
 		parameters[2] = offerAcceptance.getComments();		
 		parameters[3] = offerAcceptance.nextVersion();
 		parameters[4] = offerAcceptance.getId();
 		parameters[5] = offerAcceptance.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOfferAcceptanceCreateParameters(OfferAcceptance offerAcceptance){
		Object[] parameters = new Object[4];
		String newOfferAcceptanceId=getNextId();
		offerAcceptance.setId(newOfferAcceptanceId);
		parameters[0] =  offerAcceptance.getId();
 
 		parameters[1] = offerAcceptance.getWho();
 		parameters[2] = offerAcceptance.getAcceptTime();
 		parameters[3] = offerAcceptance.getComments();		
 				
 		return parameters;
 	}
 	
	protected OfferAcceptance saveInternalOfferAcceptance(OfferAcceptance offerAcceptance, Map<String,Object> options){
		
		saveOfferAcceptance(offerAcceptance);

		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(offerAcceptance, options);
	 		//removeEmployeeList(offerAcceptance, options);
	 		//Not delete the record
	 		
 		}		
		
		return offerAcceptance;
		
	}
	
	
	
	//======================================================================================
	

	
	public OfferAcceptance planToRemoveEmployeeList(OfferAcceptance offerAcceptance, String employeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptance.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerAcceptance;
		}
		if(externalEmployeeList.isEmpty()){
			return offerAcceptance;
		}
		
		for(Employee employee: externalEmployeeList){

			employee.clearFromAll();
		}
		
		
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerAcceptance;	
	
	}


	//disconnect OfferAcceptance with company in Employee
	public OfferAcceptance planToRemoveEmployeeListWithCompany(OfferAcceptance offerAcceptance, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptance.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerAcceptance;
		}
		if(externalEmployeeList.isEmpty()){
			return offerAcceptance;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCompany();
			employee.clearOfferAcceptance();
			
		}
		
		
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerAcceptance;
	}
	
	public int countEmployeeListWithCompany(String offerAcceptanceId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptanceId);
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OfferAcceptance with department in Employee
	public OfferAcceptance planToRemoveEmployeeListWithDepartment(OfferAcceptance offerAcceptance, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptance.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerAcceptance;
		}
		if(externalEmployeeList.isEmpty()){
			return offerAcceptance;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearDepartment();
			employee.clearOfferAcceptance();
			
		}
		
		
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerAcceptance;
	}
	
	public int countEmployeeListWithDepartment(String offerAcceptanceId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptanceId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OfferAcceptance with occupation in Employee
	public OfferAcceptance planToRemoveEmployeeListWithOccupation(OfferAcceptance offerAcceptance, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptance.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerAcceptance;
		}
		if(externalEmployeeList.isEmpty()){
			return offerAcceptance;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearOccupation();
			employee.clearOfferAcceptance();
			
		}
		
		
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerAcceptance;
	}
	
	public int countEmployeeListWithOccupation(String offerAcceptanceId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptanceId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OfferAcceptance with responsible_for in Employee
	public OfferAcceptance planToRemoveEmployeeListWithResponsibleFor(OfferAcceptance offerAcceptance, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptance.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerAcceptance;
		}
		if(externalEmployeeList.isEmpty()){
			return offerAcceptance;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearResponsibleFor();
			employee.clearOfferAcceptance();
			
		}
		
		
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerAcceptance;
	}
	
	public int countEmployeeListWithResponsibleFor(String offerAcceptanceId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptanceId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OfferAcceptance with current_salary_grade in Employee
	public OfferAcceptance planToRemoveEmployeeListWithCurrentSalaryGrade(OfferAcceptance offerAcceptance, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptance.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return offerAcceptance;
		}
		if(externalEmployeeList.isEmpty()){
			return offerAcceptance;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCurrentSalaryGrade();
			employee.clearOfferAcceptance();
			
		}
		
		
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return offerAcceptance;
	}
	
	public int countEmployeeListWithCurrentSalaryGrade(String offerAcceptanceId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OFFER_ACCEPTANCE_PROPERTY, offerAcceptanceId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected OfferAcceptance saveEmployeeList(OfferAcceptance offerAcceptance, Map<String,Object> options){
		
		
		
		
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return offerAcceptance;
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
		
		
		return offerAcceptance;
	
	}
	
	protected OfferAcceptance removeEmployeeList(OfferAcceptance offerAcceptance, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();
		if(employeeList == null){
			return offerAcceptance;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return offerAcceptance;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return offerAcceptance;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return offerAcceptance;
	
	}
	
	

 	
 	
	
	
	
		

	public OfferAcceptance present(OfferAcceptance offerAcceptance,Map<String, Object> options){
	
		presentEmployeeList(offerAcceptance,options);

		return offerAcceptance;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected OfferAcceptance presentEmployeeList(
			OfferAcceptance offerAcceptance,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = offerAcceptance.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(offerAcceptance.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByOfferAcceptance,
				getEmployeeDAO()::findEmployeeByOfferAcceptance
				);

		
		offerAcceptance.setEmployeeList(newList);
		

		return offerAcceptance;
	}			
		

	
    public SmartList<OfferAcceptance> requestCandidateOfferAcceptanceForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(OfferAcceptanceTable.COLUMN_WHO, filterKey, pageNo, pageSize, getOfferAcceptanceMapper());
    }
		

	protected String getTableName(){
		return OfferAcceptanceTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<OfferAcceptance> offerAcceptanceList) {		
		this.enhanceListInternal(offerAcceptanceList, this.getOfferAcceptanceMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<OfferAcceptance> offerAcceptanceList = ownerEntity.collectRefsWithType(OfferAcceptance.INTERNAL_TYPE);
		this.enhanceList(offerAcceptanceList);
		
	}
	
	@Override
	public SmartList<OfferAcceptance> findOfferAcceptanceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getOfferAcceptanceMapper());

	}
	@Override
	public int countOfferAcceptanceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countOfferAcceptanceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<OfferAcceptance> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getOfferAcceptanceMapper());
	}
}


