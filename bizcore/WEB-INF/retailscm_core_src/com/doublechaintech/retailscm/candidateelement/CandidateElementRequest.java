package com.doublechaintech.retailscm.candidateelement;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainerRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.candidateelement.CandidateElement.*;

public class CandidateElementRequest extends BaseRequest<CandidateElement> {
  public static CandidateElementRequest newInstance() {
    return new CandidateElementRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public CandidateElementRequest resultByClass(Class<? extends CandidateElement> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public CandidateElementRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public CandidateElementRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "CandidateElement";
  }

  public CandidateElementRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public CandidateElementRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public CandidateElementRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public CandidateElementRequest select(String... names) {
    super.select(names);
    return this;
  }

  public CandidateElementRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectType()
        .selectImage()
        .selectContainer()
        .selectVersion();
  }

  public CandidateElementRequest selectAny() {
    return selectAll();
  }

  public CandidateElementRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(TYPE_PROPERTY);
    select(IMAGE_PROPERTY);
    select(CONTAINER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public CandidateElementRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public CandidateElementRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, TYPE_PROPERTY, IMAGE_PROPERTY, CONTAINER_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public CandidateElementRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public CandidateElementRequest comment(String comment) {
    return this;
  }

  public CandidateElementRequest enhance() {
    return this;
  }

  public CandidateElementRequest overrideClass(Class<? extends CandidateElement> clazz) {
    return this;
  }

  public CandidateElementRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public CandidateElementRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public CandidateElementRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public CandidateElementRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public CandidateElementRequest count() {
    return countId("count");
  }

  public static CandidateElementRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public CandidateElementRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public CandidateElementRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CandidateElementRequest selectId() {
    return select(ID_PROPERTY);
  }

  public CandidateElementRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CandidateElementRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public CandidateElementRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public CandidateElementRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public CandidateElementRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public CandidateElementRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public CandidateElementRequest countId() {
    return countId("countId");
  }

  public CandidateElementRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public CandidateElementRequest maxId() {
    return maxId("maxId");
  }

  public CandidateElementRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public CandidateElementRequest minId() {
    return minId("minId");
  }

  public CandidateElementRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public CandidateElementRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public CandidateElementRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public CandidateElementRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public CandidateElementRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public CandidateElementRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public CandidateElementRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public CandidateElementRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CandidateElementRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CandidateElementRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public CandidateElementRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CandidateElementRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public CandidateElementRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public CandidateElementRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public CandidateElementRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public CandidateElementRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public CandidateElementRequest countName() {
    return countName("countName");
  }

  public CandidateElementRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public CandidateElementRequest maxName() {
    return maxName("maxName");
  }

  public CandidateElementRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public CandidateElementRequest minName() {
    return minName("minName");
  }

  public CandidateElementRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public CandidateElementRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public CandidateElementRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public CandidateElementRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public CandidateElementRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public CandidateElementRequest filterByType(String type) {

    if (type == null) {
      return this;
    }

    return filterByType(QueryOperator.EQUAL, type);
  }

  public CandidateElementRequest whereTypeIsNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public CandidateElementRequest whereTypeIsNotNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CandidateElementRequest filterByType(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CandidateElementRequest selectType() {
    return select(TYPE_PROPERTY);
  }

  public CandidateElementRequest unselectType() {
    return unselect(TYPE_PROPERTY);
  }

  public SearchCriteria getTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CandidateElementRequest orderByType(boolean asc) {
    addOrderBy(TYPE_PROPERTY, asc);
    return this;
  }

  public CandidateElementRequest orderByTypeAscending() {
    addOrderBy(TYPE_PROPERTY, true);
    return this;
  }

  public CandidateElementRequest orderByTypeDescending() {
    addOrderBy(TYPE_PROPERTY, false);
    return this;
  }

  public CandidateElementRequest orderByTypeAscendingUsingGBK() {
    addOrderBy("convert(type using gbk)", true);
    return this;
  }

  public CandidateElementRequest orderByTypeDescendingUsingGBK() {
    addOrderBy("convert(type using gbk)", false);
    return this;
  }

  public CandidateElementRequest countType() {
    return countType("countType");
  }

  public CandidateElementRequest countType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TYPE_PROPERTY);
  }

