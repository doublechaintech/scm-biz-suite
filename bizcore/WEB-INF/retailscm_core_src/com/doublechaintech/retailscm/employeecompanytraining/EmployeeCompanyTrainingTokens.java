package com.doublechaintech.retailscm.employeecompanytraining;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.employee.EmployeeTokens;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingTokens;
import com.doublechaintech.retailscm.scoring.ScoringTokens;

public class EmployeeCompanyTrainingTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "employeeCompanyTraining";

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

  protected EmployeeCompanyTrainingTokens() {
    // ensure not initialized outside the class
  }

  public static EmployeeCompanyTrainingTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    EmployeeCompanyTrainingTokens tokens = new EmployeeCompanyTrainingTokens(options);
    return tokens;
  }

  protected EmployeeCompanyTrainingTokens(Map<String, Object> options) {
    this.options = options;
  }

  public EmployeeCompanyTrainingTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static EmployeeCompanyTrainingTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected EmployeeCompanyTrainingTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static EmployeeCompanyTrainingTokens start() {
    return new EmployeeCompanyTrainingTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public EmployeeCompanyTrainingTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static EmployeeCompanyTrainingTokens loadGroupTokens(String... groupNames) {
    EmployeeCompanyTrainingTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, EMPLOYEE, groupNames, new String[] {"default"});
    addToken(tokens, TRAINING, groupNames, new String[] {"default"});
    addToken(tokens, SCORING, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      EmployeeCompanyTrainingTokens pTokens,
      String pTokenName,
      String[] pGroupNames,
      String[] fieldGroups) {
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

  public static EmployeeCompanyTrainingTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withEmployee().withTraining().withScoring();
  }

  public static EmployeeCompanyTrainingTokens allTokens() {

    return start().withEmployee().withTraining().withScoring();
  }

  public static EmployeeCompanyTrainingTokens withoutListsTokens() {

    return start().withEmployee().withTraining().withScoring();
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

  public EmployeeCompanyTrainingTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String EMPLOYEE = "employee";

  public String getEmployee() {
    return EMPLOYEE;
  }
  //
  public EmployeeCompanyTrainingTokens withEmployee() {
    addSimpleOptions(EMPLOYEE);
    return this;
  }

  public EmployeeTokens withEmployeeTokens() {
    // addSimpleOptions(EMPLOYEE);
    return EmployeeTokens.start();
  }

  protected static final String TRAINING = "training";

  public String getTraining() {
    return TRAINING;
  }
  //
  public EmployeeCompanyTrainingTokens withTraining() {
    addSimpleOptions(TRAINING);
    return this;
  }

  public CompanyTrainingTokens withTrainingTokens() {
    // addSimpleOptions(TRAINING);
    return CompanyTrainingTokens.start();
  }

  protected static final String SCORING = "scoring";

  public String getScoring() {
    return SCORING;
  }
  //
  public EmployeeCompanyTrainingTokens withScoring() {
    addSimpleOptions(SCORING);
    return this;
  }

  public ScoringTokens withScoringTokens() {
    // addSimpleOptions(SCORING);
    return ScoringTokens.start();
  }

  public EmployeeCompanyTrainingTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
