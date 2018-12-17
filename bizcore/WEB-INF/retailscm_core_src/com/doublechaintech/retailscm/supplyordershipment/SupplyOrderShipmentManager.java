
package com.doublechaintech.retailscm.supplyordershipment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderShipmentManager{

		

	public SupplyOrderShipment createSupplyOrderShipment(RetailscmUserContext userContext, String who, Date shipTime) throws Exception;	
	public SupplyOrderShipment updateSupplyOrderShipment(RetailscmUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderShipment loadSupplyOrderShipment(RetailscmUserContext userContext, String supplyOrderShipmentId, String [] tokensExpr) throws Exception;
	public SupplyOrderShipment internalSaveSupplyOrderShipment(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment) throws Exception;
	public SupplyOrderShipment internalSaveSupplyOrderShipment(RetailscmUserContext userContext, SupplyOrderShipment supplyOrderShipment,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String supplyOrderShipmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderShipment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderShipment addConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderShipment associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateConsumerOrderListToApproval(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderShipmentId, String  consumerOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderShipment addSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderShipment associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderShipment associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderShipmentId, String  supplyOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


