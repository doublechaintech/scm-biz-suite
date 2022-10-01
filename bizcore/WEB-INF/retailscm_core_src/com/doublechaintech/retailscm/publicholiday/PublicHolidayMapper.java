package com.doublechaintech.retailscm.publicholiday;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class PublicHolidayMapper extends BaseRowMapper<PublicHoliday> {

  public static PublicHolidayMapper mapperForClass(Class<?> clazz) {

    PublicHolidayMapper mapperForOverride = new PublicHolidayMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected PublicHoliday internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    PublicHoliday publicHoliday = getPublicHoliday();

    setId(publicHoliday, rs, rowNumber);
    setCode(publicHoliday, rs, rowNumber);
    setCompany(publicHoliday, rs, rowNumber);
    setName(publicHoliday, rs, rowNumber);
    setDescription(publicHoliday, rs, rowNumber);
    setVersion(publicHoliday, rs, rowNumber);

    return publicHoliday;
  }

  protected PublicHoliday getPublicHoliday() {
    if (null == clazz) {

      PublicHoliday entity = new PublicHoliday();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(PublicHoliday publicHoliday, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(PublicHolidayTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      publicHoliday.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setCode(PublicHoliday publicHoliday, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String code = rs.getString(PublicHolidayTable.COLUMN_CODE);

      if (code == null) {
        // do nothing when nothing found in database
        return;
      }

      publicHoliday.setCode(code);
    } catch (SQLException e) {

    }
  }

  protected void setCompany(PublicHoliday publicHoliday, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreCountryCenterId;
    try {
      retailStoreCountryCenterId = rs.getString(PublicHolidayTable.COLUMN_COMPANY);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreCountryCenterId == null) {
      return;
    }
    if (retailStoreCountryCenterId.isEmpty()) {
      return;
    }
    RetailStoreCountryCenter retailStoreCountryCenter = publicHoliday.getCompany();
    if (retailStoreCountryCenter != null) {
      // if the root object 'publicHoliday' already have the property, just set the id for it;
      retailStoreCountryCenter.setId(retailStoreCountryCenterId);

      return;
    }
    publicHoliday.setCompany(createEmptyCompany(retailStoreCountryCenterId));
  }

  protected void setName(PublicHoliday publicHoliday, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(PublicHolidayTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      publicHoliday.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setDescription(PublicHoliday publicHoliday, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String description = rs.getString(PublicHolidayTable.COLUMN_DESCRIPTION);

      if (description == null) {
        // do nothing when nothing found in database
        return;
      }

      publicHoliday.setDescription(description);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(PublicHoliday publicHoliday, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(PublicHolidayTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      publicHoliday.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected RetailStoreCountryCenter createEmptyCompany(String retailStoreCountryCenterId) {

    RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();

    retailStoreCountryCenter.setId(retailStoreCountryCenterId);
    retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
    return retailStoreCountryCenter;
  }
}
