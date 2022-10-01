package com.doublechaintech.retailscm.transporttasktrack;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.transporttask.TransportTask;

public class TransportTaskTrackMapper extends BaseRowMapper<TransportTaskTrack> {

  public static TransportTaskTrackMapper mapperForClass(Class<?> clazz) {

    TransportTaskTrackMapper mapperForOverride = new TransportTaskTrackMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected TransportTaskTrack internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    TransportTaskTrack transportTaskTrack = getTransportTaskTrack();

    setId(transportTaskTrack, rs, rowNumber);
    setTrackTime(transportTaskTrack, rs, rowNumber);
    setLatitude(transportTaskTrack, rs, rowNumber);
    setLongitude(transportTaskTrack, rs, rowNumber);
    setMovement(transportTaskTrack, rs, rowNumber);
    setVersion(transportTaskTrack, rs, rowNumber);

    return transportTaskTrack;
  }

  protected TransportTaskTrack getTransportTaskTrack() {
    if (null == clazz) {

      TransportTaskTrack entity = new TransportTaskTrack();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(TransportTaskTrackTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      transportTaskTrack.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setTrackTime(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date trackTime = rs.getDate(TransportTaskTrackTable.COLUMN_TRACK_TIME);

      if (trackTime == null) {
        // do nothing when nothing found in database
        return;
      }

      transportTaskTrack.setTrackTime(trackTime);
    } catch (SQLException e) {

    }
  }

  protected void setLatitude(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      BigDecimal latitude = rs.getBigDecimal(TransportTaskTrackTable.COLUMN_LATITUDE);

      if (latitude == null) {
        // do nothing when nothing found in database
        return;
      }

      transportTaskTrack.setLatitude(latitude);
    } catch (SQLException e) {

    }
  }

  protected void setLongitude(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      BigDecimal longitude = rs.getBigDecimal(TransportTaskTrackTable.COLUMN_LONGITUDE);

      if (longitude == null) {
        // do nothing when nothing found in database
        return;
      }

      transportTaskTrack.setLongitude(longitude);
    } catch (SQLException e) {

    }
  }

  protected void setMovement(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber)
      throws SQLException {
    String transportTaskId;
    try {
      transportTaskId = rs.getString(TransportTaskTrackTable.COLUMN_MOVEMENT);
    } catch (SQLException e) {
      return;
    }
    if (transportTaskId == null) {
      return;
    }
    if (transportTaskId.isEmpty()) {
      return;
    }
    TransportTask transportTask = transportTaskTrack.getMovement();
    if (transportTask != null) {
      // if the root object 'transportTaskTrack' already have the property, just set the id for it;
      transportTask.setId(transportTaskId);

      return;
    }
    transportTaskTrack.setMovement(createEmptyMovement(transportTaskId));
  }

  protected void setVersion(TransportTaskTrack transportTaskTrack, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(TransportTaskTrackTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      transportTaskTrack.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected TransportTask createEmptyMovement(String transportTaskId) {

    TransportTask transportTask = new TransportTask();

    transportTask.setId(transportTaskId);
    transportTask.setVersion(Integer.MAX_VALUE);
    return transportTask;
  }
}
