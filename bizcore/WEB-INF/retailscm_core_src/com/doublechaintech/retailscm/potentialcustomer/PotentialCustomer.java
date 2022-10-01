package com.doublechaintech.retailscm.potentialcustomer;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;

@JsonSerialize(using = PotentialCustomerSerializer.class)
public class PotentialCustomer extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(PotentialCustomer target) {
    if (target == null) {
      return;
    }
    target.addPotentialCustomerContactPersonList(this.getPotentialCustomerContactPersonList());
    target.addPotentialCustomerContactList(this.getPotentialCustomerContactList());
    target.addEventAttendanceList(this.getEventAttendanceList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String MOBILE_PROPERTY = "mobile";
  public static final String CITY_SERVICE_CENTER_PROPERTY = "cityServiceCenter";
  public static final String CITY_PARTNER_PROPERTY = "cityPartner";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST =
      "potentialCustomerContactPersonList";
  public static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";
  public static final String EVENT_ATTENDANCE_LIST = "eventAttendanceList";

  public static final String INTERNAL_TYPE = "PotentialCustomer";

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
        MemberMetaInfo.defineBy(CITY_PARTNER_PROPERTY, "city_partner", "城市合伙人")
            .withType("city_partner", CityPartner.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
            .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(
                POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, "potentialCustomer", "潜在客户联系人名单")
            .withType("potential_customer_contact_person", PotentialCustomerContactPerson.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(POTENTIAL_CUSTOMER_CONTACT_LIST, "potentialCustomer", "潜在客户联络名单")
            .withType("potential_customer_contact", PotentialCustomerContact.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EVENT_ATTENDANCE_LIST, "potentialCustomer", "事件出席名单")
            .withType("event_attendance", EventAttendance.class));
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
      CITY_PARTNER_PROPERTY,
      DESCRIPTION_PROPERTY,
      LAST_UPDATE_TIME_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, "potentialCustomer");

    refers.put(POTENTIAL_CUSTOMER_CONTACT_LIST, "potentialCustomer");

    refers.put(EVENT_ATTENDANCE_LIST, "potentialCustomer");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, PotentialCustomerContactPerson.class);

    refers.put(POTENTIAL_CUSTOMER_CONTACT_LIST, PotentialCustomerContact.class);

