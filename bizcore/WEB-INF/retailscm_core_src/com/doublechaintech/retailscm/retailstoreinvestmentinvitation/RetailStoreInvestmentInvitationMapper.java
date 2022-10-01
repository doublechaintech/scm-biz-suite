package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreInvestmentInvitationMapper
    extends BaseRowMapper<RetailStoreInvestmentInvitation> {

  public static RetailStoreInvestmentInvitationMapper mapperForClass(Class<?> clazz) {

    RetailStoreInvestmentInvitationMapper mapperForOverride =
        new RetailStoreInvestmentInvitationMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected RetailStoreInvestmentInvitation internalMapRow(ResultSet rs, int rowNumber)
      throws SQLException {
    RetailStoreInvestmentInvitation retailStoreInvestmentInvitation =
        getRetailStoreInvestmentInvitation();

    setId(retailStoreInvestmentInvitation, rs, rowNumber);
    setComment(retailStoreInvestmentInvitation, rs, rowNumber);
    setVersion(retailStoreInvestmentInvitation, rs, rowNumber);

    return retailStoreInvestmentInvitation;
  }

  protected RetailStoreInvestmentInvitation getRetailStoreInvestmentInvitation() {
    if (null == clazz) {

      RetailStoreInvestmentInvitation entity = new RetailStoreInvestmentInvitation();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(RetailStoreInvestmentInvitationTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreInvestmentInvitation.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setComment(
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String comment = rs.getString(RetailStoreInvestmentInvitationTable.COLUMN_COMMENT);

      if (comment == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreInvestmentInvitation.setComment(comment);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(
      RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(RetailStoreInvestmentInvitationTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      retailStoreInvestmentInvitation.setVersion(version);
    } catch (SQLException e) {

    }
  }
}
