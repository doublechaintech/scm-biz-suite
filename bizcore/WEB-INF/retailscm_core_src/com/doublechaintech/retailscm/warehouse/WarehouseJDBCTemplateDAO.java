
package com.doublechaintech.retailscm.warehouse;

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


import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

import com.doublechaintech.retailscm.damagespace.DamageSpaceDAO;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAssetDAO;
import com.doublechaintech.retailscm.smartpallet.SmartPalletDAO;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceDAO;
import com.doublechaintech.retailscm.storagespace.StorageSpaceDAO;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class WarehouseJDBCTemplateDAO extends RetailscmBaseDAOImpl implements WarehouseDAO{

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

	protected StorageSpaceDAO storageSpaceDAO;
	public void setStorageSpaceDAO(StorageSpaceDAO storageSpaceDAO){
 	
 		if(storageSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set storageSpaceDAO to null.");
 		}
	 	this.storageSpaceDAO = storageSpaceDAO;
 	}
 	public StorageSpaceDAO getStorageSpaceDAO(){
 		if(this.storageSpaceDAO == null){
 			throw new IllegalStateException("The storageSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.storageSpaceDAO;
 	}	

	protected SmartPalletDAO smartPalletDAO;
	public void setSmartPalletDAO(SmartPalletDAO smartPalletDAO){
 	
 		if(smartPalletDAO == null){
 			throw new IllegalStateException("Do not try to set smartPalletDAO to null.");
 		}
	 	this.smartPalletDAO = smartPalletDAO;
 	}
 	public SmartPalletDAO getSmartPalletDAO(){
 		if(this.smartPalletDAO == null){
 			throw new IllegalStateException("The smartPalletDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.smartPalletDAO;
 	}	

	protected SupplierSpaceDAO supplierSpaceDAO;
	public void setSupplierSpaceDAO(SupplierSpaceDAO supplierSpaceDAO){
 	
 		if(supplierSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set supplierSpaceDAO to null.");
 		}
	 	this.supplierSpaceDAO = supplierSpaceDAO;
 	}
 	public SupplierSpaceDAO getSupplierSpaceDAO(){
 		if(this.supplierSpaceDAO == null){
 			throw new IllegalStateException("The supplierSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplierSpaceDAO;
 	}	

	protected ReceivingSpaceDAO receivingSpaceDAO;
	public void setReceivingSpaceDAO(ReceivingSpaceDAO receivingSpaceDAO){
 	
 		if(receivingSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set receivingSpaceDAO to null.");
 		}
	 	this.receivingSpaceDAO = receivingSpaceDAO;
 	}
 	public ReceivingSpaceDAO getReceivingSpaceDAO(){
 		if(this.receivingSpaceDAO == null){
 			throw new IllegalStateException("The receivingSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.receivingSpaceDAO;
 	}	

	protected ShippingSpaceDAO shippingSpaceDAO;
	public void setShippingSpaceDAO(ShippingSpaceDAO shippingSpaceDAO){
 	
 		if(shippingSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set shippingSpaceDAO to null.");
 		}
	 	this.shippingSpaceDAO = shippingSpaceDAO;
 	}
 	public ShippingSpaceDAO getShippingSpaceDAO(){
 		if(this.shippingSpaceDAO == null){
 			throw new IllegalStateException("The shippingSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingSpaceDAO;
 	}	

	protected DamageSpaceDAO damageSpaceDAO;
	public void setDamageSpaceDAO(DamageSpaceDAO damageSpaceDAO){
 	
 		if(damageSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set damageSpaceDAO to null.");
 		}
	 	this.damageSpaceDAO = damageSpaceDAO;
 	}
 	public DamageSpaceDAO getDamageSpaceDAO(){
 		if(this.damageSpaceDAO == null){
 			throw new IllegalStateException("The damageSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.damageSpaceDAO;
 	}	

	protected WarehouseAssetDAO warehouseAssetDAO;
	public void setWarehouseAssetDAO(WarehouseAssetDAO warehouseAssetDAO){
 	
 		if(warehouseAssetDAO == null){
 			throw new IllegalStateException("Do not try to set warehouseAssetDAO to null.");
 		}
	 	this.warehouseAssetDAO = warehouseAssetDAO;
 	}
 	public WarehouseAssetDAO getWarehouseAssetDAO(){
 		if(this.warehouseAssetDAO == null){
 			throw new IllegalStateException("The warehouseAssetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.warehouseAssetDAO;
 	}	

	
	/*
	protected Warehouse load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWarehouse(accessKey, options);
	}
	*/
	
	public SmartList<Warehouse> loadAll() {
	    return this.loadAll(getWarehouseMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Warehouse load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWarehouse(WarehouseTable.withId(id), options);
	}
	
	
	
	public Warehouse save(Warehouse warehouse,Map<String,Object> options){
		
		String methodName="save(Warehouse warehouse,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(warehouse, methodName, "warehouse");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalWarehouse(warehouse,options);
	}
	public Warehouse clone(String warehouseId, Map<String,Object> options) throws Exception{
	
		return clone(WarehouseTable.withId(warehouseId),options);
	}
	
	protected Warehouse clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String warehouseId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Warehouse newWarehouse = loadInternalWarehouse(accessKey, options);
		newWarehouse.setVersion(0);
		
		
 		
 		if(isSaveStorageSpaceListEnabled(options)){
 			for(StorageSpace item: newWarehouse.getStorageSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSmartPalletListEnabled(options)){
 			for(SmartPallet item: newWarehouse.getSmartPalletList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplierSpaceListEnabled(options)){
 			for(SupplierSpace item: newWarehouse.getSupplierSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveReceivingSpaceListEnabled(options)){
 			for(ReceivingSpace item: newWarehouse.getReceivingSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveShippingSpaceListEnabled(options)){
 			for(ShippingSpace item: newWarehouse.getShippingSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveDamageSpaceListEnabled(options)){
 			for(DamageSpace item: newWarehouse.getDamageSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveWarehouseAssetListEnabled(options)){
 			for(WarehouseAsset item: newWarehouse.getWarehouseAssetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalWarehouse(newWarehouse,options);
		
		return newWarehouse;
	}
	
	
	
	

	protected void throwIfHasException(String warehouseId,int version,int count) throws Exception{
		if (count == 1) {
			throw new WarehouseVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WarehouseNotFoundException(
					"The " + this.getTableName() + "(" + warehouseId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String warehouseId, int version) throws Exception{
	
		String methodName="delete(String warehouseId, int version)";
		assertMethodArgumentNotNull(warehouseId, methodName, "warehouseId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{warehouseId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(warehouseId,version);
		}
		
	
	}
	
	
	
	
	

	public Warehouse disconnectFromAll(String warehouseId, int version) throws Exception{
	
		
		Warehouse warehouse = loadInternalWarehouse(WarehouseTable.withId(warehouseId), emptyOptions());
		warehouse.clearFromAll();
		this.saveWarehouse(warehouse);
		return warehouse;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return WarehouseTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "warehouse";
	}
	@Override
	protected String getBeanName() {
		
		return "warehouse";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return WarehouseTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, WarehouseTokens.OWNER);
 	}

 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, WarehouseTokens.OWNER);
 	}
 	

 	
 
		
	
	protected boolean isExtractStorageSpaceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WarehouseTokens.STORAGE_SPACE_LIST);
 	}
 	protected boolean isAnalyzeStorageSpaceListEnabled(Map<String,Object> options){		 		
 		return WarehouseTokens.of(options).analyzeStorageSpaceListEnabled();
 	}
	
	protected boolean isSaveStorageSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.STORAGE_SPACE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractSmartPalletListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WarehouseTokens.SMART_PALLET_LIST);
 	}
 	protected boolean isAnalyzeSmartPalletListEnabled(Map<String,Object> options){		 		
 		return WarehouseTokens.of(options).analyzeSmartPalletListEnabled();
 	}
	
	protected boolean isSaveSmartPalletListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.SMART_PALLET_LIST);
		
 	}
 	
		
	
	protected boolean isExtractSupplierSpaceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WarehouseTokens.SUPPLIER_SPACE_LIST);
 	}
 	protected boolean isAnalyzeSupplierSpaceListEnabled(Map<String,Object> options){		 		
 		return WarehouseTokens.of(options).analyzeSupplierSpaceListEnabled();
 	}
	
	protected boolean isSaveSupplierSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.SUPPLIER_SPACE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractReceivingSpaceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WarehouseTokens.RECEIVING_SPACE_LIST);
 	}
 	protected boolean isAnalyzeReceivingSpaceListEnabled(Map<String,Object> options){		 		
 		return WarehouseTokens.of(options).analyzeReceivingSpaceListEnabled();
 	}
	
	protected boolean isSaveReceivingSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.RECEIVING_SPACE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractShippingSpaceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WarehouseTokens.SHIPPING_SPACE_LIST);
 	}
 	protected boolean isAnalyzeShippingSpaceListEnabled(Map<String,Object> options){		 		
 		return WarehouseTokens.of(options).analyzeShippingSpaceListEnabled();
 	}
	
	protected boolean isSaveShippingSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.SHIPPING_SPACE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractDamageSpaceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WarehouseTokens.DAMAGE_SPACE_LIST);
 	}
 	protected boolean isAnalyzeDamageSpaceListEnabled(Map<String,Object> options){		 		
 		return WarehouseTokens.of(options).analyzeDamageSpaceListEnabled();
 	}
	
	protected boolean isSaveDamageSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.DAMAGE_SPACE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractWarehouseAssetListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WarehouseTokens.WAREHOUSE_ASSET_LIST);
 	}
 	protected boolean isAnalyzeWarehouseAssetListEnabled(Map<String,Object> options){		 		
 		return WarehouseTokens.of(options).analyzeWarehouseAssetListEnabled();
 	}
	
	protected boolean isSaveWarehouseAssetListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.WAREHOUSE_ASSET_LIST);
		
 	}
 	
		

	

	protected WarehouseMapper getWarehouseMapper(){
		return new WarehouseMapper();
	}

	
	
	protected Warehouse extractWarehouse(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Warehouse warehouse = loadSingleObject(accessKey, getWarehouseMapper());
			return warehouse;
		}catch(EmptyResultDataAccessException e){
			throw new WarehouseNotFoundException("Warehouse("+accessKey+") is not found!");
		}

	}

	
	

	protected Warehouse loadInternalWarehouse(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Warehouse warehouse = extractWarehouse(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(warehouse, loadOptions);
 		}
 
		
		if(isExtractStorageSpaceListEnabled(loadOptions)){
	 		extractStorageSpaceList(warehouse, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeStorageSpaceListEnabled(loadOptions)){
	 		analyzeStorageSpaceList(warehouse, loadOptions);
 		}
 		
		
		if(isExtractSmartPalletListEnabled(loadOptions)){
	 		extractSmartPalletList(warehouse, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeSmartPalletListEnabled(loadOptions)){
	 		analyzeSmartPalletList(warehouse, loadOptions);
 		}
 		
		
		if(isExtractSupplierSpaceListEnabled(loadOptions)){
	 		extractSupplierSpaceList(warehouse, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeSupplierSpaceListEnabled(loadOptions)){
	 		analyzeSupplierSpaceList(warehouse, loadOptions);
 		}
 		
		
		if(isExtractReceivingSpaceListEnabled(loadOptions)){
	 		extractReceivingSpaceList(warehouse, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeReceivingSpaceListEnabled(loadOptions)){
	 		analyzeReceivingSpaceList(warehouse, loadOptions);
 		}
 		
		
		if(isExtractShippingSpaceListEnabled(loadOptions)){
	 		extractShippingSpaceList(warehouse, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeShippingSpaceListEnabled(loadOptions)){
	 		analyzeShippingSpaceList(warehouse, loadOptions);
 		}
 		
		
		if(isExtractDamageSpaceListEnabled(loadOptions)){
	 		extractDamageSpaceList(warehouse, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeDamageSpaceListEnabled(loadOptions)){
	 		analyzeDamageSpaceList(warehouse, loadOptions);
 		}
 		
		
		if(isExtractWarehouseAssetListEnabled(loadOptions)){
	 		extractWarehouseAssetList(warehouse, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeWarehouseAssetListEnabled(loadOptions)){
	 		analyzeWarehouseAssetList(warehouse, loadOptions);
 		}
 		
		
		return warehouse;
		
	}

	 

 	protected Warehouse extractOwner(Warehouse warehouse, Map<String,Object> options) throws Exception{

		if(warehouse.getOwner() == null){
			return warehouse;
		}
		String ownerId = warehouse.getOwner().getId();
		if( ownerId == null){
			return warehouse;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			warehouse.setOwner(owner);
		}
		
 		
 		return warehouse;
 	}
 		
 
		
	protected void enhanceStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Warehouse extractStorageSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<StorageSpace> storageSpaceList = getStorageSpaceDAO().findStorageSpaceByWarehouse(warehouse.getId(),options);
		if(storageSpaceList != null){
			enhanceStorageSpaceList(storageSpaceList,options);
			warehouse.setStorageSpaceList(storageSpaceList);
		}
		
		return warehouse;
	
	}	
	
	protected Warehouse analyzeStorageSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();
		if(storageSpaceList != null){
			getStorageSpaceDAO().analyzeStorageSpaceByWarehouse(storageSpaceList, warehouse.getId(), options);
			
		}
		
		return warehouse;
	
	}	
	
		
	protected void enhanceSmartPalletList(SmartList<SmartPallet> smartPalletList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Warehouse extractSmartPalletList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<SmartPallet> smartPalletList = getSmartPalletDAO().findSmartPalletByWarehouse(warehouse.getId(),options);
		if(smartPalletList != null){
			enhanceSmartPalletList(smartPalletList,options);
			warehouse.setSmartPalletList(smartPalletList);
		}
		
		return warehouse;
	
	}	
	
	protected Warehouse analyzeSmartPalletList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<SmartPallet> smartPalletList = warehouse.getSmartPalletList();
		if(smartPalletList != null){
			getSmartPalletDAO().analyzeSmartPalletByWarehouse(smartPalletList, warehouse.getId(), options);
			
		}
		
		return warehouse;
	
	}	
	
		
	protected void enhanceSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Warehouse extractSupplierSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<SupplierSpace> supplierSpaceList = getSupplierSpaceDAO().findSupplierSpaceByWarehouse(warehouse.getId(),options);
		if(supplierSpaceList != null){
			enhanceSupplierSpaceList(supplierSpaceList,options);
			warehouse.setSupplierSpaceList(supplierSpaceList);
		}
		
		return warehouse;
	
	}	
	
	protected Warehouse analyzeSupplierSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();
		if(supplierSpaceList != null){
			getSupplierSpaceDAO().analyzeSupplierSpaceByWarehouse(supplierSpaceList, warehouse.getId(), options);
			
		}
		
		return warehouse;
	
	}	
	
		
	protected void enhanceReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Warehouse extractReceivingSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<ReceivingSpace> receivingSpaceList = getReceivingSpaceDAO().findReceivingSpaceByWarehouse(warehouse.getId(),options);
		if(receivingSpaceList != null){
			enhanceReceivingSpaceList(receivingSpaceList,options);
			warehouse.setReceivingSpaceList(receivingSpaceList);
		}
		
		return warehouse;
	
	}	
	
	protected Warehouse analyzeReceivingSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();
		if(receivingSpaceList != null){
			getReceivingSpaceDAO().analyzeReceivingSpaceByWarehouse(receivingSpaceList, warehouse.getId(), options);
			
		}
		
		return warehouse;
	
	}	
	
		
	protected void enhanceShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Warehouse extractShippingSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<ShippingSpace> shippingSpaceList = getShippingSpaceDAO().findShippingSpaceByWarehouse(warehouse.getId(),options);
		if(shippingSpaceList != null){
			enhanceShippingSpaceList(shippingSpaceList,options);
			warehouse.setShippingSpaceList(shippingSpaceList);
		}
		
		return warehouse;
	
	}	
	
	protected Warehouse analyzeShippingSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();
		if(shippingSpaceList != null){
			getShippingSpaceDAO().analyzeShippingSpaceByWarehouse(shippingSpaceList, warehouse.getId(), options);
			
		}
		
		return warehouse;
	
	}	
	
		
	protected void enhanceDamageSpaceList(SmartList<DamageSpace> damageSpaceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Warehouse extractDamageSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<DamageSpace> damageSpaceList = getDamageSpaceDAO().findDamageSpaceByWarehouse(warehouse.getId(),options);
		if(damageSpaceList != null){
			enhanceDamageSpaceList(damageSpaceList,options);
			warehouse.setDamageSpaceList(damageSpaceList);
		}
		
		return warehouse;
	
	}	
	
	protected Warehouse analyzeDamageSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();
		if(damageSpaceList != null){
			getDamageSpaceDAO().analyzeDamageSpaceByWarehouse(damageSpaceList, warehouse.getId(), options);
			
		}
		
		return warehouse;
	
	}	
	
		
	protected void enhanceWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Warehouse extractWarehouseAssetList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<WarehouseAsset> warehouseAssetList = getWarehouseAssetDAO().findWarehouseAssetByOwner(warehouse.getId(),options);
		if(warehouseAssetList != null){
			enhanceWarehouseAssetList(warehouseAssetList,options);
			warehouse.setWarehouseAssetList(warehouseAssetList);
		}
		
		return warehouse;
	
	}	
	
	protected Warehouse analyzeWarehouseAssetList(Warehouse warehouse, Map<String,Object> options){
		
		
		if(warehouse == null){
			return null;
		}
		if(warehouse.getId() == null){
			return warehouse;
		}

		
		
		SmartList<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();
		if(warehouseAssetList != null){
			getWarehouseAssetDAO().analyzeWarehouseAssetByOwner(warehouseAssetList, warehouse.getId(), options);
			
		}
		
		return warehouse;
	
	}	
	
		
		
  	
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<Warehouse> resultList = queryWith(WarehouseTable.COLUMN_OWNER, retailStoreCountryCenterId, options, getWarehouseMapper());
		// analyzeWarehouseByOwner(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Warehouse> resultList =  queryWithRange(WarehouseTable.COLUMN_OWNER, retailStoreCountryCenterId, options, getWarehouseMapper(), start, count);
 		//analyzeWarehouseByOwner(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeWarehouseByOwner(SmartList<Warehouse> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Warehouse.OWNER_PROPERTY, retailStoreCountryCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//Warehouse.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("仓库");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(Warehouse.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Warehouse.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countWarehouseByOwner(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(WarehouseTable.COLUMN_OWNER, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countWarehouseByOwnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(WarehouseTable.COLUMN_OWNER, ids, options);
	}
 	
 	
		
		
		

	

	protected Warehouse saveWarehouse(Warehouse  warehouse){
		
		if(!warehouse.isChanged()){
			return warehouse;
		}
		
		
		String SQL=this.getSaveWarehouseSQL(warehouse);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWarehouseParameters(warehouse);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		warehouse.incVersion();
		return warehouse;
	
	}
	public SmartList<Warehouse> saveWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWarehouseList(warehouseList);
		
		batchWarehouseCreate((List<Warehouse>)lists[CREATE_LIST_INDEX]);
		
		batchWarehouseUpdate((List<Warehouse>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Warehouse warehouse:warehouseList){
			if(warehouse.isChanged()){
				warehouse.incVersion();
			}
			
		
		}
		
		
		return warehouseList;
	}

	public SmartList<Warehouse> removeWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options){
		
		
		super.removeList(warehouseList, options);
		
		return warehouseList;
		
		
	}
	
	protected List<Object[]> prepareWarehouseBatchCreateArgs(List<Warehouse> warehouseList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Warehouse warehouse:warehouseList ){
			Object [] parameters = prepareWarehouseCreateParameters(warehouse);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareWarehouseBatchUpdateArgs(List<Warehouse> warehouseList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Warehouse warehouse:warehouseList ){
			if(!warehouse.isChanged()){
				continue;
			}
			Object [] parameters = prepareWarehouseUpdateParameters(warehouse);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchWarehouseCreate(List<Warehouse> warehouseList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWarehouseBatchCreateArgs(warehouseList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchWarehouseUpdate(List<Warehouse> warehouseList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWarehouseBatchUpdateArgs(warehouseList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitWarehouseList(List<Warehouse> warehouseList){
		
		List<Warehouse> warehouseCreateList=new ArrayList<Warehouse>();
		List<Warehouse> warehouseUpdateList=new ArrayList<Warehouse>();
		
		for(Warehouse warehouse: warehouseList){
			if(isUpdateRequest(warehouse)){
				warehouseUpdateList.add( warehouse);
				continue;
			}
			warehouseCreateList.add(warehouse);
		}
		
		return new Object[]{warehouseCreateList,warehouseUpdateList};
	}
	
	protected boolean isUpdateRequest(Warehouse warehouse){
 		return warehouse.getVersion() > 0;
 	}
 	protected String getSaveWarehouseSQL(Warehouse warehouse){
 		if(isUpdateRequest(warehouse)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveWarehouseParameters(Warehouse warehouse){
 		if(isUpdateRequest(warehouse) ){
 			return prepareWarehouseUpdateParameters(warehouse);
 		}
 		return prepareWarehouseCreateParameters(warehouse);
 	}
 	protected Object[] prepareWarehouseUpdateParameters(Warehouse warehouse){
 		Object[] parameters = new Object[10];
 
 		
 		parameters[0] = warehouse.getLocation();
 		
 		
 		parameters[1] = warehouse.getContactNumber();
 		
 		
 		parameters[2] = warehouse.getTotalArea();
 		 	
 		if(warehouse.getOwner() != null){
 			parameters[3] = warehouse.getOwner().getId();
 		}
 
 		
 		parameters[4] = warehouse.getLatitude();
 		
 		
 		parameters[5] = warehouse.getLongitude();
 		
 		
 		parameters[6] = warehouse.getLastUpdateTime();
 				
 		parameters[7] = warehouse.nextVersion();
 		parameters[8] = warehouse.getId();
 		parameters[9] = warehouse.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareWarehouseCreateParameters(Warehouse warehouse){
		Object[] parameters = new Object[8];
		String newWarehouseId=getNextId();
		warehouse.setId(newWarehouseId);
		parameters[0] =  warehouse.getId();
 
 		
 		parameters[1] = warehouse.getLocation();
 		
 		
 		parameters[2] = warehouse.getContactNumber();
 		
 		
 		parameters[3] = warehouse.getTotalArea();
 		 	
 		if(warehouse.getOwner() != null){
 			parameters[4] = warehouse.getOwner().getId();
 		
 		}
 		
 		
 		parameters[5] = warehouse.getLatitude();
 		
 		
 		parameters[6] = warehouse.getLongitude();
 		
 		
 		parameters[7] = warehouse.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected Warehouse saveInternalWarehouse(Warehouse warehouse, Map<String,Object> options){
		
		saveWarehouse(warehouse);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(warehouse, options);
 		}
 
		
		if(isSaveStorageSpaceListEnabled(options)){
	 		saveStorageSpaceList(warehouse, options);
	 		//removeStorageSpaceList(warehouse, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSmartPalletListEnabled(options)){
	 		saveSmartPalletList(warehouse, options);
	 		//removeSmartPalletList(warehouse, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveSupplierSpaceListEnabled(options)){
	 		saveSupplierSpaceList(warehouse, options);
	 		//removeSupplierSpaceList(warehouse, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveReceivingSpaceListEnabled(options)){
	 		saveReceivingSpaceList(warehouse, options);
	 		//removeReceivingSpaceList(warehouse, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveShippingSpaceListEnabled(options)){
	 		saveShippingSpaceList(warehouse, options);
	 		//removeShippingSpaceList(warehouse, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveDamageSpaceListEnabled(options)){
	 		saveDamageSpaceList(warehouse, options);
	 		//removeDamageSpaceList(warehouse, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveWarehouseAssetListEnabled(options)){
	 		saveWarehouseAssetList(warehouse, options);
	 		//removeWarehouseAssetList(warehouse, options);
	 		//Not delete the record
	 		
 		}		
		
		return warehouse;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Warehouse saveOwner(Warehouse warehouse, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(warehouse.getOwner() == null){
 			return warehouse;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(warehouse.getOwner(),options);
 		return warehouse;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Warehouse planToRemoveStorageSpaceList(Warehouse warehouse, String storageSpaceIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StorageSpace.WAREHOUSE_PROPERTY, warehouse.getId());
		key.put(StorageSpace.ID_PROPERTY, storageSpaceIds);
		
		SmartList<StorageSpace> externalStorageSpaceList = getStorageSpaceDAO().
				findStorageSpaceWithKey(key, options);
		if(externalStorageSpaceList == null){
			return warehouse;
		}
		if(externalStorageSpaceList.isEmpty()){
			return warehouse;
		}
		
		for(StorageSpace storageSpaceItem: externalStorageSpaceList){

			storageSpaceItem.clearFromAll();
		}
		
		
		SmartList<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();		
		storageSpaceList.addAllToRemoveList(externalStorageSpaceList);
		return warehouse;	
	
	}


	public Warehouse planToRemoveSmartPalletList(Warehouse warehouse, String smartPalletIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SmartPallet.WAREHOUSE_PROPERTY, warehouse.getId());
		key.put(SmartPallet.ID_PROPERTY, smartPalletIds);
		
		SmartList<SmartPallet> externalSmartPalletList = getSmartPalletDAO().
				findSmartPalletWithKey(key, options);
		if(externalSmartPalletList == null){
			return warehouse;
		}
		if(externalSmartPalletList.isEmpty()){
			return warehouse;
		}
		
		for(SmartPallet smartPalletItem: externalSmartPalletList){

			smartPalletItem.clearFromAll();
		}
		
		
		SmartList<SmartPallet> smartPalletList = warehouse.getSmartPalletList();		
		smartPalletList.addAllToRemoveList(externalSmartPalletList);
		return warehouse;	
	
	}


	public Warehouse planToRemoveSupplierSpaceList(Warehouse warehouse, String supplierSpaceIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplierSpace.WAREHOUSE_PROPERTY, warehouse.getId());
		key.put(SupplierSpace.ID_PROPERTY, supplierSpaceIds);
		
		SmartList<SupplierSpace> externalSupplierSpaceList = getSupplierSpaceDAO().
				findSupplierSpaceWithKey(key, options);
		if(externalSupplierSpaceList == null){
			return warehouse;
		}
		if(externalSupplierSpaceList.isEmpty()){
			return warehouse;
		}
		
		for(SupplierSpace supplierSpaceItem: externalSupplierSpaceList){

			supplierSpaceItem.clearFromAll();
		}
		
		
		SmartList<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();		
		supplierSpaceList.addAllToRemoveList(externalSupplierSpaceList);
		return warehouse;	
	
	}


	public Warehouse planToRemoveReceivingSpaceList(Warehouse warehouse, String receivingSpaceIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ReceivingSpace.WAREHOUSE_PROPERTY, warehouse.getId());
		key.put(ReceivingSpace.ID_PROPERTY, receivingSpaceIds);
		
		SmartList<ReceivingSpace> externalReceivingSpaceList = getReceivingSpaceDAO().
				findReceivingSpaceWithKey(key, options);
		if(externalReceivingSpaceList == null){
			return warehouse;
		}
		if(externalReceivingSpaceList.isEmpty()){
			return warehouse;
		}
		
		for(ReceivingSpace receivingSpaceItem: externalReceivingSpaceList){

			receivingSpaceItem.clearFromAll();
		}
		
		
		SmartList<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();		
		receivingSpaceList.addAllToRemoveList(externalReceivingSpaceList);
		return warehouse;	
	
	}


	public Warehouse planToRemoveShippingSpaceList(Warehouse warehouse, String shippingSpaceIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ShippingSpace.WAREHOUSE_PROPERTY, warehouse.getId());
		key.put(ShippingSpace.ID_PROPERTY, shippingSpaceIds);
		
		SmartList<ShippingSpace> externalShippingSpaceList = getShippingSpaceDAO().
				findShippingSpaceWithKey(key, options);
		if(externalShippingSpaceList == null){
			return warehouse;
		}
		if(externalShippingSpaceList.isEmpty()){
			return warehouse;
		}
		
		for(ShippingSpace shippingSpaceItem: externalShippingSpaceList){

			shippingSpaceItem.clearFromAll();
		}
		
		
		SmartList<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();		
		shippingSpaceList.addAllToRemoveList(externalShippingSpaceList);
		return warehouse;	
	
	}


	public Warehouse planToRemoveDamageSpaceList(Warehouse warehouse, String damageSpaceIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DamageSpace.WAREHOUSE_PROPERTY, warehouse.getId());
		key.put(DamageSpace.ID_PROPERTY, damageSpaceIds);
		
		SmartList<DamageSpace> externalDamageSpaceList = getDamageSpaceDAO().
				findDamageSpaceWithKey(key, options);
		if(externalDamageSpaceList == null){
			return warehouse;
		}
		if(externalDamageSpaceList.isEmpty()){
			return warehouse;
		}
		
		for(DamageSpace damageSpaceItem: externalDamageSpaceList){

			damageSpaceItem.clearFromAll();
		}
		
		
		SmartList<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();		
		damageSpaceList.addAllToRemoveList(externalDamageSpaceList);
		return warehouse;	
	
	}


	public Warehouse planToRemoveWarehouseAssetList(Warehouse warehouse, String warehouseAssetIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WarehouseAsset.OWNER_PROPERTY, warehouse.getId());
		key.put(WarehouseAsset.ID_PROPERTY, warehouseAssetIds);
		
		SmartList<WarehouseAsset> externalWarehouseAssetList = getWarehouseAssetDAO().
				findWarehouseAssetWithKey(key, options);
		if(externalWarehouseAssetList == null){
			return warehouse;
		}
		if(externalWarehouseAssetList.isEmpty()){
			return warehouse;
		}
		
		for(WarehouseAsset warehouseAssetItem: externalWarehouseAssetList){

			warehouseAssetItem.clearFromAll();
		}
		
		
		SmartList<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();		
		warehouseAssetList.addAllToRemoveList(externalWarehouseAssetList);
		return warehouse;	
	
	}



		
	protected Warehouse saveStorageSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		
		
		SmartList<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();
		if(storageSpaceList == null){
			//null list means nothing
			return warehouse;
		}
		SmartList<StorageSpace> mergedUpdateStorageSpaceList = new SmartList<StorageSpace>();
		
		
		mergedUpdateStorageSpaceList.addAll(storageSpaceList); 
		if(storageSpaceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateStorageSpaceList.addAll(storageSpaceList.getToRemoveList());
			storageSpaceList.removeAll(storageSpaceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getStorageSpaceDAO().saveStorageSpaceList(mergedUpdateStorageSpaceList,options);
		
		if(storageSpaceList.getToRemoveList() != null){
			storageSpaceList.removeAll(storageSpaceList.getToRemoveList());
		}
		
		
		return warehouse;
	
	}
	
	protected Warehouse removeStorageSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();
		if(storageSpaceList == null){
			return warehouse;
		}	
	
		SmartList<StorageSpace> toRemoveStorageSpaceList = storageSpaceList.getToRemoveList();
		
		if(toRemoveStorageSpaceList == null){
			return warehouse;
		}
		if(toRemoveStorageSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getStorageSpaceDAO().removeStorageSpaceList(toRemoveStorageSpaceList,options);
		
		return warehouse;
	
	}
	
	

 	
 	
	
	
	
		
	protected Warehouse saveSmartPalletList(Warehouse warehouse, Map<String,Object> options){
		
		
		
		
		SmartList<SmartPallet> smartPalletList = warehouse.getSmartPalletList();
		if(smartPalletList == null){
			//null list means nothing
			return warehouse;
		}
		SmartList<SmartPallet> mergedUpdateSmartPalletList = new SmartList<SmartPallet>();
		
		
		mergedUpdateSmartPalletList.addAll(smartPalletList); 
		if(smartPalletList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSmartPalletList.addAll(smartPalletList.getToRemoveList());
			smartPalletList.removeAll(smartPalletList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSmartPalletDAO().saveSmartPalletList(mergedUpdateSmartPalletList,options);
		
		if(smartPalletList.getToRemoveList() != null){
			smartPalletList.removeAll(smartPalletList.getToRemoveList());
		}
		
		
		return warehouse;
	
	}
	
	protected Warehouse removeSmartPalletList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<SmartPallet> smartPalletList = warehouse.getSmartPalletList();
		if(smartPalletList == null){
			return warehouse;
		}	
	
		SmartList<SmartPallet> toRemoveSmartPalletList = smartPalletList.getToRemoveList();
		
		if(toRemoveSmartPalletList == null){
			return warehouse;
		}
		if(toRemoveSmartPalletList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSmartPalletDAO().removeSmartPalletList(toRemoveSmartPalletList,options);
		
		return warehouse;
	
	}
	
	

 	
 	
	
	
	
		
	protected Warehouse saveSupplierSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		
		
		SmartList<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();
		if(supplierSpaceList == null){
			//null list means nothing
			return warehouse;
		}
		SmartList<SupplierSpace> mergedUpdateSupplierSpaceList = new SmartList<SupplierSpace>();
		
		
		mergedUpdateSupplierSpaceList.addAll(supplierSpaceList); 
		if(supplierSpaceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSupplierSpaceList.addAll(supplierSpaceList.getToRemoveList());
			supplierSpaceList.removeAll(supplierSpaceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getSupplierSpaceDAO().saveSupplierSpaceList(mergedUpdateSupplierSpaceList,options);
		
		if(supplierSpaceList.getToRemoveList() != null){
			supplierSpaceList.removeAll(supplierSpaceList.getToRemoveList());
		}
		
		
		return warehouse;
	
	}
	
	protected Warehouse removeSupplierSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();
		if(supplierSpaceList == null){
			return warehouse;
		}	
	
		SmartList<SupplierSpace> toRemoveSupplierSpaceList = supplierSpaceList.getToRemoveList();
		
		if(toRemoveSupplierSpaceList == null){
			return warehouse;
		}
		if(toRemoveSupplierSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplierSpaceDAO().removeSupplierSpaceList(toRemoveSupplierSpaceList,options);
		
		return warehouse;
	
	}
	
	

 	
 	
	
	
	
		
	protected Warehouse saveReceivingSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		
		
		SmartList<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();
		if(receivingSpaceList == null){
			//null list means nothing
			return warehouse;
		}
		SmartList<ReceivingSpace> mergedUpdateReceivingSpaceList = new SmartList<ReceivingSpace>();
		
		
		mergedUpdateReceivingSpaceList.addAll(receivingSpaceList); 
		if(receivingSpaceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateReceivingSpaceList.addAll(receivingSpaceList.getToRemoveList());
			receivingSpaceList.removeAll(receivingSpaceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getReceivingSpaceDAO().saveReceivingSpaceList(mergedUpdateReceivingSpaceList,options);
		
		if(receivingSpaceList.getToRemoveList() != null){
			receivingSpaceList.removeAll(receivingSpaceList.getToRemoveList());
		}
		
		
		return warehouse;
	
	}
	
	protected Warehouse removeReceivingSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();
		if(receivingSpaceList == null){
			return warehouse;
		}	
	
		SmartList<ReceivingSpace> toRemoveReceivingSpaceList = receivingSpaceList.getToRemoveList();
		
		if(toRemoveReceivingSpaceList == null){
			return warehouse;
		}
		if(toRemoveReceivingSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getReceivingSpaceDAO().removeReceivingSpaceList(toRemoveReceivingSpaceList,options);
		
		return warehouse;
	
	}
	
	

 	
 	
	
	
	
		
	protected Warehouse saveShippingSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		
		
		SmartList<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();
		if(shippingSpaceList == null){
			//null list means nothing
			return warehouse;
		}
		SmartList<ShippingSpace> mergedUpdateShippingSpaceList = new SmartList<ShippingSpace>();
		
		
		mergedUpdateShippingSpaceList.addAll(shippingSpaceList); 
		if(shippingSpaceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateShippingSpaceList.addAll(shippingSpaceList.getToRemoveList());
			shippingSpaceList.removeAll(shippingSpaceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getShippingSpaceDAO().saveShippingSpaceList(mergedUpdateShippingSpaceList,options);
		
		if(shippingSpaceList.getToRemoveList() != null){
			shippingSpaceList.removeAll(shippingSpaceList.getToRemoveList());
		}
		
		
		return warehouse;
	
	}
	
	protected Warehouse removeShippingSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();
		if(shippingSpaceList == null){
			return warehouse;
		}	
	
		SmartList<ShippingSpace> toRemoveShippingSpaceList = shippingSpaceList.getToRemoveList();
		
		if(toRemoveShippingSpaceList == null){
			return warehouse;
		}
		if(toRemoveShippingSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getShippingSpaceDAO().removeShippingSpaceList(toRemoveShippingSpaceList,options);
		
		return warehouse;
	
	}
	
	

 	
 	
	
	
	
		
	protected Warehouse saveDamageSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		
		
		
		SmartList<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();
		if(damageSpaceList == null){
			//null list means nothing
			return warehouse;
		}
		SmartList<DamageSpace> mergedUpdateDamageSpaceList = new SmartList<DamageSpace>();
		
		
		mergedUpdateDamageSpaceList.addAll(damageSpaceList); 
		if(damageSpaceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateDamageSpaceList.addAll(damageSpaceList.getToRemoveList());
			damageSpaceList.removeAll(damageSpaceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getDamageSpaceDAO().saveDamageSpaceList(mergedUpdateDamageSpaceList,options);
		
		if(damageSpaceList.getToRemoveList() != null){
			damageSpaceList.removeAll(damageSpaceList.getToRemoveList());
		}
		
		
		return warehouse;
	
	}
	
	protected Warehouse removeDamageSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();
		if(damageSpaceList == null){
			return warehouse;
		}	
	
		SmartList<DamageSpace> toRemoveDamageSpaceList = damageSpaceList.getToRemoveList();
		
		if(toRemoveDamageSpaceList == null){
			return warehouse;
		}
		if(toRemoveDamageSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDamageSpaceDAO().removeDamageSpaceList(toRemoveDamageSpaceList,options);
		
		return warehouse;
	
	}
	
	

 	
 	
	
	
	
		
	protected Warehouse saveWarehouseAssetList(Warehouse warehouse, Map<String,Object> options){
		
		
		
		
		SmartList<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();
		if(warehouseAssetList == null){
			//null list means nothing
			return warehouse;
		}
		SmartList<WarehouseAsset> mergedUpdateWarehouseAssetList = new SmartList<WarehouseAsset>();
		
		
		mergedUpdateWarehouseAssetList.addAll(warehouseAssetList); 
		if(warehouseAssetList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateWarehouseAssetList.addAll(warehouseAssetList.getToRemoveList());
			warehouseAssetList.removeAll(warehouseAssetList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getWarehouseAssetDAO().saveWarehouseAssetList(mergedUpdateWarehouseAssetList,options);
		
		if(warehouseAssetList.getToRemoveList() != null){
			warehouseAssetList.removeAll(warehouseAssetList.getToRemoveList());
		}
		
		
		return warehouse;
	
	}
	
	protected Warehouse removeWarehouseAssetList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();
		if(warehouseAssetList == null){
			return warehouse;
		}	
	
		SmartList<WarehouseAsset> toRemoveWarehouseAssetList = warehouseAssetList.getToRemoveList();
		
		if(toRemoveWarehouseAssetList == null){
			return warehouse;
		}
		if(toRemoveWarehouseAssetList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getWarehouseAssetDAO().removeWarehouseAssetList(toRemoveWarehouseAssetList,options);
		
		return warehouse;
	
	}
	
	

 	
 	
	
	
	
		

	public Warehouse present(Warehouse warehouse,Map<String, Object> options){
	
		presentStorageSpaceList(warehouse,options);
		presentSmartPalletList(warehouse,options);
		presentSupplierSpaceList(warehouse,options);
		presentReceivingSpaceList(warehouse,options);
		presentShippingSpaceList(warehouse,options);
		presentDamageSpaceList(warehouse,options);
		presentWarehouseAssetList(warehouse,options);

		return warehouse;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Warehouse presentStorageSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();		
				SmartList<StorageSpace> newList= presentSubList(warehouse.getId(),
				storageSpaceList,
				options,
				getStorageSpaceDAO()::countStorageSpaceByWarehouse,
				getStorageSpaceDAO()::findStorageSpaceByWarehouse
				);

		
		warehouse.setStorageSpaceList(newList);
		

		return warehouse;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Warehouse presentSmartPalletList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<SmartPallet> smartPalletList = warehouse.getSmartPalletList();		
				SmartList<SmartPallet> newList= presentSubList(warehouse.getId(),
				smartPalletList,
				options,
				getSmartPalletDAO()::countSmartPalletByWarehouse,
				getSmartPalletDAO()::findSmartPalletByWarehouse
				);

		
		warehouse.setSmartPalletList(newList);
		

		return warehouse;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Warehouse presentSupplierSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();		
				SmartList<SupplierSpace> newList= presentSubList(warehouse.getId(),
				supplierSpaceList,
				options,
				getSupplierSpaceDAO()::countSupplierSpaceByWarehouse,
				getSupplierSpaceDAO()::findSupplierSpaceByWarehouse
				);

		
		warehouse.setSupplierSpaceList(newList);
		

		return warehouse;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Warehouse presentReceivingSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();		
				SmartList<ReceivingSpace> newList= presentSubList(warehouse.getId(),
				receivingSpaceList,
				options,
				getReceivingSpaceDAO()::countReceivingSpaceByWarehouse,
				getReceivingSpaceDAO()::findReceivingSpaceByWarehouse
				);

		
		warehouse.setReceivingSpaceList(newList);
		

		return warehouse;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Warehouse presentShippingSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();		
				SmartList<ShippingSpace> newList= presentSubList(warehouse.getId(),
				shippingSpaceList,
				options,
				getShippingSpaceDAO()::countShippingSpaceByWarehouse,
				getShippingSpaceDAO()::findShippingSpaceByWarehouse
				);

		
		warehouse.setShippingSpaceList(newList);
		

		return warehouse;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Warehouse presentDamageSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();		
				SmartList<DamageSpace> newList= presentSubList(warehouse.getId(),
				damageSpaceList,
				options,
				getDamageSpaceDAO()::countDamageSpaceByWarehouse,
				getDamageSpaceDAO()::findDamageSpaceByWarehouse
				);

		
		warehouse.setDamageSpaceList(newList);
		

		return warehouse;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Warehouse presentWarehouseAssetList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();		
				SmartList<WarehouseAsset> newList= presentSubList(warehouse.getId(),
				warehouseAssetList,
				options,
				getWarehouseAssetDAO()::countWarehouseAssetByOwner,
				getWarehouseAssetDAO()::findWarehouseAssetByOwner
				);

		
		warehouse.setWarehouseAssetList(newList);
		

		return warehouse;
	}			
		

	
    public SmartList<Warehouse> requestCandidateWarehouseForStorageSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WarehouseTable.COLUMN_LOCATION, WarehouseTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getWarehouseMapper());
    }
		
    public SmartList<Warehouse> requestCandidateWarehouseForSmartPallet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WarehouseTable.COLUMN_LOCATION, WarehouseTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getWarehouseMapper());
    }
		
    public SmartList<Warehouse> requestCandidateWarehouseForSupplierSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WarehouseTable.COLUMN_LOCATION, WarehouseTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getWarehouseMapper());
    }
		
    public SmartList<Warehouse> requestCandidateWarehouseForReceivingSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WarehouseTable.COLUMN_LOCATION, WarehouseTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getWarehouseMapper());
    }
		
    public SmartList<Warehouse> requestCandidateWarehouseForShippingSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WarehouseTable.COLUMN_LOCATION, WarehouseTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getWarehouseMapper());
    }
		
    public SmartList<Warehouse> requestCandidateWarehouseForDamageSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WarehouseTable.COLUMN_LOCATION, WarehouseTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getWarehouseMapper());
    }
		
    public SmartList<Warehouse> requestCandidateWarehouseForWarehouseAsset(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WarehouseTable.COLUMN_LOCATION, WarehouseTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getWarehouseMapper());
    }
		

	protected String getTableName(){
		return WarehouseTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Warehouse> warehouseList) {		
		this.enhanceListInternal(warehouseList, this.getWarehouseMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:StorageSpace的warehouse的StorageSpaceList
	public SmartList<StorageSpace> loadOurStorageSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StorageSpace.WAREHOUSE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<StorageSpace> loadedObjs = userContext.getDAOGroup().getStorageSpaceDAO().findStorageSpaceWithKey(key, options);
		Map<String, List<StorageSpace>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getWarehouse().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<StorageSpace> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<StorageSpace> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setStorageSpaceList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:SmartPallet的warehouse的SmartPalletList
	public SmartList<SmartPallet> loadOurSmartPalletList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SmartPallet.WAREHOUSE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SmartPallet> loadedObjs = userContext.getDAOGroup().getSmartPalletDAO().findSmartPalletWithKey(key, options);
		Map<String, List<SmartPallet>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getWarehouse().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SmartPallet> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SmartPallet> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSmartPalletList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:SupplierSpace的warehouse的SupplierSpaceList
	public SmartList<SupplierSpace> loadOurSupplierSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplierSpace.WAREHOUSE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SupplierSpace> loadedObjs = userContext.getDAOGroup().getSupplierSpaceDAO().findSupplierSpaceWithKey(key, options);
		Map<String, List<SupplierSpace>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getWarehouse().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SupplierSpace> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SupplierSpace> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSupplierSpaceList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ReceivingSpace的warehouse的ReceivingSpaceList
	public SmartList<ReceivingSpace> loadOurReceivingSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ReceivingSpace.WAREHOUSE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ReceivingSpace> loadedObjs = userContext.getDAOGroup().getReceivingSpaceDAO().findReceivingSpaceWithKey(key, options);
		Map<String, List<ReceivingSpace>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getWarehouse().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ReceivingSpace> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ReceivingSpace> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setReceivingSpaceList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ShippingSpace的warehouse的ShippingSpaceList
	public SmartList<ShippingSpace> loadOurShippingSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ShippingSpace.WAREHOUSE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ShippingSpace> loadedObjs = userContext.getDAOGroup().getShippingSpaceDAO().findShippingSpaceWithKey(key, options);
		Map<String, List<ShippingSpace>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getWarehouse().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ShippingSpace> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ShippingSpace> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setShippingSpaceList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:DamageSpace的warehouse的DamageSpaceList
	public SmartList<DamageSpace> loadOurDamageSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(DamageSpace.WAREHOUSE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<DamageSpace> loadedObjs = userContext.getDAOGroup().getDamageSpaceDAO().findDamageSpaceWithKey(key, options);
		Map<String, List<DamageSpace>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getWarehouse().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<DamageSpace> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<DamageSpace> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setDamageSpaceList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:WarehouseAsset的owner的WarehouseAssetList
	public SmartList<WarehouseAsset> loadOurWarehouseAssetList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WarehouseAsset.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<WarehouseAsset> loadedObjs = userContext.getDAOGroup().getWarehouseAssetDAO().findWarehouseAssetWithKey(key, options);
		Map<String, List<WarehouseAsset>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<WarehouseAsset> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<WarehouseAsset> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setWarehouseAssetList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Warehouse> warehouseList = ownerEntity.collectRefsWithType(Warehouse.INTERNAL_TYPE);
		this.enhanceList(warehouseList);
		
	}
	
	@Override
	public SmartList<Warehouse> findWarehouseWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getWarehouseMapper());

	}
	@Override
	public int countWarehouseWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countWarehouseWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Warehouse> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getWarehouseMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateWarehouse executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateWarehouse result = new CandidateWarehouse();
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


