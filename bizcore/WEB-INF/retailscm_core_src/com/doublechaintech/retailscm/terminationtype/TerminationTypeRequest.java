package com.doublechaintech.retailscm.terminationtype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.termination.TerminationRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.terminationtype.TerminationType.*;

public class TerminationTypeRequest extends BaseRequest<TerminationType> {
    public static TerminationTypeRequest newInstance() {
        return new TerminationTypeRequest().selectId();
    }

    public String getInternalType() {
        return "TerminationType";
    }

    public TerminationTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TerminationTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TerminationTypeRequest selectAll() {return this.selectId().selectCode().selectCompany().selectBaseDescription().selectDetailDescription().selectVersion();
    }

    public TerminationTypeRequest selectSelf() {return this.selectId().selectCode().selectBaseDescription().selectDetailDescription().selectVersion();
    }

    public TerminationTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TerminationTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TerminationTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TerminationTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TerminationTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TerminationTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TerminationTypeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public TerminationTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationTypeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public TerminationTypeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationTypeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public TerminationTypeRequest filterByBaseDescription(String baseDescription) {
          
          if (baseDescription == null) {
              return this;
          }
          
          return filterByBaseDescription(QueryOperator.EQUAL, baseDescription);
      }
    

      public TerminationTypeRequest filterByBaseDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getBaseDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationTypeRequest selectBaseDescription(){
          return select(BASE_DESCRIPTION_PROPERTY);
      }

      public TerminationTypeRequest unselectBaseDescription(){
          return unselect(BASE_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getBaseDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(BASE_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationTypeRequest orderByBaseDescription(boolean asc){
          addOrderBy(BASE_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public TerminationTypeRequest filterByDetailDescription(String detailDescription) {
          
          if (detailDescription == null) {
              return this;
          }
          
          return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
      }
    

      public TerminationTypeRequest filterByDetailDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationTypeRequest selectDetailDescription(){
          return select(DETAIL_DESCRIPTION_PROPERTY);
      }

      public TerminationTypeRequest unselectDetailDescription(){
          return unselect(DETAIL_DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDetailDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationTypeRequest orderByDetailDescription(boolean asc){
          addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public TerminationTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TerminationTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TerminationTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TerminationTypeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public TerminationTypeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public TerminationTypeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public TerminationTypeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public TerminationTypeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public TerminationTypeRequest hasTermination() {
      return hasTermination(TerminationRequest.newInstance());
    }

    public TerminationTypeRequest hasTermination(TerminationRequest termination) {
        return hasTermination(termination, terminationList -> terminationList.stream().map(Termination::getType).map(TerminationType::getId).collect(Collectors.toSet()));
    }

    public TerminationTypeRequest hasTermination(TerminationRequest termination, IDRefine<Termination> idRefine) {
        termination.select(Termination.TYPE_PROPERTY);
        return addSearchCriteria(createTerminationCriteria(termination, idRefine));
    }

    public SearchCriteria createTerminationCriteria(TerminationRequest termination, IDRefine<Termination> idRefine){
       return new RefinedIdInCriteria(termination, ID_PROPERTY, idRefine);
    }

    public TerminationTypeRequest selectTerminationList(TerminationRequest termination) {
        selectChild(Termination.TYPE_PROPERTY, termination);
        return this;
    }

    public TerminationTypeRequest selectTerminationList() {
        return selectTerminationList(TerminationRequest.newInstance().selectAll());
    }

    public TerminationTypeRequest unselectTerminationList(){
        unselectChild(Termination.TYPE_PROPERTY, Termination.class);
        return this;
    }
  

   public TerminationTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

