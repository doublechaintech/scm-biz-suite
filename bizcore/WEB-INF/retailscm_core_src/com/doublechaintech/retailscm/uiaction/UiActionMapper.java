package com.doublechaintech.retailscm.uiaction;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.page.Page;

public class UiActionMapper extends BaseRowMapper<UiAction> {

  public static UiActionMapper mapperForClass(Class<?> clazz) {

    UiActionMapper mapperForOverride = new UiActionMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected UiAction internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    UiAction uiAction = getUiAction();

    setId(uiAction, rs, rowNumber);
    setCode(uiAction, rs, rowNumber);
    setIcon(uiAction, rs, rowNumber);
    setTitle(uiAction, rs, rowNumber);
    setDisplayOrder(uiAction, rs, rowNumber);
    setBrief(uiAction, rs, rowNumber);
    setImageUrl(uiAction, rs, rowNumber);
    setLinkToUrl(uiAction, rs, rowNumber);
    setExtraData(uiAction, rs, rowNumber);
    setPage(uiAction, rs, rowNumber);
    setVersion(uiAction, rs, rowNumber);

    return uiAction;
  }

  protected UiAction getUiAction() {
    if (null == clazz) {

      UiAction entity = new UiAction();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(UiActionTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setCode(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String code = rs.getString(UiActionTable.COLUMN_CODE);

      if (code == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setCode(code);
    } catch (SQLException e) {

    }
  }

  protected void setIcon(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String icon = rs.getString(UiActionTable.COLUMN_ICON);

      if (icon == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setIcon(icon);
    } catch (SQLException e) {

    }
  }

  protected void setTitle(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String title = rs.getString(UiActionTable.COLUMN_TITLE);

      if (title == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setTitle(title);
    } catch (SQLException e) {

    }
  }

  protected void setDisplayOrder(UiAction uiAction, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer displayOrder = rs.getInt(UiActionTable.COLUMN_DISPLAY_ORDER);

      if (displayOrder == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setDisplayOrder(displayOrder);
    } catch (SQLException e) {

    }
  }

  protected void setBrief(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String brief = rs.getString(UiActionTable.COLUMN_BRIEF);

      if (brief == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setBrief(brief);
    } catch (SQLException e) {

    }
  }

  protected void setImageUrl(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String imageUrl = rs.getString(UiActionTable.COLUMN_IMAGE_URL);

      if (imageUrl == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setImageUrl(imageUrl);
    } catch (SQLException e) {

    }
  }

  protected void setLinkToUrl(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String linkToUrl = rs.getString(UiActionTable.COLUMN_LINK_TO_URL);

      if (linkToUrl == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setLinkToUrl(linkToUrl);
    } catch (SQLException e) {

    }
  }

  protected void setExtraData(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String extraData = rs.getString(UiActionTable.COLUMN_EXTRA_DATA);

      if (extraData == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setExtraData(extraData);
    } catch (SQLException e) {

    }
  }

  protected void setPage(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    String pageId;
    try {
      pageId = rs.getString(UiActionTable.COLUMN_PAGE);
    } catch (SQLException e) {
      return;
    }
    if (pageId == null) {
      return;
    }
    if (pageId.isEmpty()) {
      return;
    }
    Page page = uiAction.getPage();
    if (page != null) {
      // if the root object 'uiAction' already have the property, just set the id for it;
      page.setId(pageId);

      return;
    }
    uiAction.setPage(createEmptyPage(pageId));
  }

  protected void setVersion(UiAction uiAction, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(UiActionTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      uiAction.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected Page createEmptyPage(String pageId) {

    Page page = new Page();

    page.setId(pageId);
    page.setVersion(Integer.MAX_VALUE);
    return page;
  }
}
