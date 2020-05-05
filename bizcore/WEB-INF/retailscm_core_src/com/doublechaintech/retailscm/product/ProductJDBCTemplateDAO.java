
package com.doublechaintech.retailscm.product;

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
import com.doublechaintech.retailscm.sku.Sku;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryDAO;
import com.doublechaintech.retailscm.sku.SkuDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ProductJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ProductDAO{

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

	protected SkuDAO skuDAO;
	public void setSkuDAO(SkuDAO skuDAO){
 	
 		if(skuDAO == null){
 			throw new IllegalStateException("Do not try to set skuDAO to null.");
 		}
	 	this.skuDAO = skuDAO;
 	}
 	public SkuDAO getSkuDAO(){
 		if(this.skuDAO == null){
 			throw new IllegalStateException("The skuDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.skuDAO;
 	}	

	
	/*
	protected Product load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProduct(accessKey, options);
	}
	*/
	
	public SmartList<Product> loadAll() {
	    return this.loadAll(getProductMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Product load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProduct(ProductTable.withId(id), options);
	}
	
	
	
	public Product save(Product product,Map<String,Object> options){
		
		String methodName="save(Product product,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(product, methodName, "product");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProduct(product,options);
	}
	public Product clone(String productId, Map<String,Object> options) throws Exception{
	
		return clone(ProductTable.withId(productId),options);
	}
	
	protected Product clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String productId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Product newProduct = loadInternalProduct(accessKey, options);
		newProduct.setVersion(0);
		
		
 		
 		if(isSaveSkuListEnabled(options)){
 			for(Sku item: newProduct.getSkuList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProduct(newProduct,options);
		
		return newProduct;
	}
	
	
	
	

	protected void throwIfHasException(String productId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProductNotFoundException(
					"The " + this.getTableName() + "(" + productId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String productId, int version) throws Exception{
	
		String methodName="delete(String productId, int version)";
		assertMethodArgumentNotNull(productId, methodName, "productId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{productId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(productId,version);
		}
		
	
	}
	
	
	
	
	

	public Product disconnectFromAll(String productId, int version) throws Exception{
	
		
		Product product = loadInternalProduct(ProductTable.withId(productId), emptyOptions());
		product.clearFromAll();
		this.saveProduct(product);
		return product;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "product";
	}
	@Override
	protected String getBeanName() {
		
		return "product";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProductTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractParentCategoryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProductTokens.PARENTCATEGORY);
 	}

 	protected boolean isSaveParentCategoryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProductTokens.PARENTCATEGORY);
 	}
 	

 	
 
		
	
	protected boolean isExtractSkuListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ProductTokens.SKU_LIST);
 	}
 	protected boolean isAnalyzeSkuListEnabled(Map<String,Object> options){		 		
 		return ProductTokens.of(options).analyzeSkuListEnabled();
 	}
	
	protected boolean isSaveSkuListEnabled(Map<String,Object> options){
		return checkOptions(options, ProductTokens.SKU_LIST);
		
 	}
 	
		

	

	protected ProductMapper getProductMapper(){
		return new ProductMapper();
	}

	
	
	protected Product extractProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Product product = loadSingleObject(accessKey, getProductMapper());
			return product;
		}catch(EmptyResultDataAccessException e){
			throw new ProductNotFoundException("Product("+accessKey+") is not found!");
		}

	}

	
	

	protected Product loadInternalProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Product product = extractProduct(accessKey, loadOptions);
 	
 		if(isExtractParentCategoryEnabled(loadOptions)){
	 		extractParentCategory(product, loadOptions);
 		}
 
		
		if(isExtractSkuListEnabled(loadOptions)){
	 		extractSkuList(product, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeSkuListEnabled(loadOptions)){
	 		analyzeSkuList(product, loadOptions);
 		}
 		
		
		return product;
		
	}

	 

 	protected Product extractParentCategory(Product product, Map<String,Object> options) throws Exception{

		if(product.getParentCategory() == null){
			return product;
		}
		String parentCategoryId = product.getParentCategory().getId();
		if( parentCategoryId == null){
			return product;
		}
		LevelThreeCategory parentCategory = getLevelThreeCategoryDAO().load(parentCategoryId,options);
		if(parentCategory != null){
			product.setParentCategory(parentCategory);
		}
		
 		
 		return product;
 	}
 		
 
		
	protected void enhanceSkuList(SmartList<Sku> skuList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Product extractSkuList(Product product, Map<String,Object> options){
		
		
		if(product == null){
			return null;
		}
		if(product.getId() == null){
			return product;
		}

		
		
		SmartList<Sku> skuList = getSkuDAO().findSkuByProduct(product.getId(),options);
		if(skuList != null){
			enhanceSkuList(skuList,options);
			product.setSkuList(skuList);
		}
		
		return product;
	
	}	
	
	protected Product analyzeSkuList(Product product, Map<String,Object> options){
		
		
		if(product == null){
			return null;
		}
		if(product.getId() == null){
			return product;
		}

		
		
		SmartList<Sku> skuList = product.getSkuList();
		if(skuList != null){
			getSkuDAO().analyzeSkuByProduct(skuList, product.getId(), options);
			
		}
		
		return product;
	
	}	
	
		
		
  	
 	public SmartList<Product> findProductByParentCategory(String levelThreeCategoryId,Map<String,Object> options){
 	
  		SmartList<Product> resultList = queryWith(ProductTable.COLUMN_PARENT_CATEGORY, levelThreeCategoryId, options, getProductMapper());
		// analyzeProductByParentCategory(resultList, levelThreeCategoryId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Product> findProductByParentCategory(String levelThreeCategoryId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Product> resultList =  queryWithRange(ProductTable.COLUMN_PARENT_CATEGORY, levelThreeCategoryId, options, getProductMapper(), start, count);
 		//analyzeProductByParentCategory(resultList, levelThreeCategoryId, options);
 		return resultList;
 		
 	}
 	public void analyzeProductByParentCategory(SmartList<Product> resultList, String levelThreeCategoryId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Product.PARENT_CATEGORY_PROPERTY, levelThreeCategoryId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//Product.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("产品");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(Product.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Product.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countProductByParentCategory(String levelThreeCategoryId,Map<String,Object> options){

 		return countWith(ProductTable.COLUMN_PARENT_CATEGORY, levelThreeCategoryId, options);
 	}
 	@Override
	public Map<String, Integer> countProductByParentCategoryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProductTable.COLUMN_PARENT_CATEGORY, ids, options);
	}
 	
 	
		
		
		

	

	protected Product saveProduct(Product  product){
		
		if(!product.isChanged()){
			return product;
		}
		
		
		String SQL=this.getSaveProductSQL(product);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProductParameters(product);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		product.incVersion();
		return product;
	
	}
	public SmartList<Product> saveProductList(SmartList<Product> productList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProductList(productList);
		
		batchProductCreate((List<Product>)lists[CREATE_LIST_INDEX]);
		
		batchProductUpdate((List<Product>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Product product:productList){
			if(product.isChanged()){
				product.incVersion();
			}
			
		
		}
		
		
		return productList;
	}

	public SmartList<Product> removeProductList(SmartList<Product> productList,Map<String,Object> options){
		
		
		super.removeList(productList, options);
		
		return productList;
		
		
	}
	
	protected List<Object[]> prepareProductBatchCreateArgs(List<Product> productList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Product product:productList ){
			Object [] parameters = prepareProductCreateParameters(product);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProductBatchUpdateArgs(List<Product> productList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Product product:productList ){
			if(!product.isChanged()){
				continue;
			}
			Object [] parameters = prepareProductUpdateParameters(product);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProductCreate(List<Product> productList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProductBatchCreateArgs(productList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProductUpdate(List<Product> productList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProductBatchUpdateArgs(productList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProductList(List<Product> productList){
		
		List<Product> productCreateList=new ArrayList<Product>();
		List<Product> productUpdateList=new ArrayList<Product>();
		
		for(Product product: productList){
			if(isUpdateRequest(product)){
				productUpdateList.add( product);
				continue;
			}
			productCreateList.add(product);
		}
		
		return new Object[]{productCreateList,productUpdateList};
	}
	
	protected boolean isUpdateRequest(Product product){
 		return product.getVersion() > 0;
 	}
 	protected String getSaveProductSQL(Product product){
 		if(isUpdateRequest(product)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProductParameters(Product product){
 		if(isUpdateRequest(product) ){
 			return prepareProductUpdateParameters(product);
 		}
 		return prepareProductCreateParameters(product);
 	}
 	protected Object[] prepareProductUpdateParameters(Product product){
 		Object[] parameters = new Object[10];
 
 		
 		parameters[0] = product.getName();
 		 	
 		if(product.getParentCategory() != null){
 			parameters[1] = product.getParentCategory().getId();
 		}
 
 		
 		parameters[2] = product.getOrigin();
 		
 		
 		parameters[3] = product.getRemark();
 		
 		
 		parameters[4] = product.getBrand();
 		
 		
 		parameters[5] = product.getPicture();
 		
 		
 		parameters[6] = product.getLastUpdateTime();
 				
 		parameters[7] = product.nextVersion();
 		parameters[8] = product.getId();
 		parameters[9] = product.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProductCreateParameters(Product product){
		Object[] parameters = new Object[8];
		String newProductId=getNextId();
		product.setId(newProductId);
		parameters[0] =  product.getId();
 
 		
 		parameters[1] = product.getName();
 		 	
 		if(product.getParentCategory() != null){
 			parameters[2] = product.getParentCategory().getId();
 		
 		}
 		
 		
 		parameters[3] = product.getOrigin();
 		
 		
 		parameters[4] = product.getRemark();
 		
 		
 		parameters[5] = product.getBrand();
 		
 		
 		parameters[6] = product.getPicture();
 		
 		
 		parameters[7] = product.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected Product saveInternalProduct(Product product, Map<String,Object> options){
		
		saveProduct(product);
 	
 		if(isSaveParentCategoryEnabled(options)){
	 		saveParentCategory(product, options);
 		}
 
		
		if(isSaveSkuListEnabled(options)){
	 		saveSkuList(product, options);
	 		//removeSkuList(product, options);
	 		//Not delete the record
	 		
 		}		
		
		return product;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Product saveParentCategory(Product product, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(product.getParentCategory() == null){
 			return product;//do nothing when it is null
 		}
 		
 		getLevelThreeCategoryDAO().save(product.getParentCategory(),options);
 		return product;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Product planToRemoveSkuList(Product product, String skuIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Sku.PRODUCT_PROPERTY, product.getId());
		key.put(Sku.ID_PROPERTY, skuIds);
		
		SmartList<Sku> externalSkuList = getSkuDAO().
				findSkuWithKey(key, options);
		if(externalSkuList == null){
			return product;
		}
		if(externalSkuList.isEmpty()){
			return product;
		}
		
		for(Sku skuItem: externalSkuList){

			skuItem.clearFromAll();
		}
		
		
		SmartList<Sku> skuList = product.getSkuList();		
		skuList.addAllToRemoveList(externalSkuList);
		return product;	
	
	}



		
	protected Product saveSkuList(Product product, Map<String,Object> options){
		
		
		
		
		SmartList<Sku> skuList = product.getSkuList();
		if(skuList == null){
			//null list means nothing
			return product;
		}
		SmartList<Sku> mergedUpdateSkuList = new SmartList<Sku>();
		
		
		mergedUpdateSkuList.addAll(skuList); 
		if(skuList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSkuList.addAll(skuList.getToRemoveList());
			skuList.removeAll(skuList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSkuDAO().saveSkuList(mergedUpdateSkuList,options);
		
		if(skuList.getToRemoveList() != null){
			skuList.removeAll(skuList.getToRemoveList());
		}
		
		
		return product;
	
	}
	
	protected Product removeSkuList(Product product, Map<String,Object> options){
	
	
		SmartList<Sku> skuList = product.getSkuList();
		if(skuList == null){
			return product;
		}	
	
		SmartList<Sku> toRemoveSkuList = skuList.getToRemoveList();
		
		if(toRemoveSkuList == null){
			return product;
		}
		if(toRemoveSkuList.isEmpty()){
			return product;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSkuDAO().removeSkuList(toRemoveSkuList,options);
		
		return product;
	
	}
	
	

 	
 	
	
	
	
		

	public Product present(Product product,Map<String, Object> options){
	
		presentSkuList(product,options);

		return product;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Product presentSkuList(
			Product product,
			Map<String, Object> options) {

		SmartList<Sku> skuList = product.getSkuList();		
				SmartList<Sku> newList= presentSubList(product.getId(),
				skuList,
				options,
				getSkuDAO()::countSkuByProduct,
				getSkuDAO()::findSkuByProduct
				);

		
		product.setSkuList(newList);
		

		return product;
	}			
		

	
    public SmartList<Product> requestCandidateProductForSku(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProductTable.COLUMN_NAME, ProductTable.COLUMN_PARENT_CATEGORY, filterKey, pageNo, pageSize, getProductMapper());
    }
		

	protected String getTableName(){
		return ProductTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Product> productList) {		
		this.enhanceListInternal(productList, this.getProductMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Sku的product的SkuList
	public SmartList<Sku> loadOurSkuList(RetailscmUserContext userContext, List<Product> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Sku.PRODUCT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Sku> loadedObjs = userContext.getDAOGroup().getSkuDAO().findSkuWithKey(key, options);
		Map<String, List<Sku>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getProduct().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Sku> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Sku> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSkuList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Product> productList = ownerEntity.collectRefsWithType(Product.INTERNAL_TYPE);
		this.enhanceList(productList);
		
	}
	
	@Override
	public SmartList<Product> findProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getProductMapper());

	}
	@Override
	public int countProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Product> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProductMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateProduct executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateProduct result = new CandidateProduct();
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


