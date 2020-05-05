
package com.doublechaintech.retailscm.storagespace;

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


import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class StorageSpaceJDBCTemplateDAO extends RetailscmBaseDAOImpl implements StorageSpaceDAO{

	protected WarehouseDAO warehouseDAO;
	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
 	
 		if(warehouseDAO == null){
 			throw new IllegalStateException("Do not try to set warehouseDAO to null.");
 		}
	 	this.warehouseDAO = warehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
 		if(this.warehouseDAO == null){
 			throw new IllegalStateException("The warehouseDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.warehouseDAO;
 	}	

	protected GoodsShelfDAO goodsShelfDAO;
	public void setGoodsShelfDAO(GoodsShelfDAO goodsShelfDAO){
 	
 		if(goodsShelfDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfDAO to null.");
 		}
	 	this.goodsShelfDAO = goodsShelfDAO;
 	}
 	public GoodsShelfDAO getGoodsShelfDAO(){
 		if(this.goodsShelfDAO == null){
 			throw new IllegalStateException("The goodsShelfDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsShelfDAO;
 	}	

	
	/*
	protected StorageSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalStorageSpace(accessKey, options);
	}
	*/
	
	public SmartList<StorageSpace> loadAll() {
	    return this.loadAll(getStorageSpaceMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public StorageSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalStorageSpace(StorageSpaceTable.withId(id), options);
	}
	
	
	
	public StorageSpace save(StorageSpace storageSpace,Map<String,Object> options){
		
		String methodName="save(StorageSpace storageSpace,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(storageSpace, methodName, "storageSpace");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalStorageSpace(storageSpace,options);
	}
	public StorageSpace clone(String storageSpaceId, Map<String,Object> options) throws Exception{
	
		return clone(StorageSpaceTable.withId(storageSpaceId),options);
	}
	
	protected StorageSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String storageSpaceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		StorageSpace newStorageSpace = loadInternalStorageSpace(accessKey, options);
		newStorageSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsShelfListEnabled(options)){
 			for(GoodsShelf item: newStorageSpace.getGoodsShelfList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalStorageSpace(newStorageSpace,options);
		
		return newStorageSpace;
	}
	
	
	
	

	protected void throwIfHasException(String storageSpaceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new StorageSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new StorageSpaceNotFoundException(
					"The " + this.getTableName() + "(" + storageSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String storageSpaceId, int version) throws Exception{
	
		String methodName="delete(String storageSpaceId, int version)";
		assertMethodArgumentNotNull(storageSpaceId, methodName, "storageSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{storageSpaceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(storageSpaceId,version);
		}
		
	
	}
	
	
	
	
	

	public StorageSpace disconnectFromAll(String storageSpaceId, int version) throws Exception{
	
		
		StorageSpace storageSpace = loadInternalStorageSpace(StorageSpaceTable.withId(storageSpaceId), emptyOptions());
		storageSpace.clearFromAll();
		this.saveStorageSpace(storageSpace);
		return storageSpace;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return StorageSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "storage_space";
	}
	@Override
	protected String getBeanName() {
		
		return "storageSpace";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return StorageSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, StorageSpaceTokens.WAREHOUSE);
 	}

 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, StorageSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	
	protected boolean isExtractGoodsShelfListEnabled(Map<String,Object> options){		
 		return checkOptions(options,StorageSpaceTokens.GOODS_SHELF_LIST);
 	}
 	protected boolean isAnalyzeGoodsShelfListEnabled(Map<String,Object> options){		 		
 		return StorageSpaceTokens.of(options).analyzeGoodsShelfListEnabled();
 	}
	
	protected boolean isSaveGoodsShelfListEnabled(Map<String,Object> options){
		return checkOptions(options, StorageSpaceTokens.GOODS_SHELF_LIST);
		
 	}
 	
		

	

	protected StorageSpaceMapper getStorageSpaceMapper(){
		return new StorageSpaceMapper();
	}

	
	
	protected StorageSpace extractStorageSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			StorageSpace storageSpace = loadSingleObject(accessKey, getStorageSpaceMapper());
			return storageSpace;
		}catch(EmptyResultDataAccessException e){
			throw new StorageSpaceNotFoundException("StorageSpace("+accessKey+") is not found!");
		}

	}

	
	

	protected StorageSpace loadInternalStorageSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		StorageSpace storageSpace = extractStorageSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(storageSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsShelfListEnabled(loadOptions)){
	 		extractGoodsShelfList(storageSpace, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeGoodsShelfListEnabled(loadOptions)){
	 		analyzeGoodsShelfList(storageSpace, loadOptions);
 		}
 		
		
		return storageSpace;
		
	}

	 

 	protected StorageSpace extractWarehouse(StorageSpace storageSpace, Map<String,Object> options) throws Exception{

		if(storageSpace.getWarehouse() == null){
			return storageSpace;
		}
		String warehouseId = storageSpace.getWarehouse().getId();
		if( warehouseId == null){
			return storageSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			storageSpace.setWarehouse(warehouse);
		}
		
 		
 		return storageSpace;
 	}
 		
 
		
	protected void enhanceGoodsShelfList(SmartList<GoodsShelf> goodsShelfList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected StorageSpace extractGoodsShelfList(StorageSpace storageSpace, Map<String,Object> options){
		
		
		if(storageSpace == null){
			return null;
		}
		if(storageSpace.getId() == null){
			return storageSpace;
		}

		
		
		SmartList<GoodsShelf> goodsShelfList = getGoodsShelfDAO().findGoodsShelfByStorageSpace(storageSpace.getId(),options);
		if(goodsShelfList != null){
			enhanceGoodsShelfList(goodsShelfList,options);
			storageSpace.setGoodsShelfList(goodsShelfList);
		}
		
		return storageSpace;
	
	}	
	
	protected StorageSpace analyzeGoodsShelfList(StorageSpace storageSpace, Map<String,Object> options){
		
		
		if(storageSpace == null){
			return null;
		}
		if(storageSpace.getId() == null){
			return storageSpace;
		}

		
		
		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();
		if(goodsShelfList != null){
			getGoodsShelfDAO().analyzeGoodsShelfByStorageSpace(goodsShelfList, storageSpace.getId(), options);
			
		}
		
		return storageSpace;
	
	}	
	
		
		
  	
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
  		SmartList<StorageSpace> resultList = queryWith(StorageSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getStorageSpaceMapper());
		// analyzeStorageSpaceByWarehouse(resultList, warehouseId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 		
 		SmartList<StorageSpace> resultList =  queryWithRange(StorageSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getStorageSpaceMapper(), start, count);
 		//analyzeStorageSpaceByWarehouse(resultList, warehouseId, options);
 		return resultList;
 		
 	}
 	public void analyzeStorageSpaceByWarehouse(SmartList<StorageSpace> resultList, String warehouseId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(StorageSpace.WAREHOUSE_PROPERTY, warehouseId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//StorageSpace.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("存货区");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(StorageSpace.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(StorageSpace.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countStorageSpaceByWarehouse(String warehouseId,Map<String,Object> options){

 		return countWith(StorageSpaceTable.COLUMN_WAREHOUSE, warehouseId, options);
 	}
 	@Override
	public Map<String, Integer> countStorageSpaceByWarehouseIds(String[] ids, Map<String, Object> options) {
		return countWithIds(StorageSpaceTable.COLUMN_WAREHOUSE, ids, options);
	}
 	
 	
		
		
		

	

	protected StorageSpace saveStorageSpace(StorageSpace  storageSpace){
		
		if(!storageSpace.isChanged()){
			return storageSpace;
		}
		
		
		String SQL=this.getSaveStorageSpaceSQL(storageSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveStorageSpaceParameters(storageSpace);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		storageSpace.incVersion();
		return storageSpace;
	
	}
	public SmartList<StorageSpace> saveStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitStorageSpaceList(storageSpaceList);
		
		batchStorageSpaceCreate((List<StorageSpace>)lists[CREATE_LIST_INDEX]);
		
		batchStorageSpaceUpdate((List<StorageSpace>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(StorageSpace storageSpace:storageSpaceList){
			if(storageSpace.isChanged()){
				storageSpace.incVersion();
			}
			
		
		}
		
		
		return storageSpaceList;
	}

	public SmartList<StorageSpace> removeStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options){
		
		
		super.removeList(storageSpaceList, options);
		
		return storageSpaceList;
		
		
	}
	
	protected List<Object[]> prepareStorageSpaceBatchCreateArgs(List<StorageSpace> storageSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StorageSpace storageSpace:storageSpaceList ){
			Object [] parameters = prepareStorageSpaceCreateParameters(storageSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareStorageSpaceBatchUpdateArgs(List<StorageSpace> storageSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StorageSpace storageSpace:storageSpaceList ){
			if(!storageSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareStorageSpaceUpdateParameters(storageSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchStorageSpaceCreate(List<StorageSpace> storageSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareStorageSpaceBatchCreateArgs(storageSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchStorageSpaceUpdate(List<StorageSpace> storageSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareStorageSpaceBatchUpdateArgs(storageSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitStorageSpaceList(List<StorageSpace> storageSpaceList){
		
		List<StorageSpace> storageSpaceCreateList=new ArrayList<StorageSpace>();
		List<StorageSpace> storageSpaceUpdateList=new ArrayList<StorageSpace>();
		
		for(StorageSpace storageSpace: storageSpaceList){
			if(isUpdateRequest(storageSpace)){
				storageSpaceUpdateList.add( storageSpace);
				continue;
			}
			storageSpaceCreateList.add(storageSpace);
		}
		
		return new Object[]{storageSpaceCreateList,storageSpaceUpdateList};
	}
	
	protected boolean isUpdateRequest(StorageSpace storageSpace){
 		return storageSpace.getVersion() > 0;
 	}
 	protected String getSaveStorageSpaceSQL(StorageSpace storageSpace){
 		if(isUpdateRequest(storageSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveStorageSpaceParameters(StorageSpace storageSpace){
 		if(isUpdateRequest(storageSpace) ){
 			return prepareStorageSpaceUpdateParameters(storageSpace);
 		}
 		return prepareStorageSpaceCreateParameters(storageSpace);
 	}
 	protected Object[] prepareStorageSpaceUpdateParameters(StorageSpace storageSpace){
 		Object[] parameters = new Object[10];
 
 		
 		parameters[0] = storageSpace.getLocation();
 		
 		
 		parameters[1] = storageSpace.getContactNumber();
 		
 		
 		parameters[2] = storageSpace.getTotalArea();
 		 	
 		if(storageSpace.getWarehouse() != null){
 			parameters[3] = storageSpace.getWarehouse().getId();
 		}
 
 		
 		parameters[4] = storageSpace.getLatitude();
 		
 		
 		parameters[5] = storageSpace.getLongitude();
 		
 		
 		parameters[6] = storageSpace.getLastUpdateTime();
 				
 		parameters[7] = storageSpace.nextVersion();
 		parameters[8] = storageSpace.getId();
 		parameters[9] = storageSpace.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareStorageSpaceCreateParameters(StorageSpace storageSpace){
		Object[] parameters = new Object[8];
		String newStorageSpaceId=getNextId();
		storageSpace.setId(newStorageSpaceId);
		parameters[0] =  storageSpace.getId();
 
 		
 		parameters[1] = storageSpace.getLocation();
 		
 		
 		parameters[2] = storageSpace.getContactNumber();
 		
 		
 		parameters[3] = storageSpace.getTotalArea();
 		 	
 		if(storageSpace.getWarehouse() != null){
 			parameters[4] = storageSpace.getWarehouse().getId();
 		
 		}
 		
 		
 		parameters[5] = storageSpace.getLatitude();
 		
 		
 		parameters[6] = storageSpace.getLongitude();
 		
 		
 		parameters[7] = storageSpace.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected StorageSpace saveInternalStorageSpace(StorageSpace storageSpace, Map<String,Object> options){
		
		saveStorageSpace(storageSpace);
 	
 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(storageSpace, options);
 		}
 
		
		if(isSaveGoodsShelfListEnabled(options)){
	 		saveGoodsShelfList(storageSpace, options);
	 		//removeGoodsShelfList(storageSpace, options);
	 		//Not delete the record
	 		
 		}		
		
		return storageSpace;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected StorageSpace saveWarehouse(StorageSpace storageSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(storageSpace.getWarehouse() == null){
 			return storageSpace;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(storageSpace.getWarehouse(),options);
 		return storageSpace;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public StorageSpace planToRemoveGoodsShelfList(StorageSpace storageSpace, String goodsShelfIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpace.getId());
		key.put(GoodsShelf.ID_PROPERTY, goodsShelfIds);
		
		SmartList<GoodsShelf> externalGoodsShelfList = getGoodsShelfDAO().
				findGoodsShelfWithKey(key, options);
		if(externalGoodsShelfList == null){
			return storageSpace;
		}
		if(externalGoodsShelfList.isEmpty()){
			return storageSpace;
		}
		
		for(GoodsShelf goodsShelfItem: externalGoodsShelfList){

			goodsShelfItem.clearFromAll();
		}
		
		
		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();		
		goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
		return storageSpace;	
	
	}


	//disconnect StorageSpace with supplier_space in GoodsShelf
	public StorageSpace planToRemoveGoodsShelfListWithSupplierSpace(StorageSpace storageSpace, String supplierSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpace.getId());
		key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpaceId);
		
		SmartList<GoodsShelf> externalGoodsShelfList = getGoodsShelfDAO().
				findGoodsShelfWithKey(key, options);
		if(externalGoodsShelfList == null){
			return storageSpace;
		}
		if(externalGoodsShelfList.isEmpty()){
			return storageSpace;
		}
		
		for(GoodsShelf goodsShelfItem: externalGoodsShelfList){
			goodsShelfItem.clearSupplierSpace();
			goodsShelfItem.clearStorageSpace();
			
		}
		
		
		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();		
		goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
		return storageSpace;
	}
	
	public int countGoodsShelfListWithSupplierSpace(String storageSpaceId, String supplierSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpaceId);
		key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpaceId);
		
		int count = getGoodsShelfDAO().countGoodsShelfWithKey(key, options);
		return count;
	}
	
	//disconnect StorageSpace with damage_space in GoodsShelf
	public StorageSpace planToRemoveGoodsShelfListWithDamageSpace(StorageSpace storageSpace, String damageSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpace.getId());
		key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpaceId);
		
		SmartList<GoodsShelf> externalGoodsShelfList = getGoodsShelfDAO().
				findGoodsShelfWithKey(key, options);
		if(externalGoodsShelfList == null){
			return storageSpace;
		}
		if(externalGoodsShelfList.isEmpty()){
			return storageSpace;
		}
		
		for(GoodsShelf goodsShelfItem: externalGoodsShelfList){
			goodsShelfItem.clearDamageSpace();
			goodsShelfItem.clearStorageSpace();
			
		}
		
		
		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();		
		goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
		return storageSpace;
	}
	
	public int countGoodsShelfListWithDamageSpace(String storageSpaceId, String damageSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpaceId);
		key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpaceId);
		
		int count = getGoodsShelfDAO().countGoodsShelfWithKey(key, options);
		return count;
	}
	

		
	protected StorageSpace saveGoodsShelfList(StorageSpace storageSpace, Map<String,Object> options){
		
		
		
		
		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			//null list means nothing
			return storageSpace;
		}
		SmartList<GoodsShelf> mergedUpdateGoodsShelfList = new SmartList<GoodsShelf>();
		
		
		mergedUpdateGoodsShelfList.addAll(goodsShelfList); 
		if(goodsShelfList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGoodsShelfList.addAll(goodsShelfList.getToRemoveList());
			goodsShelfList.removeAll(goodsShelfList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getGoodsShelfDAO().saveGoodsShelfList(mergedUpdateGoodsShelfList,options);
		
		if(goodsShelfList.getToRemoveList() != null){
			goodsShelfList.removeAll(goodsShelfList.getToRemoveList());
		}
		
		
		return storageSpace;
	
	}
	
	protected StorageSpace removeGoodsShelfList(StorageSpace storageSpace, Map<String,Object> options){
	
	
		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			return storageSpace;
		}	
	
		SmartList<GoodsShelf> toRemoveGoodsShelfList = goodsShelfList.getToRemoveList();
		
		if(toRemoveGoodsShelfList == null){
			return storageSpace;
		}
		if(toRemoveGoodsShelfList.isEmpty()){
			return storageSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsShelfDAO().removeGoodsShelfList(toRemoveGoodsShelfList,options);
		
		return storageSpace;
	
	}
	
	

 	
 	
	
	
	
		

	public StorageSpace present(StorageSpace storageSpace,Map<String, Object> options){
	
		presentGoodsShelfList(storageSpace,options);

		return storageSpace;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected StorageSpace presentGoodsShelfList(
			StorageSpace storageSpace,
			Map<String, Object> options) {

		SmartList<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();		
				SmartList<GoodsShelf> newList= presentSubList(storageSpace.getId(),
				goodsShelfList,
				options,
				getGoodsShelfDAO()::countGoodsShelfByStorageSpace,
				getGoodsShelfDAO()::findGoodsShelfByStorageSpace
				);

		
		storageSpace.setGoodsShelfList(newList);
		

		return storageSpace;
	}			
		

	
    public SmartList<StorageSpace> requestCandidateStorageSpaceForGoodsShelf(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(StorageSpaceTable.COLUMN_LOCATION, StorageSpaceTable.COLUMN_WAREHOUSE, filterKey, pageNo, pageSize, getStorageSpaceMapper());
    }
		

	protected String getTableName(){
		return StorageSpaceTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<StorageSpace> storageSpaceList) {		
		this.enhanceListInternal(storageSpaceList, this.getStorageSpaceMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:GoodsShelf的storageSpace的GoodsShelfList
	public SmartList<GoodsShelf> loadOurGoodsShelfList(RetailscmUserContext userContext, List<StorageSpace> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<GoodsShelf> loadedObjs = userContext.getDAOGroup().getGoodsShelfDAO().findGoodsShelfWithKey(key, options);
		Map<String, List<GoodsShelf>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getStorageSpace().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<GoodsShelf> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<GoodsShelf> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setGoodsShelfList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<StorageSpace> storageSpaceList = ownerEntity.collectRefsWithType(StorageSpace.INTERNAL_TYPE);
		this.enhanceList(storageSpaceList);
		
	}
	
	@Override
	public SmartList<StorageSpace> findStorageSpaceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getStorageSpaceMapper());

	}
	@Override
	public int countStorageSpaceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countStorageSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<StorageSpace> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getStorageSpaceMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateStorageSpace executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateStorageSpace result = new CandidateStorageSpace();
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


