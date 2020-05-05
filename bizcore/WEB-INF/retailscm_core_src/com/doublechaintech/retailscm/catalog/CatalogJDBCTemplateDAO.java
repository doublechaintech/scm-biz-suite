
package com.doublechaintech.retailscm.catalog;

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
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class CatalogJDBCTemplateDAO extends RetailscmBaseDAOImpl implements CatalogDAO{

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

	
	/*
	protected Catalog load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCatalog(accessKey, options);
	}
	*/
	
	public SmartList<Catalog> loadAll() {
	    return this.loadAll(getCatalogMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Catalog load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCatalog(CatalogTable.withId(id), options);
	}
	
	
	
	public Catalog save(Catalog catalog,Map<String,Object> options){
		
		String methodName="save(Catalog catalog,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(catalog, methodName, "catalog");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCatalog(catalog,options);
	}
	public Catalog clone(String catalogId, Map<String,Object> options) throws Exception{
	
		return clone(CatalogTable.withId(catalogId),options);
	}
	
	protected Catalog clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String catalogId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Catalog newCatalog = loadInternalCatalog(accessKey, options);
		newCatalog.setVersion(0);
		
		
 		
 		if(isSaveLevelOneCategoryListEnabled(options)){
 			for(LevelOneCategory item: newCatalog.getLevelOneCategoryList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCatalog(newCatalog,options);
		
		return newCatalog;
	}
	
	
	
	

	protected void throwIfHasException(String catalogId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CatalogVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CatalogNotFoundException(
					"The " + this.getTableName() + "(" + catalogId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String catalogId, int version) throws Exception{
	
		String methodName="delete(String catalogId, int version)";
		assertMethodArgumentNotNull(catalogId, methodName, "catalogId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{catalogId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(catalogId,version);
		}
		
	
	}
	
	
	
	
	

	public Catalog disconnectFromAll(String catalogId, int version) throws Exception{
	
		
		Catalog catalog = loadInternalCatalog(CatalogTable.withId(catalogId), emptyOptions());
		catalog.clearFromAll();
		this.saveCatalog(catalog);
		return catalog;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return CatalogTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "catalog";
	}
	@Override
	protected String getBeanName() {
		
		return "catalog";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CatalogTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CatalogTokens.OWNER);
 	}

 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CatalogTokens.OWNER);
 	}
 	

 	
 
		
	
	protected boolean isExtractLevelOneCategoryListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CatalogTokens.LEVEL_ONE_CATEGORY_LIST);
 	}
 	protected boolean isAnalyzeLevelOneCategoryListEnabled(Map<String,Object> options){		 		
 		return CatalogTokens.of(options).analyzeLevelOneCategoryListEnabled();
 	}
	
	protected boolean isSaveLevelOneCategoryListEnabled(Map<String,Object> options){
		return checkOptions(options, CatalogTokens.LEVEL_ONE_CATEGORY_LIST);
		
 	}
 	
		

	

	protected CatalogMapper getCatalogMapper(){
		return new CatalogMapper();
	}

	
	
	protected Catalog extractCatalog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Catalog catalog = loadSingleObject(accessKey, getCatalogMapper());
			return catalog;
		}catch(EmptyResultDataAccessException e){
			throw new CatalogNotFoundException("Catalog("+accessKey+") is not found!");
		}

	}

	
	

	protected Catalog loadInternalCatalog(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Catalog catalog = extractCatalog(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(catalog, loadOptions);
 		}
 
		
		if(isExtractLevelOneCategoryListEnabled(loadOptions)){
	 		extractLevelOneCategoryList(catalog, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeLevelOneCategoryListEnabled(loadOptions)){
	 		analyzeLevelOneCategoryList(catalog, loadOptions);
 		}
 		
		
		return catalog;
		
	}

	 

 	protected Catalog extractOwner(Catalog catalog, Map<String,Object> options) throws Exception{

		if(catalog.getOwner() == null){
			return catalog;
		}
		String ownerId = catalog.getOwner().getId();
		if( ownerId == null){
			return catalog;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			catalog.setOwner(owner);
		}
		
 		
 		return catalog;
 	}
 		
 
		
	protected void enhanceLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Catalog extractLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<LevelOneCategory> levelOneCategoryList = getLevelOneCategoryDAO().findLevelOneCategoryByCatalog(catalog.getId(),options);
		if(levelOneCategoryList != null){
			enhanceLevelOneCategoryList(levelOneCategoryList,options);
			catalog.setLevelOneCategoryList(levelOneCategoryList);
		}
		
		return catalog;
	
	}	
	
	protected Catalog analyzeLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		if(catalog == null){
			return null;
		}
		if(catalog.getId() == null){
			return catalog;
		}

		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList != null){
			getLevelOneCategoryDAO().analyzeLevelOneCategoryByCatalog(levelOneCategoryList, catalog.getId(), options);
			
		}
		
		return catalog;
	
	}	
	
		
		
  	
 	public SmartList<Catalog> findCatalogByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<Catalog> resultList = queryWith(CatalogTable.COLUMN_OWNER, retailStoreCountryCenterId, options, getCatalogMapper());
		// analyzeCatalogByOwner(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Catalog> findCatalogByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Catalog> resultList =  queryWithRange(CatalogTable.COLUMN_OWNER, retailStoreCountryCenterId, options, getCatalogMapper(), start, count);
 		//analyzeCatalogByOwner(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeCatalogByOwner(SmartList<Catalog> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countCatalogByOwner(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(CatalogTable.COLUMN_OWNER, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countCatalogByOwnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CatalogTable.COLUMN_OWNER, ids, options);
	}
 	
 	
		
		
		

	

	protected Catalog saveCatalog(Catalog  catalog){
		
		if(!catalog.isChanged()){
			return catalog;
		}
		
		
		String SQL=this.getSaveCatalogSQL(catalog);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCatalogParameters(catalog);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		catalog.incVersion();
		return catalog;
	
	}
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCatalogList(catalogList);
		
		batchCatalogCreate((List<Catalog>)lists[CREATE_LIST_INDEX]);
		
		batchCatalogUpdate((List<Catalog>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Catalog catalog:catalogList){
			if(catalog.isChanged()){
				catalog.incVersion();
			}
			
		
		}
		
		
		return catalogList;
	}

	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		
		
		super.removeList(catalogList, options);
		
		return catalogList;
		
		
	}
	
	protected List<Object[]> prepareCatalogBatchCreateArgs(List<Catalog> catalogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Catalog catalog:catalogList ){
			Object [] parameters = prepareCatalogCreateParameters(catalog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCatalogBatchUpdateArgs(List<Catalog> catalogList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Catalog catalog:catalogList ){
			if(!catalog.isChanged()){
				continue;
			}
			Object [] parameters = prepareCatalogUpdateParameters(catalog);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCatalogCreate(List<Catalog> catalogList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCatalogBatchCreateArgs(catalogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCatalogUpdate(List<Catalog> catalogList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCatalogBatchUpdateArgs(catalogList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCatalogList(List<Catalog> catalogList){
		
		List<Catalog> catalogCreateList=new ArrayList<Catalog>();
		List<Catalog> catalogUpdateList=new ArrayList<Catalog>();
		
		for(Catalog catalog: catalogList){
			if(isUpdateRequest(catalog)){
				catalogUpdateList.add( catalog);
				continue;
			}
			catalogCreateList.add(catalog);
		}
		
		return new Object[]{catalogCreateList,catalogUpdateList};
	}
	
	protected boolean isUpdateRequest(Catalog catalog){
 		return catalog.getVersion() > 0;
 	}
 	protected String getSaveCatalogSQL(Catalog catalog){
 		if(isUpdateRequest(catalog)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCatalogParameters(Catalog catalog){
 		if(isUpdateRequest(catalog) ){
 			return prepareCatalogUpdateParameters(catalog);
 		}
 		return prepareCatalogCreateParameters(catalog);
 	}
 	protected Object[] prepareCatalogUpdateParameters(Catalog catalog){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = catalog.getName();
 		 	
 		if(catalog.getOwner() != null){
 			parameters[1] = catalog.getOwner().getId();
 		}
 
 		
 		parameters[2] = catalog.getSubCount();
 		
 		
 		parameters[3] = catalog.getAmount();
 				
 		parameters[4] = catalog.nextVersion();
 		parameters[5] = catalog.getId();
 		parameters[6] = catalog.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCatalogCreateParameters(Catalog catalog){
		Object[] parameters = new Object[5];
		String newCatalogId=getNextId();
		catalog.setId(newCatalogId);
		parameters[0] =  catalog.getId();
 
 		
 		parameters[1] = catalog.getName();
 		 	
 		if(catalog.getOwner() != null){
 			parameters[2] = catalog.getOwner().getId();
 		
 		}
 		
 		
 		parameters[3] = catalog.getSubCount();
 		
 		
 		parameters[4] = catalog.getAmount();
 				
 				
 		return parameters;
 	}
 	
	protected Catalog saveInternalCatalog(Catalog catalog, Map<String,Object> options){
		
		saveCatalog(catalog);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(catalog, options);
 		}
 
		
		if(isSaveLevelOneCategoryListEnabled(options)){
	 		saveLevelOneCategoryList(catalog, options);
	 		//removeLevelOneCategoryList(catalog, options);
	 		//Not delete the record
	 		
 		}		
		
		return catalog;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Catalog saveOwner(Catalog catalog, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(catalog.getOwner() == null){
 			return catalog;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(catalog.getOwner(),options);
 		return catalog;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Catalog planToRemoveLevelOneCategoryList(Catalog catalog, String levelOneCategoryIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelOneCategory.CATALOG_PROPERTY, catalog.getId());
		key.put(LevelOneCategory.ID_PROPERTY, levelOneCategoryIds);
		
		SmartList<LevelOneCategory> externalLevelOneCategoryList = getLevelOneCategoryDAO().
				findLevelOneCategoryWithKey(key, options);
		if(externalLevelOneCategoryList == null){
			return catalog;
		}
		if(externalLevelOneCategoryList.isEmpty()){
			return catalog;
		}
		
		for(LevelOneCategory levelOneCategoryItem: externalLevelOneCategoryList){

			levelOneCategoryItem.clearFromAll();
		}
		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();		
		levelOneCategoryList.addAllToRemoveList(externalLevelOneCategoryList);
		return catalog;	
	
	}



		
	protected Catalog saveLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
		
		
		
		
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList == null){
			//null list means nothing
			return catalog;
		}
		SmartList<LevelOneCategory> mergedUpdateLevelOneCategoryList = new SmartList<LevelOneCategory>();
		
		
		mergedUpdateLevelOneCategoryList.addAll(levelOneCategoryList); 
		if(levelOneCategoryList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelOneCategoryList.addAll(levelOneCategoryList.getToRemoveList());
			levelOneCategoryList.removeAll(levelOneCategoryList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLevelOneCategoryDAO().saveLevelOneCategoryList(mergedUpdateLevelOneCategoryList,options);
		
		if(levelOneCategoryList.getToRemoveList() != null){
			levelOneCategoryList.removeAll(levelOneCategoryList.getToRemoveList());
		}
		
		
		return catalog;
	
	}
	
	protected Catalog removeLevelOneCategoryList(Catalog catalog, Map<String,Object> options){
	
	
		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();
		if(levelOneCategoryList == null){
			return catalog;
		}	
	
		SmartList<LevelOneCategory> toRemoveLevelOneCategoryList = levelOneCategoryList.getToRemoveList();
		
		if(toRemoveLevelOneCategoryList == null){
			return catalog;
		}
		if(toRemoveLevelOneCategoryList.isEmpty()){
			return catalog;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelOneCategoryDAO().removeLevelOneCategoryList(toRemoveLevelOneCategoryList,options);
		
		return catalog;
	
	}
	
	

 	
 	
	
	
	
		

	public Catalog present(Catalog catalog,Map<String, Object> options){
	
		presentLevelOneCategoryList(catalog,options);

		return catalog;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Catalog presentLevelOneCategoryList(
			Catalog catalog,
			Map<String, Object> options) {

		SmartList<LevelOneCategory> levelOneCategoryList = catalog.getLevelOneCategoryList();		
				SmartList<LevelOneCategory> newList= presentSubList(catalog.getId(),
				levelOneCategoryList,
				options,
				getLevelOneCategoryDAO()::countLevelOneCategoryByCatalog,
				getLevelOneCategoryDAO()::findLevelOneCategoryByCatalog
				);

		
		catalog.setLevelOneCategoryList(newList);
		

		return catalog;
	}			
		

	
    public SmartList<Catalog> requestCandidateCatalogForLevelOneCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CatalogTable.COLUMN_NAME, CatalogTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getCatalogMapper());
    }
		

	protected String getTableName(){
		return CatalogTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Catalog> catalogList) {		
		this.enhanceListInternal(catalogList, this.getCatalogMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:LevelOneCategory的catalog的LevelOneCategoryList
	public SmartList<LevelOneCategory> loadOurLevelOneCategoryList(RetailscmUserContext userContext, List<Catalog> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelOneCategory.CATALOG_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LevelOneCategory> loadedObjs = userContext.getDAOGroup().getLevelOneCategoryDAO().findLevelOneCategoryWithKey(key, options);
		Map<String, List<LevelOneCategory>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCatalog().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LevelOneCategory> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LevelOneCategory> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLevelOneCategoryList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Catalog> catalogList = ownerEntity.collectRefsWithType(Catalog.INTERNAL_TYPE);
		this.enhanceList(catalogList);
		
	}
	
	@Override
	public SmartList<Catalog> findCatalogWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getCatalogMapper());

	}
	@Override
	public int countCatalogWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countCatalogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Catalog> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCatalogMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateCatalog executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateCatalog result = new CandidateCatalog();
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


