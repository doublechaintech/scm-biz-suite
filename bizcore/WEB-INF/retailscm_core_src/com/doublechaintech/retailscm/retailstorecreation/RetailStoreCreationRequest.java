package com.doublechaintech.retailscm.retailstorecreation;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation.*;

public class RetailStoreCreationRequest extends BaseRequest<RetailStoreCreation> {
    public static RetailStoreCreationRequest newInstance() {
        return new RetailStoreCreationRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreCreation";
    }

    public RetailStoreCreationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreCreationRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreCreationRequest selectAll() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreCreationRequest selectSelf() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreCreationRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreCreationRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreCreationRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreCreationRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreCreationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCreationRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreCreationRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCreationRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCreationRequest filterByComment(String comment) {
          
          if (comment == null) {
              return this;
          }
          
          return filterByComment(QueryOperator.EQUAL, comment);
      }
    

      public RetailStoreCreationRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCreationRequest selectComment(){
          return select(COMMENT_PROPERTY);
      }

      public RetailStoreCreationRequest unselectComment(){
          return unselect(COMMENT_PROPERTY);
      }

      public SearchCriteria getCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCreationRequest orderByComment(boolean asc){
          addOrderBy(COMMENT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCreationRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreCreationRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCreationRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreCreationRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCreationRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public RetailStoreCreationRequest hasRetailStore() {
      return hasRetailStore(RetailStoreRequest.newInstance());
    }

    public RetailStoreCreationRequest hasRetailStore(RetailStoreRequest retailStore) {
        return hasRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getCreation).map(RetailStoreCreation::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCreationRequest hasRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        retailStore.select(RetailStore.CREATION_PROPERTY);
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine){
       return new RefinedIdInCriteria(retailStore, ID_PROPERTY, idRefine);
    }

    public RetailStoreCreationRequest selectRetailStoreList(RetailStoreRequest retailStore) {
        selectChild(RetailStore.CREATION_PROPERTY, retailStore);
        return this;
    }

    public RetailStoreCreationRequest selectRetailStoreList() {
        return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
    }

    public RetailStoreCreationRequest unselectRetailStoreList(){
        unselectChild(RetailStore.CREATION_PROPERTY, RetailStore.class);
        return this;
    }
  

   public RetailStoreCreationRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

