
package com.doublechaintech.retailscm.supplierspace;

import java.util.*;
import java.math.BigDecimal;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;



import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.warehouse.CandidateWarehouse;

import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;






public class SupplierSpaceManagerImpl extends CustomRetailscmCheckerManager implements SupplierSpaceManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = SupplierSpaceTokens.start().withTokenFromListName(listName).done();
		SupplierSpace  supplierSpace = (SupplierSpace) this.loadSupplierSpace(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = supplierSpace.collectRefercencesFromLists();
		supplierSpaceDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, supplierSpace, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SupplierSpaceGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "SupplierSpace";
	@Override
	public SupplierSpaceDAO daoOf(RetailscmUserContext userContext) {
		return supplierSpaceDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplierSpaceManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierSpace, tokens);
 	}
 	
 	
 	 public SupplierSpace searchSupplierSpace(RetailscmUserContext userContext, String supplierSpaceId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplierSpaceManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		SupplierSpace supplierSpace = loadSupplierSpace( userContext, supplierSpaceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplierSpace, tokens);
 	}
 	
 	

 	protected SupplierSpace present(RetailscmUserContext userContext, SupplierSpace supplierSpace, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplierSpace,tokens);
		
		
		SupplierSpace  supplierSpaceToPresent = supplierSpaceDaoOf(userContext).present(supplierSpace, tokens);
		
		List<BaseEntity> entityListToNaming = supplierSpaceToPresent.collectRefercencesFromLists();
		supplierSpaceDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,supplierSpace,tokens);
		
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
 		return supplierSpaceDaoOf(userContext).save(supplierSpace, tokens);
 	}
 	protected SupplierSpace loadSupplierSpace(RetailscmUserContext userContext, String supplierSpaceId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);
		checkerOf(userContext).throwExceptionIfHasErrors( SupplierSpaceManagerException.class);

 
 		return supplierSpaceDaoOf(userContext).load(supplierSpaceId, tokens);
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
	
 	
 	
 
 	
 	

	public SupplierSpace createSupplierSpace(RetailscmUserContext userContext, String location,String contactNumber,String totalArea,String warehouseId,BigDecimal latitude,BigDecimal longitude) throws Exception
	//public SupplierSpace createSupplierSpace(RetailscmUserContext userContext,String location, String contactNumber, String totalArea, String warehouseId, BigDecimal latitude, BigDecimal longitude) throws Exception
	{

		

		

		checkerOf(userContext).checkLocationOfSupplierSpace(location);
		checkerOf(userContext).checkContactNumberOfSupplierSpace(contactNumber);
		checkerOf(userContext).checkTotalAreaOfSupplierSpace(totalArea);
		checkerOf(userContext).checkLatitudeOfSupplierSpace(latitude);
		checkerOf(userContext).checkLongitudeOfSupplierSpace(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);


		SupplierSpace supplierSpace=createNewSupplierSpace();	

		supplierSpace.setLocation(location);
		supplierSpace.setContactNumber(contactNumber);
		supplierSpace.setTotalArea(totalArea);
			
		Warehouse warehouse = loadWarehouse(userContext, warehouseId,emptyOptions());
		supplierSpace.setWarehouse(warehouse);
		
		
		supplierSpace.setLatitude(latitude);
		supplierSpace.setLongitude(longitude);
		supplierSpace.setLastUpdateTime(userContext.now());

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
		

		
		
		checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);
		checkerOf(userContext).checkVersionOfSupplierSpace( supplierSpaceVersion);
		

		if(SupplierSpace.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfSupplierSpace(parseString(newValueExpr));
		
			
		}
		if(SupplierSpace.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfSupplierSpace(parseString(newValueExpr));
		
			
		}
		if(SupplierSpace.TOTAL_AREA_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAreaOfSupplierSpace(parseString(newValueExpr));
		
			
		}		

		
		if(SupplierSpace.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfSupplierSpace(parseBigDecimal(newValueExpr));
		
			
		}
		if(SupplierSpace.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfSupplierSpace(parseBigDecimal(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);


	}



	public SupplierSpace clone(RetailscmUserContext userContext, String fromSupplierSpaceId) throws Exception{

		return supplierSpaceDaoOf(userContext).clone(fromSupplierSpaceId, this.allTokens());
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
			if (supplierSpace.isChanged()){
			supplierSpace.updateLastUpdateTime(userContext.now());
			}
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
			supplierSpace.updateLastUpdateTime(userContext.now());
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
			supplierSpace.updateLastUpdateTime(userContext.now());
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplierSpaceTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWarehouse(RetailscmUserContext userContext, String supplierSpaceId, String anotherWarehouseId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);
 		checkerOf(userContext).checkIdOfWarehouse(anotherWarehouseId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);

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
		SmartList<Warehouse> candidateList = warehouseDaoOf(userContext).requestCandidateWarehouseForSupplierSpace(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected Warehouse loadWarehouse(RetailscmUserContext userContext, String newWarehouseId, Map<String,Object> options) throws Exception
 	{

 		return warehouseDaoOf(userContext).load(newWarehouseId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplierSpaceId, int supplierSpaceVersion) throws Exception {
		//deleteInternal(userContext, supplierSpaceId, supplierSpaceVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplierSpaceId, int supplierSpaceVersion) throws Exception{

		supplierSpaceDaoOf(userContext).delete(supplierSpaceId, supplierSpaceVersion);
	}

	public SupplierSpace forgetByAll(RetailscmUserContext userContext, String supplierSpaceId, int supplierSpaceVersion) throws Exception {
		return forgetByAllInternal(userContext, supplierSpaceId, supplierSpaceVersion);
	}
	protected SupplierSpace forgetByAllInternal(RetailscmUserContext userContext,
			String supplierSpaceId, int supplierSpaceVersion) throws Exception{

		return supplierSpaceDaoOf(userContext).disconnectFromAll(supplierSpaceId, supplierSpaceVersion);
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
		return supplierSpaceDaoOf(userContext).deleteAll();
	}


	//disconnect SupplierSpace with storage_space in GoodsShelf
	protected SupplierSpace breakWithGoodsShelfByStorageSpace(RetailscmUserContext userContext, String supplierSpaceId, String storageSpaceId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());

			synchronized(supplierSpace){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				supplierSpaceDaoOf(userContext).planToRemoveGoodsShelfListWithStorageSpace(supplierSpace, storageSpaceId, this.emptyOptions());

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

				supplierSpaceDaoOf(userContext).planToRemoveGoodsShelfListWithDamageSpace(supplierSpace, damageSpaceId, this.emptyOptions());

				supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
				return supplierSpace;
			}
	}






	protected void checkParamsForAddingGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);

		
		checkerOf(userContext).checkLocationOfGoodsShelf(location);
		
		checkerOf(userContext).checkStorageSpaceIdOfGoodsShelf(storageSpaceId);
		
		checkerOf(userContext).checkDamageSpaceIdOfGoodsShelf(damageSpaceId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);


	}
	public  SupplierSpace addGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoodsShelf(userContext,supplierSpaceId,location, storageSpaceId, damageSpaceId,tokensExpr);

		GoodsShelf goodsShelf = createGoodsShelf(userContext,location, storageSpaceId, damageSpaceId);

		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, emptyOptions());
		synchronized(supplierSpace){
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplierSpace.addGoodsShelf( goodsShelf );
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			
			goodsShelfManagerOf(userContext).onNewInstanceCreated(userContext, goodsShelf);
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsShelfProperties(RetailscmUserContext userContext, String supplierSpaceId,String id,String location,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);
		checkerOf(userContext).checkIdOfGoodsShelf(id);

		checkerOf(userContext).checkLocationOfGoodsShelf( location);

		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);

	}
	public  SupplierSpace updateGoodsShelfProperties(RetailscmUserContext userContext, String supplierSpaceId, String id,String location, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsShelfProperties(userContext,supplierSpaceId,id,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsShelfListList()
				.searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, tokens().is(), id).done();

		SupplierSpace supplierSpaceToUpdate = loadSupplierSpace(userContext, supplierSpaceId, options);

		if(supplierSpaceToUpdate.getGoodsShelfList().isEmpty()){
			throw new SupplierSpaceManagerException("GoodsShelf is NOT FOUND with id: '"+id+"'");
		}

		GoodsShelf item = supplierSpaceToUpdate.getGoodsShelfList().first();
		beforeUpdateGoodsShelfProperties(userContext,item, supplierSpaceId,id,location,tokensExpr);
		item.updateLocation( location );


		//checkParamsForAddingGoodsShelf(userContext,supplierSpaceId,name, code, used,tokensExpr);
		SupplierSpace supplierSpace = saveSupplierSpace(userContext, supplierSpaceToUpdate, tokens().withGoodsShelfList().done());
		synchronized(supplierSpace){
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateGoodsShelfProperties(RetailscmUserContext userContext, GoodsShelf item, String supplierSpaceId, String id,String location, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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
		goodsShelf.setLastUpdateTime(userContext.now());
	
		
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

		checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);
		for(String goodsShelfIdItem: goodsShelfIds){
			checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);

	}
	public  SupplierSpace removeGoodsShelfList(RetailscmUserContext userContext, String supplierSpaceId,
			String goodsShelfIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsShelfList(userContext, supplierSpaceId,  goodsShelfIds, tokensExpr);


			SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
			synchronized(supplierSpace){
				//Will be good when the supplierSpace loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				supplierSpaceDaoOf(userContext).planToRemoveGoodsShelfList(supplierSpace, goodsShelfIds, allTokens());
				supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
				deleteRelationListInGraph(userContext, supplierSpace.getGoodsShelfList());
				return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId,
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSupplierSpace( supplierSpaceId);
		checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
		checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);

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
		
		checkerOf(userContext).checkIdOfSupplierSpace( supplierSpaceId);
		checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
		checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);

	}
	public  SupplierSpace copyGoodsShelfFrom(RetailscmUserContext userContext, String supplierSpaceId,
		String goodsShelfId, int goodsShelfVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoodsShelf(userContext,supplierSpaceId, goodsShelfId, goodsShelfVersion,tokensExpr);

		GoodsShelf goodsShelf = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);
		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, allTokens());
		synchronized(supplierSpace){
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			goodsShelf.updateLastUpdateTime(userContext.now());

			supplierSpace.copyGoodsShelfFrom( goodsShelf );
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			
			goodsShelfManagerOf(userContext).onNewInstanceCreated(userContext, (GoodsShelf)supplierSpace.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSupplierSpace(supplierSpaceId);
		checkerOf(userContext).checkIdOfGoodsShelf(goodsShelfId);
		checkerOf(userContext).checkVersionOfGoodsShelf(goodsShelfVersion);


		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
			checkerOf(userContext).checkLocationOfGoodsShelf(parseString(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(SupplierSpaceManagerException.class);

	}

	public  SupplierSpace updateGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoodsShelf(userContext, supplierSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsShelfList().searchGoodsShelfListWith(GoodsShelf.ID_PROPERTY, tokens().equals(), goodsShelfId).done();



		SupplierSpace supplierSpace = loadSupplierSpace(userContext, supplierSpaceId, loadTokens);

		synchronized(supplierSpace){
			//Will be good when the supplierSpace loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplierSpace.removeGoodsShelf( goodsShelf );
			//make changes to AcceleraterAccount.
			GoodsShelf goodsShelfIdVersionKey = createIndexedGoodsShelf(goodsShelfId, goodsShelfVersion);

			GoodsShelf goodsShelf = supplierSpace.findTheGoodsShelf(goodsShelfIdVersionKey);
			if(goodsShelf == null){
				throw new SupplierSpaceManagerException(goodsShelfId+" is NOT FOUND" );
			}

			beforeUpdateGoodsShelf(userContext, goodsShelf, supplierSpaceId, goodsShelfId, goodsShelfVersion, property, newValueExpr,  tokensExpr);
			goodsShelf.changeProperty(property, newValueExpr);
			goodsShelf.updateLastUpdateTime(userContext.now());
			supplierSpace = saveSupplierSpace(userContext, supplierSpace, tokens().withGoodsShelfList().done());
			return present(userContext,supplierSpace, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateGoodsShelf(RetailscmUserContext userContext, GoodsShelf existed, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplierSpace newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    supplierSpaceDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}

		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
	}

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   SupplierSpace newSupplierSpace = this.createSupplierSpace(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSupplierSpace
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SupplierSpace.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<SupplierSpace> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<Warehouse> warehouseList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, Warehouse.class);
		userContext.getDAOGroup().enhanceList(warehouseList, Warehouse.class);


    }
	
	public Object listByWarehouse(RetailscmUserContext userContext,String warehouseId) throws Exception {
		return listPageByWarehouse(userContext, warehouseId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByWarehouse(RetailscmUserContext userContext,String warehouseId, int start, int count) throws Exception {
		SmartList<SupplierSpace> list = supplierSpaceDaoOf(userContext).findSupplierSpaceByWarehouse(warehouseId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(SupplierSpace.class);
		page.setContainerObject(Warehouse.withId(warehouseId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("供应商的空间列表");
		page.setRequestName("listByWarehouse");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByWarehouse/%s/",  getBeanName(), warehouseId)));

		page.assemblerContent(userContext, "listByWarehouse");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String supplierSpaceId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getSupplierSpaceDetailScope().clone();
		SupplierSpace merchantObj = (SupplierSpace) this.view(userContext, supplierSpaceId);
    String merchantObjId = supplierSpaceId;
    String linkToUrl =	"supplierSpaceManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "供应商的空间"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-location")
				    .put("fieldName", "location")
				    .put("label", "位置")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("location", merchantObj.getLocation());

		propList.add(
				MapUtil.put("id", "3-contactNumber")
				    .put("fieldName", "contactNumber")
				    .put("label", "联系电话")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactNumber", merchantObj.getContactNumber());

		propList.add(
				MapUtil.put("id", "4-totalArea")
				    .put("fieldName", "totalArea")
				    .put("label", "总面积")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("totalArea", merchantObj.getTotalArea());

		propList.add(
				MapUtil.put("id", "5-warehouse")
				    .put("fieldName", "warehouse")
				    .put("label", "仓库")
				    .put("type", "auto")
				    .put("linkToUrl", "warehouseManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"contact_number\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("warehouse", merchantObj.getWarehouse());

		propList.add(
				MapUtil.put("id", "6-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "7-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		propList.add(
				MapUtil.put("id", "8-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：goodsShelfListSection
		Map goodsShelfListSection = ListofUtils.buildSection(
		    "goodsShelfListSection",
		    "货架列表",
		    null,
		    "",
		    "__no_group",
		    "goodsShelfManager/listBySupplierSpace/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsShelfListSection);

		result.put("goodsShelfListSection", ListofUtils.toShortList(merchantObj.getGoodsShelfList(), "goodsShelf"));
		vscope.field("goodsShelfListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( GoodsShelf.class.getName(), null));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}



}


