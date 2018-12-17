
package com.doublechaintech.retailscm.supplierspace;

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






public class SupplierSpaceManagerImpl extends CustomRetailscmCheckerManager implements SupplierSpaceManager {
	
	private static final String SERVICE_TYPE = "SupplierSpace";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplierSpaceManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplierSpaceManagerException(message);

	}
	
	

 	protected SupplierSpace saveSupplierSpace(RetailscmUserContext userContext, SupplierSpace supplierSpace, String [] tokensExpr) throws Exception{	
 		//return getSupplierSpaceDAO().save(supplierSpace, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplierSpace(userContext, supplierSpace, tokens);
 	}
 	
 	protected SupplierSpace saveSupplierSpaceDetail(RetailscmUserContext userContext, SupplierSpace supplierSpace) throws Exception{	

 		
 		return saveSupplierSpace(userContext, supplierSpace, allTokens());
 	}
 	
 	public SupplierSpace loadSupplierSpace(RetailscmUserContext userContext, String supplierSpaceId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplierSpaceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierSpace, tokens);
 	}
 	
 	
 	 public SupplierSpace searchSupplierSpace(RetailscmUserContext userContext, String supplierSpaceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplierSpaceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierSpace, tokens);
 	}
 	
 	

 	protected SupplierSpace present(RetailscmUserContext userContext, SupplierSpace supplierSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplierSpace,tokens);
		
		
		SupplierSpace  supplierSpaceToPresent = userContext.getDAOGroup().getSupplierSpaceDAO().present(supplierSpace, tokens);
		
		List<BaseEntity> entityListToNaming = supplierSpaceToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplierSpaceDAO().alias(entityListToNaming);
		
		return  supplierSpaceToPresent;
		
		
	}
 
 	
 	
 	public SupplierSpace loadSupplierSpaceDetail(RetailscmUserContext userContext, String supplierSpaceId) throws Exception{	
 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, allTokens());
 		return present(userContext,supplierSpace, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplierSpaceId) throws Exception{	
 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, viewTokens());
 		return present(userContext,supplierSpace, allTokens());
		
 	}
 	protected SupplierSpace saveSupplierSpace(RetailscmUserContext userContext, SupplierSpace supplierSpace, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplierSpaceDAO().save(supplierSpace, tokens);
 	}
 	protected SupplierSpace loadSupplierSpace(RetailscmUserContext userContext, String supplierSpaceId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplierSpaceManagerException.class);

 
 		return userContext.getDAOGroup().getSupplierSpaceDAO().load(supplierSpaceId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplierSpace supplierSpace, Map<String, Object> tokens){
		super.addActions(userContext, supplierSpace, tokens);
		
		addAction(userContext, supplierSpace, tokens,"@create","createSupplierSpace","createSupplierSpace/","main","primary");
		addAction(userContext, supplierSpace, tokens,"@update","updateSupplierSpace","updateSupplierSpace/"+supplierSpace.getId()+"/","main","primary");
		addAction(userContext, supplierSpace, tokens,"@copy","cloneSupplierSpace","cloneSupplierSpace/"+supplierSpace.getId()+"/","main","primary");
		
		addAction(userContext, supplierSpace, tokens,"supplier_space.transfer_to_warehouse","transferToAnotherWarehouse","transferToAnotherWarehouse/"+supplierSpace.getId()+"/","main","primary");
		addAction(userContext, supplierSpace, tokens,"supplier_space.addGoodsShelf","addGoodsShelf","addGoodsShelf/"+supplierSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, supplierSpace, tokens,"supplier_space.removeGoodsShelf","removeGoodsShelf","removeGoodsShelf/"+supplierSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, supplierSpace, tokens,"supplier_space.updateGoodsShelf","updateGoodsShelf","updateGoodsShelf/"+supplierSpace.getId()+"/","goodsShelfList","primary");
		addAction(userContext, supplierSpace, tokens,"supplier_space.copyGoodsShelfFrom","copyGoodsShelfFrom","copyGoodsShelfFrom/"+supplierSpace.getId()+"/","goodsShelfList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplierSpace supplierSpace, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplierSpace createSupplierSpace(RetailscmUserContext userContext,String location, String contactNumber, String totalArea, String warehouseId, BigDecimal latitude, BigDecimal longitude) throws Exception
	{
		
		

		

		userContext.getChecker().checkLocationOfSupplierSpace(location);
		userContext.getChecker().checkContactNumberOfSupplierSpace(contactNumber);
		userContext.getChecker().checkTotalAreaOfSupplierSpace(totalArea);
		userContext.getChecker().checkLatitudeOfSupplierSpace(latitude);
		userContext.getChecker().checkLongitudeOfSupplierSpace(longitude);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);


		SupplierSpace supplierSpace=createNewSupplierSpace();	

		supplierSpace.setLocation(location);
		supplierSpace.setContactNumber(contactNumber);
		supplierSpace.setTotalArea(totalArea);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		supplierSpace.setWarehouse(warehouse);
		
		
		supplierSpace.setLatitude(latitude);
		supplierSpace.setLongitude(longitude);

		supplierSpace = saveSupplierSpace(userContext, supplierSpace, emptyOptions());
		
		onNewInstanceCreated(userContext, supplierSpace);
		return supplierSpace;

		
	}
	protected SupplierSpace createNewSupplierSpace() 
	{
		
		return new SupplierSpace();		
	}
	
	protected void checkParamsForUpdatingSupplierSpace(RetailscmUserContext userContext,String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().checkVersionOfSupplierSpace( supplierSpaceVersion);
		

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
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);
	
		
	}
	
	
	
	public SupplierSpace clone(RetailscmUserContext userContext, String fromSupplierSpaceId) throws Exception{
		
		return userContext.getDAOGroup().getSupplierSpaceDAO().clone(fromSupplierSpaceId, this.allTokens());
	}
	
	public SupplierSpace internalSaveSupplierSpace(RetailscmUserContext userContext, SupplierSpace supplierSpace) throws Exception 
	{
		return internalSaveSupplierSpace(userContext, supplierSpace, allTokens());

	}
	public SupplierSpace internalSaveSupplierSpace(RetailscmUserContext userContext, SupplierSpace supplierSpace, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplierSpace(userContext, supplierSpaceId, supplierSpaceVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplierSpace){ 
			//will be good when the supplierSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplierSpace.
			
			
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, options);
			return supplierSpace;
			
		}

	}
	
	public SupplierSpace updateSupplierSpace(RetailscmUserContext userContext,String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplierSpace(userContext, supplierSpaceId, supplierSpaceVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		if(supplierSpace.getVersion() != supplierSpaceVersion){
			String message = "The target version("+supplierSpace.getVersion()+") is not equals to version("+supplierSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplierSpace){ 
			//will be good when the supplierSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplierSpace.
			
			supplierSpace.changeProperty(property, newValueExpr);
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
			//return saveSupplierSpace(userContext, supplierSpace, tokens().done());
		}

	}
	
	public SupplierSpace updateSupplierSpaceProperty(RetailscmUserContext userContext,String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplierSpace(userContext, supplierSpaceId, supplierSpaceVersion, property, newValueExpr, tokensExpr);
		
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		if(supplierSpace.getVersion() != supplierSpaceVersion){
			String message = "The target version("+supplierSpace.getVersion()+") is not equals to version("+supplierSpaceVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplierSpace){ 
			//will be good when the supplierSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplierSpace.
			
			supplierSpace.changeProperty(property, newValueExpr);
			
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
			//return saveSupplierSpace(userContext, supplierSpace, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplierSpaceTokens tokens(){
		return SupplierSpaceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplierSpaceTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortGoodsShelfListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplierSpaceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailscmUserContext userContext, String supplierSpaceId, String anotherWarehouseId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
 		userContext.getChecker().checkIdOfWarehouse(anotherWarehouseId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);
 		
 	}
 	public SupplierSpace transferToAnotherWarehouse(RetailscmUserContext userContext, String supplierSpaceId, String anotherWarehouseId) throws Exception
 	{
 		checkParamsForTransferingAnotherWarehouse(userContext, supplierSpaceId,anotherWarehouseId);
 
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());	
		synchronized(supplierSpace){
			//will be good when the supplierSpace loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse warehouse = loadWarehouse(userContext, anotherWarehouseId, emptyOptions());		
			supplierSpace.updateWarehouse(warehouse);		
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, emptyOptions());
			
			return present(userContext,supplierSpace, allTokens());
			
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
		SmartList<Warehouse> candidateList = userContext.getDAOGroup().getWarehouseDAO().requestCandidateWarehouseForSupplierSpace(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String supplierSpaceId, int supplierSpaceVersion) throws Exception {
		//deleteInternal(userContext, supplierSpaceId, supplierSpaceVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplierSpaceId, int supplierSpaceVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplierSpaceDAO().delete(supplierSpaceId, supplierSpaceVersion);
	}
	
	public SupplierSpace forgetByAll(RetailscmUserContext userContext, String supplierSpaceId, int supplierSpaceVersion) throws Exception {
		return forgetByAllInternal(userContext, supplierSpaceId, supplierSpaceVersion);		
	}
	protected SupplierSpace forgetByAllInternal(RetailscmUserContext userContext,
			String supplierSpaceId, int supplierSpaceVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplierSpaceDAO().disconnectFromAll(supplierSpaceId, supplierSpaceVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplierSpaceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplierSpaceDAO().deleteAll();
	}


	//disconnect SupplierSpace with storage_space in GoodsShelf
	protected SupplierSpace breakWithGoodsShelfByStorageSpace(RetailscmUserContext userContext, String supplierSpaceId, String storageSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());

			synchronized(supplierSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplierSpaceDAO().planToRemoveGoodsShelfListWithStorageSpace(supplierSpace, storageSpaceId, this.emptyOptions());

				supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
				return supplierSpace;
			}
	}
	//disconnect SupplierSpace with damage_space in GoodsShelf
	protected SupplierSpace breakWithGoodsShelfByDamageSpace(RetailscmUserContext userContext, String supplierSpaceId, String damageSpaceId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());

			synchronized(supplierSpace){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSupplierSpaceDAO().planToRemoveGoodsShelfListWithDamageSpace(supplierSpace, damageSpaceId, this.emptyOptions());

				supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
				return supplierSpace;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);

		
		userContext.getChecker().checkLocationOfGoodsShelf(location);
		
		userContext.getChecker().checkStorageSpaceIdOfGoodsShelf(storageSpaceId);
		
		userContext.getChecker().checkDamageSpaceIdOfGoodsShelf(damageSpaceId);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);

	
	}
	public  SupplierSpace addGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsShelf(userContext,supplierSpaceId,location, storageSpaceId, damageSpaceId,tokensExpr);
		
		GoodsShelf goodsShelf = createGoodsShelf(userContext,location, storageSpaceId, damageSpaceId);
		
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		synchronized(supplierSpace){ 
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierSpace.addGoodsShelf( goodsShelf );		
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			
			userContext.getManagerGroup().getGoodsShelfManager().onNewInstanceCreated(userContext, goodsShelf);
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsShelfProperties(RetailscmUserContext userContext, String supplierSpaceId,String id,String location,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(id);
		
		userContext.getChecker().checkLocationOfGoodsShelf( location);

		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);
		
	}
	public  SupplierSpace updateGoodsShelfProperties(RetailscmUserContext userContext, String supplierSpaceId, String id,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingGoodsShelfProperties(userContext,supplierSpaceId,id,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsShelfListList()
				.searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, "is", id).done();
		
		SupplierSpace supplierSpaceToUpdate = loadSupplierSpace(userContext, supplierSpaceId, options);
		
		if(supplierSpaceToUpdate.getGoodsShelfList().isEmpty()){
			throw new SupplierSpaceManagerException("GoodsShelf is NOT FOUND with id: '"+id+"'");
		}
		
		GoodsShelf item = supplierSpaceToUpdate.getGoodsShelfList().first();
		
		item.updateLocation( location );

		
		//checkParamsForAddingGoodsShelf(userContext,supplierSpaceId,name, code, used,tokensExpr);
		SupplierSpace supplierSpace = saveSupplierSpace(userContext, supplierSpaceToUpdate, tokens().withGoodsShelfList().done());
		synchronized(supplierSpace){ 
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected GoodsShelf createGoodsShelf(RetailscmUserContext userContext, String location, String storageSpaceId, String damageSpaceId) throws Exception{

		GoodsShelf goodsShelf = new GoodsShelf();
		
		
		goodsShelf.setLocation(location);		
		StorageSpace  storageSpace = new StorageSpace();
		storageSpace.setId(storageSpaceId);		
		goodsShelf.setStorageSpace(storageSpace);		
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
	
	protected void checkParamsForRemovingGoodsShelfList(RetailscmUserContext userContext, String supplierSpaceId, 
			String goodsShelfIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		for(String goodsShelfId: goodsShelfIds){
			userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);
		
	}
	public  SupplierSpace removeGoodsShelfList(RetailscmUserContext userContext, String supplierSpaceId, 
			String goodsShelfIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingGoodsShelfList(userContext, supplierSpaceId,  goodsShelfIds, tokensExpr);
			
			
			SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
			synchronized(supplierSpace){ 
				//Will be good when the supplierSpace loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSupplierSpaceDAO().planToRemoveGoodsShelfList(supplierSpace, goodsShelfIds, allTokens());
				supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
				deleteRelationListInGraph(userContext, supplierSpace.getGoodsShelfList());
				return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplierSpace( supplierSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);
	
	}
	public  SupplierSpace removeGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsShelf(userContext,supplierSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		synchronized(supplierSpace){ 
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierSpace.removeGoodsShelf( goodsShelf );		
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			deleteRelationInGraph(userContext, goodsShelf);
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSupplierSpace( supplierSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);
	
	}
	public  SupplierSpace copyGoodsShelfFrom(RetailscmUserContext userContext, String supplierSpaceId, 
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsShelf(userContext,supplierSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);
		
		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		synchronized(supplierSpace){ 
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			supplierSpace.copyGoodsShelfFrom( goodsShelf );		
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			
			userContext.getManagerGroup().getGoodsShelfManager().onNewInstanceCreated(userContext, (GoodsShelf)supplierSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSupplierSpace(supplierSpaceId);
		userContext.getChecker().checkIdOfGoodsShelf(goodsShelfId);
		userContext.getChecker().checkVersionOfGoodsShelf(goodsShelfVersion);
		

		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
			userContext.getChecker().checkLocationOfGoodsShelf(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplierSpaceManagerException.class);
	
	}
	
	public  SupplierSpace updateGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsShelf(userContext, supplierSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withGoodsShelfList().searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, "eq", goodsShelfId).done();
		
		
		
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, loadTokens);
		
		synchronized(supplierSpace){ 
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplierSpace.removeGoodsShelf( goodsShelf );	
			//make changes to AcceleraterAccount.
			GoodsShelf goodsShelfIndex = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		
			GoodsShelf goodsShelf = supplierSpace.findTheGoodsShelf(goodsShelfIndex);
			if(goodsShelf == null){
				throw new SupplierSpaceManagerException(goodsShelf+" is NOT FOUND" );
			}
			
			goodsShelf.changeProperty(property, newValueExpr);
			
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplierSpace newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


