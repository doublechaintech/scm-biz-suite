
package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

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






public class RetailStoreInvestmentInvitationManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreInvestmentInvitationManager {
	
	private static final String SERVICE_TYPE = "RetailStoreInvestmentInvitation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreInvestmentInvitationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreInvestmentInvitationManagerException(message);

	}
	
	

 	protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitation(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreInvestmentInvitationDAO().save(retailStoreInvestmentInvitation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens);
 	}
 	
 	protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitationDetail(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation) throws Exception{	

 		
 		return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, allTokens());
 	}
 	
 	public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreInvestmentInvitationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreInvestmentInvitation, tokens);
 	}
 	
 	
 	 public RetailStoreInvestmentInvitation searchRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreInvestmentInvitationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreInvestmentInvitation, tokens);
 	}
 	
 	

 	protected RetailStoreInvestmentInvitation present(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreInvestmentInvitation,tokens);
		
		
		RetailStoreInvestmentInvitation  retailStoreInvestmentInvitationToPresent = userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().present(retailStoreInvestmentInvitation, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreInvestmentInvitationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().alias(entityListToNaming);
		
		return  retailStoreInvestmentInvitationToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitationDetail(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId) throws Exception{	
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, allTokens());
 		return present(userContext,retailStoreInvestmentInvitation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId) throws Exception{	
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, viewTokens());
 		return present(userContext,retailStoreInvestmentInvitation, allTokens());
		
 	}
 	protected RetailStoreInvestmentInvitation saveRetailStoreInvestmentInvitation(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().save(retailStoreInvestmentInvitation, tokens);
 	}
 	protected RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreInvestmentInvitationManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().load(retailStoreInvestmentInvitationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreInvestmentInvitation, tokens);
		
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"@create","createRetailStoreInvestmentInvitation","createRetailStoreInvestmentInvitation/","main","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"@update","updateRetailStoreInvestmentInvitation","updateRetailStoreInvestmentInvitation/"+retailStoreInvestmentInvitation.getId()+"/","main","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"@copy","cloneRetailStoreInvestmentInvitation","cloneRetailStoreInvestmentInvitation/"+retailStoreInvestmentInvitation.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"retail_store_investment_invitation.addRetailStore","addRetailStore","addRetailStore/"+retailStoreInvestmentInvitation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"retail_store_investment_invitation.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreInvestmentInvitation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"retail_store_investment_invitation.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreInvestmentInvitation.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreInvestmentInvitation, tokens,"retail_store_investment_invitation.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreInvestmentInvitation.getId()+"/","retailStoreList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(RetailscmUserContext userContext,String comment) throws Exception
	{
		
		

		

		userContext.getChecker().checkCommentOfRetailStoreInvestmentInvitation(comment);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);


		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation=createNewRetailStoreInvestmentInvitation();	

		retailStoreInvestmentInvitation.setComment(comment);

		retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreInvestmentInvitation);
		return retailStoreInvestmentInvitation;

		
	}
	protected RetailStoreInvestmentInvitation createNewRetailStoreInvestmentInvitation() 
	{
		
		return new RetailStoreInvestmentInvitation();		
	}
	
	protected void checkParamsForUpdatingRetailStoreInvestmentInvitation(RetailscmUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		userContext.getChecker().checkVersionOfRetailStoreInvestmentInvitation( retailStoreInvestmentInvitationVersion);
		

		if(RetailStoreInvestmentInvitation.COMMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentOfRetailStoreInvestmentInvitation(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
	
		
	}
	
	
	
	public RetailStoreInvestmentInvitation clone(RetailscmUserContext userContext, String fromRetailStoreInvestmentInvitationId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().clone(fromRetailStoreInvestmentInvitationId, this.allTokens());
	}
	
	public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation) throws Exception 
	{
		return internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, allTokens());

	}
	public RetailStoreInvestmentInvitation internalSaveRetailStoreInvestmentInvitation(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreInvestmentInvitation){ 
			//will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreInvestmentInvitation.
			
			
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, options);
			return retailStoreInvestmentInvitation;
			
		}

	}
	
	public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitation(RetailscmUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		if(retailStoreInvestmentInvitation.getVersion() != retailStoreInvestmentInvitationVersion){
			String message = "The target version("+retailStoreInvestmentInvitation.getVersion()+") is not equals to version("+retailStoreInvestmentInvitationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreInvestmentInvitation){ 
			//will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreInvestmentInvitation.
			
			retailStoreInvestmentInvitation.changeProperty(property, newValueExpr);
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().done());
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
			//return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().done());
		}

	}
	
	public RetailStoreInvestmentInvitation updateRetailStoreInvestmentInvitationProperty(RetailscmUserContext userContext,String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		if(retailStoreInvestmentInvitation.getVersion() != retailStoreInvestmentInvitationVersion){
			String message = "The target version("+retailStoreInvestmentInvitation.getVersion()+") is not equals to version("+retailStoreInvestmentInvitationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreInvestmentInvitation){ 
			//will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreInvestmentInvitation.
			
			retailStoreInvestmentInvitation.changeProperty(property, newValueExpr);
			
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().done());
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
			//return saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreInvestmentInvitationTokens tokens(){
		return RetailStoreInvestmentInvitationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreInvestmentInvitationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreInvestmentInvitationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion) throws Exception {
		//deleteInternal(userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().delete(retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);
	}
	
	public RetailStoreInvestmentInvitation forgetByAll(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);		
	}
	protected RetailStoreInvestmentInvitation forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().disconnectFromAll(retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreInvestmentInvitationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().deleteAll();
	}


	//disconnect RetailStoreInvestmentInvitation with retail_store_country_center in RetailStore
	protected RetailStoreInvestmentInvitation breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());

			synchronized(retailStoreInvestmentInvitation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreInvestmentInvitation, retailStoreCountryCenterId, this.emptyOptions());

				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				return retailStoreInvestmentInvitation;
			}
	}
	//disconnect RetailStoreInvestmentInvitation with city_service_center in RetailStore
	protected RetailStoreInvestmentInvitation breakWithRetailStoreByCityServiceCenter(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());

			synchronized(retailStoreInvestmentInvitation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().planToRemoveRetailStoreListWithCityServiceCenter(retailStoreInvestmentInvitation, cityServiceCenterId, this.emptyOptions());

				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				return retailStoreInvestmentInvitation;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);

		
		userContext.getChecker().checkNameOfRetailStore(name);
		
		userContext.getChecker().checkTelephoneOfRetailStore(telephone);
		
		userContext.getChecker().checkOwnerOfRetailStore(owner);
		
		userContext.getChecker().checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		userContext.getChecker().checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		userContext.getChecker().checkFoundedOfRetailStore(founded);
		
		userContext.getChecker().checkLatitudeOfRetailStore(latitude);
		
		userContext.getChecker().checkLongitudeOfRetailStore(longitude);
		
		userContext.getChecker().checkDescriptionOfRetailStore(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

	
	}
	public  RetailStoreInvestmentInvitation addRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreInvestmentInvitationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		synchronized(retailStoreInvestmentInvitation){ 
			//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreInvestmentInvitation.addRetailStore( retailStore );		
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		userContext.getChecker().checkIdOfRetailStore(id);
		
		userContext.getChecker().checkNameOfRetailStore( name);
		userContext.getChecker().checkTelephoneOfRetailStore( telephone);
		userContext.getChecker().checkOwnerOfRetailStore( owner);
		userContext.getChecker().checkFoundedOfRetailStore( founded);
		userContext.getChecker().checkLatitudeOfRetailStore( latitude);
		userContext.getChecker().checkLongitudeOfRetailStore( longitude);
		userContext.getChecker().checkDescriptionOfRetailStore( description);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
		
	}
	public  RetailStoreInvestmentInvitation updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreInvestmentInvitationId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitationToUpdate = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		if(retailStoreInvestmentInvitationToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreInvestmentInvitationManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStore item = retailStoreInvestmentInvitationToUpdate.getRetailStoreList().first();
		
		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );

		
		//checkParamsForAddingRetailStore(userContext,retailStoreInvestmentInvitationId,name, code, used,tokensExpr);
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreInvestmentInvitation){ 
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		for(String retailStoreId: retailStoreIds){
			userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
		
	}
	public  RetailStoreInvestmentInvitation removeRetailStoreList(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, 
			String retailStoreIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreList(userContext, retailStoreInvestmentInvitationId,  retailStoreIds, tokensExpr);
			
			
			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
			synchronized(retailStoreInvestmentInvitation){ 
				//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO().planToRemoveRetailStoreList(retailStoreInvestmentInvitation, retailStoreIds, allTokens());
				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreInvestmentInvitation.getRetailStoreList());
				return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation( retailStoreInvestmentInvitationId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
	
	}
	public  RetailStoreInvestmentInvitation removeRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreInvestmentInvitationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		synchronized(retailStoreInvestmentInvitation){ 
			//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreInvestmentInvitation.removeRetailStore( retailStore );		
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation( retailStoreInvestmentInvitationId);
		userContext.getChecker().checkIdOfRetailStore(retailStoreId);
		userContext.getChecker().checkVersionOfRetailStore(retailStoreVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
	
	}
	public  RetailStoreInvestmentInvitation copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreInvestmentInvitationId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
		synchronized(retailStoreInvestmentInvitation){ 
			//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStore.updateLastUpdateTime(userContext.now());
			
			retailStoreInvestmentInvitation.copyRetailStoreFrom( retailStore );		
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreInvestmentInvitation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);
	
	}
	
	public  RetailStoreInvestmentInvitation updateRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreInvestmentInvitationId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();
		
		
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, loadTokens);
		
		synchronized(retailStoreInvestmentInvitation){ 
			//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreInvestmentInvitation.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreInvestmentInvitation.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreInvestmentInvitationManagerException(retailStore+" is NOT FOUND" );
			}
			
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().createRetailStoreCreation(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().createRetailStoreFranchising(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().createRetailStoreDecoration(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().createRetailStoreOpening(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}	public  RetailStoreInvestmentInvitation associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().createRetailStoreClosing(userContext,  comment);
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}
	*/
	
	public  RetailStoreInvestmentInvitation associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreCreation creation = userContext.getManagerGroup().getRetailStoreCreationManager().loadRetailStoreCreation(userContext,creationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateCreation(creation);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}	public  RetailStoreInvestmentInvitation associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String franchisingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreFranchising franchising = userContext.getManagerGroup().getRetailStoreFranchisingManager().loadRetailStoreFranchising(userContext,franchisingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateFranchising(franchising);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}	public  RetailStoreInvestmentInvitation associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String decorationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreDecoration decoration = userContext.getManagerGroup().getRetailStoreDecorationManager().loadRetailStoreDecoration(userContext,decorationId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateDecoration(decoration);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}	public  RetailStoreInvestmentInvitation associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String openingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreOpening opening = userContext.getManagerGroup().getRetailStoreOpeningManager().loadRetailStoreOpening(userContext,openingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateOpening(opening);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}	public  RetailStoreInvestmentInvitation associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String  retailStoreIds[], String closingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "oneof", this.joinArray("|", retailStoreIds)).done();
		
		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, options);
		
		RetailStoreClosing closing = userContext.getManagerGroup().getRetailStoreClosingManager().loadRetailStoreClosing(userContext,closingId,new String[]{"none"} );
		
		for(RetailStore retailStore: retailStoreInvestmentInvitation.getRetailStoreList()) {
			//TODO: need to check if already associated
			retailStore.updateClosing(closing);
		}
		return this.internalSaveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreInvestmentInvitation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


