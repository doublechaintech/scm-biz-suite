
package com.doublechaintech.retailscm.retailstoreorderpicking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderPickingManager{

		

	public RetailStoreOrderPicking createRetailStoreOrderPicking(RetailscmUserContext userContext, String who, Date processTime) throws Exception;	
	public RetailStoreOrderPicking updateRetailStoreOrderPicking(RetailscmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderPicking loadRetailStoreOrderPicking(RetailscmUserContext userContext, String retailStoreOrderPickingId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderPicking internalSaveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking) throws Exception;
	public RetailStoreOrderPicking internalSaveRetailStoreOrderPicking(RetailscmUserContext userContext, RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreOrderPickingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderPicking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrderPicking addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderPicking removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderPicking updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderPicking associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreOrderPickingId, String  retailStoreOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


