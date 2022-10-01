package com.doublechaintech.retailscm.publicholiday;

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

@JsonSerialize(using = PublicHolidaySerializer.class)
public class PublicHoliday extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(PublicHoliday target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String CODE_PROPERTY = "code";
  public static final String COMPANY_PROPERTY = "company";
  public static final String NAME_PROPERTY = "name";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "PublicHoliday";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CODE_PROPERTY, "code", "代码").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COMPANY_PROPERTY, "retail_store_country_center", "公司")
            .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      CODE_PROPERTY,
      COMPANY_PROPERTY,
      NAME_PROPERTY,
      DESCRIPTION_PROPERTY,
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
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }
  /*
  public PublicHoliday want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public PublicHoliday wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getCode();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String code;
  protected RetailStoreCountryCenter company;
  protected String name;
  protected String description;
  protected int version;

  public PublicHoliday() {
    // lazy load for all the properties
  }

  public static PublicHoliday withId(String id) {
    PublicHoliday publicHoliday = new PublicHoliday();
    publicHoliday.setId(id);
    publicHoliday.setVersion(Integer.MAX_VALUE);
    publicHoliday.setChecked(true);
    return publicHoliday;
  }

  public static PublicHoliday refById(String id) {
    return withId(id);
  }

  public PublicHoliday limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public PublicHoliday limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static PublicHoliday searchExample() {
    PublicHoliday publicHoliday = new PublicHoliday();
    publicHoliday.setVersion(UNSET_INT);

    return publicHoliday;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setCompany( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (CODE_PROPERTY.equals(property)) {
      changeCodeProperty(newValueExpr);
    }
    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      changeDescriptionProperty(newValueExpr);
    }
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

    if (CODE_PROPERTY.equals(property)) {
      return getCode();
    }
    if (COMPANY_PROPERTY.equals(property)) {
      return getCompany();
    }
    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
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

  public PublicHoliday updateId(String id) {
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

  public PublicHoliday orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public PublicHoliday ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public PublicHoliday addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
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

  public PublicHoliday updateCode(String code) {
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

  public PublicHoliday orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public PublicHoliday ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public PublicHoliday addCodeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCode(String code) {
    if (code != null) {
      updateCode(code);
    }
  }

  public void setCompany(RetailStoreCountryCenter company) {
    RetailStoreCountryCenter oldCompany = this.company;
    RetailStoreCountryCenter newCompany = company;
    this.company = newCompany;
  }

  public RetailStoreCountryCenter company() {
    doLoad();
    return getCompany();
  }

  public RetailStoreCountryCenter getCompany() {
    return this.company;
  }

  public PublicHoliday updateCompany(RetailStoreCountryCenter company) {
    RetailStoreCountryCenter oldCompany = this.company;
    RetailStoreCountryCenter newCompany = company;
    if (!shouldReplaceBy(newCompany, oldCompany)) {
      return this;
    }
    this.company = newCompany;
    if (cn.hutool.core.util.ObjectUtil.equals(newCompany, oldCompany)) {
      return this;
    }
    addPropertyChange(COMPANY_PROPERTY, oldCompany, newCompany);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public PublicHoliday orderByCompany(boolean asc) {
    doAddOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMPANY_PROPERTY, operator, parameters);
  }

  public PublicHoliday ignoreCompanyCriteria() {
    super.ignoreSearchProperty(COMPANY_PROPERTY);
    return this;
  }

  public PublicHoliday addCompanyCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCompanyCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCompany(RetailStoreCountryCenter company) {
    if (company != null) {
      updateCompany(company);
    }
  }

  public PublicHoliday updateCompanyByReferenceId(String companyId) {
    updateCompany(RetailStoreCountryCenter.refById(companyId));
    return this;
  }

  public void clearCompany() {
    setCompany(null);
    this.changed = true;
    setChecked(false);
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

  public PublicHoliday updateName(String name) {
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

  public PublicHoliday orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public PublicHoliday ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public PublicHoliday addNameCriteria(QueryOperator operator, Object... parameters) {
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

  public PublicHoliday updateDescription(String description) {
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

  public PublicHoliday orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public PublicHoliday ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public PublicHoliday addDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDescription(String description) {
    if (description != null) {
      updateDescription(description);
    }
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

  public PublicHoliday updateVersion(int version) {
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

  public PublicHoliday orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public PublicHoliday ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public PublicHoliday addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getCompany(), internalType);
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
    appendKeyValuePair(result, CODE_PROPERTY, getCode());
    appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof PublicHoliday) {

      PublicHoliday dest = (PublicHoliday) baseDest;

      dest.setId(getId());
      dest.setCode(getCode());
      dest.setCompany(getCompany());
      dest.setName(getName());
      dest.setDescription(getDescription());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof PublicHoliday) {

      PublicHoliday source = (PublicHoliday) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeCompany(source.getCompany());
      mergeName(source.getName());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof PublicHoliday) {

      PublicHoliday source = (PublicHoliday) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeName(source.getName());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getCode(), getCompany(), getName(), getDescription(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    PublicHoliday checkPublicHoliday = Q.publicHolidayWithIdField().filterById(id).execute(ctx);

    return checkPublicHoliday != null
        && !checkPublicHoliday.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public PublicHoliday save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("PublicHoliday{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    if (getCompany() != null) {
      stringBuilder.append("\tcompany='RetailStoreCountryCenter(" + getCompany().getId() + ")';");
    }
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
