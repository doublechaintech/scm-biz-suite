package com.doublechaintech.retailscm.treenode;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TreeNodeExpression<T> implements Expression<T, TreeNode> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TreeNodeExpression.this.$getRoot();
      }

      @Override
      public String eval(T treeNode) {
        TreeNode parent = TreeNodeExpression.this.eval(treeNode);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getNodeId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TreeNodeExpression.this.$getRoot();
      }

      @Override
      public String eval(T treeNode) {
        TreeNode parent = TreeNodeExpression.this.eval(treeNode);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getNodeId();
      }
    };
  }

  public Expression<T, String> getNodeType() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TreeNodeExpression.this.$getRoot();
      }

      @Override
      public String eval(T treeNode) {
        TreeNode parent = TreeNodeExpression.this.eval(treeNode);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getNodeType();
      }
    };
  }

  public Expression<T, Integer> getLeftValue() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TreeNodeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T treeNode) {
        TreeNode parent = TreeNodeExpression.this.eval(treeNode);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLeftValue();
      }
    };
  }

  public Expression<T, Integer> getRightValue() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TreeNodeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T treeNode) {
        TreeNode parent = TreeNodeExpression.this.eval(treeNode);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRightValue();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TreeNodeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T treeNode) {
        TreeNode parent = TreeNodeExpression.this.eval(treeNode);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }
}
