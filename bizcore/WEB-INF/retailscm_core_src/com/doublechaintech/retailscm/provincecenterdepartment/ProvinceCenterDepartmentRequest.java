package com.doublechaintech.retailscm.provincecenterdepartment;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment.*;

public class ProvinceCenterDepartmentRequest extends BaseRequest<ProvinceCenterDepartment> {
    public static ProvinceCenterDepartmentRequest newInstance() {
        return new ProvinceCenterDepartmentRequest().selectId();
    }

    public String getInternalType() {
        return "ProvinceCenterDepartment";
    }

    public ProvinceCenterDepartmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ProvinceCenterDepartmentRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ProvinceCenterDepartmentRequest selectAll() {return this.selectId().selectName().selectFounded().selectProvinceCenter().selectManager().selectVersion();
    }

    public ProvinceCenterDepartmentRequest selectSelf() {return this.selectId().selectName().selectFounded().selectManager().selectVersion();
    }

    public ProvinceCenterDepartmentRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ProvinceCenterDepartmentRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ProvinceCenterDepartmentRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ProvinceCenterDepartmentRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ProvinceCenterDepartmentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterDepartmentRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ProvinceCenterDepartmentRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterDepartmentRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterDepartmentRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public ProvinceCenterDepartmentRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterDepartmentRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public ProvinceCenterDepartmentRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterDepartmentRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterDepartmentRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public ProvinceCenterDepartmentRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterDepartmentRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public ProvinceCenterDepartmentRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterDepartmentRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterDepartmentRequest filterByManager(String manager) {
          
          if (manager == null) {
              return this;
          }
          
          return filterByManager(QueryOperator.EQUAL, manager);
      }
    

      public ProvinceCenterDepartmentRequest filterByManager(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getManagerSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterDepartmentRequest selectManager(){
          return select(MANAGER_PROPERTY);
      }

      public ProvinceCenterDepartmentRequest unselectManager(){
          return unselect(MANAGER_PROPERTY);
      }

      public SearchCriteria getManagerSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MANAGER_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterDepartmentRequest orderByManager(boolean asc){
          addOrderBy(MANAGER_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterDepartmentRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ProvinceCenterDepartmentRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterDepartmentRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ProvinceCenterDepartmentRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterDepartmentRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ProvinceCenterDepartmentRequest filterByProvinceCenter(RetailStoreProvinceCenterRequest provinceCenter){
        return filterByProvinceCenter(provinceCenter, provinceCenterList -> provinceCenterList.stream().map(RetailStoreProvinceCenter::getId).collect(Collectors.toSet()));
    }

    public ProvinceCenterDepartmentRequest filterByProvinceCenter(RetailStoreProvinceCenterRequest provinceCenter, IDRefine<RetailStoreProvinceCenter> idRefine) {
        return addSearchCriteria(createProvinceCenterCriteria(provinceCenter, idRefine));
    }

    public SearchCriteria createProvinceCenterCriteria(RetailStoreProvinceCenterRequest provinceCenter, IDRefine<RetailStoreProvinceCenter> idRefine) {
        return new RefinedIdInCriteria(provinceCenter, PROVINCE_CENTER_PROPERTY, idRefine);
    }
    

    
    public ProvinceCenterDepartmentRequest selectProvinceCenter(){
        return selectProvinceCenter(RetailStoreProvinceCenterRequest.newInstance().selectSelf());
    }

    public ProvinceCenterDepartmentRequest selectProvinceCenter(RetailStoreProvinceCenterRequest provinceCenter){
        selectParent(PROVINCE_CENTER_PROPERTY, provinceCenter);
        return this;
    }
    

    public ProvinceCenterDepartmentRequest unselectProvinceCenter(){
        unselectParent(PROVINCE_CENTER_PROPERTY);
        return this;
    }

  


  

    public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee() {
      return hasProvinceCenterEmployee(ProvinceCenterEmployeeRequest.newInstance());
    }

    public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee(ProvinceCenterEmployeeRequest provinceCenterEmployee) {
        return hasProvinceCenterEmployee(provinceCenterEmployee, provinceCenterEmployeeList -> provinceCenterEmployeeList.stream().map(ProvinceCenterEmployee::getDepartment).map(ProvinceCenterDepartment::getId).collect(Collectors.toSet()));
    }

    public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee(ProvinceCenterEmployeeRequest provinceCenterEmployee, IDRefine<ProvinceCenterEmployee> idRefine) {
        provinceCenterEmployee.select(ProvinceCenterEmployee.DEPARTMENT_PROPERTY);
        return addSearchCriteria(createProvinceCenterEmployeeCriteria(provinceCenterEmployee, idRefine));
    }

    public SearchCriteria createProvinceCenterEmployeeCriteria(ProvinceCenterEmployeeRequest provinceCenterEmployee, IDRefine<ProvinceCenterEmployee> idRefine){
       return new RefinedIdInCriteria(provinceCenterEmployee, ID_PROPERTY, idRefine);
    }

    public ProvinceCenterDepartmentRequest selectProvinceCenterEmployeeList(ProvinceCenterEmployeeRequest provinceCenterEmployee) {
        selectChild(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, provinceCenterEmployee);
        return this;
    }

    public ProvinceCenterDepartmentRequest selectProvinceCenterEmployeeList() {
        return selectProvinceCenterEmployeeList(ProvinceCenterEmployeeRequest.newInstance().selectAll());
    }

    public ProvinceCenterDepartmentRequest unselectProvinceCenterEmployeeList(){
        unselectChild(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, ProvinceCenterEmployee.class);
        return this;
    }
  

   public ProvinceCenterDepartmentRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

