
package com.doublechaintech.retailscm.supplierspace;

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


import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class SupplierSpaceJDBCTemplateDAO extends RetailscmNamingServiceDAO implements SupplierSpaceDAO{
 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}


			
		
	
  	private  GoodsShelfDAO  goodsShelfDAO;
 	public void setGoodsShelfDAO(GoodsShelfDAO pGoodsShelfDAO){
 	
 		if(pGoodsShelfDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfDAO to null.");
 		}
	 	this.goodsShelfDAO = pGoodsShelfDAO;
 	}
 	public GoodsShelfDAO getGoodsShelfDAO(){
 		if(this.goodsShelfDAO == null){
 			throw new IllegalStateException("The goodsShelfDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsShelfDAO;
 	}	
 	
			
		

	
	/*
	protected SupplierSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplierSpace(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplierSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplierSpace(SupplierSpaceTable.withId(id), options);
	}
	
	
	
	public SupplierSpace save(SupplierSpace supplierSpace,Map<String,Object> options){
		
		String methodName="save(SupplierSpace supplierSpace,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplierSpace, methodName, "supplierSpace");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplierSpace(supplierSpace,options);
	}
	public SupplierSpace clone(String supplierSpaceId, Map<String,Object> options) throws Exception{
	
		return clone(SupplierSpaceTable.withId(supplierSpaceId),options);
	}
	
	protected SupplierSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplierSpaceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplierSpace newSupplierSpace = loadInternalSupplierSpace(accessKey, options);
		newSupplierSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsShelfListEnabled(options)){
 			for(GoodsShelf item: newSupplierSpace.getGoodsShelfList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplierSpace(newSupplierSpace,options);
		
		return newSupplierSpace;
	}
	
	
	
	

	protected void throwIfHasException(String supplierSpaceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplierSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplierSpaceNotFoundException(
					"The " + this.getTableName() + "(" + supplierSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplierSpaceId, int version) throws Exception{
	
		String methodName="delete(String supplierSpaceId, int version)";
		assertMethodArgumentNotNull(supplierSpaceId, methodName, "supplierSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplierSpaceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplierSpaceId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplierSpace disconnectFromAll(String supplierSpaceId, int version) throws Exception{
	
		
		SupplierSpace supplierSpace = loadInternalSupplierSpace(SupplierSpaceTable.withId(supplierSpaceId), emptyOptions());
		supplierSpace.clearFromAll();
		this.saveSupplierSpace(supplierSpace);
		return supplierSpace;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplierSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supplier_space";
	}
	@Override
	protected String getBeanName() {
		
		return "supplierSpace";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplierSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplierSpaceTokens.WAREHOUSE);
 	}

 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplierSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	
	protected boolean isExtractGoodsShelfListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplierSpaceTokens.GOODS_SHELF_LIST);
		
 	}

	protected boolean isSaveGoodsShelfListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplierSpaceTokens.GOODS_SHELF_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplierSpaceMapper getSupplierSpaceMapper(){
		return new SupplierSpaceMapper();
	}

	
	
	protected SupplierSpace extractSupplierSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplierSpace supplierSpace = loadSingleObject(accessKey, getSupplierSpaceMapper());
			return supplierSpace;
		}catch(EmptyResultDataAccessException e){
			throw new SupplierSpaceNotFoundException("SupplierSpace("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplierSpace loadInternalSupplierSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplierSpace supplierSpace = extractSupplierSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(supplierSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsShelfListEnabled(loadOptions)){
	 		extractGoodsShelfList(supplierSpace, loadOptions);
 		}		
		
		return supplierSpace;
		
	}



	
	
	 

 	protected SupplierSpace extractWarehouse(SupplierSpace supplierSpace, Map<String,Object> options) throws Exception{

		if(supplierSpace.getWarehouse() == null){
			return supplierSpace;
		}
		String warehouseId = supplierSpace.getWarehouse().getId();
		if( warehouseId == null){
			return supplierSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			supplierSpace.setWarehouse(warehouse);
		}
		
 		
 		return supplierSpace;
 	}
 		
 
		
	protected void enhanceGoodsShelfList(SmartList<GoodsShelf> goodsShelfList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected SupplierSpace extractGoodsShelfList(SupplierSpace supplierSpace, Map<String,Object> options){
		
		
		if(supplierSpace == null){
			return null;
		}
		if(supplierSpace.getId() == null){
			return supplierSpace;
		}

		
		
		SmartList<GoodsShelf> goodsShelfList = getGoodsShelfDAO().findGoodsShelfBySupplierSpace(supplierSpace.getId(),options);
		if(goodsShelfList != null){
			enhanceGoodsShelfList(goodsShelfList,options);
			supplierSpace.setGoodsShelfList(goodsShelfList);
		}
		
		return supplierSpace;
	
	}	
		
		
  	
 	public SmartList<SupplierSpace> findSupplierSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
  		SmartList<SupplierSpace> resultList = queryWith(SupplierSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getSupplierSpaceMapper());
		analyzeSupplierSpaceByWarehouse(resultList, warehouseId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplierSpace> findSupplierSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplierSpace> resultList =  queryWithRange(SupplierSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getSupplierSpaceMapper(), start, count);
 		analyzeSupplierSpaceByWarehouse(resultList, warehouseId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplierSpaceByWarehouse(SmartList<SupplierSpace> resultList, String warehouseId, Map<String,Object> options){
	

 	
 		
 	}
 	@Override
 	public int countSupplierSpaceByWarehouse(String warehouseId,Map<String,Object> options){

 		return countWith(SupplierSpaceTable.COLUMN_WAREHOUSE, warehouseId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplierSpaceByWarehouseIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplierSpaceTable.COLUMN_WAREHOUSE, ids, options);
	}
 	
 	
		
		
		

	

	protected SupplierSpace saveSupplierSpace(SupplierSpace  supplierSpace){
		
		if(!supplierSpace.isChanged()){
			return supplierSpace;
		}
		
		
		String SQL=this.getSaveSupplierSpaceSQL(supplierSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplierSpaceParameters(supplierSpace);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplierSpace.incVersion();
		return supplierSpace;
	
	}
	public SmartList<SupplierSpace> saveSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplierSpaceList(supplierSpaceList);
		
		batchSupplierSpaceCreate((List<SupplierSpace>)lists[CREATE_LIST_INDEX]);
		
		batchSupplierSpaceUpdate((List<SupplierSpace>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplierSpace supplierSpace:supplierSpaceList){
			if(supplierSpace.isChanged()){
				supplierSpace.incVersion();
			}
			
		
		}
		
		
		return supplierSpaceList;
	}

	public SmartList<SupplierSpace> removeSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options){
		
		
		super.removeList(supplierSpaceList, options);
		
		return supplierSpaceList;
		
		
	}
	
	protected List<Object[]> prepareSupplierSpaceBatchCreateArgs(List<SupplierSpace> supplierSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplierSpace supplierSpace:supplierSpaceList ){
			Object [] parameters = prepareSupplierSpaceCreateParameters(supplierSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplierSpaceBatchUpdateArgs(List<SupplierSpace> supplierSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplierSpace supplierSpace:supplierSpaceList ){
			if(!supplierSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplierSpaceUpdateParameters(supplierSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplierSpaceCreate(List<SupplierSpace> supplierSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplierSpaceBatchCreateArgs(supplierSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplierSpaceUpdate(List<SupplierSpace> supplierSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplierSpaceBatchUpdateArgs(supplierSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplierSpaceList(List<SupplierSpace> supplierSpaceList){
		
		List<SupplierSpace> supplierSpaceCreateList=new ArrayList<SupplierSpace>();
		List<SupplierSpace> supplierSpaceUpdateList=new ArrayList<SupplierSpace>();
		
		for(SupplierSpace supplierSpace: supplierSpaceList){
			if(isUpdateRequest(supplierSpace)){
				supplierSpaceUpdateList.add( supplierSpace);
				continue;
			}
			supplierSpaceCreateList.add(supplierSpace);
		}
		
		return new Object[]{supplierSpaceCreateList,supplierSpaceUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplierSpace supplierSpace){
 		return supplierSpace.getVersion() > 0;
 	}
 	protected String getSaveSupplierSpaceSQL(SupplierSpace supplierSpace){
 		if(isUpdateRequest(supplierSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplierSpaceParameters(SupplierSpace supplierSpace){
 		if(isUpdateRequest(supplierSpace) ){
 			return prepareSupplierSpaceUpdateParameters(supplierSpace);
 		}
 		return prepareSupplierSpaceCreateParameters(supplierSpace);
 	}
 	protected Object[] prepareSupplierSpaceUpdateParameters(SupplierSpace supplierSpace){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = supplierSpace.getLocation();
 		parameters[1] = supplierSpace.getContactNumber();
 		parameters[2] = supplierSpace.getTotalArea(); 	
 		if(supplierSpace.getWarehouse() != null){
 			parameters[3] = supplierSpace.getWarehouse().getId();
 		}
 
 		parameters[4] = supplierSpace.getLatitude();
 		parameters[5] = supplierSpace.getLongitude();		
 		parameters[6] = supplierSpace.nextVersion();
 		parameters[7] = supplierSpace.getId();
 		parameters[8] = supplierSpace.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplierSpaceCreateParameters(SupplierSpace supplierSpace){
		Object[] parameters = new Object[7];
		String newSupplierSpaceId=getNextId();
		supplierSpace.setId(newSupplierSpaceId);
		parameters[0] =  supplierSpace.getId();
 
 		parameters[1] = supplierSpace.getLocation();
 		parameters[2] = supplierSpace.getContactNumber();
 		parameters[3] = supplierSpace.getTotalArea(); 	
 		if(supplierSpace.getWarehouse() != null){
 			parameters[4] = supplierSpace.getWarehouse().getId();
 		
 		}
 		
 		parameters[5] = supplierSpace.getLatitude();
 		parameters[6] = supplierSpace.getLongitude();		
 				
 		return parameters;
 	}
 	
	protected SupplierSpace saveInternalSupplierSpace(SupplierSpace supplierSpace, Map<String,Object> options){
		
		saveSupplierSpace(supplierSpace);
 	
 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(supplierSpace, options);
 		}
 
		
		if(isSaveGoodsShelfListEnabled(options)){
	 		saveGoodsShelfList(supplierSpace, options);
	 		//removeGoodsShelfList(supplierSpace, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplierSpace;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplierSpace saveWarehouse(SupplierSpace supplierSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplierSpace.getWarehouse() == null){
 			return supplierSpace;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(supplierSpace.getWarehouse(),options);
 		return supplierSpace;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public SupplierSpace planToRemoveGoodsShelfList(SupplierSpace supplierSpace, String goodsShelfIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpace.getId());
		key.put(GoodsShelf.ID_PROPERTY, goodsShelfIds);
		
		SmartList<GoodsShelf> externalGoodsShelfList = getGoodsShelfDAO().
				findGoodsShelfWithKey(key, options);
		if(externalGoodsShelfList == null){
			return supplierSpace;
		}
		if(externalGoodsShelfList.isEmpty()){
			return supplierSpace;
		}
		
		for(GoodsShelf goodsShelf: externalGoodsShelfList){

			goodsShelf.clearFromAll();
		}
		
		
		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();		
		goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
		return supplierSpace;	
	
	}


	//disconnect SupplierSpace with storage_space in GoodsShelf
	public SupplierSpace planToRemoveGoodsShelfListWithStorageSpace(SupplierSpace supplierSpace, String storageSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpace.getId());
		key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpaceId);
		
		SmartList<GoodsShelf> externalGoodsShelfList = getGoodsShelfDAO().
				findGoodsShelfWithKey(key, options);
		if(externalGoodsShelfList == null){
			return supplierSpace;
		}
		if(externalGoodsShelfList.isEmpty()){
			return supplierSpace;
		}
		
		for(GoodsShelf goodsShelf: externalGoodsShelfList){
			goodsShelf.clearStorageSpace();
			goodsShelf.clearSupplierSpace();
			
		}
		
		
		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();		
		goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
		return supplierSpace;
	}
	
	public int countGoodsShelfListWithStorageSpace(String supplierSpaceId, String storageSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpaceId);
		key.put(GoodsShelf.STORAGE_SPACE_PROPERTY, storageSpaceId);
		
		int count = getGoodsShelfDAO().countGoodsShelfWithKey(key, options);
		return count;
	}
	
	//disconnect SupplierSpace with damage_space in GoodsShelf
	public SupplierSpace planToRemoveGoodsShelfListWithDamageSpace(SupplierSpace supplierSpace, String damageSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpace.getId());
		key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpaceId);
		
		SmartList<GoodsShelf> externalGoodsShelfList = getGoodsShelfDAO().
				findGoodsShelfWithKey(key, options);
		if(externalGoodsShelfList == null){
			return supplierSpace;
		}
		if(externalGoodsShelfList.isEmpty()){
			return supplierSpace;
		}
		
		for(GoodsShelf goodsShelf: externalGoodsShelfList){
			goodsShelf.clearDamageSpace();
			goodsShelf.clearSupplierSpace();
			
		}
		
		
		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();		
		goodsShelfList.addAllToRemoveList(externalGoodsShelfList);
		return supplierSpace;
	}
	
	public int countGoodsShelfListWithDamageSpace(String supplierSpaceId, String damageSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsShelf.SUPPLIER_SPACE_PROPERTY, supplierSpaceId);
		key.put(GoodsShelf.DAMAGE_SPACE_PROPERTY, damageSpaceId);
		
		int count = getGoodsShelfDAO().countGoodsShelfWithKey(key, options);
		return count;
	}
	

		
	protected SupplierSpace saveGoodsShelfList(SupplierSpace supplierSpace, Map<String,Object> options){
		
		
		
		
		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			//null list means nothing
			return supplierSpace;
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
		
		
		return supplierSpace;
	
	}
	
	protected SupplierSpace removeGoodsShelfList(SupplierSpace supplierSpace, Map<String,Object> options){
	
	
		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			return supplierSpace;
		}	
	
		SmartList<GoodsShelf> toRemoveGoodsShelfList = goodsShelfList.getToRemoveList();
		
		if(toRemoveGoodsShelfList == null){
			return supplierSpace;
		}
		if(toRemoveGoodsShelfList.isEmpty()){
			return supplierSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsShelfDAO().removeGoodsShelfList(toRemoveGoodsShelfList,options);
		
		return supplierSpace;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplierSpace present(SupplierSpace supplierSpace,Map<String, Object> options){
	
		presentGoodsShelfList(supplierSpace,options);

		return supplierSpace;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplierSpace presentGoodsShelfList(
			SupplierSpace supplierSpace,
			Map<String, Object> options) {

		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();		
				SmartList<GoodsShelf> newList= presentSubList(supplierSpace.getId(),
				goodsShelfList,
				options,
				getGoodsShelfDAO()::countGoodsShelfBySupplierSpace,
				getGoodsShelfDAO()::findGoodsShelfBySupplierSpace
				);

		
		supplierSpace.setGoodsShelfList(newList);
		

		return supplierSpace;
	}			
		

	
    public SmartList<SupplierSpace> requestCandidateSupplierSpaceForGoodsShelf(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplierSpaceTable.COLUMN_LOCATION, filterKey, pageNo, pageSize, getSupplierSpaceMapper());
    }
		

	protected String getTableName(){
		return SupplierSpaceTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplierSpace> supplierSpaceList) {		
		this.enhanceListInternal(supplierSpaceList, this.getSupplierSpaceMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplierSpace> supplierSpaceList = ownerEntity.collectRefsWithType(SupplierSpace.INTERNAL_TYPE);
		this.enhanceList(supplierSpaceList);
		
	}
	
	@Override
	public SmartList<SupplierSpace> findSupplierSpaceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplierSpaceMapper());

	}
	@Override
	public int countSupplierSpaceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplierSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplierSpace> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplierSpaceMapper());
	}
}


