
package com.doublechaintech.retailscm.supplyorder;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderManager extends BaseManager{

		

	public SupplyOrder createSupplyOrder(RetailscmUserContext userContext, String buyerId,String sellerId,String title,BigDecimal totalAmount) throws Exception;
	public SupplyOrder updateSupplyOrder(RetailscmUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrder loadSupplyOrder(RetailscmUserContext userContext, String supplyOrderId, String [] tokensExpr) throws Exception;
	public SupplyOrder internalSaveSupplyOrder(RetailscmUserContext userContext, SupplyOrder supplyOrder) throws Exception;
	public SupplyOrder internalSaveSupplyOrder(RetailscmUserContext userContext, SupplyOrder supplyOrder,Map<String,Object>option) throws Exception;

	public SupplyOrder transferToAnotherBuyer(RetailscmUserContext userContext, String supplyOrderId, String anotherBuyerId)  throws Exception;
 	public SupplyOrder transferToAnotherSeller(RetailscmUserContext userContext, String supplyOrderId, String anotherSellerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String supplyOrderId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrder newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SupplyOrderLineItemManager getSupplyOrderLineItemManager(RetailscmUserContext userContext, String supplyOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement ,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement , String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderShippingGroupManager getSupplyOrderShippingGroupManager(RetailscmUserContext userContext, String supplyOrderId, String name, BigDecimal amount ,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, String name, BigDecimal amount , String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderPaymentGroupManager getSupplyOrderPaymentGroupManager(RetailscmUserContext userContext, String supplyOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, String name, String cardNumber , String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addGoods(RetailscmUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId , String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeGoods(RetailscmUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateGoods(RetailscmUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBuyer(RetailscmUserContext userContext,String buyerId) throws Exception;
	public Object listPageByBuyer(RetailscmUserContext userContext,String buyerId, int start, int count) throws Exception;
  
	public Object listBySeller(RetailscmUserContext userContext,String sellerId) throws Exception;
	public Object listPageBySeller(RetailscmUserContext userContext,String sellerId, int start, int count) throws Exception;
  

}


