package com.doublechaintech.retailscm.slide;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SlideExpression<T> implements Expression<T, Slide> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SlideExpression.this.$getRoot();
      }

      @Override
      public String eval(T slide) {
        Slide parent = SlideExpression.this.eval(slide);
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
        return SlideExpression.this.$getRoot();
      }

      @Override
      public String eval(T slide) {
        Slide parent = SlideExpression.this.eval(slide);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, Integer> getDisplayOrder() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SlideExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T slide) {
        Slide parent = SlideExpression.this.eval(slide);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDisplayOrder();
      }
    };
  }

  public Expression<T, String> getImageUrl() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SlideExpression.this.$getRoot();
      }

      @Override
      public String eval(T slide) {
        Slide parent = SlideExpression.this.eval(slide);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getImageUrl();
      }
    };
  }

  public Expression<T, String> getVideoUrl() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SlideExpression.this.$getRoot();
      }

      @Override
      public String eval(T slide) {
        Slide parent = SlideExpression.this.eval(slide);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVideoUrl();
      }
    };
  }

  public Expression<T, String> getLinkToUrl() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SlideExpression.this.$getRoot();
      }

      @Override
      public String eval(T slide) {
        Slide parent = SlideExpression.this.eval(slide);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLinkToUrl();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SlideExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T slide) {
        Slide parent = SlideExpression.this.eval(slide);
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
        return SlideExpression.this.$getRoot();
      }

      public Page eval(T slide) {
        Slide parent = SlideExpression.this.eval(slide);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPage();
      }
    };
  }
}
