
package com.doublechaintech.retailscm.occupationtype;

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

public class OccupationTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements OccupationTypeDAO{

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
	protected OccupationType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOccupationType(accessKey, options);
	}
	*/

	public SmartList<OccupationType> loadAll() {
	    return this.loadAll(getOccupationTypeMapper());
	}

  public Stream<OccupationType> loadAllAsStream() {
      return this.loadAllAsStream(getOccupationTypeMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public OccupationType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOccupationType(OccupationTypeTable.withId(id), options);
	}

	

	public OccupationType save(OccupationType occupationType,Map<String,Object> options){

		String methodName="save(OccupationType occupationType,Map<String,Object> options)";

		assertMethodArgumentNotNull(occupationType, methodName, "occupationType");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalOccupationType(occupationType,options);
	}
	public OccupationType clone(String occupationTypeId, Map<String,Object> options) throws Exception{

		return clone(OccupationTypeTable.withId(occupationTypeId),options);
	}

	protected OccupationType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String occupationTypeId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		OccupationType newOccupationType = loadInternalOccupationType(accessKey, options);
		newOccupationType.setVersion(0);
		
		

 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newOccupationType.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalOccupationType(newOccupationType,options);

		return newOccupationType;
	}

	



	protected void throwIfHasException(String occupationTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new OccupationTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OccupationTypeNotFoundException(
					"The " + this.getTableName() + "(" + occupationTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String occupationTypeId, int version) throws Exception{

		String methodName="delete(String occupationTypeId, int version)";
		assertMethodArgumentNotNull(occupationTypeId, methodName, "occupationTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{occupationTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(occupationTypeId,version);
		}


	}






	public OccupationType disconnectFromAll(String occupationTypeId, int version) throws Exception{


		OccupationType occupationType = loadInternalOccupationType(OccupationTypeTable.withId(occupationTypeId), emptyOptions());
		occupationType.clearFromAll();
		this.saveOccupationType(occupationType);
		return occupationType;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return OccupationTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "occupation_type";
	}
	@Override
	protected String getBeanName() {

		return "occupationType";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return OccupationTypeTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){

	 	return checkOptions(options, OccupationTypeTokens.COMPANY);
 	}

 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){

 		return checkOptions(options, OccupationTypeTokens.COMPANY);
 	}



 
		

	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
 		return checkOptions(options,OccupationTypeTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){
 		return OccupationTypeTokens.of(options).analyzeEmployeeListEnabled();
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, OccupationTypeTokens.EMPLOYEE_LIST);

 	}

		

	

	protected OccupationTypeMapper getOccupationTypeMapper(){
		return new OccupationTypeMapper();
	}



	protected OccupationType extractOccupationType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			OccupationType occupationType = loadSingleObject(accessKey, getOccupationTypeMapper());
			return occupationType;
		}catch(EmptyResultDataAccessException e){
			throw new OccupationTypeNotFoundException("OccupationType("+accessKey+") is not found!");
		}

	}




	protected OccupationType loadInternalOccupationType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		OccupationType occupationType = extractOccupationType(accessKey, loadOptions);

 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(occupationType, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(occupationType, loadOptions);
 		}

 		
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(occupationType, loadOptions);
 		}
 		
		
		return occupationType;

	}

	

 	protected OccupationType extractCompany(OccupationType occupationType, Map<String,Object> options) throws Exception{
  

		if(occupationType.getCompany() == null){
			return occupationType;
		}
		String companyId = occupationType.getCompany().getId();
		if( companyId == null){
			return occupationType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			occupationType.setCompany(company);
		}


 		return occupationType;
 	}

 
		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected OccupationType extractEmployeeList(OccupationType occupationType, Map<String,Object> options){
    

		if(occupationType == null){
			return null;
		}
		if(occupationType.getId() == null){
			return occupationType;
		}



		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByOccupation(occupationType.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			occupationType.setEmployeeList(employeeList);
		}

		return occupationType;
  
	}

	protected OccupationType analyzeEmployeeList(OccupationType occupationType, Map<String,Object> options){
     
		if(occupationType == null){
			return null;
		}
		if(occupationType.getId() == null){
			return occupationType;
		}



		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByOccupation(employeeList, occupationType.getId(), options);

		}

		return occupationType;
    
	}

		

 
 	public SmartList<OccupationType> findOccupationTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

  		SmartList<OccupationType> resultList = queryWith(OccupationTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getOccupationTypeMapper());
		// analyzeOccupationTypeByCompany(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	

 	public SmartList<OccupationType> findOccupationTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){

 		SmartList<OccupationType> resultList =  queryWithRange(OccupationTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getOccupationTypeMapper(), start, count);
 		//analyzeOccupationTypeByCompany(resultList, retailStoreCountryCenterId, options);
 		return resultList;

 	}
 	public void analyzeOccupationTypeByCompany(SmartList<OccupationType> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countOccupationTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(OccupationTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countOccupationTypeByCompanyIds(String[] ids, Map<String, Object> options) {
		return countWithIds(OccupationTypeTable.COLUMN_COMPANY, ids, options);
	}

 




	

	protected OccupationType saveOccupationType(OccupationType  occupationType){
    

		
		if(!occupationType.isChanged()){
			return occupationType;
		}
		

    Beans.dbUtil().cacheCleanUp(occupationType);
		String SQL=this.getSaveOccupationTypeSQL(occupationType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOccupationTypeParameters(occupationType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		occupationType.incVersion();
		occupationType.afterSave();
		return occupationType;

	}
	public SmartList<OccupationType> saveOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOccupationTypeList(occupationTypeList);

		batchOccupationTypeCreate((List<OccupationType>)lists[CREATE_LIST_INDEX]);

		batchOccupationTypeUpdate((List<OccupationType>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(OccupationType occupationType:occupationTypeList){
			if(occupationType.isChanged()){
				occupationType.incVersion();
				occupationType.afterSave();
			}


		}


		return occupationTypeList;
	}

	public SmartList<OccupationType> removeOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options){


		super.removeList(occupationTypeList, options);

		return occupationTypeList;


	}

	protected List<Object[]> prepareOccupationTypeBatchCreateArgs(List<OccupationType> occupationTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OccupationType occupationType:occupationTypeList ){
			Object [] parameters = prepareOccupationTypeCreateParameters(occupationType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareOccupationTypeBatchUpdateArgs(List<OccupationType> occupationTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OccupationType occupationType:occupationTypeList ){
			if(!occupationType.isChanged()){
				continue;
			}
			Object [] parameters = prepareOccupationTypeUpdateParameters(occupationType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchOccupationTypeCreate(List<OccupationType> occupationTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOccupationTypeBatchCreateArgs(occupationTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchOccupationTypeUpdate(List<OccupationType> occupationTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOccupationTypeBatchUpdateArgs(occupationTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitOccupationTypeList(List<OccupationType> occupationTypeList){

		List<OccupationType> occupationTypeCreateList=new ArrayList<OccupationType>();
		List<OccupationType> occupationTypeUpdateList=new ArrayList<OccupationType>();

		for(OccupationType occupationType: occupationTypeList){
			if(isUpdateRequest(occupationType)){
				occupationTypeUpdateList.add( occupationType);
				continue;
			}
			occupationTypeCreateList.add(occupationType);
		}

		return new Object[]{occupationTypeCreateList,occupationTypeUpdateList};
	}

	protected boolean isUpdateRequest(OccupationType occupationType){
 		return occupationType.getVersion() > 0;
 	}
 	protected String getSaveOccupationTypeSQL(OccupationType occupationType){
 		if(isUpdateRequest(occupationType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveOccupationTypeParameters(OccupationType occupationType){
 		if(isUpdateRequest(occupationType) ){
 			return prepareOccupationTypeUpdateParameters(occupationType);
 		}
 		return prepareOccupationTypeCreateParameters(occupationType);
 	}
 	protected Object[] prepareOccupationTypeUpdateParameters(OccupationType occupationType){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = occupationType.getCode();
 		
 		if(occupationType.getCompany() != null){
 			parameters[1] = occupationType.getCompany().getId();
 		}
    
 		parameters[2] = occupationType.getDescription();
 		
 		parameters[3] = occupationType.getDetailDescription();
 		
 		parameters[4] = occupationType.nextVersion();
 		parameters[5] = occupationType.getId();
 		parameters[6] = occupationType.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareOccupationTypeCreateParameters(OccupationType occupationType){
		Object[] parameters = new Object[5];
        if(occupationType.getId() == null){
          String newOccupationTypeId=getNextId();
          occupationType.setId(newOccupationTypeId);
        }
		parameters[0] =  occupationType.getId();
 
 		parameters[1] = occupationType.getCode();
 		
 		if(occupationType.getCompany() != null){
 			parameters[2] = occupationType.getCompany().getId();
 		}
 		
 		parameters[3] = occupationType.getDescription();
 		
 		parameters[4] = occupationType.getDetailDescription();
 		

 		return parameters;
 	}

	protected OccupationType saveInternalOccupationType(OccupationType occupationType, Map<String,Object> options){

 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(occupationType, options);
 		}
 
   saveOccupationType(occupationType);
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(occupationType, options);
	 		//removeEmployeeList(occupationType, options);
	 		//Not delete the record

 		}
		
		return occupationType;

	}



	//======================================================================================
	

 	protected OccupationType saveCompany(OccupationType occupationType, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(occupationType.getCompany() == null){
 			return occupationType;//do nothing when it is null
 		}

 		getRetailStoreCountryCenterDAO().save(occupationType.getCompany(),options);
 		return occupationType;

 	}
 

	
	public OccupationType planToRemoveEmployeeList(OccupationType occupationType, String employeeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationType.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return occupationType;
		}
		if(externalEmployeeList.isEmpty()){
			return occupationType;
		}

		for(Employee employeeItem: externalEmployeeList){

			employeeItem.clearFromAll();
		}


		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return occupationType;

	}


	//disconnect OccupationType with company in Employee
	public OccupationType planToRemoveEmployeeListWithCompany(OccupationType occupationType, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationType.getId());
		key.put(Employee.COMPANY_PROPERTY, companyId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return occupationType;
		}
		if(externalEmployeeList.isEmpty()){
			return occupationType;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCompany();
			employeeItem.clearOccupation();

		}


		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return occupationType;
	}

	public int countEmployeeListWithCompany(String occupationTypeId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationTypeId);
		key.put(Employee.COMPANY_PROPERTY, companyId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OccupationType with department in Employee
	public OccupationType planToRemoveEmployeeListWithDepartment(OccupationType occupationType, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationType.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return occupationType;
		}
		if(externalEmployeeList.isEmpty()){
			return occupationType;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearDepartment();
			employeeItem.clearOccupation();

		}


		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return occupationType;
	}

	public int countEmployeeListWithDepartment(String occupationTypeId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationTypeId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OccupationType with responsible_for in Employee
	public OccupationType planToRemoveEmployeeListWithResponsibleFor(OccupationType occupationType, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationType.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return occupationType;
		}
		if(externalEmployeeList.isEmpty()){
			return occupationType;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearResponsibleFor();
			employeeItem.clearOccupation();

		}


		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return occupationType;
	}

	public int countEmployeeListWithResponsibleFor(String occupationTypeId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationTypeId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect OccupationType with current_salary_grade in Employee
	public OccupationType planToRemoveEmployeeListWithCurrentSalaryGrade(OccupationType occupationType, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationType.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return occupationType;
		}
		if(externalEmployeeList.isEmpty()){
			return occupationType;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCurrentSalaryGrade();
			employeeItem.clearOccupation();

		}


		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return occupationType;
	}

	public int countEmployeeListWithCurrentSalaryGrade(String occupationTypeId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, occupationTypeId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected OccupationType saveEmployeeList(OccupationType occupationType, Map<String,Object> options){
    



		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return occupationType;
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


		return occupationType;

	}

	protected OccupationType removeEmployeeList(OccupationType occupationType, Map<String,Object> options){


		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		if(employeeList == null){
			return occupationType;
		}

		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();

		if(toRemoveEmployeeList == null){
			return occupationType;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return occupationType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);

		return occupationType;

	}








		

	public OccupationType present(OccupationType occupationType,Map<String, Object> options){

		presentEmployeeList(occupationType,options);

		return occupationType;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected OccupationType presentEmployeeList(
			OccupationType occupationType,
			Map<String, Object> options) {
    
		SmartList<Employee> employeeList = occupationType.getEmployeeList();
				SmartList<Employee> newList= presentSubList(occupationType.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByOccupation,
				getEmployeeDAO()::findEmployeeByOccupation
				);


		occupationType.setEmployeeList(newList);


		return occupationType;
	}
		

	
    public SmartList<OccupationType> requestCandidateOccupationTypeForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(OccupationTypeTable.COLUMN_CODE, OccupationTypeTable.COLUMN_COMPANY, filterKey, pageNo, pageSize, getOccupationTypeMapper());
    }
		

	protected String getTableName(){
		return OccupationTypeTable.TABLE_NAME;
	}



	public void enhanceList(List<OccupationType> occupationTypeList) {
		this.enhanceListInternal(occupationTypeList, this.getOccupationTypeMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Employee的occupation的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<OccupationType> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.OCCUPATION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Employee> loadedObjs = userContext.getDAOGroup().getEmployeeDAO().findEmployeeWithKey(key, options);
		Map<String, List<Employee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOccupation().getId()));
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
		List<OccupationType> occupationTypeList = ownerEntity.collectRefsWithType(OccupationType.INTERNAL_TYPE);
		this.enhanceList(occupationTypeList);

	}

	@Override
	public SmartList<OccupationType> findOccupationTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getOccupationTypeMapper());

	}
	@Override
	public int countOccupationTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countOccupationTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<OccupationType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getOccupationTypeMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<OccupationType> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getOccupationTypeMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateOccupationType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateOccupationType result = new CandidateOccupationType();
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
  public List<OccupationType> search(OccupationTypeRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected OccupationTypeMapper mapper() {
    return getOccupationTypeMapper();
  }
}


