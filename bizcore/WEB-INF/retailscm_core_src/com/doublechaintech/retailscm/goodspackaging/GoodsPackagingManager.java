
package com.doublechaintech.retailscm.goodspackaging;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface GoodsPackagingManager{

		

	public GoodsPackaging createGoodsPackaging(RetailscmUserContext userContext, String packageName, String rfid, Date packageTime, String description) throws Exception;	
	public GoodsPackaging updateGoodsPackaging(RetailscmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsPackaging loadGoodsPackaging(RetailscmUserContext userContext, String goodsPackagingId, String [] tokensExpr) throws Exception;
	public GoodsPackaging internalSaveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging) throws Exception;
	public GoodsPackaging internalSaveGoodsPackaging(RetailscmUserContext userContext, GoodsPackaging goodsPackaging,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String goodsPackagingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsPackaging newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	
	public  GoodsPackaging addGoods(RetailscmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId , String [] tokensExpr)  throws Exception;
	public  GoodsPackaging removeGoods(RetailscmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  GoodsPackaging updateGoods(RetailscmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


