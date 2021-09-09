package com.doublechaintech.retailscm.retailstorefranchising;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising.*;

public class RetailStoreFranchisingRequest extends BaseRequest<RetailStoreFranchising> {
    public static RetailStoreFranchisingRequest newInstance() {
        return new RetailStoreFranchisingRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreFranchising";
    }

    public RetailStoreFranchisingRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreFranchisingRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreFranchisingRequest selectAll() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreFranchisingRequest selectSelf() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreFranchisingRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreFranchisingRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreFranchisingRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreFranchisingRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreFranchisingRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreFranchisingRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreFranchisingRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreFranchisingRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreFranchisingRequest filterByComment(String comment) {
          
          if (comment == null) {
              return this;
          }
          
          return filterByComment(QueryOperator.EQUAL, comment);
      }
    

      public RetailStoreFranchisingRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreFranchisingRequest selectComment(){
          return select(COMMENT_PROPERTY);
      }

      public RetailStoreFranchisingRequest unselectComment(){
          return unselect(COMMENT_PROPERTY);
      }

      public SearchCriteria getCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreFranchisingRequest orderByComment(boolean asc){
          addOrderBy(COMMENT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreFranchisingRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreFranchisingRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreFranchisingRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreFranchisingRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreFranchisingRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public RetailStoreFranchisingRequest hasRetailStore() {
      return hasRetailStore(RetailStoreRequest.newInstance());
    }

    public RetailStoreFranchisingRequest hasRetailStore(RetailStoreRequest retailStore) {
        return hasRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getFranchising).map(RetailStoreFranchising::getId).collect(Collectors.toSet()));
    }

    public RetailStoreFranchisingRequest hasRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        retailStore.select(RetailStore.FRANCHISING_PROPERTY);
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine){
       return new RefinedIdInCriteria(retailStore, ID_PROPERTY, idRefine);
    }

    public RetailStoreFranchisingRequest selectRetailStoreList(RetailStoreRequest retailStore) {
        selectChild(RetailStore.FRANCHISING_PROPERTY, retailStore);
        return this;
    }

    public RetailStoreFranchisingRequest selectRetailStoreList() {
        return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
    }

    public RetailStoreFranchisingRequest unselectRetailStoreList(){
        unselectChild(RetailStore.FRANCHISING_PROPERTY, RetailStore.class);
        return this;
    }
  

   public RetailStoreFranchisingRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

