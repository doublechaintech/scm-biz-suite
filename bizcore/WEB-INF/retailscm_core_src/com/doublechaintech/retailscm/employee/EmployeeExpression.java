package com.doublechaintech.retailscm.employee;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeExpression<T> implements Expression<T, Employee> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
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
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, String> getFamilyName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFamilyName();
      }
    };
  }

  public Expression<T, String> getGivenName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGivenName();
      }
    };
  }

  public Expression<T, String> getEmail() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmail();
      }
    };
  }

  public Expression<T, String> getCity() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCity();
      }
    };
  }

  public Expression<T, String> getAddress() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAddress();
      }
    };
  }

  public Expression<T, String> getCellPhone() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCellPhone();
      }
    };
  }

  public Expression<T, String> getSalaryAccount() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSalaryAccount();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
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
        return EmployeeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
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
        return EmployeeExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentExpression<T>
      getDepartment() {
    return new com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentExpression<
        T>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public LevelThreeDepartment eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDepartment();
      }
    };
  }

  public com.doublechaintech.retailscm.occupationtype.OccupationTypeExpression<T> getOccupation() {
    return new com.doublechaintech.retailscm.occupationtype.OccupationTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public OccupationType eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOccupation();
      }
    };
  }

  public com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeExpression<T>
      getResponsibleFor() {
    return new com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public ResponsibilityType eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getResponsibleFor();
      }
    };
  }

  public com.doublechaintech.retailscm.salarygrade.SalaryGradeExpression<T>
      getCurrentSalaryGrade() {
    return new com.doublechaintech.retailscm.salarygrade.SalaryGradeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public SalaryGrade eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCurrentSalaryGrade();
      }
    };
  }

  public com.doublechaintech.retailscm.employeecompanytraining
              .EmployeeCompanyTrainingSmartListExpression<
          T>
      getEmployeeCompanyTrainingList() {
    return new com.doublechaintech.retailscm.employeecompanytraining
            .EmployeeCompanyTrainingSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeCompanyTraining> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeCompanyTrainingList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeskill.EmployeeSkillSmartListExpression<T>
      getEmployeeSkillList() {
    return new com.doublechaintech.retailscm.employeeskill.EmployeeSkillSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeSkill> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeSkillList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceSmartListExpression<T>
      getEmployeePerformanceList() {
    return new com.doublechaintech.retailscm.employeeperformance
            .EmployeePerformanceSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeePerformance> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeePerformanceList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeworkexperience
              .EmployeeWorkExperienceSmartListExpression<
          T>
      getEmployeeWorkExperienceList() {
    return new com.doublechaintech.retailscm.employeeworkexperience
            .EmployeeWorkExperienceSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeWorkExperience> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeWorkExperienceList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeleave.EmployeeLeaveSmartListExpression<T>
      getEmployeeLeaveList() {
    return new com.doublechaintech.retailscm.employeeleave.EmployeeLeaveSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeLeave> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeLeaveList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewSmartListExpression<T>
      getEmployeeInterviewList() {
    return new com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeInterview> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeInterviewList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceSmartListExpression<T>
      getEmployeeAttendanceList() {
    return new com.doublechaintech.retailscm.employeeattendance
            .EmployeeAttendanceSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeAttendance> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeAttendanceList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierSmartListExpression<T>
      getEmployeeQualifierList() {
    return new com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeQualifier> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeQualifierList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeeducation.EmployeeEducationSmartListExpression<T>
      getEmployeeEducationList() {
    return new com.doublechaintech.retailscm.employeeeducation.EmployeeEducationSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeEducation> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeEducationList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeaward.EmployeeAwardSmartListExpression<T>
      getEmployeeAwardList() {
    return new com.doublechaintech.retailscm.employeeaward.EmployeeAwardSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeAward> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeAwardList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetSmartListExpression<T>
      getEmployeeSalarySheetList() {
    return new com.doublechaintech.retailscm.employeesalarysheet
            .EmployeeSalarySheetSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeSalarySheet> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeSalarySheetList();
      }
    };
  }

  public com.doublechaintech.retailscm.payingoff.PayingOffSmartListExpression<T>
      getPayingOffList() {
    return new com.doublechaintech.retailscm.payingoff.PayingOffSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return EmployeeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PayingOff> eval(T employee) {
        Employee parent = EmployeeExpression.this.eval(employee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPayingOffList();
      }
    };
  }
}
