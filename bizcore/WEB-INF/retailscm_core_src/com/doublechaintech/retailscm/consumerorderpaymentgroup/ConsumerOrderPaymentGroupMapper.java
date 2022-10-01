package com.doublechaintech.retailscm.consumerorderpaymentgroup;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

public class ConsumerOrderPaymentGroupMapper extends BaseRowMapper<ConsumerOrderPaymentGroup> {

  public static ConsumerOrderPaymentGroupMapper mapperForClass(Class<?> clazz) {

    ConsumerOrderPaymentGroupMapper mapperForOverride = new ConsumerOrderPaymentGroupMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected ConsumerOrderPaymentGroup internalMapRow(ResultSet rs, int rowNumber)
      throws SQLException {
    ConsumerOrderPaymentGroup consumerOrderPaymentGroup = getConsumerOrderPaymentGroup();

    setId(consumerOrderPaymentGroup, rs, rowNumber);
    setName(consumerOrderPaymentGroup, rs, rowNumber);
    setBizOrder(consumerOrderPaymentGroup, rs, rowNumber);
    setCardNumber(consumerOrderPaymentGroup, rs, rowNumber);
    setVersion(consumerOrderPaymentGroup, rs, rowNumber);

    return consumerOrderPaymentGroup;
  }

  protected ConsumerOrderPaymentGroup getConsumerOrderPaymentGroup() {
    if (null == clazz) {

      ConsumerOrderPaymentGroup entity = new ConsumerOrderPaymentGroup();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(ConsumerOrderPaymentGroupTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      consumerOrderPaymentGroup.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(ConsumerOrderPaymentGroupTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      consumerOrderPaymentGroup.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setBizOrder(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    String consumerOrderId;
    try {
      consumerOrderId = rs.getString(ConsumerOrderPaymentGroupTable.COLUMN_BIZ_ORDER);
    } catch (SQLException e) {
      return;
    }
    if (consumerOrderId == null) {
      return;
    }
    if (consumerOrderId.isEmpty()) {
      return;
    }
    ConsumerOrder consumerOrder = consumerOrderPaymentGroup.getBizOrder();
    if (consumerOrder != null) {
      // if the root object 'consumerOrderPaymentGroup' already have the property, just set the id
      // for it;
      consumerOrder.setId(consumerOrderId);

      return;
    }
    consumerOrderPaymentGroup.setBizOrder(createEmptyBizOrder(consumerOrderId));
  }

  protected void setCardNumber(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String cardNumber = rs.getString(ConsumerOrderPaymentGroupTable.COLUMN_CARD_NUMBER);

      if (cardNumber == null) {
        // do nothing when nothing found in database
        return;
      }

      consumerOrderPaymentGroup.setCardNumber(cardNumber);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(
      ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(ConsumerOrderPaymentGroupTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      consumerOrderPaymentGroup.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected ConsumerOrder createEmptyBizOrder(String consumerOrderId) {

    ConsumerOrder consumerOrder = new ConsumerOrder();

    consumerOrder.setId(consumerOrderId);
    consumerOrder.setVersion(Integer.MAX_VALUE);
    return consumerOrder;
  }
}
