package com.doublechaintech.retailscm.potentialcustomercontact;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;

public class PotentialCustomerContactMapper extends BaseRowMapper<PotentialCustomerContact> {

  public static PotentialCustomerContactMapper mapperForClass(Class<?> clazz) {

    PotentialCustomerContactMapper mapperForOverride = new PotentialCustomerContactMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected PotentialCustomerContact internalMapRow(ResultSet rs, int rowNumber)
      throws SQLException {
    PotentialCustomerContact potentialCustomerContact = getPotentialCustomerContact();

    setId(potentialCustomerContact, rs, rowNumber);
    setName(potentialCustomerContact, rs, rowNumber);
    setContactDate(potentialCustomerContact, rs, rowNumber);
    setContactMethod(potentialCustomerContact, rs, rowNumber);
    setPotentialCustomer(potentialCustomerContact, rs, rowNumber);
    setCityPartner(potentialCustomerContact, rs, rowNumber);
    setContactTo(potentialCustomerContact, rs, rowNumber);
    setDescription(potentialCustomerContact, rs, rowNumber);
    setLastUpdateTime(potentialCustomerContact, rs, rowNumber);
    setVersion(potentialCustomerContact, rs, rowNumber);

    return potentialCustomerContact;
  }

  protected PotentialCustomerContact getPotentialCustomerContact() {
    if (null == clazz) {

      PotentialCustomerContact entity = new PotentialCustomerContact();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(PotentialCustomerContactTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      potentialCustomerContact.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(PotentialCustomerContactTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      potentialCustomerContact.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setContactDate(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date contactDate = rs.getDate(PotentialCustomerContactTable.COLUMN_CONTACT_DATE);

      if (contactDate == null) {
        // do nothing when nothing found in database
        return;
      }

      potentialCustomerContact.setContactDate(contactDate);
    } catch (SQLException e) {

    }
  }

  protected void setContactMethod(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String contactMethod = rs.getString(PotentialCustomerContactTable.COLUMN_CONTACT_METHOD);

      if (contactMethod == null) {
        // do nothing when nothing found in database
        return;
      }

      potentialCustomerContact.setContactMethod(contactMethod);
    } catch (SQLException e) {

    }
  }

  protected void setPotentialCustomer(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    String potentialCustomerId;
    try {
      potentialCustomerId = rs.getString(PotentialCustomerContactTable.COLUMN_POTENTIAL_CUSTOMER);
    } catch (SQLException e) {
      return;
    }
    if (potentialCustomerId == null) {
      return;
    }
    if (potentialCustomerId.isEmpty()) {
      return;
    }
    PotentialCustomer potentialCustomer = potentialCustomerContact.getPotentialCustomer();
    if (potentialCustomer != null) {
      // if the root object 'potentialCustomerContact' already have the property, just set the id
      // for it;
      potentialCustomer.setId(potentialCustomerId);

      return;
    }
    potentialCustomerContact.setPotentialCustomer(
        createEmptyPotentialCustomer(potentialCustomerId));
  }

  protected void setCityPartner(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    String cityPartnerId;
    try {
      cityPartnerId = rs.getString(PotentialCustomerContactTable.COLUMN_CITY_PARTNER);
    } catch (SQLException e) {
      return;
    }
    if (cityPartnerId == null) {
      return;
    }
    if (cityPartnerId.isEmpty()) {
      return;
    }
    CityPartner cityPartner = potentialCustomerContact.getCityPartner();
    if (cityPartner != null) {
      // if the root object 'potentialCustomerContact' already have the property, just set the id
      // for it;
      cityPartner.setId(cityPartnerId);

      return;
    }
    potentialCustomerContact.setCityPartner(createEmptyCityPartner(cityPartnerId));
  }

  protected void setContactTo(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    String potentialCustomerContactPersonId;
    try {
      potentialCustomerContactPersonId =
          rs.getString(PotentialCustomerContactTable.COLUMN_CONTACT_TO);
    } catch (SQLException e) {
      return;
    }
    if (potentialCustomerContactPersonId == null) {
      return;
    }
    if (potentialCustomerContactPersonId.isEmpty()) {
      return;
    }
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        potentialCustomerContact.getContactTo();
    if (potentialCustomerContactPerson != null) {
      // if the root object 'potentialCustomerContact' already have the property, just set the id
      // for it;
      potentialCustomerContactPerson.setId(potentialCustomerContactPersonId);

      return;
    }
    potentialCustomerContact.setContactTo(createEmptyContactTo(potentialCustomerContactPersonId));
  }

  protected void setDescription(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String description = rs.getString(PotentialCustomerContactTable.COLUMN_DESCRIPTION);

      if (description == null) {
        // do nothing when nothing found in database
        return;
      }

      potentialCustomerContact.setDescription(description);
    } catch (SQLException e) {

    }
  }

  protected void setLastUpdateTime(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date lastUpdateTime = rs.getTimestamp(PotentialCustomerContactTable.COLUMN_LAST_UPDATE_TIME);

      if (lastUpdateTime == null) {
        // do nothing when nothing found in database
        return;
      }

      potentialCustomerContact.setLastUpdateTime(convertToDateTime(lastUpdateTime));
    } catch (SQLException e) {

    }
  }

  protected void setVersion(
      PotentialCustomerContact potentialCustomerContact, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(PotentialCustomerContactTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      potentialCustomerContact.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected PotentialCustomer createEmptyPotentialCustomer(String potentialCustomerId) {

    PotentialCustomer potentialCustomer = new PotentialCustomer();

    potentialCustomer.setId(potentialCustomerId);
    potentialCustomer.setVersion(Integer.MAX_VALUE);
    return potentialCustomer;
  }

  protected CityPartner createEmptyCityPartner(String cityPartnerId) {

    CityPartner cityPartner = new CityPartner();

    cityPartner.setId(cityPartnerId);
    cityPartner.setVersion(Integer.MAX_VALUE);
    return cityPartner;
  }

  protected PotentialCustomerContactPerson createEmptyContactTo(
      String potentialCustomerContactPersonId) {

    PotentialCustomerContactPerson potentialCustomerContactPerson =
        new PotentialCustomerContactPerson();

    potentialCustomerContactPerson.setId(potentialCustomerContactPersonId);
    potentialCustomerContactPerson.setVersion(Integer.MAX_VALUE);
    return potentialCustomerContactPerson;
  }
}
