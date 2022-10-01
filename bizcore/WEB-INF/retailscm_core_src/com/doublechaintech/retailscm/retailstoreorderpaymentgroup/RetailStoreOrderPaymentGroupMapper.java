package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

public class RetailStoreOrderPaymentGroupMapper
    extends BaseRowMapper<RetailStoreOrderPaymentGroup> {

  public static RetailStoreOrderPaymentGroupMapper mapperForClass(Class<?> clazz) {

    RetailStoreOrderPaymentGroupMapper mapperForOverride = new RetailStoreOrderPaymentGroupMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected RetailStoreOrderPaymentGroup internalMapRow(ResultSet rs, int rowNumber)
      throws SQLException {
    RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = getRetailStoreOrderPaymentGroup();

    setId(retailStoreOrderPaymentGroup, rs, rowNumber);
    setName(retailStoreOrderPaymentGroup, rs, rowNumber);
    setBizOrder(retailStoreOrderPaymentGroup, rs, rowNumber);
    setCardNumber(retailStoreOrderPaymentGroup, rs, rowNumber);
    setVersion(retailStoreOrderPaymentGroup, rs, rowNumber);

    return retailStoreOrderPaymentGroup;
  }

  protected RetailStoreOrderPaymentGroup getRetailStoreOrderPaymentGroup() {
    if (null == clazz) {

      RetailStoreOrderPaymentGroup entity = new RetailStoreOrderPaymentGroup();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(
      RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(RetailStoreOrderPaymentGroupTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderPaymentGroup.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(
      RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(RetailStoreOrderPaymentGroupTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderPaymentGroup.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setBizOrder(
      RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreOrderId;
    try {
      retailStoreOrderId = rs.getString(RetailStoreOrderPaymentGroupTable.COLUMN_BIZ_ORDER);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreOrderId == null) {
      return;
    }
    if (retailStoreOrderId.isEmpty()) {
      return;
    }
    RetailStoreOrder retailStoreOrder = retailStoreOrderPaymentGroup.getBizOrder();
    if (retailStoreOrder != null) {
      // if the root object 'retailStoreOrderPaymentGroup' already have the property, just set the
      // id for it;
      retailStoreOrder.setId(retailStoreOrderId);

      return;
    }
    retailStoreOrderPaymentGroup.setBizOrder(createEmptyBizOrder(retailStoreOrderId));
  }

  protected void setCardNumber(
      RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String cardNumber = rs.getString(RetailStoreOrderPaymentGroupTable.COLUMN_CARD_NUMBER);

      if (cardNumber == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderPaymentGroup.setCardNumber(cardNumber);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(
      RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(RetailStoreOrderPaymentGroupTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOrderPaymentGroup.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected RetailStoreOrder createEmptyBizOrder(String retailStoreOrderId) {

    RetailStoreOrder retailStoreOrder = new RetailStoreOrder();

    retailStoreOrder.setId(retailStoreOrderId);
    retailStoreOrder.setVersion(Integer.MAX_VALUE);
    return retailStoreOrder;
  }
}
