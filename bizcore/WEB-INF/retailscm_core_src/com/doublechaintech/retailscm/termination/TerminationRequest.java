package com.doublechaintech.retailscm.termination;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.termination.Termination.*;

public class TerminationRequest extends BaseRequest<Termination> {
    public static TerminationRequest newInstance() {
        return new TerminationRequest().selectId();
    }

    public String getInternalType() {
        return "Termination";
    }

    public TerminationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TerminationRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TerminationRequest selectAll() {return this.selectId().selectReason().selectType().selectComment().selectVersion();
    }

    public TerminationRequest selectSelf() {return this.selectId().selectComment().selectVersion();
    }

    public TerminationRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TerminationRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TerminationRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TerminationRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TerminationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TerminationRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TerminationRequest filterByComment(String comment) {
          
          if (comment == null) {
              return this;
          }
          
          return filterByComment(QueryOperator.EQUAL, comment);
      }
    

      public TerminationRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationRequest selectComment(){
          return select(COMMENT_PROPERTY);
      }

      public TerminationRequest unselectComment(){
          return unselect(COMMENT_PROPERTY);
      }

      public SearchCriteria getCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationRequest orderByComment(boolean asc){
          addOrderBy(COMMENT_PROPERTY, asc);
          return this;
      }
   
      public TerminationRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TerminationRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TerminationRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TerminationRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TerminationRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TerminationRequest filterByReason(TerminationReasonRequest reason){
        return filterByReason(reason, reasonList -> reasonList.stream().map(TerminationReason::getId).collect(Collectors.toSet()));
    }

    public TerminationRequest filterByReason(TerminationReasonRequest reason, IDRefine<TerminationReason> idRefine) {
        return addSearchCriteria(createReasonCriteria(reason, idRefine));
    }

    public SearchCriteria createReasonCriteria(TerminationReasonRequest reason, IDRefine<TerminationReason> idRefine) {
        return new RefinedIdInCriteria(reason, REASON_PROPERTY, idRefine);
    }
    

    
    public TerminationRequest selectReason(){
        return selectReason(TerminationReasonRequest.newInstance().selectSelf());
    }

    public TerminationRequest selectReason(TerminationReasonRequest reason){
        selectParent(REASON_PROPERTY, reason);
        return this;
    }
    

    public TerminationRequest unselectReason(){
        unselectParent(REASON_PROPERTY);
        return this;
    }

  

    
    public TerminationRequest filterByType(TerminationTypeRequest type){
        return filterByType(type, typeList -> typeList.stream().map(TerminationType::getId).collect(Collectors.toSet()));
    }

    public TerminationRequest filterByType(TerminationTypeRequest type, IDRefine<TerminationType> idRefine) {
        return addSearchCriteria(createTypeCriteria(type, idRefine));
    }

    public SearchCriteria createTypeCriteria(TerminationTypeRequest type, IDRefine<TerminationType> idRefine) {
        return new RefinedIdInCriteria(type, TYPE_PROPERTY, idRefine);
    }
    

    
    public TerminationRequest selectType(){
        return selectType(TerminationTypeRequest.newInstance().selectSelf());
    }

    public TerminationRequest selectType(TerminationTypeRequest type){
        selectParent(TYPE_PROPERTY, type);
        return this;
    }
    

    public TerminationRequest unselectType(){
        unselectParent(TYPE_PROPERTY);
        return this;
    }

  


  

   public TerminationRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

