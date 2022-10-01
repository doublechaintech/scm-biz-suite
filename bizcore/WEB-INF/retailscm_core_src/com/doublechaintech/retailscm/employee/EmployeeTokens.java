package com.doublechaintech.retailscm.employee;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentTokens;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeTokens;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeTokens;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeTokens;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingTokens;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillTokens;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceTokens;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceTokens;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveTokens;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewTokens;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceTokens;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierTokens;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducationTokens;
import com.doublechaintech.retailscm.employeeaward.EmployeeAwardTokens;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetTokens;
import com.doublechaintech.retailscm.payingoff.PayingOffTokens;

public class EmployeeTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "employee";

  public static boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    if (options == null) {
      return false; // completely no option here
    }
    if (options.containsKey(ALL)) {
      // danger, debug only, might load the entire database!, really terrible
      return true;
    }
    String ownerKey = getOwnerObjectKey();
    Object ownerObject = (String) options.get(ownerKey);
    if (ownerObject == null) {
      return false;
    }
    if (!ownerObject.equals(OWNER_OBJECT_NAME)) { // is the owner?
      return false;
    }

    if (options.containsKey(optionToCheck)) {
      // options.remove(optionToCheck);
      // consume the key, can not use any more to extract the data with the same token.
      return true;
    }

    return false;
  }

  protected EmployeeTokens() {
    // ensure not initialized outside the class
  }

  public static EmployeeTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    EmployeeTokens tokens = new EmployeeTokens(options);
    return tokens;
  }

  protected EmployeeTokens(Map<String, Object> options) {
    this.options = options;
  }

  public EmployeeTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static EmployeeTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected EmployeeTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static EmployeeTokens start() {
    return new EmployeeTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public EmployeeTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static EmployeeTokens loadGroupTokens(String... groupNames) {
    EmployeeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[] {"default"});
    addToken(tokens, DEPARTMENT, groupNames, new String[] {"default"});
    addToken(tokens, OCCUPATION, groupNames, new String[] {"default"});
    addToken(tokens, RESPONSIBLEFOR, groupNames, new String[] {"default"});
    addToken(tokens, CURRENTSALARYGRADE, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_COMPANY_TRAINING_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_SKILL_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_PERFORMANCE_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_WORK_EXPERIENCE_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_LEAVE_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_INTERVIEW_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_ATTENDANCE_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_QUALIFIER_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_EDUCATION_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_AWARD_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_SALARY_SHEET_LIST, groupNames, new String[] {"default"});

    addToken(tokens, PAYING_OFF_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      EmployeeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null) {
      return;
    }

    for (String groupName : pGroupNames) {
      for (String g : fieldGroups) {
        if (Objects.equals(groupName, g)) {
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

  public static EmployeeTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withCompany()
        .withDepartment()
        .withOccupation()
        .withResponsibleFor()
        .withCurrentSalaryGrade()
        .withEmployeeCompanyTrainingListIfViewGroupInclude(viewGroups)
        .withEmployeeSkillListIfViewGroupInclude(viewGroups)
        .withEmployeePerformanceListIfViewGroupInclude(viewGroups)
        .withEmployeeWorkExperienceListIfViewGroupInclude(viewGroups)
        .withEmployeeLeaveListIfViewGroupInclude(viewGroups)
        .withEmployeeInterviewListIfViewGroupInclude(viewGroups)
        .withEmployeeAttendanceListIfViewGroupInclude(viewGroups)
        .withEmployeeQualifierListIfViewGroupInclude(viewGroups)
        .withEmployeeEducationListIfViewGroupInclude(viewGroups)
        .withEmployeeAwardListIfViewGroupInclude(viewGroups)
        .withEmployeeSalarySheetListIfViewGroupInclude(viewGroups)
        .withPayingOffListIfViewGroupInclude(viewGroups);
  }

  public static EmployeeTokens allTokens() {

    return start()
        .withCompany()
        .withDepartment()
        .withOccupation()
        .withResponsibleFor()
        .withCurrentSalaryGrade()
        .withEmployeeCompanyTrainingList()
        .withEmployeeSkillList()
        .withEmployeePerformanceList()
        .withEmployeeWorkExperienceList()
        .withEmployeeLeaveList()
        .withEmployeeInterviewList()
        .withEmployeeAttendanceList()
        .withEmployeeQualifierList()
        .withEmployeeEducationList()
        .withEmployeeAwardList()
        .withEmployeeSalarySheetList()
        .withPayingOffList();
  }

  public static EmployeeTokens withoutListsTokens() {

    return start()
        .withCompany()
        .withDepartment()
        .withOccupation()
        .withResponsibleFor()
        .withCurrentSalaryGrade();
  }

  public static Map<String, Object> all() {
    return allTokens().done();
  }

  public static Map<String, Object> withoutLists() {
    return withoutListsTokens().done();
  }

  public static Map<String, Object> empty() {
    return start().done();
  }

  public EmployeeTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String COMPANY = "company";

  public String getCompany() {
    return COMPANY;
  }
  //
  public EmployeeTokens withCompany() {
    addSimpleOptions(COMPANY);
    return this;
  }

  public RetailStoreCountryCenterTokens withCompanyTokens() {
    // addSimpleOptions(COMPANY);
    return RetailStoreCountryCenterTokens.start();
  }

  protected static final String DEPARTMENT = "department";

  public String getDepartment() {
    return DEPARTMENT;
  }
  //
  public EmployeeTokens withDepartment() {
    addSimpleOptions(DEPARTMENT);
    return this;
  }

  public LevelThreeDepartmentTokens withDepartmentTokens() {
    // addSimpleOptions(DEPARTMENT);
    return LevelThreeDepartmentTokens.start();
  }

  protected static final String OCCUPATION = "occupation";

  public String getOccupation() {
    return OCCUPATION;
  }
  //
  public EmployeeTokens withOccupation() {
    addSimpleOptions(OCCUPATION);
    return this;
  }

  public OccupationTypeTokens withOccupationTokens() {
    // addSimpleOptions(OCCUPATION);
    return OccupationTypeTokens.start();
  }

  protected static final String RESPONSIBLEFOR = "responsibleFor";

  public String getResponsibleFor() {
    return RESPONSIBLEFOR;
  }
  //
  public EmployeeTokens withResponsibleFor() {
    addSimpleOptions(RESPONSIBLEFOR);
    return this;
  }

  public ResponsibilityTypeTokens withResponsibleForTokens() {
    // addSimpleOptions(RESPONSIBLEFOR);
    return ResponsibilityTypeTokens.start();
  }

  protected static final String CURRENTSALARYGRADE = "currentSalaryGrade";

  public String getCurrentSalaryGrade() {
    return CURRENTSALARYGRADE;
  }
  //
  public EmployeeTokens withCurrentSalaryGrade() {
    addSimpleOptions(CURRENTSALARYGRADE);
    return this;
  }

  public SalaryGradeTokens withCurrentSalaryGradeTokens() {
    // addSimpleOptions(CURRENTSALARYGRADE);
    return SalaryGradeTokens.start();
  }

  protected static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";

  public String getEmployeeCompanyTrainingList() {
    return EMPLOYEE_COMPANY_TRAINING_LIST;
  }

  public EmployeeTokens withEmployeeCompanyTrainingListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeCompanyTrainingList() {
    addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST);
    return this;
  }

  public EmployeeCompanyTrainingTokens withEmployeeCompanyTrainingListTokens() {
    // addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST);
    return EmployeeCompanyTrainingTokens.start();
  }

  public EmployeeTokens analyzeEmployeeCompanyTrainingList() {
    addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeCompanyTrainingListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_COMPANY_TRAINING_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeCompanyTrainingList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeCompanyTrainingListSortCounter = 0;

  public EmployeeTokens sortEmployeeCompanyTrainingListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_COMPANY_TRAINING_LIST, employeeCompanyTrainingListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeCompanyTrainingListSearchCounter = 0;

  public EmployeeTokens searchEmployeeCompanyTrainingListWith(
      String field, String verb, String value) {

    withEmployeeCompanyTrainingList();
    addSearchMoreOptions(
        EMPLOYEE_COMPANY_TRAINING_LIST,
        employeeCompanyTrainingListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeCompanyTrainingList(String verb, String value) {
    String field = "id";
    addSearchMoreOptions(
        EMPLOYEE_COMPANY_TRAINING_LIST,
        employeeCompanyTrainingListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeCompanyTrainingList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeCompanyTrainingList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeCompanyTrainingList(String[] columns) {
    addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeCompanyTrainingList(String[] columns) {
    addSimpleOptions(EMPLOYEE_COMPANY_TRAINING_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_SKILL_LIST = "employeeSkillList";

  public String getEmployeeSkillList() {
    return EMPLOYEE_SKILL_LIST;
  }

  public EmployeeTokens withEmployeeSkillListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_SKILL_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeSkillList() {
    addSimpleOptions(EMPLOYEE_SKILL_LIST);
    return this;
  }

  public EmployeeSkillTokens withEmployeeSkillListTokens() {
    // addSimpleOptions(EMPLOYEE_SKILL_LIST);
    return EmployeeSkillTokens.start();
  }

  public EmployeeTokens analyzeEmployeeSkillList() {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeSkillListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_SKILL_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeSkillList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeSkillListSortCounter = 0;

  public EmployeeTokens sortEmployeeSkillListWith(String field, String descOrAsc) {
    addSortMoreOptions(EMPLOYEE_SKILL_LIST, employeeSkillListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeSkillListSearchCounter = 0;

  public EmployeeTokens searchEmployeeSkillListWith(String field, String verb, String value) {

    withEmployeeSkillList();
    addSearchMoreOptions(EMPLOYEE_SKILL_LIST, employeeSkillListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeSkillList(String verb, String value) {
    String field = "id|description";
    addSearchMoreOptions(EMPLOYEE_SKILL_LIST, employeeSkillListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeSkillList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeSkillList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeSkillList(String[] columns) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeSkillList(String[] columns) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_PERFORMANCE_LIST = "employeePerformanceList";

  public String getEmployeePerformanceList() {
    return EMPLOYEE_PERFORMANCE_LIST;
  }

  public EmployeeTokens withEmployeePerformanceListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeePerformanceList() {
    addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST);
    return this;
  }

  public EmployeePerformanceTokens withEmployeePerformanceListTokens() {
    // addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST);
    return EmployeePerformanceTokens.start();
  }

  public EmployeeTokens analyzeEmployeePerformanceList() {
    addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeePerformanceListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_PERFORMANCE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeePerformanceList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeePerformanceListSortCounter = 0;

  public EmployeeTokens sortEmployeePerformanceListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_PERFORMANCE_LIST, employeePerformanceListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeePerformanceListSearchCounter = 0;

  public EmployeeTokens searchEmployeePerformanceListWith(String field, String verb, String value) {

    withEmployeePerformanceList();
    addSearchMoreOptions(
        EMPLOYEE_PERFORMANCE_LIST, employeePerformanceListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeePerformanceList(String verb, String value) {
    String field = "id|performanceComment";
    addSearchMoreOptions(
        EMPLOYEE_PERFORMANCE_LIST, employeePerformanceListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeePerformanceList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeePerformanceList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeePerformanceList(String[] columns) {
    addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeePerformanceList(String[] columns) {
    addSimpleOptions(EMPLOYEE_PERFORMANCE_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_WORK_EXPERIENCE_LIST = "employeeWorkExperienceList";

  public String getEmployeeWorkExperienceList() {
    return EMPLOYEE_WORK_EXPERIENCE_LIST;
  }

  public EmployeeTokens withEmployeeWorkExperienceListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeWorkExperienceList() {
    addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST);
    return this;
  }

  public EmployeeWorkExperienceTokens withEmployeeWorkExperienceListTokens() {
    // addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST);
    return EmployeeWorkExperienceTokens.start();
  }

  public EmployeeTokens analyzeEmployeeWorkExperienceList() {
    addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeWorkExperienceListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_WORK_EXPERIENCE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeWorkExperienceList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeWorkExperienceListSortCounter = 0;

  public EmployeeTokens sortEmployeeWorkExperienceListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_WORK_EXPERIENCE_LIST, employeeWorkExperienceListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeWorkExperienceListSearchCounter = 0;

  public EmployeeTokens searchEmployeeWorkExperienceListWith(
      String field, String verb, String value) {

    withEmployeeWorkExperienceList();
    addSearchMoreOptions(
        EMPLOYEE_WORK_EXPERIENCE_LIST,
        employeeWorkExperienceListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeWorkExperienceList(String verb, String value) {
    String field = "id|company|description";
    addSearchMoreOptions(
        EMPLOYEE_WORK_EXPERIENCE_LIST,
        employeeWorkExperienceListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeWorkExperienceList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeWorkExperienceList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeWorkExperienceList(String[] columns) {
    addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeWorkExperienceList(String[] columns) {
    addSimpleOptions(EMPLOYEE_WORK_EXPERIENCE_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_LEAVE_LIST = "employeeLeaveList";

  public String getEmployeeLeaveList() {
    return EMPLOYEE_LEAVE_LIST;
  }

  public EmployeeTokens withEmployeeLeaveListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_LEAVE_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeLeaveList() {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST);
    return this;
  }

  public EmployeeLeaveTokens withEmployeeLeaveListTokens() {
    // addSimpleOptions(EMPLOYEE_LEAVE_LIST);
    return EmployeeLeaveTokens.start();
  }

  public EmployeeTokens analyzeEmployeeLeaveList() {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeLeaveListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_LEAVE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeLeaveList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeLeaveListSortCounter = 0;

  public EmployeeTokens sortEmployeeLeaveListWith(String field, String descOrAsc) {
    addSortMoreOptions(EMPLOYEE_LEAVE_LIST, employeeLeaveListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeLeaveListSearchCounter = 0;

  public EmployeeTokens searchEmployeeLeaveListWith(String field, String verb, String value) {

    withEmployeeLeaveList();
    addSearchMoreOptions(EMPLOYEE_LEAVE_LIST, employeeLeaveListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeLeaveList(String verb, String value) {
    String field = "id|remark";
    addSearchMoreOptions(EMPLOYEE_LEAVE_LIST, employeeLeaveListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeLeaveList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeLeaveList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeLeaveList(String[] columns) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeLeaveList(String[] columns) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_INTERVIEW_LIST = "employeeInterviewList";

  public String getEmployeeInterviewList() {
    return EMPLOYEE_INTERVIEW_LIST;
  }

  public EmployeeTokens withEmployeeInterviewListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_INTERVIEW_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeInterviewList() {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST);
    return this;
  }

  public EmployeeInterviewTokens withEmployeeInterviewListTokens() {
    // addSimpleOptions(EMPLOYEE_INTERVIEW_LIST);
    return EmployeeInterviewTokens.start();
  }

  public EmployeeTokens analyzeEmployeeInterviewList() {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeInterviewListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_INTERVIEW_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeInterviewList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeInterviewListSortCounter = 0;

  public EmployeeTokens sortEmployeeInterviewListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_INTERVIEW_LIST, employeeInterviewListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeInterviewListSearchCounter = 0;

  public EmployeeTokens searchEmployeeInterviewListWith(String field, String verb, String value) {

    withEmployeeInterviewList();
    addSearchMoreOptions(
        EMPLOYEE_INTERVIEW_LIST, employeeInterviewListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeInterviewList(String verb, String value) {
    String field = "id|remark";
    addSearchMoreOptions(
        EMPLOYEE_INTERVIEW_LIST, employeeInterviewListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeInterviewList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeInterviewList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeInterviewList(String[] columns) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeInterviewList(String[] columns) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_ATTENDANCE_LIST = "employeeAttendanceList";

  public String getEmployeeAttendanceList() {
    return EMPLOYEE_ATTENDANCE_LIST;
  }

  public EmployeeTokens withEmployeeAttendanceListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeAttendanceList() {
    addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST);
    return this;
  }

  public EmployeeAttendanceTokens withEmployeeAttendanceListTokens() {
    // addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST);
    return EmployeeAttendanceTokens.start();
  }

  public EmployeeTokens analyzeEmployeeAttendanceList() {
    addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeAttendanceListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_ATTENDANCE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeAttendanceList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeAttendanceListSortCounter = 0;

  public EmployeeTokens sortEmployeeAttendanceListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_ATTENDANCE_LIST, employeeAttendanceListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeAttendanceListSearchCounter = 0;

  public EmployeeTokens searchEmployeeAttendanceListWith(String field, String verb, String value) {

    withEmployeeAttendanceList();
    addSearchMoreOptions(
        EMPLOYEE_ATTENDANCE_LIST, employeeAttendanceListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeAttendanceList(String verb, String value) {
    String field = "id|remark";
    addSearchMoreOptions(
        EMPLOYEE_ATTENDANCE_LIST, employeeAttendanceListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeAttendanceList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeAttendanceList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeAttendanceList(String[] columns) {
    addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeAttendanceList(String[] columns) {
    addSimpleOptions(EMPLOYEE_ATTENDANCE_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_QUALIFIER_LIST = "employeeQualifierList";

  public String getEmployeeQualifierList() {
    return EMPLOYEE_QUALIFIER_LIST;
  }

  public EmployeeTokens withEmployeeQualifierListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_QUALIFIER_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeQualifierList() {
    addSimpleOptions(EMPLOYEE_QUALIFIER_LIST);
    return this;
  }

  public EmployeeQualifierTokens withEmployeeQualifierListTokens() {
    // addSimpleOptions(EMPLOYEE_QUALIFIER_LIST);
    return EmployeeQualifierTokens.start();
  }

  public EmployeeTokens analyzeEmployeeQualifierList() {
    addSimpleOptions(EMPLOYEE_QUALIFIER_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeQualifierListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_QUALIFIER_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeQualifierList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_QUALIFIER_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeQualifierListSortCounter = 0;

  public EmployeeTokens sortEmployeeQualifierListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_QUALIFIER_LIST, employeeQualifierListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeQualifierListSearchCounter = 0;

  public EmployeeTokens searchEmployeeQualifierListWith(String field, String verb, String value) {

    withEmployeeQualifierList();
    addSearchMoreOptions(
        EMPLOYEE_QUALIFIER_LIST, employeeQualifierListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeQualifierList(String verb, String value) {
    String field = "id|type|level|remark";
    addSearchMoreOptions(
        EMPLOYEE_QUALIFIER_LIST, employeeQualifierListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeQualifierList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_QUALIFIER_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeQualifierList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_QUALIFIER_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeQualifierList(String[] columns) {
    addSimpleOptions(EMPLOYEE_QUALIFIER_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeQualifierList(String[] columns) {
    addSimpleOptions(EMPLOYEE_QUALIFIER_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_EDUCATION_LIST = "employeeEducationList";

  public String getEmployeeEducationList() {
    return EMPLOYEE_EDUCATION_LIST;
  }

  public EmployeeTokens withEmployeeEducationListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_EDUCATION_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeEducationList() {
    addSimpleOptions(EMPLOYEE_EDUCATION_LIST);
    return this;
  }

  public EmployeeEducationTokens withEmployeeEducationListTokens() {
    // addSimpleOptions(EMPLOYEE_EDUCATION_LIST);
    return EmployeeEducationTokens.start();
  }

  public EmployeeTokens analyzeEmployeeEducationList() {
    addSimpleOptions(EMPLOYEE_EDUCATION_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeEducationListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_EDUCATION_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeEducationList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_EDUCATION_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeEducationListSortCounter = 0;

  public EmployeeTokens sortEmployeeEducationListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_EDUCATION_LIST, employeeEducationListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeEducationListSearchCounter = 0;

  public EmployeeTokens searchEmployeeEducationListWith(String field, String verb, String value) {

    withEmployeeEducationList();
    addSearchMoreOptions(
        EMPLOYEE_EDUCATION_LIST, employeeEducationListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeEducationList(String verb, String value) {
    String field = "id|type|remark";
    addSearchMoreOptions(
        EMPLOYEE_EDUCATION_LIST, employeeEducationListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeEducationList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_EDUCATION_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeEducationList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_EDUCATION_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeEducationList(String[] columns) {
    addSimpleOptions(EMPLOYEE_EDUCATION_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeEducationList(String[] columns) {
    addSimpleOptions(EMPLOYEE_EDUCATION_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_AWARD_LIST = "employeeAwardList";

  public String getEmployeeAwardList() {
    return EMPLOYEE_AWARD_LIST;
  }

  public EmployeeTokens withEmployeeAwardListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_AWARD_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeAwardList() {
    addSimpleOptions(EMPLOYEE_AWARD_LIST);
    return this;
  }

  public EmployeeAwardTokens withEmployeeAwardListTokens() {
    // addSimpleOptions(EMPLOYEE_AWARD_LIST);
    return EmployeeAwardTokens.start();
  }

  public EmployeeTokens analyzeEmployeeAwardList() {
    addSimpleOptions(EMPLOYEE_AWARD_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeAwardListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_AWARD_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeAwardList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_AWARD_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeAwardListSortCounter = 0;

  public EmployeeTokens sortEmployeeAwardListWith(String field, String descOrAsc) {
    addSortMoreOptions(EMPLOYEE_AWARD_LIST, employeeAwardListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeAwardListSearchCounter = 0;

  public EmployeeTokens searchEmployeeAwardListWith(String field, String verb, String value) {

    withEmployeeAwardList();
    addSearchMoreOptions(EMPLOYEE_AWARD_LIST, employeeAwardListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeAwardList(String verb, String value) {
    String field = "id|type|remark";
    addSearchMoreOptions(EMPLOYEE_AWARD_LIST, employeeAwardListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeAwardList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_AWARD_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeAwardList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_AWARD_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeAwardList(String[] columns) {
    addSimpleOptions(EMPLOYEE_AWARD_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeAwardList(String[] columns) {
    addSimpleOptions(EMPLOYEE_AWARD_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";

  public String getEmployeeSalarySheetList() {
    return EMPLOYEE_SALARY_SHEET_LIST;
  }

  public EmployeeTokens withEmployeeSalarySheetListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
    }
    return this;
  }

  public EmployeeTokens withEmployeeSalarySheetList() {
    addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
    return this;
  }

  public EmployeeSalarySheetTokens withEmployeeSalarySheetListTokens() {
    // addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST);
    return EmployeeSalarySheetTokens.start();
  }

  public EmployeeTokens analyzeEmployeeSalarySheetList() {
    addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEmployeeSalarySheetListEnabled() {

    if (checkOptions(this.options(), EMPLOYEE_SALARY_SHEET_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromEmployeeSalarySheetList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeSalarySheetListSortCounter = 0;

  public EmployeeTokens sortEmployeeSalarySheetListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_SALARY_SHEET_LIST, employeeSalarySheetListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeSalarySheetListSearchCounter = 0;

  public EmployeeTokens searchEmployeeSalarySheetListWith(String field, String verb, String value) {

    withEmployeeSalarySheetList();
    addSearchMoreOptions(
        EMPLOYEE_SALARY_SHEET_LIST, employeeSalarySheetListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfEmployeeSalarySheetList(String verb, String value) {
    String field = "id";
    addSearchMoreOptions(
        EMPLOYEE_SALARY_SHEET_LIST, employeeSalarySheetListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfEmployeeSalarySheetList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfEmployeeSalarySheetList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfEmployeeSalarySheetList(String[] columns) {
    addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfEmployeeSalarySheetList(String[] columns) {
    addSimpleOptions(EMPLOYEE_SALARY_SHEET_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String PAYING_OFF_LIST = "payingOffList";

  public String getPayingOffList() {
    return PAYING_OFF_LIST;
  }

  public EmployeeTokens withPayingOffListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(PAYING_OFF_LIST);
    }
    return this;
  }

  public EmployeeTokens withPayingOffList() {
    addSimpleOptions(PAYING_OFF_LIST);
    return this;
  }

  public PayingOffTokens withPayingOffListTokens() {
    // addSimpleOptions(PAYING_OFF_LIST);
    return PayingOffTokens.start();
  }

  public EmployeeTokens analyzePayingOffList() {
    addSimpleOptions(PAYING_OFF_LIST + ".anaylze");
    return this;
  }

  public boolean analyzePayingOffListEnabled() {

    if (checkOptions(this.options(), PAYING_OFF_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public EmployeeTokens extractMoreFromPayingOffList(String idsSeperatedWithComma) {
    addSimpleOptions(PAYING_OFF_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int payingOffListSortCounter = 0;

  public EmployeeTokens sortPayingOffListWith(String field, String descOrAsc) {
    addSortMoreOptions(PAYING_OFF_LIST, payingOffListSortCounter++, field, descOrAsc);
    return this;
  }

  private int payingOffListSearchCounter = 0;

  public EmployeeTokens searchPayingOffListWith(String field, String verb, String value) {

    withPayingOffList();
    addSearchMoreOptions(PAYING_OFF_LIST, payingOffListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens searchAllTextOfPayingOffList(String verb, String value) {
    String field = "id|who";
    addSearchMoreOptions(PAYING_OFF_LIST, payingOffListSearchCounter++, field, verb, value);
    return this;
  }

  public EmployeeTokens rowsPerPageOfPayingOffList(int rowsPerPage) {
    addSimpleOptions(PAYING_OFF_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public EmployeeTokens currentPageNumberOfPayingOffList(int currentPageNumber) {
    addSimpleOptions(PAYING_OFF_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public EmployeeTokens retainColumnsOfPayingOffList(String[] columns) {
    addSimpleOptions(PAYING_OFF_LIST + "RetainColumns", columns);
    return this;
  }

  public EmployeeTokens excludeColumnsOfPayingOffList(String[] columns) {
    addSimpleOptions(PAYING_OFF_LIST + "ExcludeColumns", columns);
    return this;
  }

  public EmployeeTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfEmployeeCompanyTrainingList(verb, value);
    searchAllTextOfEmployeeSkillList(verb, value);
    searchAllTextOfEmployeePerformanceList(verb, value);
    searchAllTextOfEmployeeWorkExperienceList(verb, value);
    searchAllTextOfEmployeeLeaveList(verb, value);
    searchAllTextOfEmployeeInterviewList(verb, value);
    searchAllTextOfEmployeeAttendanceList(verb, value);
    searchAllTextOfEmployeeQualifierList(verb, value);
    searchAllTextOfEmployeeEducationList(verb, value);
    searchAllTextOfEmployeeAwardList(verb, value);
    searchAllTextOfEmployeeSalarySheetList(verb, value);
    searchAllTextOfPayingOffList(verb, value);
    return this;
  }
}
