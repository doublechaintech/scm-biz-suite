
package com.doublechaintech.retailscm.smartpallet;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SmartPalletManager extends BaseManager{

		

	public SmartPallet createSmartPallet(RetailscmUserContext userContext, String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String warehouseId) throws Exception;
	public SmartPallet updateSmartPallet(RetailscmUserContext userContext,String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SmartPallet loadSmartPallet(RetailscmUserContext userContext, String smartPalletId, String [] tokensExpr) throws Exception;
	public SmartPallet internalSaveSmartPallet(RetailscmUserContext userContext, SmartPallet smartPallet) throws Exception;
	public SmartPallet internalSaveSmartPallet(RetailscmUserContext userContext, SmartPallet smartPallet,Map<String,Object>option) throws Exception;

	public SmartPallet transferToAnotherWarehouse(RetailscmUserContext userContext, String smartPalletId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String smartPalletId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SmartPallet newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;

	public  SmartPallet addGoods(RetailscmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId , String [] tokensExpr)  throws Exception;
	public  SmartPallet removeGoods(RetailscmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  SmartPallet updateGoods(RetailscmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByWarehouse(RetailscmUserContext userContext,String warehouseId) throws Exception;
	public Object listPageByWarehouse(RetailscmUserContext userContext,String warehouseId, int start, int count) throws Exception;
  

}


