
package com.doublechaintech.retailscm.retailstoreopening;

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






public class RetailStoreOpeningManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOpeningManager {
	
	private static final String SERVICE_TYPE = "RetailStoreOpening";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreOpeningManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOpeningManagerException(message);

	}
	
	

 	protected RetailStoreOpening saveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreOpeningDAO().save(retailStoreOpening, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreOpening(userContext, retailStoreOpening, tokens);
 	}
 	
 	protected RetailStoreOpening saveRetailStoreOpeningDetail(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception{	

 		
 		return saveRetailStoreOpening(userContext, retailStoreOpening, allTokens());
 	}
 	
 	public RetailStoreOpening loadRetailStoreOpening(RetailscmUserContext userContext, String retailStoreOpeningId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOpening(retailStoreOpeningId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOpening, tokens);
 	}
 	
 	
 	 public RetailStoreOpening searchRetailStoreOpening(RetailscmUserContext userContext, String retailStoreOpeningId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreOpening(retailStoreOpeningId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOpening, tokens);
 	}
 	
 	

 	protected RetailStoreOpening present(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreOpening,tokens);
		
		
		RetailStoreOpening  retailStoreOpeningToPresent = userContext.getDAOGroup().getRetailStoreOpeningDAO().present(retailStoreOpening, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreOpeningToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreOpeningDAO().alias(entityListToNaming);
		
		return  retailStoreOpeningToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreOpening loadRetailStoreOpeningDetail(RetailscmUserContext userContext, String retailStoreOpeningId) throws Exception{	
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, allTokens());
 		return present(userContext,retailStoreOpening, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreOpeningId) throws Exception{	
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, viewTokens());
 		return present(userContext,retailStoreOpening, allTokens());
		
 	}
 	protected RetailStoreOpening saveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreOpeningDAO().save(retailStoreOpening, tokens);
 	}
 	protected RetailStoreOpening loadRetailStoreOpening(RetailscmUserContext userContext, String retailStoreOpeningId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreOpening(retailStoreOpeningId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreOpeningDAO().load(retailStoreOpeningId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOpening, tokens);
		
		addAction(userContext, retailStoreOpening, tokens,"@create","createRetailStoreOpening","createRetailStoreOpening/","main","primary");
		addAction(userContext, retailStoreOpening, tokens,"@update","updateRetailStoreOpening","updateRetailStoreOpening/"+retailStoreOpening.getId()+"/","main","primary");
		addAction(userContext, retailStoreOpening, tokens,"@copy","cloneRetailStoreOpening","cloneRetailStoreOpening/"+retailStoreOpening.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.addRetailStore","addRetailStore","addRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreOpening createRetailStoreOpening(RetailscmUserContext userContext,String comment) throws Exception
	{
		
		

		

		userContext.getChecker().checkCommentOfRetailStoreOpening(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);


		RetailStoreOpening retailStoreOpening=createNewRetailStoreOpening();	

		retailStoreOpening.setComment(comment);

		retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOpening);
		return retailStoreOpening;

		
	}
	protected RetailStoreOpening createNewRetailStoreOpening() 
	{
		
		return new RetailStoreOpening();		
	}
	
	protected void checkParamsForUpdatingRetailStoreOpening(RetailscmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOpening(retailStoreOpeningId);
		userContext.getChecker().checkVersionOfRetailStoreOpening( retailStoreOpeningVersion);
		

		if(RetailStoreOpening.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfRetailStoreOpening(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);
	
		
	}
	
	
	
	public RetailStoreOpening clone(RetailscmUserContext userContext, String fromRetailStoreOpeningId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreOpeningDAO().clone(fromRetailStoreOpeningId, this.allTokens());
	}
	
	public RetailStoreOpening internalSaveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception 
	{
		return internalSaveRetailStoreOpening(userContext, retailStoreOpening, allTokens());

	}
	public RetailStoreOpening internalSaveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreOpening){ 
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.
			
			
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, options);
			return retailStoreOpening;
			
		}

	}
	
	public RetailStoreOpening updateRetailStoreOpening(RetailscmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		if(retailStoreOpening.getVersion() != retailStoreOpeningVersion){
			String message = "The target version("+retailStoreOpening.getVersion()+") is not equals to version("+retailStoreOpeningVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOpening){ 
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.
			
			retailStoreOpening.changeProperty(property, newValueExpr);
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
		}

	}
	
	public RetailStoreOpening updateRetailStoreOpeningProperty(RetailscmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		if(retailStoreOpening.getVersion() != retailStoreOpeningVersion){
			String message = "The target version("+retailStoreOpening.getVersion()+") is not equals to version("+retailStoreOpeningVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOpening){ 
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.
			
			retailStoreOpening.changeProperty(property, newValueExpr);
			
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreOpeningTokens tokens(){
		return RetailStoreOpeningTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOpeningTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOpeningTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOpeningId, retailStoreOpeningVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreOpeningDAO().delete(retailStoreOpeningId, retailStoreOpeningVersion);
	}
	
	public RetailStoreOpening forgetByAll(RetailscmUserContext userContext, String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOpeningId, retailStoreOpeningVersion);		
	}
	protected RetailStoreOpening forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreOpeningDAO().disconnectFromAll(retailStoreOpeningId, retailStoreOpeningVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOpeningManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreOpeningDAO().deleteAll();
	}


	//disconnect RetailStoreOpening with retail_store_country_center in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOpeningDAO().planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreOpening, retailStoreCountryCenterId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}
	//disconnect RetailStoreOpening with city_service_center in RetailStore
	protected RetailStoreOpening breakWithRetailStoreByCityServiceCenter(RetailscmUserContext userContext, String retailStoreOpeningId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());

			synchronized(retailStoreOpening){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreOpeningDAO().planToRemoveRetailStoreListWithCityServiceCenter(retailStoreOpening, cityServiceCenterId, this.emptyOptions());

				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				return retailStoreOpening;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreOpening(retailStoreOpeningId);

		
		userContext.getChecker().checkNameOfRetailStore(name);
		
		userContext.getChecker().checkTelephoneOfRetailStore(telephone);
		
		userContext.getChecker().checkOwnerOfRetailStore(owner);
		
		userContext.getChecker().checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		userContext.getChecker().checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		userContext.getChecker().checkFoundedOfRetailStore(founded);
		
		userContext.getChecker().checkLatitudeOfRetailStore(latitude);
		
		userContext.getChecker().checkLongitudeOfRetailStore(longitude);
		
		userContext.getChecker().checkDescriptionOfRetailStore(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);

	
	}
	public  RetailStoreOpening addRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreOpeningId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){ 
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.addRetailStore( retailStore );		
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreOpeningId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOpening(retailStoreOpeningId);
		userContext.getChecker().checkIdOfRetailStore(id);
		
		userContext.getChecker().checkNameOfRetailStore( name);
		userContext.getChecker().checkTelephoneOfRetailStore( telephone);
		userContext.getChecker().checkOwnerOfRetailStore( owner);
		userContext.getChecker().checkFoundedOfRetailStore( founded);
		userContext.getChecker().checkLatitudeOfRetailStore( latitude);
		userContext.getChecker().checkLongitudeOfRetailStore( longitude);
		userContext.getChecker().checkDescriptionOfRetailStore( description);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);
		
	}
	public  RetailStoreOpening updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreOpeningId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreOpeningId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();
		
		RetailStoreOpening retailStoreOpeningToUpdate = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		if(retailStoreOpeningToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreOpeningManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStore item = retailStoreOpeningToUpdate.getRetailStoreList().first();
		
		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );

		
		//checkParamsForAddingRetailStore(userContext,retailStoreOpeningId,name, code, used,tokensExpr);
		RetailStoreOpening retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpeningToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreOpening){ 
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreOpeningId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreOpening(retailStoreOpeningId);
		for(String retailStoreId: retailStoreIds){
			userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);
		
	}
	public  RetailStoreOpening removeRetailStoreList(RetailscmUserContext userContext, String retailStoreOpeningId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreList(userContext, retailStoreOpeningId,  retailStoreIds, tokensExpr);
			
			
			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
			synchronized(retailStoreOpening){ 
				//Will be good when the retailStoreOpening loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreOpeningDAO().planToRemoveRetailStoreList(retailStoreOpening, retailStoreIds, allTokens());
				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreOpening.getRetailStoreList());
				return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOpening( retailStoreOpeningId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);
	
	}
	public  RetailStoreOpening removeRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreOpeningId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){ 
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.removeRetailStore( retailStore );		
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreOpening( retailStoreOpeningId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);
	
	}
	public  RetailStoreOpening copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreOpeningId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreOpeningId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){ 
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStore.updateLastUpdateTime(userContext.now());
			
			retailStoreOpening.copyRetailStoreFrom( retailStore );		
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreOpening.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreOpening(retailStoreOpeningId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);
	
	}
	
	public  RetailStoreOpening updateRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreOpeningId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();
		
		
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, loadTokens);
		
		synchronized(retailStoreOpening){ 
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOpening.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreOpening.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreOpeningManagerException(retailStore+" is NOT FOUND" );
			}
			
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreOpening associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().createRetailStoreCreation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}	public  RetailStoreOpening associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().createRetailStoreInvestmentInvitation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}	public  RetailStoreOpening associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().createRetailStoreFranchising(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}	public  RetailStoreOpening associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().createRetailStoreDecoration(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}	public  RetailStoreOpening associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().createRetailStoreClosing(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}
	*/
	
	public  RetailStoreOpening associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().loadRetailStoreCreation(userContext,creationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}	public  RetailStoreOpening associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String investmentInvitationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().loadRetailStoreInvestmentInvitation(userContext,investmentInvitationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}	public  RetailStoreOpening associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String franchisingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().loadRetailStoreFranchising(userContext,franchisingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}	public  RetailStoreOpening associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String decorationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().loadRetailStoreDecoration(userContext,decorationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}	public  RetailStoreOpening associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreOpeningId, String  retailStoreIds[], String closingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().loadRetailStoreClosing(userContext,closingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreOpening.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreOpening(userContext, retailStoreOpening);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOpening newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


