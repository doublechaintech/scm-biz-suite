package com.doublechaintech.retailscm.pagetype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.mobileapp.MobileApp;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class PageTypeExpression<T> implements Expression<T, PageType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PageTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T pageType) {
        PageType parent = PageTypeExpression.this.eval(pageType);
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
        return PageTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T pageType) {
        PageType parent = PageTypeExpression.this.eval(pageType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getCode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PageTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T pageType) {
        PageType parent = PageTypeExpression.this.eval(pageType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, Boolean> getFooterTab() {
    return new Expression<T, Boolean>() {
      @Override
      public T $getRoot() {
        return PageTypeExpression.this.$getRoot();
      }

      @Override
      public Boolean eval(T pageType) {
        PageType parent = PageTypeExpression.this.eval(pageType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFooterTab();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return PageTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T pageType) {
        PageType parent = PageTypeExpression.this.eval(pageType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.mobileapp.MobileAppExpression<T> getMobileApp() {
    return new com.doublechaintech.retailscm.mobileapp.MobileAppExpression<T>() {
      @Override
      public T $getRoot() {
        return PageTypeExpression.this.$getRoot();
      }

      public MobileApp eval(T pageType) {
        PageType parent = PageTypeExpression.this.eval(pageType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobileApp();
      }
    };
  }
}
