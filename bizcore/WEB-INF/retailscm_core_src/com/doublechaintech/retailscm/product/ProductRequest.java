package com.doublechaintech.retailscm.product;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest;
import com.doublechaintech.retailscm.sku.SkuRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.product.Product.*;

public class ProductRequest extends BaseRequest<Product> {
  public static ProductRequest newInstance() {
    return new ProductRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ProductRequest resultByClass(Class<? extends Product> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ProductRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ProductRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Product";
  }

  public ProductRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ProductRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ProductRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ProductRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ProductRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectParentCategory()
        .selectOrigin()
        .selectRemark()
        .selectBrand()
        .selectPicture()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public ProductRequest selectAny() {
    return selectAll().selectSkuList(Q.sku().selectSelf());
  }

  public ProductRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(PARENT_CATEGORY_PROPERTY);
    select(ORIGIN_PROPERTY);
    select(REMARK_PROPERTY);
    select(BRAND_PROPERTY);
    select(PICTURE_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ProductRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ProductRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    PARENT_CATEGORY_PROPERTY,
    ORIGIN_PROPERTY,
    REMARK_PROPERTY,
    BRAND_PROPERTY,
    PICTURE_PROPERTY,
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

  public ProductRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ProductRequest comment(String comment) {
    return this;
  }

  public ProductRequest enhance() {
    return this;
  }

  public ProductRequest overrideClass(Class<? extends Product> clazz) {
    return this;
  }

  public ProductRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ProductRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ProductRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ProductRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ProductRequest count() {
    return countId("count");
  }

  public static ProductRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ProductRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ProductRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ProductRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ProductRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ProductRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ProductRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ProductRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ProductRequest countId() {
    return countId("countId");
  }

  public ProductRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ProductRequest maxId() {
    return maxId("maxId");
  }

  public ProductRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ProductRequest minId() {
    return minId("minId");
  }

  public ProductRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ProductRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ProductRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ProductRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ProductRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ProductRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public ProductRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public ProductRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public ProductRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public ProductRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public ProductRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public ProductRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public ProductRequest countName() {
    return countName("countName");
  }

  public ProductRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public ProductRequest maxName() {
    return maxName("maxName");
  }

  public ProductRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public ProductRequest minName() {
    return minName("minName");
  }

  public ProductRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public ProductRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public ProductRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public ProductRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public ProductRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public ProductRequest filterByOrigin(String origin) {

    if (origin == null) {
      return this;
    }

    return filterByOrigin(QueryOperator.EQUAL, origin);
  }

  public ProductRequest whereOriginIsNull() {
    return where(ORIGIN_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductRequest whereOriginIsNotNull() {
    return where(ORIGIN_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductRequest filterByOrigin(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getOriginSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest selectOrigin() {
    return select(ORIGIN_PROPERTY);
  }

  public ProductRequest unselectOrigin() {
    return unselect(ORIGIN_PROPERTY);
  }

  public SearchCriteria getOriginSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ORIGIN_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductRequest orderByOrigin(boolean asc) {
    addOrderBy(ORIGIN_PROPERTY, asc);
    return this;
  }

  public ProductRequest orderByOriginAscending() {
    addOrderBy(ORIGIN_PROPERTY, true);
    return this;
  }

  public ProductRequest orderByOriginDescending() {
    addOrderBy(ORIGIN_PROPERTY, false);
    return this;
  }

  public ProductRequest orderByOriginAscendingUsingGBK() {
    addOrderBy("convert(origin using gbk)", true);
    return this;
  }

  public ProductRequest orderByOriginDescendingUsingGBK() {
    addOrderBy("convert(origin using gbk)", false);
    return this;
  }

  public ProductRequest countOrigin() {
    return countOrigin("countOrigin");
  }

  public ProductRequest countOrigin(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ORIGIN_PROPERTY);
  }

  public ProductRequest maxOrigin() {
    return maxOrigin("maxOrigin");
  }

  public ProductRequest maxOrigin(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ORIGIN_PROPERTY);
  }

  public ProductRequest minOrigin() {
    return minOrigin("minOrigin");
  }

  public ProductRequest minOrigin(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ORIGIN_PROPERTY);
  }

  public ProductRequest groupByOrigin() {
    return groupByOrigin(ORIGIN_PROPERTY);
  }

  public ProductRequest groupByOrigin(String ret) {
    return groupBy(ret, ORIGIN_PROPERTY);
  }

  public ProductRequest groupByOrigin(SqlFunction func) {
    return groupByOrigin(ORIGIN_PROPERTY, func);
  }

  public ProductRequest groupByOrigin(String ret, SqlFunction func) {
    super.groupBy(ret, func, ORIGIN_PROPERTY);
    return this;
  }

  public ProductRequest filterByRemark(String remark) {

    if (remark == null) {
      return this;
    }

    return filterByRemark(QueryOperator.EQUAL, remark);
  }

  public ProductRequest whereRemarkIsNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductRequest whereRemarkIsNotNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest selectRemark() {
    return select(REMARK_PROPERTY);
  }

  public ProductRequest unselectRemark() {
    return unselect(REMARK_PROPERTY);
  }

  public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductRequest orderByRemark(boolean asc) {
    addOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public ProductRequest orderByRemarkAscending() {
    addOrderBy(REMARK_PROPERTY, true);
    return this;
  }

  public ProductRequest orderByRemarkDescending() {
    addOrderBy(REMARK_PROPERTY, false);
    return this;
  }

  public ProductRequest orderByRemarkAscendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", true);
    return this;
  }

  public ProductRequest orderByRemarkDescendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", false);
    return this;
  }

  public ProductRequest countRemark() {
    return countRemark("countRemark");
  }

  public ProductRequest countRemark(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REMARK_PROPERTY);
  }

  public ProductRequest maxRemark() {
    return maxRemark("maxRemark");
  }

  public ProductRequest maxRemark(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REMARK_PROPERTY);
  }

  public ProductRequest minRemark() {
    return minRemark("minRemark");
  }

  public ProductRequest minRemark(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REMARK_PROPERTY);
  }

