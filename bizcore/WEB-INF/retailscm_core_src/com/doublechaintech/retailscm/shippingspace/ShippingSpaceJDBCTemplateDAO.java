
package com.doublechaintech.retailscm.shippingspace;

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


import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ShippingSpaceJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ShippingSpaceDAO{

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

	protected GoodsDAO goodsDAO;
	public void setGoodsDAO(GoodsDAO goodsDAO){
 	
 		if(goodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = goodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsDAO;
 	}	


	/*
	protected ShippingSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalShippingSpace(accessKey, options);
	}
	*/

	public SmartList<ShippingSpace> loadAll() {
	    return this.loadAll(getShippingSpaceMapper());
	}

  public Stream<ShippingSpace> loadAllAsStream() {
      return this.loadAllAsStream(getShippingSpaceMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ShippingSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalShippingSpace(ShippingSpaceTable.withId(id), options);
	}

	

	public ShippingSpace save(ShippingSpace shippingSpace,Map<String,Object> options){

		String methodName="save(ShippingSpace shippingSpace,Map<String,Object> options)";

		assertMethodArgumentNotNull(shippingSpace, methodName, "shippingSpace");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalShippingSpace(shippingSpace,options);
	}
	public ShippingSpace clone(String shippingSpaceId, Map<String,Object> options) throws Exception{

		return clone(ShippingSpaceTable.withId(shippingSpaceId),options);
	}

	protected ShippingSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String shippingSpaceId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ShippingSpace newShippingSpace = loadInternalShippingSpace(accessKey, options);
		newShippingSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newShippingSpace.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalShippingSpace(newShippingSpace,options);

		return newShippingSpace;
	}

	



	protected void throwIfHasException(String shippingSpaceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ShippingSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ShippingSpaceNotFoundException(
					"The " + this.getTableName() + "(" + shippingSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String shippingSpaceId, int version) throws Exception{

		String methodName="delete(String shippingSpaceId, int version)";
		assertMethodArgumentNotNull(shippingSpaceId, methodName, "shippingSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{shippingSpaceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(shippingSpaceId,version);
		}


	}






	public ShippingSpace disconnectFromAll(String shippingSpaceId, int version) throws Exception{


		ShippingSpace shippingSpace = loadInternalShippingSpace(ShippingSpaceTable.withId(shippingSpaceId), emptyOptions());
		shippingSpace.clearFromAll();
		this.saveShippingSpace(shippingSpace);
		return shippingSpace;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ShippingSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "shipping_space";
	}
	@Override
	protected String getBeanName() {

		return "shippingSpace";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ShippingSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ShippingSpaceTokens.WAREHOUSE);
 	}

 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ShippingSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ShippingSpaceTokens.GOODS_LIST);
 	}
 	protected boolean isAnalyzeGoodsListEnabled(Map<String,Object> options){		 		
 		return ShippingSpaceTokens.of(options).analyzeGoodsListEnabled();
 	}
	
	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, ShippingSpaceTokens.GOODS_LIST);
		
 	}
 	
		

	

	protected ShippingSpaceMapper getShippingSpaceMapper(){
		return new ShippingSpaceMapper();
	}

	
	
	protected ShippingSpace extractShippingSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ShippingSpace shippingSpace = loadSingleObject(accessKey, getShippingSpaceMapper());
			return shippingSpace;
		}catch(EmptyResultDataAccessException e){
			throw new ShippingSpaceNotFoundException("ShippingSpace("+accessKey+") is not found!");
		}

	}

	
	

	protected ShippingSpace loadInternalShippingSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ShippingSpace shippingSpace = extractShippingSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(shippingSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(shippingSpace, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeGoodsListEnabled(loadOptions)){
	 		analyzeGoodsList(shippingSpace, loadOptions);
 		}
 		
		
		return shippingSpace;
		
	}

	 

 	protected ShippingSpace extractWarehouse(ShippingSpace shippingSpace, Map<String,Object> options) throws Exception{

		if(shippingSpace.getWarehouse() == null){
			return shippingSpace;
		}
		String warehouseId = shippingSpace.getWarehouse().getId();
		if( warehouseId == null){
			return shippingSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			shippingSpace.setWarehouse(warehouse);
		}
		
 		
 		return shippingSpace;
 	}
 		
 
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ShippingSpace extractGoodsList(ShippingSpace shippingSpace, Map<String,Object> options){
		
		
		if(shippingSpace == null){
			return null;
		}
		if(shippingSpace.getId() == null){
			return shippingSpace;
		}

		
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByShippingSpace(shippingSpace.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			shippingSpace.setGoodsList(goodsList);
		}
		
		return shippingSpace;
	
	}	
	
	protected ShippingSpace analyzeGoodsList(ShippingSpace shippingSpace, Map<String,Object> options){
		
		
		if(shippingSpace == null){
			return null;
		}
		if(shippingSpace.getId() == null){
			return shippingSpace;
		}

		
		
		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		if(goodsList != null){
			getGoodsDAO().analyzeGoodsByShippingSpace(goodsList, shippingSpace.getId(), options);
			
		}
		
		return shippingSpace;
	
	}	
	
		
		
  	
 	public SmartList<ShippingSpace> findShippingSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
  		SmartList<ShippingSpace> resultList = queryWith(ShippingSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getShippingSpaceMapper());
		// analyzeShippingSpaceByWarehouse(resultList, warehouseId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ShippingSpace> findShippingSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ShippingSpace> resultList =  queryWithRange(ShippingSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getShippingSpaceMapper(), start, count);
 		//analyzeShippingSpaceByWarehouse(resultList, warehouseId, options);
 		return resultList;
 		
 	}
 	public void analyzeShippingSpaceByWarehouse(SmartList<ShippingSpace> resultList, String warehouseId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ShippingSpace.WAREHOUSE_PROPERTY, warehouseId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ShippingSpace.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("发货区");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ShippingSpace.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ShippingSpace.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countShippingSpaceByWarehouse(String warehouseId,Map<String,Object> options){

 		return countWith(ShippingSpaceTable.COLUMN_WAREHOUSE, warehouseId, options);
 	}
 	@Override
	public Map<String, Integer> countShippingSpaceByWarehouseIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ShippingSpaceTable.COLUMN_WAREHOUSE, ids, options);
	}
 	
 	
		
		
		

	

	protected ShippingSpace saveShippingSpace(ShippingSpace  shippingSpace){
		
		if(!shippingSpace.isChanged()){
			return shippingSpace;
		}
		

		String SQL=this.getSaveShippingSpaceSQL(shippingSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveShippingSpaceParameters(shippingSpace);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		shippingSpace.incVersion();
		return shippingSpace;

	}
	public SmartList<ShippingSpace> saveShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitShippingSpaceList(shippingSpaceList);

		batchShippingSpaceCreate((List<ShippingSpace>)lists[CREATE_LIST_INDEX]);

		batchShippingSpaceUpdate((List<ShippingSpace>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ShippingSpace shippingSpace:shippingSpaceList){
			if(shippingSpace.isChanged()){
				shippingSpace.incVersion();
			}


		}


		return shippingSpaceList;
	}

	public SmartList<ShippingSpace> removeShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options){


		super.removeList(shippingSpaceList, options);

		return shippingSpaceList;


	}

	protected List<Object[]> prepareShippingSpaceBatchCreateArgs(List<ShippingSpace> shippingSpaceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingSpace shippingSpace:shippingSpaceList ){
			Object [] parameters = prepareShippingSpaceCreateParameters(shippingSpace);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareShippingSpaceBatchUpdateArgs(List<ShippingSpace> shippingSpaceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ShippingSpace shippingSpace:shippingSpaceList ){
			if(!shippingSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareShippingSpaceUpdateParameters(shippingSpace);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchShippingSpaceCreate(List<ShippingSpace> shippingSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareShippingSpaceBatchCreateArgs(shippingSpaceList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchShippingSpaceUpdate(List<ShippingSpace> shippingSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareShippingSpaceBatchUpdateArgs(shippingSpaceList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitShippingSpaceList(List<ShippingSpace> shippingSpaceList){

		List<ShippingSpace> shippingSpaceCreateList=new ArrayList<ShippingSpace>();
		List<ShippingSpace> shippingSpaceUpdateList=new ArrayList<ShippingSpace>();

		for(ShippingSpace shippingSpace: shippingSpaceList){
			if(isUpdateRequest(shippingSpace)){
				shippingSpaceUpdateList.add( shippingSpace);
				continue;
			}
			shippingSpaceCreateList.add(shippingSpace);
		}

		return new Object[]{shippingSpaceCreateList,shippingSpaceUpdateList};
	}

	protected boolean isUpdateRequest(ShippingSpace shippingSpace){
 		return shippingSpace.getVersion() > 0;
 	}
 	protected String getSaveShippingSpaceSQL(ShippingSpace shippingSpace){
 		if(isUpdateRequest(shippingSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveShippingSpaceParameters(ShippingSpace shippingSpace){
 		if(isUpdateRequest(shippingSpace) ){
 			return prepareShippingSpaceUpdateParameters(shippingSpace);
 		}
 		return prepareShippingSpaceCreateParameters(shippingSpace);
 	}
 	protected Object[] prepareShippingSpaceUpdateParameters(ShippingSpace shippingSpace){
 		Object[] parameters = new Object[11];
 
 		
 		parameters[0] = shippingSpace.getLocation();
 		
 		
 		parameters[1] = shippingSpace.getContactNumber();
 		
 		
 		parameters[2] = shippingSpace.getTotalArea();
 		
 		if(shippingSpace.getWarehouse() != null){
 			parameters[3] = shippingSpace.getWarehouse().getId();
 		}
 
 		
 		parameters[4] = shippingSpace.getLatitude();
 		
 		
 		parameters[5] = shippingSpace.getLongitude();
 		
 		
 		parameters[6] = shippingSpace.getDescription();
 		
 		
 		parameters[7] = shippingSpace.getLastUpdateTime();
 		
 		parameters[8] = shippingSpace.nextVersion();
 		parameters[9] = shippingSpace.getId();
 		parameters[10] = shippingSpace.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareShippingSpaceCreateParameters(ShippingSpace shippingSpace){
		Object[] parameters = new Object[9];
        if(shippingSpace.getId() == null){
          String newShippingSpaceId=getNextId();
          shippingSpace.setId(newShippingSpaceId);
        }
		parameters[0] =  shippingSpace.getId();
 
 		
 		parameters[1] = shippingSpace.getLocation();
 		
 		
 		parameters[2] = shippingSpace.getContactNumber();
 		
 		
 		parameters[3] = shippingSpace.getTotalArea();
 		
 		if(shippingSpace.getWarehouse() != null){
 			parameters[4] = shippingSpace.getWarehouse().getId();

 		}
 		
 		
 		parameters[5] = shippingSpace.getLatitude();
 		
 		
 		parameters[6] = shippingSpace.getLongitude();
 		
 		
 		parameters[7] = shippingSpace.getDescription();
 		
 		
 		parameters[8] = shippingSpace.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected ShippingSpace saveInternalShippingSpace(ShippingSpace shippingSpace, Map<String,Object> options){

		saveShippingSpace(shippingSpace);

 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(shippingSpace, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(shippingSpace, options);
	 		//removeGoodsList(shippingSpace, options);
	 		//Not delete the record

 		}
		
		return shippingSpace;

	}



	//======================================================================================
	

 	protected ShippingSpace saveWarehouse(ShippingSpace shippingSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(shippingSpace.getWarehouse() == null){
 			return shippingSpace;//do nothing when it is null
 		}

 		getWarehouseDAO().save(shippingSpace.getWarehouse(),options);
 		return shippingSpace;

 	}





 

	
	public ShippingSpace planToRemoveGoodsList(ShippingSpace shippingSpace, String goodsIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){

			goodsItem.clearFromAll();
		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;

	}


	//disconnect ShippingSpace with sku in Goods
	public ShippingSpace planToRemoveGoodsListWithSku(ShippingSpace shippingSpace, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.SKU_PROPERTY, skuId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSku();
			goodsItem.clearShippingSpace();

		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;
	}

	public int countGoodsListWithSku(String shippingSpaceId, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		key.put(Goods.SKU_PROPERTY, skuId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ShippingSpace with receiving_space in Goods
	public ShippingSpace planToRemoveGoodsListWithReceivingSpace(ShippingSpace shippingSpace, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearReceivingSpace();
			goodsItem.clearShippingSpace();

		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;
	}

	public int countGoodsListWithReceivingSpace(String shippingSpaceId, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ShippingSpace with goods_allocation in Goods
	public ShippingSpace planToRemoveGoodsListWithGoodsAllocation(ShippingSpace shippingSpace, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearGoodsAllocation();
			goodsItem.clearShippingSpace();

		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;
	}

	public int countGoodsListWithGoodsAllocation(String shippingSpaceId, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ShippingSpace with smart_pallet in Goods
	public ShippingSpace planToRemoveGoodsListWithSmartPallet(ShippingSpace shippingSpace, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSmartPallet();
			goodsItem.clearShippingSpace();

		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;
	}

	public int countGoodsListWithSmartPallet(String shippingSpaceId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ShippingSpace with transport_task in Goods
	public ShippingSpace planToRemoveGoodsListWithTransportTask(ShippingSpace shippingSpace, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearTransportTask();
			goodsItem.clearShippingSpace();

		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;
	}

	public int countGoodsListWithTransportTask(String shippingSpaceId, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ShippingSpace with retail_store in Goods
	public ShippingSpace planToRemoveGoodsListWithRetailStore(ShippingSpace shippingSpace, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStore();
			goodsItem.clearShippingSpace();

		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;
	}

	public int countGoodsListWithRetailStore(String shippingSpaceId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ShippingSpace with biz_order in Goods
	public ShippingSpace planToRemoveGoodsListWithBizOrder(ShippingSpace shippingSpace, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearBizOrder();
			goodsItem.clearShippingSpace();

		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;
	}

	public int countGoodsListWithBizOrder(String shippingSpaceId, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ShippingSpace with retail_store_order in Goods
	public ShippingSpace planToRemoveGoodsListWithRetailStoreOrder(ShippingSpace shippingSpace, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpace.getId());
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return shippingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return shippingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStoreOrder();
			goodsItem.clearShippingSpace();

		}


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return shippingSpace;
	}

	public int countGoodsListWithRetailStoreOrder(String shippingSpaceId, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	

		
	protected ShippingSpace saveGoodsList(ShippingSpace shippingSpace, Map<String,Object> options){




		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return shippingSpace;
		}
		SmartList<Goods> mergedUpdateGoodsList = new SmartList<Goods>();


		mergedUpdateGoodsList.addAll(goodsList);
		if(goodsList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGoodsList.addAll(goodsList.getToRemoveList());
			goodsList.removeAll(goodsList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getGoodsDAO().saveGoodsList(mergedUpdateGoodsList,options);

		if(goodsList.getToRemoveList() != null){
			goodsList.removeAll(goodsList.getToRemoveList());
		}


		return shippingSpace;

	}

	protected ShippingSpace removeGoodsList(ShippingSpace shippingSpace, Map<String,Object> options){


		SmartList<Goods> goodsList = shippingSpace.getGoodsList();
		if(goodsList == null){
			return shippingSpace;
		}

		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();

		if(toRemoveGoodsList == null){
			return shippingSpace;
		}
		if(toRemoveGoodsList.isEmpty()){
			return shippingSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);

		return shippingSpace;

	}








		

	public ShippingSpace present(ShippingSpace shippingSpace,Map<String, Object> options){
	
		presentGoodsList(shippingSpace,options);

		return shippingSpace;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ShippingSpace presentGoodsList(
			ShippingSpace shippingSpace,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = shippingSpace.getGoodsList();		
				SmartList<Goods> newList= presentSubList(shippingSpace.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsByShippingSpace,
				getGoodsDAO()::findGoodsByShippingSpace
				);

		
		shippingSpace.setGoodsList(newList);
		

		return shippingSpace;
	}			
		

	
    public SmartList<ShippingSpace> requestCandidateShippingSpaceForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ShippingSpaceTable.COLUMN_LOCATION, ShippingSpaceTable.COLUMN_WAREHOUSE, filterKey, pageNo, pageSize, getShippingSpaceMapper());
    }
		

	protected String getTableName(){
		return ShippingSpaceTable.TABLE_NAME;
	}



	public void enhanceList(List<ShippingSpace> shippingSpaceList) {
		this.enhanceListInternal(shippingSpaceList, this.getShippingSpaceMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Goods的shippingSpace的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<ShippingSpace> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SHIPPING_SPACE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Goods> loadedObjs = userContext.getDAOGroup().getGoodsDAO().findGoodsWithKey(key, options);
		Map<String, List<Goods>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getShippingSpace().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Goods> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Goods> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setGoodsList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ShippingSpace> shippingSpaceList = ownerEntity.collectRefsWithType(ShippingSpace.INTERNAL_TYPE);
		this.enhanceList(shippingSpaceList);

	}

	@Override
	public SmartList<ShippingSpace> findShippingSpaceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getShippingSpaceMapper());

	}
	@Override
	public int countShippingSpaceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countShippingSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ShippingSpace> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getShippingSpaceMapper());
	}

  @Override
  public Stream<ShippingSpace> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getShippingSpaceMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateShippingSpace executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateShippingSpace result = new CandidateShippingSpace();
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


