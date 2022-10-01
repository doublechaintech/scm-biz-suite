package com.doublechaintech.retailscm.termination;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.termination.Termination.*;

public class TerminationRequest extends BaseRequest<Termination> {
  public static TerminationRequest newInstance() {
    return new TerminationRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TerminationRequest resultByClass(Class<? extends Termination> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TerminationRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TerminationRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Termination";
  }

  public TerminationRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TerminationRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TerminationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TerminationRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TerminationRequest selectAll() {
    return this.selectId().selectReason().selectType().selectComment().selectVersion();
  }

  public TerminationRequest selectAny() {
    return selectAll();
  }

  public TerminationRequest selectSelf() {
    select(ID_PROPERTY);
    select(REASON_PROPERTY);
    select(TYPE_PROPERTY);
    select(COMMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TerminationRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TerminationRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, REASON_PROPERTY, TYPE_PROPERTY, COMMENT_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public TerminationRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TerminationRequest comment(String comment) {
    return this;
  }

  public TerminationRequest enhance() {
    return this;
  }

  public TerminationRequest overrideClass(Class<? extends Termination> clazz) {
    return this;
  }

  public TerminationRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TerminationRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TerminationRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TerminationRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TerminationRequest count() {
    return countId("count");
  }

  public static TerminationRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TerminationRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TerminationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TerminationRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TerminationRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TerminationRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TerminationRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TerminationRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TerminationRequest countId() {
    return countId("countId");
  }

  public TerminationRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TerminationRequest maxId() {
    return maxId("maxId");
  }

  public TerminationRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TerminationRequest minId() {
    return minId("minId");
  }

  public TerminationRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TerminationRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TerminationRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TerminationRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TerminationRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TerminationRequest filterByComment(String comment) {

    if (comment == null) {
      return this;
    }

    return filterByComment(QueryOperator.EQUAL, comment);
  }

  public TerminationRequest whereCommentIsNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationRequest whereCommentIsNotNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationRequest filterByComment(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationRequest selectComment() {
    return select(COMMENT_PROPERTY);
  }

  public TerminationRequest unselectComment() {
    return unselect(COMMENT_PROPERTY);
  }

  public SearchCriteria getCommentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationRequest orderByComment(boolean asc) {
    addOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public TerminationRequest orderByCommentAscending() {
    addOrderBy(COMMENT_PROPERTY, true);
    return this;
  }

  public TerminationRequest orderByCommentDescending() {
    addOrderBy(COMMENT_PROPERTY, false);
    return this;
  }

  public TerminationRequest orderByCommentAscendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", true);
    return this;
  }

  public TerminationRequest orderByCommentDescendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", false);
    return this;
  }

  public TerminationRequest countComment() {
    return countComment("countComment");
  }

  public TerminationRequest countComment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMMENT_PROPERTY);
  }

  public TerminationRequest maxComment() {
    return maxComment("maxComment");
  }

  public TerminationRequest maxComment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMMENT_PROPERTY);
  }

  public TerminationRequest minComment() {
    return minComment("minComment");
  }

  public TerminationRequest minComment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMMENT_PROPERTY);
  }

  public TerminationRequest groupByComment() {
    return groupByComment(COMMENT_PROPERTY);
  }

  public TerminationRequest groupByComment(String ret) {
    return groupBy(ret, COMMENT_PROPERTY);
  }

  public TerminationRequest groupByComment(SqlFunction func) {
    return groupByComment(COMMENT_PROPERTY, func);
  }

  public TerminationRequest groupByComment(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMMENT_PROPERTY);
    return this;
  }

  public TerminationRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TerminationRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TerminationRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TerminationRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TerminationRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TerminationRequest countVersion() {
    return countVersion("countVersion");
  }

  public TerminationRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TerminationRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TerminationRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TerminationRequest minVersion() {
    return minVersion("minVersion");
  }

  public TerminationRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TerminationRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TerminationRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TerminationRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TerminationRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TerminationRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TerminationRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TerminationRequest filterByReason(TerminationReasonRequest reason) {
    return filterByReason(reason, TerminationReason::getId);
  }

  public TerminationRequest filterByReason(TerminationReason... reason) {
    if (isEmptyParam(reason)) {
      throw new IllegalArgumentException("filterByReason(TerminationReason... reason)参数不能为空!");
    }
    return where(REASON_PROPERTY, QueryOperator.IN, (Object[]) reason);
  }

  public TerminationRequest selectReasonId() {
    select(REASON_PROPERTY);
    return this;
  }

  public TerminationReasonRequest upToReason() {
    return upToReason(TerminationReasonRequest.newInstance());
  }

  public TerminationReasonRequest upToReason(TerminationReasonRequest reason) {
    reason.aggregateChild(REASON_PROPERTY, this);
    this.groupByReason(reason);
    return reason;
  }

  public TerminationReasonRequest endAtReason(String retName) {
    return endAtReason(retName, TerminationReasonRequest.newInstance());
  }

  public TerminationReasonRequest endAtReason(String retName, TerminationReasonRequest reason) {
    reason.addDynamicProperty(retName, this, REASON_PROPERTY);
    return reason;
  }

  public TerminationRequest filterByReason(String... reason) {
    if (isEmptyParam(reason)) {
      throw new IllegalArgumentException("filterByReason(String... reason)参数不能为空!");
    }
    return where(REASON_PROPERTY, QueryOperator.IN, (Object[]) reason);
  }

  public TerminationRequest filterByReason(
      TerminationReasonRequest reason, IDRefine<TerminationReason> idRefine) {
    reason.unlimited();
    return addSearchCriteria(createReasonCriteria(reason, idRefine));
  }

  public SearchCriteria createReasonCriteria(
      TerminationReasonRequest reason, IDRefine<TerminationReason> idRefine) {
    return new RefinedIdInCriteria(
        reason, REASON_PROPERTY, idRefine, TerminationReason.ID_PROPERTY);
  }

  public TerminationRequest selectReason() {
    return selectReason(TerminationReasonRequest.newInstance().selectSelf());
  }

  public TerminationRequest selectReason(TerminationReasonRequest reason) {
    selectParent(REASON_PROPERTY, reason);
    return this;
  }

  public TerminationRequest unselectReason() {
    unselectParent(REASON_PROPERTY);
    return this;
  }

  public TerminationRequest groupByReason(TerminationReasonRequest reason) {
    groupBy(REASON_PROPERTY, reason);
    return this;
  }

  public TerminationRequest aggregateReason(TerminationReasonRequest reason) {
    aggregateParent(REASON_PROPERTY, reason);
    return this;
  }

  public TerminationRequest countReason() {
    return countReason("countReason");
  }

  public TerminationRequest countReason(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REASON_PROPERTY);
  }

  public TerminationRequest groupByReason() {
    return groupByReason(REASON_PROPERTY);
  }

  public TerminationRequest groupByReason(String ret) {
    return groupBy(ret, REASON_PROPERTY);
  }

  public TerminationRequest whereReasonIsNull() {
    return where(REASON_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationRequest whereReasonIsNotNull() {
    return where(REASON_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationRequest filterByType(TerminationTypeRequest type) {
    return filterByType(type, TerminationType::getId);
  }

  public TerminationRequest filterByType(TerminationType... type) {
    if (isEmptyParam(type)) {
      throw new IllegalArgumentException("filterByType(TerminationType... type)参数不能为空!");
    }
    return where(TYPE_PROPERTY, QueryOperator.IN, (Object[]) type);
  }

  public TerminationRequest selectTypeId() {
    select(TYPE_PROPERTY);
    return this;
  }

  public TerminationTypeRequest upToType() {
    return upToType(TerminationTypeRequest.newInstance());
  }

  public TerminationTypeRequest upToType(TerminationTypeRequest type) {
    type.aggregateChild(TYPE_PROPERTY, this);
    this.groupByType(type);
    return type;
  }

  public TerminationTypeRequest endAtType(String retName) {
    return endAtType(retName, TerminationTypeRequest.newInstance());
  }

  public TerminationTypeRequest endAtType(String retName, TerminationTypeRequest type) {
    type.addDynamicProperty(retName, this, TYPE_PROPERTY);
    return type;
  }

  public TerminationRequest filterByType(String... type) {
    if (isEmptyParam(type)) {
      throw new IllegalArgumentException("filterByType(String... type)参数不能为空!");
    }
    return where(TYPE_PROPERTY, QueryOperator.IN, (Object[]) type);
  }

  public TerminationRequest filterByType(
      TerminationTypeRequest type, IDRefine<TerminationType> idRefine) {
    type.unlimited();
    return addSearchCriteria(createTypeCriteria(type, idRefine));
  }

  public SearchCriteria createTypeCriteria(
      TerminationTypeRequest type, IDRefine<TerminationType> idRefine) {
    return new RefinedIdInCriteria(type, TYPE_PROPERTY, idRefine, TerminationType.ID_PROPERTY);
  }

  public TerminationRequest selectType() {
    return selectType(TerminationTypeRequest.newInstance().selectSelf());
  }

  public TerminationRequest selectType(TerminationTypeRequest type) {
    selectParent(TYPE_PROPERTY, type);
    return this;
  }

  public TerminationRequest unselectType() {
    unselectParent(TYPE_PROPERTY);
    return this;
  }

  public TerminationRequest groupByType(TerminationTypeRequest type) {
    groupBy(TYPE_PROPERTY, type);
    return this;
  }

  public TerminationRequest aggregateType(TerminationTypeRequest type) {
    aggregateParent(TYPE_PROPERTY, type);
    return this;
  }

  public TerminationRequest countType() {
    return countType("countType");
  }

  public TerminationRequest countType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TYPE_PROPERTY);
  }

  public TerminationRequest groupByType() {
    return groupByType(TYPE_PROPERTY);
  }

  public TerminationRequest groupByType(String ret) {
    return groupBy(ret, TYPE_PROPERTY);
  }

  public TerminationRequest whereTypeIsNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationRequest whereTypeIsNotNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TerminationRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TerminationRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TerminationRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
