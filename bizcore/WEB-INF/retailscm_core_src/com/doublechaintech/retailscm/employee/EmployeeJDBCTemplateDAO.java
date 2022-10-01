package com.doublechaintech.retailscm.employee;

import com.doublechaintech.retailscm.Beans;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;

import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeDAO;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeDAO;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillDAO;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewDAO;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceDAO;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveDAO;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeDAO;
import com.doublechaintech.retailscm.employeeaward.EmployeeAwardDAO;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceDAO;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierDAO;
import com.doublechaintech.retailscm.payingoff.PayingOffDAO;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentDAO;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducationDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class EmployeeJDBCTemplateDAO extends RetailscmBaseDAOImpl implements EmployeeDAO {

  protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;

  public void setRetailStoreCountryCenterDAO(
      RetailStoreCountryCenterDAO retailStoreCountryCenterDAO) {

    if (retailStoreCountryCenterDAO == null) {
      throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
    }
    this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
  }

  public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO() {
    if (this.retailStoreCountryCenterDAO == null) {
      throw new IllegalStateException(
          "The retailStoreCountryCenterDAO is not configured yet, please config it some where.");
    }

    return this.retailStoreCountryCenterDAO;
  }

  protected LevelThreeDepartmentDAO levelThreeDepartmentDAO;

  public void setLevelThreeDepartmentDAO(LevelThreeDepartmentDAO levelThreeDepartmentDAO) {

    if (levelThreeDepartmentDAO == null) {
      throw new IllegalStateException("Do not try to set levelThreeDepartmentDAO to null.");
    }
    this.levelThreeDepartmentDAO = levelThreeDepartmentDAO;
  }

  public LevelThreeDepartmentDAO getLevelThreeDepartmentDAO() {
    if (this.levelThreeDepartmentDAO == null) {
      throw new IllegalStateException(
          "The levelThreeDepartmentDAO is not configured yet, please config it some where.");
    }

    return this.levelThreeDepartmentDAO;
  }

  protected OccupationTypeDAO occupationTypeDAO;

  public void setOccupationTypeDAO(OccupationTypeDAO occupationTypeDAO) {

    if (occupationTypeDAO == null) {
      throw new IllegalStateException("Do not try to set occupationTypeDAO to null.");
    }
    this.occupationTypeDAO = occupationTypeDAO;
  }

  public OccupationTypeDAO getOccupationTypeDAO() {
    if (this.occupationTypeDAO == null) {
      throw new IllegalStateException(
          "The occupationTypeDAO is not configured yet, please config it some where.");
    }

    return this.occupationTypeDAO;
  }

  protected ResponsibilityTypeDAO responsibilityTypeDAO;

  public void setResponsibilityTypeDAO(ResponsibilityTypeDAO responsibilityTypeDAO) {

    if (responsibilityTypeDAO == null) {
      throw new IllegalStateException("Do not try to set responsibilityTypeDAO to null.");
    }
    this.responsibilityTypeDAO = responsibilityTypeDAO;
  }

  public ResponsibilityTypeDAO getResponsibilityTypeDAO() {
    if (this.responsibilityTypeDAO == null) {
      throw new IllegalStateException(
          "The responsibilityTypeDAO is not configured yet, please config it some where.");
    }

    return this.responsibilityTypeDAO;
  }

  protected SalaryGradeDAO salaryGradeDAO;

  public void setSalaryGradeDAO(SalaryGradeDAO salaryGradeDAO) {

    if (salaryGradeDAO == null) {
      throw new IllegalStateException("Do not try to set salaryGradeDAO to null.");
    }
    this.salaryGradeDAO = salaryGradeDAO;
  }

  public SalaryGradeDAO getSalaryGradeDAO() {
    if (this.salaryGradeDAO == null) {
      throw new IllegalStateException(
          "The salaryGradeDAO is not configured yet, please config it some where.");
    }

    return this.salaryGradeDAO;
  }

  protected EmployeeCompanyTrainingDAO employeeCompanyTrainingDAO;

  public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO employeeCompanyTrainingDAO) {

    if (employeeCompanyTrainingDAO == null) {
      throw new IllegalStateException("Do not try to set employeeCompanyTrainingDAO to null.");
    }
    this.employeeCompanyTrainingDAO = employeeCompanyTrainingDAO;
  }

  public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO() {
    if (this.employeeCompanyTrainingDAO == null) {
      throw new IllegalStateException(
          "The employeeCompanyTrainingDAO is not configured yet, please config it some where.");
    }

    return this.employeeCompanyTrainingDAO;
  }

  protected EmployeeSkillDAO employeeSkillDAO;

  public void setEmployeeSkillDAO(EmployeeSkillDAO employeeSkillDAO) {

    if (employeeSkillDAO == null) {
      throw new IllegalStateException("Do not try to set employeeSkillDAO to null.");
    }
    this.employeeSkillDAO = employeeSkillDAO;
  }

  public EmployeeSkillDAO getEmployeeSkillDAO() {
    if (this.employeeSkillDAO == null) {
      throw new IllegalStateException(
          "The employeeSkillDAO is not configured yet, please config it some where.");
    }

    return this.employeeSkillDAO;
  }

  protected EmployeePerformanceDAO employeePerformanceDAO;

  public void setEmployeePerformanceDAO(EmployeePerformanceDAO employeePerformanceDAO) {

    if (employeePerformanceDAO == null) {
      throw new IllegalStateException("Do not try to set employeePerformanceDAO to null.");
    }
    this.employeePerformanceDAO = employeePerformanceDAO;
  }

  public EmployeePerformanceDAO getEmployeePerformanceDAO() {
    if (this.employeePerformanceDAO == null) {
      throw new IllegalStateException(
          "The employeePerformanceDAO is not configured yet, please config it some where.");
    }

    return this.employeePerformanceDAO;
  }

  protected EmployeeWorkExperienceDAO employeeWorkExperienceDAO;

  public void setEmployeeWorkExperienceDAO(EmployeeWorkExperienceDAO employeeWorkExperienceDAO) {

    if (employeeWorkExperienceDAO == null) {
      throw new IllegalStateException("Do not try to set employeeWorkExperienceDAO to null.");
    }
    this.employeeWorkExperienceDAO = employeeWorkExperienceDAO;
  }

  public EmployeeWorkExperienceDAO getEmployeeWorkExperienceDAO() {
    if (this.employeeWorkExperienceDAO == null) {
      throw new IllegalStateException(
          "The employeeWorkExperienceDAO is not configured yet, please config it some where.");
    }

    return this.employeeWorkExperienceDAO;
  }

  protected EmployeeLeaveDAO employeeLeaveDAO;

  public void setEmployeeLeaveDAO(EmployeeLeaveDAO employeeLeaveDAO) {

    if (employeeLeaveDAO == null) {
      throw new IllegalStateException("Do not try to set employeeLeaveDAO to null.");
    }
    this.employeeLeaveDAO = employeeLeaveDAO;
  }

  public EmployeeLeaveDAO getEmployeeLeaveDAO() {
    if (this.employeeLeaveDAO == null) {
      throw new IllegalStateException(
          "The employeeLeaveDAO is not configured yet, please config it some where.");
    }

    return this.employeeLeaveDAO;
  }

  protected EmployeeInterviewDAO employeeInterviewDAO;

  public void setEmployeeInterviewDAO(EmployeeInterviewDAO employeeInterviewDAO) {

    if (employeeInterviewDAO == null) {
      throw new IllegalStateException("Do not try to set employeeInterviewDAO to null.");
    }
    this.employeeInterviewDAO = employeeInterviewDAO;
  }

  public EmployeeInterviewDAO getEmployeeInterviewDAO() {
    if (this.employeeInterviewDAO == null) {
      throw new IllegalStateException(
          "The employeeInterviewDAO is not configured yet, please config it some where.");
    }

    return this.employeeInterviewDAO;
  }

  protected EmployeeAttendanceDAO employeeAttendanceDAO;

  public void setEmployeeAttendanceDAO(EmployeeAttendanceDAO employeeAttendanceDAO) {

    if (employeeAttendanceDAO == null) {
      throw new IllegalStateException("Do not try to set employeeAttendanceDAO to null.");
    }
    this.employeeAttendanceDAO = employeeAttendanceDAO;
  }

  public EmployeeAttendanceDAO getEmployeeAttendanceDAO() {
    if (this.employeeAttendanceDAO == null) {
      throw new IllegalStateException(
          "The employeeAttendanceDAO is not configured yet, please config it some where.");
    }

    return this.employeeAttendanceDAO;
  }

  protected EmployeeQualifierDAO employeeQualifierDAO;

  public void setEmployeeQualifierDAO(EmployeeQualifierDAO employeeQualifierDAO) {

    if (employeeQualifierDAO == null) {
      throw new IllegalStateException("Do not try to set employeeQualifierDAO to null.");
    }
    this.employeeQualifierDAO = employeeQualifierDAO;
  }

  public EmployeeQualifierDAO getEmployeeQualifierDAO() {
    if (this.employeeQualifierDAO == null) {
      throw new IllegalStateException(
          "The employeeQualifierDAO is not configured yet, please config it some where.");
    }

    return this.employeeQualifierDAO;
  }

  protected EmployeeEducationDAO employeeEducationDAO;

  public void setEmployeeEducationDAO(EmployeeEducationDAO employeeEducationDAO) {

    if (employeeEducationDAO == null) {
      throw new IllegalStateException("Do not try to set employeeEducationDAO to null.");
    }
    this.employeeEducationDAO = employeeEducationDAO;
  }

  public EmployeeEducationDAO getEmployeeEducationDAO() {
    if (this.employeeEducationDAO == null) {
      throw new IllegalStateException(
          "The employeeEducationDAO is not configured yet, please config it some where.");
    }

    return this.employeeEducationDAO;
  }

  protected EmployeeAwardDAO employeeAwardDAO;

  public void setEmployeeAwardDAO(EmployeeAwardDAO employeeAwardDAO) {

    if (employeeAwardDAO == null) {
      throw new IllegalStateException("Do not try to set employeeAwardDAO to null.");
    }
    this.employeeAwardDAO = employeeAwardDAO;
  }

  public EmployeeAwardDAO getEmployeeAwardDAO() {
    if (this.employeeAwardDAO == null) {
      throw new IllegalStateException(
          "The employeeAwardDAO is not configured yet, please config it some where.");
    }

    return this.employeeAwardDAO;
  }

  protected EmployeeSalarySheetDAO employeeSalarySheetDAO;

  public void setEmployeeSalarySheetDAO(EmployeeSalarySheetDAO employeeSalarySheetDAO) {

    if (employeeSalarySheetDAO == null) {
      throw new IllegalStateException("Do not try to set employeeSalarySheetDAO to null.");
    }
    this.employeeSalarySheetDAO = employeeSalarySheetDAO;
  }

  public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO() {
    if (this.employeeSalarySheetDAO == null) {
      throw new IllegalStateException(
          "The employeeSalarySheetDAO is not configured yet, please config it some where.");
    }

    return this.employeeSalarySheetDAO;
  }

  protected PayingOffDAO payingOffDAO;

  public void setPayingOffDAO(PayingOffDAO payingOffDAO) {

    if (payingOffDAO == null) {
      throw new IllegalStateException("Do not try to set payingOffDAO to null.");
    }
    this.payingOffDAO = payingOffDAO;
  }

  public PayingOffDAO getPayingOffDAO() {
    if (this.payingOffDAO == null) {
      throw new IllegalStateException(
          "The payingOffDAO is not configured yet, please config it some where.");
    }

    return this.payingOffDAO;
  }

  /*
  protected Employee load(AccessKey accessKey,Map<String,Object> options) throws Exception{
  	return loadInternalEmployee(accessKey, options);
  }
  */

  public SmartList<Employee> loadAll() {
    return this.loadAll(getEmployeeMapper());
  }

  public Stream<Employee> loadAllAsStream() {
    return this.loadAllAsStream(getEmployeeMapper());
  }

  protected String getIdFormat() {
    return getShortName(this.getName()) + "%06d";
  }

  public Employee load(String id, Map<String, Object> options) throws Exception {
    return loadInternalEmployee(EmployeeTable.withId(id), options);
  }

  public Employee save(Employee employee, Map<String, Object> options) {

    String methodName = "save(Employee employee,Map<String,Object> options)";

    assertMethodArgumentNotNull(employee, methodName, "employee");
    assertMethodArgumentNotNull(options, methodName, "options");

    return saveInternalEmployee(employee, options);
  }

  public Employee clone(String employeeId, Map<String, Object> options) throws Exception {

    return clone(EmployeeTable.withId(employeeId), options);
  }

  protected Employee clone(AccessKey accessKey, Map<String, Object> options) throws Exception {

    String methodName = "clone(String employeeId,Map<String,Object> options)";

    assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
    assertMethodArgumentNotNull(options, methodName, "options");

    Employee newEmployee = loadInternalEmployee(accessKey, options);
    newEmployee.setVersion(0);

    if (isSaveEmployeeCompanyTrainingListEnabled(options)) {
      for (EmployeeCompanyTraining item : newEmployee.getEmployeeCompanyTrainingList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeSkillListEnabled(options)) {
      for (EmployeeSkill item : newEmployee.getEmployeeSkillList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeePerformanceListEnabled(options)) {
      for (EmployeePerformance item : newEmployee.getEmployeePerformanceList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeWorkExperienceListEnabled(options)) {
      for (EmployeeWorkExperience item : newEmployee.getEmployeeWorkExperienceList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeLeaveListEnabled(options)) {
      for (EmployeeLeave item : newEmployee.getEmployeeLeaveList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeInterviewListEnabled(options)) {
      for (EmployeeInterview item : newEmployee.getEmployeeInterviewList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeAttendanceListEnabled(options)) {
      for (EmployeeAttendance item : newEmployee.getEmployeeAttendanceList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeQualifierListEnabled(options)) {
      for (EmployeeQualifier item : newEmployee.getEmployeeQualifierList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeEducationListEnabled(options)) {
      for (EmployeeEducation item : newEmployee.getEmployeeEducationList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeAwardListEnabled(options)) {
      for (EmployeeAward item : newEmployee.getEmployeeAwardList()) {
        item.setVersion(0);
      }
    }

    if (isSaveEmployeeSalarySheetListEnabled(options)) {
      for (EmployeeSalarySheet item : newEmployee.getEmployeeSalarySheetList()) {
        item.setVersion(0);
      }
    }

    if (isSavePayingOffListEnabled(options)) {
      for (PayingOff item : newEmployee.getPayingOffList()) {
        item.setVersion(0);
      }
    }

    saveInternalEmployee(newEmployee, options);

    return newEmployee;
  }

  protected void throwIfHasException(String employeeId, int version, int count) throws Exception {
    if (count == 1) {
      throw new EmployeeVersionChangedException(
          "The object version has been changed, please reload to delete");
    }
    if (count < 1) {
      throw new EmployeeNotFoundException(
          "The " + this.getTableName() + "(" + employeeId + ") has already been deleted.");
    }
    if (count > 1) {
      throw new IllegalStateException(
          "The table '"
              + this.getTableName()
              + "' PRIMARY KEY constraint has been damaged, please fix it.");
    }
  }

  public Employee disconnectFromAll(String employeeId, int version) throws Exception {

    Employee employee = loadInternalEmployee(EmployeeTable.withId(employeeId), emptyOptions());
    employee.clearFromAll();
    this.saveEmployee(employee);
    return employee;
  }

  @Override
  protected String[] getNormalColumnNames() {

    return EmployeeTable.NORMAL_CLOUMNS;
  }

  @Override
  protected String getName() {

    return "employee";
  }

  @Override
  protected String getBeanName() {

    return "employee";
  }

  protected boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    return EmployeeTokens.checkOptions(options, optionToCheck);
  }

  protected boolean isExtractCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.COMPANY);
  }

  protected boolean isSaveCompanyEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.COMPANY);
  }

  protected boolean isExtractDepartmentEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.DEPARTMENT);
  }

  protected boolean isSaveDepartmentEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.DEPARTMENT);
  }

  protected boolean isExtractOccupationEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.OCCUPATION);
  }

  protected boolean isSaveOccupationEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.OCCUPATION);
  }

  protected boolean isExtractResponsibleForEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.RESPONSIBLEFOR);
  }

  protected boolean isSaveResponsibleForEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.RESPONSIBLEFOR);
  }

  protected boolean isExtractCurrentSalaryGradeEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.CURRENTSALARYGRADE);
  }

  protected boolean isSaveCurrentSalaryGradeEnabled(Map<String, Object> options) {

    return checkOptions(options, EmployeeTokens.CURRENTSALARYGRADE);
  }

  protected boolean isExtractEmployeeCompanyTrainingListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
  }

  protected boolean isAnalyzeEmployeeCompanyTrainingListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeCompanyTrainingListEnabled();
  }

  protected boolean isSaveEmployeeCompanyTrainingListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
  }

  protected boolean isExtractEmployeeSkillListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_SKILL_LIST);
  }

  protected boolean isAnalyzeEmployeeSkillListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeSkillListEnabled();
  }

  protected boolean isSaveEmployeeSkillListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_SKILL_LIST);
  }

  protected boolean isExtractEmployeePerformanceListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_PERFORMANCE_LIST);
  }

  protected boolean isAnalyzeEmployeePerformanceListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeePerformanceListEnabled();
  }

  protected boolean isSaveEmployeePerformanceListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_PERFORMANCE_LIST);
  }

  protected boolean isExtractEmployeeWorkExperienceListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_WORK_EXPERIENCE_LIST);
  }

  protected boolean isAnalyzeEmployeeWorkExperienceListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeWorkExperienceListEnabled();
  }

  protected boolean isSaveEmployeeWorkExperienceListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_WORK_EXPERIENCE_LIST);
  }

  protected boolean isExtractEmployeeLeaveListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_LEAVE_LIST);
  }

  protected boolean isAnalyzeEmployeeLeaveListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeLeaveListEnabled();
  }

  protected boolean isSaveEmployeeLeaveListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_LEAVE_LIST);
  }

  protected boolean isExtractEmployeeInterviewListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_INTERVIEW_LIST);
  }

  protected boolean isAnalyzeEmployeeInterviewListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeInterviewListEnabled();
  }

  protected boolean isSaveEmployeeInterviewListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_INTERVIEW_LIST);
  }

  protected boolean isExtractEmployeeAttendanceListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_ATTENDANCE_LIST);
  }

  protected boolean isAnalyzeEmployeeAttendanceListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeAttendanceListEnabled();
  }

  protected boolean isSaveEmployeeAttendanceListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_ATTENDANCE_LIST);
  }

  protected boolean isExtractEmployeeQualifierListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_QUALIFIER_LIST);
  }

  protected boolean isAnalyzeEmployeeQualifierListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeQualifierListEnabled();
  }

  protected boolean isSaveEmployeeQualifierListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_QUALIFIER_LIST);
  }

  protected boolean isExtractEmployeeEducationListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_EDUCATION_LIST);
  }

  protected boolean isAnalyzeEmployeeEducationListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeEducationListEnabled();
  }

  protected boolean isSaveEmployeeEducationListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_EDUCATION_LIST);
  }

  protected boolean isExtractEmployeeAwardListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_AWARD_LIST);
  }

  protected boolean isAnalyzeEmployeeAwardListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeAwardListEnabled();
  }

  protected boolean isSaveEmployeeAwardListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_AWARD_LIST);
  }

  protected boolean isExtractEmployeeSalarySheetListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_SALARY_SHEET_LIST);
  }

  protected boolean isAnalyzeEmployeeSalarySheetListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzeEmployeeSalarySheetListEnabled();
  }

  protected boolean isSaveEmployeeSalarySheetListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.EMPLOYEE_SALARY_SHEET_LIST);
  }

  protected boolean isExtractPayingOffListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.PAYING_OFF_LIST);
  }

  protected boolean isAnalyzePayingOffListEnabled(Map<String, Object> options) {
    return EmployeeTokens.of(options).analyzePayingOffListEnabled();
  }

  protected boolean isSavePayingOffListEnabled(Map<String, Object> options) {
    return checkOptions(options, EmployeeTokens.PAYING_OFF_LIST);
  }

  protected EmployeeMapper getEmployeeMapper() {
    return new EmployeeMapper();
  }

  protected Employee extractEmployee(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {
    try {
      Employee employee = loadSingleObject(accessKey, getEmployeeMapper());
      return employee;
    } catch (EmptyResultDataAccessException e) {
      throw new EmployeeNotFoundException("Employee(" + accessKey + ") is not found!");
    }
  }

  protected Employee loadInternalEmployee(AccessKey accessKey, Map<String, Object> loadOptions)
      throws Exception {

    Employee employee = extractEmployee(accessKey, loadOptions);

    if (isExtractCompanyEnabled(loadOptions)) {
      extractCompany(employee, loadOptions);
    }

    if (isExtractDepartmentEnabled(loadOptions)) {
      extractDepartment(employee, loadOptions);
    }

    if (isExtractOccupationEnabled(loadOptions)) {
      extractOccupation(employee, loadOptions);
    }

    if (isExtractResponsibleForEnabled(loadOptions)) {
      extractResponsibleFor(employee, loadOptions);
    }

    if (isExtractCurrentSalaryGradeEnabled(loadOptions)) {
      extractCurrentSalaryGrade(employee, loadOptions);
    }

    if (isExtractEmployeeCompanyTrainingListEnabled(loadOptions)) {
      extractEmployeeCompanyTrainingList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeCompanyTrainingListEnabled(loadOptions)) {
      analyzeEmployeeCompanyTrainingList(employee, loadOptions);
    }

    if (isExtractEmployeeSkillListEnabled(loadOptions)) {
      extractEmployeeSkillList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeSkillListEnabled(loadOptions)) {
      analyzeEmployeeSkillList(employee, loadOptions);
    }

    if (isExtractEmployeePerformanceListEnabled(loadOptions)) {
      extractEmployeePerformanceList(employee, loadOptions);
    }

    if (isAnalyzeEmployeePerformanceListEnabled(loadOptions)) {
      analyzeEmployeePerformanceList(employee, loadOptions);
    }

    if (isExtractEmployeeWorkExperienceListEnabled(loadOptions)) {
      extractEmployeeWorkExperienceList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeWorkExperienceListEnabled(loadOptions)) {
      analyzeEmployeeWorkExperienceList(employee, loadOptions);
    }

    if (isExtractEmployeeLeaveListEnabled(loadOptions)) {
      extractEmployeeLeaveList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeLeaveListEnabled(loadOptions)) {
      analyzeEmployeeLeaveList(employee, loadOptions);
    }

    if (isExtractEmployeeInterviewListEnabled(loadOptions)) {
      extractEmployeeInterviewList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeInterviewListEnabled(loadOptions)) {
      analyzeEmployeeInterviewList(employee, loadOptions);
    }

    if (isExtractEmployeeAttendanceListEnabled(loadOptions)) {
      extractEmployeeAttendanceList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeAttendanceListEnabled(loadOptions)) {
      analyzeEmployeeAttendanceList(employee, loadOptions);
    }

    if (isExtractEmployeeQualifierListEnabled(loadOptions)) {
      extractEmployeeQualifierList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeQualifierListEnabled(loadOptions)) {
      analyzeEmployeeQualifierList(employee, loadOptions);
    }

    if (isExtractEmployeeEducationListEnabled(loadOptions)) {
      extractEmployeeEducationList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeEducationListEnabled(loadOptions)) {
      analyzeEmployeeEducationList(employee, loadOptions);
    }

    if (isExtractEmployeeAwardListEnabled(loadOptions)) {
      extractEmployeeAwardList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeAwardListEnabled(loadOptions)) {
      analyzeEmployeeAwardList(employee, loadOptions);
    }

    if (isExtractEmployeeSalarySheetListEnabled(loadOptions)) {
      extractEmployeeSalarySheetList(employee, loadOptions);
    }

    if (isAnalyzeEmployeeSalarySheetListEnabled(loadOptions)) {
      analyzeEmployeeSalarySheetList(employee, loadOptions);
    }

    if (isExtractPayingOffListEnabled(loadOptions)) {
      extractPayingOffList(employee, loadOptions);
    }

    if (isAnalyzePayingOffListEnabled(loadOptions)) {
      analyzePayingOffList(employee, loadOptions);
    }

    return employee;
  }

  protected Employee extractCompany(Employee employee, Map<String, Object> options)
      throws Exception {

    if (employee.getCompany() == null) {
      return employee;
    }
    String companyId = employee.getCompany().getId();
    if (companyId == null) {
      return employee;
    }
    RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId, options);
    if (company != null) {
      employee.setCompany(company);
    }

    return employee;
  }

  protected Employee extractDepartment(Employee employee, Map<String, Object> options)
      throws Exception {

    if (employee.getDepartment() == null) {
      return employee;
    }
    String departmentId = employee.getDepartment().getId();
    if (departmentId == null) {
      return employee;
    }
    LevelThreeDepartment department = getLevelThreeDepartmentDAO().load(departmentId, options);
    if (department != null) {
      employee.setDepartment(department);
    }

    return employee;
  }

  protected Employee extractOccupation(Employee employee, Map<String, Object> options)
      throws Exception {

    if (employee.getOccupation() == null) {
      return employee;
    }
    String occupationId = employee.getOccupation().getId();
    if (occupationId == null) {
      return employee;
    }
    OccupationType occupation = getOccupationTypeDAO().load(occupationId, options);
    if (occupation != null) {
      employee.setOccupation(occupation);
    }

    return employee;
  }

  protected Employee extractResponsibleFor(Employee employee, Map<String, Object> options)
      throws Exception {

    if (employee.getResponsibleFor() == null) {
      return employee;
    }
    String responsibleForId = employee.getResponsibleFor().getId();
    if (responsibleForId == null) {
      return employee;
    }
    ResponsibilityType responsibleFor = getResponsibilityTypeDAO().load(responsibleForId, options);
    if (responsibleFor != null) {
      employee.setResponsibleFor(responsibleFor);
    }

    return employee;
  }

  protected Employee extractCurrentSalaryGrade(Employee employee, Map<String, Object> options)
      throws Exception {

    if (employee.getCurrentSalaryGrade() == null) {
      return employee;
    }
    String currentSalaryGradeId = employee.getCurrentSalaryGrade().getId();
    if (currentSalaryGradeId == null) {
      return employee;
    }
    SalaryGrade currentSalaryGrade = getSalaryGradeDAO().load(currentSalaryGradeId, options);
    if (currentSalaryGrade != null) {
      employee.setCurrentSalaryGrade(currentSalaryGrade);
    }

    return employee;
  }

  protected void enhanceEmployeeCompanyTrainingList(
      SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeCompanyTrainingList(
      Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        getEmployeeCompanyTrainingDAO()
            .findEmployeeCompanyTrainingByEmployee(employee.getId(), options);
    if (employeeCompanyTrainingList != null) {
      enhanceEmployeeCompanyTrainingList(employeeCompanyTrainingList, options);
      employee.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeCompanyTrainingList(
      Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        employee.getEmployeeCompanyTrainingList();
    if (employeeCompanyTrainingList != null) {
      getEmployeeCompanyTrainingDAO()
          .analyzeEmployeeCompanyTrainingByEmployee(
              employeeCompanyTrainingList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeSkillList(
      SmartList<EmployeeSkill> employeeSkillList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeSkillList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeSkill> employeeSkillList =
        getEmployeeSkillDAO().findEmployeeSkillByEmployee(employee.getId(), options);
    if (employeeSkillList != null) {
      enhanceEmployeeSkillList(employeeSkillList, options);
      employee.setEmployeeSkillList(employeeSkillList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeSkillList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
    if (employeeSkillList != null) {
      getEmployeeSkillDAO()
          .analyzeEmployeeSkillByEmployee(employeeSkillList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeePerformanceList(
      SmartList<EmployeePerformance> employeePerformanceList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeePerformanceList(
      Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeePerformance> employeePerformanceList =
        getEmployeePerformanceDAO().findEmployeePerformanceByEmployee(employee.getId(), options);
    if (employeePerformanceList != null) {
      enhanceEmployeePerformanceList(employeePerformanceList, options);
      employee.setEmployeePerformanceList(employeePerformanceList);
    }

    return employee;
  }

  protected Employee analyzeEmployeePerformanceList(
      Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();
    if (employeePerformanceList != null) {
      getEmployeePerformanceDAO()
          .analyzeEmployeePerformanceByEmployee(employeePerformanceList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeWorkExperienceList(
      SmartList<EmployeeWorkExperience> employeeWorkExperienceList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeWorkExperienceList(
      Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeWorkExperience> employeeWorkExperienceList =
        getEmployeeWorkExperienceDAO()
            .findEmployeeWorkExperienceByEmployee(employee.getId(), options);
    if (employeeWorkExperienceList != null) {
      enhanceEmployeeWorkExperienceList(employeeWorkExperienceList, options);
      employee.setEmployeeWorkExperienceList(employeeWorkExperienceList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeWorkExperienceList(
      Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeWorkExperience> employeeWorkExperienceList =
        employee.getEmployeeWorkExperienceList();
    if (employeeWorkExperienceList != null) {
      getEmployeeWorkExperienceDAO()
          .analyzeEmployeeWorkExperienceByEmployee(
              employeeWorkExperienceList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeLeaveList(
      SmartList<EmployeeLeave> employeeLeaveList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeLeaveList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeLeave> employeeLeaveList =
        getEmployeeLeaveDAO().findEmployeeLeaveByWho(employee.getId(), options);
    if (employeeLeaveList != null) {
      enhanceEmployeeLeaveList(employeeLeaveList, options);
      employee.setEmployeeLeaveList(employeeLeaveList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeLeaveList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
    if (employeeLeaveList != null) {
      getEmployeeLeaveDAO().analyzeEmployeeLeaveByWho(employeeLeaveList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeInterviewList(
      SmartList<EmployeeInterview> employeeInterviewList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeInterviewList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeInterview> employeeInterviewList =
        getEmployeeInterviewDAO().findEmployeeInterviewByEmployee(employee.getId(), options);
    if (employeeInterviewList != null) {
      enhanceEmployeeInterviewList(employeeInterviewList, options);
      employee.setEmployeeInterviewList(employeeInterviewList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeInterviewList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
    if (employeeInterviewList != null) {
      getEmployeeInterviewDAO()
          .analyzeEmployeeInterviewByEmployee(employeeInterviewList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeAttendanceList(
      SmartList<EmployeeAttendance> employeeAttendanceList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeAttendanceList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeAttendance> employeeAttendanceList =
        getEmployeeAttendanceDAO().findEmployeeAttendanceByEmployee(employee.getId(), options);
    if (employeeAttendanceList != null) {
      enhanceEmployeeAttendanceList(employeeAttendanceList, options);
      employee.setEmployeeAttendanceList(employeeAttendanceList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeAttendanceList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();
    if (employeeAttendanceList != null) {
      getEmployeeAttendanceDAO()
          .analyzeEmployeeAttendanceByEmployee(employeeAttendanceList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeQualifierList(
      SmartList<EmployeeQualifier> employeeQualifierList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeQualifierList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeQualifier> employeeQualifierList =
        getEmployeeQualifierDAO().findEmployeeQualifierByEmployee(employee.getId(), options);
    if (employeeQualifierList != null) {
      enhanceEmployeeQualifierList(employeeQualifierList, options);
      employee.setEmployeeQualifierList(employeeQualifierList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeQualifierList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();
    if (employeeQualifierList != null) {
      getEmployeeQualifierDAO()
          .analyzeEmployeeQualifierByEmployee(employeeQualifierList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeEducationList(
      SmartList<EmployeeEducation> employeeEducationList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeEducationList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeEducation> employeeEducationList =
        getEmployeeEducationDAO().findEmployeeEducationByEmployee(employee.getId(), options);
    if (employeeEducationList != null) {
      enhanceEmployeeEducationList(employeeEducationList, options);
      employee.setEmployeeEducationList(employeeEducationList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeEducationList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();
    if (employeeEducationList != null) {
      getEmployeeEducationDAO()
          .analyzeEmployeeEducationByEmployee(employeeEducationList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeAwardList(
      SmartList<EmployeeAward> employeeAwardList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeAwardList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeAward> employeeAwardList =
        getEmployeeAwardDAO().findEmployeeAwardByEmployee(employee.getId(), options);
    if (employeeAwardList != null) {
      enhanceEmployeeAwardList(employeeAwardList, options);
      employee.setEmployeeAwardList(employeeAwardList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeAwardList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();
    if (employeeAwardList != null) {
      getEmployeeAwardDAO()
          .analyzeEmployeeAwardByEmployee(employeeAwardList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhanceEmployeeSalarySheetList(
      SmartList<EmployeeSalarySheet> employeeSalarySheetList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractEmployeeSalarySheetList(
      Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList =
        getEmployeeSalarySheetDAO().findEmployeeSalarySheetByEmployee(employee.getId(), options);
    if (employeeSalarySheetList != null) {
      enhanceEmployeeSalarySheetList(employeeSalarySheetList, options);
      employee.setEmployeeSalarySheetList(employeeSalarySheetList);
    }

    return employee;
  }

  protected Employee analyzeEmployeeSalarySheetList(
      Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
    if (employeeSalarySheetList != null) {
      getEmployeeSalarySheetDAO()
          .analyzeEmployeeSalarySheetByEmployee(employeeSalarySheetList, employee.getId(), options);
    }

    return employee;
  }

  protected void enhancePayingOffList(
      SmartList<PayingOff> payingOffList, Map<String, Object> options) {
    // extract multiple list from difference sources
    // Trying to use a single SQL to extract all data from database and do the work in java side,
    // java is easier to scale to N ndoes;
  }

  protected Employee extractPayingOffList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<PayingOff> payingOffList =
        getPayingOffDAO().findPayingOffByPaidFor(employee.getId(), options);
    if (payingOffList != null) {
      enhancePayingOffList(payingOffList, options);
      employee.setPayingOffList(payingOffList);
    }

    return employee;
  }

  protected Employee analyzePayingOffList(Employee employee, Map<String, Object> options) {

    if (employee == null) {
      return null;
    }
    if (employee.getId() == null) {
      return employee;
    }

    SmartList<PayingOff> payingOffList = employee.getPayingOffList();
    if (payingOffList != null) {
      getPayingOffDAO().analyzePayingOffByPaidFor(payingOffList, employee.getId(), options);
    }

    return employee;
  }

  public SmartList<Employee> findEmployeeByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWith(
            EmployeeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options, getEmployeeMapper());
    // analyzeEmployeeByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public SmartList<Employee> findEmployeeByCompany(
      String retailStoreCountryCenterId, int start, int count, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWithRange(
            EmployeeTable.COLUMN_COMPANY,
            retailStoreCountryCenterId,
            options,
            getEmployeeMapper(),
            start,
            count);
    // analyzeEmployeeByCompany(resultList, retailStoreCountryCenterId, options);
    return resultList;
  }

  public void analyzeEmployeeByCompany(
      SmartList<Employee> resultList,
      String retailStoreCountryCenterId,
      Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenterId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // Employee.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("员工");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(Employee.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(Employee.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countEmployeeByCompany(
      String retailStoreCountryCenterId, Map<String, Object> options) {

    return countWith(EmployeeTable.COLUMN_COMPANY, retailStoreCountryCenterId, options);
  }

  @Override
  public Map<String, Integer> countEmployeeByCompanyIds(String[] ids, Map<String, Object> options) {
    return countWithIds(EmployeeTable.COLUMN_COMPANY, ids, options);
  }

  public SmartList<Employee> findEmployeeByDepartment(
      String levelThreeDepartmentId, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWith(
            EmployeeTable.COLUMN_DEPARTMENT, levelThreeDepartmentId, options, getEmployeeMapper());
    // analyzeEmployeeByDepartment(resultList, levelThreeDepartmentId, options);
    return resultList;
  }

  public SmartList<Employee> findEmployeeByDepartment(
      String levelThreeDepartmentId, int start, int count, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWithRange(
            EmployeeTable.COLUMN_DEPARTMENT,
            levelThreeDepartmentId,
            options,
            getEmployeeMapper(),
            start,
            count);
    // analyzeEmployeeByDepartment(resultList, levelThreeDepartmentId, options);
    return resultList;
  }

  public void analyzeEmployeeByDepartment(
      SmartList<Employee> resultList, String levelThreeDepartmentId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(Employee.DEPARTMENT_PROPERTY, levelThreeDepartmentId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // Employee.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("员工");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(Employee.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(Employee.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countEmployeeByDepartment(String levelThreeDepartmentId, Map<String, Object> options) {

    return countWith(EmployeeTable.COLUMN_DEPARTMENT, levelThreeDepartmentId, options);
  }

  @Override
  public Map<String, Integer> countEmployeeByDepartmentIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(EmployeeTable.COLUMN_DEPARTMENT, ids, options);
  }

  public SmartList<Employee> findEmployeeByOccupation(
      String occupationTypeId, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWith(EmployeeTable.COLUMN_OCCUPATION, occupationTypeId, options, getEmployeeMapper());
    // analyzeEmployeeByOccupation(resultList, occupationTypeId, options);
    return resultList;
  }

  public SmartList<Employee> findEmployeeByOccupation(
      String occupationTypeId, int start, int count, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWithRange(
            EmployeeTable.COLUMN_OCCUPATION,
            occupationTypeId,
            options,
            getEmployeeMapper(),
            start,
            count);
    // analyzeEmployeeByOccupation(resultList, occupationTypeId, options);
    return resultList;
  }

  public void analyzeEmployeeByOccupation(
      SmartList<Employee> resultList, String occupationTypeId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(Employee.OCCUPATION_PROPERTY, occupationTypeId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // Employee.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("员工");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(Employee.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(Employee.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countEmployeeByOccupation(String occupationTypeId, Map<String, Object> options) {

    return countWith(EmployeeTable.COLUMN_OCCUPATION, occupationTypeId, options);
  }

  @Override
  public Map<String, Integer> countEmployeeByOccupationIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(EmployeeTable.COLUMN_OCCUPATION, ids, options);
  }

  public SmartList<Employee> findEmployeeByResponsibleFor(
      String responsibilityTypeId, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWith(
            EmployeeTable.COLUMN_RESPONSIBLE_FOR,
            responsibilityTypeId,
            options,
            getEmployeeMapper());
    // analyzeEmployeeByResponsibleFor(resultList, responsibilityTypeId, options);
    return resultList;
  }

  public SmartList<Employee> findEmployeeByResponsibleFor(
      String responsibilityTypeId, int start, int count, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWithRange(
            EmployeeTable.COLUMN_RESPONSIBLE_FOR,
            responsibilityTypeId,
            options,
            getEmployeeMapper(),
            start,
            count);
    // analyzeEmployeeByResponsibleFor(resultList, responsibilityTypeId, options);
    return resultList;
  }

  public void analyzeEmployeeByResponsibleFor(
      SmartList<Employee> resultList, String responsibilityTypeId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibilityTypeId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // Employee.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("员工");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(Employee.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(Employee.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countEmployeeByResponsibleFor(
      String responsibilityTypeId, Map<String, Object> options) {

    return countWith(EmployeeTable.COLUMN_RESPONSIBLE_FOR, responsibilityTypeId, options);
  }

  @Override
  public Map<String, Integer> countEmployeeByResponsibleForIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(EmployeeTable.COLUMN_RESPONSIBLE_FOR, ids, options);
  }

  public SmartList<Employee> findEmployeeByCurrentSalaryGrade(
      String salaryGradeId, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWith(
            EmployeeTable.COLUMN_CURRENT_SALARY_GRADE, salaryGradeId, options, getEmployeeMapper());
    // analyzeEmployeeByCurrentSalaryGrade(resultList, salaryGradeId, options);
    return resultList;
  }

  public SmartList<Employee> findEmployeeByCurrentSalaryGrade(
      String salaryGradeId, int start, int count, Map<String, Object> options) {

    SmartList<Employee> resultList =
        queryWithRange(
            EmployeeTable.COLUMN_CURRENT_SALARY_GRADE,
            salaryGradeId,
            options,
            getEmployeeMapper(),
            start,
            count);
    // analyzeEmployeeByCurrentSalaryGrade(resultList, salaryGradeId, options);
    return resultList;
  }

  public void analyzeEmployeeByCurrentSalaryGrade(
      SmartList<Employee> resultList, String salaryGradeId, Map<String, Object> options) {
    if (resultList == null) {
      return; // do nothing when the list is null.
    }

    MultipleAccessKey filterKey = new MultipleAccessKey();
    filterKey.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, salaryGradeId);
    Map<String, Object> emptyOptions = new HashMap<String, Object>();

    StatsInfo info = new StatsInfo();

    StatsItem lastUpdateTimeStatsItem = new StatsItem();
    // Employee.LAST_UPDATE_TIME_PROPERTY
    lastUpdateTimeStatsItem.setDisplayName("员工");
    lastUpdateTimeStatsItem.setInternalName(
        formatKeyForDateLine(Employee.LAST_UPDATE_TIME_PROPERTY));
    lastUpdateTimeStatsItem.setResult(
        statsWithGroup(
            DateKey.class,
            wrapWithDate(Employee.LAST_UPDATE_TIME_PROPERTY),
            filterKey,
            emptyOptions));
    info.addItem(lastUpdateTimeStatsItem);

    resultList.setStatsInfo(info);
  }

  @Override
  public int countEmployeeByCurrentSalaryGrade(String salaryGradeId, Map<String, Object> options) {

    return countWith(EmployeeTable.COLUMN_CURRENT_SALARY_GRADE, salaryGradeId, options);
  }

  @Override
  public Map<String, Integer> countEmployeeByCurrentSalaryGradeIds(
      String[] ids, Map<String, Object> options) {
    return countWithIds(EmployeeTable.COLUMN_CURRENT_SALARY_GRADE, ids, options);
  }

  protected Employee saveEmployee(Employee employee) {

    if (!employee.isChanged()) {
      return employee;
    }

    Beans.dbUtil().cacheCleanUp(employee);
    String SQL = this.getSaveEmployeeSQL(employee);
    // FIXME: how about when an item has been updated more than MAX_INT?
    Object[] parameters = getSaveEmployeeParameters(employee);
    int affectedNumber = singleUpdate(SQL, parameters);
    if (affectedNumber != 1) {
      throw new IllegalStateException(
          "The save operation should return value = 1, while the value = "
              + affectedNumber
              + "If the value = 0, that mean the target record has been updated by someone else!");
    }

    employee.incVersion();
    employee.afterSave();
    return employee;
  }

  public SmartList<Employee> saveEmployeeList(
      SmartList<Employee> employeeList, Map<String, Object> options) {
    // assuming here are big amount objects to be updated.
    // First step is split into two groups, one group for update and another group for create
    Object[] lists = splitEmployeeList(employeeList);

    batchEmployeeCreate((List<Employee>) lists[CREATE_LIST_INDEX]);
    batchEmployeeUpdate((List<Employee>) lists[UPDATE_LIST_INDEX]);
    batchEmployeeRemove((List<Employee>) lists[REMOVE_LIST_INDEX]);
    batchEmployeeRecover((List<Employee>) lists[RECOVER_LIST_INDEX]);

    // update version after the list successfully saved to database;
    for (Employee employee : employeeList) {
      if (employee.isChanged()) {
        employee.incVersion();
        employee.afterSave();
      }
      if (employee.isToRecover() || employee.isToRemove()) {
        employee.setVersion(-employee.getVersion());
      }
    }

    return employeeList;
  }

  public SmartList<Employee> removeEmployeeList(
      SmartList<Employee> employeeList, Map<String, Object> options) {

    super.removeList(employeeList, options);

    return employeeList;
  }

  protected List<Object[]> prepareEmployeeBatchCreateArgs(List<Employee> employeeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Employee employee : employeeList) {
      Object[] parameters = prepareEmployeeCreateParameters(employee);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareEmployeeBatchUpdateArgs(List<Employee> employeeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Employee employee : employeeList) {
      if (!employee.isChanged()) {
        continue;
      }
      Object[] parameters = prepareEmployeeUpdateParameters(employee);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareEmployeeBatchRecoverArgs(List<Employee> employeeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Employee employee : employeeList) {
      if (!employee.isToRecover()) {
        continue;
      }
      Object[] parameters = prepareRecoverParameters(employee);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected List<Object[]> prepareEmployeeBatchRemoveArgs(List<Employee> employeeList) {

    List<Object[]> parametersList = new ArrayList<Object[]>();
    for (Employee employee : employeeList) {
      if (!employee.isToRemove()) {
        continue;
      }
      Object[] parameters = prepareEmployeeRemoveParameters(employee);
      parametersList.add(parameters);
    }
    return parametersList;
  }

  protected void batchEmployeeCreate(List<Employee> employeeList) {
    String SQL = getCreateSQL();
    List<Object[]> args = prepareEmployeeBatchCreateArgs(employeeList);

    int affectedNumbers[] = batchUpdate(SQL, args);
  }

  protected void batchEmployeeUpdate(List<Employee> employeeList) {
    String SQL = getUpdateSQL();
    List<Object[]> args = prepareEmployeeBatchUpdateArgs(employeeList);

    int affectedNumbers[] = batchUpdate(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchEmployeeRemove(List<Employee> employeeList) {
    String SQL = getRemoveSQL();
    List<Object[]> args = prepareEmployeeBatchRemoveArgs(employeeList);
    int affectedNumbers[] = batchRemove(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  protected void batchEmployeeRecover(List<Employee> employeeList) {
    String SQL = getRecoverSQL();
    List<Object[]> args = prepareEmployeeBatchRecoverArgs(employeeList);
    int affectedNumbers[] = batchRecover(SQL, args);
    checkBatchReturn(affectedNumbers);
  }

  static final int CREATE_LIST_INDEX = 0;
  static final int UPDATE_LIST_INDEX = 1;
  static final int REMOVE_LIST_INDEX = 2;
  static final int RECOVER_LIST_INDEX = 3;

  protected Object[] splitEmployeeList(List<Employee> employeeList) {

    List<Employee> employeeCreateList = new ArrayList<Employee>();
    List<Employee> employeeUpdateList = new ArrayList<Employee>();
    List<Employee> employeeRemoveList = new ArrayList<Employee>();
    List<Employee> employeeRecoverList = new ArrayList<Employee>();

    for (Employee employee : employeeList) {
      if (employee.isToRemove()) {
        employeeRemoveList.add(employee);
        continue;
      }
      if (employee.isToRecover()) {
        employeeRecoverList.add(employee);
        continue;
      }
      if (isUpdateRequest(employee)) {
        if (employee.isChanged()) {
          employeeUpdateList.add(employee);
        }
        continue;
      }

      if (employee.isChanged()) {
        employeeCreateList.add(employee);
      }
    }

    return new Object[] {
      employeeCreateList, employeeUpdateList, employeeRemoveList, employeeRecoverList
    };
  }

  protected boolean isUpdateRequest(Employee employee) {
    return employee.getVersion() > 0;
  }

  protected String getSaveEmployeeSQL(Employee employee) {
    if (employee.isToRemove()) {
      return getRemoveSQL();
    }
    if (isUpdateRequest(employee)) {
      return getUpdateSQL();
    }
    return getCreateSQL();
  }

  protected Object[] getSaveEmployeeParameters(Employee employee) {
    if (employee.isToRemove()) {
      return prepareEmployeeRemoveParameters(employee);
    }
    if (employee.isToRecover()) {
      return prepareRecoverParameters(employee);
    }

    if (isUpdateRequest(employee)) {
      return prepareEmployeeUpdateParameters(employee);
    }
    return prepareEmployeeCreateParameters(employee);
  }

  protected Object[] prepareEmployeeRemoveParameters(Employee employee) {
    return super.prepareRemoveParameters(employee);
  }

  protected Object[] prepareEmployeeUpdateParameters(Employee employee) {
    Object[] parameters = new Object[17];

    if (employee.getCompany() != null) {
      parameters[0] = employee.getCompany().getId();
    }

    parameters[1] = employee.getTitle();

    if (employee.getDepartment() != null) {
      parameters[2] = employee.getDepartment().getId();
    }

    parameters[3] = employee.getFamilyName();

    parameters[4] = employee.getGivenName();

    parameters[5] = employee.getEmail();

    parameters[6] = employee.getCity();

    parameters[7] = employee.getAddress();

    parameters[8] = employee.getCellPhone();

    if (employee.getOccupation() != null) {
      parameters[9] = employee.getOccupation().getId();
    }

    if (employee.getResponsibleFor() != null) {
      parameters[10] = employee.getResponsibleFor().getId();
    }

    if (employee.getCurrentSalaryGrade() != null) {
      parameters[11] = employee.getCurrentSalaryGrade().getId();
    }

    parameters[12] = employee.getSalaryAccount();

    parameters[13] = employee.getLastUpdateTime();

    parameters[14] = employee.nextVersion();
    parameters[15] = employee.getId();
    parameters[16] = employee.getVersion();

    return parameters;
  }

  protected Object[] prepareEmployeeCreateParameters(Employee employee) {
    Object[] parameters = new Object[15];
    if (employee.getId() == null) {
      String newEmployeeId = getNextId();
      employee.setId(newEmployeeId);
    }
    parameters[0] = employee.getId();

    if (employee.getCompany() != null) {
      parameters[1] = employee.getCompany().getId();
    }

    parameters[2] = employee.getTitle();

    if (employee.getDepartment() != null) {
      parameters[3] = employee.getDepartment().getId();
    }

    parameters[4] = employee.getFamilyName();

    parameters[5] = employee.getGivenName();

    parameters[6] = employee.getEmail();

    parameters[7] = employee.getCity();

    parameters[8] = employee.getAddress();

    parameters[9] = employee.getCellPhone();

    if (employee.getOccupation() != null) {
      parameters[10] = employee.getOccupation().getId();
    }

    if (employee.getResponsibleFor() != null) {
      parameters[11] = employee.getResponsibleFor().getId();
    }

    if (employee.getCurrentSalaryGrade() != null) {
      parameters[12] = employee.getCurrentSalaryGrade().getId();
    }

    parameters[13] = employee.getSalaryAccount();

    parameters[14] = employee.getLastUpdateTime();

    return parameters;
  }

  protected Employee saveInternalEmployee(Employee employee, Map<String, Object> options) {

    if (isSaveCompanyEnabled(options)) {
      saveCompany(employee, options);
    }

    if (isSaveDepartmentEnabled(options)) {
      saveDepartment(employee, options);
    }

    if (isSaveOccupationEnabled(options)) {
      saveOccupation(employee, options);
    }

    if (isSaveResponsibleForEnabled(options)) {
      saveResponsibleFor(employee, options);
    }

    if (isSaveCurrentSalaryGradeEnabled(options)) {
      saveCurrentSalaryGrade(employee, options);
    }

    saveEmployee(employee);

    if (isSaveEmployeeCompanyTrainingListEnabled(options)) {
      saveEmployeeCompanyTrainingList(employee, options);
      // removeEmployeeCompanyTrainingList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeSkillListEnabled(options)) {
      saveEmployeeSkillList(employee, options);
      // removeEmployeeSkillList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeePerformanceListEnabled(options)) {
      saveEmployeePerformanceList(employee, options);
      // removeEmployeePerformanceList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeWorkExperienceListEnabled(options)) {
      saveEmployeeWorkExperienceList(employee, options);
      // removeEmployeeWorkExperienceList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeLeaveListEnabled(options)) {
      saveEmployeeLeaveList(employee, options);
      // removeEmployeeLeaveList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeInterviewListEnabled(options)) {
      saveEmployeeInterviewList(employee, options);
      // removeEmployeeInterviewList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeAttendanceListEnabled(options)) {
      saveEmployeeAttendanceList(employee, options);
      // removeEmployeeAttendanceList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeQualifierListEnabled(options)) {
      saveEmployeeQualifierList(employee, options);
      // removeEmployeeQualifierList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeEducationListEnabled(options)) {
      saveEmployeeEducationList(employee, options);
      // removeEmployeeEducationList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeAwardListEnabled(options)) {
      saveEmployeeAwardList(employee, options);
      // removeEmployeeAwardList(employee, options);
      // Not delete the record

    }

    if (isSaveEmployeeSalarySheetListEnabled(options)) {
      saveEmployeeSalarySheetList(employee, options);
      // removeEmployeeSalarySheetList(employee, options);
      // Not delete the record

    }

    if (isSavePayingOffListEnabled(options)) {
      savePayingOffList(employee, options);
      // removePayingOffList(employee, options);
      // Not delete the record

    }

    return employee;
  }

  // ======================================================================================

  protected Employee saveCompany(Employee employee, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (employee.getCompany() == null) {
      return employee; // do nothing when it is null
    }

    getRetailStoreCountryCenterDAO().save(employee.getCompany(), options);
    return employee;
  }

  protected Employee saveDepartment(Employee employee, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (employee.getDepartment() == null) {
      return employee; // do nothing when it is null
    }

    getLevelThreeDepartmentDAO().save(employee.getDepartment(), options);
    return employee;
  }

  protected Employee saveOccupation(Employee employee, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (employee.getOccupation() == null) {
      return employee; // do nothing when it is null
    }

    getOccupationTypeDAO().save(employee.getOccupation(), options);
    return employee;
  }

  protected Employee saveResponsibleFor(Employee employee, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (employee.getResponsibleFor() == null) {
      return employee; // do nothing when it is null
    }

    getResponsibilityTypeDAO().save(employee.getResponsibleFor(), options);
    return employee;
  }

  protected Employee saveCurrentSalaryGrade(Employee employee, Map<String, Object> options) {

    // Call inject DAO to execute this method
    if (employee.getCurrentSalaryGrade() == null) {
      return employee; // do nothing when it is null
    }

    getSalaryGradeDAO().save(employee.getCurrentSalaryGrade(), options);
    return employee;
  }

  public Employee planToRemoveEmployeeCompanyTrainingList(
      Employee employee, String employeeCompanyTrainingIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeCompanyTraining.ID_PROPERTY, employeeCompanyTrainingIds);

    SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList =
        getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingWithKey(key, options);
    if (externalEmployeeCompanyTrainingList == null) {
      return employee;
    }
    if (externalEmployeeCompanyTrainingList.isEmpty()) {
      return employee;
    }

    for (EmployeeCompanyTraining employeeCompanyTrainingItem :
        externalEmployeeCompanyTrainingList) {

      employeeCompanyTrainingItem.clearFromAll();
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        employee.getEmployeeCompanyTrainingList();
    employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
    return employee;
  }

  // disconnect Employee with training in EmployeeCompanyTraining
  public Employee planToRemoveEmployeeCompanyTrainingListWithTraining(
      Employee employee, String trainingId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, trainingId);

    SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList =
        getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingWithKey(key, options);
    if (externalEmployeeCompanyTrainingList == null) {
      return employee;
    }
    if (externalEmployeeCompanyTrainingList.isEmpty()) {
      return employee;
    }

    for (EmployeeCompanyTraining employeeCompanyTrainingItem :
        externalEmployeeCompanyTrainingList) {
      employeeCompanyTrainingItem.clearTraining();
      employeeCompanyTrainingItem.clearEmployee();
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        employee.getEmployeeCompanyTrainingList();
    employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
    return employee;
  }

  public int countEmployeeCompanyTrainingListWithTraining(
      String employeeId, String trainingId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);
    key.put(EmployeeCompanyTraining.TRAINING_PROPERTY, trainingId);

    int count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingWithKey(key, options);
    return count;
  }

  // disconnect Employee with scoring in EmployeeCompanyTraining
  public Employee planToRemoveEmployeeCompanyTrainingListWithScoring(
      Employee employee, String scoringId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);

    SmartList<EmployeeCompanyTraining> externalEmployeeCompanyTrainingList =
        getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingWithKey(key, options);
    if (externalEmployeeCompanyTrainingList == null) {
      return employee;
    }
    if (externalEmployeeCompanyTrainingList.isEmpty()) {
      return employee;
    }

    for (EmployeeCompanyTraining employeeCompanyTrainingItem :
        externalEmployeeCompanyTrainingList) {
      employeeCompanyTrainingItem.clearScoring();
      employeeCompanyTrainingItem.clearEmployee();
    }

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        employee.getEmployeeCompanyTrainingList();
    employeeCompanyTrainingList.addAllToRemoveList(externalEmployeeCompanyTrainingList);
    return employee;
  }

  public int countEmployeeCompanyTrainingListWithScoring(
      String employeeId, String scoringId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, employeeId);
    key.put(EmployeeCompanyTraining.SCORING_PROPERTY, scoringId);

    int count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingWithKey(key, options);
    return count;
  }

  public Employee planToRemoveEmployeeSkillList(
      Employee employee, String employeeSkillIds[], Map<String, Object> options) throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSkill.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeSkill.ID_PROPERTY, employeeSkillIds);

    SmartList<EmployeeSkill> externalEmployeeSkillList =
        getEmployeeSkillDAO().findEmployeeSkillWithKey(key, options);
    if (externalEmployeeSkillList == null) {
      return employee;
    }
    if (externalEmployeeSkillList.isEmpty()) {
      return employee;
    }

    for (EmployeeSkill employeeSkillItem : externalEmployeeSkillList) {

      employeeSkillItem.clearFromAll();
    }

    SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
    employeeSkillList.addAllToRemoveList(externalEmployeeSkillList);
    return employee;
  }

  // disconnect Employee with skill_type in EmployeeSkill
  public Employee planToRemoveEmployeeSkillListWithSkillType(
      Employee employee, String skillTypeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSkill.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeSkill.SKILL_TYPE_PROPERTY, skillTypeId);

    SmartList<EmployeeSkill> externalEmployeeSkillList =
        getEmployeeSkillDAO().findEmployeeSkillWithKey(key, options);
    if (externalEmployeeSkillList == null) {
      return employee;
    }
    if (externalEmployeeSkillList.isEmpty()) {
      return employee;
    }

    for (EmployeeSkill employeeSkillItem : externalEmployeeSkillList) {
      employeeSkillItem.clearSkillType();
      employeeSkillItem.clearEmployee();
    }

    SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
    employeeSkillList.addAllToRemoveList(externalEmployeeSkillList);
    return employee;
  }

  public int countEmployeeSkillListWithSkillType(
      String employeeId, String skillTypeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSkill.EMPLOYEE_PROPERTY, employeeId);
    key.put(EmployeeSkill.SKILL_TYPE_PROPERTY, skillTypeId);

    int count = getEmployeeSkillDAO().countEmployeeSkillWithKey(key, options);
    return count;
  }

  public Employee planToRemoveEmployeePerformanceList(
      Employee employee, String employeePerformanceIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeePerformance.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeePerformance.ID_PROPERTY, employeePerformanceIds);

    SmartList<EmployeePerformance> externalEmployeePerformanceList =
        getEmployeePerformanceDAO().findEmployeePerformanceWithKey(key, options);
    if (externalEmployeePerformanceList == null) {
      return employee;
    }
    if (externalEmployeePerformanceList.isEmpty()) {
      return employee;
    }

    for (EmployeePerformance employeePerformanceItem : externalEmployeePerformanceList) {

      employeePerformanceItem.clearFromAll();
    }

    SmartList<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();
    employeePerformanceList.addAllToRemoveList(externalEmployeePerformanceList);
    return employee;
  }

  public Employee planToRemoveEmployeeWorkExperienceList(
      Employee employee, String employeeWorkExperienceIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeWorkExperience.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeWorkExperience.ID_PROPERTY, employeeWorkExperienceIds);

    SmartList<EmployeeWorkExperience> externalEmployeeWorkExperienceList =
        getEmployeeWorkExperienceDAO().findEmployeeWorkExperienceWithKey(key, options);
    if (externalEmployeeWorkExperienceList == null) {
      return employee;
    }
    if (externalEmployeeWorkExperienceList.isEmpty()) {
      return employee;
    }

    for (EmployeeWorkExperience employeeWorkExperienceItem : externalEmployeeWorkExperienceList) {

      employeeWorkExperienceItem.clearFromAll();
    }

    SmartList<EmployeeWorkExperience> employeeWorkExperienceList =
        employee.getEmployeeWorkExperienceList();
    employeeWorkExperienceList.addAllToRemoveList(externalEmployeeWorkExperienceList);
    return employee;
  }

  public Employee planToRemoveEmployeeLeaveList(
      Employee employee, String employeeLeaveIds[], Map<String, Object> options) throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeLeave.WHO_PROPERTY, employee.getId());
    key.put(EmployeeLeave.ID_PROPERTY, employeeLeaveIds);

    SmartList<EmployeeLeave> externalEmployeeLeaveList =
        getEmployeeLeaveDAO().findEmployeeLeaveWithKey(key, options);
    if (externalEmployeeLeaveList == null) {
      return employee;
    }
    if (externalEmployeeLeaveList.isEmpty()) {
      return employee;
    }

    for (EmployeeLeave employeeLeaveItem : externalEmployeeLeaveList) {

      employeeLeaveItem.clearFromAll();
    }

    SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
    employeeLeaveList.addAllToRemoveList(externalEmployeeLeaveList);
    return employee;
  }

  // disconnect Employee with type in EmployeeLeave
  public Employee planToRemoveEmployeeLeaveListWithType(
      Employee employee, String typeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeLeave.WHO_PROPERTY, employee.getId());
    key.put(EmployeeLeave.TYPE_PROPERTY, typeId);

    SmartList<EmployeeLeave> externalEmployeeLeaveList =
        getEmployeeLeaveDAO().findEmployeeLeaveWithKey(key, options);
    if (externalEmployeeLeaveList == null) {
      return employee;
    }
    if (externalEmployeeLeaveList.isEmpty()) {
      return employee;
    }

    for (EmployeeLeave employeeLeaveItem : externalEmployeeLeaveList) {
      employeeLeaveItem.clearType();
      employeeLeaveItem.clearWho();
    }

    SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
    employeeLeaveList.addAllToRemoveList(externalEmployeeLeaveList);
    return employee;
  }

  public int countEmployeeLeaveListWithType(
      String employeeId, String typeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeLeave.WHO_PROPERTY, employeeId);
    key.put(EmployeeLeave.TYPE_PROPERTY, typeId);

    int count = getEmployeeLeaveDAO().countEmployeeLeaveWithKey(key, options);
    return count;
  }

  public Employee planToRemoveEmployeeInterviewList(
      Employee employee, String employeeInterviewIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeInterview.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeInterview.ID_PROPERTY, employeeInterviewIds);

    SmartList<EmployeeInterview> externalEmployeeInterviewList =
        getEmployeeInterviewDAO().findEmployeeInterviewWithKey(key, options);
    if (externalEmployeeInterviewList == null) {
      return employee;
    }
    if (externalEmployeeInterviewList.isEmpty()) {
      return employee;
    }

    for (EmployeeInterview employeeInterviewItem : externalEmployeeInterviewList) {

      employeeInterviewItem.clearFromAll();
    }

    SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
    employeeInterviewList.addAllToRemoveList(externalEmployeeInterviewList);
    return employee;
  }

  // disconnect Employee with interview_type in EmployeeInterview
  public Employee planToRemoveEmployeeInterviewListWithInterviewType(
      Employee employee, String interviewTypeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeInterview.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, interviewTypeId);

    SmartList<EmployeeInterview> externalEmployeeInterviewList =
        getEmployeeInterviewDAO().findEmployeeInterviewWithKey(key, options);
    if (externalEmployeeInterviewList == null) {
      return employee;
    }
    if (externalEmployeeInterviewList.isEmpty()) {
      return employee;
    }

    for (EmployeeInterview employeeInterviewItem : externalEmployeeInterviewList) {
      employeeInterviewItem.clearInterviewType();
      employeeInterviewItem.clearEmployee();
    }

    SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
    employeeInterviewList.addAllToRemoveList(externalEmployeeInterviewList);
    return employee;
  }

  public int countEmployeeInterviewListWithInterviewType(
      String employeeId, String interviewTypeId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeInterview.EMPLOYEE_PROPERTY, employeeId);
    key.put(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, interviewTypeId);

    int count = getEmployeeInterviewDAO().countEmployeeInterviewWithKey(key, options);
    return count;
  }

  public Employee planToRemoveEmployeeAttendanceList(
      Employee employee, String employeeAttendanceIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeAttendance.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeAttendance.ID_PROPERTY, employeeAttendanceIds);

    SmartList<EmployeeAttendance> externalEmployeeAttendanceList =
        getEmployeeAttendanceDAO().findEmployeeAttendanceWithKey(key, options);
    if (externalEmployeeAttendanceList == null) {
      return employee;
    }
    if (externalEmployeeAttendanceList.isEmpty()) {
      return employee;
    }

    for (EmployeeAttendance employeeAttendanceItem : externalEmployeeAttendanceList) {

      employeeAttendanceItem.clearFromAll();
    }

    SmartList<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();
    employeeAttendanceList.addAllToRemoveList(externalEmployeeAttendanceList);
    return employee;
  }

  public Employee planToRemoveEmployeeQualifierList(
      Employee employee, String employeeQualifierIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeQualifier.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeQualifier.ID_PROPERTY, employeeQualifierIds);

    SmartList<EmployeeQualifier> externalEmployeeQualifierList =
        getEmployeeQualifierDAO().findEmployeeQualifierWithKey(key, options);
    if (externalEmployeeQualifierList == null) {
      return employee;
    }
    if (externalEmployeeQualifierList.isEmpty()) {
      return employee;
    }

    for (EmployeeQualifier employeeQualifierItem : externalEmployeeQualifierList) {

      employeeQualifierItem.clearFromAll();
    }

    SmartList<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();
    employeeQualifierList.addAllToRemoveList(externalEmployeeQualifierList);
    return employee;
  }

  public Employee planToRemoveEmployeeEducationList(
      Employee employee, String employeeEducationIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeEducation.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeEducation.ID_PROPERTY, employeeEducationIds);

    SmartList<EmployeeEducation> externalEmployeeEducationList =
        getEmployeeEducationDAO().findEmployeeEducationWithKey(key, options);
    if (externalEmployeeEducationList == null) {
      return employee;
    }
    if (externalEmployeeEducationList.isEmpty()) {
      return employee;
    }

    for (EmployeeEducation employeeEducationItem : externalEmployeeEducationList) {

      employeeEducationItem.clearFromAll();
    }

    SmartList<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();
    employeeEducationList.addAllToRemoveList(externalEmployeeEducationList);
    return employee;
  }

  public Employee planToRemoveEmployeeAwardList(
      Employee employee, String employeeAwardIds[], Map<String, Object> options) throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeAward.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeAward.ID_PROPERTY, employeeAwardIds);

    SmartList<EmployeeAward> externalEmployeeAwardList =
        getEmployeeAwardDAO().findEmployeeAwardWithKey(key, options);
    if (externalEmployeeAwardList == null) {
      return employee;
    }
    if (externalEmployeeAwardList.isEmpty()) {
      return employee;
    }

    for (EmployeeAward employeeAwardItem : externalEmployeeAwardList) {

      employeeAwardItem.clearFromAll();
    }

    SmartList<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();
    employeeAwardList.addAllToRemoveList(externalEmployeeAwardList);
    return employee;
  }

  public Employee planToRemoveEmployeeSalarySheetList(
      Employee employee, String employeeSalarySheetIds[], Map<String, Object> options)
      throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeSalarySheet.ID_PROPERTY, employeeSalarySheetIds);

    SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList =
        getEmployeeSalarySheetDAO().findEmployeeSalarySheetWithKey(key, options);
    if (externalEmployeeSalarySheetList == null) {
      return employee;
    }
    if (externalEmployeeSalarySheetList.isEmpty()) {
      return employee;
    }

    for (EmployeeSalarySheet employeeSalarySheetItem : externalEmployeeSalarySheetList) {

      employeeSalarySheetItem.clearFromAll();
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
    employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
    return employee;
  }

  // disconnect Employee with current_salary_grade in EmployeeSalarySheet
  public Employee planToRemoveEmployeeSalarySheetListWithCurrentSalaryGrade(
      Employee employee, String currentSalaryGradeId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

    SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList =
        getEmployeeSalarySheetDAO().findEmployeeSalarySheetWithKey(key, options);
    if (externalEmployeeSalarySheetList == null) {
      return employee;
    }
    if (externalEmployeeSalarySheetList.isEmpty()) {
      return employee;
    }

    for (EmployeeSalarySheet employeeSalarySheetItem : externalEmployeeSalarySheetList) {
      employeeSalarySheetItem.clearCurrentSalaryGrade();
      employeeSalarySheetItem.clearEmployee();
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
    employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
    return employee;
  }

  public int countEmployeeSalarySheetListWithCurrentSalaryGrade(
      String employeeId, String currentSalaryGradeId, Map<String, Object> options)
      throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeId);
    key.put(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

    int count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetWithKey(key, options);
    return count;
  }

  // disconnect Employee with paying_off in EmployeeSalarySheet
  public Employee planToRemoveEmployeeSalarySheetListWithPayingOff(
      Employee employee, String payingOffId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employee.getId());
    key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOffId);

    SmartList<EmployeeSalarySheet> externalEmployeeSalarySheetList =
        getEmployeeSalarySheetDAO().findEmployeeSalarySheetWithKey(key, options);
    if (externalEmployeeSalarySheetList == null) {
      return employee;
    }
    if (externalEmployeeSalarySheetList.isEmpty()) {
      return employee;
    }

    for (EmployeeSalarySheet employeeSalarySheetItem : externalEmployeeSalarySheetList) {
      employeeSalarySheetItem.clearPayingOff();
      employeeSalarySheetItem.clearEmployee();
    }

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
    employeeSalarySheetList.addAllToRemoveList(externalEmployeeSalarySheetList);
    return employee;
  }

  public int countEmployeeSalarySheetListWithPayingOff(
      String employeeId, String payingOffId, Map<String, Object> options) throws Exception {
    // SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
    // the list will not be null here, empty, maybe
    // getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(EmployeeSalarySheet.EMPLOYEE_PROPERTY, employeeId);
    key.put(EmployeeSalarySheet.PAYING_OFF_PROPERTY, payingOffId);

    int count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetWithKey(key, options);
    return count;
  }

  public Employee planToRemovePayingOffList(
      Employee employee, String payingOffIds[], Map<String, Object> options) throws Exception {

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(PayingOff.PAID_FOR_PROPERTY, employee.getId());
    key.put(PayingOff.ID_PROPERTY, payingOffIds);

    SmartList<PayingOff> externalPayingOffList =
        getPayingOffDAO().findPayingOffWithKey(key, options);
    if (externalPayingOffList == null) {
      return employee;
    }
    if (externalPayingOffList.isEmpty()) {
      return employee;
    }

    for (PayingOff payingOffItem : externalPayingOffList) {

      payingOffItem.clearFromAll();
    }

    SmartList<PayingOff> payingOffList = employee.getPayingOffList();
    payingOffList.addAllToRemoveList(externalPayingOffList);
    return employee;
  }

  protected Employee saveEmployeeCompanyTrainingList(
      Employee employee, Map<String, Object> options) {

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        employee.getEmployeeCompanyTrainingList();
    if (employeeCompanyTrainingList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeCompanyTraining> mergedUpdateEmployeeCompanyTrainingList =
        new SmartList<EmployeeCompanyTraining>();

    mergedUpdateEmployeeCompanyTrainingList.addAll(employeeCompanyTrainingList);
    if (employeeCompanyTrainingList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeCompanyTrainingList.addAll(employeeCompanyTrainingList.getToRemoveList());
      employeeCompanyTrainingList.removeAll(employeeCompanyTrainingList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeCompanyTrainingDAO()
        .saveEmployeeCompanyTrainingList(mergedUpdateEmployeeCompanyTrainingList, options);

    if (employeeCompanyTrainingList.getToRemoveList() != null) {
      employeeCompanyTrainingList.removeAll(employeeCompanyTrainingList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeCompanyTrainingList(
      Employee employee, Map<String, Object> options) {

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        employee.getEmployeeCompanyTrainingList();
    if (employeeCompanyTrainingList == null) {
      return employee;
    }

    SmartList<EmployeeCompanyTraining> toRemoveEmployeeCompanyTrainingList =
        employeeCompanyTrainingList.getToRemoveList();

    if (toRemoveEmployeeCompanyTrainingList == null) {
      return employee;
    }
    if (toRemoveEmployeeCompanyTrainingList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeCompanyTrainingDAO()
        .removeEmployeeCompanyTrainingList(toRemoveEmployeeCompanyTrainingList, options);

    return employee;
  }

  protected Employee saveEmployeeSkillList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
    if (employeeSkillList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeSkill> mergedUpdateEmployeeSkillList = new SmartList<EmployeeSkill>();

    mergedUpdateEmployeeSkillList.addAll(employeeSkillList);
    if (employeeSkillList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeSkillList.addAll(employeeSkillList.getToRemoveList());
      employeeSkillList.removeAll(employeeSkillList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeSkillDAO().saveEmployeeSkillList(mergedUpdateEmployeeSkillList, options);

    if (employeeSkillList.getToRemoveList() != null) {
      employeeSkillList.removeAll(employeeSkillList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeSkillList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
    if (employeeSkillList == null) {
      return employee;
    }

    SmartList<EmployeeSkill> toRemoveEmployeeSkillList = employeeSkillList.getToRemoveList();

    if (toRemoveEmployeeSkillList == null) {
      return employee;
    }
    if (toRemoveEmployeeSkillList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeSkillDAO().removeEmployeeSkillList(toRemoveEmployeeSkillList, options);

    return employee;
  }

  protected Employee saveEmployeePerformanceList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();
    if (employeePerformanceList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeePerformance> mergedUpdateEmployeePerformanceList =
        new SmartList<EmployeePerformance>();

    mergedUpdateEmployeePerformanceList.addAll(employeePerformanceList);
    if (employeePerformanceList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeePerformanceList.addAll(employeePerformanceList.getToRemoveList());
      employeePerformanceList.removeAll(employeePerformanceList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeePerformanceDAO()
        .saveEmployeePerformanceList(mergedUpdateEmployeePerformanceList, options);

    if (employeePerformanceList.getToRemoveList() != null) {
      employeePerformanceList.removeAll(employeePerformanceList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeePerformanceList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();
    if (employeePerformanceList == null) {
      return employee;
    }

    SmartList<EmployeePerformance> toRemoveEmployeePerformanceList =
        employeePerformanceList.getToRemoveList();

    if (toRemoveEmployeePerformanceList == null) {
      return employee;
    }
    if (toRemoveEmployeePerformanceList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeePerformanceDAO()
        .removeEmployeePerformanceList(toRemoveEmployeePerformanceList, options);

    return employee;
  }

  protected Employee saveEmployeeWorkExperienceList(
      Employee employee, Map<String, Object> options) {

    SmartList<EmployeeWorkExperience> employeeWorkExperienceList =
        employee.getEmployeeWorkExperienceList();
    if (employeeWorkExperienceList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeWorkExperience> mergedUpdateEmployeeWorkExperienceList =
        new SmartList<EmployeeWorkExperience>();

    mergedUpdateEmployeeWorkExperienceList.addAll(employeeWorkExperienceList);
    if (employeeWorkExperienceList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeWorkExperienceList.addAll(employeeWorkExperienceList.getToRemoveList());
      employeeWorkExperienceList.removeAll(employeeWorkExperienceList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeWorkExperienceDAO()
        .saveEmployeeWorkExperienceList(mergedUpdateEmployeeWorkExperienceList, options);

    if (employeeWorkExperienceList.getToRemoveList() != null) {
      employeeWorkExperienceList.removeAll(employeeWorkExperienceList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeWorkExperienceList(
      Employee employee, Map<String, Object> options) {

    SmartList<EmployeeWorkExperience> employeeWorkExperienceList =
        employee.getEmployeeWorkExperienceList();
    if (employeeWorkExperienceList == null) {
      return employee;
    }

    SmartList<EmployeeWorkExperience> toRemoveEmployeeWorkExperienceList =
        employeeWorkExperienceList.getToRemoveList();

    if (toRemoveEmployeeWorkExperienceList == null) {
      return employee;
    }
    if (toRemoveEmployeeWorkExperienceList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeWorkExperienceDAO()
        .removeEmployeeWorkExperienceList(toRemoveEmployeeWorkExperienceList, options);

    return employee;
  }

  protected Employee saveEmployeeLeaveList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
    if (employeeLeaveList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeLeave> mergedUpdateEmployeeLeaveList = new SmartList<EmployeeLeave>();

    mergedUpdateEmployeeLeaveList.addAll(employeeLeaveList);
    if (employeeLeaveList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeLeaveList.addAll(employeeLeaveList.getToRemoveList());
      employeeLeaveList.removeAll(employeeLeaveList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeLeaveDAO().saveEmployeeLeaveList(mergedUpdateEmployeeLeaveList, options);

    if (employeeLeaveList.getToRemoveList() != null) {
      employeeLeaveList.removeAll(employeeLeaveList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeLeaveList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
    if (employeeLeaveList == null) {
      return employee;
    }

    SmartList<EmployeeLeave> toRemoveEmployeeLeaveList = employeeLeaveList.getToRemoveList();

    if (toRemoveEmployeeLeaveList == null) {
      return employee;
    }
    if (toRemoveEmployeeLeaveList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeLeaveDAO().removeEmployeeLeaveList(toRemoveEmployeeLeaveList, options);

    return employee;
  }

  protected Employee saveEmployeeInterviewList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
    if (employeeInterviewList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeInterview> mergedUpdateEmployeeInterviewList =
        new SmartList<EmployeeInterview>();

    mergedUpdateEmployeeInterviewList.addAll(employeeInterviewList);
    if (employeeInterviewList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeInterviewList.addAll(employeeInterviewList.getToRemoveList());
      employeeInterviewList.removeAll(employeeInterviewList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeInterviewDAO().saveEmployeeInterviewList(mergedUpdateEmployeeInterviewList, options);

    if (employeeInterviewList.getToRemoveList() != null) {
      employeeInterviewList.removeAll(employeeInterviewList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeInterviewList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
    if (employeeInterviewList == null) {
      return employee;
    }

    SmartList<EmployeeInterview> toRemoveEmployeeInterviewList =
        employeeInterviewList.getToRemoveList();

    if (toRemoveEmployeeInterviewList == null) {
      return employee;
    }
    if (toRemoveEmployeeInterviewList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeInterviewDAO().removeEmployeeInterviewList(toRemoveEmployeeInterviewList, options);

    return employee;
  }

  protected Employee saveEmployeeAttendanceList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();
    if (employeeAttendanceList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeAttendance> mergedUpdateEmployeeAttendanceList =
        new SmartList<EmployeeAttendance>();

    mergedUpdateEmployeeAttendanceList.addAll(employeeAttendanceList);
    if (employeeAttendanceList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeAttendanceList.addAll(employeeAttendanceList.getToRemoveList());
      employeeAttendanceList.removeAll(employeeAttendanceList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeAttendanceDAO()
        .saveEmployeeAttendanceList(mergedUpdateEmployeeAttendanceList, options);

    if (employeeAttendanceList.getToRemoveList() != null) {
      employeeAttendanceList.removeAll(employeeAttendanceList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeAttendanceList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();
    if (employeeAttendanceList == null) {
      return employee;
    }

    SmartList<EmployeeAttendance> toRemoveEmployeeAttendanceList =
        employeeAttendanceList.getToRemoveList();

    if (toRemoveEmployeeAttendanceList == null) {
      return employee;
    }
    if (toRemoveEmployeeAttendanceList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeAttendanceDAO()
        .removeEmployeeAttendanceList(toRemoveEmployeeAttendanceList, options);

    return employee;
  }

  protected Employee saveEmployeeQualifierList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();
    if (employeeQualifierList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeQualifier> mergedUpdateEmployeeQualifierList =
        new SmartList<EmployeeQualifier>();

    mergedUpdateEmployeeQualifierList.addAll(employeeQualifierList);
    if (employeeQualifierList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeQualifierList.addAll(employeeQualifierList.getToRemoveList());
      employeeQualifierList.removeAll(employeeQualifierList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeQualifierDAO().saveEmployeeQualifierList(mergedUpdateEmployeeQualifierList, options);

    if (employeeQualifierList.getToRemoveList() != null) {
      employeeQualifierList.removeAll(employeeQualifierList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeQualifierList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();
    if (employeeQualifierList == null) {
      return employee;
    }

    SmartList<EmployeeQualifier> toRemoveEmployeeQualifierList =
        employeeQualifierList.getToRemoveList();

    if (toRemoveEmployeeQualifierList == null) {
      return employee;
    }
    if (toRemoveEmployeeQualifierList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeQualifierDAO().removeEmployeeQualifierList(toRemoveEmployeeQualifierList, options);

    return employee;
  }

  protected Employee saveEmployeeEducationList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();
    if (employeeEducationList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeEducation> mergedUpdateEmployeeEducationList =
        new SmartList<EmployeeEducation>();

    mergedUpdateEmployeeEducationList.addAll(employeeEducationList);
    if (employeeEducationList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeEducationList.addAll(employeeEducationList.getToRemoveList());
      employeeEducationList.removeAll(employeeEducationList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeEducationDAO().saveEmployeeEducationList(mergedUpdateEmployeeEducationList, options);

    if (employeeEducationList.getToRemoveList() != null) {
      employeeEducationList.removeAll(employeeEducationList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeEducationList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();
    if (employeeEducationList == null) {
      return employee;
    }

    SmartList<EmployeeEducation> toRemoveEmployeeEducationList =
        employeeEducationList.getToRemoveList();

    if (toRemoveEmployeeEducationList == null) {
      return employee;
    }
    if (toRemoveEmployeeEducationList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeEducationDAO().removeEmployeeEducationList(toRemoveEmployeeEducationList, options);

    return employee;
  }

  protected Employee saveEmployeeAwardList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();
    if (employeeAwardList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeAward> mergedUpdateEmployeeAwardList = new SmartList<EmployeeAward>();

    mergedUpdateEmployeeAwardList.addAll(employeeAwardList);
    if (employeeAwardList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeAwardList.addAll(employeeAwardList.getToRemoveList());
      employeeAwardList.removeAll(employeeAwardList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeAwardDAO().saveEmployeeAwardList(mergedUpdateEmployeeAwardList, options);

    if (employeeAwardList.getToRemoveList() != null) {
      employeeAwardList.removeAll(employeeAwardList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeAwardList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();
    if (employeeAwardList == null) {
      return employee;
    }

    SmartList<EmployeeAward> toRemoveEmployeeAwardList = employeeAwardList.getToRemoveList();

    if (toRemoveEmployeeAwardList == null) {
      return employee;
    }
    if (toRemoveEmployeeAwardList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeAwardDAO().removeEmployeeAwardList(toRemoveEmployeeAwardList, options);

    return employee;
  }

  protected Employee saveEmployeeSalarySheetList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
    if (employeeSalarySheetList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<EmployeeSalarySheet> mergedUpdateEmployeeSalarySheetList =
        new SmartList<EmployeeSalarySheet>();

    mergedUpdateEmployeeSalarySheetList.addAll(employeeSalarySheetList);
    if (employeeSalarySheetList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdateEmployeeSalarySheetList.addAll(employeeSalarySheetList.getToRemoveList());
      employeeSalarySheetList.removeAll(employeeSalarySheetList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getEmployeeSalarySheetDAO()
        .saveEmployeeSalarySheetList(mergedUpdateEmployeeSalarySheetList, options);

    if (employeeSalarySheetList.getToRemoveList() != null) {
      employeeSalarySheetList.removeAll(employeeSalarySheetList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removeEmployeeSalarySheetList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
    if (employeeSalarySheetList == null) {
      return employee;
    }

    SmartList<EmployeeSalarySheet> toRemoveEmployeeSalarySheetList =
        employeeSalarySheetList.getToRemoveList();

    if (toRemoveEmployeeSalarySheetList == null) {
      return employee;
    }
    if (toRemoveEmployeeSalarySheetList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getEmployeeSalarySheetDAO()
        .removeEmployeeSalarySheetList(toRemoveEmployeeSalarySheetList, options);

    return employee;
  }

  protected Employee savePayingOffList(Employee employee, Map<String, Object> options) {

    SmartList<PayingOff> payingOffList = employee.getPayingOffList();
    if (payingOffList == null) {
      // null list means nothing
      return employee;
    }
    SmartList<PayingOff> mergedUpdatePayingOffList = new SmartList<PayingOff>();

    mergedUpdatePayingOffList.addAll(payingOffList);
    if (payingOffList.getToRemoveList() != null) {
      // ensures the toRemoveList is not null
      mergedUpdatePayingOffList.addAll(payingOffList.getToRemoveList());
      payingOffList.removeAll(payingOffList.getToRemoveList());
      // OK for now, need fix later
    }

    // adding new size can improve performance

    getPayingOffDAO().savePayingOffList(mergedUpdatePayingOffList, options);

    if (payingOffList.getToRemoveList() != null) {
      payingOffList.removeAll(payingOffList.getToRemoveList());
    }

    return employee;
  }

  protected Employee removePayingOffList(Employee employee, Map<String, Object> options) {

    SmartList<PayingOff> payingOffList = employee.getPayingOffList();
    if (payingOffList == null) {
      return employee;
    }

    SmartList<PayingOff> toRemovePayingOffList = payingOffList.getToRemoveList();

    if (toRemovePayingOffList == null) {
      return employee;
    }
    if (toRemovePayingOffList.isEmpty()) {
      return employee; // Does this mean delete all from the parent object?
    }
    // Call DAO to remove the list

    getPayingOffDAO().removePayingOffList(toRemovePayingOffList, options);

    return employee;
  }

  public Employee present(Employee employee, Map<String, Object> options) {

    presentEmployeeCompanyTrainingList(employee, options);
    presentEmployeeSkillList(employee, options);
    presentEmployeePerformanceList(employee, options);
    presentEmployeeWorkExperienceList(employee, options);
    presentEmployeeLeaveList(employee, options);
    presentEmployeeInterviewList(employee, options);
    presentEmployeeAttendanceList(employee, options);
    presentEmployeeQualifierList(employee, options);
    presentEmployeeEducationList(employee, options);
    presentEmployeeAwardList(employee, options);
    presentEmployeeSalarySheetList(employee, options);
    presentPayingOffList(employee, options);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeCompanyTrainingList(
      Employee employee, Map<String, Object> options) {

    SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList =
        employee.getEmployeeCompanyTrainingList();
    SmartList<EmployeeCompanyTraining> newList =
        presentSubList(
            employee.getId(),
            employeeCompanyTrainingList,
            options,
            getEmployeeCompanyTrainingDAO()::countEmployeeCompanyTrainingByEmployee,
            getEmployeeCompanyTrainingDAO()::findEmployeeCompanyTrainingByEmployee);

    employee.setEmployeeCompanyTrainingList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeSkillList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeSkill> employeeSkillList = employee.getEmployeeSkillList();
    SmartList<EmployeeSkill> newList =
        presentSubList(
            employee.getId(),
            employeeSkillList,
            options,
            getEmployeeSkillDAO()::countEmployeeSkillByEmployee,
            getEmployeeSkillDAO()::findEmployeeSkillByEmployee);

    employee.setEmployeeSkillList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeePerformanceList(
      Employee employee, Map<String, Object> options) {

    SmartList<EmployeePerformance> employeePerformanceList = employee.getEmployeePerformanceList();
    SmartList<EmployeePerformance> newList =
        presentSubList(
            employee.getId(),
            employeePerformanceList,
            options,
            getEmployeePerformanceDAO()::countEmployeePerformanceByEmployee,
            getEmployeePerformanceDAO()::findEmployeePerformanceByEmployee);

    employee.setEmployeePerformanceList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeWorkExperienceList(
      Employee employee, Map<String, Object> options) {

    SmartList<EmployeeWorkExperience> employeeWorkExperienceList =
        employee.getEmployeeWorkExperienceList();
    SmartList<EmployeeWorkExperience> newList =
        presentSubList(
            employee.getId(),
            employeeWorkExperienceList,
            options,
            getEmployeeWorkExperienceDAO()::countEmployeeWorkExperienceByEmployee,
            getEmployeeWorkExperienceDAO()::findEmployeeWorkExperienceByEmployee);

    employee.setEmployeeWorkExperienceList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeLeaveList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeLeave> employeeLeaveList = employee.getEmployeeLeaveList();
    SmartList<EmployeeLeave> newList =
        presentSubList(
            employee.getId(),
            employeeLeaveList,
            options,
            getEmployeeLeaveDAO()::countEmployeeLeaveByWho,
            getEmployeeLeaveDAO()::findEmployeeLeaveByWho);

    employee.setEmployeeLeaveList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeInterviewList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeInterview> employeeInterviewList = employee.getEmployeeInterviewList();
    SmartList<EmployeeInterview> newList =
        presentSubList(
            employee.getId(),
            employeeInterviewList,
            options,
            getEmployeeInterviewDAO()::countEmployeeInterviewByEmployee,
            getEmployeeInterviewDAO()::findEmployeeInterviewByEmployee);

    employee.setEmployeeInterviewList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeAttendanceList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeAttendance> employeeAttendanceList = employee.getEmployeeAttendanceList();
    SmartList<EmployeeAttendance> newList =
        presentSubList(
            employee.getId(),
            employeeAttendanceList,
            options,
            getEmployeeAttendanceDAO()::countEmployeeAttendanceByEmployee,
            getEmployeeAttendanceDAO()::findEmployeeAttendanceByEmployee);

    employee.setEmployeeAttendanceList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeQualifierList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeQualifier> employeeQualifierList = employee.getEmployeeQualifierList();
    SmartList<EmployeeQualifier> newList =
        presentSubList(
            employee.getId(),
            employeeQualifierList,
            options,
            getEmployeeQualifierDAO()::countEmployeeQualifierByEmployee,
            getEmployeeQualifierDAO()::findEmployeeQualifierByEmployee);

    employee.setEmployeeQualifierList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeEducationList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeEducation> employeeEducationList = employee.getEmployeeEducationList();
    SmartList<EmployeeEducation> newList =
        presentSubList(
            employee.getId(),
            employeeEducationList,
            options,
            getEmployeeEducationDAO()::countEmployeeEducationByEmployee,
            getEmployeeEducationDAO()::findEmployeeEducationByEmployee);

    employee.setEmployeeEducationList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeAwardList(Employee employee, Map<String, Object> options) {

    SmartList<EmployeeAward> employeeAwardList = employee.getEmployeeAwardList();
    SmartList<EmployeeAward> newList =
        presentSubList(
            employee.getId(),
            employeeAwardList,
            options,
            getEmployeeAwardDAO()::countEmployeeAwardByEmployee,
            getEmployeeAwardDAO()::findEmployeeAwardByEmployee);

    employee.setEmployeeAwardList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentEmployeeSalarySheetList(
      Employee employee, Map<String, Object> options) {

    SmartList<EmployeeSalarySheet> employeeSalarySheetList = employee.getEmployeeSalarySheetList();
    SmartList<EmployeeSalarySheet> newList =
        presentSubList(
            employee.getId(),
            employeeSalarySheetList,
            options,
            getEmployeeSalarySheetDAO()::countEmployeeSalarySheetByEmployee,
            getEmployeeSalarySheetDAO()::findEmployeeSalarySheetByEmployee);

    employee.setEmployeeSalarySheetList(newList);

    return employee;
  }

  // Using java8 feature to reduce the code significantly
  protected Employee presentPayingOffList(Employee employee, Map<String, Object> options) {

    SmartList<PayingOff> payingOffList = employee.getPayingOffList();
    SmartList<PayingOff> newList =
        presentSubList(
            employee.getId(),
            payingOffList,
            options,
            getPayingOffDAO()::countPayingOffByPaidFor,
            getPayingOffDAO()::findPayingOffByPaidFor);

    employee.setPayingOffList(newList);

    return employee;
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeCompanyTraining(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeSkill(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeePerformance(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeWorkExperience(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeLeave(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeInterview(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeAttendance(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeQualifier(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeEducation(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeAward(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForEmployeeSalarySheet(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  public SmartList<Employee> requestCandidateEmployeeForPayingOff(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception {
    // NOTE: by default, ignore owner info, just return all by filter key.
    // You need override this method if you have different candidate-logic
    return findAllCandidateByFilter(
        EmployeeTable.COLUMN_COMPANY,
        EmployeeTable.COLUMN_COMPANY,
        filterKey,
        pageNo,
        pageSize,
        getEmployeeMapper());
  }

  protected String getTableName() {
    return EmployeeTable.TABLE_NAME;
  }

  public void enhanceList(List<Employee> employeeList) {
    this.enhanceListInternal(employeeList, this.getEmployeeMapper());
  }

  @Override
  public void collectAndEnhance(BaseEntity ownerEntity) {
    List<Employee> employeeList = ownerEntity.collectRefsWithType(Employee.INTERNAL_TYPE);
    this.enhanceList(employeeList);
  }

  @Override
  public SmartList<Employee> findEmployeeWithKey(
      MultipleAccessKey key, Map<String, Object> options) {

    return queryWith(key, options, getEmployeeMapper());
  }

  @Override
  public int countEmployeeWithKey(MultipleAccessKey key, Map<String, Object> options) {

    return countWith(key, options);
  }

  public Map<String, Integer> countEmployeeWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options) {

    return countWithGroup(groupKey, filterKey, options);
  }

  @Override
  public SmartList<Employee> queryList(String sql, Object... parameters) {
    return this.queryForList(sql, parameters, this.getEmployeeMapper());
  }

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }

  @Override
  public Stream<Employee> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getEmployeeMapper());
  }

  @Override
  public int count(String sql, Object... parameters) {
    return queryInt(sql, parameters);
  }

  @Override
  public CandidateEmployee executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception {

    CandidateEmployee result = new CandidateEmployee();
    int pageNo = Math.max(1, query.getPageNo());
    result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
    result.setOwnerId(query.getOwnerId());
    result.setFilterKey(query.getFilterKey());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
    result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

    SmartList candidateList = queryList(sql, parmeters);
    this.alias(candidateList);
    result.setCandidates(candidateList);
    int offSet = (pageNo - 1) * query.getPageSize();
    if (candidateList.size() > query.getPageSize()) {
      result.setTotalPage(pageNo + 1);
    } else {
      result.setTotalPage(pageNo);
    }
    return result;
  }

  @Override
  public List<Employee> search(EmployeeRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected EmployeeMapper mapper() {
    return getEmployeeMapper();
  }

  @Override
  protected EmployeeMapper mapperForClazz(Class<?> clazz) {
    return EmployeeMapper.mapperForClass(clazz);
  }
}
