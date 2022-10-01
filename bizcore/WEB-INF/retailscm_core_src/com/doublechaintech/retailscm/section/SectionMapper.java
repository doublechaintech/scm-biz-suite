package com.doublechaintech.retailscm.section;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.page.Page;

public class SectionMapper extends BaseRowMapper<Section> {

  public static SectionMapper mapperForClass(Class<?> clazz) {

    SectionMapper mapperForOverride = new SectionMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected Section internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    Section section = getSection();

    setId(section, rs, rowNumber);
    setTitle(section, rs, rowNumber);
    setBrief(section, rs, rowNumber);
    setIcon(section, rs, rowNumber);
    setDisplayOrder(section, rs, rowNumber);
    setViewGroup(section, rs, rowNumber);
    setLinkToUrl(section, rs, rowNumber);
    setPage(section, rs, rowNumber);
    setVersion(section, rs, rowNumber);

    return section;
  }

  protected Section getSection() {
    if (null == clazz) {

      Section entity = new Section();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(Section section, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(SectionTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      section.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setTitle(Section section, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String title = rs.getString(SectionTable.COLUMN_TITLE);

      if (title == null) {
        // do nothing when nothing found in database
        return;
      }

      section.setTitle(title);
    } catch (SQLException e) {

    }
  }

  protected void setBrief(Section section, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String brief = rs.getString(SectionTable.COLUMN_BRIEF);

      if (brief == null) {
        // do nothing when nothing found in database
        return;
      }

      section.setBrief(brief);
    } catch (SQLException e) {

    }
  }

  protected void setIcon(Section section, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String icon = rs.getString(SectionTable.COLUMN_ICON);

      if (icon == null) {
        // do nothing when nothing found in database
        return;
      }

      section.setIcon(icon);
    } catch (SQLException e) {

    }
  }

  protected void setDisplayOrder(Section section, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer displayOrder = rs.getInt(SectionTable.COLUMN_DISPLAY_ORDER);

      if (displayOrder == null) {
        // do nothing when nothing found in database
        return;
      }

      section.setDisplayOrder(displayOrder);
    } catch (SQLException e) {

    }
  }

  protected void setViewGroup(Section section, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String viewGroup = rs.getString(SectionTable.COLUMN_VIEW_GROUP);

      if (viewGroup == null) {
        // do nothing when nothing found in database
        return;
      }

      section.setViewGroup(viewGroup);
    } catch (SQLException e) {

    }
  }

  protected void setLinkToUrl(Section section, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String linkToUrl = rs.getString(SectionTable.COLUMN_LINK_TO_URL);

      if (linkToUrl == null) {
        // do nothing when nothing found in database
        return;
      }

      section.setLinkToUrl(linkToUrl);
    } catch (SQLException e) {

    }
  }

  protected void setPage(Section section, ResultSet rs, int rowNumber) throws SQLException {
    String pageId;
    try {
      pageId = rs.getString(SectionTable.COLUMN_PAGE);
    } catch (SQLException e) {
      return;
    }
    if (pageId == null) {
      return;
    }
    if (pageId.isEmpty()) {
      return;
    }
    Page page = section.getPage();
    if (page != null) {
      // if the root object 'section' already have the property, just set the id for it;
      page.setId(pageId);

      return;
    }
    section.setPage(createEmptyPage(pageId));
  }

  protected void setVersion(Section section, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(SectionTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      section.setVersion(version);
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
