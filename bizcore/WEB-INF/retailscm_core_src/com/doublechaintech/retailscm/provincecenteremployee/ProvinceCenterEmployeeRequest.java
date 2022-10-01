package com.doublechaintech.retailscm.provincecenteremployee;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentRequest;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee.*;

public class ProvinceCenterEmployeeRequest extends BaseRequest<ProvinceCenterEmployee> {
  public static ProvinceCenterEmployeeRequest newInstance() {
    return new ProvinceCenterEmployeeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ProvinceCenterEmployeeRequest resultByClass(
      Class<? extends ProvinceCenterEmployee> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ProvinceCenterEmployeeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ProvinceCenterEmployeeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ProvinceCenterEmployee";
  }

  public ProvinceCenterEmployeeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ProvinceCenterEmployeeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ProvinceCenterEmployeeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ProvinceCenterEmployeeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ProvinceCenterEmployeeRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectMobile()
        .selectEmail()
        .selectFounded()
        .selectDepartment()
        .selectProvinceCenter()
        .selectVersion();
  }

  public ProvinceCenterEmployeeRequest selectAny() {
    return selectAll();
  }

  public ProvinceCenterEmployeeRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(MOBILE_PROPERTY);
    select(EMAIL_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(DEPARTMENT_PROPERTY);
    select(PROVINCE_CENTER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ProvinceCenterEmployeeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ProvinceCenterEmployeeRequest where(
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
    MOBILE_PROPERTY,
    EMAIL_PROPERTY,
    FOUNDED_PROPERTY,
    DEPARTMENT_PROPERTY,
    PROVINCE_CENTER_PROPERTY,
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

  public ProvinceCenterEmployeeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ProvinceCenterEmployeeRequest comment(String comment) {
    return this;
  }

  public ProvinceCenterEmployeeRequest enhance() {
    return this;
  }

  public ProvinceCenterEmployeeRequest overrideClass(
      Class<? extends ProvinceCenterEmployee> clazz) {
    return this;
  }

  public ProvinceCenterEmployeeRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ProvinceCenterEmployeeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ProvinceCenterEmployeeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ProvinceCenterEmployeeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ProvinceCenterEmployeeRequest count() {
    return countId("count");
  }

  public static ProvinceCenterEmployeeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ProvinceCenterEmployeeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ProvinceCenterEmployeeRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterEmployeeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterEmployeeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ProvinceCenterEmployeeRequest countId() {
    return countId("countId");
  }

  public ProvinceCenterEmployeeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest maxId() {
    return maxId("maxId");
  }

  public ProvinceCenterEmployeeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest minId() {
    return minId("minId");
  }

  public ProvinceCenterEmployeeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ProvinceCenterEmployeeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ProvinceCenterEmployeeRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public ProvinceCenterEmployeeRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterEmployeeRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterEmployeeRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterEmployeeRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterEmployeeRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public ProvinceCenterEmployeeRequest countName() {
    return countName("countName");
  }

  public ProvinceCenterEmployeeRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest maxName() {
    return maxName("maxName");
  }

  public ProvinceCenterEmployeeRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest minName() {
    return minName("minName");
  }

  public ProvinceCenterEmployeeRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public ProvinceCenterEmployeeRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public ProvinceCenterEmployeeRequest filterByMobile(String mobile) {

    if (mobile == null) {
      return this;
    }

    return filterByMobile(QueryOperator.EQUAL, mobile);
  }

  public ProvinceCenterEmployeeRequest whereMobileIsNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterEmployeeRequest whereMobileIsNotNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterEmployeeRequest filterByMobile(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterEmployeeRequest selectMobile() {
    return select(MOBILE_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest unselectMobile() {
    return unselect(MOBILE_PROPERTY);
  }

  public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterEmployeeRequest orderByMobile(boolean asc) {
    addOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByMobileAscending() {
    addOrderBy(MOBILE_PROPERTY, true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByMobileDescending() {
    addOrderBy(MOBILE_PROPERTY, false);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByMobileAscendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByMobileDescendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", false);
    return this;
  }

  public ProvinceCenterEmployeeRequest countMobile() {
    return countMobile("countMobile");
  }

  public ProvinceCenterEmployeeRequest countMobile(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest maxMobile() {
    return maxMobile("maxMobile");
  }

  public ProvinceCenterEmployeeRequest maxMobile(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOBILE_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest minMobile() {
    return minMobile("minMobile");
  }

  public ProvinceCenterEmployeeRequest minMobile(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOBILE_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByMobile() {
    return groupByMobile(MOBILE_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByMobile(String ret) {
    return groupBy(ret, MOBILE_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByMobile(SqlFunction func) {
    return groupByMobile(MOBILE_PROPERTY, func);
  }

  public ProvinceCenterEmployeeRequest groupByMobile(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOBILE_PROPERTY);
    return this;
  }

  public ProvinceCenterEmployeeRequest filterByEmail(String email) {

    if (email == null) {
      return this;
    }

    return filterByEmail(QueryOperator.EQUAL, email);
  }

  public ProvinceCenterEmployeeRequest whereEmailIsNull() {
    return where(EMAIL_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterEmployeeRequest whereEmailIsNotNull() {
    return where(EMAIL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterEmployeeRequest filterByEmail(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEmailSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterEmployeeRequest selectEmail() {
    return select(EMAIL_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest unselectEmail() {
    return unselect(EMAIL_PROPERTY);
  }

  public SearchCriteria getEmailSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(EMAIL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterEmployeeRequest orderByEmail(boolean asc) {
    addOrderBy(EMAIL_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByEmailAscending() {
    addOrderBy(EMAIL_PROPERTY, true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByEmailDescending() {
    addOrderBy(EMAIL_PROPERTY, false);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByEmailAscendingUsingGBK() {
    addOrderBy("convert(email using gbk)", true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByEmailDescendingUsingGBK() {
    addOrderBy("convert(email using gbk)", false);
    return this;
  }

  public ProvinceCenterEmployeeRequest countEmail() {
    return countEmail("countEmail");
  }

  public ProvinceCenterEmployeeRequest countEmail(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMAIL_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest maxEmail() {
    return maxEmail("maxEmail");
  }

  public ProvinceCenterEmployeeRequest maxEmail(String aggName) {
    return aggregate(aggName, AggFunc.MAX, EMAIL_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest minEmail() {
    return minEmail("minEmail");
  }

  public ProvinceCenterEmployeeRequest minEmail(String aggName) {
    return aggregate(aggName, AggFunc.MIN, EMAIL_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByEmail() {
    return groupByEmail(EMAIL_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByEmail(String ret) {
    return groupBy(ret, EMAIL_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByEmail(SqlFunction func) {
    return groupByEmail(EMAIL_PROPERTY, func);
  }

  public ProvinceCenterEmployeeRequest groupByEmail(String ret, SqlFunction func) {
    super.groupBy(ret, func, EMAIL_PROPERTY);
    return this;
  }

  public ProvinceCenterEmployeeRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public ProvinceCenterEmployeeRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterEmployeeRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterEmployeeRequest whereFoundedBetween(Date foundedStart, Date foundedEnd) {
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

  public ProvinceCenterEmployeeRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterEmployeeRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterEmployeeRequest filterByFounded(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterEmployeeRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterEmployeeRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public ProvinceCenterEmployeeRequest countFounded() {
    return countFounded("countFounded");
  }

  public ProvinceCenterEmployeeRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public ProvinceCenterEmployeeRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest minFounded() {
    return minFounded("minFounded");
  }

  public ProvinceCenterEmployeeRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public ProvinceCenterEmployeeRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public ProvinceCenterEmployeeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ProvinceCenterEmployeeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterEmployeeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterEmployeeRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ProvinceCenterEmployeeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ProvinceCenterEmployeeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ProvinceCenterEmployeeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ProvinceCenterEmployeeRequest countVersion() {
    return countVersion("countVersion");
  }

  public ProvinceCenterEmployeeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ProvinceCenterEmployeeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest minVersion() {
    return minVersion("minVersion");
  }

  public ProvinceCenterEmployeeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ProvinceCenterEmployeeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ProvinceCenterEmployeeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ProvinceCenterEmployeeRequest filterByDepartment(
      ProvinceCenterDepartmentRequest department) {
    return filterByDepartment(department, ProvinceCenterDepartment::getId);
  }

  public ProvinceCenterEmployeeRequest filterByDepartment(ProvinceCenterDepartment... department) {
    if (isEmptyParam(department)) {
      throw new IllegalArgumentException(
          "filterByDepartment(ProvinceCenterDepartment... department)参数不能为空!");
    }
    return where(DEPARTMENT_PROPERTY, QueryOperator.IN, (Object[]) department);
  }

  public ProvinceCenterEmployeeRequest selectDepartmentId() {
    select(DEPARTMENT_PROPERTY);
    return this;
  }

  public ProvinceCenterDepartmentRequest upToDepartment() {
    return upToDepartment(ProvinceCenterDepartmentRequest.newInstance());
  }

  public ProvinceCenterDepartmentRequest upToDepartment(
      ProvinceCenterDepartmentRequest department) {
    department.aggregateChild(DEPARTMENT_PROPERTY, this);
    this.groupByDepartment(department);
    return department;
  }

  public ProvinceCenterDepartmentRequest endAtDepartment(String retName) {
    return endAtDepartment(retName, ProvinceCenterDepartmentRequest.newInstance());
  }

  public ProvinceCenterDepartmentRequest endAtDepartment(
      String retName, ProvinceCenterDepartmentRequest department) {
    department.addDynamicProperty(retName, this, DEPARTMENT_PROPERTY);
    return department;
  }

  public ProvinceCenterEmployeeRequest filterByDepartment(String... department) {
    if (isEmptyParam(department)) {
      throw new IllegalArgumentException("filterByDepartment(String... department)参数不能为空!");
    }
    return where(DEPARTMENT_PROPERTY, QueryOperator.IN, (Object[]) department);
  }

  public ProvinceCenterEmployeeRequest filterByDepartment(
      ProvinceCenterDepartmentRequest department, IDRefine<ProvinceCenterDepartment> idRefine) {
    department.unlimited();
    return addSearchCriteria(createDepartmentCriteria(department, idRefine));
  }

  public SearchCriteria createDepartmentCriteria(
      ProvinceCenterDepartmentRequest department, IDRefine<ProvinceCenterDepartment> idRefine) {
    return new RefinedIdInCriteria(
        department, DEPARTMENT_PROPERTY, idRefine, ProvinceCenterDepartment.ID_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest selectDepartment() {
    return selectDepartment(ProvinceCenterDepartmentRequest.newInstance().selectSelf());
  }

  public ProvinceCenterEmployeeRequest selectDepartment(
      ProvinceCenterDepartmentRequest department) {
    selectParent(DEPARTMENT_PROPERTY, department);
    return this;
  }

  public ProvinceCenterEmployeeRequest unselectDepartment() {
    unselectParent(DEPARTMENT_PROPERTY);
    return this;
  }

  public ProvinceCenterEmployeeRequest groupByDepartment(
      ProvinceCenterDepartmentRequest department) {
    groupBy(DEPARTMENT_PROPERTY, department);
    return this;
  }

  public ProvinceCenterEmployeeRequest aggregateDepartment(
      ProvinceCenterDepartmentRequest department) {
    aggregateParent(DEPARTMENT_PROPERTY, department);
    return this;
  }

  public ProvinceCenterEmployeeRequest countDepartment() {
    return countDepartment("countDepartment");
  }

  public ProvinceCenterEmployeeRequest countDepartment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DEPARTMENT_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByDepartment() {
    return groupByDepartment(DEPARTMENT_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByDepartment(String ret) {
    return groupBy(ret, DEPARTMENT_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest whereDepartmentIsNull() {
    return where(DEPARTMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterEmployeeRequest whereDepartmentIsNotNull() {
    return where(DEPARTMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterEmployeeRequest filterByProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    return filterByProvinceCenter(provinceCenter, RetailStoreProvinceCenter::getId);
  }

  public ProvinceCenterEmployeeRequest filterByProvinceCenter(
      RetailStoreProvinceCenter... provinceCenter) {
    if (isEmptyParam(provinceCenter)) {
      throw new IllegalArgumentException(
          "filterByProvinceCenter(RetailStoreProvinceCenter... provinceCenter)参数不能为空!");
    }
    return where(PROVINCE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) provinceCenter);
  }

  public ProvinceCenterEmployeeRequest selectProvinceCenterId() {
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

  public ProvinceCenterEmployeeRequest filterByProvinceCenter(String... provinceCenter) {
    if (isEmptyParam(provinceCenter)) {
      throw new IllegalArgumentException("filterByProvinceCenter(String... provinceCenter)参数不能为空!");
    }
    return where(PROVINCE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) provinceCenter);
  }

  public ProvinceCenterEmployeeRequest filterByProvinceCenter(
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

  public ProvinceCenterEmployeeRequest selectProvinceCenter() {
    return selectProvinceCenter(RetailStoreProvinceCenterRequest.newInstance().selectSelf());
  }

  public ProvinceCenterEmployeeRequest selectProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    selectParent(PROVINCE_CENTER_PROPERTY, provinceCenter);
    return this;
  }

  public ProvinceCenterEmployeeRequest unselectProvinceCenter() {
    unselectParent(PROVINCE_CENTER_PROPERTY);
    return this;
  }

  public ProvinceCenterEmployeeRequest groupByProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    groupBy(PROVINCE_CENTER_PROPERTY, provinceCenter);
    return this;
  }

  public ProvinceCenterEmployeeRequest aggregateProvinceCenter(
      RetailStoreProvinceCenterRequest provinceCenter) {
    aggregateParent(PROVINCE_CENTER_PROPERTY, provinceCenter);
    return this;
  }

  public ProvinceCenterEmployeeRequest countProvinceCenter() {
    return countProvinceCenter("countProvinceCenter");
  }

  public ProvinceCenterEmployeeRequest countProvinceCenter(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PROVINCE_CENTER_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByProvinceCenter() {
    return groupByProvinceCenter(PROVINCE_CENTER_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest groupByProvinceCenter(String ret) {
    return groupBy(ret, PROVINCE_CENTER_PROPERTY);
  }

  public ProvinceCenterEmployeeRequest whereProvinceCenterIsNull() {
    return where(PROVINCE_CENTER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ProvinceCenterEmployeeRequest whereProvinceCenterIsNotNull() {
    return where(PROVINCE_CENTER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ProvinceCenterEmployeeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ProvinceCenterEmployeeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ProvinceCenterEmployeeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ProvinceCenterEmployeeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
