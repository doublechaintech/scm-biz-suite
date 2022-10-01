package com.doublechaintech.retailscm.originalvoucher;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.originalvoucher.OriginalVoucher.*;

public class OriginalVoucherRequest extends BaseRequest<OriginalVoucher> {
  public static OriginalVoucherRequest newInstance() {
    return new OriginalVoucherRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public OriginalVoucherRequest resultByClass(Class<? extends OriginalVoucher> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public OriginalVoucherRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public OriginalVoucherRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "OriginalVoucher";
  }

  public OriginalVoucherRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public OriginalVoucherRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public OriginalVoucherRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public OriginalVoucherRequest select(String... names) {
    super.select(names);
    return this;
  }

  public OriginalVoucherRequest selectAll() {
    return this.selectId()
        .selectTitle()
        .selectMadeBy()
        .selectReceivedBy()
        .selectVoucherType()
        .selectVoucherImage()
        .selectBelongsTo()
        .selectVersion();
  }

  public OriginalVoucherRequest selectAny() {
    return selectAll();
  }

  public OriginalVoucherRequest selectSelf() {
    select(ID_PROPERTY);
    select(TITLE_PROPERTY);
    select(MADE_BY_PROPERTY);
    select(RECEIVED_BY_PROPERTY);
    select(VOUCHER_TYPE_PROPERTY);
    select(VOUCHER_IMAGE_PROPERTY);
    select(BELONGS_TO_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public OriginalVoucherRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public OriginalVoucherRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    TITLE_PROPERTY,
    MADE_BY_PROPERTY,
    RECEIVED_BY_PROPERTY,
    VOUCHER_TYPE_PROPERTY,
    VOUCHER_IMAGE_PROPERTY,
    BELONGS_TO_PROPERTY,
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

  public OriginalVoucherRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public OriginalVoucherRequest comment(String comment) {
    return this;
  }

  public OriginalVoucherRequest enhance() {
    return this;
  }

  public OriginalVoucherRequest overrideClass(Class<? extends OriginalVoucher> clazz) {
    return this;
  }

  public OriginalVoucherRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public OriginalVoucherRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public OriginalVoucherRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public OriginalVoucherRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public OriginalVoucherRequest count() {
    return countId("count");
  }

  public static OriginalVoucherRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public OriginalVoucherRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public OriginalVoucherRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OriginalVoucherRequest selectId() {
    return select(ID_PROPERTY);
  }

  public OriginalVoucherRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OriginalVoucherRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public OriginalVoucherRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public OriginalVoucherRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public OriginalVoucherRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public OriginalVoucherRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public OriginalVoucherRequest countId() {
    return countId("countId");
  }

  public OriginalVoucherRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public OriginalVoucherRequest maxId() {
    return maxId("maxId");
  }

  public OriginalVoucherRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public OriginalVoucherRequest minId() {
    return minId("minId");
  }

  public OriginalVoucherRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public OriginalVoucherRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public OriginalVoucherRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public OriginalVoucherRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public OriginalVoucherRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public OriginalVoucherRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public OriginalVoucherRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public OriginalVoucherRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OriginalVoucherRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OriginalVoucherRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public OriginalVoucherRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OriginalVoucherRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public OriginalVoucherRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public OriginalVoucherRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public OriginalVoucherRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public OriginalVoucherRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public OriginalVoucherRequest countTitle() {
    return countTitle("countTitle");
  }

  public OriginalVoucherRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public OriginalVoucherRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public OriginalVoucherRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public OriginalVoucherRequest minTitle() {
    return minTitle("minTitle");
  }

  public OriginalVoucherRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public OriginalVoucherRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public OriginalVoucherRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public OriginalVoucherRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public OriginalVoucherRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public OriginalVoucherRequest filterByMadeBy(String madeBy) {

    if (madeBy == null) {
      return this;
    }

    return filterByMadeBy(QueryOperator.EQUAL, madeBy);
  }

  public OriginalVoucherRequest whereMadeByIsNull() {
    return where(MADE_BY_PROPERTY, QueryOperator.IS_NULL);
  }

  public OriginalVoucherRequest whereMadeByIsNotNull() {
    return where(MADE_BY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OriginalVoucherRequest filterByMadeBy(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMadeBySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OriginalVoucherRequest selectMadeBy() {
    return select(MADE_BY_PROPERTY);
  }

  public OriginalVoucherRequest unselectMadeBy() {
    return unselect(MADE_BY_PROPERTY);
  }

  public SearchCriteria getMadeBySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MADE_BY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OriginalVoucherRequest orderByMadeBy(boolean asc) {
    addOrderBy(MADE_BY_PROPERTY, asc);
    return this;
  }

  public OriginalVoucherRequest orderByMadeByAscending() {
    addOrderBy(MADE_BY_PROPERTY, true);
    return this;
  }

  public OriginalVoucherRequest orderByMadeByDescending() {
    addOrderBy(MADE_BY_PROPERTY, false);
    return this;
  }

  public OriginalVoucherRequest orderByMadeByAscendingUsingGBK() {
    addOrderBy("convert(madeBy using gbk)", true);
    return this;
  }

  public OriginalVoucherRequest orderByMadeByDescendingUsingGBK() {
    addOrderBy("convert(madeBy using gbk)", false);
    return this;
  }

  public OriginalVoucherRequest countMadeBy() {
    return countMadeBy("countMadeBy");
  }

  public OriginalVoucherRequest countMadeBy(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MADE_BY_PROPERTY);
  }

  public OriginalVoucherRequest maxMadeBy() {
    return maxMadeBy("maxMadeBy");
  }

  public OriginalVoucherRequest maxMadeBy(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MADE_BY_PROPERTY);
  }

  public OriginalVoucherRequest minMadeBy() {
    return minMadeBy("minMadeBy");
  }

  public OriginalVoucherRequest minMadeBy(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MADE_BY_PROPERTY);
  }

  public OriginalVoucherRequest groupByMadeBy() {
    return groupByMadeBy(MADE_BY_PROPERTY);
  }

  public OriginalVoucherRequest groupByMadeBy(String ret) {
    return groupBy(ret, MADE_BY_PROPERTY);
  }

  public OriginalVoucherRequest groupByMadeBy(SqlFunction func) {
    return groupByMadeBy(MADE_BY_PROPERTY, func);
  }

  public OriginalVoucherRequest groupByMadeBy(String ret, SqlFunction func) {
    super.groupBy(ret, func, MADE_BY_PROPERTY);
    return this;
  }

  public OriginalVoucherRequest filterByReceivedBy(String receivedBy) {

    if (receivedBy == null) {
      return this;
    }

    return filterByReceivedBy(QueryOperator.EQUAL, receivedBy);
  }

  public OriginalVoucherRequest whereReceivedByIsNull() {
    return where(RECEIVED_BY_PROPERTY, QueryOperator.IS_NULL);
  }

  public OriginalVoucherRequest whereReceivedByIsNotNull() {
    return where(RECEIVED_BY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OriginalVoucherRequest filterByReceivedBy(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getReceivedBySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OriginalVoucherRequest selectReceivedBy() {
    return select(RECEIVED_BY_PROPERTY);
  }

  public OriginalVoucherRequest unselectReceivedBy() {
    return unselect(RECEIVED_BY_PROPERTY);
  }

  public SearchCriteria getReceivedBySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(RECEIVED_BY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OriginalVoucherRequest orderByReceivedBy(boolean asc) {
    addOrderBy(RECEIVED_BY_PROPERTY, asc);
    return this;
  }

  public OriginalVoucherRequest orderByReceivedByAscending() {
    addOrderBy(RECEIVED_BY_PROPERTY, true);
    return this;
  }

  public OriginalVoucherRequest orderByReceivedByDescending() {
    addOrderBy(RECEIVED_BY_PROPERTY, false);
    return this;
  }

  public OriginalVoucherRequest orderByReceivedByAscendingUsingGBK() {
    addOrderBy("convert(receivedBy using gbk)", true);
    return this;
  }

  public OriginalVoucherRequest orderByReceivedByDescendingUsingGBK() {
    addOrderBy("convert(receivedBy using gbk)", false);
    return this;
  }

  public OriginalVoucherRequest countReceivedBy() {
    return countReceivedBy("countReceivedBy");
  }

  public OriginalVoucherRequest countReceivedBy(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RECEIVED_BY_PROPERTY);
  }

  public OriginalVoucherRequest maxReceivedBy() {
    return maxReceivedBy("maxReceivedBy");
  }

  public OriginalVoucherRequest maxReceivedBy(String aggName) {
    return aggregate(aggName, AggFunc.MAX, RECEIVED_BY_PROPERTY);
  }

  public OriginalVoucherRequest minReceivedBy() {
    return minReceivedBy("minReceivedBy");
  }

  public OriginalVoucherRequest minReceivedBy(String aggName) {
    return aggregate(aggName, AggFunc.MIN, RECEIVED_BY_PROPERTY);
  }

  public OriginalVoucherRequest groupByReceivedBy() {
    return groupByReceivedBy(RECEIVED_BY_PROPERTY);
  }

  public OriginalVoucherRequest groupByReceivedBy(String ret) {
    return groupBy(ret, RECEIVED_BY_PROPERTY);
  }

  public OriginalVoucherRequest groupByReceivedBy(SqlFunction func) {
    return groupByReceivedBy(RECEIVED_BY_PROPERTY, func);
  }

  public OriginalVoucherRequest groupByReceivedBy(String ret, SqlFunction func) {
    super.groupBy(ret, func, RECEIVED_BY_PROPERTY);
    return this;
  }

  public OriginalVoucherRequest filterByVoucherType(String voucherType) {

    if (voucherType == null) {
      return this;
    }

    return filterByVoucherType(QueryOperator.EQUAL, voucherType);
  }

  public OriginalVoucherRequest whereVoucherTypeIsNull() {
    return where(VOUCHER_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public OriginalVoucherRequest whereVoucherTypeIsNotNull() {
    return where(VOUCHER_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OriginalVoucherRequest filterByVoucherType(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVoucherTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OriginalVoucherRequest selectVoucherType() {
    return select(VOUCHER_TYPE_PROPERTY);
  }

  public OriginalVoucherRequest unselectVoucherType() {
    return unselect(VOUCHER_TYPE_PROPERTY);
  }

  public SearchCriteria getVoucherTypeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VOUCHER_TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OriginalVoucherRequest orderByVoucherType(boolean asc) {
    addOrderBy(VOUCHER_TYPE_PROPERTY, asc);
    return this;
  }

  public OriginalVoucherRequest orderByVoucherTypeAscending() {
    addOrderBy(VOUCHER_TYPE_PROPERTY, true);
    return this;
  }

  public OriginalVoucherRequest orderByVoucherTypeDescending() {
    addOrderBy(VOUCHER_TYPE_PROPERTY, false);
    return this;
  }

  public OriginalVoucherRequest orderByVoucherTypeAscendingUsingGBK() {
    addOrderBy("convert(voucherType using gbk)", true);
    return this;
  }

  public OriginalVoucherRequest orderByVoucherTypeDescendingUsingGBK() {
    addOrderBy("convert(voucherType using gbk)", false);
    return this;
  }

  public OriginalVoucherRequest countVoucherType() {
    return countVoucherType("countVoucherType");
  }

  public OriginalVoucherRequest countVoucherType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VOUCHER_TYPE_PROPERTY);
  }

  public OriginalVoucherRequest maxVoucherType() {
    return maxVoucherType("maxVoucherType");
  }

  public OriginalVoucherRequest maxVoucherType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VOUCHER_TYPE_PROPERTY);
  }

  public OriginalVoucherRequest minVoucherType() {
    return minVoucherType("minVoucherType");
  }

  public OriginalVoucherRequest minVoucherType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VOUCHER_TYPE_PROPERTY);
  }

  public OriginalVoucherRequest groupByVoucherType() {
    return groupByVoucherType(VOUCHER_TYPE_PROPERTY);
  }

  public OriginalVoucherRequest groupByVoucherType(String ret) {
    return groupBy(ret, VOUCHER_TYPE_PROPERTY);
  }

  public OriginalVoucherRequest groupByVoucherType(SqlFunction func) {
    return groupByVoucherType(VOUCHER_TYPE_PROPERTY, func);
  }

  public OriginalVoucherRequest groupByVoucherType(String ret, SqlFunction func) {
    super.groupBy(ret, func, VOUCHER_TYPE_PROPERTY);
    return this;
  }

  public OriginalVoucherRequest filterByVoucherImage(String voucherImage) {

    if (voucherImage == null) {
      return this;
    }

    return filterByVoucherImage(QueryOperator.EQUAL, voucherImage);
  }

  public OriginalVoucherRequest whereVoucherImageIsNull() {
    return where(VOUCHER_IMAGE_PROPERTY, QueryOperator.IS_NULL);
  }

  public OriginalVoucherRequest whereVoucherImageIsNotNull() {
    return where(VOUCHER_IMAGE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OriginalVoucherRequest filterByVoucherImage(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVoucherImageSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OriginalVoucherRequest selectVoucherImage() {
    return select(VOUCHER_IMAGE_PROPERTY);
  }

  public OriginalVoucherRequest unselectVoucherImage() {
    return unselect(VOUCHER_IMAGE_PROPERTY);
  }

  public SearchCriteria getVoucherImageSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VOUCHER_IMAGE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OriginalVoucherRequest orderByVoucherImage(boolean asc) {
    addOrderBy(VOUCHER_IMAGE_PROPERTY, asc);
    return this;
  }

  public OriginalVoucherRequest orderByVoucherImageAscending() {
    addOrderBy(VOUCHER_IMAGE_PROPERTY, true);
    return this;
  }

  public OriginalVoucherRequest orderByVoucherImageDescending() {
    addOrderBy(VOUCHER_IMAGE_PROPERTY, false);
    return this;
  }

  public OriginalVoucherRequest orderByVoucherImageAscendingUsingGBK() {
    addOrderBy("convert(voucherImage using gbk)", true);
    return this;
  }

  public OriginalVoucherRequest orderByVoucherImageDescendingUsingGBK() {
    addOrderBy("convert(voucherImage using gbk)", false);
    return this;
  }

  public OriginalVoucherRequest countVoucherImage() {
    return countVoucherImage("countVoucherImage");
  }

  public OriginalVoucherRequest countVoucherImage(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VOUCHER_IMAGE_PROPERTY);
  }

  public OriginalVoucherRequest maxVoucherImage() {
    return maxVoucherImage("maxVoucherImage");
  }

  public OriginalVoucherRequest maxVoucherImage(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VOUCHER_IMAGE_PROPERTY);
  }

  public OriginalVoucherRequest minVoucherImage() {
    return minVoucherImage("minVoucherImage");
  }

  public OriginalVoucherRequest minVoucherImage(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VOUCHER_IMAGE_PROPERTY);
  }

  public OriginalVoucherRequest groupByVoucherImage() {
    return groupByVoucherImage(VOUCHER_IMAGE_PROPERTY);
  }

  public OriginalVoucherRequest groupByVoucherImage(String ret) {
    return groupBy(ret, VOUCHER_IMAGE_PROPERTY);
  }

  public OriginalVoucherRequest groupByVoucherImage(SqlFunction func) {
    return groupByVoucherImage(VOUCHER_IMAGE_PROPERTY, func);
  }

  public OriginalVoucherRequest groupByVoucherImage(String ret, SqlFunction func) {
    super.groupBy(ret, func, VOUCHER_IMAGE_PROPERTY);
    return this;
  }

  public OriginalVoucherRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public OriginalVoucherRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public OriginalVoucherRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OriginalVoucherRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public OriginalVoucherRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public OriginalVoucherRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public OriginalVoucherRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public OriginalVoucherRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public OriginalVoucherRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public OriginalVoucherRequest countVersion() {
    return countVersion("countVersion");
  }

  public OriginalVoucherRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public OriginalVoucherRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public OriginalVoucherRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public OriginalVoucherRequest minVersion() {
    return minVersion("minVersion");
  }

  public OriginalVoucherRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public OriginalVoucherRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public OriginalVoucherRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public OriginalVoucherRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public OriginalVoucherRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public OriginalVoucherRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public OriginalVoucherRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public OriginalVoucherRequest filterByBelongsTo(AccountingDocumentRequest belongsTo) {
    return filterByBelongsTo(belongsTo, AccountingDocument::getId);
  }

  public OriginalVoucherRequest filterByBelongsTo(AccountingDocument... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException(
          "filterByBelongsTo(AccountingDocument... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public OriginalVoucherRequest selectBelongsToId() {
    select(BELONGS_TO_PROPERTY);
    return this;
  }

  public AccountingDocumentRequest upToBelongsTo() {
    return upToBelongsTo(AccountingDocumentRequest.newInstance());
  }

  public AccountingDocumentRequest upToBelongsTo(AccountingDocumentRequest belongsTo) {
    belongsTo.aggregateChild(BELONGS_TO_PROPERTY, this);
    this.groupByBelongsTo(belongsTo);
    return belongsTo;
  }

  public AccountingDocumentRequest endAtBelongsTo(String retName) {
    return endAtBelongsTo(retName, AccountingDocumentRequest.newInstance());
  }

  public AccountingDocumentRequest endAtBelongsTo(
      String retName, AccountingDocumentRequest belongsTo) {
    belongsTo.addDynamicProperty(retName, this, BELONGS_TO_PROPERTY);
    return belongsTo;
  }

  public OriginalVoucherRequest filterByBelongsTo(String... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(String... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public OriginalVoucherRequest filterByBelongsTo(
      AccountingDocumentRequest belongsTo, IDRefine<AccountingDocument> idRefine) {
    belongsTo.unlimited();
    return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
  }

  public SearchCriteria createBelongsToCriteria(
      AccountingDocumentRequest belongsTo, IDRefine<AccountingDocument> idRefine) {
    return new RefinedIdInCriteria(
        belongsTo, BELONGS_TO_PROPERTY, idRefine, AccountingDocument.ID_PROPERTY);
  }

  public OriginalVoucherRequest selectBelongsTo() {
    return selectBelongsTo(AccountingDocumentRequest.newInstance().selectSelf());
  }

  public OriginalVoucherRequest selectBelongsTo(AccountingDocumentRequest belongsTo) {
    selectParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public OriginalVoucherRequest unselectBelongsTo() {
    unselectParent(BELONGS_TO_PROPERTY);
    return this;
  }

  public OriginalVoucherRequest groupByBelongsTo(AccountingDocumentRequest belongsTo) {
    groupBy(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public OriginalVoucherRequest aggregateBelongsTo(AccountingDocumentRequest belongsTo) {
    aggregateParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public OriginalVoucherRequest countBelongsTo() {
    return countBelongsTo("countBelongsTo");
  }

  public OriginalVoucherRequest countBelongsTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONGS_TO_PROPERTY);
  }

  public OriginalVoucherRequest groupByBelongsTo() {
    return groupByBelongsTo(BELONGS_TO_PROPERTY);
  }

  public OriginalVoucherRequest groupByBelongsTo(String ret) {
    return groupBy(ret, BELONGS_TO_PROPERTY);
  }

  public OriginalVoucherRequest whereBelongsToIsNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public OriginalVoucherRequest whereBelongsToIsNotNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public OriginalVoucherRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public OriginalVoucherRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public OriginalVoucherRequest unlimited() {
    super.unlimited();
    return this;
  }

  public OriginalVoucherRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
