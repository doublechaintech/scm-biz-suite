package com.doublechaintech.retailscm.trainingcoursetype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType.*;

public class TrainingCourseTypeRequest extends BaseRequest<TrainingCourseType> {
    public static TrainingCourseTypeRequest newInstance() {
        return new TrainingCourseTypeRequest().selectId();
    }

    public String getInternalType() {
        return "TrainingCourseType";
    }

    public TrainingCourseTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public TrainingCourseTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public TrainingCourseTypeRequest selectAll() {return this.selectId().selectCode().selectCompany().selectName().selectDescription().selectVersion();
    }

    public TrainingCourseTypeRequest selectSelf() {return this.selectId().selectCode().selectName().selectDescription().selectVersion();
    }

    public TrainingCourseTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public TrainingCourseTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static TrainingCourseTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public TrainingCourseTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public TrainingCourseTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TrainingCourseTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public TrainingCourseTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public TrainingCourseTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public TrainingCourseTypeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public TrainingCourseTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TrainingCourseTypeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public TrainingCourseTypeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public TrainingCourseTypeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public TrainingCourseTypeRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public TrainingCourseTypeRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TrainingCourseTypeRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public TrainingCourseTypeRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public TrainingCourseTypeRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public TrainingCourseTypeRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public TrainingCourseTypeRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TrainingCourseTypeRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public TrainingCourseTypeRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public TrainingCourseTypeRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public TrainingCourseTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public TrainingCourseTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public TrainingCourseTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public TrainingCourseTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public TrainingCourseTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public TrainingCourseTypeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public TrainingCourseTypeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public TrainingCourseTypeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public TrainingCourseTypeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public TrainingCourseTypeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public TrainingCourseTypeRequest hasCompanyTraining() {
      return hasCompanyTraining(CompanyTrainingRequest.newInstance());
    }

    public TrainingCourseTypeRequest hasCompanyTraining(CompanyTrainingRequest companyTraining) {
        return hasCompanyTraining(companyTraining, companyTrainingList -> companyTrainingList.stream().map(CompanyTraining::getTrainingCourseType).map(TrainingCourseType::getId).collect(Collectors.toSet()));
    }

    public TrainingCourseTypeRequest hasCompanyTraining(CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
        companyTraining.select(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY);
        return addSearchCriteria(createCompanyTrainingCriteria(companyTraining, idRefine));
    }

    public SearchCriteria createCompanyTrainingCriteria(CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine){
       return new RefinedIdInCriteria(companyTraining, ID_PROPERTY, idRefine);
    }

    public TrainingCourseTypeRequest selectCompanyTrainingList(CompanyTrainingRequest companyTraining) {
        selectChild(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, companyTraining);
        return this;
    }

    public TrainingCourseTypeRequest selectCompanyTrainingList() {
        return selectCompanyTrainingList(CompanyTrainingRequest.newInstance().selectAll());
    }

    public TrainingCourseTypeRequest unselectCompanyTrainingList(){
        unselectChild(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, CompanyTraining.class);
        return this;
    }
  

   public TrainingCourseTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

