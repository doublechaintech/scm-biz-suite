
package com.doublechaintech.retailscm.retailstoreorder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderManager{

		

	public RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext, String buyerId, String sellerId, String title, BigDecimal totalAmount) throws Exception;	
	public RetailStoreOrder updateRetailStoreOrder(RetailscmUserContext userContext,String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrder loadRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderId, String [] tokensExpr) throws Exception;
	public RetailStoreOrder internalSaveRetailStoreOrder(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder) throws Exception;
	public RetailStoreOrder internalSaveRetailStoreOrder(RetailscmUserContext userContext, RetailStoreOrder retailStoreOrder,Map<String,Object>option) throws Exception;
	
	public RetailStoreOrder transferToAnotherBuyer(RetailscmUserContext userContext, String retailStoreOrderId, String anotherBuyerId)  throws Exception;
 	public RetailStoreOrder transferToAnotherSeller(RetailscmUserContext userContext, String retailStoreOrderId, String anotherSellerId)  throws Exception;
 	public RetailStoreOrder confirm(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date confirmTime
)  throws Exception;
	public RetailStoreOrder approve(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date approveTime
)  throws Exception;
	public RetailStoreOrder process(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date processTime
)  throws Exception;
	public RetailStoreOrder pick(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date processTime
)  throws Exception;
	public RetailStoreOrder ship(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date shipTime
)  throws Exception;
	public RetailStoreOrder deliver(RetailscmUserContext userContext, String retailStoreOrderId, String who, Date deliveryTime
)  throws Exception;


	public void delete(RetailscmUserContext userContext, String retailStoreOrderId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrder newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreOrderLineItemManager getRetailStoreOrderLineItemManager(RetailscmUserContext userContext, String retailStoreOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrder addRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderLineItem(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreOrderShippingGroupManager getRetailStoreOrderShippingGroupManager(RetailscmUserContext userContext, String retailStoreOrderId, String name, BigDecimal amount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrder addRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, String name, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreOrderPaymentGroupManager getRetailStoreOrderPaymentGroupManager(RetailscmUserContext userContext, String retailStoreOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrder addRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, String name, String cardNumber , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrder addGoods(RetailscmUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeGoods(RetailscmUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateGoods(RetailscmUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreOrder associateGoodsListToNewPackaging(RetailscmUserContext userContext, String retailStoreOrderId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrder associateGoodsListToPackaging(RetailscmUserContext userContext, String retailStoreOrderId, String  goodsIds[],String packagingId, String [] tokensExpr) throws Exception ;

	*/



}


