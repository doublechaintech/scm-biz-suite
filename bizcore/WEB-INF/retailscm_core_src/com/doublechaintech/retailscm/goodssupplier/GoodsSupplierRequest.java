package com.doublechaintech.retailscm.goodssupplier;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodssupplier.GoodsSupplier.*;

public class GoodsSupplierRequest extends BaseRequest<GoodsSupplier> {
  public static GoodsSupplierRequest newInstance() {
    return new GoodsSupplierRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public GoodsSupplierRequest resultByClass(Class<? extends GoodsSupplier> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public GoodsSupplierRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public GoodsSupplierRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "GoodsSupplier";
  }

  public GoodsSupplierRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public GoodsSupplierRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public GoodsSupplierRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public GoodsSupplierRequest select(String... names) {
    super.select(names);
    return this;
  }

  public GoodsSupplierRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectSupplyProduct()
        .selectBelongTo()
        .selectContactNumber()
        .selectDescription()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public GoodsSupplierRequest selectAny() {
    return selectAll()
        .selectSupplierProductList(Q.supplierProduct().selectSelf())
        .selectSupplyOrderList(Q.supplyOrder().selectSelf())
        .selectAccountSetList(Q.accountSet().selectSelf());
  }

  public GoodsSupplierRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(SUPPLY_PRODUCT_PROPERTY);
    select(BELONG_TO_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public GoodsSupplierRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public GoodsSupplierRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    SUPPLY_PRODUCT_PROPERTY,
    BELONG_TO_PROPERTY,
    CONTACT_NUMBER_PROPERTY,
    DESCRIPTION_PROPERTY,
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

  public GoodsSupplierRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public GoodsSupplierRequest comment(String comment) {
    return this;
  }

  public GoodsSupplierRequest enhance() {
    return this;
  }

  public GoodsSupplierRequest overrideClass(Class<? extends GoodsSupplier> clazz) {
    return this;
  }

  public GoodsSupplierRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public GoodsSupplierRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public GoodsSupplierRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public GoodsSupplierRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public GoodsSupplierRequest count() {
    return countId("count");
  }

  public static GoodsSupplierRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public GoodsSupplierRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public GoodsSupplierRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest selectId() {
    return select(ID_PROPERTY);
  }

  public GoodsSupplierRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsSupplierRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public GoodsSupplierRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public GoodsSupplierRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public GoodsSupplierRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public GoodsSupplierRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public GoodsSupplierRequest countId() {
    return countId("countId");
  }

  public GoodsSupplierRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public GoodsSupplierRequest maxId() {
    return maxId("maxId");
  }

  public GoodsSupplierRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public GoodsSupplierRequest minId() {
    return minId("minId");
  }

  public GoodsSupplierRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public GoodsSupplierRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public GoodsSupplierRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public GoodsSupplierRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public GoodsSupplierRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public GoodsSupplierRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsSupplierRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsSupplierRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public GoodsSupplierRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsSupplierRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public GoodsSupplierRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public GoodsSupplierRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public GoodsSupplierRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public GoodsSupplierRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public GoodsSupplierRequest countName() {
    return countName("countName");
  }

  public GoodsSupplierRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public GoodsSupplierRequest maxName() {
    return maxName("maxName");
  }

  public GoodsSupplierRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public GoodsSupplierRequest minName() {
    return minName("minName");
  }

  public GoodsSupplierRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public GoodsSupplierRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public GoodsSupplierRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public GoodsSupplierRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public GoodsSupplierRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest filterBySupplyProduct(String supplyProduct) {

    if (supplyProduct == null) {
      return this;
    }

    return filterBySupplyProduct(QueryOperator.EQUAL, supplyProduct);
  }

  public GoodsSupplierRequest whereSupplyProductIsNull() {
    return where(SUPPLY_PRODUCT_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsSupplierRequest whereSupplyProductIsNotNull() {
    return where(SUPPLY_PRODUCT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsSupplierRequest filterBySupplyProduct(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSupplyProductSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest selectSupplyProduct() {
    return select(SUPPLY_PRODUCT_PROPERTY);
  }

  public GoodsSupplierRequest unselectSupplyProduct() {
    return unselect(SUPPLY_PRODUCT_PROPERTY);
  }

  public SearchCriteria getSupplyProductSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SUPPLY_PRODUCT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsSupplierRequest orderBySupplyProduct(boolean asc) {
    addOrderBy(SUPPLY_PRODUCT_PROPERTY, asc);
    return this;
  }

  public GoodsSupplierRequest orderBySupplyProductAscending() {
    addOrderBy(SUPPLY_PRODUCT_PROPERTY, true);
    return this;
  }

  public GoodsSupplierRequest orderBySupplyProductDescending() {
    addOrderBy(SUPPLY_PRODUCT_PROPERTY, false);
    return this;
  }

  public GoodsSupplierRequest orderBySupplyProductAscendingUsingGBK() {
    addOrderBy("convert(supplyProduct using gbk)", true);
    return this;
  }

  public GoodsSupplierRequest orderBySupplyProductDescendingUsingGBK() {
    addOrderBy("convert(supplyProduct using gbk)", false);
    return this;
  }

  public GoodsSupplierRequest countSupplyProduct() {
    return countSupplyProduct("countSupplyProduct");
  }

  public GoodsSupplierRequest countSupplyProduct(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SUPPLY_PRODUCT_PROPERTY);
  }

  public GoodsSupplierRequest maxSupplyProduct() {
    return maxSupplyProduct("maxSupplyProduct");
  }

  public GoodsSupplierRequest maxSupplyProduct(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SUPPLY_PRODUCT_PROPERTY);
  }

  public GoodsSupplierRequest minSupplyProduct() {
    return minSupplyProduct("minSupplyProduct");
  }

  public GoodsSupplierRequest minSupplyProduct(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SUPPLY_PRODUCT_PROPERTY);
  }

  public GoodsSupplierRequest groupBySupplyProduct() {
    return groupBySupplyProduct(SUPPLY_PRODUCT_PROPERTY);
  }

  public GoodsSupplierRequest groupBySupplyProduct(String ret) {
    return groupBy(ret, SUPPLY_PRODUCT_PROPERTY);
  }

  public GoodsSupplierRequest groupBySupplyProduct(SqlFunction func) {
    return groupBySupplyProduct(SUPPLY_PRODUCT_PROPERTY, func);
  }

  public GoodsSupplierRequest groupBySupplyProduct(String ret, SqlFunction func) {
    super.groupBy(ret, func, SUPPLY_PRODUCT_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public GoodsSupplierRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsSupplierRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsSupplierRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public GoodsSupplierRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsSupplierRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public GoodsSupplierRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public GoodsSupplierRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public GoodsSupplierRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public GoodsSupplierRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public GoodsSupplierRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public GoodsSupplierRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public GoodsSupplierRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public GoodsSupplierRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public GoodsSupplierRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public GoodsSupplierRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public GoodsSupplierRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public GoodsSupplierRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public GoodsSupplierRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public GoodsSupplierRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public GoodsSupplierRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsSupplierRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsSupplierRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public GoodsSupplierRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsSupplierRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public GoodsSupplierRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public GoodsSupplierRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public GoodsSupplierRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public GoodsSupplierRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public GoodsSupplierRequest countDescription() {
    return countDescription("countDescription");
  }

  public GoodsSupplierRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public GoodsSupplierRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public GoodsSupplierRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public GoodsSupplierRequest minDescription() {
    return minDescription("minDescription");
  }

  public GoodsSupplierRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public GoodsSupplierRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public GoodsSupplierRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public GoodsSupplierRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public GoodsSupplierRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public GoodsSupplierRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsSupplierRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsSupplierRequest whereLastUpdateTimeBetween(
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

  public GoodsSupplierRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsSupplierRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsSupplierRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public GoodsSupplierRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public GoodsSupplierRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public GoodsSupplierRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public GoodsSupplierRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsSupplierRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public GoodsSupplierRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsSupplierRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public GoodsSupplierRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsSupplierRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsSupplierRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsSupplierRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public GoodsSupplierRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public GoodsSupplierRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsSupplierRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsSupplierRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsSupplierRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public GoodsSupplierRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsSupplierRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public GoodsSupplierRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public GoodsSupplierRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public GoodsSupplierRequest countVersion() {
    return countVersion("countVersion");
  }

  public GoodsSupplierRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public GoodsSupplierRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public GoodsSupplierRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public GoodsSupplierRequest minVersion() {
    return minVersion("minVersion");
  }

  public GoodsSupplierRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public GoodsSupplierRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public GoodsSupplierRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public GoodsSupplierRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public GoodsSupplierRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public GoodsSupplierRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public GoodsSupplierRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest filterByBelongTo(RetailStoreCountryCenterRequest belongTo) {
    return filterByBelongTo(belongTo, RetailStoreCountryCenter::getId);
  }

  public GoodsSupplierRequest filterByBelongTo(RetailStoreCountryCenter... belongTo) {
    if (isEmptyParam(belongTo)) {
      throw new IllegalArgumentException(
          "filterByBelongTo(RetailStoreCountryCenter... belongTo)参数不能为空!");
    }
    return where(BELONG_TO_PROPERTY, QueryOperator.IN, (Object[]) belongTo);
  }

  public GoodsSupplierRequest selectBelongToId() {
    select(BELONG_TO_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToBelongTo() {
    return upToBelongTo(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToBelongTo(RetailStoreCountryCenterRequest belongTo) {
    belongTo.aggregateChild(BELONG_TO_PROPERTY, this);
    this.groupByBelongTo(belongTo);
    return belongTo;
  }

  public RetailStoreCountryCenterRequest endAtBelongTo(String retName) {
    return endAtBelongTo(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtBelongTo(
      String retName, RetailStoreCountryCenterRequest belongTo) {
    belongTo.addDynamicProperty(retName, this, BELONG_TO_PROPERTY);
    return belongTo;
  }

  public GoodsSupplierRequest filterByBelongTo(String... belongTo) {
    if (isEmptyParam(belongTo)) {
      throw new IllegalArgumentException("filterByBelongTo(String... belongTo)参数不能为空!");
    }
    return where(BELONG_TO_PROPERTY, QueryOperator.IN, (Object[]) belongTo);
  }

  public GoodsSupplierRequest filterByBelongTo(
      RetailStoreCountryCenterRequest belongTo, IDRefine<RetailStoreCountryCenter> idRefine) {
    belongTo.unlimited();
    return addSearchCriteria(createBelongToCriteria(belongTo, idRefine));
  }

  public SearchCriteria createBelongToCriteria(
      RetailStoreCountryCenterRequest belongTo, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        belongTo, BELONG_TO_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public GoodsSupplierRequest selectBelongTo() {
    return selectBelongTo(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public GoodsSupplierRequest selectBelongTo(RetailStoreCountryCenterRequest belongTo) {
    selectParent(BELONG_TO_PROPERTY, belongTo);
    return this;
  }

  public GoodsSupplierRequest unselectBelongTo() {
    unselectParent(BELONG_TO_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest groupByBelongTo(RetailStoreCountryCenterRequest belongTo) {
    groupBy(BELONG_TO_PROPERTY, belongTo);
    return this;
  }

  public GoodsSupplierRequest aggregateBelongTo(RetailStoreCountryCenterRequest belongTo) {
    aggregateParent(BELONG_TO_PROPERTY, belongTo);
    return this;
  }

  public GoodsSupplierRequest countBelongTo() {
    return countBelongTo("countBelongTo");
  }

  public GoodsSupplierRequest countBelongTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONG_TO_PROPERTY);
  }

  public GoodsSupplierRequest groupByBelongTo() {
    return groupByBelongTo(BELONG_TO_PROPERTY);
  }

  public GoodsSupplierRequest groupByBelongTo(String ret) {
    return groupBy(ret, BELONG_TO_PROPERTY);
  }

  public GoodsSupplierRequest whereBelongToIsNull() {
    return where(BELONG_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsSupplierRequest whereBelongToIsNotNull() {
    return where(BELONG_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsSupplierRequest hasSupplierProduct() {
    return hasSupplierProduct(SupplierProductRequest.newInstance());
  }

  public GoodsSupplierRequest hasSupplierProduct(SupplierProduct... supplierProduct) {
    if (isEmptyParam(supplierProduct)) {
      throw new IllegalArgumentException(
          "hasSupplierProduct(SupplierProduct... supplierProduct)参数不能为空!");
    }
    return hasSupplierProduct(
        Q.supplierProduct()
            .select(SupplierProduct.SUPPLIER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) supplierProduct));
  }

  public GoodsSupplierRequest hasSupplierProduct(String... supplierProduct) {
    return hasSupplierProduct(
        Q.supplierProduct().select(SupplierProduct.SUPPLIER_PROPERTY).filterById(supplierProduct));
  }

  public GoodsSupplierRequest hasSupplierProduct(SupplierProductRequest supplierProduct) {
    return hasSupplierProduct(
        supplierProduct,
        $supplierProduct ->
            java.util.Optional.of($supplierProduct)
                .map(SupplierProduct::getSupplier)
                .map(GoodsSupplier::getId)
                .orElse(null));
  }

  public GoodsSupplierRequest hasSupplierProduct(
      SupplierProductRequest supplierProduct, IDRefine<SupplierProduct> idRefine) {
    supplierProduct.select(SupplierProduct.SUPPLIER_PROPERTY);
    supplierProduct.unlimited();
    return addSearchCriteria(createSupplierProductCriteria(supplierProduct, idRefine));
  }

  public GoodsSupplierRequest hasSupplierProduct(
      SupplierProductRequest supplierProduct, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            supplierProduct, SupplierProduct.SUPPLIER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSupplierProductCriteria(
      SupplierProductRequest supplierProduct, IDRefine<SupplierProduct> idRefine) {
    return new RefinedIdInCriteria(
        supplierProduct, ID_PROPERTY, idRefine, SupplierProduct.SUPPLIER_PROPERTY);
  }

  public GoodsSupplierRequest selectSupplierProductList(SupplierProductRequest supplierProduct) {
    selectChild(SupplierProduct.SUPPLIER_PROPERTY, supplierProduct);
    return this;
  }

  public GoodsSupplierRequest selectSupplierProductList() {
    return selectSupplierProductList(SupplierProductRequest.newInstance().selectAll());
  }

  public GoodsSupplierRequest unselectSupplierProductList() {
    unselectChild(SupplierProduct.SUPPLIER_PROPERTY, SupplierProduct.class);
    return this;
  }

  public GoodsSupplierRequest hasSupplyOrder() {
    return hasSupplyOrder(SupplyOrderRequest.newInstance());
  }

  public GoodsSupplierRequest hasSupplyOrder(SupplyOrder... supplyOrder) {
    if (isEmptyParam(supplyOrder)) {
      throw new IllegalArgumentException("hasSupplyOrder(SupplyOrder... supplyOrder)参数不能为空!");
    }
    return hasSupplyOrder(
        Q.supplyOrder()
            .select(SupplyOrder.SELLER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) supplyOrder));
  }

  public GoodsSupplierRequest hasSupplyOrder(String... supplyOrder) {
    return hasSupplyOrder(
        Q.supplyOrder().select(SupplyOrder.SELLER_PROPERTY).filterById(supplyOrder));
  }

  public GoodsSupplierRequest hasSupplyOrder(SupplyOrderRequest supplyOrder) {
    return hasSupplyOrder(
        supplyOrder,
        $supplyOrder ->
            java.util.Optional.of($supplyOrder)
                .map(SupplyOrder::getSeller)
                .map(GoodsSupplier::getId)
                .orElse(null));
  }

  public GoodsSupplierRequest hasSupplyOrder(
      SupplyOrderRequest supplyOrder, IDRefine<SupplyOrder> idRefine) {
    supplyOrder.select(SupplyOrder.SELLER_PROPERTY);
    supplyOrder.unlimited();
    return addSearchCriteria(createSupplyOrderCriteria(supplyOrder, idRefine));
  }

  public GoodsSupplierRequest hasSupplyOrder(
      SupplyOrderRequest supplyOrder, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(supplyOrder, SupplyOrder.SELLER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSupplyOrderCriteria(
      SupplyOrderRequest supplyOrder, IDRefine<SupplyOrder> idRefine) {
    return new RefinedIdInCriteria(supplyOrder, ID_PROPERTY, idRefine, SupplyOrder.SELLER_PROPERTY);
  }

  public GoodsSupplierRequest selectSupplyOrderList(SupplyOrderRequest supplyOrder) {
    selectChild(SupplyOrder.SELLER_PROPERTY, supplyOrder);
    return this;
  }

  public GoodsSupplierRequest selectSupplyOrderList() {
    return selectSupplyOrderList(SupplyOrderRequest.newInstance().selectAll());
  }

  public GoodsSupplierRequest unselectSupplyOrderList() {
    unselectChild(SupplyOrder.SELLER_PROPERTY, SupplyOrder.class);
    return this;
  }

  public GoodsSupplierRequest hasAccountSet() {
    return hasAccountSet(AccountSetRequest.newInstance());
  }

  public GoodsSupplierRequest hasAccountSet(AccountSet... accountSet) {
    if (isEmptyParam(accountSet)) {
      throw new IllegalArgumentException("hasAccountSet(AccountSet... accountSet)参数不能为空!");
    }
    return hasAccountSet(
        Q.accountSet()
            .select(AccountSet.GOODS_SUPPLIER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountSet));
  }

  public GoodsSupplierRequest hasAccountSet(String... accountSet) {
    return hasAccountSet(
        Q.accountSet().select(AccountSet.GOODS_SUPPLIER_PROPERTY).filterById(accountSet));
  }

  public GoodsSupplierRequest hasAccountSet(AccountSetRequest accountSet) {
    return hasAccountSet(
        accountSet,
        $accountSet ->
            java.util.Optional.of($accountSet)
                .map(AccountSet::getGoodsSupplier)
                .map(GoodsSupplier::getId)
                .orElse(null));
  }

  public GoodsSupplierRequest hasAccountSet(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    accountSet.select(AccountSet.GOODS_SUPPLIER_PROPERTY);
    accountSet.unlimited();
    return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
  }

  public GoodsSupplierRequest hasAccountSet(
      AccountSetRequest accountSet, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountSet, AccountSet.GOODS_SUPPLIER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createAccountSetCriteria(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    return new RefinedIdInCriteria(
        accountSet, ID_PROPERTY, idRefine, AccountSet.GOODS_SUPPLIER_PROPERTY);
  }

  public GoodsSupplierRequest selectAccountSetList(AccountSetRequest accountSet) {
    selectChild(AccountSet.GOODS_SUPPLIER_PROPERTY, accountSet);
    return this;
  }

  public GoodsSupplierRequest selectAccountSetList() {
    return selectAccountSetList(AccountSetRequest.newInstance().selectAll());
  }

  public GoodsSupplierRequest unselectAccountSetList() {
    unselectChild(AccountSet.GOODS_SUPPLIER_PROPERTY, AccountSet.class);
    return this;
  }

  public GoodsSupplierRequest aggregateSupplierProductList(SupplierProductRequest supplierProduct) {
    aggregateChild(SupplierProduct.SUPPLIER_PROPERTY, supplierProduct);
    return this;
  }

  public GoodsSupplierRequest countSupplierProduct() {
    return countSupplierProduct("supplierProductCount");
  }

  public GoodsSupplierRequest countSupplierProduct(String retName) {
    return countSupplierProduct(retName, SupplierProductRequest.newInstance());
  }

  public GoodsSupplierRequest countSupplierProduct(SupplierProductRequest supplierProduct) {
    return countSupplierProduct("supplierProductCount", supplierProduct);
  }

  public GoodsSupplierRequest countSupplierProduct(
      String retName, SupplierProductRequest supplierProduct) {
    supplierProduct.count();
    return statsFromSupplierProduct(retName, supplierProduct);
  }

  public GoodsSupplierRequest statsFromSupplierProduct(
      String retName, SupplierProductRequest supplierProduct) {
    return addDynamicProperty(retName, supplierProduct, SupplierProduct.SUPPLIER_PROPERTY);
  }

  public GoodsSupplierRequest aggregateSupplyOrderList(SupplyOrderRequest supplyOrder) {
    aggregateChild(SupplyOrder.SELLER_PROPERTY, supplyOrder);
    return this;
  }

  public GoodsSupplierRequest countSupplyOrder() {
    return countSupplyOrder("supplyOrderCount");
  }

  public GoodsSupplierRequest countSupplyOrder(String retName) {
    return countSupplyOrder(retName, SupplyOrderRequest.newInstance());
  }

  public GoodsSupplierRequest countSupplyOrder(SupplyOrderRequest supplyOrder) {
    return countSupplyOrder("supplyOrderCount", supplyOrder);
  }

  public GoodsSupplierRequest countSupplyOrder(String retName, SupplyOrderRequest supplyOrder) {
    supplyOrder.count();
    return statsFromSupplyOrder(retName, supplyOrder);
  }

  public GoodsSupplierRequest statsFromSupplyOrder(String retName, SupplyOrderRequest supplyOrder) {
    return addDynamicProperty(retName, supplyOrder, SupplyOrder.SELLER_PROPERTY);
  }

  public GoodsSupplierRequest aggregateAccountSetList(AccountSetRequest accountSet) {
    aggregateChild(AccountSet.GOODS_SUPPLIER_PROPERTY, accountSet);
    return this;
  }

  public GoodsSupplierRequest countAccountSet() {
    return countAccountSet("accountSetCount");
  }

  public GoodsSupplierRequest countAccountSet(String retName) {
    return countAccountSet(retName, AccountSetRequest.newInstance());
  }

  public GoodsSupplierRequest countAccountSet(AccountSetRequest accountSet) {
    return countAccountSet("accountSetCount", accountSet);
  }

  public GoodsSupplierRequest countAccountSet(String retName, AccountSetRequest accountSet) {
    accountSet.count();
    return statsFromAccountSet(retName, accountSet);
  }

  public GoodsSupplierRequest statsFromAccountSet(String retName, AccountSetRequest accountSet) {
    return addDynamicProperty(retName, accountSet, AccountSet.GOODS_SUPPLIER_PROPERTY);
  }

  public GoodsSupplierRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public GoodsSupplierRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public GoodsSupplierRequest unlimited() {
    super.unlimited();
    return this;
  }

  public GoodsSupplierRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
