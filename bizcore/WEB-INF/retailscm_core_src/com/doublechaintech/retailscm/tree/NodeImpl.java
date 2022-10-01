package com.doublechaintech.retailscm.tree;

import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NodeImpl<T extends BaseEntity> implements Node<T> {
  private TreeNode mTreeNode;
  private T value;
  private Node<T> parent;
  private List<Node<T>> children;

  public NodeImpl() {
    children = new ArrayList<>();
  }

  public TreeNode getTreeNode() {
    return mTreeNode;
  }

  public void setTreeNode(TreeNode pTreeNode) {
    mTreeNode = pTreeNode;
  }

  @Override
  public T value() {
    return value;
  }

  @Override
  public Node<T> parent() {
    return parent;
  }

  @Override
  public List<Node<T>> children() {
    return children;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T pValue) {
    value = pValue;
  }

  public Node<T> getParent() {
    return parent;
  }

  public void setParent(Node<T> pParent) {
    parent = pParent;
  }

  public List<Node<T>> getChildren() {
    return children;
  }

  public void setChildren(List<Node<T>> pChildren) {
    children = pChildren;
  }

  public void addChild(Node pNewNode) {
    children.add(pNewNode);
    ((NodeImpl) pNewNode).setParent(this);
  }

  @Override
  public Node navigate(String nodeType, String nodeId) {
    return findInSubTree(root(), nodeType, nodeId);
  }

  private Node findInSubTree(Node root, String nodeType, String nodeId) {
    TreeNode childTreeNode = root.getTreeNode();

    if (childTreeNode == null) {
      return null;
    }

    String childTreeNodeId = childTreeNode.getNodeId();
    String childTreeNodeType = childTreeNode.getNodeType();

    if (Objects.equals(nodeId, childTreeNodeId) && Objects.equals(nodeType, childTreeNodeType)) {
      return root;
    }

    List children = root.children();
    if (children == null || children.isEmpty()) {
      return null;
    }

    for (Object child : children) {
      Node node = findInSubTree((Node) child, nodeType, nodeId);

      if (node != null) {
        return node;
      }
    }
    return null;
  }

  @Override
  public boolean equals(Object pO) {
    if (this == pO) return true;
    if (!(pO instanceof NodeImpl)) return false;
    NodeImpl<?> node = (NodeImpl<?>) pO;
    return getTreeNode().equals(node.getTreeNode());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTreeNode());
  }
}
