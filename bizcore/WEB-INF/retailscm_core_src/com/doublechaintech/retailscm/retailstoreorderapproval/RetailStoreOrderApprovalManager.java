
package com.doublechaintech.retailscm.retailstoreorderapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderApprovalManager{

		

	public RetailStoreOrderApproval createRetailStoreOrderApproval(RetailscmUserContext userContext, String who, Date approveTime) throws Exception;	
	public RetailStoreOrderApproval updateRetailStoreOrderApproval(RetailscmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderApproval loadRetailStoreOrderApproval(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval) throws Exception;
	public RetailStoreOrderApproval internalSaveRetailStoreOrderApproval(RetailscmUserContext userContext, RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreOrderApprovalId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrderApproval addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderApproval removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderApproval updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderApproval associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreOrderApprovalId, String  retailStoreOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


