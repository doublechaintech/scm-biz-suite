package com.doublechaintech.retailscm.accountset;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

@JsonSerialize(using = AccountSetSerializer.class)
public class AccountSet extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(AccountSet target) {
    if (target == null) {
      return;
    }
    target.addAccountingSubjectList(this.getAccountingSubjectList());
    target.addAccountingPeriodList(this.getAccountingPeriodList());
    target.addAccountingDocumentTypeList(this.getAccountingDocumentTypeList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String YEAR_SET_PROPERTY = "yearSet";
  public static final String EFFECTIVE_DATE_PROPERTY = "effectiveDate";
  public static final String ACCOUNTING_SYSTEM_PROPERTY = "accountingSystem";
  public static final String DOMESTIC_CURRENCY_CODE_PROPERTY = "domesticCurrencyCode";
  public static final String DOMESTIC_CURRENCY_NAME_PROPERTY = "domesticCurrencyName";
  public static final String OPENING_BANK_PROPERTY = "openingBank";
  public static final String ACCOUNT_NUMBER_PROPERTY = "accountNumber";
  public static final String COUNTRY_CENTER_PROPERTY = "countryCenter";
  public static final String RETAIL_STORE_PROPERTY = "retailStore";
  public static final String GOODS_SUPPLIER_PROPERTY = "goodsSupplier";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String ACCOUNTING_SUBJECT_LIST = "accountingSubjectList";
  public static final String ACCOUNTING_PERIOD_LIST = "accountingPeriodList";
  public static final String ACCOUNTING_DOCUMENT_TYPE_LIST = "accountingDocumentTypeList";

  public static final String INTERNAL_TYPE = "AccountSet";

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
        MemberMetaInfo.defineBy(YEAR_SET_PROPERTY, "year_set", "年组")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(EFFECTIVE_DATE_PROPERTY, "effective_date", "生效日期")
            .withType("date", Date.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ACCOUNTING_SYSTEM_PROPERTY, "accounting_system", "会计制度")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DOMESTIC_CURRENCY_CODE_PROPERTY, "domestic_currency_code", "本币代码")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DOMESTIC_CURRENCY_NAME_PROPERTY, "domestic_currency_name", "本币名称")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(OPENING_BANK_PROPERTY, "opening_bank", "开户银行")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ACCOUNT_NUMBER_PROPERTY, "account_number", "帐户号码")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COUNTRY_CENTER_PROPERTY, "retail_store_country_center", "全国运营中心")
            .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(RETAIL_STORE_PROPERTY, "retail_store", "双链小超")
            .withType("retail_store", RetailStore.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(GOODS_SUPPLIER_PROPERTY, "goods_supplier", "产品供应商")
            .withType("goods_supplier", GoodsSupplier.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
            .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(ACCOUNTING_SUBJECT_LIST, "accountSet", "会计科目表")
            .withType("accounting_subject", AccountingSubject.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(ACCOUNTING_PERIOD_LIST, "accountSet", "会计期间列表")
            .withType("accounting_period", AccountingPeriod.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(ACCOUNTING_DOCUMENT_TYPE_LIST, "accountingPeriod", "会计凭证种类表")
            .withType("accounting_document_type", AccountingDocumentType.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      YEAR_SET_PROPERTY,
      EFFECTIVE_DATE_PROPERTY,
      ACCOUNTING_SYSTEM_PROPERTY,
      DOMESTIC_CURRENCY_CODE_PROPERTY,
      DOMESTIC_CURRENCY_NAME_PROPERTY,
      OPENING_BANK_PROPERTY,
      ACCOUNT_NUMBER_PROPERTY,
      COUNTRY_CENTER_PROPERTY,
      RETAIL_STORE_PROPERTY,
      GOODS_SUPPLIER_PROPERTY,
      LAST_UPDATE_TIME_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(ACCOUNTING_SUBJECT_LIST, "accountSet");

    refers.put(ACCOUNTING_PERIOD_LIST, "accountSet");

    refers.put(ACCOUNTING_DOCUMENT_TYPE_LIST, "accountingPeriod");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(ACCOUNTING_SUBJECT_LIST, AccountingSubject.class);

    refers.put(ACCOUNTING_PERIOD_LIST, AccountingPeriod.class);

    refers.put(ACCOUNTING_DOCUMENT_TYPE_LIST, AccountingDocumentType.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COUNTRY_CENTER_PROPERTY, RetailStoreCountryCenter.class);
    parents.put(RETAIL_STORE_PROPERTY, RetailStore.class);
    parents.put(GOODS_SUPPLIER_PROPERTY, GoodsSupplier.class);

    return parents;
  }
  /*
  public AccountSet want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public AccountSet wants(Class<? extends BaseEntity>... classes) {
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
  protected String yearSet;
  protected Date effectiveDate;
  protected String accountingSystem;
  protected String domesticCurrencyCode;
  protected String domesticCurrencyName;
  protected String openingBank;
  protected String accountNumber;
  protected RetailStoreCountryCenter countryCenter;
  protected RetailStore retailStore;
  protected GoodsSupplier goodsSupplier;
  protected DateTime lastUpdateTime;
  protected int version;

  protected SmartList<AccountingSubject> mAccountingSubjectList;
  protected SmartList<AccountingPeriod> mAccountingPeriodList;
  protected SmartList<AccountingDocumentType> mAccountingDocumentTypeList;

  public AccountSet() {
    // lazy load for all the properties
  }

  public static AccountSet withId(String id) {
    AccountSet accountSet = new AccountSet();
    accountSet.setId(id);
    accountSet.setVersion(Integer.MAX_VALUE);
    accountSet.setChecked(true);
    return accountSet;
  }

  public static AccountSet refById(String id) {
    return withId(id);
  }

  public AccountSet limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public AccountSet limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static AccountSet searchExample() {
    AccountSet accountSet = new AccountSet();
    accountSet.setVersion(UNSET_INT);

    return accountSet;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setCountryCenter( null );
  	setRetailStore( null );
  	setGoodsSupplier( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (YEAR_SET_PROPERTY.equals(property)) {
      changeYearSetProperty(newValueExpr);
    }
    if (EFFECTIVE_DATE_PROPERTY.equals(property)) {
      changeEffectiveDateProperty(newValueExpr);
    }
    if (ACCOUNTING_SYSTEM_PROPERTY.equals(property)) {
      changeAccountingSystemProperty(newValueExpr);
    }
    if (DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)) {
      changeDomesticCurrencyCodeProperty(newValueExpr);
    }
    if (DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)) {
      changeDomesticCurrencyNameProperty(newValueExpr);
    }
    if (OPENING_BANK_PROPERTY.equals(property)) {
      changeOpeningBankProperty(newValueExpr);
    }
    if (ACCOUNT_NUMBER_PROPERTY.equals(property)) {
      changeAccountNumberProperty(newValueExpr);
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      changeLastUpdateTimeProperty(newValueExpr);
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

  protected void changeYearSetProperty(String newValueExpr) {

    String oldValue = getYearSet();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateYearSet(newValue);
    this.onChangeProperty(YEAR_SET_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeEffectiveDateProperty(String newValueExpr) {

    Date oldValue = getEffectiveDate();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateEffectiveDate(newValue);
    this.onChangeProperty(EFFECTIVE_DATE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAccountingSystemProperty(String newValueExpr) {

    String oldValue = getAccountingSystem();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAccountingSystem(newValue);
    this.onChangeProperty(ACCOUNTING_SYSTEM_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDomesticCurrencyCodeProperty(String newValueExpr) {

    String oldValue = getDomesticCurrencyCode();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDomesticCurrencyCode(newValue);
    this.onChangeProperty(DOMESTIC_CURRENCY_CODE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDomesticCurrencyNameProperty(String newValueExpr) {

    String oldValue = getDomesticCurrencyName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDomesticCurrencyName(newValue);
    this.onChangeProperty(DOMESTIC_CURRENCY_NAME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeOpeningBankProperty(String newValueExpr) {

    String oldValue = getOpeningBank();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateOpeningBank(newValue);
    this.onChangeProperty(OPENING_BANK_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAccountNumberProperty(String newValueExpr) {

    String oldValue = getAccountNumber();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAccountNumber(newValue);
    this.onChangeProperty(ACCOUNT_NUMBER_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLastUpdateTimeProperty(String newValueExpr) {

    DateTime oldValue = getLastUpdateTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLastUpdateTime(newValue);
    this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (YEAR_SET_PROPERTY.equals(property)) {
      return getYearSet();
    }
    if (EFFECTIVE_DATE_PROPERTY.equals(property)) {
      return getEffectiveDate();
    }
    if (ACCOUNTING_SYSTEM_PROPERTY.equals(property)) {
      return getAccountingSystem();
    }
    if (DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)) {
      return getDomesticCurrencyCode();
    }
    if (DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)) {
      return getDomesticCurrencyName();
    }
    if (OPENING_BANK_PROPERTY.equals(property)) {
      return getOpeningBank();
    }
    if (ACCOUNT_NUMBER_PROPERTY.equals(property)) {
      return getAccountNumber();
    }
    if (COUNTRY_CENTER_PROPERTY.equals(property)) {
      return getCountryCenter();
    }
    if (RETAIL_STORE_PROPERTY.equals(property)) {
      return getRetailStore();
    }
    if (GOODS_SUPPLIER_PROPERTY.equals(property)) {
      return getGoodsSupplier();
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      return getLastUpdateTime();
    }
    if (ACCOUNTING_SUBJECT_LIST.equals(property)) {
      List<BaseEntity> list =
          getAccountingSubjectList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (ACCOUNTING_PERIOD_LIST.equals(property)) {
      List<BaseEntity> list =
          getAccountingPeriodList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (ACCOUNTING_DOCUMENT_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getAccountingDocumentTypeList().stream().map(item -> item).collect(Collectors.toList());
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

  public AccountSet updateId(String id) {
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

  public AccountSet orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public AccountSet addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public AccountSet updateName(String name) {
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

  public AccountSet orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public AccountSet addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setYearSet(String yearSet) {
    String oldYearSet = this.yearSet;
    String newYearSet = trimString(yearSet);
    this.yearSet = newYearSet;
  }

  public String yearSet() {
    doLoad();
    return getYearSet();
  }

  public String getYearSet() {
    return this.yearSet;
  }

  public AccountSet updateYearSet(String yearSet) {
    String oldYearSet = this.yearSet;
    String newYearSet = trimString(yearSet);
    if (!shouldReplaceBy(newYearSet, oldYearSet)) {
      return this;
    }
    this.yearSet = newYearSet;
    if (cn.hutool.core.util.ObjectUtil.equals(newYearSet, oldYearSet)) {
      return this;
    }
    addPropertyChange(YEAR_SET_PROPERTY, oldYearSet, newYearSet);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByYearSet(boolean asc) {
    doAddOrderBy(YEAR_SET_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createYearSetCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(YEAR_SET_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreYearSetCriteria() {
    super.ignoreSearchProperty(YEAR_SET_PROPERTY);
    return this;
  }

  public AccountSet addYearSetCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createYearSetCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeYearSet(String yearSet) {
    if (yearSet != null) {
      updateYearSet(yearSet);
    }
  }

  public void setEffectiveDate(Date effectiveDate) {
    Date oldEffectiveDate = this.effectiveDate;
    Date newEffectiveDate = effectiveDate;
    this.effectiveDate = newEffectiveDate;
  }

  public Date effectiveDate() {
    doLoad();
    return getEffectiveDate();
  }

  public Date getEffectiveDate() {
    return this.effectiveDate;
  }

  public AccountSet updateEffectiveDate(Date effectiveDate) {
    Date oldEffectiveDate = this.effectiveDate;
    Date newEffectiveDate = effectiveDate;
    if (!shouldReplaceBy(newEffectiveDate, oldEffectiveDate)) {
      return this;
    }
    this.effectiveDate = newEffectiveDate;
    if (cn.hutool.core.util.ObjectUtil.equals(newEffectiveDate, oldEffectiveDate)) {
      return this;
    }
    addPropertyChange(EFFECTIVE_DATE_PROPERTY, oldEffectiveDate, newEffectiveDate);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByEffectiveDate(boolean asc) {
    doAddOrderBy(EFFECTIVE_DATE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEffectiveDateCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EFFECTIVE_DATE_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreEffectiveDateCriteria() {
    super.ignoreSearchProperty(EFFECTIVE_DATE_PROPERTY);
    return this;
  }

  public AccountSet addEffectiveDateCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEffectiveDateCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEffectiveDate(Date effectiveDate) {
    updateEffectiveDate(effectiveDate);
  }

  public void setAccountingSystem(String accountingSystem) {
    String oldAccountingSystem = this.accountingSystem;
    String newAccountingSystem = trimString(accountingSystem);
    this.accountingSystem = newAccountingSystem;
  }

  public String accountingSystem() {
    doLoad();
    return getAccountingSystem();
  }

  public String getAccountingSystem() {
    return this.accountingSystem;
  }

  public AccountSet updateAccountingSystem(String accountingSystem) {
    String oldAccountingSystem = this.accountingSystem;
    String newAccountingSystem = trimString(accountingSystem);
    if (!shouldReplaceBy(newAccountingSystem, oldAccountingSystem)) {
      return this;
    }
    this.accountingSystem = newAccountingSystem;
    if (cn.hutool.core.util.ObjectUtil.equals(newAccountingSystem, oldAccountingSystem)) {
      return this;
    }
    addPropertyChange(ACCOUNTING_SYSTEM_PROPERTY, oldAccountingSystem, newAccountingSystem);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByAccountingSystem(boolean asc) {
    doAddOrderBy(ACCOUNTING_SYSTEM_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountingSystemCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNTING_SYSTEM_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreAccountingSystemCriteria() {
    super.ignoreSearchProperty(ACCOUNTING_SYSTEM_PROPERTY);
    return this;
  }

  public AccountSet addAccountingSystemCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountingSystemCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountingSystem(String accountingSystem) {
    if (accountingSystem != null) {
      updateAccountingSystem(accountingSystem);
    }
  }

  public void setDomesticCurrencyCode(String domesticCurrencyCode) {
    String oldDomesticCurrencyCode = this.domesticCurrencyCode;
    String newDomesticCurrencyCode = trimString(domesticCurrencyCode);
    this.domesticCurrencyCode = newDomesticCurrencyCode;
  }

  public String domesticCurrencyCode() {
    doLoad();
    return getDomesticCurrencyCode();
  }

  public String getDomesticCurrencyCode() {
    return this.domesticCurrencyCode;
  }

  public AccountSet updateDomesticCurrencyCode(String domesticCurrencyCode) {
    String oldDomesticCurrencyCode = this.domesticCurrencyCode;
    String newDomesticCurrencyCode = trimString(domesticCurrencyCode);
    if (!shouldReplaceBy(newDomesticCurrencyCode, oldDomesticCurrencyCode)) {
      return this;
    }
    this.domesticCurrencyCode = newDomesticCurrencyCode;
    if (cn.hutool.core.util.ObjectUtil.equals(newDomesticCurrencyCode, oldDomesticCurrencyCode)) {
      return this;
    }
    addPropertyChange(
        DOMESTIC_CURRENCY_CODE_PROPERTY, oldDomesticCurrencyCode, newDomesticCurrencyCode);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByDomesticCurrencyCode(boolean asc) {
    doAddOrderBy(DOMESTIC_CURRENCY_CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDomesticCurrencyCodeCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(DOMESTIC_CURRENCY_CODE_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreDomesticCurrencyCodeCriteria() {
    super.ignoreSearchProperty(DOMESTIC_CURRENCY_CODE_PROPERTY);
    return this;
  }

  public AccountSet addDomesticCurrencyCodeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDomesticCurrencyCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDomesticCurrencyCode(String domesticCurrencyCode) {
    if (domesticCurrencyCode != null) {
      updateDomesticCurrencyCode(domesticCurrencyCode);
    }
  }

  public void setDomesticCurrencyName(String domesticCurrencyName) {
    String oldDomesticCurrencyName = this.domesticCurrencyName;
    String newDomesticCurrencyName = trimString(domesticCurrencyName);
    this.domesticCurrencyName = newDomesticCurrencyName;
  }

  public String domesticCurrencyName() {
    doLoad();
    return getDomesticCurrencyName();
  }

  public String getDomesticCurrencyName() {
    return this.domesticCurrencyName;
  }

  public AccountSet updateDomesticCurrencyName(String domesticCurrencyName) {
    String oldDomesticCurrencyName = this.domesticCurrencyName;
    String newDomesticCurrencyName = trimString(domesticCurrencyName);
    if (!shouldReplaceBy(newDomesticCurrencyName, oldDomesticCurrencyName)) {
      return this;
    }
    this.domesticCurrencyName = newDomesticCurrencyName;
    if (cn.hutool.core.util.ObjectUtil.equals(newDomesticCurrencyName, oldDomesticCurrencyName)) {
      return this;
    }
    addPropertyChange(
        DOMESTIC_CURRENCY_NAME_PROPERTY, oldDomesticCurrencyName, newDomesticCurrencyName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByDomesticCurrencyName(boolean asc) {
    doAddOrderBy(DOMESTIC_CURRENCY_NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDomesticCurrencyNameCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(DOMESTIC_CURRENCY_NAME_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreDomesticCurrencyNameCriteria() {
    super.ignoreSearchProperty(DOMESTIC_CURRENCY_NAME_PROPERTY);
    return this;
  }

  public AccountSet addDomesticCurrencyNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDomesticCurrencyNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDomesticCurrencyName(String domesticCurrencyName) {
    if (domesticCurrencyName != null) {
      updateDomesticCurrencyName(domesticCurrencyName);
    }
  }

  public void setOpeningBank(String openingBank) {
    String oldOpeningBank = this.openingBank;
    String newOpeningBank = trimString(openingBank);
    this.openingBank = newOpeningBank;
  }

  public String openingBank() {
    doLoad();
    return getOpeningBank();
  }

  public String getOpeningBank() {
    return this.openingBank;
  }

  public AccountSet updateOpeningBank(String openingBank) {
    String oldOpeningBank = this.openingBank;
    String newOpeningBank = trimString(openingBank);
    if (!shouldReplaceBy(newOpeningBank, oldOpeningBank)) {
      return this;
    }
    this.openingBank = newOpeningBank;
    if (cn.hutool.core.util.ObjectUtil.equals(newOpeningBank, oldOpeningBank)) {
      return this;
    }
    addPropertyChange(OPENING_BANK_PROPERTY, oldOpeningBank, newOpeningBank);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByOpeningBank(boolean asc) {
    doAddOrderBy(OPENING_BANK_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOpeningBankCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OPENING_BANK_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreOpeningBankCriteria() {
    super.ignoreSearchProperty(OPENING_BANK_PROPERTY);
    return this;
  }

  public AccountSet addOpeningBankCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOpeningBankCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOpeningBank(String openingBank) {
    if (openingBank != null) {
      updateOpeningBank(openingBank);
    }
  }

  public void setAccountNumber(String accountNumber) {
    String oldAccountNumber = this.accountNumber;
    String newAccountNumber = trimString(accountNumber);
    this.accountNumber = newAccountNumber;
  }

  public String accountNumber() {
    doLoad();
    return getAccountNumber();
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public AccountSet updateAccountNumber(String accountNumber) {
    String oldAccountNumber = this.accountNumber;
    String newAccountNumber = trimString(accountNumber);
    if (!shouldReplaceBy(newAccountNumber, oldAccountNumber)) {
      return this;
    }
    this.accountNumber = newAccountNumber;
    if (cn.hutool.core.util.ObjectUtil.equals(newAccountNumber, oldAccountNumber)) {
      return this;
    }
    addPropertyChange(ACCOUNT_NUMBER_PROPERTY, oldAccountNumber, newAccountNumber);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByAccountNumber(boolean asc) {
    doAddOrderBy(ACCOUNT_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccountNumberCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ACCOUNT_NUMBER_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreAccountNumberCriteria() {
    super.ignoreSearchProperty(ACCOUNT_NUMBER_PROPERTY);
    return this;
  }

  public AccountSet addAccountNumberCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccountNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccountNumber(String accountNumber) {
    if (accountNumber != null) {
      updateAccountNumber(accountNumber);
    }
  }

  public void setCountryCenter(RetailStoreCountryCenter countryCenter) {
    RetailStoreCountryCenter oldCountryCenter = this.countryCenter;
    RetailStoreCountryCenter newCountryCenter = countryCenter;
    this.countryCenter = newCountryCenter;
  }

  public RetailStoreCountryCenter countryCenter() {
    doLoad();
    return getCountryCenter();
  }

  public RetailStoreCountryCenter getCountryCenter() {
    return this.countryCenter;
  }

  public AccountSet updateCountryCenter(RetailStoreCountryCenter countryCenter) {
    RetailStoreCountryCenter oldCountryCenter = this.countryCenter;
    RetailStoreCountryCenter newCountryCenter = countryCenter;
    if (!shouldReplaceBy(newCountryCenter, oldCountryCenter)) {
      return this;
    }
    this.countryCenter = newCountryCenter;
    if (cn.hutool.core.util.ObjectUtil.equals(newCountryCenter, oldCountryCenter)) {
      return this;
    }
    addPropertyChange(COUNTRY_CENTER_PROPERTY, oldCountryCenter, newCountryCenter);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByCountryCenter(boolean asc) {
    doAddOrderBy(COUNTRY_CENTER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCountryCenterCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COUNTRY_CENTER_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreCountryCenterCriteria() {
    super.ignoreSearchProperty(COUNTRY_CENTER_PROPERTY);
    return this;
  }

  public AccountSet addCountryCenterCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCountryCenterCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCountryCenter(RetailStoreCountryCenter countryCenter) {
    if (countryCenter != null) {
      updateCountryCenter(countryCenter);
    }
  }

  public AccountSet updateCountryCenterByReferenceId(String countryCenterId) {
    updateCountryCenter(RetailStoreCountryCenter.refById(countryCenterId));
    return this;
  }

  public void clearCountryCenter() {
    setCountryCenter(null);
    this.changed = true;
    setChecked(false);
  }

  public void setRetailStore(RetailStore retailStore) {
    RetailStore oldRetailStore = this.retailStore;
    RetailStore newRetailStore = retailStore;
    this.retailStore = newRetailStore;
  }

  public RetailStore retailStore() {
    doLoad();
    return getRetailStore();
  }

  public RetailStore getRetailStore() {
    return this.retailStore;
  }

  public AccountSet updateRetailStore(RetailStore retailStore) {
    RetailStore oldRetailStore = this.retailStore;
    RetailStore newRetailStore = retailStore;
    if (!shouldReplaceBy(newRetailStore, oldRetailStore)) {
      return this;
    }
    this.retailStore = newRetailStore;
    if (cn.hutool.core.util.ObjectUtil.equals(newRetailStore, oldRetailStore)) {
      return this;
    }
    addPropertyChange(RETAIL_STORE_PROPERTY, oldRetailStore, newRetailStore);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByRetailStore(boolean asc) {
    doAddOrderBy(RETAIL_STORE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createRetailStoreCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(RETAIL_STORE_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreRetailStoreCriteria() {
    super.ignoreSearchProperty(RETAIL_STORE_PROPERTY);
    return this;
  }

  public AccountSet addRetailStoreCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createRetailStoreCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeRetailStore(RetailStore retailStore) {
    if (retailStore != null) {
      updateRetailStore(retailStore);
    }
  }

  public AccountSet updateRetailStoreByReferenceId(String retailStoreId) {
    updateRetailStore(RetailStore.refById(retailStoreId));
    return this;
  }

  public void clearRetailStore() {
    setRetailStore(null);
    this.changed = true;
    setChecked(false);
  }

  public void setGoodsSupplier(GoodsSupplier goodsSupplier) {
    GoodsSupplier oldGoodsSupplier = this.goodsSupplier;
    GoodsSupplier newGoodsSupplier = goodsSupplier;
    this.goodsSupplier = newGoodsSupplier;
  }

  public GoodsSupplier goodsSupplier() {
    doLoad();
    return getGoodsSupplier();
  }

  public GoodsSupplier getGoodsSupplier() {
    return this.goodsSupplier;
  }

  public AccountSet updateGoodsSupplier(GoodsSupplier goodsSupplier) {
    GoodsSupplier oldGoodsSupplier = this.goodsSupplier;
    GoodsSupplier newGoodsSupplier = goodsSupplier;
    if (!shouldReplaceBy(newGoodsSupplier, oldGoodsSupplier)) {
      return this;
    }
    this.goodsSupplier = newGoodsSupplier;
    if (cn.hutool.core.util.ObjectUtil.equals(newGoodsSupplier, oldGoodsSupplier)) {
      return this;
    }
    addPropertyChange(GOODS_SUPPLIER_PROPERTY, oldGoodsSupplier, newGoodsSupplier);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByGoodsSupplier(boolean asc) {
    doAddOrderBy(GOODS_SUPPLIER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createGoodsSupplierCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(GOODS_SUPPLIER_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreGoodsSupplierCriteria() {
    super.ignoreSearchProperty(GOODS_SUPPLIER_PROPERTY);
    return this;
  }

  public AccountSet addGoodsSupplierCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createGoodsSupplierCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeGoodsSupplier(GoodsSupplier goodsSupplier) {
    if (goodsSupplier != null) {
      updateGoodsSupplier(goodsSupplier);
    }
  }

  public AccountSet updateGoodsSupplierByReferenceId(String goodsSupplierId) {
    updateGoodsSupplier(GoodsSupplier.refById(goodsSupplierId));
    return this;
  }

  public void clearGoodsSupplier() {
    setGoodsSupplier(null);
    this.changed = true;
    setChecked(false);
  }

  public void setLastUpdateTime(DateTime lastUpdateTime) {
    DateTime oldLastUpdateTime = this.lastUpdateTime;
    DateTime newLastUpdateTime = lastUpdateTime;
    this.lastUpdateTime = newLastUpdateTime;
  }

  public DateTime lastUpdateTime() {
    doLoad();
    return getLastUpdateTime();
  }

  public DateTime getLastUpdateTime() {
    return this.lastUpdateTime;
  }

  public AccountSet updateLastUpdateTime(DateTime lastUpdateTime) {
    DateTime oldLastUpdateTime = this.lastUpdateTime;
    DateTime newLastUpdateTime = lastUpdateTime;
    if (!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)) {
      return this;
    }
    this.lastUpdateTime = newLastUpdateTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newLastUpdateTime, oldLastUpdateTime)) {
      return this;
    }
    addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public AccountSet orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public AccountSet addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLastUpdateTime(DateTime lastUpdateTime) {
    updateLastUpdateTime(lastUpdateTime);
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

  public AccountSet updateVersion(int version) {
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

  public AccountSet orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public AccountSet ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public AccountSet addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<AccountingSubject> getAccountingSubjectList() {
    if (this.mAccountingSubjectList == null) {
      this.mAccountingSubjectList = new SmartList<AccountingSubject>();
      this.mAccountingSubjectList.setListInternalName(ACCOUNTING_SUBJECT_LIST);
      // 有名字，便于做权限控制
    }

    return this.mAccountingSubjectList;
  }

  public SmartList<AccountingSubject> accountingSubjectList() {

    doLoadChild(ACCOUNTING_SUBJECT_LIST);

    return getAccountingSubjectList();
  }

  public void setAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList) {
    for (AccountingSubject accountingSubject : accountingSubjectList) {
      accountingSubject.setAccountSet(this);
    }

    this.mAccountingSubjectList = accountingSubjectList;
    this.mAccountingSubjectList.setListInternalName(ACCOUNTING_SUBJECT_LIST);
  }

  public AccountSet addAccountingSubject(AccountingSubject accountingSubject) {
    accountingSubject.updateAccountSet(this);
    getAccountingSubjectList().add(accountingSubject);
    return this;
  }

  public AccountSet addAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList) {
    for (AccountingSubject accountingSubject : accountingSubjectList) {
      accountingSubject.updateAccountSet(this);
    }

    Map<String, AccountingSubject> mapById = accountingSubjectList.mapWithId();
    getAccountingSubjectList().removeIf(item -> mapById.get(item.getId()) != null);
    getAccountingSubjectList().addAll(accountingSubjectList);
    return this;
  }

  public void mergeAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList) {
    if (accountingSubjectList == null) {
      return;
    }
    if (accountingSubjectList.isEmpty()) {
      return;
    }
    addAccountingSubjectList(accountingSubjectList);
  }

  public AccountingSubject removeAccountingSubject(AccountingSubject accountingSubjectIndex) {

    int index = getAccountingSubjectList().indexOf(accountingSubjectIndex);
    if (index < 0) {
      String message =
          "AccountingSubject("
              + accountingSubjectIndex.getId()
              + ") with version='"
              + accountingSubjectIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    AccountingSubject accountingSubject = getAccountingSubjectList().get(index);
    // accountingSubject.clearAccountSet(); //disconnect with AccountSet
    accountingSubject.clearFromAll(); // disconnect with AccountSet

    boolean result = getAccountingSubjectList().planToRemove(accountingSubject);
    if (!result) {
      String message =
          "AccountingSubject("
              + accountingSubjectIndex.getId()
              + ") with version='"
              + accountingSubjectIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return accountingSubject;
  }
  // 断舍离
  public void breakWithAccountingSubject(AccountingSubject accountingSubject) {

    if (accountingSubject == null) {
      return;
    }
    accountingSubject.setAccountSet(null);
    // getAccountingSubjectList().remove();

  }

  public boolean hasAccountingSubject(AccountingSubject accountingSubject) {

    return getAccountingSubjectList().contains(accountingSubject);
  }

  public void copyAccountingSubjectFrom(AccountingSubject accountingSubject) {

    AccountingSubject accountingSubjectInList = findTheAccountingSubject(accountingSubject);
    AccountingSubject newAccountingSubject = new AccountingSubject();
    accountingSubjectInList.copyTo(newAccountingSubject);
    newAccountingSubject.setVersion(0); // will trigger copy
    getAccountingSubjectList().add(newAccountingSubject);
    addItemToFlexiableObject(COPIED_CHILD, newAccountingSubject);
  }

  public AccountingSubject findTheAccountingSubject(AccountingSubject accountingSubject) {

    int index = getAccountingSubjectList().indexOf(accountingSubject);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "AccountingSubject("
              + accountingSubject.getId()
              + ") with version='"
              + accountingSubject.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getAccountingSubjectList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpAccountingSubjectList() {
    getAccountingSubjectList().clear();
  }

  public SmartList<AccountingPeriod> getAccountingPeriodList() {
    if (this.mAccountingPeriodList == null) {
      this.mAccountingPeriodList = new SmartList<AccountingPeriod>();
      this.mAccountingPeriodList.setListInternalName(ACCOUNTING_PERIOD_LIST);
      // 有名字，便于做权限控制
    }

    return this.mAccountingPeriodList;
  }

  public SmartList<AccountingPeriod> accountingPeriodList() {

    doLoadChild(ACCOUNTING_PERIOD_LIST);

    return getAccountingPeriodList();
  }

  public void setAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList) {
    for (AccountingPeriod accountingPeriod : accountingPeriodList) {
      accountingPeriod.setAccountSet(this);
    }

    this.mAccountingPeriodList = accountingPeriodList;
    this.mAccountingPeriodList.setListInternalName(ACCOUNTING_PERIOD_LIST);
  }

  public AccountSet addAccountingPeriod(AccountingPeriod accountingPeriod) {
    accountingPeriod.updateAccountSet(this);
    getAccountingPeriodList().add(accountingPeriod);
    return this;
  }

  public AccountSet addAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList) {
    for (AccountingPeriod accountingPeriod : accountingPeriodList) {
      accountingPeriod.updateAccountSet(this);
    }

    Map<String, AccountingPeriod> mapById = accountingPeriodList.mapWithId();
    getAccountingPeriodList().removeIf(item -> mapById.get(item.getId()) != null);
    getAccountingPeriodList().addAll(accountingPeriodList);
    return this;
  }

  public void mergeAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList) {
    if (accountingPeriodList == null) {
      return;
    }
    if (accountingPeriodList.isEmpty()) {
      return;
    }
    addAccountingPeriodList(accountingPeriodList);
  }

  public AccountingPeriod removeAccountingPeriod(AccountingPeriod accountingPeriodIndex) {

    int index = getAccountingPeriodList().indexOf(accountingPeriodIndex);
    if (index < 0) {
      String message =
          "AccountingPeriod("
              + accountingPeriodIndex.getId()
              + ") with version='"
              + accountingPeriodIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    AccountingPeriod accountingPeriod = getAccountingPeriodList().get(index);
    // accountingPeriod.clearAccountSet(); //disconnect with AccountSet
    accountingPeriod.clearFromAll(); // disconnect with AccountSet

    boolean result = getAccountingPeriodList().planToRemove(accountingPeriod);
    if (!result) {
      String message =
          "AccountingPeriod("
              + accountingPeriodIndex.getId()
              + ") with version='"
              + accountingPeriodIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return accountingPeriod;
  }
  // 断舍离
  public void breakWithAccountingPeriod(AccountingPeriod accountingPeriod) {

    if (accountingPeriod == null) {
      return;
    }
    accountingPeriod.setAccountSet(null);
    // getAccountingPeriodList().remove();

  }

  public boolean hasAccountingPeriod(AccountingPeriod accountingPeriod) {

    return getAccountingPeriodList().contains(accountingPeriod);
  }

  public void copyAccountingPeriodFrom(AccountingPeriod accountingPeriod) {

    AccountingPeriod accountingPeriodInList = findTheAccountingPeriod(accountingPeriod);
    AccountingPeriod newAccountingPeriod = new AccountingPeriod();
    accountingPeriodInList.copyTo(newAccountingPeriod);
    newAccountingPeriod.setVersion(0); // will trigger copy
    getAccountingPeriodList().add(newAccountingPeriod);
    addItemToFlexiableObject(COPIED_CHILD, newAccountingPeriod);
  }

  public AccountingPeriod findTheAccountingPeriod(AccountingPeriod accountingPeriod) {

    int index = getAccountingPeriodList().indexOf(accountingPeriod);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "AccountingPeriod("
              + accountingPeriod.getId()
              + ") with version='"
              + accountingPeriod.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getAccountingPeriodList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpAccountingPeriodList() {
    getAccountingPeriodList().clear();
  }

  public SmartList<AccountingDocumentType> getAccountingDocumentTypeList() {
    if (this.mAccountingDocumentTypeList == null) {
      this.mAccountingDocumentTypeList = new SmartList<AccountingDocumentType>();
      this.mAccountingDocumentTypeList.setListInternalName(ACCOUNTING_DOCUMENT_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mAccountingDocumentTypeList;
  }

  public SmartList<AccountingDocumentType> accountingDocumentTypeList() {

    doLoadChild(ACCOUNTING_DOCUMENT_TYPE_LIST);

    return getAccountingDocumentTypeList();
  }

  public void setAccountingDocumentTypeList(
      SmartList<AccountingDocumentType> accountingDocumentTypeList) {
    for (AccountingDocumentType accountingDocumentType : accountingDocumentTypeList) {
      accountingDocumentType.setAccountingPeriod(this);
    }

    this.mAccountingDocumentTypeList = accountingDocumentTypeList;
    this.mAccountingDocumentTypeList.setListInternalName(ACCOUNTING_DOCUMENT_TYPE_LIST);
  }

  public AccountSet addAccountingDocumentType(AccountingDocumentType accountingDocumentType) {
    accountingDocumentType.updateAccountingPeriod(this);
    getAccountingDocumentTypeList().add(accountingDocumentType);
    return this;
  }

  public AccountSet addAccountingDocumentTypeList(
      SmartList<AccountingDocumentType> accountingDocumentTypeList) {
    for (AccountingDocumentType accountingDocumentType : accountingDocumentTypeList) {
      accountingDocumentType.updateAccountingPeriod(this);
    }

    Map<String, AccountingDocumentType> mapById = accountingDocumentTypeList.mapWithId();
    getAccountingDocumentTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getAccountingDocumentTypeList().addAll(accountingDocumentTypeList);
    return this;
  }

  public void mergeAccountingDocumentTypeList(
      SmartList<AccountingDocumentType> accountingDocumentTypeList) {
    if (accountingDocumentTypeList == null) {
      return;
    }
    if (accountingDocumentTypeList.isEmpty()) {
      return;
    }
    addAccountingDocumentTypeList(accountingDocumentTypeList);
  }

  public AccountingDocumentType removeAccountingDocumentType(
      AccountingDocumentType accountingDocumentTypeIndex) {

    int index = getAccountingDocumentTypeList().indexOf(accountingDocumentTypeIndex);
    if (index < 0) {
      String message =
          "AccountingDocumentType("
              + accountingDocumentTypeIndex.getId()
              + ") with version='"
              + accountingDocumentTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    AccountingDocumentType accountingDocumentType = getAccountingDocumentTypeList().get(index);
    // accountingDocumentType.clearAccountingPeriod(); //disconnect with AccountingPeriod
    accountingDocumentType.clearFromAll(); // disconnect with AccountingPeriod

    boolean result = getAccountingDocumentTypeList().planToRemove(accountingDocumentType);
    if (!result) {
      String message =
          "AccountingDocumentType("
              + accountingDocumentTypeIndex.getId()
              + ") with version='"
              + accountingDocumentTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return accountingDocumentType;
  }
  // 断舍离
  public void breakWithAccountingDocumentType(AccountingDocumentType accountingDocumentType) {

    if (accountingDocumentType == null) {
      return;
    }
    accountingDocumentType.setAccountingPeriod(null);
    // getAccountingDocumentTypeList().remove();

  }

  public boolean hasAccountingDocumentType(AccountingDocumentType accountingDocumentType) {

    return getAccountingDocumentTypeList().contains(accountingDocumentType);
  }

  public void copyAccountingDocumentTypeFrom(AccountingDocumentType accountingDocumentType) {

    AccountingDocumentType accountingDocumentTypeInList =
        findTheAccountingDocumentType(accountingDocumentType);
    AccountingDocumentType newAccountingDocumentType = new AccountingDocumentType();
    accountingDocumentTypeInList.copyTo(newAccountingDocumentType);
    newAccountingDocumentType.setVersion(0); // will trigger copy
    getAccountingDocumentTypeList().add(newAccountingDocumentType);
    addItemToFlexiableObject(COPIED_CHILD, newAccountingDocumentType);
  }

  public AccountingDocumentType findTheAccountingDocumentType(
      AccountingDocumentType accountingDocumentType) {

    int index = getAccountingDocumentTypeList().indexOf(accountingDocumentType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "AccountingDocumentType("
              + accountingDocumentType.getId()
              + ") with version='"
              + accountingDocumentType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getAccountingDocumentTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpAccountingDocumentTypeList() {
    getAccountingDocumentTypeList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCountryCenter(), internalType);
    addToEntityList(this, entityList, getRetailStore(), internalType);
    addToEntityList(this, entityList, getGoodsSupplier(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getAccountingSubjectList(), internalType);
    collectFromList(this, entityList, getAccountingPeriodList(), internalType);
    collectFromList(this, entityList, getAccountingDocumentTypeList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getAccountingSubjectList());
    listOfList.add(getAccountingPeriodList());
    listOfList.add(getAccountingDocumentTypeList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, YEAR_SET_PROPERTY, getYearSet());
    appendKeyValuePair(result, EFFECTIVE_DATE_PROPERTY, getEffectiveDate());
    appendKeyValuePair(result, ACCOUNTING_SYSTEM_PROPERTY, getAccountingSystem());
    appendKeyValuePair(result, DOMESTIC_CURRENCY_CODE_PROPERTY, getDomesticCurrencyCode());
    appendKeyValuePair(result, DOMESTIC_CURRENCY_NAME_PROPERTY, getDomesticCurrencyName());
    appendKeyValuePair(result, OPENING_BANK_PROPERTY, getOpeningBank());
    appendKeyValuePair(result, ACCOUNT_NUMBER_PROPERTY, getAccountNumber());
    appendKeyValuePair(result, COUNTRY_CENTER_PROPERTY, getCountryCenter());
    appendKeyValuePair(result, RETAIL_STORE_PROPERTY, getRetailStore());
    appendKeyValuePair(result, GOODS_SUPPLIER_PROPERTY, getGoodsSupplier());
    appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, ACCOUNTING_SUBJECT_LIST, getAccountingSubjectList());
    if (!getAccountingSubjectList().isEmpty()) {
      appendKeyValuePair(
          result, "accountingSubjectCount", getAccountingSubjectList().getTotalCount());
      appendKeyValuePair(
          result,
          "accountingSubjectCurrentPageNumber",
          getAccountingSubjectList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, ACCOUNTING_PERIOD_LIST, getAccountingPeriodList());
    if (!getAccountingPeriodList().isEmpty()) {
      appendKeyValuePair(
          result, "accountingPeriodCount", getAccountingPeriodList().getTotalCount());
      appendKeyValuePair(
          result,
          "accountingPeriodCurrentPageNumber",
          getAccountingPeriodList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, ACCOUNTING_DOCUMENT_TYPE_LIST, getAccountingDocumentTypeList());
    if (!getAccountingDocumentTypeList().isEmpty()) {
      appendKeyValuePair(
          result, "accountingDocumentTypeCount", getAccountingDocumentTypeList().getTotalCount());
      appendKeyValuePair(
          result,
          "accountingDocumentTypeCurrentPageNumber",
          getAccountingDocumentTypeList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof AccountSet) {

      AccountSet dest = (AccountSet) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setYearSet(getYearSet());
      dest.setEffectiveDate(getEffectiveDate());
      dest.setAccountingSystem(getAccountingSystem());
      dest.setDomesticCurrencyCode(getDomesticCurrencyCode());
      dest.setDomesticCurrencyName(getDomesticCurrencyName());
      dest.setOpeningBank(getOpeningBank());
      dest.setAccountNumber(getAccountNumber());
      dest.setCountryCenter(getCountryCenter());
      dest.setRetailStore(getRetailStore());
      dest.setGoodsSupplier(getGoodsSupplier());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
      dest.setAccountingSubjectList(getAccountingSubjectList());
      dest.setAccountingPeriodList(getAccountingPeriodList());
      dest.setAccountingDocumentTypeList(getAccountingDocumentTypeList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof AccountSet) {

      AccountSet source = (AccountSet) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeYearSet(source.getYearSet());
      mergeEffectiveDate(source.getEffectiveDate());
      mergeAccountingSystem(source.getAccountingSystem());
      mergeDomesticCurrencyCode(source.getDomesticCurrencyCode());
      mergeDomesticCurrencyName(source.getDomesticCurrencyName());
      mergeOpeningBank(source.getOpeningBank());
      mergeAccountNumber(source.getAccountNumber());
      mergeCountryCenter(source.getCountryCenter());
      mergeRetailStore(source.getRetailStore());
      mergeGoodsSupplier(source.getGoodsSupplier());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
      mergeAccountingSubjectList(source.getAccountingSubjectList());
      mergeAccountingPeriodList(source.getAccountingPeriodList());
      mergeAccountingDocumentTypeList(source.getAccountingDocumentTypeList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof AccountSet) {

      AccountSet source = (AccountSet) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeYearSet(source.getYearSet());
      mergeEffectiveDate(source.getEffectiveDate());
      mergeAccountingSystem(source.getAccountingSystem());
      mergeDomesticCurrencyCode(source.getDomesticCurrencyCode());
      mergeDomesticCurrencyName(source.getDomesticCurrencyName());
      mergeOpeningBank(source.getOpeningBank());
      mergeAccountNumber(source.getAccountNumber());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getName(),
      getYearSet(),
      getEffectiveDate(),
      getAccountingSystem(),
      getDomesticCurrencyCode(),
      getDomesticCurrencyName(),
      getOpeningBank(),
      getAccountNumber(),
      getCountryCenter(),
      getRetailStore(),
      getGoodsSupplier(),
      getLastUpdateTime(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    AccountSet checkAccountSet =
        Q.accountSetWithIdField()
            .filterById(id)
            .selectAccountingSubjectList(Q.accountingSubjectWithIdField().limit(0, 1))
            .selectAccountingPeriodList(Q.accountingPeriodWithIdField().limit(0, 1))
            .selectAccountingDocumentTypeList(Q.accountingDocumentTypeWithIdField().limit(0, 1))
            .execute(ctx);

    return checkAccountSet != null
        && !checkAccountSet.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public AccountSet save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("AccountSet{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tyearSet='" + getYearSet() + "';");
    stringBuilder.append("\teffectiveDate='" + getEffectiveDate() + "';");
    stringBuilder.append("\taccountingSystem='" + getAccountingSystem() + "';");
    stringBuilder.append("\tdomesticCurrencyCode='" + getDomesticCurrencyCode() + "';");
    stringBuilder.append("\tdomesticCurrencyName='" + getDomesticCurrencyName() + "';");
    stringBuilder.append("\topeningBank='" + getOpeningBank() + "';");
    stringBuilder.append("\taccountNumber='" + getAccountNumber() + "';");
    if (getCountryCenter() != null) {
      stringBuilder.append(
          "\tcountryCenter='RetailStoreCountryCenter(" + getCountryCenter().getId() + ")';");
    }
    if (getRetailStore() != null) {
      stringBuilder.append("\tretailStore='RetailStore(" + getRetailStore().getId() + ")';");
    }
    if (getGoodsSupplier() != null) {
      stringBuilder.append("\tgoodsSupplier='GoodsSupplier(" + getGoodsSupplier().getId() + ")';");
    }
    stringBuilder.append("\tlastUpdateTime='" + getLastUpdateTime() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
