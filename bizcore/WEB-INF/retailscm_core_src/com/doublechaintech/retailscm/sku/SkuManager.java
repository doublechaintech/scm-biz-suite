
package com.doublechaintech.retailscm.sku;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface SkuManager{

		

	public Sku createSku(RetailscmUserContext userContext, String name, String size, String productId, String barcode, String packageType, String netContent, BigDecimal price, String picture) throws Exception;	
	public Sku updateSku(RetailscmUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Sku loadSku(RetailscmUserContext userContext, String skuId, String [] tokensExpr) throws Exception;
	public Sku internalSaveSku(RetailscmUserContext userContext, Sku sku) throws Exception;
	public Sku internalSaveSku(RetailscmUserContext userContext, Sku sku,Map<String,Object>option) throws Exception;
	
	public Sku transferToAnotherProduct(RetailscmUserContext userContext, String skuId, String anotherProductId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String skuId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Sku newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	
	public  Sku addGoods(RetailscmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId , String [] tokensExpr)  throws Exception;
	public  Sku removeGoods(RetailscmUserContext userContext, String skuId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  Sku updateGoods(RetailscmUserContext userContext, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  Sku associateGoodsListToNewPackaging(RetailscmUserContext userContext, String skuId, String  goodsIds[], String packageName, String rfid, Date packageTime, String description, String [] tokensExpr) throws Exception ;
	public  Sku associateGoodsListToPackaging(RetailscmUserContext userContext, String skuId, String  goodsIds[],String packagingId, String [] tokensExpr) throws Exception ;

	*/



}


