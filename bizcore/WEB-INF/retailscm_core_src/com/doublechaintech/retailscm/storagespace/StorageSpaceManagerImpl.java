
package com.doublechaintech.retailscm.storagespace;

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

import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.warehouse.CandidateWarehouse;

import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;






public class StorageSpaceManagerImpl extends CustomRetailscmCheckerManager implements StorageSpaceManager {
	
	private static final String SERVICE_TYPE = "StorageSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws StorageSpaceManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new StorageSpaceManagerException(message);

	}
	
	

 	protected StorageSpace saveStorageSpace(RetailscmUserContext userContext, StorageSpace storageSpace, String [] tokensExpr) throws Exception{	
 		//return getStorageSpaceDAO().save(storageSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveStorageSpace(userContext, storageSpace, tokens);
 	}
 	
 	protected StorageSpace saveStorageSpaceDetail(RetailscmUserContext userContext, StorageSpace storageSpace) throws Exception{	

 		
 		return saveStorageSpace(userContext, storageSpace, allTokens());
 	}
 	
 	public StorageSpace loadStorageSpace(RetailscmUserContext userContext, String storageSpaceId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( StorageSpaceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,storageSpace, tokens);
 	}
 	
 	
 	 public StorageSpace searchStorageSpace(RetailscmUserContext userContext, String storageSpaceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( StorageSpaceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,storageSpace, tokens);
 	}
 	
 	

 	protected StorageSpace present(RetailscmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,storageSpace,tokens);
		
		
		StorageSpace  storageSpaceToPresent = userContext.getDAOGroup().getStorageSpaceDAO().present(storageSpace, tokens);
		
		List<BaseEntity> entityListToNaming = storageSpaceToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getStorageSpaceDAO().alias(entityListToNaming);
		
		return  storageSpaceToPresent;
		
		
	}
 
 	
 	
 	public StorageSpace loadStorageSpaceDetail(RetailscmUserContext userContext, String storageSpaceId) throws Exception{	
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, allTokens());
 		return present(userContext,storageSpace, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String storageSpaceId) throws Exception{	
 		StorageSpace storageSpace = loadStorageSpace( userContext, storageSpaceId, viewTokens());
 		return present(userContext,storageSpace, allTokens());
		
 	}
 	protected StorageSpace saveStorageSpace(RetailscmUserContext userContext, StorageSpace storageSpace, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getStorageSpaceDAO().save(storageSpace, tokens);
 	}
 	protected StorageSpace loadStorageSpace(RetailscmUserContext userContext, String storageSpaceId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( StorageSpaceManagerException.class);

 
 		return userContext.getDAOGroup().getStorageSpaceDAO().load(storageSpaceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens){
		super.addActions(userContext, storageSpace, tokens);
		
		addAction(userContext, storageSpace, tokens,"@create","createStorageSpace","createStorageSpace/","main","primary");
		addAction(userContext, storageSpace, tokens,"@update","updateStorageSpace","updateStorageSpace/"+storageSpace.getId()+"/","main","primary");
		addAction(userContext, storageSpace, tokens,"@copy","cloneStorageSpace","cloneStorageSpace/"+storageSpace.getId()+"/","main","primary");
		
		addAction(userContext, storageSpace, tokens,"storage_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+storageSpace.getId()+"/","main","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.addGoodsShelf","addGoodsShelf","addGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.removeGoodsShelf","removeGoodsShelf","removeGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.updateGoodsShelf","updateGoodsShelf","updateGoodsShelf/"+storageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, storageSpace, tokens,"storage_space.copyGoodsShelfFrom","copyGoodsShelfFrom","copyGoodsShelfFrom/"+storageSpace.getId()+"/","goodsShelfList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, StorageSpace storageSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public StorageSpace createStorageSpace(RetailscmUserContext userContext,String location, String contactNumber, String totalArea, String warehouseId, BigDecimal latitude, BigDecimal longitude) throws Exception
	{
		
		

		

		userContext.getChecker().checkLocationOfStorageSpace(location);
		userContext.getChecker().checkContactNumberOfStorageSpace(contactNumber);
		userContext.getChecker().checkTotalAreaOfStorageSpace(totalArea);
		userContext.getChecker().checkLatitudeOfStorageSpace(latitude);
		userContext.getChecker().checkLongitudeOfStorageSpace(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);


		StorageSpace storageSpace=createNewStorageSpace();	

		storageSpace.setLocation(location);
		storageSpace.setContactNumber(contactNumber);
		storageSpace.setTotalArea(totalArea);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		storageSpace.setWarehouse(warehouse);
		
		
		storageSpace.setLatitude(latitude);
		storageSpace.setLongitude(longitude);

		storageSpace = saveStorageSpace(userContext, storageSpace, emptyOptions());
		
		onNewInstanceCreated(userContext, storageSpace);
		return storageSpace;

		
	}
	protected StorageSpace createNewStorageSpace() 
	{
		
		return new StorageSpace();		
	}
	
	protected void checkParamsForUpdatingStorageSpace(RetailscmUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().checkVersionOfStorageSpace( storageSpaceVersion);
		

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
	
		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);
	
		
	}
	
	
	
	public StorageSpace clone(RetailscmUserContext userContext, String fromStorageSpaceId) throws Exception{
		
		return userContext.getDAOGroup().getStorageSpaceDAO().clone(fromStorageSpaceId, this.allTokens());
	}
	
	public StorageSpace internalSaveStorageSpace(RetailscmUserContext userContext, StorageSpace storageSpace) throws Exception 
	{
		return internalSaveStorageSpace(userContext, storageSpace, allTokens());

	}
	public StorageSpace internalSaveStorageSpace(RetailscmUserContext userContext, StorageSpace storageSpace, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingStorageSpace(userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(storageSpace){ 
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StorageSpace.
			
			
			storageSpace = saveStorageSpace(userContext, storageSpace, options);
			return storageSpace;
			
		}

	}
	
	public StorageSpace updateStorageSpace(RetailscmUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingStorageSpace(userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);
		
		
		
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		if(storageSpace.getVersion() != storageSpaceVersion){
			String message = "The target version("+storageSpace.getVersion()+") is not equals to version("+storageSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(storageSpace){ 
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StorageSpace.
			
			storageSpace.changeProperty(property, newValueExpr);
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
			//return saveStorageSpace(userContext, storageSpace, tokens().done());
		}

	}
	
	public StorageSpace updateStorageSpaceProperty(RetailscmUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingStorageSpace(userContext, storageSpaceId, storageSpaceVersion, property, newValueExpr, tokensExpr);
		
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		if(storageSpace.getVersion() != storageSpaceVersion){
			String message = "The target version("+storageSpace.getVersion()+") is not equals to version("+storageSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(storageSpace){ 
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StorageSpace.
			
			storageSpace.changeProperty(property, newValueExpr);
			
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
			//return saveStorageSpace(userContext, storageSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected StorageSpaceTokens tokens(){
		return StorageSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return StorageSpaceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsShelfListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return StorageSpaceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailscmUserContext userContext, String storageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
 		userContext.getChecker().checkIdOfWarehouse(anotherWarehouseId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);
 		
 	}
 	public StorageSpace transferToAnotherWarehouse(RetailscmUserContext userContext, String storageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, storageSpaceId,anotherWarehouseId);
 
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());	
		synchronized(storageSpace){
			//will be good when the storageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());		
			storageSpace.updateWarehouse(warehouse);		
			storageSpace = saveStorageSpace(userContext, storageSpace, emptyOptions());
			
			return present(userContext,storageSpace, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateWarehouse requestCandidateWarehouse(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateWarehouse result = new CandidateWarehouse();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("location");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Warehouse> candidateList = userContext.getDAOGroup().getWarehouseDAO().requestCandidateWarehouseForStorageSpace(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(RetailscmUserContext userContext, String newWarehouseId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getWarehouseDAO().load(newWarehouseId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String storageSpaceId, int storageSpaceVersion) throws Exception {
		//deleteInternal(userContext, storageSpaceId, storageSpaceVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String storageSpaceId, int storageSpaceVersion) throws Exception{
			
		userContext.getDAOGroup().getStorageSpaceDAO().delete(storageSpaceId, storageSpaceVersion);
	}
	
	public StorageSpace forgetByAll(RetailscmUserContext userContext, String storageSpaceId, int storageSpaceVersion) throws Exception {
		return forgetByAllInternal(userContext, storageSpaceId, storageSpaceVersion);		
	}
	protected StorageSpace forgetByAllInternal(RetailscmUserContext userContext,
			String storageSpaceId, int storageSpaceVersion) throws Exception{
			
		return userContext.getDAOGroup().getStorageSpaceDAO().disconnectFromAll(storageSpaceId, storageSpaceVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new StorageSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getStorageSpaceDAO().deleteAll();
	}


	//disconnect StorageSpace with supplier_space in GoodsShelf
	protected StorageSpace breakWithGoodsShelfBySupplierSpace(RetailscmUserContext userContext, String storageSpaceId, String supplierSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());

			synchronized(storageSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getStorageSpaceDAO().planToRemoveGoodsShelfListWithSupplierSpace(storageSpace, supplierSpaceId, this.emptyOptions());

				storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
				return storageSpace;
			}
	}
	//disconnect StorageSpace with damage_space in GoodsShelf
	protected StorageSpace breakWithGoodsShelfByDamageSpace(RetailscmUserContext userContext, String storageSpaceId, String damageSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());

			synchronized(storageSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getStorageSpaceDAO().planToRemoveGoodsShelfListWithDamageSpace(storageSpace, damageSpaceId, this.emptyOptions());

				storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
				return storageSpace;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);

		
		userContext.getChecker().checkLocationOfGoodsShelf(location);
		
		userContext.getChecker().checkSupplierSpaceIdOfGoodsShelf(supplierSpaceId);
		
		userContext.getChecker().checkDamageSpaceIdOfGoodsShelf(damageSpaceId);
	
		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);

	
	}
	public  StorageSpace addGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsShelf(userContext,storageSpaceId,location, supplierSpaceId, damageSpaceId,tokensExpr);
		
		GoodsShelf goodsShelf = createGoodsShelf(userContext,location, supplierSpaceId, damageSpaceId);
		
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		synchronized(storageSpace){ 
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			storageSpace.addGoodsShelf( goodsShelf );		
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			
			userContext.getManagerGroup().getGoodsShelfManager().onNewInstanceCreated(userContext, goodsShelf);
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsShelfProperties(RetailscmUserContext userContext, String storageSpaceId,String id,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(id);
		
		userContext.getChecker().checkLocationOfGoodsShelf( location);

		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);
		
	}
	public  StorageSpace updateGoodsShelfProperties(RetailscmUserContext userContext, String storageSpaceId, String id,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsShelfProperties(userContext,storageSpaceId,id,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsShelfListList()
				.searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, "is", id).done();
		
		StorageSpace storageSpaceToUpdate = loadStorageSpace(userContext, storageSpaceId, options);
		
		if(storageSpaceToUpdate.getGoodsShelfList().isEmpty()){
			throw new StorageSpaceManagerException("GoodsShelf is NOT FOUND with id: '"+id+"'");
		}
		
		GoodsShelf item = storageSpaceToUpdate.getGoodsShelfList().first();
		
		item.updateLocation( location );

		
		//checkParamsForAddingGoodsShelf(userContext,storageSpaceId,name, code, used,tokensExpr);
		StorageSpace storageSpace = saveStorageSpace(userContext, storageSpaceToUpdate, tokens().withGoodsShelfList().done());
		synchronized(storageSpace){ 
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected GoodsShelf createGoodsShelf(RetailscmUserContext userContext, String location, String supplierSpaceId, String damageSpaceId) throws Exception{

		GoodsShelf goodsShelf = new GoodsShelf();
		
		
		goodsShelf.setLocation(location);		
		SupplierSpace  supplierSpace = new SupplierSpace();
		supplierSpace.setId(supplierSpaceId);		
		goodsShelf.setSupplierSpace(supplierSpace);		
		DamageSpace  damageSpace = new DamageSpace();
		damageSpace.setId(damageSpaceId);		
		goodsShelf.setDamageSpace(damageSpace);
	
		
		return goodsShelf;
	
		
	}
	
	protected GoodsShelf createIndexedGoodsShelf(String id, int version){

		GoodsShelf goodsShelf = new GoodsShelf();
		goodsShelf.setId(id);
		goodsShelf.setVersion(version);
		return goodsShelf;			
		
	}
	
	protected void checkParamsForRemovingGoodsShelfList(RetailscmUserContext userContext, String storageSpaceId, 
			String goodsShelfIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		for(String goodsShelfId: goodsShelfIds){
			userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);
		
	}
	public  StorageSpace removeGoodsShelfList(RetailscmUserContext userContext, String storageSpaceId, 
			String goodsShelfIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsShelfList(userContext, storageSpaceId,  goodsShelfIds, tokensExpr);
			
			
			StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
			synchronized(storageSpace){ 
				//Will be good when the storageSpace loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getStorageSpaceDAO().planToRemoveGoodsShelfList(storageSpace, goodsShelfIds, allTokens());
				storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
				deleteRelationListInGraph(userContext, storageSpace.getGoodsShelfList());
				return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfStorageSpace( storageSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);
	
	}
	public  StorageSpace removeGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsShelf(userContext,storageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		synchronized(storageSpace){ 
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			storageSpace.removeGoodsShelf( goodsShelf );		
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			deleteRelationInGraph(userContext, goodsShelf);
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfStorageSpace( storageSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);
	
	}
	public  StorageSpace copyGoodsShelfFrom(RetailscmUserContext userContext, String storageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsShelf(userContext,storageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, allTokens());
		synchronized(storageSpace){ 
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			storageSpace.copyGoodsShelfFrom( goodsShelf );		
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			
			userContext.getManagerGroup().getGoodsShelfManager().onNewInstanceCreated(userContext, (GoodsShelf)storageSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfStorageSpace(storageSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		

		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfGoodsShelf(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(StorageSpaceManagerException.class);
	
	}
	
	public  StorageSpace updateGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsShelf(userContext, storageSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsShelfList().searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, "eq", goodsShelfId).done();
		
		
		
		StorageSpace storageSpace = loadStorageSpace(userContext, storageSpaceId, loadTokens);
		
		synchronized(storageSpace){ 
			//Will be good when the storageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//storageSpace.removeGoodsShelf( goodsShelf );	
			//make changes to AcceleraterAccount.
			GoodsShelf goodsShelfIndex = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		
			GoodsShelf goodsShelf = storageSpace.findTheGoodsShelf(goodsShelfIndex);
			if(goodsShelf == null){
				throw new StorageSpaceManagerException(goodsShelf+" is NOT FOUND" );
			}
			
			goodsShelf.changeProperty(property, newValueExpr);
			
			storageSpace = saveStorageSpace(userContext, storageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,storageSpace, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, StorageSpace newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


