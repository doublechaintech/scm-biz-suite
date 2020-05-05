
package com.doublechaintech.retailscm.retailstorecreation;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.retailstore.RetailStore;


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;






public class RetailStoreCreationManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreCreationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreCreationTokens.start().withTokenFromListName(listName).done();
		RetailStoreCreation  retailStoreCreation = (RetailStoreCreation) this.loadRetailStoreCreation(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreCreation.collectRefercencesFromLists();
		retailStoreCreationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreCreation, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreCreationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreCreation";
	@Override
	public RetailStoreCreationDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreCreationDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreCreationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCreation, tokens);
 	}
 	
 	
 	 public RetailStoreCreation searchRetailStoreCreation(RetailscmUserContext userContext, String retailStoreCreationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreCreationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation( userContext, retailStoreCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCreation, tokens);
 	}
 	
 	

 	protected RetailStoreCreation present(RetailscmUserContext userContext, RetailStoreCreation retailStoreCreation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreCreation,tokens);
		
		
		RetailStoreCreation  retailStoreCreationToPresent = retailStoreCreationDaoOf(userContext).present(retailStoreCreation, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreCreationToPresent.collectRefercencesFromLists();
		retailStoreCreationDaoOf(userContext).alias(entityListToNaming);
		
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
 		return retailStoreCreationDaoOf(userContext).save(retailStoreCreation, tokens);
 	}
 	protected RetailStoreCreation loadRetailStoreCreation(RetailscmUserContext userContext, String retailStoreCreationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreCreationManagerException.class);

 
 		return retailStoreCreationDaoOf(userContext).load(retailStoreCreationId, tokens);
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
	
 	
 	
 
 	
 	

	public RetailStoreCreation createRetailStoreCreation(RetailscmUserContext userContext, String comment) throws Exception
	//public RetailStoreCreation createRetailStoreCreation(RetailscmUserContext userContext,String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkCommentOfRetailStoreCreation(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
		checkerOf(userContext).checkVersionOfRetailStoreCreation( retailStoreCreationVersion);
		

		if(RetailStoreCreation.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfRetailStoreCreation(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);


	}



	public RetailStoreCreation clone(RetailscmUserContext userContext, String fromRetailStoreCreationId) throws Exception{

		return retailStoreCreationDaoOf(userContext).clone(fromRetailStoreCreationId, this.allTokens());
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
			if (retailStoreCreation.isChanged()){
			
			}
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
		.analyzeAllLists().done();

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

		retailStoreCreationDaoOf(userContext).delete(retailStoreCreationId, retailStoreCreationVersion);
	}

	public RetailStoreCreation forgetByAll(RetailscmUserContext userContext, String retailStoreCreationId, int retailStoreCreationVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreCreationId, retailStoreCreationVersion);
	}
	protected RetailStoreCreation forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreCreationId, int retailStoreCreationVersion) throws Exception{

		return retailStoreCreationDaoOf(userContext).disconnectFromAll(retailStoreCreationId, retailStoreCreationVersion);
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
		return retailStoreCreationDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreCreation with retail_store_country_center in RetailStore
	protected RetailStoreCreation breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreCreationId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());

			synchronized(retailStoreCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCreationDaoOf(userContext).planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreCreation, retailStoreCountryCenterId, this.emptyOptions());

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

				retailStoreCreationDaoOf(userContext).planToRemoveRetailStoreListWithCityServiceCenter(retailStoreCreation, cityServiceCenterId, this.emptyOptions());

				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				return retailStoreCreation;
			}
	}
	//disconnect RetailStoreCreation with investment_invitation in RetailStore
	protected RetailStoreCreation breakWithRetailStoreByInvestmentInvitation(RetailscmUserContext userContext, String retailStoreCreationId, String investmentInvitationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());

			synchronized(retailStoreCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCreationDaoOf(userContext).planToRemoveRetailStoreListWithInvestmentInvitation(retailStoreCreation, investmentInvitationId, this.emptyOptions());

				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				return retailStoreCreation;
			}
	}
	//disconnect RetailStoreCreation with franchising in RetailStore
	protected RetailStoreCreation breakWithRetailStoreByFranchising(RetailscmUserContext userContext, String retailStoreCreationId, String franchisingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());

			synchronized(retailStoreCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCreationDaoOf(userContext).planToRemoveRetailStoreListWithFranchising(retailStoreCreation, franchisingId, this.emptyOptions());

				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				return retailStoreCreation;
			}
	}
	//disconnect RetailStoreCreation with decoration in RetailStore
	protected RetailStoreCreation breakWithRetailStoreByDecoration(RetailscmUserContext userContext, String retailStoreCreationId, String decorationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());

			synchronized(retailStoreCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCreationDaoOf(userContext).planToRemoveRetailStoreListWithDecoration(retailStoreCreation, decorationId, this.emptyOptions());

				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				return retailStoreCreation;
			}
	}
	//disconnect RetailStoreCreation with opening in RetailStore
	protected RetailStoreCreation breakWithRetailStoreByOpening(RetailscmUserContext userContext, String retailStoreCreationId, String openingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());

			synchronized(retailStoreCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCreationDaoOf(userContext).planToRemoveRetailStoreListWithOpening(retailStoreCreation, openingId, this.emptyOptions());

				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				return retailStoreCreation;
			}
	}
	//disconnect RetailStoreCreation with closing in RetailStore
	protected RetailStoreCreation breakWithRetailStoreByClosing(RetailscmUserContext userContext, String retailStoreCreationId, String closingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());

			synchronized(retailStoreCreation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCreationDaoOf(userContext).planToRemoveRetailStoreListWithClosing(retailStoreCreation, closingId, this.emptyOptions());

				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				return retailStoreCreation;
			}
	}






	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);

		
		checkerOf(userContext).checkNameOfRetailStore(name);
		
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		
		checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);
		
		checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);
		
		checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);
		
		checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);
		
		checkerOf(userContext).checkClosingIdOfRetailStore(closingId);
		
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		
		checkerOf(userContext).checkDescriptionOfRetailStore(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);


	}
	public  RetailStoreCreation addRetailStore(RetailscmUserContext userContext, String retailStoreCreationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStore(userContext,retailStoreCreationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, investmentInvitationId, franchisingId, decorationId, openingId, closingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, investmentInvitationId, franchisingId, decorationId, openingId, closingId, founded, latitude, longitude, description);

		RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, emptyOptions());
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

		checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

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


	protected RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

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
		RetailStoreInvestmentInvitation  investmentInvitation = new RetailStoreInvestmentInvitation();
		investmentInvitation.setId(investmentInvitationId);		
		retailStore.setInvestmentInvitation(investmentInvitation);		
		RetailStoreFranchising  franchising = new RetailStoreFranchising();
		franchising.setId(franchisingId);		
		retailStore.setFranchising(franchising);		
		RetailStoreDecoration  decoration = new RetailStoreDecoration();
		decoration.setId(decorationId);		
		retailStore.setDecoration(decoration);		
		RetailStoreOpening  opening = new RetailStoreOpening();
		opening.setId(openingId);		
		retailStore.setOpening(opening);		
		RetailStoreClosing  closing = new RetailStoreClosing();
		closing.setId(closingId);		
		retailStore.setClosing(closing);		
		retailStore.setFounded(founded);		
		retailStore.setLatitude(latitude);		
		retailStore.setLongitude(longitude);		
		retailStore.setDescription(description);		
		retailStore.setLastUpdateTime(userContext.now());
	
		
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

		checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

	}
	public  RetailStoreCreation removeRetailStoreList(RetailscmUserContext userContext, String retailStoreCreationId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreCreationId,  retailStoreIds, tokensExpr);


			RetailStoreCreation retailStoreCreation = loadRetailStoreCreation(userContext, retailStoreCreationId, allTokens());
			synchronized(retailStoreCreation){
				//Will be good when the retailStoreCreation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCreationDaoOf(userContext).planToRemoveRetailStoreList(retailStoreCreation, retailStoreIds, allTokens());
				retailStoreCreation = saveRetailStoreCreation(userContext, retailStoreCreation, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreCreation.getRetailStoreList());
				return present(userContext,retailStoreCreation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreCreationId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCreation( retailStoreCreationId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

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
		
		checkerOf(userContext).checkIdOfRetailStoreCreation( retailStoreCreationId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfRetailStoreCreation(retailStoreCreationId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStore(parseString(newValueExpr));
		
		}
		
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTelephoneOfRetailStore(parseString(newValueExpr));
		
		}
		
		if(RetailStore.OWNER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOwnerOfRetailStore(parseString(newValueExpr));
		
		}
		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfRetailStore(parseDate(newValueExpr));
		
		}
		
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfRetailStore(parseBigDecimal(newValueExpr));
		
		}
		
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfRetailStore(parseBigDecimal(newValueExpr));
		
		}
		
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfRetailStore(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCreationManagerException.class);

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

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreCreation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
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
		//   RetailStoreCreation newRetailStoreCreation = this.createRetailStoreCreation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreCreation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreCreation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreCreation> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreCreationId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreCreationDetailScope().clone();
		RetailStoreCreation merchantObj = (RetailStoreCreation) this.view(userContext, retailStoreCreationId);
    String merchantObjId = retailStoreCreationId;
    String linkToUrl =	"retailStoreCreationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超的创作"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-comment")
				    .put("fieldName", "comment")
				    .put("label", "评论")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comment", merchantObj.getComment());

		//处理 sectionList

		//处理Section：retailStoreListSection
		Map retailStoreListSection = ListofUtils.buildSection(
		    "retailStoreListSection",
		    "零售门店列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreManager/listByCreation/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreListSection);

		result.put("retailStoreListSection", ListofUtils.toShortList(merchantObj.getRetailStoreList(), "retailStore"));
		vscope.field("retailStoreListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( RetailStore.class.getName(), null));

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


