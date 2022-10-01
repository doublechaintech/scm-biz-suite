package com.doublechaintech.retailscm.retailstore;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

@JsonSerialize(using = RetailStoreSerializer.class)
public class RetailStore extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(RetailStore target) {
    if (target == null) {
      return;
    }
    target.addConsumerOrderList(this.getConsumerOrderList());
    target.addRetailStoreOrderList(this.getRetailStoreOrderList());
    target.addGoodsList(this.getGoodsList());
    target.addTransportTaskList(this.getTransportTaskList());
    target.addAccountSetList(this.getAccountSetList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String TELEPHONE_PROPERTY = "telephone";
  public static final String OWNER_PROPERTY = "owner";
  public static final String RETAIL_STORE_COUNTRY_CENTER_PROPERTY = "retailStoreCountryCenter";
  public static final String CITY_SERVICE_CENTER_PROPERTY = "cityServiceCenter";
  public static final String CREATION_PROPERTY = "creation";
  public static final String INVESTMENT_INVITATION_PROPERTY = "investmentInvitation";
  public static final String FRANCHISING_PROPERTY = "franchising";
  public static final String DECORATION_PROPERTY = "decoration";
  public static final String OPENING_PROPERTY = "opening";
  public static final String CLOSING_PROPERTY = "closing";
  public static final String FOUNDED_PROPERTY = "founded";
  public static final String LATITUDE_PROPERTY = "latitude";
  public static final String LONGITUDE_PROPERTY = "longitude";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String CONSUMER_ORDER_LIST = "consumerOrderList";
  public static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
  public static final String GOODS_LIST = "goodsList";
  public static final String TRANSPORT_TASK_LIST = "transportTaskList";
  public static final String ACCOUNT_SET_LIST = "accountSetList";

  public static final String INTERNAL_TYPE = "RetailStore";

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
        MemberMetaInfo.defineBy(TELEPHONE_PROPERTY, "telephone", "电话")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(OWNER_PROPERTY, "owner", "业主").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                RETAIL_STORE_COUNTRY_CENTER_PROPERTY, "retail_store_country_center", "双链小超全国运营中心")
            .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                CITY_SERVICE_CENTER_PROPERTY, "retail_store_city_service_center", "城市服务中心")
            .withType("retail_store_city_service_center", RetailStoreCityServiceCenter.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CREATION_PROPERTY, "retail_store_creation", "创建")
            .withType("retail_store_creation", RetailStoreCreation.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                INVESTMENT_INVITATION_PROPERTY, "retail_store_investment_invitation", "招商")
            .withType("retail_store_investment_invitation", RetailStoreInvestmentInvitation.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FRANCHISING_PROPERTY, "retail_store_franchising", "加盟")
            .withType("retail_store_franchising", RetailStoreFranchising.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DECORATION_PROPERTY, "retail_store_decoration", "装修")
            .withType("retail_store_decoration", RetailStoreDecoration.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(OPENING_PROPERTY, "retail_store_opening", "开业")
            .withType("retail_store_opening", RetailStoreOpening.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CLOSING_PROPERTY, "retail_store_closing", "关闭")
            .withType("retail_store_closing", RetailStoreClosing.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FOUNDED_PROPERTY, "founded", "成立").withType("date_past", "Date"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LATITUDE_PROPERTY, "latitude", "纬度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LONGITUDE_PROPERTY, "longitude", "经度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
            .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(CONSUMER_ORDER_LIST, "store", "消费者的订单列表")
            .withType("consumer_order", ConsumerOrder.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(RETAIL_STORE_ORDER_LIST, "buyer", "零售店订购单")
            .withType("retail_store_order", RetailStoreOrder.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(GOODS_LIST, "retailStore", "商品列表").withType("goods", Goods.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(TRANSPORT_TASK_LIST, "end", "运输任务列表")
            .withType("transport_task", TransportTask.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(ACCOUNT_SET_LIST, "retailStore", "帐户设置列表")
            .withType("account_set", AccountSet.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
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
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(CONSUMER_ORDER_LIST, "store");

    refers.put(RETAIL_STORE_ORDER_LIST, "buyer");

    refers.put(GOODS_LIST, "retailStore");

    refers.put(TRANSPORT_TASK_LIST, "end");

    refers.put(ACCOUNT_SET_LIST, "retailStore");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(CONSUMER_ORDER_LIST, ConsumerOrder.class);

    refers.put(RETAIL_STORE_ORDER_LIST, RetailStoreOrder.class);

    refers.put(GOODS_LIST, Goods.class);

    refers.put(TRANSPORT_TASK_LIST, TransportTask.class);

    refers.put(ACCOUNT_SET_LIST, AccountSet.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, RetailStoreCountryCenter.class);
    parents.put(CITY_SERVICE_CENTER_PROPERTY, RetailStoreCityServiceCenter.class);
    parents.put(CREATION_PROPERTY, RetailStoreCreation.class);
    parents.put(INVESTMENT_INVITATION_PROPERTY, RetailStoreInvestmentInvitation.class);
    parents.put(FRANCHISING_PROPERTY, RetailStoreFranchising.class);
    parents.put(DECORATION_PROPERTY, RetailStoreDecoration.class);
    parents.put(OPENING_PROPERTY, RetailStoreOpening.class);
    parents.put(CLOSING_PROPERTY, RetailStoreClosing.class);

    return parents;
  }
  /*
  public RetailStore want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStore wants(Class<? extends BaseEntity>... classes) {
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
  protected String telephone;
  protected String owner;
  protected RetailStoreCountryCenter retailStoreCountryCenter;
  protected RetailStoreCityServiceCenter cityServiceCenter;
  protected RetailStoreCreation creation;
  protected RetailStoreInvestmentInvitation investmentInvitation;
  protected RetailStoreFranchising franchising;
  protected RetailStoreDecoration decoration;
  protected RetailStoreOpening opening;
  protected RetailStoreClosing closing;
  protected Date founded;
  protected BigDecimal latitude;
  protected BigDecimal longitude;
  protected String description;
  protected DateTime lastUpdateTime;
  protected int version;

  protected SmartList<ConsumerOrder> mConsumerOrderList;
  protected SmartList<RetailStoreOrder> mRetailStoreOrderList;
  protected SmartList<Goods> mGoodsList;
  protected SmartList<TransportTask> mTransportTaskList;
  protected SmartList<AccountSet> mAccountSetList;

  public RetailStore() {
    // lazy load for all the properties
  }

  public static RetailStore withId(String id) {
    RetailStore retailStore = new RetailStore();
    retailStore.setId(id);
    retailStore.setVersion(Integer.MAX_VALUE);
    retailStore.setChecked(true);
    return retailStore;
  }

  public static RetailStore refById(String id) {
    return withId(id);
  }

  public RetailStore limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public RetailStore limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static RetailStore searchExample() {
    RetailStore retailStore = new RetailStore();
    retailStore.setVersion(UNSET_INT);

    return retailStore;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setRetailStoreCountryCenter( null );
  	setCityServiceCenter( null );
  	setCreation( null );
  	setInvestmentInvitation( null );
  	setFranchising( null );
  	setDecoration( null );
  	setOpening( null );
  	setClosing( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (TELEPHONE_PROPERTY.equals(property)) {
      changeTelephoneProperty(newValueExpr);
    }
    if (OWNER_PROPERTY.equals(property)) {
      changeOwnerProperty(newValueExpr);
    }
    if (FOUNDED_PROPERTY.equals(property)) {
      changeFoundedProperty(newValueExpr);
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      changeLatitudeProperty(newValueExpr);
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      changeLongitudeProperty(newValueExpr);
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      changeDescriptionProperty(newValueExpr);
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      changeLastUpdateTimeProperty(newValueExpr);
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

  protected void changeTelephoneProperty(String newValueExpr) {

    String oldValue = getTelephone();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateTelephone(newValue);
    this.onChangeProperty(TELEPHONE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeOwnerProperty(String newValueExpr) {

    String oldValue = getOwner();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateOwner(newValue);
    this.onChangeProperty(OWNER_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeFoundedProperty(String newValueExpr) {

    Date oldValue = getFounded();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateFounded(newValue);
    this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLatitudeProperty(String newValueExpr) {

    BigDecimal oldValue = getLatitude();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLatitude(newValue);
    this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLongitudeProperty(String newValueExpr) {

    BigDecimal oldValue = getLongitude();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLongitude(newValue);
    this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDescriptionProperty(String newValueExpr) {

    String oldValue = getDescription();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDescription(newValue);
    this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLastUpdateTimeProperty(String newValueExpr) {

    DateTime oldValue = getLastUpdateTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLastUpdateTime(newValue);
    this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (TELEPHONE_PROPERTY.equals(property)) {
      return getTelephone();
    }
    if (OWNER_PROPERTY.equals(property)) {
      return getOwner();
    }
    if (RETAIL_STORE_COUNTRY_CENTER_PROPERTY.equals(property)) {
      return getRetailStoreCountryCenter();
    }
    if (CITY_SERVICE_CENTER_PROPERTY.equals(property)) {
      return getCityServiceCenter();
    }
    if (CREATION_PROPERTY.equals(property)) {
      return getCreation();
    }
    if (INVESTMENT_INVITATION_PROPERTY.equals(property)) {
      return getInvestmentInvitation();
    }
    if (FRANCHISING_PROPERTY.equals(property)) {
      return getFranchising();
    }
    if (DECORATION_PROPERTY.equals(property)) {
      return getDecoration();
    }
    if (OPENING_PROPERTY.equals(property)) {
      return getOpening();
    }
    if (CLOSING_PROPERTY.equals(property)) {
      return getClosing();
    }
    if (FOUNDED_PROPERTY.equals(property)) {
      return getFounded();
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      return getLatitude();
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      return getLongitude();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      return getLastUpdateTime();
    }
    if (CONSUMER_ORDER_LIST.equals(property)) {
      List<BaseEntity> list =
          getConsumerOrderList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (RETAIL_STORE_ORDER_LIST.equals(property)) {
      List<BaseEntity> list =
          getRetailStoreOrderList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (GOODS_LIST.equals(property)) {
      List<BaseEntity> list =
          getGoodsList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (TRANSPORT_TASK_LIST.equals(property)) {
      List<BaseEntity> list =
          getTransportTaskList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (ACCOUNT_SET_LIST.equals(property)) {
      List<BaseEntity> list =
          getAccountSetList().stream().map(item -> item).collect(Collectors.toList());
      return list;
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

  public RetailStore updateId(String id) {
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

  public RetailStore orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public RetailStore addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public RetailStore updateName(String name) {
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

  public RetailStore orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public RetailStore addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setTelephone(String telephone) {
    String oldTelephone = this.telephone;
    String newTelephone = trimString(telephone);
    this.telephone = newTelephone;
  }

  public String telephone() {
    doLoad();
    return getTelephone();
  }

  public String getTelephone() {
    return this.telephone;
  }

  public RetailStore updateTelephone(String telephone) {
    String oldTelephone = this.telephone;
    String newTelephone = trimString(telephone);
    if (!shouldReplaceBy(newTelephone, oldTelephone)) {
      return this;
    }
    this.telephone = newTelephone;
    if (cn.hutool.core.util.ObjectUtil.equals(newTelephone, oldTelephone)) {
      return this;
    }
    addPropertyChange(TELEPHONE_PROPERTY, oldTelephone, newTelephone);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByTelephone(boolean asc) {
    doAddOrderBy(TELEPHONE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTelephoneCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TELEPHONE_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreTelephoneCriteria() {
    super.ignoreSearchProperty(TELEPHONE_PROPERTY);
    return this;
  }

  public RetailStore addTelephoneCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTelephoneCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTelephone(String telephone) {
    if (telephone != null) {
      updateTelephone(telephone);
    }
  }

  public void setOwner(String owner) {
    String oldOwner = this.owner;
    String newOwner = trimString(owner);
    this.owner = newOwner;
  }

  public String owner() {
    doLoad();
    return getOwner();
  }

  public String getOwner() {
    return this.owner;
  }

  public RetailStore updateOwner(String owner) {
    String oldOwner = this.owner;
    String newOwner = trimString(owner);
    if (!shouldReplaceBy(newOwner, oldOwner)) {
      return this;
    }
    this.owner = newOwner;
    if (cn.hutool.core.util.ObjectUtil.equals(newOwner, oldOwner)) {
      return this;
    }
    addPropertyChange(OWNER_PROPERTY, oldOwner, newOwner);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByOwner(boolean asc) {
    doAddOrderBy(OWNER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OWNER_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreOwnerCriteria() {
    super.ignoreSearchProperty(OWNER_PROPERTY);
    return this;
  }

  public RetailStore addOwnerCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOwnerCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOwner(String owner) {
    if (owner != null) {
      updateOwner(owner);
    }
  }

  public void setRetailStoreCountryCenter(RetailStoreCountryCenter retailStoreCountryCenter) {
    RetailStoreCountryCenter oldRetailStoreCountryCenter = this.retailStoreCountryCenter;
    RetailStoreCountryCenter newRetailStoreCountryCenter = retailStoreCountryCenter;
    this.retailStoreCountryCenter = newRetailStoreCountryCenter;
  }

  public RetailStoreCountryCenter retailStoreCountryCenter() {
    doLoad();
    return getRetailStoreCountryCenter();
  }

  public RetailStoreCountryCenter getRetailStoreCountryCenter() {
    return this.retailStoreCountryCenter;
  }

  public RetailStore updateRetailStoreCountryCenter(
      RetailStoreCountryCenter retailStoreCountryCenter) {
    RetailStoreCountryCenter oldRetailStoreCountryCenter = this.retailStoreCountryCenter;
    RetailStoreCountryCenter newRetailStoreCountryCenter = retailStoreCountryCenter;
    if (!shouldReplaceBy(newRetailStoreCountryCenter, oldRetailStoreCountryCenter)) {
      return this;
    }
    this.retailStoreCountryCenter = newRetailStoreCountryCenter;
    if (cn.hutool.core.util.ObjectUtil.equals(
        newRetailStoreCountryCenter, oldRetailStoreCountryCenter)) {
      return this;
    }
    addPropertyChange(
        RETAIL_STORE_COUNTRY_CENTER_PROPERTY,
        oldRetailStoreCountryCenter,
        newRetailStoreCountryCenter);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByRetailStoreCountryCenter(boolean asc) {
    doAddOrderBy(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createRetailStoreCountryCenterCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreRetailStoreCountryCenterCriteria() {
    super.ignoreSearchProperty(RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
    return this;
  }

  public RetailStore addRetailStoreCountryCenterCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createRetailStoreCountryCenterCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeRetailStoreCountryCenter(RetailStoreCountryCenter retailStoreCountryCenter) {
    if (retailStoreCountryCenter != null) {
      updateRetailStoreCountryCenter(retailStoreCountryCenter);
    }
  }

  public RetailStore updateRetailStoreCountryCenterByReferenceId(
      String retailStoreCountryCenterId) {
    updateRetailStoreCountryCenter(RetailStoreCountryCenter.refById(retailStoreCountryCenterId));
    return this;
  }

  public void clearRetailStoreCountryCenter() {
    setRetailStoreCountryCenter(null);
    this.changed = true;
    setChecked(false);
  }

  public void setCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
    RetailStoreCityServiceCenter oldCityServiceCenter = this.cityServiceCenter;
    RetailStoreCityServiceCenter newCityServiceCenter = cityServiceCenter;
    this.cityServiceCenter = newCityServiceCenter;
  }

  public RetailStoreCityServiceCenter cityServiceCenter() {
    doLoad();
    return getCityServiceCenter();
  }

  public RetailStoreCityServiceCenter getCityServiceCenter() {
    return this.cityServiceCenter;
  }

  public RetailStore updateCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
    RetailStoreCityServiceCenter oldCityServiceCenter = this.cityServiceCenter;
    RetailStoreCityServiceCenter newCityServiceCenter = cityServiceCenter;
    if (!shouldReplaceBy(newCityServiceCenter, oldCityServiceCenter)) {
      return this;
    }
    this.cityServiceCenter = newCityServiceCenter;
    if (cn.hutool.core.util.ObjectUtil.equals(newCityServiceCenter, oldCityServiceCenter)) {
      return this;
    }
    addPropertyChange(CITY_SERVICE_CENTER_PROPERTY, oldCityServiceCenter, newCityServiceCenter);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByCityServiceCenter(boolean asc) {
    doAddOrderBy(CITY_SERVICE_CENTER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCityServiceCenterCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(CITY_SERVICE_CENTER_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreCityServiceCenterCriteria() {
    super.ignoreSearchProperty(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public RetailStore addCityServiceCenterCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCityServiceCenterCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
    if (cityServiceCenter != null) {
      updateCityServiceCenter(cityServiceCenter);
    }
  }

  public RetailStore updateCityServiceCenterByReferenceId(String cityServiceCenterId) {
    updateCityServiceCenter(RetailStoreCityServiceCenter.refById(cityServiceCenterId));
    return this;
  }

  public void clearCityServiceCenter() {
    setCityServiceCenter(null);
    this.changed = true;
    setChecked(false);
  }

  public void setCreation(RetailStoreCreation creation) {
    RetailStoreCreation oldCreation = this.creation;
    RetailStoreCreation newCreation = creation;
    this.creation = newCreation;
  }

  public RetailStoreCreation creation() {
    doLoad();
    return getCreation();
  }

  public RetailStoreCreation getCreation() {
    return this.creation;
  }

  public RetailStore updateCreation(RetailStoreCreation creation) {
    RetailStoreCreation oldCreation = this.creation;
    RetailStoreCreation newCreation = creation;
    if (!shouldReplaceBy(newCreation, oldCreation)) {
      return this;
    }
    this.creation = newCreation;
    if (cn.hutool.core.util.ObjectUtil.equals(newCreation, oldCreation)) {
      return this;
    }
    addPropertyChange(CREATION_PROPERTY, oldCreation, newCreation);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByCreation(boolean asc) {
    doAddOrderBy(CREATION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCreationCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CREATION_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreCreationCriteria() {
    super.ignoreSearchProperty(CREATION_PROPERTY);
    return this;
  }

  public RetailStore addCreationCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCreationCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCreation(RetailStoreCreation creation) {
    if (creation != null) {
      updateCreation(creation);
    }
  }

  public RetailStore updateCreationByReferenceId(String creationId) {
    updateCreation(RetailStoreCreation.refById(creationId));
    return this;
  }

  public void clearCreation() {
    setCreation(null);
    this.changed = true;
    setChecked(false);
  }

  public void setInvestmentInvitation(RetailStoreInvestmentInvitation investmentInvitation) {
    RetailStoreInvestmentInvitation oldInvestmentInvitation = this.investmentInvitation;
    RetailStoreInvestmentInvitation newInvestmentInvitation = investmentInvitation;
    this.investmentInvitation = newInvestmentInvitation;
  }

  public RetailStoreInvestmentInvitation investmentInvitation() {
    doLoad();
    return getInvestmentInvitation();
  }

  public RetailStoreInvestmentInvitation getInvestmentInvitation() {
    return this.investmentInvitation;
  }

  public RetailStore updateInvestmentInvitation(
      RetailStoreInvestmentInvitation investmentInvitation) {
    RetailStoreInvestmentInvitation oldInvestmentInvitation = this.investmentInvitation;
    RetailStoreInvestmentInvitation newInvestmentInvitation = investmentInvitation;
    if (!shouldReplaceBy(newInvestmentInvitation, oldInvestmentInvitation)) {
      return this;
    }
    this.investmentInvitation = newInvestmentInvitation;
    if (cn.hutool.core.util.ObjectUtil.equals(newInvestmentInvitation, oldInvestmentInvitation)) {
      return this;
    }
    addPropertyChange(
        INVESTMENT_INVITATION_PROPERTY, oldInvestmentInvitation, newInvestmentInvitation);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByInvestmentInvitation(boolean asc) {
    doAddOrderBy(INVESTMENT_INVITATION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createInvestmentInvitationCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(INVESTMENT_INVITATION_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreInvestmentInvitationCriteria() {
    super.ignoreSearchProperty(INVESTMENT_INVITATION_PROPERTY);
    return this;
  }

  public RetailStore addInvestmentInvitationCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createInvestmentInvitationCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeInvestmentInvitation(RetailStoreInvestmentInvitation investmentInvitation) {
    if (investmentInvitation != null) {
      updateInvestmentInvitation(investmentInvitation);
    }
  }

  public RetailStore updateInvestmentInvitationByReferenceId(String investmentInvitationId) {
    updateInvestmentInvitation(RetailStoreInvestmentInvitation.refById(investmentInvitationId));
    return this;
  }

  public void clearInvestmentInvitation() {
    setInvestmentInvitation(null);
    this.changed = true;
    setChecked(false);
  }

  public void setFranchising(RetailStoreFranchising franchising) {
    RetailStoreFranchising oldFranchising = this.franchising;
    RetailStoreFranchising newFranchising = franchising;
    this.franchising = newFranchising;
  }

  public RetailStoreFranchising franchising() {
    doLoad();
    return getFranchising();
  }

  public RetailStoreFranchising getFranchising() {
    return this.franchising;
  }

  public RetailStore updateFranchising(RetailStoreFranchising franchising) {
    RetailStoreFranchising oldFranchising = this.franchising;
    RetailStoreFranchising newFranchising = franchising;
    if (!shouldReplaceBy(newFranchising, oldFranchising)) {
      return this;
    }
    this.franchising = newFranchising;
    if (cn.hutool.core.util.ObjectUtil.equals(newFranchising, oldFranchising)) {
      return this;
    }
    addPropertyChange(FRANCHISING_PROPERTY, oldFranchising, newFranchising);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByFranchising(boolean asc) {
    doAddOrderBy(FRANCHISING_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFranchisingCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FRANCHISING_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreFranchisingCriteria() {
    super.ignoreSearchProperty(FRANCHISING_PROPERTY);
    return this;
  }

  public RetailStore addFranchisingCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFranchisingCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFranchising(RetailStoreFranchising franchising) {
    if (franchising != null) {
      updateFranchising(franchising);
    }
  }

  public RetailStore updateFranchisingByReferenceId(String franchisingId) {
    updateFranchising(RetailStoreFranchising.refById(franchisingId));
    return this;
  }

  public void clearFranchising() {
    setFranchising(null);
    this.changed = true;
    setChecked(false);
  }

  public void setDecoration(RetailStoreDecoration decoration) {
    RetailStoreDecoration oldDecoration = this.decoration;
    RetailStoreDecoration newDecoration = decoration;
    this.decoration = newDecoration;
  }

  public RetailStoreDecoration decoration() {
    doLoad();
    return getDecoration();
  }

  public RetailStoreDecoration getDecoration() {
    return this.decoration;
  }

  public RetailStore updateDecoration(RetailStoreDecoration decoration) {
    RetailStoreDecoration oldDecoration = this.decoration;
    RetailStoreDecoration newDecoration = decoration;
    if (!shouldReplaceBy(newDecoration, oldDecoration)) {
      return this;
    }
    this.decoration = newDecoration;
    if (cn.hutool.core.util.ObjectUtil.equals(newDecoration, oldDecoration)) {
      return this;
    }
    addPropertyChange(DECORATION_PROPERTY, oldDecoration, newDecoration);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByDecoration(boolean asc) {
    doAddOrderBy(DECORATION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDecorationCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DECORATION_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreDecorationCriteria() {
    super.ignoreSearchProperty(DECORATION_PROPERTY);
    return this;
  }

  public RetailStore addDecorationCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDecorationCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDecoration(RetailStoreDecoration decoration) {
    if (decoration != null) {
      updateDecoration(decoration);
    }
  }

  public RetailStore updateDecorationByReferenceId(String decorationId) {
    updateDecoration(RetailStoreDecoration.refById(decorationId));
    return this;
  }

  public void clearDecoration() {
    setDecoration(null);
    this.changed = true;
    setChecked(false);
  }

  public void setOpening(RetailStoreOpening opening) {
    RetailStoreOpening oldOpening = this.opening;
    RetailStoreOpening newOpening = opening;
    this.opening = newOpening;
  }

  public RetailStoreOpening opening() {
    doLoad();
    return getOpening();
  }

  public RetailStoreOpening getOpening() {
    return this.opening;
  }

  public RetailStore updateOpening(RetailStoreOpening opening) {
    RetailStoreOpening oldOpening = this.opening;
    RetailStoreOpening newOpening = opening;
    if (!shouldReplaceBy(newOpening, oldOpening)) {
      return this;
    }
    this.opening = newOpening;
    if (cn.hutool.core.util.ObjectUtil.equals(newOpening, oldOpening)) {
      return this;
    }
    addPropertyChange(OPENING_PROPERTY, oldOpening, newOpening);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByOpening(boolean asc) {
    doAddOrderBy(OPENING_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOpeningCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OPENING_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreOpeningCriteria() {
    super.ignoreSearchProperty(OPENING_PROPERTY);
    return this;
  }

  public RetailStore addOpeningCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOpeningCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOpening(RetailStoreOpening opening) {
    if (opening != null) {
      updateOpening(opening);
    }
  }

  public RetailStore updateOpeningByReferenceId(String openingId) {
    updateOpening(RetailStoreOpening.refById(openingId));
    return this;
  }

  public void clearOpening() {
    setOpening(null);
    this.changed = true;
    setChecked(false);
  }

  public void setClosing(RetailStoreClosing closing) {
    RetailStoreClosing oldClosing = this.closing;
    RetailStoreClosing newClosing = closing;
    this.closing = newClosing;
  }

  public RetailStoreClosing closing() {
    doLoad();
    return getClosing();
  }

  public RetailStoreClosing getClosing() {
    return this.closing;
  }

  public RetailStore updateClosing(RetailStoreClosing closing) {
    RetailStoreClosing oldClosing = this.closing;
    RetailStoreClosing newClosing = closing;
    if (!shouldReplaceBy(newClosing, oldClosing)) {
      return this;
    }
    this.closing = newClosing;
    if (cn.hutool.core.util.ObjectUtil.equals(newClosing, oldClosing)) {
      return this;
    }
    addPropertyChange(CLOSING_PROPERTY, oldClosing, newClosing);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByClosing(boolean asc) {
    doAddOrderBy(CLOSING_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createClosingCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CLOSING_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreClosingCriteria() {
    super.ignoreSearchProperty(CLOSING_PROPERTY);
    return this;
  }

  public RetailStore addClosingCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createClosingCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeClosing(RetailStoreClosing closing) {
    if (closing != null) {
      updateClosing(closing);
    }
  }

  public RetailStore updateClosingByReferenceId(String closingId) {
    updateClosing(RetailStoreClosing.refById(closingId));
    return this;
  }

  public void clearClosing() {
    setClosing(null);
    this.changed = true;
    setChecked(false);
  }

  public void setFounded(Date founded) {
    Date oldFounded = this.founded;
    Date newFounded = founded;
    this.founded = newFounded;
  }

  public Date founded() {
    doLoad();
    return getFounded();
  }

  public Date getFounded() {
    return this.founded;
  }

  public RetailStore updateFounded(Date founded) {
    Date oldFounded = this.founded;
    Date newFounded = founded;
    if (!shouldReplaceBy(newFounded, oldFounded)) {
      return this;
    }
    this.founded = newFounded;
    if (cn.hutool.core.util.ObjectUtil.equals(newFounded, oldFounded)) {
      return this;
    }
    addPropertyChange(FOUNDED_PROPERTY, oldFounded, newFounded);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByFounded(boolean asc) {
    doAddOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFoundedCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FOUNDED_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreFoundedCriteria() {
    super.ignoreSearchProperty(FOUNDED_PROPERTY);
    return this;
  }

  public RetailStore addFoundedCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFoundedCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFounded(Date founded) {
    updateFounded(founded);
  }

  public void setLatitude(BigDecimal latitude) {
    BigDecimal oldLatitude = this.latitude;
    BigDecimal newLatitude = latitude;
    this.latitude = newLatitude;
  }

  public BigDecimal latitude() {
    doLoad();
    return getLatitude();
  }

  public BigDecimal getLatitude() {
    return this.latitude;
  }

  public RetailStore updateLatitude(BigDecimal latitude) {
    BigDecimal oldLatitude = this.latitude;
    BigDecimal newLatitude = latitude;
    if (!shouldReplaceBy(newLatitude, oldLatitude)) {
      return this;
    }
    this.latitude = newLatitude;
    if (cn.hutool.core.util.ObjectUtil.equals(newLatitude, oldLatitude)) {
      return this;
    }
    addPropertyChange(LATITUDE_PROPERTY, oldLatitude, newLatitude);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByLatitude(boolean asc) {
    doAddOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLatitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LATITUDE_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreLatitudeCriteria() {
    super.ignoreSearchProperty(LATITUDE_PROPERTY);
    return this;
  }

  public RetailStore addLatitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLatitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLatitude(BigDecimal latitude) {
    updateLatitude(latitude);
  }

  public void setLongitude(BigDecimal longitude) {
    BigDecimal oldLongitude = this.longitude;
    BigDecimal newLongitude = longitude;
    this.longitude = newLongitude;
  }

  public BigDecimal longitude() {
    doLoad();
    return getLongitude();
  }

  public BigDecimal getLongitude() {
    return this.longitude;
  }

  public RetailStore updateLongitude(BigDecimal longitude) {
    BigDecimal oldLongitude = this.longitude;
    BigDecimal newLongitude = longitude;
    if (!shouldReplaceBy(newLongitude, oldLongitude)) {
      return this;
    }
    this.longitude = newLongitude;
    if (cn.hutool.core.util.ObjectUtil.equals(newLongitude, oldLongitude)) {
      return this;
    }
    addPropertyChange(LONGITUDE_PROPERTY, oldLongitude, newLongitude);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByLongitude(boolean asc) {
    doAddOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLongitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LONGITUDE_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreLongitudeCriteria() {
    super.ignoreSearchProperty(LONGITUDE_PROPERTY);
    return this;
  }

  public RetailStore addLongitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLongitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLongitude(BigDecimal longitude) {
    updateLongitude(longitude);
  }

  public void setDescription(String description) {
    String oldDescription = this.description;
    String newDescription = trimString(description);
    this.description = newDescription;
  }

  public String description() {
    doLoad();
    return getDescription();
  }

  public String getDescription() {
    return this.description;
  }

  public RetailStore updateDescription(String description) {
    String oldDescription = this.description;
    String newDescription = trimString(description);
    if (!shouldReplaceBy(newDescription, oldDescription)) {
      return this;
    }
    this.description = newDescription;
    if (cn.hutool.core.util.ObjectUtil.equals(newDescription, oldDescription)) {
      return this;
    }
    addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public RetailStore addDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDescription(String description) {
    if (description != null) {
      updateDescription(description);
    }
  }

  public void setLastUpdateTime(DateTime lastUpdateTime) {
    DateTime oldLastUpdateTime = this.lastUpdateTime;
    DateTime newLastUpdateTime = lastUpdateTime;
    this.lastUpdateTime = newLastUpdateTime;
  }

  public DateTime lastUpdateTime() {
    doLoad();
    return getLastUpdateTime();
  }

  public DateTime getLastUpdateTime() {
    return this.lastUpdateTime;
  }

  public RetailStore updateLastUpdateTime(DateTime lastUpdateTime) {
    DateTime oldLastUpdateTime = this.lastUpdateTime;
    DateTime newLastUpdateTime = lastUpdateTime;
    if (!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)) {
      return this;
    }
    this.lastUpdateTime = newLastUpdateTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newLastUpdateTime, oldLastUpdateTime)) {
      return this;
    }
    addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStore orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public RetailStore addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLastUpdateTime(DateTime lastUpdateTime) {
    updateLastUpdateTime(lastUpdateTime);
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

  public RetailStore updateVersion(int version) {
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

  public RetailStore orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public RetailStore ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public RetailStore addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<ConsumerOrder> getConsumerOrderList() {
    if (this.mConsumerOrderList == null) {
      this.mConsumerOrderList = new SmartList<ConsumerOrder>();
      this.mConsumerOrderList.setListInternalName(CONSUMER_ORDER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mConsumerOrderList;
  }

  public SmartList<ConsumerOrder> consumerOrderList() {

    doLoadChild(CONSUMER_ORDER_LIST);

    return getConsumerOrderList();
  }

  public void setConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList) {
    for (ConsumerOrder consumerOrder : consumerOrderList) {
      consumerOrder.setStore(this);
    }

    this.mConsumerOrderList = consumerOrderList;
    this.mConsumerOrderList.setListInternalName(CONSUMER_ORDER_LIST);
  }

  public RetailStore addConsumerOrder(ConsumerOrder consumerOrder) {
    consumerOrder.updateStore(this);
    getConsumerOrderList().add(consumerOrder);
    return this;
  }

  public RetailStore addConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList) {
    for (ConsumerOrder consumerOrder : consumerOrderList) {
      consumerOrder.updateStore(this);
    }

    Map<String, ConsumerOrder> mapById = consumerOrderList.mapWithId();
    getConsumerOrderList().removeIf(item -> mapById.get(item.getId()) != null);
    getConsumerOrderList().addAll(consumerOrderList);
    return this;
  }

  public void mergeConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList) {
    if (consumerOrderList == null) {
      return;
    }
    if (consumerOrderList.isEmpty()) {
      return;
    }
    addConsumerOrderList(consumerOrderList);
  }

  public ConsumerOrder removeConsumerOrder(ConsumerOrder consumerOrderIndex) {

    int index = getConsumerOrderList().indexOf(consumerOrderIndex);
    if (index < 0) {
      String message =
          "ConsumerOrder("
              + consumerOrderIndex.getId()
              + ") with version='"
              + consumerOrderIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    ConsumerOrder consumerOrder = getConsumerOrderList().get(index);
    // consumerOrder.clearStore(); //disconnect with Store
    consumerOrder.clearFromAll(); // disconnect with Store

    boolean result = getConsumerOrderList().planToRemove(consumerOrder);
    if (!result) {
      String message =
          "ConsumerOrder("
              + consumerOrderIndex.getId()
              + ") with version='"
              + consumerOrderIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return consumerOrder;
  }
  // 断舍离
  public void breakWithConsumerOrder(ConsumerOrder consumerOrder) {

    if (consumerOrder == null) {
      return;
    }
    consumerOrder.setStore(null);
    // getConsumerOrderList().remove();

  }

  public boolean hasConsumerOrder(ConsumerOrder consumerOrder) {

    return getConsumerOrderList().contains(consumerOrder);
  }

  public void copyConsumerOrderFrom(ConsumerOrder consumerOrder) {

    ConsumerOrder consumerOrderInList = findTheConsumerOrder(consumerOrder);
    ConsumerOrder newConsumerOrder = new ConsumerOrder();
    consumerOrderInList.copyTo(newConsumerOrder);
    newConsumerOrder.setVersion(0); // will trigger copy
    getConsumerOrderList().add(newConsumerOrder);
    addItemToFlexiableObject(COPIED_CHILD, newConsumerOrder);
  }

  public ConsumerOrder findTheConsumerOrder(ConsumerOrder consumerOrder) {

    int index = getConsumerOrderList().indexOf(consumerOrder);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "ConsumerOrder("
              + consumerOrder.getId()
              + ") with version='"
              + consumerOrder.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getConsumerOrderList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpConsumerOrderList() {
    getConsumerOrderList().clear();
  }

  public SmartList<RetailStoreOrder> getRetailStoreOrderList() {
    if (this.mRetailStoreOrderList == null) {
      this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
      this.mRetailStoreOrderList.setListInternalName(RETAIL_STORE_ORDER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mRetailStoreOrderList;
  }

  public SmartList<RetailStoreOrder> retailStoreOrderList() {

    doLoadChild(RETAIL_STORE_ORDER_LIST);

    return getRetailStoreOrderList();
  }

  public void setRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList) {
    for (RetailStoreOrder retailStoreOrder : retailStoreOrderList) {
      retailStoreOrder.setBuyer(this);
    }

    this.mRetailStoreOrderList = retailStoreOrderList;
    this.mRetailStoreOrderList.setListInternalName(RETAIL_STORE_ORDER_LIST);
  }

  public RetailStore addRetailStoreOrder(RetailStoreOrder retailStoreOrder) {
    retailStoreOrder.updateBuyer(this);
    getRetailStoreOrderList().add(retailStoreOrder);
    return this;
  }

  public RetailStore addRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList) {
    for (RetailStoreOrder retailStoreOrder : retailStoreOrderList) {
      retailStoreOrder.updateBuyer(this);
    }

    Map<String, RetailStoreOrder> mapById = retailStoreOrderList.mapWithId();
    getRetailStoreOrderList().removeIf(item -> mapById.get(item.getId()) != null);
    getRetailStoreOrderList().addAll(retailStoreOrderList);
    return this;
  }

  public void mergeRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList) {
    if (retailStoreOrderList == null) {
      return;
    }
    if (retailStoreOrderList.isEmpty()) {
      return;
    }
    addRetailStoreOrderList(retailStoreOrderList);
  }

  public RetailStoreOrder removeRetailStoreOrder(RetailStoreOrder retailStoreOrderIndex) {

    int index = getRetailStoreOrderList().indexOf(retailStoreOrderIndex);
    if (index < 0) {
      String message =
          "RetailStoreOrder("
              + retailStoreOrderIndex.getId()
              + ") with version='"
              + retailStoreOrderIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    RetailStoreOrder retailStoreOrder = getRetailStoreOrderList().get(index);
    // retailStoreOrder.clearBuyer(); //disconnect with Buyer
    retailStoreOrder.clearFromAll(); // disconnect with Buyer

    boolean result = getRetailStoreOrderList().planToRemove(retailStoreOrder);
    if (!result) {
      String message =
          "RetailStoreOrder("
              + retailStoreOrderIndex.getId()
              + ") with version='"
              + retailStoreOrderIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return retailStoreOrder;
  }
  // 断舍离
  public void breakWithRetailStoreOrder(RetailStoreOrder retailStoreOrder) {

    if (retailStoreOrder == null) {
      return;
    }
    retailStoreOrder.setBuyer(null);
    // getRetailStoreOrderList().remove();

  }

  public boolean hasRetailStoreOrder(RetailStoreOrder retailStoreOrder) {

    return getRetailStoreOrderList().contains(retailStoreOrder);
  }

  public void copyRetailStoreOrderFrom(RetailStoreOrder retailStoreOrder) {

    RetailStoreOrder retailStoreOrderInList = findTheRetailStoreOrder(retailStoreOrder);
    RetailStoreOrder newRetailStoreOrder = new RetailStoreOrder();
    retailStoreOrderInList.copyTo(newRetailStoreOrder);
    newRetailStoreOrder.setVersion(0); // will trigger copy
    getRetailStoreOrderList().add(newRetailStoreOrder);
    addItemToFlexiableObject(COPIED_CHILD, newRetailStoreOrder);
  }

  public RetailStoreOrder findTheRetailStoreOrder(RetailStoreOrder retailStoreOrder) {

    int index = getRetailStoreOrderList().indexOf(retailStoreOrder);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "RetailStoreOrder("
              + retailStoreOrder.getId()
              + ") with version='"
              + retailStoreOrder.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getRetailStoreOrderList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpRetailStoreOrderList() {
    getRetailStoreOrderList().clear();
  }

  public SmartList<Goods> getGoodsList() {
    if (this.mGoodsList == null) {
      this.mGoodsList = new SmartList<Goods>();
      this.mGoodsList.setListInternalName(GOODS_LIST);
      // 有名字，便于做权限控制
    }

    return this.mGoodsList;
  }

  public SmartList<Goods> goodsList() {

    doLoadChild(GOODS_LIST);

    return getGoodsList();
  }

  public void setGoodsList(SmartList<Goods> goodsList) {
    for (Goods goods : goodsList) {
      goods.setRetailStore(this);
    }

    this.mGoodsList = goodsList;
    this.mGoodsList.setListInternalName(GOODS_LIST);
  }

  public RetailStore addGoods(Goods goods) {
    goods.updateRetailStore(this);
    getGoodsList().add(goods);
    return this;
  }

  public RetailStore addGoodsList(SmartList<Goods> goodsList) {
    for (Goods goods : goodsList) {
      goods.updateRetailStore(this);
    }

    Map<String, Goods> mapById = goodsList.mapWithId();
    getGoodsList().removeIf(item -> mapById.get(item.getId()) != null);
    getGoodsList().addAll(goodsList);
    return this;
  }

  public void mergeGoodsList(SmartList<Goods> goodsList) {
    if (goodsList == null) {
      return;
    }
    if (goodsList.isEmpty()) {
      return;
    }
    addGoodsList(goodsList);
  }

  public Goods removeGoods(Goods goodsIndex) {

    int index = getGoodsList().indexOf(goodsIndex);
    if (index < 0) {
      String message =
          "Goods("
              + goodsIndex.getId()
              + ") with version='"
              + goodsIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Goods goods = getGoodsList().get(index);
    // goods.clearRetailStore(); //disconnect with RetailStore
    goods.clearFromAll(); // disconnect with RetailStore

    boolean result = getGoodsList().planToRemove(goods);
    if (!result) {
      String message =
          "Goods("
              + goodsIndex.getId()
              + ") with version='"
              + goodsIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return goods;
  }
  // 断舍离
  public void breakWithGoods(Goods goods) {

    if (goods == null) {
      return;
    }
    goods.setRetailStore(null);
    // getGoodsList().remove();

  }

  public boolean hasGoods(Goods goods) {

    return getGoodsList().contains(goods);
  }

  public void copyGoodsFrom(Goods goods) {

    Goods goodsInList = findTheGoods(goods);
    Goods newGoods = new Goods();
    goodsInList.copyTo(newGoods);
    newGoods.setVersion(0); // will trigger copy
    getGoodsList().add(newGoods);
    addItemToFlexiableObject(COPIED_CHILD, newGoods);
  }

  public Goods findTheGoods(Goods goods) {

    int index = getGoodsList().indexOf(goods);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Goods(" + goods.getId() + ") with version='" + goods.getVersion() + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getGoodsList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpGoodsList() {
    getGoodsList().clear();
  }

  public SmartList<TransportTask> getTransportTaskList() {
    if (this.mTransportTaskList == null) {
      this.mTransportTaskList = new SmartList<TransportTask>();
      this.mTransportTaskList.setListInternalName(TRANSPORT_TASK_LIST);
      // 有名字，便于做权限控制
    }

    return this.mTransportTaskList;
  }

  public SmartList<TransportTask> transportTaskList() {

    doLoadChild(TRANSPORT_TASK_LIST);

    return getTransportTaskList();
  }

  public void setTransportTaskList(SmartList<TransportTask> transportTaskList) {
    for (TransportTask transportTask : transportTaskList) {
      transportTask.setEnd(this);
    }

    this.mTransportTaskList = transportTaskList;
    this.mTransportTaskList.setListInternalName(TRANSPORT_TASK_LIST);
  }

  public RetailStore addTransportTask(TransportTask transportTask) {
    transportTask.updateEnd(this);
    getTransportTaskList().add(transportTask);
    return this;
  }

  public RetailStore addTransportTaskList(SmartList<TransportTask> transportTaskList) {
    for (TransportTask transportTask : transportTaskList) {
      transportTask.updateEnd(this);
    }

    Map<String, TransportTask> mapById = transportTaskList.mapWithId();
    getTransportTaskList().removeIf(item -> mapById.get(item.getId()) != null);
    getTransportTaskList().addAll(transportTaskList);
    return this;
  }

  public void mergeTransportTaskList(SmartList<TransportTask> transportTaskList) {
    if (transportTaskList == null) {
      return;
    }
    if (transportTaskList.isEmpty()) {
      return;
    }
    addTransportTaskList(transportTaskList);
  }

  public TransportTask removeTransportTask(TransportTask transportTaskIndex) {

    int index = getTransportTaskList().indexOf(transportTaskIndex);
    if (index < 0) {
      String message =
          "TransportTask("
              + transportTaskIndex.getId()
              + ") with version='"
              + transportTaskIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    TransportTask transportTask = getTransportTaskList().get(index);
    // transportTask.clearEnd(); //disconnect with End
    transportTask.clearFromAll(); // disconnect with End

    boolean result = getTransportTaskList().planToRemove(transportTask);
    if (!result) {
      String message =
          "TransportTask("
              + transportTaskIndex.getId()
              + ") with version='"
              + transportTaskIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return transportTask;
  }
  // 断舍离
  public void breakWithTransportTask(TransportTask transportTask) {

    if (transportTask == null) {
      return;
    }
    transportTask.setEnd(null);
    // getTransportTaskList().remove();

  }

  public boolean hasTransportTask(TransportTask transportTask) {

    return getTransportTaskList().contains(transportTask);
  }

  public void copyTransportTaskFrom(TransportTask transportTask) {

    TransportTask transportTaskInList = findTheTransportTask(transportTask);
    TransportTask newTransportTask = new TransportTask();
    transportTaskInList.copyTo(newTransportTask);
    newTransportTask.setVersion(0); // will trigger copy
    getTransportTaskList().add(newTransportTask);
    addItemToFlexiableObject(COPIED_CHILD, newTransportTask);
  }

  public TransportTask findTheTransportTask(TransportTask transportTask) {

    int index = getTransportTaskList().indexOf(transportTask);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "TransportTask("
              + transportTask.getId()
              + ") with version='"
              + transportTask.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getTransportTaskList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpTransportTaskList() {
    getTransportTaskList().clear();
  }

  public SmartList<AccountSet> getAccountSetList() {
    if (this.mAccountSetList == null) {
      this.mAccountSetList = new SmartList<AccountSet>();
      this.mAccountSetList.setListInternalName(ACCOUNT_SET_LIST);
      // 有名字，便于做权限控制
    }

    return this.mAccountSetList;
  }

  public SmartList<AccountSet> accountSetList() {

    doLoadChild(ACCOUNT_SET_LIST);

    return getAccountSetList();
  }

  public void setAccountSetList(SmartList<AccountSet> accountSetList) {
    for (AccountSet accountSet : accountSetList) {
      accountSet.setRetailStore(this);
    }

    this.mAccountSetList = accountSetList;
    this.mAccountSetList.setListInternalName(ACCOUNT_SET_LIST);
  }

  public RetailStore addAccountSet(AccountSet accountSet) {
    accountSet.updateRetailStore(this);
    getAccountSetList().add(accountSet);
    return this;
  }

  public RetailStore addAccountSetList(SmartList<AccountSet> accountSetList) {
    for (AccountSet accountSet : accountSetList) {
      accountSet.updateRetailStore(this);
    }

    Map<String, AccountSet> mapById = accountSetList.mapWithId();
    getAccountSetList().removeIf(item -> mapById.get(item.getId()) != null);
    getAccountSetList().addAll(accountSetList);
    return this;
  }

  public void mergeAccountSetList(SmartList<AccountSet> accountSetList) {
    if (accountSetList == null) {
      return;
    }
    if (accountSetList.isEmpty()) {
      return;
    }
    addAccountSetList(accountSetList);
  }

  public AccountSet removeAccountSet(AccountSet accountSetIndex) {

    int index = getAccountSetList().indexOf(accountSetIndex);
    if (index < 0) {
      String message =
          "AccountSet("
              + accountSetIndex.getId()
              + ") with version='"
              + accountSetIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    AccountSet accountSet = getAccountSetList().get(index);
    // accountSet.clearRetailStore(); //disconnect with RetailStore
    accountSet.clearFromAll(); // disconnect with RetailStore

    boolean result = getAccountSetList().planToRemove(accountSet);
    if (!result) {
      String message =
          "AccountSet("
              + accountSetIndex.getId()
              + ") with version='"
              + accountSetIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return accountSet;
  }
  // 断舍离
  public void breakWithAccountSet(AccountSet accountSet) {

    if (accountSet == null) {
      return;
    }
    accountSet.setRetailStore(null);
    // getAccountSetList().remove();

  }

  public boolean hasAccountSet(AccountSet accountSet) {

    return getAccountSetList().contains(accountSet);
  }

  public void copyAccountSetFrom(AccountSet accountSet) {

    AccountSet accountSetInList = findTheAccountSet(accountSet);
    AccountSet newAccountSet = new AccountSet();
    accountSetInList.copyTo(newAccountSet);
    newAccountSet.setVersion(0); // will trigger copy
    getAccountSetList().add(newAccountSet);
    addItemToFlexiableObject(COPIED_CHILD, newAccountSet);
  }

  public AccountSet findTheAccountSet(AccountSet accountSet) {

    int index = getAccountSetList().indexOf(accountSet);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "AccountSet("
              + accountSet.getId()
              + ") with version='"
              + accountSet.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getAccountSetList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpAccountSetList() {
    getAccountSetList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getRetailStoreCountryCenter(), internalType);
    addToEntityList(this, entityList, getCityServiceCenter(), internalType);
    addToEntityList(this, entityList, getCreation(), internalType);
    addToEntityList(this, entityList, getInvestmentInvitation(), internalType);
    addToEntityList(this, entityList, getFranchising(), internalType);
    addToEntityList(this, entityList, getDecoration(), internalType);
    addToEntityList(this, entityList, getOpening(), internalType);
    addToEntityList(this, entityList, getClosing(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getConsumerOrderList(), internalType);
    collectFromList(this, entityList, getRetailStoreOrderList(), internalType);
    collectFromList(this, entityList, getGoodsList(), internalType);
    collectFromList(this, entityList, getTransportTaskList(), internalType);
    collectFromList(this, entityList, getAccountSetList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getConsumerOrderList());
    listOfList.add(getRetailStoreOrderList());
    listOfList.add(getGoodsList());
    listOfList.add(getTransportTaskList());
    listOfList.add(getAccountSetList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, TELEPHONE_PROPERTY, getTelephone());
    appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
    appendKeyValuePair(result, RETAIL_STORE_COUNTRY_CENTER_PROPERTY, getRetailStoreCountryCenter());
    appendKeyValuePair(result, CITY_SERVICE_CENTER_PROPERTY, getCityServiceCenter());
    appendKeyValuePair(result, CREATION_PROPERTY, getCreation());
    appendKeyValuePair(result, INVESTMENT_INVITATION_PROPERTY, getInvestmentInvitation());
    appendKeyValuePair(result, FRANCHISING_PROPERTY, getFranchising());
    appendKeyValuePair(result, DECORATION_PROPERTY, getDecoration());
    appendKeyValuePair(result, OPENING_PROPERTY, getOpening());
    appendKeyValuePair(result, CLOSING_PROPERTY, getClosing());
    appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
    appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
    appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, CONSUMER_ORDER_LIST, getConsumerOrderList());
    if (!getConsumerOrderList().isEmpty()) {
      appendKeyValuePair(result, "consumerOrderCount", getConsumerOrderList().getTotalCount());
      appendKeyValuePair(
          result, "consumerOrderCurrentPageNumber", getConsumerOrderList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, RETAIL_STORE_ORDER_LIST, getRetailStoreOrderList());
    if (!getRetailStoreOrderList().isEmpty()) {
      appendKeyValuePair(
          result, "retailStoreOrderCount", getRetailStoreOrderList().getTotalCount());
      appendKeyValuePair(
          result,
          "retailStoreOrderCurrentPageNumber",
          getRetailStoreOrderList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, GOODS_LIST, getGoodsList());
    if (!getGoodsList().isEmpty()) {
      appendKeyValuePair(result, "goodsCount", getGoodsList().getTotalCount());
      appendKeyValuePair(result, "goodsCurrentPageNumber", getGoodsList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, TRANSPORT_TASK_LIST, getTransportTaskList());
    if (!getTransportTaskList().isEmpty()) {
      appendKeyValuePair(result, "transportTaskCount", getTransportTaskList().getTotalCount());
      appendKeyValuePair(
          result, "transportTaskCurrentPageNumber", getTransportTaskList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, ACCOUNT_SET_LIST, getAccountSetList());
    if (!getAccountSetList().isEmpty()) {
      appendKeyValuePair(result, "accountSetCount", getAccountSetList().getTotalCount());
      appendKeyValuePair(
          result, "accountSetCurrentPageNumber", getAccountSetList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof RetailStore) {

      RetailStore dest = (RetailStore) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setTelephone(getTelephone());
      dest.setOwner(getOwner());
      dest.setRetailStoreCountryCenter(getRetailStoreCountryCenter());
      dest.setCityServiceCenter(getCityServiceCenter());
      dest.setCreation(getCreation());
      dest.setInvestmentInvitation(getInvestmentInvitation());
      dest.setFranchising(getFranchising());
      dest.setDecoration(getDecoration());
      dest.setOpening(getOpening());
      dest.setClosing(getClosing());
      dest.setFounded(getFounded());
      dest.setLatitude(getLatitude());
      dest.setLongitude(getLongitude());
      dest.setDescription(getDescription());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
      dest.setConsumerOrderList(getConsumerOrderList());
      dest.setRetailStoreOrderList(getRetailStoreOrderList());
      dest.setGoodsList(getGoodsList());
      dest.setTransportTaskList(getTransportTaskList());
      dest.setAccountSetList(getAccountSetList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof RetailStore) {

      RetailStore source = (RetailStore) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeTelephone(source.getTelephone());
      mergeOwner(source.getOwner());
      mergeRetailStoreCountryCenter(source.getRetailStoreCountryCenter());
      mergeCityServiceCenter(source.getCityServiceCenter());
      mergeCreation(source.getCreation());
      mergeInvestmentInvitation(source.getInvestmentInvitation());
      mergeFranchising(source.getFranchising());
      mergeDecoration(source.getDecoration());
      mergeOpening(source.getOpening());
      mergeClosing(source.getClosing());
      mergeFounded(source.getFounded());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeDescription(source.getDescription());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
      mergeConsumerOrderList(source.getConsumerOrderList());
      mergeRetailStoreOrderList(source.getRetailStoreOrderList());
      mergeGoodsList(source.getGoodsList());
      mergeTransportTaskList(source.getTransportTaskList());
      mergeAccountSetList(source.getAccountSetList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof RetailStore) {

      RetailStore source = (RetailStore) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeTelephone(source.getTelephone());
      mergeOwner(source.getOwner());
      mergeFounded(source.getFounded());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeDescription(source.getDescription());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getName(),
      getTelephone(),
      getOwner(),
      getRetailStoreCountryCenter(),
      getCityServiceCenter(),
      getCreation(),
      getInvestmentInvitation(),
      getFranchising(),
      getDecoration(),
      getOpening(),
      getClosing(),
      getFounded(),
      getLatitude(),
      getLongitude(),
      getDescription(),
      getLastUpdateTime(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    RetailStore checkRetailStore =
        Q.retailStoreWithIdField()
            .filterById(id)
            .selectConsumerOrderList(Q.consumerOrderWithIdField().limit(0, 1))
            .selectRetailStoreOrderList(Q.retailStoreOrderWithIdField().limit(0, 1))
            .selectGoodsList(Q.goodsWithIdField().limit(0, 1))
            .selectTransportTaskList(Q.transportTaskWithIdField().limit(0, 1))
            .selectAccountSetList(Q.accountSetWithIdField().limit(0, 1))
            .execute(ctx);

    return checkRetailStore != null
        && !checkRetailStore.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public RetailStore save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("RetailStore{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\ttelephone='" + getTelephone() + "';");
    stringBuilder.append("\towner='" + getOwner() + "';");
    if (getRetailStoreCountryCenter() != null) {
      stringBuilder.append(
          "\tretailStoreCountryCenter='RetailStoreCountryCenter("
              + getRetailStoreCountryCenter().getId()
              + ")';");
    }
    if (getCityServiceCenter() != null) {
      stringBuilder.append(
          "\tcityServiceCenter='RetailStoreCityServiceCenter("
              + getCityServiceCenter().getId()
              + ")';");
    }
    if (getCreation() != null) {
      stringBuilder.append("\tcreation='RetailStoreCreation(" + getCreation().getId() + ")';");
    }
    if (getInvestmentInvitation() != null) {
      stringBuilder.append(
          "\tinvestmentInvitation='RetailStoreInvestmentInvitation("
              + getInvestmentInvitation().getId()
              + ")';");
    }
    if (getFranchising() != null) {
      stringBuilder.append(
          "\tfranchising='RetailStoreFranchising(" + getFranchising().getId() + ")';");
    }
    if (getDecoration() != null) {
      stringBuilder.append(
          "\tdecoration='RetailStoreDecoration(" + getDecoration().getId() + ")';");
    }
    if (getOpening() != null) {
      stringBuilder.append("\topening='RetailStoreOpening(" + getOpening().getId() + ")';");
    }
    if (getClosing() != null) {
      stringBuilder.append("\tclosing='RetailStoreClosing(" + getClosing().getId() + ")';");
    }
    stringBuilder.append("\tfounded='" + getFounded() + "';");
    stringBuilder.append("\tlatitude='" + getLatitude() + "';");
    stringBuilder.append("\tlongitude='" + getLongitude() + "';");
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tlastUpdateTime='" + getLastUpdateTime() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
