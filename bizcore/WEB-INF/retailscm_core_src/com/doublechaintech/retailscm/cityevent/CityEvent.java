package com.doublechaintech.retailscm.cityevent;

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
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

@JsonSerialize(using = CityEventSerializer.class)
public class CityEvent extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(CityEvent target) {
    if (target == null) {
      return;
    }
    target.addEventAttendanceList(this.getEventAttendanceList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String MOBILE_PROPERTY = "mobile";
  public static final String CITY_SERVICE_CENTER_PROPERTY = "cityServiceCenter";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String EVENT_ATTENDANCE_LIST = "eventAttendanceList";

  public static final String INTERNAL_TYPE = "CityEvent";

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
        MemberMetaInfo.referBy(EVENT_ATTENDANCE_LIST, "cityEvent", "事件出席名单")
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
      DESCRIPTION_PROPERTY,
      LAST_UPDATE_TIME_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(EVENT_ATTENDANCE_LIST, "cityEvent");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(EVENT_ATTENDANCE_LIST, EventAttendance.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(CITY_SERVICE_CENTER_PROPERTY, RetailStoreCityServiceCenter.class);

    return parents;
  }
  /*
  public CityEvent want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public CityEvent wants(Class<? extends BaseEntity>... classes) {
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

  protected SmartList<EventAttendance> mEventAttendanceList;

  public CityEvent() {
    // lazy load for all the properties
  }

  public static CityEvent withId(String id) {
    CityEvent cityEvent = new CityEvent();
    cityEvent.setId(id);
    cityEvent.setVersion(Integer.MAX_VALUE);
    cityEvent.setChecked(true);
    return cityEvent;
  }

  public static CityEvent refById(String id) {
    return withId(id);
  }

  public CityEvent limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public CityEvent limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static CityEvent searchExample() {
    CityEvent cityEvent = new CityEvent();
    cityEvent.setVersion(UNSET_INT);

    return cityEvent;
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

  public CityEvent updateId(String id) {
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

  public CityEvent orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public CityEvent ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public CityEvent addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public CityEvent updateName(String name) {
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

  public CityEvent orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public CityEvent ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public CityEvent addNameCriteria(QueryOperator operator, Object... parameters) {
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

  public CityEvent updateMobile(String mobile) {
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

  public CityEvent orderByMobile(boolean asc) {
    doAddOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMobileCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOBILE_PROPERTY, operator, parameters);
  }

  public CityEvent ignoreMobileCriteria() {
    super.ignoreSearchProperty(MOBILE_PROPERTY);
    return this;
  }

  public CityEvent addMobileCriteria(QueryOperator operator, Object... parameters) {
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

  public CityEvent updateCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
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

  public CityEvent orderByCityServiceCenter(boolean asc) {
    doAddOrderBy(CITY_SERVICE_CENTER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCityServiceCenterCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(CITY_SERVICE_CENTER_PROPERTY, operator, parameters);
  }

  public CityEvent ignoreCityServiceCenterCriteria() {
    super.ignoreSearchProperty(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public CityEvent addCityServiceCenterCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCityServiceCenterCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter) {
    if (cityServiceCenter != null) {
      updateCityServiceCenter(cityServiceCenter);
    }
  }

  public CityEvent updateCityServiceCenterByReferenceId(String cityServiceCenterId) {
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

  public CityEvent updateDescription(String description) {
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

  public CityEvent orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public CityEvent ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public CityEvent addDescriptionCriteria(QueryOperator operator, Object... parameters) {
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

  public CityEvent updateLastUpdateTime(DateTime lastUpdateTime) {
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

  public CityEvent orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public CityEvent ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public CityEvent addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
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

  public CityEvent updateVersion(int version) {
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

  public CityEvent orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public CityEvent ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public CityEvent addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
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
      eventAttendance.setCityEvent(this);
    }

    this.mEventAttendanceList = eventAttendanceList;
    this.mEventAttendanceList.setListInternalName(EVENT_ATTENDANCE_LIST);
  }

  public CityEvent addEventAttendance(EventAttendance eventAttendance) {
    eventAttendance.updateCityEvent(this);
    getEventAttendanceList().add(eventAttendance);
    return this;
  }

  public CityEvent addEventAttendanceList(SmartList<EventAttendance> eventAttendanceList) {
    for (EventAttendance eventAttendance : eventAttendanceList) {
      eventAttendance.updateCityEvent(this);
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
    // eventAttendance.clearCityEvent(); //disconnect with CityEvent
    eventAttendance.clearFromAll(); // disconnect with CityEvent

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
    eventAttendance.setCityEvent(null);
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
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getEventAttendanceList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getEventAttendanceList());

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
    if (baseDest instanceof CityEvent) {

      CityEvent dest = (CityEvent) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setMobile(getMobile());
      dest.setCityServiceCenter(getCityServiceCenter());
      dest.setDescription(getDescription());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
      dest.setEventAttendanceList(getEventAttendanceList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof CityEvent) {

      CityEvent source = (CityEvent) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeMobile(source.getMobile());
      mergeCityServiceCenter(source.getCityServiceCenter());
      mergeDescription(source.getDescription());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
      mergeEventAttendanceList(source.getEventAttendanceList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof CityEvent) {

      CityEvent source = (CityEvent) sourceEntity;

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
    CityEvent checkCityEvent =
        Q.cityEventWithIdField()
            .filterById(id)
            .selectEventAttendanceList(Q.eventAttendanceWithIdField().limit(0, 1))
            .execute(ctx);

    return checkCityEvent != null
        && !checkCityEvent.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public CityEvent save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("CityEvent{");
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
