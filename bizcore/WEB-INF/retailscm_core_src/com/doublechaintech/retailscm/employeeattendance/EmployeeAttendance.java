package com.doublechaintech.retailscm.employeeattendance;

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

@JsonSerialize(using = EmployeeAttendanceSerializer.class)
public class EmployeeAttendance extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(EmployeeAttendance target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String EMPLOYEE_PROPERTY = "employee";
  public static final String ENTER_TIME_PROPERTY = "enterTime";
  public static final String LEAVE_TIME_PROPERTY = "leaveTime";
  public static final String DURATION_HOURS_PROPERTY = "durationHours";
  public static final String REMARK_PROPERTY = "remark";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "EmployeeAttendance";

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
        MemberMetaInfo.defineBy(ENTER_TIME_PROPERTY, "enter_time", "进入时间")
            .withType("date", Date.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LEAVE_TIME_PROPERTY, "leave_time", "离开的时候")
            .withType("date", Date.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DURATION_HOURS_PROPERTY, "duration_hours", "持续时间")
            .withType("int", "int"));
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
      ENTER_TIME_PROPERTY,
      LEAVE_TIME_PROPERTY,
      DURATION_HOURS_PROPERTY,
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
  public EmployeeAttendance want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeAttendance wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getRemark();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected Employee employee;
  protected Date enterTime;
  protected Date leaveTime;
  protected int durationHours;
  protected String remark;
  protected int version;

  public EmployeeAttendance() {
    // lazy load for all the properties
  }

  public static EmployeeAttendance withId(String id) {
    EmployeeAttendance employeeAttendance = new EmployeeAttendance();
    employeeAttendance.setId(id);
    employeeAttendance.setVersion(Integer.MAX_VALUE);
    employeeAttendance.setChecked(true);
    return employeeAttendance;
  }

  public static EmployeeAttendance refById(String id) {
    return withId(id);
  }

  public EmployeeAttendance limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public EmployeeAttendance limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeAttendance searchExample() {
    EmployeeAttendance employeeAttendance = new EmployeeAttendance();
    employeeAttendance.setDurationHours(UNSET_INT);
    employeeAttendance.setVersion(UNSET_INT);

    return employeeAttendance;
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

    if (ENTER_TIME_PROPERTY.equals(property)) {
      changeEnterTimeProperty(newValueExpr);
    }
    if (LEAVE_TIME_PROPERTY.equals(property)) {
      changeLeaveTimeProperty(newValueExpr);
    }
    if (DURATION_HOURS_PROPERTY.equals(property)) {
      changeDurationHoursProperty(newValueExpr);
    }
    if (REMARK_PROPERTY.equals(property)) {
      changeRemarkProperty(newValueExpr);
    }
  }

  protected void changeEnterTimeProperty(String newValueExpr) {

    Date oldValue = getEnterTime();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateEnterTime(newValue);
    this.onChangeProperty(ENTER_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLeaveTimeProperty(String newValueExpr) {

    Date oldValue = getLeaveTime();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLeaveTime(newValue);
    this.onChangeProperty(LEAVE_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDurationHoursProperty(String newValueExpr) {

    int oldValue = getDurationHours();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDurationHours(newValue);
    this.onChangeProperty(DURATION_HOURS_PROPERTY, oldValue, newValue);
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
    if (ENTER_TIME_PROPERTY.equals(property)) {
      return getEnterTime();
    }
    if (LEAVE_TIME_PROPERTY.equals(property)) {
      return getLeaveTime();
    }
    if (DURATION_HOURS_PROPERTY.equals(property)) {
      return getDurationHours();
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

  public EmployeeAttendance updateId(String id) {
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

  public EmployeeAttendance orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public EmployeeAttendance ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public EmployeeAttendance addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public EmployeeAttendance updateEmployee(Employee employee) {
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

  public EmployeeAttendance orderByEmployee(boolean asc) {
    doAddOrderBy(EMPLOYEE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
  }

  public EmployeeAttendance ignoreEmployeeCriteria() {
    super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeAttendance addEmployeeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEmployeeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEmployee(Employee employee) {
    if (employee != null) {
      updateEmployee(employee);
    }
  }

  public EmployeeAttendance updateEmployeeByReferenceId(String employeeId) {
    updateEmployee(Employee.refById(employeeId));
    return this;
  }

  public void clearEmployee() {
    setEmployee(null);
    this.changed = true;
    setChecked(false);
  }

  public void setEnterTime(Date enterTime) {
    Date oldEnterTime = this.enterTime;
    Date newEnterTime = enterTime;
    this.enterTime = newEnterTime;
  }

  public Date enterTime() {
    doLoad();
    return getEnterTime();
  }

  public Date getEnterTime() {
    return this.enterTime;
  }

  public EmployeeAttendance updateEnterTime(Date enterTime) {
    Date oldEnterTime = this.enterTime;
    Date newEnterTime = enterTime;
    if (!shouldReplaceBy(newEnterTime, oldEnterTime)) {
      return this;
    }
    this.enterTime = newEnterTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newEnterTime, oldEnterTime)) {
      return this;
    }
    addPropertyChange(ENTER_TIME_PROPERTY, oldEnterTime, newEnterTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeAttendance orderByEnterTime(boolean asc) {
    doAddOrderBy(ENTER_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEnterTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ENTER_TIME_PROPERTY, operator, parameters);
  }

  public EmployeeAttendance ignoreEnterTimeCriteria() {
    super.ignoreSearchProperty(ENTER_TIME_PROPERTY);
    return this;
  }

  public EmployeeAttendance addEnterTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEnterTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEnterTime(Date enterTime) {
    updateEnterTime(enterTime);
  }

  public void setLeaveTime(Date leaveTime) {
    Date oldLeaveTime = this.leaveTime;
    Date newLeaveTime = leaveTime;
    this.leaveTime = newLeaveTime;
  }

  public Date leaveTime() {
    doLoad();
    return getLeaveTime();
  }

  public Date getLeaveTime() {
    return this.leaveTime;
  }

  public EmployeeAttendance updateLeaveTime(Date leaveTime) {
    Date oldLeaveTime = this.leaveTime;
    Date newLeaveTime = leaveTime;
    if (!shouldReplaceBy(newLeaveTime, oldLeaveTime)) {
      return this;
    }
    this.leaveTime = newLeaveTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newLeaveTime, oldLeaveTime)) {
      return this;
    }
    addPropertyChange(LEAVE_TIME_PROPERTY, oldLeaveTime, newLeaveTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeAttendance orderByLeaveTime(boolean asc) {
    doAddOrderBy(LEAVE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLeaveTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LEAVE_TIME_PROPERTY, operator, parameters);
  }

  public EmployeeAttendance ignoreLeaveTimeCriteria() {
    super.ignoreSearchProperty(LEAVE_TIME_PROPERTY);
    return this;
  }

  public EmployeeAttendance addLeaveTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLeaveTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLeaveTime(Date leaveTime) {
    updateLeaveTime(leaveTime);
  }

  public void setDurationHours(int durationHours) {
    int oldDurationHours = this.durationHours;
    int newDurationHours = durationHours;
    this.durationHours = newDurationHours;
  }

  public int durationHours() {
    doLoad();
    return getDurationHours();
  }

  public int getDurationHours() {
    return this.durationHours;
  }

  public EmployeeAttendance updateDurationHours(int durationHours) {
    int oldDurationHours = this.durationHours;
    int newDurationHours = durationHours;
    if (!shouldReplaceBy(newDurationHours, oldDurationHours)) {
      return this;
    }
    this.durationHours = newDurationHours;
    if (cn.hutool.core.util.ObjectUtil.equals(newDurationHours, oldDurationHours)) {
      return this;
    }
    addPropertyChange(DURATION_HOURS_PROPERTY, oldDurationHours, newDurationHours);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeAttendance orderByDurationHours(boolean asc) {
    doAddOrderBy(DURATION_HOURS_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDurationHoursCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DURATION_HOURS_PROPERTY, operator, parameters);
  }

  public EmployeeAttendance ignoreDurationHoursCriteria() {
    super.ignoreSearchProperty(DURATION_HOURS_PROPERTY);
    return this;
  }

  public EmployeeAttendance addDurationHoursCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDurationHoursCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDurationHours(int durationHours) {
    updateDurationHours(durationHours);
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

  public EmployeeAttendance updateRemark(String remark) {
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

  public EmployeeAttendance orderByRemark(boolean asc) {
    doAddOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createRemarkCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(REMARK_PROPERTY, operator, parameters);
  }

  public EmployeeAttendance ignoreRemarkCriteria() {
    super.ignoreSearchProperty(REMARK_PROPERTY);
    return this;
  }

  public EmployeeAttendance addRemarkCriteria(QueryOperator operator, Object... parameters) {
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

  public EmployeeAttendance updateVersion(int version) {
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

  public EmployeeAttendance orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public EmployeeAttendance ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public EmployeeAttendance addVersionCriteria(QueryOperator operator, Object... parameters) {
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
    appendKeyValuePair(result, ENTER_TIME_PROPERTY, getEnterTime());
    appendKeyValuePair(result, LEAVE_TIME_PROPERTY, getLeaveTime());
    appendKeyValuePair(result, DURATION_HOURS_PROPERTY, getDurationHours());
    appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof EmployeeAttendance) {

      EmployeeAttendance dest = (EmployeeAttendance) baseDest;

      dest.setId(getId());
      dest.setEmployee(getEmployee());
      dest.setEnterTime(getEnterTime());
      dest.setLeaveTime(getLeaveTime());
      dest.setDurationHours(getDurationHours());
      dest.setRemark(getRemark());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof EmployeeAttendance) {

      EmployeeAttendance source = (EmployeeAttendance) sourceEntity;

      mergeId(source.getId());
      mergeEmployee(source.getEmployee());
      mergeEnterTime(source.getEnterTime());
      mergeLeaveTime(source.getLeaveTime());
      mergeDurationHours(source.getDurationHours());
      mergeRemark(source.getRemark());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof EmployeeAttendance) {

      EmployeeAttendance source = (EmployeeAttendance) sourceEntity;

      mergeId(source.getId());
      mergeEnterTime(source.getEnterTime());
      mergeLeaveTime(source.getLeaveTime());
      mergeDurationHours(source.getDurationHours());
      mergeRemark(source.getRemark());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getEmployee(),
      getEnterTime(),
      getLeaveTime(),
      getDurationHours(),
      getRemark(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    EmployeeAttendance checkEmployeeAttendance =
        Q.employeeAttendanceWithIdField().filterById(id).execute(ctx);

    return checkEmployeeAttendance != null
        && !checkEmployeeAttendance.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public EmployeeAttendance save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("EmployeeAttendance{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getEmployee() != null) {
      stringBuilder.append("\temployee='Employee(" + getEmployee().getId() + ")';");
    }
    stringBuilder.append("\tenterTime='" + getEnterTime() + "';");
    stringBuilder.append("\tleaveTime='" + getLeaveTime() + "';");
    stringBuilder.append("\tdurationHours='" + getDurationHours() + "';");
    stringBuilder.append("\tremark='" + getRemark() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increaseDurationHours(int incDurationHours) {
    updateDurationHours(this.durationHours + incDurationHours);
  }

  public void decreaseDurationHours(int decDurationHours) {
    updateDurationHours(this.durationHours - decDurationHours);
  }
}
