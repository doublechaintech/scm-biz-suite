package com.doublechaintech.retailscm.levelthreedepartment;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.Employee;

@JsonSerialize(using = LevelThreeDepartmentSerializer.class)
public class LevelThreeDepartment extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(LevelThreeDepartment target) {
    if (target == null) {
      return;
    }
    target.addEmployeeList(this.getEmployeeList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String BELONGS_TO_PROPERTY = "belongsTo";
  public static final String NAME_PROPERTY = "name";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String FOUNDED_PROPERTY = "founded";
  public static final String VERSION_PROPERTY = "version";

  public static final String EMPLOYEE_LIST = "employeeList";

  public static final String INTERNAL_TYPE = "LevelThreeDepartment";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BELONGS_TO_PROPERTY, "level_two_department", "属于")
            .withType("level_two_department", LevelTwoDepartment.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FOUNDED_PROPERTY, "founded", "成立").withType("date_past", "Date"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_LIST, "department", "员工列表")
            .withType("employee", Employee.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      BELONGS_TO_PROPERTY,
      NAME_PROPERTY,
      DESCRIPTION_PROPERTY,
      FOUNDED_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(EMPLOYEE_LIST, "department");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(EMPLOYEE_LIST, Employee.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BELONGS_TO_PROPERTY, LevelTwoDepartment.class);

    return parents;
  }
  /*
  public LevelThreeDepartment want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public LevelThreeDepartment wants(Class<? extends BaseEntity>... classes) {
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
  protected LevelTwoDepartment belongsTo;
  protected String name;
  protected String description;
  protected Date founded;
  protected int version;

  protected SmartList<Employee> mEmployeeList;

  public LevelThreeDepartment() {
    // lazy load for all the properties
  }

  public static LevelThreeDepartment withId(String id) {
    LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
    levelThreeDepartment.setId(id);
    levelThreeDepartment.setVersion(Integer.MAX_VALUE);
    levelThreeDepartment.setChecked(true);
    return levelThreeDepartment;
  }

  public static LevelThreeDepartment refById(String id) {
    return withId(id);
  }

  public LevelThreeDepartment limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public LevelThreeDepartment limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static LevelThreeDepartment searchExample() {
    LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
    levelThreeDepartment.setVersion(UNSET_INT);

    return levelThreeDepartment;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setBelongsTo( null );

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
    if (FOUNDED_PROPERTY.equals(property)) {
      changeFoundedProperty(newValueExpr);
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

  protected void changeFoundedProperty(String newValueExpr) {

    Date oldValue = getFounded();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateFounded(newValue);
    this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (BELONGS_TO_PROPERTY.equals(property)) {
      return getBelongsTo();
    }
    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (FOUNDED_PROPERTY.equals(property)) {
      return getFounded();
    }
    if (EMPLOYEE_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeList().stream().map(item -> item).collect(Collectors.toList());
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

  public LevelThreeDepartment updateId(String id) {
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

  public LevelThreeDepartment orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public LevelThreeDepartment ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public LevelThreeDepartment addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setBelongsTo(LevelTwoDepartment belongsTo) {
    LevelTwoDepartment oldBelongsTo = this.belongsTo;
    LevelTwoDepartment newBelongsTo = belongsTo;
    this.belongsTo = newBelongsTo;
  }

  public LevelTwoDepartment belongsTo() {
    doLoad();
    return getBelongsTo();
  }

  public LevelTwoDepartment getBelongsTo() {
    return this.belongsTo;
  }

  public LevelThreeDepartment updateBelongsTo(LevelTwoDepartment belongsTo) {
    LevelTwoDepartment oldBelongsTo = this.belongsTo;
    LevelTwoDepartment newBelongsTo = belongsTo;
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

  public LevelThreeDepartment orderByBelongsTo(boolean asc) {
    doAddOrderBy(BELONGS_TO_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBelongsToCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BELONGS_TO_PROPERTY, operator, parameters);
  }

  public LevelThreeDepartment ignoreBelongsToCriteria() {
    super.ignoreSearchProperty(BELONGS_TO_PROPERTY);
    return this;
  }

  public LevelThreeDepartment addBelongsToCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBelongsToCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBelongsTo(LevelTwoDepartment belongsTo) {
    if (belongsTo != null) {
      updateBelongsTo(belongsTo);
    }
  }

  public LevelThreeDepartment updateBelongsToByReferenceId(String belongsToId) {
    updateBelongsTo(LevelTwoDepartment.refById(belongsToId));
    return this;
  }

  public void clearBelongsTo() {
    setBelongsTo(null);
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

  public LevelThreeDepartment updateName(String name) {
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

  public LevelThreeDepartment orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public LevelThreeDepartment ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public LevelThreeDepartment addNameCriteria(QueryOperator operator, Object... parameters) {
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

  public LevelThreeDepartment updateDescription(String description) {
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

  public LevelThreeDepartment orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public LevelThreeDepartment ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public LevelThreeDepartment addDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDescription(String description) {
    if (description != null) {
      updateDescription(description);
    }
  }

  public void setFounded(Date founded) {
    Date oldFounded = this.founded;
    Date newFounded = founded;
    this.founded = newFounded;
  }

  public Date founded() {
    doLoad();
    return getFounded();
  }

  public Date getFounded() {
    return this.founded;
  }

  public LevelThreeDepartment updateFounded(Date founded) {
    Date oldFounded = this.founded;
    Date newFounded = founded;
    if (!shouldReplaceBy(newFounded, oldFounded)) {
      return this;
    }
    this.founded = newFounded;
    if (cn.hutool.core.util.ObjectUtil.equals(newFounded, oldFounded)) {
      return this;
    }
    addPropertyChange(FOUNDED_PROPERTY, oldFounded, newFounded);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public LevelThreeDepartment orderByFounded(boolean asc) {
    doAddOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFoundedCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FOUNDED_PROPERTY, operator, parameters);
  }

  public LevelThreeDepartment ignoreFoundedCriteria() {
    super.ignoreSearchProperty(FOUNDED_PROPERTY);
    return this;
  }

  public LevelThreeDepartment addFoundedCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFoundedCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFounded(Date founded) {
    updateFounded(founded);
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

  public LevelThreeDepartment updateVersion(int version) {
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

  public LevelThreeDepartment orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public LevelThreeDepartment ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public LevelThreeDepartment addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<Employee> getEmployeeList() {
    if (this.mEmployeeList == null) {
      this.mEmployeeList = new SmartList<Employee>();
      this.mEmployeeList.setListInternalName(EMPLOYEE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEmployeeList;
  }

  public SmartList<Employee> employeeList() {

    doLoadChild(EMPLOYEE_LIST);

    return getEmployeeList();
  }

  public void setEmployeeList(SmartList<Employee> employeeList) {
    for (Employee employee : employeeList) {
      employee.setDepartment(this);
    }

    this.mEmployeeList = employeeList;
    this.mEmployeeList.setListInternalName(EMPLOYEE_LIST);
  }

  public LevelThreeDepartment addEmployee(Employee employee) {
    employee.updateDepartment(this);
    getEmployeeList().add(employee);
    return this;
  }

  public LevelThreeDepartment addEmployeeList(SmartList<Employee> employeeList) {
    for (Employee employee : employeeList) {
      employee.updateDepartment(this);
    }

    Map<String, Employee> mapById = employeeList.mapWithId();
    getEmployeeList().removeIf(item -> mapById.get(item.getId()) != null);
    getEmployeeList().addAll(employeeList);
    return this;
  }

  public void mergeEmployeeList(SmartList<Employee> employeeList) {
    if (employeeList == null) {
      return;
    }
    if (employeeList.isEmpty()) {
      return;
    }
    addEmployeeList(employeeList);
  }

  public Employee removeEmployee(Employee employeeIndex) {

    int index = getEmployeeList().indexOf(employeeIndex);
    if (index < 0) {
      String message =
          "Employee("
              + employeeIndex.getId()
              + ") with version='"
              + employeeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Employee employee = getEmployeeList().get(index);
    // employee.clearDepartment(); //disconnect with Department
    employee.clearFromAll(); // disconnect with Department

    boolean result = getEmployeeList().planToRemove(employee);
    if (!result) {
      String message =
          "Employee("
              + employeeIndex.getId()
              + ") with version='"
              + employeeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return employee;
  }
  // 断舍离
  public void breakWithEmployee(Employee employee) {

    if (employee == null) {
      return;
    }
    employee.setDepartment(null);
    // getEmployeeList().remove();

  }

  public boolean hasEmployee(Employee employee) {

    return getEmployeeList().contains(employee);
  }

  public void copyEmployeeFrom(Employee employee) {

    Employee employeeInList = findTheEmployee(employee);
    Employee newEmployee = new Employee();
    employeeInList.copyTo(newEmployee);
    newEmployee.setVersion(0); // will trigger copy
    getEmployeeList().add(newEmployee);
    addItemToFlexiableObject(COPIED_CHILD, newEmployee);
  }

  public Employee findTheEmployee(Employee employee) {

    int index = getEmployeeList().indexOf(employee);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Employee("
              + employee.getId()
              + ") with version='"
              + employee.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEmployeeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEmployeeList() {
    getEmployeeList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getBelongsTo(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getEmployeeList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getEmployeeList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
    if (!getEmployeeList().isEmpty()) {
      appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
      appendKeyValuePair(
          result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof LevelThreeDepartment) {

      LevelThreeDepartment dest = (LevelThreeDepartment) baseDest;

      dest.setId(getId());
      dest.setBelongsTo(getBelongsTo());
      dest.setName(getName());
      dest.setDescription(getDescription());
      dest.setFounded(getFounded());
      dest.setVersion(getVersion());
      dest.setEmployeeList(getEmployeeList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof LevelThreeDepartment) {

      LevelThreeDepartment source = (LevelThreeDepartment) sourceEntity;

      mergeId(source.getId());
      mergeBelongsTo(source.getBelongsTo());
      mergeName(source.getName());
      mergeDescription(source.getDescription());
      mergeFounded(source.getFounded());
      mergeVersion(source.getVersion());
      mergeEmployeeList(source.getEmployeeList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof LevelThreeDepartment) {

      LevelThreeDepartment source = (LevelThreeDepartment) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeDescription(source.getDescription());
      mergeFounded(source.getFounded());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getBelongsTo(), getName(), getDescription(), getFounded(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    LevelThreeDepartment checkLevelThreeDepartment =
        Q.levelThreeDepartmentWithIdField()
            .filterById(id)
            .selectEmployeeList(Q.employeeWithIdField().limit(0, 1))
            .execute(ctx);

    return checkLevelThreeDepartment != null
        && !checkLevelThreeDepartment.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public LevelThreeDepartment save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("LevelThreeDepartment{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getBelongsTo() != null) {
      stringBuilder.append("\tbelongsTo='LevelTwoDepartment(" + getBelongsTo().getId() + ")';");
    }
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tfounded='" + getFounded() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
