package com.doublechaintech.retailscm.userapp;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;

public class UserAppMapper extends BaseRowMapper<UserApp> {

  public static UserAppMapper mapperForClass(Class<?> clazz) {

    UserAppMapper mapperForOverride = new UserAppMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected UserApp internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    UserApp userApp = getUserApp();

    setId(userApp, rs, rowNumber);
    setTitle(userApp, rs, rowNumber);
    setSecUser(userApp, rs, rowNumber);
    setAppIcon(userApp, rs, rowNumber);
    setFullAccess(userApp, rs, rowNumber);
    setPermission(userApp, rs, rowNumber);
    setAppType(userApp, rs, rowNumber);
    setAppId(userApp, rs, rowNumber);
    setCtxType(userApp, rs, rowNumber);
    setCtxId(userApp, rs, rowNumber);
    setLocation(userApp, rs, rowNumber);
    setVersion(userApp, rs, rowNumber);

    return userApp;
  }

  protected UserApp getUserApp() {
    if (null == clazz) {

      UserApp entity = new UserApp();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(UserAppTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setTitle(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String title = rs.getString(UserAppTable.COLUMN_TITLE);

      if (title == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setTitle(title);
    } catch (SQLException e) {

    }
  }

  protected void setSecUser(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    String secUserId;
    try {
      secUserId = rs.getString(UserAppTable.COLUMN_SEC_USER);
    } catch (SQLException e) {
      return;
    }
    if (secUserId == null) {
      return;
    }
    if (secUserId.isEmpty()) {
      return;
    }
    SecUser secUser = userApp.getSecUser();
    if (secUser != null) {
      // if the root object 'userApp' already have the property, just set the id for it;
      secUser.setId(secUserId);

      return;
    }
    userApp.setSecUser(createEmptySecUser(secUserId));
  }

  protected void setAppIcon(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String appIcon = rs.getString(UserAppTable.COLUMN_APP_ICON);

      if (appIcon == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setAppIcon(appIcon);
    } catch (SQLException e) {

    }
  }

  protected void setFullAccess(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Boolean fullAccess = rs.getBoolean(UserAppTable.COLUMN_FULL_ACCESS);

      if (fullAccess == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setFullAccess(fullAccess);
    } catch (SQLException e) {

    }
  }

  protected void setPermission(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String permission = rs.getString(UserAppTable.COLUMN_PERMISSION);

      if (permission == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setPermission(permission);
    } catch (SQLException e) {

    }
  }

  protected void setAppType(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String appType = rs.getString(UserAppTable.COLUMN_APP_TYPE);

      if (appType == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setAppType(appType);
    } catch (SQLException e) {

    }
  }

  protected void setAppId(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String appId = rs.getString(UserAppTable.COLUMN_APP_ID);

      if (appId == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setAppId(appId);
    } catch (SQLException e) {

    }
  }

  protected void setCtxType(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String ctxType = rs.getString(UserAppTable.COLUMN_CTX_TYPE);

      if (ctxType == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setCtxType(ctxType);
    } catch (SQLException e) {

    }
  }

  protected void setCtxId(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String ctxId = rs.getString(UserAppTable.COLUMN_CTX_ID);

      if (ctxId == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setCtxId(ctxId);
    } catch (SQLException e) {

    }
  }

  protected void setLocation(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String location = rs.getString(UserAppTable.COLUMN_LOCATION);

      if (location == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setLocation(location);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(UserAppTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      userApp.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected SecUser createEmptySecUser(String secUserId) {

    SecUser secUser = new SecUser();

    secUser.setId(secUserId);
    secUser.setVersion(Integer.MAX_VALUE);
    return secUser;
  }
}
