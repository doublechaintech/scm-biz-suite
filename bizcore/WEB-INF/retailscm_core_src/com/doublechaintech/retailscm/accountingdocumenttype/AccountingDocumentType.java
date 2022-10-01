package com.doublechaintech.retailscm.accountingdocumenttype;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;

@JsonSerialize(using = AccountingDocumentTypeSerializer.class)
public class AccountingDocumentType extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(AccountingDocumentType target) {
    if (target == null) {
      return;
    }
    target.addAccountingDocumentList(this.getAccountingDocumentList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String ACCOUNTING_PERIOD_PROPERTY = "accountingPeriod";
  public static final String VERSION_PROPERTY = "version";

  public static final String ACCOUNTING_DOCUMENT_LIST = "accountingDocumentList";

  public static final String INTERNAL_TYPE = "AccountingDocumentType";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ACCOUNTING_PERIOD_PROPERTY, "account_set", "会计期间")
            .withType("account_set", AccountSet.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(ACCOUNTING_DOCUMENT_LIST, "documentType", "会计文档列表")
            .withType("accounting_document", AccountingDocument.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, NAME_PROPERTY, DESCRIPTION_PROPERTY, ACCOUNTING_PERIOD_PROPERTY, VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(ACCOUNTING_DOCUMENT_LIST, "documentType");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(ACCOUNTING_DOCUMENT_LIST, AccountingDocument.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(ACCOUNTING_PERIOD_PROPERTY, AccountSet.class);

    return parents;
  }
  /*
  public AccountingDocumentType want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public AccountingDocumentType wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getName();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;
  protected String description;
  protected AccountSet accountingPeriod;
  protected int version;

  protected SmartList<AccountingDocument> mAccountingDocumentList;

  public AccountingDocumentType() {
    // lazy load for all the properties
  }

  public static AccountingDocumentType withId(String id) {
    AccountingDocumentType accountingDocumentType = new AccountingDocumentType();
    accountingDocumentType.setId(id);
    accountingDocumentType.setVersion(Integer.MAX_VALUE);
    accountingDocumentType.setChecked(true);
    return accountingDocumentType;
  }

  public static AccountingDocumentType refById(String id) {
    return withId(id);
  }

  public AccountingDocumentType limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public AccountingDocumentType limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static AccountingDocumentType searchExample() {
    AccountingDocumentType accountingDocumentType = new AccountingDocumentType();
    accountingDocumentType.setVersion(UNSET_INT);

    return accountingDocumentType;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setAccountingPeriod( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      changeDescriptionProperty(newValueExpr);
    }
  }

  protected void changeNameProperty(String newValueExpr) {

    String oldValue = getName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateName(newValue);
    this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDescriptionProperty(String newValueExpr) {

    String oldValue = getDescription();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDescription(newValue);
    this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (ACCOUNTING_PERIOD_PROPERTY.equals(property)) {
      return getAccountingPeriod();
    }
    if (ACCOUNTING_DOCUMENT_LIST.equals(property)) {
      List<BaseEntity> list =
          getAccountingDocumentList().stream().map(item -> item).collect(Collectors.toList());
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

  public AccountingDocumentType updateId(String id) {
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

  public AccountingDocumentType orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public AccountingDocumentType ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public AccountingDocumentType addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setName(String name) {
    String oldName = this.name;
    String newName = trimString(name);
    this.name = newName;
  }

  public String name() {
    doLoad();
    return getName();
  }

  public String getName() {
    return this.name;
  }

  public AccountingDocumentType updateName(String name) {
    String oldName = this.name;
    String newName = trimString(name);
    if (!shouldReplaceBy(newName, oldName)) {
      return this;
    }
    this.name = newName;
    if (cn.hutool.core.util.ObjectUtil.equals(newName, oldName)) {
      return this;
    }
    addPropertyChange(NAME_PROPERTY, oldName, newName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingDocumentType orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public AccountingDocumentType ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public AccountingDocumentType addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setDescription(String description) {
    String oldDescription = this.description;
    String newDescription = trimString(description);
    this.description = newDescription;
  }

  public String description() {
    doLoad();
    return getDescription();
  }

  public String getDescription() {
    return this.description;
  }

  public AccountingDocumentType updateDescription(String description) {
    String oldDescription = this.description;
    String newDescription = trimString(description);
    if (!shouldReplaceBy(newDescription, oldDescription)) {
      return this;
    }
    this.description = newDescription;
    if (cn.hutool.core.util.ObjectUtil.equals(newDescription, oldDescription)) {
      return this;
    }
    addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingDocumentType orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public AccountingDocumentType ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public AccountingDocumentType addDescriptionCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDescription(String description) {
    if (description != null) {
      updateDescription(description);
    }
  }

  public void setAccountingPeriod(AccountSet accountingPeriod) {
    AccountSet oldAccountingPeriod = this.accountingPeriod;
    AccountSet newAccountingPeriod = accountingPeriod;
    this.accountingPeriod = newAccountingPeriod;
  }

  public AccountSet accountingPeriod() {
    doLoad();
    return getAccountingPeriod();
  }

  public AccountSet getAccountingPeriod() {
    return this.accountingPeriod;
  }

  public AccountingDocumentType updateAccountingPeriod(AccountSet accountingPeriod) {
    AccountSet oldAccountingPeriod = this.accountingPeriod;
    AccountSet newAccountingPeriod = accountingPeriod;
    if (!shouldReplaceBy(newAccountingPeriod, oldAccountingPeriod)) {
      return this;
    }
    this.accountingPeriod = newAccountingPeriod;
    if (cn.hutool.core.util.ObjectUtil.equals(newAccountingPeriod, oldAccountingPeriod)) {
      return this;
    }
    addPropertyChange(ACCOUNTING_PERIOD_PROPERTY, oldAccountingPeriod, newAccountingPeriod);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingDocumentType orderByAccountingPeriod(boolean asc) {
    doAddOrderBy(ACCOUNTING_PERIOD_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountingPeriodCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNTING_PERIOD_PROPERTY, operator, parameters);
  }

  public AccountingDocumentType ignoreAccountingPeriodCriteria() {
    super.ignoreSearchProperty(ACCOUNTING_PERIOD_PROPERTY);
    return this;
  }

  public AccountingDocumentType addAccountingPeriodCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountingPeriodCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountingPeriod(AccountSet accountingPeriod) {
    if (accountingPeriod != null) {
      updateAccountingPeriod(accountingPeriod);
    }
  }

  public AccountingDocumentType updateAccountingPeriodByReferenceId(String accountingPeriodId) {
    updateAccountingPeriod(AccountSet.refById(accountingPeriodId));
    return this;
  }

  public void clearAccountingPeriod() {
    setAccountingPeriod(null);
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

  public AccountingDocumentType updateVersion(int version) {
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

  public AccountingDocumentType orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public AccountingDocumentType ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public AccountingDocumentType addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<AccountingDocument> getAccountingDocumentList() {
    if (this.mAccountingDocumentList == null) {
      this.mAccountingDocumentList = new SmartList<AccountingDocument>();
      this.mAccountingDocumentList.setListInternalName(ACCOUNTING_DOCUMENT_LIST);
      // 有名字，便于做权限控制
    }

    return this.mAccountingDocumentList;
  }

  public SmartList<AccountingDocument> accountingDocumentList() {

    doLoadChild(ACCOUNTING_DOCUMENT_LIST);

    return getAccountingDocumentList();
  }

  public void setAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList) {
    for (AccountingDocument accountingDocument : accountingDocumentList) {
      accountingDocument.setDocumentType(this);
    }

    this.mAccountingDocumentList = accountingDocumentList;
    this.mAccountingDocumentList.setListInternalName(ACCOUNTING_DOCUMENT_LIST);
  }

  public AccountingDocumentType addAccountingDocument(AccountingDocument accountingDocument) {
    accountingDocument.updateDocumentType(this);
    getAccountingDocumentList().add(accountingDocument);
    return this;
  }

  public AccountingDocumentType addAccountingDocumentList(
      SmartList<AccountingDocument> accountingDocumentList) {
    for (AccountingDocument accountingDocument : accountingDocumentList) {
      accountingDocument.updateDocumentType(this);
    }

    Map<String, AccountingDocument> mapById = accountingDocumentList.mapWithId();
    getAccountingDocumentList().removeIf(item -> mapById.get(item.getId()) != null);
    getAccountingDocumentList().addAll(accountingDocumentList);
    return this;
  }

  public void mergeAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList) {
    if (accountingDocumentList == null) {
      return;
    }
    if (accountingDocumentList.isEmpty()) {
      return;
    }
    addAccountingDocumentList(accountingDocumentList);
  }

  public AccountingDocument removeAccountingDocument(AccountingDocument accountingDocumentIndex) {

    int index = getAccountingDocumentList().indexOf(accountingDocumentIndex);
    if (index < 0) {
      String message =
          "AccountingDocument("
              + accountingDocumentIndex.getId()
              + ") with version='"
              + accountingDocumentIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    AccountingDocument accountingDocument = getAccountingDocumentList().get(index);
    // accountingDocument.clearDocumentType(); //disconnect with DocumentType
    accountingDocument.clearFromAll(); // disconnect with DocumentType

    boolean result = getAccountingDocumentList().planToRemove(accountingDocument);
    if (!result) {
      String message =
          "AccountingDocument("
              + accountingDocumentIndex.getId()
              + ") with version='"
              + accountingDocumentIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return accountingDocument;
  }
  // 断舍离
  public void breakWithAccountingDocument(AccountingDocument accountingDocument) {

    if (accountingDocument == null) {
      return;
    }
    accountingDocument.setDocumentType(null);
    // getAccountingDocumentList().remove();

  }

  public boolean hasAccountingDocument(AccountingDocument accountingDocument) {

    return getAccountingDocumentList().contains(accountingDocument);
  }

  public void copyAccountingDocumentFrom(AccountingDocument accountingDocument) {

    AccountingDocument accountingDocumentInList = findTheAccountingDocument(accountingDocument);
    AccountingDocument newAccountingDocument = new AccountingDocument();
    accountingDocumentInList.copyTo(newAccountingDocument);
    newAccountingDocument.setVersion(0); // will trigger copy
    getAccountingDocumentList().add(newAccountingDocument);
    addItemToFlexiableObject(COPIED_CHILD, newAccountingDocument);
  }

  public AccountingDocument findTheAccountingDocument(AccountingDocument accountingDocument) {

    int index = getAccountingDocumentList().indexOf(accountingDocument);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "AccountingDocument("
              + accountingDocument.getId()
              + ") with version='"
              + accountingDocument.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getAccountingDocumentList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpAccountingDocumentList() {
    getAccountingDocumentList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getAccountingPeriod(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getAccountingDocumentList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getAccountingDocumentList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, ACCOUNTING_PERIOD_PROPERTY, getAccountingPeriod());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, ACCOUNTING_DOCUMENT_LIST, getAccountingDocumentList());
    if (!getAccountingDocumentList().isEmpty()) {
      appendKeyValuePair(
          result, "accountingDocumentCount", getAccountingDocumentList().getTotalCount());
      appendKeyValuePair(
          result,
          "accountingDocumentCurrentPageNumber",
          getAccountingDocumentList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof AccountingDocumentType) {

      AccountingDocumentType dest = (AccountingDocumentType) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setDescription(getDescription());
      dest.setAccountingPeriod(getAccountingPeriod());
      dest.setVersion(getVersion());
      dest.setAccountingDocumentList(getAccountingDocumentList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof AccountingDocumentType) {

      AccountingDocumentType source = (AccountingDocumentType) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeDescription(source.getDescription());
      mergeAccountingPeriod(source.getAccountingPeriod());
      mergeVersion(source.getVersion());
      mergeAccountingDocumentList(source.getAccountingDocumentList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof AccountingDocumentType) {

      AccountingDocumentType source = (AccountingDocumentType) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getName(), getDescription(), getAccountingPeriod(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    AccountingDocumentType checkAccountingDocumentType =
        Q.accountingDocumentTypeWithIdField()
            .filterById(id)
            .selectAccountingDocumentList(Q.accountingDocumentWithIdField().limit(0, 1))
            .execute(ctx);

    return checkAccountingDocumentType != null
        && !checkAccountingDocumentType.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public AccountingDocumentType save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("AccountingDocumentType{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    if (getAccountingPeriod() != null) {
      stringBuilder.append(
          "\taccountingPeriod='AccountSet(" + getAccountingPeriod().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
