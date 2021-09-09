package com.doublechaintech.retailscm.view;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;


import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.view.View.*;

public class ViewRequest extends BaseRequest<View> {
    public static ViewRequest newInstance() {
        return new ViewRequest().selectId();
    }

    public String getInternalType() {
        return "View";
    }

    public ViewRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ViewRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ViewRequest selectAll() {return this.selectId().selectWho().selectAssessment().selectInterviewTime().selectVersion();
    }

    public ViewRequest selectSelf() {return this.selectId().selectWho().selectAssessment().selectInterviewTime().selectVersion();
    }

    public ViewRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ViewRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ViewRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ViewRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ViewRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ViewRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ViewRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ViewRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ViewRequest filterByWho(String who) {
          
          if (who == null) {
              return this;
          }
          
          return filterByWho(QueryOperator.EQUAL, who);
      }
    

      public ViewRequest filterByWho(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getWhoSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ViewRequest selectWho(){
          return select(WHO_PROPERTY);
      }

      public ViewRequest unselectWho(){
          return unselect(WHO_PROPERTY);
      }

      public SearchCriteria getWhoSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(WHO_PROPERTY, pQueryOperator, parameters);
      }

      public ViewRequest orderByWho(boolean asc){
          addOrderBy(WHO_PROPERTY, asc);
          return this;
      }
   
      public ViewRequest filterByAssessment(String assessment) {
          
          if (assessment == null) {
              return this;
          }
          
          return filterByAssessment(QueryOperator.EQUAL, assessment);
      }
    

      public ViewRequest filterByAssessment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAssessmentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ViewRequest selectAssessment(){
          return select(ASSESSMENT_PROPERTY);
      }

      public ViewRequest unselectAssessment(){
          return unselect(ASSESSMENT_PROPERTY);
      }

      public SearchCriteria getAssessmentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ASSESSMENT_PROPERTY, pQueryOperator, parameters);
      }

      public ViewRequest orderByAssessment(boolean asc){
          addOrderBy(ASSESSMENT_PROPERTY, asc);
          return this;
      }
   
      public ViewRequest filterByInterviewTime(Date interviewTime) {
          
          if (interviewTime == null) {
              return this;
          }
          
          return filterByInterviewTime(QueryOperator.EQUAL, interviewTime);
      }
    

      public ViewRequest filterByInterviewTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getInterviewTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ViewRequest selectInterviewTime(){
          return select(INTERVIEW_TIME_PROPERTY);
      }

      public ViewRequest unselectInterviewTime(){
          return unselect(INTERVIEW_TIME_PROPERTY);
      }

      public SearchCriteria getInterviewTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(INTERVIEW_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public ViewRequest orderByInterviewTime(boolean asc){
          addOrderBy(INTERVIEW_TIME_PROPERTY, asc);
          return this;
      }
   
      public ViewRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ViewRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ViewRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ViewRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ViewRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

   public ViewRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

