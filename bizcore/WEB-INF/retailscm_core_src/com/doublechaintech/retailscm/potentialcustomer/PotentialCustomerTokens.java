package com.doublechaintech.retailscm.potentialcustomer;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTokens;
import com.doublechaintech.retailscm.citypartner.CityPartnerTokens;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonTokens;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactTokens;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceTokens;

public class PotentialCustomerTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "potentialCustomer";

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

  protected PotentialCustomerTokens() {
    // ensure not initialized outside the class
  }

  public static PotentialCustomerTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    PotentialCustomerTokens tokens = new PotentialCustomerTokens(options);
    return tokens;
  }

  protected PotentialCustomerTokens(Map<String, Object> options) {
    this.options = options;
  }

  public PotentialCustomerTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static PotentialCustomerTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected PotentialCustomerTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static PotentialCustomerTokens start() {
    return new PotentialCustomerTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public PotentialCustomerTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static PotentialCustomerTokens loadGroupTokens(String... groupNames) {
    PotentialCustomerTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, CITYSERVICECENTER, groupNames, new String[] {"default"});
    addToken(tokens, CITYPARTNER, groupNames, new String[] {"default"});

    addToken(tokens, POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, groupNames, new String[] {"default"});

    addToken(tokens, POTENTIAL_CUSTOMER_CONTACT_LIST, groupNames, new String[] {"default"});

    addToken(tokens, EVENT_ATTENDANCE_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      PotentialCustomerTokens pTokens,
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

  public static PotentialCustomerTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withCityServiceCenter()
        .withCityPartner()
        .withPotentialCustomerContactPersonListIfViewGroupInclude(viewGroups)
        .withPotentialCustomerContactListIfViewGroupInclude(viewGroups)
        .withEventAttendanceListIfViewGroupInclude(viewGroups);
  }

  public static PotentialCustomerTokens allTokens() {

    return start()
        .withCityServiceCenter()
        .withCityPartner()
        .withPotentialCustomerContactPersonList()
        .withPotentialCustomerContactList()
        .withEventAttendanceList();
  }

  public static PotentialCustomerTokens withoutListsTokens() {

    return start().withCityServiceCenter().withCityPartner();
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

  public PotentialCustomerTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String CITYSERVICECENTER = "cityServiceCenter";

  public String getCityServiceCenter() {
    return CITYSERVICECENTER;
  }
  //
  public PotentialCustomerTokens withCityServiceCenter() {
    addSimpleOptions(CITYSERVICECENTER);
    return this;
  }

  public RetailStoreCityServiceCenterTokens withCityServiceCenterTokens() {
    // addSimpleOptions(CITYSERVICECENTER);
    return RetailStoreCityServiceCenterTokens.start();
  }

  protected static final String CITYPARTNER = "cityPartner";

  public String getCityPartner() {
    return CITYPARTNER;
  }
  //
  public PotentialCustomerTokens withCityPartner() {
    addSimpleOptions(CITYPARTNER);
    return this;
  }

  public CityPartnerTokens withCityPartnerTokens() {
    // addSimpleOptions(CITYPARTNER);
    return CityPartnerTokens.start();
  }

  protected static final String POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST =
      "potentialCustomerContactPersonList";

  public String getPotentialCustomerContactPersonList() {
    return POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST;
  }

  public PotentialCustomerTokens withPotentialCustomerContactPersonListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
    }
    return this;
  }

  public PotentialCustomerTokens withPotentialCustomerContactPersonList() {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
    return this;
  }

  public PotentialCustomerContactPersonTokens withPotentialCustomerContactPersonListTokens() {
    // addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
    return PotentialCustomerContactPersonTokens.start();
  }

  public PotentialCustomerTokens analyzePotentialCustomerContactPersonList() {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST + ".anaylze");
    return this;
  }

  public boolean analyzePotentialCustomerContactPersonListEnabled() {

    if (checkOptions(this.options(), POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public PotentialCustomerTokens extractMoreFromPotentialCustomerContactPersonList(
      String idsSeperatedWithComma) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int potentialCustomerContactPersonListSortCounter = 0;

  public PotentialCustomerTokens sortPotentialCustomerContactPersonListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST,
        potentialCustomerContactPersonListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int potentialCustomerContactPersonListSearchCounter = 0;

  public PotentialCustomerTokens searchPotentialCustomerContactPersonListWith(
      String field, String verb, String value) {

    withPotentialCustomerContactPersonList();
    addSearchMoreOptions(
        POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST,
        potentialCustomerContactPersonListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public PotentialCustomerTokens searchAllTextOfPotentialCustomerContactPersonList(
      String verb, String value) {
    String field = "id|name|mobile|description";
    addSearchMoreOptions(
        POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST,
        potentialCustomerContactPersonListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public PotentialCustomerTokens rowsPerPageOfPotentialCustomerContactPersonList(int rowsPerPage) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public PotentialCustomerTokens currentPageNumberOfPotentialCustomerContactPersonList(
      int currentPageNumber) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public PotentialCustomerTokens retainColumnsOfPotentialCustomerContactPersonList(
      String[] columns) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST + "RetainColumns", columns);
    return this;
  }

  public PotentialCustomerTokens excludeColumnsOfPotentialCustomerContactPersonList(
      String[] columns) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";

  public String getPotentialCustomerContactList() {
    return POTENTIAL_CUSTOMER_CONTACT_LIST;
  }

  public PotentialCustomerTokens withPotentialCustomerContactListIfViewGroupInclude(
      String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
    }
    return this;
  }

  public PotentialCustomerTokens withPotentialCustomerContactList() {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
    return this;
  }

  public PotentialCustomerContactTokens withPotentialCustomerContactListTokens() {
    // addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
    return PotentialCustomerContactTokens.start();
  }

  public PotentialCustomerTokens analyzePotentialCustomerContactList() {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST + ".anaylze");
    return this;
  }

  public boolean analyzePotentialCustomerContactListEnabled() {

    if (checkOptions(this.options(), POTENTIAL_CUSTOMER_CONTACT_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public PotentialCustomerTokens extractMoreFromPotentialCustomerContactList(
      String idsSeperatedWithComma) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int potentialCustomerContactListSortCounter = 0;

  public PotentialCustomerTokens sortPotentialCustomerContactListWith(
      String field, String descOrAsc) {
    addSortMoreOptions(
        POTENTIAL_CUSTOMER_CONTACT_LIST,
        potentialCustomerContactListSortCounter++,
        field,
        descOrAsc);
    return this;
  }

  private int potentialCustomerContactListSearchCounter = 0;

  public PotentialCustomerTokens searchPotentialCustomerContactListWith(
      String field, String verb, String value) {

    withPotentialCustomerContactList();
    addSearchMoreOptions(
        POTENTIAL_CUSTOMER_CONTACT_LIST,
        potentialCustomerContactListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public PotentialCustomerTokens searchAllTextOfPotentialCustomerContactList(
      String verb, String value) {
    String field = "id|name|contactMethod|description";
    addSearchMoreOptions(
        POTENTIAL_CUSTOMER_CONTACT_LIST,
        potentialCustomerContactListSearchCounter++,
        field,
        verb,
        value);
    return this;
  }

  public PotentialCustomerTokens rowsPerPageOfPotentialCustomerContactList(int rowsPerPage) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public PotentialCustomerTokens currentPageNumberOfPotentialCustomerContactList(
      int currentPageNumber) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public PotentialCustomerTokens retainColumnsOfPotentialCustomerContactList(String[] columns) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST + "RetainColumns", columns);
    return this;
  }

  public PotentialCustomerTokens excludeColumnsOfPotentialCustomerContactList(String[] columns) {
    addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String EVENT_ATTENDANCE_LIST = "eventAttendanceList";

  public String getEventAttendanceList() {
    return EVENT_ATTENDANCE_LIST;
  }

  public PotentialCustomerTokens withEventAttendanceListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(EVENT_ATTENDANCE_LIST);
    }
    return this;
  }

  public PotentialCustomerTokens withEventAttendanceList() {
    addSimpleOptions(EVENT_ATTENDANCE_LIST);
    return this;
  }

  public EventAttendanceTokens withEventAttendanceListTokens() {
    // addSimpleOptions(EVENT_ATTENDANCE_LIST);
    return EventAttendanceTokens.start();
  }

  public PotentialCustomerTokens analyzeEventAttendanceList() {
    addSimpleOptions(EVENT_ATTENDANCE_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeEventAttendanceListEnabled() {

    if (checkOptions(this.options(), EVENT_ATTENDANCE_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public PotentialCustomerTokens extractMoreFromEventAttendanceList(String idsSeperatedWithComma) {
    addSimpleOptions(EVENT_ATTENDANCE_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int eventAttendanceListSortCounter = 0;

  public PotentialCustomerTokens sortEventAttendanceListWith(String field, String descOrAsc) {
    addSortMoreOptions(EVENT_ATTENDANCE_LIST, eventAttendanceListSortCounter++, field, descOrAsc);
    return this;
  }

  private int eventAttendanceListSearchCounter = 0;

  public PotentialCustomerTokens searchEventAttendanceListWith(
      String field, String verb, String value) {

    withEventAttendanceList();
    addSearchMoreOptions(
        EVENT_ATTENDANCE_LIST, eventAttendanceListSearchCounter++, field, verb, value);
    return this;
  }

  public PotentialCustomerTokens searchAllTextOfEventAttendanceList(String verb, String value) {
    String field = "id|name|description";
    addSearchMoreOptions(
        EVENT_ATTENDANCE_LIST, eventAttendanceListSearchCounter++, field, verb, value);
    return this;
  }

  public PotentialCustomerTokens rowsPerPageOfEventAttendanceList(int rowsPerPage) {
    addSimpleOptions(EVENT_ATTENDANCE_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public PotentialCustomerTokens currentPageNumberOfEventAttendanceList(int currentPageNumber) {
    addSimpleOptions(EVENT_ATTENDANCE_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public PotentialCustomerTokens retainColumnsOfEventAttendanceList(String[] columns) {
    addSimpleOptions(EVENT_ATTENDANCE_LIST + "RetainColumns", columns);
    return this;
  }

  public PotentialCustomerTokens excludeColumnsOfEventAttendanceList(String[] columns) {
    addSimpleOptions(EVENT_ATTENDANCE_LIST + "ExcludeColumns", columns);
    return this;
  }

  public PotentialCustomerTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfPotentialCustomerContactPersonList(verb, value);
    searchAllTextOfPotentialCustomerContactList(verb, value);
    searchAllTextOfEventAttendanceList(verb, value);
    return this;
  }
}
