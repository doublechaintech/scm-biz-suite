package com.doublechaintech.retailscm.userallowlist;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.userdomain.UserDomain;

public class UserAllowListMapper extends BaseRowMapper<UserAllowList> {

  public static UserAllowListMapper mapperForClass(Class<?> clazz) {

    UserAllowListMapper mapperForOverride = new UserAllowListMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected UserAllowList internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    UserAllowList userAllowList = getUserAllowList();

    setId(userAllowList, rs, rowNumber);
    setUserIdentity(userAllowList, rs, rowNumber);
    setUserSpecialFunctions(userAllowList, rs, rowNumber);
    setDomain(userAllowList, rs, rowNumber);
    setVersion(userAllowList, rs, rowNumber);

    return userAllowList;
  }

  protected UserAllowList getUserAllowList() {
    if (null == clazz) {

      UserAllowList entity = new UserAllowList();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(UserAllowList userAllowList, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(UserAllowListTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      userAllowList.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setUserIdentity(UserAllowList userAllowList, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String userIdentity = rs.getString(UserAllowListTable.COLUMN_USER_IDENTITY);

      if (userIdentity == null) {
        // do nothing when nothing found in database
        return;
      }

      userAllowList.setUserIdentity(userIdentity);
    } catch (SQLException e) {

    }
  }

  protected void setUserSpecialFunctions(UserAllowList userAllowList, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String userSpecialFunctions = rs.getString(UserAllowListTable.COLUMN_USER_SPECIAL_FUNCTIONS);

      if (userSpecialFunctions == null) {
        // do nothing when nothing found in database
        return;
      }

      userAllowList.setUserSpecialFunctions(userSpecialFunctions);
    } catch (SQLException e) {

    }
  }

  protected void setDomain(UserAllowList userAllowList, ResultSet rs, int rowNumber)
      throws SQLException {
    String userDomainId;
    try {
      userDomainId = rs.getString(UserAllowListTable.COLUMN_DOMAIN);
    } catch (SQLException e) {
      return;
    }
    if (userDomainId == null) {
      return;
    }
    if (userDomainId.isEmpty()) {
      return;
    }
    UserDomain userDomain = userAllowList.getDomain();
    if (userDomain != null) {
      // if the root object 'userAllowList' already have the property, just set the id for it;
      userDomain.setId(userDomainId);

      return;
    }
    userAllowList.setDomain(createEmptyDomain(userDomainId));
  }

  protected void setVersion(UserAllowList userAllowList, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(UserAllowListTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      userAllowList.setVersion(version);
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
