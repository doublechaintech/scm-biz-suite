package com.doublechaintech.retailscm.quicklink;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.userapp.UserApp;

public class QuickLinkMapper extends BaseRowMapper<QuickLink> {

  public static QuickLinkMapper mapperForClass(Class<?> clazz) {

    QuickLinkMapper mapperForOverride = new QuickLinkMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected QuickLink internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    QuickLink quickLink = getQuickLink();

    setId(quickLink, rs, rowNumber);
    setName(quickLink, rs, rowNumber);
    setIcon(quickLink, rs, rowNumber);
    setImagePath(quickLink, rs, rowNumber);
    setLinkTarget(quickLink, rs, rowNumber);
    setCreateTime(quickLink, rs, rowNumber);
    setApp(quickLink, rs, rowNumber);
    setVersion(quickLink, rs, rowNumber);

    return quickLink;
  }

  protected QuickLink getQuickLink() {
    if (null == clazz) {

      QuickLink entity = new QuickLink();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(QuickLink quickLink, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(QuickLinkTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      quickLink.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(QuickLink quickLink, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(QuickLinkTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      quickLink.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setIcon(QuickLink quickLink, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String icon = rs.getString(QuickLinkTable.COLUMN_ICON);

      if (icon == null) {
        // do nothing when nothing found in database
        return;
      }

      quickLink.setIcon(icon);
    } catch (SQLException e) {

    }
  }

  protected void setImagePath(QuickLink quickLink, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String imagePath = rs.getString(QuickLinkTable.COLUMN_IMAGE_PATH);

      if (imagePath == null) {
        // do nothing when nothing found in database
        return;
      }

      quickLink.setImagePath(imagePath);
    } catch (SQLException e) {

    }
  }

  protected void setLinkTarget(QuickLink quickLink, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String linkTarget = rs.getString(QuickLinkTable.COLUMN_LINK_TARGET);

      if (linkTarget == null) {
        // do nothing when nothing found in database
        return;
      }

      quickLink.setLinkTarget(linkTarget);
    } catch (SQLException e) {

    }
  }

  protected void setCreateTime(QuickLink quickLink, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date createTime = rs.getTimestamp(QuickLinkTable.COLUMN_CREATE_TIME);

      if (createTime == null) {
        // do nothing when nothing found in database
        return;
      }

      quickLink.setCreateTime(convertToDateTime(createTime));
    } catch (SQLException e) {

    }
  }

  protected void setApp(QuickLink quickLink, ResultSet rs, int rowNumber) throws SQLException {
    String userAppId;
    try {
      userAppId = rs.getString(QuickLinkTable.COLUMN_APP);
    } catch (SQLException e) {
      return;
    }
    if (userAppId == null) {
      return;
    }
    if (userAppId.isEmpty()) {
      return;
    }
    UserApp userApp = quickLink.getApp();
    if (userApp != null) {
      // if the root object 'quickLink' already have the property, just set the id for it;
      userApp.setId(userAppId);

      return;
    }
    quickLink.setApp(createEmptyApp(userAppId));
  }

  protected void setVersion(QuickLink quickLink, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(QuickLinkTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      quickLink.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected UserApp createEmptyApp(String userAppId) {

    UserApp userApp = new UserApp();

    userApp.setId(userAppId);
    userApp.setVersion(Integer.MAX_VALUE);
    return userApp;
  }
}
