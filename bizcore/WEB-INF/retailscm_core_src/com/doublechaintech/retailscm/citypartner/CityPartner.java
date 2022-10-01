package com.doublechaintech.retailscm.citypartner;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

@JsonSerialize(using = CityPartnerSerializer.class)
public class CityPartner extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(CityPartner target) {
    if (target == null) {
      return;
    }
    target.addPotentialCustomerList(this.getPotentialCustomerList());
    target.addPotentialCustomerContactList(this.getPotentialCustomerContactList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String MOBILE_PROPERTY = "mobile";
  public static final String CITY_SERVICE_CENTER_PROPERTY = "cityServiceCenter";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String POTENTIAL_CUSTOMER_LIST = "potentialCustomerList";
  public static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";

  public static final String INTERNAL_TYPE = "CityPartner";

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
        MemberMetaInfo.defineBy(MOBILE_PROPERTY, "mobile", "手机")
            .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                CITY_SERVICE_CENTER_PROPERTY, "retail_store_city_service_center", "城市服务中心")
            .withType("retail_store_city_service_center", RetailStoreCityServiceCenter.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
            .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(POTENTIAL_CUSTOMER_LIST, "cityPartner", "潜在客户列表")
            .withType("potential_customer", PotentialCustomer.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(POTENTIAL_CUSTOMER_CONTACT_LIST, "cityPartner", "潜在客户联络名单")
            .withType("potential_customer_contact", PotentialCustomerContact.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      MOBILE_PROPERTY,
      CITY_SERVICE_CENTER_PROPERTY,
      DESCRIPTION_PROPERTY,
      LAST_UPDATE_TIME_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(POTENTIAL_CUSTOMER_LIST, "cityPartner");

    refers.put(POTENTIAL_CUSTOMER_CONTACT_LIST, "cityPartner");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(POTENTIAL_CUSTOMER_LIST, PotentialCustomer.class);

    refers.put(POTENTIAL_CUSTOMER_CONTACT_LIST, PotentialCustomerContact.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(CITY_SERVICE_CENTER_PROPERTY, RetailStoreCityServiceCenter.class);

    return parents;
  }
  /*
  public CityPartner want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public CityPartner wants(Class<? extends BaseEntity>... classes) {
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
  protected String mobile;
  protected RetailStoreCityServiceCenter cityServiceCenter;
  protected String description;
  protected DateTime lastUpdateTime;
  protected int version;

  protected SmartList<PotentialCustomer> mPotentialCustomerList;
  protected SmartList<PotentialCustomerContact> mPotentialCustomerContactList;

  public CityPartner() {
    // lazy load for all the properties
  }

  public static CityPartner withId(String id) {
    CityPartner cityPartner = new CityPartner();
    cityPartner.setId(id);
    cityPartner.setVersion(Integer.MAX_VALUE);
    cityPartner.setChecked(true);
    return cityPartner;
  }

  public static CityPartner refById(String id) {
    return withId(id);
  }

  public CityPartner limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public CityPartner limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static CityPartner searchExample() {
    CityPartner cityPartner = new CityPartner();
    cityPartner.setVersion(UNSET_INT);

    return cityPartner;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setCityServiceCenter( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (MOBILE_PROPERTY.equals(property)) {
      changeMobileProperty(newValueExpr);
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

  protected void changeMobileProperty(String newValueExpr) {

    String oldValue = getMobile();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateMobile(newValue);
    this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
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
    if (MOBILE_PROPERTY.equals(property)) {
      return getMobile();
    }
    if (CITY_SERVICE_CENTER_PROPERTY.equals(property)) {
      return getCityServiceCenter();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      return getLastUpdateTime();
    }
    if (POTENTIAL_CUSTOMER_LIST.equals(property)) {
      List<BaseEntity> list =
          getPotentialCustomerList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (POTENTIAL_CUSTOMER_CONTACT_LIST.equals(property)) {
      List<BaseEntity> list =
          getPotentialCustomerContactList().stream().map(item -> item).collect(Collectors.toList());
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

  public CityPartner updateId(String id) {
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

  public CityPartner orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public CityPartner ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public CityPartner addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public CityPartner updateName(String name) {
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

  public CityPartner orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public CityPartner ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public CityPartner addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setMobile(String mobile) {
    String oldMobile = this.mobile;
    String newMobile = trimString(mobile);
    this.mobile = newMobile;
  }

  public String mobile() {
    doLoad();
    return getMobile();
  }

  public String getMobile() {
    return this.mobile;
  }

  public CityPartner updateMobile(String mobile) {
    String oldMobile = this.mobile;
    String newMobile = trimString(mobile);
    if (!shouldReplaceBy(newMobile, oldMobile)) {
      return this;
    }
    this.mobile = newMobile;
    if (cn.hutool.core.util.ObjectUtil.equals(newMobile, oldMobile)) {
      return this;
    }
    addPropertyChange(MOBILE_PROPERTY, oldMobile, newMobile);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CityPartner orderByMobile(boolean asc) {
    doAddOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMobileCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOBILE_PROPERTY, operator, parameters);
  }

  public CityPartner ignoreMobileCriteria() {
    super.ignoreSearchProperty(MOBILE_PROPERTY);
    return this;
  }

  public CityPartner addMobileCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMobileCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMobile(String mobile) {
    if (mobile != null) {
      updateMobile(mobile);
    }
  }

  public String getMaskedMobile() {
    String mobilePhoneNumber = getMobile();
    return maskChinaMobileNumber(mobilePhoneNumber);
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

  public CityPartner updateCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
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

  public CityPartner orderByCityServiceCenter(boolean asc) {
    doAddOrderBy(CITY_SERVICE_CENTER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCityServiceCenterCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(CITY_SERVICE_CENTER_PROPERTY, operator, parameters);
  }

  public CityPartner ignoreCityServiceCenterCriteria() {
    super.ignoreSearchProperty(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public CityPartner addCityServiceCenterCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCityServiceCenterCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
    if (cityServiceCenter != null) {
      updateCityServiceCenter(cityServiceCenter);
    }
  }

  public CityPartner updateCityServiceCenterByReferenceId(String cityServiceCenterId) {
    updateCityServiceCenter(RetailStoreCityServiceCenter.refById(cityServiceCenterId));
    return this;
  }

  public void clearCityServiceCenter() {
    setCityServiceCenter(null);
    this.changed = true;
    setChecked(false);
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

  public CityPartner updateDescription(String description) {
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

  public CityPartner orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public CityPartner ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public CityPartner addDescriptionCriteria(QueryOperator operator, Object... parameters) {
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

  public CityPartner updateLastUpdateTime(DateTime lastUpdateTime) {
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

  public CityPartner orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public CityPartner ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public CityPartner addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
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

  public CityPartner updateVersion(int version) {
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

  public CityPartner orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public CityPartner ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public CityPartner addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<PotentialCustomer> getPotentialCustomerList() {
    if (this.mPotentialCustomerList == null) {
      this.mPotentialCustomerList = new SmartList<PotentialCustomer>();
      this.mPotentialCustomerList.setListInternalName(POTENTIAL_CUSTOMER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mPotentialCustomerList;
  }

  public SmartList<PotentialCustomer> potentialCustomerList() {

    doLoadChild(POTENTIAL_CUSTOMER_LIST);

    return getPotentialCustomerList();
  }

  public void setPotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList) {
    for (PotentialCustomer potentialCustomer : potentialCustomerList) {
      potentialCustomer.setCityPartner(this);
    }

    this.mPotentialCustomerList = potentialCustomerList;
    this.mPotentialCustomerList.setListInternalName(POTENTIAL_CUSTOMER_LIST);
  }

  public CityPartner addPotentialCustomer(PotentialCustomer potentialCustomer) {
    potentialCustomer.updateCityPartner(this);
    getPotentialCustomerList().add(potentialCustomer);
    return this;
  }

  public CityPartner addPotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList) {
    for (PotentialCustomer potentialCustomer : potentialCustomerList) {
      potentialCustomer.updateCityPartner(this);
    }

    Map<String, PotentialCustomer> mapById = potentialCustomerList.mapWithId();
    getPotentialCustomerList().removeIf(item -> mapById.get(item.getId()) != null);
    getPotentialCustomerList().addAll(potentialCustomerList);
    return this;
  }

  public void mergePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList) {
    if (potentialCustomerList == null) {
      return;
    }
    if (potentialCustomerList.isEmpty()) {
      return;
    }
    addPotentialCustomerList(potentialCustomerList);
  }

  public PotentialCustomer removePotentialCustomer(PotentialCustomer potentialCustomerIndex) {

    int index = getPotentialCustomerList().indexOf(potentialCustomerIndex);
    if (index < 0) {
      String message =
          "PotentialCustomer("
              + potentialCustomerIndex.getId()
              + ") with version='"
              + potentialCustomerIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    PotentialCustomer potentialCustomer = getPotentialCustomerList().get(index);
    // potentialCustomer.clearCityPartner(); //disconnect with CityPartner
    potentialCustomer.clearFromAll(); // disconnect with CityPartner

    boolean result = getPotentialCustomerList().planToRemove(potentialCustomer);
    if (!result) {
      String message =
          "PotentialCustomer("
              + potentialCustomerIndex.getId()
              + ") with version='"
              + potentialCustomerIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return potentialCustomer;
  }
  // 断舍离
  public void breakWithPotentialCustomer(PotentialCustomer potentialCustomer) {

    if (potentialCustomer == null) {
      return;
    }
    potentialCustomer.setCityPartner(null);
    // getPotentialCustomerList().remove();

  }

  public boolean hasPotentialCustomer(PotentialCustomer potentialCustomer) {

    return getPotentialCustomerList().contains(potentialCustomer);
  }

  public void copyPotentialCustomerFrom(PotentialCustomer potentialCustomer) {

    PotentialCustomer potentialCustomerInList = findThePotentialCustomer(potentialCustomer);
    PotentialCustomer newPotentialCustomer = new PotentialCustomer();
    potentialCustomerInList.copyTo(newPotentialCustomer);
    newPotentialCustomer.setVersion(0); // will trigger copy
    getPotentialCustomerList().add(newPotentialCustomer);
    addItemToFlexiableObject(COPIED_CHILD, newPotentialCustomer);
  }

  public PotentialCustomer findThePotentialCustomer(PotentialCustomer potentialCustomer) {

    int index = getPotentialCustomerList().indexOf(potentialCustomer);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "PotentialCustomer("
              + potentialCustomer.getId()
              + ") with version='"
              + potentialCustomer.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getPotentialCustomerList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpPotentialCustomerList() {
    getPotentialCustomerList().clear();
  }

  public SmartList<PotentialCustomerContact> getPotentialCustomerContactList() {
    if (this.mPotentialCustomerContactList == null) {
      this.mPotentialCustomerContactList = new SmartList<PotentialCustomerContact>();
      this.mPotentialCustomerContactList.setListInternalName(POTENTIAL_CUSTOMER_CONTACT_LIST);
      // 有名字，便于做权限控制
    }

    return this.mPotentialCustomerContactList;
  }

  public SmartList<PotentialCustomerContact> potentialCustomerContactList() {

    doLoadChild(POTENTIAL_CUSTOMER_CONTACT_LIST);

    return getPotentialCustomerContactList();
  }

  public void setPotentialCustomerContactList(
      SmartList<PotentialCustomerContact> potentialCustomerContactList) {
    for (PotentialCustomerContact potentialCustomerContact : potentialCustomerContactList) {
      potentialCustomerContact.setCityPartner(this);
    }

    this.mPotentialCustomerContactList = potentialCustomerContactList;
    this.mPotentialCustomerContactList.setListInternalName(POTENTIAL_CUSTOMER_CONTACT_LIST);
  }

  public CityPartner addPotentialCustomerContact(
      PotentialCustomerContact potentialCustomerContact) {
    potentialCustomerContact.updateCityPartner(this);
    getPotentialCustomerContactList().add(potentialCustomerContact);
    return this;
  }

  public CityPartner addPotentialCustomerContactList(
      SmartList<PotentialCustomerContact> potentialCustomerContactList) {
    for (PotentialCustomerContact potentialCustomerContact : potentialCustomerContactList) {
      potentialCustomerContact.updateCityPartner(this);
    }

    Map<String, PotentialCustomerContact> mapById = potentialCustomerContactList.mapWithId();
    getPotentialCustomerContactList().removeIf(item -> mapById.get(item.getId()) != null);
    getPotentialCustomerContactList().addAll(potentialCustomerContactList);
    return this;
  }

  public void mergePotentialCustomerContactList(
      SmartList<PotentialCustomerContact> potentialCustomerContactList) {
    if (potentialCustomerContactList == null) {
      return;
    }
    if (potentialCustomerContactList.isEmpty()) {
      return;
    }
    addPotentialCustomerContactList(potentialCustomerContactList);
  }

  public PotentialCustomerContact removePotentialCustomerContact(
      PotentialCustomerContact potentialCustomerContactIndex) {

    int index = getPotentialCustomerContactList().indexOf(potentialCustomerContactIndex);
    if (index < 0) {
      String message =
          "PotentialCustomerContact("
              + potentialCustomerContactIndex.getId()
              + ") with version='"
              + potentialCustomerContactIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    PotentialCustomerContact potentialCustomerContact =
        getPotentialCustomerContactList().get(index);
    // potentialCustomerContact.clearCityPartner(); //disconnect with CityPartner
    potentialCustomerContact.clearFromAll(); // disconnect with CityPartner

    boolean result = getPotentialCustomerContactList().planToRemove(potentialCustomerContact);
    if (!result) {
      String message =
          "PotentialCustomerContact("
              + potentialCustomerContactIndex.getId()
              + ") with version='"
              + potentialCustomerContactIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return potentialCustomerContact;
  }
  // 断舍离
  public void breakWithPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact) {

    if (potentialCustomerContact == null) {
      return;
    }
    potentialCustomerContact.setCityPartner(null);
    // getPotentialCustomerContactList().remove();

  }

  public boolean hasPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact) {

    return getPotentialCustomerContactList().contains(potentialCustomerContact);
  }

  public void copyPotentialCustomerContactFrom(PotentialCustomerContact potentialCustomerContact) {

    PotentialCustomerContact potentialCustomerContactInList =
        findThePotentialCustomerContact(potentialCustomerContact);
    PotentialCustomerContact newPotentialCustomerContact = new PotentialCustomerContact();
    potentialCustomerContactInList.copyTo(newPotentialCustomerContact);
    newPotentialCustomerContact.setVersion(0); // will trigger copy
    getPotentialCustomerContactList().add(newPotentialCustomerContact);
    addItemToFlexiableObject(COPIED_CHILD, newPotentialCustomerContact);
  }

  public PotentialCustomerContact findThePotentialCustomerContact(
      PotentialCustomerContact potentialCustomerContact) {

    int index = getPotentialCustomerContactList().indexOf(potentialCustomerContact);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "PotentialCustomerContact("
              + potentialCustomerContact.getId()
              + ") with version='"
              + potentialCustomerContact.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getPotentialCustomerContactList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpPotentialCustomerContactList() {
    getPotentialCustomerContactList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCityServiceCenter(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getPotentialCustomerList(), internalType);
    collectFromList(this, entityList, getPotentialCustomerContactList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getPotentialCustomerList());
    listOfList.add(getPotentialCustomerContactList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
    appendKeyValuePair(result, CITY_SERVICE_CENTER_PROPERTY, getCityServiceCenter());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, POTENTIAL_CUSTOMER_LIST, getPotentialCustomerList());
    if (!getPotentialCustomerList().isEmpty()) {
      appendKeyValuePair(
          result, "potentialCustomerCount", getPotentialCustomerList().getTotalCount());
      appendKeyValuePair(
          result,
          "potentialCustomerCurrentPageNumber",
          getPotentialCustomerList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactList());
    if (!getPotentialCustomerContactList().isEmpty()) {
      appendKeyValuePair(
          result,
          "potentialCustomerContactCount",
          getPotentialCustomerContactList().getTotalCount());
      appendKeyValuePair(
          result,
          "potentialCustomerContactCurrentPageNumber",
          getPotentialCustomerContactList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof CityPartner) {

      CityPartner dest = (CityPartner) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setMobile(getMobile());
      dest.setCityServiceCenter(getCityServiceCenter());
      dest.setDescription(getDescription());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
      dest.setPotentialCustomerList(getPotentialCustomerList());
      dest.setPotentialCustomerContactList(getPotentialCustomerContactList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof CityPartner) {

      CityPartner source = (CityPartner) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeMobile(source.getMobile());
      mergeCityServiceCenter(source.getCityServiceCenter());
      mergeDescription(source.getDescription());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
      mergePotentialCustomerList(source.getPotentialCustomerList());
      mergePotentialCustomerContactList(source.getPotentialCustomerContactList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof CityPartner) {

      CityPartner source = (CityPartner) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeMobile(source.getMobile());
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
      getMobile(),
      getCityServiceCenter(),
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
    CityPartner checkCityPartner =
        Q.cityPartnerWithIdField()
            .filterById(id)
            .selectPotentialCustomerList(Q.potentialCustomerWithIdField().limit(0, 1))
            .selectPotentialCustomerContactList(Q.potentialCustomerContactWithIdField().limit(0, 1))
            .execute(ctx);

    return checkCityPartner != null
        && !checkCityPartner.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public CityPartner save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("CityPartner{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tmobile='" + getMobile() + "';");
    if (getCityServiceCenter() != null) {
      stringBuilder.append(
          "\tcityServiceCenter='RetailStoreCityServiceCenter("
              + getCityServiceCenter().getId()
              + ")';");
    }
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tlastUpdateTime='" + getLastUpdateTime() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
