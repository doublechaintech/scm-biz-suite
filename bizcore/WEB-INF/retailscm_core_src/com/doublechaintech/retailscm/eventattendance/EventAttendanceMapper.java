package com.doublechaintech.retailscm.eventattendance;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;

public class EventAttendanceMapper extends BaseRowMapper<EventAttendance> {

  public static EventAttendanceMapper mapperForClass(Class<?> clazz) {

    EventAttendanceMapper mapperForOverride = new EventAttendanceMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected EventAttendance internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    EventAttendance eventAttendance = getEventAttendance();

    setId(eventAttendance, rs, rowNumber);
    setName(eventAttendance, rs, rowNumber);
    setPotentialCustomer(eventAttendance, rs, rowNumber);
    setCityEvent(eventAttendance, rs, rowNumber);
    setDescription(eventAttendance, rs, rowNumber);
    setVersion(eventAttendance, rs, rowNumber);

    return eventAttendance;
  }

  protected EventAttendance getEventAttendance() {
    if (null == clazz) {

      EventAttendance entity = new EventAttendance();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(EventAttendance eventAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(EventAttendanceTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      eventAttendance.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(EventAttendance eventAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(EventAttendanceTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      eventAttendance.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setPotentialCustomer(EventAttendance eventAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    String potentialCustomerId;
    try {
      potentialCustomerId = rs.getString(EventAttendanceTable.COLUMN_POTENTIAL_CUSTOMER);
    } catch (SQLException e) {
      return;
    }
    if (potentialCustomerId == null) {
      return;
    }
    if (potentialCustomerId.isEmpty()) {
      return;
    }
    PotentialCustomer potentialCustomer = eventAttendance.getPotentialCustomer();
    if (potentialCustomer != null) {
      // if the root object 'eventAttendance' already have the property, just set the id for it;
      potentialCustomer.setId(potentialCustomerId);

      return;
    }
    eventAttendance.setPotentialCustomer(createEmptyPotentialCustomer(potentialCustomerId));
  }

  protected void setCityEvent(EventAttendance eventAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    String cityEventId;
    try {
      cityEventId = rs.getString(EventAttendanceTable.COLUMN_CITY_EVENT);
    } catch (SQLException e) {
      return;
    }
    if (cityEventId == null) {
      return;
    }
    if (cityEventId.isEmpty()) {
      return;
    }
    CityEvent cityEvent = eventAttendance.getCityEvent();
    if (cityEvent != null) {
      // if the root object 'eventAttendance' already have the property, just set the id for it;
      cityEvent.setId(cityEventId);

      return;
    }
    eventAttendance.setCityEvent(createEmptyCityEvent(cityEventId));
  }

  protected void setDescription(EventAttendance eventAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String description = rs.getString(EventAttendanceTable.COLUMN_DESCRIPTION);

      if (description == null) {
        // do nothing when nothing found in database
        return;
      }

      eventAttendance.setDescription(description);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(EventAttendance eventAttendance, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(EventAttendanceTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      eventAttendance.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected PotentialCustomer createEmptyPotentialCustomer(String potentialCustomerId) {

    PotentialCustomer potentialCustomer = new PotentialCustomer();

    potentialCustomer.setId(potentialCustomerId);
    potentialCustomer.setVersion(Integer.MAX_VALUE);
    return potentialCustomer;
  }

  protected CityEvent createEmptyCityEvent(String cityEventId) {

    CityEvent cityEvent = new CityEvent();

    cityEvent.setId(cityEventId);
    cityEvent.setVersion(Integer.MAX_VALUE);
    return cityEvent;
  }
}
