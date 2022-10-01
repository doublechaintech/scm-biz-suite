package com.doublechaintech.retailscm.leavetype;

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
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;

@JsonSerialize(using = LeaveTypeSerializer.class)
public class LeaveType extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(LeaveType target) {
    if (target == null) {
      return;
    }
    target.addEmployeeLeaveList(this.getEmployeeLeaveList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String CODE_PROPERTY = "code";
  public static final String COMPANY_PROPERTY = "company";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String DETAIL_DESCRIPTION_PROPERTY = "detailDescription";
  public static final String VERSION_PROPERTY = "version";

  public static final String EMPLOYEE_LEAVE_LIST = "employeeLeaveList";

  public static final String INTERNAL_TYPE = "LeaveType";

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
        MemberMetaInfo.defineBy(DETAIL_DESCRIPTION_PROPERTY, "detail_description", "详细描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_LEAVE_LIST, "type", "员工离开列表")
            .withType("employee_leave", EmployeeLeave.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      CODE_PROPERTY,
      COMPANY_PROPERTY,
      DESCRIPTION_PROPERTY,
      DETAIL_DESCRIPTION_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(EMPLOYEE_LEAVE_LIST, "type");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(EMPLOYEE_LEAVE_LIST, EmployeeLeave.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }
  /*
  public LeaveType want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public LeaveType wants(Class<? extends BaseEntity>... classes) {
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
  protected String detailDescription;
  protected int version;

  protected SmartList<EmployeeLeave> mEmployeeLeaveList;

  public LeaveType() {
    // lazy load for all the properties
  }

  public static LeaveType withId(String id) {
    LeaveType leaveType = new LeaveType();
    leaveType.setId(id);
    leaveType.setVersion(Integer.MAX_VALUE);
    leaveType.setChecked(true);
    return leaveType;
  }

  public static LeaveType refById(String id) {
    return withId(id);
  }

  public LeaveType limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public LeaveType limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static LeaveType searchExample() {
    LeaveType leaveType = new LeaveType();
    leaveType.setVersion(UNSET_INT);

    return leaveType;
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
    if (DETAIL_DESCRIPTION_PROPERTY.equals(property)) {
      changeDetailDescriptionProperty(newValueExpr);
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

  protected void changeDetailDescriptionProperty(String newValueExpr) {

    String oldValue = getDetailDescription();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDetailDescription(newValue);
    this.onChangeProperty(DETAIL_DESCRIPTION_PROPERTY, oldValue, newValue);
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
    if (DETAIL_DESCRIPTION_PROPERTY.equals(property)) {
      return getDetailDescription();
    }
    if (EMPLOYEE_LEAVE_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeLeaveList().stream().map(item -> item).collect(Collectors.toList());
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

  public LeaveType updateId(String id) {
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

  public LeaveType orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public LeaveType ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public LeaveType addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public LeaveType updateCode(String code) {
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

  public LeaveType orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public LeaveType ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public LeaveType addCodeCriteria(QueryOperator operator, Object... parameters) {
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

  public LeaveType updateCompany(RetailStoreCountryCenter company) {
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

  public LeaveType orderByCompany(boolean asc) {
    doAddOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMPANY_PROPERTY, operator, parameters);
  }

  public LeaveType ignoreCompanyCriteria() {
    super.ignoreSearchProperty(COMPANY_PROPERTY);
    return this;
  }

  public LeaveType addCompanyCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCompanyCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCompany(RetailStoreCountryCenter company) {
    if (company != null) {
      updateCompany(company);
    }
  }

  public LeaveType updateCompanyByReferenceId(String companyId) {
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

  public LeaveType updateDescription(String description) {
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

  public LeaveType orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public LeaveType ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public LeaveType addDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDescription(String description) {
    if (description != null) {
      updateDescription(description);
    }
  }

  public void setDetailDescription(String detailDescription) {
    String oldDetailDescription = this.detailDescription;
    String newDetailDescription = trimString(detailDescription);
    this.detailDescription = newDetailDescription;
  }

  public String detailDescription() {
    doLoad();
    return getDetailDescription();
  }

  public String getDetailDescription() {
    return this.detailDescription;
  }

  public LeaveType updateDetailDescription(String detailDescription) {
    String oldDetailDescription = this.detailDescription;
    String newDetailDescription = trimString(detailDescription);
    if (!shouldReplaceBy(newDetailDescription, oldDetailDescription)) {
      return this;
    }
    this.detailDescription = newDetailDescription;
    if (cn.hutool.core.util.ObjectUtil.equals(newDetailDescription, oldDetailDescription)) {
      return this;
    }
    addPropertyChange(DETAIL_DESCRIPTION_PROPERTY, oldDetailDescription, newDetailDescription);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public LeaveType orderByDetailDescription(boolean asc) {
    doAddOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDetailDescriptionCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(DETAIL_DESCRIPTION_PROPERTY, operator, parameters);
  }

  public LeaveType ignoreDetailDescriptionCriteria() {
    super.ignoreSearchProperty(DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public LeaveType addDetailDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDetailDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDetailDescription(String detailDescription) {
    if (detailDescription != null) {
      updateDetailDescription(detailDescription);
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

  public LeaveType updateVersion(int version) {
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

  public LeaveType orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public LeaveType ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public LeaveType addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<EmployeeLeave> getEmployeeLeaveList() {
    if (this.mEmployeeLeaveList == null) {
      this.mEmployeeLeaveList = new SmartList<EmployeeLeave>();
      this.mEmployeeLeaveList.setListInternalName(EMPLOYEE_LEAVE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEmployeeLeaveList;
  }

  public SmartList<EmployeeLeave> employeeLeaveList() {

    doLoadChild(EMPLOYEE_LEAVE_LIST);

    return getEmployeeLeaveList();
  }

  public void setEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList) {
    for (EmployeeLeave employeeLeave : employeeLeaveList) {
      employeeLeave.setType(this);
    }

    this.mEmployeeLeaveList = employeeLeaveList;
    this.mEmployeeLeaveList.setListInternalName(EMPLOYEE_LEAVE_LIST);
  }

  public LeaveType addEmployeeLeave(EmployeeLeave employeeLeave) {
    employeeLeave.updateType(this);
    getEmployeeLeaveList().add(employeeLeave);
    return this;
  }

  public LeaveType addEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList) {
    for (EmployeeLeave employeeLeave : employeeLeaveList) {
      employeeLeave.updateType(this);
    }

    Map<String, EmployeeLeave> mapById = employeeLeaveList.mapWithId();
    getEmployeeLeaveList().removeIf(item -> mapById.get(item.getId()) != null);
    getEmployeeLeaveList().addAll(employeeLeaveList);
    return this;
  }

  public void mergeEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList) {
    if (employeeLeaveList == null) {
      return;
    }
    if (employeeLeaveList.isEmpty()) {
      return;
    }
    addEmployeeLeaveList(employeeLeaveList);
  }

  public EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeaveIndex) {

    int index = getEmployeeLeaveList().indexOf(employeeLeaveIndex);
    if (index < 0) {
      String message =
          "EmployeeLeave("
              + employeeLeaveIndex.getId()
              + ") with version='"
              + employeeLeaveIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    EmployeeLeave employeeLeave = getEmployeeLeaveList().get(index);
    // employeeLeave.clearType(); //disconnect with Type
    employeeLeave.clearFromAll(); // disconnect with Type

    boolean result = getEmployeeLeaveList().planToRemove(employeeLeave);
    if (!result) {
      String message =
          "EmployeeLeave("
              + employeeLeaveIndex.getId()
              + ") with version='"
              + employeeLeaveIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return employeeLeave;
  }
  // 断舍离
  public void breakWithEmployeeLeave(EmployeeLeave employeeLeave) {

    if (employeeLeave == null) {
      return;
    }
    employeeLeave.setType(null);
    // getEmployeeLeaveList().remove();

  }

  public boolean hasEmployeeLeave(EmployeeLeave employeeLeave) {

    return getEmployeeLeaveList().contains(employeeLeave);
  }

  public void copyEmployeeLeaveFrom(EmployeeLeave employeeLeave) {

    EmployeeLeave employeeLeaveInList = findTheEmployeeLeave(employeeLeave);
    EmployeeLeave newEmployeeLeave = new EmployeeLeave();
    employeeLeaveInList.copyTo(newEmployeeLeave);
    newEmployeeLeave.setVersion(0); // will trigger copy
    getEmployeeLeaveList().add(newEmployeeLeave);
    addItemToFlexiableObject(COPIED_CHILD, newEmployeeLeave);
  }

  public EmployeeLeave findTheEmployeeLeave(EmployeeLeave employeeLeave) {

    int index = getEmployeeLeaveList().indexOf(employeeLeave);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "EmployeeLeave("
              + employeeLeave.getId()
              + ") with version='"
              + employeeLeave.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEmployeeLeaveList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEmployeeLeaveList() {
    getEmployeeLeaveList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCompany(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getEmployeeLeaveList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getEmployeeLeaveList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, CODE_PROPERTY, getCode());
    appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, DETAIL_DESCRIPTION_PROPERTY, getDetailDescription());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, EMPLOYEE_LEAVE_LIST, getEmployeeLeaveList());
    if (!getEmployeeLeaveList().isEmpty()) {
      appendKeyValuePair(result, "employeeLeaveCount", getEmployeeLeaveList().getTotalCount());
      appendKeyValuePair(
          result, "employeeLeaveCurrentPageNumber", getEmployeeLeaveList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof LeaveType) {

      LeaveType dest = (LeaveType) baseDest;

      dest.setId(getId());
      dest.setCode(getCode());
      dest.setCompany(getCompany());
      dest.setDescription(getDescription());
      dest.setDetailDescription(getDetailDescription());
      dest.setVersion(getVersion());
      dest.setEmployeeLeaveList(getEmployeeLeaveList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof LeaveType) {

      LeaveType source = (LeaveType) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeCompany(source.getCompany());
      mergeDescription(source.getDescription());
      mergeDetailDescription(source.getDetailDescription());
      mergeVersion(source.getVersion());
      mergeEmployeeLeaveList(source.getEmployeeLeaveList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof LeaveType) {

      LeaveType source = (LeaveType) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeDescription(source.getDescription());
      mergeDetailDescription(source.getDetailDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getCode(), getCompany(), getDescription(), getDetailDescription(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    LeaveType checkLeaveType =
        Q.leaveTypeWithIdField()
            .filterById(id)
            .selectEmployeeLeaveList(Q.employeeLeaveWithIdField().limit(0, 1))
            .execute(ctx);

    return checkLeaveType != null
        && !checkLeaveType.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public LeaveType save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("LeaveType{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    if (getCompany() != null) {
      stringBuilder.append("\tcompany='RetailStoreCountryCenter(" + getCompany().getId() + ")';");
    }
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tdetailDescription='" + getDetailDescription() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
