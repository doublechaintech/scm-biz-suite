package com.doublechaintech.retailscm.companytraining;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest;
import com.doublechaintech.retailscm.instructor.InstructorRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.companytraining.CompanyTraining.*;

public class CompanyTrainingRequest extends BaseRequest<CompanyTraining> {
    public static CompanyTrainingRequest newInstance() {
        return new CompanyTrainingRequest().selectId();
    }

    public String getInternalType() {
        return "CompanyTraining";
    }

    public CompanyTrainingRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public CompanyTrainingRequest select(String... names) {
        super.select(names);
        return this;
    }

    public CompanyTrainingRequest selectAll() {return this.selectId().selectTitle().selectCompany().selectInstructor().selectTrainingCourseType().selectTimeStart().selectDurationHours().selectLastUpdateTime().selectVersion();
    }

    public CompanyTrainingRequest selectSelf() {return this.selectId().selectTitle().selectTimeStart().selectDurationHours().selectLastUpdateTime().selectVersion();
    }

    public CompanyTrainingRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public CompanyTrainingRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static CompanyTrainingRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public CompanyTrainingRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public CompanyTrainingRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CompanyTrainingRequest selectId(){
          return select(ID_PROPERTY);
      }

      public CompanyTrainingRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public CompanyTrainingRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public CompanyTrainingRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public CompanyTrainingRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CompanyTrainingRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public CompanyTrainingRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public CompanyTrainingRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public CompanyTrainingRequest filterByTimeStart(Date timeStart) {
          
          if (timeStart == null) {
              return this;
          }
          
          return filterByTimeStart(QueryOperator.EQUAL, timeStart);
      }
    

