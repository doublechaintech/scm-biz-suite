package com.doublechaintech.retailscm.shippingspace;

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

public interface ShippingSpaceManager extends BaseManager {

  List<ShippingSpace> searchShippingSpaceList(
      RetailscmUserContext ctx, ShippingSpaceRequest pRequest);

  ShippingSpace searchShippingSpace(RetailscmUserContext ctx, ShippingSpaceRequest pRequest);

  public ShippingSpace createShippingSpace(
      RetailscmUserContext userContext,
      String location,
      String contactNumber,
      String totalArea,
      String warehouseId,
      BigDecimal latitude,
      BigDecimal longitude,
      String description)
      throws Exception;

  public ShippingSpace updateShippingSpace(
      RetailscmUserContext userContext,
      String shippingSpaceId,
      int shippingSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public ShippingSpace loadShippingSpace(
      RetailscmUserContext userContext, String shippingSpaceId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public ShippingSpace internalSaveShippingSpace(
      RetailscmUserContext userContext, ShippingSpace shippingSpace) throws Exception;

  public ShippingSpace internalSaveShippingSpace(
      RetailscmUserContext userContext, ShippingSpace shippingSpace, Map<String, Object> option)
      throws Exception;

  public ShippingSpace transferToAnotherWarehouse(
      RetailscmUserContext userContext, String shippingSpaceId, String anotherWarehouseId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, ShippingSpace newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, ShippingSpace updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String shippingSpaceId,
  // String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String
  // receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId,
  // String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)
  // throws Exception;

  public ShippingSpace addGoods(
      RetailscmUserContext userContext,
      String shippingSpaceId,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String skuId,
      String receivingSpaceId,
      String goodsAllocationId,
      String smartPalletId,
      String transportTaskId,
      String retailStoreId,
      String bizOrderId,
      String retailStoreOrderId,
      String[] tokensExpr)
      throws Exception;

  public ShippingSpace removeGoods(
      RetailscmUserContext userContext,
      String shippingSpaceId,
      String goodsId,
      int goodsVersion,
      String[] tokensExpr)
      throws Exception;

  public ShippingSpace updateGoods(
      RetailscmUserContext userContext,
      String shippingSpaceId,
      String goodsId,
      int goodsVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByWarehouse(RetailscmUserContext userContext, String warehouseId)
      throws Exception;

  public Object listPageByWarehouse(
      RetailscmUserContext userContext, String warehouseId, int start, int count) throws Exception;
}
