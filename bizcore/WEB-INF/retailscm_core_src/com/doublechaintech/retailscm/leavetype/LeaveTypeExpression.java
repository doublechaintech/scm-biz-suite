package com.doublechaintech.retailscm.leavetype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class LeaveTypeExpression<T> implements Expression<T, LeaveType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LeaveTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T leaveType) {
        LeaveType parent = LeaveTypeExpression.this.eval(leaveType);
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
        return LeaveTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T leaveType) {
        LeaveType parent = LeaveTypeExpression.this.eval(leaveType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LeaveTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T leaveType) {
        LeaveType parent = LeaveTypeExpression.this.eval(leaveType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, String> getDetailDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LeaveTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T leaveType) {
        LeaveType parent = LeaveTypeExpression.this.eval(leaveType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDetailDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return LeaveTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T leaveType) {
        LeaveType parent = LeaveTypeExpression.this.eval(leaveType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getCompany() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return LeaveTypeExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T leaveType) {
        LeaveType parent = LeaveTypeExpression.this.eval(leaveType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeleave.EmployeeLeaveSmartListExpression<T>
      getEmployeeLeaveList() {
    return new com.doublechaintech.retailscm.employeeleave.EmployeeLeaveSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return LeaveTypeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeLeave> eval(T leaveType) {
        LeaveType parent = LeaveTypeExpression.this.eval(leaveType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeLeaveList();
      }
    };
  }
}
