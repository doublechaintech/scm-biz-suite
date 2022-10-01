package com.doublechaintech.retailscm.secuser;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.userdomain.UserDomain;

public class SecUserMapper extends BaseRowMapper<SecUser> {

  public static SecUserMapper mapperForClass(Class<?> clazz) {

    SecUserMapper mapperForOverride = new SecUserMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected SecUser internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    SecUser secUser = getSecUser();

    setId(secUser, rs, rowNumber);
    setLogin(secUser, rs, rowNumber);
    setMobile(secUser, rs, rowNumber);
    setEmail(secUser, rs, rowNumber);
    setPwd(secUser, rs, rowNumber);
    setWeixinOpenid(secUser, rs, rowNumber);
    setWeixinAppid(secUser, rs, rowNumber);
    setAccessToken(secUser, rs, rowNumber);
    setVerificationCode(secUser, rs, rowNumber);
    setVerificationCodeExpire(secUser, rs, rowNumber);
    setLastLoginTime(secUser, rs, rowNumber);
    setDomain(secUser, rs, rowNumber);
    setVersion(secUser, rs, rowNumber);

    return secUser;
  }

  protected SecUser getSecUser() {
    if (null == clazz) {

      SecUser entity = new SecUser();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(SecUserTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setLogin(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String login = rs.getString(SecUserTable.COLUMN_LOGIN);

      if (login == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setLogin(login);
    } catch (SQLException e) {

    }
  }

  protected void setMobile(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String mobile = rs.getString(SecUserTable.COLUMN_MOBILE);

      if (mobile == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setMobile(mobile);
    } catch (SQLException e) {

    }
  }

  protected void setEmail(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String email = rs.getString(SecUserTable.COLUMN_EMAIL);

      if (email == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setEmail(email);
    } catch (SQLException e) {

    }
  }

  protected void setPwd(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String pwd = rs.getString(SecUserTable.COLUMN_PWD);

      if (pwd == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setPwd(pwd);
    } catch (SQLException e) {

    }
  }

  protected void setWeixinOpenid(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String weixinOpenid = rs.getString(SecUserTable.COLUMN_WEIXIN_OPENID);

      if (weixinOpenid == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setWeixinOpenid(weixinOpenid);
    } catch (SQLException e) {

    }
  }

  protected void setWeixinAppid(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String weixinAppid = rs.getString(SecUserTable.COLUMN_WEIXIN_APPID);

      if (weixinAppid == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setWeixinAppid(weixinAppid);
    } catch (SQLException e) {

    }
  }

  protected void setAccessToken(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String accessToken = rs.getString(SecUserTable.COLUMN_ACCESS_TOKEN);

      if (accessToken == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setAccessToken(accessToken);
    } catch (SQLException e) {

    }
  }

  protected void setVerificationCode(SecUser secUser, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer verificationCode = rs.getInt(SecUserTable.COLUMN_VERIFICATION_CODE);

      if (verificationCode == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setVerificationCode(verificationCode);
    } catch (SQLException e) {

    }
  }

  protected void setVerificationCodeExpire(SecUser secUser, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date verificationCodeExpire = rs.getTimestamp(SecUserTable.COLUMN_VERIFICATION_CODE_EXPIRE);

      if (verificationCodeExpire == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setVerificationCodeExpire(convertToDateTime(verificationCodeExpire));
    } catch (SQLException e) {

    }
  }

  protected void setLastLoginTime(SecUser secUser, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date lastLoginTime = rs.getTimestamp(SecUserTable.COLUMN_LAST_LOGIN_TIME);

      if (lastLoginTime == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setLastLoginTime(convertToDateTime(lastLoginTime));
    } catch (SQLException e) {

    }
  }

  protected void setDomain(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    String userDomainId;
    try {
      userDomainId = rs.getString(SecUserTable.COLUMN_DOMAIN);
    } catch (SQLException e) {
      return;
    }
    if (userDomainId == null) {
      return;
    }
    if (userDomainId.isEmpty()) {
      return;
    }
    UserDomain userDomain = secUser.getDomain();
    if (userDomain != null) {
      // if the root object 'secUser' already have the property, just set the id for it;
      userDomain.setId(userDomainId);

      return;
    }
    secUser.setDomain(createEmptyDomain(userDomainId));
  }

  protected void setVersion(SecUser secUser, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(SecUserTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      secUser.setVersion(version);
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
