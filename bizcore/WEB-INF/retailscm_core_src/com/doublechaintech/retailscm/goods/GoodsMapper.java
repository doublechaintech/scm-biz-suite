package com.doublechaintech.retailscm.goods;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

public class GoodsMapper extends BaseRowMapper<Goods> {

  public static GoodsMapper mapperForClass(Class<?> clazz) {

    GoodsMapper mapperForOverride = new GoodsMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected Goods internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    Goods goods = getGoods();

    setId(goods, rs, rowNumber);
    setName(goods, rs, rowNumber);
    setRfid(goods, rs, rowNumber);
    setUom(goods, rs, rowNumber);
    setMaxPackage(goods, rs, rowNumber);
    setExpireTime(goods, rs, rowNumber);
    setSku(goods, rs, rowNumber);
    setReceivingSpace(goods, rs, rowNumber);
    setGoodsAllocation(goods, rs, rowNumber);
    setSmartPallet(goods, rs, rowNumber);
    setShippingSpace(goods, rs, rowNumber);
    setTransportTask(goods, rs, rowNumber);
    setRetailStore(goods, rs, rowNumber);
    setBizOrder(goods, rs, rowNumber);
    setRetailStoreOrder(goods, rs, rowNumber);
    setVersion(goods, rs, rowNumber);

    return goods;
  }

  protected Goods getGoods() {
    if (null == clazz) {

      Goods entity = new Goods();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(GoodsTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      goods.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(GoodsTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      goods.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setRfid(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String rfid = rs.getString(GoodsTable.COLUMN_RFID);

      if (rfid == null) {
        // do nothing when nothing found in database
        return;
      }

      goods.setRfid(rfid);
    } catch (SQLException e) {

    }
  }

  protected void setUom(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String uom = rs.getString(GoodsTable.COLUMN_UOM);

      if (uom == null) {
        // do nothing when nothing found in database
        return;
      }

      goods.setUom(uom);
    } catch (SQLException e) {

    }
  }

  protected void setMaxPackage(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer maxPackage = rs.getInt(GoodsTable.COLUMN_MAX_PACKAGE);

      if (maxPackage == null) {
        // do nothing when nothing found in database
        return;
      }

      goods.setMaxPackage(maxPackage);
    } catch (SQLException e) {

    }
  }

  protected void setExpireTime(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date expireTime = rs.getDate(GoodsTable.COLUMN_EXPIRE_TIME);

      if (expireTime == null) {
        // do nothing when nothing found in database
        return;
      }

      goods.setExpireTime(expireTime);
    } catch (SQLException e) {

    }
  }

  protected void setSku(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String skuId;
    try {
      skuId = rs.getString(GoodsTable.COLUMN_SKU);
    } catch (SQLException e) {
      return;
    }
    if (skuId == null) {
      return;
    }
    if (skuId.isEmpty()) {
      return;
    }
    Sku sku = goods.getSku();
    if (sku != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      sku.setId(skuId);

      return;
    }
    goods.setSku(createEmptySku(skuId));
  }

  protected void setReceivingSpace(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String receivingSpaceId;
    try {
      receivingSpaceId = rs.getString(GoodsTable.COLUMN_RECEIVING_SPACE);
    } catch (SQLException e) {
      return;
    }
    if (receivingSpaceId == null) {
      return;
    }
    if (receivingSpaceId.isEmpty()) {
      return;
    }
    ReceivingSpace receivingSpace = goods.getReceivingSpace();
    if (receivingSpace != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      receivingSpace.setId(receivingSpaceId);

      return;
    }
    goods.setReceivingSpace(createEmptyReceivingSpace(receivingSpaceId));
  }

  protected void setGoodsAllocation(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String goodsAllocationId;
    try {
      goodsAllocationId = rs.getString(GoodsTable.COLUMN_GOODS_ALLOCATION);
    } catch (SQLException e) {
      return;
    }
    if (goodsAllocationId == null) {
      return;
    }
    if (goodsAllocationId.isEmpty()) {
      return;
    }
    GoodsAllocation goodsAllocation = goods.getGoodsAllocation();
    if (goodsAllocation != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      goodsAllocation.setId(goodsAllocationId);

      return;
    }
    goods.setGoodsAllocation(createEmptyGoodsAllocation(goodsAllocationId));
  }

  protected void setSmartPallet(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String smartPalletId;
    try {
      smartPalletId = rs.getString(GoodsTable.COLUMN_SMART_PALLET);
    } catch (SQLException e) {
      return;
    }
    if (smartPalletId == null) {
      return;
    }
    if (smartPalletId.isEmpty()) {
      return;
    }
    SmartPallet smartPallet = goods.getSmartPallet();
    if (smartPallet != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      smartPallet.setId(smartPalletId);

      return;
    }
    goods.setSmartPallet(createEmptySmartPallet(smartPalletId));
  }

  protected void setShippingSpace(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String shippingSpaceId;
    try {
      shippingSpaceId = rs.getString(GoodsTable.COLUMN_SHIPPING_SPACE);
    } catch (SQLException e) {
      return;
    }
    if (shippingSpaceId == null) {
      return;
    }
    if (shippingSpaceId.isEmpty()) {
      return;
    }
    ShippingSpace shippingSpace = goods.getShippingSpace();
    if (shippingSpace != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      shippingSpace.setId(shippingSpaceId);

      return;
    }
    goods.setShippingSpace(createEmptyShippingSpace(shippingSpaceId));
  }

