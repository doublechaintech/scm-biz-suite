
package com.doublechaintech.retailscm.retailstoremember;

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

import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;






public class RetailStoreMemberManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreMemberManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMember";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RetailStoreMemberManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreMemberManagerException(message);

	}
	
	

 	protected RetailStoreMember saveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberDAO().save(retailStoreMember, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMember(userContext, retailStoreMember, tokens);
 	}
 	
 	protected RetailStoreMember saveRetailStoreMemberDetail(RetailscmUserContext userContext, RetailStoreMember retailStoreMember) throws Exception{	

 		
 		return saveRetailStoreMember(userContext, retailStoreMember, allTokens());
 	}
 	
 	public RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String retailStoreMemberId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMember, tokens);
 	}
 	
 	
 	 public RetailStoreMember searchRetailStoreMember(RetailscmUserContext userContext, String retailStoreMemberId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMember, tokens);
 	}
 	
 	

 	protected RetailStoreMember present(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMember,tokens);
		
		
		RetailStoreMember  retailStoreMemberToPresent = userContext.getDAOGroup().getRetailStoreMemberDAO().present(retailStoreMember, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreMemberToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getRetailStoreMemberDAO().alias(entityListToNaming);
		
		return  retailStoreMemberToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreMember loadRetailStoreMemberDetail(RetailscmUserContext userContext, String retailStoreMemberId) throws Exception{	
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, allTokens());
 		return present(userContext,retailStoreMember, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreMemberId) throws Exception{	
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, viewTokens());
 		return present(userContext,retailStoreMember, allTokens());
		
 	}
 	protected RetailStoreMember saveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getRetailStoreMemberDAO().save(retailStoreMember, tokens);
 	}
 	protected RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String retailStoreMemberId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);

 
 		return userContext.getDAOGroup().getRetailStoreMemberDAO().load(retailStoreMemberId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMember, tokens);
		
		addAction(userContext, retailStoreMember, tokens,"@create","createRetailStoreMember","createRetailStoreMember/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"@update","updateRetailStoreMember","updateRetailStoreMember/"+retailStoreMember.getId()+"/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"@copy","cloneRetailStoreMember","cloneRetailStoreMember/"+retailStoreMember.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMember.getId()+"/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberCoupon","addRetailStoreMemberCoupon","addRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberCoupon","removeRetailStoreMemberCoupon","removeRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberCouponFrom","copyRetailStoreMemberCouponFrom","copyRetailStoreMemberCouponFrom/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberWishlist","addMemberWishlist","addMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberWishlist","removeMemberWishlist","removeMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberWishlist","updateMemberWishlist","updateMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberWishlistFrom","copyMemberWishlistFrom","copyMemberWishlistFrom/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberRewardPoint","addMemberRewardPoint","addMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberRewardPoint","removeMemberRewardPoint","removeMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberRewardPoint","updateMemberRewardPoint","updateMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberRewardPointFrom","copyMemberRewardPointFrom","copyMemberRewardPointFrom/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberRewardPointRedemption","addMemberRewardPointRedemption","addMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberRewardPointRedemption","removeMemberRewardPointRedemption","removeMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberRewardPointRedemption","updateMemberRewardPointRedemption","updateMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberRewardPointRedemptionFrom","copyMemberRewardPointRedemptionFrom","copyMemberRewardPointRedemptionFrom/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberAddress","addRetailStoreMemberAddress","addRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberAddress","removeRetailStoreMemberAddress","removeRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberAddress","updateRetailStoreMemberAddress","updateRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberAddressFrom","copyRetailStoreMemberAddressFrom","copyRetailStoreMemberAddressFrom/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberGiftCard","addRetailStoreMemberGiftCard","addRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberGiftCard","removeRetailStoreMemberGiftCard","removeRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberGiftCardFrom","copyRetailStoreMemberGiftCardFrom","copyRetailStoreMemberGiftCardFrom/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMember createRetailStoreMember(RetailscmUserContext userContext,String name, String mobilePhone, String ownerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfRetailStoreMember(name);
		userContext.getChecker().checkMobilePhoneOfRetailStoreMember(mobilePhone);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


		RetailStoreMember retailStoreMember=createNewRetailStoreMember();	

		retailStoreMember.setName(name);
		retailStoreMember.setMobilePhone(mobilePhone);
			
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, ownerId,emptyOptions());
		retailStoreMember.setOwner(owner);
		
		

		retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreMember);
		return retailStoreMember;

		
	}
	protected RetailStoreMember createNewRetailStoreMember() 
	{
		
		return new RetailStoreMember();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMember(RetailscmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkVersionOfRetailStoreMember( retailStoreMemberVersion);
		

		if(RetailStoreMember.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreMember(parseString(newValueExpr));
		}
		if(RetailStoreMember.MOBILE_PHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkMobilePhoneOfRetailStoreMember(parseString(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
		
	}
	
	
	
	public RetailStoreMember clone(RetailscmUserContext userContext, String fromRetailStoreMemberId) throws Exception{
		
		return userContext.getDAOGroup().getRetailStoreMemberDAO().clone(fromRetailStoreMemberId, this.allTokens());
	}
	
	public RetailStoreMember internalSaveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember) throws Exception 
	{
		return internalSaveRetailStoreMember(userContext, retailStoreMember, allTokens());

	}
	public RetailStoreMember internalSaveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(retailStoreMember){ 
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.
			
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, options);
			return retailStoreMember;
			
		}

	}
	
	public RetailStoreMember updateRetailStoreMember(RetailscmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);
		
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		if(retailStoreMember.getVersion() != retailStoreMemberVersion){
			String message = "The target version("+retailStoreMember.getVersion()+") is not equals to version("+retailStoreMemberVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMember){ 
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.
			
			retailStoreMember.changeProperty(property, newValueExpr);
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
		}

	}
	
	public RetailStoreMember updateRetailStoreMemberProperty(RetailscmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		if(retailStoreMember.getVersion() != retailStoreMemberVersion){
			String message = "The target version("+retailStoreMember.getVersion()+") is not equals to version("+retailStoreMemberVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMember){ 
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.
			
			retailStoreMember.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberTokens tokens(){
		return RetailStoreMemberTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith("id","desc")
		.sortRetailStoreMemberCouponListWith("id","desc")
		.sortMemberWishlistListWith("id","desc")
		.sortMemberRewardPointListWith("id","desc")
		.sortMemberRewardPointRedemptionListWith("id","desc")
		.sortRetailStoreMemberAddressListWith("id","desc")
		.sortRetailStoreMemberGiftCardListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
 		
 	}
 	public RetailStoreMember transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberId,anotherOwnerId);
 
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());	
		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, anotherOwnerId, emptyOptions());		
			retailStoreMember.updateOwner(owner);		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, emptyOptions());
			
			return present(userContext,retailStoreMember, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForRetailStoreMember(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreMemberId, int retailStoreMemberVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberId, retailStoreMemberVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreMemberId, int retailStoreMemberVersion) throws Exception{
			
		userContext.getDAOGroup().getRetailStoreMemberDAO().delete(retailStoreMemberId, retailStoreMemberVersion);
	}
	
	public RetailStoreMember forgetByAll(RetailscmUserContext userContext, String retailStoreMemberId, int retailStoreMemberVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberId, retailStoreMemberVersion);		
	}
	protected RetailStoreMember forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreMemberId, int retailStoreMemberVersion) throws Exception{
			
		return userContext.getDAOGroup().getRetailStoreMemberDAO().disconnectFromAll(retailStoreMemberId, retailStoreMemberVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getRetailStoreMemberDAO().deleteAll();
	}


	//disconnect RetailStoreMember with store in ConsumerOrder
	protected RetailStoreMember breakWithConsumerOrderByStore(RetailscmUserContext userContext, String retailStoreMemberId, String storeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());

			synchronized(retailStoreMember){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getRetailStoreMemberDAO().planToRemoveConsumerOrderListWithStore(retailStoreMember, storeId, this.emptyOptions());

				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				return retailStoreMember;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String title, String storeId,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);

		
		userContext.getChecker().checkTitleOfConsumerOrder(title);
		
		userContext.getChecker().checkStoreIdOfConsumerOrder(storeId);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	
	}
	public  RetailStoreMember addConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String title, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,retailStoreMemberId,title, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, storeId);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addConsumerOrder( consumerOrder );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String title,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfConsumerOrder(id);
		
		userContext.getChecker().checkTitleOfConsumerOrder( title);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember updateConsumerOrderProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String title, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingConsumerOrderProperties(userContext,retailStoreMemberId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "is", id).done();
		
		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		if(retailStoreMemberToUpdate.getConsumerOrderList().isEmpty()){
			throw new RetailStoreMemberManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}
		
		ConsumerOrder item = retailStoreMemberToUpdate.getConsumerOrderList().first();
		
		item.updateTitle( title );

		
		//checkParamsForAddingConsumerOrder(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withConsumerOrderList().done());
		synchronized(retailStoreMember){ 
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStore  store = new RetailStore();
		store.setId(storeId);		
		consumerOrder.setStore(store);		
		consumerOrder.setLastUpdateTime(userContext.now());		
		consumerOrder.setCurrentStatus("INIT");
	
		
		return consumerOrder;
	
		
	}
	
	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;			
		
	}
	
	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String consumerOrderId: consumerOrderIds){
			userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember removeConsumerOrderList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String consumerOrderIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingConsumerOrderList(userContext, retailStoreMemberId,  consumerOrderIds, tokensExpr);
			
			
			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){ 
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreMemberDAO().planToRemoveConsumerOrderList(retailStoreMember, consumerOrderIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getConsumerOrderList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember removeConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,retailStoreMemberId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeConsumerOrder( consumerOrder );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember copyConsumerOrderFrom(RetailscmUserContext userContext, String retailStoreMemberId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,retailStoreMemberId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			consumerOrder.updateLastUpdateTime(userContext.now());
			
			retailStoreMember.copyConsumerOrderFrom( consumerOrder );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			
			userContext.getManagerGroup().getConsumerOrderManager().onNewInstanceCreated(userContext, (ConsumerOrder)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfConsumerOrder(consumerOrderId);
		userContext.getChecker().checkVersionOfConsumerOrder(consumerOrderVersion);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			userContext.getChecker().checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	
	public  RetailStoreMember updateConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, retailStoreMemberId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "eq", consumerOrderId).done();
		
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = retailStoreMember.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new RetailStoreMemberManagerException(consumerOrder+" is NOT FOUND" );
			}
			
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*
	public  RetailStoreMember associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().createSupplyOrderConfirmation(userContext,  who,  confirmTime);
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}	public  RetailStoreMember associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().createSupplyOrderApproval(userContext,  who,  approveTime);
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}	public  RetailStoreMember associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().createSupplyOrderProcessing(userContext,  who,  processTime);
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}	public  RetailStoreMember associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().createSupplyOrderShipment(userContext,  who,  shipTime);
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}	public  RetailStoreMember associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().createSupplyOrderDelivery(userContext,  who,  deliveryTime);
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}
	*/
	
	public  RetailStoreMember associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String confirmationId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderConfirmation confirmation = userContext.getManagerGroup().getSupplyOrderConfirmationManager().loadSupplyOrderConfirmation(userContext,confirmationId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateConfirmation(confirmation);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}	public  RetailStoreMember associateConsumerOrderListToApproval(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String approvalId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderApproval approval = userContext.getManagerGroup().getSupplyOrderApprovalManager().loadSupplyOrderApproval(userContext,approvalId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateApproval(approval);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}	public  RetailStoreMember associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String processingId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderProcessing processing = userContext.getManagerGroup().getSupplyOrderProcessingManager().loadSupplyOrderProcessing(userContext,processingId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateProcessing(processing);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}	public  RetailStoreMember associateConsumerOrderListToShipment(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String shipmentId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderShipment shipment = userContext.getManagerGroup().getSupplyOrderShipmentManager().loadSupplyOrderShipment(userContext,shipmentId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateShipment(shipment);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}	public  RetailStoreMember associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String deliveryId, String [] tokensExpr) throws Exception {

		
		
		Map<String, Object> options = tokens()
				.allTokens()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, "oneof", this.joinArray("|", consumerOrderIds)).done();
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		SupplyOrderDelivery delivery = userContext.getManagerGroup().getSupplyOrderDeliveryManager().loadSupplyOrderDelivery(userContext,deliveryId,new String[]{"none"} );
		
		for(ConsumerOrder consumerOrder: retailStoreMember.getConsumerOrderList()) {
			//TODO: need to check if already associated
			consumerOrder.updateDelivery(delivery);
		}
		return this.internalSaveRetailStoreMember(userContext, retailStoreMember);
	}


	protected void checkParamsForAddingRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);

		
		userContext.getChecker().checkNameOfRetailStoreMemberCoupon(name);
		
		userContext.getChecker().checkNumberOfRetailStoreMemberCoupon(number);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	
	}
	public  RetailStoreMember addRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberCoupon(userContext,retailStoreMemberId,name, number,tokensExpr);
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = createRetailStoreMemberCoupon(userContext,name, number);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberCoupon( retailStoreMemberCoupon );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberCouponManager().onNewInstanceCreated(userContext, retailStoreMemberCoupon);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberCouponProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,String number,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(id);
		
		userContext.getChecker().checkNameOfRetailStoreMemberCoupon( name);
		userContext.getChecker().checkNumberOfRetailStoreMemberCoupon( number);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember updateRetailStoreMemberCouponProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,String number, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreMemberCouponProperties(userContext,retailStoreMemberId,id,name,number,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberCouponListList()
				.searchRetailStoreMemberCouponListWith(RetailStoreMemberCoupon.ID_PROPERTY, "is", id).done();
		
		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		if(retailStoreMemberToUpdate.getRetailStoreMemberCouponList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberCoupon is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreMemberCoupon item = retailStoreMemberToUpdate.getRetailStoreMemberCouponList().first();
		
		item.updateName( name );
		item.updateNumber( number );

		
		//checkParamsForAddingRetailStoreMemberCoupon(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberCouponList().done());
		synchronized(retailStoreMember){ 
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailscmUserContext userContext, String name, String number) throws Exception{

		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		
		
		retailStoreMemberCoupon.setName(name);		
		retailStoreMemberCoupon.setNumber(number);		
		retailStoreMemberCoupon.setLastUpdateTime(userContext.now());
	
		
		return retailStoreMemberCoupon;
	
		
	}
	
	protected RetailStoreMemberCoupon createIndexedRetailStoreMemberCoupon(String id, int version){

		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		retailStoreMemberCoupon.setId(id);
		retailStoreMemberCoupon.setVersion(version);
		return retailStoreMemberCoupon;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreMemberCouponList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String retailStoreMemberCouponIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberCouponId: retailStoreMemberCouponIds){
			userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember removeRetailStoreMemberCouponList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String retailStoreMemberCouponIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreMemberCouponList(userContext, retailStoreMemberId,  retailStoreMemberCouponIds, tokensExpr);
			
			
			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){ 
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreMemberDAO().planToRemoveRetailStoreMemberCouponList(retailStoreMember, retailStoreMemberCouponIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberCouponList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		userContext.getChecker().checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember removeRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberCoupon(userContext,retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion,tokensExpr);
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberCoupon( retailStoreMemberCoupon );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			deleteRelationInGraph(userContext, retailStoreMemberCoupon);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		userContext.getChecker().checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember copyRetailStoreMemberCouponFrom(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberCoupon(userContext,retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion,tokensExpr);
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());
			
			retailStoreMember.copyRetailStoreMemberCouponFrom( retailStoreMemberCoupon );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberCouponManager().onNewInstanceCreated(userContext, (RetailStoreMemberCoupon)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		userContext.getChecker().checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);
		

		if(RetailStoreMemberCoupon.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreMemberCoupon(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberCoupon.NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkNumberOfRetailStoreMemberCoupon(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	
	public  RetailStoreMember updateRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberCouponList().searchRetailStoreMemberCouponListWith(RetailStoreMemberCoupon.ID_PROPERTY, "eq", retailStoreMemberCouponId).done();
		
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberCoupon( retailStoreMemberCoupon );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberCoupon retailStoreMemberCouponIndex = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		
			RetailStoreMemberCoupon retailStoreMemberCoupon = retailStoreMember.findTheRetailStoreMemberCoupon(retailStoreMemberCouponIndex);
			if(retailStoreMemberCoupon == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberCoupon+" is NOT FOUND" );
			}
			
			retailStoreMemberCoupon.changeProperty(property, newValueExpr);
			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String name,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);

		
		userContext.getChecker().checkNameOfMemberWishlist(name);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	
	}
	public  RetailStoreMember addMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMemberWishlist(userContext,retailStoreMemberId,name,tokensExpr);
		
		MemberWishlist memberWishlist = createMemberWishlist(userContext,name);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberWishlist( memberWishlist );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			
			userContext.getManagerGroup().getMemberWishlistManager().onNewInstanceCreated(userContext, memberWishlist);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberWishlistProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberWishlist(id);
		
		userContext.getChecker().checkNameOfMemberWishlist( name);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember updateMemberWishlistProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingMemberWishlistProperties(userContext,retailStoreMemberId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberWishlistListList()
				.searchMemberWishlistListWith(MemberWishlist.ID_PROPERTY, "is", id).done();
		
		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		if(retailStoreMemberToUpdate.getMemberWishlistList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberWishlist is NOT FOUND with id: '"+id+"'");
		}
		
		MemberWishlist item = retailStoreMemberToUpdate.getMemberWishlistList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingMemberWishlist(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberWishlistList().done());
		synchronized(retailStoreMember){ 
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected MemberWishlist createMemberWishlist(RetailscmUserContext userContext, String name) throws Exception{

		MemberWishlist memberWishlist = new MemberWishlist();
		
		
		memberWishlist.setName(name);
	
		
		return memberWishlist;
	
		
	}
	
	protected MemberWishlist createIndexedMemberWishlist(String id, int version){

		MemberWishlist memberWishlist = new MemberWishlist();
		memberWishlist.setId(id);
		memberWishlist.setVersion(version);
		return memberWishlist;			
		
	}
	
	protected void checkParamsForRemovingMemberWishlistList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String memberWishlistIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberWishlistId: memberWishlistIds){
			userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember removeMemberWishlistList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String memberWishlistIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingMemberWishlistList(userContext, retailStoreMemberId,  memberWishlistIds, tokensExpr);
			
			
			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){ 
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreMemberDAO().planToRemoveMemberWishlistList(retailStoreMember, memberWishlistIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberWishlistList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().checkVersionOfMemberWishlist(memberWishlistVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember removeMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMemberWishlist(userContext,retailStoreMemberId, memberWishlistId, memberWishlistVersion,tokensExpr);
		
		MemberWishlist memberWishlist = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberWishlist( memberWishlist );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			deleteRelationInGraph(userContext, memberWishlist);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().checkVersionOfMemberWishlist(memberWishlistVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember copyMemberWishlistFrom(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMemberWishlist(userContext,retailStoreMemberId, memberWishlistId, memberWishlistVersion,tokensExpr);
		
		MemberWishlist memberWishlist = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreMember.copyMemberWishlistFrom( memberWishlist );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			
			userContext.getManagerGroup().getMemberWishlistManager().onNewInstanceCreated(userContext, (MemberWishlist)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberWishlist(memberWishlistId);
		userContext.getChecker().checkVersionOfMemberWishlist(memberWishlistVersion);
		

		if(MemberWishlist.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMemberWishlist(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	
	public  RetailStoreMember updateMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMemberWishlist(userContext, retailStoreMemberId, memberWishlistId, memberWishlistVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withMemberWishlistList().searchMemberWishlistListWith(MemberWishlist.ID_PROPERTY, "eq", memberWishlistId).done();
		
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberWishlist( memberWishlist );	
			//make changes to AcceleraterAccount.
			MemberWishlist memberWishlistIndex = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		
			MemberWishlist memberWishlist = retailStoreMember.findTheMemberWishlist(memberWishlistIndex);
			if(memberWishlist == null){
				throw new RetailStoreMemberManagerException(memberWishlist+" is NOT FOUND" );
			}
			
			memberWishlist.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);

		
		userContext.getChecker().checkNameOfMemberRewardPoint(name);
		
		userContext.getChecker().checkPointOfMemberRewardPoint(point);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	
	}
	public  RetailStoreMember addMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMemberRewardPoint(userContext,retailStoreMemberId,name, point,tokensExpr);
		
		MemberRewardPoint memberRewardPoint = createMemberRewardPoint(userContext,name, point);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberRewardPoint( memberRewardPoint );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			
			userContext.getManagerGroup().getMemberRewardPointManager().onNewInstanceCreated(userContext, memberRewardPoint);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberRewardPointProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,int point,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberRewardPoint(id);
		
		userContext.getChecker().checkNameOfMemberRewardPoint( name);
		userContext.getChecker().checkPointOfMemberRewardPoint( point);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember updateMemberRewardPointProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,int point, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingMemberRewardPointProperties(userContext,retailStoreMemberId,id,name,point,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberRewardPointListList()
				.searchMemberRewardPointListWith(MemberRewardPoint.ID_PROPERTY, "is", id).done();
		
		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		if(retailStoreMemberToUpdate.getMemberRewardPointList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberRewardPoint is NOT FOUND with id: '"+id+"'");
		}
		
		MemberRewardPoint item = retailStoreMemberToUpdate.getMemberRewardPointList().first();
		
		item.updateName( name );
		item.updatePoint( point );

		
		//checkParamsForAddingMemberRewardPoint(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberRewardPointList().done());
		synchronized(retailStoreMember){ 
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected MemberRewardPoint createMemberRewardPoint(RetailscmUserContext userContext, String name, int point) throws Exception{

		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		
		
		memberRewardPoint.setName(name);		
		memberRewardPoint.setPoint(point);
	
		
		return memberRewardPoint;
	
		
	}
	
	protected MemberRewardPoint createIndexedMemberRewardPoint(String id, int version){

		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		memberRewardPoint.setId(id);
		memberRewardPoint.setVersion(version);
		return memberRewardPoint;			
		
	}
	
	protected void checkParamsForRemovingMemberRewardPointList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String memberRewardPointIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberRewardPointId: memberRewardPointIds){
			userContext.getChecker().checkIdOfMemberRewardPoint(memberRewardPointId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember removeMemberRewardPointList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String memberRewardPointIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingMemberRewardPointList(userContext, retailStoreMemberId,  memberRewardPointIds, tokensExpr);
			
			
			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){ 
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreMemberDAO().planToRemoveMemberRewardPointList(retailStoreMember, memberRewardPointIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberRewardPointList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberRewardPoint(memberRewardPointId);
		userContext.getChecker().checkVersionOfMemberRewardPoint(memberRewardPointVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember removeMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMemberRewardPoint(userContext,retailStoreMemberId, memberRewardPointId, memberRewardPointVersion,tokensExpr);
		
		MemberRewardPoint memberRewardPoint = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberRewardPoint( memberRewardPoint );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			deleteRelationInGraph(userContext, memberRewardPoint);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberRewardPoint(memberRewardPointId);
		userContext.getChecker().checkVersionOfMemberRewardPoint(memberRewardPointVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember copyMemberRewardPointFrom(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMemberRewardPoint(userContext,retailStoreMemberId, memberRewardPointId, memberRewardPointVersion,tokensExpr);
		
		MemberRewardPoint memberRewardPoint = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreMember.copyMemberRewardPointFrom( memberRewardPoint );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			
			userContext.getManagerGroup().getMemberRewardPointManager().onNewInstanceCreated(userContext, (MemberRewardPoint)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberRewardPoint(memberRewardPointId);
		userContext.getChecker().checkVersionOfMemberRewardPoint(memberRewardPointVersion);
		

		if(MemberRewardPoint.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMemberRewardPoint(parseString(newValueExpr));
		}
		
		if(MemberRewardPoint.POINT_PROPERTY.equals(property)){
			userContext.getChecker().checkPointOfMemberRewardPoint(parseInt(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	
	public  RetailStoreMember updateMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMemberRewardPoint(userContext, retailStoreMemberId, memberRewardPointId, memberRewardPointVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withMemberRewardPointList().searchMemberRewardPointListWith(MemberRewardPoint.ID_PROPERTY, "eq", memberRewardPointId).done();
		
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberRewardPoint( memberRewardPoint );	
			//make changes to AcceleraterAccount.
			MemberRewardPoint memberRewardPointIndex = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		
			MemberRewardPoint memberRewardPoint = retailStoreMember.findTheMemberRewardPoint(memberRewardPointIndex);
			if(memberRewardPoint == null){
				throw new RetailStoreMemberManagerException(memberRewardPoint+" is NOT FOUND" );
			}
			
			memberRewardPoint.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);

		
		userContext.getChecker().checkNameOfMemberRewardPointRedemption(name);
		
		userContext.getChecker().checkPointOfMemberRewardPointRedemption(point);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	
	}
	public  RetailStoreMember addMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMemberRewardPointRedemption(userContext,retailStoreMemberId,name, point,tokensExpr);
		
		MemberRewardPointRedemption memberRewardPointRedemption = createMemberRewardPointRedemption(userContext,name, point);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberRewardPointRedemption( memberRewardPointRedemption );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			
			userContext.getManagerGroup().getMemberRewardPointRedemptionManager().onNewInstanceCreated(userContext, memberRewardPointRedemption);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberRewardPointRedemptionProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,int point,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberRewardPointRedemption(id);
		
		userContext.getChecker().checkNameOfMemberRewardPointRedemption( name);
		userContext.getChecker().checkPointOfMemberRewardPointRedemption( point);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember updateMemberRewardPointRedemptionProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,int point, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingMemberRewardPointRedemptionProperties(userContext,retailStoreMemberId,id,name,point,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberRewardPointRedemptionListList()
				.searchMemberRewardPointRedemptionListWith(MemberRewardPointRedemption.ID_PROPERTY, "is", id).done();
		
		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		if(retailStoreMemberToUpdate.getMemberRewardPointRedemptionList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberRewardPointRedemption is NOT FOUND with id: '"+id+"'");
		}
		
		MemberRewardPointRedemption item = retailStoreMemberToUpdate.getMemberRewardPointRedemptionList().first();
		
		item.updateName( name );
		item.updatePoint( point );

		
		//checkParamsForAddingMemberRewardPointRedemption(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberRewardPointRedemptionList().done());
		synchronized(retailStoreMember){ 
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected MemberRewardPointRedemption createMemberRewardPointRedemption(RetailscmUserContext userContext, String name, int point) throws Exception{

		MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
		
		
		memberRewardPointRedemption.setName(name);		
		memberRewardPointRedemption.setPoint(point);
	
		
		return memberRewardPointRedemption;
	
		
	}
	
	protected MemberRewardPointRedemption createIndexedMemberRewardPointRedemption(String id, int version){

		MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
		memberRewardPointRedemption.setId(id);
		memberRewardPointRedemption.setVersion(version);
		return memberRewardPointRedemption;			
		
	}
	
	protected void checkParamsForRemovingMemberRewardPointRedemptionList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String memberRewardPointRedemptionIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberRewardPointRedemptionId: memberRewardPointRedemptionIds){
			userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember removeMemberRewardPointRedemptionList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String memberRewardPointRedemptionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingMemberRewardPointRedemptionList(userContext, retailStoreMemberId,  memberRewardPointRedemptionIds, tokensExpr);
			
			
			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){ 
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreMemberDAO().planToRemoveMemberRewardPointRedemptionList(retailStoreMember, memberRewardPointRedemptionIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberRewardPointRedemptionList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		userContext.getChecker().checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember removeMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMemberRewardPointRedemption(userContext,retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion,tokensExpr);
		
		MemberRewardPointRedemption memberRewardPointRedemption = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberRewardPointRedemption( memberRewardPointRedemption );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			deleteRelationInGraph(userContext, memberRewardPointRedemption);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		userContext.getChecker().checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember copyMemberRewardPointRedemptionFrom(RetailscmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMemberRewardPointRedemption(userContext,retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion,tokensExpr);
		
		MemberRewardPointRedemption memberRewardPointRedemption = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreMember.copyMemberRewardPointRedemptionFrom( memberRewardPointRedemption );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			
			userContext.getManagerGroup().getMemberRewardPointRedemptionManager().onNewInstanceCreated(userContext, (MemberRewardPointRedemption)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		userContext.getChecker().checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);
		

		if(MemberRewardPointRedemption.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMemberRewardPointRedemption(parseString(newValueExpr));
		}
		
		if(MemberRewardPointRedemption.POINT_PROPERTY.equals(property)){
			userContext.getChecker().checkPointOfMemberRewardPointRedemption(parseInt(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	
	public  RetailStoreMember updateMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMemberRewardPointRedemption(userContext, retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withMemberRewardPointRedemptionList().searchMemberRewardPointRedemptionListWith(MemberRewardPointRedemption.ID_PROPERTY, "eq", memberRewardPointRedemptionId).done();
		
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberRewardPointRedemption( memberRewardPointRedemption );	
			//make changes to AcceleraterAccount.
			MemberRewardPointRedemption memberRewardPointRedemptionIndex = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		
			MemberRewardPointRedemption memberRewardPointRedemption = retailStoreMember.findTheMemberRewardPointRedemption(memberRewardPointRedemptionIndex);
			if(memberRewardPointRedemption == null){
				throw new RetailStoreMemberManagerException(memberRewardPointRedemption+" is NOT FOUND" );
			}
			
			memberRewardPointRedemption.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);

		
		userContext.getChecker().checkNameOfRetailStoreMemberAddress(name);
		
		userContext.getChecker().checkMobilePhoneOfRetailStoreMemberAddress(mobilePhone);
		
		userContext.getChecker().checkAddressOfRetailStoreMemberAddress(address);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	
	}
	public  RetailStoreMember addRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberAddress(userContext,retailStoreMemberId,name, mobilePhone, address,tokensExpr);
		
		RetailStoreMemberAddress retailStoreMemberAddress = createRetailStoreMemberAddress(userContext,name, mobilePhone, address);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberAddress( retailStoreMemberAddress );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberAddressManager().onNewInstanceCreated(userContext, retailStoreMemberAddress);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberAddressProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,String mobilePhone,String address,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberAddress(id);
		
		userContext.getChecker().checkNameOfRetailStoreMemberAddress( name);
		userContext.getChecker().checkMobilePhoneOfRetailStoreMemberAddress( mobilePhone);
		userContext.getChecker().checkAddressOfRetailStoreMemberAddress( address);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember updateRetailStoreMemberAddressProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,String mobilePhone,String address, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreMemberAddressProperties(userContext,retailStoreMemberId,id,name,mobilePhone,address,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberAddressListList()
				.searchRetailStoreMemberAddressListWith(RetailStoreMemberAddress.ID_PROPERTY, "is", id).done();
		
		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		if(retailStoreMemberToUpdate.getRetailStoreMemberAddressList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberAddress is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreMemberAddress item = retailStoreMemberToUpdate.getRetailStoreMemberAddressList().first();
		
		item.updateName( name );
		item.updateMobilePhone( mobilePhone );
		item.updateAddress( address );

		
		//checkParamsForAddingRetailStoreMemberAddress(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberAddressList().done());
		synchronized(retailStoreMember){ 
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreMemberAddress createRetailStoreMemberAddress(RetailscmUserContext userContext, String name, String mobilePhone, String address) throws Exception{

		RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
		
		
		retailStoreMemberAddress.setName(name);		
		retailStoreMemberAddress.setMobilePhone(mobilePhone);		
		retailStoreMemberAddress.setAddress(address);
	
		
		return retailStoreMemberAddress;
	
		
	}
	
	protected RetailStoreMemberAddress createIndexedRetailStoreMemberAddress(String id, int version){

		RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
		retailStoreMemberAddress.setId(id);
		retailStoreMemberAddress.setVersion(version);
		return retailStoreMemberAddress;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreMemberAddressList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String retailStoreMemberAddressIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberAddressId: retailStoreMemberAddressIds){
			userContext.getChecker().checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember removeRetailStoreMemberAddressList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String retailStoreMemberAddressIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreMemberAddressList(userContext, retailStoreMemberId,  retailStoreMemberAddressIds, tokensExpr);
			
			
			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){ 
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreMemberDAO().planToRemoveRetailStoreMemberAddressList(retailStoreMember, retailStoreMemberAddressIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberAddressList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		userContext.getChecker().checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember removeRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberAddress(userContext,retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion,tokensExpr);
		
		RetailStoreMemberAddress retailStoreMemberAddress = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberAddress( retailStoreMemberAddress );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			deleteRelationInGraph(userContext, retailStoreMemberAddress);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		userContext.getChecker().checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember copyRetailStoreMemberAddressFrom(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberAddress(userContext,retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion,tokensExpr);
		
		RetailStoreMemberAddress retailStoreMemberAddress = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreMember.copyRetailStoreMemberAddressFrom( retailStoreMemberAddress );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberAddressManager().onNewInstanceCreated(userContext, (RetailStoreMemberAddress)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		userContext.getChecker().checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);
		

		if(RetailStoreMemberAddress.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreMemberAddress(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY.equals(property)){
			userContext.getChecker().checkMobilePhoneOfRetailStoreMemberAddress(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberAddress.ADDRESS_PROPERTY.equals(property)){
			userContext.getChecker().checkAddressOfRetailStoreMemberAddress(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	
	public  RetailStoreMember updateRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberAddress(userContext, retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberAddressList().searchRetailStoreMemberAddressListWith(RetailStoreMemberAddress.ID_PROPERTY, "eq", retailStoreMemberAddressId).done();
		
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberAddress( retailStoreMemberAddress );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberAddress retailStoreMemberAddressIndex = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		
			RetailStoreMemberAddress retailStoreMemberAddress = retailStoreMember.findTheRetailStoreMemberAddress(retailStoreMemberAddressIndex);
			if(retailStoreMemberAddress == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberAddress+" is NOT FOUND" );
			}
			
			retailStoreMemberAddress.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);

		
		userContext.getChecker().checkNameOfRetailStoreMemberGiftCard(name);
		
		userContext.getChecker().checkNumberOfRetailStoreMemberGiftCard(number);
		
		userContext.getChecker().checkRemainOfRetailStoreMemberGiftCard(remain);
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	
	}
	public  RetailStoreMember addRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberGiftCard(userContext,retailStoreMemberId,name, number, remain,tokensExpr);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createRetailStoreMemberGiftCard(userContext,name, number, remain);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberGiftCard( retailStoreMemberGiftCard );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberGiftCardManager().onNewInstanceCreated(userContext, retailStoreMemberGiftCard);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,String number,BigDecimal remain,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(id);
		
		userContext.getChecker().checkNameOfRetailStoreMemberGiftCard( name);
		userContext.getChecker().checkNumberOfRetailStoreMemberGiftCard( number);
		userContext.getChecker().checkRemainOfRetailStoreMemberGiftCard( remain);

		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember updateRetailStoreMemberGiftCardProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,String number,BigDecimal remain, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRetailStoreMemberGiftCardProperties(userContext,retailStoreMemberId,id,name,number,remain,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberGiftCardListList()
				.searchRetailStoreMemberGiftCardListWith(RetailStoreMemberGiftCard.ID_PROPERTY, "is", id).done();
		
		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);
		
		if(retailStoreMemberToUpdate.getRetailStoreMemberGiftCardList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberGiftCard is NOT FOUND with id: '"+id+"'");
		}
		
		RetailStoreMemberGiftCard item = retailStoreMemberToUpdate.getRetailStoreMemberGiftCardList().first();
		
		item.updateName( name );
		item.updateNumber( number );
		item.updateRemain( remain );

		
		//checkParamsForAddingRetailStoreMemberGiftCard(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberGiftCardList().done());
		synchronized(retailStoreMember){ 
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(RetailscmUserContext userContext, String name, String number, BigDecimal remain) throws Exception{

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		
		
		retailStoreMemberGiftCard.setName(name);		
		retailStoreMemberGiftCard.setNumber(number);		
		retailStoreMemberGiftCard.setRemain(remain);
	
		
		return retailStoreMemberGiftCard;
	
		
	}
	
	protected RetailStoreMemberGiftCard createIndexedRetailStoreMemberGiftCard(String id, int version){

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		retailStoreMemberGiftCard.setId(id);
		retailStoreMemberGiftCard.setVersion(version);
		return retailStoreMemberGiftCard;			
		
	}
	
	protected void checkParamsForRemovingRetailStoreMemberGiftCardList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String retailStoreMemberGiftCardIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberGiftCardId: retailStoreMemberGiftCardIds){
			userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
		
	}
	public  RetailStoreMember removeRetailStoreMemberGiftCardList(RetailscmUserContext userContext, String retailStoreMemberId, 
			String retailStoreMemberGiftCardIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRetailStoreMemberGiftCardList(userContext, retailStoreMemberId,  retailStoreMemberGiftCardIds, tokensExpr);
			
			
			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){ 
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getRetailStoreMemberDAO().planToRemoveRetailStoreMemberGiftCardList(retailStoreMember, retailStoreMemberGiftCardIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberGiftCardList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember removeRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberGiftCard(userContext,retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion,tokensExpr);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberGiftCard( retailStoreMemberGiftCard );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			deleteRelationInGraph(userContext, retailStoreMemberGiftCard);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfRetailStoreMember( retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	public  RetailStoreMember copyRetailStoreMemberGiftCardFrom(RetailscmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberGiftCard(userContext,retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion,tokensExpr);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			retailStoreMember.copyRetailStoreMemberGiftCardFrom( retailStoreMemberGiftCard );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberGiftCardManager().onNewInstanceCreated(userContext, (RetailStoreMemberGiftCard)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfRetailStoreMember(retailStoreMemberId);
		userContext.getChecker().checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		userContext.getChecker().checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);
		

		if(RetailStoreMemberGiftCard.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberGiftCard.NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkNumberOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberGiftCard.REMAIN_PROPERTY.equals(property)){
			userContext.getChecker().checkRemainOfRetailStoreMemberGiftCard(parseBigDecimal(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);
	
	}
	
	public  RetailStoreMember updateRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberGiftCardList().searchRetailStoreMemberGiftCardListWith(RetailStoreMemberGiftCard.ID_PROPERTY, "eq", retailStoreMemberGiftCardId).done();
		
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberGiftCard( retailStoreMemberGiftCard );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberGiftCard retailStoreMemberGiftCardIndex = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		
			RetailStoreMemberGiftCard retailStoreMemberGiftCard = retailStoreMember.findTheRetailStoreMemberGiftCard(retailStoreMemberGiftCardIndex);
			if(retailStoreMemberGiftCard == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberGiftCard+" is NOT FOUND" );
			}
			
			retailStoreMemberGiftCard.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMember newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


