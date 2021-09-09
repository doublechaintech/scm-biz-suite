package com.doublechaintech.retailscm.retailstoreprovincecenter;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentRequest;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter.*;

public class RetailStoreProvinceCenterRequest extends BaseRequest<RetailStoreProvinceCenter> {
    public static RetailStoreProvinceCenterRequest newInstance() {
        return new RetailStoreProvinceCenterRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreProvinceCenter";
    }

    public RetailStoreProvinceCenterRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreProvinceCenterRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreProvinceCenterRequest selectAll() {return this.selectId().selectName().selectFounded().selectCountry().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreProvinceCenterRequest selectSelf() {return this.selectId().selectName().selectFounded().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreProvinceCenterRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreProvinceCenterRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreProvinceCenterRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreProvinceCenterRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreProvinceCenterRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreProvinceCenterRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreProvinceCenterRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreProvinceCenterRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreProvinceCenterRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreProvinceCenterRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreProvinceCenterRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreProvinceCenterRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreProvinceCenterRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreProvinceCenterRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public RetailStoreProvinceCenterRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreProvinceCenterRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public RetailStoreProvinceCenterRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreProvinceCenterRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreProvinceCenterRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public RetailStoreProvinceCenterRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreProvinceCenterRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public RetailStoreProvinceCenterRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreProvinceCenterRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreProvinceCenterRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreProvinceCenterRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreProvinceCenterRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreProvinceCenterRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreProvinceCenterRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreProvinceCenterRequest filterByCountry(RetailStoreCountryCenterRequest country){
        return filterByCountry(country, countryList -> countryList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreProvinceCenterRequest filterByCountry(RetailStoreCountryCenterRequest country, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCountryCriteria(country, idRefine));
    }

    public SearchCriteria createCountryCriteria(RetailStoreCountryCenterRequest country, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(country, COUNTRY_PROPERTY, idRefine);
    }
    

    
    public RetailStoreProvinceCenterRequest selectCountry(){
        return selectCountry(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public RetailStoreProvinceCenterRequest selectCountry(RetailStoreCountryCenterRequest country){
        selectParent(COUNTRY_PROPERTY, country);
        return this;
    }
    

    public RetailStoreProvinceCenterRequest unselectCountry(){
        unselectParent(COUNTRY_PROPERTY);
        return this;
    }

  


  

    public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment() {
      return hasProvinceCenterDepartment(ProvinceCenterDepartmentRequest.newInstance());
    }

    public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment(ProvinceCenterDepartmentRequest provinceCenterDepartment) {
        return hasProvinceCenterDepartment(provinceCenterDepartment, provinceCenterDepartmentList -> provinceCenterDepartmentList.stream().map(ProvinceCenterDepartment::getProvinceCenter).map(RetailStoreProvinceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment(ProvinceCenterDepartmentRequest provinceCenterDepartment, IDRefine<ProvinceCenterDepartment> idRefine) {
        provinceCenterDepartment.select(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY);
        return addSearchCriteria(createProvinceCenterDepartmentCriteria(provinceCenterDepartment, idRefine));
    }

    public SearchCriteria createProvinceCenterDepartmentCriteria(ProvinceCenterDepartmentRequest provinceCenterDepartment, IDRefine<ProvinceCenterDepartment> idRefine){
       return new RefinedIdInCriteria(provinceCenterDepartment, ID_PROPERTY, idRefine);
    }

    public RetailStoreProvinceCenterRequest selectProvinceCenterDepartmentList(ProvinceCenterDepartmentRequest provinceCenterDepartment) {
        selectChild(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, provinceCenterDepartment);
        return this;
    }

    public RetailStoreProvinceCenterRequest selectProvinceCenterDepartmentList() {
        return selectProvinceCenterDepartmentList(ProvinceCenterDepartmentRequest.newInstance().selectAll());
    }

    public RetailStoreProvinceCenterRequest unselectProvinceCenterDepartmentList(){
        unselectChild(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, ProvinceCenterDepartment.class);
        return this;
    }
  

    public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee() {
      return hasProvinceCenterEmployee(ProvinceCenterEmployeeRequest.newInstance());
    }

    public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee(ProvinceCenterEmployeeRequest provinceCenterEmployee) {
        return hasProvinceCenterEmployee(provinceCenterEmployee, provinceCenterEmployeeList -> provinceCenterEmployeeList.stream().map(ProvinceCenterEmployee::getProvinceCenter).map(RetailStoreProvinceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee(ProvinceCenterEmployeeRequest provinceCenterEmployee, IDRefine<ProvinceCenterEmployee> idRefine) {
        provinceCenterEmployee.select(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY);
        return addSearchCriteria(createProvinceCenterEmployeeCriteria(provinceCenterEmployee, idRefine));
    }

    public SearchCriteria createProvinceCenterEmployeeCriteria(ProvinceCenterEmployeeRequest provinceCenterEmployee, IDRefine<ProvinceCenterEmployee> idRefine){
       return new RefinedIdInCriteria(provinceCenterEmployee, ID_PROPERTY, idRefine);
    }

    public RetailStoreProvinceCenterRequest selectProvinceCenterEmployeeList(ProvinceCenterEmployeeRequest provinceCenterEmployee) {
        selectChild(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, provinceCenterEmployee);
        return this;
    }

    public RetailStoreProvinceCenterRequest selectProvinceCenterEmployeeList() {
        return selectProvinceCenterEmployeeList(ProvinceCenterEmployeeRequest.newInstance().selectAll());
    }

    public RetailStoreProvinceCenterRequest unselectProvinceCenterEmployeeList(){
        unselectChild(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, ProvinceCenterEmployee.class);
        return this;
    }
  

    public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter() {
      return hasRetailStoreCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance());
    }

    public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter(RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter) {
        return hasRetailStoreCityServiceCenter(retailStoreCityServiceCenter, retailStoreCityServiceCenterList -> retailStoreCityServiceCenterList.stream().map(RetailStoreCityServiceCenter::getBelongsTo).map(RetailStoreProvinceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter(RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        retailStoreCityServiceCenter.select(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY);
        return addSearchCriteria(createRetailStoreCityServiceCenterCriteria(retailStoreCityServiceCenter, idRefine));
    }

    public SearchCriteria createRetailStoreCityServiceCenterCriteria(RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine){
       return new RefinedIdInCriteria(retailStoreCityServiceCenter, ID_PROPERTY, idRefine);
    }

    public RetailStoreProvinceCenterRequest selectRetailStoreCityServiceCenterList(RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter) {
        selectChild(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, retailStoreCityServiceCenter);
        return this;
    }

    public RetailStoreProvinceCenterRequest selectRetailStoreCityServiceCenterList() {
        return selectRetailStoreCityServiceCenterList(RetailStoreCityServiceCenterRequest.newInstance().selectAll());
    }

    public RetailStoreProvinceCenterRequest unselectRetailStoreCityServiceCenterList(){
        unselectChild(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, RetailStoreCityServiceCenter.class);
        return this;
    }
  

   public RetailStoreProvinceCenterRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

