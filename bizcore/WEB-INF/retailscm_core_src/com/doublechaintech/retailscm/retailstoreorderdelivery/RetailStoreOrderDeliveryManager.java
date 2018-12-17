
package com.doublechaintech.retailscm.retailstoreorderdelivery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderDeliveryManager{

		

	public RetailStoreOrderDelivery createRetailStoreOrderDelivery(RetailscmUserContext userContext, String who, Date deliveryTime) throws Exception;	
	public RetailStoreOrderDelivery updateRetailStoreOrderDelivery(RetailscmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderDelivery loadRetailStoreOrderDelivery(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderDelivery internalSaveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery) throws Exception;
	public RetailStoreOrderDelivery internalSaveRetailStoreOrderDelivery(RetailscmUserContext userContext, RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderDelivery newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrderDelivery addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderDelivery removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderDelivery updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderDelivery associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreOrderDeliveryId, String  retailStoreOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;

	*/



}


