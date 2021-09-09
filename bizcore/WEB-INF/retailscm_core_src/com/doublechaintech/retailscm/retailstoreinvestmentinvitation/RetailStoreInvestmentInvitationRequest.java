package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation.*;

public class RetailStoreInvestmentInvitationRequest extends BaseRequest<RetailStoreInvestmentInvitation> {
    public static RetailStoreInvestmentInvitationRequest newInstance() {
        return new RetailStoreInvestmentInvitationRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreInvestmentInvitation";
    }

    public RetailStoreInvestmentInvitationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreInvestmentInvitationRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreInvestmentInvitationRequest selectAll() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreInvestmentInvitationRequest selectSelf() {return this.selectId().selectComment().selectVersion();
    }

    public RetailStoreInvestmentInvitationRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreInvestmentInvitationRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreInvestmentInvitationRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreInvestmentInvitationRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreInvestmentInvitationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreInvestmentInvitationRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreInvestmentInvitationRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreInvestmentInvitationRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreInvestmentInvitationRequest filterByComment(String comment) {
          
          if (comment == null) {
              return this;
          }
          
          return filterByComment(QueryOperator.EQUAL, comment);
      }
    

      public RetailStoreInvestmentInvitationRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreInvestmentInvitationRequest selectComment(){
          return select(COMMENT_PROPERTY);
      }

      public RetailStoreInvestmentInvitationRequest unselectComment(){
          return unselect(COMMENT_PROPERTY);
      }

      public SearchCriteria getCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreInvestmentInvitationRequest orderByComment(boolean asc){
          addOrderBy(COMMENT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreInvestmentInvitationRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreInvestmentInvitationRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreInvestmentInvitationRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreInvestmentInvitationRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreInvestmentInvitationRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public RetailStoreInvestmentInvitationRequest hasRetailStore() {
      return hasRetailStore(RetailStoreRequest.newInstance());
    }

    public RetailStoreInvestmentInvitationRequest hasRetailStore(RetailStoreRequest retailStore) {
        return hasRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getInvestmentInvitation).map(RetailStoreInvestmentInvitation::getId).collect(Collectors.toSet()));
    }

    public RetailStoreInvestmentInvitationRequest hasRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        retailStore.select(RetailStore.INVESTMENT_INVITATION_PROPERTY);
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine){
       return new RefinedIdInCriteria(retailStore, ID_PROPERTY, idRefine);
    }

    public RetailStoreInvestmentInvitationRequest selectRetailStoreList(RetailStoreRequest retailStore) {
        selectChild(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStore);
        return this;
    }

    public RetailStoreInvestmentInvitationRequest selectRetailStoreList() {
        return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
    }

    public RetailStoreInvestmentInvitationRequest unselectRetailStoreList(){
        unselectChild(RetailStore.INVESTMENT_INVITATION_PROPERTY, RetailStore.class);
        return this;
    }
  

   public RetailStoreInvestmentInvitationRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

