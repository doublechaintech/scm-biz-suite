
package com.doublechaintech.retailscm.retailstoredecoration;

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






public class RetailStoreDecorationManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreDecorationManager {
	
	private static final String SERVICE_TYPE = "RetailStoreDecoration";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreDecorationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreDecorationManagerException(message);

	}
	
	

 	protected RetailStoreDecoration saveRetailStoreDecoration(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreDecorationDAO().save(retailStoreDecoration, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens);
 	}
 	
 	protected RetailStoreDecoration saveRetailStoreDecorationDetail(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration) throws Exception{	

 		
 		return saveRetailStoreDecoration(userContext, retailStoreDecoration, allTokens());
 	}
 	
 	public RetailStoreDecoration loadRetailStoreDecoration(RetailscmUserContext userContext, String retailStoreDecorationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreDecorationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreDecoration, tokens);
 	}
 	
 	
 	 public RetailStoreDecoration searchRetailStoreDecoration(RetailscmUserContext userContext, String retailStoreDecorationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreDecorationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreDecoration, tokens);
 	}
 	
 	

 	protected RetailStoreDecoration present(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreDecoration,tokens);
		
		
		RetailStoreDecoration  retailStoreDecorationToPresent = userContext.getDAOGroup().getRetailStoreDecorationDAO().present(retailStoreDecoration, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreDecorationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreDecorationDAO().alias(entityListToNaming);
		
		return  retailStoreDecorationToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreDecoration loadRetailStoreDecorationDetail(RetailscmUserContext userContext, String retailStoreDecorationId) throws Exception{	
 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, allTokens());
 		return present(userContext,retailStoreDecoration, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreDecorationId) throws Exception{	
 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, viewTokens());
 		return present(userContext,retailStoreDecoration, allTokens());
		
 	}
 	protected RetailStoreDecoration saveRetailStoreDecoration(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreDecorationDAO().save(retailStoreDecoration, tokens);
 	}
 	protected RetailStoreDecoration loadRetailStoreDecoration(RetailscmUserContext userContext, String retailStoreDecorationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreDecorationManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreDecorationDAO().load(retailStoreDecorationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreDecoration, tokens);
		
		addAction(userContext, retailStoreDecoration, tokens,"@create","createRetailStoreDecoration","createRetailStoreDecoration/","main","primary");
		addAction(userContext, retailStoreDecoration, tokens,"@update","updateRetailStoreDecoration","updateRetailStoreDecoration/"+retailStoreDecoration.getId()+"/","main","primary");
		addAction(userContext, retailStoreDecoration, tokens,"@copy","cloneRetailStoreDecoration","cloneRetailStoreDecoration/"+retailStoreDecoration.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreDecoration, tokens,"retail_store_decoration.addRetailStore","addRetailStore","addRetailStore/"+retailStoreDecoration.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreDecoration, tokens,"retail_store_decoration.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreDecoration.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreDecoration, tokens,"retail_store_decoration.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreDecoration.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreDecoration, tokens,"retail_store_decoration.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreDecoration.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreDecoration createRetailStoreDecoration(RetailscmUserContext userContext,String comment) throws Exception
	{
		
		

		

		userContext.getChecker().checkCommentOfRetailStoreDecoration(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);


		RetailStoreDecoration retailStoreDecoration=createNewRetailStoreDecoration();	

		retailStoreDecoration.setComment(comment);

		retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreDecoration);
		return retailStoreDecoration;

		
	}
	protected RetailStoreDecoration createNewRetailStoreDecoration() 
	{
		
		return new RetailStoreDecoration();		
	}
	
	protected void checkParamsForUpdatingRetailStoreDecoration(RetailscmUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		userContext.getChecker().checkVersionOfRetailStoreDecoration( retailStoreDecorationVersion);
		

		if(RetailStoreDecoration.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfRetailStoreDecoration(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
	
		
	}
	
	
	
	public RetailStoreDecoration clone(RetailscmUserContext userContext, String fromRetailStoreDecorationId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreDecorationDAO().clone(fromRetailStoreDecorationId, this.allTokens());
	}
	
	public RetailStoreDecoration internalSaveRetailStoreDecoration(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration) throws Exception 
	{
		return internalSaveRetailStoreDecoration(userContext, retailStoreDecoration, allTokens());

	}
	public RetailStoreDecoration internalSaveRetailStoreDecoration(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreDecoration(userContext, retailStoreDecorationId, retailStoreDecorationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreDecoration){ 
			//will be good when the retailStoreDecoration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreDecoration.
			
			
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, options);
			return retailStoreDecoration;
			
		}

	}
	
	public RetailStoreDecoration updateRetailStoreDecoration(RetailscmUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreDecoration(userContext, retailStoreDecorationId, retailStoreDecorationVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		if(retailStoreDecoration.getVersion() != retailStoreDecorationVersion){
			String message = "The target version("+retailStoreDecoration.getVersion()+") is not equals to version("+retailStoreDecorationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreDecoration){ 
			//will be good when the retailStoreDecoration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreDecoration.
			
			retailStoreDecoration.changeProperty(property, newValueExpr);
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
			//return saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
		}

	}
	
	public RetailStoreDecoration updateRetailStoreDecorationProperty(RetailscmUserContext userContext,String retailStoreDecorationId, int retailStoreDecorationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreDecoration(userContext, retailStoreDecorationId, retailStoreDecorationVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		if(retailStoreDecoration.getVersion() != retailStoreDecorationVersion){
			String message = "The target version("+retailStoreDecoration.getVersion()+") is not equals to version("+retailStoreDecorationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreDecoration){ 
			//will be good when the retailStoreDecoration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreDecoration.
			
			retailStoreDecoration.changeProperty(property, newValueExpr);
			
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
			//return saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreDecorationTokens tokens(){
		return RetailStoreDecorationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreDecorationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreDecorationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreDecorationId, int retailStoreDecorationVersion) throws Exception {
		//deleteInternal(userContext, retailStoreDecorationId, retailStoreDecorationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreDecorationId, int retailStoreDecorationVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreDecorationDAO().delete(retailStoreDecorationId, retailStoreDecorationVersion);
	}
	
	public RetailStoreDecoration forgetByAll(RetailscmUserContext userContext, String retailStoreDecorationId, int retailStoreDecorationVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreDecorationId, retailStoreDecorationVersion);		
	}
	protected RetailStoreDecoration forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreDecorationId, int retailStoreDecorationVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreDecorationDAO().disconnectFromAll(retailStoreDecorationId, retailStoreDecorationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreDecorationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreDecorationDAO().deleteAll();
	}


	//disconnect RetailStoreDecoration with retail_store_country_center in RetailStore
	protected RetailStoreDecoration breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());

			synchronized(retailStoreDecoration){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDecorationDAO().planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreDecoration, retailStoreCountryCenterId, this.emptyOptions());

				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				return retailStoreDecoration;
			}
	}
	//disconnect RetailStoreDecoration with city_service_center in RetailStore
	protected RetailStoreDecoration breakWithRetailStoreByCityServiceCenter(RetailscmUserContext userContext, String retailStoreDecorationId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());

			synchronized(retailStoreDecoration){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreDecorationDAO().planToRemoveRetailStoreListWithCityServiceCenter(retailStoreDecoration, cityServiceCenterId, this.emptyOptions());

				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				return retailStoreDecoration;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreDecoration(retailStoreDecorationId);

		
		userContext.getChecker().checkNameOfRetailStore(name);
		
		userContext.getChecker().checkTelephoneOfRetailStore(telephone);
		
		userContext.getChecker().checkOwnerOfRetailStore(owner);
		
		userContext.getChecker().checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		userContext.getChecker().checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		userContext.getChecker().checkFoundedOfRetailStore(founded);
		
		userContext.getChecker().checkLatitudeOfRetailStore(latitude);
		
		userContext.getChecker().checkLongitudeOfRetailStore(longitude);
		
		userContext.getChecker().checkDescriptionOfRetailStore(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

	
	}
	public  RetailStoreDecoration addRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreDecorationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		synchronized(retailStoreDecoration){ 
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreDecoration.addRetailStore( retailStore );		
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreDecorationId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		userContext.getChecker().checkIdOfRetailStore(id);
		
		userContext.getChecker().checkNameOfRetailStore( name);
		userContext.getChecker().checkTelephoneOfRetailStore( telephone);
		userContext.getChecker().checkOwnerOfRetailStore( owner);
		userContext.getChecker().checkFoundedOfRetailStore( founded);
		userContext.getChecker().checkLatitudeOfRetailStore( latitude);
		userContext.getChecker().checkLongitudeOfRetailStore( longitude);
		userContext.getChecker().checkDescriptionOfRetailStore( description);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
		
	}
	public  RetailStoreDecoration updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreDecorationId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreDecorationId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();
		
		RetailStoreDecoration retailStoreDecorationToUpdate = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		if(retailStoreDecorationToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreDecorationManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStore item = retailStoreDecorationToUpdate.getRetailStoreList().first();
		
		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );

		
		//checkParamsForAddingRetailStore(userContext,retailStoreDecorationId,name, code, used,tokensExpr);
		RetailStoreDecoration retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecorationToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreDecoration){ 
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreDecorationId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		for(String retailStoreId: retailStoreIds){
			userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
		
	}
	public  RetailStoreDecoration removeRetailStoreList(RetailscmUserContext userContext, String retailStoreDecorationId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreList(userContext, retailStoreDecorationId,  retailStoreIds, tokensExpr);
			
			
			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
			synchronized(retailStoreDecoration){ 
				//Will be good when the retailStoreDecoration loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreDecorationDAO().planToRemoveRetailStoreList(retailStoreDecoration, retailStoreIds, allTokens());
				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreDecoration.getRetailStoreList());
				return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreDecoration( retailStoreDecorationId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
	
	}
	public  RetailStoreDecoration removeRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreDecorationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		synchronized(retailStoreDecoration){ 
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreDecoration.removeRetailStore( retailStore );		
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreDecoration( retailStoreDecorationId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
	
	}
	public  RetailStoreDecoration copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreDecorationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreDecorationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
		synchronized(retailStoreDecoration){ 
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStore.updateLastUpdateTime(userContext.now());
			
			retailStoreDecoration.copyRetailStoreFrom( retailStore );		
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreDecoration.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreDecoration(retailStoreDecorationId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);
	
	}
	
	public  RetailStoreDecoration updateRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreDecorationId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();
		
		
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, loadTokens);
		
		synchronized(retailStoreDecoration){ 
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreDecoration.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreDecoration.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreDecorationManagerException(retailStore+" is NOT FOUND" );
			}
			
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreDecoration associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().createRetailStoreCreation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}	public  RetailStoreDecoration associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().createRetailStoreInvestmentInvitation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}	public  RetailStoreDecoration associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().createRetailStoreFranchising(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}	public  RetailStoreDecoration associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().createRetailStoreOpening(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}	public  RetailStoreDecoration associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().createRetailStoreClosing(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}
	*/
	
	public  RetailStoreDecoration associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().loadRetailStoreCreation(userContext,creationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}	public  RetailStoreDecoration associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String investmentInvitationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().loadRetailStoreInvestmentInvitation(userContext,investmentInvitationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}	public  RetailStoreDecoration associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String franchisingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().loadRetailStoreFranchising(userContext,franchisingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}	public  RetailStoreDecoration associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String openingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().loadRetailStoreOpening(userContext,openingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}	public  RetailStoreDecoration associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreDecorationId, String  retailStoreIds[], String closingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().loadRetailStoreClosing(userContext,closingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreDecoration.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreDecoration(userContext, retailStoreDecoration);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreDecoration newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


