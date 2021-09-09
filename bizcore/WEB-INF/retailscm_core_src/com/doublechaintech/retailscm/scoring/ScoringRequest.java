package com.doublechaintech.retailscm.scoring;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.scoring.Scoring.*;

public class ScoringRequest extends BaseRequest<Scoring> {
    public static ScoringRequest newInstance() {
        return new ScoringRequest().selectId();
    }

    public String getInternalType() {
        return "Scoring";
    }

    public ScoringRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ScoringRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ScoringRequest selectAll() {return this.selectId().selectScoredBy().selectScore().selectComment().selectVersion();
    }

    public ScoringRequest selectSelf() {return this.selectId().selectScoredBy().selectScore().selectComment().selectVersion();
    }

    public ScoringRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ScoringRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ScoringRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ScoringRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ScoringRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ScoringRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ScoringRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ScoringRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ScoringRequest filterByScoredBy(String scoredBy) {
          
          if (scoredBy == null) {
              return this;
          }
          
          return filterByScoredBy(QueryOperator.EQUAL, scoredBy);
      }
    

      public ScoringRequest filterByScoredBy(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getScoredBySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ScoringRequest selectScoredBy(){
          return select(SCORED_BY_PROPERTY);
      }

      public ScoringRequest unselectScoredBy(){
          return unselect(SCORED_BY_PROPERTY);
      }

      public SearchCriteria getScoredBySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SCORED_BY_PROPERTY, pQueryOperator, parameters);
      }

      public ScoringRequest orderByScoredBy(boolean asc){
          addOrderBy(SCORED_BY_PROPERTY, asc);
          return this;
      }
   
      public ScoringRequest filterByScore(int score) {
          
          return filterByScore(QueryOperator.EQUAL, score);
      }
    

      public ScoringRequest filterByScore(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getScoreSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ScoringRequest selectScore(){
          return select(SCORE_PROPERTY);
      }

      public ScoringRequest unselectScore(){
          return unselect(SCORE_PROPERTY);
      }

      public SearchCriteria getScoreSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SCORE_PROPERTY, pQueryOperator, parameters);
      }

      public ScoringRequest orderByScore(boolean asc){
          addOrderBy(SCORE_PROPERTY, asc);
          return this;
      }
   
      public ScoringRequest filterByComment(String comment) {
          
          if (comment == null) {
              return this;
          }
          
          return filterByComment(QueryOperator.EQUAL, comment);
      }
    

      public ScoringRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ScoringRequest selectComment(){
          return select(COMMENT_PROPERTY);
      }

      public ScoringRequest unselectComment(){
          return unselect(COMMENT_PROPERTY);
      }

      public SearchCriteria getCommentSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
      }

      public ScoringRequest orderByComment(boolean asc){
          addOrderBy(COMMENT_PROPERTY, asc);
          return this;
      }
   
      public ScoringRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ScoringRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ScoringRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ScoringRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ScoringRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public ScoringRequest hasEmployeeCompanyTraining() {
      return hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest.newInstance());
    }

    public ScoringRequest hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest employeeCompanyTraining) {
        return hasEmployeeCompanyTraining(employeeCompanyTraining, employeeCompanyTrainingList -> employeeCompanyTrainingList.stream().map(EmployeeCompanyTraining::getScoring).map(Scoring::getId).collect(Collectors.toSet()));
    }

    public ScoringRequest hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest employeeCompanyTraining, IDRefine<EmployeeCompanyTraining> idRefine) {
        employeeCompanyTraining.select(EmployeeCompanyTraining.SCORING_PROPERTY);
        return addSearchCriteria(createEmployeeCompanyTrainingCriteria(employeeCompanyTraining, idRefine));
    }

    public SearchCriteria createEmployeeCompanyTrainingCriteria(EmployeeCompanyTrainingRequest employeeCompanyTraining, IDRefine<EmployeeCompanyTraining> idRefine){
       return new RefinedIdInCriteria(employeeCompanyTraining, ID_PROPERTY, idRefine);
    }

    public ScoringRequest selectEmployeeCompanyTrainingList(EmployeeCompanyTrainingRequest employeeCompanyTraining) {
        selectChild(EmployeeCompanyTraining.SCORING_PROPERTY, employeeCompanyTraining);
        return this;
    }

    public ScoringRequest selectEmployeeCompanyTrainingList() {
        return selectEmployeeCompanyTrainingList(EmployeeCompanyTrainingRequest.newInstance().selectAll());
    }

    public ScoringRequest unselectEmployeeCompanyTrainingList(){
        unselectChild(EmployeeCompanyTraining.SCORING_PROPERTY, EmployeeCompanyTraining.class);
        return this;
    }
  

   public ScoringRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

