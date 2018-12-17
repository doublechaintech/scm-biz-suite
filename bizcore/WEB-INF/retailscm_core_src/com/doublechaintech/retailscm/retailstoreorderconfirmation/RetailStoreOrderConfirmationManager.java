
package com.doublechaintech.retailscm.retailstoreorderconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderConfirmationManager{

		

	public RetailStoreOrderConfirmation createRetailStoreOrderConfirmation(RetailscmUserContext userContext, String who, Date confirmTime) throws Exception;	
	public RetailStoreOrderConfirmation updateRetailStoreOrderConfirmation(RetailscmUserContext userContext,String retailStoreOrderConfirmationId, int retailStoreOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderConfirmation loadRetailStoreOrderConfirmation(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderConfirmation internalSaveRetailStoreOrderConfirmation(RetailscmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation) throws Exception;
	public RetailStoreOrderConfirmation internalSaveRetailStoreOrderConfirmation(RetailscmUserContext userContext, RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrderConfirmation addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderConfirmation removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderConfirmation updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderConfirmation associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreOrderConfirmationId, String  retailStoreOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


