
package com.doublechaintech.retailscm.warehouseasset;

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

import com.doublechaintech.retailscm.warehouse.CandidateWarehouse;







public class WarehouseAssetManagerImpl extends CustomRetailscmCheckerManager implements WarehouseAssetManager {
	
	private static final String SERVICE_TYPE = "WarehouseAsset";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws WarehouseAssetManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new WarehouseAssetManagerException(message);

	}
	
	

 	protected WarehouseAsset saveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, String [] tokensExpr) throws Exception{	
 		//return getWarehouseAssetDAO().save(warehouseAsset, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWarehouseAsset(userContext, warehouseAsset, tokens);
 	}
 	
 	protected WarehouseAsset saveWarehouseAssetDetail(RetailscmUserContext userContext, WarehouseAsset warehouseAsset) throws Exception{	

 		
 		return saveWarehouseAsset(userContext, warehouseAsset, allTokens());
 	}
 	
 	public WarehouseAsset loadWarehouseAsset(RetailscmUserContext userContext, String warehouseAssetId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
		userContext.getChecker().throwExceptionIfHasErrors( WarehouseAssetManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,warehouseAsset, tokens);
 	}
 	
 	
 	 public WarehouseAsset searchWarehouseAsset(RetailscmUserContext userContext, String warehouseAssetId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
		userContext.getChecker().throwExceptionIfHasErrors( WarehouseAssetManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,warehouseAsset, tokens);
 	}
 	
 	

 	protected WarehouseAsset present(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,warehouseAsset,tokens);
		
		
		WarehouseAsset  warehouseAssetToPresent = userContext.getDAOGroup().getWarehouseAssetDAO().present(warehouseAsset, tokens);
		
		List<BaseEntity> entityListToNaming = warehouseAssetToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getWarehouseAssetDAO().alias(entityListToNaming);
		
		return  warehouseAssetToPresent;
		
		
	}
 
 	
 	
 	public WarehouseAsset loadWarehouseAssetDetail(RetailscmUserContext userContext, String warehouseAssetId) throws Exception{	
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, allTokens());
 		return present(userContext,warehouseAsset, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String warehouseAssetId) throws Exception{	
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, viewTokens());
 		return present(userContext,warehouseAsset, allTokens());
		
 	}
 	protected WarehouseAsset saveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getWarehouseAssetDAO().save(warehouseAsset, tokens);
 	}
 	protected WarehouseAsset loadWarehouseAsset(RetailscmUserContext userContext, String warehouseAssetId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
		userContext.getChecker().throwExceptionIfHasErrors( WarehouseAssetManagerException.class);

 
 		return userContext.getDAOGroup().getWarehouseAssetDAO().load(warehouseAssetId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens){
		super.addActions(userContext, warehouseAsset, tokens);
		
		addAction(userContext, warehouseAsset, tokens,"@create","createWarehouseAsset","createWarehouseAsset/","main","primary");
		addAction(userContext, warehouseAsset, tokens,"@update","updateWarehouseAsset","updateWarehouseAsset/"+warehouseAsset.getId()+"/","main","primary");
		addAction(userContext, warehouseAsset, tokens,"@copy","cloneWarehouseAsset","cloneWarehouseAsset/"+warehouseAsset.getId()+"/","main","primary");
		
		addAction(userContext, warehouseAsset, tokens,"warehouse_asset.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+warehouseAsset.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public WarehouseAsset createWarehouseAsset(RetailscmUserContext userContext,String name, String position, String ownerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfWarehouseAsset(name);
		userContext.getChecker().checkPositionOfWarehouseAsset(position);
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseAssetManagerException.class);


		WarehouseAsset warehouseAsset=createNewWarehouseAsset();	

		warehouseAsset.setName(name);
		warehouseAsset.setPosition(position);
			
		Warehouse owner = loadWarehouse(userContext, ownerId,emptyOptions());
		warehouseAsset.setOwner(owner);
		
		
		warehouseAsset.setLastUpdateTime(userContext.now());

		warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, emptyOptions());
		
		onNewInstanceCreated(userContext, warehouseAsset);
		return warehouseAsset;

		
	}
	protected WarehouseAsset createNewWarehouseAsset() 
	{
		
		return new WarehouseAsset();		
	}
	
	protected void checkParamsForUpdatingWarehouseAsset(RetailscmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
		userContext.getChecker().checkVersionOfWarehouseAsset( warehouseAssetVersion);
		

		if(WarehouseAsset.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfWarehouseAsset(parseString(newValueExpr));
		}
		if(WarehouseAsset.POSITION_PROPERTY.equals(property)){
			userContext.getChecker().checkPositionOfWarehouseAsset(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(WarehouseAssetManagerException.class);
	
		
	}
	
	
	
	public WarehouseAsset clone(RetailscmUserContext userContext, String fromWarehouseAssetId) throws Exception{
		
		return userContext.getDAOGroup().getWarehouseAssetDAO().clone(fromWarehouseAssetId, this.allTokens());
	}
	
	public WarehouseAsset internalSaveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset) throws Exception 
	{
		return internalSaveWarehouseAsset(userContext, warehouseAsset, allTokens());

	}
	public WarehouseAsset internalSaveWarehouseAsset(RetailscmUserContext userContext, WarehouseAsset warehouseAsset, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingWarehouseAsset(userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(warehouseAsset){ 
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WarehouseAsset.
			
			
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, options);
			return warehouseAsset;
			
		}

	}
	
	public WarehouseAsset updateWarehouseAsset(RetailscmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWarehouseAsset(userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);
		
		
		
		WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
		if(warehouseAsset.getVersion() != warehouseAssetVersion){
			String message = "The target version("+warehouseAsset.getVersion()+") is not equals to version("+warehouseAssetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(warehouseAsset){ 
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WarehouseAsset.
			warehouseAsset.updateLastUpdateTime(userContext.now());
			warehouseAsset.changeProperty(property, newValueExpr);
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
			return present(userContext,warehouseAsset, mergedAllTokens(tokensExpr));
			//return saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
		}

	}
	
	public WarehouseAsset updateWarehouseAssetProperty(RetailscmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWarehouseAsset(userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);
		
		WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
		if(warehouseAsset.getVersion() != warehouseAssetVersion){
			String message = "The target version("+warehouseAsset.getVersion()+") is not equals to version("+warehouseAssetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(warehouseAsset){ 
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WarehouseAsset.
			
			warehouseAsset.changeProperty(property, newValueExpr);
			warehouseAsset.updateLastUpdateTime(userContext.now());
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
			return present(userContext,warehouseAsset, mergedAllTokens(tokensExpr));
			//return saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected WarehouseAssetTokens tokens(){
		return WarehouseAssetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WarehouseAssetTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WarehouseAssetTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String warehouseAssetId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfWarehouseAsset(warehouseAssetId);
 		userContext.getChecker().checkIdOfWarehouse(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(WarehouseAssetManagerException.class);
 		
 	}
 	public WarehouseAsset transferToAnotherOwner(RetailscmUserContext userContext, String warehouseAssetId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, warehouseAssetId,anotherOwnerId);
 
		WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());	
		synchronized(warehouseAsset){
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse owner = loadWarehouse(userContext, anotherOwnerId, emptyOptions());		
			warehouseAsset.updateOwner(owner);		
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, emptyOptions());
			
			return present(userContext,warehouseAsset, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateWarehouse requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<Warehouse> candidateList = userContext.getDAOGroup().getWarehouseDAO().requestCandidateWarehouseForWarehouseAsset(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getWarehouseDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String warehouseAssetId, int warehouseAssetVersion) throws Exception {
		//deleteInternal(userContext, warehouseAssetId, warehouseAssetVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String warehouseAssetId, int warehouseAssetVersion) throws Exception{
			
		userContext.getDAOGroup().getWarehouseAssetDAO().delete(warehouseAssetId, warehouseAssetVersion);
	}
	
	public WarehouseAsset forgetByAll(RetailscmUserContext userContext, String warehouseAssetId, int warehouseAssetVersion) throws Exception {
		return forgetByAllInternal(userContext, warehouseAssetId, warehouseAssetVersion);		
	}
	protected WarehouseAsset forgetByAllInternal(RetailscmUserContext userContext,
			String warehouseAssetId, int warehouseAssetVersion) throws Exception{
			
		return userContext.getDAOGroup().getWarehouseAssetDAO().disconnectFromAll(warehouseAssetId, warehouseAssetVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WarehouseAssetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getWarehouseAssetDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, WarehouseAsset newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


