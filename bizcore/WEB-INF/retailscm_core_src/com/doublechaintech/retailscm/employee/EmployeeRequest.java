package com.doublechaintech.retailscm.employee;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceRequest;
import com.doublechaintech.retailscm.employeeaward.EmployeeAwardRequest;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducationRequest;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceRequest;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierRequest;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceRequest;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest;
import com.doublechaintech.retailscm.payingoff.PayingOffRequest;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employee.Employee.*;

public class EmployeeRequest extends BaseRequest<Employee> {
    public static EmployeeRequest newInstance() {
        return new EmployeeRequest().selectId();
    }

    public String getInternalType() {
        return "Employee";
    }

    public EmployeeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeRequest selectAll() {return this.selectId().selectCompany().selectTitle().selectDepartment().selectFamilyName().selectGivenName().selectEmail().selectCity().selectAddress().selectCellPhone().selectOccupation().selectResponsibleFor().selectCurrentSalaryGrade().selectSalaryAccount().selectLastUpdateTime().selectVersion();
    }

    public EmployeeRequest selectSelf() {return this.selectId().selectTitle().selectFamilyName().selectGivenName().selectEmail().selectCity().selectAddress().selectCellPhone().selectSalaryAccount().selectLastUpdateTime().selectVersion();
    }

    public EmployeeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public EmployeeRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public EmployeeRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByFamilyName(String familyName) {
          
          if (familyName == null) {
              return this;
          }
          
          return filterByFamilyName(QueryOperator.EQUAL, familyName);
      }
    

      public EmployeeRequest filterByFamilyName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFamilyNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectFamilyName(){
          return select(FAMILY_NAME_PROPERTY);
      }

      public EmployeeRequest unselectFamilyName(){
          return unselect(FAMILY_NAME_PROPERTY);
      }

