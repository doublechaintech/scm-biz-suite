package com.doublechaintech.retailscm.mobileapp;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class MobileAppMapper extends BaseRowMapper<MobileApp> {

  public static MobileAppMapper mapperForClass(Class<?> clazz) {

    MobileAppMapper mapperForOverride = new MobileAppMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected MobileApp internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    MobileApp mobileApp = getMobileApp();

    setId(mobileApp, rs, rowNumber);
    setName(mobileApp, rs, rowNumber);
    setVersion(mobileApp, rs, rowNumber);

    return mobileApp;
  }

  protected MobileApp getMobileApp() {
    if (null == clazz) {

      MobileApp entity = new MobileApp();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(MobileApp mobileApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(MobileAppTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      mobileApp.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(MobileApp mobileApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(MobileAppTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      mobileApp.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(MobileApp mobileApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(MobileAppTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      mobileApp.setVersion(version);
    } catch (SQLException e) {

    }
  }
}
