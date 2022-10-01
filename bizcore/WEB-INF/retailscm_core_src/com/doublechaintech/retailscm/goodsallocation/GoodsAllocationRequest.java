package com.doublechaintech.retailscm.goodsallocation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodsallocation.GoodsAllocation.*;

public class GoodsAllocationRequest extends BaseRequest<GoodsAllocation> {
  public static GoodsAllocationRequest newInstance() {
    return new GoodsAllocationRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public GoodsAllocationRequest resultByClass(Class<? extends GoodsAllocation> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public GoodsAllocationRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public GoodsAllocationRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "GoodsAllocation";
  }

  public GoodsAllocationRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public GoodsAllocationRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public GoodsAllocationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public GoodsAllocationRequest select(String... names) {
    super.select(names);
    return this;
  }

  public GoodsAllocationRequest selectAll() {
    return this.selectId()
        .selectLocation()
        .selectLatitude()
        .selectLongitude()
        .selectGoodsShelf()
        .selectVersion();
  }

  public GoodsAllocationRequest selectAny() {
    return selectAll().selectGoodsList(Q.goods().selectSelf());
  }

  public GoodsAllocationRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOCATION_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(GOODS_SHELF_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public GoodsAllocationRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public GoodsAllocationRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    LOCATION_PROPERTY,
    LATITUDE_PROPERTY,
    LONGITUDE_PROPERTY,
    GOODS_SHELF_PROPERTY,
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

  public GoodsAllocationRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public GoodsAllocationRequest comment(String comment) {
    return this;
  }

  public GoodsAllocationRequest enhance() {
    return this;
  }

  public GoodsAllocationRequest overrideClass(Class<? extends GoodsAllocation> clazz) {
    return this;
  }

  public GoodsAllocationRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public GoodsAllocationRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public GoodsAllocationRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public GoodsAllocationRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public GoodsAllocationRequest count() {
    return countId("count");
  }

  public static GoodsAllocationRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public GoodsAllocationRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public GoodsAllocationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest selectId() {
    return select(ID_PROPERTY);
  }

  public GoodsAllocationRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsAllocationRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public GoodsAllocationRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public GoodsAllocationRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public GoodsAllocationRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public GoodsAllocationRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public GoodsAllocationRequest countId() {
    return countId("countId");
  }

  public GoodsAllocationRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public GoodsAllocationRequest maxId() {
    return maxId("maxId");
  }

  public GoodsAllocationRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public GoodsAllocationRequest minId() {
    return minId("minId");
  }

  public GoodsAllocationRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public GoodsAllocationRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public GoodsAllocationRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public GoodsAllocationRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public GoodsAllocationRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public GoodsAllocationRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public GoodsAllocationRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsAllocationRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsAllocationRequest filterByLocation(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public GoodsAllocationRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsAllocationRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public GoodsAllocationRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public GoodsAllocationRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public GoodsAllocationRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public GoodsAllocationRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public GoodsAllocationRequest countLocation() {
    return countLocation("countLocation");
  }

  public GoodsAllocationRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public GoodsAllocationRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public GoodsAllocationRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public GoodsAllocationRequest minLocation() {
    return minLocation("minLocation");
  }

  public GoodsAllocationRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public GoodsAllocationRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public GoodsAllocationRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public GoodsAllocationRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public GoodsAllocationRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public GoodsAllocationRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public GoodsAllocationRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsAllocationRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsAllocationRequest whereLatitudeBetween(
      BigDecimal latitudeStart, BigDecimal latitudeEnd) {
    if (ObjectUtil.isEmpty(latitudeStart)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeBetween, the parameter latitudeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(latitudeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeBetween, the parameter latitudeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.BETWEEN, new Object[] {latitudeStart, latitudeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest filterByLatitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public GoodsAllocationRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsAllocationRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public GoodsAllocationRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public GoodsAllocationRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public GoodsAllocationRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public GoodsAllocationRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public GoodsAllocationRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public GoodsAllocationRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public GoodsAllocationRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public GoodsAllocationRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public GoodsAllocationRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public GoodsAllocationRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public GoodsAllocationRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public GoodsAllocationRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public GoodsAllocationRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public GoodsAllocationRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public GoodsAllocationRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public GoodsAllocationRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsAllocationRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsAllocationRequest whereLongitudeBetween(
      BigDecimal longitudeStart, BigDecimal longitudeEnd) {
    if (ObjectUtil.isEmpty(longitudeStart)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeBetween, the parameter longitudeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(longitudeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeBetween, the parameter longitudeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {longitudeStart, longitudeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest filterByLongitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public GoodsAllocationRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsAllocationRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public GoodsAllocationRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public GoodsAllocationRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public GoodsAllocationRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public GoodsAllocationRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public GoodsAllocationRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public GoodsAllocationRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public GoodsAllocationRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public GoodsAllocationRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public GoodsAllocationRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public GoodsAllocationRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public GoodsAllocationRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public GoodsAllocationRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public GoodsAllocationRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public GoodsAllocationRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public GoodsAllocationRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public GoodsAllocationRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsAllocationRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsAllocationRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsAllocationRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public GoodsAllocationRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsAllocationRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public GoodsAllocationRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public GoodsAllocationRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public GoodsAllocationRequest countVersion() {
    return countVersion("countVersion");
  }

  public GoodsAllocationRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public GoodsAllocationRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public GoodsAllocationRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public GoodsAllocationRequest minVersion() {
    return minVersion("minVersion");
  }

  public GoodsAllocationRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public GoodsAllocationRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public GoodsAllocationRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public GoodsAllocationRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public GoodsAllocationRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public GoodsAllocationRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public GoodsAllocationRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public GoodsAllocationRequest filterByGoodsShelf(GoodsShelfRequest goodsShelf) {
    return filterByGoodsShelf(goodsShelf, GoodsShelf::getId);
  }

  public GoodsAllocationRequest filterByGoodsShelf(GoodsShelf... goodsShelf) {
    if (isEmptyParam(goodsShelf)) {
      throw new IllegalArgumentException("filterByGoodsShelf(GoodsShelf... goodsShelf)参数不能为空!");
    }
    return where(GOODS_SHELF_PROPERTY, QueryOperator.IN, (Object[]) goodsShelf);
  }

  public GoodsAllocationRequest selectGoodsShelfId() {
    select(GOODS_SHELF_PROPERTY);
    return this;
  }

  public GoodsShelfRequest upToGoodsShelf() {
    return upToGoodsShelf(GoodsShelfRequest.newInstance());
  }

  public GoodsShelfRequest upToGoodsShelf(GoodsShelfRequest goodsShelf) {
    goodsShelf.aggregateChild(GOODS_SHELF_PROPERTY, this);
    this.groupByGoodsShelf(goodsShelf);
    return goodsShelf;
  }

  public GoodsShelfRequest endAtGoodsShelf(String retName) {
    return endAtGoodsShelf(retName, GoodsShelfRequest.newInstance());
  }

  public GoodsShelfRequest endAtGoodsShelf(String retName, GoodsShelfRequest goodsShelf) {
    goodsShelf.addDynamicProperty(retName, this, GOODS_SHELF_PROPERTY);
    return goodsShelf;
  }

  public GoodsAllocationRequest filterByGoodsShelf(String... goodsShelf) {
    if (isEmptyParam(goodsShelf)) {
      throw new IllegalArgumentException("filterByGoodsShelf(String... goodsShelf)参数不能为空!");
    }
    return where(GOODS_SHELF_PROPERTY, QueryOperator.IN, (Object[]) goodsShelf);
  }

  public GoodsAllocationRequest filterByGoodsShelf(
      GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
    goodsShelf.unlimited();
    return addSearchCriteria(createGoodsShelfCriteria(goodsShelf, idRefine));
  }

  public SearchCriteria createGoodsShelfCriteria(
      GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
    return new RefinedIdInCriteria(
        goodsShelf, GOODS_SHELF_PROPERTY, idRefine, GoodsShelf.ID_PROPERTY);
  }

  public GoodsAllocationRequest selectGoodsShelf() {
    return selectGoodsShelf(GoodsShelfRequest.newInstance().selectSelf());
  }

  public GoodsAllocationRequest selectGoodsShelf(GoodsShelfRequest goodsShelf) {
    selectParent(GOODS_SHELF_PROPERTY, goodsShelf);
    return this;
  }

  public GoodsAllocationRequest unselectGoodsShelf() {
    unselectParent(GOODS_SHELF_PROPERTY);
    return this;
  }

  public GoodsAllocationRequest groupByGoodsShelf(GoodsShelfRequest goodsShelf) {
    groupBy(GOODS_SHELF_PROPERTY, goodsShelf);
    return this;
  }

  public GoodsAllocationRequest aggregateGoodsShelf(GoodsShelfRequest goodsShelf) {
    aggregateParent(GOODS_SHELF_PROPERTY, goodsShelf);
    return this;
  }

  public GoodsAllocationRequest countGoodsShelf() {
    return countGoodsShelf("countGoodsShelf");
  }

  public GoodsAllocationRequest countGoodsShelf(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, GOODS_SHELF_PROPERTY);
  }

  public GoodsAllocationRequest groupByGoodsShelf() {
    return groupByGoodsShelf(GOODS_SHELF_PROPERTY);
  }

  public GoodsAllocationRequest groupByGoodsShelf(String ret) {
    return groupBy(ret, GOODS_SHELF_PROPERTY);
  }

  public GoodsAllocationRequest whereGoodsShelfIsNull() {
    return where(GOODS_SHELF_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsAllocationRequest whereGoodsShelfIsNotNull() {
    return where(GOODS_SHELF_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsAllocationRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public GoodsAllocationRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods()
            .select(Goods.GOODS_ALLOCATION_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goods));
  }

  public GoodsAllocationRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.GOODS_ALLOCATION_PROPERTY).filterById(goods));
  }

  public GoodsAllocationRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods ->
            java.util.Optional.of($goods)
                .map(Goods::getGoodsAllocation)
                .map(GoodsAllocation::getId)
                .orElse(null));
  }

  public GoodsAllocationRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.GOODS_ALLOCATION_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public GoodsAllocationRequest hasGoods(
      GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.GOODS_ALLOCATION_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.GOODS_ALLOCATION_PROPERTY);
  }

  public GoodsAllocationRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.GOODS_ALLOCATION_PROPERTY, goods);
    return this;
  }

  public GoodsAllocationRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public GoodsAllocationRequest unselectGoodsList() {
    unselectChild(Goods.GOODS_ALLOCATION_PROPERTY, Goods.class);
    return this;
  }

  public GoodsAllocationRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.GOODS_ALLOCATION_PROPERTY, goods);
    return this;
  }

  public GoodsAllocationRequest countGoods() {
    return countGoods("goodsCount");
  }

  public GoodsAllocationRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public GoodsAllocationRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public GoodsAllocationRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public GoodsAllocationRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.GOODS_ALLOCATION_PROPERTY);
  }

  public GoodsAllocationRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public GoodsAllocationRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public GoodsAllocationRequest unlimited() {
    super.unlimited();
    return this;
  }

  public GoodsAllocationRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
