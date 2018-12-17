
package com.doublechaintech.retailscm.goodssupplier;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface GoodsSupplierManager{

		

	public GoodsSupplier createGoodsSupplier(RetailscmUserContext userContext, String name, String supplyProduct, String belongToId, String contactNumber, String description) throws Exception;	
	public GoodsSupplier updateGoodsSupplier(RetailscmUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsSupplier loadGoodsSupplier(RetailscmUserContext userContext, String goodsSupplierId, String [] tokensExpr) throws Exception;
	public GoodsSupplier internalSaveGoodsSupplier(RetailscmUserContext userContext, GoodsSupplier goodsSupplier) throws Exception;
	public GoodsSupplier internalSaveGoodsSupplier(RetailscmUserContext userContext, GoodsSupplier goodsSupplier,Map<String,Object>option) throws Exception;
	
	public GoodsSupplier transferToAnotherBelongTo(RetailscmUserContext userContext, String goodsSupplierId, String anotherBelongToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String goodsSupplierId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsSupplier newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  SupplierProductManager getSupplierProductManager(RetailscmUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit ,String [] tokensExpr)  throws Exception;
	
	public  GoodsSupplier addSupplierProduct(RetailscmUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeSupplierProduct(RetailscmUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateSupplierProduct(RetailscmUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String goodsSupplierId, String buyerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  GoodsSupplier addSupplyOrder(RetailscmUserContext userContext, String goodsSupplierId, String buyerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeSupplyOrder(RetailscmUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateSupplyOrder(RetailscmUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  GoodsSupplier associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToApproval(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToPicking(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToShipment(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  GoodsSupplier associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String goodsSupplierId, String  supplyOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  AccountSetManager getAccountSetManager(RetailscmUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId ,String [] tokensExpr)  throws Exception;
	
	public  GoodsSupplier addAccountSet(RetailscmUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeAccountSet(RetailscmUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateAccountSet(RetailscmUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


