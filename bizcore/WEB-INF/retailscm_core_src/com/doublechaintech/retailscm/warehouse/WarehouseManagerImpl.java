
package com.doublechaintech.retailscm.warehouse;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;


import com.doublechaintech.retailscm.Message;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;

import com.doublechaintech.retailscm.RetailscmUserContext;
//import com.doublechaintech.retailscm.BaseManagerImpl;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmCheckerManager;

import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.warehouse.Warehouse;






public class WarehouseManagerImpl extends CustomRetailscmCheckerManager implements WarehouseManager {
	
	private static final String SERVICE_TYPE = "Warehouse";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws WarehouseManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new WarehouseManagerException(message);

	}
	
	

 	protected Warehouse saveWarehouse(RetailscmUserContext userContext, Warehouse warehouse, String [] tokensExpr) throws Exception{	
 		//return getWarehouseDAO().save(warehouse, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWarehouse(userContext, warehouse, tokens);
 	}
 	
 	protected Warehouse saveWarehouseDetail(RetailscmUserContext userContext, Warehouse warehouse) throws Exception{	

 		
 		return saveWarehouse(userContext, warehouse, allTokens());
 	}
 	
 	public Warehouse loadWarehouse(RetailscmUserContext userContext, String warehouseId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().throwExceptionIfHasErrors( WarehouseManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Warehouse warehouse = loadWarehouse( userContext, warehouseId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,warehouse, tokens);
 	}
 	
 	
 	 public Warehouse searchWarehouse(RetailscmUserContext userContext, String warehouseId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().throwExceptionIfHasErrors( WarehouseManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Warehouse warehouse = loadWarehouse( userContext, warehouseId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,warehouse, tokens);
 	}
 	
 	

 	protected Warehouse present(RetailscmUserContext userContext, Warehouse warehouse, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,warehouse,tokens);
		
		
		Warehouse  warehouseToPresent = userContext.getDAOGroup().getWarehouseDAO().present(warehouse, tokens);
		
		List<BaseEntity> entityListToNaming = warehouseToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getWarehouseDAO().alias(entityListToNaming);
		
		return  warehouseToPresent;
		
		
	}
 
 	
 	
 	public Warehouse loadWarehouseDetail(RetailscmUserContext userContext, String warehouseId) throws Exception{	
 		Warehouse warehouse = loadWarehouse( userContext, warehouseId, allTokens());
 		return present(userContext,warehouse, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String warehouseId) throws Exception{	
 		Warehouse warehouse = loadWarehouse( userContext, warehouseId, viewTokens());
 		return present(userContext,warehouse, allTokens());
		
 	}
 	protected Warehouse saveWarehouse(RetailscmUserContext userContext, Warehouse warehouse, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getWarehouseDAO().save(warehouse, tokens);
 	}
 	protected Warehouse loadWarehouse(RetailscmUserContext userContext, String warehouseId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().throwExceptionIfHasErrors( WarehouseManagerException.class);

 
 		return userContext.getDAOGroup().getWarehouseDAO().load(warehouseId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Warehouse warehouse, Map<String, Object> tokens){
		super.addActions(userContext, warehouse, tokens);
		
		addAction(userContext, warehouse, tokens,"@create","createWarehouse","createWarehouse/","main","primary");
		addAction(userContext, warehouse, tokens,"@update","updateWarehouse","updateWarehouse/"+warehouse.getId()+"/","main","primary");
		addAction(userContext, warehouse, tokens,"@copy","cloneWarehouse","cloneWarehouse/"+warehouse.getId()+"/","main","primary");
		
		addAction(userContext, warehouse, tokens,"warehouse.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+warehouse.getId()+"/","main","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addStorageSpace","addStorageSpace","addStorageSpace/"+warehouse.getId()+"/","storageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeStorageSpace","removeStorageSpace","removeStorageSpace/"+warehouse.getId()+"/","storageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateStorageSpace","updateStorageSpace","updateStorageSpace/"+warehouse.getId()+"/","storageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyStorageSpaceFrom","copyStorageSpaceFrom","copyStorageSpaceFrom/"+warehouse.getId()+"/","storageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addSmartPallet","addSmartPallet","addSmartPallet/"+warehouse.getId()+"/","smartPalletList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeSmartPallet","removeSmartPallet","removeSmartPallet/"+warehouse.getId()+"/","smartPalletList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateSmartPallet","updateSmartPallet","updateSmartPallet/"+warehouse.getId()+"/","smartPalletList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copySmartPalletFrom","copySmartPalletFrom","copySmartPalletFrom/"+warehouse.getId()+"/","smartPalletList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addSupplierSpace","addSupplierSpace","addSupplierSpace/"+warehouse.getId()+"/","supplierSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeSupplierSpace","removeSupplierSpace","removeSupplierSpace/"+warehouse.getId()+"/","supplierSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateSupplierSpace","updateSupplierSpace","updateSupplierSpace/"+warehouse.getId()+"/","supplierSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copySupplierSpaceFrom","copySupplierSpaceFrom","copySupplierSpaceFrom/"+warehouse.getId()+"/","supplierSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addReceivingSpace","addReceivingSpace","addReceivingSpace/"+warehouse.getId()+"/","receivingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeReceivingSpace","removeReceivingSpace","removeReceivingSpace/"+warehouse.getId()+"/","receivingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateReceivingSpace","updateReceivingSpace","updateReceivingSpace/"+warehouse.getId()+"/","receivingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyReceivingSpaceFrom","copyReceivingSpaceFrom","copyReceivingSpaceFrom/"+warehouse.getId()+"/","receivingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addShippingSpace","addShippingSpace","addShippingSpace/"+warehouse.getId()+"/","shippingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeShippingSpace","removeShippingSpace","removeShippingSpace/"+warehouse.getId()+"/","shippingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateShippingSpace","updateShippingSpace","updateShippingSpace/"+warehouse.getId()+"/","shippingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyShippingSpaceFrom","copyShippingSpaceFrom","copyShippingSpaceFrom/"+warehouse.getId()+"/","shippingSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addDamageSpace","addDamageSpace","addDamageSpace/"+warehouse.getId()+"/","damageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeDamageSpace","removeDamageSpace","removeDamageSpace/"+warehouse.getId()+"/","damageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateDamageSpace","updateDamageSpace","updateDamageSpace/"+warehouse.getId()+"/","damageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyDamageSpaceFrom","copyDamageSpaceFrom","copyDamageSpaceFrom/"+warehouse.getId()+"/","damageSpaceList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.addWarehouseAsset","addWarehouseAsset","addWarehouseAsset/"+warehouse.getId()+"/","warehouseAssetList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.removeWarehouseAsset","removeWarehouseAsset","removeWarehouseAsset/"+warehouse.getId()+"/","warehouseAssetList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.updateWarehouseAsset","updateWarehouseAsset","updateWarehouseAsset/"+warehouse.getId()+"/","warehouseAssetList","primary");
		addAction(userContext, warehouse, tokens,"warehouse.copyWarehouseAssetFrom","copyWarehouseAssetFrom","copyWarehouseAssetFrom/"+warehouse.getId()+"/","warehouseAssetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, Warehouse warehouse, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Warehouse createWarehouse(RetailscmUserContext userContext,String location, String contactNumber, String totalArea, String ownerId, BigDecimal latitude, BigDecimal longitude) throws Exception
	{
		
		

		

		userContext.getChecker().checkLocationOfWarehouse(location);
		userContext.getChecker().checkContactNumberOfWarehouse(contactNumber);
		userContext.getChecker().checkTotalAreaOfWarehouse(totalArea);
		userContext.getChecker().checkLatitudeOfWarehouse(latitude);
		userContext.getChecker().checkLongitudeOfWarehouse(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);


		Warehouse warehouse=createNewWarehouse();	

		warehouse.setLocation(location);
		warehouse.setContactNumber(contactNumber);
		warehouse.setTotalArea(totalArea);
			
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, ownerId,emptyOptions());
		warehouse.setOwner(owner);
		
		
		warehouse.setLatitude(latitude);
		warehouse.setLongitude(longitude);
		warehouse.setLastUpdateTime(userContext.now());

		warehouse = saveWarehouse(userContext, warehouse, emptyOptions());
		
		onNewInstanceCreated(userContext, warehouse);
		return warehouse;

		
	}
	protected Warehouse createNewWarehouse() 
	{
		
		return new Warehouse();		
	}
	
	protected void checkParamsForUpdatingWarehouse(RetailscmUserContext userContext,String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkVersionOfWarehouse( warehouseVersion);
		

		if(Warehouse.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfWarehouse(parseString(newValueExpr));
		}
		if(Warehouse.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfWarehouse(parseString(newValueExpr));
		}
		if(Warehouse.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfWarehouse(parseString(newValueExpr));
		}		

		
		if(Warehouse.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfWarehouse(parseBigDecimal(newValueExpr));
		}
		if(Warehouse.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfWarehouse(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
		
	}
	
	
	
	public Warehouse clone(RetailscmUserContext userContext, String fromWarehouseId) throws Exception{
		
		return userContext.getDAOGroup().getWarehouseDAO().clone(fromWarehouseId, this.allTokens());
	}
	
	public Warehouse internalSaveWarehouse(RetailscmUserContext userContext, Warehouse warehouse) throws Exception 
	{
		return internalSaveWarehouse(userContext, warehouse, allTokens());

	}
	public Warehouse internalSaveWarehouse(RetailscmUserContext userContext, Warehouse warehouse, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingWarehouse(userContext, warehouseId, warehouseVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(warehouse){ 
			//will be good when the warehouse loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Warehouse.
			
			
			warehouse = saveWarehouse(userContext, warehouse, options);
			return warehouse;
			
		}

	}
	
	public Warehouse updateWarehouse(RetailscmUserContext userContext,String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWarehouse(userContext, warehouseId, warehouseVersion, property, newValueExpr, tokensExpr);
		
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		if(warehouse.getVersion() != warehouseVersion){
			String message = "The target version("+warehouse.getVersion()+") is not equals to version("+warehouseVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(warehouse){ 
			//will be good when the warehouse loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Warehouse.
			warehouse.updateLastUpdateTime(userContext.now());
			warehouse.changeProperty(property, newValueExpr);
			warehouse = saveWarehouse(userContext, warehouse, tokens().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			//return saveWarehouse(userContext, warehouse, tokens().done());
		}

	}
	
	public Warehouse updateWarehouseProperty(RetailscmUserContext userContext,String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWarehouse(userContext, warehouseId, warehouseVersion, property, newValueExpr, tokensExpr);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		if(warehouse.getVersion() != warehouseVersion){
			String message = "The target version("+warehouse.getVersion()+") is not equals to version("+warehouseVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(warehouse){ 
			//will be good when the warehouse loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Warehouse.
			
			warehouse.changeProperty(property, newValueExpr);
			warehouse.updateLastUpdateTime(userContext.now());
			warehouse = saveWarehouse(userContext, warehouse, tokens().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			//return saveWarehouse(userContext, warehouse, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected WarehouseTokens tokens(){
		return WarehouseTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WarehouseTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortStorageSpaceListWith("id","desc")
		.sortSmartPalletListWith("id","desc")
		.sortSupplierSpaceListWith("id","desc")
		.sortReceivingSpaceListWith("id","desc")
		.sortShippingSpaceListWith("id","desc")
		.sortDamageSpaceListWith("id","desc")
		.sortWarehouseAssetListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WarehouseTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String warehouseId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfWarehouse(warehouseId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
 		
 	}
 	public Warehouse transferToAnotherOwner(RetailscmUserContext userContext, String warehouseId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, warehouseId,anotherOwnerId);
 
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());	
		synchronized(warehouse){
			//will be good when the warehouse loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, anotherOwnerId, emptyOptions());		
			warehouse.updateOwner(owner);		
			warehouse = saveWarehouse(userContext, warehouse, emptyOptions());
			
			return present(userContext,warehouse, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForWarehouse(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String warehouseId, int warehouseVersion) throws Exception {
		//deleteInternal(userContext, warehouseId, warehouseVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String warehouseId, int warehouseVersion) throws Exception{
			
		userContext.getDAOGroup().getWarehouseDAO().delete(warehouseId, warehouseVersion);
	}
	
	public Warehouse forgetByAll(RetailscmUserContext userContext, String warehouseId, int warehouseVersion) throws Exception {
		return forgetByAllInternal(userContext, warehouseId, warehouseVersion);		
	}
	protected Warehouse forgetByAllInternal(RetailscmUserContext userContext,
			String warehouseId, int warehouseVersion) throws Exception{
			
		return userContext.getDAOGroup().getWarehouseDAO().disconnectFromAll(warehouseId, warehouseVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WarehouseManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getWarehouseDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingStorageSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);

		
		userContext.getChecker().checkLocationOfStorageSpace(location);
		
		userContext.getChecker().checkContactNumberOfStorageSpace(contactNumber);
		
		userContext.getChecker().checkTotalAreaOfStorageSpace(totalArea);
		
		userContext.getChecker().checkLatitudeOfStorageSpace(latitude);
		
		userContext.getChecker().checkLongitudeOfStorageSpace(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);

	
	}
	public  Warehouse addStorageSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingStorageSpace(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		StorageSpace storageSpace = createStorageSpace(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addStorageSpace( storageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
			
			userContext.getManagerGroup().getStorageSpaceManager().onNewInstanceCreated(userContext, storageSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingStorageSpaceProperties(RetailscmUserContext userContext, String warehouseId,String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfStorageSpace(id);
		
		userContext.getChecker().checkLocationOfStorageSpace( location);
		userContext.getChecker().checkContactNumberOfStorageSpace( contactNumber);
		userContext.getChecker().checkTotalAreaOfStorageSpace( totalArea);
		userContext.getChecker().checkLatitudeOfStorageSpace( latitude);
		userContext.getChecker().checkLongitudeOfStorageSpace( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse updateStorageSpaceProperties(RetailscmUserContext userContext, String warehouseId, String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingStorageSpaceProperties(userContext,warehouseId,id,location,contactNumber,totalArea,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withStorageSpaceListList()
				.searchStorageSpaceListWith(StorageSpace.ID_PROPERTY, "is", id).done();
		
		Warehouse warehouseToUpdate = loadWarehouse(userContext, warehouseId, options);
		
		if(warehouseToUpdate.getStorageSpaceList().isEmpty()){
			throw new WarehouseManagerException("StorageSpace is NOT FOUND with id: '"+id+"'");
		}
		
		StorageSpace item = warehouseToUpdate.getStorageSpaceList().first();
		
		item.updateLocation( location );
		item.updateContactNumber( contactNumber );
		item.updateTotalArea( totalArea );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingStorageSpace(userContext,warehouseId,name, code, used,tokensExpr);
		Warehouse warehouse = saveWarehouse(userContext, warehouseToUpdate, tokens().withStorageSpaceList().done());
		synchronized(warehouse){ 
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected StorageSpace createStorageSpace(RetailscmUserContext userContext, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude) throws Exception{

		StorageSpace storageSpace = new StorageSpace();
		
		
		storageSpace.setLocation(location);		
		storageSpace.setContactNumber(contactNumber);		
		storageSpace.setTotalArea(totalArea);		
		storageSpace.setLatitude(latitude);		
		storageSpace.setLongitude(longitude);
	
		
		return storageSpace;
	
		
	}
	
	protected StorageSpace createIndexedStorageSpace(String id, int version){

		StorageSpace storageSpace = new StorageSpace();
		storageSpace.setId(id);
		storageSpace.setVersion(version);
		return storageSpace;			
		
	}
	
	protected void checkParamsForRemovingStorageSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String storageSpaceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		for(String storageSpaceId: storageSpaceIds){
			userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse removeStorageSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String storageSpaceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingStorageSpaceList(userContext, warehouseId,  storageSpaceIds, tokensExpr);
			
			
			Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
			synchronized(warehouse){ 
				//Will be good when the warehouse loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getWarehouseDAO().planToRemoveStorageSpaceList(warehouse, storageSpaceIds, allTokens());
				warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
				deleteRelationListInGraph(userContext, warehouse.getStorageSpaceList());
				return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingStorageSpace(RetailscmUserContext userContext, String warehouseId, 
		String storageSpaceId, int storageSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().checkVersionOfStorageSpace(storageSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse removeStorageSpace(RetailscmUserContext userContext, String warehouseId, 
		String storageSpaceId, int storageSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingStorageSpace(userContext,warehouseId, storageSpaceId, storageSpaceVersion,tokensExpr);
		
		StorageSpace storageSpace = createIndexedStorageSpace(storageSpaceId, storageSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeStorageSpace( storageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
			deleteRelationInGraph(userContext, storageSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingStorageSpace(RetailscmUserContext userContext, String warehouseId, 
		String storageSpaceId, int storageSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().checkVersionOfStorageSpace(storageSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse copyStorageSpaceFrom(RetailscmUserContext userContext, String warehouseId, 
		String storageSpaceId, int storageSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingStorageSpace(userContext,warehouseId, storageSpaceId, storageSpaceVersion,tokensExpr);
		
		StorageSpace storageSpace = createIndexedStorageSpace(storageSpaceId, storageSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			warehouse.copyStorageSpaceFrom( storageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
			
			userContext.getManagerGroup().getStorageSpaceManager().onNewInstanceCreated(userContext, (StorageSpace)warehouse.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingStorageSpace(RetailscmUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().checkVersionOfStorageSpace(storageSpaceVersion);
		

		if(StorageSpace.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfStorageSpace(parseString(newValueExpr));
		}
		
		if(StorageSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfStorageSpace(parseString(newValueExpr));
		}
		
		if(StorageSpace.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfStorageSpace(parseString(newValueExpr));
		}
		
		if(StorageSpace.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfStorageSpace(parseBigDecimal(newValueExpr));
		}
		
		if(StorageSpace.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfStorageSpace(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	
	public  Warehouse updateStorageSpace(RetailscmUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingStorageSpace(userContext, warehouseId, storageSpaceId, storageSpaceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withStorageSpaceList().searchStorageSpaceListWith(StorageSpace.ID_PROPERTY, "eq", storageSpaceId).done();
		
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, loadTokens);
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeStorageSpace( storageSpace );	
			//make changes to AcceleraterAccount.
			StorageSpace storageSpaceIndex = createIndexedStorageSpace(storageSpaceId, storageSpaceVersion);
		
			StorageSpace storageSpace = warehouse.findTheStorageSpace(storageSpaceIndex);
			if(storageSpace == null){
				throw new WarehouseManagerException(storageSpace+" is NOT FOUND" );
			}
			
			storageSpace.changeProperty(property, newValueExpr);
			
			warehouse = saveWarehouse(userContext, warehouse, tokens().withStorageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingSmartPallet(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);

		
		userContext.getChecker().checkLocationOfSmartPallet(location);
		
		userContext.getChecker().checkContactNumberOfSmartPallet(contactNumber);
		
		userContext.getChecker().checkTotalAreaOfSmartPallet(totalArea);
		
		userContext.getChecker().checkLatitudeOfSmartPallet(latitude);
		
		userContext.getChecker().checkLongitudeOfSmartPallet(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);

	
	}
	public  Warehouse addSmartPallet(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSmartPallet(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		SmartPallet smartPallet = createSmartPallet(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addSmartPallet( smartPallet );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
			
			userContext.getManagerGroup().getSmartPalletManager().onNewInstanceCreated(userContext, smartPallet);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSmartPalletProperties(RetailscmUserContext userContext, String warehouseId,String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfSmartPallet(id);
		
		userContext.getChecker().checkLocationOfSmartPallet( location);
		userContext.getChecker().checkContactNumberOfSmartPallet( contactNumber);
		userContext.getChecker().checkTotalAreaOfSmartPallet( totalArea);
		userContext.getChecker().checkLatitudeOfSmartPallet( latitude);
		userContext.getChecker().checkLongitudeOfSmartPallet( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse updateSmartPalletProperties(RetailscmUserContext userContext, String warehouseId, String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSmartPalletProperties(userContext,warehouseId,id,location,contactNumber,totalArea,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSmartPalletListList()
				.searchSmartPalletListWith(SmartPallet.ID_PROPERTY, "is", id).done();
		
		Warehouse warehouseToUpdate = loadWarehouse(userContext, warehouseId, options);
		
		if(warehouseToUpdate.getSmartPalletList().isEmpty()){
			throw new WarehouseManagerException("SmartPallet is NOT FOUND with id: '"+id+"'");
		}
		
		SmartPallet item = warehouseToUpdate.getSmartPalletList().first();
		
		item.updateLocation( location );
		item.updateContactNumber( contactNumber );
		item.updateTotalArea( totalArea );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingSmartPallet(userContext,warehouseId,name, code, used,tokensExpr);
		Warehouse warehouse = saveWarehouse(userContext, warehouseToUpdate, tokens().withSmartPalletList().done());
		synchronized(warehouse){ 
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SmartPallet createSmartPallet(RetailscmUserContext userContext, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude) throws Exception{

		SmartPallet smartPallet = new SmartPallet();
		
		
		smartPallet.setLocation(location);		
		smartPallet.setContactNumber(contactNumber);		
		smartPallet.setTotalArea(totalArea);		
		smartPallet.setLatitude(latitude);		
		smartPallet.setLongitude(longitude);
	
		
		return smartPallet;
	
		
	}
	
	protected SmartPallet createIndexedSmartPallet(String id, int version){

		SmartPallet smartPallet = new SmartPallet();
		smartPallet.setId(id);
		smartPallet.setVersion(version);
		return smartPallet;			
		
	}
	
	protected void checkParamsForRemovingSmartPalletList(RetailscmUserContext userContext, String warehouseId, 
			String smartPalletIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		for(String smartPalletId: smartPalletIds){
			userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse removeSmartPalletList(RetailscmUserContext userContext, String warehouseId, 
			String smartPalletIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSmartPalletList(userContext, warehouseId,  smartPalletIds, tokensExpr);
			
			
			Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
			synchronized(warehouse){ 
				//Will be good when the warehouse loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getWarehouseDAO().planToRemoveSmartPalletList(warehouse, smartPalletIds, allTokens());
				warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
				deleteRelationListInGraph(userContext, warehouse.getSmartPalletList());
				return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSmartPallet(RetailscmUserContext userContext, String warehouseId, 
		String smartPalletId, int smartPalletVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		userContext.getChecker().checkVersionOfSmartPallet(smartPalletVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse removeSmartPallet(RetailscmUserContext userContext, String warehouseId, 
		String smartPalletId, int smartPalletVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSmartPallet(userContext,warehouseId, smartPalletId, smartPalletVersion,tokensExpr);
		
		SmartPallet smartPallet = createIndexedSmartPallet(smartPalletId, smartPalletVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeSmartPallet( smartPallet );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
			deleteRelationInGraph(userContext, smartPallet);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSmartPallet(RetailscmUserContext userContext, String warehouseId, 
		String smartPalletId, int smartPalletVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		userContext.getChecker().checkVersionOfSmartPallet(smartPalletVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse copySmartPalletFrom(RetailscmUserContext userContext, String warehouseId, 
		String smartPalletId, int smartPalletVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSmartPallet(userContext,warehouseId, smartPalletId, smartPalletVersion,tokensExpr);
		
		SmartPallet smartPallet = createIndexedSmartPallet(smartPalletId, smartPalletVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			warehouse.copySmartPalletFrom( smartPallet );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
			
			userContext.getManagerGroup().getSmartPalletManager().onNewInstanceCreated(userContext, (SmartPallet)warehouse.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSmartPallet(RetailscmUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfSmartPallet(smartPalletId);
		userContext.getChecker().checkVersionOfSmartPallet(smartPalletVersion);
		

		if(SmartPallet.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfSmartPallet(parseString(newValueExpr));
		}
		
		if(SmartPallet.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfSmartPallet(parseString(newValueExpr));
		}
		
		if(SmartPallet.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfSmartPallet(parseString(newValueExpr));
		}
		
		if(SmartPallet.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfSmartPallet(parseBigDecimal(newValueExpr));
		}
		
		if(SmartPallet.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfSmartPallet(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	
	public  Warehouse updateSmartPallet(RetailscmUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSmartPallet(userContext, warehouseId, smartPalletId, smartPalletVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSmartPalletList().searchSmartPalletListWith(SmartPallet.ID_PROPERTY, "eq", smartPalletId).done();
		
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, loadTokens);
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeSmartPallet( smartPallet );	
			//make changes to AcceleraterAccount.
			SmartPallet smartPalletIndex = createIndexedSmartPallet(smartPalletId, smartPalletVersion);
		
			SmartPallet smartPallet = warehouse.findTheSmartPallet(smartPalletIndex);
			if(smartPallet == null){
				throw new WarehouseManagerException(smartPallet+" is NOT FOUND" );
			}
			
			smartPallet.changeProperty(property, newValueExpr);
			
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSmartPalletList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingSupplierSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);

		
		userContext.getChecker().checkLocationOfSupplierSpace(location);
		
		userContext.getChecker().checkContactNumberOfSupplierSpace(contactNumber);
		
		userContext.getChecker().checkTotalAreaOfSupplierSpace(totalArea);
		
		userContext.getChecker().checkLatitudeOfSupplierSpace(latitude);
		
		userContext.getChecker().checkLongitudeOfSupplierSpace(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);

	
	}
	public  Warehouse addSupplierSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplierSpace(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		SupplierSpace supplierSpace = createSupplierSpace(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addSupplierSpace( supplierSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
			
			userContext.getManagerGroup().getSupplierSpaceManager().onNewInstanceCreated(userContext, supplierSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplierSpaceProperties(RetailscmUserContext userContext, String warehouseId,String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfSupplierSpace(id);
		
		userContext.getChecker().checkLocationOfSupplierSpace( location);
		userContext.getChecker().checkContactNumberOfSupplierSpace( contactNumber);
		userContext.getChecker().checkTotalAreaOfSupplierSpace( totalArea);
		userContext.getChecker().checkLatitudeOfSupplierSpace( latitude);
		userContext.getChecker().checkLongitudeOfSupplierSpace( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse updateSupplierSpaceProperties(RetailscmUserContext userContext, String warehouseId, String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingSupplierSpaceProperties(userContext,warehouseId,id,location,contactNumber,totalArea,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplierSpaceListList()
				.searchSupplierSpaceListWith(SupplierSpace.ID_PROPERTY, "is", id).done();
		
		Warehouse warehouseToUpdate = loadWarehouse(userContext, warehouseId, options);
		
		if(warehouseToUpdate.getSupplierSpaceList().isEmpty()){
			throw new WarehouseManagerException("SupplierSpace is NOT FOUND with id: '"+id+"'");
		}
		
		SupplierSpace item = warehouseToUpdate.getSupplierSpaceList().first();
		
		item.updateLocation( location );
		item.updateContactNumber( contactNumber );
		item.updateTotalArea( totalArea );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingSupplierSpace(userContext,warehouseId,name, code, used,tokensExpr);
		Warehouse warehouse = saveWarehouse(userContext, warehouseToUpdate, tokens().withSupplierSpaceList().done());
		synchronized(warehouse){ 
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected SupplierSpace createSupplierSpace(RetailscmUserContext userContext, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude) throws Exception{

		SupplierSpace supplierSpace = new SupplierSpace();
		
		
		supplierSpace.setLocation(location);		
		supplierSpace.setContactNumber(contactNumber);		
		supplierSpace.setTotalArea(totalArea);		
		supplierSpace.setLatitude(latitude);		
		supplierSpace.setLongitude(longitude);
	
		
		return supplierSpace;
	
		
	}
	
	protected SupplierSpace createIndexedSupplierSpace(String id, int version){

		SupplierSpace supplierSpace = new SupplierSpace();
		supplierSpace.setId(id);
		supplierSpace.setVersion(version);
		return supplierSpace;			
		
	}
	
	protected void checkParamsForRemovingSupplierSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String supplierSpaceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		for(String supplierSpaceId: supplierSpaceIds){
			userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse removeSupplierSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String supplierSpaceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingSupplierSpaceList(userContext, warehouseId,  supplierSpaceIds, tokensExpr);
			
			
			Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
			synchronized(warehouse){ 
				//Will be good when the warehouse loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getWarehouseDAO().planToRemoveSupplierSpaceList(warehouse, supplierSpaceIds, allTokens());
				warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
				deleteRelationListInGraph(userContext, warehouse.getSupplierSpaceList());
				return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingSupplierSpace(RetailscmUserContext userContext, String warehouseId, 
		String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().checkVersionOfSupplierSpace(supplierSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse removeSupplierSpace(RetailscmUserContext userContext, String warehouseId, 
		String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplierSpace(userContext,warehouseId, supplierSpaceId, supplierSpaceVersion,tokensExpr);
		
		SupplierSpace supplierSpace = createIndexedSupplierSpace(supplierSpaceId, supplierSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeSupplierSpace( supplierSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
			deleteRelationInGraph(userContext, supplierSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingSupplierSpace(RetailscmUserContext userContext, String warehouseId, 
		String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().checkVersionOfSupplierSpace(supplierSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse copySupplierSpaceFrom(RetailscmUserContext userContext, String warehouseId, 
		String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplierSpace(userContext,warehouseId, supplierSpaceId, supplierSpaceVersion,tokensExpr);
		
		SupplierSpace supplierSpace = createIndexedSupplierSpace(supplierSpaceId, supplierSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			warehouse.copySupplierSpaceFrom( supplierSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
			
			userContext.getManagerGroup().getSupplierSpaceManager().onNewInstanceCreated(userContext, (SupplierSpace)warehouse.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingSupplierSpace(RetailscmUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().checkVersionOfSupplierSpace(supplierSpaceVersion);
		

		if(SupplierSpace.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfSupplierSpace(parseString(newValueExpr));
		}
		
		if(SupplierSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfSupplierSpace(parseString(newValueExpr));
		}
		
		if(SupplierSpace.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfSupplierSpace(parseString(newValueExpr));
		}
		
		if(SupplierSpace.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfSupplierSpace(parseBigDecimal(newValueExpr));
		}
		
		if(SupplierSpace.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfSupplierSpace(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	
	public  Warehouse updateSupplierSpace(RetailscmUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplierSpace(userContext, warehouseId, supplierSpaceId, supplierSpaceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withSupplierSpaceList().searchSupplierSpaceListWith(SupplierSpace.ID_PROPERTY, "eq", supplierSpaceId).done();
		
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, loadTokens);
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeSupplierSpace( supplierSpace );	
			//make changes to AcceleraterAccount.
			SupplierSpace supplierSpaceIndex = createIndexedSupplierSpace(supplierSpaceId, supplierSpaceVersion);
		
			SupplierSpace supplierSpace = warehouse.findTheSupplierSpace(supplierSpaceIndex);
			if(supplierSpace == null){
				throw new WarehouseManagerException(supplierSpace+" is NOT FOUND" );
			}
			
			supplierSpace.changeProperty(property, newValueExpr);
			
			warehouse = saveWarehouse(userContext, warehouse, tokens().withSupplierSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingReceivingSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);

		
		userContext.getChecker().checkLocationOfReceivingSpace(location);
		
		userContext.getChecker().checkContactNumberOfReceivingSpace(contactNumber);
		
		userContext.getChecker().checkDescriptionOfReceivingSpace(description);
		
		userContext.getChecker().checkTotalAreaOfReceivingSpace(totalArea);
		
		userContext.getChecker().checkLatitudeOfReceivingSpace(latitude);
		
		userContext.getChecker().checkLongitudeOfReceivingSpace(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);

	
	}
	public  Warehouse addReceivingSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingReceivingSpace(userContext,warehouseId,location, contactNumber, description, totalArea, latitude, longitude,tokensExpr);
		
		ReceivingSpace receivingSpace = createReceivingSpace(userContext,location, contactNumber, description, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addReceivingSpace( receivingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
			
			userContext.getManagerGroup().getReceivingSpaceManager().onNewInstanceCreated(userContext, receivingSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingReceivingSpaceProperties(RetailscmUserContext userContext, String warehouseId,String id,String location,String contactNumber,String description,String totalArea,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfReceivingSpace(id);
		
		userContext.getChecker().checkLocationOfReceivingSpace( location);
		userContext.getChecker().checkContactNumberOfReceivingSpace( contactNumber);
		userContext.getChecker().checkDescriptionOfReceivingSpace( description);
		userContext.getChecker().checkTotalAreaOfReceivingSpace( totalArea);
		userContext.getChecker().checkLatitudeOfReceivingSpace( latitude);
		userContext.getChecker().checkLongitudeOfReceivingSpace( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse updateReceivingSpaceProperties(RetailscmUserContext userContext, String warehouseId, String id,String location,String contactNumber,String description,String totalArea,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingReceivingSpaceProperties(userContext,warehouseId,id,location,contactNumber,description,totalArea,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withReceivingSpaceListList()
				.searchReceivingSpaceListWith(ReceivingSpace.ID_PROPERTY, "is", id).done();
		
		Warehouse warehouseToUpdate = loadWarehouse(userContext, warehouseId, options);
		
		if(warehouseToUpdate.getReceivingSpaceList().isEmpty()){
			throw new WarehouseManagerException("ReceivingSpace is NOT FOUND with id: '"+id+"'");
		}
		
		ReceivingSpace item = warehouseToUpdate.getReceivingSpaceList().first();
		
		item.updateLocation( location );
		item.updateContactNumber( contactNumber );
		item.updateDescription( description );
		item.updateTotalArea( totalArea );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingReceivingSpace(userContext,warehouseId,name, code, used,tokensExpr);
		Warehouse warehouse = saveWarehouse(userContext, warehouseToUpdate, tokens().withReceivingSpaceList().done());
		synchronized(warehouse){ 
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ReceivingSpace createReceivingSpace(RetailscmUserContext userContext, String location, String contactNumber, String description, String totalArea, BigDecimal latitude, BigDecimal longitude) throws Exception{

		ReceivingSpace receivingSpace = new ReceivingSpace();
		
		
		receivingSpace.setLocation(location);		
		receivingSpace.setContactNumber(contactNumber);		
		receivingSpace.setDescription(description);		
		receivingSpace.setTotalArea(totalArea);		
		receivingSpace.setLatitude(latitude);		
		receivingSpace.setLongitude(longitude);
	
		
		return receivingSpace;
	
		
	}
	
	protected ReceivingSpace createIndexedReceivingSpace(String id, int version){

		ReceivingSpace receivingSpace = new ReceivingSpace();
		receivingSpace.setId(id);
		receivingSpace.setVersion(version);
		return receivingSpace;			
		
	}
	
	protected void checkParamsForRemovingReceivingSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String receivingSpaceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		for(String receivingSpaceId: receivingSpaceIds){
			userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse removeReceivingSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String receivingSpaceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingReceivingSpaceList(userContext, warehouseId,  receivingSpaceIds, tokensExpr);
			
			
			Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
			synchronized(warehouse){ 
				//Will be good when the warehouse loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getWarehouseDAO().planToRemoveReceivingSpaceList(warehouse, receivingSpaceIds, allTokens());
				warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
				deleteRelationListInGraph(userContext, warehouse.getReceivingSpaceList());
				return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingReceivingSpace(RetailscmUserContext userContext, String warehouseId, 
		String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		userContext.getChecker().checkVersionOfReceivingSpace(receivingSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse removeReceivingSpace(RetailscmUserContext userContext, String warehouseId, 
		String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingReceivingSpace(userContext,warehouseId, receivingSpaceId, receivingSpaceVersion,tokensExpr);
		
		ReceivingSpace receivingSpace = createIndexedReceivingSpace(receivingSpaceId, receivingSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeReceivingSpace( receivingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
			deleteRelationInGraph(userContext, receivingSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingReceivingSpace(RetailscmUserContext userContext, String warehouseId, 
		String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		userContext.getChecker().checkVersionOfReceivingSpace(receivingSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse copyReceivingSpaceFrom(RetailscmUserContext userContext, String warehouseId, 
		String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingReceivingSpace(userContext,warehouseId, receivingSpaceId, receivingSpaceVersion,tokensExpr);
		
		ReceivingSpace receivingSpace = createIndexedReceivingSpace(receivingSpaceId, receivingSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			warehouse.copyReceivingSpaceFrom( receivingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
			
			userContext.getManagerGroup().getReceivingSpaceManager().onNewInstanceCreated(userContext, (ReceivingSpace)warehouse.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingReceivingSpace(RetailscmUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfReceivingSpace(receivingSpaceId);
		userContext.getChecker().checkVersionOfReceivingSpace(receivingSpaceVersion);
		

		if(ReceivingSpace.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfReceivingSpace(parseString(newValueExpr));
		}
		
		if(ReceivingSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfReceivingSpace(parseString(newValueExpr));
		}
		
		if(ReceivingSpace.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfReceivingSpace(parseString(newValueExpr));
		}
		
		if(ReceivingSpace.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfReceivingSpace(parseString(newValueExpr));
		}
		
		if(ReceivingSpace.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfReceivingSpace(parseBigDecimal(newValueExpr));
		}
		
		if(ReceivingSpace.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfReceivingSpace(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	
	public  Warehouse updateReceivingSpace(RetailscmUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingReceivingSpace(userContext, warehouseId, receivingSpaceId, receivingSpaceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withReceivingSpaceList().searchReceivingSpaceListWith(ReceivingSpace.ID_PROPERTY, "eq", receivingSpaceId).done();
		
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, loadTokens);
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeReceivingSpace( receivingSpace );	
			//make changes to AcceleraterAccount.
			ReceivingSpace receivingSpaceIndex = createIndexedReceivingSpace(receivingSpaceId, receivingSpaceVersion);
		
			ReceivingSpace receivingSpace = warehouse.findTheReceivingSpace(receivingSpaceIndex);
			if(receivingSpace == null){
				throw new WarehouseManagerException(receivingSpace+" is NOT FOUND" );
			}
			
			receivingSpace.changeProperty(property, newValueExpr);
			
			warehouse = saveWarehouse(userContext, warehouse, tokens().withReceivingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingShippingSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);

		
		userContext.getChecker().checkLocationOfShippingSpace(location);
		
		userContext.getChecker().checkContactNumberOfShippingSpace(contactNumber);
		
		userContext.getChecker().checkTotalAreaOfShippingSpace(totalArea);
		
		userContext.getChecker().checkLatitudeOfShippingSpace(latitude);
		
		userContext.getChecker().checkLongitudeOfShippingSpace(longitude);
		
		userContext.getChecker().checkDescriptionOfShippingSpace(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);

	
	}
	public  Warehouse addShippingSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingShippingSpace(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude, description,tokensExpr);
		
		ShippingSpace shippingSpace = createShippingSpace(userContext,location, contactNumber, totalArea, latitude, longitude, description);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addShippingSpace( shippingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
			
			userContext.getManagerGroup().getShippingSpaceManager().onNewInstanceCreated(userContext, shippingSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingShippingSpaceProperties(RetailscmUserContext userContext, String warehouseId,String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfShippingSpace(id);
		
		userContext.getChecker().checkLocationOfShippingSpace( location);
		userContext.getChecker().checkContactNumberOfShippingSpace( contactNumber);
		userContext.getChecker().checkTotalAreaOfShippingSpace( totalArea);
		userContext.getChecker().checkLatitudeOfShippingSpace( latitude);
		userContext.getChecker().checkLongitudeOfShippingSpace( longitude);
		userContext.getChecker().checkDescriptionOfShippingSpace( description);

		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse updateShippingSpaceProperties(RetailscmUserContext userContext, String warehouseId, String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingShippingSpaceProperties(userContext,warehouseId,id,location,contactNumber,totalArea,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withShippingSpaceListList()
				.searchShippingSpaceListWith(ShippingSpace.ID_PROPERTY, "is", id).done();
		
		Warehouse warehouseToUpdate = loadWarehouse(userContext, warehouseId, options);
		
		if(warehouseToUpdate.getShippingSpaceList().isEmpty()){
			throw new WarehouseManagerException("ShippingSpace is NOT FOUND with id: '"+id+"'");
		}
		
		ShippingSpace item = warehouseToUpdate.getShippingSpaceList().first();
		
		item.updateLocation( location );
		item.updateContactNumber( contactNumber );
		item.updateTotalArea( totalArea );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );

		
		//checkParamsForAddingShippingSpace(userContext,warehouseId,name, code, used,tokensExpr);
		Warehouse warehouse = saveWarehouse(userContext, warehouseToUpdate, tokens().withShippingSpaceList().done());
		synchronized(warehouse){ 
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ShippingSpace createShippingSpace(RetailscmUserContext userContext, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

		ShippingSpace shippingSpace = new ShippingSpace();
		
		
		shippingSpace.setLocation(location);		
		shippingSpace.setContactNumber(contactNumber);		
		shippingSpace.setTotalArea(totalArea);		
		shippingSpace.setLatitude(latitude);		
		shippingSpace.setLongitude(longitude);		
		shippingSpace.setDescription(description);
	
		
		return shippingSpace;
	
		
	}
	
	protected ShippingSpace createIndexedShippingSpace(String id, int version){

		ShippingSpace shippingSpace = new ShippingSpace();
		shippingSpace.setId(id);
		shippingSpace.setVersion(version);
		return shippingSpace;			
		
	}
	
	protected void checkParamsForRemovingShippingSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String shippingSpaceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		for(String shippingSpaceId: shippingSpaceIds){
			userContext.getChecker().checkIdOfShippingSpace(shippingSpaceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse removeShippingSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String shippingSpaceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingShippingSpaceList(userContext, warehouseId,  shippingSpaceIds, tokensExpr);
			
			
			Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
			synchronized(warehouse){ 
				//Will be good when the warehouse loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getWarehouseDAO().planToRemoveShippingSpaceList(warehouse, shippingSpaceIds, allTokens());
				warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
				deleteRelationListInGraph(userContext, warehouse.getShippingSpaceList());
				return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingShippingSpace(RetailscmUserContext userContext, String warehouseId, 
		String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfShippingSpace(shippingSpaceId);
		userContext.getChecker().checkVersionOfShippingSpace(shippingSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse removeShippingSpace(RetailscmUserContext userContext, String warehouseId, 
		String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingShippingSpace(userContext,warehouseId, shippingSpaceId, shippingSpaceVersion,tokensExpr);
		
		ShippingSpace shippingSpace = createIndexedShippingSpace(shippingSpaceId, shippingSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeShippingSpace( shippingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
			deleteRelationInGraph(userContext, shippingSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingShippingSpace(RetailscmUserContext userContext, String warehouseId, 
		String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfShippingSpace(shippingSpaceId);
		userContext.getChecker().checkVersionOfShippingSpace(shippingSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse copyShippingSpaceFrom(RetailscmUserContext userContext, String warehouseId, 
		String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingShippingSpace(userContext,warehouseId, shippingSpaceId, shippingSpaceVersion,tokensExpr);
		
		ShippingSpace shippingSpace = createIndexedShippingSpace(shippingSpaceId, shippingSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			warehouse.copyShippingSpaceFrom( shippingSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
			
			userContext.getManagerGroup().getShippingSpaceManager().onNewInstanceCreated(userContext, (ShippingSpace)warehouse.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingShippingSpace(RetailscmUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfShippingSpace(shippingSpaceId);
		userContext.getChecker().checkVersionOfShippingSpace(shippingSpaceVersion);
		

		if(ShippingSpace.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfShippingSpace(parseString(newValueExpr));
		}
		
		if(ShippingSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfShippingSpace(parseString(newValueExpr));
		}
		
		if(ShippingSpace.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfShippingSpace(parseString(newValueExpr));
		}
		
		if(ShippingSpace.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfShippingSpace(parseBigDecimal(newValueExpr));
		}
		
		if(ShippingSpace.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfShippingSpace(parseBigDecimal(newValueExpr));
		}
		
		if(ShippingSpace.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfShippingSpace(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	
	public  Warehouse updateShippingSpace(RetailscmUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingShippingSpace(userContext, warehouseId, shippingSpaceId, shippingSpaceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withShippingSpaceList().searchShippingSpaceListWith(ShippingSpace.ID_PROPERTY, "eq", shippingSpaceId).done();
		
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, loadTokens);
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeShippingSpace( shippingSpace );	
			//make changes to AcceleraterAccount.
			ShippingSpace shippingSpaceIndex = createIndexedShippingSpace(shippingSpaceId, shippingSpaceVersion);
		
			ShippingSpace shippingSpace = warehouse.findTheShippingSpace(shippingSpaceIndex);
			if(shippingSpace == null){
				throw new WarehouseManagerException(shippingSpace+" is NOT FOUND" );
			}
			
			shippingSpace.changeProperty(property, newValueExpr);
			
			warehouse = saveWarehouse(userContext, warehouse, tokens().withShippingSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingDamageSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);

		
		userContext.getChecker().checkLocationOfDamageSpace(location);
		
		userContext.getChecker().checkContactNumberOfDamageSpace(contactNumber);
		
		userContext.getChecker().checkTotalAreaOfDamageSpace(totalArea);
		
		userContext.getChecker().checkLatitudeOfDamageSpace(latitude);
		
		userContext.getChecker().checkLongitudeOfDamageSpace(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);

	
	}
	public  Warehouse addDamageSpace(RetailscmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingDamageSpace(userContext,warehouseId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		DamageSpace damageSpace = createDamageSpace(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addDamageSpace( damageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
			
			userContext.getManagerGroup().getDamageSpaceManager().onNewInstanceCreated(userContext, damageSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingDamageSpaceProperties(RetailscmUserContext userContext, String warehouseId,String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfDamageSpace(id);
		
		userContext.getChecker().checkLocationOfDamageSpace( location);
		userContext.getChecker().checkContactNumberOfDamageSpace( contactNumber);
		userContext.getChecker().checkTotalAreaOfDamageSpace( totalArea);
		userContext.getChecker().checkLatitudeOfDamageSpace( latitude);
		userContext.getChecker().checkLongitudeOfDamageSpace( longitude);

		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse updateDamageSpaceProperties(RetailscmUserContext userContext, String warehouseId, String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingDamageSpaceProperties(userContext,warehouseId,id,location,contactNumber,totalArea,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withDamageSpaceListList()
				.searchDamageSpaceListWith(DamageSpace.ID_PROPERTY, "is", id).done();
		
		Warehouse warehouseToUpdate = loadWarehouse(userContext, warehouseId, options);
		
		if(warehouseToUpdate.getDamageSpaceList().isEmpty()){
			throw new WarehouseManagerException("DamageSpace is NOT FOUND with id: '"+id+"'");
		}
		
		DamageSpace item = warehouseToUpdate.getDamageSpaceList().first();
		
		item.updateLocation( location );
		item.updateContactNumber( contactNumber );
		item.updateTotalArea( totalArea );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );

		
		//checkParamsForAddingDamageSpace(userContext,warehouseId,name, code, used,tokensExpr);
		Warehouse warehouse = saveWarehouse(userContext, warehouseToUpdate, tokens().withDamageSpaceList().done());
		synchronized(warehouse){ 
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected DamageSpace createDamageSpace(RetailscmUserContext userContext, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude) throws Exception{

		DamageSpace damageSpace = new DamageSpace();
		
		
		damageSpace.setLocation(location);		
		damageSpace.setContactNumber(contactNumber);		
		damageSpace.setTotalArea(totalArea);		
		damageSpace.setLatitude(latitude);		
		damageSpace.setLongitude(longitude);
	
		
		return damageSpace;
	
		
	}
	
	protected DamageSpace createIndexedDamageSpace(String id, int version){

		DamageSpace damageSpace = new DamageSpace();
		damageSpace.setId(id);
		damageSpace.setVersion(version);
		return damageSpace;			
		
	}
	
	protected void checkParamsForRemovingDamageSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String damageSpaceIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		for(String damageSpaceId: damageSpaceIds){
			userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse removeDamageSpaceList(RetailscmUserContext userContext, String warehouseId, 
			String damageSpaceIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingDamageSpaceList(userContext, warehouseId,  damageSpaceIds, tokensExpr);
			
			
			Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
			synchronized(warehouse){ 
				//Will be good when the warehouse loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getWarehouseDAO().planToRemoveDamageSpaceList(warehouse, damageSpaceIds, allTokens());
				warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
				deleteRelationListInGraph(userContext, warehouse.getDamageSpaceList());
				return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingDamageSpace(RetailscmUserContext userContext, String warehouseId, 
		String damageSpaceId, int damageSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().checkVersionOfDamageSpace(damageSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse removeDamageSpace(RetailscmUserContext userContext, String warehouseId, 
		String damageSpaceId, int damageSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingDamageSpace(userContext,warehouseId, damageSpaceId, damageSpaceVersion,tokensExpr);
		
		DamageSpace damageSpace = createIndexedDamageSpace(damageSpaceId, damageSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeDamageSpace( damageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
			deleteRelationInGraph(userContext, damageSpace);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingDamageSpace(RetailscmUserContext userContext, String warehouseId, 
		String damageSpaceId, int damageSpaceVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().checkVersionOfDamageSpace(damageSpaceVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse copyDamageSpaceFrom(RetailscmUserContext userContext, String warehouseId, 
		String damageSpaceId, int damageSpaceVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingDamageSpace(userContext,warehouseId, damageSpaceId, damageSpaceVersion,tokensExpr);
		
		DamageSpace damageSpace = createIndexedDamageSpace(damageSpaceId, damageSpaceVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			warehouse.copyDamageSpaceFrom( damageSpace );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
			
			userContext.getManagerGroup().getDamageSpaceManager().onNewInstanceCreated(userContext, (DamageSpace)warehouse.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingDamageSpace(RetailscmUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().checkVersionOfDamageSpace(damageSpaceVersion);
		

		if(DamageSpace.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfDamageSpace(parseString(newValueExpr));
		}
		
		if(DamageSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkContactNumberOfDamageSpace(parseString(newValueExpr));
		}
		
		if(DamageSpace.TOTAL_AREA_PROPERTY.equals(property)){
			userContext.getChecker().checkTotalAreaOfDamageSpace(parseString(newValueExpr));
		}
		
		if(DamageSpace.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfDamageSpace(parseBigDecimal(newValueExpr));
		}
		
		if(DamageSpace.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfDamageSpace(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	
	public  Warehouse updateDamageSpace(RetailscmUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingDamageSpace(userContext, warehouseId, damageSpaceId, damageSpaceVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withDamageSpaceList().searchDamageSpaceListWith(DamageSpace.ID_PROPERTY, "eq", damageSpaceId).done();
		
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, loadTokens);
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeDamageSpace( damageSpace );	
			//make changes to AcceleraterAccount.
			DamageSpace damageSpaceIndex = createIndexedDamageSpace(damageSpaceId, damageSpaceVersion);
		
			DamageSpace damageSpace = warehouse.findTheDamageSpace(damageSpaceIndex);
			if(damageSpace == null){
				throw new WarehouseManagerException(damageSpace+" is NOT FOUND" );
			}
			
			damageSpace.changeProperty(property, newValueExpr);
			
			warehouse = saveWarehouse(userContext, warehouse, tokens().withDamageSpaceList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingWarehouseAsset(RetailscmUserContext userContext, String warehouseId, String name, String position,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);

		
		userContext.getChecker().checkNameOfWarehouseAsset(name);
		
		userContext.getChecker().checkPositionOfWarehouseAsset(position);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);

	
	}
	public  Warehouse addWarehouseAsset(RetailscmUserContext userContext, String warehouseId, String name, String position, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingWarehouseAsset(userContext,warehouseId,name, position,tokensExpr);
		
		WarehouseAsset warehouseAsset = createWarehouseAsset(userContext,name, position);
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.addWarehouseAsset( warehouseAsset );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
			
			userContext.getManagerGroup().getWarehouseAssetManager().onNewInstanceCreated(userContext, warehouseAsset);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingWarehouseAssetProperties(RetailscmUserContext userContext, String warehouseId,String id,String name,String position,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfWarehouseAsset(id);
		
		userContext.getChecker().checkNameOfWarehouseAsset( name);
		userContext.getChecker().checkPositionOfWarehouseAsset( position);

		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse updateWarehouseAssetProperties(RetailscmUserContext userContext, String warehouseId, String id,String name,String position, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingWarehouseAssetProperties(userContext,warehouseId,id,name,position,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withWarehouseAssetListList()
				.searchWarehouseAssetListWith(WarehouseAsset.ID_PROPERTY, "is", id).done();
		
		Warehouse warehouseToUpdate = loadWarehouse(userContext, warehouseId, options);
		
		if(warehouseToUpdate.getWarehouseAssetList().isEmpty()){
			throw new WarehouseManagerException("WarehouseAsset is NOT FOUND with id: '"+id+"'");
		}
		
		WarehouseAsset item = warehouseToUpdate.getWarehouseAssetList().first();
		
		item.updateName( name );
		item.updatePosition( position );

		
		//checkParamsForAddingWarehouseAsset(userContext,warehouseId,name, code, used,tokensExpr);
		Warehouse warehouse = saveWarehouse(userContext, warehouseToUpdate, tokens().withWarehouseAssetList().done());
		synchronized(warehouse){ 
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected WarehouseAsset createWarehouseAsset(RetailscmUserContext userContext, String name, String position) throws Exception{

		WarehouseAsset warehouseAsset = new WarehouseAsset();
		
		
		warehouseAsset.setName(name);		
		warehouseAsset.setPosition(position);
	
		
		return warehouseAsset;
	
		
	}
	
	protected WarehouseAsset createIndexedWarehouseAsset(String id, int version){

		WarehouseAsset warehouseAsset = new WarehouseAsset();
		warehouseAsset.setId(id);
		warehouseAsset.setVersion(version);
		return warehouseAsset;			
		
	}
	
	protected void checkParamsForRemovingWarehouseAssetList(RetailscmUserContext userContext, String warehouseId, 
			String warehouseAssetIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		for(String warehouseAssetId: warehouseAssetIds){
			userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
		
	}
	public  Warehouse removeWarehouseAssetList(RetailscmUserContext userContext, String warehouseId, 
			String warehouseAssetIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingWarehouseAssetList(userContext, warehouseId,  warehouseAssetIds, tokensExpr);
			
			
			Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
			synchronized(warehouse){ 
				//Will be good when the warehouse loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getWarehouseDAO().planToRemoveWarehouseAssetList(warehouse, warehouseAssetIds, allTokens());
				warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
				deleteRelationListInGraph(userContext, warehouse.getWarehouseAssetList());
				return present(userContext,warehouse, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingWarehouseAsset(RetailscmUserContext userContext, String warehouseId, 
		String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
		userContext.getChecker().checkVersionOfWarehouseAsset(warehouseAssetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse removeWarehouseAsset(RetailscmUserContext userContext, String warehouseId, 
		String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingWarehouseAsset(userContext,warehouseId, warehouseAssetId, warehouseAssetVersion,tokensExpr);
		
		WarehouseAsset warehouseAsset = createIndexedWarehouseAsset(warehouseAssetId, warehouseAssetVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			warehouse.removeWarehouseAsset( warehouseAsset );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
			deleteRelationInGraph(userContext, warehouseAsset);
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingWarehouseAsset(RetailscmUserContext userContext, String warehouseId, 
		String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfWarehouse( warehouseId);
		userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
		userContext.getChecker().checkVersionOfWarehouseAsset(warehouseAssetVersion);
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	public  Warehouse copyWarehouseAssetFrom(RetailscmUserContext userContext, String warehouseId, 
		String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingWarehouseAsset(userContext,warehouseId, warehouseAssetId, warehouseAssetVersion,tokensExpr);
		
		WarehouseAsset warehouseAsset = createIndexedWarehouseAsset(warehouseAssetId, warehouseAssetVersion);
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, allTokens());
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			warehouse.copyWarehouseAssetFrom( warehouseAsset );		
			warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
			
			userContext.getManagerGroup().getWarehouseAssetManager().onNewInstanceCreated(userContext, (WarehouseAsset)warehouse.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingWarehouseAsset(RetailscmUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfWarehouse(warehouseId);
		userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
		userContext.getChecker().checkVersionOfWarehouseAsset(warehouseAssetVersion);
		

		if(WarehouseAsset.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfWarehouseAsset(parseString(newValueExpr));
		}
		
		if(WarehouseAsset.POSITION_PROPERTY.equals(property)){
			userContext.getChecker().checkPositionOfWarehouseAsset(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseManagerException.class);
	
	}
	
	public  Warehouse updateWarehouseAsset(RetailscmUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingWarehouseAsset(userContext, warehouseId, warehouseAssetId, warehouseAssetVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withWarehouseAssetList().searchWarehouseAssetListWith(WarehouseAsset.ID_PROPERTY, "eq", warehouseAssetId).done();
		
		
		
		Warehouse warehouse = loadWarehouse(userContext, warehouseId, loadTokens);
		
		synchronized(warehouse){ 
			//Will be good when the warehouse loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//warehouse.removeWarehouseAsset( warehouseAsset );	
			//make changes to AcceleraterAccount.
			WarehouseAsset warehouseAssetIndex = createIndexedWarehouseAsset(warehouseAssetId, warehouseAssetVersion);
		
			WarehouseAsset warehouseAsset = warehouse.findTheWarehouseAsset(warehouseAssetIndex);
			if(warehouseAsset == null){
				throw new WarehouseManagerException(warehouseAsset+" is NOT FOUND" );
			}
			
			warehouseAsset.changeProperty(property, newValueExpr);
			
			warehouse = saveWarehouse(userContext, warehouse, tokens().withWarehouseAssetList().done());
			return present(userContext,warehouse, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, Warehouse newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