  public ProductRequest groupByRemark() {
    return groupByRemark(REMARK_PROPERTY);
  }

  public ProductRequest groupByRemark(String ret) {
    return groupBy(ret, REMARK_PROPERTY);
  }

  public ProductRequest groupByRemark(SqlFunction func) {
    return groupByRemark(REMARK_PROPERTY, func);
  }

  public ProductRequest groupByRemark(String ret, SqlFunction func) {
    super.groupBy(ret, func, REMARK_PROPERTY);
    return this;
  }

  public ProductRequest filterByBrand(String brand) {

    if (brand == null) {
      return this;
    }

    return filterByBrand(QueryOperator.EQUAL, brand);
  }

  public ProductRequest whereBrandIsNull() {
    return where(BRAND_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductRequest whereBrandIsNotNull() {
    return where(BRAND_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductRequest filterByBrand(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBrandSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest selectBrand() {
    return select(BRAND_PROPERTY);
  }

  public ProductRequest unselectBrand() {
    return unselect(BRAND_PROPERTY);
  }

  public SearchCriteria getBrandSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BRAND_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductRequest orderByBrand(boolean asc) {
    addOrderBy(BRAND_PROPERTY, asc);
    return this;
  }

  public ProductRequest orderByBrandAscending() {
    addOrderBy(BRAND_PROPERTY, true);
    return this;
  }

  public ProductRequest orderByBrandDescending() {
    addOrderBy(BRAND_PROPERTY, false);
    return this;
  }

  public ProductRequest orderByBrandAscendingUsingGBK() {
    addOrderBy("convert(brand using gbk)", true);
    return this;
  }

  public ProductRequest orderByBrandDescendingUsingGBK() {
    addOrderBy("convert(brand using gbk)", false);
    return this;
  }

  public ProductRequest countBrand() {
    return countBrand("countBrand");
  }

  public ProductRequest countBrand(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BRAND_PROPERTY);
  }

  public ProductRequest maxBrand() {
    return maxBrand("maxBrand");
  }

  public ProductRequest maxBrand(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BRAND_PROPERTY);
  }

  public ProductRequest minBrand() {
    return minBrand("minBrand");
  }

  public ProductRequest minBrand(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BRAND_PROPERTY);
  }

  public ProductRequest groupByBrand() {
    return groupByBrand(BRAND_PROPERTY);
  }

  public ProductRequest groupByBrand(String ret) {
    return groupBy(ret, BRAND_PROPERTY);
  }

  public ProductRequest groupByBrand(SqlFunction func) {
    return groupByBrand(BRAND_PROPERTY, func);
  }

  public ProductRequest groupByBrand(String ret, SqlFunction func) {
    super.groupBy(ret, func, BRAND_PROPERTY);
    return this;
  }

  public ProductRequest filterByPicture(String picture) {

    if (picture == null) {
      return this;
    }

    return filterByPicture(QueryOperator.EQUAL, picture);
  }

  public ProductRequest wherePictureIsNull() {
    return where(PICTURE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductRequest wherePictureIsNotNull() {
    return where(PICTURE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductRequest filterByPicture(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPictureSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest selectPicture() {
    return select(PICTURE_PROPERTY);
  }

  public ProductRequest unselectPicture() {
    return unselect(PICTURE_PROPERTY);
  }

  public SearchCriteria getPictureSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PICTURE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductRequest orderByPicture(boolean asc) {
    addOrderBy(PICTURE_PROPERTY, asc);
    return this;
  }

  public ProductRequest orderByPictureAscending() {
    addOrderBy(PICTURE_PROPERTY, true);
    return this;
  }

  public ProductRequest orderByPictureDescending() {
    addOrderBy(PICTURE_PROPERTY, false);
    return this;
  }

  public ProductRequest orderByPictureAscendingUsingGBK() {
    addOrderBy("convert(picture using gbk)", true);
    return this;
  }

  public ProductRequest orderByPictureDescendingUsingGBK() {
    addOrderBy("convert(picture using gbk)", false);
    return this;
  }

  public ProductRequest countPicture() {
    return countPicture("countPicture");
  }

  public ProductRequest countPicture(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PICTURE_PROPERTY);
  }

  public ProductRequest maxPicture() {
    return maxPicture("maxPicture");
  }

  public ProductRequest maxPicture(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PICTURE_PROPERTY);
  }

  public ProductRequest minPicture() {
    return minPicture("minPicture");
  }

  public ProductRequest minPicture(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PICTURE_PROPERTY);
  }

  public ProductRequest groupByPicture() {
    return groupByPicture(PICTURE_PROPERTY);
  }

  public ProductRequest groupByPicture(String ret) {
    return groupBy(ret, PICTURE_PROPERTY);
  }

  public ProductRequest groupByPicture(SqlFunction func) {
    return groupByPicture(PICTURE_PROPERTY, func);
  }

  public ProductRequest groupByPicture(String ret, SqlFunction func) {
    super.groupBy(ret, func, PICTURE_PROPERTY);
    return this;
  }

  public ProductRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public ProductRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductRequest whereLastUpdateTimeBetween(
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

  public ProductRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public ProductRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public ProductRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public ProductRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public ProductRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public ProductRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public ProductRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public ProductRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public ProductRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public ProductRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public ProductRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public ProductRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public ProductRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public ProductRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public ProductRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ProductRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProductRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ProductRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProductRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ProductRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ProductRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ProductRequest countVersion() {
    return countVersion("countVersion");
  }

  public ProductRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ProductRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ProductRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ProductRequest minVersion() {
    return minVersion("minVersion");
  }

  public ProductRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ProductRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ProductRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ProductRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ProductRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ProductRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ProductRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ProductRequest filterByParentCategory(LevelThreeCategoryRequest parentCategory) {
    return filterByParentCategory(parentCategory, LevelThreeCategory::getId);
  }

  public ProductRequest filterByParentCategory(LevelThreeCategory... parentCategory) {
    if (isEmptyParam(parentCategory)) {
      throw new IllegalArgumentException(
          "filterByParentCategory(LevelThreeCategory... parentCategory)参数不能为空!");
    }
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IN, (Object[]) parentCategory);
  }

  public ProductRequest selectParentCategoryId() {
    select(PARENT_CATEGORY_PROPERTY);
    return this;
  }

  public LevelThreeCategoryRequest upToParentCategory() {
    return upToParentCategory(LevelThreeCategoryRequest.newInstance());
  }

  public LevelThreeCategoryRequest upToParentCategory(LevelThreeCategoryRequest parentCategory) {
    parentCategory.aggregateChild(PARENT_CATEGORY_PROPERTY, this);
    this.groupByParentCategory(parentCategory);
    return parentCategory;
  }

  public LevelThreeCategoryRequest endAtParentCategory(String retName) {
    return endAtParentCategory(retName, LevelThreeCategoryRequest.newInstance());
  }

  public LevelThreeCategoryRequest endAtParentCategory(
      String retName, LevelThreeCategoryRequest parentCategory) {
    parentCategory.addDynamicProperty(retName, this, PARENT_CATEGORY_PROPERTY);
    return parentCategory;
  }

  public ProductRequest filterByParentCategory(String... parentCategory) {
    if (isEmptyParam(parentCategory)) {
      throw new IllegalArgumentException("filterByParentCategory(String... parentCategory)参数不能为空!");
    }
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IN, (Object[]) parentCategory);
  }

  public ProductRequest filterByParentCategory(
      LevelThreeCategoryRequest parentCategory, IDRefine<LevelThreeCategory> idRefine) {
    parentCategory.unlimited();
    return addSearchCriteria(createParentCategoryCriteria(parentCategory, idRefine));
  }

  public SearchCriteria createParentCategoryCriteria(
      LevelThreeCategoryRequest parentCategory, IDRefine<LevelThreeCategory> idRefine) {
    return new RefinedIdInCriteria(
        parentCategory, PARENT_CATEGORY_PROPERTY, idRefine, LevelThreeCategory.ID_PROPERTY);
  }

  public ProductRequest selectParentCategory() {
    return selectParentCategory(LevelThreeCategoryRequest.newInstance().selectSelf());
  }

  public ProductRequest selectParentCategory(LevelThreeCategoryRequest parentCategory) {
    selectParent(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public ProductRequest unselectParentCategory() {
    unselectParent(PARENT_CATEGORY_PROPERTY);
    return this;
  }

  public ProductRequest groupByParentCategory(LevelThreeCategoryRequest parentCategory) {
    groupBy(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public ProductRequest aggregateParentCategory(LevelThreeCategoryRequest parentCategory) {
    aggregateParent(PARENT_CATEGORY_PROPERTY, parentCategory);
    return this;
  }

  public ProductRequest countParentCategory() {
    return countParentCategory("countParentCategory");
  }

  public ProductRequest countParentCategory(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PARENT_CATEGORY_PROPERTY);
  }

  public ProductRequest groupByParentCategory() {
    return groupByParentCategory(PARENT_CATEGORY_PROPERTY);
  }

  public ProductRequest groupByParentCategory(String ret) {
    return groupBy(ret, PARENT_CATEGORY_PROPERTY);
  }

  public ProductRequest whereParentCategoryIsNull() {
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProductRequest whereParentCategoryIsNotNull() {
    return where(PARENT_CATEGORY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProductRequest hasSku() {
    return hasSku(SkuRequest.newInstance());
  }

  public ProductRequest hasSku(Sku... sku) {
    if (isEmptyParam(sku)) {
      throw new IllegalArgumentException("hasSku(Sku... sku)参数不能为空!");
    }
    return hasSku(
        Q.sku().select(Sku.PRODUCT_PROPERTY).filterById(QueryOperator.IN, (Object[]) sku));
  }

  public ProductRequest hasSku(String... sku) {
    return hasSku(Q.sku().select(Sku.PRODUCT_PROPERTY).filterById(sku));
  }

  public ProductRequest hasSku(SkuRequest sku) {
    return hasSku(
        sku,
        $sku -> java.util.Optional.of($sku).map(Sku::getProduct).map(Product::getId).orElse(null));
  }

  public ProductRequest hasSku(SkuRequest sku, IDRefine<Sku> idRefine) {
    sku.select(Sku.PRODUCT_PROPERTY);
    sku.unlimited();
    return addSearchCriteria(createSkuCriteria(sku, idRefine));
  }

  public ProductRequest hasSku(SkuRequest sku, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(sku, Sku.PRODUCT_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSkuCriteria(SkuRequest sku, IDRefine<Sku> idRefine) {
    return new RefinedIdInCriteria(sku, ID_PROPERTY, idRefine, Sku.PRODUCT_PROPERTY);
  }

  public ProductRequest selectSkuList(SkuRequest sku) {
    selectChild(Sku.PRODUCT_PROPERTY, sku);
    return this;
  }

  public ProductRequest selectSkuList() {
    return selectSkuList(SkuRequest.newInstance().selectAll());
  }

  public ProductRequest unselectSkuList() {
    unselectChild(Sku.PRODUCT_PROPERTY, Sku.class);
    return this;
  }

  public ProductRequest aggregateSkuList(SkuRequest sku) {
    aggregateChild(Sku.PRODUCT_PROPERTY, sku);
    return this;
  }

  public ProductRequest countSku() {
    return countSku("skuCount");
  }

  public ProductRequest countSku(String retName) {
    return countSku(retName, SkuRequest.newInstance());
  }

  public ProductRequest countSku(SkuRequest sku) {
    return countSku("skuCount", sku);
  }

  public ProductRequest countSku(String retName, SkuRequest sku) {
    sku.count();
    return statsFromSku(retName, sku);
  }

  public ProductRequest statsFromSku(String retName, SkuRequest sku) {
    return addDynamicProperty(retName, sku, Sku.PRODUCT_PROPERTY);
  }

  public ProductRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ProductRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ProductRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ProductRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
