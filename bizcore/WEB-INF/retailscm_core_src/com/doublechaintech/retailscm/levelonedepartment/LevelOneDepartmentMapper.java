package com.doublechaintech.retailscm.levelonedepartment;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class LevelOneDepartmentMapper extends BaseRowMapper<LevelOneDepartment> {

  public static LevelOneDepartmentMapper mapperForClass(Class<?> clazz) {

    LevelOneDepartmentMapper mapperForOverride = new LevelOneDepartmentMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected LevelOneDepartment internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    LevelOneDepartment levelOneDepartment = getLevelOneDepartment();

    setId(levelOneDepartment, rs, rowNumber);
    setBelongsTo(levelOneDepartment, rs, rowNumber);
    setName(levelOneDepartment, rs, rowNumber);
    setDescription(levelOneDepartment, rs, rowNumber);
    setManager(levelOneDepartment, rs, rowNumber);
    setFounded(levelOneDepartment, rs, rowNumber);
    setVersion(levelOneDepartment, rs, rowNumber);

    return levelOneDepartment;
  }

  protected LevelOneDepartment getLevelOneDepartment() {
    if (null == clazz) {

      LevelOneDepartment entity = new LevelOneDepartment();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(LevelOneDepartment levelOneDepartment, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(LevelOneDepartmentTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      levelOneDepartment.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setBelongsTo(LevelOneDepartment levelOneDepartment, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreCountryCenterId;
    try {
      retailStoreCountryCenterId = rs.getString(LevelOneDepartmentTable.COLUMN_BELONGS_TO);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreCountryCenterId == null) {
      return;
    }
    if (retailStoreCountryCenterId.isEmpty()) {
      return;
    }
    RetailStoreCountryCenter retailStoreCountryCenter = levelOneDepartment.getBelongsTo();
    if (retailStoreCountryCenter != null) {
      // if the root object 'levelOneDepartment' already have the property, just set the id for it;
      retailStoreCountryCenter.setId(retailStoreCountryCenterId);

      return;
    }
    levelOneDepartment.setBelongsTo(createEmptyBelongsTo(retailStoreCountryCenterId));
  }

  protected void setName(LevelOneDepartment levelOneDepartment, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(LevelOneDepartmentTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      levelOneDepartment.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setDescription(LevelOneDepartment levelOneDepartment, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String description = rs.getString(LevelOneDepartmentTable.COLUMN_DESCRIPTION);

      if (description == null) {
        // do nothing when nothing found in database
        return;
      }

      levelOneDepartment.setDescription(description);
    } catch (SQLException e) {

    }
  }

  protected void setManager(LevelOneDepartment levelOneDepartment, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String manager = rs.getString(LevelOneDepartmentTable.COLUMN_MANAGER);

      if (manager == null) {
        // do nothing when nothing found in database
        return;
      }

      levelOneDepartment.setManager(manager);
    } catch (SQLException e) {

    }
  }

  protected void setFounded(LevelOneDepartment levelOneDepartment, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date founded = rs.getDate(LevelOneDepartmentTable.COLUMN_FOUNDED);

      if (founded == null) {
        // do nothing when nothing found in database
        return;
      }

      levelOneDepartment.setFounded(founded);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(LevelOneDepartment levelOneDepartment, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(LevelOneDepartmentTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      levelOneDepartment.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected RetailStoreCountryCenter createEmptyBelongsTo(String retailStoreCountryCenterId) {

    RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();

    retailStoreCountryCenter.setId(retailStoreCountryCenterId);
    retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
    return retailStoreCountryCenter;
  }
}
