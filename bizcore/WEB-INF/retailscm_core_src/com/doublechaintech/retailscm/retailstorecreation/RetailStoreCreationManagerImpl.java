
package com.doublechaintech.retailscm.retailstorecreation;

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






public class RetailStoreCreationManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreCreationManager {
	
	private static final String SERVICE_TYPE = "RetailStoreCreation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreCreationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreCreationManagerException(message);

	}
	
	

 	protected RetailStoreCreation saveRetailStoreCreation(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreCreationDAO().save(retailStoreCreation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreCreation(userContext, retailStoreCreation, tokens);
 	}
 	
 	protected RetailStoreCreation saveRetailStoreCreationDetail(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation) throws Exception{	

 		
 		return saveRetailStoreCreation(userContext, retailStoreCreation, allTokens());
 	}
 	
 	public RetailStoreCreation loadRetailStoreCreation(RetailscmUserContext userContext, String retailStoreCreationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreCreation(retailStoreCreationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreCreationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCreation, tokens);
 	}
 	
 	
 	 public RetailStoreCreation searchRetailStoreCreation(RetailscmUserContext userContext, String retailStoreCreationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreCreation(retailStoreCreationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreCreationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCreation, tokens);
 	}
 	
 	

 	protected RetailStoreCreation present(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreCreation,tokens);
		
		
		RetailStoreCreation  retailStoreCreationToPresent = userContext.getDAOGroup().getRetailStoreCreationDAO().present(retailStoreCreation, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreCreationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreCreationDAO().alias(entityListToNaming);
		
		return  retailStoreCreationToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreCreation loadRetailStoreCreationDetail(RetailscmUserContext userContext, String retailStoreCreationId) throws Exception{	
 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, allTokens());
 		return present(userContext,retailStoreCreation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreCreationId) throws Exception{	
 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, viewTokens());
 		return present(userContext,retailStoreCreation, allTokens());
		
 	}
 	protected RetailStoreCreation saveRetailStoreCreation(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreCreationDAO().save(retailStoreCreation, tokens);
 	}
 	protected RetailStoreCreation loadRetailStoreCreation(RetailscmUserContext userContext, String retailStoreCreationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreCreation(retailStoreCreationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreCreationManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreCreationDAO().load(retailStoreCreationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreCreation, tokens);
		
		addAction(userContext, retailStoreCreation, tokens,"@create","createRetailStoreCreation","createRetailStoreCreation/","main","primary");
		addAction(userContext, retailStoreCreation, tokens,"@update","updateRetailStoreCreation","updateRetailStoreCreation/"+retailStoreCreation.getId()+"/","main","primary");
		addAction(userContext, retailStoreCreation, tokens,"@copy","cloneRetailStoreCreation","cloneRetailStoreCreation/"+retailStoreCreation.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreCreation, tokens,"retail_store_creation.addRetailStore","addRetailStore","addRetailStore/"+retailStoreCreation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCreation, tokens,"retail_store_creation.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreCreation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCreation, tokens,"retail_store_creation.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreCreation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCreation, tokens,"retail_store_creation.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreCreation.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreCreation createRetailStoreCreation(RetailscmUserContext userContext,String comment) throws Exception
	{
		
		

		

		userContext.getChecker().checkCommentOfRetailStoreCreation(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);


		RetailStoreCreation retailStoreCreation=createNewRetailStoreCreation();	

		retailStoreCreation.setComment(comment);

		retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreCreation);
		return retailStoreCreation;

		
	}
	protected RetailStoreCreation createNewRetailStoreCreation() 
	{
		
		return new RetailStoreCreation();		
	}
	
	protected void checkParamsForUpdatingRetailStoreCreation(RetailscmUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreCreation(retailStoreCreationId);
		userContext.getChecker().checkVersionOfRetailStoreCreation( retailStoreCreationVersion);
		

		if(RetailStoreCreation.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfRetailStoreCreation(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
	
		
	}
	
	
	
	public RetailStoreCreation clone(RetailscmUserContext userContext, String fromRetailStoreCreationId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreCreationDAO().clone(fromRetailStoreCreationId, this.allTokens());
	}
	
	public RetailStoreCreation internalSaveRetailStoreCreation(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation) throws Exception 
	{
		return internalSaveRetailStoreCreation(userContext, retailStoreCreation, allTokens());

	}
	public RetailStoreCreation internalSaveRetailStoreCreation(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreCreation(userContext, retailStoreCreationId, retailStoreCreationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreCreation){ 
			//will be good when the retailStoreCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCreation.
			
			
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, options);
			return retailStoreCreation;
			
		}

	}
	
	public RetailStoreCreation updateRetailStoreCreation(RetailscmUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreCreation(userContext, retailStoreCreationId, retailStoreCreationVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		if(retailStoreCreation.getVersion() != retailStoreCreationVersion){
			String message = "The target version("+retailStoreCreation.getVersion()+") is not equals to version("+retailStoreCreationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreCreation){ 
			//will be good when the retailStoreCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCreation.
			
			retailStoreCreation.changeProperty(property, newValueExpr);
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
			//return saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
		}

	}
	
	public RetailStoreCreation updateRetailStoreCreationProperty(RetailscmUserContext userContext,String retailStoreCreationId, int retailStoreCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreCreation(userContext, retailStoreCreationId, retailStoreCreationVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		if(retailStoreCreation.getVersion() != retailStoreCreationVersion){
			String message = "The target version("+retailStoreCreation.getVersion()+") is not equals to version("+retailStoreCreationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreCreation){ 
			//will be good when the retailStoreCreation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCreation.
			
			retailStoreCreation.changeProperty(property, newValueExpr);
			
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
			//return saveRetailStoreCreation(userContext, retailStoreCreation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreCreationTokens tokens(){
		return RetailStoreCreationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreCreationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreCreationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreCreationId, int retailStoreCreationVersion) throws Exception {
		//deleteInternal(userContext, retailStoreCreationId, retailStoreCreationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreCreationId, int retailStoreCreationVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreCreationDAO().delete(retailStoreCreationId, retailStoreCreationVersion);
	}
	
	public RetailStoreCreation forgetByAll(RetailscmUserContext userContext, String retailStoreCreationId, int retailStoreCreationVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreCreationId, retailStoreCreationVersion);		
	}
	protected RetailStoreCreation forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreCreationId, int retailStoreCreationVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreCreationDAO().disconnectFromAll(retailStoreCreationId, retailStoreCreationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreCreationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreCreationDAO().deleteAll();
	}


	//disconnect RetailStoreCreation with retail_store_country_center in RetailStore
	protected RetailStoreCreation breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreCreationId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());

			synchronized(retailStoreCreation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreCreationDAO().planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreCreation, retailStoreCountryCenterId, this.emptyOptions());

				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				return retailStoreCreation;
			}
	}
	//disconnect RetailStoreCreation with city_service_center in RetailStore
	protected RetailStoreCreation breakWithRetailStoreByCityServiceCenter(RetailscmUserContext userContext, String retailStoreCreationId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());

			synchronized(retailStoreCreation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreCreationDAO().planToRemoveRetailStoreListWithCityServiceCenter(retailStoreCreation, cityServiceCenterId, this.emptyOptions());

				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				return retailStoreCreation;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreCreation(retailStoreCreationId);

		
		userContext.getChecker().checkNameOfRetailStore(name);
		
		userContext.getChecker().checkTelephoneOfRetailStore(telephone);
		
		userContext.getChecker().checkOwnerOfRetailStore(owner);
		
		userContext.getChecker().checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		userContext.getChecker().checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		userContext.getChecker().checkFoundedOfRetailStore(founded);
		
		userContext.getChecker().checkLatitudeOfRetailStore(latitude);
		
		userContext.getChecker().checkLongitudeOfRetailStore(longitude);
		
		userContext.getChecker().checkDescriptionOfRetailStore(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

	
	}
	public  RetailStoreCreation addRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreCreationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		synchronized(retailStoreCreation){ 
			//Will be good when the retailStoreCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCreation.addRetailStore( retailStore );		
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreCreationId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreCreation(retailStoreCreationId);
		userContext.getChecker().checkIdOfRetailStore(id);
		
		userContext.getChecker().checkNameOfRetailStore( name);
		userContext.getChecker().checkTelephoneOfRetailStore( telephone);
		userContext.getChecker().checkOwnerOfRetailStore( owner);
		userContext.getChecker().checkFoundedOfRetailStore( founded);
		userContext.getChecker().checkLatitudeOfRetailStore( latitude);
		userContext.getChecker().checkLongitudeOfRetailStore( longitude);
		userContext.getChecker().checkDescriptionOfRetailStore( description);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
		
	}
	public  RetailStoreCreation updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreCreationId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreCreationId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();
		
		RetailStoreCreation retailStoreCreationToUpdate = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		if(retailStoreCreationToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreCreationManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStore item = retailStoreCreationToUpdate.getRetailStoreList().first();
		
		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );

		
		//checkParamsForAddingRetailStore(userContext,retailStoreCreationId,name, code, used,tokensExpr);
		RetailStoreCreation retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreationToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreCreation){ 
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreCreationId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreCreation(retailStoreCreationId);
		for(String retailStoreId: retailStoreIds){
			userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
		
	}
	public  RetailStoreCreation removeRetailStoreList(RetailscmUserContext userContext, String retailStoreCreationId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreList(userContext, retailStoreCreationId,  retailStoreIds, tokensExpr);
			
			
			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
			synchronized(retailStoreCreation){ 
				//Will be good when the retailStoreCreation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreCreationDAO().planToRemoveRetailStoreList(retailStoreCreation, retailStoreIds, allTokens());
				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreCreation.getRetailStoreList());
				return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreCreation( retailStoreCreationId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
	
	}
	public  RetailStoreCreation removeRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreCreationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		synchronized(retailStoreCreation){ 
			//Will be good when the retailStoreCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCreation.removeRetailStore( retailStore );		
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreCreation( retailStoreCreationId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
	
	}
	public  RetailStoreCreation copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreCreationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreCreationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
		synchronized(retailStoreCreation){ 
			//Will be good when the retailStoreCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStore.updateLastUpdateTime(userContext.now());
			
			retailStoreCreation.copyRetailStoreFrom( retailStore );		
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreCreation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreCreation(retailStoreCreationId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);
	
	}
	
	public  RetailStoreCreation updateRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreCreationId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();
		
		
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, loadTokens);
		
		synchronized(retailStoreCreation){ 
			//Will be good when the retailStoreCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCreation.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreCreation.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreCreationManagerException(retailStore+" is NOT FOUND" );
			}
			
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreCreation associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().createRetailStoreInvestmentInvitation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}	public  RetailStoreCreation associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().createRetailStoreFranchising(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}	public  RetailStoreCreation associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().createRetailStoreDecoration(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}	public  RetailStoreCreation associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().createRetailStoreOpening(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}	public  RetailStoreCreation associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().createRetailStoreClosing(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}
	*/
	
	public  RetailStoreCreation associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String investmentInvitationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().loadRetailStoreInvestmentInvitation(userContext,investmentInvitationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}	public  RetailStoreCreation associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String franchisingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().loadRetailStoreFranchising(userContext,franchisingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}	public  RetailStoreCreation associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String decorationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().loadRetailStoreDecoration(userContext,decorationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}	public  RetailStoreCreation associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String openingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().loadRetailStoreOpening(userContext,openingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}	public  RetailStoreCreation associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreCreationId, String  retailStoreIds[], String closingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().loadRetailStoreClosing(userContext,closingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreCreation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreCreation(userContext, retailStoreCreation);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreCreation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


