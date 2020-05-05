
package com.doublechaintech.retailscm.companytraining;

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
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.instructor.InstructorDAO;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class CompanyTrainingJDBCTemplateDAO extends RetailscmBaseDAOImpl implements CompanyTrainingDAO{

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

	protected InstructorDAO instructorDAO;
	public void setInstructorDAO(InstructorDAO instructorDAO){
 	
 		if(instructorDAO == null){
 			throw new IllegalStateException("Do not try to set instructorDAO to null.");
 		}
	 	this.instructorDAO = instructorDAO;
 	}
 	public InstructorDAO getInstructorDAO(){
 		if(this.instructorDAO == null){
 			throw new IllegalStateException("The instructorDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.instructorDAO;
 	}	

	protected TrainingCourseTypeDAO trainingCourseTypeDAO;
	public void setTrainingCourseTypeDAO(TrainingCourseTypeDAO trainingCourseTypeDAO){
 	
 		if(trainingCourseTypeDAO == null){
 			throw new IllegalStateException("Do not try to set trainingCourseTypeDAO to null.");
 		}
	 	this.trainingCourseTypeDAO = trainingCourseTypeDAO;
 	}
 	public TrainingCourseTypeDAO getTrainingCourseTypeDAO(){
 		if(this.trainingCourseTypeDAO == null){
 			throw new IllegalStateException("The trainingCourseTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.trainingCourseTypeDAO;
 	}	

	protected EmployeeCompanyTrainingDAO employeeCompanyTrainingDAO;
	public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO employeeCompanyTrainingDAO){
 	
 		if(employeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set employeeCompanyTrainingDAO to null.");
 		}
	 	this.employeeCompanyTrainingDAO = employeeCompanyTrainingDAO;
 	}
 	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO(){
 		if(this.employeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("The employeeCompanyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeCompanyTrainingDAO;
 	}	

	
	/*
	protected CompanyTraining load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCompanyTraining(accessKey, options);
	}
	*/
	
	public SmartList<CompanyTraining> loadAll() {
	    return this.loadAll(getCompanyTrainingMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public CompanyTraining load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCompanyTraining(CompanyTrainingTable.withId(id), options);
	}
	
	
	
	public CompanyTraining save(CompanyTraining companyTraining,Map<String,Object> options){
		
		String methodName="save(CompanyTraining companyTraining,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(companyTraining, methodName, "companyTraining");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCompanyTraining(companyTraining,options);
	}
	public CompanyTraining clone(String companyTrainingId, Map<String,Object> options) throws Exception{
	
		return clone(CompanyTrainingTable.withId(companyTrainingId),options);
	}
	
	protected CompanyTraining clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String companyTrainingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CompanyTraining newCompanyTraining = loadInternalCompanyTraining(accessKey, options);
		newCompanyTraining.setVersion(0);
		
		
 		
 		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
 			for(EmployeeCompanyTraining item: newCompanyTraining.getEmployeeCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCompanyTraining(newCompanyTraining,options);
		
		return newCompanyTraining;
	}
	
	
	
	

	protected void throwIfHasException(String companyTrainingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CompanyTrainingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CompanyTrainingNotFoundException(
					"The " + this.getTableName() + "(" + companyTrainingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String companyTrainingId, int version) throws Exception{
	
		String methodName="delete(String companyTrainingId, int version)";
		assertMethodArgumentNotNull(companyTrainingId, methodName, "companyTrainingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{companyTrainingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(companyTrainingId,version);
		}
		
	
	}
	
	
	
	
	

	public CompanyTraining disconnectFromAll(String companyTrainingId, int version) throws Exception{
	
		
		CompanyTraining companyTraining = loadInternalCompanyTraining(CompanyTrainingTable.withId(companyTrainingId), emptyOptions());
		companyTraining.clearFromAll();
		this.saveCompanyTraining(companyTraining);
		return companyTraining;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return CompanyTrainingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "company_training";
	}
	@Override
	protected String getBeanName() {
		
		return "companyTraining";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CompanyTrainingTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CompanyTrainingTokens.COMPANY);
 	}

 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CompanyTrainingTokens.COMPANY);
 	}
 	

 	
  

 	protected boolean isExtractInstructorEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CompanyTrainingTokens.INSTRUCTOR);
 	}

 	protected boolean isSaveInstructorEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CompanyTrainingTokens.INSTRUCTOR);
 	}
 	

 	
  

 	protected boolean isExtractTrainingCourseTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CompanyTrainingTokens.TRAININGCOURSETYPE);
 	}

 	protected boolean isSaveTrainingCourseTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CompanyTrainingTokens.TRAININGCOURSETYPE);
 	}
 	

 	
 
		
	
	protected boolean isExtractEmployeeCompanyTrainingListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CompanyTrainingTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
 	}
 	protected boolean isAnalyzeEmployeeCompanyTrainingListEnabled(Map<String,Object> options){		 		
 		return CompanyTrainingTokens.of(options).analyzeEmployeeCompanyTrainingListEnabled();
 	}
	
	protected boolean isSaveEmployeeCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, CompanyTrainingTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
		
 	}
 	
		

	

	protected CompanyTrainingMapper getCompanyTrainingMapper(){
		return new CompanyTrainingMapper();
	}

	
	
	protected CompanyTraining extractCompanyTraining(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			CompanyTraining companyTraining = loadSingleObject(accessKey, getCompanyTrainingMapper());
			return companyTraining;
		}catch(EmptyResultDataAccessException e){
			throw new CompanyTrainingNotFoundException("CompanyTraining("+accessKey+") is not found!");
		}

	}

	
	

	protected CompanyTraining loadInternalCompanyTraining(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CompanyTraining companyTraining = extractCompanyTraining(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(companyTraining, loadOptions);
 		}
  	
 		if(isExtractInstructorEnabled(loadOptions)){
	 		extractInstructor(companyTraining, loadOptions);
 		}
  	
 		if(isExtractTrainingCourseTypeEnabled(loadOptions)){
	 		extractTrainingCourseType(companyTraining, loadOptions);
 		}
 
		
		if(isExtractEmployeeCompanyTrainingListEnabled(loadOptions)){
	 		extractEmployeeCompanyTrainingList(companyTraining, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeEmployeeCompanyTrainingListEnabled(loadOptions)){
	 		analyzeEmployeeCompanyTrainingList(companyTraining, loadOptions);
 		}
 		
		
		return companyTraining;
		
	}

	 

 	protected CompanyTraining extractCompany(CompanyTraining companyTraining, Map<String,Object> options) throws Exception{

		if(companyTraining.getCompany() == null){
			return companyTraining;
		}
		String companyId = companyTraining.getCompany().getId();
		if( companyId == null){
			return companyTraining;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			companyTraining.setCompany(company);
		}
		
 		
 		return companyTraining;
 	}
 		
  

 	protected CompanyTraining extractInstructor(CompanyTraining companyTraining, Map<String,Object> options) throws Exception{

		if(companyTraining.getInstructor() == null){
			return companyTraining;
		}
		String instructorId = companyTraining.getInstructor().getId();
		if( instructorId == null){
			return companyTraining;
		}
		Instructor instructor = getInstructorDAO().load(instructorId,options);
		if(instructor != null){
			companyTraining.setInstructor(instructor);
		}
		
 		
 		return companyTraining;
 	}
 		
  

 	protected CompanyTraining extractTrainingCourseType(CompanyTraining companyTraining, Map<String,Object> options) throws Exception{

		if(companyTraining.getTrainingCourseType() == null){
			return companyTraining;
		}
		String trainingCourseTypeId = companyTraining.getTrainingCourseType().getId();
		if( trainingCourseTypeId == null){
			return companyTraining;
		}
		TrainingCourseType trainingCourseType = getTrainingCourseTypeDAO().load(trainingCourseTypeId,options);
		if(trainingCourseType != null){
			companyTraining.setTrainingCourseType(trainingCourseType);
		}
		
 		
 		return companyTraining;
 	}
 		
 
		
	protected void enhanceEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected CompanyTraining extractEmployeeCompanyTrainingList(CompanyTraining companyTraining, Map<String,Object> options){
		
		
		if(companyTraining == null){
			return null;
		}
		if(companyTraining.getId() == null){
			return companyTraining;
		}

		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingByTraining(companyTraining.getId(),options);
		if(employeeCompanyTrainingList != null){
			enhanceEmployeeCompanyTrainingList(employeeCompanyTrainingList,options);
			companyTraining.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
		}
		
		return companyTraining;
	
	}	
	
	protected CompanyTraining analyzeEmployeeCompanyTrainingList(CompanyTraining companyTraining, Map<String,Object> options){
		
		
		if(companyTraining == null){
			return null;
		}
		if(companyTraining.getId() == null){
			return companyTraining;
		}

		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList != null){
			getEmployeeCompanyTrainingDAO().analyzeEmployeeCompanyTrainingByTraining(employeeCompanyTrainingList, companyTraining.getId(), options);
			
		}
		
		return companyTraining;
	
	}	
	
		
		
  	
 	public SmartList<CompanyTraining> findCompanyTrainingByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<CompanyTraining> resultList = queryWith(CompanyTrainingTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getCompanyTrainingMapper());
		// analyzeCompanyTrainingByCompany(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CompanyTraining> findCompanyTrainingByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CompanyTraining> resultList =  queryWithRange(CompanyTrainingTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getCompanyTrainingMapper(), start, count);
 		//analyzeCompanyTrainingByCompany(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeCompanyTrainingByCompany(SmartList<CompanyTraining> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(CompanyTraining.COMPANY_PROPERTY, retailStoreCountryCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//CompanyTraining.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("公司培训");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(CompanyTraining.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(CompanyTraining.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCompanyTrainingByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(CompanyTrainingTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countCompanyTrainingByCompanyIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CompanyTrainingTable.COLUMN_COMPANY, ids, options);
	}
 	
  	
 	public SmartList<CompanyTraining> findCompanyTrainingByInstructor(String instructorId,Map<String,Object> options){
 	
  		SmartList<CompanyTraining> resultList = queryWith(CompanyTrainingTable.COLUMN_INSTRUCTOR, instructorId, options, getCompanyTrainingMapper());
		// analyzeCompanyTrainingByInstructor(resultList, instructorId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CompanyTraining> findCompanyTrainingByInstructor(String instructorId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CompanyTraining> resultList =  queryWithRange(CompanyTrainingTable.COLUMN_INSTRUCTOR, instructorId, options, getCompanyTrainingMapper(), start, count);
 		//analyzeCompanyTrainingByInstructor(resultList, instructorId, options);
 		return resultList;
 		
 	}
 	public void analyzeCompanyTrainingByInstructor(SmartList<CompanyTraining> resultList, String instructorId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructorId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//CompanyTraining.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("公司培训");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(CompanyTraining.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(CompanyTraining.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCompanyTrainingByInstructor(String instructorId,Map<String,Object> options){

 		return countWith(CompanyTrainingTable.COLUMN_INSTRUCTOR, instructorId, options);
 	}
 	@Override
	public Map<String, Integer> countCompanyTrainingByInstructorIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CompanyTrainingTable.COLUMN_INSTRUCTOR, ids, options);
	}
 	
  	
 	public SmartList<CompanyTraining> findCompanyTrainingByTrainingCourseType(String trainingCourseTypeId,Map<String,Object> options){
 	
  		SmartList<CompanyTraining> resultList = queryWith(CompanyTrainingTable.COLUMN_TRAINING_COURSE_TYPE, trainingCourseTypeId, options, getCompanyTrainingMapper());
		// analyzeCompanyTrainingByTrainingCourseType(resultList, trainingCourseTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CompanyTraining> findCompanyTrainingByTrainingCourseType(String trainingCourseTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CompanyTraining> resultList =  queryWithRange(CompanyTrainingTable.COLUMN_TRAINING_COURSE_TYPE, trainingCourseTypeId, options, getCompanyTrainingMapper(), start, count);
 		//analyzeCompanyTrainingByTrainingCourseType(resultList, trainingCourseTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeCompanyTrainingByTrainingCourseType(SmartList<CompanyTraining> resultList, String trainingCourseTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//CompanyTraining.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("公司培训");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(CompanyTraining.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(CompanyTraining.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCompanyTrainingByTrainingCourseType(String trainingCourseTypeId,Map<String,Object> options){

 		return countWith(CompanyTrainingTable.COLUMN_TRAINING_COURSE_TYPE, trainingCourseTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countCompanyTrainingByTrainingCourseTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CompanyTrainingTable.COLUMN_TRAINING_COURSE_TYPE, ids, options);
	}
 	
 	
		
		
		

	

	protected CompanyTraining saveCompanyTraining(CompanyTraining  companyTraining){
		
		if(!companyTraining.isChanged()){
			return companyTraining;
		}
		
		
		String SQL=this.getSaveCompanyTrainingSQL(companyTraining);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCompanyTrainingParameters(companyTraining);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		companyTraining.incVersion();
		return companyTraining;
	
	}
	public SmartList<CompanyTraining> saveCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCompanyTrainingList(companyTrainingList);
		
		batchCompanyTrainingCreate((List<CompanyTraining>)lists[CREATE_LIST_INDEX]);
		
		batchCompanyTrainingUpdate((List<CompanyTraining>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(CompanyTraining companyTraining:companyTrainingList){
			if(companyTraining.isChanged()){
				companyTraining.incVersion();
			}
			
		
		}
		
		
		return companyTrainingList;
	}

	public SmartList<CompanyTraining> removeCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options){
		
		
		super.removeList(companyTrainingList, options);
		
		return companyTrainingList;
		
		
	}
	
	protected List<Object[]> prepareCompanyTrainingBatchCreateArgs(List<CompanyTraining> companyTrainingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CompanyTraining companyTraining:companyTrainingList ){
			Object [] parameters = prepareCompanyTrainingCreateParameters(companyTraining);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCompanyTrainingBatchUpdateArgs(List<CompanyTraining> companyTrainingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CompanyTraining companyTraining:companyTrainingList ){
			if(!companyTraining.isChanged()){
				continue;
			}
			Object [] parameters = prepareCompanyTrainingUpdateParameters(companyTraining);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCompanyTrainingCreate(List<CompanyTraining> companyTrainingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCompanyTrainingBatchCreateArgs(companyTrainingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCompanyTrainingUpdate(List<CompanyTraining> companyTrainingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCompanyTrainingBatchUpdateArgs(companyTrainingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCompanyTrainingList(List<CompanyTraining> companyTrainingList){
		
		List<CompanyTraining> companyTrainingCreateList=new ArrayList<CompanyTraining>();
		List<CompanyTraining> companyTrainingUpdateList=new ArrayList<CompanyTraining>();
		
		for(CompanyTraining companyTraining: companyTrainingList){
			if(isUpdateRequest(companyTraining)){
				companyTrainingUpdateList.add( companyTraining);
				continue;
			}
			companyTrainingCreateList.add(companyTraining);
		}
		
		return new Object[]{companyTrainingCreateList,companyTrainingUpdateList};
	}
	
	protected boolean isUpdateRequest(CompanyTraining companyTraining){
 		return companyTraining.getVersion() > 0;
 	}
 	protected String getSaveCompanyTrainingSQL(CompanyTraining companyTraining){
 		if(isUpdateRequest(companyTraining)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCompanyTrainingParameters(CompanyTraining companyTraining){
 		if(isUpdateRequest(companyTraining) ){
 			return prepareCompanyTrainingUpdateParameters(companyTraining);
 		}
 		return prepareCompanyTrainingCreateParameters(companyTraining);
 	}
 	protected Object[] prepareCompanyTrainingUpdateParameters(CompanyTraining companyTraining){
 		Object[] parameters = new Object[10];
 
 		
 		parameters[0] = companyTraining.getTitle();
 		 	
 		if(companyTraining.getCompany() != null){
 			parameters[1] = companyTraining.getCompany().getId();
 		}
  	
 		if(companyTraining.getInstructor() != null){
 			parameters[2] = companyTraining.getInstructor().getId();
 		}
  	
 		if(companyTraining.getTrainingCourseType() != null){
 			parameters[3] = companyTraining.getTrainingCourseType().getId();
 		}
 
 		
 		parameters[4] = companyTraining.getTimeStart();
 		
 		
 		parameters[5] = companyTraining.getDurationHours();
 		
 		
 		parameters[6] = companyTraining.getLastUpdateTime();
 				
 		parameters[7] = companyTraining.nextVersion();
 		parameters[8] = companyTraining.getId();
 		parameters[9] = companyTraining.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCompanyTrainingCreateParameters(CompanyTraining companyTraining){
		Object[] parameters = new Object[8];
		String newCompanyTrainingId=getNextId();
		companyTraining.setId(newCompanyTrainingId);
		parameters[0] =  companyTraining.getId();
 
 		
 		parameters[1] = companyTraining.getTitle();
 		 	
 		if(companyTraining.getCompany() != null){
 			parameters[2] = companyTraining.getCompany().getId();
 		
 		}
 		 	
 		if(companyTraining.getInstructor() != null){
 			parameters[3] = companyTraining.getInstructor().getId();
 		
 		}
 		 	
 		if(companyTraining.getTrainingCourseType() != null){
 			parameters[4] = companyTraining.getTrainingCourseType().getId();
 		
 		}
 		
 		
 		parameters[5] = companyTraining.getTimeStart();
 		
 		
 		parameters[6] = companyTraining.getDurationHours();
 		
 		
 		parameters[7] = companyTraining.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected CompanyTraining saveInternalCompanyTraining(CompanyTraining companyTraining, Map<String,Object> options){
		
		saveCompanyTraining(companyTraining);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(companyTraining, options);
 		}
  	
 		if(isSaveInstructorEnabled(options)){
	 		saveInstructor(companyTraining, options);
 		}
  	
 		if(isSaveTrainingCourseTypeEnabled(options)){
	 		saveTrainingCourseType(companyTraining, options);
 		}
 
		
		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
	 		saveEmployeeCompanyTrainingList(companyTraining, options);
	 		//removeEmployeeCompanyTrainingList(companyTraining, options);
	 		//Not delete the record
	 		
 		}		
		
		return companyTraining;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CompanyTraining saveCompany(CompanyTraining companyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(companyTraining.getCompany() == null){
 			return companyTraining;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(companyTraining.getCompany(),options);
 		return companyTraining;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected CompanyTraining saveInstructor(CompanyTraining companyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(companyTraining.getInstructor() == null){
 			return companyTraining;//do nothing when it is null
 		}
 		
 		getInstructorDAO().save(companyTraining.getInstructor(),options);
 		return companyTraining;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected CompanyTraining saveTrainingCourseType(CompanyTraining companyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(companyTraining.getTrainingCourseType() == null){
 			return companyTraining;//do nothing when it is null
 		}
 		
 		getTrainingCourseTypeDAO().save(companyTraining.getTrainingCourseType(),options);
 		return companyTraining;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public CompanyTraining planToRemoveEmployeeCompanyTrainingList(CompanyTraining companyTraining, String employeeCompanyTrainingIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, companyTraining.getId());
		key.put(EmployeeCompanyTraining.ID_PROPERTY, employeeCompanyTrainingIds);
		
		SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().
				findEmployeeCompanyTrainingWithKey(key, options);
		if(externalEmployeeCompanyTrainingList == null){
			return companyTraining;
		}
		if(externalEmployeeCompanyTrainingList.isEmpty()){
			return companyTraining;
		}
		
		for(EmployeeCompanyTraining employeeCompanyTrainingItem: externalEmployeeCompanyTrainingList){

			employeeCompanyTrainingItem.clearFromAll();
		}
		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();		
		employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
		return companyTraining;	
	
	}


	//disconnect CompanyTraining with employee in EmployeeCompanyTraining
	public CompanyTraining planToRemoveEmployeeCompanyTrainingListWithEmployee(CompanyTraining companyTraining, String employeeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, companyTraining.getId());
		key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);
		
		SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().
				findEmployeeCompanyTrainingWithKey(key, options);
		if(externalEmployeeCompanyTrainingList == null){
			return companyTraining;
		}
		if(externalEmployeeCompanyTrainingList.isEmpty()){
			return companyTraining;
		}
		
		for(EmployeeCompanyTraining employeeCompanyTrainingItem: externalEmployeeCompanyTrainingList){
			employeeCompanyTrainingItem.clearEmployee();
			employeeCompanyTrainingItem.clearTraining();
			
		}
		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();		
		employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
		return companyTraining;
	}
	
	public int countEmployeeCompanyTrainingListWithEmployee(String companyTrainingId, String employeeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, companyTrainingId);
		key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);
		
		int count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingWithKey(key, options);
		return count;
	}
	
	//disconnect CompanyTraining with scoring in EmployeeCompanyTraining
	public CompanyTraining planToRemoveEmployeeCompanyTrainingListWithScoring(CompanyTraining companyTraining, String scoringId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, companyTraining.getId());
		key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);
		
		SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().
				findEmployeeCompanyTrainingWithKey(key, options);
		if(externalEmployeeCompanyTrainingList == null){
			return companyTraining;
		}
		if(externalEmployeeCompanyTrainingList.isEmpty()){
			return companyTraining;
		}
		
		for(EmployeeCompanyTraining employeeCompanyTrainingItem: externalEmployeeCompanyTrainingList){
			employeeCompanyTrainingItem.clearScoring();
			employeeCompanyTrainingItem.clearTraining();
			
		}
		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();		
		employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
		return companyTraining;
	}
	
	public int countEmployeeCompanyTrainingListWithScoring(String companyTrainingId, String scoringId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, companyTrainingId);
		key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);
		
		int count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingWithKey(key, options);
		return count;
	}
	

		
	protected CompanyTraining saveEmployeeCompanyTrainingList(CompanyTraining companyTraining, Map<String,Object> options){
		
		
		
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			//null list means nothing
			return companyTraining;
		}
		SmartList<EmployeeCompanyTraining> mergedUpdateEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
		
		
		mergedUpdateEmployeeCompanyTrainingList.addAll(employeeCompanyTrainingList); 
		if(employeeCompanyTrainingList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEmployeeCompanyTrainingList.addAll(employeeCompanyTrainingList.getToRemoveList());
			employeeCompanyTrainingList.removeAll(employeeCompanyTrainingList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getEmployeeCompanyTrainingDAO().saveEmployeeCompanyTrainingList(mergedUpdateEmployeeCompanyTrainingList,options);
		
		if(employeeCompanyTrainingList.getToRemoveList() != null){
			employeeCompanyTrainingList.removeAll(employeeCompanyTrainingList.getToRemoveList());
		}
		
		
		return companyTraining;
	
	}
	
	protected CompanyTraining removeEmployeeCompanyTrainingList(CompanyTraining companyTraining, Map<String,Object> options){
	
	
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			return companyTraining;
		}	
	
		SmartList<EmployeeCompanyTraining> toRemoveEmployeeCompanyTrainingList = employeeCompanyTrainingList.getToRemoveList();
		
		if(toRemoveEmployeeCompanyTrainingList == null){
			return companyTraining;
		}
		if(toRemoveEmployeeCompanyTrainingList.isEmpty()){
			return companyTraining;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeCompanyTrainingDAO().removeEmployeeCompanyTrainingList(toRemoveEmployeeCompanyTrainingList,options);
		
		return companyTraining;
	
	}
	
	

 	
 	
	
	
	
		

	public CompanyTraining present(CompanyTraining companyTraining,Map<String, Object> options){
	
		presentEmployeeCompanyTrainingList(companyTraining,options);

		return companyTraining;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected CompanyTraining presentEmployeeCompanyTrainingList(
			CompanyTraining companyTraining,
			Map<String, Object> options) {

		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();		
				SmartList<EmployeeCompanyTraining> newList= presentSubList(companyTraining.getId(),
				employeeCompanyTrainingList,
				options,
				getEmployeeCompanyTrainingDAO()::countEmployeeCompanyTrainingByTraining,
				getEmployeeCompanyTrainingDAO()::findEmployeeCompanyTrainingByTraining
				);

		
		companyTraining.setEmployeeCompanyTrainingList(newList);
		

		return companyTraining;
	}			
		

	
    public SmartList<CompanyTraining> requestCandidateCompanyTrainingForEmployeeCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CompanyTrainingTable.COLUMN_TITLE, CompanyTrainingTable.COLUMN_COMPANY, filterKey, pageNo, pageSize, getCompanyTrainingMapper());
    }
		

	protected String getTableName(){
		return CompanyTrainingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<CompanyTraining> companyTrainingList) {		
		this.enhanceListInternal(companyTrainingList, this.getCompanyTrainingMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:EmployeeCompanyTraining的training的EmployeeCompanyTrainingList
	public SmartList<EmployeeCompanyTraining> loadOurEmployeeCompanyTrainingList(RetailscmUserContext userContext, List<CompanyTraining> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<EmployeeCompanyTraining> loadedObjs = userContext.getDAOGroup().getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingWithKey(key, options);
		Map<String, List<EmployeeCompanyTraining>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getTraining().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<EmployeeCompanyTraining> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<EmployeeCompanyTraining> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setEmployeeCompanyTrainingList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<CompanyTraining> companyTrainingList = ownerEntity.collectRefsWithType(CompanyTraining.INTERNAL_TYPE);
		this.enhanceList(companyTrainingList);
		
	}
	
	@Override
	public SmartList<CompanyTraining> findCompanyTrainingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getCompanyTrainingMapper());

	}
	@Override
	public int countCompanyTrainingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countCompanyTrainingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<CompanyTraining> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCompanyTrainingMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateCompanyTraining executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateCompanyTraining result = new CandidateCompanyTraining();
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


