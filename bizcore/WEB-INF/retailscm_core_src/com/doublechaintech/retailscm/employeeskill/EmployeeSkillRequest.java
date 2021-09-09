package com.doublechaintech.retailscm.employeeskill;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.skilltype.SkillTypeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeskill.EmployeeSkill.*;

public class EmployeeSkillRequest extends BaseRequest<EmployeeSkill> {
    public static EmployeeSkillRequest newInstance() {
        return new EmployeeSkillRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeSkill";
    }

    public EmployeeSkillRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeSkillRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeSkillRequest selectAll() {return this.selectId().selectEmployee().selectSkillType().selectDescription().selectVersion();
    }

    public EmployeeSkillRequest selectSelf() {return this.selectId().selectDescription().selectVersion();
    }

    public EmployeeSkillRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeSkillRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeSkillRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeSkillRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeSkillRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSkillRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeSkillRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSkillRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSkillRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public EmployeeSkillRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSkillRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public EmployeeSkillRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSkillRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public EmployeeSkillRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeSkillRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeSkillRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeSkillRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeSkillRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeSkillRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeSkillRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeSkillRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeSkillRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeSkillRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  

    
    public EmployeeSkillRequest filterBySkillType(SkillTypeRequest skillType){
        return filterBySkillType(skillType, skillTypeList -> skillTypeList.stream().map(SkillType::getId).collect(Collectors.toSet()));
    }

    public EmployeeSkillRequest filterBySkillType(SkillTypeRequest skillType, IDRefine<SkillType> idRefine) {
        return addSearchCriteria(createSkillTypeCriteria(skillType, idRefine));
    }

    public SearchCriteria createSkillTypeCriteria(SkillTypeRequest skillType, IDRefine<SkillType> idRefine) {
        return new RefinedIdInCriteria(skillType, SKILL_TYPE_PROPERTY, idRefine);
    }
    

    
    public EmployeeSkillRequest selectSkillType(){
        return selectSkillType(SkillTypeRequest.newInstance().selectSelf());
    }

    public EmployeeSkillRequest selectSkillType(SkillTypeRequest skillType){
        selectParent(SKILL_TYPE_PROPERTY, skillType);
        return this;
    }
    

    public EmployeeSkillRequest unselectSkillType(){
        unselectParent(SKILL_TYPE_PROPERTY);
        return this;
    }

  


  

   public EmployeeSkillRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

