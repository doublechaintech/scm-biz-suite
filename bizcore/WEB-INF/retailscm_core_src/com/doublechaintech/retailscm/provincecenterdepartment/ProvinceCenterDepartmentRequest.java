package com.doublechaintech.retailscm.provincecenterdepartment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment.*;

public class ProvinceCenterDepartmentRequest extends BaseRequest<ProvinceCenterDepartment> {
  public static ProvinceCenterDepartmentRequest newInstance() {
    return new ProvinceCenterDepartmentRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ProvinceCenterDepartmentRequest resultByClass(
      Class<? extends ProvinceCenterDepartment> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ProvinceCenterDepartmentRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ProvinceCenterDepartmentRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ProvinceCenterDepartment";
  }

  public ProvinceCenterDepartmentRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ProvinceCenterDepartmentRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ProvinceCenterDepartmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ProvinceCenterDepartmentRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ProvinceCenterDepartmentRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectFounded()
        .selectProvinceCenter()
        .selectManager()
        .selectVersion();
  }

  public ProvinceCenterDepartmentRequest selectAny() {
    return selectAll().selectProvinceCenterEmployeeList(Q.provinceCenterEmployee().selectSelf());
  }

  public ProvinceCenterDepartmentRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(PROVINCE_CENTER_PROPERTY);
    select(MANAGER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ProvinceCenterDepartmentRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ProvinceCenterDepartmentRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {FOUNDED_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    FOUNDED_PROPERTY,
    PROVINCE_CENTER_PROPERTY,
    MANAGER_PROPERTY,
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

  public ProvinceCenterDepartmentRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ProvinceCenterDepartmentRequest comment(String comment) {
    return this;
  }

  public ProvinceCenterDepartmentRequest enhance() {
    return this;
  }

  public ProvinceCenterDepartmentRequest overrideClass(
      Class<? extends ProvinceCenterDepartment> clazz) {
    return this;
  }

  public ProvinceCenterDepartmentRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ProvinceCenterDepartmentRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ProvinceCenterDepartmentRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ProvinceCenterDepartmentRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ProvinceCenterDepartmentRequest count() {
    return countId("count");
  }

  public static ProvinceCenterDepartmentRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ProvinceCenterDepartmentRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ProvinceCenterDepartmentRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterDepartmentRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterDepartmentRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ProvinceCenterDepartmentRequest countId() {
    return countId("countId");
  }

  public ProvinceCenterDepartmentRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest maxId() {
    return maxId("maxId");
  }

  public ProvinceCenterDepartmentRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest minId() {
    return minId("minId");
  }

  public ProvinceCenterDepartmentRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ProvinceCenterDepartmentRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ProvinceCenterDepartmentRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public ProvinceCenterDepartmentRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterDepartmentRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterDepartmentRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterDepartmentRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterDepartmentRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public ProvinceCenterDepartmentRequest countName() {
    return countName("countName");
  }

  public ProvinceCenterDepartmentRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest maxName() {
    return maxName("maxName");
  }

  public ProvinceCenterDepartmentRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest minName() {
    return minName("minName");
  }

  public ProvinceCenterDepartmentRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public ProvinceCenterDepartmentRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public ProvinceCenterDepartmentRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public ProvinceCenterDepartmentRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterDepartmentRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterDepartmentRequest whereFoundedBetween(Date foundedStart, Date foundedEnd) {
    if (ObjectUtil.isEmpty(foundedStart)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBetween, the parameter foundedStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(foundedEnd)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBetween, the parameter foundedEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.BETWEEN, new Object[] {foundedStart, foundedEnd});
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterDepartmentRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterDepartmentRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterDepartmentRequest filterByFounded(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterDepartmentRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterDepartmentRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public ProvinceCenterDepartmentRequest countFounded() {
    return countFounded("countFounded");
  }

  public ProvinceCenterDepartmentRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public ProvinceCenterDepartmentRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest minFounded() {
    return minFounded("minFounded");
  }

  public ProvinceCenterDepartmentRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public ProvinceCenterDepartmentRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public ProvinceCenterDepartmentRequest filterByManager(String manager) {

    if (manager == null) {
      return this;
    }

    return filterByManager(QueryOperator.EQUAL, manager);
  }

  public ProvinceCenterDepartmentRequest whereManagerIsNull() {
    return where(MANAGER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterDepartmentRequest whereManagerIsNotNull() {
    return where(MANAGER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterDepartmentRequest filterByManager(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getManagerSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterDepartmentRequest selectManager() {
    return select(MANAGER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest unselectManager() {
    return unselect(MANAGER_PROPERTY);
  }

  public SearchCriteria getManagerSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MANAGER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterDepartmentRequest orderByManager(boolean asc) {
    addOrderBy(MANAGER_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByManagerAscending() {
    addOrderBy(MANAGER_PROPERTY, true);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByManagerDescending() {
    addOrderBy(MANAGER_PROPERTY, false);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByManagerAscendingUsingGBK() {
    addOrderBy("convert(manager using gbk)", true);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByManagerDescendingUsingGBK() {
    addOrderBy("convert(manager using gbk)", false);
    return this;
  }

  public ProvinceCenterDepartmentRequest countManager() {
    return countManager("countManager");
  }

  public ProvinceCenterDepartmentRequest countManager(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MANAGER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest maxManager() {
    return maxManager("maxManager");
  }

  public ProvinceCenterDepartmentRequest maxManager(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MANAGER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest minManager() {
    return minManager("minManager");
  }

  public ProvinceCenterDepartmentRequest minManager(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MANAGER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByManager() {
    return groupByManager(MANAGER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByManager(String ret) {
    return groupBy(ret, MANAGER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByManager(SqlFunction func) {
    return groupByManager(MANAGER_PROPERTY, func);
  }

  public ProvinceCenterDepartmentRequest groupByManager(String ret, SqlFunction func) {
    super.groupBy(ret, func, MANAGER_PROPERTY);
    return this;
  }

  public ProvinceCenterDepartmentRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ProvinceCenterDepartmentRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterDepartmentRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterDepartmentRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterDepartmentRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterDepartmentRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ProvinceCenterDepartmentRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ProvinceCenterDepartmentRequest countVersion() {
    return countVersion("countVersion");
  }

  public ProvinceCenterDepartmentRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ProvinceCenterDepartmentRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest minVersion() {
    return minVersion("minVersion");
  }

  public ProvinceCenterDepartmentRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ProvinceCenterDepartmentRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ProvinceCenterDepartmentRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ProvinceCenterDepartmentRequest filterByProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    return filterByProvinceCenter(provinceCenter, RetailStoreProvinceCenter::getId);
  }

  public ProvinceCenterDepartmentRequest filterByProvinceCenter(
      RetailStoreProvinceCenter... provinceCenter) {
    if (isEmptyParam(provinceCenter)) {
      throw new IllegalArgumentException(
          "filterByProvinceCenter(RetailStoreProvinceCenter... provinceCenter)参数不能为空!");
    }
    return where(PROVINCE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) provinceCenter);
  }

  public ProvinceCenterDepartmentRequest selectProvinceCenterId() {
    select(PROVINCE_CENTER_PROPERTY);
    return this;
  }

  public RetailStoreProvinceCenterRequest upToProvinceCenter() {
    return upToProvinceCenter(RetailStoreProvinceCenterRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest upToProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    provinceCenter.aggregateChild(PROVINCE_CENTER_PROPERTY, this);
    this.groupByProvinceCenter(provinceCenter);
    return provinceCenter;
  }

  public RetailStoreProvinceCenterRequest endAtProvinceCenter(String retName) {
    return endAtProvinceCenter(retName, RetailStoreProvinceCenterRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest endAtProvinceCenter(
      String retName, RetailStoreProvinceCenterRequest provinceCenter) {
    provinceCenter.addDynamicProperty(retName, this, PROVINCE_CENTER_PROPERTY);
    return provinceCenter;
  }

  public ProvinceCenterDepartmentRequest filterByProvinceCenter(String... provinceCenter) {
    if (isEmptyParam(provinceCenter)) {
      throw new IllegalArgumentException("filterByProvinceCenter(String... provinceCenter)参数不能为空!");
    }
    return where(PROVINCE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) provinceCenter);
  }

  public ProvinceCenterDepartmentRequest filterByProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter,
      IDRefine<RetailStoreProvinceCenter> idRefine) {
    provinceCenter.unlimited();
    return addSearchCriteria(createProvinceCenterCriteria(provinceCenter, idRefine));
  }

  public SearchCriteria createProvinceCenterCriteria(
      RetailStoreProvinceCenterRequest provinceCenter,
      IDRefine<RetailStoreProvinceCenter> idRefine) {
    return new RefinedIdInCriteria(
        provinceCenter, PROVINCE_CENTER_PROPERTY, idRefine, RetailStoreProvinceCenter.ID_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest selectProvinceCenter() {
    return selectProvinceCenter(RetailStoreProvinceCenterRequest.newInstance().selectSelf());
  }

  public ProvinceCenterDepartmentRequest selectProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    selectParent(PROVINCE_CENTER_PROPERTY, provinceCenter);
    return this;
  }

  public ProvinceCenterDepartmentRequest unselectProvinceCenter() {
    unselectParent(PROVINCE_CENTER_PROPERTY);
    return this;
  }

  public ProvinceCenterDepartmentRequest groupByProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    groupBy(PROVINCE_CENTER_PROPERTY, provinceCenter);
    return this;
  }

  public ProvinceCenterDepartmentRequest aggregateProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    aggregateParent(PROVINCE_CENTER_PROPERTY, provinceCenter);
    return this;
  }

  public ProvinceCenterDepartmentRequest countProvinceCenter() {
    return countProvinceCenter("countProvinceCenter");
  }

  public ProvinceCenterDepartmentRequest countProvinceCenter(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PROVINCE_CENTER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByProvinceCenter() {
    return groupByProvinceCenter(PROVINCE_CENTER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest groupByProvinceCenter(String ret) {
    return groupBy(ret, PROVINCE_CENTER_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest whereProvinceCenterIsNull() {
    return where(PROVINCE_CENTER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterDepartmentRequest whereProvinceCenterIsNotNull() {
    return where(PROVINCE_CENTER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee() {
    return hasProvinceCenterEmployee(ProvinceCenterEmployeeRequest.newInstance());
  }

  public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee(
      ProvinceCenterEmployee... provinceCenterEmployee) {
    if (isEmptyParam(provinceCenterEmployee)) {
      throw new IllegalArgumentException(
          "hasProvinceCenterEmployee(ProvinceCenterEmployee... provinceCenterEmployee)参数不能为空!");
    }
    return hasProvinceCenterEmployee(
        Q.provinceCenterEmployee()
            .select(ProvinceCenterEmployee.DEPARTMENT_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) provinceCenterEmployee));
  }

  public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee(
      String... provinceCenterEmployee) {
    return hasProvinceCenterEmployee(
        Q.provinceCenterEmployee()
            .select(ProvinceCenterEmployee.DEPARTMENT_PROPERTY)
            .filterById(provinceCenterEmployee));
  }

  public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee(
      ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    return hasProvinceCenterEmployee(
        provinceCenterEmployee,
        $provinceCenterEmployee ->
            java.util.Optional.of($provinceCenterEmployee)
                .map(ProvinceCenterEmployee::getDepartment)
                .map(ProvinceCenterDepartment::getId)
                .orElse(null));
  }

  public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee(
      ProvinceCenterEmployeeRequest provinceCenterEmployee,
      IDRefine<ProvinceCenterEmployee> idRefine) {
    provinceCenterEmployee.select(ProvinceCenterEmployee.DEPARTMENT_PROPERTY);
    provinceCenterEmployee.unlimited();
    return addSearchCriteria(
        createProvinceCenterEmployeeCriteria(provinceCenterEmployee, idRefine));
  }

  public ProvinceCenterDepartmentRequest hasProvinceCenterEmployee(
      ProvinceCenterEmployeeRequest provinceCenterEmployee,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            provinceCenterEmployee,
            ProvinceCenterEmployee.DEPARTMENT_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createProvinceCenterEmployeeCriteria(
      ProvinceCenterEmployeeRequest provinceCenterEmployee,
      IDRefine<ProvinceCenterEmployee> idRefine) {
    return new RefinedIdInCriteria(
        provinceCenterEmployee, ID_PROPERTY, idRefine, ProvinceCenterEmployee.DEPARTMENT_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest selectProvinceCenterEmployeeList(
      ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    selectChild(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, provinceCenterEmployee);
    return this;
  }

  public ProvinceCenterDepartmentRequest selectProvinceCenterEmployeeList() {
    return selectProvinceCenterEmployeeList(
        ProvinceCenterEmployeeRequest.newInstance().selectAll());
  }

  public ProvinceCenterDepartmentRequest unselectProvinceCenterEmployeeList() {
    unselectChild(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, ProvinceCenterEmployee.class);
    return this;
  }

  public ProvinceCenterDepartmentRequest aggregateProvinceCenterEmployeeList(
      ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    aggregateChild(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, provinceCenterEmployee);
    return this;
  }

  public ProvinceCenterDepartmentRequest countProvinceCenterEmployee() {
    return countProvinceCenterEmployee("provinceCenterEmployeeCount");
  }

  public ProvinceCenterDepartmentRequest countProvinceCenterEmployee(String retName) {
    return countProvinceCenterEmployee(retName, ProvinceCenterEmployeeRequest.newInstance());
  }

  public ProvinceCenterDepartmentRequest countProvinceCenterEmployee(
      ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    return countProvinceCenterEmployee("provinceCenterEmployeeCount", provinceCenterEmployee);
  }

  public ProvinceCenterDepartmentRequest countProvinceCenterEmployee(
      String retName, ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    provinceCenterEmployee.count();
    return statsFromProvinceCenterEmployee(retName, provinceCenterEmployee);
  }

  public ProvinceCenterDepartmentRequest statsFromProvinceCenterEmployee(
      String retName, ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    return addDynamicProperty(
        retName, provinceCenterEmployee, ProvinceCenterEmployee.DEPARTMENT_PROPERTY);
  }

  public ProvinceCenterDepartmentRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ProvinceCenterDepartmentRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ProvinceCenterDepartmentRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ProvinceCenterDepartmentRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
