package com.doublechaintech.retailscm.retailstoreclosing;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing.*;

public class RetailStoreClosingRequest extends BaseRequest<RetailStoreClosing> {
    public static RetailStoreClosingRequest newInstance() {
        return new RetailStoreClosingRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreClosing";
    }

    public RetailStoreClosingRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreClosingRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreClosingRequest selectAll() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreClosingRequest selectSelf() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreClosingRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreClosingRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreClosingRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreClosingRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreClosingRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreClosingRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreClosingRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreClosingRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreClosingRequest filterByComment(String comment) {
          
          if (comment == null) {
              return this;
          }
          
          return filterByComment(QueryOperator.EQUAL, comment);
      }
    

      public RetailStoreClosingRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreClosingRequest selectComment(){
          return select(COMMENT_PROPERTY);
      }

      public RetailStoreClosingRequest unselectComment(){
          return unselect(COMMENT_PROPERTY);
      }

      public SearchCriteria getCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreClosingRequest orderByComment(boolean asc){
          addOrderBy(COMMENT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreClosingRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreClosingRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreClosingRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreClosingRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreClosingRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public RetailStoreClosingRequest hasRetailStore() {
      return hasRetailStore(RetailStoreRequest.newInstance());
    }

    public RetailStoreClosingRequest hasRetailStore(RetailStoreRequest retailStore) {
        return hasRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getClosing).map(RetailStoreClosing::getId).collect(Collectors.toSet()));
    }

    public RetailStoreClosingRequest hasRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        retailStore.select(RetailStore.CLOSING_PROPERTY);
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine){
       return new RefinedIdInCriteria(retailStore, ID_PROPERTY, idRefine);
    }

    public RetailStoreClosingRequest selectRetailStoreList(RetailStoreRequest retailStore) {
        selectChild(RetailStore.CLOSING_PROPERTY, retailStore);
        return this;
    }

    public RetailStoreClosingRequest selectRetailStoreList() {
        return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
    }

    public RetailStoreClosingRequest unselectRetailStoreList(){
        unselectChild(RetailStore.CLOSING_PROPERTY, RetailStore.class);
        return this;
    }
  

   public RetailStoreClosingRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

