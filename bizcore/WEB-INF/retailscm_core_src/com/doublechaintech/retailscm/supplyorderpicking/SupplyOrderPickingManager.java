
package com.doublechaintech.retailscm.supplyorderpicking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderPickingManager{

		

	public SupplyOrderPicking createSupplyOrderPicking(RetailscmUserContext userContext, String who, Date processTime) throws Exception;	
	public SupplyOrderPicking updateSupplyOrderPicking(RetailscmUserContext userContext,String supplyOrderPickingId, int supplyOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderPicking loadSupplyOrderPicking(RetailscmUserContext userContext, String supplyOrderPickingId, String [] tokensExpr) throws Exception;
	public SupplyOrderPicking internalSaveSupplyOrderPicking(RetailscmUserContext userContext, SupplyOrderPicking supplyOrderPicking) throws Exception;
	public SupplyOrderPicking internalSaveSupplyOrderPicking(RetailscmUserContext userContext, SupplyOrderPicking supplyOrderPicking,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String supplyOrderPickingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderPicking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  SupplyOrderPicking addSupplyOrder(RetailscmUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  SupplyOrderPicking removeSupplyOrder(RetailscmUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderPicking updateSupplyOrder(RetailscmUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  SupplyOrderPicking associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToApproval(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToShipment(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  SupplyOrderPicking associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String supplyOrderPickingId, String  supplyOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/



}