    refers.put(EVENT_ATTENDANCE_LIST, EventAttendance.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(CITY_SERVICE_CENTER_PROPERTY, RetailStoreCityServiceCenter.class);
    parents.put(CITY_PARTNER_PROPERTY, CityPartner.class);

    return parents;
  }
  /*
  public PotentialCustomer want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public PotentialCustomer wants(Class<? extends BaseEntity>... classes) {
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
  protected CityPartner cityPartner;
  protected String description;
  protected DateTime lastUpdateTime;
  protected int version;

  protected SmartList<PotentialCustomerContactPerson> mPotentialCustomerContactPersonList;
  protected SmartList<PotentialCustomerContact> mPotentialCustomerContactList;
  protected SmartList<EventAttendance> mEventAttendanceList;

  public PotentialCustomer() {
    // lazy load for all the properties
  }

  public static PotentialCustomer withId(String id) {
    PotentialCustomer potentialCustomer = new PotentialCustomer();
    potentialCustomer.setId(id);
    potentialCustomer.setVersion(Integer.MAX_VALUE);
    potentialCustomer.setChecked(true);
    return potentialCustomer;
  }

  public static PotentialCustomer refById(String id) {
    return withId(id);
  }

  public PotentialCustomer limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public PotentialCustomer limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static PotentialCustomer searchExample() {
    PotentialCustomer potentialCustomer = new PotentialCustomer();
    potentialCustomer.setVersion(UNSET_INT);

    return potentialCustomer;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setCityServiceCenter( null );
  	setCityPartner( null );

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
    if (CITY_PARTNER_PROPERTY.equals(property)) {
      return getCityPartner();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      return getLastUpdateTime();
    }
    if (POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST.equals(property)) {
      List<BaseEntity> list =
          getPotentialCustomerContactPersonList().stream()
              .map(item -> item)
              .collect(Collectors.toList());
      return list;
    }
    if (POTENTIAL_CUSTOMER_CONTACT_LIST.equals(property)) {
      List<BaseEntity> list =
          getPotentialCustomerContactList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (EVENT_ATTENDANCE_LIST.equals(property)) {
      List<BaseEntity> list =
          getEventAttendanceList().stream().map(item -> item).collect(Collectors.toList());
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

  public PotentialCustomer updateId(String id) {
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

  public PotentialCustomer orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public PotentialCustomer ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public PotentialCustomer addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public PotentialCustomer updateName(String name) {
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

  public PotentialCustomer orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public PotentialCustomer ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public PotentialCustomer addNameCriteria(QueryOperator operator, Object... parameters) {
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

  public PotentialCustomer updateMobile(String mobile) {
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

  public PotentialCustomer orderByMobile(boolean asc) {
    doAddOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMobileCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOBILE_PROPERTY, operator, parameters);
  }

  public PotentialCustomer ignoreMobileCriteria() {
    super.ignoreSearchProperty(MOBILE_PROPERTY);
    return this;
  }

  public PotentialCustomer addMobileCriteria(QueryOperator operator, Object... parameters) {
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

  public PotentialCustomer updateCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
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

  public PotentialCustomer orderByCityServiceCenter(boolean asc) {
    doAddOrderBy(CITY_SERVICE_CENTER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCityServiceCenterCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(CITY_SERVICE_CENTER_PROPERTY, operator, parameters);
  }

  public PotentialCustomer ignoreCityServiceCenterCriteria() {
    super.ignoreSearchProperty(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public PotentialCustomer addCityServiceCenterCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCityServiceCenterCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
    if (cityServiceCenter != null) {
      updateCityServiceCenter(cityServiceCenter);
    }
  }

  public PotentialCustomer updateCityServiceCenterByReferenceId(String cityServiceCenterId) {
    updateCityServiceCenter(RetailStoreCityServiceCenter.refById(cityServiceCenterId));
    return this;
  }

  public void clearCityServiceCenter() {
    setCityServiceCenter(null);
    this.changed = true;
    setChecked(false);
  }

  public void setCityPartner(CityPartner cityPartner) {
    CityPartner oldCityPartner = this.cityPartner;
    CityPartner newCityPartner = cityPartner;
    this.cityPartner = newCityPartner;
  }

  public CityPartner cityPartner() {
    doLoad();
    return getCityPartner();
  }

  public CityPartner getCityPartner() {
    return this.cityPartner;
  }

  public PotentialCustomer updateCityPartner(CityPartner cityPartner) {
    CityPartner oldCityPartner = this.cityPartner;
    CityPartner newCityPartner = cityPartner;
    if (!shouldReplaceBy(newCityPartner, oldCityPartner)) {
      return this;
    }
    this.cityPartner = newCityPartner;
    if (cn.hutool.core.util.ObjectUtil.equals(newCityPartner, oldCityPartner)) {
      return this;
    }
    addPropertyChange(CITY_PARTNER_PROPERTY, oldCityPartner, newCityPartner);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public PotentialCustomer orderByCityPartner(boolean asc) {
    doAddOrderBy(CITY_PARTNER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCityPartnerCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CITY_PARTNER_PROPERTY, operator, parameters);
  }

  public PotentialCustomer ignoreCityPartnerCriteria() {
    super.ignoreSearchProperty(CITY_PARTNER_PROPERTY);
    return this;
  }

  public PotentialCustomer addCityPartnerCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCityPartnerCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCityPartner(CityPartner cityPartner) {
    if (cityPartner != null) {
      updateCityPartner(cityPartner);
    }
  }

  public PotentialCustomer updateCityPartnerByReferenceId(String cityPartnerId) {
    updateCityPartner(CityPartner.refById(cityPartnerId));
    return this;
  }

  public void clearCityPartner() {
    setCityPartner(null);
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

  public PotentialCustomer updateDescription(String description) {
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

  public PotentialCustomer orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public PotentialCustomer ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public PotentialCustomer addDescriptionCriteria(QueryOperator operator, Object... parameters) {
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

  public PotentialCustomer updateLastUpdateTime(DateTime lastUpdateTime) {
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

  public PotentialCustomer orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public PotentialCustomer ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public PotentialCustomer addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
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

  public PotentialCustomer updateVersion(int version) {
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

  public PotentialCustomer orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public PotentialCustomer ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public PotentialCustomer addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<PotentialCustomerContactPerson> getPotentialCustomerContactPersonList() {
    if (this.mPotentialCustomerContactPersonList == null) {
      this.mPotentialCustomerContactPersonList = new SmartList<PotentialCustomerContactPerson>();
      this.mPotentialCustomerContactPersonList.setListInternalName(
          POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
      // 有名字，便于做权限控制
    }

    return this.mPotentialCustomerContactPersonList;
  }

  public SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList() {

    doLoadChild(POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);

    return getPotentialCustomerContactPersonList();
  }

  public void setPotentialCustomerContactPersonList(
      SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList) {
    for (PotentialCustomerContactPerson potentialCustomerContactPerson :
        potentialCustomerContactPersonList) {
      potentialCustomerContactPerson.setPotentialCustomer(this);
    }

    this.mPotentialCustomerContactPersonList = potentialCustomerContactPersonList;
    this.mPotentialCustomerContactPersonList.setListInternalName(
        POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
  }

  public PotentialCustomer addPotentialCustomerContactPerson(
      PotentialCustomerContactPerson potentialCustomerContactPerson) {
    potentialCustomerContactPerson.updatePotentialCustomer(this);
    getPotentialCustomerContactPersonList().add(potentialCustomerContactPerson);
    return this;
  }

  public PotentialCustomer addPotentialCustomerContactPersonList(
      SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList) {
    for (PotentialCustomerContactPerson potentialCustomerContactPerson :
        potentialCustomerContactPersonList) {
      potentialCustomerContactPerson.updatePotentialCustomer(this);
    }

    Map<String, PotentialCustomerContactPerson> mapById =
        potentialCustomerContactPersonList.mapWithId();
    getPotentialCustomerContactPersonList().removeIf(item -> mapById.get(item.getId()) != null);
    getPotentialCustomerContactPersonList().addAll(potentialCustomerContactPersonList);
    return this;
  }

  public void mergePotentialCustomerContactPersonList(
      SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList) {
    if (potentialCustomerContactPersonList == null) {
      return;
    }
    if (potentialCustomerContactPersonList.isEmpty()) {
      return;
    }
    addPotentialCustomerContactPersonList(potentialCustomerContactPersonList);
  }

  public PotentialCustomerContactPerson removePotentialCustomerContactPerson(
      PotentialCustomerContactPerson potentialCustomerContactPersonIndex) {

    int index =
        getPotentialCustomerContactPersonList().indexOf(potentialCustomerContactPersonIndex);
    if (index < 0) {
      String message =
          "PotentialCustomerContactPerson("
              + potentialCustomerContactPersonIndex.getId()
              + ") with version='"
              + potentialCustomerContactPersonIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    PotentialCustomerContactPerson potentialCustomerContactPerson =
        getPotentialCustomerContactPersonList().get(index);
    // potentialCustomerContactPerson.clearPotentialCustomer(); //disconnect with PotentialCustomer
    potentialCustomerContactPerson.clearFromAll(); // disconnect with PotentialCustomer

    boolean result =
        getPotentialCustomerContactPersonList().planToRemove(potentialCustomerContactPerson);
    if (!result) {
      String message =
          "PotentialCustomerContactPerson("
              + potentialCustomerContactPersonIndex.getId()
              + ") with version='"
              + potentialCustomerContactPersonIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return potentialCustomerContactPerson;
  }
  // 断舍离
  public void breakWithPotentialCustomerContactPerson(
      PotentialCustomerContactPerson potentialCustomerContactPerson) {

    if (potentialCustomerContactPerson == null) {
      return;
    }
    potentialCustomerContactPerson.setPotentialCustomer(null);
    // getPotentialCustomerContactPersonList().remove();

  }

  public boolean hasPotentialCustomerContactPerson(
      PotentialCustomerContactPerson potentialCustomerContactPerson) {

    return getPotentialCustomerContactPersonList().contains(potentialCustomerContactPerson);
  }

  public void copyPotentialCustomerContactPersonFrom(
      PotentialCustomerContactPerson potentialCustomerContactPerson) {

    PotentialCustomerContactPerson potentialCustomerContactPersonInList =
        findThePotentialCustomerContactPerson(potentialCustomerContactPerson);
    PotentialCustomerContactPerson newPotentialCustomerContactPerson =
        new PotentialCustomerContactPerson();
    potentialCustomerContactPersonInList.copyTo(newPotentialCustomerContactPerson);
    newPotentialCustomerContactPerson.setVersion(0); // will trigger copy
    getPotentialCustomerContactPersonList().add(newPotentialCustomerContactPerson);
    addItemToFlexiableObject(COPIED_CHILD, newPotentialCustomerContactPerson);
  }

  public PotentialCustomerContactPerson findThePotentialCustomerContactPerson(
      PotentialCustomerContactPerson potentialCustomerContactPerson) {

    int index = getPotentialCustomerContactPersonList().indexOf(potentialCustomerContactPerson);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "PotentialCustomerContactPerson("
              + potentialCustomerContactPerson.getId()
              + ") with version='"
              + potentialCustomerContactPerson.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getPotentialCustomerContactPersonList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpPotentialCustomerContactPersonList() {
    getPotentialCustomerContactPersonList().clear();
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
      potentialCustomerContact.setPotentialCustomer(this);
    }

    this.mPotentialCustomerContactList = potentialCustomerContactList;
    this.mPotentialCustomerContactList.setListInternalName(POTENTIAL_CUSTOMER_CONTACT_LIST);
  }

  public PotentialCustomer addPotentialCustomerContact(
      PotentialCustomerContact potentialCustomerContact) {
    potentialCustomerContact.updatePotentialCustomer(this);
    getPotentialCustomerContactList().add(potentialCustomerContact);
    return this;
  }

  public PotentialCustomer addPotentialCustomerContactList(
      SmartList<PotentialCustomerContact> potentialCustomerContactList) {
    for (PotentialCustomerContact potentialCustomerContact : potentialCustomerContactList) {
      potentialCustomerContact.updatePotentialCustomer(this);
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
    // potentialCustomerContact.clearPotentialCustomer(); //disconnect with PotentialCustomer
    potentialCustomerContact.clearFromAll(); // disconnect with PotentialCustomer

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
    potentialCustomerContact.setPotentialCustomer(null);
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

  public SmartList<EventAttendance> getEventAttendanceList() {
    if (this.mEventAttendanceList == null) {
      this.mEventAttendanceList = new SmartList<EventAttendance>();
      this.mEventAttendanceList.setListInternalName(EVENT_ATTENDANCE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEventAttendanceList;
  }

  public SmartList<EventAttendance> eventAttendanceList() {

    doLoadChild(EVENT_ATTENDANCE_LIST);

    return getEventAttendanceList();
  }

  public void setEventAttendanceList(SmartList<EventAttendance> eventAttendanceList) {
    for (EventAttendance eventAttendance : eventAttendanceList) {
      eventAttendance.setPotentialCustomer(this);
    }

    this.mEventAttendanceList = eventAttendanceList;
    this.mEventAttendanceList.setListInternalName(EVENT_ATTENDANCE_LIST);
  }

  public PotentialCustomer addEventAttendance(EventAttendance eventAttendance) {
    eventAttendance.updatePotentialCustomer(this);
    getEventAttendanceList().add(eventAttendance);
    return this;
  }

  public PotentialCustomer addEventAttendanceList(SmartList<EventAttendance> eventAttendanceList) {
    for (EventAttendance eventAttendance : eventAttendanceList) {
      eventAttendance.updatePotentialCustomer(this);
    }

    Map<String, EventAttendance> mapById = eventAttendanceList.mapWithId();
    getEventAttendanceList().removeIf(item -> mapById.get(item.getId()) != null);
    getEventAttendanceList().addAll(eventAttendanceList);
    return this;
  }

  public void mergeEventAttendanceList(SmartList<EventAttendance> eventAttendanceList) {
    if (eventAttendanceList == null) {
      return;
    }
    if (eventAttendanceList.isEmpty()) {
      return;
    }
    addEventAttendanceList(eventAttendanceList);
  }

  public EventAttendance removeEventAttendance(EventAttendance eventAttendanceIndex) {

    int index = getEventAttendanceList().indexOf(eventAttendanceIndex);
    if (index < 0) {
      String message =
          "EventAttendance("
              + eventAttendanceIndex.getId()
              + ") with version='"
              + eventAttendanceIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    EventAttendance eventAttendance = getEventAttendanceList().get(index);
    // eventAttendance.clearPotentialCustomer(); //disconnect with PotentialCustomer
    eventAttendance.clearFromAll(); // disconnect with PotentialCustomer

    boolean result = getEventAttendanceList().planToRemove(eventAttendance);
    if (!result) {
      String message =
          "EventAttendance("
              + eventAttendanceIndex.getId()
              + ") with version='"
              + eventAttendanceIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return eventAttendance;
  }
  // 断舍离
  public void breakWithEventAttendance(EventAttendance eventAttendance) {

    if (eventAttendance == null) {
      return;
    }
    eventAttendance.setPotentialCustomer(null);
    // getEventAttendanceList().remove();

  }

  public boolean hasEventAttendance(EventAttendance eventAttendance) {

    return getEventAttendanceList().contains(eventAttendance);
  }

  public void copyEventAttendanceFrom(EventAttendance eventAttendance) {

    EventAttendance eventAttendanceInList = findTheEventAttendance(eventAttendance);
    EventAttendance newEventAttendance = new EventAttendance();
    eventAttendanceInList.copyTo(newEventAttendance);
    newEventAttendance.setVersion(0); // will trigger copy
    getEventAttendanceList().add(newEventAttendance);
    addItemToFlexiableObject(COPIED_CHILD, newEventAttendance);
  }

  public EventAttendance findTheEventAttendance(EventAttendance eventAttendance) {

    int index = getEventAttendanceList().indexOf(eventAttendance);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "EventAttendance("
              + eventAttendance.getId()
              + ") with version='"
              + eventAttendance.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEventAttendanceList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEventAttendanceList() {
    getEventAttendanceList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCityServiceCenter(), internalType);
    addToEntityList(this, entityList, getCityPartner(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getPotentialCustomerContactPersonList(), internalType);
    collectFromList(this, entityList, getPotentialCustomerContactList(), internalType);
    collectFromList(this, entityList, getEventAttendanceList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getPotentialCustomerContactPersonList());
    listOfList.add(getPotentialCustomerContactList());
    listOfList.add(getEventAttendanceList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
    appendKeyValuePair(result, CITY_SERVICE_CENTER_PROPERTY, getCityServiceCenter());
    appendKeyValuePair(result, CITY_PARTNER_PROPERTY, getCityPartner());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(
        result, POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, getPotentialCustomerContactPersonList());
    if (!getPotentialCustomerContactPersonList().isEmpty()) {
      appendKeyValuePair(
          result,
          "potentialCustomerContactPersonCount",
          getPotentialCustomerContactPersonList().getTotalCount());
      appendKeyValuePair(
          result,
          "potentialCustomerContactPersonCurrentPageNumber",
          getPotentialCustomerContactPersonList().getCurrentPageNumber());
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
    appendKeyValuePair(result, EVENT_ATTENDANCE_LIST, getEventAttendanceList());
    if (!getEventAttendanceList().isEmpty()) {
      appendKeyValuePair(result, "eventAttendanceCount", getEventAttendanceList().getTotalCount());
      appendKeyValuePair(
          result,
          "eventAttendanceCurrentPageNumber",
          getEventAttendanceList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof PotentialCustomer) {

      PotentialCustomer dest = (PotentialCustomer) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setMobile(getMobile());
      dest.setCityServiceCenter(getCityServiceCenter());
      dest.setCityPartner(getCityPartner());
      dest.setDescription(getDescription());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
      dest.setPotentialCustomerContactPersonList(getPotentialCustomerContactPersonList());
      dest.setPotentialCustomerContactList(getPotentialCustomerContactList());
      dest.setEventAttendanceList(getEventAttendanceList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof PotentialCustomer) {

      PotentialCustomer source = (PotentialCustomer) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeMobile(source.getMobile());
      mergeCityServiceCenter(source.getCityServiceCenter());
      mergeCityPartner(source.getCityPartner());
      mergeDescription(source.getDescription());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
      mergePotentialCustomerContactPersonList(source.getPotentialCustomerContactPersonList());
      mergePotentialCustomerContactList(source.getPotentialCustomerContactList());
      mergeEventAttendanceList(source.getEventAttendanceList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof PotentialCustomer) {

      PotentialCustomer source = (PotentialCustomer) sourceEntity;

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
      getCityPartner(),
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
    PotentialCustomer checkPotentialCustomer =
        Q.potentialCustomerWithIdField()
            .filterById(id)
            .selectPotentialCustomerContactPersonList(
                Q.potentialCustomerContactPersonWithIdField().limit(0, 1))
            .selectPotentialCustomerContactList(Q.potentialCustomerContactWithIdField().limit(0, 1))
            .selectEventAttendanceList(Q.eventAttendanceWithIdField().limit(0, 1))
            .execute(ctx);

    return checkPotentialCustomer != null
        && !checkPotentialCustomer.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public PotentialCustomer save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("PotentialCustomer{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tmobile='" + getMobile() + "';");
    if (getCityServiceCenter() != null) {
      stringBuilder.append(
          "\tcityServiceCenter='RetailStoreCityServiceCenter("
              + getCityServiceCenter().getId()
              + ")';");
    }
    if (getCityPartner() != null) {
      stringBuilder.append("\tcityPartner='CityPartner(" + getCityPartner().getId() + ")';");
    }
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tlastUpdateTime='" + getLastUpdateTime() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
