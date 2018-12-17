
package com.doublechaintech.retailscm.retailstoremembercoupon;

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

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;







public class RetailStoreMemberCouponManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreMemberCouponManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMemberCoupon";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreMemberCouponManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreMemberCouponManagerException(message);

	}
	
	

 	protected RetailStoreMemberCoupon saveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberCouponDAO().save(retailStoreMemberCoupon, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens);
 	}
 	
 	protected RetailStoreMemberCoupon saveRetailStoreMemberCouponDetail(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon) throws Exception{	

 		
 		return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, allTokens());
 	}
 	
 	public RetailStoreMemberCoupon loadRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberCouponId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberCouponManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberCoupon, tokens);
 	}
 	
 	
 	 public RetailStoreMemberCoupon searchRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberCouponId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberCouponManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberCoupon, tokens);
 	}
 	
 	

 	protected RetailStoreMemberCoupon present(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberCoupon,tokens);
		
		
		RetailStoreMemberCoupon  retailStoreMemberCouponToPresent = userContext.getDAOGroup().getRetailStoreMemberCouponDAO().present(retailStoreMemberCoupon, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreMemberCouponToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreMemberCouponDAO().alias(entityListToNaming);
		
		return  retailStoreMemberCouponToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreMemberCoupon loadRetailStoreMemberCouponDetail(RetailscmUserContext userContext, String retailStoreMemberCouponId) throws Exception{	
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, allTokens());
 		return present(userContext,retailStoreMemberCoupon, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreMemberCouponId) throws Exception{	
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, viewTokens());
 		return present(userContext,retailStoreMemberCoupon, allTokens());
		
 	}
 	protected RetailStoreMemberCoupon saveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreMemberCouponDAO().save(retailStoreMemberCoupon, tokens);
 	}
 	protected RetailStoreMemberCoupon loadRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberCouponId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberCouponManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreMemberCouponDAO().load(retailStoreMemberCouponId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberCoupon, tokens);
		
		addAction(userContext, retailStoreMemberCoupon, tokens,"@create","createRetailStoreMemberCoupon","createRetailStoreMemberCoupon/","main","primary");
		addAction(userContext, retailStoreMemberCoupon, tokens,"@update","updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon/"+retailStoreMemberCoupon.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberCoupon, tokens,"@copy","cloneRetailStoreMemberCoupon","cloneRetailStoreMemberCoupon/"+retailStoreMemberCoupon.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMemberCoupon, tokens,"retail_store_member_coupon.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberCoupon.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailscmUserContext userContext,String name, String ownerId, String number) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfRetailStoreMemberCoupon(name);
		userContext.getChecker().checkNumberOfRetailStoreMemberCoupon(number);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberCouponManagerException.class);


		RetailStoreMemberCoupon retailStoreMemberCoupon=createNewRetailStoreMemberCoupon();	

		retailStoreMemberCoupon.setName(name);
			
		RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId,emptyOptions());
		retailStoreMemberCoupon.setOwner(owner);
		
		
		retailStoreMemberCoupon.setNumber(number);

		retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreMemberCoupon);
		return retailStoreMemberCoupon;

		
	}
	protected RetailStoreMemberCoupon createNewRetailStoreMemberCoupon() 
	{
		
		return new RetailStoreMemberCoupon();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberCoupon(RetailscmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		userContext.getChecker().checkVersionOfRetailStoreMemberCoupon( retailStoreMemberCouponVersion);
		

		if(RetailStoreMemberCoupon.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreMemberCoupon(parseString(newValueExpr));
		}		

		
		if(RetailStoreMemberCoupon.NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkNumberOfRetailStoreMemberCoupon(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberCouponManagerException.class);
	
		
	}
	
	
	
	public RetailStoreMemberCoupon clone(RetailscmUserContext userContext, String fromRetailStoreMemberCouponId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreMemberCouponDAO().clone(fromRetailStoreMemberCouponId, this.allTokens());
	}
	
	public RetailStoreMemberCoupon internalSaveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon) throws Exception 
	{
		return internalSaveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, allTokens());

	}
	public RetailStoreMemberCoupon internalSaveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreMemberCoupon){ 
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberCoupon.
			
			
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, options);
			return retailStoreMemberCoupon;
			
		}

	}
	
	public RetailStoreMemberCoupon updateRetailStoreMemberCoupon(RetailscmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, allTokens());
		if(retailStoreMemberCoupon.getVersion() != retailStoreMemberCouponVersion){
			String message = "The target version("+retailStoreMemberCoupon.getVersion()+") is not equals to version("+retailStoreMemberCouponVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberCoupon){ 
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberCoupon.
			
			retailStoreMemberCoupon.changeProperty(property, newValueExpr);
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
			return present(userContext,retailStoreMemberCoupon, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
		}

	}
	
	public RetailStoreMemberCoupon updateRetailStoreMemberCouponProperty(RetailscmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, allTokens());
		if(retailStoreMemberCoupon.getVersion() != retailStoreMemberCouponVersion){
			String message = "The target version("+retailStoreMemberCoupon.getVersion()+") is not equals to version("+retailStoreMemberCouponVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberCoupon){ 
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberCoupon.
			
			retailStoreMemberCoupon.changeProperty(property, newValueExpr);
			
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
			return present(userContext,retailStoreMemberCoupon, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberCouponTokens tokens(){
		return RetailStoreMemberCouponTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberCouponTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberCouponTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
 		userContext.getChecker().checkIdOfRetailStoreMember(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberCouponManagerException.class);
 		
 	}
 	public RetailStoreMemberCoupon transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberCouponId,anotherOwnerId);
 
		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, allTokens());	
		synchronized(retailStoreMemberCoupon){
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());		
			retailStoreMemberCoupon.updateOwner(owner);		
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, emptyOptions());
			
			return present(userContext,retailStoreMemberCoupon, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreMember requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreMember result = new CandidateRetailStoreMember();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreMember> candidateList = userContext.getDAOGroup().getRetailStoreMemberDAO().requestCandidateRetailStoreMemberForRetailStoreMemberCoupon(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreMemberCouponDAO().delete(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
	}
	
	public RetailStoreMemberCoupon forgetByAll(RetailscmUserContext userContext, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion);		
	}
	protected RetailStoreMemberCoupon forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreMemberCouponDAO().disconnectFromAll(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberCouponManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreMemberCouponDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMemberCoupon newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


