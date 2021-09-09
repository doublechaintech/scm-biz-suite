package com.doublechaintech.retailscm.employeesalarysheet;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.payingoff.PayingOffRequest;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet.*;

public class EmployeeSalarySheetRequest extends BaseRequest<EmployeeSalarySheet> {
    public static EmployeeSalarySheetRequest newInstance() {
        return new EmployeeSalarySheetRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeSalarySheet";
    }

    public EmployeeSalarySheetRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeSalarySheetRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeSalarySheetRequest selectAll() {return this.selectId().selectEmployee().selectCurrentSalaryGrade().selectBaseSalary().selectBonus().selectReward().selectPersonalTax().selectSocialSecurity().selectHousingFound().selectJobInsurance().selectPayingOff().selectVersion();
    }

    public EmployeeSalarySheetRequest selectSelf() {return this.selectId().selectBaseSalary().selectBonus().selectReward().selectPersonalTax().selectSocialSecurity().selectHousingFound().selectJobInsurance().selectVersion();
    }

    public EmployeeSalarySheetRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeSalarySheetRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeSalarySheetRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeSalarySheetRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeSalarySheetRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSalarySheetRequest filterByBaseSalary(BigDecimal baseSalary) {
          
          if (baseSalary == null) {
              return this;
          }
          
          return filterByBaseSalary(QueryOperator.EQUAL, baseSalary);
      }
    

