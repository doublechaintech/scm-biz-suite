package com.doublechaintech.retailscm.interviewtype;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewTokens;

public class InterviewTypeTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "interviewType";

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

  protected InterviewTypeTokens() {
    // ensure not initialized outside the class
  }

  public static InterviewTypeTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    InterviewTypeTokens tokens = new InterviewTypeTokens(options);
    return tokens;
  }

  protected InterviewTypeTokens(Map<String, Object> options) {
    this.options = options;
  }

  public InterviewTypeTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static InterviewTypeTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected InterviewTypeTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static InterviewTypeTokens start() {
    return new InterviewTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public InterviewTypeTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static InterviewTypeTokens loadGroupTokens(String... groupNames) {
    InterviewTypeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_INTERVIEW_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      InterviewTypeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static InterviewTypeTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withCompany().withEmployeeInterviewListIfViewGroupInclude(viewGroups);
  }

  public static InterviewTypeTokens allTokens() {

    return start().withCompany().withEmployeeInterviewList();
  }

  public static InterviewTypeTokens withoutListsTokens() {

    return start().withCompany();
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

  public InterviewTypeTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String COMPANY = "company";

  public String getCompany() {
    return COMPANY;
  }
  //
  public InterviewTypeTokens withCompany() {
    addSimpleOptions(COMPANY);
    return this;
  }

  public RetailStoreCountryCenterTokens withCompanyTokens() {
    // addSimpleOptions(COMPANY);
    return RetailStoreCountryCenterTokens.start();
  }

  protected static final String EMPLOYEE_INTERVIEW_LIST = "employeeInterviewList";

  public String getEmployeeInterviewList() {
    return EMPLOYEE_INTERVIEW_LIST;
  }

  public InterviewTypeTokens withEmployeeInterviewListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_INTERVIEW_LIST);
    }
    return this;
  }

  public InterviewTypeTokens withEmployeeInterviewList() {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST);
    return this;
  }

  public EmployeeInterviewTokens withEmployeeInterviewListTokens() {
    // addSimpleOptions(EMPLOYEE_INTERVIEW_LIST);
    return EmployeeInterviewTokens.start();
  }

  public InterviewTypeTokens analyzeEmployeeInterviewList() {
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

  public InterviewTypeTokens extractMoreFromEmployeeInterviewList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeInterviewListSortCounter = 0;

  public InterviewTypeTokens sortEmployeeInterviewListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        EMPLOYEE_INTERVIEW_LIST, employeeInterviewListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeInterviewListSearchCounter = 0;

  public InterviewTypeTokens searchEmployeeInterviewListWith(
      String field, String verb, String value) {

    withEmployeeInterviewList();
    addSearchMoreOptions(
        EMPLOYEE_INTERVIEW_LIST, employeeInterviewListSearchCounter++, field, verb, value);
    return this;
  }

  public InterviewTypeTokens searchAllTextOfEmployeeInterviewList(String verb, String value) {
    String field = "id|remark";
    addSearchMoreOptions(
        EMPLOYEE_INTERVIEW_LIST, employeeInterviewListSearchCounter++, field, verb, value);
    return this;
  }

  public InterviewTypeTokens rowsPerPageOfEmployeeInterviewList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public InterviewTypeTokens currentPageNumberOfEmployeeInterviewList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public InterviewTypeTokens retainColumnsOfEmployeeInterviewList(String[] columns) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + "RetainColumns", columns);
    return this;
  }

  public InterviewTypeTokens excludeColumnsOfEmployeeInterviewList(String[] columns) {
    addSimpleOptions(EMPLOYEE_INTERVIEW_LIST + "ExcludeColumns", columns);
    return this;
  }

  public InterviewTypeTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfEmployeeInterviewList(verb, value);
    return this;
  }
}
