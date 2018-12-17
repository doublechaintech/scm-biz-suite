
package com.doublechaintech.retailscm.originalvoucherauditing;

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






public class OriginalVoucherAuditingManagerImpl extends CustomRetailscmCheckerManager implements OriginalVoucherAuditingManager {
	
	private static final String SERVICE_TYPE = "OriginalVoucherAuditing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws OriginalVoucherAuditingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new OriginalVoucherAuditingManagerException(message);

	}
	
	

 	protected OriginalVoucherAuditing saveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherAuditingDAO().save(originalVoucherAuditing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens);
 	}
 	
 	protected OriginalVoucherAuditing saveOriginalVoucherAuditingDetail(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing) throws Exception{	

 		
 		return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, allTokens());
 	}
 	
 	public OriginalVoucherAuditing loadOriginalVoucherAuditing(RetailscmUserContext userContext, String originalVoucherAuditingId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherAuditingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherAuditing, tokens);
 	}
 	
 	
 	 public OriginalVoucherAuditing searchOriginalVoucherAuditing(RetailscmUserContext userContext, String originalVoucherAuditingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherAuditingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherAuditing, tokens);
 	}
 	
 	

 	protected OriginalVoucherAuditing present(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucherAuditing,tokens);
		
		
		OriginalVoucherAuditing  originalVoucherAuditingToPresent = userContext.getDAOGroup().getOriginalVoucherAuditingDAO().present(originalVoucherAuditing, tokens);
		
		List<BaseEntity> entityListToNaming = originalVoucherAuditingToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getOriginalVoucherAuditingDAO().alias(entityListToNaming);
		
		return  originalVoucherAuditingToPresent;
		
		
	}
 
 	
 	
 	public OriginalVoucherAuditing loadOriginalVoucherAuditingDetail(RetailscmUserContext userContext, String originalVoucherAuditingId) throws Exception{	
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, allTokens());
 		return present(userContext,originalVoucherAuditing, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String originalVoucherAuditingId) throws Exception{	
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, viewTokens());
 		return present(userContext,originalVoucherAuditing, allTokens());
		
 	}
 	protected OriginalVoucherAuditing saveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getOriginalVoucherAuditingDAO().save(originalVoucherAuditing, tokens);
 	}
 	protected OriginalVoucherAuditing loadOriginalVoucherAuditing(RetailscmUserContext userContext, String originalVoucherAuditingId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		userContext.getChecker().throwExceptionIfHasErrors( OriginalVoucherAuditingManagerException.class);

 
 		return userContext.getDAOGroup().getOriginalVoucherAuditingDAO().load(originalVoucherAuditingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucherAuditing, tokens);
		
		addAction(userContext, originalVoucherAuditing, tokens,"@create","createOriginalVoucherAuditing","createOriginalVoucherAuditing/","main","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"@update","updateOriginalVoucherAuditing","updateOriginalVoucherAuditing/"+originalVoucherAuditing.getId()+"/","main","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"@copy","cloneOriginalVoucherAuditing","cloneOriginalVoucherAuditing/"+originalVoucherAuditing.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OriginalVoucherAuditing createOriginalVoucherAuditing(RetailscmUserContext userContext,String who, String comments, Date makeDate) throws Exception
	{
		
		

		

		userContext.getChecker().checkWhoOfOriginalVoucherAuditing(who);
		userContext.getChecker().checkCommentsOfOriginalVoucherAuditing(comments);
		userContext.getChecker().checkMakeDateOfOriginalVoucherAuditing(makeDate);
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);


		OriginalVoucherAuditing originalVoucherAuditing=createNewOriginalVoucherAuditing();	

		originalVoucherAuditing.setWho(who);
		originalVoucherAuditing.setComments(comments);
		originalVoucherAuditing.setMakeDate(makeDate);

		originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, emptyOptions());
		
		onNewInstanceCreated(userContext, originalVoucherAuditing);
		return originalVoucherAuditing;

		
	}
	protected OriginalVoucherAuditing createNewOriginalVoucherAuditing() 
	{
		
		return new OriginalVoucherAuditing();		
	}
	
	protected void checkParamsForUpdatingOriginalVoucherAuditing(RetailscmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		userContext.getChecker().checkVersionOfOriginalVoucherAuditing( originalVoucherAuditingVersion);
		

		if(OriginalVoucherAuditing.WHO_PROPERTY.equals(property)){
			userContext.getChecker().checkWhoOfOriginalVoucherAuditing(parseString(newValueExpr));
		}
		if(OriginalVoucherAuditing.COMMENTS_PROPERTY.equals(property)){
			userContext.getChecker().checkCommentsOfOriginalVoucherAuditing(parseString(newValueExpr));
		}
		if(OriginalVoucherAuditing.MAKE_DATE_PROPERTY.equals(property)){
			userContext.getChecker().checkMakeDateOfOriginalVoucherAuditing(parseDate(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);
	
		
	}
	
	
	
	public OriginalVoucherAuditing clone(RetailscmUserContext userContext, String fromOriginalVoucherAuditingId) throws Exception{
		
		return userContext.getDAOGroup().getOriginalVoucherAuditingDAO().clone(fromOriginalVoucherAuditingId, this.allTokens());
	}
	
	public OriginalVoucherAuditing internalSaveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing) throws Exception 
	{
		return internalSaveOriginalVoucherAuditing(userContext, originalVoucherAuditing, allTokens());

	}
	public OriginalVoucherAuditing internalSaveOriginalVoucherAuditing(RetailscmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingOriginalVoucherAuditing(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(originalVoucherAuditing){ 
			//will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherAuditing.
			
			
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, options);
			return originalVoucherAuditing;
			
		}

	}
	
	public OriginalVoucherAuditing updateOriginalVoucherAuditing(RetailscmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucherAuditing(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion, property, newValueExpr, tokensExpr);
		
		
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		if(originalVoucherAuditing.getVersion() != originalVoucherAuditingVersion){
			String message = "The target version("+originalVoucherAuditing.getVersion()+") is not equals to version("+originalVoucherAuditingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherAuditing){ 
			//will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherAuditing.
			
			originalVoucherAuditing.changeProperty(property, newValueExpr);
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
		}

	}
	
	public OriginalVoucherAuditing updateOriginalVoucherAuditingProperty(RetailscmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucherAuditing(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion, property, newValueExpr, tokensExpr);
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		if(originalVoucherAuditing.getVersion() != originalVoucherAuditingVersion){
			String message = "The target version("+originalVoucherAuditing.getVersion()+") is not equals to version("+originalVoucherAuditingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(originalVoucherAuditing){ 
			//will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherAuditing.
			
			originalVoucherAuditing.changeProperty(property, newValueExpr);
			
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OriginalVoucherAuditingTokens tokens(){
		return OriginalVoucherAuditingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherAuditingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortOriginalVoucherListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherAuditingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception {
		//deleteInternal(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception{
			
		userContext.getDAOGroup().getOriginalVoucherAuditingDAO().delete(originalVoucherAuditingId, originalVoucherAuditingVersion);
	}
	
	public OriginalVoucherAuditing forgetByAll(RetailscmUserContext userContext, String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception {
		return forgetByAllInternal(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion);		
	}
	protected OriginalVoucherAuditing forgetByAllInternal(RetailscmUserContext userContext,
			String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception{
			
		return userContext.getDAOGroup().getOriginalVoucherAuditingDAO().disconnectFromAll(originalVoucherAuditingId, originalVoucherAuditingVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherAuditingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getOriginalVoucherAuditingDAO().deleteAll();
	}


	//disconnect OriginalVoucherAuditing with belongs_to in OriginalVoucher
	protected OriginalVoucherAuditing breakWithOriginalVoucherByBelongsTo(RetailscmUserContext userContext, String originalVoucherAuditingId, String belongsToId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());

			synchronized(originalVoucherAuditing){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getOriginalVoucherAuditingDAO().planToRemoveOriginalVoucherListWithBelongsTo(originalVoucherAuditing, belongsToId, this.emptyOptions());

				originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
				return originalVoucherAuditing;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);

		
		userContext.getChecker().checkTitleOfOriginalVoucher(title);
		
		userContext.getChecker().checkMadeByOfOriginalVoucher(madeBy);
		
		userContext.getChecker().checkReceivedByOfOriginalVoucher(receivedBy);
		
		userContext.getChecker().checkVoucherTypeOfOriginalVoucher(voucherType);
		
		userContext.getChecker().checkVoucherImageOfOriginalVoucher(voucherImage);
		
		userContext.getChecker().checkBelongsToIdOfOriginalVoucher(belongsToId);
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);

	
	}
	public  OriginalVoucherAuditing addOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOriginalVoucher(userContext,originalVoucherAuditingId,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId,tokensExpr);
		
		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId);
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		synchronized(originalVoucherAuditing){ 
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherAuditing.addOriginalVoucher( originalVoucher );		
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, originalVoucher);
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOriginalVoucherProperties(RetailscmUserContext userContext, String originalVoucherAuditingId,String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		userContext.getChecker().checkIdOfOriginalVoucher(id);
		
		userContext.getChecker().checkTitleOfOriginalVoucher( title);
		userContext.getChecker().checkMadeByOfOriginalVoucher( madeBy);
		userContext.getChecker().checkReceivedByOfOriginalVoucher( receivedBy);
		userContext.getChecker().checkVoucherTypeOfOriginalVoucher( voucherType);
		userContext.getChecker().checkVoucherImageOfOriginalVoucher( voucherImage);

		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);
		
	}
	public  OriginalVoucherAuditing updateOriginalVoucherProperties(RetailscmUserContext userContext, String originalVoucherAuditingId, String id,String title,String madeBy,String receivedBy,String voucherType,String voucherImage, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingOriginalVoucherProperties(userContext,originalVoucherAuditingId,id,title,madeBy,receivedBy,voucherType,voucherImage,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOriginalVoucherListList()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "is", id).done();
		
		OriginalVoucherAuditing originalVoucherAuditingToUpdate = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, options);
		
		if(originalVoucherAuditingToUpdate.getOriginalVoucherList().isEmpty()){
			throw new OriginalVoucherAuditingManagerException("OriginalVoucher is NOT FOUND with id: '"+id+"'");
		}
		
		OriginalVoucher item = originalVoucherAuditingToUpdate.getOriginalVoucherList().first();
		
		item.updateTitle( title );
		item.updateMadeBy( madeBy );
		item.updateReceivedBy( receivedBy );
		item.updateVoucherType( voucherType );
		item.updateVoucherImage( voucherImage );

		
		//checkParamsForAddingOriginalVoucher(userContext,originalVoucherAuditingId,name, code, used,tokensExpr);
		OriginalVoucherAuditing originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditingToUpdate, tokens().withOriginalVoucherList().done());
		synchronized(originalVoucherAuditing){ 
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
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
	
	protected void checkParamsForRemovingOriginalVoucherList(RetailscmUserContext userContext, String originalVoucherAuditingId, 
			String originalVoucherIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
		for(String originalVoucherId: originalVoucherIds){
			userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);
		
	}
	public  OriginalVoucherAuditing removeOriginalVoucherList(RetailscmUserContext userContext, String originalVoucherAuditingId, 
			String originalVoucherIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingOriginalVoucherList(userContext, originalVoucherAuditingId,  originalVoucherIds, tokensExpr);
			
			
			OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
			synchronized(originalVoucherAuditing){ 
				//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getOriginalVoucherAuditingDAO().planToRemoveOriginalVoucherList(originalVoucherAuditing, originalVoucherIds, allTokens());
				originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
				deleteRelationListInGraph(userContext, originalVoucherAuditing.getOriginalVoucherList());
				return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOriginalVoucherAuditing( originalVoucherAuditingId);
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher(originalVoucherVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);
	
	}
	public  OriginalVoucherAuditing removeOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOriginalVoucher(userContext,originalVoucherAuditingId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		synchronized(originalVoucherAuditing){ 
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherAuditing.removeOriginalVoucher( originalVoucher );		
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			deleteRelationInGraph(userContext, originalVoucher);
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfOriginalVoucherAuditing( originalVoucherAuditingId);
		userContext.getChecker().checkIdOfOriginalVoucher(originalVoucherId);
		userContext.getChecker().checkVersionOfOriginalVoucher(originalVoucherVersion);
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);
	
	}
	public  OriginalVoucherAuditing copyOriginalVoucherFrom(RetailscmUserContext userContext, String originalVoucherAuditingId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOriginalVoucher(userContext,originalVoucherAuditingId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		synchronized(originalVoucherAuditing){ 
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			originalVoucherAuditing.copyOriginalVoucherFrom( originalVoucher );		
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			
			userContext.getManagerGroup().getOriginalVoucherManager().onNewInstanceCreated(userContext, (OriginalVoucher)originalVoucherAuditing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfOriginalVoucherAuditing(originalVoucherAuditingId);
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
		
	
		userContext.getChecker().throwExceptionIfHasErrors(OriginalVoucherAuditingManagerException.class);
	
	}
	
	public  OriginalVoucherAuditing updateOriginalVoucher(RetailscmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherAuditingId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withOriginalVoucherList().searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "eq", originalVoucherId).done();
		
		
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, loadTokens);
		
		synchronized(originalVoucherAuditing){ 
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//originalVoucherAuditing.removeOriginalVoucher( originalVoucher );	
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		
			OriginalVoucher originalVoucher = originalVoucherAuditing.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new OriginalVoucherAuditingManagerException(originalVoucher+" is NOT FOUND" );
			}
			
			originalVoucher.changeProperty(property, newValueExpr);
			
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  OriginalVoucherAuditing associateOriginalVoucherListToNewCreation(RetailscmUserContext userContext, String originalVoucherAuditingId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, options);
		
		OriginalVoucherCreation creation = userContext.getManagerGroup().getOriginalVoucherCreationManager().createOriginalVoucherCreation(userContext,  who,  comments,  makeDate);
		
		for(OriginalVoucher originalVoucher: originalVoucherAuditing.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateCreation(creation);
		}
		return this.internalSaveOriginalVoucherAuditing(userContext, originalVoucherAuditing);
	}	public  OriginalVoucherAuditing associateOriginalVoucherListToNewConfirmation(RetailscmUserContext userContext, String originalVoucherAuditingId, String  originalVoucherIds[], String who, String comments, Date makeDate, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, options);
		
		OriginalVoucherConfirmation confirmation = userContext.getManagerGroup().getOriginalVoucherConfirmationManager().createOriginalVoucherConfirmation(userContext,  who,  comments,  makeDate);
		
		for(OriginalVoucher originalVoucher: originalVoucherAuditing.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateConfirmation(confirmation);
		}
		return this.internalSaveOriginalVoucherAuditing(userContext, originalVoucherAuditing);
	}
	*/
	
	public  OriginalVoucherAuditing associateOriginalVoucherListToCreation(RetailscmUserContext userContext, String originalVoucherAuditingId, String  originalVoucherIds[], String creationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, options);
		
		OriginalVoucherCreation creation = userContext.getManagerGroup().getOriginalVoucherCreationManager().loadOriginalVoucherCreation(userContext,creationId,new String[]{"none"} );
		
		for(OriginalVoucher originalVoucher: originalVoucherAuditing.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateCreation(creation);
		}
		return this.internalSaveOriginalVoucherAuditing(userContext, originalVoucherAuditing);
	}	public  OriginalVoucherAuditing associateOriginalVoucherListToConfirmation(RetailscmUserContext userContext, String originalVoucherAuditingId, String  originalVoucherIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchOriginalVoucherListWith(OriginalVoucher.ID_PROPERTY, "oneof", this.joinArray("|", originalVoucherIds)).done();
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, options);
		
		OriginalVoucherConfirmation confirmation = userContext.getManagerGroup().getOriginalVoucherConfirmationManager().loadOriginalVoucherConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(OriginalVoucher originalVoucher: originalVoucherAuditing.getOriginalVoucherList()) {
			//TODO: need to check if already associated
			originalVoucher.updateConfirmation(confirmation);
		}
		return this.internalSaveOriginalVoucherAuditing(userContext, originalVoucherAuditing);
	}


	public void onNewInstanceCreated(RetailscmUserContext userContext, OriginalVoucherAuditing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


