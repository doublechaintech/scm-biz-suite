package com.doublechaintech.retailscm.companytraining;

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
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

@JsonSerialize(using = CompanyTrainingSerializer.class)
public class CompanyTraining extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(CompanyTraining target) {
    if (target == null) {
      return;
    }
    target.addEmployeeCompanyTrainingList(this.getEmployeeCompanyTrainingList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String TITLE_PROPERTY = "title";
  public static final String COMPANY_PROPERTY = "company";
  public static final String INSTRUCTOR_PROPERTY = "instructor";
  public static final String TRAINING_COURSE_TYPE_PROPERTY = "trainingCourseType";
  public static final String TIME_START_PROPERTY = "timeStart";
  public static final String DURATION_HOURS_PROPERTY = "durationHours";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";

  public static final String INTERNAL_TYPE = "CompanyTraining";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COMPANY_PROPERTY, "retail_store_country_center", "公司")
            .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(INSTRUCTOR_PROPERTY, "instructor", "讲师")
            .withType("instructor", Instructor.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TRAINING_COURSE_TYPE_PROPERTY, "training_course_type", "培训课程类型")
            .withType("training_course_type", TrainingCourseType.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TIME_START_PROPERTY, "time_start", "时间开始")
            .withType("date_past", "Date"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DURATION_HOURS_PROPERTY, "duration_hours", "持续时间")
            .withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
            .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_COMPANY_TRAINING_LIST, "training", "员工公司培训名单")
            .withType("employee_company_training", EmployeeCompanyTraining.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      TITLE_PROPERTY,
      COMPANY_PROPERTY,
      INSTRUCTOR_PROPERTY,
      TRAINING_COURSE_TYPE_PROPERTY,
      TIME_START_PROPERTY,
      DURATION_HOURS_PROPERTY,
      LAST_UPDATE_TIME_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(EMPLOYEE_COMPANY_TRAINING_LIST, "training");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(EMPLOYEE_COMPANY_TRAINING_LIST, EmployeeCompanyTraining.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);
    parents.put(INSTRUCTOR_PROPERTY, Instructor.class);
    parents.put(TRAINING_COURSE_TYPE_PROPERTY, TrainingCourseType.class);

    return parents;
  }
  /*
  public CompanyTraining want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public CompanyTraining wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getTitle();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String title;
  protected RetailStoreCountryCenter company;
  protected Instructor instructor;
  protected TrainingCourseType trainingCourseType;
  protected Date timeStart;
  protected int durationHours;
  protected DateTime lastUpdateTime;
  protected int version;

  protected SmartList<EmployeeCompanyTraining> mEmployeeCompanyTrainingList;

  public CompanyTraining() {
    // lazy load for all the properties
  }

  public static CompanyTraining withId(String id) {
    CompanyTraining companyTraining = new CompanyTraining();
    companyTraining.setId(id);
    companyTraining.setVersion(Integer.MAX_VALUE);
    companyTraining.setChecked(true);
    return companyTraining;
  }

  public static CompanyTraining refById(String id) {
    return withId(id);
  }

  public CompanyTraining limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public CompanyTraining limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static CompanyTraining searchExample() {
    CompanyTraining companyTraining = new CompanyTraining();
    companyTraining.setDurationHours(UNSET_INT);
    companyTraining.setVersion(UNSET_INT);

    return companyTraining;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setCompany( null );
  	setInstructor( null );
  	setTrainingCourseType( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (TITLE_PROPERTY.equals(property)) {
      changeTitleProperty(newValueExpr);
    }
    if (TIME_START_PROPERTY.equals(property)) {
      changeTimeStartProperty(newValueExpr);
    }
    if (DURATION_HOURS_PROPERTY.equals(property)) {
      changeDurationHoursProperty(newValueExpr);
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      changeLastUpdateTimeProperty(newValueExpr);
    }
  }

  protected void changeTitleProperty(String newValueExpr) {

    String oldValue = getTitle();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateTitle(newValue);
    this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeTimeStartProperty(String newValueExpr) {

    Date oldValue = getTimeStart();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateTimeStart(newValue);
    this.onChangeProperty(TIME_START_PROPERTY, oldValue, newValue);
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

  protected void changeLastUpdateTimeProperty(String newValueExpr) {

    DateTime oldValue = getLastUpdateTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLastUpdateTime(newValue);
    this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (TITLE_PROPERTY.equals(property)) {
      return getTitle();
    }
    if (COMPANY_PROPERTY.equals(property)) {
      return getCompany();
    }
    if (INSTRUCTOR_PROPERTY.equals(property)) {
      return getInstructor();
    }
    if (TRAINING_COURSE_TYPE_PROPERTY.equals(property)) {
      return getTrainingCourseType();
    }
    if (TIME_START_PROPERTY.equals(property)) {
      return getTimeStart();
    }
    if (DURATION_HOURS_PROPERTY.equals(property)) {
      return getDurationHours();
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      return getLastUpdateTime();
    }
    if (EMPLOYEE_COMPANY_TRAINING_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeCompanyTrainingList().stream().map(item -> item).collect(Collectors.toList());
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

  public CompanyTraining updateId(String id) {
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

  public CompanyTraining orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public CompanyTraining addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setTitle(String title) {
    String oldTitle = this.title;
    String newTitle = trimString(title);
    this.title = newTitle;
  }

  public String title() {
    doLoad();
    return getTitle();
  }

  public String getTitle() {
    return this.title;
  }

  public CompanyTraining updateTitle(String title) {
    String oldTitle = this.title;
    String newTitle = trimString(title);
    if (!shouldReplaceBy(newTitle, oldTitle)) {
      return this;
    }
    this.title = newTitle;
    if (cn.hutool.core.util.ObjectUtil.equals(newTitle, oldTitle)) {
      return this;
    }
    addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CompanyTraining orderByTitle(boolean asc) {
    doAddOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TITLE_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreTitleCriteria() {
    super.ignoreSearchProperty(TITLE_PROPERTY);
    return this;
  }

  public CompanyTraining addTitleCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTitleCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTitle(String title) {
    if (title != null) {
      updateTitle(title);
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

  public CompanyTraining updateCompany(RetailStoreCountryCenter company) {
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

  public CompanyTraining orderByCompany(boolean asc) {
    doAddOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMPANY_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreCompanyCriteria() {
    super.ignoreSearchProperty(COMPANY_PROPERTY);
    return this;
  }

  public CompanyTraining addCompanyCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCompanyCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCompany(RetailStoreCountryCenter company) {
    if (company != null) {
      updateCompany(company);
    }
  }

  public CompanyTraining updateCompanyByReferenceId(String companyId) {
    updateCompany(RetailStoreCountryCenter.refById(companyId));
    return this;
  }

  public void clearCompany() {
    setCompany(null);
    this.changed = true;
    setChecked(false);
  }

  public void setInstructor(Instructor instructor) {
    Instructor oldInstructor = this.instructor;
    Instructor newInstructor = instructor;
    this.instructor = newInstructor;
  }

  public Instructor instructor() {
    doLoad();
    return getInstructor();
  }

  public Instructor getInstructor() {
    return this.instructor;
  }

  public CompanyTraining updateInstructor(Instructor instructor) {
    Instructor oldInstructor = this.instructor;
    Instructor newInstructor = instructor;
    if (!shouldReplaceBy(newInstructor, oldInstructor)) {
      return this;
    }
    this.instructor = newInstructor;
    if (cn.hutool.core.util.ObjectUtil.equals(newInstructor, oldInstructor)) {
      return this;
    }
    addPropertyChange(INSTRUCTOR_PROPERTY, oldInstructor, newInstructor);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CompanyTraining orderByInstructor(boolean asc) {
    doAddOrderBy(INSTRUCTOR_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createInstructorCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(INSTRUCTOR_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreInstructorCriteria() {
    super.ignoreSearchProperty(INSTRUCTOR_PROPERTY);
    return this;
  }

  public CompanyTraining addInstructorCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createInstructorCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeInstructor(Instructor instructor) {
    if (instructor != null) {
      updateInstructor(instructor);
    }
  }

  public CompanyTraining updateInstructorByReferenceId(String instructorId) {
    updateInstructor(Instructor.refById(instructorId));
    return this;
  }

  public void clearInstructor() {
    setInstructor(null);
    this.changed = true;
    setChecked(false);
  }

  public void setTrainingCourseType(TrainingCourseType trainingCourseType) {
    TrainingCourseType oldTrainingCourseType = this.trainingCourseType;
    TrainingCourseType newTrainingCourseType = trainingCourseType;
    this.trainingCourseType = newTrainingCourseType;
  }

  public TrainingCourseType trainingCourseType() {
    doLoad();
    return getTrainingCourseType();
  }

  public TrainingCourseType getTrainingCourseType() {
    return this.trainingCourseType;
  }

  public CompanyTraining updateTrainingCourseType(TrainingCourseType trainingCourseType) {
    TrainingCourseType oldTrainingCourseType = this.trainingCourseType;
    TrainingCourseType newTrainingCourseType = trainingCourseType;
    if (!shouldReplaceBy(newTrainingCourseType, oldTrainingCourseType)) {
      return this;
    }
    this.trainingCourseType = newTrainingCourseType;
    if (cn.hutool.core.util.ObjectUtil.equals(newTrainingCourseType, oldTrainingCourseType)) {
      return this;
    }
    addPropertyChange(TRAINING_COURSE_TYPE_PROPERTY, oldTrainingCourseType, newTrainingCourseType);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CompanyTraining orderByTrainingCourseType(boolean asc) {
    doAddOrderBy(TRAINING_COURSE_TYPE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTrainingCourseTypeCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(TRAINING_COURSE_TYPE_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreTrainingCourseTypeCriteria() {
    super.ignoreSearchProperty(TRAINING_COURSE_TYPE_PROPERTY);
    return this;
  }

  public CompanyTraining addTrainingCourseTypeCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTrainingCourseTypeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTrainingCourseType(TrainingCourseType trainingCourseType) {
    if (trainingCourseType != null) {
      updateTrainingCourseType(trainingCourseType);
    }
  }

  public CompanyTraining updateTrainingCourseTypeByReferenceId(String trainingCourseTypeId) {
    updateTrainingCourseType(TrainingCourseType.refById(trainingCourseTypeId));
    return this;
  }

  public void clearTrainingCourseType() {
    setTrainingCourseType(null);
    this.changed = true;
    setChecked(false);
  }

  public void setTimeStart(Date timeStart) {
    Date oldTimeStart = this.timeStart;
    Date newTimeStart = timeStart;
    this.timeStart = newTimeStart;
  }

  public Date timeStart() {
    doLoad();
    return getTimeStart();
  }

  public Date getTimeStart() {
    return this.timeStart;
  }

  public CompanyTraining updateTimeStart(Date timeStart) {
    Date oldTimeStart = this.timeStart;
    Date newTimeStart = timeStart;
    if (!shouldReplaceBy(newTimeStart, oldTimeStart)) {
      return this;
    }
    this.timeStart = newTimeStart;
    if (cn.hutool.core.util.ObjectUtil.equals(newTimeStart, oldTimeStart)) {
      return this;
    }
    addPropertyChange(TIME_START_PROPERTY, oldTimeStart, newTimeStart);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CompanyTraining orderByTimeStart(boolean asc) {
    doAddOrderBy(TIME_START_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTimeStartCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TIME_START_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreTimeStartCriteria() {
    super.ignoreSearchProperty(TIME_START_PROPERTY);
    return this;
  }

  public CompanyTraining addTimeStartCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTimeStartCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTimeStart(Date timeStart) {
    updateTimeStart(timeStart);
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

  public CompanyTraining updateDurationHours(int durationHours) {
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

  public CompanyTraining orderByDurationHours(boolean asc) {
    doAddOrderBy(DURATION_HOURS_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDurationHoursCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DURATION_HOURS_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreDurationHoursCriteria() {
    super.ignoreSearchProperty(DURATION_HOURS_PROPERTY);
    return this;
  }

  public CompanyTraining addDurationHoursCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDurationHoursCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDurationHours(int durationHours) {
    updateDurationHours(durationHours);
  }

  public void setLastUpdateTime(DateTime lastUpdateTime) {
    DateTime oldLastUpdateTime = this.lastUpdateTime;
    DateTime newLastUpdateTime = lastUpdateTime;
    this.lastUpdateTime = newLastUpdateTime;
  }

  public DateTime lastUpdateTime() {
    doLoad();
    return getLastUpdateTime();
  }

  public DateTime getLastUpdateTime() {
    return this.lastUpdateTime;
  }

  public CompanyTraining updateLastUpdateTime(DateTime lastUpdateTime) {
    DateTime oldLastUpdateTime = this.lastUpdateTime;
    DateTime newLastUpdateTime = lastUpdateTime;
    if (!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)) {
      return this;
    }
    this.lastUpdateTime = newLastUpdateTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newLastUpdateTime, oldLastUpdateTime)) {
      return this;
    }
    addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CompanyTraining orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public CompanyTraining addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLastUpdateTime(DateTime lastUpdateTime) {
    updateLastUpdateTime(lastUpdateTime);
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

  public CompanyTraining updateVersion(int version) {
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

  public CompanyTraining orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public CompanyTraining ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public CompanyTraining addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<EmployeeCompanyTraining> getEmployeeCompanyTrainingList() {
    if (this.mEmployeeCompanyTrainingList == null) {
      this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
      this.mEmployeeCompanyTrainingList.setListInternalName(EMPLOYEE_COMPANY_TRAINING_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEmployeeCompanyTrainingList;
  }

  public SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList() {

    doLoadChild(EMPLOYEE_COMPANY_TRAINING_LIST);

    return getEmployeeCompanyTrainingList();
  }

  public void setEmployeeCompanyTrainingList(
      SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList) {
    for (EmployeeCompanyTraining employeeCompanyTraining : employeeCompanyTrainingList) {
      employeeCompanyTraining.setTraining(this);
    }

    this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
    this.mEmployeeCompanyTrainingList.setListInternalName(EMPLOYEE_COMPANY_TRAINING_LIST);
  }

  public CompanyTraining addEmployeeCompanyTraining(
      EmployeeCompanyTraining employeeCompanyTraining) {
    employeeCompanyTraining.updateTraining(this);
    getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
    return this;
  }

  public CompanyTraining addEmployeeCompanyTrainingList(
      SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList) {
    for (EmployeeCompanyTraining employeeCompanyTraining : employeeCompanyTrainingList) {
      employeeCompanyTraining.updateTraining(this);
    }

    Map<String, EmployeeCompanyTraining> mapById = employeeCompanyTrainingList.mapWithId();
    getEmployeeCompanyTrainingList().removeIf(item -> mapById.get(item.getId()) != null);
    getEmployeeCompanyTrainingList().addAll(employeeCompanyTrainingList);
    return this;
  }

  public void mergeEmployeeCompanyTrainingList(
      SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList) {
    if (employeeCompanyTrainingList == null) {
      return;
    }
    if (employeeCompanyTrainingList.isEmpty()) {
      return;
    }
    addEmployeeCompanyTrainingList(employeeCompanyTrainingList);
  }

  public EmployeeCompanyTraining removeEmployeeCompanyTraining(
      EmployeeCompanyTraining employeeCompanyTrainingIndex) {

    int index = getEmployeeCompanyTrainingList().indexOf(employeeCompanyTrainingIndex);
    if (index < 0) {
      String message =
          "EmployeeCompanyTraining("
              + employeeCompanyTrainingIndex.getId()
              + ") with version='"
              + employeeCompanyTrainingIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    EmployeeCompanyTraining employeeCompanyTraining = getEmployeeCompanyTrainingList().get(index);
    // employeeCompanyTraining.clearTraining(); //disconnect with Training
    employeeCompanyTraining.clearFromAll(); // disconnect with Training

    boolean result = getEmployeeCompanyTrainingList().planToRemove(employeeCompanyTraining);
    if (!result) {
      String message =
          "EmployeeCompanyTraining("
              + employeeCompanyTrainingIndex.getId()
              + ") with version='"
              + employeeCompanyTrainingIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return employeeCompanyTraining;
  }
  // 断舍离
  public void breakWithEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining) {

    if (employeeCompanyTraining == null) {
      return;
    }
    employeeCompanyTraining.setTraining(null);
    // getEmployeeCompanyTrainingList().remove();

  }

  public boolean hasEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining) {

    return getEmployeeCompanyTrainingList().contains(employeeCompanyTraining);
  }

  public void copyEmployeeCompanyTrainingFrom(EmployeeCompanyTraining employeeCompanyTraining) {

    EmployeeCompanyTraining employeeCompanyTrainingInList =
        findTheEmployeeCompanyTraining(employeeCompanyTraining);
    EmployeeCompanyTraining newEmployeeCompanyTraining = new EmployeeCompanyTraining();
    employeeCompanyTrainingInList.copyTo(newEmployeeCompanyTraining);
    newEmployeeCompanyTraining.setVersion(0); // will trigger copy
    getEmployeeCompanyTrainingList().add(newEmployeeCompanyTraining);
    addItemToFlexiableObject(COPIED_CHILD, newEmployeeCompanyTraining);
  }

  public EmployeeCompanyTraining findTheEmployeeCompanyTraining(
      EmployeeCompanyTraining employeeCompanyTraining) {

    int index = getEmployeeCompanyTrainingList().indexOf(employeeCompanyTraining);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "EmployeeCompanyTraining("
              + employeeCompanyTraining.getId()
              + ") with version='"
              + employeeCompanyTraining.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEmployeeCompanyTrainingList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEmployeeCompanyTrainingList() {
    getEmployeeCompanyTrainingList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCompany(), internalType);
    addToEntityList(this, entityList, getInstructor(), internalType);
    addToEntityList(this, entityList, getTrainingCourseType(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getEmployeeCompanyTrainingList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getEmployeeCompanyTrainingList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
    appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
    appendKeyValuePair(result, INSTRUCTOR_PROPERTY, getInstructor());
    appendKeyValuePair(result, TRAINING_COURSE_TYPE_PROPERTY, getTrainingCourseType());
    appendKeyValuePair(result, TIME_START_PROPERTY, getTimeStart());
    appendKeyValuePair(result, DURATION_HOURS_PROPERTY, getDurationHours());
    appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingList());
    if (!getEmployeeCompanyTrainingList().isEmpty()) {
      appendKeyValuePair(
          result, "employeeCompanyTrainingCount", getEmployeeCompanyTrainingList().getTotalCount());
      appendKeyValuePair(
          result,
          "employeeCompanyTrainingCurrentPageNumber",
          getEmployeeCompanyTrainingList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof CompanyTraining) {

      CompanyTraining dest = (CompanyTraining) baseDest;

      dest.setId(getId());
      dest.setTitle(getTitle());
      dest.setCompany(getCompany());
      dest.setInstructor(getInstructor());
      dest.setTrainingCourseType(getTrainingCourseType());
      dest.setTimeStart(getTimeStart());
      dest.setDurationHours(getDurationHours());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
      dest.setEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof CompanyTraining) {

      CompanyTraining source = (CompanyTraining) sourceEntity;

      mergeId(source.getId());
      mergeTitle(source.getTitle());
      mergeCompany(source.getCompany());
      mergeInstructor(source.getInstructor());
      mergeTrainingCourseType(source.getTrainingCourseType());
      mergeTimeStart(source.getTimeStart());
      mergeDurationHours(source.getDurationHours());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
      mergeEmployeeCompanyTrainingList(source.getEmployeeCompanyTrainingList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof CompanyTraining) {

      CompanyTraining source = (CompanyTraining) sourceEntity;

      mergeId(source.getId());
      mergeTitle(source.getTitle());
      mergeTimeStart(source.getTimeStart());
      mergeDurationHours(source.getDurationHours());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getTitle(),
      getCompany(),
      getInstructor(),
      getTrainingCourseType(),
      getTimeStart(),
      getDurationHours(),
      getLastUpdateTime(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    CompanyTraining checkCompanyTraining =
        Q.companyTrainingWithIdField()
            .filterById(id)
            .selectEmployeeCompanyTrainingList(Q.employeeCompanyTrainingWithIdField().limit(0, 1))
            .execute(ctx);

    return checkCompanyTraining != null
        && !checkCompanyTraining.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public CompanyTraining save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("CompanyTraining{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\ttitle='" + getTitle() + "';");
    if (getCompany() != null) {
      stringBuilder.append("\tcompany='RetailStoreCountryCenter(" + getCompany().getId() + ")';");
    }
    if (getInstructor() != null) {
      stringBuilder.append("\tinstructor='Instructor(" + getInstructor().getId() + ")';");
    }
    if (getTrainingCourseType() != null) {
      stringBuilder.append(
          "\ttrainingCourseType='TrainingCourseType(" + getTrainingCourseType().getId() + ")';");
    }
    stringBuilder.append("\ttimeStart='" + getTimeStart() + "';");
    stringBuilder.append("\tdurationHours='" + getDurationHours() + "';");
    stringBuilder.append("\tlastUpdateTime='" + getLastUpdateTime() + "';");
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
