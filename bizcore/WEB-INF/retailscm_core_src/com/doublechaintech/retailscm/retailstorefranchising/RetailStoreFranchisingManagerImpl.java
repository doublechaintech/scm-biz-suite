
package com.doublechaintech.retailscm.retailstorefranchising;

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






public class RetailStoreFranchisingManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreFranchisingManager {
	
	private static final String SERVICE_TYPE = "RetailStoreFranchising";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreFranchisingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreFranchisingManagerException(message);

	}
	
	

 	protected RetailStoreFranchising saveRetailStoreFranchising(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreFranchisingDAO().save(retailStoreFranchising, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens);
 	}
 	
 	protected RetailStoreFranchising saveRetailStoreFranchisingDetail(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising) throws Exception{	

 		
 		return saveRetailStoreFranchising(userContext, retailStoreFranchising, allTokens());
 	}
 	
 	public RetailStoreFranchising loadRetailStoreFranchising(RetailscmUserContext userContext, String retailStoreFranchisingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreFranchisingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreFranchising, tokens);
 	}
 	
 	
 	 public RetailStoreFranchising searchRetailStoreFranchising(RetailscmUserContext userContext, String retailStoreFranchisingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreFranchisingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreFranchising, tokens);
 	}
 	
 	

 	protected RetailStoreFranchising present(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreFranchising,tokens);
		
		
		RetailStoreFranchising  retailStoreFranchisingToPresent = userContext.getDAOGroup().getRetailStoreFranchisingDAO().present(retailStoreFranchising, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreFranchisingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreFranchisingDAO().alias(entityListToNaming);
		
		return  retailStoreFranchisingToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreFranchising loadRetailStoreFranchisingDetail(RetailscmUserContext userContext, String retailStoreFranchisingId) throws Exception{	
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, allTokens());
 		return present(userContext,retailStoreFranchising, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreFranchisingId) throws Exception{	
 		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising( userContext, retailStoreFranchisingId, viewTokens());
 		return present(userContext,retailStoreFranchising, allTokens());
		
 	}
 	protected RetailStoreFranchising saveRetailStoreFranchising(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreFranchisingDAO().save(retailStoreFranchising, tokens);
 	}
 	protected RetailStoreFranchising loadRetailStoreFranchising(RetailscmUserContext userContext, String retailStoreFranchisingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreFranchisingManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreFranchisingDAO().load(retailStoreFranchisingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreFranchising, tokens);
		
		addAction(userContext, retailStoreFranchising, tokens,"@create","createRetailStoreFranchising","createRetailStoreFranchising/","main","primary");
		addAction(userContext, retailStoreFranchising, tokens,"@update","updateRetailStoreFranchising","updateRetailStoreFranchising/"+retailStoreFranchising.getId()+"/","main","primary");
		addAction(userContext, retailStoreFranchising, tokens,"@copy","cloneRetailStoreFranchising","cloneRetailStoreFranchising/"+retailStoreFranchising.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.addRetailStore","addRetailStore","addRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreFranchising, tokens,"retail_store_franchising.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreFranchising.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreFranchising createRetailStoreFranchising(RetailscmUserContext userContext,String comment) throws Exception
	{
		
		

		

		userContext.getChecker().checkCommentOfRetailStoreFranchising(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);


		RetailStoreFranchising retailStoreFranchising=createNewRetailStoreFranchising();	

		retailStoreFranchising.setComment(comment);

		retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreFranchising);
		return retailStoreFranchising;

		
	}
	protected RetailStoreFranchising createNewRetailStoreFranchising() 
	{
		
		return new RetailStoreFranchising();		
	}
	
	protected void checkParamsForUpdatingRetailStoreFranchising(RetailscmUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		userContext.getChecker().checkVersionOfRetailStoreFranchising( retailStoreFranchisingVersion);
		

		if(RetailStoreFranchising.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfRetailStoreFranchising(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
	
		
	}
	
	
	
	public RetailStoreFranchising clone(RetailscmUserContext userContext, String fromRetailStoreFranchisingId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreFranchisingDAO().clone(fromRetailStoreFranchisingId, this.allTokens());
	}
	
	public RetailStoreFranchising internalSaveRetailStoreFranchising(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising) throws Exception 
	{
		return internalSaveRetailStoreFranchising(userContext, retailStoreFranchising, allTokens());

	}
	public RetailStoreFranchising internalSaveRetailStoreFranchising(RetailscmUserContext userContext, RetailStoreFranchising retailStoreFranchising, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreFranchising(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreFranchising){ 
			//will be good when the retailStoreFranchising loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreFranchising.
			
			
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, options);
			return retailStoreFranchising;
			
		}

	}
	
	public RetailStoreFranchising updateRetailStoreFranchising(RetailscmUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreFranchising(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		if(retailStoreFranchising.getVersion() != retailStoreFranchisingVersion){
			String message = "The target version("+retailStoreFranchising.getVersion()+") is not equals to version("+retailStoreFranchisingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreFranchising){ 
			//will be good when the retailStoreFranchising loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreFranchising.
			
			retailStoreFranchising.changeProperty(property, newValueExpr);
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
			//return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
		}

	}
	
	public RetailStoreFranchising updateRetailStoreFranchisingProperty(RetailscmUserContext userContext,String retailStoreFranchisingId, int retailStoreFranchisingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreFranchising(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		if(retailStoreFranchising.getVersion() != retailStoreFranchisingVersion){
			String message = "The target version("+retailStoreFranchising.getVersion()+") is not equals to version("+retailStoreFranchisingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreFranchising){ 
			//will be good when the retailStoreFranchising loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreFranchising.
			
			retailStoreFranchising.changeProperty(property, newValueExpr);
			
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
			//return saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreFranchisingTokens tokens(){
		return RetailStoreFranchisingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreFranchisingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreFranchisingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception {
		//deleteInternal(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreFranchisingDAO().delete(retailStoreFranchisingId, retailStoreFranchisingVersion);
	}
	
	public RetailStoreFranchising forgetByAll(RetailscmUserContext userContext, String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreFranchisingId, retailStoreFranchisingVersion);		
	}
	protected RetailStoreFranchising forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreFranchisingId, int retailStoreFranchisingVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreFranchisingDAO().disconnectFromAll(retailStoreFranchisingId, retailStoreFranchisingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreFranchisingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreFranchisingDAO().deleteAll();
	}


	//disconnect RetailStoreFranchising with retail_store_country_center in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreFranchisingId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreFranchisingDAO().planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreFranchising, retailStoreCountryCenterId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}
	//disconnect RetailStoreFranchising with city_service_center in RetailStore
	protected RetailStoreFranchising breakWithRetailStoreByCityServiceCenter(RetailscmUserContext userContext, String retailStoreFranchisingId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());

			synchronized(retailStoreFranchising){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreFranchisingDAO().planToRemoveRetailStoreListWithCityServiceCenter(retailStoreFranchising, cityServiceCenterId, this.emptyOptions());

				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				return retailStoreFranchising;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreFranchising(retailStoreFranchisingId);

		
		userContext.getChecker().checkNameOfRetailStore(name);
		
		userContext.getChecker().checkTelephoneOfRetailStore(telephone);
		
		userContext.getChecker().checkOwnerOfRetailStore(owner);
		
		userContext.getChecker().checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		userContext.getChecker().checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		userContext.getChecker().checkFoundedOfRetailStore(founded);
		
		userContext.getChecker().checkLatitudeOfRetailStore(latitude);
		
		userContext.getChecker().checkLongitudeOfRetailStore(longitude);
		
		userContext.getChecker().checkDescriptionOfRetailStore(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);

	
	}
	public  RetailStoreFranchising addRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreFranchisingId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		synchronized(retailStoreFranchising){ 
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreFranchising.addRetailStore( retailStore );		
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreFranchisingId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		userContext.getChecker().checkIdOfRetailStore(id);
		
		userContext.getChecker().checkNameOfRetailStore( name);
		userContext.getChecker().checkTelephoneOfRetailStore( telephone);
		userContext.getChecker().checkOwnerOfRetailStore( owner);
		userContext.getChecker().checkFoundedOfRetailStore( founded);
		userContext.getChecker().checkLatitudeOfRetailStore( latitude);
		userContext.getChecker().checkLongitudeOfRetailStore( longitude);
		userContext.getChecker().checkDescriptionOfRetailStore( description);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
		
	}
	public  RetailStoreFranchising updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreFranchisingId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreFranchisingId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();
		
		RetailStoreFranchising retailStoreFranchisingToUpdate = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		if(retailStoreFranchisingToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreFranchisingManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStore item = retailStoreFranchisingToUpdate.getRetailStoreList().first();
		
		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );

		
		//checkParamsForAddingRetailStore(userContext,retailStoreFranchisingId,name, code, used,tokensExpr);
		RetailStoreFranchising retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchisingToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreFranchising){ 
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreFranchisingId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
		for(String retailStoreId: retailStoreIds){
			userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
		
	}
	public  RetailStoreFranchising removeRetailStoreList(RetailscmUserContext userContext, String retailStoreFranchisingId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreList(userContext, retailStoreFranchisingId,  retailStoreIds, tokensExpr);
			
			
			RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
			synchronized(retailStoreFranchising){ 
				//Will be good when the retailStoreFranchising loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreFranchisingDAO().planToRemoveRetailStoreList(retailStoreFranchising, retailStoreIds, allTokens());
				retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreFranchising.getRetailStoreList());
				return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreFranchising( retailStoreFranchisingId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
	
	}
	public  RetailStoreFranchising removeRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreFranchisingId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		synchronized(retailStoreFranchising){ 
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreFranchising.removeRetailStore( retailStore );		
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreFranchising( retailStoreFranchisingId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
	
	}
	public  RetailStoreFranchising copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreFranchisingId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreFranchisingId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, allTokens());
		synchronized(retailStoreFranchising){ 
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStore.updateLastUpdateTime(userContext.now());
			
			retailStoreFranchising.copyRetailStoreFrom( retailStore );		
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreFranchising.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreFranchising(retailStoreFranchisingId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreFranchisingManagerException.class);
	
	}
	
	public  RetailStoreFranchising updateRetailStore(RetailscmUserContext userContext, String retailStoreFranchisingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreFranchisingId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();
		
		
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, loadTokens);
		
		synchronized(retailStoreFranchising){ 
			//Will be good when the retailStoreFranchising loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreFranchising.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreFranchising.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreFranchisingManagerException(retailStore+" is NOT FOUND" );
			}
			
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreFranchising = saveRetailStoreFranchising(userContext, retailStoreFranchising, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreFranchising, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreFranchising associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().createRetailStoreCreation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}	public  RetailStoreFranchising associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().createRetailStoreInvestmentInvitation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}	public  RetailStoreFranchising associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().createRetailStoreDecoration(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}	public  RetailStoreFranchising associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().createRetailStoreOpening(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}	public  RetailStoreFranchising associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().createRetailStoreClosing(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}
	*/
	
	public  RetailStoreFranchising associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().loadRetailStoreCreation(userContext,creationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}	public  RetailStoreFranchising associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String investmentInvitationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreInvestmentInvitation investmentInvitation = userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager().loadRetailStoreInvestmentInvitation(userContext,investmentInvitationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateInvestmentInvitation(investmentInvitation);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}	public  RetailStoreFranchising associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String decorationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().loadRetailStoreDecoration(userContext,decorationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}	public  RetailStoreFranchising associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String openingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().loadRetailStoreOpening(userContext,openingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}	public  RetailStoreFranchising associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreFranchisingId, String  retailStoreIds[], String closingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreFranchising retailStoreFranchising = loadRetailStoreFranchising(userContext, retailStoreFranchisingId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().loadRetailStoreClosing(userContext,closingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreFranchising.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreFranchising(userContext, retailStoreFranchising);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreFranchising newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


