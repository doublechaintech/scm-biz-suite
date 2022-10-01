package com.doublechaintech.retailscm.consumerordershippinggroup;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

@JsonSerialize(using = ConsumerOrderShippingGroupSerializer.class)
public class ConsumerOrderShippingGroup extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(ConsumerOrderShippingGroup target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String BIZ_ORDER_PROPERTY = "bizOrder";
  public static final String AMOUNT_PROPERTY = "amount";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "ConsumerOrderShippingGroup";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BIZ_ORDER_PROPERTY, "consumer_order", "订单")
            .withType("consumer_order", ConsumerOrder.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额").withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, NAME_PROPERTY, BIZ_ORDER_PROPERTY, AMOUNT_PROPERTY, VERSION_PROPERTY
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
    parents.put(BIZ_ORDER_PROPERTY, ConsumerOrder.class);

    return parents;
  }
  /*
  public ConsumerOrderShippingGroup want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ConsumerOrderShippingGroup wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getName();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;
  protected ConsumerOrder bizOrder;
  protected BigDecimal amount;
  protected int version;

  public ConsumerOrderShippingGroup() {
    // lazy load for all the properties
  }

  public static ConsumerOrderShippingGroup withId(String id) {
    ConsumerOrderShippingGroup consumerOrderShippingGroup = new ConsumerOrderShippingGroup();
    consumerOrderShippingGroup.setId(id);
    consumerOrderShippingGroup.setVersion(Integer.MAX_VALUE);
    consumerOrderShippingGroup.setChecked(true);
    return consumerOrderShippingGroup;
  }

  public static ConsumerOrderShippingGroup refById(String id) {
    return withId(id);
  }

  public ConsumerOrderShippingGroup limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public ConsumerOrderShippingGroup limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static ConsumerOrderShippingGroup searchExample() {
    ConsumerOrderShippingGroup consumerOrderShippingGroup = new ConsumerOrderShippingGroup();
    consumerOrderShippingGroup.setVersion(UNSET_INT);

    return consumerOrderShippingGroup;
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

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (AMOUNT_PROPERTY.equals(property)) {
      changeAmountProperty(newValueExpr);
    }
  }

  protected void changeNameProperty(String newValueExpr) {

    String oldValue = getName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateName(newValue);
    this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
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

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (BIZ_ORDER_PROPERTY.equals(property)) {
      return getBizOrder();
    }
    if (AMOUNT_PROPERTY.equals(property)) {
      return getAmount();
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

  public ConsumerOrderShippingGroup updateId(String id) {
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

  public ConsumerOrderShippingGroup orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public ConsumerOrderShippingGroup ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroup addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setName(String name) {
    String oldName = this.name;
    String newName = trimString(name);
    this.name = newName;
  }

  public String name() {
    doLoad();
    return getName();
  }

  public String getName() {
    return this.name;
  }

  public ConsumerOrderShippingGroup updateName(String name) {
    String oldName = this.name;
    String newName = trimString(name);
    if (!shouldReplaceBy(newName, oldName)) {
      return this;
    }
    this.name = newName;
    if (cn.hutool.core.util.ObjectUtil.equals(newName, oldName)) {
      return this;
    }
    addPropertyChange(NAME_PROPERTY, oldName, newName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ConsumerOrderShippingGroup orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public ConsumerOrderShippingGroup ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroup addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setBizOrder(ConsumerOrder bizOrder) {
    ConsumerOrder oldBizOrder = this.bizOrder;
    ConsumerOrder newBizOrder = bizOrder;
    this.bizOrder = newBizOrder;
  }

  public ConsumerOrder bizOrder() {
    doLoad();
    return getBizOrder();
  }

  public ConsumerOrder getBizOrder() {
    return this.bizOrder;
  }

  public ConsumerOrderShippingGroup updateBizOrder(ConsumerOrder bizOrder) {
    ConsumerOrder oldBizOrder = this.bizOrder;
    ConsumerOrder newBizOrder = bizOrder;
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

  public ConsumerOrderShippingGroup orderByBizOrder(boolean asc) {
    doAddOrderBy(BIZ_ORDER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBizOrderCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BIZ_ORDER_PROPERTY, operator, parameters);
  }

  public ConsumerOrderShippingGroup ignoreBizOrderCriteria() {
    super.ignoreSearchProperty(BIZ_ORDER_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroup addBizOrderCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBizOrderCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBizOrder(ConsumerOrder bizOrder) {
    if (bizOrder != null) {
      updateBizOrder(bizOrder);
    }
  }

  public ConsumerOrderShippingGroup updateBizOrderByReferenceId(String bizOrderId) {
    updateBizOrder(ConsumerOrder.refById(bizOrderId));
    return this;
  }

  public void clearBizOrder() {
    setBizOrder(null);
    this.changed = true;
    setChecked(false);
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

  public ConsumerOrderShippingGroup updateAmount(BigDecimal amount) {
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

  public ConsumerOrderShippingGroup orderByAmount(boolean asc) {
    doAddOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(AMOUNT_PROPERTY, operator, parameters);
  }

  public ConsumerOrderShippingGroup ignoreAmountCriteria() {
    super.ignoreSearchProperty(AMOUNT_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroup addAmountCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAmountCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAmount(BigDecimal amount) {
    updateAmount(amount);
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

  public ConsumerOrderShippingGroup updateVersion(int version) {
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

  public ConsumerOrderShippingGroup orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public ConsumerOrderShippingGroup ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public ConsumerOrderShippingGroup addVersionCriteria(
      QueryOperator operator, Object... parameters) {
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
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, BIZ_ORDER_PROPERTY, getBizOrder());
    appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof ConsumerOrderShippingGroup) {

      ConsumerOrderShippingGroup dest = (ConsumerOrderShippingGroup) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setBizOrder(getBizOrder());
      dest.setAmount(getAmount());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof ConsumerOrderShippingGroup) {

      ConsumerOrderShippingGroup source = (ConsumerOrderShippingGroup) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeBizOrder(source.getBizOrder());
      mergeAmount(source.getAmount());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof ConsumerOrderShippingGroup) {

      ConsumerOrderShippingGroup source = (ConsumerOrderShippingGroup) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeAmount(source.getAmount());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getName(), getBizOrder(), getAmount(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    ConsumerOrderShippingGroup checkConsumerOrderShippingGroup =
        Q.consumerOrderShippingGroupWithIdField().filterById(id).execute(ctx);

    return checkConsumerOrderShippingGroup != null
        && !checkConsumerOrderShippingGroup.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public ConsumerOrderShippingGroup save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("ConsumerOrderShippingGroup{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    if (getBizOrder() != null) {
      stringBuilder.append("\tbizOrder='ConsumerOrder(" + getBizOrder().getId() + ")';");
    }
    stringBuilder.append("\tamount='" + getAmount() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
