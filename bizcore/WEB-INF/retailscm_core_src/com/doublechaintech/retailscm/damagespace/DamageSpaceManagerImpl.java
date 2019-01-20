
package com.doublechaintech.retailscm.damagespace;

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






public class DamageSpaceManagerImpl extends CustomRetailscmCheckerManager implements DamageSpaceManager {
	
	private static final String SERVICE_TYPE = "DamageSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws DamageSpaceManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new DamageSpaceManagerException(message);

	}
	
	

 	protected DamageSpace saveDamageSpace(RetailscmUserContext userContext, DamageSpace damageSpace, String [] tokensExpr) throws Exception{	
 		//return getDamageSpaceDAO().save(damageSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveDamageSpace(userContext, damageSpace, tokens);
 	}
 	
 	protected DamageSpace saveDamageSpaceDetail(RetailscmUserContext userContext, DamageSpace damageSpace) throws Exception{	

 		
 		return saveDamageSpace(userContext, damageSpace, allTokens());
 	}
 	
 	public DamageSpace loadDamageSpace(RetailscmUserContext userContext, String damageSpaceId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( DamageSpaceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		DamageSpace damageSpace = loadDamageSpace( userContext, damageSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,damageSpace, tokens);
 	}
 	
 	
 	 public DamageSpace searchDamageSpace(RetailscmUserContext userContext, String damageSpaceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( DamageSpaceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		DamageSpace damageSpace = loadDamageSpace( userContext, damageSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,damageSpace, tokens);
 	}
 	
 	

 	protected DamageSpace present(RetailscmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,damageSpace,tokens);
		
		
		DamageSpace  damageSpaceToPresent = userContext.getDAOGroup().getDamageSpaceDAO().present(damageSpace, tokens);
		
		List<BaseEntity> entityListToNaming = damageSpaceToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getDamageSpaceDAO().alias(entityListToNaming);
		
		return  damageSpaceToPresent;
		
		
	}
 
 	
 	
 	public DamageSpace loadDamageSpaceDetail(RetailscmUserContext userContext, String damageSpaceId) throws Exception{	
 		DamageSpace damageSpace = loadDamageSpace( userContext, damageSpaceId, allTokens());
 		return present(userContext,damageSpace, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String damageSpaceId) throws Exception{	
 		DamageSpace damageSpace = loadDamageSpace( userContext, damageSpaceId, viewTokens());
 		return present(userContext,damageSpace, allTokens());
		
 	}
 	protected DamageSpace saveDamageSpace(RetailscmUserContext userContext, DamageSpace damageSpace, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getDamageSpaceDAO().save(damageSpace, tokens);
 	}
 	protected DamageSpace loadDamageSpace(RetailscmUserContext userContext, String damageSpaceId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( DamageSpaceManagerException.class);

 
 		return userContext.getDAOGroup().getDamageSpaceDAO().load(damageSpaceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens){
		super.addActions(userContext, damageSpace, tokens);
		
		addAction(userContext, damageSpace, tokens,"@create","createDamageSpace","createDamageSpace/","main","primary");
		addAction(userContext, damageSpace, tokens,"@update","updateDamageSpace","updateDamageSpace/"+damageSpace.getId()+"/","main","primary");
		addAction(userContext, damageSpace, tokens,"@copy","cloneDamageSpace","cloneDamageSpace/"+damageSpace.getId()+"/","main","primary");
		
		addAction(userContext, damageSpace, tokens,"damage_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+damageSpace.getId()+"/","main","primary");
		addAction(userContext, damageSpace, tokens,"damage_space.addGoodsShelf","addGoodsShelf","addGoodsShelf/"+damageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, damageSpace, tokens,"damage_space.removeGoodsShelf","removeGoodsShelf","removeGoodsShelf/"+damageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, damageSpace, tokens,"damage_space.updateGoodsShelf","updateGoodsShelf","updateGoodsShelf/"+damageSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, damageSpace, tokens,"damage_space.copyGoodsShelfFrom","copyGoodsShelfFrom","copyGoodsShelfFrom/"+damageSpace.getId()+"/","goodsShelfList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, DamageSpace damageSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public DamageSpace createDamageSpace(RetailscmUserContext userContext,String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String warehouseId) throws Exception
	{
		
		

		

		userContext.getChecker().checkLocationOfDamageSpace(location);
		userContext.getChecker().checkContactNumberOfDamageSpace(contactNumber);
		userContext.getChecker().checkTotalAreaOfDamageSpace(totalArea);
		userContext.getChecker().checkLatitudeOfDamageSpace(latitude);
		userContext.getChecker().checkLongitudeOfDamageSpace(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);


		DamageSpace damageSpace=createNewDamageSpace();	

		damageSpace.setLocation(location);
		damageSpace.setContactNumber(contactNumber);
		damageSpace.setTotalArea(totalArea);
		damageSpace.setLatitude(latitude);
		damageSpace.setLongitude(longitude);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		damageSpace.setWarehouse(warehouse);
		
		
		damageSpace.setLastUpdateTime(userContext.now());

		damageSpace = saveDamageSpace(userContext, damageSpace, emptyOptions());
		
		onNewInstanceCreated(userContext, damageSpace);
		return damageSpace;

		
	}
	protected DamageSpace createNewDamageSpace() 
	{
		
		return new DamageSpace();		
	}
	
	protected void checkParamsForUpdatingDamageSpace(RetailscmUserContext userContext,String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().checkVersionOfDamageSpace( damageSpaceVersion);
		

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

		
	
		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);
	
		
	}
	
	
	
	public DamageSpace clone(RetailscmUserContext userContext, String fromDamageSpaceId) throws Exception{
		
		return userContext.getDAOGroup().getDamageSpaceDAO().clone(fromDamageSpaceId, this.allTokens());
	}
	
	public DamageSpace internalSaveDamageSpace(RetailscmUserContext userContext, DamageSpace damageSpace) throws Exception 
	{
		return internalSaveDamageSpace(userContext, damageSpace, allTokens());

	}
	public DamageSpace internalSaveDamageSpace(RetailscmUserContext userContext, DamageSpace damageSpace, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingDamageSpace(userContext, damageSpaceId, damageSpaceVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(damageSpace){ 
			//will be good when the damageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DamageSpace.
			
			
			damageSpace = saveDamageSpace(userContext, damageSpace, options);
			return damageSpace;
			
		}

	}
	
	public DamageSpace updateDamageSpace(RetailscmUserContext userContext,String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDamageSpace(userContext, damageSpaceId, damageSpaceVersion, property, newValueExpr, tokensExpr);
		
		
		
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		if(damageSpace.getVersion() != damageSpaceVersion){
			String message = "The target version("+damageSpace.getVersion()+") is not equals to version("+damageSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(damageSpace){ 
			//will be good when the damageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DamageSpace.
			damageSpace.updateLastUpdateTime(userContext.now());
			damageSpace.changeProperty(property, newValueExpr);
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().done());
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
			//return saveDamageSpace(userContext, damageSpace, tokens().done());
		}

	}
	
	public DamageSpace updateDamageSpaceProperty(RetailscmUserContext userContext,String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingDamageSpace(userContext, damageSpaceId, damageSpaceVersion, property, newValueExpr, tokensExpr);
		
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		if(damageSpace.getVersion() != damageSpaceVersion){
			String message = "The target version("+damageSpace.getVersion()+") is not equals to version("+damageSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(damageSpace){ 
			//will be good when the damageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to DamageSpace.
			
			damageSpace.changeProperty(property, newValueExpr);
			damageSpace.updateLastUpdateTime(userContext.now());
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().done());
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
			//return saveDamageSpace(userContext, damageSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected DamageSpaceTokens tokens(){
		return DamageSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return DamageSpaceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsShelfListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return DamageSpaceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailscmUserContext userContext, String damageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
 		userContext.getChecker().checkIdOfWarehouse(anotherWarehouseId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);
 		
 	}
 	public DamageSpace transferToAnotherWarehouse(RetailscmUserContext userContext, String damageSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, damageSpaceId,anotherWarehouseId);
 
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());	
		synchronized(damageSpace){
			//will be good when the damageSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());		
			damageSpace.updateWarehouse(warehouse);		
			damageSpace = saveDamageSpace(userContext, damageSpace, emptyOptions());
			
			return present(userContext,damageSpace, allTokens());
			
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
		SmartList<Warehouse> candidateList = userContext.getDAOGroup().getWarehouseDAO().requestCandidateWarehouseForDamageSpace(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String damageSpaceId, int damageSpaceVersion) throws Exception {
		//deleteInternal(userContext, damageSpaceId, damageSpaceVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String damageSpaceId, int damageSpaceVersion) throws Exception{
			
		userContext.getDAOGroup().getDamageSpaceDAO().delete(damageSpaceId, damageSpaceVersion);
	}
	
	public DamageSpace forgetByAll(RetailscmUserContext userContext, String damageSpaceId, int damageSpaceVersion) throws Exception {
		return forgetByAllInternal(userContext, damageSpaceId, damageSpaceVersion);		
	}
	protected DamageSpace forgetByAllInternal(RetailscmUserContext userContext,
			String damageSpaceId, int damageSpaceVersion) throws Exception{
			
		return userContext.getDAOGroup().getDamageSpaceDAO().disconnectFromAll(damageSpaceId, damageSpaceVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new DamageSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getDamageSpaceDAO().deleteAll();
	}


	//disconnect DamageSpace with storage_space in GoodsShelf
	protected DamageSpace breakWithGoodsShelfByStorageSpace(RetailscmUserContext userContext, String damageSpaceId, String storageSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());

			synchronized(damageSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDamageSpaceDAO().planToRemoveGoodsShelfListWithStorageSpace(damageSpace, storageSpaceId, this.emptyOptions());

				damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
				return damageSpace;
			}
	}
	//disconnect DamageSpace with supplier_space in GoodsShelf
	protected DamageSpace breakWithGoodsShelfBySupplierSpace(RetailscmUserContext userContext, String damageSpaceId, String supplierSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());

			synchronized(damageSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getDamageSpaceDAO().planToRemoveGoodsShelfListWithSupplierSpace(damageSpace, supplierSpaceId, this.emptyOptions());

				damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
				return damageSpace;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);

		
		userContext.getChecker().checkLocationOfGoodsShelf(location);
		
		userContext.getChecker().checkStorageSpaceIdOfGoodsShelf(storageSpaceId);
		
		userContext.getChecker().checkSupplierSpaceIdOfGoodsShelf(supplierSpaceId);
	
		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);

	
	}
	public  DamageSpace addGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsShelf(userContext,damageSpaceId,location, storageSpaceId, supplierSpaceId,tokensExpr);
		
		GoodsShelf goodsShelf = createGoodsShelf(userContext,location, storageSpaceId, supplierSpaceId);
		
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		synchronized(damageSpace){ 
			//Will be good when the damageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			damageSpace.addGoodsShelf( goodsShelf );		
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
			
			userContext.getManagerGroup().getGoodsShelfManager().onNewInstanceCreated(userContext, goodsShelf);
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsShelfProperties(RetailscmUserContext userContext, String damageSpaceId,String id,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(id);
		
		userContext.getChecker().checkLocationOfGoodsShelf( location);

		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);
		
	}
	public  DamageSpace updateGoodsShelfProperties(RetailscmUserContext userContext, String damageSpaceId, String id,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsShelfProperties(userContext,damageSpaceId,id,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsShelfListList()
				.searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, "is", id).done();
		
		DamageSpace damageSpaceToUpdate = loadDamageSpace(userContext, damageSpaceId, options);
		
		if(damageSpaceToUpdate.getGoodsShelfList().isEmpty()){
			throw new DamageSpaceManagerException("GoodsShelf is NOT FOUND with id: '"+id+"'");
		}
		
		GoodsShelf item = damageSpaceToUpdate.getGoodsShelfList().first();
		
		item.updateLocation( location );

		
		//checkParamsForAddingGoodsShelf(userContext,damageSpaceId,name, code, used,tokensExpr);
		DamageSpace damageSpace = saveDamageSpace(userContext, damageSpaceToUpdate, tokens().withGoodsShelfList().done());
		synchronized(damageSpace){ 
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected GoodsShelf createGoodsShelf(RetailscmUserContext userContext, String location, String storageSpaceId, String supplierSpaceId) throws Exception{

		GoodsShelf goodsShelf = new GoodsShelf();
		
		
		goodsShelf.setLocation(location);		
		StorageSpace  storageSpace = new StorageSpace();
		storageSpace.setId(storageSpaceId);		
		goodsShelf.setStorageSpace(storageSpace);		
		SupplierSpace  supplierSpace = new SupplierSpace();
		supplierSpace.setId(supplierSpaceId);		
		goodsShelf.setSupplierSpace(supplierSpace);		
		goodsShelf.setLastUpdateTime(userContext.now());
	
		
		return goodsShelf;
	
		
	}
	
	protected GoodsShelf createIndexedGoodsShelf(String id, int version){

		GoodsShelf goodsShelf = new GoodsShelf();
		goodsShelf.setId(id);
		goodsShelf.setVersion(version);
		return goodsShelf;			
		
	}
	
	protected void checkParamsForRemovingGoodsShelfList(RetailscmUserContext userContext, String damageSpaceId, 
			String goodsShelfIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		for(String goodsShelfId: goodsShelfIds){
			userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);
		
	}
	public  DamageSpace removeGoodsShelfList(RetailscmUserContext userContext, String damageSpaceId, 
			String goodsShelfIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsShelfList(userContext, damageSpaceId,  goodsShelfIds, tokensExpr);
			
			
			DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
			synchronized(damageSpace){ 
				//Will be good when the damageSpace loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getDamageSpaceDAO().planToRemoveGoodsShelfList(damageSpace, goodsShelfIds, allTokens());
				damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
				deleteRelationListInGraph(userContext, damageSpace.getGoodsShelfList());
				return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDamageSpace( damageSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);
	
	}
	public  DamageSpace removeGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsShelf(userContext,damageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		synchronized(damageSpace){ 
			//Will be good when the damageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			damageSpace.removeGoodsShelf( goodsShelf );		
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
			deleteRelationInGraph(userContext, goodsShelf);
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfDamageSpace( damageSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);
	
	}
	public  DamageSpace copyGoodsShelfFrom(RetailscmUserContext userContext, String damageSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsShelf(userContext,damageSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, allTokens());
		synchronized(damageSpace){ 
			//Will be good when the damageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			goodsShelf.updateLastUpdateTime(userContext.now());
			
			damageSpace.copyGoodsShelfFrom( goodsShelf );		
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
			
			userContext.getManagerGroup().getGoodsShelfManager().onNewInstanceCreated(userContext, (GoodsShelf)damageSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfDamageSpace(damageSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		

		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfGoodsShelf(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(DamageSpaceManagerException.class);
	
	}
	
	public  DamageSpace updateGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsShelf(userContext, damageSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsShelfList().searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, "eq", goodsShelfId).done();
		
		
		
		DamageSpace damageSpace = loadDamageSpace(userContext, damageSpaceId, loadTokens);
		
		synchronized(damageSpace){ 
			//Will be good when the damageSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//damageSpace.removeGoodsShelf( goodsShelf );	
			//make changes to AcceleraterAccount.
			GoodsShelf goodsShelfIndex = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		
			GoodsShelf goodsShelf = damageSpace.findTheGoodsShelf(goodsShelfIndex);
			if(goodsShelf == null){
				throw new DamageSpaceManagerException(goodsShelf+" is NOT FOUND" );
			}
			
			goodsShelf.changeProperty(property, newValueExpr);
			goodsShelf.updateLastUpdateTime(userContext.now());
			damageSpace = saveDamageSpace(userContext, damageSpace, tokens().withGoodsShelfList().done());
			return present(userContext,damageSpace, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, DamageSpace newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


