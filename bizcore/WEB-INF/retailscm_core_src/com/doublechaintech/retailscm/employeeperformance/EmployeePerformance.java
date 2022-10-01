package com.doublechaintech.retailscm.employeeperformance;

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

@JsonSerialize(using = EmployeePerformanceSerializer.class)
public class EmployeePerformance extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(EmployeePerformance target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String EMPLOYEE_PROPERTY = "employee";
  public static final String PERFORMANCE_COMMENT_PROPERTY = "performanceComment";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "EmployeePerformance";

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
        MemberMetaInfo.defineBy(PERFORMANCE_COMMENT_PROPERTY, "performance_comment", "绩效评价")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, EMPLOYEE_PROPERTY, PERFORMANCE_COMMENT_PROPERTY, VERSION_PROPERTY
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
  public EmployeePerformance want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeePerformance wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getPerformanceComment();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected Employee employee;
  protected String performanceComment;
  protected int version;

  public EmployeePerformance() {
    // lazy load for all the properties
  }

  public static EmployeePerformance withId(String id) {
    EmployeePerformance employeePerformance = new EmployeePerformance();
    employeePerformance.setId(id);
    employeePerformance.setVersion(Integer.MAX_VALUE);
    employeePerformance.setChecked(true);
    return employeePerformance;
  }

  public static EmployeePerformance refById(String id) {
    return withId(id);
  }

  public EmployeePerformance limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public EmployeePerformance limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static EmployeePerformance searchExample() {
    EmployeePerformance employeePerformance = new EmployeePerformance();
    employeePerformance.setVersion(UNSET_INT);

    return employeePerformance;
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

    if (PERFORMANCE_COMMENT_PROPERTY.equals(property)) {
      changePerformanceCommentProperty(newValueExpr);
    }
  }

  protected void changePerformanceCommentProperty(String newValueExpr) {

    String oldValue = getPerformanceComment();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updatePerformanceComment(newValue);
    this.onChangeProperty(PERFORMANCE_COMMENT_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (EMPLOYEE_PROPERTY.equals(property)) {
      return getEmployee();
    }
    if (PERFORMANCE_COMMENT_PROPERTY.equals(property)) {
      return getPerformanceComment();
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

  public EmployeePerformance updateId(String id) {
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

  public EmployeePerformance orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public EmployeePerformance ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public EmployeePerformance addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public EmployeePerformance updateEmployee(Employee employee) {
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

  public EmployeePerformance orderByEmployee(boolean asc) {
    doAddOrderBy(EMPLOYEE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
  }

  public EmployeePerformance ignoreEmployeeCriteria() {
    super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeePerformance addEmployeeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEmployeeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEmployee(Employee employee) {
    if (employee != null) {
      updateEmployee(employee);
    }
  }

  public EmployeePerformance updateEmployeeByReferenceId(String employeeId) {
    updateEmployee(Employee.refById(employeeId));
    return this;
  }

  public void clearEmployee() {
    setEmployee(null);
    this.changed = true;
    setChecked(false);
  }

  public void setPerformanceComment(String performanceComment) {
    String oldPerformanceComment = this.performanceComment;
    String newPerformanceComment = trimString(performanceComment);
    this.performanceComment = newPerformanceComment;
  }

  public String performanceComment() {
    doLoad();
    return getPerformanceComment();
  }

  public String getPerformanceComment() {
    return this.performanceComment;
  }

  public EmployeePerformance updatePerformanceComment(String performanceComment) {
    String oldPerformanceComment = this.performanceComment;
    String newPerformanceComment = trimString(performanceComment);
    if (!shouldReplaceBy(newPerformanceComment, oldPerformanceComment)) {
      return this;
    }
    this.performanceComment = newPerformanceComment;
    if (cn.hutool.core.util.ObjectUtil.equals(newPerformanceComment, oldPerformanceComment)) {
      return this;
    }
    addPropertyChange(PERFORMANCE_COMMENT_PROPERTY, oldPerformanceComment, newPerformanceComment);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeePerformance orderByPerformanceComment(boolean asc) {
    doAddOrderBy(PERFORMANCE_COMMENT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPerformanceCommentCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(PERFORMANCE_COMMENT_PROPERTY, operator, parameters);
  }

  public EmployeePerformance ignorePerformanceCommentCriteria() {
    super.ignoreSearchProperty(PERFORMANCE_COMMENT_PROPERTY);
    return this;
  }

  public EmployeePerformance addPerformanceCommentCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPerformanceCommentCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePerformanceComment(String performanceComment) {
    if (performanceComment != null) {
      updatePerformanceComment(performanceComment);
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

  public EmployeePerformance updateVersion(int version) {
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

  public EmployeePerformance orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public EmployeePerformance ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public EmployeePerformance addVersionCriteria(QueryOperator operator, Object... parameters) {
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
    appendKeyValuePair(result, PERFORMANCE_COMMENT_PROPERTY, getPerformanceComment());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof EmployeePerformance) {

      EmployeePerformance dest = (EmployeePerformance) baseDest;

      dest.setId(getId());
      dest.setEmployee(getEmployee());
      dest.setPerformanceComment(getPerformanceComment());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof EmployeePerformance) {

      EmployeePerformance source = (EmployeePerformance) sourceEntity;

      mergeId(source.getId());
      mergeEmployee(source.getEmployee());
      mergePerformanceComment(source.getPerformanceComment());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof EmployeePerformance) {

      EmployeePerformance source = (EmployeePerformance) sourceEntity;

      mergeId(source.getId());
      mergePerformanceComment(source.getPerformanceComment());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getEmployee(), getPerformanceComment(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    EmployeePerformance checkEmployeePerformance =
        Q.employeePerformanceWithIdField().filterById(id).execute(ctx);

    return checkEmployeePerformance != null
        && !checkEmployeePerformance.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public EmployeePerformance save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("EmployeePerformance{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getEmployee() != null) {
      stringBuilder.append("\temployee='Employee(" + getEmployee().getId() + ")';");
    }
    stringBuilder.append("\tperformanceComment='" + getPerformanceComment() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
