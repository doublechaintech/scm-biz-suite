
package com.doublechaintech.retailscm.supplierproduct;

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


import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;

import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class SupplierProductJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SupplierProductDAO{

	protected GoodsSupplierDAO goodsSupplierDAO;
	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){
 	
 		if(goodsSupplierDAO == null){
 			throw new IllegalStateException("Do not try to set goodsSupplierDAO to null.");
 		}
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
 		if(this.goodsSupplierDAO == null){
 			throw new IllegalStateException("The goodsSupplierDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsSupplierDAO;
 	}	

	protected ProductSupplyDurationDAO productSupplyDurationDAO;
	public void setProductSupplyDurationDAO(ProductSupplyDurationDAO productSupplyDurationDAO){
 	
 		if(productSupplyDurationDAO == null){
 			throw new IllegalStateException("Do not try to set productSupplyDurationDAO to null.");
 		}
	 	this.productSupplyDurationDAO = productSupplyDurationDAO;
 	}
 	public ProductSupplyDurationDAO getProductSupplyDurationDAO(){
 		if(this.productSupplyDurationDAO == null){
 			throw new IllegalStateException("The productSupplyDurationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.productSupplyDurationDAO;
 	}	

	
	/*
	protected SupplierProduct load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplierProduct(accessKey, options);
	}
	*/
	
	public SmartList<SupplierProduct> loadAll() {
	    return this.loadAll(getSupplierProductMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SupplierProduct load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplierProduct(SupplierProductTable.withId(id), options);
	}
	
	
	
	public SupplierProduct save(SupplierProduct supplierProduct,Map<String,Object> options){
		
		String methodName="save(SupplierProduct supplierProduct,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplierProduct, methodName, "supplierProduct");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplierProduct(supplierProduct,options);
	}
	public SupplierProduct clone(String supplierProductId, Map<String,Object> options) throws Exception{
	
		return clone(SupplierProductTable.withId(supplierProductId),options);
	}
	
	protected SupplierProduct clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplierProductId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplierProduct newSupplierProduct = loadInternalSupplierProduct(accessKey, options);
		newSupplierProduct.setVersion(0);
		
		
 		
 		if(isSaveProductSupplyDurationListEnabled(options)){
 			for(ProductSupplyDuration item: newSupplierProduct.getProductSupplyDurationList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplierProduct(newSupplierProduct,options);
		
		return newSupplierProduct;
	}
	
	
	
	

	protected void throwIfHasException(String supplierProductId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SupplierProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplierProductNotFoundException(
					"The " + this.getTableName() + "(" + supplierProductId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String supplierProductId, int version) throws Exception{
	
		String methodName="delete(String supplierProductId, int version)";
		assertMethodArgumentNotNull(supplierProductId, methodName, "supplierProductId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplierProductId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplierProductId,version);
		}
		
	
	}
	
	
	
	
	

	public SupplierProduct disconnectFromAll(String supplierProductId, int version) throws Exception{
	
		
		SupplierProduct supplierProduct = loadInternalSupplierProduct(SupplierProductTable.withId(supplierProductId), emptyOptions());
		supplierProduct.clearFromAll();
		this.saveSupplierProduct(supplierProduct);
		return supplierProduct;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SupplierProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supplier_product";
	}
	@Override
	protected String getBeanName() {
		
		return "supplierProduct";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplierProductTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractSupplierEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplierProductTokens.SUPPLIER);
 	}

 	protected boolean isSaveSupplierEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplierProductTokens.SUPPLIER);
 	}
 	

 	
 
		
	
	protected boolean isExtractProductSupplyDurationListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SupplierProductTokens.PRODUCT_SUPPLY_DURATION_LIST);
 	}
 	protected boolean isAnalyzeProductSupplyDurationListEnabled(Map<String,Object> options){		 		
 		return SupplierProductTokens.of(options).analyzeProductSupplyDurationListEnabled();
 	}
	
	protected boolean isSaveProductSupplyDurationListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplierProductTokens.PRODUCT_SUPPLY_DURATION_LIST);
		
 	}
 	
		

	

	protected SupplierProductMapper getSupplierProductMapper(){
		return new SupplierProductMapper();
	}

	
	
	protected SupplierProduct extractSupplierProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SupplierProduct supplierProduct = loadSingleObject(accessKey, getSupplierProductMapper());
			return supplierProduct;
		}catch(EmptyResultDataAccessException e){
			throw new SupplierProductNotFoundException("SupplierProduct("+accessKey+") is not found!");
		}

	}

	
	

	protected SupplierProduct loadInternalSupplierProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplierProduct supplierProduct = extractSupplierProduct(accessKey, loadOptions);
 	
 		if(isExtractSupplierEnabled(loadOptions)){
	 		extractSupplier(supplierProduct, loadOptions);
 		}
 
		
		if(isExtractProductSupplyDurationListEnabled(loadOptions)){
	 		extractProductSupplyDurationList(supplierProduct, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeProductSupplyDurationListEnabled(loadOptions)){
	 		analyzeProductSupplyDurationList(supplierProduct, loadOptions);
 		}
 		
		
		return supplierProduct;
		
	}

	 

 	protected SupplierProduct extractSupplier(SupplierProduct supplierProduct, Map<String,Object> options) throws Exception{

		if(supplierProduct.getSupplier() == null){
			return supplierProduct;
		}
		String supplierId = supplierProduct.getSupplier().getId();
		if( supplierId == null){
			return supplierProduct;
		}
		GoodsSupplier supplier = getGoodsSupplierDAO().load(supplierId,options);
		if(supplier != null){
			supplierProduct.setSupplier(supplier);
		}
		
 		
 		return supplierProduct;
 	}
 		
 
		
	protected void enhanceProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SupplierProduct extractProductSupplyDurationList(SupplierProduct supplierProduct, Map<String,Object> options){
		
		
		if(supplierProduct == null){
			return null;
		}
		if(supplierProduct.getId() == null){
			return supplierProduct;
		}

		
		
		SmartList<ProductSupplyDuration> productSupplyDurationList = getProductSupplyDurationDAO().findProductSupplyDurationByProduct(supplierProduct.getId(),options);
		if(productSupplyDurationList != null){
			enhanceProductSupplyDurationList(productSupplyDurationList,options);
			supplierProduct.setProductSupplyDurationList(productSupplyDurationList);
		}
		
		return supplierProduct;
	
	}	
	
	protected SupplierProduct analyzeProductSupplyDurationList(SupplierProduct supplierProduct, Map<String,Object> options){
		
		
		if(supplierProduct == null){
			return null;
		}
		if(supplierProduct.getId() == null){
			return supplierProduct;
		}

		
		
		SmartList<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();
		if(productSupplyDurationList != null){
			getProductSupplyDurationDAO().analyzeProductSupplyDurationByProduct(productSupplyDurationList, supplierProduct.getId(), options);
			
		}
		
		return supplierProduct;
	
	}	
	
		
		
  	
 	public SmartList<SupplierProduct> findSupplierProductBySupplier(String goodsSupplierId,Map<String,Object> options){
 	
  		SmartList<SupplierProduct> resultList = queryWith(SupplierProductTable.COLUMN_SUPPLIER, goodsSupplierId, options, getSupplierProductMapper());
		// analyzeSupplierProductBySupplier(resultList, goodsSupplierId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SupplierProduct> findSupplierProductBySupplier(String goodsSupplierId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SupplierProduct> resultList =  queryWithRange(SupplierProductTable.COLUMN_SUPPLIER, goodsSupplierId, options, getSupplierProductMapper(), start, count);
 		//analyzeSupplierProductBySupplier(resultList, goodsSupplierId, options);
 		return resultList;
 		
 	}
 	public void analyzeSupplierProductBySupplier(SmartList<SupplierProduct> resultList, String goodsSupplierId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countSupplierProductBySupplier(String goodsSupplierId,Map<String,Object> options){

 		return countWith(SupplierProductTable.COLUMN_SUPPLIER, goodsSupplierId, options);
 	}
 	@Override
	public Map<String, Integer> countSupplierProductBySupplierIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SupplierProductTable.COLUMN_SUPPLIER, ids, options);
	}
 	
 	
		
		
		

	

	protected SupplierProduct saveSupplierProduct(SupplierProduct  supplierProduct){
		
		if(!supplierProduct.isChanged()){
			return supplierProduct;
		}
		
		
		String SQL=this.getSaveSupplierProductSQL(supplierProduct);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplierProductParameters(supplierProduct);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplierProduct.incVersion();
		return supplierProduct;
	
	}
	public SmartList<SupplierProduct> saveSupplierProductList(SmartList<SupplierProduct> supplierProductList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplierProductList(supplierProductList);
		
		batchSupplierProductCreate((List<SupplierProduct>)lists[CREATE_LIST_INDEX]);
		
		batchSupplierProductUpdate((List<SupplierProduct>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplierProduct supplierProduct:supplierProductList){
			if(supplierProduct.isChanged()){
				supplierProduct.incVersion();
			}
			
		
		}
		
		
		return supplierProductList;
	}

	public SmartList<SupplierProduct> removeSupplierProductList(SmartList<SupplierProduct> supplierProductList,Map<String,Object> options){
		
		
		super.removeList(supplierProductList, options);
		
		return supplierProductList;
		
		
	}
	
	protected List<Object[]> prepareSupplierProductBatchCreateArgs(List<SupplierProduct> supplierProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplierProduct supplierProduct:supplierProductList ){
			Object [] parameters = prepareSupplierProductCreateParameters(supplierProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplierProductBatchUpdateArgs(List<SupplierProduct> supplierProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplierProduct supplierProduct:supplierProductList ){
			if(!supplierProduct.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplierProductUpdateParameters(supplierProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplierProductCreate(List<SupplierProduct> supplierProductList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplierProductBatchCreateArgs(supplierProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplierProductUpdate(List<SupplierProduct> supplierProductList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplierProductBatchUpdateArgs(supplierProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplierProductList(List<SupplierProduct> supplierProductList){
		
		List<SupplierProduct> supplierProductCreateList=new ArrayList<SupplierProduct>();
		List<SupplierProduct> supplierProductUpdateList=new ArrayList<SupplierProduct>();
		
		for(SupplierProduct supplierProduct: supplierProductList){
			if(isUpdateRequest(supplierProduct)){
				supplierProductUpdateList.add( supplierProduct);
				continue;
			}
			supplierProductCreateList.add(supplierProduct);
		}
		
		return new Object[]{supplierProductCreateList,supplierProductUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplierProduct supplierProduct){
 		return supplierProduct.getVersion() > 0;
 	}
 	protected String getSaveSupplierProductSQL(SupplierProduct supplierProduct){
 		if(isUpdateRequest(supplierProduct)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplierProductParameters(SupplierProduct supplierProduct){
 		if(isUpdateRequest(supplierProduct) ){
 			return prepareSupplierProductUpdateParameters(supplierProduct);
 		}
 		return prepareSupplierProductCreateParameters(supplierProduct);
 	}
 	protected Object[] prepareSupplierProductUpdateParameters(SupplierProduct supplierProduct){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = supplierProduct.getProductName();
 		
 		
 		parameters[1] = supplierProduct.getProductDescription();
 		
 		
 		parameters[2] = supplierProduct.getProductUnit();
 		 	
 		if(supplierProduct.getSupplier() != null){
 			parameters[3] = supplierProduct.getSupplier().getId();
 		}
 		
 		parameters[4] = supplierProduct.nextVersion();
 		parameters[5] = supplierProduct.getId();
 		parameters[6] = supplierProduct.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplierProductCreateParameters(SupplierProduct supplierProduct){
		Object[] parameters = new Object[5];
		String newSupplierProductId=getNextId();
		supplierProduct.setId(newSupplierProductId);
		parameters[0] =  supplierProduct.getId();
 
 		
 		parameters[1] = supplierProduct.getProductName();
 		
 		
 		parameters[2] = supplierProduct.getProductDescription();
 		
 		
 		parameters[3] = supplierProduct.getProductUnit();
 		 	
 		if(supplierProduct.getSupplier() != null){
 			parameters[4] = supplierProduct.getSupplier().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected SupplierProduct saveInternalSupplierProduct(SupplierProduct supplierProduct, Map<String,Object> options){
		
		saveSupplierProduct(supplierProduct);
 	
 		if(isSaveSupplierEnabled(options)){
	 		saveSupplier(supplierProduct, options);
 		}
 
		
		if(isSaveProductSupplyDurationListEnabled(options)){
	 		saveProductSupplyDurationList(supplierProduct, options);
	 		//removeProductSupplyDurationList(supplierProduct, options);
	 		//Not delete the record
	 		
 		}		
		
		return supplierProduct;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplierProduct saveSupplier(SupplierProduct supplierProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplierProduct.getSupplier() == null){
 			return supplierProduct;//do nothing when it is null
 		}
 		
 		getGoodsSupplierDAO().save(supplierProduct.getSupplier(),options);
 		return supplierProduct;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public SupplierProduct planToRemoveProductSupplyDurationList(SupplierProduct supplierProduct, String productSupplyDurationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProductSupplyDuration.PRODUCT_PROPERTY, supplierProduct.getId());
		key.put(ProductSupplyDuration.ID_PROPERTY, productSupplyDurationIds);
		
		SmartList<ProductSupplyDuration> externalProductSupplyDurationList = getProductSupplyDurationDAO().
				findProductSupplyDurationWithKey(key, options);
		if(externalProductSupplyDurationList == null){
			return supplierProduct;
		}
		if(externalProductSupplyDurationList.isEmpty()){
			return supplierProduct;
		}
		
		for(ProductSupplyDuration productSupplyDurationItem: externalProductSupplyDurationList){

			productSupplyDurationItem.clearFromAll();
		}
		
		
		SmartList<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();		
		productSupplyDurationList.addAllToRemoveList(externalProductSupplyDurationList);
		return supplierProduct;	
	
	}



		
	protected SupplierProduct saveProductSupplyDurationList(SupplierProduct supplierProduct, Map<String,Object> options){
		
		
		
		
		SmartList<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();
		if(productSupplyDurationList == null){
			//null list means nothing
			return supplierProduct;
		}
		SmartList<ProductSupplyDuration> mergedUpdateProductSupplyDurationList = new SmartList<ProductSupplyDuration>();
		
		
		mergedUpdateProductSupplyDurationList.addAll(productSupplyDurationList); 
		if(productSupplyDurationList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProductSupplyDurationList.addAll(productSupplyDurationList.getToRemoveList());
			productSupplyDurationList.removeAll(productSupplyDurationList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProductSupplyDurationDAO().saveProductSupplyDurationList(mergedUpdateProductSupplyDurationList,options);
		
		if(productSupplyDurationList.getToRemoveList() != null){
			productSupplyDurationList.removeAll(productSupplyDurationList.getToRemoveList());
		}
		
		
		return supplierProduct;
	
	}
	
	protected SupplierProduct removeProductSupplyDurationList(SupplierProduct supplierProduct, Map<String,Object> options){
	
	
		SmartList<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();
		if(productSupplyDurationList == null){
			return supplierProduct;
		}	
	
		SmartList<ProductSupplyDuration> toRemoveProductSupplyDurationList = productSupplyDurationList.getToRemoveList();
		
		if(toRemoveProductSupplyDurationList == null){
			return supplierProduct;
		}
		if(toRemoveProductSupplyDurationList.isEmpty()){
			return supplierProduct;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProductSupplyDurationDAO().removeProductSupplyDurationList(toRemoveProductSupplyDurationList,options);
		
		return supplierProduct;
	
	}
	
	

 	
 	
	
	
	
		

	public SupplierProduct present(SupplierProduct supplierProduct,Map<String, Object> options){
	
		presentProductSupplyDurationList(supplierProduct,options);

		return supplierProduct;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SupplierProduct presentProductSupplyDurationList(
			SupplierProduct supplierProduct,
			Map<String, Object> options) {

		SmartList<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();		
				SmartList<ProductSupplyDuration> newList= presentSubList(supplierProduct.getId(),
				productSupplyDurationList,
				options,
				getProductSupplyDurationDAO()::countProductSupplyDurationByProduct,
				getProductSupplyDurationDAO()::findProductSupplyDurationByProduct
				);

		
		supplierProduct.setProductSupplyDurationList(newList);
		

		return supplierProduct;
	}			
		

	
    public SmartList<SupplierProduct> requestCandidateSupplierProductForProductSupplyDuration(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SupplierProductTable.COLUMN_PRODUCT_NAME, SupplierProductTable.COLUMN_SUPPLIER, filterKey, pageNo, pageSize, getSupplierProductMapper());
    }
		

	protected String getTableName(){
		return SupplierProductTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SupplierProduct> supplierProductList) {		
		this.enhanceListInternal(supplierProductList, this.getSupplierProductMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ProductSupplyDuration的product的ProductSupplyDurationList
	public SmartList<ProductSupplyDuration> loadOurProductSupplyDurationList(RetailscmUserContext userContext, List<SupplierProduct> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProductSupplyDuration.PRODUCT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ProductSupplyDuration> loadedObjs = userContext.getDAOGroup().getProductSupplyDurationDAO().findProductSupplyDurationWithKey(key, options);
		Map<String, List<ProductSupplyDuration>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getProduct().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ProductSupplyDuration> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ProductSupplyDuration> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setProductSupplyDurationList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SupplierProduct> supplierProductList = ownerEntity.collectRefsWithType(SupplierProduct.INTERNAL_TYPE);
		this.enhanceList(supplierProductList);
		
	}
	
	@Override
	public SmartList<SupplierProduct> findSupplierProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSupplierProductMapper());

	}
	@Override
	public int countSupplierProductWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSupplierProductWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SupplierProduct> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSupplierProductMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSupplierProduct executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSupplierProduct result = new CandidateSupplierProduct();
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


