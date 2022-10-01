package com.doublechaintech.retailscm.transporttask;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

@JsonSerialize(using = TransportTaskSerializer.class)
public class TransportTask extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(TransportTask target) {
    if (target == null) {
      return;
    }
    target.addGoodsList(this.getGoodsList());
    target.addTransportTaskTrackList(this.getTransportTaskTrackList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String START_PROPERTY = "start";
  public static final String BEGIN_TIME_PROPERTY = "beginTime";
  public static final String END_PROPERTY = "end";
  public static final String DRIVER_PROPERTY = "driver";
  public static final String TRUCK_PROPERTY = "truck";
  public static final String BELONGS_TO_PROPERTY = "belongsTo";
  public static final String LATITUDE_PROPERTY = "latitude";
  public static final String LONGITUDE_PROPERTY = "longitude";
  public static final String VERSION_PROPERTY = "version";

  public static final String GOODS_LIST = "goodsList";
  public static final String TRANSPORT_TASK_TRACK_LIST = "transportTaskTrackList";

  public static final String INTERNAL_TYPE = "TransportTask";

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
        MemberMetaInfo.defineBy(START_PROPERTY, "start", "开始").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BEGIN_TIME_PROPERTY, "begin_time", "开始时间")
            .withType("date_past", "Date"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(END_PROPERTY, "retail_store", "结束")
            .withType("retail_store", RetailStore.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DRIVER_PROPERTY, "truck_driver", "司机")
            .withType("truck_driver", TruckDriver.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TRUCK_PROPERTY, "transport_truck", "卡车")
            .withType("transport_truck", TransportTruck.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BELONGS_TO_PROPERTY, "transport_fleet", "属于")
            .withType("transport_fleet", TransportFleet.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LATITUDE_PROPERTY, "latitude", "纬度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LONGITUDE_PROPERTY, "longitude", "经度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(GOODS_LIST, "transportTask", "商品列表").withType("goods", Goods.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(TRANSPORT_TASK_TRACK_LIST, "movement", "传输任务跟踪列表")
            .withType("transport_task_track", TransportTaskTrack.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      START_PROPERTY,
      BEGIN_TIME_PROPERTY,
      END_PROPERTY,
      DRIVER_PROPERTY,
      TRUCK_PROPERTY,
      BELONGS_TO_PROPERTY,
      LATITUDE_PROPERTY,
      LONGITUDE_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(GOODS_LIST, "transportTask");

    refers.put(TRANSPORT_TASK_TRACK_LIST, "movement");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(GOODS_LIST, Goods.class);

    refers.put(TRANSPORT_TASK_TRACK_LIST, TransportTaskTrack.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(END_PROPERTY, RetailStore.class);
    parents.put(DRIVER_PROPERTY, TruckDriver.class);
    parents.put(TRUCK_PROPERTY, TransportTruck.class);
    parents.put(BELONGS_TO_PROPERTY, TransportFleet.class);

    return parents;
  }
  /*
  public TransportTask want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public TransportTask wants(Class<? extends BaseEntity>... classes) {
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
  protected String start;
  protected Date beginTime;
  protected RetailStore end;
  protected TruckDriver driver;
  protected TransportTruck truck;
  protected TransportFleet belongsTo;
  protected BigDecimal latitude;
  protected BigDecimal longitude;
  protected int version;

  protected SmartList<Goods> mGoodsList;
  protected SmartList<TransportTaskTrack> mTransportTaskTrackList;

  public TransportTask() {
    // lazy load for all the properties
  }

  public static TransportTask withId(String id) {
    TransportTask transportTask = new TransportTask();
    transportTask.setId(id);
    transportTask.setVersion(Integer.MAX_VALUE);
    transportTask.setChecked(true);
    return transportTask;
  }

  public static TransportTask refById(String id) {
    return withId(id);
  }

  public TransportTask limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public TransportTask limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static TransportTask searchExample() {
    TransportTask transportTask = new TransportTask();
    transportTask.setVersion(UNSET_INT);

    return transportTask;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setEnd( null );
  	setDriver( null );
  	setTruck( null );
  	setBelongsTo( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (START_PROPERTY.equals(property)) {
      changeStartProperty(newValueExpr);
    }
    if (BEGIN_TIME_PROPERTY.equals(property)) {
      changeBeginTimeProperty(newValueExpr);
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      changeLatitudeProperty(newValueExpr);
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      changeLongitudeProperty(newValueExpr);
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

  protected void changeStartProperty(String newValueExpr) {

    String oldValue = getStart();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateStart(newValue);
    this.onChangeProperty(START_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeBeginTimeProperty(String newValueExpr) {

    Date oldValue = getBeginTime();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateBeginTime(newValue);
    this.onChangeProperty(BEGIN_TIME_PROPERTY, oldValue, newValue);
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

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (START_PROPERTY.equals(property)) {
      return getStart();
    }
    if (BEGIN_TIME_PROPERTY.equals(property)) {
      return getBeginTime();
    }
    if (END_PROPERTY.equals(property)) {
      return getEnd();
    }
    if (DRIVER_PROPERTY.equals(property)) {
      return getDriver();
    }
    if (TRUCK_PROPERTY.equals(property)) {
      return getTruck();
    }
    if (BELONGS_TO_PROPERTY.equals(property)) {
      return getBelongsTo();
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      return getLatitude();
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      return getLongitude();
    }
    if (GOODS_LIST.equals(property)) {
      List<BaseEntity> list =
          getGoodsList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (TRANSPORT_TASK_TRACK_LIST.equals(property)) {
      List<BaseEntity> list =
          getTransportTaskTrackList().stream().map(item -> item).collect(Collectors.toList());
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

  public TransportTask updateId(String id) {
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

  public TransportTask orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public TransportTask addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public TransportTask updateName(String name) {
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

  public TransportTask orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public TransportTask addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setStart(String start) {
    String oldStart = this.start;
    String newStart = trimString(start);
    this.start = newStart;
  }

  public String start() {
    doLoad();
    return getStart();
  }

  public String getStart() {
    return this.start;
  }

  public TransportTask updateStart(String start) {
    String oldStart = this.start;
    String newStart = trimString(start);
    if (!shouldReplaceBy(newStart, oldStart)) {
      return this;
    }
    this.start = newStart;
    if (cn.hutool.core.util.ObjectUtil.equals(newStart, oldStart)) {
      return this;
    }
    addPropertyChange(START_PROPERTY, oldStart, newStart);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTask orderByStart(boolean asc) {
    doAddOrderBy(START_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createStartCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(START_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreStartCriteria() {
    super.ignoreSearchProperty(START_PROPERTY);
    return this;
  }

  public TransportTask addStartCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createStartCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeStart(String start) {
    if (start != null) {
      updateStart(start);
    }
  }

  public void setBeginTime(Date beginTime) {
    Date oldBeginTime = this.beginTime;
    Date newBeginTime = beginTime;
    this.beginTime = newBeginTime;
  }

  public Date beginTime() {
    doLoad();
    return getBeginTime();
  }

  public Date getBeginTime() {
    return this.beginTime;
  }

  public TransportTask updateBeginTime(Date beginTime) {
    Date oldBeginTime = this.beginTime;
    Date newBeginTime = beginTime;
    if (!shouldReplaceBy(newBeginTime, oldBeginTime)) {
      return this;
    }
    this.beginTime = newBeginTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newBeginTime, oldBeginTime)) {
      return this;
    }
    addPropertyChange(BEGIN_TIME_PROPERTY, oldBeginTime, newBeginTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTask orderByBeginTime(boolean asc) {
    doAddOrderBy(BEGIN_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBeginTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BEGIN_TIME_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreBeginTimeCriteria() {
    super.ignoreSearchProperty(BEGIN_TIME_PROPERTY);
    return this;
  }

  public TransportTask addBeginTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBeginTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBeginTime(Date beginTime) {
    updateBeginTime(beginTime);
  }

  public void setEnd(RetailStore end) {
    RetailStore oldEnd = this.end;
    RetailStore newEnd = end;
    this.end = newEnd;
  }

  public RetailStore end() {
    doLoad();
    return getEnd();
  }

  public RetailStore getEnd() {
    return this.end;
  }

  public TransportTask updateEnd(RetailStore end) {
    RetailStore oldEnd = this.end;
    RetailStore newEnd = end;
    if (!shouldReplaceBy(newEnd, oldEnd)) {
      return this;
    }
    this.end = newEnd;
    if (cn.hutool.core.util.ObjectUtil.equals(newEnd, oldEnd)) {
      return this;
    }
    addPropertyChange(END_PROPERTY, oldEnd, newEnd);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTask orderByEnd(boolean asc) {
    doAddOrderBy(END_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEndCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(END_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreEndCriteria() {
    super.ignoreSearchProperty(END_PROPERTY);
    return this;
  }

  public TransportTask addEndCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEndCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEnd(RetailStore end) {
    if (end != null) {
      updateEnd(end);
    }
  }

  public TransportTask updateEndByReferenceId(String endId) {
    updateEnd(RetailStore.refById(endId));
    return this;
  }

  public void clearEnd() {
    setEnd(null);
    this.changed = true;
    setChecked(false);
  }

  public void setDriver(TruckDriver driver) {
    TruckDriver oldDriver = this.driver;
    TruckDriver newDriver = driver;
    this.driver = newDriver;
  }

  public TruckDriver driver() {
    doLoad();
    return getDriver();
  }

  public TruckDriver getDriver() {
    return this.driver;
  }

  public TransportTask updateDriver(TruckDriver driver) {
    TruckDriver oldDriver = this.driver;
    TruckDriver newDriver = driver;
    if (!shouldReplaceBy(newDriver, oldDriver)) {
      return this;
    }
    this.driver = newDriver;
    if (cn.hutool.core.util.ObjectUtil.equals(newDriver, oldDriver)) {
      return this;
    }
    addPropertyChange(DRIVER_PROPERTY, oldDriver, newDriver);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTask orderByDriver(boolean asc) {
    doAddOrderBy(DRIVER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDriverCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DRIVER_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreDriverCriteria() {
    super.ignoreSearchProperty(DRIVER_PROPERTY);
    return this;
  }

  public TransportTask addDriverCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDriverCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDriver(TruckDriver driver) {
    if (driver != null) {
      updateDriver(driver);
    }
  }

  public TransportTask updateDriverByReferenceId(String driverId) {
    updateDriver(TruckDriver.refById(driverId));
    return this;
  }

  public void clearDriver() {
    setDriver(null);
    this.changed = true;
    setChecked(false);
  }

  public void setTruck(TransportTruck truck) {
    TransportTruck oldTruck = this.truck;
    TransportTruck newTruck = truck;
    this.truck = newTruck;
  }

  public TransportTruck truck() {
    doLoad();
    return getTruck();
  }

  public TransportTruck getTruck() {
    return this.truck;
  }

  public TransportTask updateTruck(TransportTruck truck) {
    TransportTruck oldTruck = this.truck;
    TransportTruck newTruck = truck;
    if (!shouldReplaceBy(newTruck, oldTruck)) {
      return this;
    }
    this.truck = newTruck;
    if (cn.hutool.core.util.ObjectUtil.equals(newTruck, oldTruck)) {
      return this;
    }
    addPropertyChange(TRUCK_PROPERTY, oldTruck, newTruck);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTask orderByTruck(boolean asc) {
    doAddOrderBy(TRUCK_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTruckCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TRUCK_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreTruckCriteria() {
    super.ignoreSearchProperty(TRUCK_PROPERTY);
    return this;
  }

  public TransportTask addTruckCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTruckCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTruck(TransportTruck truck) {
    if (truck != null) {
      updateTruck(truck);
    }
  }

  public TransportTask updateTruckByReferenceId(String truckId) {
    updateTruck(TransportTruck.refById(truckId));
    return this;
  }

  public void clearTruck() {
    setTruck(null);
    this.changed = true;
    setChecked(false);
  }

  public void setBelongsTo(TransportFleet belongsTo) {
    TransportFleet oldBelongsTo = this.belongsTo;
    TransportFleet newBelongsTo = belongsTo;
    this.belongsTo = newBelongsTo;
  }

  public TransportFleet belongsTo() {
    doLoad();
    return getBelongsTo();
  }

  public TransportFleet getBelongsTo() {
    return this.belongsTo;
  }

  public TransportTask updateBelongsTo(TransportFleet belongsTo) {
    TransportFleet oldBelongsTo = this.belongsTo;
    TransportFleet newBelongsTo = belongsTo;
    if (!shouldReplaceBy(newBelongsTo, oldBelongsTo)) {
      return this;
    }
    this.belongsTo = newBelongsTo;
    if (cn.hutool.core.util.ObjectUtil.equals(newBelongsTo, oldBelongsTo)) {
      return this;
    }
    addPropertyChange(BELONGS_TO_PROPERTY, oldBelongsTo, newBelongsTo);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTask orderByBelongsTo(boolean asc) {
    doAddOrderBy(BELONGS_TO_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBelongsToCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BELONGS_TO_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreBelongsToCriteria() {
    super.ignoreSearchProperty(BELONGS_TO_PROPERTY);
    return this;
  }

  public TransportTask addBelongsToCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBelongsToCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBelongsTo(TransportFleet belongsTo) {
    if (belongsTo != null) {
      updateBelongsTo(belongsTo);
    }
  }

  public TransportTask updateBelongsToByReferenceId(String belongsToId) {
    updateBelongsTo(TransportFleet.refById(belongsToId));
    return this;
  }

  public void clearBelongsTo() {
    setBelongsTo(null);
    this.changed = true;
    setChecked(false);
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

  public TransportTask updateLatitude(BigDecimal latitude) {
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

  public TransportTask orderByLatitude(boolean asc) {
    doAddOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLatitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LATITUDE_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreLatitudeCriteria() {
    super.ignoreSearchProperty(LATITUDE_PROPERTY);
    return this;
  }

  public TransportTask addLatitudeCriteria(QueryOperator operator, Object... parameters) {
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

  public TransportTask updateLongitude(BigDecimal longitude) {
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

  public TransportTask orderByLongitude(boolean asc) {
    doAddOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLongitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LONGITUDE_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreLongitudeCriteria() {
    super.ignoreSearchProperty(LONGITUDE_PROPERTY);
    return this;
  }

  public TransportTask addLongitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLongitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLongitude(BigDecimal longitude) {
    updateLongitude(longitude);
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

  public TransportTask updateVersion(int version) {
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

  public TransportTask orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public TransportTask ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public TransportTask addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
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
      goods.setTransportTask(this);
    }

    this.mGoodsList = goodsList;
    this.mGoodsList.setListInternalName(GOODS_LIST);
  }

  public TransportTask addGoods(Goods goods) {
    goods.updateTransportTask(this);
    getGoodsList().add(goods);
    return this;
  }

  public TransportTask addGoodsList(SmartList<Goods> goodsList) {
    for (Goods goods : goodsList) {
      goods.updateTransportTask(this);
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
    // goods.clearTransportTask(); //disconnect with TransportTask
    goods.clearFromAll(); // disconnect with TransportTask

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
    goods.setTransportTask(null);
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

  public SmartList<TransportTaskTrack> getTransportTaskTrackList() {
    if (this.mTransportTaskTrackList == null) {
      this.mTransportTaskTrackList = new SmartList<TransportTaskTrack>();
      this.mTransportTaskTrackList.setListInternalName(TRANSPORT_TASK_TRACK_LIST);
      // 有名字，便于做权限控制
    }

    return this.mTransportTaskTrackList;
  }

  public SmartList<TransportTaskTrack> transportTaskTrackList() {

    doLoadChild(TRANSPORT_TASK_TRACK_LIST);

    return getTransportTaskTrackList();
  }

  public void setTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList) {
    for (TransportTaskTrack transportTaskTrack : transportTaskTrackList) {
      transportTaskTrack.setMovement(this);
    }

    this.mTransportTaskTrackList = transportTaskTrackList;
    this.mTransportTaskTrackList.setListInternalName(TRANSPORT_TASK_TRACK_LIST);
  }

  public TransportTask addTransportTaskTrack(TransportTaskTrack transportTaskTrack) {
    transportTaskTrack.updateMovement(this);
    getTransportTaskTrackList().add(transportTaskTrack);
    return this;
  }

  public TransportTask addTransportTaskTrackList(
      SmartList<TransportTaskTrack> transportTaskTrackList) {
    for (TransportTaskTrack transportTaskTrack : transportTaskTrackList) {
      transportTaskTrack.updateMovement(this);
    }

    Map<String, TransportTaskTrack> mapById = transportTaskTrackList.mapWithId();
    getTransportTaskTrackList().removeIf(item -> mapById.get(item.getId()) != null);
    getTransportTaskTrackList().addAll(transportTaskTrackList);
    return this;
  }

  public void mergeTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList) {
    if (transportTaskTrackList == null) {
      return;
    }
    if (transportTaskTrackList.isEmpty()) {
      return;
    }
    addTransportTaskTrackList(transportTaskTrackList);
  }

  public TransportTaskTrack removeTransportTaskTrack(TransportTaskTrack transportTaskTrackIndex) {

    int index = getTransportTaskTrackList().indexOf(transportTaskTrackIndex);
    if (index < 0) {
      String message =
          "TransportTaskTrack("
              + transportTaskTrackIndex.getId()
              + ") with version='"
              + transportTaskTrackIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    TransportTaskTrack transportTaskTrack = getTransportTaskTrackList().get(index);
    // transportTaskTrack.clearMovement(); //disconnect with Movement
    transportTaskTrack.clearFromAll(); // disconnect with Movement

    boolean result = getTransportTaskTrackList().planToRemove(transportTaskTrack);
    if (!result) {
      String message =
          "TransportTaskTrack("
              + transportTaskTrackIndex.getId()
              + ") with version='"
              + transportTaskTrackIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return transportTaskTrack;
  }
  // 断舍离
  public void breakWithTransportTaskTrack(TransportTaskTrack transportTaskTrack) {

    if (transportTaskTrack == null) {
      return;
    }
    transportTaskTrack.setMovement(null);
    // getTransportTaskTrackList().remove();

  }

  public boolean hasTransportTaskTrack(TransportTaskTrack transportTaskTrack) {

    return getTransportTaskTrackList().contains(transportTaskTrack);
  }

  public void copyTransportTaskTrackFrom(TransportTaskTrack transportTaskTrack) {

    TransportTaskTrack transportTaskTrackInList = findTheTransportTaskTrack(transportTaskTrack);
    TransportTaskTrack newTransportTaskTrack = new TransportTaskTrack();
    transportTaskTrackInList.copyTo(newTransportTaskTrack);
    newTransportTaskTrack.setVersion(0); // will trigger copy
    getTransportTaskTrackList().add(newTransportTaskTrack);
    addItemToFlexiableObject(COPIED_CHILD, newTransportTaskTrack);
  }

  public TransportTaskTrack findTheTransportTaskTrack(TransportTaskTrack transportTaskTrack) {

    int index = getTransportTaskTrackList().indexOf(transportTaskTrack);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "TransportTaskTrack("
              + transportTaskTrack.getId()
              + ") with version='"
              + transportTaskTrack.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getTransportTaskTrackList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpTransportTaskTrackList() {
    getTransportTaskTrackList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getEnd(), internalType);
    addToEntityList(this, entityList, getDriver(), internalType);
    addToEntityList(this, entityList, getTruck(), internalType);
    addToEntityList(this, entityList, getBelongsTo(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getGoodsList(), internalType);
    collectFromList(this, entityList, getTransportTaskTrackList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getGoodsList());
    listOfList.add(getTransportTaskTrackList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, START_PROPERTY, getStart());
    appendKeyValuePair(result, BEGIN_TIME_PROPERTY, getBeginTime());
    appendKeyValuePair(result, END_PROPERTY, getEnd());
    appendKeyValuePair(result, DRIVER_PROPERTY, getDriver());
    appendKeyValuePair(result, TRUCK_PROPERTY, getTruck());
    appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
    appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
    appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, GOODS_LIST, getGoodsList());
    if (!getGoodsList().isEmpty()) {
      appendKeyValuePair(result, "goodsCount", getGoodsList().getTotalCount());
      appendKeyValuePair(result, "goodsCurrentPageNumber", getGoodsList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, TRANSPORT_TASK_TRACK_LIST, getTransportTaskTrackList());
    if (!getTransportTaskTrackList().isEmpty()) {
      appendKeyValuePair(
          result, "transportTaskTrackCount", getTransportTaskTrackList().getTotalCount());
      appendKeyValuePair(
          result,
          "transportTaskTrackCurrentPageNumber",
          getTransportTaskTrackList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof TransportTask) {

      TransportTask dest = (TransportTask) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setStart(getStart());
      dest.setBeginTime(getBeginTime());
      dest.setEnd(getEnd());
      dest.setDriver(getDriver());
      dest.setTruck(getTruck());
      dest.setBelongsTo(getBelongsTo());
      dest.setLatitude(getLatitude());
      dest.setLongitude(getLongitude());
      dest.setVersion(getVersion());
      dest.setGoodsList(getGoodsList());
      dest.setTransportTaskTrackList(getTransportTaskTrackList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof TransportTask) {

      TransportTask source = (TransportTask) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeStart(source.getStart());
      mergeBeginTime(source.getBeginTime());
      mergeEnd(source.getEnd());
      mergeDriver(source.getDriver());
      mergeTruck(source.getTruck());
      mergeBelongsTo(source.getBelongsTo());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeVersion(source.getVersion());
      mergeGoodsList(source.getGoodsList());
      mergeTransportTaskTrackList(source.getTransportTaskTrackList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof TransportTask) {

      TransportTask source = (TransportTask) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeStart(source.getStart());
      mergeBeginTime(source.getBeginTime());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getName(),
      getStart(),
      getBeginTime(),
      getEnd(),
      getDriver(),
      getTruck(),
      getBelongsTo(),
      getLatitude(),
      getLongitude(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    TransportTask checkTransportTask =
        Q.transportTaskWithIdField()
            .filterById(id)
            .selectGoodsList(Q.goodsWithIdField().limit(0, 1))
            .selectTransportTaskTrackList(Q.transportTaskTrackWithIdField().limit(0, 1))
            .execute(ctx);

    return checkTransportTask != null
        && !checkTransportTask.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public TransportTask save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("TransportTask{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tstart='" + getStart() + "';");
    stringBuilder.append("\tbeginTime='" + getBeginTime() + "';");
    if (getEnd() != null) {
      stringBuilder.append("\tend='RetailStore(" + getEnd().getId() + ")';");
    }
    if (getDriver() != null) {
      stringBuilder.append("\tdriver='TruckDriver(" + getDriver().getId() + ")';");
    }
    if (getTruck() != null) {
      stringBuilder.append("\ttruck='TransportTruck(" + getTruck().getId() + ")';");
    }
    if (getBelongsTo() != null) {
      stringBuilder.append("\tbelongsTo='TransportFleet(" + getBelongsTo().getId() + ")';");
    }
    stringBuilder.append("\tlatitude='" + getLatitude() + "';");
    stringBuilder.append("\tlongitude='" + getLongitude() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