  public CandidateElementRequest maxType() {
    return maxType("maxType");
  }

  public CandidateElementRequest maxType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TYPE_PROPERTY);
  }

  public CandidateElementRequest minType() {
    return minType("minType");
  }

  public CandidateElementRequest minType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TYPE_PROPERTY);
  }

  public CandidateElementRequest groupByType() {
    return groupByType(TYPE_PROPERTY);
  }

  public CandidateElementRequest groupByType(String ret) {
    return groupBy(ret, TYPE_PROPERTY);
  }

  public CandidateElementRequest groupByType(SqlFunction func) {
    return groupByType(TYPE_PROPERTY, func);
  }

  public CandidateElementRequest groupByType(String ret, SqlFunction func) {
    super.groupBy(ret, func, TYPE_PROPERTY);
    return this;
  }

  public CandidateElementRequest filterByImage(String image) {

    if (image == null) {
      return this;
    }

    return filterByImage(QueryOperator.EQUAL, image);
  }

  public CandidateElementRequest whereImageIsNull() {
    return where(IMAGE_PROPERTY, QueryOperator.IS_NULL);
  }

  public CandidateElementRequest whereImageIsNotNull() {
    return where(IMAGE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CandidateElementRequest filterByImage(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getImageSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CandidateElementRequest selectImage() {
    return select(IMAGE_PROPERTY);
  }

  public CandidateElementRequest unselectImage() {
    return unselect(IMAGE_PROPERTY);
  }

  public SearchCriteria getImageSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(IMAGE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CandidateElementRequest orderByImage(boolean asc) {
    addOrderBy(IMAGE_PROPERTY, asc);
    return this;
  }

  public CandidateElementRequest orderByImageAscending() {
    addOrderBy(IMAGE_PROPERTY, true);
    return this;
  }

  public CandidateElementRequest orderByImageDescending() {
    addOrderBy(IMAGE_PROPERTY, false);
    return this;
  }

  public CandidateElementRequest orderByImageAscendingUsingGBK() {
    addOrderBy("convert(image using gbk)", true);
    return this;
  }

  public CandidateElementRequest orderByImageDescendingUsingGBK() {
    addOrderBy("convert(image using gbk)", false);
    return this;
  }

  public CandidateElementRequest countImage() {
    return countImage("countImage");
  }

  public CandidateElementRequest countImage(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, IMAGE_PROPERTY);
  }

  public CandidateElementRequest maxImage() {
    return maxImage("maxImage");
  }

  public CandidateElementRequest maxImage(String aggName) {
    return aggregate(aggName, AggFunc.MAX, IMAGE_PROPERTY);
  }

  public CandidateElementRequest minImage() {
    return minImage("minImage");
  }

  public CandidateElementRequest minImage(String aggName) {
    return aggregate(aggName, AggFunc.MIN, IMAGE_PROPERTY);
  }

  public CandidateElementRequest groupByImage() {
    return groupByImage(IMAGE_PROPERTY);
  }

  public CandidateElementRequest groupByImage(String ret) {
    return groupBy(ret, IMAGE_PROPERTY);
  }

  public CandidateElementRequest groupByImage(SqlFunction func) {
    return groupByImage(IMAGE_PROPERTY, func);
  }

  public CandidateElementRequest groupByImage(String ret, SqlFunction func) {
    super.groupBy(ret, func, IMAGE_PROPERTY);
    return this;
  }

  public CandidateElementRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public CandidateElementRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public CandidateElementRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CandidateElementRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CandidateElementRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public CandidateElementRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CandidateElementRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public CandidateElementRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public CandidateElementRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public CandidateElementRequest countVersion() {
    return countVersion("countVersion");
  }

  public CandidateElementRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public CandidateElementRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public CandidateElementRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public CandidateElementRequest minVersion() {
    return minVersion("minVersion");
  }

  public CandidateElementRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public CandidateElementRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public CandidateElementRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public CandidateElementRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public CandidateElementRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public CandidateElementRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public CandidateElementRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public CandidateElementRequest filterByContainer(CandidateContainerRequest container) {
    return filterByContainer(container, CandidateContainer::getId);
  }

  public CandidateElementRequest filterByContainer(CandidateContainer... container) {
    if (isEmptyParam(container)) {
      throw new IllegalArgumentException(
          "filterByContainer(CandidateContainer... container)参数不能为空!");
    }
    return where(CONTAINER_PROPERTY, QueryOperator.IN, (Object[]) container);
  }

  public CandidateElementRequest selectContainerId() {
    select(CONTAINER_PROPERTY);
    return this;
  }

  public CandidateContainerRequest upToContainer() {
    return upToContainer(CandidateContainerRequest.newInstance());
  }

  public CandidateContainerRequest upToContainer(CandidateContainerRequest container) {
    container.aggregateChild(CONTAINER_PROPERTY, this);
    this.groupByContainer(container);
    return container;
  }

  public CandidateContainerRequest endAtContainer(String retName) {
    return endAtContainer(retName, CandidateContainerRequest.newInstance());
  }

  public CandidateContainerRequest endAtContainer(
      String retName, CandidateContainerRequest container) {
    container.addDynamicProperty(retName, this, CONTAINER_PROPERTY);
    return container;
  }

  public CandidateElementRequest filterByContainer(String... container) {
    if (isEmptyParam(container)) {
      throw new IllegalArgumentException("filterByContainer(String... container)参数不能为空!");
    }
    return where(CONTAINER_PROPERTY, QueryOperator.IN, (Object[]) container);
  }

  public CandidateElementRequest filterByContainer(
      CandidateContainerRequest container, IDRefine<CandidateContainer> idRefine) {
    container.unlimited();
    return addSearchCriteria(createContainerCriteria(container, idRefine));
  }

  public SearchCriteria createContainerCriteria(
      CandidateContainerRequest container, IDRefine<CandidateContainer> idRefine) {
    return new RefinedIdInCriteria(
        container, CONTAINER_PROPERTY, idRefine, CandidateContainer.ID_PROPERTY);
  }

  public CandidateElementRequest selectContainer() {
    return selectContainer(CandidateContainerRequest.newInstance().selectSelf());
  }

  public CandidateElementRequest selectContainer(CandidateContainerRequest container) {
    selectParent(CONTAINER_PROPERTY, container);
    return this;
  }

  public CandidateElementRequest unselectContainer() {
    unselectParent(CONTAINER_PROPERTY);
    return this;
  }

  public CandidateElementRequest groupByContainer(CandidateContainerRequest container) {
    groupBy(CONTAINER_PROPERTY, container);
    return this;
  }

  public CandidateElementRequest aggregateContainer(CandidateContainerRequest container) {
    aggregateParent(CONTAINER_PROPERTY, container);
    return this;
  }

  public CandidateElementRequest countContainer() {
    return countContainer("countContainer");
  }

  public CandidateElementRequest countContainer(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTAINER_PROPERTY);
  }

  public CandidateElementRequest groupByContainer() {
    return groupByContainer(CONTAINER_PROPERTY);
  }

  public CandidateElementRequest groupByContainer(String ret) {
    return groupBy(ret, CONTAINER_PROPERTY);
  }

  public CandidateElementRequest whereContainerIsNull() {
    return where(CONTAINER_PROPERTY, QueryOperator.IS_NULL);
  }

  public CandidateElementRequest whereContainerIsNotNull() {
    return where(CONTAINER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CandidateElementRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public CandidateElementRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public CandidateElementRequest unlimited() {
    super.unlimited();
    return this;
  }

  public CandidateElementRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
