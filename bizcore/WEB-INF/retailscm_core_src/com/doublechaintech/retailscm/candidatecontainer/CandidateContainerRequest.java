package com.doublechaintech.retailscm.candidatecontainer;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.candidateelement.CandidateElement;
import com.doublechaintech.retailscm.candidateelement.CandidateElementRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.candidatecontainer.CandidateContainer.*;

public class CandidateContainerRequest extends BaseRequest<CandidateContainer> {
    public static CandidateContainerRequest newInstance() {
        return new CandidateContainerRequest().selectId();
    }

    public String getInternalType() {
        return "CandidateContainer";
    }

    public CandidateContainerRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public CandidateContainerRequest select(String... names) {
        super.select(names);
        return this;
    }

    public CandidateContainerRequest selectAll() {return this.selectId().selectName().selectVersion();
    }

    public CandidateContainerRequest selectSelf() {return this.selectId().selectName().selectVersion();
    }

    public CandidateContainerRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public CandidateContainerRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static CandidateContainerRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public CandidateContainerRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public CandidateContainerRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CandidateContainerRequest selectId(){
          return select(ID_PROPERTY);
      }

      public CandidateContainerRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public CandidateContainerRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public CandidateContainerRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public CandidateContainerRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CandidateContainerRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public CandidateContainerRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public CandidateContainerRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public CandidateContainerRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public CandidateContainerRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CandidateContainerRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public CandidateContainerRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public CandidateContainerRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public CandidateContainerRequest hasCandidateElement() {
      return hasCandidateElement(CandidateElementRequest.newInstance());
    }

    public CandidateContainerRequest hasCandidateElement(CandidateElementRequest candidateElement) {
        return hasCandidateElement(candidateElement, candidateElementList -> candidateElementList.stream().map(CandidateElement::getContainer).map(CandidateContainer::getId).collect(Collectors.toSet()));
    }

    public CandidateContainerRequest hasCandidateElement(CandidateElementRequest candidateElement, IDRefine<CandidateElement> idRefine) {
        candidateElement.select(CandidateElement.CONTAINER_PROPERTY);
        return addSearchCriteria(createCandidateElementCriteria(candidateElement, idRefine));
    }

    public SearchCriteria createCandidateElementCriteria(CandidateElementRequest candidateElement, IDRefine<CandidateElement> idRefine){
       return new RefinedIdInCriteria(candidateElement, ID_PROPERTY, idRefine);
    }

    public CandidateContainerRequest selectCandidateElementList(CandidateElementRequest candidateElement) {
        selectChild(CandidateElement.CONTAINER_PROPERTY, candidateElement);
        return this;
    }

    public CandidateContainerRequest selectCandidateElementList() {
        return selectCandidateElementList(CandidateElementRequest.newInstance().selectAll());
    }

    public CandidateContainerRequest unselectCandidateElementList(){
        unselectChild(CandidateElement.CONTAINER_PROPERTY, CandidateElement.class);
        return this;
    }
  

   public CandidateContainerRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

