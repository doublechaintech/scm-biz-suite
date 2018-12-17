
package com.doublechaintech.retailscm.memberwishlist;

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

import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;

import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;






public class MemberWishlistManagerImpl extends CustomRetailscmCheckerManager implements MemberWishlistManager {
	
	private static final String SERVICE_TYPE = "MemberWishlist";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws MemberWishlistManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new MemberWishlistManagerException(message);

	}
	
	

 	protected MemberWishlist saveMemberWishlist(RetailscmUserContext userContext, MemberWishlist memberWishlist, String [] tokensExpr) throws Exception{	
 		//return getMemberWishlistDAO().save(memberWishlist, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMemberWishlist(userContext, memberWishlist, tokens);
 	}
 	
 	protected MemberWishlist saveMemberWishlistDetail(RetailscmUserContext userContext, MemberWishlist memberWishlist) throws Exception{	

 		
 		return saveMemberWishlist(userContext, memberWishlist, allTokens());
 	}
 	
 	public MemberWishlist loadMemberWishlist(RetailscmUserContext userContext, String memberWishlistId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberWishlistManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MemberWishlist memberWishlist = loadMemberWishlist( userContext, memberWishlistId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberWishlist, tokens);
 	}
 	
 	
 	 public MemberWishlist searchMemberWishlist(RetailscmUserContext userContext, String memberWishlistId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberWishlistManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		MemberWishlist memberWishlist = loadMemberWishlist( userContext, memberWishlistId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberWishlist, tokens);
 	}
 	
 	

 	protected MemberWishlist present(RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,memberWishlist,tokens);
		
		
		MemberWishlist  memberWishlistToPresent = userContext.getDAOGroup().getMemberWishlistDAO().present(memberWishlist, tokens);
		
		List<BaseEntity> entityListToNaming = memberWishlistToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getMemberWishlistDAO().alias(entityListToNaming);
		
		return  memberWishlistToPresent;
		
		
	}
 
 	
 	
 	public MemberWishlist loadMemberWishlistDetail(RetailscmUserContext userContext, String memberWishlistId) throws Exception{	
 		MemberWishlist memberWishlist = loadMemberWishlist( userContext, memberWishlistId, allTokens());
 		return present(userContext,memberWishlist, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String memberWishlistId) throws Exception{	
 		MemberWishlist memberWishlist = loadMemberWishlist( userContext, memberWishlistId, viewTokens());
 		return present(userContext,memberWishlist, allTokens());
		
 	}
 	protected MemberWishlist saveMemberWishlist(RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getMemberWishlistDAO().save(memberWishlist, tokens);
 	}
 	protected MemberWishlist loadMemberWishlist(RetailscmUserContext userContext, String memberWishlistId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberWishlistManagerException.class);

 
 		return userContext.getDAOGroup().getMemberWishlistDAO().load(memberWishlistId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens){
		super.addActions(userContext, memberWishlist, tokens);
		
		addAction(userContext, memberWishlist, tokens,"@create","createMemberWishlist","createMemberWishlist/","main","primary");
		addAction(userContext, memberWishlist, tokens,"@update","updateMemberWishlist","updateMemberWishlist/"+memberWishlist.getId()+"/","main","primary");
		addAction(userContext, memberWishlist, tokens,"@copy","cloneMemberWishlist","cloneMemberWishlist/"+memberWishlist.getId()+"/","main","primary");
		
		addAction(userContext, memberWishlist, tokens,"member_wishlist.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+memberWishlist.getId()+"/","main","primary");
		addAction(userContext, memberWishlist, tokens,"member_wishlist.addMemberWishlistProduct","addMemberWishlistProduct","addMemberWishlistProduct/"+memberWishlist.getId()+"/","memberWishlistProductList","primary");
		addAction(userContext, memberWishlist, tokens,"member_wishlist.removeMemberWishlistProduct","removeMemberWishlistProduct","removeMemberWishlistProduct/"+memberWishlist.getId()+"/","memberWishlistProductList","primary");
		addAction(userContext, memberWishlist, tokens,"member_wishlist.updateMemberWishlistProduct","updateMemberWishlistProduct","updateMemberWishlistProduct/"+memberWishlist.getId()+"/","memberWishlistProductList","primary");
		addAction(userContext, memberWishlist, tokens,"member_wishlist.copyMemberWishlistProductFrom","copyMemberWishlistProductFrom","copyMemberWishlistProductFrom/"+memberWishlist.getId()+"/","memberWishlistProductList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MemberWishlist createMemberWishlist(RetailscmUserContext userContext,String name, String ownerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfMemberWishlist(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);


		MemberWishlist memberWishlist=createNewMemberWishlist();	

		memberWishlist.setName(name);
			
		RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId,emptyOptions());
		memberWishlist.setOwner(owner);
		
		

		memberWishlist = saveMemberWishlist(userContext, memberWishlist, emptyOptions());
		
		onNewInstanceCreated(userContext, memberWishlist);
		return memberWishlist;

		
	}
	protected MemberWishlist createNewMemberWishlist() 
	{
		
		return new MemberWishlist();		
	}
	
	protected void checkParamsForUpdatingMemberWishlist(RetailscmUserContext userContext,String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().checkVersionOfMemberWishlist( memberWishlistVersion);
		

		if(MemberWishlist.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMemberWishlist(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);
	
		
	}
	
	
	
	public MemberWishlist clone(RetailscmUserContext userContext, String fromMemberWishlistId) throws Exception{
		
		return userContext.getDAOGroup().getMemberWishlistDAO().clone(fromMemberWishlistId, this.allTokens());
	}
	
	public MemberWishlist internalSaveMemberWishlist(RetailscmUserContext userContext, MemberWishlist memberWishlist) throws Exception 
	{
		return internalSaveMemberWishlist(userContext, memberWishlist, allTokens());

	}
	public MemberWishlist internalSaveMemberWishlist(RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingMemberWishlist(userContext, memberWishlistId, memberWishlistVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(memberWishlist){ 
			//will be good when the memberWishlist loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberWishlist.
			
			
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, options);
			return memberWishlist;
			
		}

	}
	
	public MemberWishlist updateMemberWishlist(RetailscmUserContext userContext,String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberWishlist(userContext, memberWishlistId, memberWishlistVersion, property, newValueExpr, tokensExpr);
		
		
		
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		if(memberWishlist.getVersion() != memberWishlistVersion){
			String message = "The target version("+memberWishlist.getVersion()+") is not equals to version("+memberWishlistVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(memberWishlist){ 
			//will be good when the memberWishlist loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberWishlist.
			
			memberWishlist.changeProperty(property, newValueExpr);
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().done());
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
			//return saveMemberWishlist(userContext, memberWishlist, tokens().done());
		}

	}
	
	public MemberWishlist updateMemberWishlistProperty(RetailscmUserContext userContext,String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberWishlist(userContext, memberWishlistId, memberWishlistVersion, property, newValueExpr, tokensExpr);
		
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		if(memberWishlist.getVersion() != memberWishlistVersion){
			String message = "The target version("+memberWishlist.getVersion()+") is not equals to version("+memberWishlistVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(memberWishlist){ 
			//will be good when the memberWishlist loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberWishlist.
			
			memberWishlist.changeProperty(property, newValueExpr);
			
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().done());
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
			//return saveMemberWishlist(userContext, memberWishlist, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MemberWishlistTokens tokens(){
		return MemberWishlistTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MemberWishlistTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortMemberWishlistProductListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MemberWishlistTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String memberWishlistId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
 		userContext.getChecker().checkIdOfRetailStoreMember(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);
 		
 	}
 	public MemberWishlist transferToAnotherOwner(RetailscmUserContext userContext, String memberWishlistId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, memberWishlistId,anotherOwnerId);
 
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());	
		synchronized(memberWishlist){
			//will be good when the memberWishlist loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());		
			memberWishlist.updateOwner(owner);		
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, emptyOptions());
			
			return present(userContext,memberWishlist, allTokens());
			
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
		SmartList<RetailStoreMember> candidateList = userContext.getDAOGroup().getRetailStoreMemberDAO().requestCandidateRetailStoreMemberForMemberWishlist(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String memberWishlistId, int memberWishlistVersion) throws Exception {
		//deleteInternal(userContext, memberWishlistId, memberWishlistVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String memberWishlistId, int memberWishlistVersion) throws Exception{
			
		userContext.getDAOGroup().getMemberWishlistDAO().delete(memberWishlistId, memberWishlistVersion);
	}
	
	public MemberWishlist forgetByAll(RetailscmUserContext userContext, String memberWishlistId, int memberWishlistVersion) throws Exception {
		return forgetByAllInternal(userContext, memberWishlistId, memberWishlistVersion);		
	}
	protected MemberWishlist forgetByAllInternal(RetailscmUserContext userContext,
			String memberWishlistId, int memberWishlistVersion) throws Exception{
			
		return userContext.getDAOGroup().getMemberWishlistDAO().disconnectFromAll(memberWishlistId, memberWishlistVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MemberWishlistManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getMemberWishlistDAO().deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);

		
		userContext.getChecker().checkNameOfMemberWishlistProduct(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);

	
	}
	public  MemberWishlist addMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMemberWishlistProduct(userContext,memberWishlistId,name,tokensExpr);
		
		MemberWishlistProduct memberWishlistProduct = createMemberWishlistProduct(userContext,name);
		
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		synchronized(memberWishlist){ 
			//Will be good when the memberWishlist loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			memberWishlist.addMemberWishlistProduct( memberWishlistProduct );		
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
			
			userContext.getManagerGroup().getMemberWishlistProductManager().onNewInstanceCreated(userContext, memberWishlistProduct);
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberWishlistProductProperties(RetailscmUserContext userContext, String memberWishlistId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().checkIdOfMemberWishlistProduct(id);
		
		userContext.getChecker().checkNameOfMemberWishlistProduct( name);

		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);
		
	}
	public  MemberWishlist updateMemberWishlistProductProperties(RetailscmUserContext userContext, String memberWishlistId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingMemberWishlistProductProperties(userContext,memberWishlistId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberWishlistProductListList()
				.searchMemberWishlistProductListWith(MemberWishlistProduct.ID_PROPERTY, "is", id).done();
		
		MemberWishlist memberWishlistToUpdate = loadMemberWishlist(userContext, memberWishlistId, options);
		
		if(memberWishlistToUpdate.getMemberWishlistProductList().isEmpty()){
			throw new MemberWishlistManagerException("MemberWishlistProduct is NOT FOUND with id: '"+id+"'");
		}
		
		MemberWishlistProduct item = memberWishlistToUpdate.getMemberWishlistProductList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingMemberWishlistProduct(userContext,memberWishlistId,name, code, used,tokensExpr);
		MemberWishlist memberWishlist = saveMemberWishlist(userContext, memberWishlistToUpdate, tokens().withMemberWishlistProductList().done());
		synchronized(memberWishlist){ 
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected MemberWishlistProduct createMemberWishlistProduct(RetailscmUserContext userContext, String name) throws Exception{

		MemberWishlistProduct memberWishlistProduct = new MemberWishlistProduct();
		
		
		memberWishlistProduct.setName(name);
	
		
		return memberWishlistProduct;
	
		
	}
	
	protected MemberWishlistProduct createIndexedMemberWishlistProduct(String id, int version){

		MemberWishlistProduct memberWishlistProduct = new MemberWishlistProduct();
		memberWishlistProduct.setId(id);
		memberWishlistProduct.setVersion(version);
		return memberWishlistProduct;			
		
	}
	
	protected void checkParamsForRemovingMemberWishlistProductList(RetailscmUserContext userContext, String memberWishlistId, 
			String memberWishlistProductIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		for(String memberWishlistProductId: memberWishlistProductIds){
			userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);
		
	}
	public  MemberWishlist removeMemberWishlistProductList(RetailscmUserContext userContext, String memberWishlistId, 
			String memberWishlistProductIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingMemberWishlistProductList(userContext, memberWishlistId,  memberWishlistProductIds, tokensExpr);
			
			
			MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
			synchronized(memberWishlist){ 
				//Will be good when the memberWishlist loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getMemberWishlistDAO().planToRemoveMemberWishlistProductList(memberWishlist, memberWishlistProductIds, allTokens());
				memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
				deleteRelationListInGraph(userContext, memberWishlist.getMemberWishlistProductList());
				return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, 
		String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMemberWishlist( memberWishlistId);
		userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
		userContext.getChecker().checkVersionOfMemberWishlistProduct(memberWishlistProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);
	
	}
	public  MemberWishlist removeMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, 
		String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMemberWishlistProduct(userContext,memberWishlistId, memberWishlistProductId, memberWishlistProductVersion,tokensExpr);
		
		MemberWishlistProduct memberWishlistProduct = createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		synchronized(memberWishlist){ 
			//Will be good when the memberWishlist loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			memberWishlist.removeMemberWishlistProduct( memberWishlistProduct );		
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
			deleteRelationInGraph(userContext, memberWishlistProduct);
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, 
		String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfMemberWishlist( memberWishlistId);
		userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
		userContext.getChecker().checkVersionOfMemberWishlistProduct(memberWishlistProductVersion);
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);
	
	}
	public  MemberWishlist copyMemberWishlistProductFrom(RetailscmUserContext userContext, String memberWishlistId, 
		String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMemberWishlistProduct(userContext,memberWishlistId, memberWishlistProductId, memberWishlistProductVersion,tokensExpr);
		
		MemberWishlistProduct memberWishlistProduct = createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		synchronized(memberWishlist){ 
			//Will be good when the memberWishlist loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			memberWishlist.copyMemberWishlistProductFrom( memberWishlistProduct );		
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
			
			userContext.getManagerGroup().getMemberWishlistProductManager().onNewInstanceCreated(userContext, (MemberWishlistProduct)memberWishlist.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().checkIdOfMemberWishlistProduct(memberWishlistProductId);
		userContext.getChecker().checkVersionOfMemberWishlistProduct(memberWishlistProductVersion);
		

		if(MemberWishlistProduct.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMemberWishlistProduct(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(MemberWishlistManagerException.class);
	
	}
	
	public  MemberWishlist updateMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMemberWishlistProduct(userContext, memberWishlistId, memberWishlistProductId, memberWishlistProductVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withMemberWishlistProductList().searchMemberWishlistProductListWith(MemberWishlistProduct.ID_PROPERTY, "eq", memberWishlistProductId).done();
		
		
		
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, loadTokens);
		
		synchronized(memberWishlist){ 
			//Will be good when the memberWishlist loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//memberWishlist.removeMemberWishlistProduct( memberWishlistProduct );	
			//make changes to AcceleraterAccount.
			MemberWishlistProduct memberWishlistProductIndex = createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);
		
			MemberWishlistProduct memberWishlistProduct = memberWishlist.findTheMemberWishlistProduct(memberWishlistProductIndex);
			if(memberWishlistProduct == null){
				throw new MemberWishlistManagerException(memberWishlistProduct+" is NOT FOUND" );
			}
			
			memberWishlistProduct.changeProperty(property, newValueExpr);
			
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, MemberWishlist newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


