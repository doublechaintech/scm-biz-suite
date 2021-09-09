
package com.doublechaintech.retailscm.goodsallocation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface GoodsAllocationManager extends BaseManager{

		

  List<GoodsAllocation> searchGoodsAllocationList(RetailscmUserContext ctx, GoodsAllocationRequest pRequest);
  GoodsAllocation searchGoodsAllocation(RetailscmUserContext ctx, GoodsAllocationRequest pRequest);
	public GoodsAllocation createGoodsAllocation(RetailscmUserContext userContext, String location,BigDecimal latitude,BigDecimal longitude,String goodsShelfId) throws Exception;
	public GoodsAllocation updateGoodsAllocation(RetailscmUserContext userContext,String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsAllocation loadGoodsAllocation(RetailscmUserContext userContext, String goodsAllocationId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public GoodsAllocation internalSaveGoodsAllocation(RetailscmUserContext userContext, GoodsAllocation goodsAllocation) throws Exception;
	public GoodsAllocation internalSaveGoodsAllocation(RetailscmUserContext userContext, GoodsAllocation goodsAllocation,Map<String,Object>option) throws Exception;

	public GoodsAllocation transferToAnotherGoodsShelf(RetailscmUserContext userContext, String goodsAllocationId, String anotherGoodsShelfId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String goodsAllocationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsAllocation newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, GoodsAllocation updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;

	public  GoodsAllocation addGoods(RetailscmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId , String [] tokensExpr)  throws Exception;
	public  GoodsAllocation removeGoods(RetailscmUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  GoodsAllocation updateGoods(RetailscmUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByGoodsShelf(RetailscmUserContext userContext,String goodsShelfId) throws Exception;
	public Object listPageByGoodsShelf(RetailscmUserContext userContext,String goodsShelfId, int start, int count) throws Exception;
  




}