      public EmployeeSalarySheetRequest filterByBaseSalary(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBaseSalarySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectBaseSalary(){
          return select(BASE_SALARY_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectBaseSalary(){
          return unselect(BASE_SALARY_PROPERTY);
      }

      public SearchCriteria getBaseSalarySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BASE_SALARY_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderByBaseSalary(boolean asc){
          addOrderBy(BASE_SALARY_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSalarySheetRequest filterByBonus(BigDecimal bonus) {
          
          if (bonus == null) {
              return this;
          }
          
          return filterByBonus(QueryOperator.EQUAL, bonus);
      }
    

      public EmployeeSalarySheetRequest filterByBonus(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBonusSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectBonus(){
          return select(BONUS_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectBonus(){
          return unselect(BONUS_PROPERTY);
      }

      public SearchCriteria getBonusSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BONUS_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderByBonus(boolean asc){
          addOrderBy(BONUS_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSalarySheetRequest filterByReward(BigDecimal reward) {
          
          if (reward == null) {
              return this;
          }
          
          return filterByReward(QueryOperator.EQUAL, reward);
      }
    

      public EmployeeSalarySheetRequest filterByReward(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRewardSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectReward(){
          return select(REWARD_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectReward(){
          return unselect(REWARD_PROPERTY);
      }

      public SearchCriteria getRewardSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REWARD_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderByReward(boolean asc){
          addOrderBy(REWARD_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSalarySheetRequest filterByPersonalTax(BigDecimal personalTax) {
          
          if (personalTax == null) {
              return this;
          }
          
          return filterByPersonalTax(QueryOperator.EQUAL, personalTax);
      }
    

      public EmployeeSalarySheetRequest filterByPersonalTax(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPersonalTaxSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectPersonalTax(){
          return select(PERSONAL_TAX_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectPersonalTax(){
          return unselect(PERSONAL_TAX_PROPERTY);
      }

      public SearchCriteria getPersonalTaxSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PERSONAL_TAX_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderByPersonalTax(boolean asc){
          addOrderBy(PERSONAL_TAX_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSalarySheetRequest filterBySocialSecurity(BigDecimal socialSecurity) {
          
          if (socialSecurity == null) {
              return this;
          }
          
          return filterBySocialSecurity(QueryOperator.EQUAL, socialSecurity);
      }
    

      public EmployeeSalarySheetRequest filterBySocialSecurity(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSocialSecuritySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectSocialSecurity(){
          return select(SOCIAL_SECURITY_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectSocialSecurity(){
          return unselect(SOCIAL_SECURITY_PROPERTY);
      }

      public SearchCriteria getSocialSecuritySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SOCIAL_SECURITY_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderBySocialSecurity(boolean asc){
          addOrderBy(SOCIAL_SECURITY_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSalarySheetRequest filterByHousingFound(BigDecimal housingFound) {
          
          if (housingFound == null) {
              return this;
          }
          
          return filterByHousingFound(QueryOperator.EQUAL, housingFound);
      }
    

      public EmployeeSalarySheetRequest filterByHousingFound(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getHousingFoundSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectHousingFound(){
          return select(HOUSING_FOUND_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectHousingFound(){
          return unselect(HOUSING_FOUND_PROPERTY);
      }

      public SearchCriteria getHousingFoundSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(HOUSING_FOUND_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderByHousingFound(boolean asc){
          addOrderBy(HOUSING_FOUND_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSalarySheetRequest filterByJobInsurance(BigDecimal jobInsurance) {
          
          if (jobInsurance == null) {
              return this;
          }
          
          return filterByJobInsurance(QueryOperator.EQUAL, jobInsurance);
      }
    

      public EmployeeSalarySheetRequest filterByJobInsurance(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getJobInsuranceSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectJobInsurance(){
          return select(JOB_INSURANCE_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectJobInsurance(){
          return unselect(JOB_INSURANCE_PROPERTY);
      }

      public SearchCriteria getJobInsuranceSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(JOB_INSURANCE_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderByJobInsurance(boolean asc){
          addOrderBy(JOB_INSURANCE_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSalarySheetRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeSalarySheetRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSalarySheetRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeSalarySheetRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSalarySheetRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeSalarySheetRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeSalarySheetRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeSalarySheetRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeSalarySheetRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeSalarySheetRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  

    
    public EmployeeSalarySheetRequest filterByCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade){
        return filterByCurrentSalaryGrade(currentSalaryGrade, currentSalaryGradeList -> currentSalaryGradeList.stream().map(SalaryGrade::getId).collect(Collectors.toSet()));
    }

    public EmployeeSalarySheetRequest filterByCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade, IDRefine<SalaryGrade> idRefine) {
        return addSearchCriteria(createCurrentSalaryGradeCriteria(currentSalaryGrade, idRefine));
    }

    public SearchCriteria createCurrentSalaryGradeCriteria(SalaryGradeRequest currentSalaryGrade, IDRefine<SalaryGrade> idRefine) {
        return new RefinedIdInCriteria(currentSalaryGrade, CURRENT_SALARY_GRADE_PROPERTY, idRefine);
    }
    

    
    public EmployeeSalarySheetRequest selectCurrentSalaryGrade(){
        return selectCurrentSalaryGrade(SalaryGradeRequest.newInstance().selectSelf());
    }

    public EmployeeSalarySheetRequest selectCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade){
        selectParent(CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGrade);
        return this;
    }
    

    public EmployeeSalarySheetRequest unselectCurrentSalaryGrade(){
        unselectParent(CURRENT_SALARY_GRADE_PROPERTY);
        return this;
    }

  

    
    public EmployeeSalarySheetRequest filterByPayingOff(PayingOffRequest payingOff){
        return filterByPayingOff(payingOff, payingOffList -> payingOffList.stream().map(PayingOff::getId).collect(Collectors.toSet()));
    }

    public EmployeeSalarySheetRequest filterByPayingOff(PayingOffRequest payingOff, IDRefine<PayingOff> idRefine) {
        return addSearchCriteria(createPayingOffCriteria(payingOff, idRefine));
    }

    public SearchCriteria createPayingOffCriteria(PayingOffRequest payingOff, IDRefine<PayingOff> idRefine) {
        return new RefinedIdInCriteria(payingOff, PAYING_OFF_PROPERTY, idRefine);
    }
    

    
    public EmployeeSalarySheetRequest selectPayingOff(){
        return selectPayingOff(PayingOffRequest.newInstance().selectSelf());
    }

    public EmployeeSalarySheetRequest selectPayingOff(PayingOffRequest payingOff){
        selectParent(PAYING_OFF_PROPERTY, payingOff);
        return this;
    }
    

    public EmployeeSalarySheetRequest unselectPayingOff(){
        unselectParent(PAYING_OFF_PROPERTY);
        return this;
    }

  


  

   public EmployeeSalarySheetRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

