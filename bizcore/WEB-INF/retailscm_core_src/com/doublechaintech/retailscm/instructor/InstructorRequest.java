package com.doublechaintech.retailscm.instructor;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.instructor.Instructor.*;

public class InstructorRequest extends BaseRequest<Instructor> {
    public static InstructorRequest newInstance() {
        return new InstructorRequest().selectId();
    }

    public String getInternalType() {
        return "Instructor";
    }

    public InstructorRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public InstructorRequest select(String... names) {
        super.select(names);
        return this;
    }

    public InstructorRequest selectAll() {return this.selectId().selectTitle().selectFamilyName().selectGivenName().selectCellPhone().selectEmail().selectCompany().selectIntroduction().selectLastUpdateTime().selectVersion();
    }

    public InstructorRequest selectSelf() {return this.selectId().selectTitle().selectFamilyName().selectGivenName().selectCellPhone().selectEmail().selectIntroduction().selectLastUpdateTime().selectVersion();
    }

    public InstructorRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public InstructorRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static InstructorRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public InstructorRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public InstructorRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectId(){
          return select(ID_PROPERTY);
      }

      public InstructorRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public InstructorRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public InstructorRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public InstructorRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public InstructorRequest filterByFamilyName(String familyName) {
          
          if (familyName == null) {
              return this;
          }
          
          return filterByFamilyName(QueryOperator.EQUAL, familyName);
      }
    

      public InstructorRequest filterByFamilyName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFamilyNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectFamilyName(){
          return select(FAMILY_NAME_PROPERTY);
      }

      public InstructorRequest unselectFamilyName(){
          return unselect(FAMILY_NAME_PROPERTY);
      }

      public SearchCriteria getFamilyNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FAMILY_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderByFamilyName(boolean asc){
          addOrderBy(FAMILY_NAME_PROPERTY, asc);
          return this;
      }
   
      public InstructorRequest filterByGivenName(String givenName) {
          
          if (givenName == null) {
              return this;
          }
          
          return filterByGivenName(QueryOperator.EQUAL, givenName);
      }
    

      public InstructorRequest filterByGivenName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getGivenNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectGivenName(){
          return select(GIVEN_NAME_PROPERTY);
      }

      public InstructorRequest unselectGivenName(){
          return unselect(GIVEN_NAME_PROPERTY);
      }

      public SearchCriteria getGivenNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(GIVEN_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderByGivenName(boolean asc){
          addOrderBy(GIVEN_NAME_PROPERTY, asc);
          return this;
      }
   
      public InstructorRequest filterByCellPhone(String cellPhone) {
          
          if (cellPhone == null) {
              return this;
          }
          
          return filterByCellPhone(QueryOperator.EQUAL, cellPhone);
      }
    

      public InstructorRequest filterByCellPhone(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCellPhoneSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectCellPhone(){
          return select(CELL_PHONE_PROPERTY);
      }

      public InstructorRequest unselectCellPhone(){
          return unselect(CELL_PHONE_PROPERTY);
      }

      public SearchCriteria getCellPhoneSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CELL_PHONE_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderByCellPhone(boolean asc){
          addOrderBy(CELL_PHONE_PROPERTY, asc);
          return this;
      }
   
      public InstructorRequest filterByEmail(String email) {
          
          if (email == null) {
              return this;
          }
          
          return filterByEmail(QueryOperator.EQUAL, email);
      }
    

      public InstructorRequest filterByEmail(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEmailSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectEmail(){
          return select(EMAIL_PROPERTY);
      }

      public InstructorRequest unselectEmail(){
          return unselect(EMAIL_PROPERTY);
      }

      public SearchCriteria getEmailSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(EMAIL_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderByEmail(boolean asc){
          addOrderBy(EMAIL_PROPERTY, asc);
          return this;
      }
   
      public InstructorRequest filterByIntroduction(String introduction) {
          
          if (introduction == null) {
              return this;
          }
          
          return filterByIntroduction(QueryOperator.EQUAL, introduction);
      }
    

      public InstructorRequest filterByIntroduction(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIntroductionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectIntroduction(){
          return select(INTRODUCTION_PROPERTY);
      }

      public InstructorRequest unselectIntroduction(){
          return unselect(INTRODUCTION_PROPERTY);
      }

      public SearchCriteria getIntroductionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(INTRODUCTION_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderByIntroduction(boolean asc){
          addOrderBy(INTRODUCTION_PROPERTY, asc);
          return this;
      }
   
      public InstructorRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public InstructorRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public InstructorRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public InstructorRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public InstructorRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public InstructorRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public InstructorRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public InstructorRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public InstructorRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public InstructorRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public InstructorRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public InstructorRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public InstructorRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public InstructorRequest hasCompanyTraining() {
      return hasCompanyTraining(CompanyTrainingRequest.newInstance());
    }

    public InstructorRequest hasCompanyTraining(CompanyTrainingRequest companyTraining) {
        return hasCompanyTraining(companyTraining, companyTrainingList -> companyTrainingList.stream().map(CompanyTraining::getInstructor).map(Instructor::getId).collect(Collectors.toSet()));
    }

    public InstructorRequest hasCompanyTraining(CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
        companyTraining.select(CompanyTraining.INSTRUCTOR_PROPERTY);
        return addSearchCriteria(createCompanyTrainingCriteria(companyTraining, idRefine));
    }

    public SearchCriteria createCompanyTrainingCriteria(CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine){
       return new RefinedIdInCriteria(companyTraining, ID_PROPERTY, idRefine);
    }

    public InstructorRequest selectCompanyTrainingList(CompanyTrainingRequest companyTraining) {
        selectChild(CompanyTraining.INSTRUCTOR_PROPERTY, companyTraining);
        return this;
    }

    public InstructorRequest selectCompanyTrainingList() {
        return selectCompanyTrainingList(CompanyTrainingRequest.newInstance().selectAll());
    }

    public InstructorRequest unselectCompanyTrainingList(){
        unselectChild(CompanyTraining.INSTRUCTOR_PROPERTY, CompanyTraining.class);
        return this;
    }
  

   public InstructorRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

