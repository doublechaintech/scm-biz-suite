package com.doublechaintech.retailscm.employeeaward;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeaward.EmployeeAward.*;

public class EmployeeAwardRequest extends BaseRequest<EmployeeAward> {
    public static EmployeeAwardRequest newInstance() {
        return new EmployeeAwardRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeAward";
    }

    public EmployeeAwardRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeAwardRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeAwardRequest selectAll() {return this.selectId().selectEmployee().selectCompleteTime().selectType().selectRemark().selectVersion();
    }

    public EmployeeAwardRequest selectSelf() {return this.selectId().selectCompleteTime().selectType().selectRemark().selectVersion();
    }

    public EmployeeAwardRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeAwardRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeAwardRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeAwardRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeAwardRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAwardRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeAwardRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAwardRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAwardRequest filterByCompleteTime(Date completeTime) {
          
          if (completeTime == null) {
              return this;
          }
          
          return filterByCompleteTime(QueryOperator.EQUAL, completeTime);
      }
    

      public EmployeeAwardRequest filterByCompleteTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCompleteTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAwardRequest selectCompleteTime(){
          return select(COMPLETE_TIME_PROPERTY);
      }

      public EmployeeAwardRequest unselectCompleteTime(){
          return unselect(COMPLETE_TIME_PROPERTY);
      }

      public SearchCriteria getCompleteTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMPLETE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAwardRequest orderByCompleteTime(boolean asc){
          addOrderBy(COMPLETE_TIME_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAwardRequest filterByType(String type) {
          
          if (type == null) {
              return this;
          }
          
          return filterByType(QueryOperator.EQUAL, type);
      }
    

      public EmployeeAwardRequest filterByType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAwardRequest selectType(){
          return select(TYPE_PROPERTY);
      }

      public EmployeeAwardRequest unselectType(){
          return unselect(TYPE_PROPERTY);
      }

      public SearchCriteria getTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAwardRequest orderByType(boolean asc){
          addOrderBy(TYPE_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAwardRequest filterByRemark(String remark) {
          
          if (remark == null) {
              return this;
          }
          
          return filterByRemark(QueryOperator.EQUAL, remark);
      }
    

      public EmployeeAwardRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAwardRequest selectRemark(){
          return select(REMARK_PROPERTY);
      }

      public EmployeeAwardRequest unselectRemark(){
          return unselect(REMARK_PROPERTY);
      }

      public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAwardRequest orderByRemark(boolean asc){
          addOrderBy(REMARK_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAwardRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeAwardRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAwardRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeAwardRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAwardRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeAwardRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeAwardRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeAwardRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeAwardRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeAwardRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  


  

   public EmployeeAwardRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

