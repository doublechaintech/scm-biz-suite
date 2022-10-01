package com.doublechaintech.retailscm.publickeytype;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.userdomain.UserDomain;

public class PublicKeyTypeMapper extends BaseRowMapper<PublicKeyType> {

  public static PublicKeyTypeMapper mapperForClass(Class<?> clazz) {

    PublicKeyTypeMapper mapperForOverride = new PublicKeyTypeMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected PublicKeyType internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    PublicKeyType publicKeyType = getPublicKeyType();

    setId(publicKeyType, rs, rowNumber);
    setKeyAlg(publicKeyType, rs, rowNumber);
    setSignAlg(publicKeyType, rs, rowNumber);
    setDomain(publicKeyType, rs, rowNumber);
    setVersion(publicKeyType, rs, rowNumber);

    return publicKeyType;
  }

  protected PublicKeyType getPublicKeyType() {
    if (null == clazz) {

      PublicKeyType entity = new PublicKeyType();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(PublicKeyType publicKeyType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(PublicKeyTypeTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      publicKeyType.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setKeyAlg(PublicKeyType publicKeyType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String keyAlg = rs.getString(PublicKeyTypeTable.COLUMN_KEY_ALG);

      if (keyAlg == null) {
        // do nothing when nothing found in database
        return;
      }

      publicKeyType.setKeyAlg(keyAlg);
    } catch (SQLException e) {

    }
  }

  protected void setSignAlg(PublicKeyType publicKeyType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String signAlg = rs.getString(PublicKeyTypeTable.COLUMN_SIGN_ALG);

      if (signAlg == null) {
        // do nothing when nothing found in database
        return;
      }

      publicKeyType.setSignAlg(signAlg);
    } catch (SQLException e) {

    }
  }

  protected void setDomain(PublicKeyType publicKeyType, ResultSet rs, int rowNumber)
      throws SQLException {
    String userDomainId;
    try {
      userDomainId = rs.getString(PublicKeyTypeTable.COLUMN_DOMAIN);
    } catch (SQLException e) {
      return;
    }
    if (userDomainId == null) {
      return;
    }
    if (userDomainId.isEmpty()) {
      return;
    }
    UserDomain userDomain = publicKeyType.getDomain();
    if (userDomain != null) {
      // if the root object 'publicKeyType' already have the property, just set the id for it;
      userDomain.setId(userDomainId);

      return;
    }
    publicKeyType.setDomain(createEmptyDomain(userDomainId));
  }

  protected void setVersion(PublicKeyType publicKeyType, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(PublicKeyTypeTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      publicKeyType.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected UserDomain createEmptyDomain(String userDomainId) {

    UserDomain userDomain = new UserDomain();

    userDomain.setId(userDomainId);
    userDomain.setVersion(Integer.MAX_VALUE);
    return userDomain;
  }
}
