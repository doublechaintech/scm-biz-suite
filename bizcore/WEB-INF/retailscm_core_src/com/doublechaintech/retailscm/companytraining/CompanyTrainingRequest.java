package com.doublechaintech.retailscm.companytraining;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest;
import com.doublechaintech.retailscm.instructor.InstructorRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.companytraining.CompanyTraining.*;

public class CompanyTrainingRequest extends BaseRequest<CompanyTraining> {
  public static CompanyTrainingRequest newInstance() {
    return new CompanyTrainingRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public CompanyTrainingRequest resultByClass(Class<? extends CompanyTraining> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public CompanyTrainingRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public CompanyTrainingRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "CompanyTraining";
  }

  public CompanyTrainingRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public CompanyTrainingRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public CompanyTrainingRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public CompanyTrainingRequest select(String... names) {
    super.select(names);
    return this;
  }

  public CompanyTrainingRequest selectAll() {
    return this.selectId()
        .selectTitle()
        .selectCompany()
        .selectInstructor()
        .selectTrainingCourseType()
        .selectTimeStart()
        .selectDurationHours()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public CompanyTrainingRequest selectAny() {
    return selectAll().selectEmployeeCompanyTrainingList(Q.employeeCompanyTraining().selectSelf());
  }

  public CompanyTrainingRequest selectSelf() {
    select(ID_PROPERTY);
    select(TITLE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(INSTRUCTOR_PROPERTY);
    select(TRAINING_COURSE_TYPE_PROPERTY);
    select(TIME_START_PROPERTY);
    select(DURATION_HOURS_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public CompanyTrainingRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public CompanyTrainingRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {
    TIME_START_PROPERTY, LAST_UPDATE_TIME_PROPERTY
  };
  protected static final String[] ALL_SELF_FIELDS = {
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

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public CompanyTrainingRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public CompanyTrainingRequest comment(String comment) {
    return this;
  }

  public CompanyTrainingRequest enhance() {
    return this;
  }

  public CompanyTrainingRequest overrideClass(Class<? extends CompanyTraining> clazz) {
    return this;
  }

  public CompanyTrainingRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public CompanyTrainingRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public CompanyTrainingRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public CompanyTrainingRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public CompanyTrainingRequest count() {
    return countId("count");
  }

  public static CompanyTrainingRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public CompanyTrainingRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public CompanyTrainingRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest selectId() {
    return select(ID_PROPERTY);
  }

  public CompanyTrainingRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CompanyTrainingRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public CompanyTrainingRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public CompanyTrainingRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public CompanyTrainingRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public CompanyTrainingRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public CompanyTrainingRequest countId() {
    return countId("countId");
  }

  public CompanyTrainingRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public CompanyTrainingRequest maxId() {
    return maxId("maxId");
  }

  public CompanyTrainingRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public CompanyTrainingRequest minId() {
    return minId("minId");
  }

  public CompanyTrainingRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public CompanyTrainingRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public CompanyTrainingRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public CompanyTrainingRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public CompanyTrainingRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public CompanyTrainingRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public CompanyTrainingRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CompanyTrainingRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public CompanyTrainingRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CompanyTrainingRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public CompanyTrainingRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public CompanyTrainingRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public CompanyTrainingRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public CompanyTrainingRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public CompanyTrainingRequest countTitle() {
    return countTitle("countTitle");
  }

  public CompanyTrainingRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public CompanyTrainingRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public CompanyTrainingRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public CompanyTrainingRequest minTitle() {
    return minTitle("minTitle");
  }

  public CompanyTrainingRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public CompanyTrainingRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public CompanyTrainingRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public CompanyTrainingRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public CompanyTrainingRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest filterByTimeStart(Date timeStart) {

    if (timeStart == null) {
      return this;
    }

    return filterByTimeStart(QueryOperator.EQUAL, timeStart);
  }

  public CompanyTrainingRequest whereTimeStartIsNull() {
    return where(TIME_START_PROPERTY, QueryOperator.IS_NULL);
  }

  public CompanyTrainingRequest whereTimeStartIsNotNull() {
    return where(TIME_START_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CompanyTrainingRequest whereTimeStartBetween(Date timeStartStart, Date timeStartEnd) {
    if (ObjectUtil.isEmpty(timeStartStart)) {
      throw new IllegalArgumentException(
          "Method whereTimeStartBetween, the parameter timeStartStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(timeStartEnd)) {
      throw new IllegalArgumentException(
          "Method whereTimeStartBetween, the parameter timeStartEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTimeStartSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {timeStartStart, timeStartEnd});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest whereTimeStartBefore(Date timeStart) {

    if (ObjectUtil.isEmpty(timeStart)) {
      throw new IllegalArgumentException(
          "Method whereTimeStartBefore, the parameter timeStart is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getTimeStartSearchCriteria(QueryOperator.LESS_THAN, new Object[] {timeStart});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest whereTimeStartAfter(Date timeStart) {
    if (ObjectUtil.isEmpty(timeStart)) {
      throw new IllegalArgumentException(
          "Method whereTimeStartAfter, the parameter timeStart is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTimeStartSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {timeStart});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest filterByTimeStart(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTimeStartSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest selectTimeStart() {
    return select(TIME_START_PROPERTY);
  }

  public CompanyTrainingRequest unselectTimeStart() {
    return unselect(TIME_START_PROPERTY);
  }

  public SearchCriteria getTimeStartSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TIME_START_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CompanyTrainingRequest orderByTimeStart(boolean asc) {
    addOrderBy(TIME_START_PROPERTY, asc);
    return this;
  }

  public CompanyTrainingRequest orderByTimeStartAscending() {
    addOrderBy(TIME_START_PROPERTY, true);
    return this;
  }

  public CompanyTrainingRequest orderByTimeStartDescending() {
    addOrderBy(TIME_START_PROPERTY, false);
    return this;
  }

  public CompanyTrainingRequest countTimeStart() {
    return countTimeStart("countTimeStart");
  }

  public CompanyTrainingRequest countTimeStart(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TIME_START_PROPERTY);
  }

  public CompanyTrainingRequest maxTimeStart() {
    return maxTimeStart("maxTimeStart");
  }

  public CompanyTrainingRequest maxTimeStart(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TIME_START_PROPERTY);
  }

  public CompanyTrainingRequest minTimeStart() {
    return minTimeStart("minTimeStart");
  }

  public CompanyTrainingRequest minTimeStart(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TIME_START_PROPERTY);
  }

  public CompanyTrainingRequest groupByTimeStart() {
    return groupByTimeStart(TIME_START_PROPERTY);
  }

  public CompanyTrainingRequest groupByTimeStart(String ret) {
    return groupBy(ret, TIME_START_PROPERTY);
  }

  public CompanyTrainingRequest groupByTimeStart(SqlFunction func) {
    return groupByTimeStart(TIME_START_PROPERTY, func);
  }

  public CompanyTrainingRequest groupByTimeStart(String ret, SqlFunction func) {
    super.groupBy(ret, func, TIME_START_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest filterByDurationHours(int durationHours) {

    return filterByDurationHours(QueryOperator.EQUAL, durationHours);
  }

  public CompanyTrainingRequest whereDurationHoursIsNull() {
    return where(DURATION_HOURS_PROPERTY, QueryOperator.IS_NULL);
  }

  public CompanyTrainingRequest whereDurationHoursIsNotNull() {
    return where(DURATION_HOURS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CompanyTrainingRequest whereDurationHoursBetween(
      Integer durationHoursStart, Integer durationHoursEnd) {
    if (ObjectUtil.isEmpty(durationHoursStart)) {
      throw new IllegalArgumentException(
          "Method whereDurationHoursBetween, the parameter durationHoursStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(durationHoursEnd)) {
      throw new IllegalArgumentException(
          "Method whereDurationHoursBetween, the parameter durationHoursEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDurationHoursSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {durationHoursStart, durationHoursEnd});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest whereDurationHoursLessThan(Integer durationHours) {
    if (ObjectUtil.isEmpty(durationHours)) {
      throw new IllegalArgumentException(
          "Method whereDurationHoursLessThan, the parameter durationHours is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDurationHoursSearchCriteria(QueryOperator.LESS_THAN, new Object[] {durationHours});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest whereDurationHoursGreaterThan(int durationHours) {
    if (ObjectUtil.isEmpty(durationHours)) {
      throw new IllegalArgumentException(
          "Method whereDurationHoursGreaterThan, the parameter durationHours is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDurationHoursSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {durationHours});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest filterByDurationHours(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDurationHoursSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest selectDurationHours() {
    return select(DURATION_HOURS_PROPERTY);
  }

  public CompanyTrainingRequest unselectDurationHours() {
    return unselect(DURATION_HOURS_PROPERTY);
  }

  public SearchCriteria getDurationHoursSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DURATION_HOURS_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CompanyTrainingRequest orderByDurationHours(boolean asc) {
    addOrderBy(DURATION_HOURS_PROPERTY, asc);
    return this;
  }

  public CompanyTrainingRequest orderByDurationHoursAscending() {
    addOrderBy(DURATION_HOURS_PROPERTY, true);
    return this;
  }

  public CompanyTrainingRequest orderByDurationHoursDescending() {
    addOrderBy(DURATION_HOURS_PROPERTY, false);
    return this;
  }

  public CompanyTrainingRequest countDurationHours() {
    return countDurationHours("countDurationHours");
  }

  public CompanyTrainingRequest countDurationHours(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DURATION_HOURS_PROPERTY);
  }

  public CompanyTrainingRequest maxDurationHours() {
    return maxDurationHours("maxDurationHours");
  }

  public CompanyTrainingRequest maxDurationHours(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DURATION_HOURS_PROPERTY);
  }

  public CompanyTrainingRequest minDurationHours() {
    return minDurationHours("minDurationHours");
  }

  public CompanyTrainingRequest minDurationHours(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DURATION_HOURS_PROPERTY);
  }

  public CompanyTrainingRequest sumDurationHours() {
    return sumDurationHours("sumDurationHours");
  }

  public CompanyTrainingRequest sumDurationHours(String aggName) {
    return aggregate(aggName, AggFunc.SUM, DURATION_HOURS_PROPERTY);
  }

  public CompanyTrainingRequest groupByDurationHours() {
    return groupByDurationHours(DURATION_HOURS_PROPERTY);
  }

  public CompanyTrainingRequest groupByDurationHours(String ret) {
    return groupBy(ret, DURATION_HOURS_PROPERTY);
  }

  public CompanyTrainingRequest groupByDurationHours(SqlFunction func) {
    return groupByDurationHours(DURATION_HOURS_PROPERTY, func);
  }

  public CompanyTrainingRequest groupByDurationHours(String ret, SqlFunction func) {
    super.groupBy(ret, func, DURATION_HOURS_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public CompanyTrainingRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public CompanyTrainingRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CompanyTrainingRequest whereLastUpdateTimeBetween(
      Date lastUpdateTimeStart, Date lastUpdateTimeEnd) {
    if (ObjectUtil.isEmpty(lastUpdateTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastUpdateTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastUpdateTimeStart, lastUpdateTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public CompanyTrainingRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CompanyTrainingRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public CompanyTrainingRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public CompanyTrainingRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public CompanyTrainingRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public CompanyTrainingRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public CompanyTrainingRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public CompanyTrainingRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public CompanyTrainingRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public CompanyTrainingRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public CompanyTrainingRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public CompanyTrainingRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public CompanyTrainingRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public CompanyTrainingRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public CompanyTrainingRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public CompanyTrainingRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CompanyTrainingRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CompanyTrainingRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public CompanyTrainingRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CompanyTrainingRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public CompanyTrainingRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public CompanyTrainingRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public CompanyTrainingRequest countVersion() {
    return countVersion("countVersion");
  }

  public CompanyTrainingRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public CompanyTrainingRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public CompanyTrainingRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public CompanyTrainingRequest minVersion() {
    return minVersion("minVersion");
  }

  public CompanyTrainingRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public CompanyTrainingRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public CompanyTrainingRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public CompanyTrainingRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public CompanyTrainingRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public CompanyTrainingRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public CompanyTrainingRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public CompanyTrainingRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public CompanyTrainingRequest selectCompanyId() {
    select(COMPANY_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToCompany() {
    return upToCompany(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToCompany(RetailStoreCountryCenterRequest company) {
    company.aggregateChild(COMPANY_PROPERTY, this);
    this.groupByCompany(company);
    return company;
  }

  public RetailStoreCountryCenterRequest endAtCompany(String retName) {
    return endAtCompany(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtCompany(
      String retName, RetailStoreCountryCenterRequest company) {
    company.addDynamicProperty(retName, this, COMPANY_PROPERTY);
    return company;
  }

  public CompanyTrainingRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public CompanyTrainingRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public CompanyTrainingRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public CompanyTrainingRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public CompanyTrainingRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public CompanyTrainingRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public CompanyTrainingRequest countCompany() {
    return countCompany("countCompany");
  }

  public CompanyTrainingRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public CompanyTrainingRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public CompanyTrainingRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public CompanyTrainingRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public CompanyTrainingRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CompanyTrainingRequest filterByInstructor(InstructorRequest instructor) {
    return filterByInstructor(instructor, Instructor::getId);
  }

  public CompanyTrainingRequest filterByInstructor(Instructor... instructor) {
    if (isEmptyParam(instructor)) {
      throw new IllegalArgumentException("filterByInstructor(Instructor... instructor)参数不能为空!");
    }
    return where(INSTRUCTOR_PROPERTY, QueryOperator.IN, (Object[]) instructor);
  }

  public CompanyTrainingRequest selectInstructorId() {
    select(INSTRUCTOR_PROPERTY);
    return this;
  }

  public InstructorRequest upToInstructor() {
    return upToInstructor(InstructorRequest.newInstance());
  }

  public InstructorRequest upToInstructor(InstructorRequest instructor) {
    instructor.aggregateChild(INSTRUCTOR_PROPERTY, this);
    this.groupByInstructor(instructor);
    return instructor;
  }

  public InstructorRequest endAtInstructor(String retName) {
    return endAtInstructor(retName, InstructorRequest.newInstance());
  }

  public InstructorRequest endAtInstructor(String retName, InstructorRequest instructor) {
    instructor.addDynamicProperty(retName, this, INSTRUCTOR_PROPERTY);
    return instructor;
  }

  public CompanyTrainingRequest filterByInstructor(String... instructor) {
    if (isEmptyParam(instructor)) {
      throw new IllegalArgumentException("filterByInstructor(String... instructor)参数不能为空!");
    }
    return where(INSTRUCTOR_PROPERTY, QueryOperator.IN, (Object[]) instructor);
  }

  public CompanyTrainingRequest filterByInstructor(
      InstructorRequest instructor, IDRefine<Instructor> idRefine) {
    instructor.unlimited();
    return addSearchCriteria(createInstructorCriteria(instructor, idRefine));
  }

  public SearchCriteria createInstructorCriteria(
      InstructorRequest instructor, IDRefine<Instructor> idRefine) {
    return new RefinedIdInCriteria(
        instructor, INSTRUCTOR_PROPERTY, idRefine, Instructor.ID_PROPERTY);
  }

  public CompanyTrainingRequest selectInstructor() {
    return selectInstructor(InstructorRequest.newInstance().selectSelf());
  }

  public CompanyTrainingRequest selectInstructor(InstructorRequest instructor) {
    selectParent(INSTRUCTOR_PROPERTY, instructor);
    return this;
  }

  public CompanyTrainingRequest unselectInstructor() {
    unselectParent(INSTRUCTOR_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest groupByInstructor(InstructorRequest instructor) {
    groupBy(INSTRUCTOR_PROPERTY, instructor);
    return this;
  }

  public CompanyTrainingRequest aggregateInstructor(InstructorRequest instructor) {
    aggregateParent(INSTRUCTOR_PROPERTY, instructor);
    return this;
  }

  public CompanyTrainingRequest countInstructor() {
    return countInstructor("countInstructor");
  }

  public CompanyTrainingRequest countInstructor(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, INSTRUCTOR_PROPERTY);
  }

  public CompanyTrainingRequest groupByInstructor() {
    return groupByInstructor(INSTRUCTOR_PROPERTY);
  }

  public CompanyTrainingRequest groupByInstructor(String ret) {
    return groupBy(ret, INSTRUCTOR_PROPERTY);
  }

  public CompanyTrainingRequest whereInstructorIsNull() {
    return where(INSTRUCTOR_PROPERTY, QueryOperator.IS_NULL);
  }

  public CompanyTrainingRequest whereInstructorIsNotNull() {
    return where(INSTRUCTOR_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CompanyTrainingRequest filterByTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType) {
    return filterByTrainingCourseType(trainingCourseType, TrainingCourseType::getId);
  }

  public CompanyTrainingRequest filterByTrainingCourseType(
      TrainingCourseType... trainingCourseType) {
    if (isEmptyParam(trainingCourseType)) {
      throw new IllegalArgumentException(
          "filterByTrainingCourseType(TrainingCourseType... trainingCourseType)参数不能为空!");
    }
    return where(TRAINING_COURSE_TYPE_PROPERTY, QueryOperator.IN, (Object[]) trainingCourseType);
  }

  public CompanyTrainingRequest selectTrainingCourseTypeId() {
    select(TRAINING_COURSE_TYPE_PROPERTY);
    return this;
  }

  public TrainingCourseTypeRequest upToTrainingCourseType() {
    return upToTrainingCourseType(TrainingCourseTypeRequest.newInstance());
  }

  public TrainingCourseTypeRequest upToTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType) {
    trainingCourseType.aggregateChild(TRAINING_COURSE_TYPE_PROPERTY, this);
    this.groupByTrainingCourseType(trainingCourseType);
    return trainingCourseType;
  }

  public TrainingCourseTypeRequest endAtTrainingCourseType(String retName) {
    return endAtTrainingCourseType(retName, TrainingCourseTypeRequest.newInstance());
  }

  public TrainingCourseTypeRequest endAtTrainingCourseType(
      String retName, TrainingCourseTypeRequest trainingCourseType) {
    trainingCourseType.addDynamicProperty(retName, this, TRAINING_COURSE_TYPE_PROPERTY);
    return trainingCourseType;
  }

  public CompanyTrainingRequest filterByTrainingCourseType(String... trainingCourseType) {
    if (isEmptyParam(trainingCourseType)) {
      throw new IllegalArgumentException(
          "filterByTrainingCourseType(String... trainingCourseType)参数不能为空!");
    }
    return where(TRAINING_COURSE_TYPE_PROPERTY, QueryOperator.IN, (Object[]) trainingCourseType);
  }

  public CompanyTrainingRequest filterByTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType, IDRefine<TrainingCourseType> idRefine) {
    trainingCourseType.unlimited();
    return addSearchCriteria(createTrainingCourseTypeCriteria(trainingCourseType, idRefine));
  }

  public SearchCriteria createTrainingCourseTypeCriteria(
      TrainingCourseTypeRequest trainingCourseType, IDRefine<TrainingCourseType> idRefine) {
    return new RefinedIdInCriteria(
        trainingCourseType,
        TRAINING_COURSE_TYPE_PROPERTY,
        idRefine,
        TrainingCourseType.ID_PROPERTY);
  }

  public CompanyTrainingRequest selectTrainingCourseType() {
    return selectTrainingCourseType(TrainingCourseTypeRequest.newInstance().selectSelf());
  }

  public CompanyTrainingRequest selectTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType) {
    selectParent(TRAINING_COURSE_TYPE_PROPERTY, trainingCourseType);
    return this;
  }

  public CompanyTrainingRequest unselectTrainingCourseType() {
    unselectParent(TRAINING_COURSE_TYPE_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest groupByTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType) {
    groupBy(TRAINING_COURSE_TYPE_PROPERTY, trainingCourseType);
    return this;
  }

  public CompanyTrainingRequest aggregateTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType) {
    aggregateParent(TRAINING_COURSE_TYPE_PROPERTY, trainingCourseType);
    return this;
  }

  public CompanyTrainingRequest countTrainingCourseType() {
    return countTrainingCourseType("countTrainingCourseType");
  }

  public CompanyTrainingRequest countTrainingCourseType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TRAINING_COURSE_TYPE_PROPERTY);
  }

  public CompanyTrainingRequest groupByTrainingCourseType() {
    return groupByTrainingCourseType(TRAINING_COURSE_TYPE_PROPERTY);
  }

  public CompanyTrainingRequest groupByTrainingCourseType(String ret) {
    return groupBy(ret, TRAINING_COURSE_TYPE_PROPERTY);
  }

  public CompanyTrainingRequest whereTrainingCourseTypeIsNull() {
    return where(TRAINING_COURSE_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public CompanyTrainingRequest whereTrainingCourseTypeIsNotNull() {
    return where(TRAINING_COURSE_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CompanyTrainingRequest hasEmployeeCompanyTraining() {
    return hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest.newInstance());
  }

  public CompanyTrainingRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTraining... employeeCompanyTraining) {
    if (isEmptyParam(employeeCompanyTraining)) {
      throw new IllegalArgumentException(
          "hasEmployeeCompanyTraining(EmployeeCompanyTraining... employeeCompanyTraining)参数不能为空!");
    }
    return hasEmployeeCompanyTraining(
        Q.employeeCompanyTraining()
            .select(EmployeeCompanyTraining.TRAINING_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeCompanyTraining));
  }

  public CompanyTrainingRequest hasEmployeeCompanyTraining(String... employeeCompanyTraining) {
    return hasEmployeeCompanyTraining(
        Q.employeeCompanyTraining()
            .select(EmployeeCompanyTraining.TRAINING_PROPERTY)
            .filterById(employeeCompanyTraining));
  }

  public CompanyTrainingRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return hasEmployeeCompanyTraining(
        employeeCompanyTraining,
        $employeeCompanyTraining ->
            java.util.Optional.of($employeeCompanyTraining)
                .map(EmployeeCompanyTraining::getTraining)
                .map(CompanyTraining::getId)
                .orElse(null));
  }

  public CompanyTrainingRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      IDRefine<EmployeeCompanyTraining> idRefine) {
    employeeCompanyTraining.select(EmployeeCompanyTraining.TRAINING_PROPERTY);
    employeeCompanyTraining.unlimited();
    return addSearchCriteria(
        createEmployeeCompanyTrainingCriteria(employeeCompanyTraining, idRefine));
  }

  public CompanyTrainingRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeCompanyTraining,
            EmployeeCompanyTraining.TRAINING_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createEmployeeCompanyTrainingCriteria(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      IDRefine<EmployeeCompanyTraining> idRefine) {
    return new RefinedIdInCriteria(
        employeeCompanyTraining, ID_PROPERTY, idRefine, EmployeeCompanyTraining.TRAINING_PROPERTY);
  }

  public CompanyTrainingRequest selectEmployeeCompanyTrainingList(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    selectChild(EmployeeCompanyTraining.TRAINING_PROPERTY, employeeCompanyTraining);
    return this;
  }

  public CompanyTrainingRequest selectEmployeeCompanyTrainingList() {
    return selectEmployeeCompanyTrainingList(
        EmployeeCompanyTrainingRequest.newInstance().selectAll());
  }

  public CompanyTrainingRequest unselectEmployeeCompanyTrainingList() {
    unselectChild(EmployeeCompanyTraining.TRAINING_PROPERTY, EmployeeCompanyTraining.class);
    return this;
  }

  public CompanyTrainingRequest aggregateEmployeeCompanyTrainingList(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    aggregateChild(EmployeeCompanyTraining.TRAINING_PROPERTY, employeeCompanyTraining);
    return this;
  }

  public CompanyTrainingRequest countEmployeeCompanyTraining() {
    return countEmployeeCompanyTraining("employeeCompanyTrainingCount");
  }

  public CompanyTrainingRequest countEmployeeCompanyTraining(String retName) {
    return countEmployeeCompanyTraining(retName, EmployeeCompanyTrainingRequest.newInstance());
  }

  public CompanyTrainingRequest countEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return countEmployeeCompanyTraining("employeeCompanyTrainingCount", employeeCompanyTraining);
  }

  public CompanyTrainingRequest countEmployeeCompanyTraining(
      String retName, EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    employeeCompanyTraining.count();
    return statsFromEmployeeCompanyTraining(retName, employeeCompanyTraining);
  }

  public CompanyTrainingRequest statsFromEmployeeCompanyTraining(
      String retName, EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return addDynamicProperty(
        retName, employeeCompanyTraining, EmployeeCompanyTraining.TRAINING_PROPERTY);
  }

  public CompanyTrainingRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public CompanyTrainingRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public CompanyTrainingRequest unlimited() {
    super.unlimited();
    return this;
  }

  public CompanyTrainingRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
