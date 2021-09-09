package com.doublechaintech.retailscm.employeequalifier;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier.*;

public class EmployeeQualifierRequest extends BaseRequest<EmployeeQualifier> {
    public static EmployeeQualifierRequest newInstance() {
        return new EmployeeQualifierRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeQualifier";
    }

    public EmployeeQualifierRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeQualifierRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeQualifierRequest selectAll() {return this.selectId().selectEmployee().selectQualifiedTime().selectType().selectLevel().selectRemark().selectVersion();
    }

    public EmployeeQualifierRequest selectSelf() {return this.selectId().selectQualifiedTime().selectType().selectLevel().selectRemark().selectVersion();
    }

    public EmployeeQualifierRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeQualifierRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeQualifierRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeQualifierRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeQualifierRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeQualifierRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeQualifierRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeQualifierRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeQualifierRequest filterByQualifiedTime(Date qualifiedTime) {
          
          if (qualifiedTime == null) {
              return this;
          }
          
          return filterByQualifiedTime(QueryOperator.EQUAL, qualifiedTime);
      }
    

      public EmployeeQualifierRequest filterByQualifiedTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getQualifiedTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeQualifierRequest selectQualifiedTime(){
          return select(QUALIFIED_TIME_PROPERTY);
      }

      public EmployeeQualifierRequest unselectQualifiedTime(){
          return unselect(QUALIFIED_TIME_PROPERTY);
      }

      public SearchCriteria getQualifiedTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(QUALIFIED_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeQualifierRequest orderByQualifiedTime(boolean asc){
          addOrderBy(QUALIFIED_TIME_PROPERTY, asc);
          return this;
      }
   
      public EmployeeQualifierRequest filterByType(String type) {
          
          if (type == null) {
              return this;
          }
          
          return filterByType(QueryOperator.EQUAL, type);
      }
    

      public EmployeeQualifierRequest filterByType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeQualifierRequest selectType(){
          return select(TYPE_PROPERTY);
      }

      public EmployeeQualifierRequest unselectType(){
          return unselect(TYPE_PROPERTY);
      }

      public SearchCriteria getTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeQualifierRequest orderByType(boolean asc){
          addOrderBy(TYPE_PROPERTY, asc);
          return this;
      }
   
      public EmployeeQualifierRequest filterByLevel(String level) {
          
          if (level == null) {
              return this;
          }
          
          return filterByLevel(QueryOperator.EQUAL, level);
      }
    

      public EmployeeQualifierRequest filterByLevel(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLevelSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeQualifierRequest selectLevel(){
          return select(LEVEL_PROPERTY);
      }

      public EmployeeQualifierRequest unselectLevel(){
          return unselect(LEVEL_PROPERTY);
      }

      public SearchCriteria getLevelSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LEVEL_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeQualifierRequest orderByLevel(boolean asc){
          addOrderBy(LEVEL_PROPERTY, asc);
          return this;
      }
   
      public EmployeeQualifierRequest filterByRemark(String remark) {
          
          if (remark == null) {
              return this;
          }
          
          return filterByRemark(QueryOperator.EQUAL, remark);
      }
    

      public EmployeeQualifierRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeQualifierRequest selectRemark(){
          return select(REMARK_PROPERTY);
      }

      public EmployeeQualifierRequest unselectRemark(){
          return unselect(REMARK_PROPERTY);
      }

      public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeQualifierRequest orderByRemark(boolean asc){
          addOrderBy(REMARK_PROPERTY, asc);
          return this;
      }
   
      public EmployeeQualifierRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeQualifierRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeQualifierRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeQualifierRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeQualifierRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeQualifierRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeQualifierRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeQualifierRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeQualifierRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeQualifierRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  


  

   public EmployeeQualifierRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

