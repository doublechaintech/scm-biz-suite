package com.doublechaintech.retailscm.treenode;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TreeNodeSmartListExpression<T> extends SmartListExpression<T, TreeNode> {
  public TreeNodeExpression<T> first() {
    return new TreeNodeExpression<T>() {
      @Override
      public TreeNode eval(T l) {
        List<TreeNode> list = TreeNodeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TreeNodeSmartListExpression.this.$getRoot();
      }
    };
  }

  public TreeNodeExpression<T> get(int index) {
    return new TreeNodeExpression<T>() {
      @Override
      public TreeNode eval(T l) {
        List<TreeNode> list = TreeNodeSmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

      @Override
      public T $getRoot() {
        return TreeNodeSmartListExpression.this.$getRoot();
      }
    };
  }
}
