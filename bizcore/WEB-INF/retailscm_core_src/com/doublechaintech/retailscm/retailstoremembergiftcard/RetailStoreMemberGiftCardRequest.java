package com.doublechaintech.retailscm.retailstoremembergiftcard;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard.*;

public class RetailStoreMemberGiftCardRequest extends BaseRequest<RetailStoreMemberGiftCard> {
  public static RetailStoreMemberGiftCardRequest newInstance() {
    return new RetailStoreMemberGiftCardRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreMemberGiftCardRequest resultByClass(
      Class<? extends RetailStoreMemberGiftCard> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreMemberGiftCardRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreMemberGiftCardRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreMemberGiftCard";
  }

  public RetailStoreMemberGiftCardRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreMemberGiftCardRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreMemberGiftCardRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreMemberGiftCardRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreMemberGiftCardRequest selectAll() {
    return this.selectId().selectName().selectOwner().selectNumber().selectRemain().selectVersion();
  }

  public RetailStoreMemberGiftCardRequest selectAny() {
    return selectAll()
        .selectRetailStoreMemberGiftCardConsumeRecordList(
            Q.retailStoreMemberGiftCardConsumeRecord().selectSelf());
  }

  public RetailStoreMemberGiftCardRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(OWNER_PROPERTY);
    select(NUMBER_PROPERTY);
    select(REMAIN_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreMemberGiftCardRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreMemberGiftCardRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, OWNER_PROPERTY, NUMBER_PROPERTY, REMAIN_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public RetailStoreMemberGiftCardRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreMemberGiftCardRequest comment(String comment) {
    return this;
  }

  public RetailStoreMemberGiftCardRequest enhance() {
    return this;
  }

  public RetailStoreMemberGiftCardRequest overrideClass(
      Class<? extends RetailStoreMemberGiftCard> clazz) {
    return this;
  }

  public RetailStoreMemberGiftCardRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreMemberGiftCardRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreMemberGiftCardRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreMemberGiftCardRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreMemberGiftCardRequest count() {
    return countId("count");
  }

  public static RetailStoreMemberGiftCardRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreMemberGiftCardRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreMemberGiftCardRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreMemberGiftCardRequest countId() {
    return countId("countId");
  }

  public RetailStoreMemberGiftCardRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreMemberGiftCardRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest minId() {
    return minId("minId");
  }

  public RetailStoreMemberGiftCardRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreMemberGiftCardRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreMemberGiftCardRequest countName() {
    return countName("countName");
  }

  public RetailStoreMemberGiftCardRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreMemberGiftCardRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest minName() {
    return minName("minName");
  }

  public RetailStoreMemberGiftCardRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardRequest filterByNumber(String number) {

    if (number == null) {
      return this;
    }

    return filterByNumber(QueryOperator.EQUAL, number);
  }

  public RetailStoreMemberGiftCardRequest whereNumberIsNull() {
    return where(NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardRequest whereNumberIsNotNull() {
    return where(NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardRequest filterByNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardRequest selectNumber() {
    return select(NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest unselectNumber() {
    return unselect(NUMBER_PROPERTY);
  }

  public SearchCriteria getNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardRequest orderByNumber(boolean asc) {
    addOrderBy(NUMBER_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByNumberAscending() {
    addOrderBy(NUMBER_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByNumberDescending() {
    addOrderBy(NUMBER_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByNumberAscendingUsingGBK() {
    addOrderBy("convert(number using gbk)", true);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByNumberDescendingUsingGBK() {
    addOrderBy("convert(number using gbk)", false);
    return this;
  }

  public RetailStoreMemberGiftCardRequest countNumber() {
    return countNumber("countNumber");
  }

  public RetailStoreMemberGiftCardRequest countNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest maxNumber() {
    return maxNumber("maxNumber");
  }

  public RetailStoreMemberGiftCardRequest maxNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest minNumber() {
    return minNumber("minNumber");
  }

  public RetailStoreMemberGiftCardRequest minNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByNumber() {
    return groupByNumber(NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByNumber(String ret) {
    return groupBy(ret, NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByNumber(SqlFunction func) {
    return groupByNumber(NUMBER_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardRequest groupByNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, NUMBER_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardRequest filterByRemain(BigDecimal remain) {

    if (remain == null) {
      return this;
    }

    return filterByRemain(QueryOperator.EQUAL, remain);
  }

  public RetailStoreMemberGiftCardRequest whereRemainIsNull() {
    return where(REMAIN_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardRequest whereRemainIsNotNull() {
    return where(REMAIN_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardRequest whereRemainBetween(
      BigDecimal remainStart, BigDecimal remainEnd) {
    if (ObjectUtil.isEmpty(remainStart)) {
      throw new IllegalArgumentException(
          "Method whereRemainBetween, the parameter remainStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(remainEnd)) {
      throw new IllegalArgumentException(
          "Method whereRemainBetween, the parameter remainEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRemainSearchCriteria(QueryOperator.BETWEEN, new Object[] {remainStart, remainEnd});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardRequest whereRemainLessThan(BigDecimal remain) {
    if (ObjectUtil.isEmpty(remain)) {
      throw new IllegalArgumentException(
          "Method whereRemainLessThan, the parameter remain is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRemainSearchCriteria(QueryOperator.LESS_THAN, new Object[] {remain});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardRequest whereRemainGreaterThan(BigDecimal remain) {
    if (ObjectUtil.isEmpty(remain)) {
      throw new IllegalArgumentException(
          "Method whereRemainGreaterThan, the parameter remain is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRemainSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {remain});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardRequest filterByRemain(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRemainSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardRequest selectRemain() {
    return select(REMAIN_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest unselectRemain() {
    return unselect(REMAIN_PROPERTY);
  }

  public SearchCriteria getRemainSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REMAIN_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardRequest orderByRemain(boolean asc) {
    addOrderBy(REMAIN_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByRemainAscending() {
    addOrderBy(REMAIN_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByRemainDescending() {
    addOrderBy(REMAIN_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardRequest countRemain() {
    return countRemain("countRemain");
  }

  public RetailStoreMemberGiftCardRequest countRemain(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REMAIN_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest maxRemain() {
    return maxRemain("maxRemain");
  }

  public RetailStoreMemberGiftCardRequest maxRemain(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REMAIN_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest minRemain() {
    return minRemain("minRemain");
  }

  public RetailStoreMemberGiftCardRequest minRemain(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REMAIN_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest sumRemain() {
    return sumRemain("sumRemain");
  }

  public RetailStoreMemberGiftCardRequest sumRemain(String aggName) {
    return aggregate(aggName, AggFunc.SUM, REMAIN_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByRemain() {
    return groupByRemain(REMAIN_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByRemain(String ret) {
    return groupBy(ret, REMAIN_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByRemain(SqlFunction func) {
    return groupByRemain(REMAIN_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardRequest groupByRemain(String ret, SqlFunction func) {
    super.groupBy(ret, func, REMAIN_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreMemberGiftCardRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreMemberGiftCardRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreMemberGiftCardRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreMemberGiftCardRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreMemberGiftCardRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardRequest filterByOwner(RetailStoreMemberRequest owner) {
    return filterByOwner(owner, RetailStoreMember::getId);
  }

  public RetailStoreMemberGiftCardRequest filterByOwner(RetailStoreMember... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreMember... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberGiftCardRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberRequest upToOwner() {
    return upToOwner(RetailStoreMemberRequest.newInstance());
  }

  public RetailStoreMemberRequest upToOwner(RetailStoreMemberRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public RetailStoreMemberRequest endAtOwner(String retName) {
    return endAtOwner(retName, RetailStoreMemberRequest.newInstance());
  }

  public RetailStoreMemberRequest endAtOwner(String retName, RetailStoreMemberRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public RetailStoreMemberGiftCardRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberGiftCardRequest filterByOwner(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, RetailStoreMember.ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest selectOwner() {
    return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
  }

  public RetailStoreMemberGiftCardRequest selectOwner(RetailStoreMemberRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberGiftCardRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardRequest groupByOwner(RetailStoreMemberRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberGiftCardRequest aggregateOwner(RetailStoreMemberRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberGiftCardRequest countOwner() {
    return countOwner("countOwner");
  }

  public RetailStoreMemberGiftCardRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord() {
    return hasRetailStoreMemberGiftCardConsumeRecord(
        RetailStoreMemberGiftCardConsumeRecordRequest.newInstance());
  }

  public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecord... retailStoreMemberGiftCardConsumeRecord) {
    if (isEmptyParam(retailStoreMemberGiftCardConsumeRecord)) {
      throw new IllegalArgumentException(
          "hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord... retailStoreMemberGiftCardConsumeRecord)参数不能为空!");
    }
    return hasRetailStoreMemberGiftCardConsumeRecord(
        Q.retailStoreMemberGiftCardConsumeRecord()
            .select(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreMemberGiftCardConsumeRecord));
  }

  public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord(
      String... retailStoreMemberGiftCardConsumeRecord) {
    return hasRetailStoreMemberGiftCardConsumeRecord(
        Q.retailStoreMemberGiftCardConsumeRecord()
            .select(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY)
            .filterById(retailStoreMemberGiftCardConsumeRecord));
  }

  public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    return hasRetailStoreMemberGiftCardConsumeRecord(
        retailStoreMemberGiftCardConsumeRecord,
        $retailStoreMemberGiftCardConsumeRecord ->
            java.util.Optional.of($retailStoreMemberGiftCardConsumeRecord)
                .map(RetailStoreMemberGiftCardConsumeRecord::getOwner)
                .map(RetailStoreMemberGiftCard::getId)
                .orElse(null));
  }

  public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord,
      IDRefine<RetailStoreMemberGiftCardConsumeRecord> idRefine) {
    retailStoreMemberGiftCardConsumeRecord.select(
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY);
    retailStoreMemberGiftCardConsumeRecord.unlimited();
    return addSearchCriteria(
        createRetailStoreMemberGiftCardConsumeRecordCriteria(
            retailStoreMemberGiftCardConsumeRecord, idRefine));
  }

  public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreMemberGiftCardConsumeRecord,
            RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreMemberGiftCardConsumeRecordCriteria(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord,
      IDRefine<RetailStoreMemberGiftCardConsumeRecord> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreMemberGiftCardConsumeRecord,
        ID_PROPERTY,
        idRefine,
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest selectRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    selectChild(
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY,
        retailStoreMemberGiftCardConsumeRecord);
    return this;
  }

  public RetailStoreMemberGiftCardRequest selectRetailStoreMemberGiftCardConsumeRecordList() {
    return selectRetailStoreMemberGiftCardConsumeRecordList(
        RetailStoreMemberGiftCardConsumeRecordRequest.newInstance().selectAll());
  }

  public RetailStoreMemberGiftCardRequest unselectRetailStoreMemberGiftCardConsumeRecordList() {
    unselectChild(
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY,
        RetailStoreMemberGiftCardConsumeRecord.class);
    return this;
  }

  public RetailStoreMemberGiftCardRequest aggregateRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    aggregateChild(
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY,
        retailStoreMemberGiftCardConsumeRecord);
    return this;
  }

  public RetailStoreMemberGiftCardRequest countRetailStoreMemberGiftCardConsumeRecord() {
    return countRetailStoreMemberGiftCardConsumeRecord(
        "retailStoreMemberGiftCardConsumeRecordCount");
  }

  public RetailStoreMemberGiftCardRequest countRetailStoreMemberGiftCardConsumeRecord(
      String retName) {
    return countRetailStoreMemberGiftCardConsumeRecord(
        retName, RetailStoreMemberGiftCardConsumeRecordRequest.newInstance());
  }

  public RetailStoreMemberGiftCardRequest countRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    return countRetailStoreMemberGiftCardConsumeRecord(
        "retailStoreMemberGiftCardConsumeRecordCount", retailStoreMemberGiftCardConsumeRecord);
  }

  public RetailStoreMemberGiftCardRequest countRetailStoreMemberGiftCardConsumeRecord(
      String retName,
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    retailStoreMemberGiftCardConsumeRecord.count();
    return statsFromRetailStoreMemberGiftCardConsumeRecord(
        retName, retailStoreMemberGiftCardConsumeRecord);
  }

  public RetailStoreMemberGiftCardRequest statsFromRetailStoreMemberGiftCardConsumeRecord(
      String retName,
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    return addDynamicProperty(
        retName,
        retailStoreMemberGiftCardConsumeRecord,
        RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY);
  }

  public RetailStoreMemberGiftCardRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreMemberGiftCardRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreMemberGiftCardRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreMemberGiftCardRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
