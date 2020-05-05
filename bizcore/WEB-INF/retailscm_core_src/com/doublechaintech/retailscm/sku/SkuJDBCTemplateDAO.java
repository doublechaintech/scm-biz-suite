
package com.doublechaintech.retailscm.sku;

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
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.product.ProductDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class SkuJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SkuDAO{

	protected ProductDAO productDAO;
	public void setProductDAO(ProductDAO productDAO){
 	
 		if(productDAO == null){
 			throw new IllegalStateException("Do not try to set productDAO to null.");
 		}
	 	this.productDAO = productDAO;
 	}
 	public ProductDAO getProductDAO(){
 		if(this.productDAO == null){
 			throw new IllegalStateException("The productDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productDAO;
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
	protected Sku load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSku(accessKey, options);
	}
	*/
	
	public SmartList<Sku> loadAll() {
	    return this.loadAll(getSkuMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Sku load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSku(SkuTable.withId(id), options);
	}
	
	
	
	public Sku save(Sku sku,Map<String,Object> options){
		
		String methodName="save(Sku sku,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(sku, methodName, "sku");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSku(sku,options);
	}
	public Sku clone(String skuId, Map<String,Object> options) throws Exception{
	
		return clone(SkuTable.withId(skuId),options);
	}
	
	protected Sku clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String skuId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Sku newSku = loadInternalSku(accessKey, options);
		newSku.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newSku.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSku(newSku,options);
		
		return newSku;
	}
	
	
	
	

	protected void throwIfHasException(String skuId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SkuVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SkuNotFoundException(
					"The " + this.getTableName() + "(" + skuId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String skuId, int version) throws Exception{
	
		String methodName="delete(String skuId, int version)";
		assertMethodArgumentNotNull(skuId, methodName, "skuId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{skuId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(skuId,version);
		}
		
	
	}
	
	
	
	
	

	public Sku disconnectFromAll(String skuId, int version) throws Exception{
	
		
		Sku sku = loadInternalSku(SkuTable.withId(skuId), emptyOptions());
		sku.clearFromAll();
		this.saveSku(sku);
		return sku;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SkuTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "sku";
	}
	@Override
	protected String getBeanName() {
		
		return "sku";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SkuTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractProductEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SkuTokens.PRODUCT);
 	}

 	protected boolean isSaveProductEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SkuTokens.PRODUCT);
 	}
 	

 	
 
		
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SkuTokens.GOODS_LIST);
 	}
 	protected boolean isAnalyzeGoodsListEnabled(Map<String,Object> options){		 		
 		return SkuTokens.of(options).analyzeGoodsListEnabled();
 	}
	
	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, SkuTokens.GOODS_LIST);
		
 	}
 	
		

	

	protected SkuMapper getSkuMapper(){
		return new SkuMapper();
	}

	
	
	protected Sku extractSku(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Sku sku = loadSingleObject(accessKey, getSkuMapper());
			return sku;
		}catch(EmptyResultDataAccessException e){
			throw new SkuNotFoundException("Sku("+accessKey+") is not found!");
		}

	}

	
	

	protected Sku loadInternalSku(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Sku sku = extractSku(accessKey, loadOptions);
 	
 		if(isExtractProductEnabled(loadOptions)){
	 		extractProduct(sku, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(sku, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeGoodsListEnabled(loadOptions)){
	 		analyzeGoodsList(sku, loadOptions);
 		}
 		
		
		return sku;
		
	}

	 

 	protected Sku extractProduct(Sku sku, Map<String,Object> options) throws Exception{

		if(sku.getProduct() == null){
			return sku;
		}
		String productId = sku.getProduct().getId();
		if( productId == null){
			return sku;
		}
		Product product = getProductDAO().load(productId,options);
		if(product != null){
			sku.setProduct(product);
		}
		
 		
 		return sku;
 	}
 		
 
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Sku extractGoodsList(Sku sku, Map<String,Object> options){
		
		
		if(sku == null){
			return null;
		}
		if(sku.getId() == null){
			return sku;
		}

		
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsBySku(sku.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			sku.setGoodsList(goodsList);
		}
		
		return sku;
	
	}	
	
	protected Sku analyzeGoodsList(Sku sku, Map<String,Object> options){
		
		
		if(sku == null){
			return null;
		}
		if(sku.getId() == null){
			return sku;
		}

		
		
		SmartList<Goods> goodsList = sku.getGoodsList();
		if(goodsList != null){
			getGoodsDAO().analyzeGoodsBySku(goodsList, sku.getId(), options);
			
		}
		
		return sku;
	
	}	
	
		
		
  	
 	public SmartList<Sku> findSkuByProduct(String productId,Map<String,Object> options){
 	
  		SmartList<Sku> resultList = queryWith(SkuTable.COLUMN_PRODUCT, productId, options, getSkuMapper());
		// analyzeSkuByProduct(resultList, productId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Sku> findSkuByProduct(String productId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Sku> resultList =  queryWithRange(SkuTable.COLUMN_PRODUCT, productId, options, getSkuMapper(), start, count);
 		//analyzeSkuByProduct(resultList, productId, options);
 		return resultList;
 		
 	}
 	public void analyzeSkuByProduct(SmartList<Sku> resultList, String productId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countSkuByProduct(String productId,Map<String,Object> options){

 		return countWith(SkuTable.COLUMN_PRODUCT, productId, options);
 	}
 	@Override
	public Map<String, Integer> countSkuByProductIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SkuTable.COLUMN_PRODUCT, ids, options);
	}
 	
 	
		
		
		

	

	protected Sku saveSku(Sku  sku){
		
		if(!sku.isChanged()){
			return sku;
		}
		
		
		String SQL=this.getSaveSkuSQL(sku);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSkuParameters(sku);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		sku.incVersion();
		return sku;
	
	}
	public SmartList<Sku> saveSkuList(SmartList<Sku> skuList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSkuList(skuList);
		
		batchSkuCreate((List<Sku>)lists[CREATE_LIST_INDEX]);
		
		batchSkuUpdate((List<Sku>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Sku sku:skuList){
			if(sku.isChanged()){
				sku.incVersion();
			}
			
		
		}
		
		
		return skuList;
	}

	public SmartList<Sku> removeSkuList(SmartList<Sku> skuList,Map<String,Object> options){
		
		
		super.removeList(skuList, options);
		
		return skuList;
		
		
	}
	
	protected List<Object[]> prepareSkuBatchCreateArgs(List<Sku> skuList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Sku sku:skuList ){
			Object [] parameters = prepareSkuCreateParameters(sku);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSkuBatchUpdateArgs(List<Sku> skuList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Sku sku:skuList ){
			if(!sku.isChanged()){
				continue;
			}
			Object [] parameters = prepareSkuUpdateParameters(sku);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSkuCreate(List<Sku> skuList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSkuBatchCreateArgs(skuList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSkuUpdate(List<Sku> skuList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSkuBatchUpdateArgs(skuList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSkuList(List<Sku> skuList){
		
		List<Sku> skuCreateList=new ArrayList<Sku>();
		List<Sku> skuUpdateList=new ArrayList<Sku>();
		
		for(Sku sku: skuList){
			if(isUpdateRequest(sku)){
				skuUpdateList.add( sku);
				continue;
			}
			skuCreateList.add(sku);
		}
		
		return new Object[]{skuCreateList,skuUpdateList};
	}
	
	protected boolean isUpdateRequest(Sku sku){
 		return sku.getVersion() > 0;
 	}
 	protected String getSaveSkuSQL(Sku sku){
 		if(isUpdateRequest(sku)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSkuParameters(Sku sku){
 		if(isUpdateRequest(sku) ){
 			return prepareSkuUpdateParameters(sku);
 		}
 		return prepareSkuCreateParameters(sku);
 	}
 	protected Object[] prepareSkuUpdateParameters(Sku sku){
 		Object[] parameters = new Object[11];
 
 		
 		parameters[0] = sku.getName();
 		
 		
 		parameters[1] = sku.getSize();
 		 	
 		if(sku.getProduct() != null){
 			parameters[2] = sku.getProduct().getId();
 		}
 
 		
 		parameters[3] = sku.getBarcode();
 		
 		
 		parameters[4] = sku.getPackageType();
 		
 		
 		parameters[5] = sku.getNetContent();
 		
 		
 		parameters[6] = sku.getPrice();
 		
 		
 		parameters[7] = sku.getPicture();
 				
 		parameters[8] = sku.nextVersion();
 		parameters[9] = sku.getId();
 		parameters[10] = sku.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSkuCreateParameters(Sku sku){
		Object[] parameters = new Object[9];
		String newSkuId=getNextId();
		sku.setId(newSkuId);
		parameters[0] =  sku.getId();
 
 		
 		parameters[1] = sku.getName();
 		
 		
 		parameters[2] = sku.getSize();
 		 	
 		if(sku.getProduct() != null){
 			parameters[3] = sku.getProduct().getId();
 		
 		}
 		
 		
 		parameters[4] = sku.getBarcode();
 		
 		
 		parameters[5] = sku.getPackageType();
 		
 		
 		parameters[6] = sku.getNetContent();
 		
 		
 		parameters[7] = sku.getPrice();
 		
 		
 		parameters[8] = sku.getPicture();
 				
 				
 		return parameters;
 	}
 	
	protected Sku saveInternalSku(Sku sku, Map<String,Object> options){
		
		saveSku(sku);
 	
 		if(isSaveProductEnabled(options)){
	 		saveProduct(sku, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(sku, options);
	 		//removeGoodsList(sku, options);
	 		//Not delete the record
	 		
 		}		
		
		return sku;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Sku saveProduct(Sku sku, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(sku.getProduct() == null){
 			return sku;//do nothing when it is null
 		}
 		
 		getProductDAO().save(sku.getProduct(),options);
 		return sku;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Sku planToRemoveGoodsList(Sku sku, String goodsIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){

			goodsItem.clearFromAll();
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;	
	
	}


	//disconnect Sku with receiving_space in Goods
	public Sku planToRemoveGoodsListWithReceivingSpace(Sku sku, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearReceivingSpace();
			goodsItem.clearSku();
			
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;
	}
	
	public int countGoodsListWithReceivingSpace(String skuId, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, skuId);
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect Sku with goods_allocation in Goods
	public Sku planToRemoveGoodsListWithGoodsAllocation(Sku sku, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearGoodsAllocation();
			goodsItem.clearSku();
			
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;
	}
	
	public int countGoodsListWithGoodsAllocation(String skuId, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, skuId);
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect Sku with smart_pallet in Goods
	public Sku planToRemoveGoodsListWithSmartPallet(Sku sku, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSmartPallet();
			goodsItem.clearSku();
			
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;
	}
	
	public int countGoodsListWithSmartPallet(String skuId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, skuId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect Sku with shipping_space in Goods
	public Sku planToRemoveGoodsListWithShippingSpace(Sku sku, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearShippingSpace();
			goodsItem.clearSku();
			
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;
	}
	
	public int countGoodsListWithShippingSpace(String skuId, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, skuId);
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect Sku with transport_task in Goods
	public Sku planToRemoveGoodsListWithTransportTask(Sku sku, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearTransportTask();
			goodsItem.clearSku();
			
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;
	}
	
	public int countGoodsListWithTransportTask(String skuId, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, skuId);
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect Sku with retail_store in Goods
	public Sku planToRemoveGoodsListWithRetailStore(Sku sku, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStore();
			goodsItem.clearSku();
			
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;
	}
	
	public int countGoodsListWithRetailStore(String skuId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, skuId);
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect Sku with biz_order in Goods
	public Sku planToRemoveGoodsListWithBizOrder(Sku sku, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearBizOrder();
			goodsItem.clearSku();
			
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;
	}
	
	public int countGoodsListWithBizOrder(String skuId, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, skuId);
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect Sku with retail_store_order in Goods
	public Sku planToRemoveGoodsListWithRetailStoreOrder(Sku sku, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, sku.getId());
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return sku;
		}
		if(externalGoodsList.isEmpty()){
			return sku;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStoreOrder();
			goodsItem.clearSku();
			
		}
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return sku;
	}
	
	public int countGoodsListWithRetailStoreOrder(String skuId, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, skuId);
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	

		
	protected Sku saveGoodsList(Sku sku, Map<String,Object> options){
		
		
		
		
		SmartList<Goods> goodsList = sku.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return sku;
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
		
		
		return sku;
	
	}
	
	protected Sku removeGoodsList(Sku sku, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = sku.getGoodsList();
		if(goodsList == null){
			return sku;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return sku;
		}
		if(toRemoveGoodsList.isEmpty()){
			return sku;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return sku;
	
	}
	
	

 	
 	
	
	
	
		

	public Sku present(Sku sku,Map<String, Object> options){
	
		presentGoodsList(sku,options);

		return sku;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Sku presentGoodsList(
			Sku sku,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = sku.getGoodsList();		
				SmartList<Goods> newList= presentSubList(sku.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsBySku,
				getGoodsDAO()::findGoodsBySku
				);

		
		sku.setGoodsList(newList);
		

		return sku;
	}			
		

	
    public SmartList<Sku> requestCandidateSkuForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SkuTable.COLUMN_NAME, SkuTable.COLUMN_PRODUCT, filterKey, pageNo, pageSize, getSkuMapper());
    }
		

	protected String getTableName(){
		return SkuTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Sku> skuList) {		
		this.enhanceListInternal(skuList, this.getSkuMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Goods的sku的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<Sku> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.SKU_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Goods> loadedObjs = userContext.getDAOGroup().getGoodsDAO().findGoodsWithKey(key, options);
		Map<String, List<Goods>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getSku().getId()));
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
		List<Sku> skuList = ownerEntity.collectRefsWithType(Sku.INTERNAL_TYPE);
		this.enhanceList(skuList);
		
	}
	
	@Override
	public SmartList<Sku> findSkuWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSkuMapper());

	}
	@Override
	public int countSkuWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSkuWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Sku> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSkuMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSku executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSku result = new CandidateSku();
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


