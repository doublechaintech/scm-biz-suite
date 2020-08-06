
package com.doublechaintech.retailscm.retailstoredecoration;

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



import com.doublechaintech.retailscm.retailstore.RetailStore;


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;






public class RetailStoreDecorationManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreDecorationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = RetailStoreDecorationTokens.start().withTokenFromListName(listName).done();
		RetailStoreDecoration  retailStoreDecoration = (RetailStoreDecoration) this.loadRetailStoreDecoration(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreDecoration.collectRefercencesFromLists();
		retailStoreDecorationDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, retailStoreDecoration, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreDecorationGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "RetailStoreDecoration";
	@Override
	public RetailStoreDecorationDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreDecorationDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreDecorationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreDecoration, tokens);
 	}
 	
 	
 	 public RetailStoreDecoration searchRetailStoreDecoration(RetailscmUserContext userContext, String retailStoreDecorationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreDecorationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration( userContext, retailStoreDecorationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreDecoration, tokens);
 	}
 	
 	

 	protected RetailStoreDecoration present(RetailscmUserContext userContext, RetailStoreDecoration retailStoreDecoration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreDecoration,tokens);
		
		
		RetailStoreDecoration  retailStoreDecorationToPresent = retailStoreDecorationDaoOf(userContext).present(retailStoreDecoration, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreDecorationToPresent.collectRefercencesFromLists();
		retailStoreDecorationDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,retailStoreDecoration,tokens);
		
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
 		return retailStoreDecorationDaoOf(userContext).save(retailStoreDecoration, tokens);
 	}
 	protected RetailStoreDecoration loadRetailStoreDecoration(RetailscmUserContext userContext, String retailStoreDecorationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreDecorationManagerException.class);

 
 		return retailStoreDecorationDaoOf(userContext).load(retailStoreDecorationId, tokens);
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
	
 	
 	
 
 	
 	

	public RetailStoreDecoration createRetailStoreDecoration(RetailscmUserContext userContext, String comment) throws Exception
	//public RetailStoreDecoration createRetailStoreDecoration(RetailscmUserContext userContext,String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkCommentOfRetailStoreDecoration(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		checkerOf(userContext).checkVersionOfRetailStoreDecoration( retailStoreDecorationVersion);
		

		if(RetailStoreDecoration.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfRetailStoreDecoration(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);


	}



	public RetailStoreDecoration clone(RetailscmUserContext userContext, String fromRetailStoreDecorationId) throws Exception{

		return retailStoreDecorationDaoOf(userContext).clone(fromRetailStoreDecorationId, this.allTokens());
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
			if (retailStoreDecoration.isChanged()){
			
			}
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
		.analyzeAllLists().done();

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

		retailStoreDecorationDaoOf(userContext).delete(retailStoreDecorationId, retailStoreDecorationVersion);
	}

	public RetailStoreDecoration forgetByAll(RetailscmUserContext userContext, String retailStoreDecorationId, int retailStoreDecorationVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreDecorationId, retailStoreDecorationVersion);
	}
	protected RetailStoreDecoration forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreDecorationId, int retailStoreDecorationVersion) throws Exception{

		return retailStoreDecorationDaoOf(userContext).disconnectFromAll(retailStoreDecorationId, retailStoreDecorationVersion);
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
		return retailStoreDecorationDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreDecoration with retail_store_country_center in RetailStore
	protected RetailStoreDecoration breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());

			synchronized(retailStoreDecoration){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDecorationDaoOf(userContext).planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreDecoration, retailStoreCountryCenterId, this.emptyOptions());

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

				retailStoreDecorationDaoOf(userContext).planToRemoveRetailStoreListWithCityServiceCenter(retailStoreDecoration, cityServiceCenterId, this.emptyOptions());

				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				return retailStoreDecoration;
			}
	}
	//disconnect RetailStoreDecoration with creation in RetailStore
	protected RetailStoreDecoration breakWithRetailStoreByCreation(RetailscmUserContext userContext, String retailStoreDecorationId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());

			synchronized(retailStoreDecoration){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDecorationDaoOf(userContext).planToRemoveRetailStoreListWithCreation(retailStoreDecoration, creationId, this.emptyOptions());

				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				return retailStoreDecoration;
			}
	}
	//disconnect RetailStoreDecoration with investment_invitation in RetailStore
	protected RetailStoreDecoration breakWithRetailStoreByInvestmentInvitation(RetailscmUserContext userContext, String retailStoreDecorationId, String investmentInvitationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());

			synchronized(retailStoreDecoration){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDecorationDaoOf(userContext).planToRemoveRetailStoreListWithInvestmentInvitation(retailStoreDecoration, investmentInvitationId, this.emptyOptions());

				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				return retailStoreDecoration;
			}
	}
	//disconnect RetailStoreDecoration with franchising in RetailStore
	protected RetailStoreDecoration breakWithRetailStoreByFranchising(RetailscmUserContext userContext, String retailStoreDecorationId, String franchisingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());

			synchronized(retailStoreDecoration){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDecorationDaoOf(userContext).planToRemoveRetailStoreListWithFranchising(retailStoreDecoration, franchisingId, this.emptyOptions());

				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				return retailStoreDecoration;
			}
	}
	//disconnect RetailStoreDecoration with opening in RetailStore
	protected RetailStoreDecoration breakWithRetailStoreByOpening(RetailscmUserContext userContext, String retailStoreDecorationId, String openingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());

			synchronized(retailStoreDecoration){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDecorationDaoOf(userContext).planToRemoveRetailStoreListWithOpening(retailStoreDecoration, openingId, this.emptyOptions());

				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				return retailStoreDecoration;
			}
	}
	//disconnect RetailStoreDecoration with closing in RetailStore
	protected RetailStoreDecoration breakWithRetailStoreByClosing(RetailscmUserContext userContext, String retailStoreDecorationId, String closingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());

			synchronized(retailStoreDecoration){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreDecorationDaoOf(userContext).planToRemoveRetailStoreListWithClosing(retailStoreDecoration, closingId, this.emptyOptions());

				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				return retailStoreDecoration;
			}
	}






	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);

		
		checkerOf(userContext).checkNameOfRetailStore(name);
		
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		
		checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		checkerOf(userContext).checkCreationIdOfRetailStore(creationId);
		
		checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);
		
		checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);
		
		checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);
		
		checkerOf(userContext).checkClosingIdOfRetailStore(closingId);
		
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		
		checkerOf(userContext).checkDescriptionOfRetailStore(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);


	}
	public  RetailStoreDecoration addRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStore(userContext,retailStoreDecorationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, openingId, closingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, openingId, closingId, founded, latitude, longitude, description);

		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, emptyOptions());
		synchronized(retailStoreDecoration){
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreDecoration.addRetailStore( retailStore );
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			
			retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreDecorationId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

	}
	public  RetailStoreDecoration updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreDecorationId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreDecorationId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreDecoration retailStoreDecorationToUpdate = loadRetailStoreDecoration(userContext, retailStoreDecorationId, options);

		if(retailStoreDecorationToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreDecorationManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}

		RetailStore item = retailStoreDecorationToUpdate.getRetailStoreList().first();
		beforeUpdateRetailStoreProperties(userContext,item, retailStoreDecorationId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);
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

	protected  void beforeUpdateRetailStoreProperties(RetailscmUserContext userContext, RetailStore item, String retailStoreDecorationId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

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
		RetailStoreCreation  creation = new RetailStoreCreation();
		creation.setId(creationId);		
		retailStore.setCreation(creation);		
		RetailStoreInvestmentInvitation  investmentInvitation = new RetailStoreInvestmentInvitation();
		investmentInvitation.setId(investmentInvitationId);		
		retailStore.setInvestmentInvitation(investmentInvitation);		
		RetailStoreFranchising  franchising = new RetailStoreFranchising();
		franchising.setId(franchisingId);		
		retailStore.setFranchising(franchising);		
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

	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreDecorationId,
			String retailStoreIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

	}
	public  RetailStoreDecoration removeRetailStoreList(RetailscmUserContext userContext, String retailStoreDecorationId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreDecorationId,  retailStoreIds, tokensExpr);


			RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, allTokens());
			synchronized(retailStoreDecoration){
				//Will be good when the retailStoreDecoration loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDecorationDaoOf(userContext).planToRemoveRetailStoreList(retailStoreDecoration, retailStoreIds, allTokens());
				retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreDecoration.getRetailStoreList());
				return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreDecoration( retailStoreDecorationId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

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
		
		checkerOf(userContext).checkIdOfRetailStoreDecoration( retailStoreDecorationId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

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
			
			retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, (RetailStore)retailStoreDecoration.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreDecoration(retailStoreDecorationId);
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
		

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreDecorationManagerException.class);

	}

	public  RetailStoreDecoration updateRetailStore(RetailscmUserContext userContext, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStore(userContext, retailStoreDecorationId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, tokens().equals(), retailStoreId).done();



		RetailStoreDecoration retailStoreDecoration = loadRetailStoreDecoration(userContext, retailStoreDecorationId, loadTokens);

		synchronized(retailStoreDecoration){
			//Will be good when the retailStoreDecoration loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreDecoration.removeRetailStore( retailStore );
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIdVersionKey = createIndexedRetailStore(retailStoreId, retailStoreVersion);

			RetailStore retailStore = retailStoreDecoration.findTheRetailStore(retailStoreIdVersionKey);
			if(retailStore == null){
				throw new RetailStoreDecorationManagerException(retailStoreId+" is NOT FOUND" );
			}

			beforeUpdateRetailStore(userContext, retailStore, retailStoreDecorationId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreDecoration = saveRetailStoreDecoration(userContext, retailStoreDecoration, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreDecoration, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateRetailStore(RetailscmUserContext userContext, RetailStore existed, String retailStoreDecorationId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreDecoration newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreDecorationDaoOf(ctx).loadAllAsStream().forEach(
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

    if (methodName.equals("ensureModelInDB")){
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
		//   RetailStoreDecoration newRetailStoreDecoration = this.createRetailStoreDecoration(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreDecoration
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreDecoration.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreDecoration> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreDecorationId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreDecorationDetailScope().clone();
		RetailStoreDecoration merchantObj = (RetailStoreDecoration) this.view(userContext, retailStoreDecorationId);
    String merchantObjId = retailStoreDecorationId;
    String linkToUrl =	"retailStoreDecorationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超装修"+"详情";
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
		    "retailStoreManager/listByDecoration/"+merchantObjId+"/",
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


