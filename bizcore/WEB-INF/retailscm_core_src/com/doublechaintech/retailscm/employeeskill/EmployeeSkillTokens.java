package com.doublechaintech.retailscm.employeeskill;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.employee.EmployeeTokens;
import com.doublechaintech.retailscm.skilltype.SkillTypeTokens;

public class EmployeeSkillTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "employeeSkill";

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

  protected EmployeeSkillTokens() {
    // ensure not initialized outside the class
  }

  public static EmployeeSkillTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    EmployeeSkillTokens tokens = new EmployeeSkillTokens(options);
    return tokens;
  }

  protected EmployeeSkillTokens(Map<String, Object> options) {
    this.options = options;
  }

  public EmployeeSkillTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static EmployeeSkillTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected EmployeeSkillTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static EmployeeSkillTokens start() {
    return new EmployeeSkillTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public EmployeeSkillTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static EmployeeSkillTokens loadGroupTokens(String... groupNames) {
    EmployeeSkillTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, EMPLOYEE, groupNames, new String[] {"default"});
    addToken(tokens, SKILLTYPE, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      EmployeeSkillTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static EmployeeSkillTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withEmployee().withSkillType();
  }

  public static EmployeeSkillTokens allTokens() {

    return start().withEmployee().withSkillType();
  }

  public static EmployeeSkillTokens withoutListsTokens() {

    return start().withEmployee().withSkillType();
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

  public EmployeeSkillTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String EMPLOYEE = "employee";

  public String getEmployee() {
    return EMPLOYEE;
  }
  //
  public EmployeeSkillTokens withEmployee() {
    addSimpleOptions(EMPLOYEE);
    return this;
  }

  public EmployeeTokens withEmployeeTokens() {
    // addSimpleOptions(EMPLOYEE);
    return EmployeeTokens.start();
  }

  protected static final String SKILLTYPE = "skillType";

  public String getSkillType() {
    return SKILLTYPE;
  }
  //
  public EmployeeSkillTokens withSkillType() {
    addSimpleOptions(SKILLTYPE);
    return this;
  }

  public SkillTypeTokens withSkillTypeTokens() {
    // addSimpleOptions(SKILLTYPE);
    return SkillTypeTokens.start();
  }

  public EmployeeSkillTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
