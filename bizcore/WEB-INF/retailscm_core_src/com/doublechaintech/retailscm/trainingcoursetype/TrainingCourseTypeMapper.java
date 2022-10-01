package com.doublechaintech.retailscm.trainingcoursetype;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class TrainingCourseTypeMapper extends BaseRowMapper<TrainingCourseType> {

  public static TrainingCourseTypeMapper mapperForClass(Class<?> clazz) {

    TrainingCourseTypeMapper mapperForOverride = new TrainingCourseTypeMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected TrainingCourseType internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    TrainingCourseType trainingCourseType = getTrainingCourseType();

    setId(trainingCourseType, rs, rowNumber);
    setCode(trainingCourseType, rs, rowNumber);
    setCompany(trainingCourseType, rs, rowNumber);
    setName(trainingCourseType, rs, rowNumber);
    setDescription(trainingCourseType, rs, rowNumber);
    setVersion(trainingCourseType, rs, rowNumber);

    return trainingCourseType;
  }

  protected TrainingCourseType getTrainingCourseType() {
    if (null == clazz) {

      TrainingCourseType entity = new TrainingCourseType();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(TrainingCourseType trainingCourseType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(TrainingCourseTypeTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      trainingCourseType.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setCode(TrainingCourseType trainingCourseType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String code = rs.getString(TrainingCourseTypeTable.COLUMN_CODE);

      if (code == null) {
        // do nothing when nothing found in database
        return;
      }

      trainingCourseType.setCode(code);
    } catch (SQLException e) {

    }
  }

  protected void setCompany(TrainingCourseType trainingCourseType, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreCountryCenterId;
    try {
      retailStoreCountryCenterId = rs.getString(TrainingCourseTypeTable.COLUMN_COMPANY);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreCountryCenterId == null) {
      return;
    }
    if (retailStoreCountryCenterId.isEmpty()) {
      return;
    }
    RetailStoreCountryCenter retailStoreCountryCenter = trainingCourseType.getCompany();
    if (retailStoreCountryCenter != null) {
      // if the root object 'trainingCourseType' already have the property, just set the id for it;
      retailStoreCountryCenter.setId(retailStoreCountryCenterId);

      return;
    }
    trainingCourseType.setCompany(createEmptyCompany(retailStoreCountryCenterId));
  }

  protected void setName(TrainingCourseType trainingCourseType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(TrainingCourseTypeTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      trainingCourseType.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setDescription(TrainingCourseType trainingCourseType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String description = rs.getString(TrainingCourseTypeTable.COLUMN_DESCRIPTION);

      if (description == null) {
        // do nothing when nothing found in database
        return;
      }

      trainingCourseType.setDescription(description);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(TrainingCourseType trainingCourseType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(TrainingCourseTypeTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      trainingCourseType.setVersion(version);
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
