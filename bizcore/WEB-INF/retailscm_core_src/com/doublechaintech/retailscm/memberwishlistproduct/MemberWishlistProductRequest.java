package com.doublechaintech.retailscm.memberwishlistproduct;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct.*;

public class MemberWishlistProductRequest extends BaseRequest<MemberWishlistProduct> {
  public static MemberWishlistProductRequest newInstance() {
    return new MemberWishlistProductRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public MemberWishlistProductRequest resultByClass(Class<? extends MemberWishlistProduct> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public MemberWishlistProductRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public MemberWishlistProductRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "MemberWishlistProduct";
  }

  public MemberWishlistProductRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public MemberWishlistProductRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public MemberWishlistProductRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public MemberWishlistProductRequest select(String... names) {
    super.select(names);
    return this;
  }

  public MemberWishlistProductRequest selectAll() {
    return this.selectId().selectName().selectOwner().selectVersion();
  }

  public MemberWishlistProductRequest selectAny() {
    return selectAll();
  }

  public MemberWishlistProductRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(OWNER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public MemberWishlistProductRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public MemberWishlistProductRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, OWNER_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public MemberWishlistProductRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public MemberWishlistProductRequest comment(String comment) {
    return this;
  }

  public MemberWishlistProductRequest enhance() {
    return this;
  }

  public MemberWishlistProductRequest overrideClass(Class<? extends MemberWishlistProduct> clazz) {
    return this;
  }

  public MemberWishlistProductRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public MemberWishlistProductRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public MemberWishlistProductRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public MemberWishlistProductRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public MemberWishlistProductRequest count() {
    return countId("count");
  }

  public static MemberWishlistProductRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public MemberWishlistProductRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public MemberWishlistProductRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberWishlistProductRequest selectId() {
    return select(ID_PROPERTY);
  }

  public MemberWishlistProductRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberWishlistProductRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public MemberWishlistProductRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public MemberWishlistProductRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public MemberWishlistProductRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public MemberWishlistProductRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public MemberWishlistProductRequest countId() {
    return countId("countId");
  }

  public MemberWishlistProductRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public MemberWishlistProductRequest maxId() {
    return maxId("maxId");
  }

  public MemberWishlistProductRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public MemberWishlistProductRequest minId() {
    return minId("minId");
  }

  public MemberWishlistProductRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public MemberWishlistProductRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public MemberWishlistProductRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public MemberWishlistProductRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public MemberWishlistProductRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public MemberWishlistProductRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public MemberWishlistProductRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberWishlistProductRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberWishlistProductRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberWishlistProductRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public MemberWishlistProductRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberWishlistProductRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public MemberWishlistProductRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public MemberWishlistProductRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public MemberWishlistProductRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public MemberWishlistProductRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public MemberWishlistProductRequest countName() {
    return countName("countName");
  }

  public MemberWishlistProductRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public MemberWishlistProductRequest maxName() {
    return maxName("maxName");
  }

  public MemberWishlistProductRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public MemberWishlistProductRequest minName() {
    return minName("minName");
  }

  public MemberWishlistProductRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public MemberWishlistProductRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public MemberWishlistProductRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public MemberWishlistProductRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public MemberWishlistProductRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public MemberWishlistProductRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public MemberWishlistProductRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberWishlistProductRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberWishlistProductRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberWishlistProductRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public MemberWishlistProductRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberWishlistProductRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public MemberWishlistProductRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public MemberWishlistProductRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public MemberWishlistProductRequest countVersion() {
    return countVersion("countVersion");
  }

  public MemberWishlistProductRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public MemberWishlistProductRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public MemberWishlistProductRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public MemberWishlistProductRequest minVersion() {
    return minVersion("minVersion");
  }

  public MemberWishlistProductRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public MemberWishlistProductRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public MemberWishlistProductRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public MemberWishlistProductRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public MemberWishlistProductRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public MemberWishlistProductRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public MemberWishlistProductRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public MemberWishlistProductRequest filterByOwner(MemberWishlistRequest owner) {
    return filterByOwner(owner, MemberWishlist::getId);
  }

  public MemberWishlistProductRequest filterByOwner(MemberWishlist... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(MemberWishlist... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public MemberWishlistProductRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public MemberWishlistRequest upToOwner() {
    return upToOwner(MemberWishlistRequest.newInstance());
  }

  public MemberWishlistRequest upToOwner(MemberWishlistRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public MemberWishlistRequest endAtOwner(String retName) {
    return endAtOwner(retName, MemberWishlistRequest.newInstance());
  }

  public MemberWishlistRequest endAtOwner(String retName, MemberWishlistRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public MemberWishlistProductRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public MemberWishlistProductRequest filterByOwner(
      MemberWishlistRequest owner, IDRefine<MemberWishlist> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      MemberWishlistRequest owner, IDRefine<MemberWishlist> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, MemberWishlist.ID_PROPERTY);
  }

  public MemberWishlistProductRequest selectOwner() {
    return selectOwner(MemberWishlistRequest.newInstance().selectSelf());
  }

  public MemberWishlistProductRequest selectOwner(MemberWishlistRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberWishlistProductRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public MemberWishlistProductRequest groupByOwner(MemberWishlistRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberWishlistProductRequest aggregateOwner(MemberWishlistRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberWishlistProductRequest countOwner() {
    return countOwner("countOwner");
  }

  public MemberWishlistProductRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public MemberWishlistProductRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public MemberWishlistProductRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public MemberWishlistProductRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberWishlistProductRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberWishlistProductRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public MemberWishlistProductRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public MemberWishlistProductRequest unlimited() {
    super.unlimited();
    return this;
  }

  public MemberWishlistProductRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
