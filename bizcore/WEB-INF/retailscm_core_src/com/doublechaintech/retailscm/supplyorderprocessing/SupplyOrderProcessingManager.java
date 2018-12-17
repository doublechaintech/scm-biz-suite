
package com.doublechaintech.retailscm.supplyorderprocessing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderProcessingManager{

		

	public SupplyOrderProcessing createSupplyOrderProcessing(RetailscmUserContext userContext, String who, Date processTime) throws Exception;	
	public SupplyOrderProcessing updateSupplyOrderProcessing(RetailscmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderProcessing loadSupplyOrderProcessing(RetailscmUserContext userContext, String supplyOrderProcessingId, String [] tokensExpr) throws Exception;
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing) throws Exception;
	public SupplyOrderProcessing internalSaveSupplyOrderProcessing(RetailscmUserContext userContext, SupplyOrderProcessing supplyOrderProcessing,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String supplyOrderProcessingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderProcessing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderProcessing addConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderProcessing associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateConsumerOrderListToApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateConsumerOrderListToShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String  consumerOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderProcessing addSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderProcessing associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderProcessing associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderProcessingId, String  supplyOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


