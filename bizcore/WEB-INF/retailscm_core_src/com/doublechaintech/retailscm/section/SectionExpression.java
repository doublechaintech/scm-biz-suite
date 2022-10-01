package com.doublechaintech.retailscm.section;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SectionExpression<T> implements Expression<T, Section> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SectionExpression.this.$getRoot();
      }

      @Override
      public String eval(T section) {
        Section parent = SectionExpression.this.eval(section);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SectionExpression.this.$getRoot();
      }

      @Override
      public String eval(T section) {
        Section parent = SectionExpression.this.eval(section);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, String> getBrief() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SectionExpression.this.$getRoot();
      }

      @Override
      public String eval(T section) {
        Section parent = SectionExpression.this.eval(section);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBrief();
      }
    };
  }

  public Expression<T, String> getIcon() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SectionExpression.this.$getRoot();
      }

      @Override
      public String eval(T section) {
        Section parent = SectionExpression.this.eval(section);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getIcon();
      }
    };
  }

  public Expression<T, Integer> getDisplayOrder() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SectionExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T section) {
        Section parent = SectionExpression.this.eval(section);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDisplayOrder();
      }
    };
  }

  public Expression<T, String> getViewGroup() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SectionExpression.this.$getRoot();
      }

      @Override
      public String eval(T section) {
        Section parent = SectionExpression.this.eval(section);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getViewGroup();
      }
    };
  }

  public Expression<T, String> getLinkToUrl() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SectionExpression.this.$getRoot();
      }

      @Override
      public String eval(T section) {
        Section parent = SectionExpression.this.eval(section);
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
        return SectionExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T section) {
        Section parent = SectionExpression.this.eval(section);
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
        return SectionExpression.this.$getRoot();
      }

      public Page eval(T section) {
        Section parent = SectionExpression.this.eval(section);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPage();
      }
    };
  }
}
