
package com.doublechaintech.retailscm.goods;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface GoodsManager extends BaseManager{

		

	public Goods createGoods(RetailscmUserContext userContext, String name,String rfid,String uom,int maxPackage,Date expireTime,String skuId,String receivingSpaceId,String goodsAllocationId,String smartPalletId,String shippingSpaceId,String transportTaskId,String retailStoreId,String bizOrderId,String retailStoreOrderId) throws Exception;
	public Goods updateGoods(RetailscmUserContext userContext,String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Goods loadGoods(RetailscmUserContext userContext, String goodsId, String [] tokensExpr) throws Exception;
	public Goods internalSaveGoods(RetailscmUserContext userContext, Goods goods) throws Exception;
	public Goods internalSaveGoods(RetailscmUserContext userContext, Goods goods,Map<String,Object>option) throws Exception;

	public Goods transferToAnotherSku(RetailscmUserContext userContext, String goodsId, String anotherSkuId)  throws Exception;
 	public Goods transferToAnotherReceivingSpace(RetailscmUserContext userContext, String goodsId, String anotherReceivingSpaceId)  throws Exception;
 	public Goods transferToAnotherGoodsAllocation(RetailscmUserContext userContext, String goodsId, String anotherGoodsAllocationId)  throws Exception;
 	public Goods transferToAnotherSmartPallet(RetailscmUserContext userContext, String goodsId, String anotherSmartPalletId)  throws Exception;
 	public Goods transferToAnotherShippingSpace(RetailscmUserContext userContext, String goodsId, String anotherShippingSpaceId)  throws Exception;
 	public Goods transferToAnotherTransportTask(RetailscmUserContext userContext, String goodsId, String anotherTransportTaskId)  throws Exception;
 	public Goods transferToAnotherRetailStore(RetailscmUserContext userContext, String goodsId, String anotherRetailStoreId)  throws Exception;
 	public Goods transferToAnotherBizOrder(RetailscmUserContext userContext, String goodsId, String anotherBizOrderId)  throws Exception;
 	public Goods transferToAnotherRetailStoreOrder(RetailscmUserContext userContext, String goodsId, String anotherRetailStoreOrderId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String goodsId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Goods newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsMovementManager getGoodsMovementManager(RetailscmUserContext userContext, String goodsId, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  Goods addGoodsMovement(RetailscmUserContext userContext, String goodsId, DateTime moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  Goods removeGoodsMovement(RetailscmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion,String [] tokensExpr)  throws Exception;
	public  Goods updateGoodsMovement(RetailscmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySku(RetailscmUserContext userContext,String skuId) throws Exception;
	public Object listPageBySku(RetailscmUserContext userContext,String skuId, int start, int count) throws Exception;
  
	public Object listByReceivingSpace(RetailscmUserContext userContext,String receivingSpaceId) throws Exception;
	public Object listPageByReceivingSpace(RetailscmUserContext userContext,String receivingSpaceId, int start, int count) throws Exception;
  
	public Object listByGoodsAllocation(RetailscmUserContext userContext,String goodsAllocationId) throws Exception;
	public Object listPageByGoodsAllocation(RetailscmUserContext userContext,String goodsAllocationId, int start, int count) throws Exception;
  
	public Object listBySmartPallet(RetailscmUserContext userContext,String smartPalletId) throws Exception;
	public Object listPageBySmartPallet(RetailscmUserContext userContext,String smartPalletId, int start, int count) throws Exception;
  
	public Object listByShippingSpace(RetailscmUserContext userContext,String shippingSpaceId) throws Exception;
	public Object listPageByShippingSpace(RetailscmUserContext userContext,String shippingSpaceId, int start, int count) throws Exception;
  
	public Object listByTransportTask(RetailscmUserContext userContext,String transportTaskId) throws Exception;
	public Object listPageByTransportTask(RetailscmUserContext userContext,String transportTaskId, int start, int count) throws Exception;
  
	public Object listByRetailStore(RetailscmUserContext userContext,String retailStoreId) throws Exception;
	public Object listPageByRetailStore(RetailscmUserContext userContext,String retailStoreId, int start, int count) throws Exception;
  
	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  
	public Object listByRetailStoreOrder(RetailscmUserContext userContext,String retailStoreOrderId) throws Exception;
	public Object listPageByRetailStoreOrder(RetailscmUserContext userContext,String retailStoreOrderId, int start, int count) throws Exception;
  

}


