package com.doublechaintech.retailscm.retailstore;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreExpression<T> implements Expression<T, RetailStore> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
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
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getTelephone() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTelephone();
      }
    };
  }

  public Expression<T, String> getOwner() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }

  public Expression<T, DateTime> getFounded() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFounded();
      }
    };
  }

  public Expression<T, BigDecimal> getLatitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLatitude();
      }
    };
  }

  public Expression<T, BigDecimal> getLongitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLongitude();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
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
        return RetailStoreExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getRetailStoreCountryCenter() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreCountryCenter();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecityservicecenter
              .RetailStoreCityServiceCenterExpression<
          T>
      getCityServiceCenter() {
    return new com.doublechaintech.retailscm.retailstorecityservicecenter
            .RetailStoreCityServiceCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public RetailStoreCityServiceCenter eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityServiceCenter();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationExpression<T>
      getCreation() {
    return new com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public RetailStoreCreation eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCreation();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreinvestmentinvitation
              .RetailStoreInvestmentInvitationExpression<
          T>
      getInvestmentInvitation() {
    return new com.doublechaintech.retailscm.retailstoreinvestmentinvitation
            .RetailStoreInvestmentInvitationExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public RetailStoreInvestmentInvitation eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getInvestmentInvitation();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingExpression<T>
      getFranchising() {
    return new com.doublechaintech.retailscm.retailstorefranchising
            .RetailStoreFranchisingExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public RetailStoreFranchising eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFranchising();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationExpression<T>
      getDecoration() {
    return new com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public RetailStoreDecoration eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDecoration();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningExpression<T>
      getOpening() {
    return new com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningExpression<T>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public RetailStoreOpening eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOpening();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingExpression<T>
      getClosing() {
    return new com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingExpression<T>() {
      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public RetailStoreClosing eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getClosing();
      }
    };
  }

  public com.doublechaintech.retailscm.consumerorder.ConsumerOrderSmartListExpression<T>
      getConsumerOrderList() {
    return new com.doublechaintech.retailscm.consumerorder.ConsumerOrderSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ConsumerOrder> eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getConsumerOrderList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderSmartListExpression<T>
      getRetailStoreOrderList() {
    return new com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreOrder> eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreOrderList();
      }
    };
  }

  public com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T> getGoodsList() {
    return new com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Goods> eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsList();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttask.TransportTaskSmartListExpression<T>
      getTransportTaskList() {
    return new com.doublechaintech.retailscm.transporttask.TransportTaskSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TransportTask> eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTransportTaskList();
      }
    };
  }

  public com.doublechaintech.retailscm.accountset.AccountSetSmartListExpression<T>
      getAccountSetList() {
    return new com.doublechaintech.retailscm.accountset.AccountSetSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountSet> eval(T retailStore) {
        RetailStore parent = RetailStoreExpression.this.eval(retailStore);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountSetList();
      }
    };
  }
}
