
package com.doublechaintech.retailscm.receivingspace;

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

public class ReceivingSpaceJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ReceivingSpaceDAO{

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
	protected ReceivingSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalReceivingSpace(accessKey, options);
	}
	*/

	public SmartList<ReceivingSpace> loadAll() {
	    return this.loadAll(getReceivingSpaceMapper());
	}

  public Stream<ReceivingSpace> loadAllAsStream() {
      return this.loadAllAsStream(getReceivingSpaceMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ReceivingSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalReceivingSpace(ReceivingSpaceTable.withId(id), options);
	}

	

	public ReceivingSpace save(ReceivingSpace receivingSpace,Map<String,Object> options){

		String methodName="save(ReceivingSpace receivingSpace,Map<String,Object> options)";

		assertMethodArgumentNotNull(receivingSpace, methodName, "receivingSpace");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalReceivingSpace(receivingSpace,options);
	}
	public ReceivingSpace clone(String receivingSpaceId, Map<String,Object> options) throws Exception{

		return clone(ReceivingSpaceTable.withId(receivingSpaceId),options);
	}

	protected ReceivingSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String receivingSpaceId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ReceivingSpace newReceivingSpace = loadInternalReceivingSpace(accessKey, options);
		newReceivingSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newReceivingSpace.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalReceivingSpace(newReceivingSpace,options);

		return newReceivingSpace;
	}

	



	protected void throwIfHasException(String receivingSpaceId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ReceivingSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ReceivingSpaceNotFoundException(
					"The " + this.getTableName() + "(" + receivingSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String receivingSpaceId, int version) throws Exception{

		String methodName="delete(String receivingSpaceId, int version)";
		assertMethodArgumentNotNull(receivingSpaceId, methodName, "receivingSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{receivingSpaceId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(receivingSpaceId,version);
		}


	}






	public ReceivingSpace disconnectFromAll(String receivingSpaceId, int version) throws Exception{


		ReceivingSpace receivingSpace = loadInternalReceivingSpace(ReceivingSpaceTable.withId(receivingSpaceId), emptyOptions());
		receivingSpace.clearFromAll();
		this.saveReceivingSpace(receivingSpace);
		return receivingSpace;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ReceivingSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "receiving_space";
	}
	@Override
	protected String getBeanName() {

		return "receivingSpace";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ReceivingSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ReceivingSpaceTokens.WAREHOUSE);
 	}

 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ReceivingSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ReceivingSpaceTokens.GOODS_LIST);
 	}
 	protected boolean isAnalyzeGoodsListEnabled(Map<String,Object> options){		 		
 		return ReceivingSpaceTokens.of(options).analyzeGoodsListEnabled();
 	}
	
	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, ReceivingSpaceTokens.GOODS_LIST);
		
 	}
 	
		

	

	protected ReceivingSpaceMapper getReceivingSpaceMapper(){
		return new ReceivingSpaceMapper();
	}

	
	
	protected ReceivingSpace extractReceivingSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ReceivingSpace receivingSpace = loadSingleObject(accessKey, getReceivingSpaceMapper());
			return receivingSpace;
		}catch(EmptyResultDataAccessException e){
			throw new ReceivingSpaceNotFoundException("ReceivingSpace("+accessKey+") is not found!");
		}

	}

	
	

	protected ReceivingSpace loadInternalReceivingSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ReceivingSpace receivingSpace = extractReceivingSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(receivingSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(receivingSpace, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeGoodsListEnabled(loadOptions)){
	 		analyzeGoodsList(receivingSpace, loadOptions);
 		}
 		
		
		return receivingSpace;
		
	}

	 

 	protected ReceivingSpace extractWarehouse(ReceivingSpace receivingSpace, Map<String,Object> options) throws Exception{

		if(receivingSpace.getWarehouse() == null){
			return receivingSpace;
		}
		String warehouseId = receivingSpace.getWarehouse().getId();
		if( warehouseId == null){
			return receivingSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			receivingSpace.setWarehouse(warehouse);
		}
		
 		
 		return receivingSpace;
 	}
 		
 
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ReceivingSpace extractGoodsList(ReceivingSpace receivingSpace, Map<String,Object> options){
		
		
		if(receivingSpace == null){
			return null;
		}
		if(receivingSpace.getId() == null){
			return receivingSpace;
		}

		
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByReceivingSpace(receivingSpace.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			receivingSpace.setGoodsList(goodsList);
		}
		
		return receivingSpace;
	
	}	
	
	protected ReceivingSpace analyzeGoodsList(ReceivingSpace receivingSpace, Map<String,Object> options){
		
		
		if(receivingSpace == null){
			return null;
		}
		if(receivingSpace.getId() == null){
			return receivingSpace;
		}

		
		
		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		if(goodsList != null){
			getGoodsDAO().analyzeGoodsByReceivingSpace(goodsList, receivingSpace.getId(), options);
			
		}
		
		return receivingSpace;
	
	}	
	
		
		
  	
 	public SmartList<ReceivingSpace> findReceivingSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
  		SmartList<ReceivingSpace> resultList = queryWith(ReceivingSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getReceivingSpaceMapper());
		// analyzeReceivingSpaceByWarehouse(resultList, warehouseId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ReceivingSpace> findReceivingSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ReceivingSpace> resultList =  queryWithRange(ReceivingSpaceTable.COLUMN_WAREHOUSE, warehouseId, options, getReceivingSpaceMapper(), start, count);
 		//analyzeReceivingSpaceByWarehouse(resultList, warehouseId, options);
 		return resultList;
 		
 	}
 	public void analyzeReceivingSpaceByWarehouse(SmartList<ReceivingSpace> resultList, String warehouseId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ReceivingSpace.WAREHOUSE_PROPERTY, warehouseId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//ReceivingSpace.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("收货区");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countReceivingSpaceByWarehouse(String warehouseId,Map<String,Object> options){

 		return countWith(ReceivingSpaceTable.COLUMN_WAREHOUSE, warehouseId, options);
 	}
 	@Override
	public Map<String, Integer> countReceivingSpaceByWarehouseIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ReceivingSpaceTable.COLUMN_WAREHOUSE, ids, options);
	}
 	
 	
		
		
		

	

	protected ReceivingSpace saveReceivingSpace(ReceivingSpace  receivingSpace){
		
		if(!receivingSpace.isChanged()){
			return receivingSpace;
		}
		

		String SQL=this.getSaveReceivingSpaceSQL(receivingSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveReceivingSpaceParameters(receivingSpace);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		receivingSpace.incVersion();
		return receivingSpace;

	}
	public SmartList<ReceivingSpace> saveReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitReceivingSpaceList(receivingSpaceList);

		batchReceivingSpaceCreate((List<ReceivingSpace>)lists[CREATE_LIST_INDEX]);

		batchReceivingSpaceUpdate((List<ReceivingSpace>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ReceivingSpace receivingSpace:receivingSpaceList){
			if(receivingSpace.isChanged()){
				receivingSpace.incVersion();
			}


		}


		return receivingSpaceList;
	}

	public SmartList<ReceivingSpace> removeReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options){


		super.removeList(receivingSpaceList, options);

		return receivingSpaceList;


	}

	protected List<Object[]> prepareReceivingSpaceBatchCreateArgs(List<ReceivingSpace> receivingSpaceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ReceivingSpace receivingSpace:receivingSpaceList ){
			Object [] parameters = prepareReceivingSpaceCreateParameters(receivingSpace);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareReceivingSpaceBatchUpdateArgs(List<ReceivingSpace> receivingSpaceList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ReceivingSpace receivingSpace:receivingSpaceList ){
			if(!receivingSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareReceivingSpaceUpdateParameters(receivingSpace);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchReceivingSpaceCreate(List<ReceivingSpace> receivingSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareReceivingSpaceBatchCreateArgs(receivingSpaceList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchReceivingSpaceUpdate(List<ReceivingSpace> receivingSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareReceivingSpaceBatchUpdateArgs(receivingSpaceList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitReceivingSpaceList(List<ReceivingSpace> receivingSpaceList){

		List<ReceivingSpace> receivingSpaceCreateList=new ArrayList<ReceivingSpace>();
		List<ReceivingSpace> receivingSpaceUpdateList=new ArrayList<ReceivingSpace>();

		for(ReceivingSpace receivingSpace: receivingSpaceList){
			if(isUpdateRequest(receivingSpace)){
				receivingSpaceUpdateList.add( receivingSpace);
				continue;
			}
			receivingSpaceCreateList.add(receivingSpace);
		}

		return new Object[]{receivingSpaceCreateList,receivingSpaceUpdateList};
	}

	protected boolean isUpdateRequest(ReceivingSpace receivingSpace){
 		return receivingSpace.getVersion() > 0;
 	}
 	protected String getSaveReceivingSpaceSQL(ReceivingSpace receivingSpace){
 		if(isUpdateRequest(receivingSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveReceivingSpaceParameters(ReceivingSpace receivingSpace){
 		if(isUpdateRequest(receivingSpace) ){
 			return prepareReceivingSpaceUpdateParameters(receivingSpace);
 		}
 		return prepareReceivingSpaceCreateParameters(receivingSpace);
 	}
 	protected Object[] prepareReceivingSpaceUpdateParameters(ReceivingSpace receivingSpace){
 		Object[] parameters = new Object[11];
 
 		
 		parameters[0] = receivingSpace.getLocation();
 		
 		
 		parameters[1] = receivingSpace.getContactNumber();
 		
 		
 		parameters[2] = receivingSpace.getDescription();
 		
 		
 		parameters[3] = receivingSpace.getTotalArea();
 		
 		if(receivingSpace.getWarehouse() != null){
 			parameters[4] = receivingSpace.getWarehouse().getId();
 		}
 
 		
 		parameters[5] = receivingSpace.getLatitude();
 		
 		
 		parameters[6] = receivingSpace.getLongitude();
 		
 		
 		parameters[7] = receivingSpace.getLastUpdateTime();
 		
 		parameters[8] = receivingSpace.nextVersion();
 		parameters[9] = receivingSpace.getId();
 		parameters[10] = receivingSpace.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareReceivingSpaceCreateParameters(ReceivingSpace receivingSpace){
		Object[] parameters = new Object[9];
        if(receivingSpace.getId() == null){
          String newReceivingSpaceId=getNextId();
          receivingSpace.setId(newReceivingSpaceId);
        }
		parameters[0] =  receivingSpace.getId();
 
 		
 		parameters[1] = receivingSpace.getLocation();
 		
 		
 		parameters[2] = receivingSpace.getContactNumber();
 		
 		
 		parameters[3] = receivingSpace.getDescription();
 		
 		
 		parameters[4] = receivingSpace.getTotalArea();
 		
 		if(receivingSpace.getWarehouse() != null){
 			parameters[5] = receivingSpace.getWarehouse().getId();

 		}
 		
 		
 		parameters[6] = receivingSpace.getLatitude();
 		
 		
 		parameters[7] = receivingSpace.getLongitude();
 		
 		
 		parameters[8] = receivingSpace.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected ReceivingSpace saveInternalReceivingSpace(ReceivingSpace receivingSpace, Map<String,Object> options){

		saveReceivingSpace(receivingSpace);

 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(receivingSpace, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(receivingSpace, options);
	 		//removeGoodsList(receivingSpace, options);
	 		//Not delete the record

 		}
		
		return receivingSpace;

	}



	//======================================================================================
	

 	protected ReceivingSpace saveWarehouse(ReceivingSpace receivingSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(receivingSpace.getWarehouse() == null){
 			return receivingSpace;//do nothing when it is null
 		}

 		getWarehouseDAO().save(receivingSpace.getWarehouse(),options);
 		return receivingSpace;

 	}





 

	
	public ReceivingSpace planToRemoveGoodsList(ReceivingSpace receivingSpace, String goodsIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){

			goodsItem.clearFromAll();
		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;

	}


	//disconnect ReceivingSpace with sku in Goods
	public ReceivingSpace planToRemoveGoodsListWithSku(ReceivingSpace receivingSpace, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.SKU_PROPERTY, skuId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSku();
			goodsItem.clearReceivingSpace();

		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;
	}

	public int countGoodsListWithSku(String receivingSpaceId, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		key.put(Goods.SKU_PROPERTY, skuId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ReceivingSpace with goods_allocation in Goods
	public ReceivingSpace planToRemoveGoodsListWithGoodsAllocation(ReceivingSpace receivingSpace, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearGoodsAllocation();
			goodsItem.clearReceivingSpace();

		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;
	}

	public int countGoodsListWithGoodsAllocation(String receivingSpaceId, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ReceivingSpace with smart_pallet in Goods
	public ReceivingSpace planToRemoveGoodsListWithSmartPallet(ReceivingSpace receivingSpace, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSmartPallet();
			goodsItem.clearReceivingSpace();

		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;
	}

	public int countGoodsListWithSmartPallet(String receivingSpaceId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ReceivingSpace with shipping_space in Goods
	public ReceivingSpace planToRemoveGoodsListWithShippingSpace(ReceivingSpace receivingSpace, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearShippingSpace();
			goodsItem.clearReceivingSpace();

		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;
	}

	public int countGoodsListWithShippingSpace(String receivingSpaceId, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ReceivingSpace with transport_task in Goods
	public ReceivingSpace planToRemoveGoodsListWithTransportTask(ReceivingSpace receivingSpace, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearTransportTask();
			goodsItem.clearReceivingSpace();

		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;
	}

	public int countGoodsListWithTransportTask(String receivingSpaceId, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ReceivingSpace with retail_store in Goods
	public ReceivingSpace planToRemoveGoodsListWithRetailStore(ReceivingSpace receivingSpace, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStore();
			goodsItem.clearReceivingSpace();

		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;
	}

	public int countGoodsListWithRetailStore(String receivingSpaceId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ReceivingSpace with biz_order in Goods
	public ReceivingSpace planToRemoveGoodsListWithBizOrder(ReceivingSpace receivingSpace, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearBizOrder();
			goodsItem.clearReceivingSpace();

		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;
	}

	public int countGoodsListWithBizOrder(String receivingSpaceId, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect ReceivingSpace with retail_store_order in Goods
	public ReceivingSpace planToRemoveGoodsListWithRetailStoreOrder(ReceivingSpace receivingSpace, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpace.getId());
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return receivingSpace;
		}
		if(externalGoodsList.isEmpty()){
			return receivingSpace;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStoreOrder();
			goodsItem.clearReceivingSpace();

		}


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return receivingSpace;
	}

	public int countGoodsListWithRetailStoreOrder(String receivingSpaceId, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	

		
	protected ReceivingSpace saveGoodsList(ReceivingSpace receivingSpace, Map<String,Object> options){




		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return receivingSpace;
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


		return receivingSpace;

	}

	protected ReceivingSpace removeGoodsList(ReceivingSpace receivingSpace, Map<String,Object> options){


		SmartList<Goods> goodsList = receivingSpace.getGoodsList();
		if(goodsList == null){
			return receivingSpace;
		}

		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();

		if(toRemoveGoodsList == null){
			return receivingSpace;
		}
		if(toRemoveGoodsList.isEmpty()){
			return receivingSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);

		return receivingSpace;

	}








		

	public ReceivingSpace present(ReceivingSpace receivingSpace,Map<String, Object> options){
	
		presentGoodsList(receivingSpace,options);

		return receivingSpace;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ReceivingSpace presentGoodsList(
			ReceivingSpace receivingSpace,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = receivingSpace.getGoodsList();		
				SmartList<Goods> newList= presentSubList(receivingSpace.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsByReceivingSpace,
				getGoodsDAO()::findGoodsByReceivingSpace
				);

		
		receivingSpace.setGoodsList(newList);
		

		return receivingSpace;
	}			
		

	
    public SmartList<ReceivingSpace> requestCandidateReceivingSpaceForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ReceivingSpaceTable.COLUMN_LOCATION, ReceivingSpaceTable.COLUMN_WAREHOUSE, filterKey, pageNo, pageSize, getReceivingSpaceMapper());
    }
		

	protected String getTableName(){
		return ReceivingSpaceTable.TABLE_NAME;
	}



	public void enhanceList(List<ReceivingSpace> receivingSpaceList) {
		this.enhanceListInternal(receivingSpaceList, this.getReceivingSpaceMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Goods的receivingSpace的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<ReceivingSpace> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RECEIVING_SPACE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Goods> loadedObjs = userContext.getDAOGroup().getGoodsDAO().findGoodsWithKey(key, options);
		Map<String, List<Goods>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getReceivingSpace().getId()));
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
		List<ReceivingSpace> receivingSpaceList = ownerEntity.collectRefsWithType(ReceivingSpace.INTERNAL_TYPE);
		this.enhanceList(receivingSpaceList);

	}

	@Override
	public SmartList<ReceivingSpace> findReceivingSpaceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getReceivingSpaceMapper());

	}
	@Override
	public int countReceivingSpaceWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countReceivingSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ReceivingSpace> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getReceivingSpaceMapper());
	}

  @Override
  public Stream<ReceivingSpace> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getReceivingSpaceMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateReceivingSpace executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateReceivingSpace result = new CandidateReceivingSpace();
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


