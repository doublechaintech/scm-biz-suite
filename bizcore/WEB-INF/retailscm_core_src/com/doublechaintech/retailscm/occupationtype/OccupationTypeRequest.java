package com.doublechaintech.retailscm.occupationtype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.occupationtype.OccupationType.*;

public class OccupationTypeRequest extends BaseRequest<OccupationType> {
    public static OccupationTypeRequest newInstance() {
        return new OccupationTypeRequest().selectId();
    }

    public String getInternalType() {
        return "OccupationType";
    }

    public OccupationTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public OccupationTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public OccupationTypeRequest selectAll() {return this.selectId().selectCode().selectCompany().selectDescription().selectDetailDescription().selectVersion();
    }

    public OccupationTypeRequest selectSelf() {return this.selectId().selectCode().selectDescription().selectDetailDescription().selectVersion();
    }

    public OccupationTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public OccupationTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static OccupationTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public OccupationTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public OccupationTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OccupationTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public OccupationTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public OccupationTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public OccupationTypeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public OccupationTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OccupationTypeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public OccupationTypeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public OccupationTypeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public OccupationTypeRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public OccupationTypeRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OccupationTypeRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public OccupationTypeRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public OccupationTypeRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public OccupationTypeRequest filterByDetailDescription(String detailDescription) {
          
          if (detailDescription == null) {
              return this;
          }
          
          return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
      }
    

      public OccupationTypeRequest filterByDetailDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OccupationTypeRequest selectDetailDescription(){
          return select(DETAIL_DESCRIPTION_PROPERTY);
      }

      public OccupationTypeRequest unselectDetailDescription(){
          return unselect(DETAIL_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDetailDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public OccupationTypeRequest orderByDetailDescription(boolean asc){
          addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public OccupationTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public OccupationTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OccupationTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public OccupationTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public OccupationTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public OccupationTypeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public OccupationTypeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public OccupationTypeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public OccupationTypeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public OccupationTypeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public OccupationTypeRequest hasEmployee() {
      return hasEmployee(EmployeeRequest.newInstance());
    }

    public OccupationTypeRequest hasEmployee(EmployeeRequest employee) {
        return hasEmployee(employee, employeeList -> employeeList.stream().map(Employee::getOccupation).map(OccupationType::getId).collect(Collectors.toSet()));
    }

    public OccupationTypeRequest hasEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        employee.select(Employee.OCCUPATION_PROPERTY);
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine){
       return new RefinedIdInCriteria(employee, ID_PROPERTY, idRefine);
    }

    public OccupationTypeRequest selectEmployeeList(EmployeeRequest employee) {
        selectChild(Employee.OCCUPATION_PROPERTY, employee);
        return this;
    }

    public OccupationTypeRequest selectEmployeeList() {
        return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
    }

    public OccupationTypeRequest unselectEmployeeList(){
        unselectChild(Employee.OCCUPATION_PROPERTY, Employee.class);
        return this;
    }
  

   public OccupationTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

