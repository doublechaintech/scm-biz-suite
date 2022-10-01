package com.doublechaintech.retailscm.uiaction;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class UiActionExpression<T> implements Expression<T, UiAction> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public String eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getCode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public String eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getIcon() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public String eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getIcon();
      }
    };
  }

  public Expression<T, String> getTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public String eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, Integer> getDisplayOrder() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDisplayOrder();
      }
    };
  }

  public Expression<T, String> getBrief() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public String eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBrief();
      }
    };
  }

  public Expression<T, String> getImageUrl() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public String eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getImageUrl();
      }
    };
  }

  public Expression<T, String> getLinkToUrl() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public String eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLinkToUrl();
      }
    };
  }

  public Expression<T, String> getExtraData() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public String eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getExtraData();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.page.PageExpression<T> getPage() {
    return new com.doublechaintech.retailscm.page.PageExpression<T>() {
      @Override
      public T $getRoot() {
        return UiActionExpression.this.$getRoot();
      }

      public Page eval(T uiAction) {
        UiAction parent = UiActionExpression.this.eval(uiAction);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPage();
      }
    };
  }
}
