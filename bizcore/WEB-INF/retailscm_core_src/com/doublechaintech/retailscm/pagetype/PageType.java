package com.doublechaintech.retailscm.pagetype;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.mobileapp.MobileApp;

@JsonSerialize(using = PageTypeSerializer.class)
public class PageType extends BaseEntity implements java.io.Serializable {

  public static final String HOME = "home"; // 首页
  public static final String ME = "me"; // 我的
  public static final String GENERIC_PAGE = "generic-page"; // Generic Page
  public static final String LISTOF_PAGE = "listof-page"; // Listof Page
  public static final String SERVICE_CENTER = "service-center"; // 功能大厅
  public static final String SIMPLE = "simple"; // 普通
  public static List<KeyValuePair> CODE_NAME_LIST;

  static {
    CODE_NAME_LIST = new ArrayList<>();

    CODE_NAME_LIST.add(new KeyValuePair(HOME, "首页"));
    CODE_NAME_LIST.add(new KeyValuePair(ME, "我的"));
    CODE_NAME_LIST.add(new KeyValuePair(GENERIC_PAGE, "Generic Page"));
    CODE_NAME_LIST.add(new KeyValuePair(LISTOF_PAGE, "Listof Page"));
    CODE_NAME_LIST.add(new KeyValuePair(SERVICE_CENTER, "功能大厅"));
    CODE_NAME_LIST.add(new KeyValuePair(SIMPLE, "普通"));
  }

  public static String getName(String code) {
    return (String)
        CODE_NAME_LIST.stream()
            .filter(kv -> Objects.equals(code, kv.getKey()))
            .map(KeyValuePair::getValue)
            .findFirst()
            .orElse(null);
  }

  public static String getCode(String name) {
    return CODE_NAME_LIST.stream()
        .filter(kv -> Objects.equals(name, kv.getValue()))
        .map(KeyValuePair::getKey)
        .findFirst()
        .orElse(null);
  }

  public void transferAllRelationshipsTo(PageType target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String CODE_PROPERTY = "code";
  public static final String MOBILE_APP_PROPERTY = "mobileApp";
  public static final String FOOTER_TAB_PROPERTY = "footerTab";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "PageType";

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
        MemberMetaInfo.defineBy(MOBILE_APP_PROPERTY, "mobile_app", "手机应用程序")
            .withType("mobile_app", MobileApp.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FOOTER_TAB_PROPERTY, "footer_tab", "页脚选项卡")
            .withType("bool", "boolean"));
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
      MOBILE_APP_PROPERTY,
      FOOTER_TAB_PROPERTY,
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
    parents.put(MOBILE_APP_PROPERTY, MobileApp.class);

