package com.doublechaintech.retailscm.transporttruck;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;

@JsonSerialize(using = TransportTruckSerializer.class)
public class TransportTruck extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(TransportTruck target) {
    if (target == null) {
      return;
    }
    target.addTransportTaskList(this.getTransportTaskList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String PLATE_NUMBER_PROPERTY = "plateNumber";
  public static final String CONTACT_NUMBER_PROPERTY = "contactNumber";
  public static final String VEHICLE_LICENSE_NUMBER_PROPERTY = "vehicleLicenseNumber";
  public static final String ENGINE_NUMBER_PROPERTY = "engineNumber";
  public static final String MAKE_DATE_PROPERTY = "makeDate";
  public static final String MILEAGE_PROPERTY = "mileage";
  public static final String BODY_COLOR_PROPERTY = "bodyColor";
  public static final String OWNER_PROPERTY = "owner";
  public static final String VERSION_PROPERTY = "version";

  public static final String TRANSPORT_TASK_LIST = "transportTaskList";

  public static final String INTERNAL_TYPE = "TransportTruck";

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
        MemberMetaInfo.defineBy(PLATE_NUMBER_PROPERTY, "plate_number", "车牌号码")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CONTACT_NUMBER_PROPERTY, "contact_number", "联系电话")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VEHICLE_LICENSE_NUMBER_PROPERTY, "vehicle_license_number", "汽车牌照号码")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ENGINE_NUMBER_PROPERTY, "engine_number", "发动机号")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(MAKE_DATE_PROPERTY, "make_date", "制造日期")
            .withType("date", Date.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(MILEAGE_PROPERTY, "mileage", "里程")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BODY_COLOR_PROPERTY, "body_color", "车身颜色")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(OWNER_PROPERTY, "transport_fleet", "业主")
            .withType("transport_fleet", TransportFleet.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(TRANSPORT_TASK_LIST, "truck", "运输任务列表")
            .withType("transport_task", TransportTask.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      PLATE_NUMBER_PROPERTY,
      CONTACT_NUMBER_PROPERTY,
      VEHICLE_LICENSE_NUMBER_PROPERTY,
      ENGINE_NUMBER_PROPERTY,
      MAKE_DATE_PROPERTY,
      MILEAGE_PROPERTY,
      BODY_COLOR_PROPERTY,
      OWNER_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(TRANSPORT_TASK_LIST, "truck");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(TRANSPORT_TASK_LIST, TransportTask.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(OWNER_PROPERTY, TransportFleet.class);

    return parents;
  }
  /*
  public TransportTruck want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public TransportTruck wants(Class<? extends BaseEntity>... classes) {
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
  protected String plateNumber;
  protected String contactNumber;
  protected String vehicleLicenseNumber;
  protected String engineNumber;
  protected Date makeDate;
  protected String mileage;
  protected String bodyColor;
  protected TransportFleet owner;
  protected int version;

  protected SmartList<TransportTask> mTransportTaskList;

  public TransportTruck() {
    // lazy load for all the properties
  }

  public static TransportTruck withId(String id) {
    TransportTruck transportTruck = new TransportTruck();
    transportTruck.setId(id);
    transportTruck.setVersion(Integer.MAX_VALUE);
    transportTruck.setChecked(true);
    return transportTruck;
  }

  public static TransportTruck refById(String id) {
    return withId(id);
  }

  public TransportTruck limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public TransportTruck limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static TransportTruck searchExample() {
    TransportTruck transportTruck = new TransportTruck();
    transportTruck.setVersion(UNSET_INT);

    return transportTruck;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setOwner( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (PLATE_NUMBER_PROPERTY.equals(property)) {
      changePlateNumberProperty(newValueExpr);
    }
    if (CONTACT_NUMBER_PROPERTY.equals(property)) {
      changeContactNumberProperty(newValueExpr);
    }
    if (VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)) {
      changeVehicleLicenseNumberProperty(newValueExpr);
    }
    if (ENGINE_NUMBER_PROPERTY.equals(property)) {
      changeEngineNumberProperty(newValueExpr);
    }
    if (MAKE_DATE_PROPERTY.equals(property)) {
      changeMakeDateProperty(newValueExpr);
    }
    if (MILEAGE_PROPERTY.equals(property)) {
      changeMileageProperty(newValueExpr);
    }
    if (BODY_COLOR_PROPERTY.equals(property)) {
      changeBodyColorProperty(newValueExpr);
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

  protected void changePlateNumberProperty(String newValueExpr) {

    String oldValue = getPlateNumber();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updatePlateNumber(newValue);
    this.onChangeProperty(PLATE_NUMBER_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeContactNumberProperty(String newValueExpr) {

    String oldValue = getContactNumber();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateContactNumber(newValue);
    this.onChangeProperty(CONTACT_NUMBER_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeVehicleLicenseNumberProperty(String newValueExpr) {

    String oldValue = getVehicleLicenseNumber();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateVehicleLicenseNumber(newValue);
    this.onChangeProperty(VEHICLE_LICENSE_NUMBER_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeEngineNumberProperty(String newValueExpr) {

    String oldValue = getEngineNumber();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateEngineNumber(newValue);
    this.onChangeProperty(ENGINE_NUMBER_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeMakeDateProperty(String newValueExpr) {

    Date oldValue = getMakeDate();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateMakeDate(newValue);
    this.onChangeProperty(MAKE_DATE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeMileageProperty(String newValueExpr) {

    String oldValue = getMileage();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateMileage(newValue);
    this.onChangeProperty(MILEAGE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeBodyColorProperty(String newValueExpr) {

    String oldValue = getBodyColor();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateBodyColor(newValue);
    this.onChangeProperty(BODY_COLOR_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (PLATE_NUMBER_PROPERTY.equals(property)) {
      return getPlateNumber();
    }
    if (CONTACT_NUMBER_PROPERTY.equals(property)) {
      return getContactNumber();
    }
    if (VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)) {
      return getVehicleLicenseNumber();
    }
    if (ENGINE_NUMBER_PROPERTY.equals(property)) {
      return getEngineNumber();
    }
    if (MAKE_DATE_PROPERTY.equals(property)) {
      return getMakeDate();
    }
    if (MILEAGE_PROPERTY.equals(property)) {
      return getMileage();
    }
    if (BODY_COLOR_PROPERTY.equals(property)) {
      return getBodyColor();
    }
    if (OWNER_PROPERTY.equals(property)) {
      return getOwner();
    }
    if (TRANSPORT_TASK_LIST.equals(property)) {
      List<BaseEntity> list =
          getTransportTaskList().stream().map(item -> item).collect(Collectors.toList());
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

  public TransportTruck updateId(String id) {
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

  public TransportTruck orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public TransportTruck addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public TransportTruck updateName(String name) {
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

  public TransportTruck orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public TransportTruck addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setPlateNumber(String plateNumber) {
    String oldPlateNumber = this.plateNumber;
    String newPlateNumber = trimString(plateNumber);
    this.plateNumber = newPlateNumber;
  }

  public String plateNumber() {
    doLoad();
    return getPlateNumber();
  }

  public String getPlateNumber() {
    return this.plateNumber;
  }

  public TransportTruck updatePlateNumber(String plateNumber) {
    String oldPlateNumber = this.plateNumber;
    String newPlateNumber = trimString(plateNumber);
    if (!shouldReplaceBy(newPlateNumber, oldPlateNumber)) {
      return this;
    }
    this.plateNumber = newPlateNumber;
    if (cn.hutool.core.util.ObjectUtil.equals(newPlateNumber, oldPlateNumber)) {
      return this;
    }
    addPropertyChange(PLATE_NUMBER_PROPERTY, oldPlateNumber, newPlateNumber);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTruck orderByPlateNumber(boolean asc) {
    doAddOrderBy(PLATE_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPlateNumberCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PLATE_NUMBER_PROPERTY, operator, parameters);
  }

  public TransportTruck ignorePlateNumberCriteria() {
    super.ignoreSearchProperty(PLATE_NUMBER_PROPERTY);
    return this;
  }

  public TransportTruck addPlateNumberCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPlateNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePlateNumber(String plateNumber) {
    if (plateNumber != null) {
      updatePlateNumber(plateNumber);
    }
  }

  public void setContactNumber(String contactNumber) {
    String oldContactNumber = this.contactNumber;
    String newContactNumber = trimString(contactNumber);
    this.contactNumber = newContactNumber;
  }

  public String contactNumber() {
    doLoad();
    return getContactNumber();
  }

  public String getContactNumber() {
    return this.contactNumber;
  }

  public TransportTruck updateContactNumber(String contactNumber) {
    String oldContactNumber = this.contactNumber;
    String newContactNumber = trimString(contactNumber);
    if (!shouldReplaceBy(newContactNumber, oldContactNumber)) {
      return this;
    }
    this.contactNumber = newContactNumber;
    if (cn.hutool.core.util.ObjectUtil.equals(newContactNumber, oldContactNumber)) {
      return this;
    }
    addPropertyChange(CONTACT_NUMBER_PROPERTY, oldContactNumber, newContactNumber);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTruck orderByContactNumber(boolean asc) {
    doAddOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createContactNumberCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CONTACT_NUMBER_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreContactNumberCriteria() {
    super.ignoreSearchProperty(CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public TransportTruck addContactNumberCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createContactNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeContactNumber(String contactNumber) {
    if (contactNumber != null) {
      updateContactNumber(contactNumber);
    }
  }

  public void setVehicleLicenseNumber(String vehicleLicenseNumber) {
    String oldVehicleLicenseNumber = this.vehicleLicenseNumber;
    String newVehicleLicenseNumber = trimString(vehicleLicenseNumber);
    this.vehicleLicenseNumber = newVehicleLicenseNumber;
  }

  public String vehicleLicenseNumber() {
    doLoad();
    return getVehicleLicenseNumber();
  }

  public String getVehicleLicenseNumber() {
    return this.vehicleLicenseNumber;
  }

  public TransportTruck updateVehicleLicenseNumber(String vehicleLicenseNumber) {
    String oldVehicleLicenseNumber = this.vehicleLicenseNumber;
    String newVehicleLicenseNumber = trimString(vehicleLicenseNumber);
    if (!shouldReplaceBy(newVehicleLicenseNumber, oldVehicleLicenseNumber)) {
      return this;
    }
    this.vehicleLicenseNumber = newVehicleLicenseNumber;
    if (cn.hutool.core.util.ObjectUtil.equals(newVehicleLicenseNumber, oldVehicleLicenseNumber)) {
      return this;
    }
    addPropertyChange(
        VEHICLE_LICENSE_NUMBER_PROPERTY, oldVehicleLicenseNumber, newVehicleLicenseNumber);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTruck orderByVehicleLicenseNumber(boolean asc) {
    doAddOrderBy(VEHICLE_LICENSE_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVehicleLicenseNumberCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(VEHICLE_LICENSE_NUMBER_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreVehicleLicenseNumberCriteria() {
    super.ignoreSearchProperty(VEHICLE_LICENSE_NUMBER_PROPERTY);
    return this;
  }

  public TransportTruck addVehicleLicenseNumberCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVehicleLicenseNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVehicleLicenseNumber(String vehicleLicenseNumber) {
    if (vehicleLicenseNumber != null) {
      updateVehicleLicenseNumber(vehicleLicenseNumber);
    }
  }

  public void setEngineNumber(String engineNumber) {
    String oldEngineNumber = this.engineNumber;
    String newEngineNumber = trimString(engineNumber);
    this.engineNumber = newEngineNumber;
  }

  public String engineNumber() {
    doLoad();
    return getEngineNumber();
  }

  public String getEngineNumber() {
    return this.engineNumber;
  }

  public TransportTruck updateEngineNumber(String engineNumber) {
    String oldEngineNumber = this.engineNumber;
    String newEngineNumber = trimString(engineNumber);
    if (!shouldReplaceBy(newEngineNumber, oldEngineNumber)) {
      return this;
    }
    this.engineNumber = newEngineNumber;
    if (cn.hutool.core.util.ObjectUtil.equals(newEngineNumber, oldEngineNumber)) {
      return this;
    }
    addPropertyChange(ENGINE_NUMBER_PROPERTY, oldEngineNumber, newEngineNumber);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTruck orderByEngineNumber(boolean asc) {
    doAddOrderBy(ENGINE_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEngineNumberCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ENGINE_NUMBER_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreEngineNumberCriteria() {
    super.ignoreSearchProperty(ENGINE_NUMBER_PROPERTY);
    return this;
  }

  public TransportTruck addEngineNumberCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEngineNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEngineNumber(String engineNumber) {
    if (engineNumber != null) {
      updateEngineNumber(engineNumber);
    }
  }

  public void setMakeDate(Date makeDate) {
    Date oldMakeDate = this.makeDate;
    Date newMakeDate = makeDate;
    this.makeDate = newMakeDate;
  }

  public Date makeDate() {
    doLoad();
    return getMakeDate();
  }

  public Date getMakeDate() {
    return this.makeDate;
  }

  public TransportTruck updateMakeDate(Date makeDate) {
    Date oldMakeDate = this.makeDate;
    Date newMakeDate = makeDate;
    if (!shouldReplaceBy(newMakeDate, oldMakeDate)) {
      return this;
    }
    this.makeDate = newMakeDate;
    if (cn.hutool.core.util.ObjectUtil.equals(newMakeDate, oldMakeDate)) {
      return this;
    }
    addPropertyChange(MAKE_DATE_PROPERTY, oldMakeDate, newMakeDate);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTruck orderByMakeDate(boolean asc) {
    doAddOrderBy(MAKE_DATE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMakeDateCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MAKE_DATE_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreMakeDateCriteria() {
    super.ignoreSearchProperty(MAKE_DATE_PROPERTY);
    return this;
  }

  public TransportTruck addMakeDateCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMakeDateCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMakeDate(Date makeDate) {
    updateMakeDate(makeDate);
  }

  public void setMileage(String mileage) {
    String oldMileage = this.mileage;
    String newMileage = trimString(mileage);
    this.mileage = newMileage;
  }

  public String mileage() {
    doLoad();
    return getMileage();
  }

  public String getMileage() {
    return this.mileage;
  }

  public TransportTruck updateMileage(String mileage) {
    String oldMileage = this.mileage;
    String newMileage = trimString(mileage);
    if (!shouldReplaceBy(newMileage, oldMileage)) {
      return this;
    }
    this.mileage = newMileage;
    if (cn.hutool.core.util.ObjectUtil.equals(newMileage, oldMileage)) {
      return this;
    }
    addPropertyChange(MILEAGE_PROPERTY, oldMileage, newMileage);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTruck orderByMileage(boolean asc) {
    doAddOrderBy(MILEAGE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMileageCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MILEAGE_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreMileageCriteria() {
    super.ignoreSearchProperty(MILEAGE_PROPERTY);
    return this;
  }

  public TransportTruck addMileageCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMileageCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMileage(String mileage) {
    if (mileage != null) {
      updateMileage(mileage);
    }
  }

  public void setBodyColor(String bodyColor) {
    String oldBodyColor = this.bodyColor;
    String newBodyColor = trimString(bodyColor);
    this.bodyColor = newBodyColor;
  }

  public String bodyColor() {
    doLoad();
    return getBodyColor();
  }

  public String getBodyColor() {
    return this.bodyColor;
  }

  public TransportTruck updateBodyColor(String bodyColor) {
    String oldBodyColor = this.bodyColor;
    String newBodyColor = trimString(bodyColor);
    if (!shouldReplaceBy(newBodyColor, oldBodyColor)) {
      return this;
    }
    this.bodyColor = newBodyColor;
    if (cn.hutool.core.util.ObjectUtil.equals(newBodyColor, oldBodyColor)) {
      return this;
    }
    addPropertyChange(BODY_COLOR_PROPERTY, oldBodyColor, newBodyColor);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTruck orderByBodyColor(boolean asc) {
    doAddOrderBy(BODY_COLOR_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBodyColorCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BODY_COLOR_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreBodyColorCriteria() {
    super.ignoreSearchProperty(BODY_COLOR_PROPERTY);
    return this;
  }

  public TransportTruck addBodyColorCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBodyColorCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBodyColor(String bodyColor) {
    if (bodyColor != null) {
      updateBodyColor(bodyColor);
    }
  }

  public void setOwner(TransportFleet owner) {
    TransportFleet oldOwner = this.owner;
    TransportFleet newOwner = owner;
    this.owner = newOwner;
  }

  public TransportFleet owner() {
    doLoad();
    return getOwner();
  }

  public TransportFleet getOwner() {
    return this.owner;
  }

  public TransportTruck updateOwner(TransportFleet owner) {
    TransportFleet oldOwner = this.owner;
    TransportFleet newOwner = owner;
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

  public TransportTruck orderByOwner(boolean asc) {
    doAddOrderBy(OWNER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OWNER_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreOwnerCriteria() {
    super.ignoreSearchProperty(OWNER_PROPERTY);
    return this;
  }

  public TransportTruck addOwnerCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOwnerCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOwner(TransportFleet owner) {
    if (owner != null) {
      updateOwner(owner);
    }
  }

  public TransportTruck updateOwnerByReferenceId(String ownerId) {
    updateOwner(TransportFleet.refById(ownerId));
    return this;
  }

  public void clearOwner() {
    setOwner(null);
    this.changed = true;
    setChecked(false);
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

  public TransportTruck updateVersion(int version) {
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

  public TransportTruck orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public TransportTruck ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public TransportTruck addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
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
      transportTask.setTruck(this);
    }

    this.mTransportTaskList = transportTaskList;
    this.mTransportTaskList.setListInternalName(TRANSPORT_TASK_LIST);
  }

  public TransportTruck addTransportTask(TransportTask transportTask) {
    transportTask.updateTruck(this);
    getTransportTaskList().add(transportTask);
    return this;
  }

  public TransportTruck addTransportTaskList(SmartList<TransportTask> transportTaskList) {
    for (TransportTask transportTask : transportTaskList) {
      transportTask.updateTruck(this);
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
    // transportTask.clearTruck(); //disconnect with Truck
    transportTask.clearFromAll(); // disconnect with Truck

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
    transportTask.setTruck(null);
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

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getOwner(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getTransportTaskList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getTransportTaskList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, PLATE_NUMBER_PROPERTY, getPlateNumber());
    appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getContactNumber());
    appendKeyValuePair(result, VEHICLE_LICENSE_NUMBER_PROPERTY, getVehicleLicenseNumber());
    appendKeyValuePair(result, ENGINE_NUMBER_PROPERTY, getEngineNumber());
    appendKeyValuePair(result, MAKE_DATE_PROPERTY, getMakeDate());
    appendKeyValuePair(result, MILEAGE_PROPERTY, getMileage());
    appendKeyValuePair(result, BODY_COLOR_PROPERTY, getBodyColor());
    appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, TRANSPORT_TASK_LIST, getTransportTaskList());
    if (!getTransportTaskList().isEmpty()) {
      appendKeyValuePair(result, "transportTaskCount", getTransportTaskList().getTotalCount());
      appendKeyValuePair(
          result, "transportTaskCurrentPageNumber", getTransportTaskList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof TransportTruck) {

      TransportTruck dest = (TransportTruck) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setPlateNumber(getPlateNumber());
      dest.setContactNumber(getContactNumber());
      dest.setVehicleLicenseNumber(getVehicleLicenseNumber());
      dest.setEngineNumber(getEngineNumber());
      dest.setMakeDate(getMakeDate());
      dest.setMileage(getMileage());
      dest.setBodyColor(getBodyColor());
      dest.setOwner(getOwner());
      dest.setVersion(getVersion());
      dest.setTransportTaskList(getTransportTaskList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof TransportTruck) {

      TransportTruck source = (TransportTruck) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergePlateNumber(source.getPlateNumber());
      mergeContactNumber(source.getContactNumber());
      mergeVehicleLicenseNumber(source.getVehicleLicenseNumber());
      mergeEngineNumber(source.getEngineNumber());
      mergeMakeDate(source.getMakeDate());
      mergeMileage(source.getMileage());
      mergeBodyColor(source.getBodyColor());
      mergeOwner(source.getOwner());
      mergeVersion(source.getVersion());
      mergeTransportTaskList(source.getTransportTaskList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof TransportTruck) {

      TransportTruck source = (TransportTruck) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergePlateNumber(source.getPlateNumber());
      mergeContactNumber(source.getContactNumber());
      mergeVehicleLicenseNumber(source.getVehicleLicenseNumber());
      mergeEngineNumber(source.getEngineNumber());
      mergeMakeDate(source.getMakeDate());
      mergeMileage(source.getMileage());
      mergeBodyColor(source.getBodyColor());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getName(),
      getPlateNumber(),
      getContactNumber(),
      getVehicleLicenseNumber(),
      getEngineNumber(),
      getMakeDate(),
      getMileage(),
      getBodyColor(),
      getOwner(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    TransportTruck checkTransportTruck =
        Q.transportTruckWithIdField()
            .filterById(id)
            .selectTransportTaskList(Q.transportTaskWithIdField().limit(0, 1))
            .execute(ctx);

    return checkTransportTruck != null
        && !checkTransportTruck.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public TransportTruck save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("TransportTruck{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tplateNumber='" + getPlateNumber() + "';");
    stringBuilder.append("\tcontactNumber='" + getContactNumber() + "';");
    stringBuilder.append("\tvehicleLicenseNumber='" + getVehicleLicenseNumber() + "';");
    stringBuilder.append("\tengineNumber='" + getEngineNumber() + "';");
    stringBuilder.append("\tmakeDate='" + getMakeDate() + "';");
    stringBuilder.append("\tmileage='" + getMileage() + "';");
    stringBuilder.append("\tbodyColor='" + getBodyColor() + "';");
    if (getOwner() != null) {
      stringBuilder.append("\towner='TransportFleet(" + getOwner().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
