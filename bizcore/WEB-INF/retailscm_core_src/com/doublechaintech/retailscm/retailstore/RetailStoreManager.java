
package com.doublechaintech.retailscm.retailstore;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreManager{

		

	public RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception;	
	public RetailStore updateRetailStore(RetailscmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStore loadRetailStore(RetailscmUserContext userContext, String retailStoreId, String [] tokensExpr) throws Exception;
	public RetailStore internalSaveRetailStore(RetailscmUserContext userContext, RetailStore retailStore) throws Exception;
	public RetailStore internalSaveRetailStore(RetailscmUserContext userContext, RetailStore retailStore,Map<String,Object>option) throws Exception;
	
	public RetailStore transferToAnotherRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId)  throws Exception;
 	public RetailStore transferToAnotherCityServiceCenter(RetailscmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId)  throws Exception;
 	public RetailStore create(RetailscmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore inviteInvestment(RetailscmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore franchise(RetailscmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore decorate(RetailscmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore open(RetailscmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore close(RetailscmUserContext userContext, String retailStoreId, String comment
)  throws Exception;


	public void delete(RetailscmUserContext userContext, String retailStoreId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStore newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ConsumerOrderManager getConsumerOrderManager(RetailscmUserContext userContext, String retailStoreId, String title, String consumerId ,String [] tokensExpr)  throws Exception;
	
	public  RetailStore addConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String title, String consumerId , String [] tokensExpr)  throws Exception;
	public  RetailStore removeConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStore associateConsumerOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToApproval(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToProcessing(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToShipment(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateConsumerOrderListToDelivery(RetailscmUserContext userContext, String retailStoreId, String  consumerOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStore addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStore removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStore associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStore associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreId, String  retailStoreOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	
	public  RetailStore addGoods(RetailscmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId , String [] tokensExpr)  throws Exception;
	public  RetailStore removeGoods(RetailscmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateGoods(RetailscmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStore associateGoodsListToNewPackaging(RetailscmUserContext userContext, String retailStoreId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception ;
	public  RetailStore associateGoodsListToPackaging(RetailscmUserContext userContext, String retailStoreId, String  goodsIds[],String packagingId, String [] tokensExpr) throws Exception ;

	*/

	//public  TransportTaskManager getTransportTaskManager(RetailscmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;
	
	public  RetailStore addTransportTask(RetailscmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  RetailStore removeTransportTask(RetailscmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateTransportTask(RetailscmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountSetManager getAccountSetManager(RetailscmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId ,String [] tokensExpr)  throws Exception;
	
	public  RetailStore addAccountSet(RetailscmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId , String [] tokensExpr)  throws Exception;
	public  RetailStore removeAccountSet(RetailscmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateAccountSet(RetailscmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


