package com.doublechaintech.retailscm.retailstore;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import java.util.Date;

import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationRequest;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationRequest;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingRequest;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationRequest;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningRequest;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstore.RetailStore.*;

public class RetailStoreRequest extends BaseRequest<RetailStore> {
  public static RetailStoreRequest newInstance() {
    return new RetailStoreRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreRequest resultByClass(Class<? extends RetailStore> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStore";
  }

  public RetailStoreRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectTelephone()
        .selectOwner()
        .selectRetailStoreCountryCenter()
        .selectCityServiceCenter()
        .selectCreation()
        .selectInvestmentInvitation()
        .selectFranchising()
        .selectDecoration()
        .selectOpening()
        .selectClosing()
        .selectFounded()
        .selectLatitude()
        .selectLongitude()
        .selectDescription()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public RetailStoreRequest selectAny() {
    return selectAll()
        .selectConsumerOrderList(Q.consumerOrder().selectSelf())
        .selectRetailStoreOrderList(Q.retailStoreOrder().selectSelf())
        .selectGoodsList(Q.goods().selectSelf())
        .selectTransportTaskList(Q.transportTask().selectSelf())
        .selectAccountSetList(Q.accountSet().selectSelf());
  }

  public RetailStoreRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(TELEPHONE_PROPERTY);
    select(OWNER_PROPERTY);
    select(RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
    select(CITY_SERVICE_CENTER_PROPERTY);
    select(CREATION_PROPERTY);
    select(INVESTMENT_INVITATION_PROPERTY);
    select(FRANCHISING_PROPERTY);
    select(DECORATION_PROPERTY);
    select(OPENING_PROPERTY);
    select(CLOSING_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {
    FOUNDED_PROPERTY, LAST_UPDATE_TIME_PROPERTY
  };
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    TELEPHONE_PROPERTY,
    OWNER_PROPERTY,
    RETAIL_STORE_COUNTRY_CENTER_PROPERTY,
    CITY_SERVICE_CENTER_PROPERTY,
    CREATION_PROPERTY,
    INVESTMENT_INVITATION_PROPERTY,
    FRANCHISING_PROPERTY,
    DECORATION_PROPERTY,
    OPENING_PROPERTY,
    CLOSING_PROPERTY,
    FOUNDED_PROPERTY,
    LATITUDE_PROPERTY,
    LONGITUDE_PROPERTY,
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

  public RetailStoreRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreRequest comment(String comment) {
    return this;
  }

  public RetailStoreRequest enhance() {
    return this;
  }

  public RetailStoreRequest overrideClass(Class<? extends RetailStore> clazz) {
    return this;
  }

  public RetailStoreRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreRequest count() {
    return countId("count");
  }

  public static RetailStoreRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreRequest countId() {
    return countId("countId");
  }

  public RetailStoreRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreRequest minId() {
    return minId("minId");
  }

  public RetailStoreRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreRequest countName() {
    return countName("countName");
  }

  public RetailStoreRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreRequest minName() {
    return minName("minName");
  }

  public RetailStoreRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByTelephone(String telephone) {

    if (telephone == null) {
      return this;
    }

    return filterByTelephone(QueryOperator.EQUAL, telephone);
  }

  public RetailStoreRequest whereTelephoneIsNull() {
    return where(TELEPHONE_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereTelephoneIsNotNull() {
    return where(TELEPHONE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByTelephone(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTelephoneSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectTelephone() {
    return select(TELEPHONE_PROPERTY);
  }

  public RetailStoreRequest unselectTelephone() {
    return unselect(TELEPHONE_PROPERTY);
  }

  public SearchCriteria getTelephoneSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TELEPHONE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByTelephone(boolean asc) {
    addOrderBy(TELEPHONE_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByTelephoneAscending() {
    addOrderBy(TELEPHONE_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByTelephoneDescending() {
    addOrderBy(TELEPHONE_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest orderByTelephoneAscendingUsingGBK() {
    addOrderBy("convert(telephone using gbk)", true);
    return this;
  }

  public RetailStoreRequest orderByTelephoneDescendingUsingGBK() {
    addOrderBy("convert(telephone using gbk)", false);
    return this;
  }

  public RetailStoreRequest countTelephone() {
    return countTelephone("countTelephone");
  }

  public RetailStoreRequest countTelephone(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TELEPHONE_PROPERTY);
  }

  public RetailStoreRequest maxTelephone() {
    return maxTelephone("maxTelephone");
  }

  public RetailStoreRequest maxTelephone(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TELEPHONE_PROPERTY);
  }

  public RetailStoreRequest minTelephone() {
    return minTelephone("minTelephone");
  }

  public RetailStoreRequest minTelephone(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TELEPHONE_PROPERTY);
  }

  public RetailStoreRequest groupByTelephone() {
    return groupByTelephone(TELEPHONE_PROPERTY);
  }

  public RetailStoreRequest groupByTelephone(String ret) {
    return groupBy(ret, TELEPHONE_PROPERTY);
  }

  public RetailStoreRequest groupByTelephone(SqlFunction func) {
    return groupByTelephone(TELEPHONE_PROPERTY, func);
  }

  public RetailStoreRequest groupByTelephone(String ret, SqlFunction func) {
    super.groupBy(ret, func, TELEPHONE_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByOwner(String owner) {

    if (owner == null) {
      return this;
    }

    return filterByOwner(QueryOperator.EQUAL, owner);
  }

  public RetailStoreRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByOwner(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getOwnerSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectOwner() {
    return select(OWNER_PROPERTY);
  }

  public RetailStoreRequest unselectOwner() {
    return unselect(OWNER_PROPERTY);
  }

  public SearchCriteria getOwnerSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(OWNER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByOwner(boolean asc) {
    addOrderBy(OWNER_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByOwnerAscending() {
    addOrderBy(OWNER_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByOwnerDescending() {
    addOrderBy(OWNER_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest orderByOwnerAscendingUsingGBK() {
    addOrderBy("convert(owner using gbk)", true);
    return this;
  }

  public RetailStoreRequest orderByOwnerDescendingUsingGBK() {
    addOrderBy("convert(owner using gbk)", false);
    return this;
  }

  public RetailStoreRequest countOwner() {
    return countOwner("countOwner");
  }

  public RetailStoreRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public RetailStoreRequest maxOwner() {
    return maxOwner("maxOwner");
  }

  public RetailStoreRequest maxOwner(String aggName) {
    return aggregate(aggName, AggFunc.MAX, OWNER_PROPERTY);
  }

  public RetailStoreRequest minOwner() {
    return minOwner("minOwner");
  }

  public RetailStoreRequest minOwner(String aggName) {
    return aggregate(aggName, AggFunc.MIN, OWNER_PROPERTY);
  }

  public RetailStoreRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public RetailStoreRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public RetailStoreRequest groupByOwner(SqlFunction func) {
    return groupByOwner(OWNER_PROPERTY, func);
  }

  public RetailStoreRequest groupByOwner(String ret, SqlFunction func) {
    super.groupBy(ret, func, OWNER_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public RetailStoreRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest whereFoundedBetween(Date foundedStart, Date foundedEnd) {
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

  public RetailStoreRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public RetailStoreRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest countFounded() {
    return countFounded("countFounded");
  }

  public RetailStoreRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public RetailStoreRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public RetailStoreRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public RetailStoreRequest minFounded() {
    return minFounded("minFounded");
  }

  public RetailStoreRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public RetailStoreRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public RetailStoreRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public RetailStoreRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public RetailStoreRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public RetailStoreRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest whereLatitudeBetween(BigDecimal latitudeStart, BigDecimal latitudeEnd) {
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

  public RetailStoreRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public RetailStoreRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public RetailStoreRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public RetailStoreRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public RetailStoreRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public RetailStoreRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public RetailStoreRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public RetailStoreRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public RetailStoreRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public RetailStoreRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public RetailStoreRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public RetailStoreRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public RetailStoreRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public RetailStoreRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest whereLongitudeBetween(
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

  public RetailStoreRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public RetailStoreRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public RetailStoreRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public RetailStoreRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public RetailStoreRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public RetailStoreRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public RetailStoreRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public RetailStoreRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public RetailStoreRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public RetailStoreRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public RetailStoreRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public RetailStoreRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public RetailStoreRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public RetailStoreRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public RetailStoreRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public RetailStoreRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public RetailStoreRequest countDescription() {
    return countDescription("countDescription");
  }

  public RetailStoreRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public RetailStoreRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public RetailStoreRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public RetailStoreRequest minDescription() {
    return minDescription("minDescription");
  }

  public RetailStoreRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public RetailStoreRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public RetailStoreRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public RetailStoreRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public RetailStoreRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public RetailStoreRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest whereLastUpdateTimeBetween(
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

  public RetailStoreRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public RetailStoreRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public RetailStoreRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public RetailStoreRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public RetailStoreRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreRequest filterByRetailStoreCountryCenter(
      RetailStoreCountryCenterRequest retailStoreCountryCenter) {
    return filterByRetailStoreCountryCenter(
        retailStoreCountryCenter, RetailStoreCountryCenter::getId);
  }

  public RetailStoreRequest filterByRetailStoreCountryCenter(
      RetailStoreCountryCenter... retailStoreCountryCenter) {
    if (isEmptyParam(retailStoreCountryCenter)) {
      throw new IllegalArgumentException(
          "filterByRetailStoreCountryCenter(RetailStoreCountryCenter... retailStoreCountryCenter)参数不能为空!");
    }
    return where(
        RETAIL_STORE_COUNTRY_CENTER_PROPERTY,
        QueryOperator.IN,
        (Object[]) retailStoreCountryCenter);
  }

  public RetailStoreRequest selectRetailStoreCountryCenterId() {
    select(RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToRetailStoreCountryCenter() {
    return upToRetailStoreCountryCenter(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToRetailStoreCountryCenter(
      RetailStoreCountryCenterRequest retailStoreCountryCenter) {
    retailStoreCountryCenter.aggregateChild(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, this);
    this.groupByRetailStoreCountryCenter(retailStoreCountryCenter);
    return retailStoreCountryCenter;
  }

  public RetailStoreCountryCenterRequest endAtRetailStoreCountryCenter(String retName) {
    return endAtRetailStoreCountryCenter(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtRetailStoreCountryCenter(
      String retName, RetailStoreCountryCenterRequest retailStoreCountryCenter) {
    retailStoreCountryCenter.addDynamicProperty(
        retName, this, RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
    return retailStoreCountryCenter;
  }

  public RetailStoreRequest filterByRetailStoreCountryCenter(String... retailStoreCountryCenter) {
    if (isEmptyParam(retailStoreCountryCenter)) {
      throw new IllegalArgumentException(
          "filterByRetailStoreCountryCenter(String... retailStoreCountryCenter)参数不能为空!");
    }
    return where(
        RETAIL_STORE_COUNTRY_CENTER_PROPERTY,
        QueryOperator.IN,
        (Object[]) retailStoreCountryCenter);
  }

  public RetailStoreRequest filterByRetailStoreCountryCenter(
      RetailStoreCountryCenterRequest retailStoreCountryCenter,
      IDRefine<RetailStoreCountryCenter> idRefine) {
    retailStoreCountryCenter.unlimited();
    return addSearchCriteria(
        createRetailStoreCountryCenterCriteria(retailStoreCountryCenter, idRefine));
  }

  public SearchCriteria createRetailStoreCountryCenterCriteria(
      RetailStoreCountryCenterRequest retailStoreCountryCenter,
      IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreCountryCenter,
        RETAIL_STORE_COUNTRY_CENTER_PROPERTY,
        idRefine,
        RetailStoreCountryCenter.ID_PROPERTY);
  }

  public RetailStoreRequest selectRetailStoreCountryCenter() {
    return selectRetailStoreCountryCenter(
        RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public RetailStoreRequest selectRetailStoreCountryCenter(
      RetailStoreCountryCenterRequest retailStoreCountryCenter) {
    selectParent(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter);
    return this;
  }

  public RetailStoreRequest unselectRetailStoreCountryCenter() {
    unselectParent(RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
    return this;
  }

  public RetailStoreRequest groupByRetailStoreCountryCenter(
      RetailStoreCountryCenterRequest retailStoreCountryCenter) {
    groupBy(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter);
    return this;
  }

  public RetailStoreRequest aggregateRetailStoreCountryCenter(
      RetailStoreCountryCenterRequest retailStoreCountryCenter) {
    aggregateParent(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter);
    return this;
  }

  public RetailStoreRequest countRetailStoreCountryCenter() {
    return countRetailStoreCountryCenter("countRetailStoreCountryCenter");
  }

  public RetailStoreRequest countRetailStoreCountryCenter(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
  }

  public RetailStoreRequest groupByRetailStoreCountryCenter() {
    return groupByRetailStoreCountryCenter(RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
  }

  public RetailStoreRequest groupByRetailStoreCountryCenter(String ret) {
    return groupBy(ret, RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
  }

  public RetailStoreRequest whereRetailStoreCountryCenterIsNull() {
    return where(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereRetailStoreCountryCenterIsNotNull() {
    return where(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    return filterByCityServiceCenter(cityServiceCenter, RetailStoreCityServiceCenter::getId);
  }

  public RetailStoreRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenter... cityServiceCenter) {
    if (isEmptyParam(cityServiceCenter)) {
      throw new IllegalArgumentException(
          "filterByCityServiceCenter(RetailStoreCityServiceCenter... cityServiceCenter)参数不能为空!");
    }
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) cityServiceCenter);
  }

  public RetailStoreRequest selectCityServiceCenterId() {
    select(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public RetailStoreCityServiceCenterRequest upToCityServiceCenter() {
    return upToCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest upToCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    cityServiceCenter.aggregateChild(CITY_SERVICE_CENTER_PROPERTY, this);
    this.groupByCityServiceCenter(cityServiceCenter);
    return cityServiceCenter;
  }

  public RetailStoreCityServiceCenterRequest endAtCityServiceCenter(String retName) {
    return endAtCityServiceCenter(retName, RetailStoreCityServiceCenterRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest endAtCityServiceCenter(
      String retName, RetailStoreCityServiceCenterRequest cityServiceCenter) {
    cityServiceCenter.addDynamicProperty(retName, this, CITY_SERVICE_CENTER_PROPERTY);
    return cityServiceCenter;
  }

  public RetailStoreRequest filterByCityServiceCenter(String... cityServiceCenter) {
    if (isEmptyParam(cityServiceCenter)) {
      throw new IllegalArgumentException(
          "filterByCityServiceCenter(String... cityServiceCenter)参数不能为空!");
    }
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) cityServiceCenter);
  }

  public RetailStoreRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter,
      IDRefine<RetailStoreCityServiceCenter> idRefine) {
    cityServiceCenter.unlimited();
    return addSearchCriteria(createCityServiceCenterCriteria(cityServiceCenter, idRefine));
  }

  public SearchCriteria createCityServiceCenterCriteria(
      RetailStoreCityServiceCenterRequest cityServiceCenter,
      IDRefine<RetailStoreCityServiceCenter> idRefine) {
    return new RefinedIdInCriteria(
        cityServiceCenter,
        CITY_SERVICE_CENTER_PROPERTY,
        idRefine,
        RetailStoreCityServiceCenter.ID_PROPERTY);
  }

  public RetailStoreRequest selectCityServiceCenter() {
    return selectCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance().selectSelf());
  }

  public RetailStoreRequest selectCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    selectParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public RetailStoreRequest unselectCityServiceCenter() {
    unselectParent(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public RetailStoreRequest groupByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    groupBy(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public RetailStoreRequest aggregateCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    aggregateParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public RetailStoreRequest countCityServiceCenter() {
    return countCityServiceCenter("countCityServiceCenter");
  }

  public RetailStoreRequest countCityServiceCenter(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreRequest groupByCityServiceCenter() {
    return groupByCityServiceCenter(CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreRequest groupByCityServiceCenter(String ret) {
    return groupBy(ret, CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreRequest whereCityServiceCenterIsNull() {
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereCityServiceCenterIsNotNull() {
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByCreation(RetailStoreCreationRequest creation) {
    return filterByCreation(creation, RetailStoreCreation::getId);
  }

  public RetailStoreRequest filterByCreation(RetailStoreCreation... creation) {
    if (isEmptyParam(creation)) {
      throw new IllegalArgumentException(
          "filterByCreation(RetailStoreCreation... creation)参数不能为空!");
    }
    return where(CREATION_PROPERTY, QueryOperator.IN, (Object[]) creation);
  }

  public RetailStoreRequest selectCreationId() {
    select(CREATION_PROPERTY);
    return this;
  }

  public RetailStoreCreationRequest upToCreation() {
    return upToCreation(RetailStoreCreationRequest.newInstance());
  }

  public RetailStoreCreationRequest upToCreation(RetailStoreCreationRequest creation) {
    creation.aggregateChild(CREATION_PROPERTY, this);
    this.groupByCreation(creation);
    return creation;
  }

  public RetailStoreCreationRequest endAtCreation(String retName) {
    return endAtCreation(retName, RetailStoreCreationRequest.newInstance());
  }

  public RetailStoreCreationRequest endAtCreation(
      String retName, RetailStoreCreationRequest creation) {
    creation.addDynamicProperty(retName, this, CREATION_PROPERTY);
    return creation;
  }

  public RetailStoreRequest filterByCreation(String... creation) {
    if (isEmptyParam(creation)) {
      throw new IllegalArgumentException("filterByCreation(String... creation)参数不能为空!");
    }
    return where(CREATION_PROPERTY, QueryOperator.IN, (Object[]) creation);
  }

  public RetailStoreRequest filterByCreation(
      RetailStoreCreationRequest creation, IDRefine<RetailStoreCreation> idRefine) {
    creation.unlimited();
    return addSearchCriteria(createCreationCriteria(creation, idRefine));
  }

  public SearchCriteria createCreationCriteria(
      RetailStoreCreationRequest creation, IDRefine<RetailStoreCreation> idRefine) {
    return new RefinedIdInCriteria(
        creation, CREATION_PROPERTY, idRefine, RetailStoreCreation.ID_PROPERTY);
  }

  public RetailStoreRequest selectCreation() {
    return selectCreation(RetailStoreCreationRequest.newInstance().selectSelf());
  }

  public RetailStoreRequest selectCreation(RetailStoreCreationRequest creation) {
    selectParent(CREATION_PROPERTY, creation);
    return this;
  }

  public RetailStoreRequest unselectCreation() {
    unselectParent(CREATION_PROPERTY);
    return this;
  }

  public RetailStoreRequest groupByCreation(RetailStoreCreationRequest creation) {
    groupBy(CREATION_PROPERTY, creation);
    return this;
  }

  public RetailStoreRequest aggregateCreation(RetailStoreCreationRequest creation) {
    aggregateParent(CREATION_PROPERTY, creation);
    return this;
  }

  public RetailStoreRequest countCreation() {
    return countCreation("countCreation");
  }

  public RetailStoreRequest countCreation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CREATION_PROPERTY);
  }

  public RetailStoreRequest groupByCreation() {
    return groupByCreation(CREATION_PROPERTY);
  }

  public RetailStoreRequest groupByCreation(String ret) {
    return groupBy(ret, CREATION_PROPERTY);
  }

  public RetailStoreRequest whereCreationIsNull() {
    return where(CREATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereCreationIsNotNull() {
    return where(CREATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByInvestmentInvitation(
      RetailStoreInvestmentInvitationRequest investmentInvitation) {
    return filterByInvestmentInvitation(
        investmentInvitation, RetailStoreInvestmentInvitation::getId);
  }

  public RetailStoreRequest filterByInvestmentInvitation(
      RetailStoreInvestmentInvitation... investmentInvitation) {
    if (isEmptyParam(investmentInvitation)) {
      throw new IllegalArgumentException(
          "filterByInvestmentInvitation(RetailStoreInvestmentInvitation... investmentInvitation)参数不能为空!");
    }
    return where(INVESTMENT_INVITATION_PROPERTY, QueryOperator.IN, (Object[]) investmentInvitation);
  }

  public RetailStoreRequest selectInvestmentInvitationId() {
    select(INVESTMENT_INVITATION_PROPERTY);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest upToInvestmentInvitation() {
    return upToInvestmentInvitation(RetailStoreInvestmentInvitationRequest.newInstance());
  }

  public RetailStoreInvestmentInvitationRequest upToInvestmentInvitation(
      RetailStoreInvestmentInvitationRequest investmentInvitation) {
    investmentInvitation.aggregateChild(INVESTMENT_INVITATION_PROPERTY, this);
    this.groupByInvestmentInvitation(investmentInvitation);
    return investmentInvitation;
  }

  public RetailStoreInvestmentInvitationRequest endAtInvestmentInvitation(String retName) {
    return endAtInvestmentInvitation(retName, RetailStoreInvestmentInvitationRequest.newInstance());
  }

  public RetailStoreInvestmentInvitationRequest endAtInvestmentInvitation(
      String retName, RetailStoreInvestmentInvitationRequest investmentInvitation) {
    investmentInvitation.addDynamicProperty(retName, this, INVESTMENT_INVITATION_PROPERTY);
    return investmentInvitation;
  }

  public RetailStoreRequest filterByInvestmentInvitation(String... investmentInvitation) {
    if (isEmptyParam(investmentInvitation)) {
      throw new IllegalArgumentException(
          "filterByInvestmentInvitation(String... investmentInvitation)参数不能为空!");
    }
    return where(INVESTMENT_INVITATION_PROPERTY, QueryOperator.IN, (Object[]) investmentInvitation);
  }

  public RetailStoreRequest filterByInvestmentInvitation(
      RetailStoreInvestmentInvitationRequest investmentInvitation,
      IDRefine<RetailStoreInvestmentInvitation> idRefine) {
    investmentInvitation.unlimited();
    return addSearchCriteria(createInvestmentInvitationCriteria(investmentInvitation, idRefine));
  }

  public SearchCriteria createInvestmentInvitationCriteria(
      RetailStoreInvestmentInvitationRequest investmentInvitation,
      IDRefine<RetailStoreInvestmentInvitation> idRefine) {
    return new RefinedIdInCriteria(
        investmentInvitation,
        INVESTMENT_INVITATION_PROPERTY,
        idRefine,
        RetailStoreInvestmentInvitation.ID_PROPERTY);
  }

  public RetailStoreRequest selectInvestmentInvitation() {
    return selectInvestmentInvitation(
        RetailStoreInvestmentInvitationRequest.newInstance().selectSelf());
  }

  public RetailStoreRequest selectInvestmentInvitation(
      RetailStoreInvestmentInvitationRequest investmentInvitation) {
    selectParent(INVESTMENT_INVITATION_PROPERTY, investmentInvitation);
    return this;
  }

  public RetailStoreRequest unselectInvestmentInvitation() {
    unselectParent(INVESTMENT_INVITATION_PROPERTY);
    return this;
  }

  public RetailStoreRequest groupByInvestmentInvitation(
      RetailStoreInvestmentInvitationRequest investmentInvitation) {
    groupBy(INVESTMENT_INVITATION_PROPERTY, investmentInvitation);
    return this;
  }

  public RetailStoreRequest aggregateInvestmentInvitation(
      RetailStoreInvestmentInvitationRequest investmentInvitation) {
    aggregateParent(INVESTMENT_INVITATION_PROPERTY, investmentInvitation);
    return this;
  }

  public RetailStoreRequest countInvestmentInvitation() {
    return countInvestmentInvitation("countInvestmentInvitation");
  }

  public RetailStoreRequest countInvestmentInvitation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, INVESTMENT_INVITATION_PROPERTY);
  }

  public RetailStoreRequest groupByInvestmentInvitation() {
    return groupByInvestmentInvitation(INVESTMENT_INVITATION_PROPERTY);
  }

  public RetailStoreRequest groupByInvestmentInvitation(String ret) {
    return groupBy(ret, INVESTMENT_INVITATION_PROPERTY);
  }

  public RetailStoreRequest whereInvestmentInvitationIsNull() {
    return where(INVESTMENT_INVITATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereInvestmentInvitationIsNotNull() {
    return where(INVESTMENT_INVITATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByFranchising(RetailStoreFranchisingRequest franchising) {
    return filterByFranchising(franchising, RetailStoreFranchising::getId);
  }

  public RetailStoreRequest filterByFranchising(RetailStoreFranchising... franchising) {
    if (isEmptyParam(franchising)) {
      throw new IllegalArgumentException(
          "filterByFranchising(RetailStoreFranchising... franchising)参数不能为空!");
    }
    return where(FRANCHISING_PROPERTY, QueryOperator.IN, (Object[]) franchising);
  }

  public RetailStoreRequest selectFranchisingId() {
    select(FRANCHISING_PROPERTY);
    return this;
  }

  public RetailStoreFranchisingRequest upToFranchising() {
    return upToFranchising(RetailStoreFranchisingRequest.newInstance());
  }

  public RetailStoreFranchisingRequest upToFranchising(RetailStoreFranchisingRequest franchising) {
    franchising.aggregateChild(FRANCHISING_PROPERTY, this);
    this.groupByFranchising(franchising);
    return franchising;
  }

  public RetailStoreFranchisingRequest endAtFranchising(String retName) {
    return endAtFranchising(retName, RetailStoreFranchisingRequest.newInstance());
  }

  public RetailStoreFranchisingRequest endAtFranchising(
      String retName, RetailStoreFranchisingRequest franchising) {
    franchising.addDynamicProperty(retName, this, FRANCHISING_PROPERTY);
    return franchising;
  }

  public RetailStoreRequest filterByFranchising(String... franchising) {
    if (isEmptyParam(franchising)) {
      throw new IllegalArgumentException("filterByFranchising(String... franchising)参数不能为空!");
    }
    return where(FRANCHISING_PROPERTY, QueryOperator.IN, (Object[]) franchising);
  }

  public RetailStoreRequest filterByFranchising(
      RetailStoreFranchisingRequest franchising, IDRefine<RetailStoreFranchising> idRefine) {
    franchising.unlimited();
    return addSearchCriteria(createFranchisingCriteria(franchising, idRefine));
  }

  public SearchCriteria createFranchisingCriteria(
      RetailStoreFranchisingRequest franchising, IDRefine<RetailStoreFranchising> idRefine) {
    return new RefinedIdInCriteria(
        franchising, FRANCHISING_PROPERTY, idRefine, RetailStoreFranchising.ID_PROPERTY);
  }

  public RetailStoreRequest selectFranchising() {
    return selectFranchising(RetailStoreFranchisingRequest.newInstance().selectSelf());
  }

  public RetailStoreRequest selectFranchising(RetailStoreFranchisingRequest franchising) {
    selectParent(FRANCHISING_PROPERTY, franchising);
    return this;
  }

  public RetailStoreRequest unselectFranchising() {
    unselectParent(FRANCHISING_PROPERTY);
    return this;
  }

  public RetailStoreRequest groupByFranchising(RetailStoreFranchisingRequest franchising) {
    groupBy(FRANCHISING_PROPERTY, franchising);
    return this;
  }

  public RetailStoreRequest aggregateFranchising(RetailStoreFranchisingRequest franchising) {
    aggregateParent(FRANCHISING_PROPERTY, franchising);
    return this;
  }

  public RetailStoreRequest countFranchising() {
    return countFranchising("countFranchising");
  }

  public RetailStoreRequest countFranchising(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FRANCHISING_PROPERTY);
  }

  public RetailStoreRequest groupByFranchising() {
    return groupByFranchising(FRANCHISING_PROPERTY);
  }

  public RetailStoreRequest groupByFranchising(String ret) {
    return groupBy(ret, FRANCHISING_PROPERTY);
  }

  public RetailStoreRequest whereFranchisingIsNull() {
    return where(FRANCHISING_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereFranchisingIsNotNull() {
    return where(FRANCHISING_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByDecoration(RetailStoreDecorationRequest decoration) {
    return filterByDecoration(decoration, RetailStoreDecoration::getId);
  }

  public RetailStoreRequest filterByDecoration(RetailStoreDecoration... decoration) {
    if (isEmptyParam(decoration)) {
      throw new IllegalArgumentException(
          "filterByDecoration(RetailStoreDecoration... decoration)参数不能为空!");
    }
    return where(DECORATION_PROPERTY, QueryOperator.IN, (Object[]) decoration);
  }

  public RetailStoreRequest selectDecorationId() {
    select(DECORATION_PROPERTY);
    return this;
  }

  public RetailStoreDecorationRequest upToDecoration() {
    return upToDecoration(RetailStoreDecorationRequest.newInstance());
  }

  public RetailStoreDecorationRequest upToDecoration(RetailStoreDecorationRequest decoration) {
    decoration.aggregateChild(DECORATION_PROPERTY, this);
    this.groupByDecoration(decoration);
    return decoration;
  }

  public RetailStoreDecorationRequest endAtDecoration(String retName) {
    return endAtDecoration(retName, RetailStoreDecorationRequest.newInstance());
  }

  public RetailStoreDecorationRequest endAtDecoration(
      String retName, RetailStoreDecorationRequest decoration) {
    decoration.addDynamicProperty(retName, this, DECORATION_PROPERTY);
    return decoration;
  }

  public RetailStoreRequest filterByDecoration(String... decoration) {
    if (isEmptyParam(decoration)) {
      throw new IllegalArgumentException("filterByDecoration(String... decoration)参数不能为空!");
    }
    return where(DECORATION_PROPERTY, QueryOperator.IN, (Object[]) decoration);
  }

  public RetailStoreRequest filterByDecoration(
      RetailStoreDecorationRequest decoration, IDRefine<RetailStoreDecoration> idRefine) {
    decoration.unlimited();
    return addSearchCriteria(createDecorationCriteria(decoration, idRefine));
  }

  public SearchCriteria createDecorationCriteria(
      RetailStoreDecorationRequest decoration, IDRefine<RetailStoreDecoration> idRefine) {
    return new RefinedIdInCriteria(
        decoration, DECORATION_PROPERTY, idRefine, RetailStoreDecoration.ID_PROPERTY);
  }

  public RetailStoreRequest selectDecoration() {
    return selectDecoration(RetailStoreDecorationRequest.newInstance().selectSelf());
  }

  public RetailStoreRequest selectDecoration(RetailStoreDecorationRequest decoration) {
    selectParent(DECORATION_PROPERTY, decoration);
    return this;
  }

  public RetailStoreRequest unselectDecoration() {
    unselectParent(DECORATION_PROPERTY);
    return this;
  }

  public RetailStoreRequest groupByDecoration(RetailStoreDecorationRequest decoration) {
    groupBy(DECORATION_PROPERTY, decoration);
    return this;
  }

  public RetailStoreRequest aggregateDecoration(RetailStoreDecorationRequest decoration) {
    aggregateParent(DECORATION_PROPERTY, decoration);
    return this;
  }

  public RetailStoreRequest countDecoration() {
    return countDecoration("countDecoration");
  }

  public RetailStoreRequest countDecoration(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DECORATION_PROPERTY);
  }

  public RetailStoreRequest groupByDecoration() {
    return groupByDecoration(DECORATION_PROPERTY);
  }

  public RetailStoreRequest groupByDecoration(String ret) {
    return groupBy(ret, DECORATION_PROPERTY);
  }

  public RetailStoreRequest whereDecorationIsNull() {
    return where(DECORATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereDecorationIsNotNull() {
    return where(DECORATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByOpening(RetailStoreOpeningRequest opening) {
    return filterByOpening(opening, RetailStoreOpening::getId);
  }

  public RetailStoreRequest filterByOpening(RetailStoreOpening... opening) {
    if (isEmptyParam(opening)) {
      throw new IllegalArgumentException("filterByOpening(RetailStoreOpening... opening)参数不能为空!");
    }
    return where(OPENING_PROPERTY, QueryOperator.IN, (Object[]) opening);
  }

  public RetailStoreRequest selectOpeningId() {
    select(OPENING_PROPERTY);
    return this;
  }

  public RetailStoreOpeningRequest upToOpening() {
    return upToOpening(RetailStoreOpeningRequest.newInstance());
  }

  public RetailStoreOpeningRequest upToOpening(RetailStoreOpeningRequest opening) {
    opening.aggregateChild(OPENING_PROPERTY, this);
    this.groupByOpening(opening);
    return opening;
  }

  public RetailStoreOpeningRequest endAtOpening(String retName) {
    return endAtOpening(retName, RetailStoreOpeningRequest.newInstance());
  }

  public RetailStoreOpeningRequest endAtOpening(String retName, RetailStoreOpeningRequest opening) {
    opening.addDynamicProperty(retName, this, OPENING_PROPERTY);
    return opening;
  }

  public RetailStoreRequest filterByOpening(String... opening) {
    if (isEmptyParam(opening)) {
      throw new IllegalArgumentException("filterByOpening(String... opening)参数不能为空!");
    }
    return where(OPENING_PROPERTY, QueryOperator.IN, (Object[]) opening);
  }

  public RetailStoreRequest filterByOpening(
      RetailStoreOpeningRequest opening, IDRefine<RetailStoreOpening> idRefine) {
    opening.unlimited();
    return addSearchCriteria(createOpeningCriteria(opening, idRefine));
  }

  public SearchCriteria createOpeningCriteria(
      RetailStoreOpeningRequest opening, IDRefine<RetailStoreOpening> idRefine) {
    return new RefinedIdInCriteria(
        opening, OPENING_PROPERTY, idRefine, RetailStoreOpening.ID_PROPERTY);
  }

  public RetailStoreRequest selectOpening() {
    return selectOpening(RetailStoreOpeningRequest.newInstance().selectSelf());
  }

  public RetailStoreRequest selectOpening(RetailStoreOpeningRequest opening) {
    selectParent(OPENING_PROPERTY, opening);
    return this;
  }

  public RetailStoreRequest unselectOpening() {
    unselectParent(OPENING_PROPERTY);
    return this;
  }

  public RetailStoreRequest groupByOpening(RetailStoreOpeningRequest opening) {
    groupBy(OPENING_PROPERTY, opening);
    return this;
  }

  public RetailStoreRequest aggregateOpening(RetailStoreOpeningRequest opening) {
    aggregateParent(OPENING_PROPERTY, opening);
    return this;
  }

  public RetailStoreRequest countOpening() {
    return countOpening("countOpening");
  }

  public RetailStoreRequest countOpening(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OPENING_PROPERTY);
  }

  public RetailStoreRequest groupByOpening() {
    return groupByOpening(OPENING_PROPERTY);
  }

  public RetailStoreRequest groupByOpening(String ret) {
    return groupBy(ret, OPENING_PROPERTY);
  }

  public RetailStoreRequest whereOpeningIsNull() {
    return where(OPENING_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereOpeningIsNotNull() {
    return where(OPENING_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest filterByClosing(RetailStoreClosingRequest closing) {
    return filterByClosing(closing, RetailStoreClosing::getId);
  }

  public RetailStoreRequest filterByClosing(RetailStoreClosing... closing) {
    if (isEmptyParam(closing)) {
      throw new IllegalArgumentException("filterByClosing(RetailStoreClosing... closing)参数不能为空!");
    }
    return where(CLOSING_PROPERTY, QueryOperator.IN, (Object[]) closing);
  }

  public RetailStoreRequest selectClosingId() {
    select(CLOSING_PROPERTY);
    return this;
  }

  public RetailStoreClosingRequest upToClosing() {
    return upToClosing(RetailStoreClosingRequest.newInstance());
  }

  public RetailStoreClosingRequest upToClosing(RetailStoreClosingRequest closing) {
    closing.aggregateChild(CLOSING_PROPERTY, this);
    this.groupByClosing(closing);
    return closing;
  }

  public RetailStoreClosingRequest endAtClosing(String retName) {
    return endAtClosing(retName, RetailStoreClosingRequest.newInstance());
  }

  public RetailStoreClosingRequest endAtClosing(String retName, RetailStoreClosingRequest closing) {
    closing.addDynamicProperty(retName, this, CLOSING_PROPERTY);
    return closing;
  }

  public RetailStoreRequest filterByClosing(String... closing) {
    if (isEmptyParam(closing)) {
      throw new IllegalArgumentException("filterByClosing(String... closing)参数不能为空!");
    }
    return where(CLOSING_PROPERTY, QueryOperator.IN, (Object[]) closing);
  }

  public RetailStoreRequest filterByClosing(
      RetailStoreClosingRequest closing, IDRefine<RetailStoreClosing> idRefine) {
    closing.unlimited();
    return addSearchCriteria(createClosingCriteria(closing, idRefine));
  }

  public SearchCriteria createClosingCriteria(
      RetailStoreClosingRequest closing, IDRefine<RetailStoreClosing> idRefine) {
    return new RefinedIdInCriteria(
        closing, CLOSING_PROPERTY, idRefine, RetailStoreClosing.ID_PROPERTY);
  }

  public RetailStoreRequest selectClosing() {
    return selectClosing(RetailStoreClosingRequest.newInstance().selectSelf());
  }

  public RetailStoreRequest selectClosing(RetailStoreClosingRequest closing) {
    selectParent(CLOSING_PROPERTY, closing);
    return this;
  }

  public RetailStoreRequest unselectClosing() {
    unselectParent(CLOSING_PROPERTY);
    return this;
  }

  public RetailStoreRequest groupByClosing(RetailStoreClosingRequest closing) {
    groupBy(CLOSING_PROPERTY, closing);
    return this;
  }

  public RetailStoreRequest aggregateClosing(RetailStoreClosingRequest closing) {
    aggregateParent(CLOSING_PROPERTY, closing);
    return this;
  }

  public RetailStoreRequest countClosing() {
    return countClosing("countClosing");
  }

  public RetailStoreRequest countClosing(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CLOSING_PROPERTY);
  }

  public RetailStoreRequest groupByClosing() {
    return groupByClosing(CLOSING_PROPERTY);
  }

  public RetailStoreRequest groupByClosing(String ret) {
    return groupBy(ret, CLOSING_PROPERTY);
  }

  public RetailStoreRequest whereClosingIsNull() {
    return where(CLOSING_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreRequest whereClosingIsNotNull() {
    return where(CLOSING_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreRequest hasConsumerOrder() {
    return hasConsumerOrder(ConsumerOrderRequest.newInstance());
  }

  public RetailStoreRequest hasConsumerOrder(ConsumerOrder... consumerOrder) {
    if (isEmptyParam(consumerOrder)) {
      throw new IllegalArgumentException("hasConsumerOrder(ConsumerOrder... consumerOrder)参数不能为空!");
    }
    return hasConsumerOrder(
        Q.consumerOrder()
            .select(ConsumerOrder.STORE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) consumerOrder));
  }

  public RetailStoreRequest hasConsumerOrder(String... consumerOrder) {
    return hasConsumerOrder(
        Q.consumerOrder().select(ConsumerOrder.STORE_PROPERTY).filterById(consumerOrder));
  }

  public RetailStoreRequest hasConsumerOrder(ConsumerOrderRequest consumerOrder) {
    return hasConsumerOrder(
        consumerOrder,
        $consumerOrder ->
            java.util.Optional.of($consumerOrder)
                .map(ConsumerOrder::getStore)
                .map(RetailStore::getId)
                .orElse(null));
  }

  public RetailStoreRequest hasConsumerOrder(
      ConsumerOrderRequest consumerOrder, IDRefine<ConsumerOrder> idRefine) {
    consumerOrder.select(ConsumerOrder.STORE_PROPERTY);
    consumerOrder.unlimited();
    return addSearchCriteria(createConsumerOrderCriteria(consumerOrder, idRefine));
  }

  public RetailStoreRequest hasConsumerOrder(
      ConsumerOrderRequest consumerOrder, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(consumerOrder, ConsumerOrder.STORE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createConsumerOrderCriteria(
      ConsumerOrderRequest consumerOrder, IDRefine<ConsumerOrder> idRefine) {
    return new RefinedIdInCriteria(
        consumerOrder, ID_PROPERTY, idRefine, ConsumerOrder.STORE_PROPERTY);
  }

  public RetailStoreRequest selectConsumerOrderList(ConsumerOrderRequest consumerOrder) {
    selectChild(ConsumerOrder.STORE_PROPERTY, consumerOrder);
    return this;
  }

  public RetailStoreRequest selectConsumerOrderList() {
    return selectConsumerOrderList(ConsumerOrderRequest.newInstance().selectAll());
  }

  public RetailStoreRequest unselectConsumerOrderList() {
    unselectChild(ConsumerOrder.STORE_PROPERTY, ConsumerOrder.class);
    return this;
  }

  public RetailStoreRequest hasRetailStoreOrder() {
    return hasRetailStoreOrder(RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreRequest hasRetailStoreOrder(RetailStoreOrder... retailStoreOrder) {
    if (isEmptyParam(retailStoreOrder)) {
      throw new IllegalArgumentException(
          "hasRetailStoreOrder(RetailStoreOrder... retailStoreOrder)参数不能为空!");
    }
    return hasRetailStoreOrder(
        Q.retailStoreOrder()
            .select(RetailStoreOrder.BUYER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreOrder));
  }

  public RetailStoreRequest hasRetailStoreOrder(String... retailStoreOrder) {
    return hasRetailStoreOrder(
        Q.retailStoreOrder().select(RetailStoreOrder.BUYER_PROPERTY).filterById(retailStoreOrder));
  }

  public RetailStoreRequest hasRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
    return hasRetailStoreOrder(
        retailStoreOrder,
        $retailStoreOrder ->
            java.util.Optional.of($retailStoreOrder)
                .map(RetailStoreOrder::getBuyer)
                .map(RetailStore::getId)
                .orElse(null));
  }

  public RetailStoreRequest hasRetailStoreOrder(
      RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
    retailStoreOrder.select(RetailStoreOrder.BUYER_PROPERTY);
    retailStoreOrder.unlimited();
    return addSearchCriteria(createRetailStoreOrderCriteria(retailStoreOrder, idRefine));
  }

  public RetailStoreRequest hasRetailStoreOrder(
      RetailStoreOrderRequest retailStoreOrder, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreOrder, RetailStoreOrder.BUYER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreOrderCriteria(
      RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreOrder, ID_PROPERTY, idRefine, RetailStoreOrder.BUYER_PROPERTY);
  }

  public RetailStoreRequest selectRetailStoreOrderList(RetailStoreOrderRequest retailStoreOrder) {
    selectChild(RetailStoreOrder.BUYER_PROPERTY, retailStoreOrder);
    return this;
  }

  public RetailStoreRequest selectRetailStoreOrderList() {
    return selectRetailStoreOrderList(RetailStoreOrderRequest.newInstance().selectAll());
  }

  public RetailStoreRequest unselectRetailStoreOrderList() {
    unselectChild(RetailStoreOrder.BUYER_PROPERTY, RetailStoreOrder.class);
    return this;
  }

  public RetailStoreRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public RetailStoreRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods()
            .select(Goods.RETAIL_STORE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goods));
  }

  public RetailStoreRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.RETAIL_STORE_PROPERTY).filterById(goods));
  }

  public RetailStoreRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods ->
            java.util.Optional.of($goods)
                .map(Goods::getRetailStore)
                .map(RetailStore::getId)
                .orElse(null));
  }

  public RetailStoreRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.RETAIL_STORE_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public RetailStoreRequest hasGoods(
      GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.RETAIL_STORE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.RETAIL_STORE_PROPERTY);
  }

  public RetailStoreRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.RETAIL_STORE_PROPERTY, goods);
    return this;
  }

  public RetailStoreRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public RetailStoreRequest unselectGoodsList() {
    unselectChild(Goods.RETAIL_STORE_PROPERTY, Goods.class);
    return this;
  }

  public RetailStoreRequest hasTransportTask() {
    return hasTransportTask(TransportTaskRequest.newInstance());
  }

  public RetailStoreRequest hasTransportTask(TransportTask... transportTask) {
    if (isEmptyParam(transportTask)) {
      throw new IllegalArgumentException("hasTransportTask(TransportTask... transportTask)参数不能为空!");
    }
    return hasTransportTask(
        Q.transportTask()
            .select(TransportTask.END_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) transportTask));
  }

  public RetailStoreRequest hasTransportTask(String... transportTask) {
    return hasTransportTask(
        Q.transportTask().select(TransportTask.END_PROPERTY).filterById(transportTask));
  }

  public RetailStoreRequest hasTransportTask(TransportTaskRequest transportTask) {
    return hasTransportTask(
        transportTask,
        $transportTask ->
            java.util.Optional.of($transportTask)
                .map(TransportTask::getEnd)
                .map(RetailStore::getId)
                .orElse(null));
  }

  public RetailStoreRequest hasTransportTask(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    transportTask.select(TransportTask.END_PROPERTY);
    transportTask.unlimited();
    return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
  }

  public RetailStoreRequest hasTransportTask(
      TransportTaskRequest transportTask, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(transportTask, TransportTask.END_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTransportTaskCriteria(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    return new RefinedIdInCriteria(
        transportTask, ID_PROPERTY, idRefine, TransportTask.END_PROPERTY);
  }

  public RetailStoreRequest selectTransportTaskList(TransportTaskRequest transportTask) {
    selectChild(TransportTask.END_PROPERTY, transportTask);
    return this;
  }

  public RetailStoreRequest selectTransportTaskList() {
    return selectTransportTaskList(TransportTaskRequest.newInstance().selectAll());
  }

  public RetailStoreRequest unselectTransportTaskList() {
    unselectChild(TransportTask.END_PROPERTY, TransportTask.class);
    return this;
  }

  public RetailStoreRequest hasAccountSet() {
    return hasAccountSet(AccountSetRequest.newInstance());
  }

  public RetailStoreRequest hasAccountSet(AccountSet... accountSet) {
    if (isEmptyParam(accountSet)) {
      throw new IllegalArgumentException("hasAccountSet(AccountSet... accountSet)参数不能为空!");
    }
    return hasAccountSet(
        Q.accountSet()
            .select(AccountSet.RETAIL_STORE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountSet));
  }

  public RetailStoreRequest hasAccountSet(String... accountSet) {
    return hasAccountSet(
        Q.accountSet().select(AccountSet.RETAIL_STORE_PROPERTY).filterById(accountSet));
  }

  public RetailStoreRequest hasAccountSet(AccountSetRequest accountSet) {
    return hasAccountSet(
        accountSet,
        $accountSet ->
            java.util.Optional.of($accountSet)
                .map(AccountSet::getRetailStore)
                .map(RetailStore::getId)
                .orElse(null));
  }

  public RetailStoreRequest hasAccountSet(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    accountSet.select(AccountSet.RETAIL_STORE_PROPERTY);
    accountSet.unlimited();
    return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
  }

  public RetailStoreRequest hasAccountSet(
      AccountSetRequest accountSet, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountSet, AccountSet.RETAIL_STORE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createAccountSetCriteria(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    return new RefinedIdInCriteria(
        accountSet, ID_PROPERTY, idRefine, AccountSet.RETAIL_STORE_PROPERTY);
  }

  public RetailStoreRequest selectAccountSetList(AccountSetRequest accountSet) {
    selectChild(AccountSet.RETAIL_STORE_PROPERTY, accountSet);
    return this;
  }

  public RetailStoreRequest selectAccountSetList() {
    return selectAccountSetList(AccountSetRequest.newInstance().selectAll());
  }

  public RetailStoreRequest unselectAccountSetList() {
    unselectChild(AccountSet.RETAIL_STORE_PROPERTY, AccountSet.class);
    return this;
  }

  public RetailStoreRequest aggregateConsumerOrderList(ConsumerOrderRequest consumerOrder) {
    aggregateChild(ConsumerOrder.STORE_PROPERTY, consumerOrder);
    return this;
  }

  public RetailStoreRequest countConsumerOrder() {
    return countConsumerOrder("consumerOrderCount");
  }

  public RetailStoreRequest countConsumerOrder(String retName) {
    return countConsumerOrder(retName, ConsumerOrderRequest.newInstance());
  }

  public RetailStoreRequest countConsumerOrder(ConsumerOrderRequest consumerOrder) {
    return countConsumerOrder("consumerOrderCount", consumerOrder);
  }

  public RetailStoreRequest countConsumerOrder(String retName, ConsumerOrderRequest consumerOrder) {
    consumerOrder.count();
    return statsFromConsumerOrder(retName, consumerOrder);
  }

  public RetailStoreRequest statsFromConsumerOrder(
      String retName, ConsumerOrderRequest consumerOrder) {
    return addDynamicProperty(retName, consumerOrder, ConsumerOrder.STORE_PROPERTY);
  }

  public RetailStoreRequest aggregateRetailStoreOrderList(
      RetailStoreOrderRequest retailStoreOrder) {
    aggregateChild(RetailStoreOrder.BUYER_PROPERTY, retailStoreOrder);
    return this;
  }

  public RetailStoreRequest countRetailStoreOrder() {
    return countRetailStoreOrder("retailStoreOrderCount");
  }

  public RetailStoreRequest countRetailStoreOrder(String retName) {
    return countRetailStoreOrder(retName, RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreRequest countRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
    return countRetailStoreOrder("retailStoreOrderCount", retailStoreOrder);
  }

  public RetailStoreRequest countRetailStoreOrder(
      String retName, RetailStoreOrderRequest retailStoreOrder) {
    retailStoreOrder.count();
    return statsFromRetailStoreOrder(retName, retailStoreOrder);
  }

  public RetailStoreRequest statsFromRetailStoreOrder(
      String retName, RetailStoreOrderRequest retailStoreOrder) {
    return addDynamicProperty(retName, retailStoreOrder, RetailStoreOrder.BUYER_PROPERTY);
  }

  public RetailStoreRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.RETAIL_STORE_PROPERTY, goods);
    return this;
  }

  public RetailStoreRequest countGoods() {
    return countGoods("goodsCount");
  }

  public RetailStoreRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public RetailStoreRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public RetailStoreRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public RetailStoreRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.RETAIL_STORE_PROPERTY);
  }

  public RetailStoreRequest aggregateTransportTaskList(TransportTaskRequest transportTask) {
    aggregateChild(TransportTask.END_PROPERTY, transportTask);
    return this;
  }

  public RetailStoreRequest countTransportTask() {
    return countTransportTask("transportTaskCount");
  }

  public RetailStoreRequest countTransportTask(String retName) {
    return countTransportTask(retName, TransportTaskRequest.newInstance());
  }

  public RetailStoreRequest countTransportTask(TransportTaskRequest transportTask) {
    return countTransportTask("transportTaskCount", transportTask);
  }

  public RetailStoreRequest countTransportTask(String retName, TransportTaskRequest transportTask) {
    transportTask.count();
    return statsFromTransportTask(retName, transportTask);
  }

  public RetailStoreRequest statsFromTransportTask(
      String retName, TransportTaskRequest transportTask) {
    return addDynamicProperty(retName, transportTask, TransportTask.END_PROPERTY);
  }

  public RetailStoreRequest aggregateAccountSetList(AccountSetRequest accountSet) {
    aggregateChild(AccountSet.RETAIL_STORE_PROPERTY, accountSet);
    return this;
  }

  public RetailStoreRequest countAccountSet() {
    return countAccountSet("accountSetCount");
  }

  public RetailStoreRequest countAccountSet(String retName) {
    return countAccountSet(retName, AccountSetRequest.newInstance());
  }

  public RetailStoreRequest countAccountSet(AccountSetRequest accountSet) {
    return countAccountSet("accountSetCount", accountSet);
  }

  public RetailStoreRequest countAccountSet(String retName, AccountSetRequest accountSet) {
    accountSet.count();
    return statsFromAccountSet(retName, accountSet);
  }

  public RetailStoreRequest statsFromAccountSet(String retName, AccountSetRequest accountSet) {
    return addDynamicProperty(retName, accountSet, AccountSet.RETAIL_STORE_PROPERTY);
  }

  public RetailStoreRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
