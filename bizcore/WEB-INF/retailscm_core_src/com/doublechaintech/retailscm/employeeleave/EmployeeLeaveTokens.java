package com.doublechaintech.retailscm.employeeleave;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.employee.EmployeeTokens;
import com.doublechaintech.retailscm.leavetype.LeaveTypeTokens;

public class EmployeeLeaveTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "employeeLeave";

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

  protected EmployeeLeaveTokens() {
    // ensure not initialized outside the class
  }

  public static EmployeeLeaveTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    EmployeeLeaveTokens tokens = new EmployeeLeaveTokens(options);
    return tokens;
  }

  protected EmployeeLeaveTokens(Map<String, Object> options) {
    this.options = options;
  }

  public EmployeeLeaveTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static EmployeeLeaveTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected EmployeeLeaveTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static EmployeeLeaveTokens start() {
    return new EmployeeLeaveTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public EmployeeLeaveTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static EmployeeLeaveTokens loadGroupTokens(String... groupNames) {
    EmployeeLeaveTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, WHO, groupNames, new String[] {"default"});
    addToken(tokens, TYPE, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      EmployeeLeaveTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

  public static EmployeeLeaveTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withWho().withType();
  }

  public static EmployeeLeaveTokens allTokens() {

    return start().withWho().withType();
  }

  public static EmployeeLeaveTokens withoutListsTokens() {

    return start().withWho().withType();
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

  public EmployeeLeaveTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String WHO = "who";

  public String getWho() {
    return WHO;
  }
  //
  public EmployeeLeaveTokens withWho() {
    addSimpleOptions(WHO);
    return this;
  }

  public EmployeeTokens withWhoTokens() {
    // addSimpleOptions(WHO);
    return EmployeeTokens.start();
  }

  protected static final String TYPE = "type";

  public String getType() {
    return TYPE;
  }
  //
  public EmployeeLeaveTokens withType() {
    addSimpleOptions(TYPE);
    return this;
  }

  public LeaveTypeTokens withTypeTokens() {
    // addSimpleOptions(TYPE);
    return LeaveTypeTokens.start();
  }

  public EmployeeLeaveTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
