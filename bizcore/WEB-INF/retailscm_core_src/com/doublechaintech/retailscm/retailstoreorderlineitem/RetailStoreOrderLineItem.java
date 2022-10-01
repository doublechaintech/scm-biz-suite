package com.doublechaintech.retailscm.retailstoreorderlineitem;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

@JsonSerialize(using = RetailStoreOrderLineItemSerializer.class)
public class RetailStoreOrderLineItem extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(RetailStoreOrderLineItem target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String BIZ_ORDER_PROPERTY = "bizOrder";
  public static final String SKU_ID_PROPERTY = "skuId";
  public static final String SKU_NAME_PROPERTY = "skuName";
  public static final String AMOUNT_PROPERTY = "amount";
  public static final String QUANTITY_PROPERTY = "quantity";
  public static final String UNIT_OF_MEASUREMENT_PROPERTY = "unitOfMeasurement";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "RetailStoreOrderLineItem";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BIZ_ORDER_PROPERTY, "retail_store_order", "订单")
            .withType("retail_store_order", RetailStoreOrder.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SKU_ID_PROPERTY, "sku_id", "产品ID")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SKU_NAME_PROPERTY, "sku_name", "产品名称")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额").withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(QUANTITY_PROPERTY, "quantity", "数量").withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(UNIT_OF_MEASUREMENT_PROPERTY, "unit_of_measurement", "测量单位")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      BIZ_ORDER_PROPERTY,
      SKU_ID_PROPERTY,
      SKU_NAME_PROPERTY,
      AMOUNT_PROPERTY,
      QUANTITY_PROPERTY,
      UNIT_OF_MEASUREMENT_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BIZ_ORDER_PROPERTY, RetailStoreOrder.class);

    return parents;
  }
  /*
  public RetailStoreOrderLineItem want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreOrderLineItem wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getSkuId();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected RetailStoreOrder bizOrder;
  protected String skuId;
  protected String skuName;
  protected BigDecimal amount;
  protected int quantity;
  protected String unitOfMeasurement;
  protected int version;

  public RetailStoreOrderLineItem() {
    // lazy load for all the properties
  }

  public static RetailStoreOrderLineItem withId(String id) {
    RetailStoreOrderLineItem retailStoreOrderLineItem = new RetailStoreOrderLineItem();
    retailStoreOrderLineItem.setId(id);
    retailStoreOrderLineItem.setVersion(Integer.MAX_VALUE);
    retailStoreOrderLineItem.setChecked(true);
    return retailStoreOrderLineItem;
  }

  public static RetailStoreOrderLineItem refById(String id) {
    return withId(id);
  }

  public RetailStoreOrderLineItem limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreOrderLineItem limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreOrderLineItem searchExample() {
    RetailStoreOrderLineItem retailStoreOrderLineItem = new RetailStoreOrderLineItem();
    retailStoreOrderLineItem.setQuantity(UNSET_INT);
    retailStoreOrderLineItem.setVersion(UNSET_INT);

    return retailStoreOrderLineItem;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setBizOrder( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (SKU_ID_PROPERTY.equals(property)) {
      changeSkuIdProperty(newValueExpr);
    }
    if (SKU_NAME_PROPERTY.equals(property)) {
      changeSkuNameProperty(newValueExpr);
    }
    if (AMOUNT_PROPERTY.equals(property)) {
      changeAmountProperty(newValueExpr);
    }
    if (QUANTITY_PROPERTY.equals(property)) {
      changeQuantityProperty(newValueExpr);
    }
    if (UNIT_OF_MEASUREMENT_PROPERTY.equals(property)) {
      changeUnitOfMeasurementProperty(newValueExpr);
    }
  }

  protected void changeSkuIdProperty(String newValueExpr) {

    String oldValue = getSkuId();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateSkuId(newValue);
    this.onChangeProperty(SKU_ID_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeSkuNameProperty(String newValueExpr) {

    String oldValue = getSkuName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateSkuName(newValue);
    this.onChangeProperty(SKU_NAME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAmountProperty(String newValueExpr) {

    BigDecimal oldValue = getAmount();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAmount(newValue);
    this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeQuantityProperty(String newValueExpr) {

    int oldValue = getQuantity();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateQuantity(newValue);
    this.onChangeProperty(QUANTITY_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeUnitOfMeasurementProperty(String newValueExpr) {

    String oldValue = getUnitOfMeasurement();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateUnitOfMeasurement(newValue);
    this.onChangeProperty(UNIT_OF_MEASUREMENT_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (BIZ_ORDER_PROPERTY.equals(property)) {
      return getBizOrder();
    }
    if (SKU_ID_PROPERTY.equals(property)) {
      return getSkuId();
    }
    if (SKU_NAME_PROPERTY.equals(property)) {
      return getSkuName();
    }
    if (AMOUNT_PROPERTY.equals(property)) {
      return getAmount();
    }
    if (QUANTITY_PROPERTY.equals(property)) {
      return getQuantity();
    }
    if (UNIT_OF_MEASUREMENT_PROPERTY.equals(property)) {
      return getUnitOfMeasurement();
    }

    // other property not include here
    return super.propertyOf(property);
  }

  public void setId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    this.id = newId;
  }

  public String id() {
    doLoad();
    return getId();
  }

  public String getId() {
    return this.id;
  }

  public RetailStoreOrderLineItem updateId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    if (!shouldReplaceBy(newId, oldId)) {
      return this;
    }
    this.id = newId;
    if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)) {
      return this;
    }
    addPropertyChange(ID_PROPERTY, oldId, newId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreOrderLineItem orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public RetailStoreOrderLineItem ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItem addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setBizOrder(RetailStoreOrder bizOrder) {
    RetailStoreOrder oldBizOrder = this.bizOrder;
    RetailStoreOrder newBizOrder = bizOrder;
    this.bizOrder = newBizOrder;
  }

  public RetailStoreOrder bizOrder() {
    doLoad();
    return getBizOrder();
  }

  public RetailStoreOrder getBizOrder() {
    return this.bizOrder;
  }

  public RetailStoreOrderLineItem updateBizOrder(RetailStoreOrder bizOrder) {
    RetailStoreOrder oldBizOrder = this.bizOrder;
    RetailStoreOrder newBizOrder = bizOrder;
    if (!shouldReplaceBy(newBizOrder, oldBizOrder)) {
      return this;
    }
    this.bizOrder = newBizOrder;
    if (cn.hutool.core.util.ObjectUtil.equals(newBizOrder, oldBizOrder)) {
      return this;
    }
    addPropertyChange(BIZ_ORDER_PROPERTY, oldBizOrder, newBizOrder);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreOrderLineItem orderByBizOrder(boolean asc) {
    doAddOrderBy(BIZ_ORDER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBizOrderCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BIZ_ORDER_PROPERTY, operator, parameters);
  }

  public RetailStoreOrderLineItem ignoreBizOrderCriteria() {
    super.ignoreSearchProperty(BIZ_ORDER_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItem addBizOrderCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBizOrderCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBizOrder(RetailStoreOrder bizOrder) {
    if (bizOrder != null) {
      updateBizOrder(bizOrder);
    }
  }

  public RetailStoreOrderLineItem updateBizOrderByReferenceId(String bizOrderId) {
    updateBizOrder(RetailStoreOrder.refById(bizOrderId));
    return this;
  }

  public void clearBizOrder() {
    setBizOrder(null);
    this.changed = true;
    setChecked(false);
  }

  public void setSkuId(String skuId) {
    String oldSkuId = this.skuId;
    String newSkuId = trimString(skuId);
    this.skuId = newSkuId;
  }

  public String skuId() {
    doLoad();
    return getSkuId();
  }

  public String getSkuId() {
    return this.skuId;
  }

  public RetailStoreOrderLineItem updateSkuId(String skuId) {
    String oldSkuId = this.skuId;
    String newSkuId = trimString(skuId);
    if (!shouldReplaceBy(newSkuId, oldSkuId)) {
      return this;
    }
    this.skuId = newSkuId;
    if (cn.hutool.core.util.ObjectUtil.equals(newSkuId, oldSkuId)) {
      return this;
    }
    addPropertyChange(SKU_ID_PROPERTY, oldSkuId, newSkuId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreOrderLineItem orderBySkuId(boolean asc) {
    doAddOrderBy(SKU_ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSkuIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SKU_ID_PROPERTY, operator, parameters);
  }

  public RetailStoreOrderLineItem ignoreSkuIdCriteria() {
    super.ignoreSearchProperty(SKU_ID_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItem addSkuIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSkuIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSkuId(String skuId) {
    if (skuId != null) {
      updateSkuId(skuId);
    }
  }

  public void setSkuName(String skuName) {
    String oldSkuName = this.skuName;
    String newSkuName = trimString(skuName);
    this.skuName = newSkuName;
  }

  public String skuName() {
    doLoad();
    return getSkuName();
  }

  public String getSkuName() {
    return this.skuName;
  }

  public RetailStoreOrderLineItem updateSkuName(String skuName) {
    String oldSkuName = this.skuName;
    String newSkuName = trimString(skuName);
    if (!shouldReplaceBy(newSkuName, oldSkuName)) {
      return this;
    }
    this.skuName = newSkuName;
    if (cn.hutool.core.util.ObjectUtil.equals(newSkuName, oldSkuName)) {
      return this;
    }
    addPropertyChange(SKU_NAME_PROPERTY, oldSkuName, newSkuName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreOrderLineItem orderBySkuName(boolean asc) {
    doAddOrderBy(SKU_NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSkuNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SKU_NAME_PROPERTY, operator, parameters);
  }

  public RetailStoreOrderLineItem ignoreSkuNameCriteria() {
    super.ignoreSearchProperty(SKU_NAME_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItem addSkuNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSkuNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSkuName(String skuName) {
    if (skuName != null) {
      updateSkuName(skuName);
    }
  }

  public void setAmount(BigDecimal amount) {
    BigDecimal oldAmount = this.amount;
    BigDecimal newAmount = amount;
    this.amount = newAmount;
  }

  public BigDecimal amount() {
    doLoad();
    return getAmount();
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public RetailStoreOrderLineItem updateAmount(BigDecimal amount) {
    BigDecimal oldAmount = this.amount;
    BigDecimal newAmount = amount;
    if (!shouldReplaceBy(newAmount, oldAmount)) {
      return this;
    }
    this.amount = newAmount;
    if (cn.hutool.core.util.ObjectUtil.equals(newAmount, oldAmount)) {
      return this;
    }
    addPropertyChange(AMOUNT_PROPERTY, oldAmount, newAmount);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreOrderLineItem orderByAmount(boolean asc) {
    doAddOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(AMOUNT_PROPERTY, operator, parameters);
  }

  public RetailStoreOrderLineItem ignoreAmountCriteria() {
    super.ignoreSearchProperty(AMOUNT_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItem addAmountCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAmountCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAmount(BigDecimal amount) {
    updateAmount(amount);
  }

  public void setQuantity(int quantity) {
    int oldQuantity = this.quantity;
    int newQuantity = quantity;
    this.quantity = newQuantity;
  }

  public int quantity() {
    doLoad();
    return getQuantity();
  }

  public int getQuantity() {
    return this.quantity;
  }

  public RetailStoreOrderLineItem updateQuantity(int quantity) {
    int oldQuantity = this.quantity;
    int newQuantity = quantity;
    if (!shouldReplaceBy(newQuantity, oldQuantity)) {
      return this;
    }
    this.quantity = newQuantity;
    if (cn.hutool.core.util.ObjectUtil.equals(newQuantity, oldQuantity)) {
      return this;
    }
    addPropertyChange(QUANTITY_PROPERTY, oldQuantity, newQuantity);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreOrderLineItem orderByQuantity(boolean asc) {
    doAddOrderBy(QUANTITY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createQuantityCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(QUANTITY_PROPERTY, operator, parameters);
  }

  public RetailStoreOrderLineItem ignoreQuantityCriteria() {
    super.ignoreSearchProperty(QUANTITY_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItem addQuantityCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createQuantityCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeQuantity(int quantity) {
    updateQuantity(quantity);
  }

  public void setUnitOfMeasurement(String unitOfMeasurement) {
    String oldUnitOfMeasurement = this.unitOfMeasurement;
    String newUnitOfMeasurement = trimString(unitOfMeasurement);
    this.unitOfMeasurement = newUnitOfMeasurement;
  }

  public String unitOfMeasurement() {
    doLoad();
    return getUnitOfMeasurement();
  }

  public String getUnitOfMeasurement() {
    return this.unitOfMeasurement;
  }

  public RetailStoreOrderLineItem updateUnitOfMeasurement(String unitOfMeasurement) {
    String oldUnitOfMeasurement = this.unitOfMeasurement;
    String newUnitOfMeasurement = trimString(unitOfMeasurement);
    if (!shouldReplaceBy(newUnitOfMeasurement, oldUnitOfMeasurement)) {
      return this;
    }
    this.unitOfMeasurement = newUnitOfMeasurement;
    if (cn.hutool.core.util.ObjectUtil.equals(newUnitOfMeasurement, oldUnitOfMeasurement)) {
      return this;
    }
    addPropertyChange(UNIT_OF_MEASUREMENT_PROPERTY, oldUnitOfMeasurement, newUnitOfMeasurement);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreOrderLineItem orderByUnitOfMeasurement(boolean asc) {
    doAddOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createUnitOfMeasurementCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(UNIT_OF_MEASUREMENT_PROPERTY, operator, parameters);
  }

  public RetailStoreOrderLineItem ignoreUnitOfMeasurementCriteria() {
    super.ignoreSearchProperty(UNIT_OF_MEASUREMENT_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItem addUnitOfMeasurementCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createUnitOfMeasurementCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeUnitOfMeasurement(String unitOfMeasurement) {
    if (unitOfMeasurement != null) {
      updateUnitOfMeasurement(unitOfMeasurement);
    }
  }

  public void setVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    this.version = newVersion;
  }

  public int version() {
    doLoad();
    return getVersion();
  }

  public int getVersion() {
    return this.version;
  }

  public RetailStoreOrderLineItem updateVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    if (!shouldReplaceBy(newVersion, oldVersion)) {
      return this;
    }
    this.version = newVersion;
    if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)) {
      return this;
    }
    addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreOrderLineItem orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public RetailStoreOrderLineItem ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public RetailStoreOrderLineItem addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getBizOrder(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, BIZ_ORDER_PROPERTY, getBizOrder());
    appendKeyValuePair(result, SKU_ID_PROPERTY, getSkuId());
    appendKeyValuePair(result, SKU_NAME_PROPERTY, getSkuName());
    appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
    appendKeyValuePair(result, QUANTITY_PROPERTY, getQuantity());
    appendKeyValuePair(result, UNIT_OF_MEASUREMENT_PROPERTY, getUnitOfMeasurement());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof RetailStoreOrderLineItem) {

      RetailStoreOrderLineItem dest = (RetailStoreOrderLineItem) baseDest;

      dest.setId(getId());
      dest.setBizOrder(getBizOrder());
      dest.setSkuId(getSkuId());
      dest.setSkuName(getSkuName());
      dest.setAmount(getAmount());
      dest.setQuantity(getQuantity());
      dest.setUnitOfMeasurement(getUnitOfMeasurement());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof RetailStoreOrderLineItem) {

      RetailStoreOrderLineItem source = (RetailStoreOrderLineItem) sourceEntity;

      mergeId(source.getId());
      mergeBizOrder(source.getBizOrder());
      mergeSkuId(source.getSkuId());
      mergeSkuName(source.getSkuName());
      mergeAmount(source.getAmount());
      mergeQuantity(source.getQuantity());
      mergeUnitOfMeasurement(source.getUnitOfMeasurement());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof RetailStoreOrderLineItem) {

      RetailStoreOrderLineItem source = (RetailStoreOrderLineItem) sourceEntity;

      mergeId(source.getId());
      mergeSkuId(source.getSkuId());
      mergeSkuName(source.getSkuName());
      mergeAmount(source.getAmount());
      mergeQuantity(source.getQuantity());
      mergeUnitOfMeasurement(source.getUnitOfMeasurement());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getBizOrder(),
      getSkuId(),
      getSkuName(),
      getAmount(),
      getQuantity(),
      getUnitOfMeasurement(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    RetailStoreOrderLineItem checkRetailStoreOrderLineItem =
        Q.retailStoreOrderLineItemWithIdField().filterById(id).execute(ctx);

    return checkRetailStoreOrderLineItem != null
        && !checkRetailStoreOrderLineItem.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public RetailStoreOrderLineItem save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("RetailStoreOrderLineItem{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getBizOrder() != null) {
      stringBuilder.append("\tbizOrder='RetailStoreOrder(" + getBizOrder().getId() + ")';");
    }
    stringBuilder.append("\tskuId='" + getSkuId() + "';");
    stringBuilder.append("\tskuName='" + getSkuName() + "';");
    stringBuilder.append("\tamount='" + getAmount() + "';");
    stringBuilder.append("\tquantity='" + getQuantity() + "';");
    stringBuilder.append("\tunitOfMeasurement='" + getUnitOfMeasurement() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increaseQuantity(int incQuantity) {
    updateQuantity(this.quantity + incQuantity);
  }

  public void decreaseQuantity(int decQuantity) {
    updateQuantity(this.quantity - decQuantity);
  }
}