    return parents;
  }
  /*
  public PageType want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public PageType wants(Class<? extends BaseEntity>... classes) {
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
  protected MobileApp mobileApp;
  protected boolean footerTab;
  protected int version;

  public PageType() {
    // lazy load for all the properties
  }

  public static PageType withId(String id) {
    PageType pageType = new PageType();
    pageType.setId(id);
    pageType.setVersion(Integer.MAX_VALUE);
    pageType.setChecked(true);
    return pageType;
  }

  public static PageType refById(String id) {
    return withId(id);
  }

  public PageType limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public PageType limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static PageType searchExample() {
    PageType pageType = new PageType();
    pageType.setVersion(UNSET_INT);

    return pageType;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setMobileApp( null );

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
    if (FOOTER_TAB_PROPERTY.equals(property)) {
      changeFooterTabProperty(newValueExpr);
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

  protected void changeFooterTabProperty(String newValueExpr) {

    boolean oldValue = getFooterTab();
    boolean newValue = parseBoolean(newValueExpr);
    if (equalsBoolean(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateFooterTab(newValue);
    this.onChangeProperty(FOOTER_TAB_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (CODE_PROPERTY.equals(property)) {
      return getCode();
    }
    if (MOBILE_APP_PROPERTY.equals(property)) {
      return getMobileApp();
    }
    if (FOOTER_TAB_PROPERTY.equals(property)) {
      return getFooterTab();
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

  public PageType updateId(String id) {
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

  public PageType orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public PageType ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public PageType addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public PageType updateName(String name) {
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

  public PageType orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public PageType ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public PageType addNameCriteria(QueryOperator operator, Object... parameters) {
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

  public PageType updateCode(String code) {
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

  public PageType orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public PageType ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public PageType addCodeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCode(String code) {
    if (code != null) {
      updateCode(code);
    }
  }

  public void setMobileApp(MobileApp mobileApp) {
    MobileApp oldMobileApp = this.mobileApp;
    MobileApp newMobileApp = mobileApp;
    this.mobileApp = newMobileApp;
  }

  public MobileApp mobileApp() {
    doLoad();
    return getMobileApp();
  }

  public MobileApp getMobileApp() {
    return this.mobileApp;
  }

  public PageType updateMobileApp(MobileApp mobileApp) {
    MobileApp oldMobileApp = this.mobileApp;
    MobileApp newMobileApp = mobileApp;
    if (!shouldReplaceBy(newMobileApp, oldMobileApp)) {
      return this;
    }
    this.mobileApp = newMobileApp;
    if (cn.hutool.core.util.ObjectUtil.equals(newMobileApp, oldMobileApp)) {
      return this;
    }
    addPropertyChange(MOBILE_APP_PROPERTY, oldMobileApp, newMobileApp);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public PageType orderByMobileApp(boolean asc) {
    doAddOrderBy(MOBILE_APP_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMobileAppCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOBILE_APP_PROPERTY, operator, parameters);
  }

  public PageType ignoreMobileAppCriteria() {
    super.ignoreSearchProperty(MOBILE_APP_PROPERTY);
    return this;
  }

  public PageType addMobileAppCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMobileAppCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMobileApp(MobileApp mobileApp) {
    if (mobileApp != null) {
      updateMobileApp(mobileApp);
    }
  }

  public PageType updateMobileAppByReferenceId(String mobileAppId) {
    updateMobileApp(MobileApp.refById(mobileAppId));
    return this;
  }

  public void clearMobileApp() {
    setMobileApp(null);
    this.changed = true;
    setChecked(false);
  }

  public void setFooterTab(boolean footerTab) {
    boolean oldFooterTab = this.footerTab;
    boolean newFooterTab = footerTab;
    this.footerTab = newFooterTab;
  }

  public boolean footerTab() {
    doLoad();
    return getFooterTab();
  }

  public boolean getFooterTab() {
    return this.footerTab;
  }

  public PageType updateFooterTab(boolean footerTab) {
    boolean oldFooterTab = this.footerTab;
    boolean newFooterTab = footerTab;
    if (!shouldReplaceBy(newFooterTab, oldFooterTab)) {
      return this;
    }
    this.footerTab = newFooterTab;
    if (cn.hutool.core.util.ObjectUtil.equals(newFooterTab, oldFooterTab)) {
      return this;
    }
    addPropertyChange(FOOTER_TAB_PROPERTY, oldFooterTab, newFooterTab);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public PageType orderByFooterTab(boolean asc) {
    doAddOrderBy(FOOTER_TAB_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFooterTabCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FOOTER_TAB_PROPERTY, operator, parameters);
  }

  public PageType ignoreFooterTabCriteria() {
    super.ignoreSearchProperty(FOOTER_TAB_PROPERTY);
    return this;
  }

  public PageType addFooterTabCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFooterTabCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFooterTab(boolean footerTab) {
    updateFooterTab(footerTab);
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

  public PageType updateVersion(int version) {
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

  public PageType orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public PageType ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public PageType addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getMobileApp(), internalType);
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
    appendKeyValuePair(result, MOBILE_APP_PROPERTY, getMobileApp());
    appendKeyValuePair(result, FOOTER_TAB_PROPERTY, getFooterTab());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof PageType) {

      PageType dest = (PageType) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setCode(getCode());
      dest.setMobileApp(getMobileApp());
      dest.setFooterTab(getFooterTab());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof PageType) {

      PageType source = (PageType) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeCode(source.getCode());
      mergeMobileApp(source.getMobileApp());
      mergeFooterTab(source.getFooterTab());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof PageType) {

      PageType source = (PageType) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeCode(source.getCode());
      mergeFooterTab(source.getFooterTab());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getName(), getCode(), getMobileApp(), getFooterTab(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    PageType checkPageType = Q.pageTypeWithIdField().filterById(id).execute(ctx);

    return checkPageType != null
        && !checkPageType.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public PageType save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("PageType{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    if (getMobileApp() != null) {
      stringBuilder.append("\tmobileApp='MobileApp(" + getMobileApp().getId() + ")';");
    }
    stringBuilder.append("\tfooterTab='" + getFooterTab() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
