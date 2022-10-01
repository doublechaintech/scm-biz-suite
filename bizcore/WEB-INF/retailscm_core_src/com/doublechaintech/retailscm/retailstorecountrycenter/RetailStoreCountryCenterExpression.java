package com.doublechaintech.retailscm.retailstorecountrycenter;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreCountryCenterExpression<T>
    implements Expression<T, RetailStoreCountryCenter> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
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
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getServiceNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getServiceNumber();
      }
    };
  }

  public Expression<T, DateTime> getFounded() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFounded();
      }
    };
  }

  public Expression<T, String> getWebSite() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWebSite();
      }
    };
  }

  public Expression<T, String> getAddress() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAddress();
      }
    };
  }

  public Expression<T, String> getOperatedBy() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOperatedBy();
      }
    };
  }

  public Expression<T, String> getLegalRepresentative() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLegalRepresentative();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.catalog.CatalogSmartListExpression<T> getCatalogList() {
    return new com.doublechaintech.retailscm.catalog.CatalogSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Catalog> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCatalogList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreprovincecenter
              .RetailStoreProvinceCenterSmartListExpression<
          T>
      getRetailStoreProvinceCenterList() {
    return new com.doublechaintech.retailscm.retailstoreprovincecenter
            .RetailStoreProvinceCenterSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreProvinceCenter> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreProvinceCenterList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstore.RetailStoreSmartListExpression<T>
      getRetailStoreList() {
    return new com.doublechaintech.retailscm.retailstore.RetailStoreSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStore> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberSmartListExpression<T>
      getRetailStoreMemberList() {
    return new com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreMember> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreMemberList();
      }
    };
  }

  public com.doublechaintech.retailscm.goodssupplier.GoodsSupplierSmartListExpression<T>
      getGoodsSupplierList() {
    return new com.doublechaintech.retailscm.goodssupplier.GoodsSupplierSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<GoodsSupplier> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsSupplierList();
      }
    };
  }

  public com.doublechaintech.retailscm.supplyorder.SupplyOrderSmartListExpression<T>
      getSupplyOrderList() {
    return new com.doublechaintech.retailscm.supplyorder.SupplyOrderSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SupplyOrder> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplyOrderList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderSmartListExpression<T>
      getRetailStoreOrderList() {
    return new com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreOrder> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreOrderList();
      }
    };
  }

  public com.doublechaintech.retailscm.warehouse.WarehouseSmartListExpression<T>
      getWarehouseList() {
    return new com.doublechaintech.retailscm.warehouse.WarehouseSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Warehouse> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWarehouseList();
      }
    };
  }

  public com.doublechaintech.retailscm.transportfleet.TransportFleetSmartListExpression<T>
      getTransportFleetList() {
    return new com.doublechaintech.retailscm.transportfleet.TransportFleetSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TransportFleet> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTransportFleetList();
      }
    };
  }

  public com.doublechaintech.retailscm.accountset.AccountSetSmartListExpression<T>
      getAccountSetList() {
    return new com.doublechaintech.retailscm.accountset.AccountSetSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountSet> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountSetList();
      }
    };
  }

  public com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentSmartListExpression<T>
      getLevelOneDepartmentList() {
    return new com.doublechaintech.retailscm.levelonedepartment
            .LevelOneDepartmentSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<LevelOneDepartment> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLevelOneDepartmentList();
      }
    };
  }

  public com.doublechaintech.retailscm.skilltype.SkillTypeSmartListExpression<T>
      getSkillTypeList() {
    return new com.doublechaintech.retailscm.skilltype.SkillTypeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SkillType> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSkillTypeList();
      }
    };
  }

  public com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeSmartListExpression<T>
      getResponsibilityTypeList() {
    return new com.doublechaintech.retailscm.responsibilitytype
            .ResponsibilityTypeSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ResponsibilityType> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getResponsibilityTypeList();
      }
    };
  }

  public com.doublechaintech.retailscm.terminationreason.TerminationReasonSmartListExpression<T>
      getTerminationReasonList() {
    return new com.doublechaintech.retailscm.terminationreason.TerminationReasonSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TerminationReason> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTerminationReasonList();
      }
    };
  }

  public com.doublechaintech.retailscm.terminationtype.TerminationTypeSmartListExpression<T>
      getTerminationTypeList() {
    return new com.doublechaintech.retailscm.terminationtype.TerminationTypeSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TerminationType> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTerminationTypeList();
      }
    };
  }

  public com.doublechaintech.retailscm.occupationtype.OccupationTypeSmartListExpression<T>
      getOccupationTypeList() {
    return new com.doublechaintech.retailscm.occupationtype.OccupationTypeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<OccupationType> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOccupationTypeList();
      }
    };
  }

  public com.doublechaintech.retailscm.leavetype.LeaveTypeSmartListExpression<T>
      getLeaveTypeList() {
    return new com.doublechaintech.retailscm.leavetype.LeaveTypeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<LeaveType> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLeaveTypeList();
      }
    };
  }

  public com.doublechaintech.retailscm.salarygrade.SalaryGradeSmartListExpression<T>
      getSalaryGradeList() {
    return new com.doublechaintech.retailscm.salarygrade.SalaryGradeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SalaryGrade> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSalaryGradeList();
      }
    };
  }

  public com.doublechaintech.retailscm.interviewtype.InterviewTypeSmartListExpression<T>
      getInterviewTypeList() {
    return new com.doublechaintech.retailscm.interviewtype.InterviewTypeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<InterviewType> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getInterviewTypeList();
      }
    };
  }

  public com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeSmartListExpression<T>
      getTrainingCourseTypeList() {
    return new com.doublechaintech.retailscm.trainingcoursetype
            .TrainingCourseTypeSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TrainingCourseType> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTrainingCourseTypeList();
      }
    };
  }

  public com.doublechaintech.retailscm.publicholiday.PublicHolidaySmartListExpression<T>
      getPublicHolidayList() {
    return new com.doublechaintech.retailscm.publicholiday.PublicHolidaySmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PublicHoliday> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPublicHolidayList();
      }
    };
  }

  public com.doublechaintech.retailscm.employee.EmployeeSmartListExpression<T> getEmployeeList() {
    return new com.doublechaintech.retailscm.employee.EmployeeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Employee> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeList();
      }
    };
  }

  public com.doublechaintech.retailscm.instructor.InstructorSmartListExpression<T>
      getInstructorList() {
    return new com.doublechaintech.retailscm.instructor.InstructorSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Instructor> eval(T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getInstructorList();
      }
    };
  }

  public com.doublechaintech.retailscm.companytraining.CompanyTrainingSmartListExpression<T>
      getCompanyTrainingList() {
    return new com.doublechaintech.retailscm.companytraining.CompanyTrainingSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<CompanyTraining> eval(
          T retailStoreCountryCenter) {
        RetailStoreCountryCenter parent =
            RetailStoreCountryCenterExpression.this.eval(retailStoreCountryCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompanyTrainingList();
      }
    };
  }
}
