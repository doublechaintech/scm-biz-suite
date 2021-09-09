package com.doublechaintech.retailscm.employeeworkexperience;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience.*;

public class EmployeeWorkExperienceRequest extends BaseRequest<EmployeeWorkExperience> {
    public static EmployeeWorkExperienceRequest newInstance() {
        return new EmployeeWorkExperienceRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeWorkExperience";
    }

    public EmployeeWorkExperienceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeWorkExperienceRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeWorkExperienceRequest selectAll() {return this.selectId().selectEmployee().selectStart().selectEnd().selectCompany().selectDescription().selectVersion();
    }

    public EmployeeWorkExperienceRequest selectSelf() {return this.selectId().selectStart().selectEnd().selectCompany().selectDescription().selectVersion();
    }

    public EmployeeWorkExperienceRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeWorkExperienceRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeWorkExperienceRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeWorkExperienceRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeWorkExperienceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeWorkExperienceRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeWorkExperienceRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeWorkExperienceRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeWorkExperienceRequest filterByStart(Date start) {
          
          if (start == null) {
              return this;
          }
          
          return filterByStart(QueryOperator.EQUAL, start);
      }
    

      public EmployeeWorkExperienceRequest filterByStart(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getStartSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeWorkExperienceRequest selectStart(){
          return select(START_PROPERTY);
      }

      public EmployeeWorkExperienceRequest unselectStart(){
          return unselect(START_PROPERTY);
      }

      public SearchCriteria getStartSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(START_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeWorkExperienceRequest orderByStart(boolean asc){
          addOrderBy(START_PROPERTY, asc);
          return this;
      }
   
      public EmployeeWorkExperienceRequest filterByEnd(Date end) {
          
          if (end == null) {
              return this;
          }
          
          return filterByEnd(QueryOperator.EQUAL, end);
      }
    

      public EmployeeWorkExperienceRequest filterByEnd(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEndSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeWorkExperienceRequest selectEnd(){
          return select(END_PROPERTY);
      }

      public EmployeeWorkExperienceRequest unselectEnd(){
          return unselect(END_PROPERTY);
      }

      public SearchCriteria getEndSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(END_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeWorkExperienceRequest orderByEnd(boolean asc){
          addOrderBy(END_PROPERTY, asc);
          return this;
      }
   
      public EmployeeWorkExperienceRequest filterByCompany(String company) {
          
          if (company == null) {
              return this;
          }
          
          return filterByCompany(QueryOperator.EQUAL, company);
      }
    

      public EmployeeWorkExperienceRequest filterByCompany(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCompanySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeWorkExperienceRequest selectCompany(){
          return select(COMPANY_PROPERTY);
      }

      public EmployeeWorkExperienceRequest unselectCompany(){
          return unselect(COMPANY_PROPERTY);
      }

      public SearchCriteria getCompanySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMPANY_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeWorkExperienceRequest orderByCompany(boolean asc){
          addOrderBy(COMPANY_PROPERTY, asc);
          return this;
      }
   
      public EmployeeWorkExperienceRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public EmployeeWorkExperienceRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeWorkExperienceRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public EmployeeWorkExperienceRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeWorkExperienceRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public EmployeeWorkExperienceRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeWorkExperienceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeWorkExperienceRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeWorkExperienceRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeWorkExperienceRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeWorkExperienceRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeWorkExperienceRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeWorkExperienceRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeWorkExperienceRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeWorkExperienceRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  


  

   public EmployeeWorkExperienceRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

