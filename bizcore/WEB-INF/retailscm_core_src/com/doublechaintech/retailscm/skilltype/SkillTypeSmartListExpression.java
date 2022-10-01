package com.doublechaintech.retailscm.skilltype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SkillTypeSmartListExpression<T> extends SmartListExpression<T, SkillType> {
  public SkillTypeExpression<T> first() {
    return new SkillTypeExpression<T>() {
      @Override
      public SkillType eval(T l) {
        List<SkillType> list = SkillTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SkillTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public SkillTypeExpression<T> get(int index) {
    return new SkillTypeExpression<T>() {
      @Override
      public SkillType eval(T l) {
        List<SkillType> list = SkillTypeSmartListExpression.this.eval(l);
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
        return SkillTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
