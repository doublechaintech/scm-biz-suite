package com.doublechaintech.retailscm.retailstoredecoration;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration.*;

public class RetailStoreDecorationRequest extends BaseRequest<RetailStoreDecoration> {
    public static RetailStoreDecorationRequest newInstance() {
        return new RetailStoreDecorationRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreDecoration";
    }

    public RetailStoreDecorationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreDecorationRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreDecorationRequest selectAll() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreDecorationRequest selectSelf() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreDecorationRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreDecorationRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreDecorationRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreDecorationRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreDecorationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreDecorationRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreDecorationRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreDecorationRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreDecorationRequest filterByComment(String comment) {
          
          if (comment == null) {
              return this;
          }
          
          return filterByComment(QueryOperator.EQUAL, comment);
      }
    

      public RetailStoreDecorationRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreDecorationRequest selectComment(){
          return select(COMMENT_PROPERTY);
      }

      public RetailStoreDecorationRequest unselectComment(){
          return unselect(COMMENT_PROPERTY);
      }

      public SearchCriteria getCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreDecorationRequest orderByComment(boolean asc){
          addOrderBy(COMMENT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreDecorationRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreDecorationRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreDecorationRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreDecorationRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreDecorationRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public RetailStoreDecorationRequest hasRetailStore() {
      return hasRetailStore(RetailStoreRequest.newInstance());
    }

    public RetailStoreDecorationRequest hasRetailStore(RetailStoreRequest retailStore) {
        return hasRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getDecoration).map(RetailStoreDecoration::getId).collect(Collectors.toSet()));
    }

    public RetailStoreDecorationRequest hasRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        retailStore.select(RetailStore.DECORATION_PROPERTY);
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine){
       return new RefinedIdInCriteria(retailStore, ID_PROPERTY, idRefine);
    }

    public RetailStoreDecorationRequest selectRetailStoreList(RetailStoreRequest retailStore) {
        selectChild(RetailStore.DECORATION_PROPERTY, retailStore);
        return this;
    }

    public RetailStoreDecorationRequest selectRetailStoreList() {
        return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
    }

    public RetailStoreDecorationRequest unselectRetailStoreList(){
        unselectChild(RetailStore.DECORATION_PROPERTY, RetailStore.class);
        return this;
    }
  

   public RetailStoreDecorationRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

