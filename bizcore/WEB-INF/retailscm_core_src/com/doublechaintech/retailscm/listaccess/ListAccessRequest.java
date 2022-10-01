package com.doublechaintech.retailscm.listaccess;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userapp.UserAppRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.listaccess.ListAccess.*;

public class ListAccessRequest extends BaseRequest<ListAccess> {
  public static ListAccessRequest newInstance() {
    return new ListAccessRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ListAccessRequest resultByClass(Class<? extends ListAccess> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ListAccessRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ListAccessRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ListAccess";
  }

  public ListAccessRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ListAccessRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ListAccessRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ListAccessRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ListAccessRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectInternalName()
        .selectReadPermission()
        .selectCreatePermission()
        .selectDeletePermission()
        .selectUpdatePermission()
        .selectExecutionPermission()
        .selectApp()
        .selectVersion();
  }

  public ListAccessRequest selectAny() {
    return selectAll();
  }

  public ListAccessRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(INTERNAL_NAME_PROPERTY);
    select(READ_PERMISSION_PROPERTY);
    select(CREATE_PERMISSION_PROPERTY);
    select(DELETE_PERMISSION_PROPERTY);
    select(UPDATE_PERMISSION_PROPERTY);
    select(EXECUTION_PERMISSION_PROPERTY);
    select(APP_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ListAccessRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ListAccessRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    INTERNAL_NAME_PROPERTY,
    READ_PERMISSION_PROPERTY,
    CREATE_PERMISSION_PROPERTY,
    DELETE_PERMISSION_PROPERTY,
    UPDATE_PERMISSION_PROPERTY,
    EXECUTION_PERMISSION_PROPERTY,
    APP_PROPERTY,
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

  public ListAccessRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ListAccessRequest comment(String comment) {
    return this;
  }

  public ListAccessRequest enhance() {
    return this;
  }

  public ListAccessRequest overrideClass(Class<? extends ListAccess> clazz) {
    return this;
  }

  public ListAccessRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ListAccessRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ListAccessRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ListAccessRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ListAccessRequest count() {
    return countId("count");
  }

  public static ListAccessRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ListAccessRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ListAccessRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ListAccessRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ListAccessRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ListAccessRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ListAccessRequest countId() {
    return countId("countId");
  }

  public ListAccessRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ListAccessRequest maxId() {
    return maxId("maxId");
  }

  public ListAccessRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ListAccessRequest minId() {
    return minId("minId");
  }

  public ListAccessRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ListAccessRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ListAccessRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ListAccessRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ListAccessRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public ListAccessRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public ListAccessRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public ListAccessRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public ListAccessRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public ListAccessRequest countName() {
    return countName("countName");
  }

  public ListAccessRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public ListAccessRequest maxName() {
    return maxName("maxName");
  }

  public ListAccessRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public ListAccessRequest minName() {
    return minName("minName");
  }

  public ListAccessRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public ListAccessRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public ListAccessRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public ListAccessRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public ListAccessRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByInternalName(String internalName) {

    if (internalName == null) {
      return this;
    }

    return filterByInternalName(QueryOperator.EQUAL, internalName);
  }

  public ListAccessRequest whereInternalNameIsNull() {
    return where(INTERNAL_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereInternalNameIsNotNull() {
    return where(INTERNAL_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest filterByInternalName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getInternalNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectInternalName() {
    return select(INTERNAL_NAME_PROPERTY);
  }

  public ListAccessRequest unselectInternalName() {
    return unselect(INTERNAL_NAME_PROPERTY);
  }

  public SearchCriteria getInternalNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(INTERNAL_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderByInternalName(boolean asc) {
    addOrderBy(INTERNAL_NAME_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByInternalNameAscending() {
    addOrderBy(INTERNAL_NAME_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByInternalNameDescending() {
    addOrderBy(INTERNAL_NAME_PROPERTY, false);
    return this;
  }

  public ListAccessRequest orderByInternalNameAscendingUsingGBK() {
    addOrderBy("convert(internalName using gbk)", true);
    return this;
  }

  public ListAccessRequest orderByInternalNameDescendingUsingGBK() {
    addOrderBy("convert(internalName using gbk)", false);
    return this;
  }

  public ListAccessRequest countInternalName() {
    return countInternalName("countInternalName");
  }

  public ListAccessRequest countInternalName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, INTERNAL_NAME_PROPERTY);
  }

  public ListAccessRequest maxInternalName() {
    return maxInternalName("maxInternalName");
  }

  public ListAccessRequest maxInternalName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, INTERNAL_NAME_PROPERTY);
  }

  public ListAccessRequest minInternalName() {
    return minInternalName("minInternalName");
  }

  public ListAccessRequest minInternalName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, INTERNAL_NAME_PROPERTY);
  }

  public ListAccessRequest groupByInternalName() {
    return groupByInternalName(INTERNAL_NAME_PROPERTY);
  }

  public ListAccessRequest groupByInternalName(String ret) {
    return groupBy(ret, INTERNAL_NAME_PROPERTY);
  }

  public ListAccessRequest groupByInternalName(SqlFunction func) {
    return groupByInternalName(INTERNAL_NAME_PROPERTY, func);
  }

  public ListAccessRequest groupByInternalName(String ret, SqlFunction func) {
    super.groupBy(ret, func, INTERNAL_NAME_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByReadPermission(boolean readPermission) {

    return filterByReadPermission(QueryOperator.EQUAL, readPermission);
  }

  public ListAccessRequest whereReadPermissionIsNull() {
    return where(READ_PERMISSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereReadPermissionIsNotNull() {
    return where(READ_PERMISSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest filterByReadPermission(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getReadPermissionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectReadPermission() {
    return select(READ_PERMISSION_PROPERTY);
  }

  public ListAccessRequest unselectReadPermission() {
    return unselect(READ_PERMISSION_PROPERTY);
  }

  public SearchCriteria getReadPermissionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(READ_PERMISSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderByReadPermission(boolean asc) {
    addOrderBy(READ_PERMISSION_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByReadPermissionAscending() {
    addOrderBy(READ_PERMISSION_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByReadPermissionDescending() {
    addOrderBy(READ_PERMISSION_PROPERTY, false);
    return this;
  }

  public ListAccessRequest countReadPermission() {
    return countReadPermission("countReadPermission");
  }

  public ListAccessRequest countReadPermission(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, READ_PERMISSION_PROPERTY);
  }

  public ListAccessRequest maxReadPermission() {
    return maxReadPermission("maxReadPermission");
  }

  public ListAccessRequest maxReadPermission(String aggName) {
    return aggregate(aggName, AggFunc.MAX, READ_PERMISSION_PROPERTY);
  }

  public ListAccessRequest minReadPermission() {
    return minReadPermission("minReadPermission");
  }

  public ListAccessRequest minReadPermission(String aggName) {
    return aggregate(aggName, AggFunc.MIN, READ_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByReadPermission() {
    return groupByReadPermission(READ_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByReadPermission(String ret) {
    return groupBy(ret, READ_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByReadPermission(SqlFunction func) {
    return groupByReadPermission(READ_PERMISSION_PROPERTY, func);
  }

  public ListAccessRequest groupByReadPermission(String ret, SqlFunction func) {
    super.groupBy(ret, func, READ_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByCreatePermission(boolean createPermission) {

    return filterByCreatePermission(QueryOperator.EQUAL, createPermission);
  }

  public ListAccessRequest whereCreatePermissionIsNull() {
    return where(CREATE_PERMISSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereCreatePermissionIsNotNull() {
    return where(CREATE_PERMISSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest filterByCreatePermission(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCreatePermissionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectCreatePermission() {
    return select(CREATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest unselectCreatePermission() {
    return unselect(CREATE_PERMISSION_PROPERTY);
  }

  public SearchCriteria getCreatePermissionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CREATE_PERMISSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderByCreatePermission(boolean asc) {
    addOrderBy(CREATE_PERMISSION_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByCreatePermissionAscending() {
    addOrderBy(CREATE_PERMISSION_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByCreatePermissionDescending() {
    addOrderBy(CREATE_PERMISSION_PROPERTY, false);
    return this;
  }

  public ListAccessRequest countCreatePermission() {
    return countCreatePermission("countCreatePermission");
  }

  public ListAccessRequest countCreatePermission(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CREATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest maxCreatePermission() {
    return maxCreatePermission("maxCreatePermission");
  }

  public ListAccessRequest maxCreatePermission(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CREATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest minCreatePermission() {
    return minCreatePermission("minCreatePermission");
  }

  public ListAccessRequest minCreatePermission(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CREATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByCreatePermission() {
    return groupByCreatePermission(CREATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByCreatePermission(String ret) {
    return groupBy(ret, CREATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByCreatePermission(SqlFunction func) {
    return groupByCreatePermission(CREATE_PERMISSION_PROPERTY, func);
  }

  public ListAccessRequest groupByCreatePermission(String ret, SqlFunction func) {
    super.groupBy(ret, func, CREATE_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByDeletePermission(boolean deletePermission) {

    return filterByDeletePermission(QueryOperator.EQUAL, deletePermission);
  }

  public ListAccessRequest whereDeletePermissionIsNull() {
    return where(DELETE_PERMISSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereDeletePermissionIsNotNull() {
    return where(DELETE_PERMISSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest filterByDeletePermission(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDeletePermissionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectDeletePermission() {
    return select(DELETE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest unselectDeletePermission() {
    return unselect(DELETE_PERMISSION_PROPERTY);
  }

  public SearchCriteria getDeletePermissionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DELETE_PERMISSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderByDeletePermission(boolean asc) {
    addOrderBy(DELETE_PERMISSION_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByDeletePermissionAscending() {
    addOrderBy(DELETE_PERMISSION_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByDeletePermissionDescending() {
    addOrderBy(DELETE_PERMISSION_PROPERTY, false);
    return this;
  }

  public ListAccessRequest countDeletePermission() {
    return countDeletePermission("countDeletePermission");
  }

  public ListAccessRequest countDeletePermission(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DELETE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest maxDeletePermission() {
    return maxDeletePermission("maxDeletePermission");
  }

  public ListAccessRequest maxDeletePermission(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DELETE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest minDeletePermission() {
    return minDeletePermission("minDeletePermission");
  }

  public ListAccessRequest minDeletePermission(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DELETE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByDeletePermission() {
    return groupByDeletePermission(DELETE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByDeletePermission(String ret) {
    return groupBy(ret, DELETE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByDeletePermission(SqlFunction func) {
    return groupByDeletePermission(DELETE_PERMISSION_PROPERTY, func);
  }

  public ListAccessRequest groupByDeletePermission(String ret, SqlFunction func) {
    super.groupBy(ret, func, DELETE_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByUpdatePermission(boolean updatePermission) {

    return filterByUpdatePermission(QueryOperator.EQUAL, updatePermission);
  }

  public ListAccessRequest whereUpdatePermissionIsNull() {
    return where(UPDATE_PERMISSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereUpdatePermissionIsNotNull() {
    return where(UPDATE_PERMISSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest filterByUpdatePermission(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getUpdatePermissionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectUpdatePermission() {
    return select(UPDATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest unselectUpdatePermission() {
    return unselect(UPDATE_PERMISSION_PROPERTY);
  }

  public SearchCriteria getUpdatePermissionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(UPDATE_PERMISSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderByUpdatePermission(boolean asc) {
    addOrderBy(UPDATE_PERMISSION_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByUpdatePermissionAscending() {
    addOrderBy(UPDATE_PERMISSION_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByUpdatePermissionDescending() {
    addOrderBy(UPDATE_PERMISSION_PROPERTY, false);
    return this;
  }

  public ListAccessRequest countUpdatePermission() {
    return countUpdatePermission("countUpdatePermission");
  }

  public ListAccessRequest countUpdatePermission(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, UPDATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest maxUpdatePermission() {
    return maxUpdatePermission("maxUpdatePermission");
  }

  public ListAccessRequest maxUpdatePermission(String aggName) {
    return aggregate(aggName, AggFunc.MAX, UPDATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest minUpdatePermission() {
    return minUpdatePermission("minUpdatePermission");
  }

  public ListAccessRequest minUpdatePermission(String aggName) {
    return aggregate(aggName, AggFunc.MIN, UPDATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByUpdatePermission() {
    return groupByUpdatePermission(UPDATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByUpdatePermission(String ret) {
    return groupBy(ret, UPDATE_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByUpdatePermission(SqlFunction func) {
    return groupByUpdatePermission(UPDATE_PERMISSION_PROPERTY, func);
  }

  public ListAccessRequest groupByUpdatePermission(String ret, SqlFunction func) {
    super.groupBy(ret, func, UPDATE_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByExecutionPermission(boolean executionPermission) {

    return filterByExecutionPermission(QueryOperator.EQUAL, executionPermission);
  }

  public ListAccessRequest whereExecutionPermissionIsNull() {
    return where(EXECUTION_PERMISSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereExecutionPermissionIsNotNull() {
    return where(EXECUTION_PERMISSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest filterByExecutionPermission(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getExecutionPermissionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectExecutionPermission() {
    return select(EXECUTION_PERMISSION_PROPERTY);
  }

  public ListAccessRequest unselectExecutionPermission() {
    return unselect(EXECUTION_PERMISSION_PROPERTY);
  }

  public SearchCriteria getExecutionPermissionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(EXECUTION_PERMISSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderByExecutionPermission(boolean asc) {
    addOrderBy(EXECUTION_PERMISSION_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByExecutionPermissionAscending() {
    addOrderBy(EXECUTION_PERMISSION_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByExecutionPermissionDescending() {
    addOrderBy(EXECUTION_PERMISSION_PROPERTY, false);
    return this;
  }

  public ListAccessRequest countExecutionPermission() {
    return countExecutionPermission("countExecutionPermission");
  }

  public ListAccessRequest countExecutionPermission(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EXECUTION_PERMISSION_PROPERTY);
  }

  public ListAccessRequest maxExecutionPermission() {
    return maxExecutionPermission("maxExecutionPermission");
  }

  public ListAccessRequest maxExecutionPermission(String aggName) {
    return aggregate(aggName, AggFunc.MAX, EXECUTION_PERMISSION_PROPERTY);
  }

  public ListAccessRequest minExecutionPermission() {
    return minExecutionPermission("minExecutionPermission");
  }

  public ListAccessRequest minExecutionPermission(String aggName) {
    return aggregate(aggName, AggFunc.MIN, EXECUTION_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByExecutionPermission() {
    return groupByExecutionPermission(EXECUTION_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByExecutionPermission(String ret) {
    return groupBy(ret, EXECUTION_PERMISSION_PROPERTY);
  }

  public ListAccessRequest groupByExecutionPermission(SqlFunction func) {
    return groupByExecutionPermission(EXECUTION_PERMISSION_PROPERTY, func);
  }

  public ListAccessRequest groupByExecutionPermission(String ret, SqlFunction func) {
    super.groupBy(ret, func, EXECUTION_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ListAccessRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ListAccessRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ListAccessRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ListAccessRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ListAccessRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ListAccessRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ListAccessRequest countVersion() {
    return countVersion("countVersion");
  }

  public ListAccessRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ListAccessRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ListAccessRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ListAccessRequest minVersion() {
    return minVersion("minVersion");
  }

  public ListAccessRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ListAccessRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ListAccessRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ListAccessRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ListAccessRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ListAccessRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ListAccessRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ListAccessRequest filterByApp(UserAppRequest app) {
    return filterByApp(app, UserApp::getId);
  }

  public ListAccessRequest filterByApp(UserApp... app) {
    if (isEmptyParam(app)) {
      throw new IllegalArgumentException("filterByApp(UserApp... app)参数不能为空!");
    }
    return where(APP_PROPERTY, QueryOperator.IN, (Object[]) app);
  }

  public ListAccessRequest selectAppId() {
    select(APP_PROPERTY);
    return this;
  }

  public UserAppRequest upToApp() {
    return upToApp(UserAppRequest.newInstance());
  }

  public UserAppRequest upToApp(UserAppRequest app) {
    app.aggregateChild(APP_PROPERTY, this);
    this.groupByApp(app);
    return app;
  }

  public UserAppRequest endAtApp(String retName) {
    return endAtApp(retName, UserAppRequest.newInstance());
  }

  public UserAppRequest endAtApp(String retName, UserAppRequest app) {
    app.addDynamicProperty(retName, this, APP_PROPERTY);
    return app;
  }

  public ListAccessRequest filterByApp(String... app) {
    if (isEmptyParam(app)) {
      throw new IllegalArgumentException("filterByApp(String... app)参数不能为空!");
    }
    return where(APP_PROPERTY, QueryOperator.IN, (Object[]) app);
  }

  public ListAccessRequest filterByApp(UserAppRequest app, IDRefine<UserApp> idRefine) {
    app.unlimited();
    return addSearchCriteria(createAppCriteria(app, idRefine));
  }

  public SearchCriteria createAppCriteria(UserAppRequest app, IDRefine<UserApp> idRefine) {
    return new RefinedIdInCriteria(app, APP_PROPERTY, idRefine, UserApp.ID_PROPERTY);
  }

  public ListAccessRequest selectApp() {
    return selectApp(UserAppRequest.newInstance().selectSelf());
  }

  public ListAccessRequest selectApp(UserAppRequest app) {
    selectParent(APP_PROPERTY, app);
    return this;
  }

  public ListAccessRequest unselectApp() {
    unselectParent(APP_PROPERTY);
    return this;
  }

  public ListAccessRequest groupByApp(UserAppRequest app) {
    groupBy(APP_PROPERTY, app);
    return this;
  }

  public ListAccessRequest aggregateApp(UserAppRequest app) {
    aggregateParent(APP_PROPERTY, app);
    return this;
  }

  public ListAccessRequest countApp() {
    return countApp("countApp");
  }

  public ListAccessRequest countApp(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, APP_PROPERTY);
  }

  public ListAccessRequest groupByApp() {
    return groupByApp(APP_PROPERTY);
  }

  public ListAccessRequest groupByApp(String ret) {
    return groupBy(ret, APP_PROPERTY);
  }

  public ListAccessRequest whereAppIsNull() {
    return where(APP_PROPERTY, QueryOperator.IS_NULL);
  }

  public ListAccessRequest whereAppIsNotNull() {
    return where(APP_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ListAccessRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ListAccessRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ListAccessRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ListAccessRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
