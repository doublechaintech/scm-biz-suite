package com.doublechaintech.retailscm.page;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;

public class PageMapper extends BaseRowMapper<Page> {

  public static PageMapper mapperForClass(Class<?> clazz) {

    PageMapper mapperForOverride = new PageMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected Page internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    Page page = getPage();

    setId(page, rs, rowNumber);
    setPageTitle(page, rs, rowNumber);
    setLinkToUrl(page, rs, rowNumber);
    setPageType(page, rs, rowNumber);
    setDisplayOrder(page, rs, rowNumber);
    setMobileApp(page, rs, rowNumber);
    setVersion(page, rs, rowNumber);

    return page;
  }

  protected Page getPage() {
    if (null == clazz) {

      Page entity = new Page();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(Page page, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(PageTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      page.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setPageTitle(Page page, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String pageTitle = rs.getString(PageTable.COLUMN_PAGE_TITLE);

      if (pageTitle == null) {
        // do nothing when nothing found in database
        return;
      }

      page.setPageTitle(pageTitle);
    } catch (SQLException e) {

    }
  }

  protected void setLinkToUrl(Page page, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String linkToUrl = rs.getString(PageTable.COLUMN_LINK_TO_URL);

      if (linkToUrl == null) {
        // do nothing when nothing found in database
        return;
      }

      page.setLinkToUrl(linkToUrl);
    } catch (SQLException e) {

    }
  }

  protected void setPageType(Page page, ResultSet rs, int rowNumber) throws SQLException {
    String pageTypeId;
    try {
      pageTypeId = rs.getString(PageTable.COLUMN_PAGE_TYPE);
    } catch (SQLException e) {
      return;
    }
    if (pageTypeId == null) {
      return;
    }
    if (pageTypeId.isEmpty()) {
      return;
    }
    PageType pageType = page.getPageType();
    if (pageType != null) {
      // if the root object 'page' already have the property, just set the id for it;
      pageType.setId(pageTypeId);

      return;
    }
    page.setPageType(createEmptyPageType(pageTypeId));
  }

  protected void setDisplayOrder(Page page, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer displayOrder = rs.getInt(PageTable.COLUMN_DISPLAY_ORDER);

      if (displayOrder == null) {
        // do nothing when nothing found in database
        return;
      }

      page.setDisplayOrder(displayOrder);
    } catch (SQLException e) {

    }
  }

  protected void setMobileApp(Page page, ResultSet rs, int rowNumber) throws SQLException {
    String mobileAppId;
    try {
      mobileAppId = rs.getString(PageTable.COLUMN_MOBILE_APP);
    } catch (SQLException e) {
      return;
    }
    if (mobileAppId == null) {
      return;
    }
    if (mobileAppId.isEmpty()) {
      return;
    }
    MobileApp mobileApp = page.getMobileApp();
    if (mobileApp != null) {
      // if the root object 'page' already have the property, just set the id for it;
      mobileApp.setId(mobileAppId);

      return;
    }
    page.setMobileApp(createEmptyMobileApp(mobileAppId));
  }

  protected void setVersion(Page page, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(PageTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      page.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected PageType createEmptyPageType(String pageTypeId) {

    PageType pageType = new PageType();

    pageType.setId(pageTypeId);
    pageType.setVersion(Integer.MAX_VALUE);
    return pageType;
  }

  protected MobileApp createEmptyMobileApp(String mobileAppId) {

    MobileApp mobileApp = new MobileApp();

    mobileApp.setId(mobileAppId);
    mobileApp.setVersion(Integer.MAX_VALUE);
    return mobileApp;
  }
}