      public SearchCriteria getFamilyNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FAMILY_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByFamilyName(boolean asc){
          addOrderBy(FAMILY_NAME_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByGivenName(String givenName) {
          
          if (givenName == null) {
              return this;
          }
          
          return filterByGivenName(QueryOperator.EQUAL, givenName);
      }
    

      public EmployeeRequest filterByGivenName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getGivenNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectGivenName(){
          return select(GIVEN_NAME_PROPERTY);
      }

      public EmployeeRequest unselectGivenName(){
          return unselect(GIVEN_NAME_PROPERTY);
      }

      public SearchCriteria getGivenNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(GIVEN_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByGivenName(boolean asc){
          addOrderBy(GIVEN_NAME_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByEmail(String email) {
          
          if (email == null) {
              return this;
          }
          
          return filterByEmail(QueryOperator.EQUAL, email);
      }
    

      public EmployeeRequest filterByEmail(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEmailSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectEmail(){
          return select(EMAIL_PROPERTY);
      }

      public EmployeeRequest unselectEmail(){
          return unselect(EMAIL_PROPERTY);
      }

      public SearchCriteria getEmailSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(EMAIL_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByEmail(boolean asc){
          addOrderBy(EMAIL_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByCity(String city) {
          
          if (city == null) {
              return this;
          }
          
          return filterByCity(QueryOperator.EQUAL, city);
      }
    

      public EmployeeRequest filterByCity(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCitySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectCity(){
          return select(CITY_PROPERTY);
      }

      public EmployeeRequest unselectCity(){
          return unselect(CITY_PROPERTY);
      }

      public SearchCriteria getCitySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CITY_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByCity(boolean asc){
          addOrderBy(CITY_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByAddress(String address) {
          
          if (address == null) {
              return this;
          }
          
          return filterByAddress(QueryOperator.EQUAL, address);
      }
    

      public EmployeeRequest filterByAddress(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAddressSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectAddress(){
          return select(ADDRESS_PROPERTY);
      }

      public EmployeeRequest unselectAddress(){
          return unselect(ADDRESS_PROPERTY);
      }

      public SearchCriteria getAddressSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ADDRESS_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByAddress(boolean asc){
          addOrderBy(ADDRESS_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByCellPhone(String cellPhone) {
          
          if (cellPhone == null) {
              return this;
          }
          
          return filterByCellPhone(QueryOperator.EQUAL, cellPhone);
      }
    

      public EmployeeRequest filterByCellPhone(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCellPhoneSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectCellPhone(){
          return select(CELL_PHONE_PROPERTY);
      }

      public EmployeeRequest unselectCellPhone(){
          return unselect(CELL_PHONE_PROPERTY);
      }

      public SearchCriteria getCellPhoneSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CELL_PHONE_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByCellPhone(boolean asc){
          addOrderBy(CELL_PHONE_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterBySalaryAccount(String salaryAccount) {
          
          if (salaryAccount == null) {
              return this;
          }
          
          return filterBySalaryAccount(QueryOperator.EQUAL, salaryAccount);
      }
    

      public EmployeeRequest filterBySalaryAccount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSalaryAccountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectSalaryAccount(){
          return select(SALARY_ACCOUNT_PROPERTY);
      }

      public EmployeeRequest unselectSalaryAccount(){
          return unselect(SALARY_ACCOUNT_PROPERTY);
      }

      public SearchCriteria getSalaryAccountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SALARY_ACCOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderBySalaryAccount(boolean asc){
          addOrderBy(SALARY_ACCOUNT_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public EmployeeRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public EmployeeRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public EmployeeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public EmployeeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public EmployeeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public EmployeeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  

    
    public EmployeeRequest filterByDepartment(LevelThreeDepartmentRequest department){
        return filterByDepartment(department, departmentList -> departmentList.stream().map(LevelThreeDepartment::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest filterByDepartment(LevelThreeDepartmentRequest department, IDRefine<LevelThreeDepartment> idRefine) {
        return addSearchCriteria(createDepartmentCriteria(department, idRefine));
    }

    public SearchCriteria createDepartmentCriteria(LevelThreeDepartmentRequest department, IDRefine<LevelThreeDepartment> idRefine) {
        return new RefinedIdInCriteria(department, DEPARTMENT_PROPERTY, idRefine);
    }
    

    
    public EmployeeRequest selectDepartment(){
        return selectDepartment(LevelThreeDepartmentRequest.newInstance().selectSelf());
    }

    public EmployeeRequest selectDepartment(LevelThreeDepartmentRequest department){
        selectParent(DEPARTMENT_PROPERTY, department);
        return this;
    }
    

    public EmployeeRequest unselectDepartment(){
        unselectParent(DEPARTMENT_PROPERTY);
        return this;
    }

  

    
    public EmployeeRequest filterByOccupation(OccupationTypeRequest occupation){
        return filterByOccupation(occupation, occupationList -> occupationList.stream().map(OccupationType::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest filterByOccupation(OccupationTypeRequest occupation, IDRefine<OccupationType> idRefine) {
        return addSearchCriteria(createOccupationCriteria(occupation, idRefine));
    }

    public SearchCriteria createOccupationCriteria(OccupationTypeRequest occupation, IDRefine<OccupationType> idRefine) {
        return new RefinedIdInCriteria(occupation, OCCUPATION_PROPERTY, idRefine);
    }
    

    
    public EmployeeRequest selectOccupation(){
        return selectOccupation(OccupationTypeRequest.newInstance().selectSelf());
    }

    public EmployeeRequest selectOccupation(OccupationTypeRequest occupation){
        selectParent(OCCUPATION_PROPERTY, occupation);
        return this;
    }
    

    public EmployeeRequest unselectOccupation(){
        unselectParent(OCCUPATION_PROPERTY);
        return this;
    }

  

    
    public EmployeeRequest filterByResponsibleFor(ResponsibilityTypeRequest responsibleFor){
        return filterByResponsibleFor(responsibleFor, responsibleForList -> responsibleForList.stream().map(ResponsibilityType::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest filterByResponsibleFor(ResponsibilityTypeRequest responsibleFor, IDRefine<ResponsibilityType> idRefine) {
        return addSearchCriteria(createResponsibleForCriteria(responsibleFor, idRefine));
    }

    public SearchCriteria createResponsibleForCriteria(ResponsibilityTypeRequest responsibleFor, IDRefine<ResponsibilityType> idRefine) {
        return new RefinedIdInCriteria(responsibleFor, RESPONSIBLE_FOR_PROPERTY, idRefine);
    }
    

    
    public EmployeeRequest selectResponsibleFor(){
        return selectResponsibleFor(ResponsibilityTypeRequest.newInstance().selectSelf());
    }

    public EmployeeRequest selectResponsibleFor(ResponsibilityTypeRequest responsibleFor){
        selectParent(RESPONSIBLE_FOR_PROPERTY, responsibleFor);
        return this;
    }
    

    public EmployeeRequest unselectResponsibleFor(){
        unselectParent(RESPONSIBLE_FOR_PROPERTY);
        return this;
    }

  

    
    public EmployeeRequest filterByCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade){
        return filterByCurrentSalaryGrade(currentSalaryGrade, currentSalaryGradeList -> currentSalaryGradeList.stream().map(SalaryGrade::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest filterByCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade, IDRefine<SalaryGrade> idRefine) {
        return addSearchCriteria(createCurrentSalaryGradeCriteria(currentSalaryGrade, idRefine));
    }

    public SearchCriteria createCurrentSalaryGradeCriteria(SalaryGradeRequest currentSalaryGrade, IDRefine<SalaryGrade> idRefine) {
        return new RefinedIdInCriteria(currentSalaryGrade, CURRENT_SALARY_GRADE_PROPERTY, idRefine);
    }
    

    
    public EmployeeRequest selectCurrentSalaryGrade(){
        return selectCurrentSalaryGrade(SalaryGradeRequest.newInstance().selectSelf());
    }

    public EmployeeRequest selectCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade){
        selectParent(CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGrade);
        return this;
    }
    

    public EmployeeRequest unselectCurrentSalaryGrade(){
        unselectParent(CURRENT_SALARY_GRADE_PROPERTY);
        return this;
    }

  


  

    public EmployeeRequest hasEmployeeCompanyTraining() {
      return hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest employeeCompanyTraining) {
        return hasEmployeeCompanyTraining(employeeCompanyTraining, employeeCompanyTrainingList -> employeeCompanyTrainingList.stream().map(EmployeeCompanyTraining::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest employeeCompanyTraining, IDRefine<EmployeeCompanyTraining> idRefine) {
        employeeCompanyTraining.select(EmployeeCompanyTraining.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeCompanyTrainingCriteria(employeeCompanyTraining, idRefine));
    }

    public SearchCriteria createEmployeeCompanyTrainingCriteria(EmployeeCompanyTrainingRequest employeeCompanyTraining, IDRefine<EmployeeCompanyTraining> idRefine){
       return new RefinedIdInCriteria(employeeCompanyTraining, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeCompanyTrainingList(EmployeeCompanyTrainingRequest employeeCompanyTraining) {
        selectChild(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeCompanyTraining);
        return this;
    }

    public EmployeeRequest selectEmployeeCompanyTrainingList() {
        return selectEmployeeCompanyTrainingList(EmployeeCompanyTrainingRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeCompanyTrainingList(){
        unselectChild(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, EmployeeCompanyTraining.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeSkill() {
      return hasEmployeeSkill(EmployeeSkillRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeSkill(EmployeeSkillRequest employeeSkill) {
        return hasEmployeeSkill(employeeSkill, employeeSkillList -> employeeSkillList.stream().map(EmployeeSkill::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeSkill(EmployeeSkillRequest employeeSkill, IDRefine<EmployeeSkill> idRefine) {
        employeeSkill.select(EmployeeSkill.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeSkillCriteria(employeeSkill, idRefine));
    }

    public SearchCriteria createEmployeeSkillCriteria(EmployeeSkillRequest employeeSkill, IDRefine<EmployeeSkill> idRefine){
       return new RefinedIdInCriteria(employeeSkill, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeSkillList(EmployeeSkillRequest employeeSkill) {
        selectChild(EmployeeSkill.EMPLOYEE_PROPERTY, employeeSkill);
        return this;
    }

    public EmployeeRequest selectEmployeeSkillList() {
        return selectEmployeeSkillList(EmployeeSkillRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeSkillList(){
        unselectChild(EmployeeSkill.EMPLOYEE_PROPERTY, EmployeeSkill.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeePerformance() {
      return hasEmployeePerformance(EmployeePerformanceRequest.newInstance());
    }

    public EmployeeRequest hasEmployeePerformance(EmployeePerformanceRequest employeePerformance) {
        return hasEmployeePerformance(employeePerformance, employeePerformanceList -> employeePerformanceList.stream().map(EmployeePerformance::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeePerformance(EmployeePerformanceRequest employeePerformance, IDRefine<EmployeePerformance> idRefine) {
        employeePerformance.select(EmployeePerformance.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeePerformanceCriteria(employeePerformance, idRefine));
    }

    public SearchCriteria createEmployeePerformanceCriteria(EmployeePerformanceRequest employeePerformance, IDRefine<EmployeePerformance> idRefine){
       return new RefinedIdInCriteria(employeePerformance, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeePerformanceList(EmployeePerformanceRequest employeePerformance) {
        selectChild(EmployeePerformance.EMPLOYEE_PROPERTY, employeePerformance);
        return this;
    }

    public EmployeeRequest selectEmployeePerformanceList() {
        return selectEmployeePerformanceList(EmployeePerformanceRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeePerformanceList(){
        unselectChild(EmployeePerformance.EMPLOYEE_PROPERTY, EmployeePerformance.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeWorkExperience() {
      return hasEmployeeWorkExperience(EmployeeWorkExperienceRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeWorkExperience(EmployeeWorkExperienceRequest employeeWorkExperience) {
        return hasEmployeeWorkExperience(employeeWorkExperience, employeeWorkExperienceList -> employeeWorkExperienceList.stream().map(EmployeeWorkExperience::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeWorkExperience(EmployeeWorkExperienceRequest employeeWorkExperience, IDRefine<EmployeeWorkExperience> idRefine) {
        employeeWorkExperience.select(EmployeeWorkExperience.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeWorkExperienceCriteria(employeeWorkExperience, idRefine));
    }

    public SearchCriteria createEmployeeWorkExperienceCriteria(EmployeeWorkExperienceRequest employeeWorkExperience, IDRefine<EmployeeWorkExperience> idRefine){
       return new RefinedIdInCriteria(employeeWorkExperience, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeWorkExperienceList(EmployeeWorkExperienceRequest employeeWorkExperience) {
        selectChild(EmployeeWorkExperience.EMPLOYEE_PROPERTY, employeeWorkExperience);
        return this;
    }

    public EmployeeRequest selectEmployeeWorkExperienceList() {
        return selectEmployeeWorkExperienceList(EmployeeWorkExperienceRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeWorkExperienceList(){
        unselectChild(EmployeeWorkExperience.EMPLOYEE_PROPERTY, EmployeeWorkExperience.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeLeave() {
      return hasEmployeeLeave(EmployeeLeaveRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeLeave(EmployeeLeaveRequest employeeLeave) {
        return hasEmployeeLeave(employeeLeave, employeeLeaveList -> employeeLeaveList.stream().map(EmployeeLeave::getWho).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeLeave(EmployeeLeaveRequest employeeLeave, IDRefine<EmployeeLeave> idRefine) {
        employeeLeave.select(EmployeeLeave.WHO_PROPERTY);
        return addSearchCriteria(createEmployeeLeaveCriteria(employeeLeave, idRefine));
    }

    public SearchCriteria createEmployeeLeaveCriteria(EmployeeLeaveRequest employeeLeave, IDRefine<EmployeeLeave> idRefine){
       return new RefinedIdInCriteria(employeeLeave, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeLeaveList(EmployeeLeaveRequest employeeLeave) {
        selectChild(EmployeeLeave.WHO_PROPERTY, employeeLeave);
        return this;
    }

    public EmployeeRequest selectEmployeeLeaveList() {
        return selectEmployeeLeaveList(EmployeeLeaveRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeLeaveList(){
        unselectChild(EmployeeLeave.WHO_PROPERTY, EmployeeLeave.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeInterview() {
      return hasEmployeeInterview(EmployeeInterviewRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeInterview(EmployeeInterviewRequest employeeInterview) {
        return hasEmployeeInterview(employeeInterview, employeeInterviewList -> employeeInterviewList.stream().map(EmployeeInterview::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeInterview(EmployeeInterviewRequest employeeInterview, IDRefine<EmployeeInterview> idRefine) {
        employeeInterview.select(EmployeeInterview.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeInterviewCriteria(employeeInterview, idRefine));
    }

    public SearchCriteria createEmployeeInterviewCriteria(EmployeeInterviewRequest employeeInterview, IDRefine<EmployeeInterview> idRefine){
       return new RefinedIdInCriteria(employeeInterview, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeInterviewList(EmployeeInterviewRequest employeeInterview) {
        selectChild(EmployeeInterview.EMPLOYEE_PROPERTY, employeeInterview);
        return this;
    }

    public EmployeeRequest selectEmployeeInterviewList() {
        return selectEmployeeInterviewList(EmployeeInterviewRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeInterviewList(){
        unselectChild(EmployeeInterview.EMPLOYEE_PROPERTY, EmployeeInterview.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeAttendance() {
      return hasEmployeeAttendance(EmployeeAttendanceRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeAttendance(EmployeeAttendanceRequest employeeAttendance) {
        return hasEmployeeAttendance(employeeAttendance, employeeAttendanceList -> employeeAttendanceList.stream().map(EmployeeAttendance::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeAttendance(EmployeeAttendanceRequest employeeAttendance, IDRefine<EmployeeAttendance> idRefine) {
        employeeAttendance.select(EmployeeAttendance.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeAttendanceCriteria(employeeAttendance, idRefine));
    }

    public SearchCriteria createEmployeeAttendanceCriteria(EmployeeAttendanceRequest employeeAttendance, IDRefine<EmployeeAttendance> idRefine){
       return new RefinedIdInCriteria(employeeAttendance, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeAttendanceList(EmployeeAttendanceRequest employeeAttendance) {
        selectChild(EmployeeAttendance.EMPLOYEE_PROPERTY, employeeAttendance);
        return this;
    }

    public EmployeeRequest selectEmployeeAttendanceList() {
        return selectEmployeeAttendanceList(EmployeeAttendanceRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeAttendanceList(){
        unselectChild(EmployeeAttendance.EMPLOYEE_PROPERTY, EmployeeAttendance.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeQualifier() {
      return hasEmployeeQualifier(EmployeeQualifierRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeQualifier(EmployeeQualifierRequest employeeQualifier) {
        return hasEmployeeQualifier(employeeQualifier, employeeQualifierList -> employeeQualifierList.stream().map(EmployeeQualifier::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeQualifier(EmployeeQualifierRequest employeeQualifier, IDRefine<EmployeeQualifier> idRefine) {
        employeeQualifier.select(EmployeeQualifier.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeQualifierCriteria(employeeQualifier, idRefine));
    }

    public SearchCriteria createEmployeeQualifierCriteria(EmployeeQualifierRequest employeeQualifier, IDRefine<EmployeeQualifier> idRefine){
       return new RefinedIdInCriteria(employeeQualifier, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeQualifierList(EmployeeQualifierRequest employeeQualifier) {
        selectChild(EmployeeQualifier.EMPLOYEE_PROPERTY, employeeQualifier);
        return this;
    }

    public EmployeeRequest selectEmployeeQualifierList() {
        return selectEmployeeQualifierList(EmployeeQualifierRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeQualifierList(){
        unselectChild(EmployeeQualifier.EMPLOYEE_PROPERTY, EmployeeQualifier.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeEducation() {
      return hasEmployeeEducation(EmployeeEducationRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeEducation(EmployeeEducationRequest employeeEducation) {
        return hasEmployeeEducation(employeeEducation, employeeEducationList -> employeeEducationList.stream().map(EmployeeEducation::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeEducation(EmployeeEducationRequest employeeEducation, IDRefine<EmployeeEducation> idRefine) {
        employeeEducation.select(EmployeeEducation.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeEducationCriteria(employeeEducation, idRefine));
    }

    public SearchCriteria createEmployeeEducationCriteria(EmployeeEducationRequest employeeEducation, IDRefine<EmployeeEducation> idRefine){
       return new RefinedIdInCriteria(employeeEducation, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeEducationList(EmployeeEducationRequest employeeEducation) {
        selectChild(EmployeeEducation.EMPLOYEE_PROPERTY, employeeEducation);
        return this;
    }

    public EmployeeRequest selectEmployeeEducationList() {
        return selectEmployeeEducationList(EmployeeEducationRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeEducationList(){
        unselectChild(EmployeeEducation.EMPLOYEE_PROPERTY, EmployeeEducation.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeAward() {
      return hasEmployeeAward(EmployeeAwardRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeAward(EmployeeAwardRequest employeeAward) {
        return hasEmployeeAward(employeeAward, employeeAwardList -> employeeAwardList.stream().map(EmployeeAward::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeAward(EmployeeAwardRequest employeeAward, IDRefine<EmployeeAward> idRefine) {
        employeeAward.select(EmployeeAward.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeAwardCriteria(employeeAward, idRefine));
    }

    public SearchCriteria createEmployeeAwardCriteria(EmployeeAwardRequest employeeAward, IDRefine<EmployeeAward> idRefine){
       return new RefinedIdInCriteria(employeeAward, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeAwardList(EmployeeAwardRequest employeeAward) {
        selectChild(EmployeeAward.EMPLOYEE_PROPERTY, employeeAward);
        return this;
    }

    public EmployeeRequest selectEmployeeAwardList() {
        return selectEmployeeAwardList(EmployeeAwardRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeAwardList(){
        unselectChild(EmployeeAward.EMPLOYEE_PROPERTY, EmployeeAward.class);
        return this;
    }
  

    public EmployeeRequest hasEmployeeSalarySheet() {
      return hasEmployeeSalarySheet(EmployeeSalarySheetRequest.newInstance());
    }

    public EmployeeRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet) {
        return hasEmployeeSalarySheet(employeeSalarySheet, employeeSalarySheetList -> employeeSalarySheetList.stream().map(EmployeeSalarySheet::getEmployee).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
        employeeSalarySheet.select(EmployeeSalarySheet.EMPLOYEE_PROPERTY);
        return addSearchCriteria(createEmployeeSalarySheetCriteria(employeeSalarySheet, idRefine));
    }

    public SearchCriteria createEmployeeSalarySheetCriteria(EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine){
       return new RefinedIdInCriteria(employeeSalarySheet, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectEmployeeSalarySheetList(EmployeeSalarySheetRequest employeeSalarySheet) {
        selectChild(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeSalarySheet);
        return this;
    }

    public EmployeeRequest selectEmployeeSalarySheetList() {
        return selectEmployeeSalarySheetList(EmployeeSalarySheetRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectEmployeeSalarySheetList(){
        unselectChild(EmployeeSalarySheet.EMPLOYEE_PROPERTY, EmployeeSalarySheet.class);
        return this;
    }
  

    public EmployeeRequest hasPayingOff() {
      return hasPayingOff(PayingOffRequest.newInstance());
    }

    public EmployeeRequest hasPayingOff(PayingOffRequest payingOff) {
        return hasPayingOff(payingOff, payingOffList -> payingOffList.stream().map(PayingOff::getPaidFor).map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeRequest hasPayingOff(PayingOffRequest payingOff, IDRefine<PayingOff> idRefine) {
        payingOff.select(PayingOff.PAID_FOR_PROPERTY);
        return addSearchCriteria(createPayingOffCriteria(payingOff, idRefine));
    }

    public SearchCriteria createPayingOffCriteria(PayingOffRequest payingOff, IDRefine<PayingOff> idRefine){
       return new RefinedIdInCriteria(payingOff, ID_PROPERTY, idRefine);
    }

    public EmployeeRequest selectPayingOffList(PayingOffRequest payingOff) {
        selectChild(PayingOff.PAID_FOR_PROPERTY, payingOff);
        return this;
    }

    public EmployeeRequest selectPayingOffList() {
        return selectPayingOffList(PayingOffRequest.newInstance().selectAll());
    }

    public EmployeeRequest unselectPayingOffList(){
        unselectChild(PayingOff.PAID_FOR_PROPERTY, PayingOff.class);
        return this;
    }
  

   public EmployeeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

