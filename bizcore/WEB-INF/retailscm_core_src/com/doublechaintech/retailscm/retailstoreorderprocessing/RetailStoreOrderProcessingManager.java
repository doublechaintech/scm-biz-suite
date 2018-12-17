
package com.doublechaintech.retailscm.retailstoreorderprocessing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderProcessingManager{

		

	public RetailStoreOrderProcessing createRetailStoreOrderProcessing(RetailscmUserContext userContext, String who, Date processTime) throws Exception;	
	public RetailStoreOrderProcessing updateRetailStoreOrderProcessing(RetailscmUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderProcessing loadRetailStoreOrderProcessing(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderProcessing internalSaveRetailStoreOrderProcessing(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing) throws Exception;
	public RetailStoreOrderProcessing internalSaveRetailStoreOrderProcessing(RetailscmUserContext userContext, RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreOrderProcessingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderProcessing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrderProcessing addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderProcessing removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderProcessing updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderProcessing associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreOrderProcessingId, String  retailStoreOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


