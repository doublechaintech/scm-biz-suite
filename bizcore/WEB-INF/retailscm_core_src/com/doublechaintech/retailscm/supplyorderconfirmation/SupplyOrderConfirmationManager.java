
package com.doublechaintech.retailscm.supplyorderconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderConfirmationManager{

		

	public SupplyOrderConfirmation createSupplyOrderConfirmation(RetailscmUserContext userContext, String who, Date confirmTime) throws Exception;	
	public SupplyOrderConfirmation updateSupplyOrderConfirmation(RetailscmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderConfirmation loadSupplyOrderConfirmation(RetailscmUserContext userContext, String supplyOrderConfirmationId, String [] tokensExpr) throws Exception;
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation) throws Exception;
	public SupplyOrderConfirmation internalSaveSupplyOrderConfirmation(RetailscmUserContext userContext, SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String supplyOrderConfirmationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderConfirmation addConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderConfirmation associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateConsumerOrderListToApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateConsumerOrderListToShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  consumerOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderConfirmation addSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderConfirmation associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderConfirmation associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderConfirmationId, String  supplyOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


