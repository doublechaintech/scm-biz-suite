
package com.doublechaintech.retailscm.levelonecategory;

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


import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.catalog.Catalog;

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryDAO;
import com.doublechaintech.retailscm.catalog.CatalogDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class LevelOneCategoryJDBCTemplateDAO extends RetailscmBaseDAOImpl implements LevelOneCategoryDAO{

	protected CatalogDAO catalogDAO;
	public void setCatalogDAO(CatalogDAO catalogDAO){
 	
 		if(catalogDAO == null){
 			throw new IllegalStateException("Do not try to set catalogDAO to null.");
 		}
	 	this.catalogDAO = catalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
 		if(this.catalogDAO == null){
 			throw new IllegalStateException("The catalogDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.catalogDAO;
 	}	

	protected LevelTwoCategoryDAO levelTwoCategoryDAO;
	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO levelTwoCategoryDAO){
 	
 		if(levelTwoCategoryDAO == null){
 			throw new IllegalStateException("Do not try to set levelTwoCategoryDAO to null.");
 		}
	 	this.levelTwoCategoryDAO = levelTwoCategoryDAO;
 	}
 	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
 		if(this.levelTwoCategoryDAO == null){
 			throw new IllegalStateException("The levelTwoCategoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelTwoCategoryDAO;
 	}	

	
	/*
	protected LevelOneCategory load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLevelOneCategory(accessKey, options);
	}
	*/
	
	public SmartList<LevelOneCategory> loadAll() {
	    return this.loadAll(getLevelOneCategoryMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public LevelOneCategory load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLevelOneCategory(LevelOneCategoryTable.withId(id), options);
	}
	
	
	
	public LevelOneCategory save(LevelOneCategory levelOneCategory,Map<String,Object> options){
		
		String methodName="save(LevelOneCategory levelOneCategory,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(levelOneCategory, methodName, "levelOneCategory");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLevelOneCategory(levelOneCategory,options);
	}
	public LevelOneCategory clone(String levelOneCategoryId, Map<String,Object> options) throws Exception{
	
		return clone(LevelOneCategoryTable.withId(levelOneCategoryId),options);
	}
	
	protected LevelOneCategory clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String levelOneCategoryId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LevelOneCategory newLevelOneCategory = loadInternalLevelOneCategory(accessKey, options);
		newLevelOneCategory.setVersion(0);
		
		
 		
 		if(isSaveLevelTwoCategoryListEnabled(options)){
 			for(LevelTwoCategory item: newLevelOneCategory.getLevelTwoCategoryList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLevelOneCategory(newLevelOneCategory,options);
		
		return newLevelOneCategory;
	}
	
	
	
	

	protected void throwIfHasException(String levelOneCategoryId,int version,int count) throws Exception{
		if (count == 1) {
			throw new LevelOneCategoryVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LevelOneCategoryNotFoundException(
					"The " + this.getTableName() + "(" + levelOneCategoryId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String levelOneCategoryId, int version) throws Exception{
	
		String methodName="delete(String levelOneCategoryId, int version)";
		assertMethodArgumentNotNull(levelOneCategoryId, methodName, "levelOneCategoryId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{levelOneCategoryId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(levelOneCategoryId,version);
		}
		
	
	}
	
	
	
	
	

	public LevelOneCategory disconnectFromAll(String levelOneCategoryId, int version) throws Exception{
	
		
		LevelOneCategory levelOneCategory = loadInternalLevelOneCategory(LevelOneCategoryTable.withId(levelOneCategoryId), emptyOptions());
		levelOneCategory.clearFromAll();
		this.saveLevelOneCategory(levelOneCategory);
		return levelOneCategory;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return LevelOneCategoryTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "level_one_category";
	}
	@Override
	protected String getBeanName() {
		
		return "levelOneCategory";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LevelOneCategoryTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCatalogEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LevelOneCategoryTokens.CATALOG);
 	}

 	protected boolean isSaveCatalogEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LevelOneCategoryTokens.CATALOG);
 	}
 	

 	
 
		
	
	protected boolean isExtractLevelTwoCategoryListEnabled(Map<String,Object> options){		
 		return checkOptions(options,LevelOneCategoryTokens.LEVEL_TWO_CATEGORY_LIST);
 	}
 	protected boolean isAnalyzeLevelTwoCategoryListEnabled(Map<String,Object> options){		 		
 		return LevelOneCategoryTokens.of(options).analyzeLevelTwoCategoryListEnabled();
 	}
	
	protected boolean isSaveLevelTwoCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, LevelOneCategoryTokens.LEVEL_TWO_CATEGORY_LIST);
		
 	}
 	
		

	

	protected LevelOneCategoryMapper getLevelOneCategoryMapper(){
		return new LevelOneCategoryMapper();
	}

	
	
	protected LevelOneCategory extractLevelOneCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			LevelOneCategory levelOneCategory = loadSingleObject(accessKey, getLevelOneCategoryMapper());
			return levelOneCategory;
		}catch(EmptyResultDataAccessException e){
			throw new LevelOneCategoryNotFoundException("LevelOneCategory("+accessKey+") is not found!");
		}

	}

	
	

	protected LevelOneCategory loadInternalLevelOneCategory(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LevelOneCategory levelOneCategory = extractLevelOneCategory(accessKey, loadOptions);
 	
 		if(isExtractCatalogEnabled(loadOptions)){
	 		extractCatalog(levelOneCategory, loadOptions);
 		}
 
		
		if(isExtractLevelTwoCategoryListEnabled(loadOptions)){
	 		extractLevelTwoCategoryList(levelOneCategory, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeLevelTwoCategoryListEnabled(loadOptions)){
	 		analyzeLevelTwoCategoryList(levelOneCategory, loadOptions);
 		}
 		
		
		return levelOneCategory;
		
	}

	 

 	protected LevelOneCategory extractCatalog(LevelOneCategory levelOneCategory, Map<String,Object> options) throws Exception{

		if(levelOneCategory.getCatalog() == null){
			return levelOneCategory;
		}
		String catalogId = levelOneCategory.getCatalog().getId();
		if( catalogId == null){
			return levelOneCategory;
		}
		Catalog catalog = getCatalogDAO().load(catalogId,options);
		if(catalog != null){
			levelOneCategory.setCatalog(catalog);
		}
		
 		
 		return levelOneCategory;
 	}
 		
 
		
	protected void enhanceLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected LevelOneCategory extractLevelTwoCategoryList(LevelOneCategory levelOneCategory, Map<String,Object> options){
		
		
		if(levelOneCategory == null){
			return null;
		}
		if(levelOneCategory.getId() == null){
			return levelOneCategory;
		}

		
		
		SmartList<LevelTwoCategory> levelTwoCategoryList = getLevelTwoCategoryDAO().findLevelTwoCategoryByParentCategory(levelOneCategory.getId(),options);
		if(levelTwoCategoryList != null){
			enhanceLevelTwoCategoryList(levelTwoCategoryList,options);
			levelOneCategory.setLevelTwoCategoryList(levelTwoCategoryList);
		}
		
		return levelOneCategory;
	
	}	
	
	protected LevelOneCategory analyzeLevelTwoCategoryList(LevelOneCategory levelOneCategory, Map<String,Object> options){
		
		
		if(levelOneCategory == null){
			return null;
		}
		if(levelOneCategory.getId() == null){
			return levelOneCategory;
		}

		
		
		SmartList<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();
		if(levelTwoCategoryList != null){
			getLevelTwoCategoryDAO().analyzeLevelTwoCategoryByParentCategory(levelTwoCategoryList, levelOneCategory.getId(), options);
			
		}
		
		return levelOneCategory;
	
	}	
	
		
		
  	
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId,Map<String,Object> options){
 	
  		SmartList<LevelOneCategory> resultList = queryWith(LevelOneCategoryTable.COLUMN_CATALOG, catalogId, options, getLevelOneCategoryMapper());
		// analyzeLevelOneCategoryByCatalog(resultList, catalogId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId, int start, int count,Map<String,Object> options){
 		
 		SmartList<LevelOneCategory> resultList =  queryWithRange(LevelOneCategoryTable.COLUMN_CATALOG, catalogId, options, getLevelOneCategoryMapper(), start, count);
 		//analyzeLevelOneCategoryByCatalog(resultList, catalogId, options);
 		return resultList;
 		
 	}
 	public void analyzeLevelOneCategoryByCatalog(SmartList<LevelOneCategory> resultList, String catalogId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countLevelOneCategoryByCatalog(String catalogId,Map<String,Object> options){

 		return countWith(LevelOneCategoryTable.COLUMN_CATALOG, catalogId, options);
 	}
 	@Override
	public Map<String, Integer> countLevelOneCategoryByCatalogIds(String[] ids, Map<String, Object> options) {
		return countWithIds(LevelOneCategoryTable.COLUMN_CATALOG, ids, options);
	}
 	
 	
		
		
		

	

	protected LevelOneCategory saveLevelOneCategory(LevelOneCategory  levelOneCategory){
		
		if(!levelOneCategory.isChanged()){
			return levelOneCategory;
		}
		
		
		String SQL=this.getSaveLevelOneCategorySQL(levelOneCategory);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLevelOneCategoryParameters(levelOneCategory);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		levelOneCategory.incVersion();
		return levelOneCategory;
	
	}
	public SmartList<LevelOneCategory> saveLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLevelOneCategoryList(levelOneCategoryList);
		
		batchLevelOneCategoryCreate((List<LevelOneCategory>)lists[CREATE_LIST_INDEX]);
		
		batchLevelOneCategoryUpdate((List<LevelOneCategory>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LevelOneCategory levelOneCategory:levelOneCategoryList){
			if(levelOneCategory.isChanged()){
				levelOneCategory.incVersion();
			}
			
		
		}
		
		
		return levelOneCategoryList;
	}

	public SmartList<LevelOneCategory> removeLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options){
		
		
		super.removeList(levelOneCategoryList, options);
		
		return levelOneCategoryList;
		
		
	}
	
	protected List<Object[]> prepareLevelOneCategoryBatchCreateArgs(List<LevelOneCategory> levelOneCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelOneCategory levelOneCategory:levelOneCategoryList ){
			Object [] parameters = prepareLevelOneCategoryCreateParameters(levelOneCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLevelOneCategoryBatchUpdateArgs(List<LevelOneCategory> levelOneCategoryList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LevelOneCategory levelOneCategory:levelOneCategoryList ){
			if(!levelOneCategory.isChanged()){
				continue;
			}
			Object [] parameters = prepareLevelOneCategoryUpdateParameters(levelOneCategory);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLevelOneCategoryCreate(List<LevelOneCategory> levelOneCategoryList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLevelOneCategoryBatchCreateArgs(levelOneCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLevelOneCategoryUpdate(List<LevelOneCategory> levelOneCategoryList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLevelOneCategoryBatchUpdateArgs(levelOneCategoryList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLevelOneCategoryList(List<LevelOneCategory> levelOneCategoryList){
		
		List<LevelOneCategory> levelOneCategoryCreateList=new ArrayList<LevelOneCategory>();
		List<LevelOneCategory> levelOneCategoryUpdateList=new ArrayList<LevelOneCategory>();
		
		for(LevelOneCategory levelOneCategory: levelOneCategoryList){
			if(isUpdateRequest(levelOneCategory)){
				levelOneCategoryUpdateList.add( levelOneCategory);
				continue;
			}
			levelOneCategoryCreateList.add(levelOneCategory);
		}
		
		return new Object[]{levelOneCategoryCreateList,levelOneCategoryUpdateList};
	}
	
	protected boolean isUpdateRequest(LevelOneCategory levelOneCategory){
 		return levelOneCategory.getVersion() > 0;
 	}
 	protected String getSaveLevelOneCategorySQL(LevelOneCategory levelOneCategory){
 		if(isUpdateRequest(levelOneCategory)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLevelOneCategoryParameters(LevelOneCategory levelOneCategory){
 		if(isUpdateRequest(levelOneCategory) ){
 			return prepareLevelOneCategoryUpdateParameters(levelOneCategory);
 		}
 		return prepareLevelOneCategoryCreateParameters(levelOneCategory);
 	}
 	protected Object[] prepareLevelOneCategoryUpdateParameters(LevelOneCategory levelOneCategory){
 		Object[] parameters = new Object[5];
  	
 		if(levelOneCategory.getCatalog() != null){
 			parameters[0] = levelOneCategory.getCatalog().getId();
 		}
 
 		
 		parameters[1] = levelOneCategory.getName();
 				
 		parameters[2] = levelOneCategory.nextVersion();
 		parameters[3] = levelOneCategory.getId();
 		parameters[4] = levelOneCategory.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLevelOneCategoryCreateParameters(LevelOneCategory levelOneCategory){
		Object[] parameters = new Object[3];
		String newLevelOneCategoryId=getNextId();
		levelOneCategory.setId(newLevelOneCategoryId);
		parameters[0] =  levelOneCategory.getId();
  	
 		if(levelOneCategory.getCatalog() != null){
 			parameters[1] = levelOneCategory.getCatalog().getId();
 		
 		}
 		
 		
 		parameters[2] = levelOneCategory.getName();
 				
 				
 		return parameters;
 	}
 	
	protected LevelOneCategory saveInternalLevelOneCategory(LevelOneCategory levelOneCategory, Map<String,Object> options){
		
		saveLevelOneCategory(levelOneCategory);
 	
 		if(isSaveCatalogEnabled(options)){
	 		saveCatalog(levelOneCategory, options);
 		}
 
		
		if(isSaveLevelTwoCategoryListEnabled(options)){
	 		saveLevelTwoCategoryList(levelOneCategory, options);
	 		//removeLevelTwoCategoryList(levelOneCategory, options);
	 		//Not delete the record
	 		
 		}		
		
		return levelOneCategory;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LevelOneCategory saveCatalog(LevelOneCategory levelOneCategory, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(levelOneCategory.getCatalog() == null){
 			return levelOneCategory;//do nothing when it is null
 		}
 		
 		getCatalogDAO().save(levelOneCategory.getCatalog(),options);
 		return levelOneCategory;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public LevelOneCategory planToRemoveLevelTwoCategoryList(LevelOneCategory levelOneCategory, String levelTwoCategoryIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, levelOneCategory.getId());
		key.put(LevelTwoCategory.ID_PROPERTY, levelTwoCategoryIds);
		
		SmartList<LevelTwoCategory> externalLevelTwoCategoryList = getLevelTwoCategoryDAO().
				findLevelTwoCategoryWithKey(key, options);
		if(externalLevelTwoCategoryList == null){
			return levelOneCategory;
		}
		if(externalLevelTwoCategoryList.isEmpty()){
			return levelOneCategory;
		}
		
		for(LevelTwoCategory levelTwoCategoryItem: externalLevelTwoCategoryList){

			levelTwoCategoryItem.clearFromAll();
		}
		
		
		SmartList<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();		
		levelTwoCategoryList.addAllToRemoveList(externalLevelTwoCategoryList);
		return levelOneCategory;	
	
	}



		
	protected LevelOneCategory saveLevelTwoCategoryList(LevelOneCategory levelOneCategory, Map<String,Object> options){
		
		
		
		
		SmartList<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();
		if(levelTwoCategoryList == null){
			//null list means nothing
			return levelOneCategory;
		}
		SmartList<LevelTwoCategory> mergedUpdateLevelTwoCategoryList = new SmartList<LevelTwoCategory>();
		
		
		mergedUpdateLevelTwoCategoryList.addAll(levelTwoCategoryList); 
		if(levelTwoCategoryList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelTwoCategoryList.addAll(levelTwoCategoryList.getToRemoveList());
			levelTwoCategoryList.removeAll(levelTwoCategoryList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLevelTwoCategoryDAO().saveLevelTwoCategoryList(mergedUpdateLevelTwoCategoryList,options);
		
		if(levelTwoCategoryList.getToRemoveList() != null){
			levelTwoCategoryList.removeAll(levelTwoCategoryList.getToRemoveList());
		}
		
		
		return levelOneCategory;
	
	}
	
	protected LevelOneCategory removeLevelTwoCategoryList(LevelOneCategory levelOneCategory, Map<String,Object> options){
	
	
		SmartList<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();
		if(levelTwoCategoryList == null){
			return levelOneCategory;
		}	
	
		SmartList<LevelTwoCategory> toRemoveLevelTwoCategoryList = levelTwoCategoryList.getToRemoveList();
		
		if(toRemoveLevelTwoCategoryList == null){
			return levelOneCategory;
		}
		if(toRemoveLevelTwoCategoryList.isEmpty()){
			return levelOneCategory;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelTwoCategoryDAO().removeLevelTwoCategoryList(toRemoveLevelTwoCategoryList,options);
		
		return levelOneCategory;
	
	}
	
	

 	
 	
	
	
	
		

	public LevelOneCategory present(LevelOneCategory levelOneCategory,Map<String, Object> options){
	
		presentLevelTwoCategoryList(levelOneCategory,options);

		return levelOneCategory;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected LevelOneCategory presentLevelTwoCategoryList(
			LevelOneCategory levelOneCategory,
			Map<String, Object> options) {

		SmartList<LevelTwoCategory> levelTwoCategoryList = levelOneCategory.getLevelTwoCategoryList();		
				SmartList<LevelTwoCategory> newList= presentSubList(levelOneCategory.getId(),
				levelTwoCategoryList,
				options,
				getLevelTwoCategoryDAO()::countLevelTwoCategoryByParentCategory,
				getLevelTwoCategoryDAO()::findLevelTwoCategoryByParentCategory
				);

		
		levelOneCategory.setLevelTwoCategoryList(newList);
		

		return levelOneCategory;
	}			
		

	
    public SmartList<LevelOneCategory> requestCandidateLevelOneCategoryForLevelTwoCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(LevelOneCategoryTable.COLUMN_CATALOG, LevelOneCategoryTable.COLUMN_CATALOG, filterKey, pageNo, pageSize, getLevelOneCategoryMapper());
    }
		

	protected String getTableName(){
		return LevelOneCategoryTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<LevelOneCategory> levelOneCategoryList) {		
		this.enhanceListInternal(levelOneCategoryList, this.getLevelOneCategoryMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:LevelTwoCategory的parentCategory的LevelTwoCategoryList
	public SmartList<LevelTwoCategory> loadOurLevelTwoCategoryList(RetailscmUserContext userContext, List<LevelOneCategory> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LevelTwoCategory> loadedObjs = userContext.getDAOGroup().getLevelTwoCategoryDAO().findLevelTwoCategoryWithKey(key, options);
		Map<String, List<LevelTwoCategory>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getParentCategory().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LevelTwoCategory> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LevelTwoCategory> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLevelTwoCategoryList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<LevelOneCategory> levelOneCategoryList = ownerEntity.collectRefsWithType(LevelOneCategory.INTERNAL_TYPE);
		this.enhanceList(levelOneCategoryList);
		
	}
	
	@Override
	public SmartList<LevelOneCategory> findLevelOneCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getLevelOneCategoryMapper());

	}
	@Override
	public int countLevelOneCategoryWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countLevelOneCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<LevelOneCategory> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getLevelOneCategoryMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateLevelOneCategory executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateLevelOneCategory result = new CandidateLevelOneCategory();
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


