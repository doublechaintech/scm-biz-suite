
package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

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






public class RetailStoreInvestmentInvitationManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreInvestmentInvitationManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreInvestmentInvitationTokens.start().withTokenFromListName(listName).done();
		RetailStoreInvestmentInvitation  retailStoreInvestmentInvitation = (RetailStoreInvestmentInvitation) this.loadRetailStoreInvestmentInvitation(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreInvestmentInvitation.collectRefercencesFromLists();
		retailStoreInvestmentInvitationDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreInvestmentInvitation, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreInvestmentInvitationGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreInvestmentInvitation";
	@Override
	public RetailStoreInvestmentInvitationDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreInvestmentInvitationDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreInvestmentInvitationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreInvestmentInvitation, tokens);
 	}
 	
 	
 	 public RetailStoreInvestmentInvitation searchRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreInvestmentInvitationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation( userContext, retailStoreInvestmentInvitationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreInvestmentInvitation, tokens);
 	}
 	
 	

 	protected RetailStoreInvestmentInvitation present(RetailscmUserContext userContext, RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreInvestmentInvitation,tokens);
		
		
		RetailStoreInvestmentInvitation  retailStoreInvestmentInvitationToPresent = retailStoreInvestmentInvitationDaoOf(userContext).present(retailStoreInvestmentInvitation, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreInvestmentInvitationToPresent.collectRefercencesFromLists();
		retailStoreInvestmentInvitationDaoOf(userContext).alias(entityListToNaming);
		
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
 		return retailStoreInvestmentInvitationDaoOf(userContext).save(retailStoreInvestmentInvitation, tokens);
 	}
 	protected RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreInvestmentInvitationManagerException.class);

 
 		return retailStoreInvestmentInvitationDaoOf(userContext).load(retailStoreInvestmentInvitationId, tokens);
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
	
 	
 	
 
 	
 	

	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String comment) throws Exception
	//public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(RetailscmUserContext userContext,String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkCommentOfRetailStoreInvestmentInvitation(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		checkerOf(userContext).checkVersionOfRetailStoreInvestmentInvitation( retailStoreInvestmentInvitationVersion);
		

		if(RetailStoreInvestmentInvitation.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfRetailStoreInvestmentInvitation(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);


	}



	public RetailStoreInvestmentInvitation clone(RetailscmUserContext userContext, String fromRetailStoreInvestmentInvitationId) throws Exception{

		return retailStoreInvestmentInvitationDaoOf(userContext).clone(fromRetailStoreInvestmentInvitationId, this.allTokens());
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
			if (retailStoreInvestmentInvitation.isChanged()){
			
			}
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
		.analyzeAllLists().done();

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

		retailStoreInvestmentInvitationDaoOf(userContext).delete(retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);
	}

	public RetailStoreInvestmentInvitation forgetByAll(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);
	}
	protected RetailStoreInvestmentInvitation forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreInvestmentInvitationId, int retailStoreInvestmentInvitationVersion) throws Exception{

		return retailStoreInvestmentInvitationDaoOf(userContext).disconnectFromAll(retailStoreInvestmentInvitationId, retailStoreInvestmentInvitationVersion);
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
		return retailStoreInvestmentInvitationDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreInvestmentInvitation with retail_store_country_center in RetailStore
	protected RetailStoreInvestmentInvitation breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());

			synchronized(retailStoreInvestmentInvitation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreInvestmentInvitationDaoOf(userContext).planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreInvestmentInvitation, retailStoreCountryCenterId, this.emptyOptions());

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

				retailStoreInvestmentInvitationDaoOf(userContext).planToRemoveRetailStoreListWithCityServiceCenter(retailStoreInvestmentInvitation, cityServiceCenterId, this.emptyOptions());

				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				return retailStoreInvestmentInvitation;
			}
	}
	//disconnect RetailStoreInvestmentInvitation with creation in RetailStore
	protected RetailStoreInvestmentInvitation breakWithRetailStoreByCreation(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());

			synchronized(retailStoreInvestmentInvitation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreInvestmentInvitationDaoOf(userContext).planToRemoveRetailStoreListWithCreation(retailStoreInvestmentInvitation, creationId, this.emptyOptions());

				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				return retailStoreInvestmentInvitation;
			}
	}
	//disconnect RetailStoreInvestmentInvitation with franchising in RetailStore
	protected RetailStoreInvestmentInvitation breakWithRetailStoreByFranchising(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String franchisingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());

			synchronized(retailStoreInvestmentInvitation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreInvestmentInvitationDaoOf(userContext).planToRemoveRetailStoreListWithFranchising(retailStoreInvestmentInvitation, franchisingId, this.emptyOptions());

				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				return retailStoreInvestmentInvitation;
			}
	}
	//disconnect RetailStoreInvestmentInvitation with decoration in RetailStore
	protected RetailStoreInvestmentInvitation breakWithRetailStoreByDecoration(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String decorationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());

			synchronized(retailStoreInvestmentInvitation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreInvestmentInvitationDaoOf(userContext).planToRemoveRetailStoreListWithDecoration(retailStoreInvestmentInvitation, decorationId, this.emptyOptions());

				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				return retailStoreInvestmentInvitation;
			}
	}
	//disconnect RetailStoreInvestmentInvitation with opening in RetailStore
	protected RetailStoreInvestmentInvitation breakWithRetailStoreByOpening(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String openingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());

			synchronized(retailStoreInvestmentInvitation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreInvestmentInvitationDaoOf(userContext).planToRemoveRetailStoreListWithOpening(retailStoreInvestmentInvitation, openingId, this.emptyOptions());

				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				return retailStoreInvestmentInvitation;
			}
	}
	//disconnect RetailStoreInvestmentInvitation with closing in RetailStore
	protected RetailStoreInvestmentInvitation breakWithRetailStoreByClosing(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String closingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());

			synchronized(retailStoreInvestmentInvitation){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreInvestmentInvitationDaoOf(userContext).planToRemoveRetailStoreListWithClosing(retailStoreInvestmentInvitation, closingId, this.emptyOptions());

				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				return retailStoreInvestmentInvitation;
			}
	}






	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);

		
		checkerOf(userContext).checkNameOfRetailStore(name);
		
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		
		checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		checkerOf(userContext).checkCreationIdOfRetailStore(creationId);
		
		checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);
		
		checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);
		
		checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);
		
		checkerOf(userContext).checkClosingIdOfRetailStore(closingId);
		
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		
		checkerOf(userContext).checkDescriptionOfRetailStore(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);


	}
	public  RetailStoreInvestmentInvitation addRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStore(userContext,retailStoreInvestmentInvitationId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, franchisingId, decorationId, openingId, closingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, franchisingId, decorationId, openingId, closingId, founded, latitude, longitude, description);

		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, emptyOptions());
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

		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

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


	protected RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

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

	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId,
			String retailStoreIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

	}
	public  RetailStoreInvestmentInvitation removeRetailStoreList(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreInvestmentInvitationId,  retailStoreIds, tokensExpr);


			RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = loadRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitationId, allTokens());
			synchronized(retailStoreInvestmentInvitation){
				//Will be good when the retailStoreInvestmentInvitation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreInvestmentInvitationDaoOf(userContext).planToRemoveRetailStoreList(retailStoreInvestmentInvitation, retailStoreIds, allTokens());
				retailStoreInvestmentInvitation = saveRetailStoreInvestmentInvitation(userContext, retailStoreInvestmentInvitation, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreInvestmentInvitation.getRetailStoreList());
				return present(userContext,retailStoreInvestmentInvitation, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation( retailStoreInvestmentInvitationId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

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
		
		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation( retailStoreInvestmentInvitationId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(retailStoreInvestmentInvitationId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreInvestmentInvitationManagerException.class);

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

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreInvestmentInvitation newCreated) throws Exception{
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
		//   RetailStoreInvestmentInvitation newRetailStoreInvestmentInvitation = this.createRetailStoreInvestmentInvitation(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreInvestmentInvitation
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreInvestmentInvitation.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreInvestmentInvitation> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreInvestmentInvitationId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreInvestmentInvitationDetailScope().clone();
		RetailStoreInvestmentInvitation merchantObj = (RetailStoreInvestmentInvitation) this.view(userContext, retailStoreInvestmentInvitationId);
    String merchantObjId = retailStoreInvestmentInvitationId;
    String linkToUrl =	"retailStoreInvestmentInvitationManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超招商"+"详情";
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
		    "retailStoreManager/listByInvestmentInvitation/"+merchantObjId+"/",
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


