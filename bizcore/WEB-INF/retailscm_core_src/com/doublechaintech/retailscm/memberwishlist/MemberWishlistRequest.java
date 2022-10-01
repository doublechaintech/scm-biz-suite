package com.doublechaintech.retailscm.memberwishlist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductRequest;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.memberwishlist.MemberWishlist.*;

public class MemberWishlistRequest extends BaseRequest<MemberWishlist> {
  public static MemberWishlistRequest newInstance() {
    return new MemberWishlistRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public MemberWishlistRequest resultByClass(Class<? extends MemberWishlist> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public MemberWishlistRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public MemberWishlistRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "MemberWishlist";
  }

  public MemberWishlistRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public MemberWishlistRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public MemberWishlistRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public MemberWishlistRequest select(String... names) {
    super.select(names);
    return this;
  }

  public MemberWishlistRequest selectAll() {
    return this.selectId().selectName().selectOwner().selectVersion();
  }

  public MemberWishlistRequest selectAny() {
    return selectAll().selectMemberWishlistProductList(Q.memberWishlistProduct().selectSelf());
  }

  public MemberWishlistRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(OWNER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public MemberWishlistRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public MemberWishlistRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, OWNER_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public MemberWishlistRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public MemberWishlistRequest comment(String comment) {
    return this;
  }

  public MemberWishlistRequest enhance() {
    return this;
  }

  public MemberWishlistRequest overrideClass(Class<? extends MemberWishlist> clazz) {
    return this;
  }

  public MemberWishlistRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public MemberWishlistRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public MemberWishlistRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public MemberWishlistRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public MemberWishlistRequest count() {
    return countId("count");
  }

  public static MemberWishlistRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public MemberWishlistRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public MemberWishlistRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberWishlistRequest selectId() {
    return select(ID_PROPERTY);
  }

  public MemberWishlistRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberWishlistRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public MemberWishlistRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public MemberWishlistRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public MemberWishlistRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public MemberWishlistRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public MemberWishlistRequest countId() {
    return countId("countId");
  }

  public MemberWishlistRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public MemberWishlistRequest maxId() {
    return maxId("maxId");
  }

  public MemberWishlistRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public MemberWishlistRequest minId() {
    return minId("minId");
  }

  public MemberWishlistRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public MemberWishlistRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public MemberWishlistRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public MemberWishlistRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public MemberWishlistRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public MemberWishlistRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public MemberWishlistRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberWishlistRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberWishlistRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberWishlistRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public MemberWishlistRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberWishlistRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public MemberWishlistRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public MemberWishlistRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public MemberWishlistRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public MemberWishlistRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public MemberWishlistRequest countName() {
    return countName("countName");
  }

  public MemberWishlistRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public MemberWishlistRequest maxName() {
    return maxName("maxName");
  }

  public MemberWishlistRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public MemberWishlistRequest minName() {
    return minName("minName");
  }

  public MemberWishlistRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public MemberWishlistRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public MemberWishlistRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public MemberWishlistRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public MemberWishlistRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public MemberWishlistRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public MemberWishlistRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberWishlistRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberWishlistRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberWishlistRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public MemberWishlistRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberWishlistRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public MemberWishlistRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public MemberWishlistRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public MemberWishlistRequest countVersion() {
    return countVersion("countVersion");
  }

  public MemberWishlistRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public MemberWishlistRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public MemberWishlistRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public MemberWishlistRequest minVersion() {
    return minVersion("minVersion");
  }

  public MemberWishlistRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public MemberWishlistRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public MemberWishlistRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public MemberWishlistRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public MemberWishlistRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public MemberWishlistRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public MemberWishlistRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public MemberWishlistRequest filterByOwner(RetailStoreMemberRequest owner) {
    return filterByOwner(owner, RetailStoreMember::getId);
  }

  public MemberWishlistRequest filterByOwner(RetailStoreMember... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreMember... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public MemberWishlistRequest selectOwnerId() {
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

  public MemberWishlistRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public MemberWishlistRequest filterByOwner(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, RetailStoreMember.ID_PROPERTY);
  }

  public MemberWishlistRequest selectOwner() {
    return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
  }

  public MemberWishlistRequest selectOwner(RetailStoreMemberRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberWishlistRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public MemberWishlistRequest groupByOwner(RetailStoreMemberRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberWishlistRequest aggregateOwner(RetailStoreMemberRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberWishlistRequest countOwner() {
    return countOwner("countOwner");
  }

  public MemberWishlistRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public MemberWishlistRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public MemberWishlistRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public MemberWishlistRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberWishlistRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberWishlistRequest hasMemberWishlistProduct() {
    return hasMemberWishlistProduct(MemberWishlistProductRequest.newInstance());
  }

  public MemberWishlistRequest hasMemberWishlistProduct(
      MemberWishlistProduct... memberWishlistProduct) {
    if (isEmptyParam(memberWishlistProduct)) {
      throw new IllegalArgumentException(
          "hasMemberWishlistProduct(MemberWishlistProduct... memberWishlistProduct)参数不能为空!");
    }
    return hasMemberWishlistProduct(
        Q.memberWishlistProduct()
            .select(MemberWishlistProduct.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) memberWishlistProduct));
  }

  public MemberWishlistRequest hasMemberWishlistProduct(String... memberWishlistProduct) {
    return hasMemberWishlistProduct(
        Q.memberWishlistProduct()
            .select(MemberWishlistProduct.OWNER_PROPERTY)
            .filterById(memberWishlistProduct));
  }

  public MemberWishlistRequest hasMemberWishlistProduct(
      MemberWishlistProductRequest memberWishlistProduct) {
    return hasMemberWishlistProduct(
        memberWishlistProduct,
        $memberWishlistProduct ->
            java.util.Optional.of($memberWishlistProduct)
                .map(MemberWishlistProduct::getOwner)
                .map(MemberWishlist::getId)
                .orElse(null));
  }

  public MemberWishlistRequest hasMemberWishlistProduct(
      MemberWishlistProductRequest memberWishlistProduct,
      IDRefine<MemberWishlistProduct> idRefine) {
    memberWishlistProduct.select(MemberWishlistProduct.OWNER_PROPERTY);
    memberWishlistProduct.unlimited();
    return addSearchCriteria(createMemberWishlistProductCriteria(memberWishlistProduct, idRefine));
  }

  public MemberWishlistRequest hasMemberWishlistProduct(
      MemberWishlistProductRequest memberWishlistProduct,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            memberWishlistProduct, MemberWishlistProduct.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createMemberWishlistProductCriteria(
      MemberWishlistProductRequest memberWishlistProduct,
      IDRefine<MemberWishlistProduct> idRefine) {
    return new RefinedIdInCriteria(
        memberWishlistProduct, ID_PROPERTY, idRefine, MemberWishlistProduct.OWNER_PROPERTY);
  }

  public MemberWishlistRequest selectMemberWishlistProductList(
      MemberWishlistProductRequest memberWishlistProduct) {
    selectChild(MemberWishlistProduct.OWNER_PROPERTY, memberWishlistProduct);
    return this;
  }

  public MemberWishlistRequest selectMemberWishlistProductList() {
    return selectMemberWishlistProductList(MemberWishlistProductRequest.newInstance().selectAll());
  }

  public MemberWishlistRequest unselectMemberWishlistProductList() {
    unselectChild(MemberWishlistProduct.OWNER_PROPERTY, MemberWishlistProduct.class);
    return this;
  }

  public MemberWishlistRequest aggregateMemberWishlistProductList(
      MemberWishlistProductRequest memberWishlistProduct) {
    aggregateChild(MemberWishlistProduct.OWNER_PROPERTY, memberWishlistProduct);
    return this;
  }

  public MemberWishlistRequest countMemberWishlistProduct() {
    return countMemberWishlistProduct("memberWishlistProductCount");
  }

  public MemberWishlistRequest countMemberWishlistProduct(String retName) {
    return countMemberWishlistProduct(retName, MemberWishlistProductRequest.newInstance());
  }

  public MemberWishlistRequest countMemberWishlistProduct(
      MemberWishlistProductRequest memberWishlistProduct) {
    return countMemberWishlistProduct("memberWishlistProductCount", memberWishlistProduct);
  }

  public MemberWishlistRequest countMemberWishlistProduct(
      String retName, MemberWishlistProductRequest memberWishlistProduct) {
    memberWishlistProduct.count();
    return statsFromMemberWishlistProduct(retName, memberWishlistProduct);
  }

  public MemberWishlistRequest statsFromMemberWishlistProduct(
      String retName, MemberWishlistProductRequest memberWishlistProduct) {
    return addDynamicProperty(retName, memberWishlistProduct, MemberWishlistProduct.OWNER_PROPERTY);
  }

  public MemberWishlistRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public MemberWishlistRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public MemberWishlistRequest unlimited() {
    super.unlimited();
    return this;
  }

  public MemberWishlistRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
