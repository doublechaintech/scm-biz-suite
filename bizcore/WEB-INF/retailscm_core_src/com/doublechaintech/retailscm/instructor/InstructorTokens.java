package com.doublechaintech.retailscm.instructor;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingTokens;

public class InstructorTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "instructor";

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

  protected InstructorTokens() {
    // ensure not initialized outside the class
  }

  public static InstructorTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    InstructorTokens tokens = new InstructorTokens(options);
    return tokens;
  }

  protected InstructorTokens(Map<String, Object> options) {
    this.options = options;
  }

  public InstructorTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static InstructorTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected InstructorTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static InstructorTokens start() {
    return new InstructorTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public InstructorTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static InstructorTokens loadGroupTokens(String... groupNames) {
    InstructorTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[] {"default"});

    addToken(tokens, COMPANY_TRAINING_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      InstructorTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static InstructorTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withCompany().withCompanyTrainingListIfViewGroupInclude(viewGroups);
  }

  public static InstructorTokens allTokens() {

    return start().withCompany().withCompanyTrainingList();
  }

  public static InstructorTokens withoutListsTokens() {

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

  public InstructorTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String COMPANY = "company";

  public String getCompany() {
    return COMPANY;
  }
  //
  public InstructorTokens withCompany() {
    addSimpleOptions(COMPANY);
    return this;
  }

  public RetailStoreCountryCenterTokens withCompanyTokens() {
    // addSimpleOptions(COMPANY);
    return RetailStoreCountryCenterTokens.start();
  }

  protected static final String COMPANY_TRAINING_LIST = "companyTrainingList";

  public String getCompanyTrainingList() {
    return COMPANY_TRAINING_LIST;
  }

  public InstructorTokens withCompanyTrainingListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(COMPANY_TRAINING_LIST);
    }
    return this;
  }

  public InstructorTokens withCompanyTrainingList() {
    addSimpleOptions(COMPANY_TRAINING_LIST);
    return this;
  }

  public CompanyTrainingTokens withCompanyTrainingListTokens() {
    // addSimpleOptions(COMPANY_TRAINING_LIST);
    return CompanyTrainingTokens.start();
  }

  public InstructorTokens analyzeCompanyTrainingList() {
    addSimpleOptions(COMPANY_TRAINING_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeCompanyTrainingListEnabled() {

    if (checkOptions(this.options(), COMPANY_TRAINING_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public InstructorTokens extractMoreFromCompanyTrainingList(String idsSeperatedWithComma) {
    addSimpleOptions(COMPANY_TRAINING_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int companyTrainingListSortCounter = 0;

  public InstructorTokens sortCompanyTrainingListWith(String field, String descOrAsc) {
    addSortMoreOptions(COMPANY_TRAINING_LIST, companyTrainingListSortCounter++, field, descOrAsc);
    return this;
  }

  private int companyTrainingListSearchCounter = 0;

  public InstructorTokens searchCompanyTrainingListWith(String field, String verb, String value) {

    withCompanyTrainingList();
    addSearchMoreOptions(
        COMPANY_TRAINING_LIST, companyTrainingListSearchCounter++, field, verb, value);
    return this;
  }

  public InstructorTokens searchAllTextOfCompanyTrainingList(String verb, String value) {
    String field = "id|title";
    addSearchMoreOptions(
        COMPANY_TRAINING_LIST, companyTrainingListSearchCounter++, field, verb, value);
    return this;
  }

  public InstructorTokens rowsPerPageOfCompanyTrainingList(int rowsPerPage) {
    addSimpleOptions(COMPANY_TRAINING_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public InstructorTokens currentPageNumberOfCompanyTrainingList(int currentPageNumber) {
    addSimpleOptions(COMPANY_TRAINING_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public InstructorTokens retainColumnsOfCompanyTrainingList(String[] columns) {
    addSimpleOptions(COMPANY_TRAINING_LIST + "RetainColumns", columns);
    return this;
  }

  public InstructorTokens excludeColumnsOfCompanyTrainingList(String[] columns) {
    addSimpleOptions(COMPANY_TRAINING_LIST + "ExcludeColumns", columns);
    return this;
  }

  public InstructorTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfCompanyTrainingList(verb, value);
    return this;
  }
}
