
package com.doublechaintech.retailscm.leveltwocategory;

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


import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryDAO;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class LevelTwoCategoryJDBCTemplateDAO extends RetailscmBaseDAOImpl implements LevelTwoCategoryDAO{

	protected LevelOneCategoryDAO levelOneCategoryDAO;
	public void setLevelOneCategoryDAO(LevelOneCategoryDAO levelOneCategoryDAO){
 	
 		if(levelOneCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneCategoryDAO to null.");
 		}
	 	this.levelOneCategoryDAO = levelOneCategoryDAO;
 	}
 	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
 		if(this.levelOneCategoryDAO == null){
 			throw new IllegalStateException("The levelOneCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelOneCategoryDAO;
 	}	

	protected LevelThreeCategoryDAO levelThreeCategoryDAO;
	public void setLevelThreeCategoryDAO(LevelThreeCategoryDAO levelThreeCategoryDAO){
 	
 		if(levelThreeCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelThreeCategoryDAO to null.");
 		}
	 	this.levelThreeCategoryDAO = levelThreeCategoryDAO;
 	}
 	public LevelThreeCategoryDAO getLevelThreeCategoryDAO(){
 		if(this.levelThreeCategoryDAO == null){
 			throw new IllegalStateException("The levelThreeCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelThreeCategoryDAO;
 	}	

	
	/*
	protected LevelTwoCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoCategory(accessKey, options);
	}
	*/
	
	public SmartList<LevelTwoCategory> loadAll() {
	    return this.loadAll(getLevelTwoCategoryMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LevelTwoCategory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelTwoCategory(LevelTwoCategoryTable.withId(id), options);
	}
	
	
	
	public LevelTwoCategory save(LevelTwoCategory levelTwoCategory,Map<String,Object> options){
		
		String methodName="save(LevelTwoCategory levelTwoCategory,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelTwoCategory, methodName, "levelTwoCategory");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelTwoCategory(levelTwoCategory,options);
	}
	public LevelTwoCategory clone(String levelTwoCategoryId, Map<String,Object> options) throws Exception{
	
		return clone(LevelTwoCategoryTable.withId(levelTwoCategoryId),options);
	}
	
	protected LevelTwoCategory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelTwoCategoryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelTwoCategory newLevelTwoCategory = loadInternalLevelTwoCategory(accessKey, options);
		newLevelTwoCategory.setVersion(0);
		
		
 		
 		if(isSaveLevelThreeCategoryListEnabled(options)){
 			for(LevelThreeCategory item: newLevelTwoCategory.getLevelThreeCategoryList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelTwoCategory(newLevelTwoCategory,options);
		
		return newLevelTwoCategory;
	}
	
	
	
	

	protected void throwIfHasException(String levelTwoCategoryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LevelTwoCategoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelTwoCategoryNotFoundException(
					"The " + this.getTableName() + "(" + levelTwoCategoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String levelTwoCategoryId, int version) throws Exception{
	
		String methodName="delete(String levelTwoCategoryId, int version)";
		assertMethodArgumentNotNull(levelTwoCategoryId, methodName, "levelTwoCategoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelTwoCategoryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelTwoCategoryId,version);
		}
		
	
	}
	
	
	
	
	

	public LevelTwoCategory disconnectFromAll(String levelTwoCategoryId, int version) throws Exception{
	
		
		LevelTwoCategory levelTwoCategory = loadInternalLevelTwoCategory(LevelTwoCategoryTable.withId(levelTwoCategoryId), emptyOptions());
		levelTwoCategory.clearFromAll();
		this.saveLevelTwoCategory(levelTwoCategory);
		return levelTwoCategory;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LevelTwoCategoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_two_category";
	}
	@Override
	protected String getBeanName() {
		
		return "levelTwoCategory";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelTwoCategoryTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelTwoCategoryTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelTwoCategoryTokens.PARENTCATEGORY);
 	}
 	

 	
 
		
	
	protected boolean isExtractLevelThreeCategoryListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelTwoCategoryTokens.LEVEL_THREE_CATEGORY_LIST);
 	}
 	protected boolean isAnalyzeLevelThreeCategoryListEnabled(Map<String,Object> options){		 		
 		return LevelTwoCategoryTokens.of(options).analyzeLevelThreeCategoryListEnabled();
 	}
	
	protected boolean isSaveLevelThreeCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelTwoCategoryTokens.LEVEL_THREE_CATEGORY_LIST);
		
 	}
 	
		

	

	protected LevelTwoCategoryMapper getLevelTwoCategoryMapper(){
		return new LevelTwoCategoryMapper();
	}

	
	
	protected LevelTwoCategory extractLevelTwoCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LevelTwoCategory levelTwoCategory = loadSingleObject(accessKey, getLevelTwoCategoryMapper());
			return levelTwoCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelTwoCategoryNotFoundException("LevelTwoCategory("+accessKey+") is not found!");
		}

	}

	
	

	protected LevelTwoCategory loadInternalLevelTwoCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelTwoCategory levelTwoCategory = extractLevelTwoCategory(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(levelTwoCategory, loadOptions);
 		}
 
		
		if(isExtractLevelThreeCategoryListEnabled(loadOptions)){
	 		extractLevelThreeCategoryList(levelTwoCategory, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeLevelThreeCategoryListEnabled(loadOptions)){
	 		analyzeLevelThreeCategoryList(levelTwoCategory, loadOptions);
 		}
 		
		
		return levelTwoCategory;
		
	}

	 

 	protected LevelTwoCategory extractParentCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options) throws Exception{

		if(levelTwoCategory.getParentCategory() == null){
			return levelTwoCategory;
		}
		String parentCategoryId = levelTwoCategory.getParentCategory().getId();
		if( parentCategoryId == null){
			return levelTwoCategory;
		}
		LevelOneCategory parentCategory = getLevelOneCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			levelTwoCategory.setParentCategory(parentCategory);
		}
		
 		
 		return levelTwoCategory;
 	}
 		
 
		
	protected void enhanceLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelTwoCategory extractLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		
		if(levelTwoCategory == null){
			return null;
		}
		if(levelTwoCategory.getId() == null){
			return levelTwoCategory;
		}

		
		
		SmartList<LevelThreeCategory> levelThreeCategoryList = getLevelThreeCategoryDAO().findLevelThreeCategoryByParentCategory(levelTwoCategory.getId(),options);
		if(levelThreeCategoryList != null){
			enhanceLevelThreeCategoryList(levelThreeCategoryList,options);
			levelTwoCategory.setLevelThreeCategoryList(levelThreeCategoryList);
		}
		
		return levelTwoCategory;
	
	}	
	
	protected LevelTwoCategory analyzeLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		
		if(levelTwoCategory == null){
			return null;
		}
		if(levelTwoCategory.getId() == null){
			return levelTwoCategory;
		}

		
		
		SmartList<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();
		if(levelThreeCategoryList != null){
			getLevelThreeCategoryDAO().analyzeLevelThreeCategoryByParentCategory(levelThreeCategoryList, levelTwoCategory.getId(), options);
			
		}
		
		return levelTwoCategory;
	
	}	
	
		
		
  	
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId,Map<String,Object> options){
 	
  		SmartList<LevelTwoCategory> resultList = queryWith(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, levelOneCategoryId, options, getLevelTwoCategoryMapper());
		// analyzeLevelTwoCategoryByParentCategory(resultList, levelOneCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LevelTwoCategory> resultList =  queryWithRange(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, levelOneCategoryId, options, getLevelTwoCategoryMapper(), start, count);
 		//analyzeLevelTwoCategoryByParentCategory(resultList, levelOneCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeLevelTwoCategoryByParentCategory(SmartList<LevelTwoCategory> resultList, String levelOneCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLevelTwoCategoryByParentCategory(String levelOneCategoryId,Map<String,Object> options){

 		return countWith(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, levelOneCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countLevelTwoCategoryByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
 	
		
		
		

	

	protected LevelTwoCategory saveLevelTwoCategory(LevelTwoCategory  levelTwoCategory){
		
		if(!levelTwoCategory.isChanged()){
			return levelTwoCategory;
		}
		
		
		String SQL=this.getSaveLevelTwoCategorySQL(levelTwoCategory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelTwoCategoryParameters(levelTwoCategory);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelTwoCategory.incVersion();
		return levelTwoCategory;
	
	}
	public SmartList<LevelTwoCategory> saveLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelTwoCategoryList(levelTwoCategoryList);
		
		batchLevelTwoCategoryCreate((List<LevelTwoCategory>)lists[CREATE_LIST_INDEX]);
		
		batchLevelTwoCategoryUpdate((List<LevelTwoCategory>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList){
			if(levelTwoCategory.isChanged()){
				levelTwoCategory.incVersion();
			}
			
		
		}
		
		
		return levelTwoCategoryList;
	}

	public SmartList<LevelTwoCategory> removeLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options){
		
		
		super.removeList(levelTwoCategoryList, options);
		
		return levelTwoCategoryList;
		
		
	}
	
	protected List<Object[]> prepareLevelTwoCategoryBatchCreateArgs(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList ){
			Object [] parameters = prepareLevelTwoCategoryCreateParameters(levelTwoCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelTwoCategoryBatchUpdateArgs(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelTwoCategory levelTwoCategory:levelTwoCategoryList ){
			if(!levelTwoCategory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelTwoCategoryUpdateParameters(levelTwoCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelTwoCategoryCreate(List<LevelTwoCategory> levelTwoCategoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelTwoCategoryBatchCreateArgs(levelTwoCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelTwoCategoryUpdate(List<LevelTwoCategory> levelTwoCategoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelTwoCategoryBatchUpdateArgs(levelTwoCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelTwoCategoryList(List<LevelTwoCategory> levelTwoCategoryList){
		
		List<LevelTwoCategory> levelTwoCategoryCreateList=new ArrayList<LevelTwoCategory>();
		List<LevelTwoCategory> levelTwoCategoryUpdateList=new ArrayList<LevelTwoCategory>();
		
		for(LevelTwoCategory levelTwoCategory: levelTwoCategoryList){
			if(isUpdateRequest(levelTwoCategory)){
				levelTwoCategoryUpdateList.add( levelTwoCategory);
				continue;
			}
			levelTwoCategoryCreateList.add(levelTwoCategory);
		}
		
		return new Object[]{levelTwoCategoryCreateList,levelTwoCategoryUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelTwoCategory levelTwoCategory){
 		return levelTwoCategory.getVersion() > 0;
 	}
 	protected String getSaveLevelTwoCategorySQL(LevelTwoCategory levelTwoCategory){
 		if(isUpdateRequest(levelTwoCategory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelTwoCategoryParameters(LevelTwoCategory levelTwoCategory){
 		if(isUpdateRequest(levelTwoCategory) ){
 			return prepareLevelTwoCategoryUpdateParameters(levelTwoCategory);
 		}
 		return prepareLevelTwoCategoryCreateParameters(levelTwoCategory);
 	}
 	protected Object[] prepareLevelTwoCategoryUpdateParameters(LevelTwoCategory levelTwoCategory){
 		Object[] parameters = new Object[5];
  	
 		if(levelTwoCategory.getParentCategory() != null){
 			parameters[0] = levelTwoCategory.getParentCategory().getId();
 		}
 
 		
 		parameters[1] = levelTwoCategory.getName();
 				
 		parameters[2] = levelTwoCategory.nextVersion();
 		parameters[3] = levelTwoCategory.getId();
 		parameters[4] = levelTwoCategory.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelTwoCategoryCreateParameters(LevelTwoCategory levelTwoCategory){
		Object[] parameters = new Object[3];
		String newLevelTwoCategoryId=getNextId();
		levelTwoCategory.setId(newLevelTwoCategoryId);
		parameters[0] =  levelTwoCategory.getId();
  	
 		if(levelTwoCategory.getParentCategory() != null){
 			parameters[1] = levelTwoCategory.getParentCategory().getId();
 		
 		}
 		
 		
 		parameters[2] = levelTwoCategory.getName();
 				
 				
 		return parameters;
 	}
 	
	protected LevelTwoCategory saveInternalLevelTwoCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		saveLevelTwoCategory(levelTwoCategory);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(levelTwoCategory, options);
 		}
 
		
		if(isSaveLevelThreeCategoryListEnabled(options)){
	 		saveLevelThreeCategoryList(levelTwoCategory, options);
	 		//removeLevelThreeCategoryList(levelTwoCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		return levelTwoCategory;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelTwoCategory saveParentCategory(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelTwoCategory.getParentCategory() == null){
 			return levelTwoCategory;//do nothing when it is null
 		}
 		
 		getLevelOneCategoryDAO().save(levelTwoCategory.getParentCategory(),options);
 		return levelTwoCategory;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public LevelTwoCategory planToRemoveLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, String levelThreeCategoryIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, levelTwoCategory.getId());
		key.put(LevelThreeCategory.ID_PROPERTY, levelThreeCategoryIds);
		
		SmartList<LevelThreeCategory> externalLevelThreeCategoryList = getLevelThreeCategoryDAO().
				findLevelThreeCategoryWithKey(key, options);
		if(externalLevelThreeCategoryList == null){
			return levelTwoCategory;
		}
		if(externalLevelThreeCategoryList.isEmpty()){
			return levelTwoCategory;
		}
		
		for(LevelThreeCategory levelThreeCategoryItem: externalLevelThreeCategoryList){

			levelThreeCategoryItem.clearFromAll();
		}
		
		
		SmartList<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();		
		levelThreeCategoryList.addAllToRemoveList(externalLevelThreeCategoryList);
		return levelTwoCategory;	
	
	}



		
	protected LevelTwoCategory saveLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
		
		
		
		
		SmartList<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();
		if(levelThreeCategoryList == null){
			//null list means nothing
			return levelTwoCategory;
		}
		SmartList<LevelThreeCategory> mergedUpdateLevelThreeCategoryList = new SmartList<LevelThreeCategory>();
		
		
		mergedUpdateLevelThreeCategoryList.addAll(levelThreeCategoryList); 
		if(levelThreeCategoryList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelThreeCategoryList.addAll(levelThreeCategoryList.getToRemoveList());
			levelThreeCategoryList.removeAll(levelThreeCategoryList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLevelThreeCategoryDAO().saveLevelThreeCategoryList(mergedUpdateLevelThreeCategoryList,options);
		
		if(levelThreeCategoryList.getToRemoveList() != null){
			levelThreeCategoryList.removeAll(levelThreeCategoryList.getToRemoveList());
		}
		
		
		return levelTwoCategory;
	
	}
	
	protected LevelTwoCategory removeLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, Map<String,Object> options){
	
	
		SmartList<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();
		if(levelThreeCategoryList == null){
			return levelTwoCategory;
		}	
	
		SmartList<LevelThreeCategory> toRemoveLevelThreeCategoryList = levelThreeCategoryList.getToRemoveList();
		
		if(toRemoveLevelThreeCategoryList == null){
			return levelTwoCategory;
		}
		if(toRemoveLevelThreeCategoryList.isEmpty()){
			return levelTwoCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelThreeCategoryDAO().removeLevelThreeCategoryList(toRemoveLevelThreeCategoryList,options);
		
		return levelTwoCategory;
	
	}
	
	

 	
 	
	
	
	
		

	public LevelTwoCategory present(LevelTwoCategory levelTwoCategory,Map<String, Object> options){
	
		presentLevelThreeCategoryList(levelTwoCategory,options);

		return levelTwoCategory;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LevelTwoCategory presentLevelThreeCategoryList(
			LevelTwoCategory levelTwoCategory,
			Map<String, Object> options) {

		SmartList<LevelThreeCategory> levelThreeCategoryList = levelTwoCategory.getLevelThreeCategoryList();		
				SmartList<LevelThreeCategory> newList= presentSubList(levelTwoCategory.getId(),
				levelThreeCategoryList,
				options,
				getLevelThreeCategoryDAO()::countLevelThreeCategoryByParentCategory,
				getLevelThreeCategoryDAO()::findLevelThreeCategoryByParentCategory
				);

		
		levelTwoCategory.setLevelThreeCategoryList(newList);
		

		return levelTwoCategory;
	}			
		

	
    public SmartList<LevelTwoCategory> requestCandidateLevelTwoCategoryForLevelThreeCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getLevelTwoCategoryMapper());
    }
		

	protected String getTableName(){
		return LevelTwoCategoryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LevelTwoCategory> levelTwoCategoryList) {		
		this.enhanceListInternal(levelTwoCategoryList, this.getLevelTwoCategoryMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:LevelThreeCategory的parentCategory的LevelThreeCategoryList
	public SmartList<LevelThreeCategory> loadOurLevelThreeCategoryList(RetailscmUserContext userContext, List<LevelTwoCategory> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LevelThreeCategory> loadedObjs = userContext.getDAOGroup().getLevelThreeCategoryDAO().findLevelThreeCategoryWithKey(key, options);
		Map<String, List<LevelThreeCategory>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getParentCategory().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LevelThreeCategory> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LevelThreeCategory> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLevelThreeCategoryList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LevelTwoCategory> levelTwoCategoryList = ownerEntity.collectRefsWithType(LevelTwoCategory.INTERNAL_TYPE);
		this.enhanceList(levelTwoCategoryList);
		
	}
	
	@Override
	public SmartList<LevelTwoCategory> findLevelTwoCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLevelTwoCategoryMapper());

	}
	@Override
	public int countLevelTwoCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLevelTwoCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LevelTwoCategory> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLevelTwoCategoryMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateLevelTwoCategory executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateLevelTwoCategory result = new CandidateLevelTwoCategory();
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


