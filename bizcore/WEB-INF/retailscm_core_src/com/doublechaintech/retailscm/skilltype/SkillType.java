package com.doublechaintech.retailscm.skilltype;

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
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;

@JsonSerialize(using = SkillTypeSerializer.class)
public class SkillType extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(SkillType target) {
    if (target == null) {
      return;
    }
    target.addEmployeeSkillList(this.getEmployeeSkillList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String CODE_PROPERTY = "code";
  public static final String COMPANY_PROPERTY = "company";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String VERSION_PROPERTY = "version";

  public static final String EMPLOYEE_SKILL_LIST = "employeeSkillList";

  public static final String INTERNAL_TYPE = "SkillType";

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
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_SKILL_LIST, "skillType", "员工技能列表")
            .withType("employee_skill", EmployeeSkill.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, CODE_PROPERTY, COMPANY_PROPERTY, DESCRIPTION_PROPERTY, VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(EMPLOYEE_SKILL_LIST, "skillType");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(EMPLOYEE_SKILL_LIST, EmployeeSkill.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }
  /*
  public SkillType want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public SkillType wants(Class<? extends BaseEntity>... classes) {
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
  protected String description;
  protected int version;

  protected SmartList<EmployeeSkill> mEmployeeSkillList;

  public SkillType() {
    // lazy load for all the properties
  }

  public static SkillType withId(String id) {
    SkillType skillType = new SkillType();
    skillType.setId(id);
    skillType.setVersion(Integer.MAX_VALUE);
    skillType.setChecked(true);
    return skillType;
  }

  public static SkillType refById(String id) {
    return withId(id);
  }

  public SkillType limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public SkillType limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static SkillType searchExample() {
    SkillType skillType = new SkillType();
    skillType.setVersion(UNSET_INT);

    return skillType;
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
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (EMPLOYEE_SKILL_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeSkillList().stream().map(item -> item).collect(Collectors.toList());
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

  public SkillType updateId(String id) {
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

  public SkillType orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public SkillType ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public SkillType addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public SkillType updateCode(String code) {
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

  public SkillType orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public SkillType ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public SkillType addCodeCriteria(QueryOperator operator, Object... parameters) {
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

  public SkillType updateCompany(RetailStoreCountryCenter company) {
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

  public SkillType orderByCompany(boolean asc) {
    doAddOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMPANY_PROPERTY, operator, parameters);
  }

  public SkillType ignoreCompanyCriteria() {
    super.ignoreSearchProperty(COMPANY_PROPERTY);
    return this;
  }

  public SkillType addCompanyCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCompanyCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCompany(RetailStoreCountryCenter company) {
    if (company != null) {
      updateCompany(company);
    }
  }

  public SkillType updateCompanyByReferenceId(String companyId) {
    updateCompany(RetailStoreCountryCenter.refById(companyId));
    return this;
  }

  public void clearCompany() {
    setCompany(null);
    this.changed = true;
    setChecked(false);
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

  public SkillType updateDescription(String description) {
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

  public SkillType orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public SkillType ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public SkillType addDescriptionCriteria(QueryOperator operator, Object... parameters) {
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

  public SkillType updateVersion(int version) {
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

  public SkillType orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public SkillType ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public SkillType addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<EmployeeSkill> getEmployeeSkillList() {
    if (this.mEmployeeSkillList == null) {
      this.mEmployeeSkillList = new SmartList<EmployeeSkill>();
      this.mEmployeeSkillList.setListInternalName(EMPLOYEE_SKILL_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEmployeeSkillList;
  }

  public SmartList<EmployeeSkill> employeeSkillList() {

    doLoadChild(EMPLOYEE_SKILL_LIST);

    return getEmployeeSkillList();
  }

  public void setEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList) {
    for (EmployeeSkill employeeSkill : employeeSkillList) {
      employeeSkill.setSkillType(this);
    }

    this.mEmployeeSkillList = employeeSkillList;
    this.mEmployeeSkillList.setListInternalName(EMPLOYEE_SKILL_LIST);
  }

  public SkillType addEmployeeSkill(EmployeeSkill employeeSkill) {
    employeeSkill.updateSkillType(this);
    getEmployeeSkillList().add(employeeSkill);
    return this;
  }

  public SkillType addEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList) {
    for (EmployeeSkill employeeSkill : employeeSkillList) {
      employeeSkill.updateSkillType(this);
    }

    Map<String, EmployeeSkill> mapById = employeeSkillList.mapWithId();
    getEmployeeSkillList().removeIf(item -> mapById.get(item.getId()) != null);
    getEmployeeSkillList().addAll(employeeSkillList);
    return this;
  }

  public void mergeEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList) {
    if (employeeSkillList == null) {
      return;
    }
    if (employeeSkillList.isEmpty()) {
      return;
    }
    addEmployeeSkillList(employeeSkillList);
  }

  public EmployeeSkill removeEmployeeSkill(EmployeeSkill employeeSkillIndex) {

    int index = getEmployeeSkillList().indexOf(employeeSkillIndex);
    if (index < 0) {
      String message =
          "EmployeeSkill("
              + employeeSkillIndex.getId()
              + ") with version='"
              + employeeSkillIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    EmployeeSkill employeeSkill = getEmployeeSkillList().get(index);
    // employeeSkill.clearSkillType(); //disconnect with SkillType
    employeeSkill.clearFromAll(); // disconnect with SkillType

    boolean result = getEmployeeSkillList().planToRemove(employeeSkill);
    if (!result) {
      String message =
          "EmployeeSkill("
              + employeeSkillIndex.getId()
              + ") with version='"
              + employeeSkillIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return employeeSkill;
  }
  // 断舍离
  public void breakWithEmployeeSkill(EmployeeSkill employeeSkill) {

    if (employeeSkill == null) {
      return;
    }
    employeeSkill.setSkillType(null);
    // getEmployeeSkillList().remove();

  }

  public boolean hasEmployeeSkill(EmployeeSkill employeeSkill) {

    return getEmployeeSkillList().contains(employeeSkill);
  }

  public void copyEmployeeSkillFrom(EmployeeSkill employeeSkill) {

    EmployeeSkill employeeSkillInList = findTheEmployeeSkill(employeeSkill);
    EmployeeSkill newEmployeeSkill = new EmployeeSkill();
    employeeSkillInList.copyTo(newEmployeeSkill);
    newEmployeeSkill.setVersion(0); // will trigger copy
    getEmployeeSkillList().add(newEmployeeSkill);
    addItemToFlexiableObject(COPIED_CHILD, newEmployeeSkill);
  }

  public EmployeeSkill findTheEmployeeSkill(EmployeeSkill employeeSkill) {

    int index = getEmployeeSkillList().indexOf(employeeSkill);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "EmployeeSkill("
              + employeeSkill.getId()
              + ") with version='"
              + employeeSkill.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEmployeeSkillList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEmployeeSkillList() {
    getEmployeeSkillList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCompany(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getEmployeeSkillList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getEmployeeSkillList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, CODE_PROPERTY, getCode());
    appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, EMPLOYEE_SKILL_LIST, getEmployeeSkillList());
    if (!getEmployeeSkillList().isEmpty()) {
      appendKeyValuePair(result, "employeeSkillCount", getEmployeeSkillList().getTotalCount());
      appendKeyValuePair(
          result, "employeeSkillCurrentPageNumber", getEmployeeSkillList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof SkillType) {

      SkillType dest = (SkillType) baseDest;

      dest.setId(getId());
      dest.setCode(getCode());
      dest.setCompany(getCompany());
      dest.setDescription(getDescription());
      dest.setVersion(getVersion());
      dest.setEmployeeSkillList(getEmployeeSkillList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof SkillType) {

      SkillType source = (SkillType) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeCompany(source.getCompany());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
      mergeEmployeeSkillList(source.getEmployeeSkillList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof SkillType) {

      SkillType source = (SkillType) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getCode(), getCompany(), getDescription(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    SkillType checkSkillType =
        Q.skillTypeWithIdField()
            .filterById(id)
            .selectEmployeeSkillList(Q.employeeSkillWithIdField().limit(0, 1))
            .execute(ctx);

    return checkSkillType != null
        && !checkSkillType.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public SkillType save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("SkillType{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    if (getCompany() != null) {
      stringBuilder.append("\tcompany='RetailStoreCountryCenter(" + getCompany().getId() + ")';");
    }
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
