package com.doublechaintech.retailscm.scoring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.scoring.Scoring.*;

public class ScoringRequest extends BaseRequest<Scoring> {
  public static ScoringRequest newInstance() {
    return new ScoringRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ScoringRequest resultByClass(Class<? extends Scoring> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ScoringRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ScoringRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Scoring";
  }

  public ScoringRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ScoringRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ScoringRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ScoringRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ScoringRequest selectAll() {
    return this.selectId().selectScoredBy().selectScore().selectComment().selectVersion();
  }

  public ScoringRequest selectAny() {
    return selectAll().selectEmployeeCompanyTrainingList(Q.employeeCompanyTraining().selectSelf());
  }

  public ScoringRequest selectSelf() {
    select(ID_PROPERTY);
    select(SCORED_BY_PROPERTY);
    select(SCORE_PROPERTY);
    select(COMMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ScoringRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ScoringRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, SCORED_BY_PROPERTY, SCORE_PROPERTY, COMMENT_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public ScoringRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ScoringRequest comment(String comment) {
    return this;
  }

  public ScoringRequest enhance() {
    return this;
  }

  public ScoringRequest overrideClass(Class<? extends Scoring> clazz) {
    return this;
  }

  public ScoringRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ScoringRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ScoringRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ScoringRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ScoringRequest count() {
    return countId("count");
  }

  public static ScoringRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ScoringRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ScoringRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ScoringRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ScoringRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ScoringRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ScoringRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ScoringRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ScoringRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ScoringRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ScoringRequest countId() {
    return countId("countId");
  }

  public ScoringRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ScoringRequest maxId() {
    return maxId("maxId");
  }

  public ScoringRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ScoringRequest minId() {
    return minId("minId");
  }

  public ScoringRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ScoringRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ScoringRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ScoringRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ScoringRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ScoringRequest filterByScoredBy(String scoredBy) {

    if (scoredBy == null) {
      return this;
    }

    return filterByScoredBy(QueryOperator.EQUAL, scoredBy);
  }

  public ScoringRequest whereScoredByIsNull() {
    return where(SCORED_BY_PROPERTY, QueryOperator.IS_NULL);
  }

  public ScoringRequest whereScoredByIsNotNull() {
    return where(SCORED_BY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ScoringRequest filterByScoredBy(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getScoredBySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ScoringRequest selectScoredBy() {
    return select(SCORED_BY_PROPERTY);
  }

  public ScoringRequest unselectScoredBy() {
    return unselect(SCORED_BY_PROPERTY);
  }

  public SearchCriteria getScoredBySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SCORED_BY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ScoringRequest orderByScoredBy(boolean asc) {
    addOrderBy(SCORED_BY_PROPERTY, asc);
    return this;
  }

  public ScoringRequest orderByScoredByAscending() {
    addOrderBy(SCORED_BY_PROPERTY, true);
    return this;
  }

  public ScoringRequest orderByScoredByDescending() {
    addOrderBy(SCORED_BY_PROPERTY, false);
    return this;
  }

  public ScoringRequest orderByScoredByAscendingUsingGBK() {
    addOrderBy("convert(scoredBy using gbk)", true);
    return this;
  }

  public ScoringRequest orderByScoredByDescendingUsingGBK() {
    addOrderBy("convert(scoredBy using gbk)", false);
    return this;
  }

  public ScoringRequest countScoredBy() {
    return countScoredBy("countScoredBy");
  }

  public ScoringRequest countScoredBy(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SCORED_BY_PROPERTY);
  }

  public ScoringRequest maxScoredBy() {
    return maxScoredBy("maxScoredBy");
  }

  public ScoringRequest maxScoredBy(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SCORED_BY_PROPERTY);
  }

  public ScoringRequest minScoredBy() {
    return minScoredBy("minScoredBy");
  }

  public ScoringRequest minScoredBy(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SCORED_BY_PROPERTY);
  }

  public ScoringRequest groupByScoredBy() {
    return groupByScoredBy(SCORED_BY_PROPERTY);
  }

  public ScoringRequest groupByScoredBy(String ret) {
    return groupBy(ret, SCORED_BY_PROPERTY);
  }

  public ScoringRequest groupByScoredBy(SqlFunction func) {
    return groupByScoredBy(SCORED_BY_PROPERTY, func);
  }

  public ScoringRequest groupByScoredBy(String ret, SqlFunction func) {
    super.groupBy(ret, func, SCORED_BY_PROPERTY);
    return this;
  }

  public ScoringRequest filterByScore(int score) {

    return filterByScore(QueryOperator.EQUAL, score);
  }

  public ScoringRequest whereScoreIsNull() {
    return where(SCORE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ScoringRequest whereScoreIsNotNull() {
    return where(SCORE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ScoringRequest whereScoreBetween(Integer scoreStart, Integer scoreEnd) {
    if (ObjectUtil.isEmpty(scoreStart)) {
      throw new IllegalArgumentException(
          "Method whereScoreBetween, the parameter scoreStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(scoreEnd)) {
      throw new IllegalArgumentException(
          "Method whereScoreBetween, the parameter scoreEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getScoreSearchCriteria(QueryOperator.BETWEEN, new Object[] {scoreStart, scoreEnd});
    return addSearchCriteria(searchCriteria);
  }

  public ScoringRequest whereScoreLessThan(Integer score) {
    if (ObjectUtil.isEmpty(score)) {
      throw new IllegalArgumentException(
          "Method whereScoreLessThan, the parameter score is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getScoreSearchCriteria(QueryOperator.LESS_THAN, new Object[] {score});
    return addSearchCriteria(searchCriteria);
  }

  public ScoringRequest whereScoreGreaterThan(int score) {
    if (ObjectUtil.isEmpty(score)) {
      throw new IllegalArgumentException(
          "Method whereScoreGreaterThan, the parameter score is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getScoreSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {score});
    return addSearchCriteria(searchCriteria);
  }

  public ScoringRequest filterByScore(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getScoreSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ScoringRequest selectScore() {
    return select(SCORE_PROPERTY);
  }

  public ScoringRequest unselectScore() {
    return unselect(SCORE_PROPERTY);
  }

  public SearchCriteria getScoreSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SCORE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ScoringRequest orderByScore(boolean asc) {
    addOrderBy(SCORE_PROPERTY, asc);
    return this;
  }

  public ScoringRequest orderByScoreAscending() {
    addOrderBy(SCORE_PROPERTY, true);
    return this;
  }

  public ScoringRequest orderByScoreDescending() {
    addOrderBy(SCORE_PROPERTY, false);
    return this;
  }

  public ScoringRequest countScore() {
    return countScore("countScore");
  }

  public ScoringRequest countScore(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SCORE_PROPERTY);
  }

  public ScoringRequest maxScore() {
    return maxScore("maxScore");
  }

  public ScoringRequest maxScore(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SCORE_PROPERTY);
  }

  public ScoringRequest minScore() {
    return minScore("minScore");
  }

  public ScoringRequest minScore(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SCORE_PROPERTY);
  }

  public ScoringRequest sumScore() {
    return sumScore("sumScore");
  }

  public ScoringRequest sumScore(String aggName) {
    return aggregate(aggName, AggFunc.SUM, SCORE_PROPERTY);
  }

  public ScoringRequest groupByScore() {
    return groupByScore(SCORE_PROPERTY);
  }

  public ScoringRequest groupByScore(String ret) {
    return groupBy(ret, SCORE_PROPERTY);
  }

  public ScoringRequest groupByScore(SqlFunction func) {
    return groupByScore(SCORE_PROPERTY, func);
  }

  public ScoringRequest groupByScore(String ret, SqlFunction func) {
    super.groupBy(ret, func, SCORE_PROPERTY);
    return this;
  }

  public ScoringRequest filterByComment(String comment) {

    if (comment == null) {
      return this;
    }

    return filterByComment(QueryOperator.EQUAL, comment);
  }

  public ScoringRequest whereCommentIsNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public ScoringRequest whereCommentIsNotNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ScoringRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ScoringRequest selectComment() {
    return select(COMMENT_PROPERTY);
  }

  public ScoringRequest unselectComment() {
    return unselect(COMMENT_PROPERTY);
  }

  public SearchCriteria getCommentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ScoringRequest orderByComment(boolean asc) {
    addOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public ScoringRequest orderByCommentAscending() {
    addOrderBy(COMMENT_PROPERTY, true);
    return this;
  }

  public ScoringRequest orderByCommentDescending() {
    addOrderBy(COMMENT_PROPERTY, false);
    return this;
  }

  public ScoringRequest orderByCommentAscendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", true);
    return this;
  }

  public ScoringRequest orderByCommentDescendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", false);
    return this;
  }

  public ScoringRequest countComment() {
    return countComment("countComment");
  }

  public ScoringRequest countComment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMMENT_PROPERTY);
  }

  public ScoringRequest maxComment() {
    return maxComment("maxComment");
  }

  public ScoringRequest maxComment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMMENT_PROPERTY);
  }

  public ScoringRequest minComment() {
    return minComment("minComment");
  }

  public ScoringRequest minComment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMMENT_PROPERTY);
  }

  public ScoringRequest groupByComment() {
    return groupByComment(COMMENT_PROPERTY);
  }

  public ScoringRequest groupByComment(String ret) {
    return groupBy(ret, COMMENT_PROPERTY);
  }

  public ScoringRequest groupByComment(SqlFunction func) {
    return groupByComment(COMMENT_PROPERTY, func);
  }

  public ScoringRequest groupByComment(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMMENT_PROPERTY);
    return this;
  }

  public ScoringRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ScoringRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ScoringRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ScoringRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ScoringRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ScoringRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ScoringRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ScoringRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ScoringRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ScoringRequest countVersion() {
    return countVersion("countVersion");
  }

  public ScoringRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ScoringRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ScoringRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ScoringRequest minVersion() {
    return minVersion("minVersion");
  }

  public ScoringRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ScoringRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ScoringRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ScoringRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ScoringRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ScoringRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ScoringRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ScoringRequest hasEmployeeCompanyTraining() {
    return hasEmployeeCompanyTraining(EmployeeCompanyTrainingRequest.newInstance());
  }

  public ScoringRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTraining... employeeCompanyTraining) {
    if (isEmptyParam(employeeCompanyTraining)) {
      throw new IllegalArgumentException(
          "hasEmployeeCompanyTraining(EmployeeCompanyTraining... employeeCompanyTraining)参数不能为空!");
    }
    return hasEmployeeCompanyTraining(
        Q.employeeCompanyTraining()
            .select(EmployeeCompanyTraining.SCORING_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeCompanyTraining));
  }

  public ScoringRequest hasEmployeeCompanyTraining(String... employeeCompanyTraining) {
    return hasEmployeeCompanyTraining(
        Q.employeeCompanyTraining()
            .select(EmployeeCompanyTraining.SCORING_PROPERTY)
            .filterById(employeeCompanyTraining));
  }

  public ScoringRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return hasEmployeeCompanyTraining(
        employeeCompanyTraining,
        $employeeCompanyTraining ->
            java.util.Optional.of($employeeCompanyTraining)
                .map(EmployeeCompanyTraining::getScoring)
                .map(Scoring::getId)
                .orElse(null));
  }

  public ScoringRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      IDRefine<EmployeeCompanyTraining> idRefine) {
    employeeCompanyTraining.select(EmployeeCompanyTraining.SCORING_PROPERTY);
    employeeCompanyTraining.unlimited();
    return addSearchCriteria(
        createEmployeeCompanyTrainingCriteria(employeeCompanyTraining, idRefine));
  }

  public ScoringRequest hasEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeCompanyTraining,
            EmployeeCompanyTraining.SCORING_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createEmployeeCompanyTrainingCriteria(
      EmployeeCompanyTrainingRequest employeeCompanyTraining,
      IDRefine<EmployeeCompanyTraining> idRefine) {
    return new RefinedIdInCriteria(
        employeeCompanyTraining, ID_PROPERTY, idRefine, EmployeeCompanyTraining.SCORING_PROPERTY);
  }

  public ScoringRequest selectEmployeeCompanyTrainingList(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    selectChild(EmployeeCompanyTraining.SCORING_PROPERTY, employeeCompanyTraining);
    return this;
  }

  public ScoringRequest selectEmployeeCompanyTrainingList() {
    return selectEmployeeCompanyTrainingList(
        EmployeeCompanyTrainingRequest.newInstance().selectAll());
  }

  public ScoringRequest unselectEmployeeCompanyTrainingList() {
    unselectChild(EmployeeCompanyTraining.SCORING_PROPERTY, EmployeeCompanyTraining.class);
    return this;
  }

  public ScoringRequest aggregateEmployeeCompanyTrainingList(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    aggregateChild(EmployeeCompanyTraining.SCORING_PROPERTY, employeeCompanyTraining);
    return this;
  }

  public ScoringRequest countEmployeeCompanyTraining() {
    return countEmployeeCompanyTraining("employeeCompanyTrainingCount");
  }

  public ScoringRequest countEmployeeCompanyTraining(String retName) {
    return countEmployeeCompanyTraining(retName, EmployeeCompanyTrainingRequest.newInstance());
  }

  public ScoringRequest countEmployeeCompanyTraining(
      EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return countEmployeeCompanyTraining("employeeCompanyTrainingCount", employeeCompanyTraining);
  }

  public ScoringRequest countEmployeeCompanyTraining(
      String retName, EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    employeeCompanyTraining.count();
    return statsFromEmployeeCompanyTraining(retName, employeeCompanyTraining);
  }

  public ScoringRequest statsFromEmployeeCompanyTraining(
      String retName, EmployeeCompanyTrainingRequest employeeCompanyTraining) {
    return addDynamicProperty(
        retName, employeeCompanyTraining, EmployeeCompanyTraining.SCORING_PROPERTY);
  }

  public ScoringRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ScoringRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ScoringRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ScoringRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
