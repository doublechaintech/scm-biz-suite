package com.doublechaintech.retailscm.leavetype;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class LeaveTypeMapper extends BaseRowMapper<LeaveType> {

  public static LeaveTypeMapper mapperForClass(Class<?> clazz) {

    LeaveTypeMapper mapperForOverride = new LeaveTypeMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected LeaveType internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    LeaveType leaveType = getLeaveType();

    setId(leaveType, rs, rowNumber);
    setCode(leaveType, rs, rowNumber);
    setCompany(leaveType, rs, rowNumber);
    setDescription(leaveType, rs, rowNumber);
    setDetailDescription(leaveType, rs, rowNumber);
    setVersion(leaveType, rs, rowNumber);

    return leaveType;
  }

  protected LeaveType getLeaveType() {
    if (null == clazz) {

      LeaveType entity = new LeaveType();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(LeaveType leaveType, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(LeaveTypeTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      leaveType.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setCode(LeaveType leaveType, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String code = rs.getString(LeaveTypeTable.COLUMN_CODE);

      if (code == null) {
        // do nothing when nothing found in database
        return;
      }

      leaveType.setCode(code);
    } catch (SQLException e) {

    }
  }

  protected void setCompany(LeaveType leaveType, ResultSet rs, int rowNumber) throws SQLException {
    String retailStoreCountryCenterId;
    try {
      retailStoreCountryCenterId = rs.getString(LeaveTypeTable.COLUMN_COMPANY);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreCountryCenterId == null) {
      return;
    }
    if (retailStoreCountryCenterId.isEmpty()) {
      return;
    }
    RetailStoreCountryCenter retailStoreCountryCenter = leaveType.getCompany();
    if (retailStoreCountryCenter != null) {
      // if the root object 'leaveType' already have the property, just set the id for it;
      retailStoreCountryCenter.setId(retailStoreCountryCenterId);

      return;
    }
    leaveType.setCompany(createEmptyCompany(retailStoreCountryCenterId));
  }

  protected void setDescription(LeaveType leaveType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String description = rs.getString(LeaveTypeTable.COLUMN_DESCRIPTION);

      if (description == null) {
        // do nothing when nothing found in database
        return;
      }

      leaveType.setDescription(description);
    } catch (SQLException e) {

    }
  }

  protected void setDetailDescription(LeaveType leaveType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String detailDescription = rs.getString(LeaveTypeTable.COLUMN_DETAIL_DESCRIPTION);

      if (detailDescription == null) {
        // do nothing when nothing found in database
        return;
      }

      leaveType.setDetailDescription(detailDescription);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(LeaveType leaveType, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(LeaveTypeTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      leaveType.setVersion(version);
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
