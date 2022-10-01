package com.doublechaintech.retailscm.mobileapp;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class MobileAppExpression<T> implements Expression<T, MobileApp> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return MobileAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T mobileApp) {
        MobileApp parent = MobileAppExpression.this.eval(mobileApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return MobileAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T mobileApp) {
        MobileApp parent = MobileAppExpression.this.eval(mobileApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return MobileAppExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T mobileApp) {
        MobileApp parent = MobileAppExpression.this.eval(mobileApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.page.PageSmartListExpression<T> getPageList() {
    return new com.doublechaintech.retailscm.page.PageSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return MobileAppExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Page> eval(T mobileApp) {
        MobileApp parent = MobileAppExpression.this.eval(mobileApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPageList();
      }
    };
  }

  public com.doublechaintech.retailscm.pagetype.PageTypeSmartListExpression<T> getPageTypeList() {
    return new com.doublechaintech.retailscm.pagetype.PageTypeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return MobileAppExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PageType> eval(T mobileApp) {
        MobileApp parent = MobileAppExpression.this.eval(mobileApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPageTypeList();
      }
    };
  }
}
