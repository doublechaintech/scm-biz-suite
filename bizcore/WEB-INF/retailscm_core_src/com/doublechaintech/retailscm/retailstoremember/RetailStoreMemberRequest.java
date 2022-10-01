package com.doublechaintech.retailscm.retailstoremember;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointRequest;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionRequest;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressRequest;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponRequest;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoremember.RetailStoreMember.*;

public class RetailStoreMemberRequest extends BaseRequest<RetailStoreMember> {
  public static RetailStoreMemberRequest newInstance() {
    return new RetailStoreMemberRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreMemberRequest resultByClass(Class<? extends RetailStoreMember> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreMemberRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreMemberRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreMember";
  }

  public RetailStoreMemberRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreMemberRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreMemberRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreMemberRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreMemberRequest selectAll() {
    return this.selectId().selectName().selectMobilePhone().selectOwner().selectVersion();
  }

  public RetailStoreMemberRequest selectAny() {
    return selectAll()
        .selectConsumerOrderList(Q.consumerOrder().selectSelf())
        .selectRetailStoreMemberCouponList(Q.retailStoreMemberCoupon().selectSelf())
        .selectMemberWishlistList(Q.memberWishlist().selectSelf())
        .selectMemberRewardPointList(Q.memberRewardPoint().selectSelf())
        .selectMemberRewardPointRedemptionList(Q.memberRewardPointRedemption().selectSelf())
        .selectRetailStoreMemberAddressList(Q.retailStoreMemberAddress().selectSelf())
        .selectRetailStoreMemberGiftCardList(Q.retailStoreMemberGiftCard().selectSelf());
  }

  public RetailStoreMemberRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(MOBILE_PHONE_PROPERTY);
    select(OWNER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreMemberRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreMemberRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, MOBILE_PHONE_PROPERTY, OWNER_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public RetailStoreMemberRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreMemberRequest comment(String comment) {
    return this;
  }

  public RetailStoreMemberRequest enhance() {
    return this;
  }

  public RetailStoreMemberRequest overrideClass(Class<? extends RetailStoreMember> clazz) {
    return this;
  }

  public RetailStoreMemberRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreMemberRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreMemberRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreMemberRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreMemberRequest count() {
    return countId("count");
  }

  public static RetailStoreMemberRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreMemberRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreMemberRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreMemberRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreMemberRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreMemberRequest countId() {
    return countId("countId");
  }

  public RetailStoreMemberRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreMemberRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreMemberRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreMemberRequest minId() {
    return minId("minId");
  }

  public RetailStoreMemberRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreMemberRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreMemberRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreMemberRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreMemberRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreMemberRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreMemberRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreMemberRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreMemberRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreMemberRequest countName() {
    return countName("countName");
  }

  public RetailStoreMemberRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreMemberRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreMemberRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreMemberRequest minName() {
    return minName("minName");
  }

  public RetailStoreMemberRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreMemberRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreMemberRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreMemberRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreMemberRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreMemberRequest filterByMobilePhone(String mobilePhone) {

    if (mobilePhone == null) {
      return this;
    }

    return filterByMobilePhone(QueryOperator.EQUAL, mobilePhone);
  }

  public RetailStoreMemberRequest whereMobilePhoneIsNull() {
    return where(MOBILE_PHONE_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberRequest whereMobilePhoneIsNotNull() {
    return where(MOBILE_PHONE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberRequest filterByMobilePhone(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMobilePhoneSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberRequest selectMobilePhone() {
    return select(MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberRequest unselectMobilePhone() {
    return unselect(MOBILE_PHONE_PROPERTY);
  }

  public SearchCriteria getMobilePhoneSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOBILE_PHONE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberRequest orderByMobilePhone(boolean asc) {
    addOrderBy(MOBILE_PHONE_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberRequest orderByMobilePhoneAscending() {
    addOrderBy(MOBILE_PHONE_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberRequest orderByMobilePhoneDescending() {
    addOrderBy(MOBILE_PHONE_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberRequest orderByMobilePhoneAscendingUsingGBK() {
    addOrderBy("convert(mobilePhone using gbk)", true);
    return this;
  }

  public RetailStoreMemberRequest orderByMobilePhoneDescendingUsingGBK() {
    addOrderBy("convert(mobilePhone using gbk)", false);
    return this;
  }

  public RetailStoreMemberRequest countMobilePhone() {
    return countMobilePhone("countMobilePhone");
  }

  public RetailStoreMemberRequest countMobilePhone(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberRequest maxMobilePhone() {
    return maxMobilePhone("maxMobilePhone");
  }

  public RetailStoreMemberRequest maxMobilePhone(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberRequest minMobilePhone() {
    return minMobilePhone("minMobilePhone");
  }

  public RetailStoreMemberRequest minMobilePhone(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberRequest groupByMobilePhone() {
    return groupByMobilePhone(MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberRequest groupByMobilePhone(String ret) {
    return groupBy(ret, MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberRequest groupByMobilePhone(SqlFunction func) {
    return groupByMobilePhone(MOBILE_PHONE_PROPERTY, func);
  }

  public RetailStoreMemberRequest groupByMobilePhone(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOBILE_PHONE_PROPERTY);
    return this;
  }

  public RetailStoreMemberRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreMemberRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreMemberRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreMemberRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreMemberRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreMemberRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreMemberRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreMemberRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreMemberRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreMemberRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreMemberRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreMemberRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreMemberRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreMemberRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreMemberRequest filterByOwner(RetailStoreCountryCenterRequest owner) {
    return filterByOwner(owner, RetailStoreCountryCenter::getId);
  }

  public RetailStoreMemberRequest filterByOwner(RetailStoreCountryCenter... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreCountryCenter... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToOwner() {
    return upToOwner(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToOwner(RetailStoreCountryCenterRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public RetailStoreCountryCenterRequest endAtOwner(String retName) {
    return endAtOwner(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtOwner(
      String retName, RetailStoreCountryCenterRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public RetailStoreMemberRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberRequest filterByOwner(
      RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        owner, OWNER_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public RetailStoreMemberRequest selectOwner() {
    return selectOwner(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public RetailStoreMemberRequest selectOwner(RetailStoreCountryCenterRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberRequest groupByOwner(RetailStoreCountryCenterRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberRequest aggregateOwner(RetailStoreCountryCenterRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberRequest countOwner() {
    return countOwner("countOwner");
  }

  public RetailStoreMemberRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberRequest hasConsumerOrder() {
    return hasConsumerOrder(ConsumerOrderRequest.newInstance());
  }

  public RetailStoreMemberRequest hasConsumerOrder(ConsumerOrder... consumerOrder) {
    if (isEmptyParam(consumerOrder)) {
      throw new IllegalArgumentException("hasConsumerOrder(ConsumerOrder... consumerOrder)参数不能为空!");
    }
    return hasConsumerOrder(
        Q.consumerOrder()
            .select(ConsumerOrder.CONSUMER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) consumerOrder));
  }

  public RetailStoreMemberRequest hasConsumerOrder(String... consumerOrder) {
    return hasConsumerOrder(
        Q.consumerOrder().select(ConsumerOrder.CONSUMER_PROPERTY).filterById(consumerOrder));
  }

  public RetailStoreMemberRequest hasConsumerOrder(ConsumerOrderRequest consumerOrder) {
    return hasConsumerOrder(
        consumerOrder,
        $consumerOrder ->
            java.util.Optional.of($consumerOrder)
                .map(ConsumerOrder::getConsumer)
                .map(RetailStoreMember::getId)
                .orElse(null));
  }

  public RetailStoreMemberRequest hasConsumerOrder(
      ConsumerOrderRequest consumerOrder, IDRefine<ConsumerOrder> idRefine) {
    consumerOrder.select(ConsumerOrder.CONSUMER_PROPERTY);
    consumerOrder.unlimited();
    return addSearchCriteria(createConsumerOrderCriteria(consumerOrder, idRefine));
  }

  public RetailStoreMemberRequest hasConsumerOrder(
      ConsumerOrderRequest consumerOrder, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            consumerOrder, ConsumerOrder.CONSUMER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createConsumerOrderCriteria(
      ConsumerOrderRequest consumerOrder, IDRefine<ConsumerOrder> idRefine) {
    return new RefinedIdInCriteria(
        consumerOrder, ID_PROPERTY, idRefine, ConsumerOrder.CONSUMER_PROPERTY);
  }

  public RetailStoreMemberRequest selectConsumerOrderList(ConsumerOrderRequest consumerOrder) {
    selectChild(ConsumerOrder.CONSUMER_PROPERTY, consumerOrder);
    return this;
  }

  public RetailStoreMemberRequest selectConsumerOrderList() {
    return selectConsumerOrderList(ConsumerOrderRequest.newInstance().selectAll());
  }

  public RetailStoreMemberRequest unselectConsumerOrderList() {
    unselectChild(ConsumerOrder.CONSUMER_PROPERTY, ConsumerOrder.class);
    return this;
  }

  public RetailStoreMemberRequest hasRetailStoreMemberCoupon() {
    return hasRetailStoreMemberCoupon(RetailStoreMemberCouponRequest.newInstance());
  }

  public RetailStoreMemberRequest hasRetailStoreMemberCoupon(
      RetailStoreMemberCoupon... retailStoreMemberCoupon) {
    if (isEmptyParam(retailStoreMemberCoupon)) {
      throw new IllegalArgumentException(
          "hasRetailStoreMemberCoupon(RetailStoreMemberCoupon... retailStoreMemberCoupon)参数不能为空!");
    }
    return hasRetailStoreMemberCoupon(
        Q.retailStoreMemberCoupon()
            .select(RetailStoreMemberCoupon.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreMemberCoupon));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberCoupon(String... retailStoreMemberCoupon) {
    return hasRetailStoreMemberCoupon(
        Q.retailStoreMemberCoupon()
            .select(RetailStoreMemberCoupon.OWNER_PROPERTY)
            .filterById(retailStoreMemberCoupon));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberCoupon(
      RetailStoreMemberCouponRequest retailStoreMemberCoupon) {
    return hasRetailStoreMemberCoupon(
        retailStoreMemberCoupon,
        $retailStoreMemberCoupon ->
            java.util.Optional.of($retailStoreMemberCoupon)
                .map(RetailStoreMemberCoupon::getOwner)
                .map(RetailStoreMember::getId)
                .orElse(null));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberCoupon(
      RetailStoreMemberCouponRequest retailStoreMemberCoupon,
      IDRefine<RetailStoreMemberCoupon> idRefine) {
    retailStoreMemberCoupon.select(RetailStoreMemberCoupon.OWNER_PROPERTY);
    retailStoreMemberCoupon.unlimited();
    return addSearchCriteria(
        createRetailStoreMemberCouponCriteria(retailStoreMemberCoupon, idRefine));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberCoupon(
      RetailStoreMemberCouponRequest retailStoreMemberCoupon,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreMemberCoupon, RetailStoreMemberCoupon.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreMemberCouponCriteria(
      RetailStoreMemberCouponRequest retailStoreMemberCoupon,
      IDRefine<RetailStoreMemberCoupon> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreMemberCoupon, ID_PROPERTY, idRefine, RetailStoreMemberCoupon.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest selectRetailStoreMemberCouponList(
      RetailStoreMemberCouponRequest retailStoreMemberCoupon) {
    selectChild(RetailStoreMemberCoupon.OWNER_PROPERTY, retailStoreMemberCoupon);
    return this;
  }

  public RetailStoreMemberRequest selectRetailStoreMemberCouponList() {
    return selectRetailStoreMemberCouponList(
        RetailStoreMemberCouponRequest.newInstance().selectAll());
  }

  public RetailStoreMemberRequest unselectRetailStoreMemberCouponList() {
    unselectChild(RetailStoreMemberCoupon.OWNER_PROPERTY, RetailStoreMemberCoupon.class);
    return this;
  }

  public RetailStoreMemberRequest hasMemberWishlist() {
    return hasMemberWishlist(MemberWishlistRequest.newInstance());
  }

  public RetailStoreMemberRequest hasMemberWishlist(MemberWishlist... memberWishlist) {
    if (isEmptyParam(memberWishlist)) {
      throw new IllegalArgumentException(
          "hasMemberWishlist(MemberWishlist... memberWishlist)参数不能为空!");
    }
    return hasMemberWishlist(
        Q.memberWishlist()
            .select(MemberWishlist.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) memberWishlist));
  }

  public RetailStoreMemberRequest hasMemberWishlist(String... memberWishlist) {
    return hasMemberWishlist(
        Q.memberWishlist().select(MemberWishlist.OWNER_PROPERTY).filterById(memberWishlist));
  }

  public RetailStoreMemberRequest hasMemberWishlist(MemberWishlistRequest memberWishlist) {
    return hasMemberWishlist(
        memberWishlist,
        $memberWishlist ->
            java.util.Optional.of($memberWishlist)
                .map(MemberWishlist::getOwner)
                .map(RetailStoreMember::getId)
                .orElse(null));
  }

  public RetailStoreMemberRequest hasMemberWishlist(
      MemberWishlistRequest memberWishlist, IDRefine<MemberWishlist> idRefine) {
    memberWishlist.select(MemberWishlist.OWNER_PROPERTY);
    memberWishlist.unlimited();
    return addSearchCriteria(createMemberWishlistCriteria(memberWishlist, idRefine));
  }

  public RetailStoreMemberRequest hasMemberWishlist(
      MemberWishlistRequest memberWishlist, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            memberWishlist, MemberWishlist.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createMemberWishlistCriteria(
      MemberWishlistRequest memberWishlist, IDRefine<MemberWishlist> idRefine) {
    return new RefinedIdInCriteria(
        memberWishlist, ID_PROPERTY, idRefine, MemberWishlist.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest selectMemberWishlistList(MemberWishlistRequest memberWishlist) {
    selectChild(MemberWishlist.OWNER_PROPERTY, memberWishlist);
    return this;
  }

  public RetailStoreMemberRequest selectMemberWishlistList() {
    return selectMemberWishlistList(MemberWishlistRequest.newInstance().selectAll());
  }

  public RetailStoreMemberRequest unselectMemberWishlistList() {
    unselectChild(MemberWishlist.OWNER_PROPERTY, MemberWishlist.class);
    return this;
  }

  public RetailStoreMemberRequest hasMemberRewardPoint() {
    return hasMemberRewardPoint(MemberRewardPointRequest.newInstance());
  }

  public RetailStoreMemberRequest hasMemberRewardPoint(MemberRewardPoint... memberRewardPoint) {
    if (isEmptyParam(memberRewardPoint)) {
      throw new IllegalArgumentException(
          "hasMemberRewardPoint(MemberRewardPoint... memberRewardPoint)参数不能为空!");
    }
    return hasMemberRewardPoint(
        Q.memberRewardPoint()
            .select(MemberRewardPoint.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) memberRewardPoint));
  }

  public RetailStoreMemberRequest hasMemberRewardPoint(String... memberRewardPoint) {
    return hasMemberRewardPoint(
        Q.memberRewardPoint()
            .select(MemberRewardPoint.OWNER_PROPERTY)
            .filterById(memberRewardPoint));
  }

  public RetailStoreMemberRequest hasMemberRewardPoint(MemberRewardPointRequest memberRewardPoint) {
    return hasMemberRewardPoint(
        memberRewardPoint,
        $memberRewardPoint ->
            java.util.Optional.of($memberRewardPoint)
                .map(MemberRewardPoint::getOwner)
                .map(RetailStoreMember::getId)
                .orElse(null));
  }

  public RetailStoreMemberRequest hasMemberRewardPoint(
      MemberRewardPointRequest memberRewardPoint, IDRefine<MemberRewardPoint> idRefine) {
    memberRewardPoint.select(MemberRewardPoint.OWNER_PROPERTY);
    memberRewardPoint.unlimited();
    return addSearchCriteria(createMemberRewardPointCriteria(memberRewardPoint, idRefine));
  }

  public RetailStoreMemberRequest hasMemberRewardPoint(
      MemberRewardPointRequest memberRewardPoint, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            memberRewardPoint, MemberRewardPoint.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createMemberRewardPointCriteria(
      MemberRewardPointRequest memberRewardPoint, IDRefine<MemberRewardPoint> idRefine) {
    return new RefinedIdInCriteria(
        memberRewardPoint, ID_PROPERTY, idRefine, MemberRewardPoint.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest selectMemberRewardPointList(
      MemberRewardPointRequest memberRewardPoint) {
    selectChild(MemberRewardPoint.OWNER_PROPERTY, memberRewardPoint);
    return this;
  }

  public RetailStoreMemberRequest selectMemberRewardPointList() {
    return selectMemberRewardPointList(MemberRewardPointRequest.newInstance().selectAll());
  }

  public RetailStoreMemberRequest unselectMemberRewardPointList() {
    unselectChild(MemberRewardPoint.OWNER_PROPERTY, MemberRewardPoint.class);
    return this;
  }

  public RetailStoreMemberRequest hasMemberRewardPointRedemption() {
    return hasMemberRewardPointRedemption(MemberRewardPointRedemptionRequest.newInstance());
  }

  public RetailStoreMemberRequest hasMemberRewardPointRedemption(
      MemberRewardPointRedemption... memberRewardPointRedemption) {
    if (isEmptyParam(memberRewardPointRedemption)) {
      throw new IllegalArgumentException(
          "hasMemberRewardPointRedemption(MemberRewardPointRedemption... memberRewardPointRedemption)参数不能为空!");
    }
    return hasMemberRewardPointRedemption(
        Q.memberRewardPointRedemption()
            .select(MemberRewardPointRedemption.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) memberRewardPointRedemption));
  }

  public RetailStoreMemberRequest hasMemberRewardPointRedemption(
      String... memberRewardPointRedemption) {
    return hasMemberRewardPointRedemption(
        Q.memberRewardPointRedemption()
            .select(MemberRewardPointRedemption.OWNER_PROPERTY)
            .filterById(memberRewardPointRedemption));
  }

  public RetailStoreMemberRequest hasMemberRewardPointRedemption(
      MemberRewardPointRedemptionRequest memberRewardPointRedemption) {
    return hasMemberRewardPointRedemption(
        memberRewardPointRedemption,
        $memberRewardPointRedemption ->
            java.util.Optional.of($memberRewardPointRedemption)
                .map(MemberRewardPointRedemption::getOwner)
                .map(RetailStoreMember::getId)
                .orElse(null));
  }

  public RetailStoreMemberRequest hasMemberRewardPointRedemption(
      MemberRewardPointRedemptionRequest memberRewardPointRedemption,
      IDRefine<MemberRewardPointRedemption> idRefine) {
    memberRewardPointRedemption.select(MemberRewardPointRedemption.OWNER_PROPERTY);
    memberRewardPointRedemption.unlimited();
    return addSearchCriteria(
        createMemberRewardPointRedemptionCriteria(memberRewardPointRedemption, idRefine));
  }

  public RetailStoreMemberRequest hasMemberRewardPointRedemption(
      MemberRewardPointRedemptionRequest memberRewardPointRedemption,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            memberRewardPointRedemption,
            MemberRewardPointRedemption.OWNER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createMemberRewardPointRedemptionCriteria(
      MemberRewardPointRedemptionRequest memberRewardPointRedemption,
      IDRefine<MemberRewardPointRedemption> idRefine) {
    return new RefinedIdInCriteria(
        memberRewardPointRedemption,
        ID_PROPERTY,
        idRefine,
        MemberRewardPointRedemption.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest selectMemberRewardPointRedemptionList(
      MemberRewardPointRedemptionRequest memberRewardPointRedemption) {
    selectChild(MemberRewardPointRedemption.OWNER_PROPERTY, memberRewardPointRedemption);
    return this;
  }

  public RetailStoreMemberRequest selectMemberRewardPointRedemptionList() {
    return selectMemberRewardPointRedemptionList(
        MemberRewardPointRedemptionRequest.newInstance().selectAll());
  }

  public RetailStoreMemberRequest unselectMemberRewardPointRedemptionList() {
    unselectChild(MemberRewardPointRedemption.OWNER_PROPERTY, MemberRewardPointRedemption.class);
    return this;
  }

  public RetailStoreMemberRequest hasRetailStoreMemberAddress() {
    return hasRetailStoreMemberAddress(RetailStoreMemberAddressRequest.newInstance());
  }

  public RetailStoreMemberRequest hasRetailStoreMemberAddress(
      RetailStoreMemberAddress... retailStoreMemberAddress) {
    if (isEmptyParam(retailStoreMemberAddress)) {
      throw new IllegalArgumentException(
          "hasRetailStoreMemberAddress(RetailStoreMemberAddress... retailStoreMemberAddress)参数不能为空!");
    }
    return hasRetailStoreMemberAddress(
        Q.retailStoreMemberAddress()
            .select(RetailStoreMemberAddress.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreMemberAddress));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberAddress(String... retailStoreMemberAddress) {
    return hasRetailStoreMemberAddress(
        Q.retailStoreMemberAddress()
            .select(RetailStoreMemberAddress.OWNER_PROPERTY)
            .filterById(retailStoreMemberAddress));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberAddress(
      RetailStoreMemberAddressRequest retailStoreMemberAddress) {
    return hasRetailStoreMemberAddress(
        retailStoreMemberAddress,
        $retailStoreMemberAddress ->
            java.util.Optional.of($retailStoreMemberAddress)
                .map(RetailStoreMemberAddress::getOwner)
                .map(RetailStoreMember::getId)
                .orElse(null));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberAddress(
      RetailStoreMemberAddressRequest retailStoreMemberAddress,
      IDRefine<RetailStoreMemberAddress> idRefine) {
    retailStoreMemberAddress.select(RetailStoreMemberAddress.OWNER_PROPERTY);
    retailStoreMemberAddress.unlimited();
    return addSearchCriteria(
        createRetailStoreMemberAddressCriteria(retailStoreMemberAddress, idRefine));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberAddress(
      RetailStoreMemberAddressRequest retailStoreMemberAddress,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreMemberAddress,
            RetailStoreMemberAddress.OWNER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreMemberAddressCriteria(
      RetailStoreMemberAddressRequest retailStoreMemberAddress,
      IDRefine<RetailStoreMemberAddress> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreMemberAddress, ID_PROPERTY, idRefine, RetailStoreMemberAddress.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest selectRetailStoreMemberAddressList(
      RetailStoreMemberAddressRequest retailStoreMemberAddress) {
    selectChild(RetailStoreMemberAddress.OWNER_PROPERTY, retailStoreMemberAddress);
    return this;
  }

  public RetailStoreMemberRequest selectRetailStoreMemberAddressList() {
    return selectRetailStoreMemberAddressList(
        RetailStoreMemberAddressRequest.newInstance().selectAll());
  }

  public RetailStoreMemberRequest unselectRetailStoreMemberAddressList() {
    unselectChild(RetailStoreMemberAddress.OWNER_PROPERTY, RetailStoreMemberAddress.class);
    return this;
  }

  public RetailStoreMemberRequest hasRetailStoreMemberGiftCard() {
    return hasRetailStoreMemberGiftCard(RetailStoreMemberGiftCardRequest.newInstance());
  }

  public RetailStoreMemberRequest hasRetailStoreMemberGiftCard(
      RetailStoreMemberGiftCard... retailStoreMemberGiftCard) {
    if (isEmptyParam(retailStoreMemberGiftCard)) {
      throw new IllegalArgumentException(
          "hasRetailStoreMemberGiftCard(RetailStoreMemberGiftCard... retailStoreMemberGiftCard)参数不能为空!");
    }
    return hasRetailStoreMemberGiftCard(
        Q.retailStoreMemberGiftCard()
            .select(RetailStoreMemberGiftCard.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreMemberGiftCard));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberGiftCard(
      String... retailStoreMemberGiftCard) {
    return hasRetailStoreMemberGiftCard(
        Q.retailStoreMemberGiftCard()
            .select(RetailStoreMemberGiftCard.OWNER_PROPERTY)
            .filterById(retailStoreMemberGiftCard));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberGiftCard(
      RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard) {
    return hasRetailStoreMemberGiftCard(
        retailStoreMemberGiftCard,
        $retailStoreMemberGiftCard ->
            java.util.Optional.of($retailStoreMemberGiftCard)
                .map(RetailStoreMemberGiftCard::getOwner)
                .map(RetailStoreMember::getId)
                .orElse(null));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberGiftCard(
      RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard,
      IDRefine<RetailStoreMemberGiftCard> idRefine) {
    retailStoreMemberGiftCard.select(RetailStoreMemberGiftCard.OWNER_PROPERTY);
    retailStoreMemberGiftCard.unlimited();
    return addSearchCriteria(
        createRetailStoreMemberGiftCardCriteria(retailStoreMemberGiftCard, idRefine));
  }

  public RetailStoreMemberRequest hasRetailStoreMemberGiftCard(
      RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreMemberGiftCard,
            RetailStoreMemberGiftCard.OWNER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreMemberGiftCardCriteria(
      RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard,
      IDRefine<RetailStoreMemberGiftCard> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreMemberGiftCard, ID_PROPERTY, idRefine, RetailStoreMemberGiftCard.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest selectRetailStoreMemberGiftCardList(
      RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard) {
    selectChild(RetailStoreMemberGiftCard.OWNER_PROPERTY, retailStoreMemberGiftCard);
    return this;
  }

  public RetailStoreMemberRequest selectRetailStoreMemberGiftCardList() {
    return selectRetailStoreMemberGiftCardList(
        RetailStoreMemberGiftCardRequest.newInstance().selectAll());
  }

  public RetailStoreMemberRequest unselectRetailStoreMemberGiftCardList() {
    unselectChild(RetailStoreMemberGiftCard.OWNER_PROPERTY, RetailStoreMemberGiftCard.class);
    return this;
  }

  public RetailStoreMemberRequest aggregateConsumerOrderList(ConsumerOrderRequest consumerOrder) {
    aggregateChild(ConsumerOrder.CONSUMER_PROPERTY, consumerOrder);
    return this;
  }

  public RetailStoreMemberRequest countConsumerOrder() {
    return countConsumerOrder("consumerOrderCount");
  }

  public RetailStoreMemberRequest countConsumerOrder(String retName) {
    return countConsumerOrder(retName, ConsumerOrderRequest.newInstance());
  }

  public RetailStoreMemberRequest countConsumerOrder(ConsumerOrderRequest consumerOrder) {
    return countConsumerOrder("consumerOrderCount", consumerOrder);
  }

  public RetailStoreMemberRequest countConsumerOrder(
      String retName, ConsumerOrderRequest consumerOrder) {
    consumerOrder.count();
    return statsFromConsumerOrder(retName, consumerOrder);
  }

  public RetailStoreMemberRequest statsFromConsumerOrder(
      String retName, ConsumerOrderRequest consumerOrder) {
    return addDynamicProperty(retName, consumerOrder, ConsumerOrder.CONSUMER_PROPERTY);
  }

  public RetailStoreMemberRequest aggregateRetailStoreMemberCouponList(
      RetailStoreMemberCouponRequest retailStoreMemberCoupon) {
    aggregateChild(RetailStoreMemberCoupon.OWNER_PROPERTY, retailStoreMemberCoupon);
    return this;
  }

  public RetailStoreMemberRequest countRetailStoreMemberCoupon() {
    return countRetailStoreMemberCoupon("retailStoreMemberCouponCount");
  }

  public RetailStoreMemberRequest countRetailStoreMemberCoupon(String retName) {
    return countRetailStoreMemberCoupon(retName, RetailStoreMemberCouponRequest.newInstance());
  }

  public RetailStoreMemberRequest countRetailStoreMemberCoupon(
      RetailStoreMemberCouponRequest retailStoreMemberCoupon) {
    return countRetailStoreMemberCoupon("retailStoreMemberCouponCount", retailStoreMemberCoupon);
  }

  public RetailStoreMemberRequest countRetailStoreMemberCoupon(
      String retName, RetailStoreMemberCouponRequest retailStoreMemberCoupon) {
    retailStoreMemberCoupon.count();
    return statsFromRetailStoreMemberCoupon(retName, retailStoreMemberCoupon);
  }

  public RetailStoreMemberRequest statsFromRetailStoreMemberCoupon(
      String retName, RetailStoreMemberCouponRequest retailStoreMemberCoupon) {
    return addDynamicProperty(
        retName, retailStoreMemberCoupon, RetailStoreMemberCoupon.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest aggregateMemberWishlistList(
      MemberWishlistRequest memberWishlist) {
    aggregateChild(MemberWishlist.OWNER_PROPERTY, memberWishlist);
    return this;
  }

  public RetailStoreMemberRequest countMemberWishlist() {
    return countMemberWishlist("memberWishlistCount");
  }

  public RetailStoreMemberRequest countMemberWishlist(String retName) {
    return countMemberWishlist(retName, MemberWishlistRequest.newInstance());
  }

  public RetailStoreMemberRequest countMemberWishlist(MemberWishlistRequest memberWishlist) {
    return countMemberWishlist("memberWishlistCount", memberWishlist);
  }

  public RetailStoreMemberRequest countMemberWishlist(
      String retName, MemberWishlistRequest memberWishlist) {
    memberWishlist.count();
    return statsFromMemberWishlist(retName, memberWishlist);
  }

  public RetailStoreMemberRequest statsFromMemberWishlist(
      String retName, MemberWishlistRequest memberWishlist) {
    return addDynamicProperty(retName, memberWishlist, MemberWishlist.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest aggregateMemberRewardPointList(
      MemberRewardPointRequest memberRewardPoint) {
    aggregateChild(MemberRewardPoint.OWNER_PROPERTY, memberRewardPoint);
    return this;
  }

  public RetailStoreMemberRequest countMemberRewardPoint() {
    return countMemberRewardPoint("memberRewardPointCount");
  }

  public RetailStoreMemberRequest countMemberRewardPoint(String retName) {
    return countMemberRewardPoint(retName, MemberRewardPointRequest.newInstance());
  }

  public RetailStoreMemberRequest countMemberRewardPoint(
      MemberRewardPointRequest memberRewardPoint) {
    return countMemberRewardPoint("memberRewardPointCount", memberRewardPoint);
  }

  public RetailStoreMemberRequest countMemberRewardPoint(
      String retName, MemberRewardPointRequest memberRewardPoint) {
    memberRewardPoint.count();
    return statsFromMemberRewardPoint(retName, memberRewardPoint);
  }

  public RetailStoreMemberRequest statsFromMemberRewardPoint(
      String retName, MemberRewardPointRequest memberRewardPoint) {
    return addDynamicProperty(retName, memberRewardPoint, MemberRewardPoint.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest aggregateMemberRewardPointRedemptionList(
      MemberRewardPointRedemptionRequest memberRewardPointRedemption) {
    aggregateChild(MemberRewardPointRedemption.OWNER_PROPERTY, memberRewardPointRedemption);
    return this;
  }

  public RetailStoreMemberRequest countMemberRewardPointRedemption() {
    return countMemberRewardPointRedemption("memberRewardPointRedemptionCount");
  }

  public RetailStoreMemberRequest countMemberRewardPointRedemption(String retName) {
    return countMemberRewardPointRedemption(
        retName, MemberRewardPointRedemptionRequest.newInstance());
  }

  public RetailStoreMemberRequest countMemberRewardPointRedemption(
      MemberRewardPointRedemptionRequest memberRewardPointRedemption) {
    return countMemberRewardPointRedemption(
        "memberRewardPointRedemptionCount", memberRewardPointRedemption);
  }

  public RetailStoreMemberRequest countMemberRewardPointRedemption(
      String retName, MemberRewardPointRedemptionRequest memberRewardPointRedemption) {
    memberRewardPointRedemption.count();
    return statsFromMemberRewardPointRedemption(retName, memberRewardPointRedemption);
  }

  public RetailStoreMemberRequest statsFromMemberRewardPointRedemption(
      String retName, MemberRewardPointRedemptionRequest memberRewardPointRedemption) {
    return addDynamicProperty(
        retName, memberRewardPointRedemption, MemberRewardPointRedemption.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest aggregateRetailStoreMemberAddressList(
      RetailStoreMemberAddressRequest retailStoreMemberAddress) {
    aggregateChild(RetailStoreMemberAddress.OWNER_PROPERTY, retailStoreMemberAddress);
    return this;
  }

  public RetailStoreMemberRequest countRetailStoreMemberAddress() {
    return countRetailStoreMemberAddress("retailStoreMemberAddressCount");
  }

  public RetailStoreMemberRequest countRetailStoreMemberAddress(String retName) {
    return countRetailStoreMemberAddress(retName, RetailStoreMemberAddressRequest.newInstance());
  }

  public RetailStoreMemberRequest countRetailStoreMemberAddress(
      RetailStoreMemberAddressRequest retailStoreMemberAddress) {
    return countRetailStoreMemberAddress("retailStoreMemberAddressCount", retailStoreMemberAddress);
  }

  public RetailStoreMemberRequest countRetailStoreMemberAddress(
      String retName, RetailStoreMemberAddressRequest retailStoreMemberAddress) {
    retailStoreMemberAddress.count();
    return statsFromRetailStoreMemberAddress(retName, retailStoreMemberAddress);
  }

  public RetailStoreMemberRequest statsFromRetailStoreMemberAddress(
      String retName, RetailStoreMemberAddressRequest retailStoreMemberAddress) {
    return addDynamicProperty(
        retName, retailStoreMemberAddress, RetailStoreMemberAddress.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest aggregateRetailStoreMemberGiftCardList(
      RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard) {
    aggregateChild(RetailStoreMemberGiftCard.OWNER_PROPERTY, retailStoreMemberGiftCard);
    return this;
  }

  public RetailStoreMemberRequest countRetailStoreMemberGiftCard() {
    return countRetailStoreMemberGiftCard("retailStoreMemberGiftCardCount");
  }

  public RetailStoreMemberRequest countRetailStoreMemberGiftCard(String retName) {
    return countRetailStoreMemberGiftCard(retName, RetailStoreMemberGiftCardRequest.newInstance());
  }

  public RetailStoreMemberRequest countRetailStoreMemberGiftCard(
      RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard) {
    return countRetailStoreMemberGiftCard(
        "retailStoreMemberGiftCardCount", retailStoreMemberGiftCard);
  }

  public RetailStoreMemberRequest countRetailStoreMemberGiftCard(
      String retName, RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard) {
    retailStoreMemberGiftCard.count();
    return statsFromRetailStoreMemberGiftCard(retName, retailStoreMemberGiftCard);
  }

  public RetailStoreMemberRequest statsFromRetailStoreMemberGiftCard(
      String retName, RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard) {
    return addDynamicProperty(
        retName, retailStoreMemberGiftCard, RetailStoreMemberGiftCard.OWNER_PROPERTY);
  }

  public RetailStoreMemberRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreMemberRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreMemberRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreMemberRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
