package com.doublechaintech.retailscm.terminationreason;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.termination.TerminationRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.terminationreason.TerminationReason.*;

public class TerminationReasonRequest extends BaseRequest<TerminationReason> {
    public static TerminationReasonRequest newInstance() {
        return new TerminationReasonRequest().selectId();
    }

    public String getInternalType() {
        return "TerminationReason";
    }

    public TerminationReasonRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TerminationReasonRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TerminationReasonRequest selectAll() {return this.selectId().selectCode().selectCompany().selectDescription().selectVersion();
    }

    public TerminationReasonRequest selectSelf() {return this.selectId().selectCode().selectDescription().selectVersion();
    }

    public TerminationReasonRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TerminationReasonRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TerminationReasonRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TerminationReasonRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TerminationReasonRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationReasonRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TerminationReasonRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationReasonRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TerminationReasonRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public TerminationReasonRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationReasonRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public TerminationReasonRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationReasonRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public TerminationReasonRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public TerminationReasonRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationReasonRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public TerminationReasonRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationReasonRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public TerminationReasonRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TerminationReasonRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationReasonRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TerminationReasonRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationReasonRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TerminationReasonRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public TerminationReasonRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public TerminationReasonRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public TerminationReasonRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public TerminationReasonRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public TerminationReasonRequest hasTermination() {
      return hasTermination(TerminationRequest.newInstance());
    }

    public TerminationReasonRequest hasTermination(TerminationRequest termination) {
        return hasTermination(termination, terminationList -> terminationList.stream().map(Termination::getReason).map(TerminationReason::getId).collect(Collectors.toSet()));
    }

    public TerminationReasonRequest hasTermination(TerminationRequest termination, IDRefine<Termination> idRefine) {
        termination.select(Termination.REASON_PROPERTY);
        return addSearchCriteria(createTerminationCriteria(termination, idRefine));
    }

    public SearchCriteria createTerminationCriteria(TerminationRequest termination, IDRefine<Termination> idRefine){
       return new RefinedIdInCriteria(termination, ID_PROPERTY, idRefine);
    }

    public TerminationReasonRequest selectTerminationList(TerminationRequest termination) {
        selectChild(Termination.REASON_PROPERTY, termination);
        return this;
    }

    public TerminationReasonRequest selectTerminationList() {
        return selectTerminationList(TerminationRequest.newInstance().selectAll());
    }

    public TerminationReasonRequest unselectTerminationList(){
        unselectChild(Termination.REASON_PROPERTY, Termination.class);
        return this;
    }
  

   public TerminationReasonRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

