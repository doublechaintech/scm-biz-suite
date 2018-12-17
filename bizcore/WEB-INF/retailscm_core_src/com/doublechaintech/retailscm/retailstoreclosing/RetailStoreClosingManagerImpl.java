
package com.doublechaintech.retailscm.retailstoreclosing;

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

import com.doublechaintech.retailscm.retailstore.RetailStore;


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;






public class RetailStoreClosingManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreClosingManager {
	
	private static final String SERVICE_TYPE = "RetailStoreClosing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreClosingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreClosingManagerException(message);

	}
	
	

 	protected RetailStoreClosing saveRetailStoreClosing(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreClosingDAO().save(retailStoreClosing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreClosing(userContext, retailStoreClosing, tokens);
 	}
 	
 	protected RetailStoreClosing saveRetailStoreClosingDetail(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing) throws Exception{	

 		
 		return saveRetailStoreClosing(userContext, retailStoreClosing, allTokens());
 	}
 	
 	public RetailStoreClosing loadRetailStoreClosing(RetailscmUserContext userContext, String retailStoreClosingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreClosing(retailStoreClosingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreClosing, tokens);
 	}
 	
 	
 	 public RetailStoreClosing searchRetailStoreClosing(RetailscmUserContext userContext, String retailStoreClosingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreClosing(retailStoreClosingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreClosing, tokens);
 	}
 	
 	

 	protected RetailStoreClosing present(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreClosing,tokens);
		
		
		RetailStoreClosing  retailStoreClosingToPresent = userContext.getDAOGroup().getRetailStoreClosingDAO().present(retailStoreClosing, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreClosingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreClosingDAO().alias(entityListToNaming);
		
		return  retailStoreClosingToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreClosing loadRetailStoreClosingDetail(RetailscmUserContext userContext, String retailStoreClosingId) throws Exception{	
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, allTokens());
 		return present(userContext,retailStoreClosing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreClosingId) throws Exception{	
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, viewTokens());
 		return present(userContext,retailStoreClosing, allTokens());
		
 	}
 	protected RetailStoreClosing saveRetailStoreClosing(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreClosingDAO().save(retailStoreClosing, tokens);
 	}
 	protected RetailStoreClosing loadRetailStoreClosing(RetailscmUserContext userContext, String retailStoreClosingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreClosing(retailStoreClosingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreClosingDAO().load(retailStoreClosingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreClosing, tokens);
		
		addAction(userContext, retailStoreClosing, tokens,"@create","createRetailStoreClosing","createRetailStoreClosing/","main","primary");
		addAction(userContext, retailStoreClosing, tokens,"@update","updateRetailStoreClosing","updateRetailStoreClosing/"+retailStoreClosing.getId()+"/","main","primary");
		addAction(userContext, retailStoreClosing, tokens,"@copy","cloneRetailStoreClosing","cloneRetailStoreClosing/"+retailStoreClosing.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.addRetailStore","addRetailStore","addRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreClosing createRetailStoreClosing(RetailscmUserContext userContext,String comment) throws Exception
	{
		
		

		

		userContext.getChecker().checkCommentOfRetailStoreClosing(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);


		RetailStoreClosing retailStoreClosing=createNewRetailStoreClosing();	

		retailStoreClosing.setComment(comment);

		retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreClosing);
		return retailStoreClosing;

		
	}
	protected RetailStoreClosing createNewRetailStoreClosing() 
	{
		
		return new RetailStoreClosing();		
	}
	
	protected void checkParamsForUpdatingRetailStoreClosing(RetailscmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreClosing(retailStoreClosingId);
		userContext.getChecker().checkVersionOfRetailStoreClosing( retailStoreClosingVersion);
		

		if(RetailStoreClosing.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfRetailStoreClosing(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);
	
		
	}
	
	
	
	public RetailStoreClosing clone(RetailscmUserContext userContext, String fromRetailStoreClosingId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreClosingDAO().clone(fromRetailStoreClosingId, this.allTokens());
	}
	
	public RetailStoreClosing internalSaveRetailStoreClosing(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing) throws Exception 
	{
		return internalSaveRetailStoreClosing(userContext, retailStoreClosing, allTokens());

	}
	public RetailStoreClosing internalSaveRetailStoreClosing(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreClosing(userContext, retailStoreClosingId, retailStoreClosingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreClosing){ 
			//will be good when the retailStoreClosing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreClosing.
			
			
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, options);
			return retailStoreClosing;
			
		}

	}
	
	public RetailStoreClosing updateRetailStoreClosing(RetailscmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreClosing(userContext, retailStoreClosingId, retailStoreClosingVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		if(retailStoreClosing.getVersion() != retailStoreClosingVersion){
			String message = "The target version("+retailStoreClosing.getVersion()+") is not equals to version("+retailStoreClosingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreClosing){ 
			//will be good when the retailStoreClosing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreClosing.
			
			retailStoreClosing.changeProperty(property, newValueExpr);
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
			//return saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
		}

	}
	
	public RetailStoreClosing updateRetailStoreClosingProperty(RetailscmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreClosing(userContext, retailStoreClosingId, retailStoreClosingVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		if(retailStoreClosing.getVersion() != retailStoreClosingVersion){
			String message = "The target version("+retailStoreClosing.getVersion()+") is not equals to version("+retailStoreClosingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreClosing){ 
			//will be good when the retailStoreClosing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreClosing.
			
			retailStoreClosing.changeProperty(property, newValueExpr);
			
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
			//return saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreClosingTokens tokens(){
		return RetailStoreClosingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreClosingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreClosingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreClosingId, int retailStoreClosingVersion) throws Exception {
		//deleteInternal(userContext, retailStoreClosingId, retailStoreClosingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreClosingId, int retailStoreClosingVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreClosingDAO().delete(retailStoreClosingId, retailStoreClosingVersion);
	}
	
	public RetailStoreClosing forgetByAll(RetailscmUserContext userContext, String retailStoreClosingId, int retailStoreClosingVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreClosingId, retailStoreClosingVersion);		
	}
	protected RetailStoreClosing forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreClosingId, int retailStoreClosingVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreClosingDAO().disconnectFromAll(retailStoreClosingId, retailStoreClosingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreClosingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreClosingDAO().deleteAll();
	}


	//disconnect RetailStoreClosing with retail_store_country_center in RetailStore
	protected RetailStoreClosing breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreClosingId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());

			synchronized(retailStoreClosing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreClosingDAO().planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreClosing, retailStoreCountryCenterId, this.emptyOptions());

				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				return retailStoreClosing;
			}
	}
	//disconnect RetailStoreClosing with city_service_center in RetailStore
	protected RetailStoreClosing breakWithRetailStoreByCityServiceCenter(RetailscmUserContext userContext, String retailStoreClosingId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());

			synchronized(retailStoreClosing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreClosingDAO().planToRemoveRetailStoreListWithCityServiceCenter(retailStoreClosing, cityServiceCenterId, this.emptyOptions());

				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				return retailStoreClosing;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreClosing(retailStoreClosingId);

		
		userContext.getChecker().checkNameOfRetailStore(name);
		
		userContext.getChecker().checkTelephoneOfRetailStore(telephone);
		
		userContext.getChecker().checkOwnerOfRetailStore(owner);
		
		userContext.getChecker().checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		userContext.getChecker().checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		userContext.getChecker().checkFoundedOfRetailStore(founded);
		
		userContext.getChecker().checkLatitudeOfRetailStore(latitude);
		
		userContext.getChecker().checkLongitudeOfRetailStore(longitude);
		
		userContext.getChecker().checkDescriptionOfRetailStore(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);

	
	}
	public  RetailStoreClosing addRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreClosingId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		synchronized(retailStoreClosing){ 
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreClosing.addRetailStore( retailStore );		
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreClosingId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreClosing(retailStoreClosingId);
		userContext.getChecker().checkIdOfRetailStore(id);
		
		userContext.getChecker().checkNameOfRetailStore( name);
		userContext.getChecker().checkTelephoneOfRetailStore( telephone);
		userContext.getChecker().checkOwnerOfRetailStore( owner);
		userContext.getChecker().checkFoundedOfRetailStore( founded);
		userContext.getChecker().checkLatitudeOfRetailStore( latitude);
		userContext.getChecker().checkLongitudeOfRetailStore( longitude);
		userContext.getChecker().checkDescriptionOfRetailStore( description);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);
		
	}
	public  RetailStoreClosing updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreClosingId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreClosingId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();
		
		RetailStoreClosing retailStoreClosingToUpdate = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		if(retailStoreClosingToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreClosingManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStore item = retailStoreClosingToUpdate.getRetailStoreList().first();
		
		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );

		
		//checkParamsForAddingRetailStore(userContext,retailStoreClosingId,name, code, used,tokensExpr);
		RetailStoreClosing retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosingToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreClosing){ 
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

		RetailStore retailStore = new RetailStore();
		
		
		retailStore.setName(name);		
		retailStore.setTelephone(telephone);		
		retailStore.setOwner(owner);		
		RetailStoreCountryCenter  retailStoreCountryCenter = new RetailStoreCountryCenter();
		retailStoreCountryCenter.setId(retailStoreCountryCenterId);		
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);		
		RetailStoreCityServiceCenter  cityServiceCenter = new RetailStoreCityServiceCenter();
		cityServiceCenter.setId(cityServiceCenterId);		
		retailStore.setCityServiceCenter(cityServiceCenter);		
		retailStore.setFounded(founded);		
		retailStore.setLatitude(latitude);		
		retailStore.setLongitude(longitude);		
		retailStore.setDescription(description);		
		retailStore.setLastUpdateTime(userContext.now());		
		retailStore.setCurrentStatus("INIT");
	
		
		return retailStore;
	
		
	}
	
	protected RetailStore createIndexedRetailStore(String id, int version){

		RetailStore retailStore = new RetailStore();
		retailStore.setId(id);
		retailStore.setVersion(version);
		return retailStore;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreClosingId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreClosing(retailStoreClosingId);
		for(String retailStoreId: retailStoreIds){
			userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);
		
	}
	public  RetailStoreClosing removeRetailStoreList(RetailscmUserContext userContext, String retailStoreClosingId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreList(userContext, retailStoreClosingId,  retailStoreIds, tokensExpr);
			
			
			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
			synchronized(retailStoreClosing){ 
				//Will be good when the retailStoreClosing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreClosingDAO().planToRemoveRetailStoreList(retailStoreClosing, retailStoreIds, allTokens());
				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreClosing.getRetailStoreList());
				return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreClosing( retailStoreClosingId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);
	
	}
	public  RetailStoreClosing removeRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreClosingId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		synchronized(retailStoreClosing){ 
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreClosing.removeRetailStore( retailStore );		
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreClosing( retailStoreClosingId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);
	
	}
	public  RetailStoreClosing copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreClosingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreClosingId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		synchronized(retailStoreClosing){ 
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStore.updateLastUpdateTime(userContext.now());
			
			retailStoreClosing.copyRetailStoreFrom( retailStore );		
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreClosing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreClosing(retailStoreClosingId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStore(parseString(newValueExpr));
		}
		
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkTelephoneOfRetailStore(parseString(newValueExpr));
		}
		
		if(RetailStore.OWNER_PROPERTY.equals(property)){
			userContext.getChecker().checkOwnerOfRetailStore(parseString(newValueExpr));
		}
		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
			userContext.getChecker().checkFoundedOfRetailStore(parseDate(newValueExpr));
		}
		
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLatitudeOfRetailStore(parseBigDecimal(newValueExpr));
		}
		
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
			userContext.getChecker().checkLongitudeOfRetailStore(parseBigDecimal(newValueExpr));
		}
		
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfRetailStore(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);
	
	}
	
	public  RetailStoreClosing updateRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreClosingId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();
		
		
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, loadTokens);
		
		synchronized(retailStoreClosing){ 
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreClosing.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreClosing.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreClosingManagerException(retailStore+" is NOT FOUND" );
			}
			
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreClosing associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().createRetailStoreCreation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}	public  RetailStoreClosing associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().createRetailStoreInvestmentInvitation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}	public  RetailStoreClosing associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().createRetailStoreFranchising(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}	public  RetailStoreClosing associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().createRetailStoreDecoration(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}	public  RetailStoreClosing associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().createRetailStoreOpening(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}
	*/
	
	public  RetailStoreClosing associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().loadRetailStoreCreation(userContext,creationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}	public  RetailStoreClosing associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String investmentInvitationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().loadRetailStoreInvestmentInvitation(userContext,investmentInvitationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}	public  RetailStoreClosing associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String franchisingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().loadRetailStoreFranchising(userContext,franchisingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}	public  RetailStoreClosing associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String decorationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().loadRetailStoreDecoration(userContext,decorationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}	public  RetailStoreClosing associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreClosingId, String  retailStoreIds[], String openingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().loadRetailStoreOpening(userContext,openingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreClosing.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreClosing(userContext, retailStoreClosing);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreClosing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


