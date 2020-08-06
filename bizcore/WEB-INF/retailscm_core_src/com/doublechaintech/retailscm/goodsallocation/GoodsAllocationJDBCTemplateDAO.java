
package com.doublechaintech.retailscm.goodsallocation;

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
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class GoodsAllocationJDBCTemplateDAO extends RetailscmBaseDAOImpl implements GoodsAllocationDAO{

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
	protected GoodsAllocation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsAllocation(accessKey, options);
	}
	*/

	public SmartList<GoodsAllocation> loadAll() {
	    return this.loadAll(getGoodsAllocationMapper());
	}

  public Stream<GoodsAllocation> loadAllAsStream() {
      return this.loadAllAsStream(getGoodsAllocationMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public GoodsAllocation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsAllocation(GoodsAllocationTable.withId(id), options);
	}

	

	public GoodsAllocation save(GoodsAllocation goodsAllocation,Map<String,Object> options){

		String methodName="save(GoodsAllocation goodsAllocation,Map<String,Object> options)";

		assertMethodArgumentNotNull(goodsAllocation, methodName, "goodsAllocation");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalGoodsAllocation(goodsAllocation,options);
	}
	public GoodsAllocation clone(String goodsAllocationId, Map<String,Object> options) throws Exception{

		return clone(GoodsAllocationTable.withId(goodsAllocationId),options);
	}

	protected GoodsAllocation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String goodsAllocationId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		GoodsAllocation newGoodsAllocation = loadInternalGoodsAllocation(accessKey, options);
		newGoodsAllocation.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newGoodsAllocation.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalGoodsAllocation(newGoodsAllocation,options);

		return newGoodsAllocation;
	}

	



	protected void throwIfHasException(String goodsAllocationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new GoodsAllocationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsAllocationNotFoundException(
					"The " + this.getTableName() + "(" + goodsAllocationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String goodsAllocationId, int version) throws Exception{

		String methodName="delete(String goodsAllocationId, int version)";
		assertMethodArgumentNotNull(goodsAllocationId, methodName, "goodsAllocationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsAllocationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsAllocationId,version);
		}


	}






	public GoodsAllocation disconnectFromAll(String goodsAllocationId, int version) throws Exception{


		GoodsAllocation goodsAllocation = loadInternalGoodsAllocation(GoodsAllocationTable.withId(goodsAllocationId), emptyOptions());
		goodsAllocation.clearFromAll();
		this.saveGoodsAllocation(goodsAllocation);
		return goodsAllocation;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return GoodsAllocationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "goods_allocation";
	}
	@Override
	protected String getBeanName() {

		return "goodsAllocation";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsAllocationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractGoodsShelfEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsAllocationTokens.GOODSSHELF);
 	}

 	protected boolean isSaveGoodsShelfEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsAllocationTokens.GOODSSHELF);
 	}
 	

 	
 
		
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GoodsAllocationTokens.GOODS_LIST);
 	}
 	protected boolean isAnalyzeGoodsListEnabled(Map<String,Object> options){		 		
 		return GoodsAllocationTokens.of(options).analyzeGoodsListEnabled();
 	}
	
	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsAllocationTokens.GOODS_LIST);
		
 	}
 	
		

	

	protected GoodsAllocationMapper getGoodsAllocationMapper(){
		return new GoodsAllocationMapper();
	}

	
	
	protected GoodsAllocation extractGoodsAllocation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			GoodsAllocation goodsAllocation = loadSingleObject(accessKey, getGoodsAllocationMapper());
			return goodsAllocation;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsAllocationNotFoundException("GoodsAllocation("+accessKey+") is not found!");
		}

	}

	
	

	protected GoodsAllocation loadInternalGoodsAllocation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GoodsAllocation goodsAllocation = extractGoodsAllocation(accessKey, loadOptions);
 	
 		if(isExtractGoodsShelfEnabled(loadOptions)){
	 		extractGoodsShelf(goodsAllocation, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(goodsAllocation, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeGoodsListEnabled(loadOptions)){
	 		analyzeGoodsList(goodsAllocation, loadOptions);
 		}
 		
		
		return goodsAllocation;
		
	}

	 

 	protected GoodsAllocation extractGoodsShelf(GoodsAllocation goodsAllocation, Map<String,Object> options) throws Exception{

		if(goodsAllocation.getGoodsShelf() == null){
			return goodsAllocation;
		}
		String goodsShelfId = goodsAllocation.getGoodsShelf().getId();
		if( goodsShelfId == null){
			return goodsAllocation;
		}
		GoodsShelf goodsShelf = getGoodsShelfDAO().load(goodsShelfId,options);
		if(goodsShelf != null){
			goodsAllocation.setGoodsShelf(goodsShelf);
		}
		
 		
 		return goodsAllocation;
 	}
 		
 
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected GoodsAllocation extractGoodsList(GoodsAllocation goodsAllocation, Map<String,Object> options){
		
		
		if(goodsAllocation == null){
			return null;
		}
		if(goodsAllocation.getId() == null){
			return goodsAllocation;
		}

		
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByGoodsAllocation(goodsAllocation.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			goodsAllocation.setGoodsList(goodsList);
		}
		
		return goodsAllocation;
	
	}	
	
	protected GoodsAllocation analyzeGoodsList(GoodsAllocation goodsAllocation, Map<String,Object> options){
		
		
		if(goodsAllocation == null){
			return null;
		}
		if(goodsAllocation.getId() == null){
			return goodsAllocation;
		}

		
		
		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		if(goodsList != null){
			getGoodsDAO().analyzeGoodsByGoodsAllocation(goodsList, goodsAllocation.getId(), options);
			
		}
		
		return goodsAllocation;
	
	}	
	
		
		
  	
 	public SmartList<GoodsAllocation> findGoodsAllocationByGoodsShelf(String goodsShelfId,Map<String,Object> options){
 	
  		SmartList<GoodsAllocation> resultList = queryWith(GoodsAllocationTable.COLUMN_GOODS_SHELF, goodsShelfId, options, getGoodsAllocationMapper());
		// analyzeGoodsAllocationByGoodsShelf(resultList, goodsShelfId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<GoodsAllocation> findGoodsAllocationByGoodsShelf(String goodsShelfId, int start, int count,Map<String,Object> options){
 		
 		SmartList<GoodsAllocation> resultList =  queryWithRange(GoodsAllocationTable.COLUMN_GOODS_SHELF, goodsShelfId, options, getGoodsAllocationMapper(), start, count);
 		//analyzeGoodsAllocationByGoodsShelf(resultList, goodsShelfId, options);
 		return resultList;
 		
 	}
 	public void analyzeGoodsAllocationByGoodsShelf(SmartList<GoodsAllocation> resultList, String goodsShelfId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countGoodsAllocationByGoodsShelf(String goodsShelfId,Map<String,Object> options){

 		return countWith(GoodsAllocationTable.COLUMN_GOODS_SHELF, goodsShelfId, options);
 	}
 	@Override
	public Map<String, Integer> countGoodsAllocationByGoodsShelfIds(String[] ids, Map<String, Object> options) {
		return countWithIds(GoodsAllocationTable.COLUMN_GOODS_SHELF, ids, options);
	}
 	
 	
		
		
		

	

	protected GoodsAllocation saveGoodsAllocation(GoodsAllocation  goodsAllocation){
		
		if(!goodsAllocation.isChanged()){
			return goodsAllocation;
		}
		

		String SQL=this.getSaveGoodsAllocationSQL(goodsAllocation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsAllocationParameters(goodsAllocation);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		goodsAllocation.incVersion();
		return goodsAllocation;

	}
	public SmartList<GoodsAllocation> saveGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsAllocationList(goodsAllocationList);

		batchGoodsAllocationCreate((List<GoodsAllocation>)lists[CREATE_LIST_INDEX]);

		batchGoodsAllocationUpdate((List<GoodsAllocation>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(GoodsAllocation goodsAllocation:goodsAllocationList){
			if(goodsAllocation.isChanged()){
				goodsAllocation.incVersion();
			}


		}


		return goodsAllocationList;
	}

	public SmartList<GoodsAllocation> removeGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList,Map<String,Object> options){


		super.removeList(goodsAllocationList, options);

		return goodsAllocationList;


	}

	protected List<Object[]> prepareGoodsAllocationBatchCreateArgs(List<GoodsAllocation> goodsAllocationList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsAllocation goodsAllocation:goodsAllocationList ){
			Object [] parameters = prepareGoodsAllocationCreateParameters(goodsAllocation);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareGoodsAllocationBatchUpdateArgs(List<GoodsAllocation> goodsAllocationList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsAllocation goodsAllocation:goodsAllocationList ){
			if(!goodsAllocation.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsAllocationUpdateParameters(goodsAllocation);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchGoodsAllocationCreate(List<GoodsAllocation> goodsAllocationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsAllocationBatchCreateArgs(goodsAllocationList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchGoodsAllocationUpdate(List<GoodsAllocation> goodsAllocationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsAllocationBatchUpdateArgs(goodsAllocationList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitGoodsAllocationList(List<GoodsAllocation> goodsAllocationList){

		List<GoodsAllocation> goodsAllocationCreateList=new ArrayList<GoodsAllocation>();
		List<GoodsAllocation> goodsAllocationUpdateList=new ArrayList<GoodsAllocation>();

		for(GoodsAllocation goodsAllocation: goodsAllocationList){
			if(isUpdateRequest(goodsAllocation)){
				goodsAllocationUpdateList.add( goodsAllocation);
				continue;
			}
			goodsAllocationCreateList.add(goodsAllocation);
		}

		return new Object[]{goodsAllocationCreateList,goodsAllocationUpdateList};
	}

	protected boolean isUpdateRequest(GoodsAllocation goodsAllocation){
 		return goodsAllocation.getVersion() > 0;
 	}
 	protected String getSaveGoodsAllocationSQL(GoodsAllocation goodsAllocation){
 		if(isUpdateRequest(goodsAllocation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveGoodsAllocationParameters(GoodsAllocation goodsAllocation){
 		if(isUpdateRequest(goodsAllocation) ){
 			return prepareGoodsAllocationUpdateParameters(goodsAllocation);
 		}
 		return prepareGoodsAllocationCreateParameters(goodsAllocation);
 	}
 	protected Object[] prepareGoodsAllocationUpdateParameters(GoodsAllocation goodsAllocation){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = goodsAllocation.getLocation();
 		
 		
 		parameters[1] = goodsAllocation.getLatitude();
 		
 		
 		parameters[2] = goodsAllocation.getLongitude();
 		
 		if(goodsAllocation.getGoodsShelf() != null){
 			parameters[3] = goodsAllocation.getGoodsShelf().getId();
 		}
 
 		parameters[4] = goodsAllocation.nextVersion();
 		parameters[5] = goodsAllocation.getId();
 		parameters[6] = goodsAllocation.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareGoodsAllocationCreateParameters(GoodsAllocation goodsAllocation){
		Object[] parameters = new Object[5];
        if(goodsAllocation.getId() == null){
          String newGoodsAllocationId=getNextId();
          goodsAllocation.setId(newGoodsAllocationId);
        }
		parameters[0] =  goodsAllocation.getId();
 
 		
 		parameters[1] = goodsAllocation.getLocation();
 		
 		
 		parameters[2] = goodsAllocation.getLatitude();
 		
 		
 		parameters[3] = goodsAllocation.getLongitude();
 		
 		if(goodsAllocation.getGoodsShelf() != null){
 			parameters[4] = goodsAllocation.getGoodsShelf().getId();

 		}
 		

 		return parameters;
 	}

	protected GoodsAllocation saveInternalGoodsAllocation(GoodsAllocation goodsAllocation, Map<String,Object> options){

		saveGoodsAllocation(goodsAllocation);

 		if(isSaveGoodsShelfEnabled(options)){
	 		saveGoodsShelf(goodsAllocation, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(goodsAllocation, options);
	 		//removeGoodsList(goodsAllocation, options);
	 		//Not delete the record

 		}
		
		return goodsAllocation;

	}



	//======================================================================================
	

 	protected GoodsAllocation saveGoodsShelf(GoodsAllocation goodsAllocation, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goodsAllocation.getGoodsShelf() == null){
 			return goodsAllocation;//do nothing when it is null
 		}

 		getGoodsShelfDAO().save(goodsAllocation.getGoodsShelf(),options);
 		return goodsAllocation;

 	}





 

	
	public GoodsAllocation planToRemoveGoodsList(GoodsAllocation goodsAllocation, String goodsIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){

			goodsItem.clearFromAll();
		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;

	}


	//disconnect GoodsAllocation with sku in Goods
	public GoodsAllocation planToRemoveGoodsListWithSku(GoodsAllocation goodsAllocation, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.SKU_PROPERTY, skuId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSku();
			goodsItem.clearGoodsAllocation();

		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;
	}

	public int countGoodsListWithSku(String goodsAllocationId, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		key.put(Goods.SKU_PROPERTY, skuId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsAllocation with receiving_space in Goods
	public GoodsAllocation planToRemoveGoodsListWithReceivingSpace(GoodsAllocation goodsAllocation, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearReceivingSpace();
			goodsItem.clearGoodsAllocation();

		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;
	}

	public int countGoodsListWithReceivingSpace(String goodsAllocationId, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsAllocation with smart_pallet in Goods
	public GoodsAllocation planToRemoveGoodsListWithSmartPallet(GoodsAllocation goodsAllocation, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSmartPallet();
			goodsItem.clearGoodsAllocation();

		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;
	}

	public int countGoodsListWithSmartPallet(String goodsAllocationId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsAllocation with shipping_space in Goods
	public GoodsAllocation planToRemoveGoodsListWithShippingSpace(GoodsAllocation goodsAllocation, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearShippingSpace();
			goodsItem.clearGoodsAllocation();

		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;
	}

	public int countGoodsListWithShippingSpace(String goodsAllocationId, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsAllocation with transport_task in Goods
	public GoodsAllocation planToRemoveGoodsListWithTransportTask(GoodsAllocation goodsAllocation, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearTransportTask();
			goodsItem.clearGoodsAllocation();

		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;
	}

	public int countGoodsListWithTransportTask(String goodsAllocationId, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsAllocation with retail_store in Goods
	public GoodsAllocation planToRemoveGoodsListWithRetailStore(GoodsAllocation goodsAllocation, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStore();
			goodsItem.clearGoodsAllocation();

		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;
	}

	public int countGoodsListWithRetailStore(String goodsAllocationId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsAllocation with biz_order in Goods
	public GoodsAllocation planToRemoveGoodsListWithBizOrder(GoodsAllocation goodsAllocation, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearBizOrder();
			goodsItem.clearGoodsAllocation();

		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;
	}

	public int countGoodsListWithBizOrder(String goodsAllocationId, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect GoodsAllocation with retail_store_order in Goods
	public GoodsAllocation planToRemoveGoodsListWithRetailStoreOrder(GoodsAllocation goodsAllocation, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocation.getId());
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return goodsAllocation;
		}
		if(externalGoodsList.isEmpty()){
			return goodsAllocation;
		}

		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStoreOrder();
			goodsItem.clearGoodsAllocation();

		}


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		goodsList.addAllToRemoveList(externalGoodsList);
		return goodsAllocation;
	}

	public int countGoodsListWithRetailStoreOrder(String goodsAllocationId, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);

		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	

		
	protected GoodsAllocation saveGoodsList(GoodsAllocation goodsAllocation, Map<String,Object> options){




		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return goodsAllocation;
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


		return goodsAllocation;

	}

	protected GoodsAllocation removeGoodsList(GoodsAllocation goodsAllocation, Map<String,Object> options){


		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();
		if(goodsList == null){
			return goodsAllocation;
		}

		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();

		if(toRemoveGoodsList == null){
			return goodsAllocation;
		}
		if(toRemoveGoodsList.isEmpty()){
			return goodsAllocation;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);

		return goodsAllocation;

	}








		

	public GoodsAllocation present(GoodsAllocation goodsAllocation,Map<String, Object> options){
	
		presentGoodsList(goodsAllocation,options);

		return goodsAllocation;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected GoodsAllocation presentGoodsList(
			GoodsAllocation goodsAllocation,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = goodsAllocation.getGoodsList();		
				SmartList<Goods> newList= presentSubList(goodsAllocation.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsByGoodsAllocation,
				getGoodsDAO()::findGoodsByGoodsAllocation
				);

		
		goodsAllocation.setGoodsList(newList);
		

		return goodsAllocation;
	}			
		

	
    public SmartList<GoodsAllocation> requestCandidateGoodsAllocationForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(GoodsAllocationTable.COLUMN_LOCATION, GoodsAllocationTable.COLUMN_GOODS_SHELF, filterKey, pageNo, pageSize, getGoodsAllocationMapper());
    }
		

	protected String getTableName(){
		return GoodsAllocationTable.TABLE_NAME;
	}



	public void enhanceList(List<GoodsAllocation> goodsAllocationList) {
		this.enhanceListInternal(goodsAllocationList, this.getGoodsAllocationMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Goods的goodsAllocation的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<GoodsAllocation> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Goods> loadedObjs = userContext.getDAOGroup().getGoodsDAO().findGoodsWithKey(key, options);
		Map<String, List<Goods>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getGoodsAllocation().getId()));
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
		List<GoodsAllocation> goodsAllocationList = ownerEntity.collectRefsWithType(GoodsAllocation.INTERNAL_TYPE);
		this.enhanceList(goodsAllocationList);

	}

	@Override
	public SmartList<GoodsAllocation> findGoodsAllocationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getGoodsAllocationMapper());

	}
	@Override
	public int countGoodsAllocationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countGoodsAllocationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<GoodsAllocation> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getGoodsAllocationMapper());
	}

  @Override
  public Stream<GoodsAllocation> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getGoodsAllocationMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateGoodsAllocation executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateGoodsAllocation result = new CandidateGoodsAllocation();
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


