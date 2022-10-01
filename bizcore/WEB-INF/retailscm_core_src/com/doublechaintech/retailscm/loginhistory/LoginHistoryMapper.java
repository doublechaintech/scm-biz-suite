package com.doublechaintech.retailscm.loginhistory;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;

public class LoginHistoryMapper extends BaseRowMapper<LoginHistory> {

  public static LoginHistoryMapper mapperForClass(Class<?> clazz) {

    LoginHistoryMapper mapperForOverride = new LoginHistoryMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected LoginHistory internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    LoginHistory loginHistory = getLoginHistory();

    setId(loginHistory, rs, rowNumber);
    setLoginTime(loginHistory, rs, rowNumber);
    setFromIp(loginHistory, rs, rowNumber);
    setDescription(loginHistory, rs, rowNumber);
    setSecUser(loginHistory, rs, rowNumber);
    setVersion(loginHistory, rs, rowNumber);

    return loginHistory;
  }

  protected LoginHistory getLoginHistory() {
    if (null == clazz) {

      LoginHistory entity = new LoginHistory();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(LoginHistory loginHistory, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(LoginHistoryTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      loginHistory.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setLoginTime(LoginHistory loginHistory, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date loginTime = rs.getTimestamp(LoginHistoryTable.COLUMN_LOGIN_TIME);

      if (loginTime == null) {
        // do nothing when nothing found in database
        return;
      }

      loginHistory.setLoginTime(convertToDateTime(loginTime));
    } catch (SQLException e) {

    }
  }

  protected void setFromIp(LoginHistory loginHistory, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String fromIp = rs.getString(LoginHistoryTable.COLUMN_FROM_IP);

      if (fromIp == null) {
        // do nothing when nothing found in database
        return;
      }

      loginHistory.setFromIp(fromIp);
    } catch (SQLException e) {

    }
  }

  protected void setDescription(LoginHistory loginHistory, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String description = rs.getString(LoginHistoryTable.COLUMN_DESCRIPTION);

      if (description == null) {
        // do nothing when nothing found in database
        return;
      }

      loginHistory.setDescription(description);
    } catch (SQLException e) {

    }
  }

  protected void setSecUser(LoginHistory loginHistory, ResultSet rs, int rowNumber)
      throws SQLException {
    String secUserId;
    try {
      secUserId = rs.getString(LoginHistoryTable.COLUMN_SEC_USER);
    } catch (SQLException e) {
      return;
    }
    if (secUserId == null) {
      return;
    }
    if (secUserId.isEmpty()) {
      return;
    }
    SecUser secUser = loginHistory.getSecUser();
    if (secUser != null) {
      // if the root object 'loginHistory' already have the property, just set the id for it;
      secUser.setId(secUserId);

      return;
    }
    loginHistory.setSecUser(createEmptySecUser(secUserId));
  }

  protected void setVersion(LoginHistory loginHistory, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(LoginHistoryTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      loginHistory.setVersion(version);
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
