package com.doublechaintech.retailscm.responsibilitytype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType.*;

public class ResponsibilityTypeRequest extends BaseRequest<ResponsibilityType> {
    public static ResponsibilityTypeRequest newInstance() {
        return new ResponsibilityTypeRequest().selectId();
    }

    public String getInternalType() {
        return "ResponsibilityType";
    }

    public ResponsibilityTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ResponsibilityTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ResponsibilityTypeRequest selectAll() {return this.selectId().selectCode().selectCompany().selectBaseDescription().selectDetailDescription().selectVersion();
    }

    public ResponsibilityTypeRequest selectSelf() {return this.selectId().selectCode().selectBaseDescription().selectDetailDescription().selectVersion();
    }

    public ResponsibilityTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ResponsibilityTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ResponsibilityTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ResponsibilityTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ResponsibilityTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ResponsibilityTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ResponsibilityTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ResponsibilityTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ResponsibilityTypeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public ResponsibilityTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ResponsibilityTypeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public ResponsibilityTypeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public ResponsibilityTypeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public ResponsibilityTypeRequest filterByBaseDescription(String baseDescription) {
          
          if (baseDescription == null) {
              return this;
          }
          
          return filterByBaseDescription(QueryOperator.EQUAL, baseDescription);
      }
    

      public ResponsibilityTypeRequest filterByBaseDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBaseDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ResponsibilityTypeRequest selectBaseDescription(){
          return select(BASE_DESCRIPTION_PROPERTY);
      }

      public ResponsibilityTypeRequest unselectBaseDescription(){
          return unselect(BASE_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getBaseDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BASE_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public ResponsibilityTypeRequest orderByBaseDescription(boolean asc){
          addOrderBy(BASE_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public ResponsibilityTypeRequest filterByDetailDescription(String detailDescription) {
          
          if (detailDescription == null) {
              return this;
          }
          
          return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
      }
    

      public ResponsibilityTypeRequest filterByDetailDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ResponsibilityTypeRequest selectDetailDescription(){
          return select(DETAIL_DESCRIPTION_PROPERTY);
      }

      public ResponsibilityTypeRequest unselectDetailDescription(){
          return unselect(DETAIL_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDetailDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public ResponsibilityTypeRequest orderByDetailDescription(boolean asc){
          addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public ResponsibilityTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ResponsibilityTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ResponsibilityTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ResponsibilityTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ResponsibilityTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ResponsibilityTypeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public ResponsibilityTypeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public ResponsibilityTypeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public ResponsibilityTypeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public ResponsibilityTypeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public ResponsibilityTypeRequest hasEmployee() {
      return hasEmployee(EmployeeRequest.newInstance());
    }

    public ResponsibilityTypeRequest hasEmployee(EmployeeRequest employee) {
        return hasEmployee(employee, employeeList -> employeeList.stream().map(Employee::getResponsibleFor).map(ResponsibilityType::getId).collect(Collectors.toSet()));
    }

    public ResponsibilityTypeRequest hasEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        employee.select(Employee.RESPONSIBLE_FOR_PROPERTY);
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine){
       return new RefinedIdInCriteria(employee, ID_PROPERTY, idRefine);
    }

    public ResponsibilityTypeRequest selectEmployeeList(EmployeeRequest employee) {
        selectChild(Employee.RESPONSIBLE_FOR_PROPERTY, employee);
        return this;
    }

    public ResponsibilityTypeRequest selectEmployeeList() {
        return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
    }

    public ResponsibilityTypeRequest unselectEmployeeList(){
        unselectChild(Employee.RESPONSIBLE_FOR_PROPERTY, Employee.class);
        return this;
    }
  

   public ResponsibilityTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

