
package com.doublechaintech.retailscm.supplyorderapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderApprovalManager{

		

	public SupplyOrderApproval createSupplyOrderApproval(RetailscmUserContext userContext, String who, Date approveTime) throws Exception;	
	public SupplyOrderApproval updateSupplyOrderApproval(RetailscmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderApproval loadSupplyOrderApproval(RetailscmUserContext userContext, String supplyOrderApprovalId, String [] tokensExpr) throws Exception;
	public SupplyOrderApproval internalSaveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval) throws Exception;
	public SupplyOrderApproval internalSaveSupplyOrderApproval(RetailscmUserContext userContext, SupplyOrderApproval supplyOrderApproval,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String supplyOrderApprovalId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderApproval addConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String storeId , String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval removeConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval updateConsumerOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderApproval associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateConsumerOrderListToShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String  consumerOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderApproval addSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderApproval associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToPicking(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderApproval associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderApprovalId, String  supplyOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


