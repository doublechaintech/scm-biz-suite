
package com.doublechaintech.retailscm.retailstoreordershipment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderShipmentManager{

		

	public RetailStoreOrderShipment createRetailStoreOrderShipment(RetailscmUserContext userContext, String who, Date shipTime) throws Exception;	
	public RetailStoreOrderShipment updateRetailStoreOrderShipment(RetailscmUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderShipment loadRetailStoreOrderShipment(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderShipment internalSaveRetailStoreOrderShipment(RetailscmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment) throws Exception;
	public RetailStoreOrderShipment internalSaveRetailStoreOrderShipment(RetailscmUserContext userContext, RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreOrderShipmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderShipment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreOrderShipment addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderShipment removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderShipment updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreOrderShipment associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreOrderShipment associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreOrderShipmentId, String  retailStoreOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


