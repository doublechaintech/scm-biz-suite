package com.doublechaintech.retailscm.goods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovementRequest;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest;
import com.doublechaintech.retailscm.sku.SkuRequest;
import com.doublechaintech.retailscm.smartpallet.SmartPalletRequest;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goods.Goods.*;

public class GoodsRequest extends BaseRequest<Goods> {
  public static GoodsRequest newInstance() {
    return new GoodsRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public GoodsRequest resultByClass(Class<? extends Goods> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public GoodsRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public GoodsRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Goods";
  }

  public GoodsRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public GoodsRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public GoodsRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public GoodsRequest select(String... names) {
    super.select(names);
    return this;
  }

  public GoodsRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectRfid()
        .selectUom()
        .selectMaxPackage()
        .selectExpireTime()
        .selectSku()
        .selectReceivingSpace()
        .selectGoodsAllocation()
        .selectSmartPallet()
        .selectShippingSpace()
        .selectTransportTask()
        .selectRetailStore()
        .selectBizOrder()
        .selectRetailStoreOrder()
        .selectVersion();
  }

  public GoodsRequest selectAny() {
    return selectAll().selectGoodsMovementList(Q.goodsMovement().selectSelf());
  }

  public GoodsRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(RFID_PROPERTY);
    select(UOM_PROPERTY);
    select(MAX_PACKAGE_PROPERTY);
    select(EXPIRE_TIME_PROPERTY);
    select(SKU_PROPERTY);
    select(RECEIVING_SPACE_PROPERTY);
    select(GOODS_ALLOCATION_PROPERTY);
    select(SMART_PALLET_PROPERTY);
    select(SHIPPING_SPACE_PROPERTY);
    select(TRANSPORT_TASK_PROPERTY);
    select(RETAIL_STORE_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(RETAIL_STORE_ORDER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public GoodsRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public GoodsRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {EXPIRE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    RFID_PROPERTY,
    UOM_PROPERTY,
    MAX_PACKAGE_PROPERTY,
    EXPIRE_TIME_PROPERTY,
    SKU_PROPERTY,
    RECEIVING_SPACE_PROPERTY,
    GOODS_ALLOCATION_PROPERTY,
    SMART_PALLET_PROPERTY,
    SHIPPING_SPACE_PROPERTY,
    TRANSPORT_TASK_PROPERTY,
    RETAIL_STORE_PROPERTY,
    BIZ_ORDER_PROPERTY,
    RETAIL_STORE_ORDER_PROPERTY,
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

  public GoodsRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public GoodsRequest comment(String comment) {
    return this;
  }

  public GoodsRequest enhance() {
    return this;
  }

  public GoodsRequest overrideClass(Class<? extends Goods> clazz) {
    return this;
  }

  public GoodsRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public GoodsRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public GoodsRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public GoodsRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public GoodsRequest count() {
    return countId("count");
  }

  public static GoodsRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public GoodsRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public GoodsRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest selectId() {
    return select(ID_PROPERTY);
  }

  public GoodsRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public GoodsRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public GoodsRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public GoodsRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public GoodsRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public GoodsRequest countId() {
    return countId("countId");
  }

  public GoodsRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public GoodsRequest maxId() {
    return maxId("maxId");
  }

  public GoodsRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public GoodsRequest minId() {
    return minId("minId");
  }

  public GoodsRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public GoodsRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public GoodsRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public GoodsRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public GoodsRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public GoodsRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public GoodsRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public GoodsRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public GoodsRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public GoodsRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public GoodsRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public GoodsRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public GoodsRequest countName() {
    return countName("countName");
  }

  public GoodsRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public GoodsRequest maxName() {
    return maxName("maxName");
  }

  public GoodsRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public GoodsRequest minName() {
    return minName("minName");
  }

  public GoodsRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public GoodsRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public GoodsRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public GoodsRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public GoodsRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public GoodsRequest filterByRfid(String rfid) {

    if (rfid == null) {
      return this;
    }

    return filterByRfid(QueryOperator.EQUAL, rfid);
  }

  public GoodsRequest whereRfidIsNull() {
    return where(RFID_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereRfidIsNotNull() {
    return where(RFID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByRfid(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRfidSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest selectRfid() {
    return select(RFID_PROPERTY);
  }

  public GoodsRequest unselectRfid() {
    return unselect(RFID_PROPERTY);
  }

  public SearchCriteria getRfidSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(RFID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsRequest orderByRfid(boolean asc) {
    addOrderBy(RFID_PROPERTY, asc);
    return this;
  }

  public GoodsRequest orderByRfidAscending() {
    addOrderBy(RFID_PROPERTY, true);
    return this;
  }

  public GoodsRequest orderByRfidDescending() {
    addOrderBy(RFID_PROPERTY, false);
    return this;
  }

  public GoodsRequest orderByRfidAscendingUsingGBK() {
    addOrderBy("convert(rfid using gbk)", true);
    return this;
  }

  public GoodsRequest orderByRfidDescendingUsingGBK() {
    addOrderBy("convert(rfid using gbk)", false);
    return this;
  }

  public GoodsRequest countRfid() {
    return countRfid("countRfid");
  }

  public GoodsRequest countRfid(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RFID_PROPERTY);
  }

  public GoodsRequest maxRfid() {
    return maxRfid("maxRfid");
  }

  public GoodsRequest maxRfid(String aggName) {
    return aggregate(aggName, AggFunc.MAX, RFID_PROPERTY);
  }

  public GoodsRequest minRfid() {
    return minRfid("minRfid");
  }

  public GoodsRequest minRfid(String aggName) {
    return aggregate(aggName, AggFunc.MIN, RFID_PROPERTY);
  }

  public GoodsRequest groupByRfid() {
    return groupByRfid(RFID_PROPERTY);
  }

  public GoodsRequest groupByRfid(String ret) {
    return groupBy(ret, RFID_PROPERTY);
  }

  public GoodsRequest groupByRfid(SqlFunction func) {
    return groupByRfid(RFID_PROPERTY, func);
  }

  public GoodsRequest groupByRfid(String ret, SqlFunction func) {
    super.groupBy(ret, func, RFID_PROPERTY);
    return this;
  }

  public GoodsRequest filterByUom(String uom) {

    if (uom == null) {
      return this;
    }

    return filterByUom(QueryOperator.EQUAL, uom);
  }

  public GoodsRequest whereUomIsNull() {
    return where(UOM_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereUomIsNotNull() {
    return where(UOM_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByUom(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getUomSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest selectUom() {
    return select(UOM_PROPERTY);
  }

  public GoodsRequest unselectUom() {
    return unselect(UOM_PROPERTY);
  }

  public SearchCriteria getUomSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(UOM_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsRequest orderByUom(boolean asc) {
    addOrderBy(UOM_PROPERTY, asc);
    return this;
  }

  public GoodsRequest orderByUomAscending() {
    addOrderBy(UOM_PROPERTY, true);
    return this;
  }

  public GoodsRequest orderByUomDescending() {
    addOrderBy(UOM_PROPERTY, false);
    return this;
  }

  public GoodsRequest orderByUomAscendingUsingGBK() {
    addOrderBy("convert(uom using gbk)", true);
    return this;
  }

  public GoodsRequest orderByUomDescendingUsingGBK() {
    addOrderBy("convert(uom using gbk)", false);
    return this;
  }

  public GoodsRequest countUom() {
    return countUom("countUom");
  }

  public GoodsRequest countUom(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, UOM_PROPERTY);
  }

  public GoodsRequest maxUom() {
    return maxUom("maxUom");
  }

  public GoodsRequest maxUom(String aggName) {
    return aggregate(aggName, AggFunc.MAX, UOM_PROPERTY);
  }

  public GoodsRequest minUom() {
    return minUom("minUom");
  }

  public GoodsRequest minUom(String aggName) {
    return aggregate(aggName, AggFunc.MIN, UOM_PROPERTY);
  }

  public GoodsRequest groupByUom() {
    return groupByUom(UOM_PROPERTY);
  }

  public GoodsRequest groupByUom(String ret) {
    return groupBy(ret, UOM_PROPERTY);
  }

  public GoodsRequest groupByUom(SqlFunction func) {
    return groupByUom(UOM_PROPERTY, func);
  }

  public GoodsRequest groupByUom(String ret, SqlFunction func) {
    super.groupBy(ret, func, UOM_PROPERTY);
    return this;
  }

  public GoodsRequest filterByMaxPackage(int maxPackage) {

    return filterByMaxPackage(QueryOperator.EQUAL, maxPackage);
  }

  public GoodsRequest whereMaxPackageIsNull() {
    return where(MAX_PACKAGE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereMaxPackageIsNotNull() {
    return where(MAX_PACKAGE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest whereMaxPackageBetween(Integer maxPackageStart, Integer maxPackageEnd) {
    if (ObjectUtil.isEmpty(maxPackageStart)) {
      throw new IllegalArgumentException(
          "Method whereMaxPackageBetween, the parameter maxPackageStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(maxPackageEnd)) {
      throw new IllegalArgumentException(
          "Method whereMaxPackageBetween, the parameter maxPackageEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getMaxPackageSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {maxPackageStart, maxPackageEnd});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest whereMaxPackageLessThan(Integer maxPackage) {
    if (ObjectUtil.isEmpty(maxPackage)) {
      throw new IllegalArgumentException(
          "Method whereMaxPackageLessThan, the parameter maxPackage is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getMaxPackageSearchCriteria(QueryOperator.LESS_THAN, new Object[] {maxPackage});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest whereMaxPackageGreaterThan(int maxPackage) {
    if (ObjectUtil.isEmpty(maxPackage)) {
      throw new IllegalArgumentException(
          "Method whereMaxPackageGreaterThan, the parameter maxPackage is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getMaxPackageSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {maxPackage});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest filterByMaxPackage(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMaxPackageSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest selectMaxPackage() {
    return select(MAX_PACKAGE_PROPERTY);
  }

  public GoodsRequest unselectMaxPackage() {
    return unselect(MAX_PACKAGE_PROPERTY);
  }

  public SearchCriteria getMaxPackageSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MAX_PACKAGE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsRequest orderByMaxPackage(boolean asc) {
    addOrderBy(MAX_PACKAGE_PROPERTY, asc);
    return this;
  }

  public GoodsRequest orderByMaxPackageAscending() {
    addOrderBy(MAX_PACKAGE_PROPERTY, true);
    return this;
  }

  public GoodsRequest orderByMaxPackageDescending() {
    addOrderBy(MAX_PACKAGE_PROPERTY, false);
    return this;
  }

  public GoodsRequest countMaxPackage() {
    return countMaxPackage("countMaxPackage");
  }

  public GoodsRequest countMaxPackage(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MAX_PACKAGE_PROPERTY);
  }

  public GoodsRequest maxMaxPackage() {
    return maxMaxPackage("maxMaxPackage");
  }

  public GoodsRequest maxMaxPackage(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MAX_PACKAGE_PROPERTY);
  }

  public GoodsRequest minMaxPackage() {
    return minMaxPackage("minMaxPackage");
  }

  public GoodsRequest minMaxPackage(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MAX_PACKAGE_PROPERTY);
  }

  public GoodsRequest sumMaxPackage() {
    return sumMaxPackage("sumMaxPackage");
  }

  public GoodsRequest sumMaxPackage(String aggName) {
    return aggregate(aggName, AggFunc.SUM, MAX_PACKAGE_PROPERTY);
  }

  public GoodsRequest groupByMaxPackage() {
    return groupByMaxPackage(MAX_PACKAGE_PROPERTY);
  }

  public GoodsRequest groupByMaxPackage(String ret) {
    return groupBy(ret, MAX_PACKAGE_PROPERTY);
  }

  public GoodsRequest groupByMaxPackage(SqlFunction func) {
    return groupByMaxPackage(MAX_PACKAGE_PROPERTY, func);
  }

  public GoodsRequest groupByMaxPackage(String ret, SqlFunction func) {
    super.groupBy(ret, func, MAX_PACKAGE_PROPERTY);
    return this;
  }

  public GoodsRequest filterByExpireTime(Date expireTime) {

    if (expireTime == null) {
      return this;
    }

    return filterByExpireTime(QueryOperator.EQUAL, expireTime);
  }

  public GoodsRequest whereExpireTimeIsNull() {
    return where(EXPIRE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereExpireTimeIsNotNull() {
    return where(EXPIRE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest whereExpireTimeBetween(Date expireTimeStart, Date expireTimeEnd) {
    if (ObjectUtil.isEmpty(expireTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereExpireTimeBetween, the parameter expireTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(expireTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereExpireTimeBetween, the parameter expireTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getExpireTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {expireTimeStart, expireTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest whereExpireTimeBefore(Date expireTime) {

    if (ObjectUtil.isEmpty(expireTime)) {
      throw new IllegalArgumentException(
          "Method whereExpireTimeBefore, the parameter expireTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getExpireTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {expireTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest whereExpireTimeAfter(Date expireTime) {
    if (ObjectUtil.isEmpty(expireTime)) {
      throw new IllegalArgumentException(
          "Method whereExpireTimeAfter, the parameter expireTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getExpireTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {expireTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest filterByExpireTime(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getExpireTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest selectExpireTime() {
    return select(EXPIRE_TIME_PROPERTY);
  }

  public GoodsRequest unselectExpireTime() {
    return unselect(EXPIRE_TIME_PROPERTY);
  }

  public SearchCriteria getExpireTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(EXPIRE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsRequest orderByExpireTime(boolean asc) {
    addOrderBy(EXPIRE_TIME_PROPERTY, asc);
    return this;
  }

  public GoodsRequest orderByExpireTimeAscending() {
    addOrderBy(EXPIRE_TIME_PROPERTY, true);
    return this;
  }

  public GoodsRequest orderByExpireTimeDescending() {
    addOrderBy(EXPIRE_TIME_PROPERTY, false);
    return this;
  }

  public GoodsRequest countExpireTime() {
    return countExpireTime("countExpireTime");
  }

  public GoodsRequest countExpireTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EXPIRE_TIME_PROPERTY);
  }

  public GoodsRequest maxExpireTime() {
    return maxExpireTime("maxExpireTime");
  }

  public GoodsRequest maxExpireTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, EXPIRE_TIME_PROPERTY);
  }

  public GoodsRequest minExpireTime() {
    return minExpireTime("minExpireTime");
  }

  public GoodsRequest minExpireTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, EXPIRE_TIME_PROPERTY);
  }

  public GoodsRequest groupByExpireTime() {
    return groupByExpireTime(EXPIRE_TIME_PROPERTY);
  }

  public GoodsRequest groupByExpireTime(String ret) {
    return groupBy(ret, EXPIRE_TIME_PROPERTY);
  }

  public GoodsRequest groupByExpireTime(SqlFunction func) {
    return groupByExpireTime(EXPIRE_TIME_PROPERTY, func);
  }

  public GoodsRequest groupByExpireTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, EXPIRE_TIME_PROPERTY);
    return this;
  }

  public GoodsRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public GoodsRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public GoodsRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public GoodsRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public GoodsRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public GoodsRequest countVersion() {
    return countVersion("countVersion");
  }

  public GoodsRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public GoodsRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public GoodsRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public GoodsRequest minVersion() {
    return minVersion("minVersion");
  }

  public GoodsRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public GoodsRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public GoodsRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public GoodsRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public GoodsRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public GoodsRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public GoodsRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public GoodsRequest filterBySku(SkuRequest sku) {
    return filterBySku(sku, Sku::getId);
  }

  public GoodsRequest filterBySku(Sku... sku) {
    if (isEmptyParam(sku)) {
      throw new IllegalArgumentException("filterBySku(Sku... sku)参数不能为空!");
    }
    return where(SKU_PROPERTY, QueryOperator.IN, (Object[]) sku);
  }

  public GoodsRequest selectSkuId() {
    select(SKU_PROPERTY);
    return this;
  }

  public SkuRequest upToSku() {
    return upToSku(SkuRequest.newInstance());
  }

  public SkuRequest upToSku(SkuRequest sku) {
    sku.aggregateChild(SKU_PROPERTY, this);
    this.groupBySku(sku);
    return sku;
  }

  public SkuRequest endAtSku(String retName) {
    return endAtSku(retName, SkuRequest.newInstance());
  }

  public SkuRequest endAtSku(String retName, SkuRequest sku) {
    sku.addDynamicProperty(retName, this, SKU_PROPERTY);
    return sku;
  }

  public GoodsRequest filterBySku(String... sku) {
    if (isEmptyParam(sku)) {
      throw new IllegalArgumentException("filterBySku(String... sku)参数不能为空!");
    }
    return where(SKU_PROPERTY, QueryOperator.IN, (Object[]) sku);
  }

  public GoodsRequest filterBySku(SkuRequest sku, IDRefine<Sku> idRefine) {
    sku.unlimited();
    return addSearchCriteria(createSkuCriteria(sku, idRefine));
  }

  public SearchCriteria createSkuCriteria(SkuRequest sku, IDRefine<Sku> idRefine) {
    return new RefinedIdInCriteria(sku, SKU_PROPERTY, idRefine, Sku.ID_PROPERTY);
  }

  public GoodsRequest selectSku() {
    return selectSku(SkuRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectSku(SkuRequest sku) {
    selectParent(SKU_PROPERTY, sku);
    return this;
  }

  public GoodsRequest unselectSku() {
    unselectParent(SKU_PROPERTY);
    return this;
  }

  public GoodsRequest groupBySku(SkuRequest sku) {
    groupBy(SKU_PROPERTY, sku);
    return this;
  }

  public GoodsRequest aggregateSku(SkuRequest sku) {
    aggregateParent(SKU_PROPERTY, sku);
    return this;
  }

  public GoodsRequest countSku() {
    return countSku("countSku");
  }

  public GoodsRequest countSku(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SKU_PROPERTY);
  }

  public GoodsRequest groupBySku() {
    return groupBySku(SKU_PROPERTY);
  }

  public GoodsRequest groupBySku(String ret) {
    return groupBy(ret, SKU_PROPERTY);
  }

  public GoodsRequest whereSkuIsNull() {
    return where(SKU_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereSkuIsNotNull() {
    return where(SKU_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByReceivingSpace(ReceivingSpaceRequest receivingSpace) {
    return filterByReceivingSpace(receivingSpace, ReceivingSpace::getId);
  }

  public GoodsRequest filterByReceivingSpace(ReceivingSpace... receivingSpace) {
    if (isEmptyParam(receivingSpace)) {
      throw new IllegalArgumentException(
          "filterByReceivingSpace(ReceivingSpace... receivingSpace)参数不能为空!");
    }
    return where(RECEIVING_SPACE_PROPERTY, QueryOperator.IN, (Object[]) receivingSpace);
  }

  public GoodsRequest selectReceivingSpaceId() {
    select(RECEIVING_SPACE_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest upToReceivingSpace() {
    return upToReceivingSpace(ReceivingSpaceRequest.newInstance());
  }

  public ReceivingSpaceRequest upToReceivingSpace(ReceivingSpaceRequest receivingSpace) {
    receivingSpace.aggregateChild(RECEIVING_SPACE_PROPERTY, this);
    this.groupByReceivingSpace(receivingSpace);
    return receivingSpace;
  }

  public ReceivingSpaceRequest endAtReceivingSpace(String retName) {
    return endAtReceivingSpace(retName, ReceivingSpaceRequest.newInstance());
  }

  public ReceivingSpaceRequest endAtReceivingSpace(
      String retName, ReceivingSpaceRequest receivingSpace) {
    receivingSpace.addDynamicProperty(retName, this, RECEIVING_SPACE_PROPERTY);
    return receivingSpace;
  }

  public GoodsRequest filterByReceivingSpace(String... receivingSpace) {
    if (isEmptyParam(receivingSpace)) {
      throw new IllegalArgumentException("filterByReceivingSpace(String... receivingSpace)参数不能为空!");
    }
    return where(RECEIVING_SPACE_PROPERTY, QueryOperator.IN, (Object[]) receivingSpace);
  }

  public GoodsRequest filterByReceivingSpace(
      ReceivingSpaceRequest receivingSpace, IDRefine<ReceivingSpace> idRefine) {
    receivingSpace.unlimited();
    return addSearchCriteria(createReceivingSpaceCriteria(receivingSpace, idRefine));
  }

  public SearchCriteria createReceivingSpaceCriteria(
      ReceivingSpaceRequest receivingSpace, IDRefine<ReceivingSpace> idRefine) {
    return new RefinedIdInCriteria(
        receivingSpace, RECEIVING_SPACE_PROPERTY, idRefine, ReceivingSpace.ID_PROPERTY);
  }

  public GoodsRequest selectReceivingSpace() {
    return selectReceivingSpace(ReceivingSpaceRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectReceivingSpace(ReceivingSpaceRequest receivingSpace) {
    selectParent(RECEIVING_SPACE_PROPERTY, receivingSpace);
    return this;
  }

  public GoodsRequest unselectReceivingSpace() {
    unselectParent(RECEIVING_SPACE_PROPERTY);
    return this;
  }

  public GoodsRequest groupByReceivingSpace(ReceivingSpaceRequest receivingSpace) {
    groupBy(RECEIVING_SPACE_PROPERTY, receivingSpace);
    return this;
  }

  public GoodsRequest aggregateReceivingSpace(ReceivingSpaceRequest receivingSpace) {
    aggregateParent(RECEIVING_SPACE_PROPERTY, receivingSpace);
    return this;
  }

  public GoodsRequest countReceivingSpace() {
    return countReceivingSpace("countReceivingSpace");
  }

  public GoodsRequest countReceivingSpace(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RECEIVING_SPACE_PROPERTY);
  }

  public GoodsRequest groupByReceivingSpace() {
    return groupByReceivingSpace(RECEIVING_SPACE_PROPERTY);
  }

  public GoodsRequest groupByReceivingSpace(String ret) {
    return groupBy(ret, RECEIVING_SPACE_PROPERTY);
  }

  public GoodsRequest whereReceivingSpaceIsNull() {
    return where(RECEIVING_SPACE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereReceivingSpaceIsNotNull() {
    return where(RECEIVING_SPACE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByGoodsAllocation(GoodsAllocationRequest goodsAllocation) {
    return filterByGoodsAllocation(goodsAllocation, GoodsAllocation::getId);
  }

  public GoodsRequest filterByGoodsAllocation(GoodsAllocation... goodsAllocation) {
    if (isEmptyParam(goodsAllocation)) {
      throw new IllegalArgumentException(
          "filterByGoodsAllocation(GoodsAllocation... goodsAllocation)参数不能为空!");
    }
    return where(GOODS_ALLOCATION_PROPERTY, QueryOperator.IN, (Object[]) goodsAllocation);
  }

  public GoodsRequest selectGoodsAllocationId() {
    select(GOODS_ALLOCATION_PROPERTY);
    return this;
  }

  public GoodsAllocationRequest upToGoodsAllocation() {
    return upToGoodsAllocation(GoodsAllocationRequest.newInstance());
  }

  public GoodsAllocationRequest upToGoodsAllocation(GoodsAllocationRequest goodsAllocation) {
    goodsAllocation.aggregateChild(GOODS_ALLOCATION_PROPERTY, this);
    this.groupByGoodsAllocation(goodsAllocation);
    return goodsAllocation;
  }

  public GoodsAllocationRequest endAtGoodsAllocation(String retName) {
    return endAtGoodsAllocation(retName, GoodsAllocationRequest.newInstance());
  }

  public GoodsAllocationRequest endAtGoodsAllocation(
      String retName, GoodsAllocationRequest goodsAllocation) {
    goodsAllocation.addDynamicProperty(retName, this, GOODS_ALLOCATION_PROPERTY);
    return goodsAllocation;
  }

  public GoodsRequest filterByGoodsAllocation(String... goodsAllocation) {
    if (isEmptyParam(goodsAllocation)) {
      throw new IllegalArgumentException(
          "filterByGoodsAllocation(String... goodsAllocation)参数不能为空!");
    }
    return where(GOODS_ALLOCATION_PROPERTY, QueryOperator.IN, (Object[]) goodsAllocation);
  }

  public GoodsRequest filterByGoodsAllocation(
      GoodsAllocationRequest goodsAllocation, IDRefine<GoodsAllocation> idRefine) {
    goodsAllocation.unlimited();
    return addSearchCriteria(createGoodsAllocationCriteria(goodsAllocation, idRefine));
  }

  public SearchCriteria createGoodsAllocationCriteria(
      GoodsAllocationRequest goodsAllocation, IDRefine<GoodsAllocation> idRefine) {
    return new RefinedIdInCriteria(
        goodsAllocation, GOODS_ALLOCATION_PROPERTY, idRefine, GoodsAllocation.ID_PROPERTY);
  }

  public GoodsRequest selectGoodsAllocation() {
    return selectGoodsAllocation(GoodsAllocationRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectGoodsAllocation(GoodsAllocationRequest goodsAllocation) {
    selectParent(GOODS_ALLOCATION_PROPERTY, goodsAllocation);
    return this;
  }

  public GoodsRequest unselectGoodsAllocation() {
    unselectParent(GOODS_ALLOCATION_PROPERTY);
    return this;
  }

  public GoodsRequest groupByGoodsAllocation(GoodsAllocationRequest goodsAllocation) {
    groupBy(GOODS_ALLOCATION_PROPERTY, goodsAllocation);
    return this;
  }

  public GoodsRequest aggregateGoodsAllocation(GoodsAllocationRequest goodsAllocation) {
    aggregateParent(GOODS_ALLOCATION_PROPERTY, goodsAllocation);
    return this;
  }

  public GoodsRequest countGoodsAllocation() {
    return countGoodsAllocation("countGoodsAllocation");
  }

  public GoodsRequest countGoodsAllocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, GOODS_ALLOCATION_PROPERTY);
  }

  public GoodsRequest groupByGoodsAllocation() {
    return groupByGoodsAllocation(GOODS_ALLOCATION_PROPERTY);
  }

  public GoodsRequest groupByGoodsAllocation(String ret) {
    return groupBy(ret, GOODS_ALLOCATION_PROPERTY);
  }

  public GoodsRequest whereGoodsAllocationIsNull() {
    return where(GOODS_ALLOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereGoodsAllocationIsNotNull() {
    return where(GOODS_ALLOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterBySmartPallet(SmartPalletRequest smartPallet) {
    return filterBySmartPallet(smartPallet, SmartPallet::getId);
  }

  public GoodsRequest filterBySmartPallet(SmartPallet... smartPallet) {
    if (isEmptyParam(smartPallet)) {
      throw new IllegalArgumentException("filterBySmartPallet(SmartPallet... smartPallet)参数不能为空!");
    }
    return where(SMART_PALLET_PROPERTY, QueryOperator.IN, (Object[]) smartPallet);
  }

  public GoodsRequest selectSmartPalletId() {
    select(SMART_PALLET_PROPERTY);
    return this;
  }

  public SmartPalletRequest upToSmartPallet() {
    return upToSmartPallet(SmartPalletRequest.newInstance());
  }

  public SmartPalletRequest upToSmartPallet(SmartPalletRequest smartPallet) {
    smartPallet.aggregateChild(SMART_PALLET_PROPERTY, this);
    this.groupBySmartPallet(smartPallet);
    return smartPallet;
  }

  public SmartPalletRequest endAtSmartPallet(String retName) {
    return endAtSmartPallet(retName, SmartPalletRequest.newInstance());
  }

  public SmartPalletRequest endAtSmartPallet(String retName, SmartPalletRequest smartPallet) {
    smartPallet.addDynamicProperty(retName, this, SMART_PALLET_PROPERTY);
    return smartPallet;
  }

  public GoodsRequest filterBySmartPallet(String... smartPallet) {
    if (isEmptyParam(smartPallet)) {
      throw new IllegalArgumentException("filterBySmartPallet(String... smartPallet)参数不能为空!");
    }
    return where(SMART_PALLET_PROPERTY, QueryOperator.IN, (Object[]) smartPallet);
  }

  public GoodsRequest filterBySmartPallet(
      SmartPalletRequest smartPallet, IDRefine<SmartPallet> idRefine) {
    smartPallet.unlimited();
    return addSearchCriteria(createSmartPalletCriteria(smartPallet, idRefine));
  }

  public SearchCriteria createSmartPalletCriteria(
      SmartPalletRequest smartPallet, IDRefine<SmartPallet> idRefine) {
    return new RefinedIdInCriteria(
        smartPallet, SMART_PALLET_PROPERTY, idRefine, SmartPallet.ID_PROPERTY);
  }

  public GoodsRequest selectSmartPallet() {
    return selectSmartPallet(SmartPalletRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectSmartPallet(SmartPalletRequest smartPallet) {
    selectParent(SMART_PALLET_PROPERTY, smartPallet);
    return this;
  }

  public GoodsRequest unselectSmartPallet() {
    unselectParent(SMART_PALLET_PROPERTY);
    return this;
  }

  public GoodsRequest groupBySmartPallet(SmartPalletRequest smartPallet) {
    groupBy(SMART_PALLET_PROPERTY, smartPallet);
    return this;
  }

  public GoodsRequest aggregateSmartPallet(SmartPalletRequest smartPallet) {
    aggregateParent(SMART_PALLET_PROPERTY, smartPallet);
    return this;
  }

  public GoodsRequest countSmartPallet() {
    return countSmartPallet("countSmartPallet");
  }

  public GoodsRequest countSmartPallet(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SMART_PALLET_PROPERTY);
  }

  public GoodsRequest groupBySmartPallet() {
    return groupBySmartPallet(SMART_PALLET_PROPERTY);
  }

  public GoodsRequest groupBySmartPallet(String ret) {
    return groupBy(ret, SMART_PALLET_PROPERTY);
  }

  public GoodsRequest whereSmartPalletIsNull() {
    return where(SMART_PALLET_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereSmartPalletIsNotNull() {
    return where(SMART_PALLET_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByShippingSpace(ShippingSpaceRequest shippingSpace) {
    return filterByShippingSpace(shippingSpace, ShippingSpace::getId);
  }

  public GoodsRequest filterByShippingSpace(ShippingSpace... shippingSpace) {
    if (isEmptyParam(shippingSpace)) {
      throw new IllegalArgumentException(
          "filterByShippingSpace(ShippingSpace... shippingSpace)参数不能为空!");
    }
    return where(SHIPPING_SPACE_PROPERTY, QueryOperator.IN, (Object[]) shippingSpace);
  }

  public GoodsRequest selectShippingSpaceId() {
    select(SHIPPING_SPACE_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest upToShippingSpace() {
    return upToShippingSpace(ShippingSpaceRequest.newInstance());
  }

  public ShippingSpaceRequest upToShippingSpace(ShippingSpaceRequest shippingSpace) {
    shippingSpace.aggregateChild(SHIPPING_SPACE_PROPERTY, this);
    this.groupByShippingSpace(shippingSpace);
    return shippingSpace;
  }

  public ShippingSpaceRequest endAtShippingSpace(String retName) {
    return endAtShippingSpace(retName, ShippingSpaceRequest.newInstance());
  }

  public ShippingSpaceRequest endAtShippingSpace(
      String retName, ShippingSpaceRequest shippingSpace) {
    shippingSpace.addDynamicProperty(retName, this, SHIPPING_SPACE_PROPERTY);
    return shippingSpace;
  }

  public GoodsRequest filterByShippingSpace(String... shippingSpace) {
    if (isEmptyParam(shippingSpace)) {
      throw new IllegalArgumentException("filterByShippingSpace(String... shippingSpace)参数不能为空!");
    }
    return where(SHIPPING_SPACE_PROPERTY, QueryOperator.IN, (Object[]) shippingSpace);
  }

  public GoodsRequest filterByShippingSpace(
      ShippingSpaceRequest shippingSpace, IDRefine<ShippingSpace> idRefine) {
    shippingSpace.unlimited();
    return addSearchCriteria(createShippingSpaceCriteria(shippingSpace, idRefine));
  }

  public SearchCriteria createShippingSpaceCriteria(
      ShippingSpaceRequest shippingSpace, IDRefine<ShippingSpace> idRefine) {
    return new RefinedIdInCriteria(
        shippingSpace, SHIPPING_SPACE_PROPERTY, idRefine, ShippingSpace.ID_PROPERTY);
  }

  public GoodsRequest selectShippingSpace() {
    return selectShippingSpace(ShippingSpaceRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectShippingSpace(ShippingSpaceRequest shippingSpace) {
    selectParent(SHIPPING_SPACE_PROPERTY, shippingSpace);
    return this;
  }

  public GoodsRequest unselectShippingSpace() {
    unselectParent(SHIPPING_SPACE_PROPERTY);
    return this;
  }

  public GoodsRequest groupByShippingSpace(ShippingSpaceRequest shippingSpace) {
    groupBy(SHIPPING_SPACE_PROPERTY, shippingSpace);
    return this;
  }

  public GoodsRequest aggregateShippingSpace(ShippingSpaceRequest shippingSpace) {
    aggregateParent(SHIPPING_SPACE_PROPERTY, shippingSpace);
    return this;
  }

  public GoodsRequest countShippingSpace() {
    return countShippingSpace("countShippingSpace");
  }

  public GoodsRequest countShippingSpace(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SHIPPING_SPACE_PROPERTY);
  }

  public GoodsRequest groupByShippingSpace() {
    return groupByShippingSpace(SHIPPING_SPACE_PROPERTY);
  }

  public GoodsRequest groupByShippingSpace(String ret) {
    return groupBy(ret, SHIPPING_SPACE_PROPERTY);
  }

  public GoodsRequest whereShippingSpaceIsNull() {
    return where(SHIPPING_SPACE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereShippingSpaceIsNotNull() {
    return where(SHIPPING_SPACE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByTransportTask(TransportTaskRequest transportTask) {
    return filterByTransportTask(transportTask, TransportTask::getId);
  }

  public GoodsRequest filterByTransportTask(TransportTask... transportTask) {
    if (isEmptyParam(transportTask)) {
      throw new IllegalArgumentException(
          "filterByTransportTask(TransportTask... transportTask)参数不能为空!");
    }
    return where(TRANSPORT_TASK_PROPERTY, QueryOperator.IN, (Object[]) transportTask);
  }

  public GoodsRequest selectTransportTaskId() {
    select(TRANSPORT_TASK_PROPERTY);
    return this;
  }

  public TransportTaskRequest upToTransportTask() {
    return upToTransportTask(TransportTaskRequest.newInstance());
  }

  public TransportTaskRequest upToTransportTask(TransportTaskRequest transportTask) {
    transportTask.aggregateChild(TRANSPORT_TASK_PROPERTY, this);
    this.groupByTransportTask(transportTask);
    return transportTask;
  }

  public TransportTaskRequest endAtTransportTask(String retName) {
    return endAtTransportTask(retName, TransportTaskRequest.newInstance());
  }

  public TransportTaskRequest endAtTransportTask(
      String retName, TransportTaskRequest transportTask) {
    transportTask.addDynamicProperty(retName, this, TRANSPORT_TASK_PROPERTY);
    return transportTask;
  }

  public GoodsRequest filterByTransportTask(String... transportTask) {
    if (isEmptyParam(transportTask)) {
      throw new IllegalArgumentException("filterByTransportTask(String... transportTask)参数不能为空!");
    }
    return where(TRANSPORT_TASK_PROPERTY, QueryOperator.IN, (Object[]) transportTask);
  }

  public GoodsRequest filterByTransportTask(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    transportTask.unlimited();
    return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
  }

  public SearchCriteria createTransportTaskCriteria(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    return new RefinedIdInCriteria(
        transportTask, TRANSPORT_TASK_PROPERTY, idRefine, TransportTask.ID_PROPERTY);
  }

  public GoodsRequest selectTransportTask() {
    return selectTransportTask(TransportTaskRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectTransportTask(TransportTaskRequest transportTask) {
    selectParent(TRANSPORT_TASK_PROPERTY, transportTask);
    return this;
  }

  public GoodsRequest unselectTransportTask() {
    unselectParent(TRANSPORT_TASK_PROPERTY);
    return this;
  }

  public GoodsRequest groupByTransportTask(TransportTaskRequest transportTask) {
    groupBy(TRANSPORT_TASK_PROPERTY, transportTask);
    return this;
  }

  public GoodsRequest aggregateTransportTask(TransportTaskRequest transportTask) {
    aggregateParent(TRANSPORT_TASK_PROPERTY, transportTask);
    return this;
  }

  public GoodsRequest countTransportTask() {
    return countTransportTask("countTransportTask");
  }

  public GoodsRequest countTransportTask(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TRANSPORT_TASK_PROPERTY);
  }

  public GoodsRequest groupByTransportTask() {
    return groupByTransportTask(TRANSPORT_TASK_PROPERTY);
  }

  public GoodsRequest groupByTransportTask(String ret) {
    return groupBy(ret, TRANSPORT_TASK_PROPERTY);
  }

  public GoodsRequest whereTransportTaskIsNull() {
    return where(TRANSPORT_TASK_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereTransportTaskIsNotNull() {
    return where(TRANSPORT_TASK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByRetailStore(RetailStoreRequest retailStore) {
    return filterByRetailStore(retailStore, RetailStore::getId);
  }

  public GoodsRequest filterByRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("filterByRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return where(RETAIL_STORE_PROPERTY, QueryOperator.IN, (Object[]) retailStore);
  }

  public GoodsRequest selectRetailStoreId() {
    select(RETAIL_STORE_PROPERTY);
    return this;
  }

  public RetailStoreRequest upToRetailStore() {
    return upToRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest upToRetailStore(RetailStoreRequest retailStore) {
    retailStore.aggregateChild(RETAIL_STORE_PROPERTY, this);
    this.groupByRetailStore(retailStore);
    return retailStore;
  }

  public RetailStoreRequest endAtRetailStore(String retName) {
    return endAtRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest endAtRetailStore(String retName, RetailStoreRequest retailStore) {
    retailStore.addDynamicProperty(retName, this, RETAIL_STORE_PROPERTY);
    return retailStore;
  }

  public GoodsRequest filterByRetailStore(String... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("filterByRetailStore(String... retailStore)参数不能为空!");
    }
    return where(RETAIL_STORE_PROPERTY, QueryOperator.IN, (Object[]) retailStore);
  }

  public GoodsRequest filterByRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, RETAIL_STORE_PROPERTY, idRefine, RetailStore.ID_PROPERTY);
  }

  public GoodsRequest selectRetailStore() {
    return selectRetailStore(RetailStoreRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectRetailStore(RetailStoreRequest retailStore) {
    selectParent(RETAIL_STORE_PROPERTY, retailStore);
    return this;
  }

  public GoodsRequest unselectRetailStore() {
    unselectParent(RETAIL_STORE_PROPERTY);
    return this;
  }

  public GoodsRequest groupByRetailStore(RetailStoreRequest retailStore) {
    groupBy(RETAIL_STORE_PROPERTY, retailStore);
    return this;
  }

  public GoodsRequest aggregateRetailStore(RetailStoreRequest retailStore) {
    aggregateParent(RETAIL_STORE_PROPERTY, retailStore);
    return this;
  }

  public GoodsRequest countRetailStore() {
    return countRetailStore("countRetailStore");
  }

  public GoodsRequest countRetailStore(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RETAIL_STORE_PROPERTY);
  }

  public GoodsRequest groupByRetailStore() {
    return groupByRetailStore(RETAIL_STORE_PROPERTY);
  }

  public GoodsRequest groupByRetailStore(String ret) {
    return groupBy(ret, RETAIL_STORE_PROPERTY);
  }

  public GoodsRequest whereRetailStoreIsNull() {
    return where(RETAIL_STORE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereRetailStoreIsNotNull() {
    return where(RETAIL_STORE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByBizOrder(SupplyOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, SupplyOrder::getId);
  }

  public GoodsRequest filterByBizOrder(SupplyOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(SupplyOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public GoodsRequest selectBizOrderId() {
    select(BIZ_ORDER_PROPERTY);
    return this;
  }

  public SupplyOrderRequest upToBizOrder() {
    return upToBizOrder(SupplyOrderRequest.newInstance());
  }

  public SupplyOrderRequest upToBizOrder(SupplyOrderRequest bizOrder) {
    bizOrder.aggregateChild(BIZ_ORDER_PROPERTY, this);
    this.groupByBizOrder(bizOrder);
    return bizOrder;
  }

  public SupplyOrderRequest endAtBizOrder(String retName) {
    return endAtBizOrder(retName, SupplyOrderRequest.newInstance());
  }

  public SupplyOrderRequest endAtBizOrder(String retName, SupplyOrderRequest bizOrder) {
    bizOrder.addDynamicProperty(retName, this, BIZ_ORDER_PROPERTY);
    return bizOrder;
  }

  public GoodsRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public GoodsRequest filterByBizOrder(
      SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
    return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine, SupplyOrder.ID_PROPERTY);
  }

  public GoodsRequest selectBizOrder() {
    return selectBizOrder(SupplyOrderRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectBizOrder(SupplyOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public GoodsRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public GoodsRequest groupByBizOrder(SupplyOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public GoodsRequest aggregateBizOrder(SupplyOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public GoodsRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public GoodsRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public GoodsRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public GoodsRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public GoodsRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest filterByRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
    return filterByRetailStoreOrder(retailStoreOrder, RetailStoreOrder::getId);
  }

  public GoodsRequest filterByRetailStoreOrder(RetailStoreOrder... retailStoreOrder) {
    if (isEmptyParam(retailStoreOrder)) {
      throw new IllegalArgumentException(
          "filterByRetailStoreOrder(RetailStoreOrder... retailStoreOrder)参数不能为空!");
    }
    return where(RETAIL_STORE_ORDER_PROPERTY, QueryOperator.IN, (Object[]) retailStoreOrder);
  }

  public GoodsRequest selectRetailStoreOrderId() {
    select(RETAIL_STORE_ORDER_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest upToRetailStoreOrder() {
    return upToRetailStoreOrder(RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreOrderRequest upToRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
    retailStoreOrder.aggregateChild(RETAIL_STORE_ORDER_PROPERTY, this);
    this.groupByRetailStoreOrder(retailStoreOrder);
    return retailStoreOrder;
  }

  public RetailStoreOrderRequest endAtRetailStoreOrder(String retName) {
    return endAtRetailStoreOrder(retName, RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreOrderRequest endAtRetailStoreOrder(
      String retName, RetailStoreOrderRequest retailStoreOrder) {
    retailStoreOrder.addDynamicProperty(retName, this, RETAIL_STORE_ORDER_PROPERTY);
    return retailStoreOrder;
  }

  public GoodsRequest filterByRetailStoreOrder(String... retailStoreOrder) {
    if (isEmptyParam(retailStoreOrder)) {
      throw new IllegalArgumentException(
          "filterByRetailStoreOrder(String... retailStoreOrder)参数不能为空!");
    }
    return where(RETAIL_STORE_ORDER_PROPERTY, QueryOperator.IN, (Object[]) retailStoreOrder);
  }

  public GoodsRequest filterByRetailStoreOrder(
      RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
    retailStoreOrder.unlimited();
    return addSearchCriteria(createRetailStoreOrderCriteria(retailStoreOrder, idRefine));
  }

  public SearchCriteria createRetailStoreOrderCriteria(
      RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreOrder, RETAIL_STORE_ORDER_PROPERTY, idRefine, RetailStoreOrder.ID_PROPERTY);
  }

  public GoodsRequest selectRetailStoreOrder() {
    return selectRetailStoreOrder(RetailStoreOrderRequest.newInstance().selectSelf());
  }

  public GoodsRequest selectRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
    selectParent(RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder);
    return this;
  }

  public GoodsRequest unselectRetailStoreOrder() {
    unselectParent(RETAIL_STORE_ORDER_PROPERTY);
    return this;
  }

  public GoodsRequest groupByRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
    groupBy(RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder);
    return this;
  }

  public GoodsRequest aggregateRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
    aggregateParent(RETAIL_STORE_ORDER_PROPERTY, retailStoreOrder);
    return this;
  }

  public GoodsRequest countRetailStoreOrder() {
    return countRetailStoreOrder("countRetailStoreOrder");
  }

  public GoodsRequest countRetailStoreOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RETAIL_STORE_ORDER_PROPERTY);
  }

  public GoodsRequest groupByRetailStoreOrder() {
    return groupByRetailStoreOrder(RETAIL_STORE_ORDER_PROPERTY);
  }

  public GoodsRequest groupByRetailStoreOrder(String ret) {
    return groupBy(ret, RETAIL_STORE_ORDER_PROPERTY);
  }

  public GoodsRequest whereRetailStoreOrderIsNull() {
    return where(RETAIL_STORE_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsRequest whereRetailStoreOrderIsNotNull() {
    return where(RETAIL_STORE_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsRequest hasGoodsMovement() {
    return hasGoodsMovement(GoodsMovementRequest.newInstance());
  }

  public GoodsRequest hasGoodsMovement(GoodsMovement... goodsMovement) {
    if (isEmptyParam(goodsMovement)) {
      throw new IllegalArgumentException("hasGoodsMovement(GoodsMovement... goodsMovement)参数不能为空!");
    }
    return hasGoodsMovement(
        Q.goodsMovement()
            .select(GoodsMovement.GOODS_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goodsMovement));
  }

  public GoodsRequest hasGoodsMovement(String... goodsMovement) {
    return hasGoodsMovement(
        Q.goodsMovement().select(GoodsMovement.GOODS_PROPERTY).filterById(goodsMovement));
  }

  public GoodsRequest hasGoodsMovement(GoodsMovementRequest goodsMovement) {
    return hasGoodsMovement(
        goodsMovement,
        $goodsMovement ->
            java.util.Optional.of($goodsMovement)
                .map(GoodsMovement::getGoods)
                .map(Goods::getId)
                .orElse(null));
  }

  public GoodsRequest hasGoodsMovement(
      GoodsMovementRequest goodsMovement, IDRefine<GoodsMovement> idRefine) {
    goodsMovement.select(GoodsMovement.GOODS_PROPERTY);
    goodsMovement.unlimited();
    return addSearchCriteria(createGoodsMovementCriteria(goodsMovement, idRefine));
  }

  public GoodsRequest hasGoodsMovement(
      GoodsMovementRequest goodsMovement, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goodsMovement, GoodsMovement.GOODS_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsMovementCriteria(
      GoodsMovementRequest goodsMovement, IDRefine<GoodsMovement> idRefine) {
    return new RefinedIdInCriteria(
        goodsMovement, ID_PROPERTY, idRefine, GoodsMovement.GOODS_PROPERTY);
  }

  public GoodsRequest selectGoodsMovementList(GoodsMovementRequest goodsMovement) {
    selectChild(GoodsMovement.GOODS_PROPERTY, goodsMovement);
    return this;
  }

  public GoodsRequest selectGoodsMovementList() {
    return selectGoodsMovementList(GoodsMovementRequest.newInstance().selectAll());
  }

  public GoodsRequest unselectGoodsMovementList() {
    unselectChild(GoodsMovement.GOODS_PROPERTY, GoodsMovement.class);
    return this;
  }

  public GoodsRequest aggregateGoodsMovementList(GoodsMovementRequest goodsMovement) {
    aggregateChild(GoodsMovement.GOODS_PROPERTY, goodsMovement);
    return this;
  }

  public GoodsRequest countGoodsMovement() {
    return countGoodsMovement("goodsMovementCount");
  }

  public GoodsRequest countGoodsMovement(String retName) {
    return countGoodsMovement(retName, GoodsMovementRequest.newInstance());
  }

  public GoodsRequest countGoodsMovement(GoodsMovementRequest goodsMovement) {
    return countGoodsMovement("goodsMovementCount", goodsMovement);
  }

  public GoodsRequest countGoodsMovement(String retName, GoodsMovementRequest goodsMovement) {
    goodsMovement.count();
    return statsFromGoodsMovement(retName, goodsMovement);
  }

  public GoodsRequest statsFromGoodsMovement(String retName, GoodsMovementRequest goodsMovement) {
    return addDynamicProperty(retName, goodsMovement, GoodsMovement.GOODS_PROPERTY);
  }

  public GoodsRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public GoodsRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public GoodsRequest unlimited() {
    super.unlimited();
    return this;
  }

  public GoodsRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
