package com.doublechaintech.retailscm.accountingdocumentline;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentTokens;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectTokens;

public class AccountingDocumentLineTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "accountingDocumentLine";

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

  protected AccountingDocumentLineTokens() {
    // ensure not initialized outside the class
  }

  public static AccountingDocumentLineTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    AccountingDocumentLineTokens tokens = new AccountingDocumentLineTokens(options);
    return tokens;
  }

  protected AccountingDocumentLineTokens(Map<String, Object> options) {
    this.options = options;
  }

  public AccountingDocumentLineTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static AccountingDocumentLineTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected AccountingDocumentLineTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static AccountingDocumentLineTokens start() {
    return new AccountingDocumentLineTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public AccountingDocumentLineTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static AccountingDocumentLineTokens loadGroupTokens(String... groupNames) {
    AccountingDocumentLineTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, BELONGSTO, groupNames, new String[] {"default"});
    addToken(tokens, ACCOUNTINGSUBJECT, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      AccountingDocumentLineTokens pTokens,
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

  public static AccountingDocumentLineTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start().withBelongsTo().withAccountingSubject();
  }

  public static AccountingDocumentLineTokens allTokens() {

    return start().withBelongsTo().withAccountingSubject();
  }

  public static AccountingDocumentLineTokens withoutListsTokens() {

    return start().withBelongsTo().withAccountingSubject();
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

  public AccountingDocumentLineTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String BELONGSTO = "belongsTo";

  public String getBelongsTo() {
    return BELONGSTO;
  }
  //
  public AccountingDocumentLineTokens withBelongsTo() {
    addSimpleOptions(BELONGSTO);
    return this;
  }

  public AccountingDocumentTokens withBelongsToTokens() {
    // addSimpleOptions(BELONGSTO);
    return AccountingDocumentTokens.start();
  }

  protected static final String ACCOUNTINGSUBJECT = "accountingSubject";

  public String getAccountingSubject() {
    return ACCOUNTINGSUBJECT;
  }
  //
  public AccountingDocumentLineTokens withAccountingSubject() {
    addSimpleOptions(ACCOUNTINGSUBJECT);
    return this;
  }

  public AccountingSubjectTokens withAccountingSubjectTokens() {
    // addSimpleOptions(ACCOUNTINGSUBJECT);
    return AccountingSubjectTokens.start();
  }

  public AccountingDocumentLineTokens searchEntireObjectText(String verb, String value) {

    return this;
  }
}
