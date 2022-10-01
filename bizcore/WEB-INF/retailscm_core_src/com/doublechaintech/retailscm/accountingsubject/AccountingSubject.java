package com.doublechaintech.retailscm.accountingsubject;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountset.AccountSet;

@JsonSerialize(using = AccountingSubjectSerializer.class)
public class AccountingSubject extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(AccountingSubject target) {
    if (target == null) {
      return;
    }
    target.addAccountingDocumentLineList(this.getAccountingDocumentLineList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String ACCOUNTING_SUBJECT_CODE_PROPERTY = "accountingSubjectCode";
  public static final String ACCOUNTING_SUBJECT_NAME_PROPERTY = "accountingSubjectName";
  public static final String ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY = "accountingSubjectClassCode";
  public static final String ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY = "accountingSubjectClassName";
  public static final String ACCOUNT_SET_PROPERTY = "accountSet";
  public static final String VERSION_PROPERTY = "version";

  public static final String ACCOUNTING_DOCUMENT_LINE_LIST = "accountingDocumentLineList";

  public static final String INTERNAL_TYPE = "AccountingSubject";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                ACCOUNTING_SUBJECT_CODE_PROPERTY, "accounting_subject_code", "会计科目代码")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                ACCOUNTING_SUBJECT_NAME_PROPERTY, "accounting_subject_name", "会计科目名称")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, "accounting_subject_class_code", "会计科目类别代码")
            .withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, "accounting_subject_class_name", "会计科目类别名称")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ACCOUNT_SET_PROPERTY, "account_set", "账套")
            .withType("account_set", AccountSet.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(ACCOUNTING_DOCUMENT_LINE_LIST, "accountingSubject", "会计文件行表")
            .withType("accounting_document_line", AccountingDocumentLine.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      ACCOUNTING_SUBJECT_CODE_PROPERTY,
      ACCOUNTING_SUBJECT_NAME_PROPERTY,
      ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY,
      ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY,
      ACCOUNT_SET_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(ACCOUNTING_DOCUMENT_LINE_LIST, "accountingSubject");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(ACCOUNTING_DOCUMENT_LINE_LIST, AccountingDocumentLine.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(ACCOUNT_SET_PROPERTY, AccountSet.class);

    return parents;
  }
  /*
  public AccountingSubject want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public AccountingSubject wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getAccountingSubjectCode();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String accountingSubjectCode;
  protected String accountingSubjectName;
  protected int accountingSubjectClassCode;
  protected String accountingSubjectClassName;
  protected AccountSet accountSet;
  protected int version;

  protected SmartList<AccountingDocumentLine> mAccountingDocumentLineList;

  public AccountingSubject() {
    // lazy load for all the properties
  }

  public static AccountingSubject withId(String id) {
    AccountingSubject accountingSubject = new AccountingSubject();
    accountingSubject.setId(id);
    accountingSubject.setVersion(Integer.MAX_VALUE);
    accountingSubject.setChecked(true);
    return accountingSubject;
  }

  public static AccountingSubject refById(String id) {
    return withId(id);
  }

  public AccountingSubject limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public AccountingSubject limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static AccountingSubject searchExample() {
    AccountingSubject accountingSubject = new AccountingSubject();
    accountingSubject.setAccountingSubjectClassCode(UNSET_INT);
    accountingSubject.setVersion(UNSET_INT);

    return accountingSubject;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setAccountSet( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (ACCOUNTING_SUBJECT_CODE_PROPERTY.equals(property)) {
      changeAccountingSubjectCodeProperty(newValueExpr);
    }
    if (ACCOUNTING_SUBJECT_NAME_PROPERTY.equals(property)) {
      changeAccountingSubjectNameProperty(newValueExpr);
    }
    if (ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY.equals(property)) {
      changeAccountingSubjectClassCodeProperty(newValueExpr);
    }
    if (ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY.equals(property)) {
      changeAccountingSubjectClassNameProperty(newValueExpr);
    }
  }

  protected void changeAccountingSubjectCodeProperty(String newValueExpr) {

    String oldValue = getAccountingSubjectCode();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAccountingSubjectCode(newValue);
    this.onChangeProperty(ACCOUNTING_SUBJECT_CODE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAccountingSubjectNameProperty(String newValueExpr) {

    String oldValue = getAccountingSubjectName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAccountingSubjectName(newValue);
    this.onChangeProperty(ACCOUNTING_SUBJECT_NAME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAccountingSubjectClassCodeProperty(String newValueExpr) {

    int oldValue = getAccountingSubjectClassCode();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAccountingSubjectClassCode(newValue);
    this.onChangeProperty(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAccountingSubjectClassNameProperty(String newValueExpr) {

    String oldValue = getAccountingSubjectClassName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAccountingSubjectClassName(newValue);
    this.onChangeProperty(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (ACCOUNTING_SUBJECT_CODE_PROPERTY.equals(property)) {
      return getAccountingSubjectCode();
    }
    if (ACCOUNTING_SUBJECT_NAME_PROPERTY.equals(property)) {
      return getAccountingSubjectName();
    }
    if (ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY.equals(property)) {
      return getAccountingSubjectClassCode();
    }
    if (ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY.equals(property)) {
      return getAccountingSubjectClassName();
    }
    if (ACCOUNT_SET_PROPERTY.equals(property)) {
      return getAccountSet();
    }
    if (ACCOUNTING_DOCUMENT_LINE_LIST.equals(property)) {
      List<BaseEntity> list =
          getAccountingDocumentLineList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }

    // other property not include here
    return super.propertyOf(property);
  }

  public void setId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    this.id = newId;
  }

  public String id() {
    doLoad();
    return getId();
  }

  public String getId() {
    return this.id;
  }

  public AccountingSubject updateId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    if (!shouldReplaceBy(newId, oldId)) {
      return this;
    }
    this.id = newId;
    if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)) {
      return this;
    }
    addPropertyChange(ID_PROPERTY, oldId, newId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingSubject orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public AccountingSubject ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public AccountingSubject addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setAccountingSubjectCode(String accountingSubjectCode) {
    String oldAccountingSubjectCode = this.accountingSubjectCode;
    String newAccountingSubjectCode = trimString(accountingSubjectCode);
    this.accountingSubjectCode = newAccountingSubjectCode;
  }

  public String accountingSubjectCode() {
    doLoad();
    return getAccountingSubjectCode();
  }

  public String getAccountingSubjectCode() {
    return this.accountingSubjectCode;
  }

  public AccountingSubject updateAccountingSubjectCode(String accountingSubjectCode) {
    String oldAccountingSubjectCode = this.accountingSubjectCode;
    String newAccountingSubjectCode = trimString(accountingSubjectCode);
    if (!shouldReplaceBy(newAccountingSubjectCode, oldAccountingSubjectCode)) {
      return this;
    }
    this.accountingSubjectCode = newAccountingSubjectCode;
    if (cn.hutool.core.util.ObjectUtil.equals(newAccountingSubjectCode, oldAccountingSubjectCode)) {
      return this;
    }
    addPropertyChange(
        ACCOUNTING_SUBJECT_CODE_PROPERTY, oldAccountingSubjectCode, newAccountingSubjectCode);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingSubject orderByAccountingSubjectCode(boolean asc) {
    doAddOrderBy(ACCOUNTING_SUBJECT_CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountingSubjectCodeCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNTING_SUBJECT_CODE_PROPERTY, operator, parameters);
  }

  public AccountingSubject ignoreAccountingSubjectCodeCriteria() {
    super.ignoreSearchProperty(ACCOUNTING_SUBJECT_CODE_PROPERTY);
    return this;
  }

  public AccountingSubject addAccountingSubjectCodeCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountingSubjectCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountingSubjectCode(String accountingSubjectCode) {
    if (accountingSubjectCode != null) {
      updateAccountingSubjectCode(accountingSubjectCode);
    }
  }

  public void setAccountingSubjectName(String accountingSubjectName) {
    String oldAccountingSubjectName = this.accountingSubjectName;
    String newAccountingSubjectName = trimString(accountingSubjectName);
    this.accountingSubjectName = newAccountingSubjectName;
  }

  public String accountingSubjectName() {
    doLoad();
    return getAccountingSubjectName();
  }

  public String getAccountingSubjectName() {
    return this.accountingSubjectName;
  }

  public AccountingSubject updateAccountingSubjectName(String accountingSubjectName) {
    String oldAccountingSubjectName = this.accountingSubjectName;
    String newAccountingSubjectName = trimString(accountingSubjectName);
    if (!shouldReplaceBy(newAccountingSubjectName, oldAccountingSubjectName)) {
      return this;
    }
    this.accountingSubjectName = newAccountingSubjectName;
    if (cn.hutool.core.util.ObjectUtil.equals(newAccountingSubjectName, oldAccountingSubjectName)) {
      return this;
    }
    addPropertyChange(
        ACCOUNTING_SUBJECT_NAME_PROPERTY, oldAccountingSubjectName, newAccountingSubjectName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingSubject orderByAccountingSubjectName(boolean asc) {
    doAddOrderBy(ACCOUNTING_SUBJECT_NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountingSubjectNameCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNTING_SUBJECT_NAME_PROPERTY, operator, parameters);
  }

  public AccountingSubject ignoreAccountingSubjectNameCriteria() {
    super.ignoreSearchProperty(ACCOUNTING_SUBJECT_NAME_PROPERTY);
    return this;
  }

  public AccountingSubject addAccountingSubjectNameCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountingSubjectNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountingSubjectName(String accountingSubjectName) {
    if (accountingSubjectName != null) {
      updateAccountingSubjectName(accountingSubjectName);
    }
  }

  public void setAccountingSubjectClassCode(int accountingSubjectClassCode) {
    int oldAccountingSubjectClassCode = this.accountingSubjectClassCode;
    int newAccountingSubjectClassCode = accountingSubjectClassCode;
    this.accountingSubjectClassCode = newAccountingSubjectClassCode;
  }

  public int accountingSubjectClassCode() {
    doLoad();
    return getAccountingSubjectClassCode();
  }

  public int getAccountingSubjectClassCode() {
    return this.accountingSubjectClassCode;
  }

  public AccountingSubject updateAccountingSubjectClassCode(int accountingSubjectClassCode) {
    int oldAccountingSubjectClassCode = this.accountingSubjectClassCode;
    int newAccountingSubjectClassCode = accountingSubjectClassCode;
    if (!shouldReplaceBy(newAccountingSubjectClassCode, oldAccountingSubjectClassCode)) {
      return this;
    }
    this.accountingSubjectClassCode = newAccountingSubjectClassCode;
    if (cn.hutool.core.util.ObjectUtil.equals(
        newAccountingSubjectClassCode, oldAccountingSubjectClassCode)) {
      return this;
    }
    addPropertyChange(
        ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY,
        oldAccountingSubjectClassCode,
        newAccountingSubjectClassCode);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingSubject orderByAccountingSubjectClassCode(boolean asc) {
    doAddOrderBy(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountingSubjectClassCodeCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, operator, parameters);
  }

  public AccountingSubject ignoreAccountingSubjectClassCodeCriteria() {
    super.ignoreSearchProperty(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
    return this;
  }

  public AccountingSubject addAccountingSubjectClassCodeCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountingSubjectClassCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountingSubjectClassCode(int accountingSubjectClassCode) {
    updateAccountingSubjectClassCode(accountingSubjectClassCode);
  }

  public void setAccountingSubjectClassName(String accountingSubjectClassName) {
    String oldAccountingSubjectClassName = this.accountingSubjectClassName;
    String newAccountingSubjectClassName = trimString(accountingSubjectClassName);
    this.accountingSubjectClassName = newAccountingSubjectClassName;
  }

  public String accountingSubjectClassName() {
    doLoad();
    return getAccountingSubjectClassName();
  }

  public String getAccountingSubjectClassName() {
    return this.accountingSubjectClassName;
  }

  public AccountingSubject updateAccountingSubjectClassName(String accountingSubjectClassName) {
    String oldAccountingSubjectClassName = this.accountingSubjectClassName;
    String newAccountingSubjectClassName = trimString(accountingSubjectClassName);
    if (!shouldReplaceBy(newAccountingSubjectClassName, oldAccountingSubjectClassName)) {
      return this;
    }
    this.accountingSubjectClassName = newAccountingSubjectClassName;
    if (cn.hutool.core.util.ObjectUtil.equals(
        newAccountingSubjectClassName, oldAccountingSubjectClassName)) {
      return this;
    }
    addPropertyChange(
        ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY,
        oldAccountingSubjectClassName,
        newAccountingSubjectClassName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingSubject orderByAccountingSubjectClassName(boolean asc) {
    doAddOrderBy(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountingSubjectClassNameCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, operator, parameters);
  }

  public AccountingSubject ignoreAccountingSubjectClassNameCriteria() {
    super.ignoreSearchProperty(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
    return this;
  }

  public AccountingSubject addAccountingSubjectClassNameCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountingSubjectClassNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountingSubjectClassName(String accountingSubjectClassName) {
    if (accountingSubjectClassName != null) {
      updateAccountingSubjectClassName(accountingSubjectClassName);
    }
  }

  public void setAccountSet(AccountSet accountSet) {
    AccountSet oldAccountSet = this.accountSet;
    AccountSet newAccountSet = accountSet;
    this.accountSet = newAccountSet;
  }

  public AccountSet accountSet() {
    doLoad();
    return getAccountSet();
  }

  public AccountSet getAccountSet() {
    return this.accountSet;
  }

  public AccountingSubject updateAccountSet(AccountSet accountSet) {
    AccountSet oldAccountSet = this.accountSet;
    AccountSet newAccountSet = accountSet;
    if (!shouldReplaceBy(newAccountSet, oldAccountSet)) {
      return this;
    }
    this.accountSet = newAccountSet;
    if (cn.hutool.core.util.ObjectUtil.equals(newAccountSet, oldAccountSet)) {
      return this;
    }
    addPropertyChange(ACCOUNT_SET_PROPERTY, oldAccountSet, newAccountSet);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingSubject orderByAccountSet(boolean asc) {
    doAddOrderBy(ACCOUNT_SET_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountSetCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNT_SET_PROPERTY, operator, parameters);
  }

  public AccountingSubject ignoreAccountSetCriteria() {
    super.ignoreSearchProperty(ACCOUNT_SET_PROPERTY);
    return this;
  }

  public AccountingSubject addAccountSetCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountSetCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountSet(AccountSet accountSet) {
    if (accountSet != null) {
      updateAccountSet(accountSet);
    }
  }

  public AccountingSubject updateAccountSetByReferenceId(String accountSetId) {
    updateAccountSet(AccountSet.refById(accountSetId));
    return this;
  }

  public void clearAccountSet() {
    setAccountSet(null);
    this.changed = true;
    setChecked(false);
  }

  public void setVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    this.version = newVersion;
  }

  public int version() {
    doLoad();
    return getVersion();
  }

  public int getVersion() {
    return this.version;
  }

  public AccountingSubject updateVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    if (!shouldReplaceBy(newVersion, oldVersion)) {
      return this;
    }
    this.version = newVersion;
    if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)) {
      return this;
    }
    addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingSubject orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public AccountingSubject ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public AccountingSubject addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<AccountingDocumentLine> getAccountingDocumentLineList() {
    if (this.mAccountingDocumentLineList == null) {
      this.mAccountingDocumentLineList = new SmartList<AccountingDocumentLine>();
      this.mAccountingDocumentLineList.setListInternalName(ACCOUNTING_DOCUMENT_LINE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mAccountingDocumentLineList;
  }

  public SmartList<AccountingDocumentLine> accountingDocumentLineList() {

    doLoadChild(ACCOUNTING_DOCUMENT_LINE_LIST);

    return getAccountingDocumentLineList();
  }

  public void setAccountingDocumentLineList(
      SmartList<AccountingDocumentLine> accountingDocumentLineList) {
    for (AccountingDocumentLine accountingDocumentLine : accountingDocumentLineList) {
      accountingDocumentLine.setAccountingSubject(this);
    }

    this.mAccountingDocumentLineList = accountingDocumentLineList;
    this.mAccountingDocumentLineList.setListInternalName(ACCOUNTING_DOCUMENT_LINE_LIST);
  }

  public AccountingSubject addAccountingDocumentLine(
      AccountingDocumentLine accountingDocumentLine) {
    accountingDocumentLine.updateAccountingSubject(this);
    getAccountingDocumentLineList().add(accountingDocumentLine);
    return this;
  }

  public AccountingSubject addAccountingDocumentLineList(
      SmartList<AccountingDocumentLine> accountingDocumentLineList) {
    for (AccountingDocumentLine accountingDocumentLine : accountingDocumentLineList) {
      accountingDocumentLine.updateAccountingSubject(this);
    }

    Map<String, AccountingDocumentLine> mapById = accountingDocumentLineList.mapWithId();
    getAccountingDocumentLineList().removeIf(item -> mapById.get(item.getId()) != null);
    getAccountingDocumentLineList().addAll(accountingDocumentLineList);
    return this;
  }

  public void mergeAccountingDocumentLineList(
      SmartList<AccountingDocumentLine> accountingDocumentLineList) {
    if (accountingDocumentLineList == null) {
      return;
    }
    if (accountingDocumentLineList.isEmpty()) {
      return;
    }
    addAccountingDocumentLineList(accountingDocumentLineList);
  }

  public AccountingDocumentLine removeAccountingDocumentLine(
      AccountingDocumentLine accountingDocumentLineIndex) {

    int index = getAccountingDocumentLineList().indexOf(accountingDocumentLineIndex);
    if (index < 0) {
      String message =
          "AccountingDocumentLine("
              + accountingDocumentLineIndex.getId()
              + ") with version='"
              + accountingDocumentLineIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    AccountingDocumentLine accountingDocumentLine = getAccountingDocumentLineList().get(index);
    // accountingDocumentLine.clearAccountingSubject(); //disconnect with AccountingSubject
    accountingDocumentLine.clearFromAll(); // disconnect with AccountingSubject

    boolean result = getAccountingDocumentLineList().planToRemove(accountingDocumentLine);
    if (!result) {
      String message =
          "AccountingDocumentLine("
              + accountingDocumentLineIndex.getId()
              + ") with version='"
              + accountingDocumentLineIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return accountingDocumentLine;
  }
  // 断舍离
  public void breakWithAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine) {

    if (accountingDocumentLine == null) {
      return;
    }
    accountingDocumentLine.setAccountingSubject(null);
    // getAccountingDocumentLineList().remove();

  }

  public boolean hasAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine) {

    return getAccountingDocumentLineList().contains(accountingDocumentLine);
  }

  public void copyAccountingDocumentLineFrom(AccountingDocumentLine accountingDocumentLine) {

    AccountingDocumentLine accountingDocumentLineInList =
        findTheAccountingDocumentLine(accountingDocumentLine);
    AccountingDocumentLine newAccountingDocumentLine = new AccountingDocumentLine();
    accountingDocumentLineInList.copyTo(newAccountingDocumentLine);
    newAccountingDocumentLine.setVersion(0); // will trigger copy
    getAccountingDocumentLineList().add(newAccountingDocumentLine);
    addItemToFlexiableObject(COPIED_CHILD, newAccountingDocumentLine);
  }

  public AccountingDocumentLine findTheAccountingDocumentLine(
      AccountingDocumentLine accountingDocumentLine) {

    int index = getAccountingDocumentLineList().indexOf(accountingDocumentLine);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "AccountingDocumentLine("
              + accountingDocumentLine.getId()
              + ") with version='"
              + accountingDocumentLine.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getAccountingDocumentLineList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpAccountingDocumentLineList() {
    getAccountingDocumentLineList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getAccountSet(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getAccountingDocumentLineList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getAccountingDocumentLineList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, ACCOUNTING_SUBJECT_CODE_PROPERTY, getAccountingSubjectCode());
    appendKeyValuePair(result, ACCOUNTING_SUBJECT_NAME_PROPERTY, getAccountingSubjectName());
    appendKeyValuePair(
        result, ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, getAccountingSubjectClassCode());
    appendKeyValuePair(
        result, ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, getAccountingSubjectClassName());
    appendKeyValuePair(result, ACCOUNT_SET_PROPERTY, getAccountSet());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, ACCOUNTING_DOCUMENT_LINE_LIST, getAccountingDocumentLineList());
    if (!getAccountingDocumentLineList().isEmpty()) {
      appendKeyValuePair(
          result, "accountingDocumentLineCount", getAccountingDocumentLineList().getTotalCount());
      appendKeyValuePair(
          result,
          "accountingDocumentLineCurrentPageNumber",
          getAccountingDocumentLineList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof AccountingSubject) {

      AccountingSubject dest = (AccountingSubject) baseDest;

      dest.setId(getId());
      dest.setAccountingSubjectCode(getAccountingSubjectCode());
      dest.setAccountingSubjectName(getAccountingSubjectName());
      dest.setAccountingSubjectClassCode(getAccountingSubjectClassCode());
      dest.setAccountingSubjectClassName(getAccountingSubjectClassName());
      dest.setAccountSet(getAccountSet());
      dest.setVersion(getVersion());
      dest.setAccountingDocumentLineList(getAccountingDocumentLineList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof AccountingSubject) {

      AccountingSubject source = (AccountingSubject) sourceEntity;

      mergeId(source.getId());
      mergeAccountingSubjectCode(source.getAccountingSubjectCode());
      mergeAccountingSubjectName(source.getAccountingSubjectName());
      mergeAccountingSubjectClassCode(source.getAccountingSubjectClassCode());
      mergeAccountingSubjectClassName(source.getAccountingSubjectClassName());
      mergeAccountSet(source.getAccountSet());
      mergeVersion(source.getVersion());
      mergeAccountingDocumentLineList(source.getAccountingDocumentLineList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof AccountingSubject) {

      AccountingSubject source = (AccountingSubject) sourceEntity;

      mergeId(source.getId());
      mergeAccountingSubjectCode(source.getAccountingSubjectCode());
      mergeAccountingSubjectName(source.getAccountingSubjectName());
      mergeAccountingSubjectClassCode(source.getAccountingSubjectClassCode());
      mergeAccountingSubjectClassName(source.getAccountingSubjectClassName());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getAccountingSubjectCode(),
      getAccountingSubjectName(),
      getAccountingSubjectClassCode(),
      getAccountingSubjectClassName(),
      getAccountSet(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    AccountingSubject checkAccountingSubject =
        Q.accountingSubjectWithIdField()
            .filterById(id)
            .selectAccountingDocumentLineList(Q.accountingDocumentLineWithIdField().limit(0, 1))
            .execute(ctx);

    return checkAccountingSubject != null
        && !checkAccountingSubject.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public AccountingSubject save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("AccountingSubject{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\taccountingSubjectCode='" + getAccountingSubjectCode() + "';");
    stringBuilder.append("\taccountingSubjectName='" + getAccountingSubjectName() + "';");
    stringBuilder.append("\taccountingSubjectClassCode='" + getAccountingSubjectClassCode() + "';");
    stringBuilder.append("\taccountingSubjectClassName='" + getAccountingSubjectClassName() + "';");
    if (getAccountSet() != null) {
      stringBuilder.append("\taccountSet='AccountSet(" + getAccountSet().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increaseAccountingSubjectClassCode(int incAccountingSubjectClassCode) {
    updateAccountingSubjectClassCode(
        this.accountingSubjectClassCode + incAccountingSubjectClassCode);
  }

  public void decreaseAccountingSubjectClassCode(int decAccountingSubjectClassCode) {
    updateAccountingSubjectClassCode(
        this.accountingSubjectClassCode - decAccountingSubjectClassCode);
  }
}
