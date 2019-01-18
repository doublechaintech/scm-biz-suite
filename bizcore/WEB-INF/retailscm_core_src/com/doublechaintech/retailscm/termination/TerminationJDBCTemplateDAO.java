
package com.doublechaintech.retailscm.termination;

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
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

import com.doublechaintech.retailscm.terminationtype.TerminationTypeDAO;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class TerminationJDBCTemplateDAO extends RetailscmNamingServiceDAO implements TerminationDAO{
 
 	
 	private  TerminationTypeDAO  terminationTypeDAO;
 	public void setTerminationTypeDAO(TerminationTypeDAO terminationTypeDAO){
	 	this.terminationTypeDAO = terminationTypeDAO;
 	}
 	public TerminationTypeDAO getTerminationTypeDAO(){
	 	return this.terminationTypeDAO;
 	}
 
 	
 	private  TerminationReasonDAO  terminationReasonDAO;
 	public void setTerminationReasonDAO(TerminationReasonDAO terminationReasonDAO){
	 	this.terminationReasonDAO = terminationReasonDAO;
 	}
 	public TerminationReasonDAO getTerminationReasonDAO(){
	 	return this.terminationReasonDAO;
 	}


			
		
	
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
	protected Termination load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTermination(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Termination load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTermination(TerminationTable.withId(id), options);
	}
	
	
	
	public Termination save(Termination termination,Map<String,Object> options){
		
		String methodName="save(Termination termination,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(termination, methodName, "termination");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTermination(termination,options);
	}
	public Termination clone(String terminationId, Map<String,Object> options) throws Exception{
	
		return clone(TerminationTable.withId(terminationId),options);
	}
	
	protected Termination clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String terminationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Termination newTermination = loadInternalTermination(accessKey, options);
		newTermination.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newTermination.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTermination(newTermination,options);
		
		return newTermination;
	}
	
	
	
	

	protected void throwIfHasException(String terminationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TerminationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TerminationNotFoundException(
					"The " + this.getTableName() + "(" + terminationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String terminationId, int version) throws Exception{
	
		String methodName="delete(String terminationId, int version)";
		assertMethodArgumentNotNull(terminationId, methodName, "terminationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{terminationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(terminationId,version);
		}
		
	
	}
	
	
	
	
	

	public Termination disconnectFromAll(String terminationId, int version) throws Exception{
	
		
		Termination termination = loadInternalTermination(TerminationTable.withId(terminationId), emptyOptions());
		termination.clearFromAll();
		this.saveTermination(termination);
		return termination;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return TerminationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "termination";
	}
	@Override
	protected String getBeanName() {
		
		return "termination";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TerminationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractReasonEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TerminationTokens.REASON);
 	}

 	protected boolean isSaveReasonEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TerminationTokens.REASON);
 	}
 	

 	
  

 	protected boolean isExtractTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TerminationTokens.TYPE);
 	}

 	protected boolean isSaveTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TerminationTokens.TYPE);
 	}
 	

 	
 
		
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TerminationTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){		
 		return true;
 		//return checkOptions(options,TerminationTokens.EMPLOYEE_LIST+".analyze");
 	}
	
	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, TerminationTokens.EMPLOYEE_LIST);
		
 	}
 	
		

	

	protected TerminationMapper getTerminationMapper(){
		return new TerminationMapper();
	}

	
	
	protected Termination extractTermination(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Termination termination = loadSingleObject(accessKey, getTerminationMapper());
			return termination;
		}catch(EmptyResultDataAccessException e){
			throw new TerminationNotFoundException("Termination("+accessKey+") is not found!");
		}

	}

	
	

	protected Termination loadInternalTermination(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Termination termination = extractTermination(accessKey, loadOptions);
 	
 		if(isExtractReasonEnabled(loadOptions)){
	 		extractReason(termination, loadOptions);
 		}
  	
 		if(isExtractTypeEnabled(loadOptions)){
	 		extractType(termination, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(termination, loadOptions);
 		}	
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(termination, loadOptions);
 		}
 		
		
		return termination;
		
	}

	 

 	protected Termination extractReason(Termination termination, Map<String,Object> options) throws Exception{

		if(termination.getReason() == null){
			return termination;
		}
		String reasonId = termination.getReason().getId();
		if( reasonId == null){
			return termination;
		}
		TerminationReason reason = getTerminationReasonDAO().load(reasonId,options);
		if(reason != null){
			termination.setReason(reason);
		}
		
 		
 		return termination;
 	}
 		
  

 	protected Termination extractType(Termination termination, Map<String,Object> options) throws Exception{

		if(termination.getType() == null){
			return termination;
		}
		String typeId = termination.getType().getId();
		if( typeId == null){
			return termination;
		}
		TerminationType type = getTerminationTypeDAO().load(typeId,options);
		if(type != null){
			termination.setType(type);
		}
		
 		
 		return termination;
 	}
 		
 
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Termination extractEmployeeList(Termination termination, Map<String,Object> options){
		
		
		if(termination == null){
			return null;
		}
		if(termination.getId() == null){
			return termination;
		}

		
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByTermination(termination.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			termination.setEmployeeList(employeeList);
		}
		
		return termination;
	
	}	
	
	protected Termination analyzeEmployeeList(Termination termination, Map<String,Object> options){
		
		
		if(termination == null){
			return null;
		}
		if(termination.getId() == null){
			return termination;
		}

		
		
		SmartList<Employee> employeeList = termination.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByTermination(employeeList, termination.getId(), options);
			
		}
		
		return termination;
	
	}	
	
		
		
  	
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId,Map<String,Object> options){
 	
  		SmartList<Termination> resultList = queryWith(TerminationTable.COLUMN_REASON, terminationReasonId, options, getTerminationMapper());
		// analyzeTerminationByReason(resultList, terminationReasonId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Termination> resultList =  queryWithRange(TerminationTable.COLUMN_REASON, terminationReasonId, options, getTerminationMapper(), start, count);
 		//analyzeTerminationByReason(resultList, terminationReasonId, options);
 		return resultList;
 		
 	}
 	public void analyzeTerminationByReason(SmartList<Termination> resultList, String terminationReasonId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Termination.REASON_PROPERTY, terminationReasonId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTerminationByReason(String terminationReasonId,Map<String,Object> options){

 		return countWith(TerminationTable.COLUMN_REASON, terminationReasonId, options);
 	}
 	@Override
	public Map<String, Integer> countTerminationByReasonIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TerminationTable.COLUMN_REASON, ids, options);
	}
 	
  	
 	public SmartList<Termination> findTerminationByType(String terminationTypeId,Map<String,Object> options){
 	
  		SmartList<Termination> resultList = queryWith(TerminationTable.COLUMN_TYPE, terminationTypeId, options, getTerminationMapper());
		// analyzeTerminationByType(resultList, terminationTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Termination> resultList =  queryWithRange(TerminationTable.COLUMN_TYPE, terminationTypeId, options, getTerminationMapper(), start, count);
 		//analyzeTerminationByType(resultList, terminationTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeTerminationByType(SmartList<Termination> resultList, String terminationTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Termination.TYPE_PROPERTY, terminationTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countTerminationByType(String terminationTypeId,Map<String,Object> options){

 		return countWith(TerminationTable.COLUMN_TYPE, terminationTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countTerminationByTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TerminationTable.COLUMN_TYPE, ids, options);
	}
 	
 	
		
		
		

	

	protected Termination saveTermination(Termination  termination){
		
		if(!termination.isChanged()){
			return termination;
		}
		
		
		String SQL=this.getSaveTerminationSQL(termination);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTerminationParameters(termination);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		termination.incVersion();
		return termination;
	
	}
	public SmartList<Termination> saveTerminationList(SmartList<Termination> terminationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTerminationList(terminationList);
		
		batchTerminationCreate((List<Termination>)lists[CREATE_LIST_INDEX]);
		
		batchTerminationUpdate((List<Termination>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Termination termination:terminationList){
			if(termination.isChanged()){
				termination.incVersion();
			}
			
		
		}
		
		
		return terminationList;
	}

	public SmartList<Termination> removeTerminationList(SmartList<Termination> terminationList,Map<String,Object> options){
		
		
		super.removeList(terminationList, options);
		
		return terminationList;
		
		
	}
	
	protected List<Object[]> prepareTerminationBatchCreateArgs(List<Termination> terminationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Termination termination:terminationList ){
			Object [] parameters = prepareTerminationCreateParameters(termination);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTerminationBatchUpdateArgs(List<Termination> terminationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Termination termination:terminationList ){
			if(!termination.isChanged()){
				continue;
			}
			Object [] parameters = prepareTerminationUpdateParameters(termination);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTerminationCreate(List<Termination> terminationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTerminationBatchCreateArgs(terminationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTerminationUpdate(List<Termination> terminationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTerminationBatchUpdateArgs(terminationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTerminationList(List<Termination> terminationList){
		
		List<Termination> terminationCreateList=new ArrayList<Termination>();
		List<Termination> terminationUpdateList=new ArrayList<Termination>();
		
		for(Termination termination: terminationList){
			if(isUpdateRequest(termination)){
				terminationUpdateList.add( termination);
				continue;
			}
			terminationCreateList.add(termination);
		}
		
		return new Object[]{terminationCreateList,terminationUpdateList};
	}
	
	protected boolean isUpdateRequest(Termination termination){
 		return termination.getVersion() > 0;
 	}
 	protected String getSaveTerminationSQL(Termination termination){
 		if(isUpdateRequest(termination)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTerminationParameters(Termination termination){
 		if(isUpdateRequest(termination) ){
 			return prepareTerminationUpdateParameters(termination);
 		}
 		return prepareTerminationCreateParameters(termination);
 	}
 	protected Object[] prepareTerminationUpdateParameters(Termination termination){
 		Object[] parameters = new Object[6];
  	
 		if(termination.getReason() != null){
 			parameters[0] = termination.getReason().getId();
 		}
  	
 		if(termination.getType() != null){
 			parameters[1] = termination.getType().getId();
 		}
 
 		parameters[2] = termination.getComment();		
 		parameters[3] = termination.nextVersion();
 		parameters[4] = termination.getId();
 		parameters[5] = termination.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTerminationCreateParameters(Termination termination){
		Object[] parameters = new Object[4];
		String newTerminationId=getNextId();
		termination.setId(newTerminationId);
		parameters[0] =  termination.getId();
  	
 		if(termination.getReason() != null){
 			parameters[1] = termination.getReason().getId();
 		
 		}
 		 	
 		if(termination.getType() != null){
 			parameters[2] = termination.getType().getId();
 		
 		}
 		
 		parameters[3] = termination.getComment();		
 				
 		return parameters;
 	}
 	
	protected Termination saveInternalTermination(Termination termination, Map<String,Object> options){
		
		saveTermination(termination);
 	
 		if(isSaveReasonEnabled(options)){
	 		saveReason(termination, options);
 		}
  	
 		if(isSaveTypeEnabled(options)){
	 		saveType(termination, options);
 		}
 
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(termination, options);
	 		//removeEmployeeList(termination, options);
	 		//Not delete the record
	 		
 		}		
		
		return termination;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Termination saveReason(Termination termination, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(termination.getReason() == null){
 			return termination;//do nothing when it is null
 		}
 		
 		getTerminationReasonDAO().save(termination.getReason(),options);
 		return termination;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Termination saveType(Termination termination, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(termination.getType() == null){
 			return termination;//do nothing when it is null
 		}
 		
 		getTerminationTypeDAO().save(termination.getType(),options);
 		return termination;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Termination planToRemoveEmployeeList(Termination termination, String employeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, termination.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return termination;
		}
		if(externalEmployeeList.isEmpty()){
			return termination;
		}
		
		for(Employee employee: externalEmployeeList){

			employee.clearFromAll();
		}
		
		
		SmartList<Employee> employeeList = termination.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return termination;	
	
	}


	//disconnect Termination with company in Employee
	public Termination planToRemoveEmployeeListWithCompany(Termination termination, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, termination.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return termination;
		}
		if(externalEmployeeList.isEmpty()){
			return termination;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCompany();
			employee.clearTermination();
			
		}
		
		
		SmartList<Employee> employeeList = termination.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return termination;
	}
	
	public int countEmployeeListWithCompany(String terminationId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, terminationId);
		key.put(Employee.COMPANY_PROPERTY, companyId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect Termination with department in Employee
	public Termination planToRemoveEmployeeListWithDepartment(Termination termination, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, termination.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return termination;
		}
		if(externalEmployeeList.isEmpty()){
			return termination;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearDepartment();
			employee.clearTermination();
			
		}
		
		
		SmartList<Employee> employeeList = termination.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return termination;
	}
	
	public int countEmployeeListWithDepartment(String terminationId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, terminationId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect Termination with occupation in Employee
	public Termination planToRemoveEmployeeListWithOccupation(Termination termination, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, termination.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return termination;
		}
		if(externalEmployeeList.isEmpty()){
			return termination;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearOccupation();
			employee.clearTermination();
			
		}
		
		
		SmartList<Employee> employeeList = termination.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return termination;
	}
	
	public int countEmployeeListWithOccupation(String terminationId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, terminationId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect Termination with responsible_for in Employee
	public Termination planToRemoveEmployeeListWithResponsibleFor(Termination termination, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, termination.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return termination;
		}
		if(externalEmployeeList.isEmpty()){
			return termination;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearResponsibleFor();
			employee.clearTermination();
			
		}
		
		
		SmartList<Employee> employeeList = termination.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return termination;
	}
	
	public int countEmployeeListWithResponsibleFor(String terminationId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, terminationId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect Termination with current_salary_grade in Employee
	public Termination planToRemoveEmployeeListWithCurrentSalaryGrade(Termination termination, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, termination.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return termination;
		}
		if(externalEmployeeList.isEmpty()){
			return termination;
		}
		
		for(Employee employee: externalEmployeeList){
			employee.clearCurrentSalaryGrade();
			employee.clearTermination();
			
		}
		
		
		SmartList<Employee> employeeList = termination.getEmployeeList();		
		employeeList.addAllToRemoveList(externalEmployeeList);
		return termination;
	}
	
	public int countEmployeeListWithCurrentSalaryGrade(String terminationId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.TERMINATION_PROPERTY, terminationId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);
		
		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected Termination saveEmployeeList(Termination termination, Map<String,Object> options){
		
		
		
		
		SmartList<Employee> employeeList = termination.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return termination;
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
		
		
		return termination;
	
	}
	
	protected Termination removeEmployeeList(Termination termination, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = termination.getEmployeeList();
		if(employeeList == null){
			return termination;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return termination;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return termination;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return termination;
	
	}
	
	

 	
 	
	
	
	
		

	public Termination present(Termination termination,Map<String, Object> options){
	
		presentEmployeeList(termination,options);

		return termination;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Termination presentEmployeeList(
			Termination termination,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = termination.getEmployeeList();		
				SmartList<Employee> newList= presentSubList(termination.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByTermination,
				getEmployeeDAO()::findEmployeeByTermination
				);

		
		termination.setEmployeeList(newList);
		

		return termination;
	}			
		

	
    public SmartList<Termination> requestCandidateTerminationForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TerminationTable.COLUMN_REASON, filterKey, pageNo, pageSize, getTerminationMapper());
    }
		

	protected String getTableName(){
		return TerminationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Termination> terminationList) {		
		this.enhanceListInternal(terminationList, this.getTerminationMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Termination> terminationList = ownerEntity.collectRefsWithType(Termination.INTERNAL_TYPE);
		this.enhanceList(terminationList);
		
	}
	
	@Override
	public SmartList<Termination> findTerminationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getTerminationMapper());

	}
	@Override
	public int countTerminationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countTerminationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Termination> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTerminationMapper());
	}
}


