
package com.doublechaintech.retailscm.trainingcoursetype;

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
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.companytraining.CompanyTrainingDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class TrainingCourseTypeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements TrainingCourseTypeDAO{

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

	protected CompanyTrainingDAO companyTrainingDAO;
	public void setCompanyTrainingDAO(CompanyTrainingDAO companyTrainingDAO){
 	
 		if(companyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set companyTrainingDAO to null.");
 		}
	 	this.companyTrainingDAO = companyTrainingDAO;
 	}
 	public CompanyTrainingDAO getCompanyTrainingDAO(){
 		if(this.companyTrainingDAO == null){
 			throw new IllegalStateException("The companyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.companyTrainingDAO;
 	}	


	/*
	protected TrainingCourseType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTrainingCourseType(accessKey, options);
	}
	*/

	public SmartList<TrainingCourseType> loadAll() {
	    return this.loadAll(getTrainingCourseTypeMapper());
	}

  public Stream<TrainingCourseType> loadAllAsStream() {
      return this.loadAllAsStream(getTrainingCourseTypeMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public TrainingCourseType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTrainingCourseType(TrainingCourseTypeTable.withId(id), options);
	}

	

	public TrainingCourseType save(TrainingCourseType trainingCourseType,Map<String,Object> options){

		String methodName="save(TrainingCourseType trainingCourseType,Map<String,Object> options)";

		assertMethodArgumentNotNull(trainingCourseType, methodName, "trainingCourseType");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalTrainingCourseType(trainingCourseType,options);
	}
	public TrainingCourseType clone(String trainingCourseTypeId, Map<String,Object> options) throws Exception{

		return clone(TrainingCourseTypeTable.withId(trainingCourseTypeId),options);
	}

	protected TrainingCourseType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String trainingCourseTypeId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		TrainingCourseType newTrainingCourseType = loadInternalTrainingCourseType(accessKey, options);
		newTrainingCourseType.setVersion(0);
		
		
 		
 		if(isSaveCompanyTrainingListEnabled(options)){
 			for(CompanyTraining item: newTrainingCourseType.getCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalTrainingCourseType(newTrainingCourseType,options);

		return newTrainingCourseType;
	}

	



	protected void throwIfHasException(String trainingCourseTypeId,int version,int count) throws Exception{
		if (count == 1) {
			throw new TrainingCourseTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TrainingCourseTypeNotFoundException(
					"The " + this.getTableName() + "(" + trainingCourseTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String trainingCourseTypeId, int version) throws Exception{

		String methodName="delete(String trainingCourseTypeId, int version)";
		assertMethodArgumentNotNull(trainingCourseTypeId, methodName, "trainingCourseTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{trainingCourseTypeId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(trainingCourseTypeId,version);
		}


	}






	public TrainingCourseType disconnectFromAll(String trainingCourseTypeId, int version) throws Exception{


		TrainingCourseType trainingCourseType = loadInternalTrainingCourseType(TrainingCourseTypeTable.withId(trainingCourseTypeId), emptyOptions());
		trainingCourseType.clearFromAll();
		this.saveTrainingCourseType(trainingCourseType);
		return trainingCourseType;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return TrainingCourseTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "training_course_type";
	}
	@Override
	protected String getBeanName() {

		return "trainingCourseType";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TrainingCourseTypeTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TrainingCourseTypeTokens.COMPANY);
 	}

 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TrainingCourseTypeTokens.COMPANY);
 	}
 	

 	
 
		
	
	protected boolean isExtractCompanyTrainingListEnabled(Map<String,Object> options){		
 		return checkOptions(options,TrainingCourseTypeTokens.COMPANY_TRAINING_LIST);
 	}
 	protected boolean isAnalyzeCompanyTrainingListEnabled(Map<String,Object> options){		 		
 		return TrainingCourseTypeTokens.of(options).analyzeCompanyTrainingListEnabled();
 	}
	
	protected boolean isSaveCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, TrainingCourseTypeTokens.COMPANY_TRAINING_LIST);
		
 	}
 	
		

	

	protected TrainingCourseTypeMapper getTrainingCourseTypeMapper(){
		return new TrainingCourseTypeMapper();
	}

	
	
	protected TrainingCourseType extractTrainingCourseType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			TrainingCourseType trainingCourseType = loadSingleObject(accessKey, getTrainingCourseTypeMapper());
			return trainingCourseType;
		}catch(EmptyResultDataAccessException e){
			throw new TrainingCourseTypeNotFoundException("TrainingCourseType("+accessKey+") is not found!");
		}

	}

	
	

	protected TrainingCourseType loadInternalTrainingCourseType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TrainingCourseType trainingCourseType = extractTrainingCourseType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(trainingCourseType, loadOptions);
 		}
 
		
		if(isExtractCompanyTrainingListEnabled(loadOptions)){
	 		extractCompanyTrainingList(trainingCourseType, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeCompanyTrainingListEnabled(loadOptions)){
	 		analyzeCompanyTrainingList(trainingCourseType, loadOptions);
 		}
 		
		
		return trainingCourseType;
		
	}

	 

 	protected TrainingCourseType extractCompany(TrainingCourseType trainingCourseType, Map<String,Object> options) throws Exception{

		if(trainingCourseType.getCompany() == null){
			return trainingCourseType;
		}
		String companyId = trainingCourseType.getCompany().getId();
		if( companyId == null){
			return trainingCourseType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			trainingCourseType.setCompany(company);
		}
		
 		
 		return trainingCourseType;
 	}
 		
 
		
	protected void enhanceCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected TrainingCourseType extractCompanyTrainingList(TrainingCourseType trainingCourseType, Map<String,Object> options){
		
		
		if(trainingCourseType == null){
			return null;
		}
		if(trainingCourseType.getId() == null){
			return trainingCourseType;
		}

		
		
		SmartList<CompanyTraining> companyTrainingList = getCompanyTrainingDAO().findCompanyTrainingByTrainingCourseType(trainingCourseType.getId(),options);
		if(companyTrainingList != null){
			enhanceCompanyTrainingList(companyTrainingList,options);
			trainingCourseType.setCompanyTrainingList(companyTrainingList);
		}
		
		return trainingCourseType;
	
	}	
	
	protected TrainingCourseType analyzeCompanyTrainingList(TrainingCourseType trainingCourseType, Map<String,Object> options){
		
		
		if(trainingCourseType == null){
			return null;
		}
		if(trainingCourseType.getId() == null){
			return trainingCourseType;
		}

		
		
		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		if(companyTrainingList != null){
			getCompanyTrainingDAO().analyzeCompanyTrainingByTrainingCourseType(companyTrainingList, trainingCourseType.getId(), options);
			
		}
		
		return trainingCourseType;
	
	}	
	
		
		
  	
 	public SmartList<TrainingCourseType> findTrainingCourseTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<TrainingCourseType> resultList = queryWith(TrainingCourseTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getTrainingCourseTypeMapper());
		// analyzeTrainingCourseTypeByCompany(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<TrainingCourseType> findTrainingCourseTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<TrainingCourseType> resultList =  queryWithRange(TrainingCourseTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getTrainingCourseTypeMapper(), start, count);
 		//analyzeTrainingCourseTypeByCompany(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeTrainingCourseTypeByCompany(SmartList<TrainingCourseType> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countTrainingCourseTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(TrainingCourseTypeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countTrainingCourseTypeByCompanyIds(String[] ids, Map<String, Object> options) {
		return countWithIds(TrainingCourseTypeTable.COLUMN_COMPANY, ids, options);
	}
 	
 	
		
		
		

	

	protected TrainingCourseType saveTrainingCourseType(TrainingCourseType  trainingCourseType){
		
		if(!trainingCourseType.isChanged()){
			return trainingCourseType;
		}
		

		String SQL=this.getSaveTrainingCourseTypeSQL(trainingCourseType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTrainingCourseTypeParameters(trainingCourseType);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		trainingCourseType.incVersion();
		return trainingCourseType;

	}
	public SmartList<TrainingCourseType> saveTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTrainingCourseTypeList(trainingCourseTypeList);

		batchTrainingCourseTypeCreate((List<TrainingCourseType>)lists[CREATE_LIST_INDEX]);

		batchTrainingCourseTypeUpdate((List<TrainingCourseType>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(TrainingCourseType trainingCourseType:trainingCourseTypeList){
			if(trainingCourseType.isChanged()){
				trainingCourseType.incVersion();
			}


		}


		return trainingCourseTypeList;
	}

	public SmartList<TrainingCourseType> removeTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options){


		super.removeList(trainingCourseTypeList, options);

		return trainingCourseTypeList;


	}

	protected List<Object[]> prepareTrainingCourseTypeBatchCreateArgs(List<TrainingCourseType> trainingCourseTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TrainingCourseType trainingCourseType:trainingCourseTypeList ){
			Object [] parameters = prepareTrainingCourseTypeCreateParameters(trainingCourseType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareTrainingCourseTypeBatchUpdateArgs(List<TrainingCourseType> trainingCourseTypeList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TrainingCourseType trainingCourseType:trainingCourseTypeList ){
			if(!trainingCourseType.isChanged()){
				continue;
			}
			Object [] parameters = prepareTrainingCourseTypeUpdateParameters(trainingCourseType);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchTrainingCourseTypeCreate(List<TrainingCourseType> trainingCourseTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTrainingCourseTypeBatchCreateArgs(trainingCourseTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchTrainingCourseTypeUpdate(List<TrainingCourseType> trainingCourseTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTrainingCourseTypeBatchUpdateArgs(trainingCourseTypeList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitTrainingCourseTypeList(List<TrainingCourseType> trainingCourseTypeList){

		List<TrainingCourseType> trainingCourseTypeCreateList=new ArrayList<TrainingCourseType>();
		List<TrainingCourseType> trainingCourseTypeUpdateList=new ArrayList<TrainingCourseType>();

		for(TrainingCourseType trainingCourseType: trainingCourseTypeList){
			if(isUpdateRequest(trainingCourseType)){
				trainingCourseTypeUpdateList.add( trainingCourseType);
				continue;
			}
			trainingCourseTypeCreateList.add(trainingCourseType);
		}

		return new Object[]{trainingCourseTypeCreateList,trainingCourseTypeUpdateList};
	}

	protected boolean isUpdateRequest(TrainingCourseType trainingCourseType){
 		return trainingCourseType.getVersion() > 0;
 	}
 	protected String getSaveTrainingCourseTypeSQL(TrainingCourseType trainingCourseType){
 		if(isUpdateRequest(trainingCourseType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveTrainingCourseTypeParameters(TrainingCourseType trainingCourseType){
 		if(isUpdateRequest(trainingCourseType) ){
 			return prepareTrainingCourseTypeUpdateParameters(trainingCourseType);
 		}
 		return prepareTrainingCourseTypeCreateParameters(trainingCourseType);
 	}
 	protected Object[] prepareTrainingCourseTypeUpdateParameters(TrainingCourseType trainingCourseType){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = trainingCourseType.getCode();
 		
 		if(trainingCourseType.getCompany() != null){
 			parameters[1] = trainingCourseType.getCompany().getId();
 		}
 
 		
 		parameters[2] = trainingCourseType.getName();
 		
 		
 		parameters[3] = trainingCourseType.getDescription();
 		
 		parameters[4] = trainingCourseType.nextVersion();
 		parameters[5] = trainingCourseType.getId();
 		parameters[6] = trainingCourseType.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareTrainingCourseTypeCreateParameters(TrainingCourseType trainingCourseType){
		Object[] parameters = new Object[5];
        if(trainingCourseType.getId() == null){
          String newTrainingCourseTypeId=getNextId();
          trainingCourseType.setId(newTrainingCourseTypeId);
        }
		parameters[0] =  trainingCourseType.getId();
 
 		
 		parameters[1] = trainingCourseType.getCode();
 		
 		if(trainingCourseType.getCompany() != null){
 			parameters[2] = trainingCourseType.getCompany().getId();

 		}
 		
 		
 		parameters[3] = trainingCourseType.getName();
 		
 		
 		parameters[4] = trainingCourseType.getDescription();
 		

 		return parameters;
 	}

	protected TrainingCourseType saveInternalTrainingCourseType(TrainingCourseType trainingCourseType, Map<String,Object> options){

		saveTrainingCourseType(trainingCourseType);

 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(trainingCourseType, options);
 		}
 
		
		if(isSaveCompanyTrainingListEnabled(options)){
	 		saveCompanyTrainingList(trainingCourseType, options);
	 		//removeCompanyTrainingList(trainingCourseType, options);
	 		//Not delete the record

 		}
		
		return trainingCourseType;

	}



	//======================================================================================
	

 	protected TrainingCourseType saveCompany(TrainingCourseType trainingCourseType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(trainingCourseType.getCompany() == null){
 			return trainingCourseType;//do nothing when it is null
 		}

 		getRetailStoreCountryCenterDAO().save(trainingCourseType.getCompany(),options);
 		return trainingCourseType;

 	}





 

	
	public TrainingCourseType planToRemoveCompanyTrainingList(TrainingCourseType trainingCourseType, String companyTrainingIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseType.getId());
		key.put(CompanyTraining.ID_PROPERTY, companyTrainingIds);

		SmartList<CompanyTraining> externalCompanyTrainingList = getCompanyTrainingDAO().
				findCompanyTrainingWithKey(key, options);
		if(externalCompanyTrainingList == null){
			return trainingCourseType;
		}
		if(externalCompanyTrainingList.isEmpty()){
			return trainingCourseType;
		}

		for(CompanyTraining companyTrainingItem: externalCompanyTrainingList){

			companyTrainingItem.clearFromAll();
		}


		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
		return trainingCourseType;

	}


	//disconnect TrainingCourseType with company in CompanyTraining
	public TrainingCourseType planToRemoveCompanyTrainingListWithCompany(TrainingCourseType trainingCourseType, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseType.getId());
		key.put(CompanyTraining.COMPANY_PROPERTY, companyId);

		SmartList<CompanyTraining> externalCompanyTrainingList = getCompanyTrainingDAO().
				findCompanyTrainingWithKey(key, options);
		if(externalCompanyTrainingList == null){
			return trainingCourseType;
		}
		if(externalCompanyTrainingList.isEmpty()){
			return trainingCourseType;
		}

		for(CompanyTraining companyTrainingItem: externalCompanyTrainingList){
			companyTrainingItem.clearCompany();
			companyTrainingItem.clearTrainingCourseType();

		}


		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
		return trainingCourseType;
	}

	public int countCompanyTrainingListWithCompany(String trainingCourseTypeId, String companyId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseTypeId);
		key.put(CompanyTraining.COMPANY_PROPERTY, companyId);

		int count = getCompanyTrainingDAO().countCompanyTrainingWithKey(key, options);
		return count;
	}
	
	//disconnect TrainingCourseType with instructor in CompanyTraining
	public TrainingCourseType planToRemoveCompanyTrainingListWithInstructor(TrainingCourseType trainingCourseType, String instructorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseType.getId());
		key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructorId);

		SmartList<CompanyTraining> externalCompanyTrainingList = getCompanyTrainingDAO().
				findCompanyTrainingWithKey(key, options);
		if(externalCompanyTrainingList == null){
			return trainingCourseType;
		}
		if(externalCompanyTrainingList.isEmpty()){
			return trainingCourseType;
		}

		for(CompanyTraining companyTrainingItem: externalCompanyTrainingList){
			companyTrainingItem.clearInstructor();
			companyTrainingItem.clearTrainingCourseType();

		}


		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
		return trainingCourseType;
	}

	public int countCompanyTrainingListWithInstructor(String trainingCourseTypeId, String instructorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseTypeId);
		key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructorId);

		int count = getCompanyTrainingDAO().countCompanyTrainingWithKey(key, options);
		return count;
	}
	

		
	protected TrainingCourseType saveCompanyTrainingList(TrainingCourseType trainingCourseType, Map<String,Object> options){




		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		if(companyTrainingList == null){
			//null list means nothing
			return trainingCourseType;
		}
		SmartList<CompanyTraining> mergedUpdateCompanyTrainingList = new SmartList<CompanyTraining>();


		mergedUpdateCompanyTrainingList.addAll(companyTrainingList);
		if(companyTrainingList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCompanyTrainingList.addAll(companyTrainingList.getToRemoveList());
			companyTrainingList.removeAll(companyTrainingList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getCompanyTrainingDAO().saveCompanyTrainingList(mergedUpdateCompanyTrainingList,options);

		if(companyTrainingList.getToRemoveList() != null){
			companyTrainingList.removeAll(companyTrainingList.getToRemoveList());
		}


		return trainingCourseType;

	}

	protected TrainingCourseType removeCompanyTrainingList(TrainingCourseType trainingCourseType, Map<String,Object> options){


		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		if(companyTrainingList == null){
			return trainingCourseType;
		}

		SmartList<CompanyTraining> toRemoveCompanyTrainingList = companyTrainingList.getToRemoveList();

		if(toRemoveCompanyTrainingList == null){
			return trainingCourseType;
		}
		if(toRemoveCompanyTrainingList.isEmpty()){
			return trainingCourseType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getCompanyTrainingDAO().removeCompanyTrainingList(toRemoveCompanyTrainingList,options);

		return trainingCourseType;

	}








		

	public TrainingCourseType present(TrainingCourseType trainingCourseType,Map<String, Object> options){
	
		presentCompanyTrainingList(trainingCourseType,options);

		return trainingCourseType;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected TrainingCourseType presentCompanyTrainingList(
			TrainingCourseType trainingCourseType,
			Map<String, Object> options) {

		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();		
				SmartList<CompanyTraining> newList= presentSubList(trainingCourseType.getId(),
				companyTrainingList,
				options,
				getCompanyTrainingDAO()::countCompanyTrainingByTrainingCourseType,
				getCompanyTrainingDAO()::findCompanyTrainingByTrainingCourseType
				);

		
		trainingCourseType.setCompanyTrainingList(newList);
		

		return trainingCourseType;
	}			
		

	
    public SmartList<TrainingCourseType> requestCandidateTrainingCourseTypeForCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(TrainingCourseTypeTable.COLUMN_CODE, TrainingCourseTypeTable.COLUMN_COMPANY, filterKey, pageNo, pageSize, getTrainingCourseTypeMapper());
    }
		

	protected String getTableName(){
		return TrainingCourseTypeTable.TABLE_NAME;
	}



	public void enhanceList(List<TrainingCourseType> trainingCourseTypeList) {
		this.enhanceListInternal(trainingCourseTypeList, this.getTrainingCourseTypeMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:CompanyTraining的trainingCourseType的CompanyTrainingList
	public SmartList<CompanyTraining> loadOurCompanyTrainingList(RetailscmUserContext userContext, List<TrainingCourseType> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<CompanyTraining> loadedObjs = userContext.getDAOGroup().getCompanyTrainingDAO().findCompanyTrainingWithKey(key, options);
		Map<String, List<CompanyTraining>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getTrainingCourseType().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<CompanyTraining> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<CompanyTraining> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCompanyTrainingList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<TrainingCourseType> trainingCourseTypeList = ownerEntity.collectRefsWithType(TrainingCourseType.INTERNAL_TYPE);
		this.enhanceList(trainingCourseTypeList);

	}

	@Override
	public SmartList<TrainingCourseType> findTrainingCourseTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getTrainingCourseTypeMapper());

	}
	@Override
	public int countTrainingCourseTypeWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countTrainingCourseTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<TrainingCourseType> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getTrainingCourseTypeMapper());
	}

  @Override
  public Stream<TrainingCourseType> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getTrainingCourseTypeMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateTrainingCourseType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateTrainingCourseType result = new CandidateTrainingCourseType();
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


