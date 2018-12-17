
package com.doublechaintech.retailscm.retailstoremember;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreMemberManager{

		

	public RetailStoreMember createRetailStoreMember(RetailscmUserContext userContext, String name, String mobilePhone, String ownerId) throws Exception;	
	public RetailStoreMember updateRetailStoreMember(RetailscmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String retailStoreMemberId, String [] tokensExpr) throws Exception;
	public RetailStoreMember internalSaveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember) throws Exception;
	public RetailStoreMember internalSaveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember,Map<String,Object>option) throws Exception;
	
	public RetailStoreMember transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String retailStoreMemberId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMember newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String retailStoreMemberId, String title, String storeId ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreMember addConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String title, String storeId , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreMember associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToApproval(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToShipment(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreMember associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String retailStoreMemberId, String  consumerOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  RetailStoreMemberCouponManager getRetailStoreMemberCouponManager(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreMember addRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MemberWishlistManager getMemberWishlistManager(RetailscmUserContext userContext, String retailStoreMemberId, String name ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreMember addMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String name , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MemberRewardPointManager getMemberRewardPointManager(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreMember addMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  MemberRewardPointRedemptionManager getMemberRewardPointRedemptionManager(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreMember addMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreMemberAddressManager getRetailStoreMemberAddressManager(RetailscmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreMember addRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreMemberGiftCardManager getRetailStoreMemberGiftCardManager(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreMember addRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain , String [] tokensExpr)  throws Exception;
	public  RetailStoreMember removeRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMember updateRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


