package com.doublechaintech.retailscm.consumerorder;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstore.RetailStore;

public class ConsumerOrderMapper extends BaseRowMapper<ConsumerOrder> {

  public static ConsumerOrderMapper mapperForClass(Class<?> clazz) {

    ConsumerOrderMapper mapperForOverride = new ConsumerOrderMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected ConsumerOrder internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    ConsumerOrder consumerOrder = getConsumerOrder();

    setId(consumerOrder, rs, rowNumber);
    setTitle(consumerOrder, rs, rowNumber);
    setConsumer(consumerOrder, rs, rowNumber);
    setStore(consumerOrder, rs, rowNumber);
    setLastUpdateTime(consumerOrder, rs, rowNumber);
    setVersion(consumerOrder, rs, rowNumber);

    return consumerOrder;
  }

  protected ConsumerOrder getConsumerOrder() {
    if (null == clazz) {

      ConsumerOrder entity = new ConsumerOrder();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(ConsumerOrderTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      consumerOrder.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setTitle(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String title = rs.getString(ConsumerOrderTable.COLUMN_TITLE);

      if (title == null) {
        // do nothing when nothing found in database
        return;
      }

      consumerOrder.setTitle(title);
    } catch (SQLException e) {

    }
  }

  protected void setConsumer(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreMemberId;
    try {
      retailStoreMemberId = rs.getString(ConsumerOrderTable.COLUMN_CONSUMER);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreMemberId == null) {
      return;
    }
    if (retailStoreMemberId.isEmpty()) {
      return;
    }
    RetailStoreMember retailStoreMember = consumerOrder.getConsumer();
    if (retailStoreMember != null) {
      // if the root object 'consumerOrder' already have the property, just set the id for it;
      retailStoreMember.setId(retailStoreMemberId);

      return;
    }
    consumerOrder.setConsumer(createEmptyConsumer(retailStoreMemberId));
  }

  protected void setStore(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreId;
    try {
      retailStoreId = rs.getString(ConsumerOrderTable.COLUMN_STORE);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreId == null) {
      return;
    }
    if (retailStoreId.isEmpty()) {
      return;
    }
    RetailStore retailStore = consumerOrder.getStore();
    if (retailStore != null) {
      // if the root object 'consumerOrder' already have the property, just set the id for it;
      retailStore.setId(retailStoreId);

      return;
    }
    consumerOrder.setStore(createEmptyStore(retailStoreId));
  }

  protected void setLastUpdateTime(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date lastUpdateTime = rs.getTimestamp(ConsumerOrderTable.COLUMN_LAST_UPDATE_TIME);

      if (lastUpdateTime == null) {
        // do nothing when nothing found in database
        return;
      }

      consumerOrder.setLastUpdateTime(convertToDateTime(lastUpdateTime));
    } catch (SQLException e) {

    }
  }

  protected void setVersion(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(ConsumerOrderTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      consumerOrder.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected RetailStoreMember createEmptyConsumer(String retailStoreMemberId) {

    RetailStoreMember retailStoreMember = new RetailStoreMember();

    retailStoreMember.setId(retailStoreMemberId);
    retailStoreMember.setVersion(Integer.MAX_VALUE);
    return retailStoreMember;
  }

  protected RetailStore createEmptyStore(String retailStoreId) {

    RetailStore retailStore = new RetailStore();

    retailStore.setId(retailStoreId);
    retailStore.setVersion(Integer.MAX_VALUE);
    return retailStore;
  }
}
