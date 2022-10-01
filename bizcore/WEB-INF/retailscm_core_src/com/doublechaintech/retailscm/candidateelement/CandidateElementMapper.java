package com.doublechaintech.retailscm.candidateelement;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;

public class CandidateElementMapper extends BaseRowMapper<CandidateElement> {

  public static CandidateElementMapper mapperForClass(Class<?> clazz) {

    CandidateElementMapper mapperForOverride = new CandidateElementMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected CandidateElement internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    CandidateElement candidateElement = getCandidateElement();

    setId(candidateElement, rs, rowNumber);
    setName(candidateElement, rs, rowNumber);
    setType(candidateElement, rs, rowNumber);
    setImage(candidateElement, rs, rowNumber);
    setContainer(candidateElement, rs, rowNumber);
    setVersion(candidateElement, rs, rowNumber);

    return candidateElement;
  }

  protected CandidateElement getCandidateElement() {
    if (null == clazz) {

      CandidateElement entity = new CandidateElement();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(CandidateElement candidateElement, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(CandidateElementTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      candidateElement.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(CandidateElement candidateElement, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(CandidateElementTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      candidateElement.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setType(CandidateElement candidateElement, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String type = rs.getString(CandidateElementTable.COLUMN_TYPE);

      if (type == null) {
        // do nothing when nothing found in database
        return;
      }

      candidateElement.setType(type);
    } catch (SQLException e) {

    }
  }

  protected void setImage(CandidateElement candidateElement, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String image = rs.getString(CandidateElementTable.COLUMN_IMAGE);

      if (image == null) {
        // do nothing when nothing found in database
        return;
      }

      candidateElement.setImage(image);
    } catch (SQLException e) {

    }
  }

  protected void setContainer(CandidateElement candidateElement, ResultSet rs, int rowNumber)
      throws SQLException {
    String candidateContainerId;
    try {
      candidateContainerId = rs.getString(CandidateElementTable.COLUMN_CONTAINER);
    } catch (SQLException e) {
      return;
    }
    if (candidateContainerId == null) {
      return;
    }
    if (candidateContainerId.isEmpty()) {
      return;
    }
    CandidateContainer candidateContainer = candidateElement.getContainer();
    if (candidateContainer != null) {
      // if the root object 'candidateElement' already have the property, just set the id for it;
      candidateContainer.setId(candidateContainerId);

      return;
    }
    candidateElement.setContainer(createEmptyContainer(candidateContainerId));
  }

  protected void setVersion(CandidateElement candidateElement, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(CandidateElementTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      candidateElement.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected CandidateContainer createEmptyContainer(String candidateContainerId) {

    CandidateContainer candidateContainer = new CandidateContainer();

    candidateContainer.setId(candidateContainerId);
    candidateContainer.setVersion(Integer.MAX_VALUE);
    return candidateContainer;
  }
}
