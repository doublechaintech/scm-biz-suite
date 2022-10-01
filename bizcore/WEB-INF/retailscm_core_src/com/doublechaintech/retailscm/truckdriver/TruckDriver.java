package com.doublechaintech.retailscm.truckdriver;

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

@JsonSerialize(using = TruckDriverSerializer.class)
public class TruckDriver extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(TruckDriver target) {
    if (target == null) {
      return;
    }
    target.addTransportTaskList(this.getTransportTaskList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String DRIVER_LICENSE_NUMBER_PROPERTY = "driverLicenseNumber";
  public static final String CONTACT_NUMBER_PROPERTY = "contactNumber";
  public static final String BELONGS_TO_PROPERTY = "belongsTo";
  public static final String VERSION_PROPERTY = "version";

  public static final String TRANSPORT_TASK_LIST = "transportTaskList";

  public static final String INTERNAL_TYPE = "TruckDriver";

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
        MemberMetaInfo.defineBy(DRIVER_LICENSE_NUMBER_PROPERTY, "driver_license_number", "驾驶执照号码")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CONTACT_NUMBER_PROPERTY, "contact_number", "联系电话")
            .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BELONGS_TO_PROPERTY, "transport_fleet", "属于")
            .withType("transport_fleet", TransportFleet.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(TRANSPORT_TASK_LIST, "driver", "运输任务列表")
            .withType("transport_task", TransportTask.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      DRIVER_LICENSE_NUMBER_PROPERTY,
      CONTACT_NUMBER_PROPERTY,
      BELONGS_TO_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(TRANSPORT_TASK_LIST, "driver");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(TRANSPORT_TASK_LIST, TransportTask.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BELONGS_TO_PROPERTY, TransportFleet.class);

    return parents;
  }
  /*
  public TruckDriver want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public TruckDriver wants(Class<? extends BaseEntity>... classes) {
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
  protected String driverLicenseNumber;
  protected String contactNumber;
  protected TransportFleet belongsTo;
  protected int version;

  protected SmartList<TransportTask> mTransportTaskList;

  public TruckDriver() {
    // lazy load for all the properties
  }

  public static TruckDriver withId(String id) {
    TruckDriver truckDriver = new TruckDriver();
    truckDriver.setId(id);
    truckDriver.setVersion(Integer.MAX_VALUE);
    truckDriver.setChecked(true);
    return truckDriver;
  }

  public static TruckDriver refById(String id) {
    return withId(id);
  }

  public TruckDriver limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public TruckDriver limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static TruckDriver searchExample() {
    TruckDriver truckDriver = new TruckDriver();
    truckDriver.setVersion(UNSET_INT);

    return truckDriver;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setBelongsTo( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)) {
      changeDriverLicenseNumberProperty(newValueExpr);
    }
    if (CONTACT_NUMBER_PROPERTY.equals(property)) {
      changeContactNumberProperty(newValueExpr);
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

  protected void changeDriverLicenseNumberProperty(String newValueExpr) {

    String oldValue = getDriverLicenseNumber();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDriverLicenseNumber(newValue);
    this.onChangeProperty(DRIVER_LICENSE_NUMBER_PROPERTY, oldValue, newValue);
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

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)) {
      return getDriverLicenseNumber();
    }
    if (CONTACT_NUMBER_PROPERTY.equals(property)) {
      return getContactNumber();
    }
    if (BELONGS_TO_PROPERTY.equals(property)) {
      return getBelongsTo();
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

  public TruckDriver updateId(String id) {
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

  public TruckDriver orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public TruckDriver ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public TruckDriver addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public TruckDriver updateName(String name) {
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

  public TruckDriver orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public TruckDriver ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public TruckDriver addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setDriverLicenseNumber(String driverLicenseNumber) {
    String oldDriverLicenseNumber = this.driverLicenseNumber;
    String newDriverLicenseNumber = trimString(driverLicenseNumber);
    this.driverLicenseNumber = newDriverLicenseNumber;
  }

  public String driverLicenseNumber() {
    doLoad();
    return getDriverLicenseNumber();
  }

  public String getDriverLicenseNumber() {
    return this.driverLicenseNumber;
  }

  public TruckDriver updateDriverLicenseNumber(String driverLicenseNumber) {
    String oldDriverLicenseNumber = this.driverLicenseNumber;
    String newDriverLicenseNumber = trimString(driverLicenseNumber);
    if (!shouldReplaceBy(newDriverLicenseNumber, oldDriverLicenseNumber)) {
      return this;
    }
    this.driverLicenseNumber = newDriverLicenseNumber;
    if (cn.hutool.core.util.ObjectUtil.equals(newDriverLicenseNumber, oldDriverLicenseNumber)) {
      return this;
    }
    addPropertyChange(
        DRIVER_LICENSE_NUMBER_PROPERTY, oldDriverLicenseNumber, newDriverLicenseNumber);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TruckDriver orderByDriverLicenseNumber(boolean asc) {
    doAddOrderBy(DRIVER_LICENSE_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDriverLicenseNumberCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(DRIVER_LICENSE_NUMBER_PROPERTY, operator, parameters);
  }

  public TruckDriver ignoreDriverLicenseNumberCriteria() {
    super.ignoreSearchProperty(DRIVER_LICENSE_NUMBER_PROPERTY);
    return this;
  }

  public TruckDriver addDriverLicenseNumberCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDriverLicenseNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDriverLicenseNumber(String driverLicenseNumber) {
    if (driverLicenseNumber != null) {
      updateDriverLicenseNumber(driverLicenseNumber);
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

  public TruckDriver updateContactNumber(String contactNumber) {
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

  public TruckDriver orderByContactNumber(boolean asc) {
    doAddOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createContactNumberCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CONTACT_NUMBER_PROPERTY, operator, parameters);
  }

  public TruckDriver ignoreContactNumberCriteria() {
    super.ignoreSearchProperty(CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public TruckDriver addContactNumberCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createContactNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeContactNumber(String contactNumber) {
    if (contactNumber != null) {
      updateContactNumber(contactNumber);
    }
  }

  public String getMaskedContactNumber() {
    String mobilePhoneNumber = getContactNumber();
    return maskChinaMobileNumber(mobilePhoneNumber);
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

  public TruckDriver updateBelongsTo(TransportFleet belongsTo) {
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

  public TruckDriver orderByBelongsTo(boolean asc) {
    doAddOrderBy(BELONGS_TO_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBelongsToCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BELONGS_TO_PROPERTY, operator, parameters);
  }

  public TruckDriver ignoreBelongsToCriteria() {
    super.ignoreSearchProperty(BELONGS_TO_PROPERTY);
    return this;
  }

  public TruckDriver addBelongsToCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBelongsToCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBelongsTo(TransportFleet belongsTo) {
    if (belongsTo != null) {
      updateBelongsTo(belongsTo);
    }
  }

  public TruckDriver updateBelongsToByReferenceId(String belongsToId) {
    updateBelongsTo(TransportFleet.refById(belongsToId));
    return this;
  }

  public void clearBelongsTo() {
    setBelongsTo(null);
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

  public TruckDriver updateVersion(int version) {
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

  public TruckDriver orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public TruckDriver ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public TruckDriver addVersionCriteria(QueryOperator operator, Object... parameters) {
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
      transportTask.setDriver(this);
    }

    this.mTransportTaskList = transportTaskList;
    this.mTransportTaskList.setListInternalName(TRANSPORT_TASK_LIST);
  }

  public TruckDriver addTransportTask(TransportTask transportTask) {
    transportTask.updateDriver(this);
    getTransportTaskList().add(transportTask);
    return this;
  }

  public TruckDriver addTransportTaskList(SmartList<TransportTask> transportTaskList) {
    for (TransportTask transportTask : transportTaskList) {
      transportTask.updateDriver(this);
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
    // transportTask.clearDriver(); //disconnect with Driver
    transportTask.clearFromAll(); // disconnect with Driver

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
    transportTask.setDriver(null);
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

    addToEntityList(this, entityList, getBelongsTo(), internalType);
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
    appendKeyValuePair(result, DRIVER_LICENSE_NUMBER_PROPERTY, getDriverLicenseNumber());
    appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getMaskedContactNumber());
    appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
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
    if (baseDest instanceof TruckDriver) {

      TruckDriver dest = (TruckDriver) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setDriverLicenseNumber(getDriverLicenseNumber());
      dest.setContactNumber(getContactNumber());
      dest.setBelongsTo(getBelongsTo());
      dest.setVersion(getVersion());
      dest.setTransportTaskList(getTransportTaskList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof TruckDriver) {

      TruckDriver source = (TruckDriver) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeDriverLicenseNumber(source.getDriverLicenseNumber());
      mergeContactNumber(source.getContactNumber());
      mergeBelongsTo(source.getBelongsTo());
      mergeVersion(source.getVersion());
      mergeTransportTaskList(source.getTransportTaskList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof TruckDriver) {

      TruckDriver source = (TruckDriver) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeDriverLicenseNumber(source.getDriverLicenseNumber());
      mergeContactNumber(source.getContactNumber());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getName(), getDriverLicenseNumber(), getContactNumber(), getBelongsTo(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    TruckDriver checkTruckDriver =
        Q.truckDriverWithIdField()
            .filterById(id)
            .selectTransportTaskList(Q.transportTaskWithIdField().limit(0, 1))
            .execute(ctx);

    return checkTruckDriver != null
        && !checkTruckDriver.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public TruckDriver save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("TruckDriver{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tdriverLicenseNumber='" + getDriverLicenseNumber() + "';");
    stringBuilder.append("\tcontactNumber='" + getContactNumber() + "';");
    if (getBelongsTo() != null) {
      stringBuilder.append("\tbelongsTo='TransportFleet(" + getBelongsTo().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
