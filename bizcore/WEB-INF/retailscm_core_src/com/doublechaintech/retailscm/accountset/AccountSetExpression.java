package com.doublechaintech.retailscm.accountset;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class AccountSetExpression<T> implements Expression<T, AccountSet> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
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
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getYearSet() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getYearSet();
      }
    };
  }

  public Expression<T, DateTime> getEffectiveDate() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEffectiveDate();
      }
    };
  }

  public Expression<T, String> getAccountingSystem() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingSystem();
      }
    };
  }

  public Expression<T, String> getDomesticCurrencyCode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDomesticCurrencyCode();
      }
    };
  }

  public Expression<T, String> getDomesticCurrencyName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDomesticCurrencyName();
      }
    };
  }

  public Expression<T, String> getOpeningBank() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOpeningBank();
      }
    };
  }

  public Expression<T, String> getAccountNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountNumber();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLastUpdateTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getCountryCenter() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCountryCenter();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T> getRetailStore() {
    return new com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      public RetailStore eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStore();
      }
    };
  }

  public com.doublechaintech.retailscm.goodssupplier.GoodsSupplierExpression<T> getGoodsSupplier() {
    return new com.doublechaintech.retailscm.goodssupplier.GoodsSupplierExpression<T>() {
      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      public GoodsSupplier eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsSupplier();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingsubject.AccountingSubjectSmartListExpression<T>
      getAccountingSubjectList() {
    return new com.doublechaintech.retailscm.accountingsubject.AccountingSubjectSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountingSubject> eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingSubjectList();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingperiod.AccountingPeriodSmartListExpression<T>
      getAccountingPeriodList() {
    return new com.doublechaintech.retailscm.accountingperiod.AccountingPeriodSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountingPeriod> eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingPeriodList();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingdocumenttype
              .AccountingDocumentTypeSmartListExpression<
          T>
      getAccountingDocumentTypeList() {
    return new com.doublechaintech.retailscm.accountingdocumenttype
            .AccountingDocumentTypeSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return AccountSetExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountingDocumentType> eval(T accountSet) {
        AccountSet parent = AccountSetExpression.this.eval(accountSet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingDocumentTypeList();
      }
    };
  }
}
