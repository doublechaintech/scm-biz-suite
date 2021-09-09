
package com.doublechaintech.retailscm.responsibilitytype;

import com.doublechaintech.retailscm.Beans;
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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ResponsibilityTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ResponsibilityTypeDAO{

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



	/*
	protected ResponsibilityType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalResponsibilityType(accessKey, options);
	}
	*/

	public SmartList<ResponsibilityType> loadAll() {
	    return this.loadAll(getResponsibilityTypeMapper());
	}

  public Stream<ResponsibilityType> loadAllAsStream() {
      return this.loadAllAsStream(getResponsibilityTypeMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ResponsibilityType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalResponsibilityType(ResponsibilityTypeTable.withId(id), options);
	}

	

	public ResponsibilityType save(ResponsibilityType responsibilityType,Map<String,Object> options){

		String methodName="save(ResponsibilityType responsibilityType,Map<String,Object> options)";

		assertMethodArgumentNotNull(responsibilityType, methodName, "responsibilityType");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalResponsibilityType(responsibilityType,options);
	}
	public ResponsibilityType clone(String responsibilityTypeId, Map<String,Object> options) throws Exception{

		return clone(ResponsibilityTypeTable.withId(responsibilityTypeId),options);
	}

	protected ResponsibilityType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String responsibilityTypeId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ResponsibilityType newResponsibilityType = loadInternalResponsibilityType(accessKey, options);
		newResponsibilityType.setVersion(0);
		
		

 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newResponsibilityType.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalResponsibilityType(newResponsibilityType,options);

		return newResponsibilityType;
	}

	



	protected void throwIfHasException(String responsibilityTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ResponsibilityTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ResponsibilityTypeNotFoundException(
					"The " + this.getTableName() + "(" + responsibilityTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String responsibilityTypeId, int version) throws Exception{

		String methodName="delete(String responsibilityTypeId, int version)";
		assertMethodArgumentNotNull(responsibilityTypeId, methodName, "responsibilityTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{responsibilityTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(responsibilityTypeId,version);
		}


	}






	public ResponsibilityType disconnectFromAll(String responsibilityTypeId, int version) throws Exception{


		ResponsibilityType responsibilityType = loadInternalResponsibilityType(ResponsibilityTypeTable.withId(responsibilityTypeId), emptyOptions());
		responsibilityType.clearFromAll();
		this.saveResponsibilityType(responsibilityType);
		return responsibilityType;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ResponsibilityTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "responsibility_type";
	}
	@Override
	protected String getBeanName() {

		return "responsibilityType";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return ResponsibilityTypeTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){

	 	return checkOptions(options, ResponsibilityTypeTokens.COMPANY);
 	}

 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){

 		return checkOptions(options, ResponsibilityTypeTokens.COMPANY);
 	}



 
		

	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
 		return checkOptions(options,ResponsibilityTypeTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){
 		return ResponsibilityTypeTokens.of(options).analyzeEmployeeListEnabled();
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, ResponsibilityTypeTokens.EMPLOYEE_LIST);

 	}

		

	

	protected ResponsibilityTypeMapper getResponsibilityTypeMapper(){
		return new ResponsibilityTypeMapper();
	}



	protected ResponsibilityType extractResponsibilityType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ResponsibilityType responsibilityType = loadSingleObject(accessKey, getResponsibilityTypeMapper());
			return responsibilityType;
		}catch(EmptyResultDataAccessException e){
			throw new ResponsibilityTypeNotFoundException("ResponsibilityType("+accessKey+") is not found!");
		}

	}




	protected ResponsibilityType loadInternalResponsibilityType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		ResponsibilityType responsibilityType = extractResponsibilityType(accessKey, loadOptions);

 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(responsibilityType, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(responsibilityType, loadOptions);
 		}

 		
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(responsibilityType, loadOptions);
 		}
 		
		
		return responsibilityType;

	}

	

 	protected ResponsibilityType extractCompany(ResponsibilityType responsibilityType, Map<String,Object> options) throws Exception{
  

		if(responsibilityType.getCompany() == null){
			return responsibilityType;
		}
		String companyId = responsibilityType.getCompany().getId();
		if( companyId == null){
			return responsibilityType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			responsibilityType.setCompany(company);
		}


 		return responsibilityType;
 	}

 
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected ResponsibilityType extractEmployeeList(ResponsibilityType responsibilityType, Map<String,Object> options){
    

		if(responsibilityType == null){
			return null;
		}
		if(responsibilityType.getId() == null){
			return responsibilityType;
		}



		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByResponsibleFor(responsibilityType.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			responsibilityType.setEmployeeList(employeeList);
		}

		return responsibilityType;
  
	}

	protected ResponsibilityType analyzeEmployeeList(ResponsibilityType responsibilityType, Map<String,Object> options){
     
		if(responsibilityType == null){
			return null;
		}
		if(responsibilityType.getId() == null){
			return responsibilityType;
		}



		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByResponsibleFor(employeeList, responsibilityType.getId(), options);

		}

		return responsibilityType;
    
	}

		

 
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

  		SmartList<ResponsibilityType> resultList = queryWith(ResponsibilityTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getResponsibilityTypeMapper());
		// analyzeResponsibilityTypeByCompany(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	

 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){

 		SmartList<ResponsibilityType> resultList =  queryWithRange(ResponsibilityTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getResponsibilityTypeMapper(), start, count);
 		//analyzeResponsibilityTypeByCompany(resultList, retailStoreCountryCenterId, options);
 		return resultList;

 	}
 	public void analyzeResponsibilityTypeByCompany(SmartList<ResponsibilityType> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countResponsibilityTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(ResponsibilityTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countResponsibilityTypeByCompanyIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ResponsibilityTypeTable.COLUMN_COMPANY, ids, options);
	}

 




	

	protected ResponsibilityType saveResponsibilityType(ResponsibilityType  responsibilityType){
    

		
		if(!responsibilityType.isChanged()){
			return responsibilityType;
		}
		

    Beans.dbUtil().cacheCleanUp(responsibilityType);
		String SQL=this.getSaveResponsibilityTypeSQL(responsibilityType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveResponsibilityTypeParameters(responsibilityType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		responsibilityType.incVersion();
		responsibilityType.afterSave();
		return responsibilityType;

	}
	public SmartList<ResponsibilityType> saveResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitResponsibilityTypeList(responsibilityTypeList);

		batchResponsibilityTypeCreate((List<ResponsibilityType>)lists[CREATE_LIST_INDEX]);

		batchResponsibilityTypeUpdate((List<ResponsibilityType>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ResponsibilityType responsibilityType:responsibilityTypeList){
			if(responsibilityType.isChanged()){
				responsibilityType.incVersion();
				responsibilityType.afterSave();
			}


		}


		return responsibilityTypeList;
	}

	public SmartList<ResponsibilityType> removeResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options){


		super.removeList(responsibilityTypeList, options);

		return responsibilityTypeList;


	}

	protected List<Object[]> prepareResponsibilityTypeBatchCreateArgs(List<ResponsibilityType> responsibilityTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ResponsibilityType responsibilityType:responsibilityTypeList ){
			Object [] parameters = prepareResponsibilityTypeCreateParameters(responsibilityType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareResponsibilityTypeBatchUpdateArgs(List<ResponsibilityType> responsibilityTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ResponsibilityType responsibilityType:responsibilityTypeList ){
			if(!responsibilityType.isChanged()){
				continue;
			}
			Object [] parameters = prepareResponsibilityTypeUpdateParameters(responsibilityType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchResponsibilityTypeCreate(List<ResponsibilityType> responsibilityTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareResponsibilityTypeBatchCreateArgs(responsibilityTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchResponsibilityTypeUpdate(List<ResponsibilityType> responsibilityTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareResponsibilityTypeBatchUpdateArgs(responsibilityTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitResponsibilityTypeList(List<ResponsibilityType> responsibilityTypeList){

		List<ResponsibilityType> responsibilityTypeCreateList=new ArrayList<ResponsibilityType>();
		List<ResponsibilityType> responsibilityTypeUpdateList=new ArrayList<ResponsibilityType>();

		for(ResponsibilityType responsibilityType: responsibilityTypeList){
			if(isUpdateRequest(responsibilityType)){
				responsibilityTypeUpdateList.add( responsibilityType);
				continue;
			}
			responsibilityTypeCreateList.add(responsibilityType);
		}

		return new Object[]{responsibilityTypeCreateList,responsibilityTypeUpdateList};
	}

	protected boolean isUpdateRequest(ResponsibilityType responsibilityType){
 		return responsibilityType.getVersion() > 0;
 	}
 	protected String getSaveResponsibilityTypeSQL(ResponsibilityType responsibilityType){
 		if(isUpdateRequest(responsibilityType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveResponsibilityTypeParameters(ResponsibilityType responsibilityType){
 		if(isUpdateRequest(responsibilityType) ){
 			return prepareResponsibilityTypeUpdateParameters(responsibilityType);
 		}
 		return prepareResponsibilityTypeCreateParameters(responsibilityType);
 	}
 	protected Object[] prepareResponsibilityTypeUpdateParameters(ResponsibilityType responsibilityType){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = responsibilityType.getCode();
 		
 		if(responsibilityType.getCompany() != null){
 			parameters[1] = responsibilityType.getCompany().getId();
 		}
    
 		parameters[2] = responsibilityType.getBaseDescription();
 		
 		parameters[3] = responsibilityType.getDetailDescription();
 		
 		parameters[4] = responsibilityType.nextVersion();
 		parameters[5] = responsibilityType.getId();
 		parameters[6] = responsibilityType.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareResponsibilityTypeCreateParameters(ResponsibilityType responsibilityType){
		Object[] parameters = new Object[5];
        if(responsibilityType.getId() == null){
          String newResponsibilityTypeId=getNextId();
          responsibilityType.setId(newResponsibilityTypeId);
        }
		parameters[0] =  responsibilityType.getId();
 
 		parameters[1] = responsibilityType.getCode();
 		
 		if(responsibilityType.getCompany() != null){
 			parameters[2] = responsibilityType.getCompany().getId();
 		}
 		
 		parameters[3] = responsibilityType.getBaseDescription();
 		
 		parameters[4] = responsibilityType.getDetailDescription();
 		

 		return parameters;
 	}

	protected ResponsibilityType saveInternalResponsibilityType(ResponsibilityType responsibilityType, Map<String,Object> options){

 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(responsibilityType, options);
 		}
 
   saveResponsibilityType(responsibilityType);
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(responsibilityType, options);
	 		//removeEmployeeList(responsibilityType, options);
	 		//Not delete the record

 		}
		
		return responsibilityType;

	}



	//======================================================================================
	

 	protected ResponsibilityType saveCompany(ResponsibilityType responsibilityType, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(responsibilityType.getCompany() == null){
 			return responsibilityType;//do nothing when it is null
 		}

 		getRetailStoreCountryCenterDAO().save(responsibilityType.getCompany(),options);
 		return responsibilityType;

 	}
 

	
	public ResponsibilityType planToRemoveEmployeeList(ResponsibilityType responsibilityType, String employeeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityType.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return responsibilityType;
		}
		if(externalEmployeeList.isEmpty()){
			return responsibilityType;
		}

		for(Employee employeeItem: externalEmployeeList){

			employeeItem.clearFromAll();
		}


		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return responsibilityType;

	}


	//disconnect ResponsibilityType with company in Employee
	public ResponsibilityType planToRemoveEmployeeListWithCompany(ResponsibilityType responsibilityType, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityType.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return responsibilityType;
		}
		if(externalEmployeeList.isEmpty()){
			return responsibilityType;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCompany();
			employeeItem.clearResponsibleFor();

		}


		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return responsibilityType;
	}

	public int countEmployeeListWithCompany(String responsibilityTypeId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityTypeId);
		key.put(Employee.COMPANY_PROPERTY, companyId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect ResponsibilityType with department in Employee
	public ResponsibilityType planToRemoveEmployeeListWithDepartment(ResponsibilityType responsibilityType, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityType.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return responsibilityType;
		}
		if(externalEmployeeList.isEmpty()){
			return responsibilityType;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearDepartment();
			employeeItem.clearResponsibleFor();

		}


		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return responsibilityType;
	}

	public int countEmployeeListWithDepartment(String responsibilityTypeId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityTypeId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect ResponsibilityType with occupation in Employee
	public ResponsibilityType planToRemoveEmployeeListWithOccupation(ResponsibilityType responsibilityType, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityType.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return responsibilityType;
		}
		if(externalEmployeeList.isEmpty()){
			return responsibilityType;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearOccupation();
			employeeItem.clearResponsibleFor();

		}


		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return responsibilityType;
	}

	public int countEmployeeListWithOccupation(String responsibilityTypeId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityTypeId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect ResponsibilityType with current_salary_grade in Employee
	public ResponsibilityType planToRemoveEmployeeListWithCurrentSalaryGrade(ResponsibilityType responsibilityType, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityType.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return responsibilityType;
		}
		if(externalEmployeeList.isEmpty()){
			return responsibilityType;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCurrentSalaryGrade();
			employeeItem.clearResponsibleFor();

		}


		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return responsibilityType;
	}

	public int countEmployeeListWithCurrentSalaryGrade(String responsibilityTypeId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityTypeId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected ResponsibilityType saveEmployeeList(ResponsibilityType responsibilityType, Map<String,Object> options){
    



		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return responsibilityType;
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


		return responsibilityType;

	}

	protected ResponsibilityType removeEmployeeList(ResponsibilityType responsibilityType, Map<String,Object> options){


		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		if(employeeList == null){
			return responsibilityType;
		}

		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();

		if(toRemoveEmployeeList == null){
			return responsibilityType;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return responsibilityType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);

		return responsibilityType;

	}








		

	public ResponsibilityType present(ResponsibilityType responsibilityType,Map<String, Object> options){

		presentEmployeeList(responsibilityType,options);

		return responsibilityType;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected ResponsibilityType presentEmployeeList(
			ResponsibilityType responsibilityType,
			Map<String, Object> options) {
    
		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
				SmartList<Employee> newList= presentSubList(responsibilityType.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByResponsibleFor,
				getEmployeeDAO()::findEmployeeByResponsibleFor
				);


		responsibilityType.setEmployeeList(newList);


		return responsibilityType;
	}
		

	
    public SmartList<ResponsibilityType> requestCandidateResponsibilityTypeForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ResponsibilityTypeTable.COLUMN_CODE, ResponsibilityTypeTable.COLUMN_COMPANY, filterKey, pageNo, pageSize, getResponsibilityTypeMapper());
    }
		

	protected String getTableName(){
		return ResponsibilityTypeTable.TABLE_NAME;
	}



	public void enhanceList(List<ResponsibilityType> responsibilityTypeList) {
		this.enhanceListInternal(responsibilityTypeList, this.getResponsibilityTypeMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Employee的responsibleFor的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<ResponsibilityType> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Employee> loadedObjs = userContext.getDAOGroup().getEmployeeDAO().findEmployeeWithKey(key, options);
		Map<String, List<Employee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getResponsibleFor().getId()));
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
		List<ResponsibilityType> responsibilityTypeList = ownerEntity.collectRefsWithType(ResponsibilityType.INTERNAL_TYPE);
		this.enhanceList(responsibilityTypeList);

	}

	@Override
	public SmartList<ResponsibilityType> findResponsibilityTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getResponsibilityTypeMapper());

	}
	@Override
	public int countResponsibilityTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countResponsibilityTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ResponsibilityType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getResponsibilityTypeMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<ResponsibilityType> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getResponsibilityTypeMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateResponsibilityType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateResponsibilityType result = new CandidateResponsibilityType();
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

	

  @Override
  public List<ResponsibilityType> search(ResponsibilityTypeRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected ResponsibilityTypeMapper mapper() {
    return getResponsibilityTypeMapper();
  }
}


