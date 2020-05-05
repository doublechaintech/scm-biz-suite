package com.doublechaintech.retailscm.tree;

import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public interface Node<T extends BaseEntity> {

    /**
     * value on the current node
     *
     * @return
     */
    T value();

    /**
     * the parent node of the current node
     *
     * @return
     */
    Node<T> parent();

    /**
     * the children nodes of the current node
     *
     * @return
     */
    List<Node<T>> children();


    /**
     * the tree node of the current node
     *
     * @return
     */
    TreeNode getTreeNode();


    /**
     * walk to the target node with node type /node id
     *
     * @param nodeType
     * @param nodeId
     * @return
     */
    Node navigate(String nodeType, String nodeId);


    /**
     * the tree may be loaded as a subtree of the completed tree in db
     *
     * @return
     */
    default boolean isRoot() {
        if (isEmpty()){
            return false;
        }

        TreeNode treeNode = getTreeNode();
        return treeNode.getLeftValue() == 1;
    }


    default boolean isEmpty() {
        return getTreeNode() == null;
    }

    default boolean isLeaf() {
        if (isEmpty()) {
            return false;
        }
        return getTreeNode().getRightValue() - getTreeNode().getLeftValue() == 1;
    }

    default Node root() {
        Node current = this;

        while (current.parent() != null) {
            current = current.parent();
        }
        return current;
    }

    default boolean hasAncestor(Node pNode) {
        if (pNode == null) {
            return false;
        }
        if (pNode.isEmpty() || this.isEmpty()) {
            return false;
        }
        return pNode.getTreeNode().getLeftValue() < this.getTreeNode().getLeftValue()
                && pNode.getTreeNode().getRightValue() > this.getTreeNode().getRightValue();
    }

    default boolean firstChild(Node pNode) {
        if (!hasDescender(pNode)) {
            return false;
        }
        return this.getTreeNode().getLeftValue() - pNode.getTreeNode().getLeftValue() == 1;
    }


    default boolean lastChild(Node pNode) {
        if (!hasDescender(pNode)) {
            return false;
        }
        return this.getTreeNode().getRightValue() - pNode.getTreeNode().getRightValue() == 1;
    }


    default boolean hasDescender(Node pNode) {
        return pNode.hasAncestor(this);
    }

    default boolean onTheSamePath(Node pNode) {
        return hasAncestor(pNode) || hasDescender(pNode);
    }

    default boolean sibling(Node pNode) {
        return pNode != null && parent() != null && parent().equals(pNode.parent()) && this != pNode;
    }

    default List<Node<T>> siblings() {
        Node<T> parent = parent();
        if (parent == null) {
            return new ArrayList<>();
        }
        return parent.children().stream().filter(c -> c != this).collect(Collectors.toList());
    }

    default int descendersCount() {
        if (isEmpty()) {
            return 0;
        }

        TreeNode treeNode = getTreeNode();
        return (treeNode.getRightValue() - treeNode.getLeftValue() - 1) / 2;
    }

    default int ancestorsCount() {
        if (isEmpty()) {
            return 0;
        }
        Node current = this;

        int count = 0;
        while (current.parent() != null) {
            current = current.parent();
            count++;
        }
        return count;
    }

    default void visit(Consumer<Node> handler) {
        Node root = root();
        root.doVisit(handler);
    }

    default void doVisit(Consumer<Node> handler) {
        handler.accept(this);
        List<Node<T>> children = children();
        if (children == null) {
            return;
        }
        children.forEach(c -> c.doVisit(handler));
    }
}

