package com.doublechaintech.retailscm.retailstoreopening;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening.*;

public class RetailStoreOpeningRequest extends BaseRequest<RetailStoreOpening> {
    public static RetailStoreOpeningRequest newInstance() {
        return new RetailStoreOpeningRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreOpening";
    }

    public RetailStoreOpeningRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreOpeningRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreOpeningRequest selectAll() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreOpeningRequest selectSelf() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreOpeningRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreOpeningRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreOpeningRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreOpeningRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreOpeningRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOpeningRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreOpeningRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOpeningRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOpeningRequest filterByComment(String comment) {
          
          if (comment == null) {
              return this;
          }
          
          return filterByComment(QueryOperator.EQUAL, comment);
      }
    

      public RetailStoreOpeningRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOpeningRequest selectComment(){
          return select(COMMENT_PROPERTY);
      }

      public RetailStoreOpeningRequest unselectComment(){
          return unselect(COMMENT_PROPERTY);
      }

      public SearchCriteria getCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOpeningRequest orderByComment(boolean asc){
          addOrderBy(COMMENT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOpeningRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreOpeningRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOpeningRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreOpeningRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOpeningRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public RetailStoreOpeningRequest hasRetailStore() {
      return hasRetailStore(RetailStoreRequest.newInstance());
    }

    public RetailStoreOpeningRequest hasRetailStore(RetailStoreRequest retailStore) {
        return hasRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getOpening).map(RetailStoreOpening::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOpeningRequest hasRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        retailStore.select(RetailStore.OPENING_PROPERTY);
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine){
       return new RefinedIdInCriteria(retailStore, ID_PROPERTY, idRefine);
    }

    public RetailStoreOpeningRequest selectRetailStoreList(RetailStoreRequest retailStore) {
        selectChild(RetailStore.OPENING_PROPERTY, retailStore);
        return this;
    }

    public RetailStoreOpeningRequest selectRetailStoreList() {
        return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
    }

    public RetailStoreOpeningRequest unselectRetailStoreList(){
        unselectChild(RetailStore.OPENING_PROPERTY, RetailStore.class);
        return this;
    }
  

   public RetailStoreOpeningRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

