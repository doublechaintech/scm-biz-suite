package com.doublechaintech.retailscm.treenode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface TreeNodeManager extends BaseManager {

  List<TreeNode> searchTreeNodeList(RetailscmUserContext ctx, TreeNodeRequest pRequest);

  TreeNode searchTreeNode(RetailscmUserContext ctx, TreeNodeRequest pRequest);

  public TreeNode createTreeNode(
      RetailscmUserContext userContext,
      String nodeId,
      String nodeType,
      int leftValue,
      int rightValue)
      throws Exception;

  public TreeNode updateTreeNode(
      RetailscmUserContext userContext,
      String treeNodeId,
      int treeNodeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public TreeNode loadTreeNode(
      RetailscmUserContext userContext, String treeNodeId, String[] tokensExpr) throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public TreeNode internalSaveTreeNode(RetailscmUserContext userContext, TreeNode treeNode)
      throws Exception;

  public TreeNode internalSaveTreeNode(
      RetailscmUserContext userContext, TreeNode treeNode, Map<String, Object> option)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, TreeNode newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, TreeNode updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

}
