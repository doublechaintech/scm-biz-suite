
package com.doublechaintech.retailscm.originalvoucherconfirmation;

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

import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;


import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.doublechaintech.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.doublechaintech.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;






public class OriginalVoucherConfirmationManagerImpl extends CustomRetailscmCheckerManager implements OriginalVoucherConfirmationManager {
	
	private static final String SERVICE_TYPE = "OriginalVoucherConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws OriginalVoucherConfirmationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new OriginalVoucherConfirmationManagerException(message);

	}
	
	

 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmation(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherConfirmationDAO().save(originalVoucherConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens);
 	}
 	
 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmationDetail(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation) throws Exception{	

 		
 		return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, allTokens());
 	}
 	
 	public OriginalVoucherConfirmation loadOriginalVoucherConfirmation(RetailscmUserContext userContext, String originalVoucherConfirmationId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherConfirmationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherConfirmation, tokens);
 	}
 	
 	
 	 public OriginalVoucherConfirmation searchOriginalVoucherConfirmation(RetailscmUserContext userContext, String originalVoucherConfirmationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherConfirmationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherConfirmation, tokens);
 	}
 	
 	

 	protected OriginalVoucherConfirmation present(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucherConfirmation,tokens);
		
		
		OriginalVoucherConfirmation  originalVoucherConfirmationToPresent = userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().present(originalVoucherConfirmation, tokens);
		
		List<BaseEntity> entityListToNaming = originalVoucherConfirmationToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().alias(entityListToNaming);
		
		return  originalVoucherConfirmationToPresent;
		
		
	}
 
 	
 	
 	public OriginalVoucherConfirmation loadOriginalVoucherConfirmationDetail(RetailscmUserContext userContext, String originalVoucherConfirmationId) throws Exception{	
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, allTokens());
 		return present(userContext,originalVoucherConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String originalVoucherConfirmationId) throws Exception{	
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, viewTokens());
 		return present(userContext,originalVoucherConfirmation, allTokens());
		
 	}
 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmation(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().save(originalVoucherConfirmation, tokens);
 	}
 	protected OriginalVoucherConfirmation loadOriginalVoucherConfirmation(RetailscmUserContext userContext, String originalVoucherConfirmationId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherConfirmationManagerException.class);

 
 		return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().load(originalVoucherConfirmationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucherConfirmation, tokens);
		
		addAction(userContext, originalVoucherConfirmation, tokens,"@create","createOriginalVoucherConfirmation","createOriginalVoucherConfirmation/","main","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"@update","updateOriginalVoucherConfirmation","updateOriginalVoucherConfirmation/"+originalVoucherConfirmation.getId()+"/","main","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"@copy","cloneOriginalVoucherConfirmation","cloneOriginalVoucherConfirmation/"+originalVoucherConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfOriginalVoucherConfirmation(who);
		userContext.getChecker().checkCommentsOfOriginalVoucherConfirmation(comments);
		userContext.getChecker().checkMakeDateOfOriginalVoucherConfirmation(makeDate);
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);


		OriginalVoucherConfirmation originalVoucherConfirmation=createNewOriginalVoucherConfirmation();	

		originalVoucherConfirmation.setWho(who);
		originalVoucherConfirmation.setComments(comments);
		originalVoucherConfirmation.setMakeDate(makeDate);

		originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, emptyOptions());
		
		onNewInstanceCreated(userContext, originalVoucherConfirmation);
		return originalVoucherConfirmation;

		
	}
	protected OriginalVoucherConfirmation createNewOriginalVoucherConfirmation() 
	{
		
		return new OriginalVoucherConfirmation();		
	}
	
	protected void checkParamsForUpdatingOriginalVoucherConfirmation(RetailscmUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		userContext.getChecker().checkVersionOfOriginalVoucherConfirmation( originalVoucherConfirmationVersion);
		

		if(OriginalVoucherConfirmation.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfOriginalVoucherConfirmation(parseString(newValueExpr));
		}
		if(OriginalVoucherConfirmation.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfOriginalVoucherConfirmation(parseString(newValueExpr));
		}
		if(OriginalVoucherConfirmation.MAKE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkMakeDateOfOriginalVoucherConfirmation(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);
	
		
	}
	
	
	
	public OriginalVoucherConfirmation clone(RetailscmUserContext userContext, String fromOriginalVoucherConfirmationId) throws Exception{
		
		return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().clone(fromOriginalVoucherConfirmationId, this.allTokens());
	}
	
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation) throws Exception 
	{
		return internalSaveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, allTokens());

	}
	public OriginalVoucherConfirmation internalSaveOriginalVoucherConfirmation(RetailscmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(originalVoucherConfirmation){ 
			//will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherConfirmation.
			
			
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, options);
			return originalVoucherConfirmation;
			
		}

	}
	
	public OriginalVoucherConfirmation updateOriginalVoucherConfirmation(RetailscmUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion, property, newValueExpr, tokensExpr);
		
		
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		if(originalVoucherConfirmation.getVersion() != originalVoucherConfirmationVersion){
			String message = "The target version("+originalVoucherConfirmation.getVersion()+") is not equals to version("+originalVoucherConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherConfirmation){ 
			//will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherConfirmation.
			
			originalVoucherConfirmation.changeProperty(property, newValueExpr);
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
		}

	}
	
	public OriginalVoucherConfirmation updateOriginalVoucherConfirmationProperty(RetailscmUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion, property, newValueExpr, tokensExpr);
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		if(originalVoucherConfirmation.getVersion() != originalVoucherConfirmationVersion){
			String message = "The target version("+originalVoucherConfirmation.getVersion()+") is not equals to version("+originalVoucherConfirmationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherConfirmation){ 
			//will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherConfirmation.
			
			originalVoucherConfirmation.changeProperty(property, newValueExpr);
			
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OriginalVoucherConfirmationTokens tokens(){
		return OriginalVoucherConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherConfirmationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortOriginalVoucherListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherConfirmationTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception {
		//deleteInternal(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception{
			
		userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().delete(originalVoucherConfirmationId, originalVoucherConfirmationVersion);
	}
	
	public OriginalVoucherConfirmation forgetByAll(RetailscmUserContext userContext, String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception {
		return forgetByAllInternal(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion);		
	}
	protected OriginalVoucherConfirmation forgetByAllInternal(RetailscmUserContext userContext,
			String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception{
			
		return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().disconnectFromAll(originalVoucherConfirmationId, originalVoucherConfirmationVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().deleteAll();
	}


	//disconnect OriginalVoucherConfirmation with belongs_to in OriginalVoucher
	protected OriginalVoucherConfirmation breakWithOriginalVoucherByBelongsTo(RetailscmUserContext userContext, String originalVoucherConfirmationId, String belongsToId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());

			synchronized(originalVoucherConfirmation){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().planToRemoveOriginalVoucherListWithBelongsTo(originalVoucherConfirmation, belongsToId, this.emptyOptions());

				originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
				return originalVoucherConfirmation;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);

		
		userContext.getChecker().checkTitleOfOriginalVoucher(title);
		
		userContext.getChecker().checkMadeByOfOriginalVoucher(madeBy);
		
		userContext.getChecker().checkReceivedByOfOriginalVoucher(receivedBy);
		
		userContext.getChecker().checkVoucherTypeOfOriginalVoucher(voucherType);
		
		userContext.getChecker().checkVoucherImageOfOriginalVoucher(voucherImage);
		
		userContext.getChecker().checkBelongsToIdOfOriginalVoucher(belongsToId);
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);

	
	}
	public  OriginalVoucherConfirmation addOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOriginalVoucher(userContext,originalVoucherConfirmationId,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId,tokensExpr);
		
		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId);
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		synchronized(originalVoucherConfirmation){ 
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherConfirmation.addOriginalVoucher( originalVoucher );		
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, originalVoucher);
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOriginalVoucherProperties(RetailscmUserContext userContext, String originalVoucherConfirmationId,String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		userContext.getChecker().checkIdOfOriginalVoucher(id);
		
		userContext.getChecker().checkTitleOfOriginalVoucher( title);
		userContext.getChecker().checkMadeByOfOriginalVoucher( madeBy);
		userContext.getChecker().checkReceivedByOfOriginalVoucher( receivedBy);
		userContext.getChecker().checkVoucherTypeOfOriginalVoucher( voucherType);
		userContext.getChecker().checkVoucherImageOfOriginalVoucher( voucherImage);

		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);
		
	}
	public  OriginalVoucherConfirmation updateOriginalVoucherProperties(RetailscmUserContext userContext, String originalVoucherConfirmationId, String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingOriginalVoucherProperties(userContext,originalVoucherConfirmationId,id,title,madeBy,receivedBy,voucherType,voucherImage,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOriginalVoucherListList()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "is", id).done();
		
		OriginalVoucherConfirmation originalVoucherConfirmationToUpdate = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, options);
		
		if(originalVoucherConfirmationToUpdate.getOriginalVoucherList().isEmpty()){
			throw new OriginalVoucherConfirmationManagerException("OriginalVoucher is NOT FOUND with id: '"+id+"'");
		}
		
		OriginalVoucher item = originalVoucherConfirmationToUpdate.getOriginalVoucherList().first();
		
		item.updateTitle( title );
		item.updateMadeBy( madeBy );
		item.updateReceivedBy( receivedBy );
		item.updateVoucherType( voucherType );
		item.updateVoucherImage( voucherImage );

		
		//checkParamsForAddingOriginalVoucher(userContext,originalVoucherConfirmationId,name, code, used,tokensExpr);
		OriginalVoucherConfirmation originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmationToUpdate, tokens().withOriginalVoucherList().done());
		synchronized(originalVoucherConfirmation){ 
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected OriginalVoucher createOriginalVoucher(RetailscmUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId) throws Exception{

		OriginalVoucher originalVoucher = new OriginalVoucher();
		
		
		originalVoucher.setTitle(title);		
		originalVoucher.setMadeBy(madeBy);		
		originalVoucher.setReceivedBy(receivedBy);		
		originalVoucher.setVoucherType(voucherType);		
		originalVoucher.setVoucherImage(voucherImage);		
		AccountingDocument  belongsTo = new AccountingDocument();
		belongsTo.setId(belongsToId);		
		originalVoucher.setBelongsTo(belongsTo);		
		originalVoucher.setCurrentStatus("INIT");
	
		
		return originalVoucher;
	
		
	}
	
	protected OriginalVoucher createIndexedOriginalVoucher(String id, int version){

		OriginalVoucher originalVoucher = new OriginalVoucher();
		originalVoucher.setId(id);
		originalVoucher.setVersion(version);
		return originalVoucher;			
		
	}
	
	protected void checkParamsForRemovingOriginalVoucherList(RetailscmUserContext userContext, String originalVoucherConfirmationId, 
			String originalVoucherIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		for(String originalVoucherId: originalVoucherIds){
			userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);
		
	}
	public  OriginalVoucherConfirmation removeOriginalVoucherList(RetailscmUserContext userContext, String originalVoucherConfirmationId, 
			String originalVoucherIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingOriginalVoucherList(userContext, originalVoucherConfirmationId,  originalVoucherIds, tokensExpr);
			
			
			OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
			synchronized(originalVoucherConfirmation){ 
				//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getOriginalVoucherConfirmationDAO().planToRemoveOriginalVoucherList(originalVoucherConfirmation, originalVoucherIds, allTokens());
				originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
				deleteRelationListInGraph(userContext, originalVoucherConfirmation.getOriginalVoucherList());
				return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOriginalVoucherConfirmation( originalVoucherConfirmationId);
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher(originalVoucherVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);
	
	}
	public  OriginalVoucherConfirmation removeOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOriginalVoucher(userContext,originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		synchronized(originalVoucherConfirmation){ 
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherConfirmation.removeOriginalVoucher( originalVoucher );		
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			deleteRelationInGraph(userContext, originalVoucher);
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOriginalVoucherConfirmation( originalVoucherConfirmationId);
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher(originalVoucherVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);
	
	}
	public  OriginalVoucherConfirmation copyOriginalVoucherFrom(RetailscmUserContext userContext, String originalVoucherConfirmationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOriginalVoucher(userContext,originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		synchronized(originalVoucherConfirmation){ 
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			originalVoucherConfirmation.copyOriginalVoucherFrom( originalVoucher );		
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, (OriginalVoucher)originalVoucherConfirmation.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfOriginalVoucherConfirmation(originalVoucherConfirmationId);
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher(originalVoucherVersion);
		

		if(OriginalVoucher.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfOriginalVoucher(parseString(newValueExpr));
		}
		
		if(OriginalVoucher.MADE_BY_PROPERTY.equals(property)){
			userContext.getChecker().checkMadeByOfOriginalVoucher(parseString(newValueExpr));
		}
		
		if(OriginalVoucher.RECEIVED_BY_PROPERTY.equals(property)){
			userContext.getChecker().checkReceivedByOfOriginalVoucher(parseString(newValueExpr));
		}
		
		if(OriginalVoucher.VOUCHER_TYPE_PROPERTY.equals(property)){
			userContext.getChecker().checkVoucherTypeOfOriginalVoucher(parseString(newValueExpr));
		}
		
		if(OriginalVoucher.VOUCHER_IMAGE_PROPERTY.equals(property)){
			userContext.getChecker().checkVoucherImageOfOriginalVoucher(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherConfirmationManagerException.class);
	
	}
	
	public  OriginalVoucherConfirmation updateOriginalVoucher(RetailscmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withOriginalVoucherList().searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "eq", originalVoucherId).done();
		
		
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, loadTokens);
		
		synchronized(originalVoucherConfirmation){ 
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//originalVoucherConfirmation.removeOriginalVoucher( originalVoucher );	
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		
			OriginalVoucher originalVoucher = originalVoucherConfirmation.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new OriginalVoucherConfirmationManagerException(originalVoucher+" is NOT FOUND" );
			}
			
			originalVoucher.changeProperty(property, newValueExpr);
			
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  OriginalVoucherConfirmation associateOriginalVoucherListToNewCreation(RetailscmUserContext userContext, String originalVoucherConfirmationId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, options);
		
		OriginalVoucherCreation creation = userContext.getManagerGroup().getOriginalVoucherCreationManager().createOriginalVoucherCreation(userContext,  who,  comments,  makeDate);
		
		for(OriginalVoucher originalVoucher: originalVoucherConfirmation.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateCreation(creation);
		}
		return this.internalSaveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation);
	}	public  OriginalVoucherConfirmation associateOriginalVoucherListToNewAuditing(RetailscmUserContext userContext, String originalVoucherConfirmationId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, options);
		
		OriginalVoucherAuditing auditing = userContext.getManagerGroup().getOriginalVoucherAuditingManager().createOriginalVoucherAuditing(userContext,  who,  comments,  makeDate);
		
		for(OriginalVoucher originalVoucher: originalVoucherConfirmation.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateAuditing(auditing);
		}
		return this.internalSaveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation);
	}
	*/
	
	public  OriginalVoucherConfirmation associateOriginalVoucherListToCreation(RetailscmUserContext userContext, String originalVoucherConfirmationId, String  originalVoucherIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, options);
		
		OriginalVoucherCreation creation = userContext.getManagerGroup().getOriginalVoucherCreationManager().loadOriginalVoucherCreation(userContext,creationId,new String[]{"none"} );
		
		for(OriginalVoucher originalVoucher: originalVoucherConfirmation.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateCreation(creation);
		}
		return this.internalSaveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation);
	}	public  OriginalVoucherConfirmation associateOriginalVoucherListToAuditing(RetailscmUserContext userContext, String originalVoucherConfirmationId, String  originalVoucherIds[], String auditingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, options);
		
		OriginalVoucherAuditing auditing = userContext.getManagerGroup().getOriginalVoucherAuditingManager().loadOriginalVoucherAuditing(userContext,auditingId,new String[]{"none"} );
		
		for(OriginalVoucher originalVoucher: originalVoucherConfirmation.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateAuditing(auditing);
		}
		return this.internalSaveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucherConfirmation newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


