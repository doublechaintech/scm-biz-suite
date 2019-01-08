
package com.doublechaintech.retailscm.interviewtype;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class InterviewTypeJDBCTemplateDAO extends RetailscmNamingServiceDAO implements InterviewTypeDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}


			
		
	
  	private  EmployeeInterviewDAO  employeeInterviewDAO;
 	public void setEmployeeInterviewDAO(EmployeeInterviewDAO pEmployeeInterviewDAO){
 	
 		if(pEmployeeInterviewDAO == null){
 			throw new IllegalStateException("Do not try to set employeeInterviewDAO to null.");
 		}
	 	this.employeeInterviewDAO = pEmployeeInterviewDAO;
 	}
 	public EmployeeInterviewDAO getEmployeeInterviewDAO(){
 		if(this.employeeInterviewDAO == null){
 			throw new IllegalStateException("The employeeInterviewDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeInterviewDAO;
 	}	
 	
			
		

	
	/*
	protected InterviewType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalInterviewType(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public InterviewType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalInterviewType(InterviewTypeTable.withId(id), options);
	}
	
	
	
	public InterviewType save(InterviewType interviewType,Map<String,Object> options){
		
		String methodName="save(InterviewType interviewType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(interviewType, methodName, "interviewType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalInterviewType(interviewType,options);
	}
	public InterviewType clone(String interviewTypeId, Map<String,Object> options) throws Exception{
	
		return clone(InterviewTypeTable.withId(interviewTypeId),options);
	}
	
	protected InterviewType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String interviewTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		InterviewType newInterviewType = loadInternalInterviewType(accessKey, options);
		newInterviewType.setVersion(0);
		
		
 		
 		if(isSaveEmployeeInterviewListEnabled(options)){
 			for(EmployeeInterview item: newInterviewType.getEmployeeInterviewList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalInterviewType(newInterviewType,options);
		
		return newInterviewType;
	}
	
	
	
	

	protected void throwIfHasException(String interviewTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new InterviewTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new InterviewTypeNotFoundException(
					"The " + this.getTableName() + "(" + interviewTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String interviewTypeId, int version) throws Exception{
	
		String methodName="delete(String interviewTypeId, int version)";
		assertMethodArgumentNotNull(interviewTypeId, methodName, "interviewTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{interviewTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(interviewTypeId,version);
		}
		
	
	}
	
	
	
	
	

	public InterviewType disconnectFromAll(String interviewTypeId, int version) throws Exception{
	
		
		InterviewType interviewType = loadInternalInterviewType(InterviewTypeTable.withId(interviewTypeId), emptyOptions());
		interviewType.clearFromAll();
		this.saveInterviewType(interviewType);
		return interviewType;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return InterviewTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "interview_type";
	}
	@Override
	protected String getBeanName() {
		
		return "interviewType";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return InterviewTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, InterviewTypeTokens.COMPANY);
 	}

 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, InterviewTypeTokens.COMPANY);
 	}
 	

 	
 
		
	
	protected boolean isExtractEmployeeInterviewListEnabled(Map<String,Object> options){		
 		return checkOptions(options,InterviewTypeTokens.EMPLOYEE_INTERVIEW_LIST);
 	}
 	protected boolean isAnalyzeEmployeeInterviewListEnabled(Map<String,Object> options){		
 		return checkOptions(options,InterviewTypeTokens.EMPLOYEE_INTERVIEW_LIST+".analyze");
 	}

	protected boolean isSaveEmployeeInterviewListEnabled(Map<String,Object> options){
		return checkOptions(options, InterviewTypeTokens.EMPLOYEE_INTERVIEW_LIST);
		
 	}
 	
		

	

	protected InterviewTypeMapper getInterviewTypeMapper(){
		return new InterviewTypeMapper();
	}

	
	
	protected InterviewType extractInterviewType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			InterviewType interviewType = loadSingleObject(accessKey, getInterviewTypeMapper());
			return interviewType;
		}catch(EmptyResultDataAccessException e){
			throw new InterviewTypeNotFoundException("InterviewType("+accessKey+") is not found!");
		}

	}

	
	

	protected InterviewType loadInternalInterviewType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		InterviewType interviewType = extractInterviewType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(interviewType, loadOptions);
 		}
 
		
		if(isExtractEmployeeInterviewListEnabled(loadOptions)){
	 		extractEmployeeInterviewList(interviewType, loadOptions);
 		}	
 		if(isAnalyzeEmployeeInterviewListEnabled(loadOptions)){
	 		// analyzeEmployeeInterviewList(interviewType, loadOptions);
 		}
 		
		
		return interviewType;
		
	}

	 

 	protected InterviewType extractCompany(InterviewType interviewType, Map<String,Object> options) throws Exception{

		if(interviewType.getCompany() == null){
			return interviewType;
		}
		String companyId = interviewType.getCompany().getId();
		if( companyId == null){
			return interviewType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			interviewType.setCompany(company);
		}
		
 		
 		return interviewType;
 	}
 		
 
		
	protected void enhanceEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected InterviewType extractEmployeeInterviewList(InterviewType interviewType, Map<String,Object> options){
		
		
		if(interviewType == null){
			return null;
		}
		if(interviewType.getId() == null){
			return interviewType;
		}

		
		
		SmartList<EmployeeInterview> employeeInterviewList = getEmployeeInterviewDAO().findEmployeeInterviewByInterviewType(interviewType.getId(),options);
		if(employeeInterviewList != null){
			enhanceEmployeeInterviewList(employeeInterviewList,options);
			interviewType.setEmployeeInterviewList(employeeInterviewList);
		}
		
		return interviewType;
	
	}	
	
	protected InterviewType analyzeEmployeeInterviewList(InterviewType interviewType, Map<String,Object> options){
		
		
		if(interviewType == null){
			return null;
		}
		if(interviewType.getId() == null){
			return interviewType;
		}

		
		
		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();
		if(employeeInterviewList != null){
			getEmployeeInterviewDAO().analyzeEmployeeInterviewByInterviewType(employeeInterviewList, interviewType.getId(), options);
			
		}
		
		return interviewType;
	
	}	
	
		
		
  	
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<InterviewType> resultList = queryWith(InterviewTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getInterviewTypeMapper());
		// analyzeInterviewTypeByCompany(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<InterviewType> resultList =  queryWithRange(InterviewTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getInterviewTypeMapper(), start, count);
 		//analyzeInterviewTypeByCompany(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeInterviewTypeByCompany(SmartList<InterviewType> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countInterviewTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(InterviewTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countInterviewTypeByCompanyIds(String[] ids, Map<String, Object> options) {
		return countWithIds(InterviewTypeTable.COLUMN_COMPANY, ids, options);
	}
 	
 	
		
		
		

	

	protected InterviewType saveInterviewType(InterviewType  interviewType){
		
		if(!interviewType.isChanged()){
			return interviewType;
		}
		
		
		String SQL=this.getSaveInterviewTypeSQL(interviewType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveInterviewTypeParameters(interviewType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		interviewType.incVersion();
		return interviewType;
	
	}
	public SmartList<InterviewType> saveInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitInterviewTypeList(interviewTypeList);
		
		batchInterviewTypeCreate((List<InterviewType>)lists[CREATE_LIST_INDEX]);
		
		batchInterviewTypeUpdate((List<InterviewType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(InterviewType interviewType:interviewTypeList){
			if(interviewType.isChanged()){
				interviewType.incVersion();
			}
			
		
		}
		
		
		return interviewTypeList;
	}

	public SmartList<InterviewType> removeInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options){
		
		
		super.removeList(interviewTypeList, options);
		
		return interviewTypeList;
		
		
	}
	
	protected List<Object[]> prepareInterviewTypeBatchCreateArgs(List<InterviewType> interviewTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(InterviewType interviewType:interviewTypeList ){
			Object [] parameters = prepareInterviewTypeCreateParameters(interviewType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareInterviewTypeBatchUpdateArgs(List<InterviewType> interviewTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(InterviewType interviewType:interviewTypeList ){
			if(!interviewType.isChanged()){
				continue;
			}
			Object [] parameters = prepareInterviewTypeUpdateParameters(interviewType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchInterviewTypeCreate(List<InterviewType> interviewTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareInterviewTypeBatchCreateArgs(interviewTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchInterviewTypeUpdate(List<InterviewType> interviewTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareInterviewTypeBatchUpdateArgs(interviewTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitInterviewTypeList(List<InterviewType> interviewTypeList){
		
		List<InterviewType> interviewTypeCreateList=new ArrayList<InterviewType>();
		List<InterviewType> interviewTypeUpdateList=new ArrayList<InterviewType>();
		
		for(InterviewType interviewType: interviewTypeList){
			if(isUpdateRequest(interviewType)){
				interviewTypeUpdateList.add( interviewType);
				continue;
			}
			interviewTypeCreateList.add(interviewType);
		}
		
		return new Object[]{interviewTypeCreateList,interviewTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(InterviewType interviewType){
 		return interviewType.getVersion() > 0;
 	}
 	protected String getSaveInterviewTypeSQL(InterviewType interviewType){
 		if(isUpdateRequest(interviewType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveInterviewTypeParameters(InterviewType interviewType){
 		if(isUpdateRequest(interviewType) ){
 			return prepareInterviewTypeUpdateParameters(interviewType);
 		}
 		return prepareInterviewTypeCreateParameters(interviewType);
 	}
 	protected Object[] prepareInterviewTypeUpdateParameters(InterviewType interviewType){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = interviewType.getCode(); 	
 		if(interviewType.getCompany() != null){
 			parameters[1] = interviewType.getCompany().getId();
 		}
 
 		parameters[2] = interviewType.getDescription();
 		parameters[3] = interviewType.getDetailDescription();		
 		parameters[4] = interviewType.nextVersion();
 		parameters[5] = interviewType.getId();
 		parameters[6] = interviewType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareInterviewTypeCreateParameters(InterviewType interviewType){
		Object[] parameters = new Object[5];
		String newInterviewTypeId=getNextId();
		interviewType.setId(newInterviewTypeId);
		parameters[0] =  interviewType.getId();
 
 		parameters[1] = interviewType.getCode(); 	
 		if(interviewType.getCompany() != null){
 			parameters[2] = interviewType.getCompany().getId();
 		
 		}
 		
 		parameters[3] = interviewType.getDescription();
 		parameters[4] = interviewType.getDetailDescription();		
 				
 		return parameters;
 	}
 	
	protected InterviewType saveInternalInterviewType(InterviewType interviewType, Map<String,Object> options){
		
		saveInterviewType(interviewType);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(interviewType, options);
 		}
 
		
		if(isSaveEmployeeInterviewListEnabled(options)){
	 		saveEmployeeInterviewList(interviewType, options);
	 		//removeEmployeeInterviewList(interviewType, options);
	 		//Not delete the record
	 		
 		}		
		
		return interviewType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected InterviewType saveCompany(InterviewType interviewType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(interviewType.getCompany() == null){
 			return interviewType;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(interviewType.getCompany(),options);
 		return interviewType;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public InterviewType planToRemoveEmployeeInterviewList(InterviewType interviewType, String employeeInterviewIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, interviewType.getId());
		key.put(EmployeeInterview.ID_PROPERTY, employeeInterviewIds);
		
		SmartList<EmployeeInterview> externalEmployeeInterviewList = getEmployeeInterviewDAO().
				findEmployeeInterviewWithKey(key, options);
		if(externalEmployeeInterviewList == null){
			return interviewType;
		}
		if(externalEmployeeInterviewList.isEmpty()){
			return interviewType;
		}
		
		for(EmployeeInterview employeeInterview: externalEmployeeInterviewList){

			employeeInterview.clearFromAll();
		}
		
		
		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();		
		employeeInterviewList.addAllToRemoveList(externalEmployeeInterviewList);
		return interviewType;	
	
	}


	//disconnect InterviewType with employee in EmployeeInterview
	public InterviewType planToRemoveEmployeeInterviewListWithEmployee(InterviewType interviewType, String employeeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, interviewType.getId());
		key.put(EmployeeInterview.EMPLOYEE_PROPERTY, employeeId);
		
		SmartList<EmployeeInterview> externalEmployeeInterviewList = getEmployeeInterviewDAO().
				findEmployeeInterviewWithKey(key, options);
		if(externalEmployeeInterviewList == null){
			return interviewType;
		}
		if(externalEmployeeInterviewList.isEmpty()){
			return interviewType;
		}
		
		for(EmployeeInterview employeeInterview: externalEmployeeInterviewList){
			employeeInterview.clearEmployee();
			employeeInterview.clearInterviewType();
			
		}
		
		
		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();		
		employeeInterviewList.addAllToRemoveList(externalEmployeeInterviewList);
		return interviewType;
	}
	
	public int countEmployeeInterviewListWithEmployee(String interviewTypeId, String employeeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, interviewTypeId);
		key.put(EmployeeInterview.EMPLOYEE_PROPERTY, employeeId);
		
		int count = getEmployeeInterviewDAO().countEmployeeInterviewWithKey(key, options);
		return count;
	}
	

		
	protected InterviewType saveEmployeeInterviewList(InterviewType interviewType, Map<String,Object> options){
		
		
		
		
		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();
		if(employeeInterviewList == null){
			//null list means nothing
			return interviewType;
		}
		SmartList<EmployeeInterview> mergedUpdateEmployeeInterviewList = new SmartList<EmployeeInterview>();
		
		
		mergedUpdateEmployeeInterviewList.addAll(employeeInterviewList); 
		if(employeeInterviewList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEmployeeInterviewList.addAll(employeeInterviewList.getToRemoveList());
			employeeInterviewList.removeAll(employeeInterviewList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getEmployeeInterviewDAO().saveEmployeeInterviewList(mergedUpdateEmployeeInterviewList,options);
		
		if(employeeInterviewList.getToRemoveList() != null){
			employeeInterviewList.removeAll(employeeInterviewList.getToRemoveList());
		}
		
		
		return interviewType;
	
	}
	
	protected InterviewType removeEmployeeInterviewList(InterviewType interviewType, Map<String,Object> options){
	
	
		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();
		if(employeeInterviewList == null){
			return interviewType;
		}	
	
		SmartList<EmployeeInterview> toRemoveEmployeeInterviewList = employeeInterviewList.getToRemoveList();
		
		if(toRemoveEmployeeInterviewList == null){
			return interviewType;
		}
		if(toRemoveEmployeeInterviewList.isEmpty()){
			return interviewType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeInterviewDAO().removeEmployeeInterviewList(toRemoveEmployeeInterviewList,options);
		
		return interviewType;
	
	}
	
	

 	
 	
	
	
	
		

	public InterviewType present(InterviewType interviewType,Map<String, Object> options){
	
		presentEmployeeInterviewList(interviewType,options);

		return interviewType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected InterviewType presentEmployeeInterviewList(
			InterviewType interviewType,
			Map<String, Object> options) {

		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();		
				SmartList<EmployeeInterview> newList= presentSubList(interviewType.getId(),
				employeeInterviewList,
				options,
				getEmployeeInterviewDAO()::countEmployeeInterviewByInterviewType,
				getEmployeeInterviewDAO()::findEmployeeInterviewByInterviewType
				);

		
		interviewType.setEmployeeInterviewList(newList);
		

		return interviewType;
	}			
		

	
    public SmartList<InterviewType> requestCandidateInterviewTypeForEmployeeInterview(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(InterviewTypeTable.COLUMN_CODE, filterKey, pageNo, pageSize, getInterviewTypeMapper());
    }
		

	protected String getTableName(){
		return InterviewTypeTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<InterviewType> interviewTypeList) {		
		this.enhanceListInternal(interviewTypeList, this.getInterviewTypeMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<InterviewType> interviewTypeList = ownerEntity.collectRefsWithType(InterviewType.INTERNAL_TYPE);
		this.enhanceList(interviewTypeList);
		
	}
	
	@Override
	public SmartList<InterviewType> findInterviewTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getInterviewTypeMapper());

	}
	@Override
	public int countInterviewTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countInterviewTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<InterviewType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getInterviewTypeMapper());
	}
}


