package com.doublechaintech.retailscm.provincecenteremployee;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentRequest;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee.*;

public class ProvinceCenterEmployeeRequest extends BaseRequest<ProvinceCenterEmployee> {
    public static ProvinceCenterEmployeeRequest newInstance() {
        return new ProvinceCenterEmployeeRequest().selectId();
    }

    public String getInternalType() {
        return "ProvinceCenterEmployee";
    }

    public ProvinceCenterEmployeeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ProvinceCenterEmployeeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ProvinceCenterEmployeeRequest selectAll() {return this.selectId().selectName().selectMobile().selectEmail().selectFounded().selectDepartment().selectProvinceCenter().selectVersion();
    }

    public ProvinceCenterEmployeeRequest selectSelf() {return this.selectId().selectName().selectMobile().selectEmail().selectFounded().selectVersion();
    }

    public ProvinceCenterEmployeeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ProvinceCenterEmployeeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ProvinceCenterEmployeeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ProvinceCenterEmployeeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ProvinceCenterEmployeeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterEmployeeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ProvinceCenterEmployeeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterEmployeeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterEmployeeRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public ProvinceCenterEmployeeRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterEmployeeRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public ProvinceCenterEmployeeRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterEmployeeRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterEmployeeRequest filterByMobile(String mobile) {
          
          if (mobile == null) {
              return this;
          }
          
          return filterByMobile(QueryOperator.EQUAL, mobile);
      }
    

      public ProvinceCenterEmployeeRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterEmployeeRequest selectMobile(){
          return select(MOBILE_PROPERTY);
      }

      public ProvinceCenterEmployeeRequest unselectMobile(){
          return unselect(MOBILE_PROPERTY);
      }

      public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterEmployeeRequest orderByMobile(boolean asc){
          addOrderBy(MOBILE_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterEmployeeRequest filterByEmail(String email) {
          
          if (email == null) {
              return this;
          }
          
          return filterByEmail(QueryOperator.EQUAL, email);
      }
    

      public ProvinceCenterEmployeeRequest filterByEmail(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEmailSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterEmployeeRequest selectEmail(){
          return select(EMAIL_PROPERTY);
      }

      public ProvinceCenterEmployeeRequest unselectEmail(){
          return unselect(EMAIL_PROPERTY);
      }

      public SearchCriteria getEmailSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(EMAIL_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterEmployeeRequest orderByEmail(boolean asc){
          addOrderBy(EMAIL_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterEmployeeRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public ProvinceCenterEmployeeRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterEmployeeRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public ProvinceCenterEmployeeRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterEmployeeRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public ProvinceCenterEmployeeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ProvinceCenterEmployeeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ProvinceCenterEmployeeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ProvinceCenterEmployeeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ProvinceCenterEmployeeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ProvinceCenterEmployeeRequest filterByDepartment(ProvinceCenterDepartmentRequest department){
        return filterByDepartment(department, departmentList -> departmentList.stream().map(ProvinceCenterDepartment::getId).collect(Collectors.toSet()));
    }

    public ProvinceCenterEmployeeRequest filterByDepartment(ProvinceCenterDepartmentRequest department, IDRefine<ProvinceCenterDepartment> idRefine) {
        return addSearchCriteria(createDepartmentCriteria(department, idRefine));
    }

    public SearchCriteria createDepartmentCriteria(ProvinceCenterDepartmentRequest department, IDRefine<ProvinceCenterDepartment> idRefine) {
        return new RefinedIdInCriteria(department, DEPARTMENT_PROPERTY, idRefine);
    }
    

    
    public ProvinceCenterEmployeeRequest selectDepartment(){
        return selectDepartment(ProvinceCenterDepartmentRequest.newInstance().selectSelf());
    }

    public ProvinceCenterEmployeeRequest selectDepartment(ProvinceCenterDepartmentRequest department){
        selectParent(DEPARTMENT_PROPERTY, department);
        return this;
    }
    

    public ProvinceCenterEmployeeRequest unselectDepartment(){
        unselectParent(DEPARTMENT_PROPERTY);
        return this;
    }

  

    
    public ProvinceCenterEmployeeRequest filterByProvinceCenter(RetailStoreProvinceCenterRequest provinceCenter){
        return filterByProvinceCenter(provinceCenter, provinceCenterList -> provinceCenterList.stream().map(RetailStoreProvinceCenter::getId).collect(Collectors.toSet()));
    }

    public ProvinceCenterEmployeeRequest filterByProvinceCenter(RetailStoreProvinceCenterRequest provinceCenter, IDRefine<RetailStoreProvinceCenter> idRefine) {
        return addSearchCriteria(createProvinceCenterCriteria(provinceCenter, idRefine));
    }

    public SearchCriteria createProvinceCenterCriteria(RetailStoreProvinceCenterRequest provinceCenter, IDRefine<RetailStoreProvinceCenter> idRefine) {
        return new RefinedIdInCriteria(provinceCenter, PROVINCE_CENTER_PROPERTY, idRefine);
    }
    

    
    public ProvinceCenterEmployeeRequest selectProvinceCenter(){
        return selectProvinceCenter(RetailStoreProvinceCenterRequest.newInstance().selectSelf());
    }

    public ProvinceCenterEmployeeRequest selectProvinceCenter(RetailStoreProvinceCenterRequest provinceCenter){
        selectParent(PROVINCE_CENTER_PROPERTY, provinceCenter);
        return this;
    }
    

    public ProvinceCenterEmployeeRequest unselectProvinceCenter(){
        unselectParent(PROVINCE_CENTER_PROPERTY);
        return this;
    }

  


  

   public ProvinceCenterEmployeeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

