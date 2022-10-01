package com.doublechaintech.retailscm.catalog;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class CatalogExpression<T> implements Expression<T, Catalog> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CatalogExpression.this.$getRoot();
      }

      @Override
      public String eval(T catalog) {
        Catalog parent = CatalogExpression.this.eval(catalog);
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
        return CatalogExpression.this.$getRoot();
      }

      @Override
      public String eval(T catalog) {
        Catalog parent = CatalogExpression.this.eval(catalog);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, Integer> getSubCount() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return CatalogExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T catalog) {
        Catalog parent = CatalogExpression.this.eval(catalog);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSubCount();
      }
    };
  }

  public Expression<T, BigDecimal> getAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return CatalogExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T catalog) {
        Catalog parent = CatalogExpression.this.eval(catalog);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAmount();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return CatalogExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T catalog) {
        Catalog parent = CatalogExpression.this.eval(catalog);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getOwner() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return CatalogExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T catalog) {
        Catalog parent = CatalogExpression.this.eval(catalog);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }

  public com.doublechaintech.retailscm.levelonecategory.LevelOneCategorySmartListExpression<T>
      getLevelOneCategoryList() {
    return new com.doublechaintech.retailscm.levelonecategory.LevelOneCategorySmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return CatalogExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<LevelOneCategory> eval(T catalog) {
        Catalog parent = CatalogExpression.this.eval(catalog);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLevelOneCategoryList();
      }
    };
  }
}
