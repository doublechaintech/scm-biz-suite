package com.doublechaintech.retailscm.employeeeducation;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeeducation.EmployeeEducation.*;

public class EmployeeEducationRequest extends BaseRequest<EmployeeEducation> {
    public static EmployeeEducationRequest newInstance() {
        return new EmployeeEducationRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeEducation";
    }

    public EmployeeEducationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeEducationRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeEducationRequest selectAll() {return this.selectId().selectEmployee().selectCompleteTime().selectType().selectRemark().selectVersion();
    }

    public EmployeeEducationRequest selectSelf() {return this.selectId().selectCompleteTime().selectType().selectRemark().selectVersion();
    }

    public EmployeeEducationRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeEducationRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeEducationRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeEducationRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeEducationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeEducationRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeEducationRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeEducationRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeEducationRequest filterByCompleteTime(Date completeTime) {
          
          if (completeTime == null) {
              return this;
          }
          
          return filterByCompleteTime(QueryOperator.EQUAL, completeTime);
      }
    

      public EmployeeEducationRequest filterByCompleteTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCompleteTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeEducationRequest selectCompleteTime(){
          return select(COMPLETE_TIME_PROPERTY);
      }

      public EmployeeEducationRequest unselectCompleteTime(){
          return unselect(COMPLETE_TIME_PROPERTY);
      }

      public SearchCriteria getCompleteTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMPLETE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeEducationRequest orderByCompleteTime(boolean asc){
          addOrderBy(COMPLETE_TIME_PROPERTY, asc);
          return this;
      }
   
      public EmployeeEducationRequest filterByType(String type) {
          
          if (type == null) {
              return this;
          }
          
          return filterByType(QueryOperator.EQUAL, type);
      }
    

      public EmployeeEducationRequest filterByType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeEducationRequest selectType(){
          return select(TYPE_PROPERTY);
      }

      public EmployeeEducationRequest unselectType(){
          return unselect(TYPE_PROPERTY);
      }

      public SearchCriteria getTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeEducationRequest orderByType(boolean asc){
          addOrderBy(TYPE_PROPERTY, asc);
          return this;
      }
   
      public EmployeeEducationRequest filterByRemark(String remark) {
          
          if (remark == null) {
              return this;
          }
          
          return filterByRemark(QueryOperator.EQUAL, remark);
      }
    

      public EmployeeEducationRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeEducationRequest selectRemark(){
          return select(REMARK_PROPERTY);
      }

      public EmployeeEducationRequest unselectRemark(){
          return unselect(REMARK_PROPERTY);
      }

      public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeEducationRequest orderByRemark(boolean asc){
          addOrderBy(REMARK_PROPERTY, asc);
          return this;
      }
   
      public EmployeeEducationRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeEducationRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeEducationRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeEducationRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeEducationRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeEducationRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeEducationRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeEducationRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeEducationRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeEducationRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  


  

   public EmployeeEducationRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

