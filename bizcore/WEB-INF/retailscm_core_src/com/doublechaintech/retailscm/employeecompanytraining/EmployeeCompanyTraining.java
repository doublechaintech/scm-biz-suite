package com.doublechaintech.retailscm.employeecompanytraining;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

@JsonSerialize(using = EmployeeCompanyTrainingSerializer.class)
public class EmployeeCompanyTraining extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(EmployeeCompanyTraining target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String EMPLOYEE_PROPERTY = "employee";
  public static final String TRAINING_PROPERTY = "training";
  public static final String SCORING_PROPERTY = "scoring";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "EmployeeCompanyTraining";

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
        MemberMetaInfo.defineBy(TRAINING_PROPERTY, "company_training", "训练")
            .withType("company_training", CompanyTraining.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SCORING_PROPERTY, "scoring", "评分")
            .withType("scoring", Scoring.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, EMPLOYEE_PROPERTY, TRAINING_PROPERTY, SCORING_PROPERTY, VERSION_PROPERTY
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
    parents.put(TRAINING_PROPERTY, CompanyTraining.class);
    parents.put(SCORING_PROPERTY, Scoring.class);

    return parents;
  }
  /*
  public EmployeeCompanyTraining want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeCompanyTraining wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getId();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected Employee employee;
  protected CompanyTraining training;
  protected Scoring scoring;
  protected int version;

  public EmployeeCompanyTraining() {
    // lazy load for all the properties
  }

  public static EmployeeCompanyTraining withId(String id) {
    EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
    employeeCompanyTraining.setId(id);
    employeeCompanyTraining.setVersion(Integer.MAX_VALUE);
    employeeCompanyTraining.setChecked(true);
    return employeeCompanyTraining;
  }

  public static EmployeeCompanyTraining refById(String id) {
    return withId(id);
  }

  public EmployeeCompanyTraining limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public EmployeeCompanyTraining limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeCompanyTraining searchExample() {
    EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
    employeeCompanyTraining.setVersion(UNSET_INT);

    return employeeCompanyTraining;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setEmployee( null );
  	setTraining( null );
  	setScoring( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {}

  public Object propertyOf(String property) {

    if (EMPLOYEE_PROPERTY.equals(property)) {
      return getEmployee();
    }
    if (TRAINING_PROPERTY.equals(property)) {
      return getTraining();
    }
    if (SCORING_PROPERTY.equals(property)) {
      return getScoring();
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

  public EmployeeCompanyTraining updateId(String id) {
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

  public EmployeeCompanyTraining orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public EmployeeCompanyTraining ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public EmployeeCompanyTraining addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public EmployeeCompanyTraining updateEmployee(Employee employee) {
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

  public EmployeeCompanyTraining orderByEmployee(boolean asc) {
    doAddOrderBy(EMPLOYEE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
  }

  public EmployeeCompanyTraining ignoreEmployeeCriteria() {
    super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeCompanyTraining addEmployeeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEmployeeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEmployee(Employee employee) {
    if (employee != null) {
      updateEmployee(employee);
    }
  }

  public EmployeeCompanyTraining updateEmployeeByReferenceId(String employeeId) {
    updateEmployee(Employee.refById(employeeId));
    return this;
  }

  public void clearEmployee() {
    setEmployee(null);
    this.changed = true;
    setChecked(false);
  }

  public void setTraining(CompanyTraining training) {
    CompanyTraining oldTraining = this.training;
    CompanyTraining newTraining = training;
    this.training = newTraining;
  }

  public CompanyTraining training() {
    doLoad();
    return getTraining();
  }

  public CompanyTraining getTraining() {
    return this.training;
  }

  public EmployeeCompanyTraining updateTraining(CompanyTraining training) {
    CompanyTraining oldTraining = this.training;
    CompanyTraining newTraining = training;
    if (!shouldReplaceBy(newTraining, oldTraining)) {
      return this;
    }
    this.training = newTraining;
    if (cn.hutool.core.util.ObjectUtil.equals(newTraining, oldTraining)) {
      return this;
    }
    addPropertyChange(TRAINING_PROPERTY, oldTraining, newTraining);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeCompanyTraining orderByTraining(boolean asc) {
    doAddOrderBy(TRAINING_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTrainingCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TRAINING_PROPERTY, operator, parameters);
  }

  public EmployeeCompanyTraining ignoreTrainingCriteria() {
    super.ignoreSearchProperty(TRAINING_PROPERTY);
    return this;
  }

  public EmployeeCompanyTraining addTrainingCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTrainingCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTraining(CompanyTraining training) {
    if (training != null) {
      updateTraining(training);
    }
  }

  public EmployeeCompanyTraining updateTrainingByReferenceId(String trainingId) {
    updateTraining(CompanyTraining.refById(trainingId));
    return this;
  }

  public void clearTraining() {
    setTraining(null);
    this.changed = true;
    setChecked(false);
  }

  public void setScoring(Scoring scoring) {
    Scoring oldScoring = this.scoring;
    Scoring newScoring = scoring;
    this.scoring = newScoring;
  }

  public Scoring scoring() {
    doLoad();
    return getScoring();
  }

  public Scoring getScoring() {
    return this.scoring;
  }

  public EmployeeCompanyTraining updateScoring(Scoring scoring) {
    Scoring oldScoring = this.scoring;
    Scoring newScoring = scoring;
    if (!shouldReplaceBy(newScoring, oldScoring)) {
      return this;
    }
    this.scoring = newScoring;
    if (cn.hutool.core.util.ObjectUtil.equals(newScoring, oldScoring)) {
      return this;
    }
    addPropertyChange(SCORING_PROPERTY, oldScoring, newScoring);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeCompanyTraining orderByScoring(boolean asc) {
    doAddOrderBy(SCORING_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createScoringCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SCORING_PROPERTY, operator, parameters);
  }

  public EmployeeCompanyTraining ignoreScoringCriteria() {
    super.ignoreSearchProperty(SCORING_PROPERTY);
    return this;
  }

  public EmployeeCompanyTraining addScoringCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createScoringCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeScoring(Scoring scoring) {
    if (scoring != null) {
      updateScoring(scoring);
    }
  }

  public EmployeeCompanyTraining updateScoringByReferenceId(String scoringId) {
    updateScoring(Scoring.refById(scoringId));
    return this;
  }

  public void clearScoring() {
    setScoring(null);
    this.changed = true;
    setChecked(false);
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

  public EmployeeCompanyTraining updateVersion(int version) {
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

  public EmployeeCompanyTraining orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public EmployeeCompanyTraining ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public EmployeeCompanyTraining addVersionCriteria(QueryOperator operator, Object... parameters) {
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
    addToEntityList(this, entityList, getTraining(), internalType);
    addToEntityList(this, entityList, getScoring(), internalType);
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
    appendKeyValuePair(result, TRAINING_PROPERTY, getTraining());
    appendKeyValuePair(result, SCORING_PROPERTY, getScoring());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof EmployeeCompanyTraining) {

      EmployeeCompanyTraining dest = (EmployeeCompanyTraining) baseDest;

      dest.setId(getId());
      dest.setEmployee(getEmployee());
      dest.setTraining(getTraining());
      dest.setScoring(getScoring());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof EmployeeCompanyTraining) {

      EmployeeCompanyTraining source = (EmployeeCompanyTraining) sourceEntity;

      mergeId(source.getId());
      mergeEmployee(source.getEmployee());
      mergeTraining(source.getTraining());
      mergeScoring(source.getScoring());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof EmployeeCompanyTraining) {

      EmployeeCompanyTraining source = (EmployeeCompanyTraining) sourceEntity;

      mergeId(source.getId());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getEmployee(), getTraining(), getScoring(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    EmployeeCompanyTraining checkEmployeeCompanyTraining =
        Q.employeeCompanyTrainingWithIdField().filterById(id).execute(ctx);

    return checkEmployeeCompanyTraining != null
        && !checkEmployeeCompanyTraining.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public EmployeeCompanyTraining save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("EmployeeCompanyTraining{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getEmployee() != null) {
      stringBuilder.append("\temployee='Employee(" + getEmployee().getId() + ")';");
    }
    if (getTraining() != null) {
      stringBuilder.append("\ttraining='CompanyTraining(" + getTraining().getId() + ")';");
    }
    if (getScoring() != null) {
      stringBuilder.append("\tscoring='Scoring(" + getScoring().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
