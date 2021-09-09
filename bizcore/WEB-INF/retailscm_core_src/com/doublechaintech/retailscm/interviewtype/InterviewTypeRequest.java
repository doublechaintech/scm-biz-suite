package com.doublechaintech.retailscm.interviewtype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.interviewtype.InterviewType.*;

public class InterviewTypeRequest extends BaseRequest<InterviewType> {
    public static InterviewTypeRequest newInstance() {
        return new InterviewTypeRequest().selectId();
    }

    public String getInternalType() {
        return "InterviewType";
    }

    public InterviewTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public InterviewTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public InterviewTypeRequest selectAll() {return this.selectId().selectCode().selectCompany().selectDescription().selectDetailDescription().selectVersion();
    }

    public InterviewTypeRequest selectSelf() {return this.selectId().selectCode().selectDescription().selectDetailDescription().selectVersion();
    }

    public InterviewTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public InterviewTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static InterviewTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public InterviewTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public InterviewTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InterviewTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public InterviewTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public InterviewTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public InterviewTypeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public InterviewTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InterviewTypeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public InterviewTypeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public InterviewTypeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public InterviewTypeRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public InterviewTypeRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InterviewTypeRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public InterviewTypeRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public InterviewTypeRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public InterviewTypeRequest filterByDetailDescription(String detailDescription) {
          
          if (detailDescription == null) {
              return this;
          }
          
          return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
      }
    

      public InterviewTypeRequest filterByDetailDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InterviewTypeRequest selectDetailDescription(){
          return select(DETAIL_DESCRIPTION_PROPERTY);
      }

      public InterviewTypeRequest unselectDetailDescription(){
          return unselect(DETAIL_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDetailDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public InterviewTypeRequest orderByDetailDescription(boolean asc){
          addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public InterviewTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public InterviewTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InterviewTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public InterviewTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public InterviewTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public InterviewTypeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public InterviewTypeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public InterviewTypeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public InterviewTypeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public InterviewTypeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public InterviewTypeRequest hasEmployeeInterview() {
      return hasEmployeeInterview(EmployeeInterviewRequest.newInstance());
    }

    public InterviewTypeRequest hasEmployeeInterview(EmployeeInterviewRequest employeeInterview) {
        return hasEmployeeInterview(employeeInterview, employeeInterviewList -> employeeInterviewList.stream().map(EmployeeInterview::getInterviewType).map(InterviewType::getId).collect(Collectors.toSet()));
    }

    public InterviewTypeRequest hasEmployeeInterview(EmployeeInterviewRequest employeeInterview, IDRefine<EmployeeInterview> idRefine) {
        employeeInterview.select(EmployeeInterview.INTERVIEW_TYPE_PROPERTY);
        return addSearchCriteria(createEmployeeInterviewCriteria(employeeInterview, idRefine));
    }

    public SearchCriteria createEmployeeInterviewCriteria(EmployeeInterviewRequest employeeInterview, IDRefine<EmployeeInterview> idRefine){
       return new RefinedIdInCriteria(employeeInterview, ID_PROPERTY, idRefine);
    }

    public InterviewTypeRequest selectEmployeeInterviewList(EmployeeInterviewRequest employeeInterview) {
        selectChild(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, employeeInterview);
        return this;
    }

    public InterviewTypeRequest selectEmployeeInterviewList() {
        return selectEmployeeInterviewList(EmployeeInterviewRequest.newInstance().selectAll());
    }

    public InterviewTypeRequest unselectEmployeeInterviewList(){
        unselectChild(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, EmployeeInterview.class);
        return this;
    }
  

   public InterviewTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

