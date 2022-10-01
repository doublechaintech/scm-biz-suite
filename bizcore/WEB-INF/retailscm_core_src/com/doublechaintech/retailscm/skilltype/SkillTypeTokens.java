package com.doublechaintech.retailscm.skilltype;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillTokens;

public class SkillTypeTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "skillType";

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

  protected SkillTypeTokens() {
    // ensure not initialized outside the class
  }

  public static SkillTypeTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    SkillTypeTokens tokens = new SkillTypeTokens(options);
    return tokens;
  }

  protected SkillTypeTokens(Map<String, Object> options) {
    this.options = options;
  }

  public SkillTypeTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static SkillTypeTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected SkillTypeTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static SkillTypeTokens start() {
    return new SkillTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public SkillTypeTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static SkillTypeTokens loadGroupTokens(String... groupNames) {
    SkillTypeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[] {"default"});

    addToken(tokens, EMPLOYEE_SKILL_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      SkillTypeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static SkillTypeTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withCompany().withEmployeeSkillListIfViewGroupInclude(viewGroups);
  }

  public static SkillTypeTokens allTokens() {

    return start().withCompany().withEmployeeSkillList();
  }

  public static SkillTypeTokens withoutListsTokens() {

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

  public SkillTypeTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String COMPANY = "company";

  public String getCompany() {
    return COMPANY;
  }
  //
  public SkillTypeTokens withCompany() {
    addSimpleOptions(COMPANY);
    return this;
  }

  public RetailStoreCountryCenterTokens withCompanyTokens() {
    // addSimpleOptions(COMPANY);
    return RetailStoreCountryCenterTokens.start();
  }

  protected static final String EMPLOYEE_SKILL_LIST = "employeeSkillList";

  public String getEmployeeSkillList() {
    return EMPLOYEE_SKILL_LIST;
  }

  public SkillTypeTokens withEmployeeSkillListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EMPLOYEE_SKILL_LIST);
    }
    return this;
  }

  public SkillTypeTokens withEmployeeSkillList() {
    addSimpleOptions(EMPLOYEE_SKILL_LIST);
    return this;
  }

  public EmployeeSkillTokens withEmployeeSkillListTokens() {
    // addSimpleOptions(EMPLOYEE_SKILL_LIST);
    return EmployeeSkillTokens.start();
  }

  public SkillTypeTokens analyzeEmployeeSkillList() {
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

  public SkillTypeTokens extractMoreFromEmployeeSkillList(String idsSeperatedWithComma) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int employeeSkillListSortCounter = 0;

  public SkillTypeTokens sortEmployeeSkillListWith(String field, String descOrAsc) {
    addSortMoreOptions(EMPLOYEE_SKILL_LIST, employeeSkillListSortCounter++, field, descOrAsc);
    return this;
  }

  private int employeeSkillListSearchCounter = 0;

  public SkillTypeTokens searchEmployeeSkillListWith(String field, String verb, String value) {

    withEmployeeSkillList();
    addSearchMoreOptions(EMPLOYEE_SKILL_LIST, employeeSkillListSearchCounter++, field, verb, value);
    return this;
  }

  public SkillTypeTokens searchAllTextOfEmployeeSkillList(String verb, String value) {
    String field = "id|description";
    addSearchMoreOptions(EMPLOYEE_SKILL_LIST, employeeSkillListSearchCounter++, field, verb, value);
    return this;
  }

  public SkillTypeTokens rowsPerPageOfEmployeeSkillList(int rowsPerPage) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public SkillTypeTokens currentPageNumberOfEmployeeSkillList(int currentPageNumber) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public SkillTypeTokens retainColumnsOfEmployeeSkillList(String[] columns) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + "RetainColumns", columns);
    return this;
  }

  public SkillTypeTokens excludeColumnsOfEmployeeSkillList(String[] columns) {
    addSimpleOptions(EMPLOYEE_SKILL_LIST + "ExcludeColumns", columns);
    return this;
  }

  public SkillTypeTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfEmployeeSkillList(verb, value);
    return this;
  }
}
