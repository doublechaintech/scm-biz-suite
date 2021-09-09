package com.doublechaintech.retailscm.salarygrade;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.salarygrade.SalaryGrade.*;

public class SalaryGradeRequest extends BaseRequest<SalaryGrade> {
    public static SalaryGradeRequest newInstance() {
        return new SalaryGradeRequest().selectId();
    }

    public String getInternalType() {
        return "SalaryGrade";
    }

    public SalaryGradeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SalaryGradeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SalaryGradeRequest selectAll() {return this.selectId().selectCode().selectCompany().selectName().selectDetailDescription().selectVersion();
    }

    public SalaryGradeRequest selectSelf() {return this.selectId().selectCode().selectName().selectDetailDescription().selectVersion();
    }

    public SalaryGradeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SalaryGradeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SalaryGradeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SalaryGradeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SalaryGradeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SalaryGradeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SalaryGradeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SalaryGradeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SalaryGradeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public SalaryGradeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SalaryGradeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public SalaryGradeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public SalaryGradeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public SalaryGradeRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public SalaryGradeRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SalaryGradeRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public SalaryGradeRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public SalaryGradeRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public SalaryGradeRequest filterByDetailDescription(String detailDescription) {
          
          if (detailDescription == null) {
              return this;
          }
          
          return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
      }
    

      public SalaryGradeRequest filterByDetailDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SalaryGradeRequest selectDetailDescription(){
          return select(DETAIL_DESCRIPTION_PROPERTY);
      }

      public SalaryGradeRequest unselectDetailDescription(){
          return unselect(DETAIL_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDetailDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public SalaryGradeRequest orderByDetailDescription(boolean asc){
          addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public SalaryGradeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SalaryGradeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SalaryGradeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SalaryGradeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SalaryGradeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SalaryGradeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public SalaryGradeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public SalaryGradeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public SalaryGradeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public SalaryGradeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public SalaryGradeRequest hasEmployee() {
      return hasEmployee(EmployeeRequest.newInstance());
    }

    public SalaryGradeRequest hasEmployee(EmployeeRequest employee) {
        return hasEmployee(employee, employeeList -> employeeList.stream().map(Employee::getCurrentSalaryGrade).map(SalaryGrade::getId).collect(Collectors.toSet()));
    }

    public SalaryGradeRequest hasEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        employee.select(Employee.CURRENT_SALARY_GRADE_PROPERTY);
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine){
       return new RefinedIdInCriteria(employee, ID_PROPERTY, idRefine);
    }

    public SalaryGradeRequest selectEmployeeList(EmployeeRequest employee) {
        selectChild(Employee.CURRENT_SALARY_GRADE_PROPERTY, employee);
        return this;
    }

    public SalaryGradeRequest selectEmployeeList() {
        return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
    }

    public SalaryGradeRequest unselectEmployeeList(){
        unselectChild(Employee.CURRENT_SALARY_GRADE_PROPERTY, Employee.class);
        return this;
    }
  

    public SalaryGradeRequest hasEmployeeSalarySheet() {
      return hasEmployeeSalarySheet(EmployeeSalarySheetRequest.newInstance());
    }

    public SalaryGradeRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet) {
        return hasEmployeeSalarySheet(employeeSalarySheet, employeeSalarySheetList -> employeeSalarySheetList.stream().map(EmployeeSalarySheet::getCurrentSalaryGrade).map(SalaryGrade::getId).collect(Collectors.toSet()));
    }

    public SalaryGradeRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
        employeeSalarySheet.select(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY);
        return addSearchCriteria(createEmployeeSalarySheetCriteria(employeeSalarySheet, idRefine));
    }

    public SearchCriteria createEmployeeSalarySheetCriteria(EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine){
       return new RefinedIdInCriteria(employeeSalarySheet, ID_PROPERTY, idRefine);
    }

    public SalaryGradeRequest selectEmployeeSalarySheetList(EmployeeSalarySheetRequest employeeSalarySheet) {
        selectChild(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, employeeSalarySheet);
        return this;
    }

    public SalaryGradeRequest selectEmployeeSalarySheetList() {
        return selectEmployeeSalarySheetList(EmployeeSalarySheetRequest.newInstance().selectAll());
    }

    public SalaryGradeRequest unselectEmployeeSalarySheetList(){
        unselectChild(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, EmployeeSalarySheet.class);
        return this;
    }
  

   public SalaryGradeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

