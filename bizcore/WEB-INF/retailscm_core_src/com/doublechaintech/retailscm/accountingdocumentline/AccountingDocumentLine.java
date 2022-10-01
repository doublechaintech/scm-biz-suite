package com.doublechaintech.retailscm.accountingdocumentline;

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
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;

@JsonSerialize(using = AccountingDocumentLineSerializer.class)
public class AccountingDocumentLine extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(AccountingDocumentLine target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String CODE_PROPERTY = "code";
  public static final String DIRECT_PROPERTY = "direct";
  public static final String AMOUNT_PROPERTY = "amount";
  public static final String BELONGS_TO_PROPERTY = "belongsTo";
  public static final String ACCOUNTING_SUBJECT_PROPERTY = "accountingSubject";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "AccountingDocumentLine";

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
        MemberMetaInfo.defineBy(CODE_PROPERTY, "code", "代码").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DIRECT_PROPERTY, "direct", "直接").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额").withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BELONGS_TO_PROPERTY, "accounting_document", "属于")
            .withType("accounting_document", AccountingDocument.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ACCOUNTING_SUBJECT_PROPERTY, "accounting_subject", "会计科目")
            .withType("accounting_subject", AccountingSubject.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      CODE_PROPERTY,
      DIRECT_PROPERTY,
      AMOUNT_PROPERTY,
      BELONGS_TO_PROPERTY,
      ACCOUNTING_SUBJECT_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BELONGS_TO_PROPERTY, AccountingDocument.class);
    parents.put(ACCOUNTING_SUBJECT_PROPERTY, AccountingSubject.class);

    return parents;
  }
  /*
  public AccountingDocumentLine want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public AccountingDocumentLine wants(Class<? extends BaseEntity>... classes) {
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
  protected String code;
  protected String direct;
  protected BigDecimal amount;
  protected AccountingDocument belongsTo;
  protected AccountingSubject accountingSubject;
  protected int version;

  public AccountingDocumentLine() {
    // lazy load for all the properties
  }

  public static AccountingDocumentLine withId(String id) {
    AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
    accountingDocumentLine.setId(id);
    accountingDocumentLine.setVersion(Integer.MAX_VALUE);
    accountingDocumentLine.setChecked(true);
    return accountingDocumentLine;
  }

  public static AccountingDocumentLine refById(String id) {
    return withId(id);
  }

  public AccountingDocumentLine limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public AccountingDocumentLine limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static AccountingDocumentLine searchExample() {
    AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
    accountingDocumentLine.setVersion(UNSET_INT);

    return accountingDocumentLine;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setBelongsTo( null );
  	setAccountingSubject( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (CODE_PROPERTY.equals(property)) {
      changeCodeProperty(newValueExpr);
    }
    if (DIRECT_PROPERTY.equals(property)) {
      changeDirectProperty(newValueExpr);
    }
    if (AMOUNT_PROPERTY.equals(property)) {
      changeAmountProperty(newValueExpr);
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

  protected void changeCodeProperty(String newValueExpr) {

    String oldValue = getCode();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateCode(newValue);
    this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDirectProperty(String newValueExpr) {

    String oldValue = getDirect();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDirect(newValue);
    this.onChangeProperty(DIRECT_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAmountProperty(String newValueExpr) {

    BigDecimal oldValue = getAmount();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAmount(newValue);
    this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (CODE_PROPERTY.equals(property)) {
      return getCode();
    }
    if (DIRECT_PROPERTY.equals(property)) {
      return getDirect();
    }
    if (AMOUNT_PROPERTY.equals(property)) {
      return getAmount();
    }
    if (BELONGS_TO_PROPERTY.equals(property)) {
      return getBelongsTo();
    }
    if (ACCOUNTING_SUBJECT_PROPERTY.equals(property)) {
      return getAccountingSubject();
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

  public AccountingDocumentLine updateId(String id) {
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

  public AccountingDocumentLine orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public AccountingDocumentLine ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public AccountingDocumentLine addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public AccountingDocumentLine updateName(String name) {
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

  public AccountingDocumentLine orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public AccountingDocumentLine ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public AccountingDocumentLine addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setCode(String code) {
    String oldCode = this.code;
    String newCode = trimString(code);
    this.code = newCode;
  }

  public String code() {
    doLoad();
    return getCode();
  }

  public String getCode() {
    return this.code;
  }

  public AccountingDocumentLine updateCode(String code) {
    String oldCode = this.code;
    String newCode = trimString(code);
    if (!shouldReplaceBy(newCode, oldCode)) {
      return this;
    }
    this.code = newCode;
    if (cn.hutool.core.util.ObjectUtil.equals(newCode, oldCode)) {
      return this;
    }
    addPropertyChange(CODE_PROPERTY, oldCode, newCode);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingDocumentLine orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public AccountingDocumentLine ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public AccountingDocumentLine addCodeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCode(String code) {
    if (code != null) {
      updateCode(code);
    }
  }

  public void setDirect(String direct) {
    String oldDirect = this.direct;
    String newDirect = trimString(direct);
    this.direct = newDirect;
  }

  public String direct() {
    doLoad();
    return getDirect();
  }

  public String getDirect() {
    return this.direct;
  }

  public AccountingDocumentLine updateDirect(String direct) {
    String oldDirect = this.direct;
    String newDirect = trimString(direct);
    if (!shouldReplaceBy(newDirect, oldDirect)) {
      return this;
    }
    this.direct = newDirect;
    if (cn.hutool.core.util.ObjectUtil.equals(newDirect, oldDirect)) {
      return this;
    }
    addPropertyChange(DIRECT_PROPERTY, oldDirect, newDirect);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingDocumentLine orderByDirect(boolean asc) {
    doAddOrderBy(DIRECT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDirectCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DIRECT_PROPERTY, operator, parameters);
  }

  public AccountingDocumentLine ignoreDirectCriteria() {
    super.ignoreSearchProperty(DIRECT_PROPERTY);
    return this;
  }

  public AccountingDocumentLine addDirectCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDirectCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDirect(String direct) {
    if (direct != null) {
      updateDirect(direct);
    }
  }

  public void setAmount(BigDecimal amount) {
    BigDecimal oldAmount = this.amount;
    BigDecimal newAmount = amount;
    this.amount = newAmount;
  }

  public BigDecimal amount() {
    doLoad();
    return getAmount();
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public AccountingDocumentLine updateAmount(BigDecimal amount) {
    BigDecimal oldAmount = this.amount;
    BigDecimal newAmount = amount;
    if (!shouldReplaceBy(newAmount, oldAmount)) {
      return this;
    }
    this.amount = newAmount;
    if (cn.hutool.core.util.ObjectUtil.equals(newAmount, oldAmount)) {
      return this;
    }
    addPropertyChange(AMOUNT_PROPERTY, oldAmount, newAmount);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingDocumentLine orderByAmount(boolean asc) {
    doAddOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(AMOUNT_PROPERTY, operator, parameters);
  }

  public AccountingDocumentLine ignoreAmountCriteria() {
    super.ignoreSearchProperty(AMOUNT_PROPERTY);
    return this;
  }

  public AccountingDocumentLine addAmountCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAmountCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAmount(BigDecimal amount) {
    updateAmount(amount);
  }

  public void setBelongsTo(AccountingDocument belongsTo) {
    AccountingDocument oldBelongsTo = this.belongsTo;
    AccountingDocument newBelongsTo = belongsTo;
    this.belongsTo = newBelongsTo;
  }

  public AccountingDocument belongsTo() {
    doLoad();
    return getBelongsTo();
  }

  public AccountingDocument getBelongsTo() {
    return this.belongsTo;
  }

  public AccountingDocumentLine updateBelongsTo(AccountingDocument belongsTo) {
    AccountingDocument oldBelongsTo = this.belongsTo;
    AccountingDocument newBelongsTo = belongsTo;
    if (!shouldReplaceBy(newBelongsTo, oldBelongsTo)) {
      return this;
    }
    this.belongsTo = newBelongsTo;
    if (cn.hutool.core.util.ObjectUtil.equals(newBelongsTo, oldBelongsTo)) {
      return this;
    }
    addPropertyChange(BELONGS_TO_PROPERTY, oldBelongsTo, newBelongsTo);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingDocumentLine orderByBelongsTo(boolean asc) {
    doAddOrderBy(BELONGS_TO_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBelongsToCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BELONGS_TO_PROPERTY, operator, parameters);
  }

  public AccountingDocumentLine ignoreBelongsToCriteria() {
    super.ignoreSearchProperty(BELONGS_TO_PROPERTY);
    return this;
  }

  public AccountingDocumentLine addBelongsToCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBelongsToCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBelongsTo(AccountingDocument belongsTo) {
    if (belongsTo != null) {
      updateBelongsTo(belongsTo);
    }
  }

  public AccountingDocumentLine updateBelongsToByReferenceId(String belongsToId) {
    updateBelongsTo(AccountingDocument.refById(belongsToId));
    return this;
  }

  public void clearBelongsTo() {
    setBelongsTo(null);
    this.changed = true;
    setChecked(false);
  }

  public void setAccountingSubject(AccountingSubject accountingSubject) {
    AccountingSubject oldAccountingSubject = this.accountingSubject;
    AccountingSubject newAccountingSubject = accountingSubject;
    this.accountingSubject = newAccountingSubject;
  }

  public AccountingSubject accountingSubject() {
    doLoad();
    return getAccountingSubject();
  }

  public AccountingSubject getAccountingSubject() {
    return this.accountingSubject;
  }

  public AccountingDocumentLine updateAccountingSubject(AccountingSubject accountingSubject) {
    AccountingSubject oldAccountingSubject = this.accountingSubject;
    AccountingSubject newAccountingSubject = accountingSubject;
    if (!shouldReplaceBy(newAccountingSubject, oldAccountingSubject)) {
      return this;
    }
    this.accountingSubject = newAccountingSubject;
    if (cn.hutool.core.util.ObjectUtil.equals(newAccountingSubject, oldAccountingSubject)) {
      return this;
    }
    addPropertyChange(ACCOUNTING_SUBJECT_PROPERTY, oldAccountingSubject, newAccountingSubject);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountingDocumentLine orderByAccountingSubject(boolean asc) {
    doAddOrderBy(ACCOUNTING_SUBJECT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountingSubjectCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNTING_SUBJECT_PROPERTY, operator, parameters);
  }

  public AccountingDocumentLine ignoreAccountingSubjectCriteria() {
    super.ignoreSearchProperty(ACCOUNTING_SUBJECT_PROPERTY);
    return this;
  }

  public AccountingDocumentLine addAccountingSubjectCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountingSubjectCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountingSubject(AccountingSubject accountingSubject) {
    if (accountingSubject != null) {
      updateAccountingSubject(accountingSubject);
    }
  }

  public AccountingDocumentLine updateAccountingSubjectByReferenceId(String accountingSubjectId) {
    updateAccountingSubject(AccountingSubject.refById(accountingSubjectId));
    return this;
  }

  public void clearAccountingSubject() {
    setAccountingSubject(null);
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

  public AccountingDocumentLine updateVersion(int version) {
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

  public AccountingDocumentLine orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public AccountingDocumentLine ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public AccountingDocumentLine addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getBelongsTo(), internalType);
    addToEntityList(this, entityList, getAccountingSubject(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, CODE_PROPERTY, getCode());
    appendKeyValuePair(result, DIRECT_PROPERTY, getDirect());
    appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
    appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
    appendKeyValuePair(result, ACCOUNTING_SUBJECT_PROPERTY, getAccountingSubject());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof AccountingDocumentLine) {

      AccountingDocumentLine dest = (AccountingDocumentLine) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setCode(getCode());
      dest.setDirect(getDirect());
      dest.setAmount(getAmount());
      dest.setBelongsTo(getBelongsTo());
      dest.setAccountingSubject(getAccountingSubject());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof AccountingDocumentLine) {

      AccountingDocumentLine source = (AccountingDocumentLine) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeCode(source.getCode());
      mergeDirect(source.getDirect());
      mergeAmount(source.getAmount());
      mergeBelongsTo(source.getBelongsTo());
      mergeAccountingSubject(source.getAccountingSubject());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof AccountingDocumentLine) {

      AccountingDocumentLine source = (AccountingDocumentLine) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeCode(source.getCode());
      mergeDirect(source.getDirect());
      mergeAmount(source.getAmount());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getName(),
      getCode(),
      getDirect(),
      getAmount(),
      getBelongsTo(),
      getAccountingSubject(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    AccountingDocumentLine checkAccountingDocumentLine =
        Q.accountingDocumentLineWithIdField().filterById(id).execute(ctx);

    return checkAccountingDocumentLine != null
        && !checkAccountingDocumentLine.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public AccountingDocumentLine save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("AccountingDocumentLine{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    stringBuilder.append("\tdirect='" + getDirect() + "';");
    stringBuilder.append("\tamount='" + getAmount() + "';");
    if (getBelongsTo() != null) {
      stringBuilder.append("\tbelongsTo='AccountingDocument(" + getBelongsTo().getId() + ")';");
    }
    if (getAccountingSubject() != null) {
      stringBuilder.append(
          "\taccountingSubject='AccountingSubject(" + getAccountingSubject().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
