package com.doublechaintech.retailscm.retailstoremember;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreMemberExpression<T> implements Expression<T, RetailStoreMember> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
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
        return RetailStoreMemberExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getMobilePhone() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobilePhone();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
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
        return RetailStoreMemberExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }

  public com.doublechaintech.retailscm.consumerorder.ConsumerOrderSmartListExpression<T>
      getConsumerOrderList() {
    return new com.doublechaintech.retailscm.consumerorder.ConsumerOrderSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ConsumerOrder> eval(T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getConsumerOrderList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremembercoupon
              .RetailStoreMemberCouponSmartListExpression<
          T>
      getRetailStoreMemberCouponList() {
    return new com.doublechaintech.retailscm.retailstoremembercoupon
            .RetailStoreMemberCouponSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreMemberCoupon> eval(
          T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreMemberCouponList();
      }
    };
  }

  public com.doublechaintech.retailscm.memberwishlist.MemberWishlistSmartListExpression<T>
      getMemberWishlistList() {
    return new com.doublechaintech.retailscm.memberwishlist.MemberWishlistSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<MemberWishlist> eval(T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMemberWishlistList();
      }
    };
  }

  public com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointSmartListExpression<T>
      getMemberRewardPointList() {
    return new com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<MemberRewardPoint> eval(T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMemberRewardPointList();
      }
    };
  }

  public com.doublechaintech.retailscm.memberrewardpointredemption
              .MemberRewardPointRedemptionSmartListExpression<
          T>
      getMemberRewardPointRedemptionList() {
    return new com.doublechaintech.retailscm.memberrewardpointredemption
            .MemberRewardPointRedemptionSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<MemberRewardPointRedemption> eval(
          T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMemberRewardPointRedemptionList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorememberaddress
              .RetailStoreMemberAddressSmartListExpression<
          T>
      getRetailStoreMemberAddressList() {
    return new com.doublechaintech.retailscm.retailstorememberaddress
            .RetailStoreMemberAddressSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreMemberAddress> eval(
          T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreMemberAddressList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremembergiftcard
              .RetailStoreMemberGiftCardSmartListExpression<
          T>
      getRetailStoreMemberGiftCardList() {
    return new com.doublechaintech.retailscm.retailstoremembergiftcard
            .RetailStoreMemberGiftCardSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreMemberExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreMemberGiftCard> eval(
          T retailStoreMember) {
        RetailStoreMember parent = RetailStoreMemberExpression.this.eval(retailStoreMember);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreMemberGiftCardList();
      }
    };
  }
}
