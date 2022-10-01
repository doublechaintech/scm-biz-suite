package com.doublechaintech.retailscm.retailstoreopening;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreOpeningMapper extends BaseRowMapper<RetailStoreOpening> {

  public static RetailStoreOpeningMapper mapperForClass(Class<?> clazz) {

    RetailStoreOpeningMapper mapperForOverride = new RetailStoreOpeningMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected RetailStoreOpening internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    RetailStoreOpening retailStoreOpening = getRetailStoreOpening();

    setId(retailStoreOpening, rs, rowNumber);
    setComment(retailStoreOpening, rs, rowNumber);
    setVersion(retailStoreOpening, rs, rowNumber);

    return retailStoreOpening;
  }

  protected RetailStoreOpening getRetailStoreOpening() {
    if (null == clazz) {

      RetailStoreOpening entity = new RetailStoreOpening();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(RetailStoreOpening retailStoreOpening, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(RetailStoreOpeningTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOpening.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setComment(RetailStoreOpening retailStoreOpening, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String comment = rs.getString(RetailStoreOpeningTable.COLUMN_COMMENT);

      if (comment == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOpening.setComment(comment);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(RetailStoreOpening retailStoreOpening, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(RetailStoreOpeningTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreOpening.setVersion(version);
    } catch (SQLException e) {

    }
  }
}
