package com.doublechaintech.retailscm.view;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.view.View.*;

public class ViewRequest extends BaseRequest<View> {
  public static ViewRequest newInstance() {
    return new ViewRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ViewRequest resultByClass(Class<? extends View> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ViewRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ViewRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "View";
  }

  public ViewRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ViewRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ViewRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ViewRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ViewRequest selectAll() {
    return this.selectId().selectWho().selectAssessment().selectInterviewTime().selectVersion();
  }

  public ViewRequest selectAny() {
    return selectAll();
  }

  public ViewRequest selectSelf() {
    select(ID_PROPERTY);
    select(WHO_PROPERTY);
    select(ASSESSMENT_PROPERTY);
    select(INTERVIEW_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ViewRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ViewRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {INTERVIEW_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, WHO_PROPERTY, ASSESSMENT_PROPERTY, INTERVIEW_TIME_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public ViewRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ViewRequest comment(String comment) {
    return this;
  }

  public ViewRequest enhance() {
    return this;
  }

  public ViewRequest overrideClass(Class<? extends View> clazz) {
    return this;
  }

  public ViewRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ViewRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ViewRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ViewRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ViewRequest count() {
    return countId("count");
  }

  public static ViewRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ViewRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ViewRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ViewRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ViewRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ViewRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ViewRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ViewRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ViewRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ViewRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ViewRequest countId() {
    return countId("countId");
  }

  public ViewRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ViewRequest maxId() {
    return maxId("maxId");
  }

  public ViewRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ViewRequest minId() {
    return minId("minId");
  }

  public ViewRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ViewRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ViewRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ViewRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ViewRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ViewRequest filterByWho(String who) {

    if (who == null) {
      return this;
    }

    return filterByWho(QueryOperator.EQUAL, who);
  }

  public ViewRequest whereWhoIsNull() {
    return where(WHO_PROPERTY, QueryOperator.IS_NULL);
  }

  public ViewRequest whereWhoIsNotNull() {
    return where(WHO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ViewRequest filterByWho(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getWhoSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ViewRequest selectWho() {
    return select(WHO_PROPERTY);
  }

  public ViewRequest unselectWho() {
    return unselect(WHO_PROPERTY);
  }

  public SearchCriteria getWhoSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(WHO_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ViewRequest orderByWho(boolean asc) {
    addOrderBy(WHO_PROPERTY, asc);
    return this;
  }

  public ViewRequest orderByWhoAscending() {
    addOrderBy(WHO_PROPERTY, true);
    return this;
  }

  public ViewRequest orderByWhoDescending() {
    addOrderBy(WHO_PROPERTY, false);
    return this;
  }

  public ViewRequest orderByWhoAscendingUsingGBK() {
    addOrderBy("convert(who using gbk)", true);
    return this;
  }

  public ViewRequest orderByWhoDescendingUsingGBK() {
    addOrderBy("convert(who using gbk)", false);
    return this;
  }

  public ViewRequest countWho() {
    return countWho("countWho");
  }

  public ViewRequest countWho(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WHO_PROPERTY);
  }

  public ViewRequest maxWho() {
    return maxWho("maxWho");
  }

  public ViewRequest maxWho(String aggName) {
    return aggregate(aggName, AggFunc.MAX, WHO_PROPERTY);
  }

  public ViewRequest minWho() {
    return minWho("minWho");
  }

  public ViewRequest minWho(String aggName) {
    return aggregate(aggName, AggFunc.MIN, WHO_PROPERTY);
  }

  public ViewRequest groupByWho() {
    return groupByWho(WHO_PROPERTY);
  }

  public ViewRequest groupByWho(String ret) {
    return groupBy(ret, WHO_PROPERTY);
  }

  public ViewRequest groupByWho(SqlFunction func) {
    return groupByWho(WHO_PROPERTY, func);
  }

  public ViewRequest groupByWho(String ret, SqlFunction func) {
    super.groupBy(ret, func, WHO_PROPERTY);
    return this;
  }

  public ViewRequest filterByAssessment(String assessment) {

    if (assessment == null) {
      return this;
    }

    return filterByAssessment(QueryOperator.EQUAL, assessment);
  }

  public ViewRequest whereAssessmentIsNull() {
    return where(ASSESSMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public ViewRequest whereAssessmentIsNotNull() {
    return where(ASSESSMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ViewRequest filterByAssessment(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAssessmentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ViewRequest selectAssessment() {
    return select(ASSESSMENT_PROPERTY);
  }

  public ViewRequest unselectAssessment() {
    return unselect(ASSESSMENT_PROPERTY);
  }

  public SearchCriteria getAssessmentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ASSESSMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ViewRequest orderByAssessment(boolean asc) {
    addOrderBy(ASSESSMENT_PROPERTY, asc);
    return this;
  }

  public ViewRequest orderByAssessmentAscending() {
    addOrderBy(ASSESSMENT_PROPERTY, true);
    return this;
  }

  public ViewRequest orderByAssessmentDescending() {
    addOrderBy(ASSESSMENT_PROPERTY, false);
    return this;
  }

  public ViewRequest orderByAssessmentAscendingUsingGBK() {
    addOrderBy("convert(assessment using gbk)", true);
    return this;
  }

  public ViewRequest orderByAssessmentDescendingUsingGBK() {
    addOrderBy("convert(assessment using gbk)", false);
    return this;
  }

  public ViewRequest countAssessment() {
    return countAssessment("countAssessment");
  }

  public ViewRequest countAssessment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ASSESSMENT_PROPERTY);
  }

  public ViewRequest maxAssessment() {
    return maxAssessment("maxAssessment");
  }

  public ViewRequest maxAssessment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ASSESSMENT_PROPERTY);
  }

  public ViewRequest minAssessment() {
    return minAssessment("minAssessment");
  }

  public ViewRequest minAssessment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ASSESSMENT_PROPERTY);
  }

  public ViewRequest groupByAssessment() {
    return groupByAssessment(ASSESSMENT_PROPERTY);
  }

  public ViewRequest groupByAssessment(String ret) {
    return groupBy(ret, ASSESSMENT_PROPERTY);
  }

  public ViewRequest groupByAssessment(SqlFunction func) {
    return groupByAssessment(ASSESSMENT_PROPERTY, func);
  }

  public ViewRequest groupByAssessment(String ret, SqlFunction func) {
    super.groupBy(ret, func, ASSESSMENT_PROPERTY);
    return this;
  }

  public ViewRequest filterByInterviewTime(Date interviewTime) {

    if (interviewTime == null) {
      return this;
    }

    return filterByInterviewTime(QueryOperator.EQUAL, interviewTime);
  }

  public ViewRequest whereInterviewTimeIsNull() {
    return where(INTERVIEW_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ViewRequest whereInterviewTimeIsNotNull() {
    return where(INTERVIEW_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ViewRequest whereInterviewTimeBetween(Date interviewTimeStart, Date interviewTimeEnd) {
    if (ObjectUtil.isEmpty(interviewTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereInterviewTimeBetween, the parameter interviewTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(interviewTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereInterviewTimeBetween, the parameter interviewTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getInterviewTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {interviewTimeStart, interviewTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public ViewRequest whereInterviewTimeBefore(Date interviewTime) {

    if (ObjectUtil.isEmpty(interviewTime)) {
      throw new IllegalArgumentException(
          "Method whereInterviewTimeBefore, the parameter interviewTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getInterviewTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {interviewTime});
    return addSearchCriteria(searchCriteria);
  }

  public ViewRequest whereInterviewTimeAfter(Date interviewTime) {
    if (ObjectUtil.isEmpty(interviewTime)) {
      throw new IllegalArgumentException(
          "Method whereInterviewTimeAfter, the parameter interviewTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getInterviewTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {interviewTime});
    return addSearchCriteria(searchCriteria);
  }

  public ViewRequest filterByInterviewTime(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getInterviewTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ViewRequest selectInterviewTime() {
    return select(INTERVIEW_TIME_PROPERTY);
  }

  public ViewRequest unselectInterviewTime() {
    return unselect(INTERVIEW_TIME_PROPERTY);
  }

  public SearchCriteria getInterviewTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(INTERVIEW_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ViewRequest orderByInterviewTime(boolean asc) {
    addOrderBy(INTERVIEW_TIME_PROPERTY, asc);
    return this;
  }

  public ViewRequest orderByInterviewTimeAscending() {
    addOrderBy(INTERVIEW_TIME_PROPERTY, true);
    return this;
  }

  public ViewRequest orderByInterviewTimeDescending() {
    addOrderBy(INTERVIEW_TIME_PROPERTY, false);
    return this;
  }

  public ViewRequest countInterviewTime() {
    return countInterviewTime("countInterviewTime");
  }

  public ViewRequest countInterviewTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, INTERVIEW_TIME_PROPERTY);
  }

  public ViewRequest maxInterviewTime() {
    return maxInterviewTime("maxInterviewTime");
  }

  public ViewRequest maxInterviewTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, INTERVIEW_TIME_PROPERTY);
  }

  public ViewRequest minInterviewTime() {
    return minInterviewTime("minInterviewTime");
  }

  public ViewRequest minInterviewTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, INTERVIEW_TIME_PROPERTY);
  }

  public ViewRequest groupByInterviewTime() {
    return groupByInterviewTime(INTERVIEW_TIME_PROPERTY);
  }

  public ViewRequest groupByInterviewTime(String ret) {
    return groupBy(ret, INTERVIEW_TIME_PROPERTY);
  }

  public ViewRequest groupByInterviewTime(SqlFunction func) {
    return groupByInterviewTime(INTERVIEW_TIME_PROPERTY, func);
  }

  public ViewRequest groupByInterviewTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, INTERVIEW_TIME_PROPERTY);
    return this;
  }

  public ViewRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ViewRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ViewRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ViewRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ViewRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ViewRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ViewRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ViewRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ViewRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ViewRequest countVersion() {
    return countVersion("countVersion");
  }

  public ViewRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ViewRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ViewRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ViewRequest minVersion() {
    return minVersion("minVersion");
  }

  public ViewRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ViewRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ViewRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ViewRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ViewRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ViewRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ViewRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ViewRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ViewRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ViewRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ViewRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
