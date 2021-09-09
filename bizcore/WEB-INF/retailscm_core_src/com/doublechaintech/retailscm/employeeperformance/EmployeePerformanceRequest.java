package com.doublechaintech.retailscm.employeeperformance;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeperformance.EmployeePerformance.*;

public class EmployeePerformanceRequest extends BaseRequest<EmployeePerformance> {
    public static EmployeePerformanceRequest newInstance() {
        return new EmployeePerformanceRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeePerformance";
    }

    public EmployeePerformanceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeePerformanceRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeePerformanceRequest selectAll() {return this.selectId().selectEmployee().selectPerformanceComment().selectVersion();
    }

    public EmployeePerformanceRequest selectSelf() {return this.selectId().selectPerformanceComment().selectVersion();
    }

    public EmployeePerformanceRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeePerformanceRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeePerformanceRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeePerformanceRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeePerformanceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeePerformanceRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeePerformanceRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeePerformanceRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeePerformanceRequest filterByPerformanceComment(String performanceComment) {
          
          if (performanceComment == null) {
              return this;
          }
          
          return filterByPerformanceComment(QueryOperator.EQUAL, performanceComment);
      }
    

      public EmployeePerformanceRequest filterByPerformanceComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPerformanceCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeePerformanceRequest selectPerformanceComment(){
          return select(PERFORMANCE_COMMENT_PROPERTY);
      }

      public EmployeePerformanceRequest unselectPerformanceComment(){
          return unselect(PERFORMANCE_COMMENT_PROPERTY);
      }

      public SearchCriteria getPerformanceCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PERFORMANCE_COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeePerformanceRequest orderByPerformanceComment(boolean asc){
          addOrderBy(PERFORMANCE_COMMENT_PROPERTY, asc);
          return this;
      }
   
      public EmployeePerformanceRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeePerformanceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeePerformanceRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeePerformanceRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeePerformanceRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeePerformanceRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeePerformanceRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeePerformanceRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeePerformanceRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeePerformanceRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  


  

   public EmployeePerformanceRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

