package com.doublechaintech.retailscm.leavetype;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveTokens;

public class LeaveTypeTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "leaveType";

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

  protected LeaveTypeTokens() {
    // ensure not initialized outside the class
  }

  public static LeaveTypeTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    LeaveTypeTokens tokens = new LeaveTypeTokens(options);
    return tokens;
  }

  protected LeaveTypeTokens(Map<String, Object> options) {
    this.options = options;
  }

  public LeaveTypeTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static LeaveTypeTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected LeaveTypeTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static LeaveTypeTokens start() {
    return new LeaveTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public LeaveTypeTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static LeaveTypeTokens loadGroupTokens(String... groupNames) {
    LeaveTypeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_LEAVE_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      LeaveTypeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static LeaveTypeTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withCompany().withEmployeeLeaveListIfViewGroupInclude(viewGroups);
  }

  public static LeaveTypeTokens allTokens() {

    return start().withCompany().withEmployeeLeaveList();
  }

  public static LeaveTypeTokens withoutListsTokens() {

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

  public LeaveTypeTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String COMPANY = "company";

  public String getCompany() {
    return COMPANY;
  }
  //
  public LeaveTypeTokens withCompany() {
    addSimpleOptions(COMPANY);
    return this;
  }

  public RetailStoreCountryCenterTokens withCompanyTokens() {
    // addSimpleOptions(COMPANY);
    return RetailStoreCountryCenterTokens.start();
  }

  protected static final String EMPLOYEE_LEAVE_LIST = "employeeLeaveList";

  public String getEmployeeLeaveList() {
    return EMPLOYEE_LEAVE_LIST;
  }

  public LeaveTypeTokens withEmployeeLeaveListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_LEAVE_LIST);
    }
    return this;
  }

  public LeaveTypeTokens withEmployeeLeaveList() {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST);
    return this;
  }

  public EmployeeLeaveTokens withEmployeeLeaveListTokens() {
    // addSimpleOptions(EMPLOYEE_LEAVE_LIST);
    return EmployeeLeaveTokens.start();
  }

  public LeaveTypeTokens analyzeEmployeeLeaveList() {
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

  public LeaveTypeTokens extractMoreFromEmployeeLeaveList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeLeaveListSortCounter = 0;

  public LeaveTypeTokens sortEmployeeLeaveListWith(String field, String descOrAsc) {
    addSortMoreOptions(EMPLOYEE_LEAVE_LIST, employeeLeaveListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeLeaveListSearchCounter = 0;

  public LeaveTypeTokens searchEmployeeLeaveListWith(String field, String verb, String value) {

    withEmployeeLeaveList();
    addSearchMoreOptions(EMPLOYEE_LEAVE_LIST, employeeLeaveListSearchCounter++, field, verb, value);
    return this;
  }

  public LeaveTypeTokens searchAllTextOfEmployeeLeaveList(String verb, String value) {
    String field = "id|remark";
    addSearchMoreOptions(EMPLOYEE_LEAVE_LIST, employeeLeaveListSearchCounter++, field, verb, value);
    return this;
  }

  public LeaveTypeTokens rowsPerPageOfEmployeeLeaveList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public LeaveTypeTokens currentPageNumberOfEmployeeLeaveList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public LeaveTypeTokens retainColumnsOfEmployeeLeaveList(String[] columns) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + "RetainColumns", columns);
    return this;
  }

  public LeaveTypeTokens excludeColumnsOfEmployeeLeaveList(String[] columns) {
    addSimpleOptions(EMPLOYEE_LEAVE_LIST + "ExcludeColumns", columns);
    return this;
  }

  public LeaveTypeTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfEmployeeLeaveList(verb, value);
    return this;
  }
}
