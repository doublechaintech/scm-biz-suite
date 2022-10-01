package com.doublechaintech.retailscm.page;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class PageExpression<T> implements Expression<T, Page> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public String eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getPageTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public String eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPageTitle();
      }
    };
  }

  public Expression<T, String> getLinkToUrl() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public String eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLinkToUrl();
      }
    };
  }

  public Expression<T, Integer> getDisplayOrder() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDisplayOrder();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.pagetype.PageTypeExpression<T> getPageType() {
    return new com.doublechaintech.retailscm.pagetype.PageTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public PageType eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPageType();
      }
    };
  }

  public com.doublechaintech.retailscm.mobileapp.MobileAppExpression<T> getMobileApp() {
    return new com.doublechaintech.retailscm.mobileapp.MobileAppExpression<T>() {
      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public MobileApp eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobileApp();
      }
    };
  }

  public com.doublechaintech.retailscm.slide.SlideSmartListExpression<T> getSlideList() {
    return new com.doublechaintech.retailscm.slide.SlideSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Slide> eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSlideList();
      }
    };
  }

  public com.doublechaintech.retailscm.uiaction.UiActionSmartListExpression<T> getUiActionList() {
    return new com.doublechaintech.retailscm.uiaction.UiActionSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<UiAction> eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUiActionList();
      }
    };
  }

  public com.doublechaintech.retailscm.section.SectionSmartListExpression<T> getSectionList() {
    return new com.doublechaintech.retailscm.section.SectionSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return PageExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Section> eval(T page) {
        Page parent = PageExpression.this.eval(page);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSectionList();
      }
    };
  }
}
