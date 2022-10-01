package com.doublechaintech.retailscm.employeequalifier;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeQualifierSerializer.class)
public class EmployeeQualifier extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(EmployeeQualifier target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String EMPLOYEE_PROPERTY = "employee";
  public static final String QUALIFIED_TIME_PROPERTY = "qualifiedTime";
  public static final String TYPE_PROPERTY = "type";
  public static final String LEVEL_PROPERTY = "level";
  public static final String REMARK_PROPERTY = "remark";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "EmployeeQualifier";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(EMPLOYEE_PROPERTY, "employee", "员工")
            .withType("employee", Employee.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(QUALIFIED_TIME_PROPERTY, "qualified_time", "合格的时间")
            .withType("date", Date.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TYPE_PROPERTY, "type", "类型").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LEVEL_PROPERTY, "level", "水平").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(REMARK_PROPERTY, "remark", "备注").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      EMPLOYEE_PROPERTY,
      QUALIFIED_TIME_PROPERTY,
      TYPE_PROPERTY,
      LEVEL_PROPERTY,
      REMARK_PROPERTY,
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
    parents.put(EMPLOYEE_PROPERTY, Employee.class);

    return parents;
  }
  /*
  public EmployeeQualifier want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeQualifier wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getType();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected Employee employee;
  protected Date qualifiedTime;
  protected String type;
  protected String level;
  protected String remark;
  protected int version;

  public EmployeeQualifier() {
    // lazy load for all the properties
  }

  public static EmployeeQualifier withId(String id) {
    EmployeeQualifier employeeQualifier = new EmployeeQualifier();
    employeeQualifier.setId(id);
    employeeQualifier.setVersion(Integer.MAX_VALUE);
    employeeQualifier.setChecked(true);
    return employeeQualifier;
  }

  public static EmployeeQualifier refById(String id) {
    return withId(id);
  }

  public EmployeeQualifier limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public EmployeeQualifier limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeQualifier searchExample() {
    EmployeeQualifier employeeQualifier = new EmployeeQualifier();
    employeeQualifier.setVersion(UNSET_INT);

    return employeeQualifier;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setEmployee( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (QUALIFIED_TIME_PROPERTY.equals(property)) {
      changeQualifiedTimeProperty(newValueExpr);
    }
    if (TYPE_PROPERTY.equals(property)) {
      changeTypeProperty(newValueExpr);
    }
    if (LEVEL_PROPERTY.equals(property)) {
      changeLevelProperty(newValueExpr);
    }
    if (REMARK_PROPERTY.equals(property)) {
      changeRemarkProperty(newValueExpr);
    }
  }

  protected void changeQualifiedTimeProperty(String newValueExpr) {

    Date oldValue = getQualifiedTime();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateQualifiedTime(newValue);
    this.onChangeProperty(QUALIFIED_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeTypeProperty(String newValueExpr) {

    String oldValue = getType();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateType(newValue);
    this.onChangeProperty(TYPE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLevelProperty(String newValueExpr) {

    String oldValue = getLevel();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLevel(newValue);
    this.onChangeProperty(LEVEL_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeRemarkProperty(String newValueExpr) {

    String oldValue = getRemark();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateRemark(newValue);
    this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (EMPLOYEE_PROPERTY.equals(property)) {
      return getEmployee();
    }
    if (QUALIFIED_TIME_PROPERTY.equals(property)) {
      return getQualifiedTime();
    }
    if (TYPE_PROPERTY.equals(property)) {
      return getType();
    }
    if (LEVEL_PROPERTY.equals(property)) {
      return getLevel();
    }
    if (REMARK_PROPERTY.equals(property)) {
      return getRemark();
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

  public EmployeeQualifier updateId(String id) {
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

  public EmployeeQualifier orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public EmployeeQualifier ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public EmployeeQualifier addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setEmployee(Employee employee) {
    Employee oldEmployee = this.employee;
    Employee newEmployee = employee;
    this.employee = newEmployee;
  }

  public Employee employee() {
    doLoad();
    return getEmployee();
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public EmployeeQualifier updateEmployee(Employee employee) {
    Employee oldEmployee = this.employee;
    Employee newEmployee = employee;
    if (!shouldReplaceBy(newEmployee, oldEmployee)) {
      return this;
    }
    this.employee = newEmployee;
    if (cn.hutool.core.util.ObjectUtil.equals(newEmployee, oldEmployee)) {
      return this;
    }
    addPropertyChange(EMPLOYEE_PROPERTY, oldEmployee, newEmployee);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeQualifier orderByEmployee(boolean asc) {
    doAddOrderBy(EMPLOYEE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
  }

  public EmployeeQualifier ignoreEmployeeCriteria() {
    super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeQualifier addEmployeeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEmployeeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEmployee(Employee employee) {
    if (employee != null) {
      updateEmployee(employee);
    }
  }

  public EmployeeQualifier updateEmployeeByReferenceId(String employeeId) {
    updateEmployee(Employee.refById(employeeId));
    return this;
  }

  public void clearEmployee() {
    setEmployee(null);
    this.changed = true;
    setChecked(false);
  }

  public void setQualifiedTime(Date qualifiedTime) {
    Date oldQualifiedTime = this.qualifiedTime;
    Date newQualifiedTime = qualifiedTime;
    this.qualifiedTime = newQualifiedTime;
  }

  public Date qualifiedTime() {
    doLoad();
    return getQualifiedTime();
  }

  public Date getQualifiedTime() {
    return this.qualifiedTime;
  }

  public EmployeeQualifier updateQualifiedTime(Date qualifiedTime) {
    Date oldQualifiedTime = this.qualifiedTime;
    Date newQualifiedTime = qualifiedTime;
    if (!shouldReplaceBy(newQualifiedTime, oldQualifiedTime)) {
      return this;
    }
    this.qualifiedTime = newQualifiedTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newQualifiedTime, oldQualifiedTime)) {
      return this;
    }
    addPropertyChange(QUALIFIED_TIME_PROPERTY, oldQualifiedTime, newQualifiedTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeQualifier orderByQualifiedTime(boolean asc) {
    doAddOrderBy(QUALIFIED_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createQualifiedTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(QUALIFIED_TIME_PROPERTY, operator, parameters);
  }

  public EmployeeQualifier ignoreQualifiedTimeCriteria() {
    super.ignoreSearchProperty(QUALIFIED_TIME_PROPERTY);
    return this;
  }

  public EmployeeQualifier addQualifiedTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createQualifiedTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeQualifiedTime(Date qualifiedTime) {
    updateQualifiedTime(qualifiedTime);
  }

  public void setType(String type) {
    String oldType = this.type;
    String newType = trimString(type);
    this.type = newType;
  }

  public String type() {
    doLoad();
    return getType();
  }

  public String getType() {
    return this.type;
  }

  public EmployeeQualifier updateType(String type) {
    String oldType = this.type;
    String newType = trimString(type);
    if (!shouldReplaceBy(newType, oldType)) {
      return this;
    }
    this.type = newType;
    if (cn.hutool.core.util.ObjectUtil.equals(newType, oldType)) {
      return this;
    }
    addPropertyChange(TYPE_PROPERTY, oldType, newType);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeQualifier orderByType(boolean asc) {
    doAddOrderBy(TYPE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTypeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TYPE_PROPERTY, operator, parameters);
  }

  public EmployeeQualifier ignoreTypeCriteria() {
    super.ignoreSearchProperty(TYPE_PROPERTY);
    return this;
  }

  public EmployeeQualifier addTypeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTypeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeType(String type) {
    if (type != null) {
      updateType(type);
    }
  }

  public void setLevel(String level) {
    String oldLevel = this.level;
    String newLevel = trimString(level);
    this.level = newLevel;
  }

  public String level() {
    doLoad();
    return getLevel();
  }

  public String getLevel() {
    return this.level;
  }

  public EmployeeQualifier updateLevel(String level) {
    String oldLevel = this.level;
    String newLevel = trimString(level);
    if (!shouldReplaceBy(newLevel, oldLevel)) {
      return this;
    }
    this.level = newLevel;
    if (cn.hutool.core.util.ObjectUtil.equals(newLevel, oldLevel)) {
      return this;
    }
    addPropertyChange(LEVEL_PROPERTY, oldLevel, newLevel);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeQualifier orderByLevel(boolean asc) {
    doAddOrderBy(LEVEL_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLevelCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LEVEL_PROPERTY, operator, parameters);
  }

  public EmployeeQualifier ignoreLevelCriteria() {
    super.ignoreSearchProperty(LEVEL_PROPERTY);
    return this;
  }

  public EmployeeQualifier addLevelCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLevelCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLevel(String level) {
    if (level != null) {
      updateLevel(level);
    }
  }

  public void setRemark(String remark) {
    String oldRemark = this.remark;
    String newRemark = trimString(remark);
    this.remark = newRemark;
  }

  public String remark() {
    doLoad();
    return getRemark();
  }

  public String getRemark() {
    return this.remark;
  }

  public EmployeeQualifier updateRemark(String remark) {
    String oldRemark = this.remark;
    String newRemark = trimString(remark);
    if (!shouldReplaceBy(newRemark, oldRemark)) {
      return this;
    }
    this.remark = newRemark;
    if (cn.hutool.core.util.ObjectUtil.equals(newRemark, oldRemark)) {
      return this;
    }
    addPropertyChange(REMARK_PROPERTY, oldRemark, newRemark);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeQualifier orderByRemark(boolean asc) {
    doAddOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createRemarkCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(REMARK_PROPERTY, operator, parameters);
  }

  public EmployeeQualifier ignoreRemarkCriteria() {
    super.ignoreSearchProperty(REMARK_PROPERTY);
    return this;
  }

  public EmployeeQualifier addRemarkCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createRemarkCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeRemark(String remark) {
    if (remark != null) {
      updateRemark(remark);
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

  public EmployeeQualifier updateVersion(int version) {
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

  public EmployeeQualifier orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public EmployeeQualifier ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public EmployeeQualifier addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getEmployee(), internalType);
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
    appendKeyValuePair(result, EMPLOYEE_PROPERTY, getEmployee());
    appendKeyValuePair(result, QUALIFIED_TIME_PROPERTY, getQualifiedTime());
    appendKeyValuePair(result, TYPE_PROPERTY, getType());
    appendKeyValuePair(result, LEVEL_PROPERTY, getLevel());
    appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof EmployeeQualifier) {

      EmployeeQualifier dest = (EmployeeQualifier) baseDest;

      dest.setId(getId());
      dest.setEmployee(getEmployee());
      dest.setQualifiedTime(getQualifiedTime());
      dest.setType(getType());
      dest.setLevel(getLevel());
      dest.setRemark(getRemark());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof EmployeeQualifier) {

      EmployeeQualifier source = (EmployeeQualifier) sourceEntity;

      mergeId(source.getId());
      mergeEmployee(source.getEmployee());
      mergeQualifiedTime(source.getQualifiedTime());
      mergeType(source.getType());
      mergeLevel(source.getLevel());
      mergeRemark(source.getRemark());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof EmployeeQualifier) {

      EmployeeQualifier source = (EmployeeQualifier) sourceEntity;

      mergeId(source.getId());
      mergeQualifiedTime(source.getQualifiedTime());
      mergeType(source.getType());
      mergeLevel(source.getLevel());
      mergeRemark(source.getRemark());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getEmployee(), getQualifiedTime(), getType(), getLevel(), getRemark(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    EmployeeQualifier checkEmployeeQualifier =
        Q.employeeQualifierWithIdField().filterById(id).execute(ctx);

    return checkEmployeeQualifier != null
        && !checkEmployeeQualifier.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public EmployeeQualifier save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("EmployeeQualifier{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getEmployee() != null) {
      stringBuilder.append("\temployee='Employee(" + getEmployee().getId() + ")';");
    }
    stringBuilder.append("\tqualifiedTime='" + getQualifiedTime() + "';");
    stringBuilder.append("\ttype='" + getType() + "';");
    stringBuilder.append("\tlevel='" + getLevel() + "';");
    stringBuilder.append("\tremark='" + getRemark() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
