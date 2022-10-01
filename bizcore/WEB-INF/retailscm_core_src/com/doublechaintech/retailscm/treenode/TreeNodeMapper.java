package com.doublechaintech.retailscm.treenode;

import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class TreeNodeMapper extends BaseRowMapper<TreeNode> {

  public static TreeNodeMapper mapperForClass(Class<?> clazz) {

    TreeNodeMapper mapperForOverride = new TreeNodeMapper();
    mapperForOverride.setClazz(clazz);
    return mapperForOverride;
  }

  protected TreeNode internalMapRow(ResultSet rs, int rowNumber) throws SQLException {
    TreeNode treeNode = getTreeNode();

    setId(treeNode, rs, rowNumber);
    setNodeId(treeNode, rs, rowNumber);
    setNodeType(treeNode, rs, rowNumber);
    setLeftValue(treeNode, rs, rowNumber);
    setRightValue(treeNode, rs, rowNumber);
    setVersion(treeNode, rs, rowNumber);

    return treeNode;
  }

  protected TreeNode getTreeNode() {
    if (null == clazz) {

      TreeNode entity = new TreeNode();

      Beans.dbUtil().markEnhanced(entity);
      return entity;
    }
    return super.constructFromClass();
  }

  protected void setId(TreeNode treeNode, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String id = rs.getString(TreeNodeTable.COLUMN_ID);

      if (id == null) {
        // do nothing when nothing found in database
        return;
      }

      treeNode.setId(id);
    } catch (SQLException e) {

    }
  }

  protected void setNodeId(TreeNode treeNode, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String nodeId = rs.getString(TreeNodeTable.COLUMN_NODE_ID);

      if (nodeId == null) {
        // do nothing when nothing found in database
        return;
      }

      treeNode.setNodeId(nodeId);
    } catch (SQLException e) {

    }
  }

  protected void setNodeType(TreeNode treeNode, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      String nodeType = rs.getString(TreeNodeTable.COLUMN_NODE_TYPE);

      if (nodeType == null) {
        // do nothing when nothing found in database
        return;
      }

      treeNode.setNodeType(nodeType);
    } catch (SQLException e) {

    }
  }

  protected void setLeftValue(TreeNode treeNode, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer leftValue = rs.getInt(TreeNodeTable.COLUMN_LEFT_VALUE);

      if (leftValue == null) {
        // do nothing when nothing found in database
        return;
      }

      treeNode.setLeftValue(leftValue);
    } catch (SQLException e) {

    }
  }

  protected void setRightValue(TreeNode treeNode, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer rightValue = rs.getInt(TreeNodeTable.COLUMN_RIGHT_VALUE);

      if (rightValue == null) {
        // do nothing when nothing found in database
        return;
      }

      treeNode.setRightValue(rightValue);
    } catch (SQLException e) {

    }
  }

  protected void setVersion(TreeNode treeNode, ResultSet rs, int rowNumber) throws SQLException {
    try {
      // there will be issue when the type is double/int/long

      Integer version = rs.getInt(TreeNodeTable.COLUMN_VERSION);

      if (version == null) {
        // do nothing when nothing found in database
        return;
      }

      treeNode.setVersion(version);
    } catch (SQLException e) {

    }
  }
}
