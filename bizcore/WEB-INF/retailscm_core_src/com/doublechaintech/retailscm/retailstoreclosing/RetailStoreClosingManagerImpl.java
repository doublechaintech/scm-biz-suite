
package com.doublechaintech.retailscm.retailstoreclosing;

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






public class RetailStoreClosingManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreClosingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreClosingTokens.start().withTokenFromListName(listName).done();
		RetailStoreClosing  retailStoreClosing = (RetailStoreClosing) this.loadRetailStoreClosing(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreClosing.collectRefercencesFromLists();
		retailStoreClosingDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreClosing, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreClosingGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreClosing";
	@Override
	public RetailStoreClosingDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreClosingDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreClosing, tokens);
 	}
 	
 	
 	 public RetailStoreClosing searchRetailStoreClosing(RetailscmUserContext userContext, String retailStoreClosingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreClosing, tokens);
 	}
 	
 	

 	protected RetailStoreClosing present(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreClosing,tokens);
		
		
		RetailStoreClosing  retailStoreClosingToPresent = retailStoreClosingDaoOf(userContext).present(retailStoreClosing, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreClosingToPresent.collectRefercencesFromLists();
		retailStoreClosingDaoOf(userContext).alias(entityListToNaming);
		
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
 		return retailStoreClosingDaoOf(userContext).save(retailStoreClosing, tokens);
 	}
 	protected RetailStoreClosing loadRetailStoreClosing(RetailscmUserContext userContext, String retailStoreClosingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);

 
 		return retailStoreClosingDaoOf(userContext).load(retailStoreClosingId, tokens);
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
	
 	
 	
 
 	
 	

	public RetailStoreClosing createRetailStoreClosing(RetailscmUserContext userContext, String comment) throws Exception
	//public RetailStoreClosing createRetailStoreClosing(RetailscmUserContext userContext,String comment) throws Exception
	{

		

		

		checkerOf(userContext).checkCommentOfRetailStoreClosing(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		checkerOf(userContext).checkVersionOfRetailStoreClosing( retailStoreClosingVersion);
		

		if(RetailStoreClosing.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfRetailStoreClosing(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);


	}



	public RetailStoreClosing clone(RetailscmUserContext userContext, String fromRetailStoreClosingId) throws Exception{

		return retailStoreClosingDaoOf(userContext).clone(fromRetailStoreClosingId, this.allTokens());
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
			if (retailStoreClosing.isChanged()){
			
			}
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
		.analyzeAllLists().done();

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

		retailStoreClosingDaoOf(userContext).delete(retailStoreClosingId, retailStoreClosingVersion);
	}

	public RetailStoreClosing forgetByAll(RetailscmUserContext userContext, String retailStoreClosingId, int retailStoreClosingVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreClosingId, retailStoreClosingVersion);
	}
	protected RetailStoreClosing forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreClosingId, int retailStoreClosingVersion) throws Exception{

		return retailStoreClosingDaoOf(userContext).disconnectFromAll(retailStoreClosingId, retailStoreClosingVersion);
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
		return retailStoreClosingDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreClosing with retail_store_country_center in RetailStore
	protected RetailStoreClosing breakWithRetailStoreByRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreClosingId, String retailStoreCountryCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());

			synchronized(retailStoreClosing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreListWithRetailStoreCountryCenter(retailStoreClosing, retailStoreCountryCenterId, this.emptyOptions());

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

				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreListWithCityServiceCenter(retailStoreClosing, cityServiceCenterId, this.emptyOptions());

				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				return retailStoreClosing;
			}
	}
	//disconnect RetailStoreClosing with creation in RetailStore
	protected RetailStoreClosing breakWithRetailStoreByCreation(RetailscmUserContext userContext, String retailStoreClosingId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());

			synchronized(retailStoreClosing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreListWithCreation(retailStoreClosing, creationId, this.emptyOptions());

				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				return retailStoreClosing;
			}
	}
	//disconnect RetailStoreClosing with investment_invitation in RetailStore
	protected RetailStoreClosing breakWithRetailStoreByInvestmentInvitation(RetailscmUserContext userContext, String retailStoreClosingId, String investmentInvitationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());

			synchronized(retailStoreClosing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreListWithInvestmentInvitation(retailStoreClosing, investmentInvitationId, this.emptyOptions());

				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				return retailStoreClosing;
			}
	}
	//disconnect RetailStoreClosing with franchising in RetailStore
	protected RetailStoreClosing breakWithRetailStoreByFranchising(RetailscmUserContext userContext, String retailStoreClosingId, String franchisingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());

			synchronized(retailStoreClosing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreListWithFranchising(retailStoreClosing, franchisingId, this.emptyOptions());

				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				return retailStoreClosing;
			}
	}
	//disconnect RetailStoreClosing with decoration in RetailStore
	protected RetailStoreClosing breakWithRetailStoreByDecoration(RetailscmUserContext userContext, String retailStoreClosingId, String decorationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());

			synchronized(retailStoreClosing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreListWithDecoration(retailStoreClosing, decorationId, this.emptyOptions());

				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				return retailStoreClosing;
			}
	}
	//disconnect RetailStoreClosing with opening in RetailStore
	protected RetailStoreClosing breakWithRetailStoreByOpening(RetailscmUserContext userContext, String retailStoreClosingId, String openingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());

			synchronized(retailStoreClosing){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreListWithOpening(retailStoreClosing, openingId, this.emptyOptions());

				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				return retailStoreClosing;
			}
	}






	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);

		
		checkerOf(userContext).checkNameOfRetailStore(name);
		
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		
		checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);
		
		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		checkerOf(userContext).checkCreationIdOfRetailStore(creationId);
		
		checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);
		
		checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);
		
		checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);
		
		checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);
		
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		
		checkerOf(userContext).checkDescriptionOfRetailStore(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);


	}
	public  RetailStoreClosing addRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStore(userContext,retailStoreClosingId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, openingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, openingId, founded, latitude, longitude, description);

		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, emptyOptions());
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

		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);

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


	protected RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

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
		RetailStoreDecoration  decoration = new RetailStoreDecoration();
		decoration.setId(decorationId);		
		retailStore.setDecoration(decoration);		
		RetailStoreOpening  opening = new RetailStoreOpening();
		opening.setId(openingId);		
		retailStore.setOpening(opening);		
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

	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreClosingId,
			String retailStoreIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);

	}
	public  RetailStoreClosing removeRetailStoreList(RetailscmUserContext userContext, String retailStoreClosingId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreClosingId,  retailStoreIds, tokensExpr);


			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
			synchronized(retailStoreClosing){
				//Will be good when the retailStoreClosing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreList(retailStoreClosing, retailStoreIds, allTokens());
				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreClosing.getRetailStoreList());
				return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreClosing( retailStoreClosingId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);

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
		
		checkerOf(userContext).checkIdOfRetailStoreClosing( retailStoreClosingId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);

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
		

		
		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);

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

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreClosing newCreated) throws Exception{
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
		//   RetailStoreClosing newRetailStoreClosing = this.createRetailStoreClosing(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreClosing
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreClosing.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreClosing> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreClosingId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreClosingDetailScope().clone();
		RetailStoreClosing merchantObj = (RetailStoreClosing) this.view(userContext, retailStoreClosingId);
    String merchantObjId = retailStoreClosingId;
    String linkToUrl =	"retailStoreClosingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "门店关闭"+"详情";
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
		    "retailStoreManager/listByClosing/"+merchantObjId+"/",
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


