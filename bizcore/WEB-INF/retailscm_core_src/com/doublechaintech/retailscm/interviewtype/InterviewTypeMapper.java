package com.doublechaintech.retailscm.interviewtype;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class InterviewTypeMapper extends BaseRowMapper<InterviewType> {

  public static InterviewTypeMapper mapperForClass(Class<?> clazz) {

    InterviewTypeMapper mapperForOverride = new InterviewTypeMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected InterviewType internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    InterviewType interviewType = getInterviewType();

    setId(interviewType, rs, rowNumber);
    setCode(interviewType, rs, rowNumber);
    setCompany(interviewType, rs, rowNumber);
    setDescription(interviewType, rs, rowNumber);
    setDetailDescription(interviewType, rs, rowNumber);
    setVersion(interviewType, rs, rowNumber);

    return interviewType;
  }

  protected InterviewType getInterviewType() {
    if (null == clazz) {

      InterviewType entity = new InterviewType();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(InterviewType interviewType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(InterviewTypeTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      interviewType.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setCode(InterviewType interviewType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String code = rs.getString(InterviewTypeTable.COLUMN_CODE);

      if (code == null) {
        // do nothing when nothing found in database
        return;
      }

      interviewType.setCode(code);
    } catch (SQLException e) {

    }
  }

  protected void setCompany(InterviewType interviewType, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreCountryCenterId;
    try {
      retailStoreCountryCenterId = rs.getString(InterviewTypeTable.COLUMN_COMPANY);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreCountryCenterId == null) {
      return;
    }
    if (retailStoreCountryCenterId.isEmpty()) {
      return;
    }
    RetailStoreCountryCenter retailStoreCountryCenter = interviewType.getCompany();
    if (retailStoreCountryCenter != null) {
      // if the root object 'interviewType' already have the property, just set the id for it;
      retailStoreCountryCenter.setId(retailStoreCountryCenterId);

      return;
    }
    interviewType.setCompany(createEmptyCompany(retailStoreCountryCenterId));
  }

  protected void setDescription(InterviewType interviewType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String description = rs.getString(InterviewTypeTable.COLUMN_DESCRIPTION);

      if (description == null) {
        // do nothing when nothing found in database
        return;
      }

      interviewType.setDescription(description);
    } catch (SQLException e) {

    }
  }

  protected void setDetailDescription(InterviewType interviewType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String detailDescription = rs.getString(InterviewTypeTable.COLUMN_DETAIL_DESCRIPTION);

      if (detailDescription == null) {
        // do nothing when nothing found in database
        return;
      }

      interviewType.setDetailDescription(detailDescription);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(InterviewType interviewType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(InterviewTypeTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      interviewType.setVersion(version);
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
