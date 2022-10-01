package com.doublechaintech.retailscm.view;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ViewMapper extends BaseRowMapper<View> {

  public static ViewMapper mapperForClass(Class<?> clazz) {

    ViewMapper mapperForOverride = new ViewMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected View internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    View view = getView();

    setId(view, rs, rowNumber);
    setWho(view, rs, rowNumber);
    setAssessment(view, rs, rowNumber);
    setInterviewTime(view, rs, rowNumber);
    setVersion(view, rs, rowNumber);

    return view;
  }

  protected View getView() {
    if (null == clazz) {

      View entity = new View();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(View view, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(ViewTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      view.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setWho(View view, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String who = rs.getString(ViewTable.COLUMN_WHO);

      if (who == null) {
        // do nothing when nothing found in database
        return;
      }

      view.setWho(who);
    } catch (SQLException e) {

    }
  }

  protected void setAssessment(View view, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String assessment = rs.getString(ViewTable.COLUMN_ASSESSMENT);

      if (assessment == null) {
        // do nothing when nothing found in database
        return;
      }

      view.setAssessment(assessment);
    } catch (SQLException e) {

    }
  }

  protected void setInterviewTime(View view, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Date interviewTime = rs.getDate(ViewTable.COLUMN_INTERVIEW_TIME);

      if (interviewTime == null) {
        // do nothing when nothing found in database
        return;
      }

      view.setInterviewTime(interviewTime);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(View view, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(ViewTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      view.setVersion(version);
    } catch (SQLException e) {

    }
  }
}
