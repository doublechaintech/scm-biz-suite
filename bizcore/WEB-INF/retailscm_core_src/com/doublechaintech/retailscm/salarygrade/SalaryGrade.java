package com.doublechaintech.retailscm.salarygrade;

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
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

@JsonSerialize(using = SalaryGradeSerializer.class)
public class SalaryGrade extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(SalaryGrade target) {
    if (target == null) {
      return;
    }
    target.addEmployeeList(this.getEmployeeList());
    target.addEmployeeSalarySheetList(this.getEmployeeSalarySheetList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String CODE_PROPERTY = "code";
  public static final String COMPANY_PROPERTY = "company";
  public static final String NAME_PROPERTY = "name";
  public static final String DETAIL_DESCRIPTION_PROPERTY = "detailDescription";
  public static final String VERSION_PROPERTY = "version";

  public static final String EMPLOYEE_LIST = "employeeList";
  public static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";

  public static final String INTERNAL_TYPE = "SalaryGrade";

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
        MemberMetaInfo.defineBy(DETAIL_DESCRIPTION_PROPERTY, "detail_description", "详细描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_LIST, "currentSalaryGrade", "员工列表")
            .withType("employee", Employee.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_SALARY_SHEET_LIST, "currentSalaryGrade", "员工工资表")
            .withType("employee_salary_sheet", EmployeeSalarySheet.class));
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
      DETAIL_DESCRIPTION_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(EMPLOYEE_LIST, "currentSalaryGrade");

    refers.put(EMPLOYEE_SALARY_SHEET_LIST, "currentSalaryGrade");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(EMPLOYEE_LIST, Employee.class);

    refers.put(EMPLOYEE_SALARY_SHEET_LIST, EmployeeSalarySheet.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }
  /*
  public SalaryGrade want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public SalaryGrade wants(Class<? extends BaseEntity>... classes) {
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
  protected String detailDescription;
  protected int version;

  protected SmartList<Employee> mEmployeeList;
  protected SmartList<EmployeeSalarySheet> mEmployeeSalarySheetList;

  public SalaryGrade() {
    // lazy load for all the properties
  }

  public static SalaryGrade withId(String id) {
    SalaryGrade salaryGrade = new SalaryGrade();
    salaryGrade.setId(id);
    salaryGrade.setVersion(Integer.MAX_VALUE);
    salaryGrade.setChecked(true);
    return salaryGrade;
  }

  public static SalaryGrade refById(String id) {
    return withId(id);
  }

  public SalaryGrade limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public SalaryGrade limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static SalaryGrade searchExample() {
    SalaryGrade salaryGrade = new SalaryGrade();
    salaryGrade.setVersion(UNSET_INT);

    return salaryGrade;
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
    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (DETAIL_DESCRIPTION_PROPERTY.equals(property)) {
      return getDetailDescription();
    }
    if (EMPLOYEE_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (EMPLOYEE_SALARY_SHEET_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeSalarySheetList().stream().map(item -> item).collect(Collectors.toList());
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

  public SalaryGrade updateId(String id) {
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

  public SalaryGrade orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public SalaryGrade ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public SalaryGrade addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public SalaryGrade updateCode(String code) {
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

  public SalaryGrade orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public SalaryGrade ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public SalaryGrade addCodeCriteria(QueryOperator operator, Object... parameters) {
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

  public SalaryGrade updateCompany(RetailStoreCountryCenter company) {
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

  public SalaryGrade orderByCompany(boolean asc) {
    doAddOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMPANY_PROPERTY, operator, parameters);
  }

  public SalaryGrade ignoreCompanyCriteria() {
    super.ignoreSearchProperty(COMPANY_PROPERTY);
    return this;
  }

  public SalaryGrade addCompanyCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCompanyCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCompany(RetailStoreCountryCenter company) {
    if (company != null) {
      updateCompany(company);
    }
  }

  public SalaryGrade updateCompanyByReferenceId(String companyId) {
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

  public SalaryGrade updateName(String name) {
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

  public SalaryGrade orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public SalaryGrade ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public SalaryGrade addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
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

  public SalaryGrade updateDetailDescription(String detailDescription) {
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

  public SalaryGrade orderByDetailDescription(boolean asc) {
    doAddOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDetailDescriptionCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(DETAIL_DESCRIPTION_PROPERTY, operator, parameters);
  }

  public SalaryGrade ignoreDetailDescriptionCriteria() {
    super.ignoreSearchProperty(DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public SalaryGrade addDetailDescriptionCriteria(QueryOperator operator, Object... parameters) {
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

  public SalaryGrade updateVersion(int version) {
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

  public SalaryGrade orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public SalaryGrade ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public SalaryGrade addVersionCriteria(QueryOperator operator, Object... parameters) {
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
      employee.setCurrentSalaryGrade(this);
    }

    this.mEmployeeList = employeeList;
    this.mEmployeeList.setListInternalName(EMPLOYEE_LIST);
  }

  public SalaryGrade addEmployee(Employee employee) {
    employee.updateCurrentSalaryGrade(this);
    getEmployeeList().add(employee);
    return this;
  }

  public SalaryGrade addEmployeeList(SmartList<Employee> employeeList) {
    for (Employee employee : employeeList) {
      employee.updateCurrentSalaryGrade(this);
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
    // employee.clearCurrentSalaryGrade(); //disconnect with CurrentSalaryGrade
    employee.clearFromAll(); // disconnect with CurrentSalaryGrade

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
    employee.setCurrentSalaryGrade(null);
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

  public SmartList<EmployeeSalarySheet> getEmployeeSalarySheetList() {
    if (this.mEmployeeSalarySheetList == null) {
      this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();
      this.mEmployeeSalarySheetList.setListInternalName(EMPLOYEE_SALARY_SHEET_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEmployeeSalarySheetList;
  }

  public SmartList<EmployeeSalarySheet> employeeSalarySheetList() {

    doLoadChild(EMPLOYEE_SALARY_SHEET_LIST);

    return getEmployeeSalarySheetList();
  }

  public void setEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList) {
    for (EmployeeSalarySheet employeeSalarySheet : employeeSalarySheetList) {
      employeeSalarySheet.setCurrentSalaryGrade(this);
    }

    this.mEmployeeSalarySheetList = employeeSalarySheetList;
    this.mEmployeeSalarySheetList.setListInternalName(EMPLOYEE_SALARY_SHEET_LIST);
  }

  public SalaryGrade addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet) {
    employeeSalarySheet.updateCurrentSalaryGrade(this);
    getEmployeeSalarySheetList().add(employeeSalarySheet);
    return this;
  }

  public SalaryGrade addEmployeeSalarySheetList(
      SmartList<EmployeeSalarySheet> employeeSalarySheetList) {
    for (EmployeeSalarySheet employeeSalarySheet : employeeSalarySheetList) {
      employeeSalarySheet.updateCurrentSalaryGrade(this);
    }

    Map<String, EmployeeSalarySheet> mapById = employeeSalarySheetList.mapWithId();
    getEmployeeSalarySheetList().removeIf(item -> mapById.get(item.getId()) != null);
    getEmployeeSalarySheetList().addAll(employeeSalarySheetList);
    return this;
  }

  public void mergeEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList) {
    if (employeeSalarySheetList == null) {
      return;
    }
    if (employeeSalarySheetList.isEmpty()) {
      return;
    }
    addEmployeeSalarySheetList(employeeSalarySheetList);
  }

  public EmployeeSalarySheet removeEmployeeSalarySheet(
      EmployeeSalarySheet employeeSalarySheetIndex) {

    int index = getEmployeeSalarySheetList().indexOf(employeeSalarySheetIndex);
    if (index < 0) {
      String message =
          "EmployeeSalarySheet("
              + employeeSalarySheetIndex.getId()
              + ") with version='"
              + employeeSalarySheetIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    EmployeeSalarySheet employeeSalarySheet = getEmployeeSalarySheetList().get(index);
    // employeeSalarySheet.clearCurrentSalaryGrade(); //disconnect with CurrentSalaryGrade
    employeeSalarySheet.clearFromAll(); // disconnect with CurrentSalaryGrade

    boolean result = getEmployeeSalarySheetList().planToRemove(employeeSalarySheet);
    if (!result) {
      String message =
          "EmployeeSalarySheet("
              + employeeSalarySheetIndex.getId()
              + ") with version='"
              + employeeSalarySheetIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return employeeSalarySheet;
  }
  // 断舍离
  public void breakWithEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet) {

    if (employeeSalarySheet == null) {
      return;
    }
    employeeSalarySheet.setCurrentSalaryGrade(null);
    // getEmployeeSalarySheetList().remove();

  }

  public boolean hasEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet) {

    return getEmployeeSalarySheetList().contains(employeeSalarySheet);
  }

  public void copyEmployeeSalarySheetFrom(EmployeeSalarySheet employeeSalarySheet) {

    EmployeeSalarySheet employeeSalarySheetInList = findTheEmployeeSalarySheet(employeeSalarySheet);
    EmployeeSalarySheet newEmployeeSalarySheet = new EmployeeSalarySheet();
    employeeSalarySheetInList.copyTo(newEmployeeSalarySheet);
    newEmployeeSalarySheet.setVersion(0); // will trigger copy
    getEmployeeSalarySheetList().add(newEmployeeSalarySheet);
    addItemToFlexiableObject(COPIED_CHILD, newEmployeeSalarySheet);
  }

  public EmployeeSalarySheet findTheEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet) {

    int index = getEmployeeSalarySheetList().indexOf(employeeSalarySheet);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "EmployeeSalarySheet("
              + employeeSalarySheet.getId()
              + ") with version='"
              + employeeSalarySheet.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEmployeeSalarySheetList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEmployeeSalarySheetList() {
    getEmployeeSalarySheetList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCompany(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getEmployeeList(), internalType);
    collectFromList(this, entityList, getEmployeeSalarySheetList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getEmployeeList());
    listOfList.add(getEmployeeSalarySheetList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, CODE_PROPERTY, getCode());
    appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, DETAIL_DESCRIPTION_PROPERTY, getDetailDescription());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
    if (!getEmployeeList().isEmpty()) {
      appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
      appendKeyValuePair(
          result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetList());
    if (!getEmployeeSalarySheetList().isEmpty()) {
      appendKeyValuePair(
          result, "employeeSalarySheetCount", getEmployeeSalarySheetList().getTotalCount());
      appendKeyValuePair(
          result,
          "employeeSalarySheetCurrentPageNumber",
          getEmployeeSalarySheetList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof SalaryGrade) {

      SalaryGrade dest = (SalaryGrade) baseDest;

      dest.setId(getId());
      dest.setCode(getCode());
      dest.setCompany(getCompany());
      dest.setName(getName());
      dest.setDetailDescription(getDetailDescription());
      dest.setVersion(getVersion());
      dest.setEmployeeList(getEmployeeList());
      dest.setEmployeeSalarySheetList(getEmployeeSalarySheetList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof SalaryGrade) {

      SalaryGrade source = (SalaryGrade) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeCompany(source.getCompany());
      mergeName(source.getName());
      mergeDetailDescription(source.getDetailDescription());
      mergeVersion(source.getVersion());
      mergeEmployeeList(source.getEmployeeList());
      mergeEmployeeSalarySheetList(source.getEmployeeSalarySheetList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof SalaryGrade) {

      SalaryGrade source = (SalaryGrade) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeName(source.getName());
      mergeDetailDescription(source.getDetailDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getCode(), getCompany(), getName(), getDetailDescription(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    SalaryGrade checkSalaryGrade =
        Q.salaryGradeWithIdField()
            .filterById(id)
            .selectEmployeeList(Q.employeeWithIdField().limit(0, 1))
            .selectEmployeeSalarySheetList(Q.employeeSalarySheetWithIdField().limit(0, 1))
            .execute(ctx);

    return checkSalaryGrade != null
        && !checkSalaryGrade.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public SalaryGrade save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("SalaryGrade{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    if (getCompany() != null) {
      stringBuilder.append("\tcompany='RetailStoreCountryCenter(" + getCompany().getId() + ")';");
    }
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tdetailDescription='" + getDetailDescription() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
