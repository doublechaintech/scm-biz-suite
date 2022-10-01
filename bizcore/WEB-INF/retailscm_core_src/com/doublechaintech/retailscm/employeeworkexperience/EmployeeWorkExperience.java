package com.doublechaintech.retailscm.employeeworkexperience;

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

@JsonSerialize(using = EmployeeWorkExperienceSerializer.class)
public class EmployeeWorkExperience extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(EmployeeWorkExperience target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String EMPLOYEE_PROPERTY = "employee";
  public static final String START_PROPERTY = "start";
  public static final String END_PROPERTY = "end";
  public static final String COMPANY_PROPERTY = "company";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "EmployeeWorkExperience";

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
        MemberMetaInfo.defineBy(START_PROPERTY, "start", "开始").withType("date", Date.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(END_PROPERTY, "end", "结束").withType("date", Date.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COMPANY_PROPERTY, "company", "公司")
            .withType("string", String.class));
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
      EMPLOYEE_PROPERTY,
      START_PROPERTY,
      END_PROPERTY,
      COMPANY_PROPERTY,
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
    parents.put(EMPLOYEE_PROPERTY, Employee.class);

    return parents;
  }
  /*
  public EmployeeWorkExperience want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeWorkExperience wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getCompany();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected Employee employee;
  protected Date start;
  protected Date end;
  protected String company;
  protected String description;
  protected int version;

  public EmployeeWorkExperience() {
    // lazy load for all the properties
  }

  public static EmployeeWorkExperience withId(String id) {
    EmployeeWorkExperience employeeWorkExperience = new EmployeeWorkExperience();
    employeeWorkExperience.setId(id);
    employeeWorkExperience.setVersion(Integer.MAX_VALUE);
    employeeWorkExperience.setChecked(true);
    return employeeWorkExperience;
  }

  public static EmployeeWorkExperience refById(String id) {
    return withId(id);
  }

  public EmployeeWorkExperience limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public EmployeeWorkExperience limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeWorkExperience searchExample() {
    EmployeeWorkExperience employeeWorkExperience = new EmployeeWorkExperience();
    employeeWorkExperience.setVersion(UNSET_INT);

    return employeeWorkExperience;
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

    if (START_PROPERTY.equals(property)) {
      changeStartProperty(newValueExpr);
    }
    if (END_PROPERTY.equals(property)) {
      changeEndProperty(newValueExpr);
    }
    if (COMPANY_PROPERTY.equals(property)) {
      changeCompanyProperty(newValueExpr);
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      changeDescriptionProperty(newValueExpr);
    }
  }

  protected void changeStartProperty(String newValueExpr) {

    Date oldValue = getStart();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateStart(newValue);
    this.onChangeProperty(START_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeEndProperty(String newValueExpr) {

    Date oldValue = getEnd();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateEnd(newValue);
    this.onChangeProperty(END_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeCompanyProperty(String newValueExpr) {

    String oldValue = getCompany();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateCompany(newValue);
    this.onChangeProperty(COMPANY_PROPERTY, oldValue, newValue);
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

    if (EMPLOYEE_PROPERTY.equals(property)) {
      return getEmployee();
    }
    if (START_PROPERTY.equals(property)) {
      return getStart();
    }
    if (END_PROPERTY.equals(property)) {
      return getEnd();
    }
    if (COMPANY_PROPERTY.equals(property)) {
      return getCompany();
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

  public EmployeeWorkExperience updateId(String id) {
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

  public EmployeeWorkExperience orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public EmployeeWorkExperience ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public EmployeeWorkExperience addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public EmployeeWorkExperience updateEmployee(Employee employee) {
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

  public EmployeeWorkExperience orderByEmployee(boolean asc) {
    doAddOrderBy(EMPLOYEE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
  }

  public EmployeeWorkExperience ignoreEmployeeCriteria() {
    super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeWorkExperience addEmployeeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEmployeeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEmployee(Employee employee) {
    if (employee != null) {
      updateEmployee(employee);
    }
  }

  public EmployeeWorkExperience updateEmployeeByReferenceId(String employeeId) {
    updateEmployee(Employee.refById(employeeId));
    return this;
  }

  public void clearEmployee() {
    setEmployee(null);
    this.changed = true;
    setChecked(false);
  }

  public void setStart(Date start) {
    Date oldStart = this.start;
    Date newStart = start;
    this.start = newStart;
  }

  public Date start() {
    doLoad();
    return getStart();
  }

  public Date getStart() {
    return this.start;
  }

  public EmployeeWorkExperience updateStart(Date start) {
    Date oldStart = this.start;
    Date newStart = start;
    if (!shouldReplaceBy(newStart, oldStart)) {
      return this;
    }
    this.start = newStart;
    if (cn.hutool.core.util.ObjectUtil.equals(newStart, oldStart)) {
      return this;
    }
    addPropertyChange(START_PROPERTY, oldStart, newStart);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeWorkExperience orderByStart(boolean asc) {
    doAddOrderBy(START_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createStartCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(START_PROPERTY, operator, parameters);
  }

  public EmployeeWorkExperience ignoreStartCriteria() {
    super.ignoreSearchProperty(START_PROPERTY);
    return this;
  }

  public EmployeeWorkExperience addStartCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createStartCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeStart(Date start) {
    updateStart(start);
  }

  public void setEnd(Date end) {
    Date oldEnd = this.end;
    Date newEnd = end;
    this.end = newEnd;
  }

  public Date end() {
    doLoad();
    return getEnd();
  }

  public Date getEnd() {
    return this.end;
  }

  public EmployeeWorkExperience updateEnd(Date end) {
    Date oldEnd = this.end;
    Date newEnd = end;
    if (!shouldReplaceBy(newEnd, oldEnd)) {
      return this;
    }
    this.end = newEnd;
    if (cn.hutool.core.util.ObjectUtil.equals(newEnd, oldEnd)) {
      return this;
    }
    addPropertyChange(END_PROPERTY, oldEnd, newEnd);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeWorkExperience orderByEnd(boolean asc) {
    doAddOrderBy(END_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEndCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(END_PROPERTY, operator, parameters);
  }

  public EmployeeWorkExperience ignoreEndCriteria() {
    super.ignoreSearchProperty(END_PROPERTY);
    return this;
  }

  public EmployeeWorkExperience addEndCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEndCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEnd(Date end) {
    updateEnd(end);
  }

  public void setCompany(String company) {
    String oldCompany = this.company;
    String newCompany = trimString(company);
    this.company = newCompany;
  }

  public String company() {
    doLoad();
    return getCompany();
  }

  public String getCompany() {
    return this.company;
  }

  public EmployeeWorkExperience updateCompany(String company) {
    String oldCompany = this.company;
    String newCompany = trimString(company);
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

  public EmployeeWorkExperience orderByCompany(boolean asc) {
    doAddOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMPANY_PROPERTY, operator, parameters);
  }

  public EmployeeWorkExperience ignoreCompanyCriteria() {
    super.ignoreSearchProperty(COMPANY_PROPERTY);
    return this;
  }

  public EmployeeWorkExperience addCompanyCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCompanyCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCompany(String company) {
    if (company != null) {
      updateCompany(company);
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

  public EmployeeWorkExperience updateDescription(String description) {
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

  public EmployeeWorkExperience orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public EmployeeWorkExperience ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public EmployeeWorkExperience addDescriptionCriteria(
      QueryOperator operator, Object... parameters) {
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

  public EmployeeWorkExperience updateVersion(int version) {
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

  public EmployeeWorkExperience orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public EmployeeWorkExperience ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public EmployeeWorkExperience addVersionCriteria(QueryOperator operator, Object... parameters) {
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
    appendKeyValuePair(result, START_PROPERTY, getStart());
    appendKeyValuePair(result, END_PROPERTY, getEnd());
    appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof EmployeeWorkExperience) {

      EmployeeWorkExperience dest = (EmployeeWorkExperience) baseDest;

      dest.setId(getId());
      dest.setEmployee(getEmployee());
      dest.setStart(getStart());
      dest.setEnd(getEnd());
      dest.setCompany(getCompany());
      dest.setDescription(getDescription());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof EmployeeWorkExperience) {

      EmployeeWorkExperience source = (EmployeeWorkExperience) sourceEntity;

      mergeId(source.getId());
      mergeEmployee(source.getEmployee());
      mergeStart(source.getStart());
      mergeEnd(source.getEnd());
      mergeCompany(source.getCompany());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof EmployeeWorkExperience) {

      EmployeeWorkExperience source = (EmployeeWorkExperience) sourceEntity;

      mergeId(source.getId());
      mergeStart(source.getStart());
      mergeEnd(source.getEnd());
      mergeCompany(source.getCompany());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getEmployee(), getStart(), getEnd(), getCompany(), getDescription(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    EmployeeWorkExperience checkEmployeeWorkExperience =
        Q.employeeWorkExperienceWithIdField().filterById(id).execute(ctx);

    return checkEmployeeWorkExperience != null
        && !checkEmployeeWorkExperience.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public EmployeeWorkExperience save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("EmployeeWorkExperience{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getEmployee() != null) {
      stringBuilder.append("\temployee='Employee(" + getEmployee().getId() + ")';");
    }
    stringBuilder.append("\tstart='" + getStart() + "';");
    stringBuilder.append("\tend='" + getEnd() + "';");
    stringBuilder.append("\tcompany='" + getCompany() + "';");
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
