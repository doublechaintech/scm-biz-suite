
package com.doublechaintech.retailscm.memberwishlistproduct;

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

import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;

import com.doublechaintech.retailscm.memberwishlist.CandidateMemberWishlist;







public class MemberWishlistProductManagerImpl extends CustomRetailscmCheckerManager implements MemberWishlistProductManager {
	
	private static final String SERVICE_TYPE = "MemberWishlistProduct";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws MemberWishlistProductManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new MemberWishlistProductManagerException(message);

	}
	
	

 	protected MemberWishlistProduct saveMemberWishlistProduct(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct, String [] tokensExpr) throws Exception{	
 		//return getMemberWishlistProductDAO().save(memberWishlistProduct, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMemberWishlistProduct(userContext, memberWishlistProduct, tokens);
 	}
 	
 	protected MemberWishlistProduct saveMemberWishlistProductDetail(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct) throws Exception{	

 		
 		return saveMemberWishlistProduct(userContext, memberWishlistProduct, allTokens());
 	}
 	
 	public MemberWishlistProduct loadMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistProductId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberWishlistProductManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct( userContext, memberWishlistProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberWishlistProduct, tokens);
 	}
 	
 	
 	 public MemberWishlistProduct searchMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistProductId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberWishlistProductManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct( userContext, memberWishlistProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberWishlistProduct, tokens);
 	}
 	
 	

 	protected MemberWishlistProduct present(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,memberWishlistProduct,tokens);
		
		
		MemberWishlistProduct  memberWishlistProductToPresent = userContext.getDAOGroup().getMemberWishlistProductDAO().present(memberWishlistProduct, tokens);
		
		List<BaseEntity> entityListToNaming = memberWishlistProductToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getMemberWishlistProductDAO().alias(entityListToNaming);
		
		return  memberWishlistProductToPresent;
		
		
	}
 
 	
 	
 	public MemberWishlistProduct loadMemberWishlistProductDetail(RetailscmUserContext userContext, String memberWishlistProductId) throws Exception{	
 		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct( userContext, memberWishlistProductId, allTokens());
 		return present(userContext,memberWishlistProduct, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String memberWishlistProductId) throws Exception{	
 		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct( userContext, memberWishlistProductId, viewTokens());
 		return present(userContext,memberWishlistProduct, allTokens());
		
 	}
 	protected MemberWishlistProduct saveMemberWishlistProduct(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getMemberWishlistProductDAO().save(memberWishlistProduct, tokens);
 	}
 	protected MemberWishlistProduct loadMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistProductId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberWishlistProductManagerException.class);

 
 		return userContext.getDAOGroup().getMemberWishlistProductDAO().load(memberWishlistProductId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String, Object> tokens){
		super.addActions(userContext, memberWishlistProduct, tokens);
		
		addAction(userContext, memberWishlistProduct, tokens,"@create","createMemberWishlistProduct","createMemberWishlistProduct/","main","primary");
		addAction(userContext, memberWishlistProduct, tokens,"@update","updateMemberWishlistProduct","updateMemberWishlistProduct/"+memberWishlistProduct.getId()+"/","main","primary");
		addAction(userContext, memberWishlistProduct, tokens,"@copy","cloneMemberWishlistProduct","cloneMemberWishlistProduct/"+memberWishlistProduct.getId()+"/","main","primary");
		
		addAction(userContext, memberWishlistProduct, tokens,"member_wishlist_product.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+memberWishlistProduct.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MemberWishlistProduct createMemberWishlistProduct(RetailscmUserContext userContext,String name, String ownerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfMemberWishlistProduct(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistProductManagerException.class);


		MemberWishlistProduct memberWishlistProduct=createNewMemberWishlistProduct();	

		memberWishlistProduct.setName(name);
			
		MemberWishlist owner = loadMemberWishlist(userContext, ownerId,emptyOptions());
		memberWishlistProduct.setOwner(owner);
		
		

		memberWishlistProduct = saveMemberWishlistProduct(userContext, memberWishlistProduct, emptyOptions());
		
		onNewInstanceCreated(userContext, memberWishlistProduct);
		return memberWishlistProduct;

		
	}
	protected MemberWishlistProduct createNewMemberWishlistProduct() 
	{
		
		return new MemberWishlistProduct();		
	}
	
	protected void checkParamsForUpdatingMemberWishlistProduct(RetailscmUserContext userContext,String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
		userContext.getChecker().checkVersionOfMemberWishlistProduct( memberWishlistProductVersion);
		

		if(MemberWishlistProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMemberWishlistProduct(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistProductManagerException.class);
	
		
	}
	
	
	
	public MemberWishlistProduct clone(RetailscmUserContext userContext, String fromMemberWishlistProductId) throws Exception{
		
		return userContext.getDAOGroup().getMemberWishlistProductDAO().clone(fromMemberWishlistProductId, this.allTokens());
	}
	
	public MemberWishlistProduct internalSaveMemberWishlistProduct(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct) throws Exception 
	{
		return internalSaveMemberWishlistProduct(userContext, memberWishlistProduct, allTokens());

	}
	public MemberWishlistProduct internalSaveMemberWishlistProduct(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingMemberWishlistProduct(userContext, memberWishlistProductId, memberWishlistProductVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(memberWishlistProduct){ 
			//will be good when the memberWishlistProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberWishlistProduct.
			
			
			memberWishlistProduct = saveMemberWishlistProduct(userContext, memberWishlistProduct, options);
			return memberWishlistProduct;
			
		}

	}
	
	public MemberWishlistProduct updateMemberWishlistProduct(RetailscmUserContext userContext,String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberWishlistProduct(userContext, memberWishlistProductId, memberWishlistProductVersion, property, newValueExpr, tokensExpr);
		
		
		
		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct(userContext, memberWishlistProductId, allTokens());
		if(memberWishlistProduct.getVersion() != memberWishlistProductVersion){
			String message = "The target version("+memberWishlistProduct.getVersion()+") is not equals to version("+memberWishlistProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(memberWishlistProduct){ 
			//will be good when the memberWishlistProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberWishlistProduct.
			
			memberWishlistProduct.changeProperty(property, newValueExpr);
			memberWishlistProduct = saveMemberWishlistProduct(userContext, memberWishlistProduct, tokens().done());
			return present(userContext,memberWishlistProduct, mergedAllTokens(tokensExpr));
			//return saveMemberWishlistProduct(userContext, memberWishlistProduct, tokens().done());
		}

	}
	
	public MemberWishlistProduct updateMemberWishlistProductProperty(RetailscmUserContext userContext,String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberWishlistProduct(userContext, memberWishlistProductId, memberWishlistProductVersion, property, newValueExpr, tokensExpr);
		
		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct(userContext, memberWishlistProductId, allTokens());
		if(memberWishlistProduct.getVersion() != memberWishlistProductVersion){
			String message = "The target version("+memberWishlistProduct.getVersion()+") is not equals to version("+memberWishlistProductVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(memberWishlistProduct){ 
			//will be good when the memberWishlistProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberWishlistProduct.
			
			memberWishlistProduct.changeProperty(property, newValueExpr);
			
			memberWishlistProduct = saveMemberWishlistProduct(userContext, memberWishlistProduct, tokens().done());
			return present(userContext,memberWishlistProduct, mergedAllTokens(tokensExpr));
			//return saveMemberWishlistProduct(userContext, memberWishlistProduct, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MemberWishlistProductTokens tokens(){
		return MemberWishlistProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MemberWishlistProductTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MemberWishlistProductTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String memberWishlistProductId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
 		userContext.getChecker().checkIdOfMemberWishlist(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistProductManagerException.class);
 		
 	}
 	public MemberWishlistProduct transferToAnotherOwner(RetailscmUserContext userContext, String memberWishlistProductId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, memberWishlistProductId,anotherOwnerId);
 
		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct(userContext, memberWishlistProductId, allTokens());	
		synchronized(memberWishlistProduct){
			//will be good when the memberWishlistProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			MemberWishlist owner = loadMemberWishlist(userContext, anotherOwnerId, emptyOptions());		
			memberWishlistProduct.updateOwner(owner);		
			memberWishlistProduct = saveMemberWishlistProduct(userContext, memberWishlistProduct, emptyOptions());
			
			return present(userContext,memberWishlistProduct, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateMemberWishlist requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateMemberWishlist result = new CandidateMemberWishlist();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<MemberWishlist> candidateList = userContext.getDAOGroup().getMemberWishlistDAO().requestCandidateMemberWishlistForMemberWishlistProduct(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected MemberWishlist loadMemberWishlist(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getMemberWishlistDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String memberWishlistProductId, int memberWishlistProductVersion) throws Exception {
		//deleteInternal(userContext, memberWishlistProductId, memberWishlistProductVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String memberWishlistProductId, int memberWishlistProductVersion) throws Exception{
			
		userContext.getDAOGroup().getMemberWishlistProductDAO().delete(memberWishlistProductId, memberWishlistProductVersion);
	}
	
	public MemberWishlistProduct forgetByAll(RetailscmUserContext userContext, String memberWishlistProductId, int memberWishlistProductVersion) throws Exception {
		return forgetByAllInternal(userContext, memberWishlistProductId, memberWishlistProductVersion);		
	}
	protected MemberWishlistProduct forgetByAllInternal(RetailscmUserContext userContext,
			String memberWishlistProductId, int memberWishlistProductVersion) throws Exception{
			
		return userContext.getDAOGroup().getMemberWishlistProductDAO().disconnectFromAll(memberWishlistProductId, memberWishlistProductVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MemberWishlistProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getMemberWishlistProductDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, MemberWishlistProduct newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


