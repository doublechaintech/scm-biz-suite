package com.doublechaintech.retailscm.receivingspace;

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

public interface ReceivingSpaceManager extends BaseManager {

  List<ReceivingSpace> searchReceivingSpaceList(
      RetailscmUserContext ctx, ReceivingSpaceRequest pRequest);

  ReceivingSpace searchReceivingSpace(RetailscmUserContext ctx, ReceivingSpaceRequest pRequest);

  public ReceivingSpace createReceivingSpace(
      RetailscmUserContext userContext,
      String location,
      String contactNumber,
      String description,
      String totalArea,
      String warehouseId,
      BigDecimal latitude,
      BigDecimal longitude)
      throws Exception;

  public ReceivingSpace updateReceivingSpace(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      int receivingSpaceVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public ReceivingSpace loadReceivingSpace(
      RetailscmUserContext userContext, String receivingSpaceId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public ReceivingSpace internalSaveReceivingSpace(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace) throws Exception;

  public ReceivingSpace internalSaveReceivingSpace(
      RetailscmUserContext userContext, ReceivingSpace receivingSpace, Map<String, Object> option)
      throws Exception;

  public ReceivingSpace transferToAnotherWarehouse(
      RetailscmUserContext userContext, String receivingSpaceId, String anotherWarehouseId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, ReceivingSpace newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, ReceivingSpace updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  GoodsManager getGoodsManager(RetailscmUserContext userContext, String receivingSpaceId,
  // String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String
  // goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String
  // retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws
  // Exception;

  public ReceivingSpace addGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String name,
      String rfid,
      String uom,
      int maxPackage,
      Date expireTime,
      String skuId,
      String goodsAllocationId,
      String smartPalletId,
      String shippingSpaceId,
      String transportTaskId,
      String retailStoreId,
      String bizOrderId,
      String retailStoreOrderId,
      String[] tokensExpr)
      throws Exception;

  public ReceivingSpace removeGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
      String goodsId,
      int goodsVersion,
      String[] tokensExpr)
      throws Exception;

  public ReceivingSpace updateGoods(
      RetailscmUserContext userContext,
      String receivingSpaceId,
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
