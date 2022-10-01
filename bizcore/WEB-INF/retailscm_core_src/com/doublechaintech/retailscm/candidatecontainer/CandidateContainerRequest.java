package com.doublechaintech.retailscm.candidatecontainer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.candidateelement.CandidateElement;
import com.doublechaintech.retailscm.candidateelement.CandidateElementRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.candidatecontainer.CandidateContainer.*;

public class CandidateContainerRequest extends BaseRequest<CandidateContainer> {
  public static CandidateContainerRequest newInstance() {
    return new CandidateContainerRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public CandidateContainerRequest resultByClass(Class<? extends CandidateContainer> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public CandidateContainerRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public CandidateContainerRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "CandidateContainer";
  }

  public CandidateContainerRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public CandidateContainerRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public CandidateContainerRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public CandidateContainerRequest select(String... names) {
    super.select(names);
    return this;
  }

  public CandidateContainerRequest selectAll() {
    return this.selectId().selectName().selectVersion();
  }

  public CandidateContainerRequest selectAny() {
    return selectAll().selectCandidateElementList(Q.candidateElement().selectSelf());
  }

  public CandidateContainerRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public CandidateContainerRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public CandidateContainerRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {ID_PROPERTY, NAME_PROPERTY, VERSION_PROPERTY};

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public CandidateContainerRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public CandidateContainerRequest comment(String comment) {
    return this;
  }

  public CandidateContainerRequest enhance() {
    return this;
  }

  public CandidateContainerRequest overrideClass(Class<? extends CandidateContainer> clazz) {
    return this;
  }

  public CandidateContainerRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public CandidateContainerRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public CandidateContainerRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public CandidateContainerRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public CandidateContainerRequest count() {
    return countId("count");
  }

  public static CandidateContainerRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public CandidateContainerRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public CandidateContainerRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CandidateContainerRequest selectId() {
    return select(ID_PROPERTY);
  }

  public CandidateContainerRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CandidateContainerRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public CandidateContainerRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public CandidateContainerRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public CandidateContainerRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public CandidateContainerRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public CandidateContainerRequest countId() {
    return countId("countId");
  }

  public CandidateContainerRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public CandidateContainerRequest maxId() {
    return maxId("maxId");
  }

  public CandidateContainerRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public CandidateContainerRequest minId() {
    return minId("minId");
  }

  public CandidateContainerRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public CandidateContainerRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public CandidateContainerRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public CandidateContainerRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public CandidateContainerRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public CandidateContainerRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public CandidateContainerRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public CandidateContainerRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CandidateContainerRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CandidateContainerRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public CandidateContainerRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CandidateContainerRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public CandidateContainerRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public CandidateContainerRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public CandidateContainerRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public CandidateContainerRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public CandidateContainerRequest countName() {
    return countName("countName");
  }

  public CandidateContainerRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public CandidateContainerRequest maxName() {
    return maxName("maxName");
  }

  public CandidateContainerRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public CandidateContainerRequest minName() {
    return minName("minName");
  }

  public CandidateContainerRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public CandidateContainerRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public CandidateContainerRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public CandidateContainerRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public CandidateContainerRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public CandidateContainerRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public CandidateContainerRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public CandidateContainerRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CandidateContainerRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CandidateContainerRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public CandidateContainerRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CandidateContainerRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public CandidateContainerRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public CandidateContainerRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public CandidateContainerRequest countVersion() {
    return countVersion("countVersion");
  }

  public CandidateContainerRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public CandidateContainerRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public CandidateContainerRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public CandidateContainerRequest minVersion() {
    return minVersion("minVersion");
  }

  public CandidateContainerRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public CandidateContainerRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public CandidateContainerRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public CandidateContainerRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public CandidateContainerRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public CandidateContainerRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public CandidateContainerRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public CandidateContainerRequest hasCandidateElement() {
    return hasCandidateElement(CandidateElementRequest.newInstance());
  }

  public CandidateContainerRequest hasCandidateElement(CandidateElement... candidateElement) {
    if (isEmptyParam(candidateElement)) {
      throw new IllegalArgumentException(
          "hasCandidateElement(CandidateElement... candidateElement)参数不能为空!");
    }
    return hasCandidateElement(
        Q.candidateElement()
            .select(CandidateElement.CONTAINER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) candidateElement));
  }

  public CandidateContainerRequest hasCandidateElement(String... candidateElement) {
    return hasCandidateElement(
        Q.candidateElement()
            .select(CandidateElement.CONTAINER_PROPERTY)
            .filterById(candidateElement));
  }

  public CandidateContainerRequest hasCandidateElement(CandidateElementRequest candidateElement) {
    return hasCandidateElement(
        candidateElement,
        $candidateElement ->
            java.util.Optional.of($candidateElement)
                .map(CandidateElement::getContainer)
                .map(CandidateContainer::getId)
                .orElse(null));
  }

  public CandidateContainerRequest hasCandidateElement(
      CandidateElementRequest candidateElement, IDRefine<CandidateElement> idRefine) {
    candidateElement.select(CandidateElement.CONTAINER_PROPERTY);
    candidateElement.unlimited();
    return addSearchCriteria(createCandidateElementCriteria(candidateElement, idRefine));
  }

  public CandidateContainerRequest hasCandidateElement(
      CandidateElementRequest candidateElement, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            candidateElement, CandidateElement.CONTAINER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createCandidateElementCriteria(
      CandidateElementRequest candidateElement, IDRefine<CandidateElement> idRefine) {
    return new RefinedIdInCriteria(
        candidateElement, ID_PROPERTY, idRefine, CandidateElement.CONTAINER_PROPERTY);
  }

  public CandidateContainerRequest selectCandidateElementList(
      CandidateElementRequest candidateElement) {
    selectChild(CandidateElement.CONTAINER_PROPERTY, candidateElement);
    return this;
  }

  public CandidateContainerRequest selectCandidateElementList() {
    return selectCandidateElementList(CandidateElementRequest.newInstance().selectAll());
  }

  public CandidateContainerRequest unselectCandidateElementList() {
    unselectChild(CandidateElement.CONTAINER_PROPERTY, CandidateElement.class);
    return this;
  }

  public CandidateContainerRequest aggregateCandidateElementList(
      CandidateElementRequest candidateElement) {
    aggregateChild(CandidateElement.CONTAINER_PROPERTY, candidateElement);
    return this;
  }

  public CandidateContainerRequest countCandidateElement() {
    return countCandidateElement("candidateElementCount");
  }

  public CandidateContainerRequest countCandidateElement(String retName) {
    return countCandidateElement(retName, CandidateElementRequest.newInstance());
  }

  public CandidateContainerRequest countCandidateElement(CandidateElementRequest candidateElement) {
    return countCandidateElement("candidateElementCount", candidateElement);
  }

  public CandidateContainerRequest countCandidateElement(
      String retName, CandidateElementRequest candidateElement) {
    candidateElement.count();
    return statsFromCandidateElement(retName, candidateElement);
  }

  public CandidateContainerRequest statsFromCandidateElement(
      String retName, CandidateElementRequest candidateElement) {
    return addDynamicProperty(retName, candidateElement, CandidateElement.CONTAINER_PROPERTY);
  }

  public CandidateContainerRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public CandidateContainerRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public CandidateContainerRequest unlimited() {
    super.unlimited();
    return this;
  }

  public CandidateContainerRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
