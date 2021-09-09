package com.doublechaintech.retailscm.levelthreedepartment;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment.*;

public class LevelThreeDepartmentRequest extends BaseRequest<LevelThreeDepartment> {
    public static LevelThreeDepartmentRequest newInstance() {
        return new LevelThreeDepartmentRequest().selectId();
    }

    public String getInternalType() {
        return "LevelThreeDepartment";
    }

    public LevelThreeDepartmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public LevelThreeDepartmentRequest select(String... names) {
        super.select(names);
        return this;
    }

    public LevelThreeDepartmentRequest selectAll() {return this.selectId().selectBelongsTo().selectName().selectDescription().selectFounded().selectVersion();
    }

    public LevelThreeDepartmentRequest selectSelf() {return this.selectId().selectName().selectDescription().selectFounded().selectVersion();
    }

    public LevelThreeDepartmentRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public LevelThreeDepartmentRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static LevelThreeDepartmentRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public LevelThreeDepartmentRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public LevelThreeDepartmentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelThreeDepartmentRequest selectId(){
          return select(ID_PROPERTY);
      }

      public LevelThreeDepartmentRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public LevelThreeDepartmentRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public LevelThreeDepartmentRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public LevelThreeDepartmentRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelThreeDepartmentRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public LevelThreeDepartmentRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public LevelThreeDepartmentRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public LevelThreeDepartmentRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public LevelThreeDepartmentRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelThreeDepartmentRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public LevelThreeDepartmentRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelThreeDepartmentRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public LevelThreeDepartmentRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public LevelThreeDepartmentRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelThreeDepartmentRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public LevelThreeDepartmentRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public LevelThreeDepartmentRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public LevelThreeDepartmentRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public LevelThreeDepartmentRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LevelThreeDepartmentRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public LevelThreeDepartmentRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public LevelThreeDepartmentRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public LevelThreeDepartmentRequest filterByBelongsTo(LevelTwoDepartmentRequest belongsTo){
        return filterByBelongsTo(belongsTo, belongsToList -> belongsToList.stream().map(LevelTwoDepartment::getId).collect(Collectors.toSet()));
    }

    public LevelThreeDepartmentRequest filterByBelongsTo(LevelTwoDepartmentRequest belongsTo, IDRefine<LevelTwoDepartment> idRefine) {
        return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
    }

    public SearchCriteria createBelongsToCriteria(LevelTwoDepartmentRequest belongsTo, IDRefine<LevelTwoDepartment> idRefine) {
        return new RefinedIdInCriteria(belongsTo, BELONGS_TO_PROPERTY, idRefine);
    }
    

    
    public LevelThreeDepartmentRequest selectBelongsTo(){
        return selectBelongsTo(LevelTwoDepartmentRequest.newInstance().selectSelf());
    }

    public LevelThreeDepartmentRequest selectBelongsTo(LevelTwoDepartmentRequest belongsTo){
        selectParent(BELONGS_TO_PROPERTY, belongsTo);
        return this;
    }
    

    public LevelThreeDepartmentRequest unselectBelongsTo(){
        unselectParent(BELONGS_TO_PROPERTY);
        return this;
    }

  


  

    public LevelThreeDepartmentRequest hasEmployee() {
      return hasEmployee(EmployeeRequest.newInstance());
    }

    public LevelThreeDepartmentRequest hasEmployee(EmployeeRequest employee) {
        return hasEmployee(employee, employeeList -> employeeList.stream().map(Employee::getDepartment).map(LevelThreeDepartment::getId).collect(Collectors.toSet()));
    }

    public LevelThreeDepartmentRequest hasEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        employee.select(Employee.DEPARTMENT_PROPERTY);
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine){
       return new RefinedIdInCriteria(employee, ID_PROPERTY, idRefine);
    }

    public LevelThreeDepartmentRequest selectEmployeeList(EmployeeRequest employee) {
        selectChild(Employee.DEPARTMENT_PROPERTY, employee);
        return this;
    }

    public LevelThreeDepartmentRequest selectEmployeeList() {
        return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
    }

    public LevelThreeDepartmentRequest unselectEmployeeList(){
        unselectChild(Employee.DEPARTMENT_PROPERTY, Employee.class);
        return this;
    }
  

   public LevelThreeDepartmentRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

