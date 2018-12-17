
package com.doublechaintech.retailscm.supplyorderdelivery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderDeliveryManager{

		

	public SupplyOrderDelivery createSupplyOrderDelivery(RetailscmUserContext userContext, String who, Date deliveryTime) throws Exception;	
	public SupplyOrderDelivery updateSupplyOrderDelivery(RetailscmUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderDelivery loadSupplyOrderDelivery(RetailscmUserContext userContext, String supplyOrderDeliveryId, String [] tokensExpr) throws Exception;
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery) throws Exception;
	public SupplyOrderDelivery internalSaveSupplyOrderDelivery(RetailscmUserContext userContext, SupplyOrderDelivery supplyOrderDelivery,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String supplyOrderDeliveryId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderDelivery newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderDelivery addConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderDelivery associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateConsumerOrderListToApproval(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateConsumerOrderListToShipment(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  consumerOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderDelivery addSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderDelivery associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderDelivery associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderDeliveryId, String  supplyOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;

	*/



}


