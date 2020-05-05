
package com.doublechaintech.retailscm.levelonedepartment;

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
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class LevelOneDepartmentJDBCTemplateDAO extends RetailscmBaseDAOImpl implements LevelOneDepartmentDAO{

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

	protected LevelTwoDepartmentDAO levelTwoDepartmentDAO;
	public void setLevelTwoDepartmentDAO(LevelTwoDepartmentDAO levelTwoDepartmentDAO){
 	
 		if(levelTwoDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelTwoDepartmentDAO to null.");
 		}
	 	this.levelTwoDepartmentDAO = levelTwoDepartmentDAO;
 	}
 	public LevelTwoDepartmentDAO getLevelTwoDepartmentDAO(){
 		if(this.levelTwoDepartmentDAO == null){
 			throw new IllegalStateException("The levelTwoDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelTwoDepartmentDAO;
 	}	

	
	/*
	protected LevelOneDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelOneDepartment(accessKey, options);
	}
	*/
	
	public SmartList<LevelOneDepartment> loadAll() {
	    return this.loadAll(getLevelOneDepartmentMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LevelOneDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelOneDepartment(LevelOneDepartmentTable.withId(id), options);
	}
	
	
	
	public LevelOneDepartment save(LevelOneDepartment levelOneDepartment,Map<String,Object> options){
		
		String methodName="save(LevelOneDepartment levelOneDepartment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelOneDepartment, methodName, "levelOneDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelOneDepartment(levelOneDepartment,options);
	}
	public LevelOneDepartment clone(String levelOneDepartmentId, Map<String,Object> options) throws Exception{
	
		return clone(LevelOneDepartmentTable.withId(levelOneDepartmentId),options);
	}
	
	protected LevelOneDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelOneDepartmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelOneDepartment newLevelOneDepartment = loadInternalLevelOneDepartment(accessKey, options);
		newLevelOneDepartment.setVersion(0);
		
		
 		
 		if(isSaveLevelTwoDepartmentListEnabled(options)){
 			for(LevelTwoDepartment item: newLevelOneDepartment.getLevelTwoDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelOneDepartment(newLevelOneDepartment,options);
		
		return newLevelOneDepartment;
	}
	
	
	
	

	protected void throwIfHasException(String levelOneDepartmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LevelOneDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelOneDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + levelOneDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String levelOneDepartmentId, int version) throws Exception{
	
		String methodName="delete(String levelOneDepartmentId, int version)";
		assertMethodArgumentNotNull(levelOneDepartmentId, methodName, "levelOneDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelOneDepartmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelOneDepartmentId,version);
		}
		
	
	}
	
	
	
	
	

	public LevelOneDepartment disconnectFromAll(String levelOneDepartmentId, int version) throws Exception{
	
		
		LevelOneDepartment levelOneDepartment = loadInternalLevelOneDepartment(LevelOneDepartmentTable.withId(levelOneDepartmentId), emptyOptions());
		levelOneDepartment.clearFromAll();
		this.saveLevelOneDepartment(levelOneDepartment);
		return levelOneDepartment;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LevelOneDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_one_department";
	}
	@Override
	protected String getBeanName() {
		
		return "levelOneDepartment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelOneDepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelOneDepartmentTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelOneDepartmentTokens.BELONGSTO);
 	}
 	

 	
 
		
	
	protected boolean isExtractLevelTwoDepartmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelOneDepartmentTokens.LEVEL_TWO_DEPARTMENT_LIST);
 	}
 	protected boolean isAnalyzeLevelTwoDepartmentListEnabled(Map<String,Object> options){		 		
 		return LevelOneDepartmentTokens.of(options).analyzeLevelTwoDepartmentListEnabled();
 	}
	
	protected boolean isSaveLevelTwoDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelOneDepartmentTokens.LEVEL_TWO_DEPARTMENT_LIST);
		
 	}
 	
		

	

	protected LevelOneDepartmentMapper getLevelOneDepartmentMapper(){
		return new LevelOneDepartmentMapper();
	}

	
	
	protected LevelOneDepartment extractLevelOneDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LevelOneDepartment levelOneDepartment = loadSingleObject(accessKey, getLevelOneDepartmentMapper());
			return levelOneDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new LevelOneDepartmentNotFoundException("LevelOneDepartment("+accessKey+") is not found!");
		}

	}

	
	

	protected LevelOneDepartment loadInternalLevelOneDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelOneDepartment levelOneDepartment = extractLevelOneDepartment(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(levelOneDepartment, loadOptions);
 		}
 
		
		if(isExtractLevelTwoDepartmentListEnabled(loadOptions)){
	 		extractLevelTwoDepartmentList(levelOneDepartment, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeLevelTwoDepartmentListEnabled(loadOptions)){
	 		analyzeLevelTwoDepartmentList(levelOneDepartment, loadOptions);
 		}
 		
		
		return levelOneDepartment;
		
	}

	 

 	protected LevelOneDepartment extractBelongsTo(LevelOneDepartment levelOneDepartment, Map<String,Object> options) throws Exception{

		if(levelOneDepartment.getBelongsTo() == null){
			return levelOneDepartment;
		}
		String belongsToId = levelOneDepartment.getBelongsTo().getId();
		if( belongsToId == null){
			return levelOneDepartment;
		}
		RetailStoreCountryCenter belongsTo = getRetailStoreCountryCenterDAO().load(belongsToId,options);
		if(belongsTo != null){
			levelOneDepartment.setBelongsTo(belongsTo);
		}
		
 		
 		return levelOneDepartment;
 	}
 		
 
		
	protected void enhanceLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelOneDepartment extractLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
		
		
		if(levelOneDepartment == null){
			return null;
		}
		if(levelOneDepartment.getId() == null){
			return levelOneDepartment;
		}

		
		
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = getLevelTwoDepartmentDAO().findLevelTwoDepartmentByBelongsTo(levelOneDepartment.getId(),options);
		if(levelTwoDepartmentList != null){
			enhanceLevelTwoDepartmentList(levelTwoDepartmentList,options);
			levelOneDepartment.setLevelTwoDepartmentList(levelTwoDepartmentList);
		}
		
		return levelOneDepartment;
	
	}	
	
	protected LevelOneDepartment analyzeLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
		
		
		if(levelOneDepartment == null){
			return null;
		}
		if(levelOneDepartment.getId() == null){
			return levelOneDepartment;
		}

		
		
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();
		if(levelTwoDepartmentList != null){
			getLevelTwoDepartmentDAO().analyzeLevelTwoDepartmentByBelongsTo(levelTwoDepartmentList, levelOneDepartment.getId(), options);
			
		}
		
		return levelOneDepartment;
	
	}	
	
		
		
  	
 	public SmartList<LevelOneDepartment> findLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<LevelOneDepartment> resultList = queryWith(LevelOneDepartmentTable.COLUMN_BELONGS_TO, retailStoreCountryCenterId, options, getLevelOneDepartmentMapper());
		// analyzeLevelOneDepartmentByBelongsTo(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LevelOneDepartment> findLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LevelOneDepartment> resultList =  queryWithRange(LevelOneDepartmentTable.COLUMN_BELONGS_TO, retailStoreCountryCenterId, options, getLevelOneDepartmentMapper(), start, count);
 		//analyzeLevelOneDepartmentByBelongsTo(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeLevelOneDepartmentByBelongsTo(SmartList<LevelOneDepartment> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(LevelOneDepartmentTable.COLUMN_BELONGS_TO, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countLevelOneDepartmentByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LevelOneDepartmentTable.COLUMN_BELONGS_TO, ids, options);
	}
 	
 	
		
		
		

	

	protected LevelOneDepartment saveLevelOneDepartment(LevelOneDepartment  levelOneDepartment){
		
		if(!levelOneDepartment.isChanged()){
			return levelOneDepartment;
		}
		
		
		String SQL=this.getSaveLevelOneDepartmentSQL(levelOneDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelOneDepartmentParameters(levelOneDepartment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelOneDepartment.incVersion();
		return levelOneDepartment;
	
	}
	public SmartList<LevelOneDepartment> saveLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelOneDepartmentList(levelOneDepartmentList);
		
		batchLevelOneDepartmentCreate((List<LevelOneDepartment>)lists[CREATE_LIST_INDEX]);
		
		batchLevelOneDepartmentUpdate((List<LevelOneDepartment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelOneDepartment levelOneDepartment:levelOneDepartmentList){
			if(levelOneDepartment.isChanged()){
				levelOneDepartment.incVersion();
			}
			
		
		}
		
		
		return levelOneDepartmentList;
	}

	public SmartList<LevelOneDepartment> removeLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options){
		
		
		super.removeList(levelOneDepartmentList, options);
		
		return levelOneDepartmentList;
		
		
	}
	
	protected List<Object[]> prepareLevelOneDepartmentBatchCreateArgs(List<LevelOneDepartment> levelOneDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelOneDepartment levelOneDepartment:levelOneDepartmentList ){
			Object [] parameters = prepareLevelOneDepartmentCreateParameters(levelOneDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelOneDepartmentBatchUpdateArgs(List<LevelOneDepartment> levelOneDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelOneDepartment levelOneDepartment:levelOneDepartmentList ){
			if(!levelOneDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelOneDepartmentUpdateParameters(levelOneDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelOneDepartmentCreate(List<LevelOneDepartment> levelOneDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelOneDepartmentBatchCreateArgs(levelOneDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelOneDepartmentUpdate(List<LevelOneDepartment> levelOneDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelOneDepartmentBatchUpdateArgs(levelOneDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelOneDepartmentList(List<LevelOneDepartment> levelOneDepartmentList){
		
		List<LevelOneDepartment> levelOneDepartmentCreateList=new ArrayList<LevelOneDepartment>();
		List<LevelOneDepartment> levelOneDepartmentUpdateList=new ArrayList<LevelOneDepartment>();
		
		for(LevelOneDepartment levelOneDepartment: levelOneDepartmentList){
			if(isUpdateRequest(levelOneDepartment)){
				levelOneDepartmentUpdateList.add( levelOneDepartment);
				continue;
			}
			levelOneDepartmentCreateList.add(levelOneDepartment);
		}
		
		return new Object[]{levelOneDepartmentCreateList,levelOneDepartmentUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelOneDepartment levelOneDepartment){
 		return levelOneDepartment.getVersion() > 0;
 	}
 	protected String getSaveLevelOneDepartmentSQL(LevelOneDepartment levelOneDepartment){
 		if(isUpdateRequest(levelOneDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelOneDepartmentParameters(LevelOneDepartment levelOneDepartment){
 		if(isUpdateRequest(levelOneDepartment) ){
 			return prepareLevelOneDepartmentUpdateParameters(levelOneDepartment);
 		}
 		return prepareLevelOneDepartmentCreateParameters(levelOneDepartment);
 	}
 	protected Object[] prepareLevelOneDepartmentUpdateParameters(LevelOneDepartment levelOneDepartment){
 		Object[] parameters = new Object[8];
  	
 		if(levelOneDepartment.getBelongsTo() != null){
 			parameters[0] = levelOneDepartment.getBelongsTo().getId();
 		}
 
 		
 		parameters[1] = levelOneDepartment.getName();
 		
 		
 		parameters[2] = levelOneDepartment.getDescription();
 		
 		
 		parameters[3] = levelOneDepartment.getManager();
 		
 		
 		parameters[4] = levelOneDepartment.getFounded();
 				
 		parameters[5] = levelOneDepartment.nextVersion();
 		parameters[6] = levelOneDepartment.getId();
 		parameters[7] = levelOneDepartment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelOneDepartmentCreateParameters(LevelOneDepartment levelOneDepartment){
		Object[] parameters = new Object[6];
		String newLevelOneDepartmentId=getNextId();
		levelOneDepartment.setId(newLevelOneDepartmentId);
		parameters[0] =  levelOneDepartment.getId();
  	
 		if(levelOneDepartment.getBelongsTo() != null){
 			parameters[1] = levelOneDepartment.getBelongsTo().getId();
 		
 		}
 		
 		
 		parameters[2] = levelOneDepartment.getName();
 		
 		
 		parameters[3] = levelOneDepartment.getDescription();
 		
 		
 		parameters[4] = levelOneDepartment.getManager();
 		
 		
 		parameters[5] = levelOneDepartment.getFounded();
 				
 				
 		return parameters;
 	}
 	
	protected LevelOneDepartment saveInternalLevelOneDepartment(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
		
		saveLevelOneDepartment(levelOneDepartment);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(levelOneDepartment, options);
 		}
 
		
		if(isSaveLevelTwoDepartmentListEnabled(options)){
	 		saveLevelTwoDepartmentList(levelOneDepartment, options);
	 		//removeLevelTwoDepartmentList(levelOneDepartment, options);
	 		//Not delete the record
	 		
 		}		
		
		return levelOneDepartment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelOneDepartment saveBelongsTo(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelOneDepartment.getBelongsTo() == null){
 			return levelOneDepartment;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(levelOneDepartment.getBelongsTo(),options);
 		return levelOneDepartment;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public LevelOneDepartment planToRemoveLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, String levelTwoDepartmentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelTwoDepartment.BELONGS_TO_PROPERTY, levelOneDepartment.getId());
		key.put(LevelTwoDepartment.ID_PROPERTY, levelTwoDepartmentIds);
		
		SmartList<LevelTwoDepartment> externalLevelTwoDepartmentList = getLevelTwoDepartmentDAO().
				findLevelTwoDepartmentWithKey(key, options);
		if(externalLevelTwoDepartmentList == null){
			return levelOneDepartment;
		}
		if(externalLevelTwoDepartmentList.isEmpty()){
			return levelOneDepartment;
		}
		
		for(LevelTwoDepartment levelTwoDepartmentItem: externalLevelTwoDepartmentList){

			levelTwoDepartmentItem.clearFromAll();
		}
		
		
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();		
		levelTwoDepartmentList.addAllToRemoveList(externalLevelTwoDepartmentList);
		return levelOneDepartment;	
	
	}



		
	protected LevelOneDepartment saveLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
		
		
		
		
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();
		if(levelTwoDepartmentList == null){
			//null list means nothing
			return levelOneDepartment;
		}
		SmartList<LevelTwoDepartment> mergedUpdateLevelTwoDepartmentList = new SmartList<LevelTwoDepartment>();
		
		
		mergedUpdateLevelTwoDepartmentList.addAll(levelTwoDepartmentList); 
		if(levelTwoDepartmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelTwoDepartmentList.addAll(levelTwoDepartmentList.getToRemoveList());
			levelTwoDepartmentList.removeAll(levelTwoDepartmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLevelTwoDepartmentDAO().saveLevelTwoDepartmentList(mergedUpdateLevelTwoDepartmentList,options);
		
		if(levelTwoDepartmentList.getToRemoveList() != null){
			levelTwoDepartmentList.removeAll(levelTwoDepartmentList.getToRemoveList());
		}
		
		
		return levelOneDepartment;
	
	}
	
	protected LevelOneDepartment removeLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, Map<String,Object> options){
	
	
		SmartList<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();
		if(levelTwoDepartmentList == null){
			return levelOneDepartment;
		}	
	
		SmartList<LevelTwoDepartment> toRemoveLevelTwoDepartmentList = levelTwoDepartmentList.getToRemoveList();
		
		if(toRemoveLevelTwoDepartmentList == null){
			return levelOneDepartment;
		}
		if(toRemoveLevelTwoDepartmentList.isEmpty()){
			return levelOneDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelTwoDepartmentDAO().removeLevelTwoDepartmentList(toRemoveLevelTwoDepartmentList,options);
		
		return levelOneDepartment;
	
	}
	
	

 	
 	
	
	
	
		

	public LevelOneDepartment present(LevelOneDepartment levelOneDepartment,Map<String, Object> options){
	
		presentLevelTwoDepartmentList(levelOneDepartment,options);

		return levelOneDepartment;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LevelOneDepartment presentLevelTwoDepartmentList(
			LevelOneDepartment levelOneDepartment,
			Map<String, Object> options) {

		SmartList<LevelTwoDepartment> levelTwoDepartmentList = levelOneDepartment.getLevelTwoDepartmentList();		
				SmartList<LevelTwoDepartment> newList= presentSubList(levelOneDepartment.getId(),
				levelTwoDepartmentList,
				options,
				getLevelTwoDepartmentDAO()::countLevelTwoDepartmentByBelongsTo,
				getLevelTwoDepartmentDAO()::findLevelTwoDepartmentByBelongsTo
				);

		
		levelOneDepartment.setLevelTwoDepartmentList(newList);
		

		return levelOneDepartment;
	}			
		

	
    public SmartList<LevelOneDepartment> requestCandidateLevelOneDepartmentForLevelTwoDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelOneDepartmentTable.COLUMN_BELONGS_TO, LevelOneDepartmentTable.COLUMN_BELONGS_TO, filterKey, pageNo, pageSize, getLevelOneDepartmentMapper());
    }
		

	protected String getTableName(){
		return LevelOneDepartmentTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LevelOneDepartment> levelOneDepartmentList) {		
		this.enhanceListInternal(levelOneDepartmentList, this.getLevelOneDepartmentMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:LevelTwoDepartment的belongsTo的LevelTwoDepartmentList
	public SmartList<LevelTwoDepartment> loadOurLevelTwoDepartmentList(RetailscmUserContext userContext, List<LevelOneDepartment> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelTwoDepartment.BELONGS_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LevelTwoDepartment> loadedObjs = userContext.getDAOGroup().getLevelTwoDepartmentDAO().findLevelTwoDepartmentWithKey(key, options);
		Map<String, List<LevelTwoDepartment>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBelongsTo().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LevelTwoDepartment> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LevelTwoDepartment> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLevelTwoDepartmentList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LevelOneDepartment> levelOneDepartmentList = ownerEntity.collectRefsWithType(LevelOneDepartment.INTERNAL_TYPE);
		this.enhanceList(levelOneDepartmentList);
		
	}
	
	@Override
	public SmartList<LevelOneDepartment> findLevelOneDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLevelOneDepartmentMapper());

	}
	@Override
	public int countLevelOneDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLevelOneDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LevelOneDepartment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLevelOneDepartmentMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateLevelOneDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateLevelOneDepartment result = new CandidateLevelOneDepartment();
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