  protected void setTransportTask(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String transportTaskId;
    try {
      transportTaskId = rs.getString(GoodsTable.COLUMN_TRANSPORT_TASK);
    } catch (SQLException e) {
      return;
    }
    if (transportTaskId == null) {
      return;
    }
    if (transportTaskId.isEmpty()) {
      return;
    }
    TransportTask transportTask = goods.getTransportTask();
    if (transportTask != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      transportTask.setId(transportTaskId);

      return;
    }
    goods.setTransportTask(createEmptyTransportTask(transportTaskId));
  }

  protected void setRetailStore(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String retailStoreId;
    try {
      retailStoreId = rs.getString(GoodsTable.COLUMN_RETAIL_STORE);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreId == null) {
      return;
    }
    if (retailStoreId.isEmpty()) {
      return;
    }
    RetailStore retailStore = goods.getRetailStore();
    if (retailStore != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      retailStore.setId(retailStoreId);

      return;
    }
    goods.setRetailStore(createEmptyRetailStore(retailStoreId));
  }

  protected void setBizOrder(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String supplyOrderId;
    try {
      supplyOrderId = rs.getString(GoodsTable.COLUMN_BIZ_ORDER);
    } catch (SQLException e) {
      return;
    }
    if (supplyOrderId == null) {
      return;
    }
    if (supplyOrderId.isEmpty()) {
      return;
    }
    SupplyOrder supplyOrder = goods.getBizOrder();
    if (supplyOrder != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      supplyOrder.setId(supplyOrderId);

      return;
    }
    goods.setBizOrder(createEmptyBizOrder(supplyOrderId));
  }

  protected void setRetailStoreOrder(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    String retailStoreOrderId;
    try {
      retailStoreOrderId = rs.getString(GoodsTable.COLUMN_RETAIL_STORE_ORDER);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreOrderId == null) {
      return;
    }
    if (retailStoreOrderId.isEmpty()) {
      return;
    }
    RetailStoreOrder retailStoreOrder = goods.getRetailStoreOrder();
    if (retailStoreOrder != null) {
      // if the root object 'goods' already have the property, just set the id for it;
      retailStoreOrder.setId(retailStoreOrderId);

      return;
    }
    goods.setRetailStoreOrder(createEmptyRetailStoreOrder(retailStoreOrderId));
  }

  protected void setVersion(Goods goods, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(GoodsTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      goods.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected Sku createEmptySku(String skuId) {

    Sku sku = new Sku();

    sku.setId(skuId);
    sku.setVersion(Integer.MAX_VALUE);
    return sku;
  }

  protected ReceivingSpace createEmptyReceivingSpace(String receivingSpaceId) {

    ReceivingSpace receivingSpace = new ReceivingSpace();

    receivingSpace.setId(receivingSpaceId);
    receivingSpace.setVersion(Integer.MAX_VALUE);
    return receivingSpace;
  }

  protected GoodsAllocation createEmptyGoodsAllocation(String goodsAllocationId) {

    GoodsAllocation goodsAllocation = new GoodsAllocation();

    goodsAllocation.setId(goodsAllocationId);
    goodsAllocation.setVersion(Integer.MAX_VALUE);
    return goodsAllocation;
  }

  protected SmartPallet createEmptySmartPallet(String smartPalletId) {

    SmartPallet smartPallet = new SmartPallet();

    smartPallet.setId(smartPalletId);
    smartPallet.setVersion(Integer.MAX_VALUE);
    return smartPallet;
  }

  protected ShippingSpace createEmptyShippingSpace(String shippingSpaceId) {

    ShippingSpace shippingSpace = new ShippingSpace();

    shippingSpace.setId(shippingSpaceId);
    shippingSpace.setVersion(Integer.MAX_VALUE);
    return shippingSpace;
  }

  protected TransportTask createEmptyTransportTask(String transportTaskId) {

    TransportTask transportTask = new TransportTask();

    transportTask.setId(transportTaskId);
    transportTask.setVersion(Integer.MAX_VALUE);
    return transportTask;
  }

  protected RetailStore createEmptyRetailStore(String retailStoreId) {

    RetailStore retailStore = new RetailStore();

    retailStore.setId(retailStoreId);
    retailStore.setVersion(Integer.MAX_VALUE);
    return retailStore;
  }

  protected SupplyOrder createEmptyBizOrder(String supplyOrderId) {

    SupplyOrder supplyOrder = new SupplyOrder();

    supplyOrder.setId(supplyOrderId);
    supplyOrder.setVersion(Integer.MAX_VALUE);
    return supplyOrder;
  }

  protected RetailStoreOrder createEmptyRetailStoreOrder(String retailStoreOrderId) {

    RetailStoreOrder retailStoreOrder = new RetailStoreOrder();

    retailStoreOrder.setId(retailStoreOrderId);
    retailStoreOrder.setVersion(Integer.MAX_VALUE);
    return retailStoreOrder;
  }
}
