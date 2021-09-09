package com.doublechaintech.retailscm.candidateelement;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainerRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.candidateelement.CandidateElement.*;

public class CandidateElementRequest extends BaseRequest<CandidateElement> {
    public static CandidateElementRequest newInstance() {
        return new CandidateElementRequest().selectId();
    }

    public String getInternalType() {
        return "CandidateElement";
    }

    public CandidateElementRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public CandidateElementRequest select(String... names) {
        super.select(names);
        return this;
    }

    public CandidateElementRequest selectAll() {return this.selectId().selectName().selectType().selectImage().selectContainer().selectVersion();
    }

    public CandidateElementRequest selectSelf() {return this.selectId().selectName().selectType().selectImage().selectVersion();
    }

    public CandidateElementRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public CandidateElementRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static CandidateElementRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public CandidateElementRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public CandidateElementRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CandidateElementRequest selectId(){
          return select(ID_PROPERTY);
      }

      public CandidateElementRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public CandidateElementRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public CandidateElementRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public CandidateElementRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CandidateElementRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public CandidateElementRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public CandidateElementRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public CandidateElementRequest filterByType(String type) {
          
          if (type == null) {
              return this;
          }
          
          return filterByType(QueryOperator.EQUAL, type);
      }
    

      public CandidateElementRequest filterByType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CandidateElementRequest selectType(){
          return select(TYPE_PROPERTY);
      }

      public CandidateElementRequest unselectType(){
          return unselect(TYPE_PROPERTY);
      }

      public SearchCriteria getTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public CandidateElementRequest orderByType(boolean asc){
          addOrderBy(TYPE_PROPERTY, asc);
          return this;
      }
   
      public CandidateElementRequest filterByImage(String image) {
          
          if (image == null) {
              return this;
          }
          
          return filterByImage(QueryOperator.EQUAL, image);
      }
    

      public CandidateElementRequest filterByImage(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getImageSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CandidateElementRequest selectImage(){
          return select(IMAGE_PROPERTY);
      }

      public CandidateElementRequest unselectImage(){
          return unselect(IMAGE_PROPERTY);
      }

      public SearchCriteria getImageSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(IMAGE_PROPERTY, pQueryOperator, parameters);
      }

      public CandidateElementRequest orderByImage(boolean asc){
          addOrderBy(IMAGE_PROPERTY, asc);
          return this;
      }
   
      public CandidateElementRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public CandidateElementRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CandidateElementRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public CandidateElementRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public CandidateElementRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public CandidateElementRequest filterByContainer(CandidateContainerRequest container){
        return filterByContainer(container, containerList -> containerList.stream().map(CandidateContainer::getId).collect(Collectors.toSet()));
    }

    public CandidateElementRequest filterByContainer(CandidateContainerRequest container, IDRefine<CandidateContainer> idRefine) {
        return addSearchCriteria(createContainerCriteria(container, idRefine));
    }

    public SearchCriteria createContainerCriteria(CandidateContainerRequest container, IDRefine<CandidateContainer> idRefine) {
        return new RefinedIdInCriteria(container, CONTAINER_PROPERTY, idRefine);
    }
    

    
    public CandidateElementRequest selectContainer(){
        return selectContainer(CandidateContainerRequest.newInstance().selectSelf());
    }

    public CandidateElementRequest selectContainer(CandidateContainerRequest container){
        selectParent(CONTAINER_PROPERTY, container);
        return this;
    }
    

    public CandidateElementRequest unselectContainer(){
        unselectParent(CONTAINER_PROPERTY);
        return this;
    }

  


  

   public CandidateElementRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

