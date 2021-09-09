package com.doublechaintech.retailscm.leavetype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.leavetype.LeaveType.*;

public class LeaveTypeRequest extends BaseRequest<LeaveType> {
    public static LeaveTypeRequest newInstance() {
        return new LeaveTypeRequest().selectId();
    }

    public String getInternalType() {
        return "LeaveType";
    }

    public LeaveTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public LeaveTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public LeaveTypeRequest selectAll() {return this.selectId().selectCode().selectCompany().selectDescription().selectDetailDescription().selectVersion();
    }

    public LeaveTypeRequest selectSelf() {return this.selectId().selectCode().selectDescription().selectDetailDescription().selectVersion();
    }

    public LeaveTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public LeaveTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static LeaveTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public LeaveTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public LeaveTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LeaveTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public LeaveTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public LeaveTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public LeaveTypeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public LeaveTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LeaveTypeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public LeaveTypeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public LeaveTypeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public LeaveTypeRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public LeaveTypeRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LeaveTypeRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public LeaveTypeRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public LeaveTypeRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public LeaveTypeRequest filterByDetailDescription(String detailDescription) {
          
          if (detailDescription == null) {
              return this;
          }
          
          return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
      }
    

      public LeaveTypeRequest filterByDetailDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LeaveTypeRequest selectDetailDescription(){
          return select(DETAIL_DESCRIPTION_PROPERTY);
      }

      public LeaveTypeRequest unselectDetailDescription(){
          return unselect(DETAIL_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDetailDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public LeaveTypeRequest orderByDetailDescription(boolean asc){
          addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public LeaveTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public LeaveTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public LeaveTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public LeaveTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public LeaveTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public LeaveTypeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public LeaveTypeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public LeaveTypeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public LeaveTypeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public LeaveTypeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public LeaveTypeRequest hasEmployeeLeave() {
      return hasEmployeeLeave(EmployeeLeaveRequest.newInstance());
    }

    public LeaveTypeRequest hasEmployeeLeave(EmployeeLeaveRequest employeeLeave) {
        return hasEmployeeLeave(employeeLeave, employeeLeaveList -> employeeLeaveList.stream().map(EmployeeLeave::getType).map(LeaveType::getId).collect(Collectors.toSet()));
    }

    public LeaveTypeRequest hasEmployeeLeave(EmployeeLeaveRequest employeeLeave, IDRefine<EmployeeLeave> idRefine) {
        employeeLeave.select(EmployeeLeave.TYPE_PROPERTY);
        return addSearchCriteria(createEmployeeLeaveCriteria(employeeLeave, idRefine));
    }

    public SearchCriteria createEmployeeLeaveCriteria(EmployeeLeaveRequest employeeLeave, IDRefine<EmployeeLeave> idRefine){
       return new RefinedIdInCriteria(employeeLeave, ID_PROPERTY, idRefine);
    }

    public LeaveTypeRequest selectEmployeeLeaveList(EmployeeLeaveRequest employeeLeave) {
        selectChild(EmployeeLeave.TYPE_PROPERTY, employeeLeave);
        return this;
    }

    public LeaveTypeRequest selectEmployeeLeaveList() {
        return selectEmployeeLeaveList(EmployeeLeaveRequest.newInstance().selectAll());
    }

    public LeaveTypeRequest unselectEmployeeLeaveList(){
        unselectChild(EmployeeLeave.TYPE_PROPERTY, EmployeeLeave.class);
        return this;
    }
  

   public LeaveTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