      public CompanyTrainingRequest filterByTimeStart(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTimeStartSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CompanyTrainingRequest selectTimeStart(){
          return select(TIME_START_PROPERTY);
      }

      public CompanyTrainingRequest unselectTimeStart(){
          return unselect(TIME_START_PROPERTY);
      }

      public SearchCriteria getTimeStartSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TIME_START_PROPERTY, pQueryOperator, parameters);
      }

      public CompanyTrainingRequest orderByTimeStart(boolean asc){
          addOrderBy(TIME_START_PROPERTY, asc);
          return this;
      }
   
      public CompanyTrainingRequest filterByDurationHours(int durationHours) {
          
          return filterByDurationHours(QueryOperator.EQUAL, durationHours);
      }
    

      public CompanyTrainingRequest filterByDurationHours(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDurationHoursSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CompanyTrainingRequest selectDurationHours(){
          return select(DURATION_HOURS_PROPERTY);
      }

      public CompanyTrainingRequest unselectDurationHours(){
          return unselect(DURATION_HOURS_PROPERTY);
      }

      public SearchCriteria getDurationHoursSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DURATION_HOURS_PROPERTY, pQueryOperator, parameters);
      }

      public CompanyTrainingRequest orderByDurationHours(boolean asc){
          addOrderBy(DURATION_HOURS_PROPERTY, asc);
          return this;
      }
   
      public CompanyTrainingRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public CompanyTrainingRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CompanyTrainingRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public CompanyTrainingRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public CompanyTrainingRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public CompanyTrainingRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public CompanyTrainingRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public CompanyTrainingRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public CompanyTrainingRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public CompanyTrainingRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public CompanyTrainingRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public CompanyTrainingRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public CompanyTrainingRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public CompanyTrainingRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public CompanyTrainingRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  

    
    public CompanyTrainingRequest filterByInstructor(InstructorRequest instructor){
        return filterByInstructor(instructor, instructorList -> instructorList.stream().map(Instructor::getId).collect(Collectors.toSet()));
    }

    public CompanyTrainingRequest filterByInstructor(InstructorRequest instructor, IDRefine<Instructor> idRefine) {
        return addSearchCriteria(createInstructorCriteria(instructor, idRefine));
    }

    public SearchCriteria createInstructorCriteria(InstructorRequest instructor, IDRefine<Instructor> idRefine) {
        return new RefinedIdInCriteria(instructor, INSTRUCTOR_PROPERTY, idRefine);
    }
    

    
    public CompanyTrainingRequest selectInstructor(){
        return selectInstructor(InstructorRequest.newInstance().selectSelf());
    }

    public CompanyTrainingRequest selectInstructor(InstructorRequest instructor){
        selectParent(INSTRUCTOR_PROPERTY, instructor);
        return this;
    }
    

    public CompanyTrainingRequest unselectInstructor(){
        unselectParent(INSTRUCTOR_PROPERTY);
        return this;
    }

  

    
    public CompanyTrainingRequest filterByTrainingCourseType(TrainingCourseTypeRequest trainingCourseType){
        return filterByTrainingCourseType(trainingCourseType, trainingCourseTypeList -> trainingCourseTypeList.stream().map(TrainingCourseType::getId).collect(Collectors.toSet()));
    }

    public CompanyTrainingRequest filterByTrainingCourseType(TrainingCourseTypeRequest trainingCourseType, IDRefine<TrainingCourseType> idRefine) {
        return addSearchCriteria(createTrainingCourseTypeCriteria(trainingCourseType, idRefine));
    }

    public SearchCriteria createTrainingCourseTypeCriteria(TrainingCourseTypeRequest trainingCourseType, IDRefine<TrainingCourseType> idRefine) {
        return new RefinedIdInCriteria(trainingCourseType, TRAINING_COURSE_TYPE_PROPERTY, idRefine);
    }
    

    
    public CompanyTrainingRequest selectTrainingCourseType(){
        return selectTrainingCourseType(TrainingCourseTypeRequest.newInstance().selectSelf());
    }

    public CompanyTrainingRequest selectTrainingCourseType(TrainingCourseTypeRequest trainingCourseType){
        selectParent(TRAINING_COURSE_TYPE_PROPERTY, trainingCourseType);
        return this;
    }
    

    public CompanyTrainingRequest unselectTrainingCourseType(){
        unselectParent(TRAINING_COURSE_TYPE_PROPERTY);
        return this;
    }

  


  

    public CompanyTrainingRequest hasEmployeeCompanyTraining() {
      return hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest.newInstance());
    }

    public CompanyTrainingRequest hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest employeeCompanyTraining) {
        return hasEmployeeCompanyTraining(employeeCompanyTraining, employeeCompanyTrainingList -> employeeCompanyTrainingList.stream().map(EmployeeCompanyTraining::getTraining).map(CompanyTraining::getId).collect(Collectors.toSet()));
    }

    public CompanyTrainingRequest hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest employeeCompanyTraining, IDRefine<EmployeeCompanyTraining> idRefine) {
        employeeCompanyTraining.select(EmployeeCompanyTraining.TRAINING_PROPERTY);
        return addSearchCriteria(createEmployeeCompanyTrainingCriteria(employeeCompanyTraining, idRefine));
    }

    public SearchCriteria createEmployeeCompanyTrainingCriteria(EmployeeCompanyTrainingRequest employeeCompanyTraining, IDRefine<EmployeeCompanyTraining> idRefine){
       return new RefinedIdInCriteria(employeeCompanyTraining, ID_PROPERTY, idRefine);
    }

    public CompanyTrainingRequest selectEmployeeCompanyTrainingList(EmployeeCompanyTrainingRequest employeeCompanyTraining) {
        selectChild(EmployeeCompanyTraining.TRAINING_PROPERTY, employeeCompanyTraining);
        return this;
    }

    public CompanyTrainingRequest selectEmployeeCompanyTrainingList() {
        return selectEmployeeCompanyTrainingList(EmployeeCompanyTrainingRequest.newInstance().selectAll());
    }

    public CompanyTrainingRequest unselectEmployeeCompanyTrainingList(){
        unselectChild(EmployeeCompanyTraining.TRAINING_PROPERTY, EmployeeCompanyTraining.class);
        return this;
    }
  

   public CompanyTrainingRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

