package com.doublechaintech.retailscm.employeecompanytraining;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.scoring.ScoringRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining.*;

public class EmployeeCompanyTrainingRequest extends BaseRequest<EmployeeCompanyTraining> {
    public static EmployeeCompanyTrainingRequest newInstance() {
        return new EmployeeCompanyTrainingRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeCompanyTraining";
    }

    public EmployeeCompanyTrainingRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeCompanyTrainingRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeCompanyTrainingRequest selectAll() {return this.selectId().selectEmployee().selectTraining().selectScoring().selectVersion();
    }

    public EmployeeCompanyTrainingRequest selectSelf() {return this.selectId().selectVersion();
    }

    public EmployeeCompanyTrainingRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeCompanyTrainingRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeCompanyTrainingRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeCompanyTrainingRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeCompanyTrainingRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeCompanyTrainingRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeCompanyTrainingRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeCompanyTrainingRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeCompanyTrainingRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeCompanyTrainingRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeCompanyTrainingRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeCompanyTrainingRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeCompanyTrainingRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeCompanyTrainingRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeCompanyTrainingRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeCompanyTrainingRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeCompanyTrainingRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeCompanyTrainingRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  

    
    public EmployeeCompanyTrainingRequest filterByTraining(CompanyTrainingRequest training){
        return filterByTraining(training, trainingList -> trainingList.stream().map(CompanyTraining::getId).collect(Collectors.toSet()));
    }

    public EmployeeCompanyTrainingRequest filterByTraining(CompanyTrainingRequest training, IDRefine<CompanyTraining> idRefine) {
        return addSearchCriteria(createTrainingCriteria(training, idRefine));
    }

    public SearchCriteria createTrainingCriteria(CompanyTrainingRequest training, IDRefine<CompanyTraining> idRefine) {
        return new RefinedIdInCriteria(training, TRAINING_PROPERTY, idRefine);
    }
    

    
    public EmployeeCompanyTrainingRequest selectTraining(){
        return selectTraining(CompanyTrainingRequest.newInstance().selectSelf());
    }

    public EmployeeCompanyTrainingRequest selectTraining(CompanyTrainingRequest training){
        selectParent(TRAINING_PROPERTY, training);
        return this;
    }
    

    public EmployeeCompanyTrainingRequest unselectTraining(){
        unselectParent(TRAINING_PROPERTY);
        return this;
    }

  

    
    public EmployeeCompanyTrainingRequest filterByScoring(ScoringRequest scoring){
        return filterByScoring(scoring, scoringList -> scoringList.stream().map(Scoring::getId).collect(Collectors.toSet()));
    }

    public EmployeeCompanyTrainingRequest filterByScoring(ScoringRequest scoring, IDRefine<Scoring> idRefine) {
        return addSearchCriteria(createScoringCriteria(scoring, idRefine));
    }

    public SearchCriteria createScoringCriteria(ScoringRequest scoring, IDRefine<Scoring> idRefine) {
        return new RefinedIdInCriteria(scoring, SCORING_PROPERTY, idRefine);
    }
    

    
    public EmployeeCompanyTrainingRequest selectScoring(){
        return selectScoring(ScoringRequest.newInstance().selectSelf());
    }

    public EmployeeCompanyTrainingRequest selectScoring(ScoringRequest scoring){
        selectParent(SCORING_PROPERTY, scoring);
        return this;
    }
    

    public EmployeeCompanyTrainingRequest unselectScoring(){
        unselectParent(SCORING_PROPERTY);
        return this;
    }

  


  

   public EmployeeCompanyTrainingRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

