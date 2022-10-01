package com.doublechaintech.retailscm.memberrewardpointredemption;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

public class MemberRewardPointRedemptionMapper extends BaseRowMapper<MemberRewardPointRedemption> {

  public static MemberRewardPointRedemptionMapper mapperForClass(Class<?> clazz) {

    MemberRewardPointRedemptionMapper mapperForOverride = new MemberRewardPointRedemptionMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected MemberRewardPointRedemption internalMapRow(ResultSet rs, int rowNumber)
      throws SQLException {
    MemberRewardPointRedemption memberRewardPointRedemption = getMemberRewardPointRedemption();

    setId(memberRewardPointRedemption, rs, rowNumber);
    setName(memberRewardPointRedemption, rs, rowNumber);
    setPoint(memberRewardPointRedemption, rs, rowNumber);
    setOwner(memberRewardPointRedemption, rs, rowNumber);
    setVersion(memberRewardPointRedemption, rs, rowNumber);

    return memberRewardPointRedemption;
  }

  protected MemberRewardPointRedemption getMemberRewardPointRedemption() {
    if (null == clazz) {

      MemberRewardPointRedemption entity = new MemberRewardPointRedemption();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(
      MemberRewardPointRedemption memberRewardPointRedemption, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(MemberRewardPointRedemptionTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      memberRewardPointRedemption.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setName(
      MemberRewardPointRedemption memberRewardPointRedemption, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String name = rs.getString(MemberRewardPointRedemptionTable.COLUMN_NAME);

      if (name == null) {
        // do nothing when nothing found in database
        return;
      }

      memberRewardPointRedemption.setName(name);
    } catch (SQLException e) {

    }
  }

  protected void setPoint(
      MemberRewardPointRedemption memberRewardPointRedemption, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer point = rs.getInt(MemberRewardPointRedemptionTable.COLUMN_POINT);

      if (point == null) {
        // do nothing when nothing found in database
        return;
      }

      memberRewardPointRedemption.setPoint(point);
    } catch (SQLException e) {

    }
  }

  protected void setOwner(
      MemberRewardPointRedemption memberRewardPointRedemption, ResultSet rs, int rowNumber)
      throws SQLException {
    String retailStoreMemberId;
    try {
      retailStoreMemberId = rs.getString(MemberRewardPointRedemptionTable.COLUMN_OWNER);
    } catch (SQLException e) {
      return;
    }
    if (retailStoreMemberId == null) {
      return;
    }
    if (retailStoreMemberId.isEmpty()) {
      return;
    }
    RetailStoreMember retailStoreMember = memberRewardPointRedemption.getOwner();
    if (retailStoreMember != null) {
      // if the root object 'memberRewardPointRedemption' already have the property, just set the id
      // for it;
      retailStoreMember.setId(retailStoreMemberId);

      return;
    }
    memberRewardPointRedemption.setOwner(createEmptyOwner(retailStoreMemberId));
  }

  protected void setVersion(
      MemberRewardPointRedemption memberRewardPointRedemption, ResultSet rs, int rowNumber)
      throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(MemberRewardPointRedemptionTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      memberRewardPointRedemption.setVersion(version);
    } catch (SQLException e) {

    }
  }

  protected RetailStoreMember createEmptyOwner(String retailStoreMemberId) {

    RetailStoreMember retailStoreMember = new RetailStoreMember();

    retailStoreMember.setId(retailStoreMemberId);
    retailStoreMember.setVersion(Integer.MAX_VALUE);
    return retailStoreMember;
  }
}
