package com.doublechaintech.retailscm.tree;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.treenode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TreeServiceImpl extends CustomRetailscmCheckerManager implements TreeService {

    @Override
    public Node loadTree(RetailscmUserContext ctx, String nodeId, String nodeType) throws Exception {
        SmartList<TreeNode> nodes = loadTreeNode(ctx, nodeId, nodeType);

        if (nodes.isEmpty()) {
            throw new RuntimeException("the tree node with nodeId: " + nodeId + ", nodeType: " + nodeType + " not found");
        }

        if (nodes.size() > 1) {
            throw new RuntimeException("found 2 more nodes with nodeId: " + nodeId + ", nodeType: " + nodeType);
        }

        TreeNode first = nodes.first();
        return extractTreeFromRoot(ctx, first);
    }

    @Override
    public Node loadAncestors(RetailscmUserContext ctx, String nodeId, String nodeType) throws Exception {
        SmartList<TreeNode> nodes = loadTreeNode(ctx, nodeId, nodeType);

        if (nodes.isEmpty()) {
            throw new RuntimeException("the tree node with nodeId: " + nodeId + ", nodeType: " + nodeType + " not found");
        }

        if (nodes.size() > 1) {
            throw new RuntimeException("found 2 more nodes with nodeId: " + nodeId + ", nodeType: " + nodeType);
        }

        TreeNode first = nodes.first();
        return extractAncestors(ctx, first);
    }


    public SmartList<TreeNode> loadTreeNode(RetailscmUserContext ctx, String nodeId, String nodeType) {
        MultipleAccessKey key = new MultipleAccessKey();
        key.put(TreeNode.NODE_ID_PROPERTY, nodeId);
        key.put(TreeNode.NODE_TYPE_PROPERTY, nodeType);
        return treeNodeDaoOf(ctx).findTreeNodeWithKey(key, EO);
    }

    /**
     * @param ctx
     * @param pRoot is not checked, and assume existed
     * @param <T>
     * @return
     * @throws Exception
     */
    private <T extends BaseEntity> Node<T> extractTreeFromRoot(RetailscmUserContext ctx, TreeNode pRoot) throws Exception {
        SmartList<TreeNode> nodeList = treeNodeDaoOf(ctx).queryList("select * from tree_node_data where left_value >= ? and right_value <= ? order by left_value asc", pRoot.getLeftValue(), pRoot.getRightValue());
        return buildInternalTree(ctx, nodeList);
    }

    private <T extends BaseEntity> Node<T> extractAncestors(RetailscmUserContext ctx, TreeNode pNode) throws Exception {
        SmartList<TreeNode> nodeList = treeNodeDaoOf(ctx).queryList("select * from tree_node_data where left_value < ? and right_value > ? order by left_value asc", pNode.getLeftValue(), pNode.getRightValue());
        return buildInternalTree(ctx, nodeList);
    }


    @Override
    public Node addChild(RetailscmUserContext ctx, Node nodeTree, String childId, String childType) throws Exception {
        Node root = ensureRoot(ctx);
        if (nodeTree == null) {
            nodeTree = root;
        }
        SmartList<TreeNode> nodes = loadTreeNode(ctx, childId, childType);

        if (!nodes.isEmpty()) {
            for (TreeNode node : nodes) {
                NodeImpl test = new NodeImpl();
                test.setTreeNode(node);
                if (nodeTree.hasDescender(test)) {
                    return nodeTree;
                }
            }
        }

        TreeNode treeNode = nodeTree.getTreeNode();

        int rightValue = 1;
        if (treeNode != null) {
            rightValue = treeNode.getRightValue();
        }

        int childLeftValue = rightValue;
        int childRightValue = rightValue + 1;

        //update the left values and right values
        ((CommonJDBCTemplateDAO) treeNodeDaoOf(ctx))
                .singleUpdate("update tree_node_data set left_value = left_value + 2 where left_value > ?", new Object[]{rightValue});
        ((CommonJDBCTemplateDAO) treeNodeDaoOf(ctx))
                .singleUpdate("update tree_node_data set right_value = right_value + 2 where right_value >= ? ", new Object[]{rightValue});

        //create new tree node for the child
        TreeNode newTreeNode = treeNodeManagerOf(ctx).createTreeNode(ctx, childId, childType, childLeftValue, childRightValue);
        NodeImpl newNode = new NodeImpl();
        newNode.setTreeNode(newTreeNode);
        newNode.setValue(ctx.getDAOGroup().loadBasicData(childType, childId));


        nodeTree.visit(n -> {
            Node node = (Node) n;
            TreeNode currentTreeNode = node.getTreeNode();

            if (currentTreeNode == null) {
                return;
            }
            if (currentTreeNode.getRightValue() >= childLeftValue) {
                currentTreeNode.setRightValue(currentTreeNode.getRightValue() + 2);
            }
            if (currentTreeNode.getRightValue() > childLeftValue) {
                currentTreeNode.setRightValue(currentTreeNode.getRightValue() + 2);
            }
        });

        ((NodeImpl) nodeTree).addChild(newNode);
        return nodeTree;
    }

    public Node ensureRoot(RetailscmUserContext ctx) throws Exception {
        SmartList<TreeNode> treeNodeWithKey = loadTreeNode(ctx, "root", "root");

        TreeNode root = treeNodeWithKey.first();
        if (root == null) {
            root = treeNodeManagerOf(ctx).createTreeNode(ctx, "root", "root", 1, 2);
        }

        NodeImpl t = new NodeImpl();
        t.setTreeNode(root);
        return t;
    }

    @Override
    public Node deleteChild(RetailscmUserContext ctx, Node parent, Node child) throws Exception {
        //do nothing
        if (parent == null || child == null || parent.isEmpty() || child.isEmpty()) {
            return parent;
        }

        //do nothing
        if (!parent.hasDescender(child)) {
            return parent;
        }


        int toBeRemovedCount = child.descendersCount() + 1;
        int leftValue = child.getTreeNode().getLeftValue();
        int rightValue = child.getTreeNode().getRightValue();

        //delete nodes
        ((CommonJDBCTemplateDAO) treeNodeDaoOf(ctx))
                .singleUpdate("delete from tree_node_data where left_value >= ? and right_value <= ?", new Object[]{leftValue, rightValue});

        ((CommonJDBCTemplateDAO) treeNodeDaoOf(ctx))
                .singleUpdate("update tree_node_data set left_value = left_value - ? where left_value > ?  ", new Object[]{toBeRemovedCount * 2, rightValue});

        ((CommonJDBCTemplateDAO) treeNodeDaoOf(ctx))
                .singleUpdate("update tree_node_data set right_value = right_value - ? where right_value > ?", new Object[]{toBeRemovedCount * 2, rightValue});


        //delete nodes in parent
        Node childParent = parent.navigate(child.getTreeNode().getNodeType(), child.getTreeNode().getNodeId()).parent();
        List children = childParent.children();
        children.removeIf(n -> n.equals(child));

        //remove tree nodes
        parent.visit(n -> {
            Node node = (Node) n;
            TreeNode currentTreeNode = node.getTreeNode();

            if (currentTreeNode == null) {
                return;
            }
            if (currentTreeNode.getLeftValue() > rightValue) {
                currentTreeNode.setLeftValue(currentTreeNode.getLeftValue() - toBeRemovedCount * 2);
            }
            if (currentTreeNode.getRightValue() > rightValue) {
                currentTreeNode.setRightValue(currentTreeNode.getRightValue() - toBeRemovedCount * 2);
            }
        });
        return parent;
    }

    private Node buildInternalTree(RetailscmUserContext ctx, final List<TreeNode> pTreeNodes) throws Exception {
        if (pTreeNodes == null || pTreeNodes.isEmpty()) {
            return null;
        }

        List<TreeNode> treeNodeList = new ArrayList<>(pTreeNodes);
        //collect item ids
        Map<String, List<String>> typeIds = treeNodeList.stream().collect(Collectors.toMap(TreeNode::getNodeType,
                n -> {
                    String id = n.getNodeId();
                    List<String> ids = new ArrayList<>();
                    ids.add(id);
                    return ids;
                },
                (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                })
        );

        //enhance items, type-> (id->item)
        Map<String, Map<String, BaseEntity>> typeItems = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : typeIds.entrySet()) {
            String k = entry.getKey();
            List<String> v = entry.getValue();
            List<BaseEntity> list = ctx.getDAOGroup().wrapperList(k, v);
            if (list == null) {
            	continue;
            }
            ctx.getDAOGroup().enhanceList(list, k);
            typeItems.put(k, list.stream().collect(Collectors.toMap(BaseEntity::getId, item -> item, (v1, v2) -> v2)));
        }

        NodeImpl root = new NodeImpl();
        NodeImpl preNode = null;
        for (TreeNode node : treeNodeList) {
            String nodeId = node.getNodeId();
            String nodeType = node.getNodeType();

            BaseEntity item = null;
            Map<String, BaseEntity> items = typeItems.get(nodeType);
            if (items != null) {
                item = items.get(nodeId);
            }

            //set root value, level
            if (preNode == null) {
                preNode = root;
                preNode.setValue(item);
                preNode.setTreeNode(node);
                continue;
            }

            //create new node
            final NodeImpl newNode = new NodeImpl();
            newNode.setValue(item);
            newNode.setTreeNode(node);

            //find parent node
            NodeImpl parent = preNode;
            while (!newNode.hasAncestor(parent)) {
                parent = (NodeImpl) parent.getParent();
            }
            //set parent
            parent.addChild(newNode);

            preNode = newNode;
        }
        return root;
    }
}





















