package com.doublechaintech.retailscm.transporttasktrack;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.transporttask.TransportTask;

@JsonSerialize(using = TransportTaskTrackSerializer.class)
public class TransportTaskTrack extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(TransportTaskTrack target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String TRACK_TIME_PROPERTY = "trackTime";
  public static final String LATITUDE_PROPERTY = "latitude";
  public static final String LONGITUDE_PROPERTY = "longitude";
  public static final String MOVEMENT_PROPERTY = "movement";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "TransportTaskTrack";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TRACK_TIME_PROPERTY, "track_time", "跟踪时间")
            .withType("date_past", "Date"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LATITUDE_PROPERTY, "latitude", "纬度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LONGITUDE_PROPERTY, "longitude", "经度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(MOVEMENT_PROPERTY, "transport_task", "运动")
            .withType("transport_task", TransportTask.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      TRACK_TIME_PROPERTY,
      LATITUDE_PROPERTY,
      LONGITUDE_PROPERTY,
      MOVEMENT_PROPERTY,
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
    parents.put(MOVEMENT_PROPERTY, TransportTask.class);

    return parents;
  }
  /*
  public TransportTaskTrack want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public TransportTaskTrack wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getId();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected Date trackTime;
  protected BigDecimal latitude;
  protected BigDecimal longitude;
  protected TransportTask movement;
  protected int version;

  public TransportTaskTrack() {
    // lazy load for all the properties
  }

  public static TransportTaskTrack withId(String id) {
    TransportTaskTrack transportTaskTrack = new TransportTaskTrack();
    transportTaskTrack.setId(id);
    transportTaskTrack.setVersion(Integer.MAX_VALUE);
    transportTaskTrack.setChecked(true);
    return transportTaskTrack;
  }

  public static TransportTaskTrack refById(String id) {
    return withId(id);
  }

  public TransportTaskTrack limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public TransportTaskTrack limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static TransportTaskTrack searchExample() {
    TransportTaskTrack transportTaskTrack = new TransportTaskTrack();
    transportTaskTrack.setVersion(UNSET_INT);

    return transportTaskTrack;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setMovement( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (TRACK_TIME_PROPERTY.equals(property)) {
      changeTrackTimeProperty(newValueExpr);
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      changeLatitudeProperty(newValueExpr);
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      changeLongitudeProperty(newValueExpr);
    }
  }

  protected void changeTrackTimeProperty(String newValueExpr) {

    Date oldValue = getTrackTime();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateTrackTime(newValue);
    this.onChangeProperty(TRACK_TIME_PROPERTY, oldValue, newValue);
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

    if (TRACK_TIME_PROPERTY.equals(property)) {
      return getTrackTime();
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      return getLatitude();
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      return getLongitude();
    }
    if (MOVEMENT_PROPERTY.equals(property)) {
      return getMovement();
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

  public TransportTaskTrack updateId(String id) {
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

  public TransportTaskTrack orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public TransportTaskTrack ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public TransportTaskTrack addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setTrackTime(Date trackTime) {
    Date oldTrackTime = this.trackTime;
    Date newTrackTime = trackTime;
    this.trackTime = newTrackTime;
  }

  public Date trackTime() {
    doLoad();
    return getTrackTime();
  }

  public Date getTrackTime() {
    return this.trackTime;
  }

  public TransportTaskTrack updateTrackTime(Date trackTime) {
    Date oldTrackTime = this.trackTime;
    Date newTrackTime = trackTime;
    if (!shouldReplaceBy(newTrackTime, oldTrackTime)) {
      return this;
    }
    this.trackTime = newTrackTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newTrackTime, oldTrackTime)) {
      return this;
    }
    addPropertyChange(TRACK_TIME_PROPERTY, oldTrackTime, newTrackTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTaskTrack orderByTrackTime(boolean asc) {
    doAddOrderBy(TRACK_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTrackTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TRACK_TIME_PROPERTY, operator, parameters);
  }

  public TransportTaskTrack ignoreTrackTimeCriteria() {
    super.ignoreSearchProperty(TRACK_TIME_PROPERTY);
    return this;
  }

  public TransportTaskTrack addTrackTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTrackTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTrackTime(Date trackTime) {
    updateTrackTime(trackTime);
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

  public TransportTaskTrack updateLatitude(BigDecimal latitude) {
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

  public TransportTaskTrack orderByLatitude(boolean asc) {
    doAddOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLatitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LATITUDE_PROPERTY, operator, parameters);
  }

  public TransportTaskTrack ignoreLatitudeCriteria() {
    super.ignoreSearchProperty(LATITUDE_PROPERTY);
    return this;
  }

  public TransportTaskTrack addLatitudeCriteria(QueryOperator operator, Object... parameters) {
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

  public TransportTaskTrack updateLongitude(BigDecimal longitude) {
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

  public TransportTaskTrack orderByLongitude(boolean asc) {
    doAddOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLongitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LONGITUDE_PROPERTY, operator, parameters);
  }

  public TransportTaskTrack ignoreLongitudeCriteria() {
    super.ignoreSearchProperty(LONGITUDE_PROPERTY);
    return this;
  }

  public TransportTaskTrack addLongitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLongitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLongitude(BigDecimal longitude) {
    updateLongitude(longitude);
  }

  public void setMovement(TransportTask movement) {
    TransportTask oldMovement = this.movement;
    TransportTask newMovement = movement;
    this.movement = newMovement;
  }

  public TransportTask movement() {
    doLoad();
    return getMovement();
  }

  public TransportTask getMovement() {
    return this.movement;
  }

  public TransportTaskTrack updateMovement(TransportTask movement) {
    TransportTask oldMovement = this.movement;
    TransportTask newMovement = movement;
    if (!shouldReplaceBy(newMovement, oldMovement)) {
      return this;
    }
    this.movement = newMovement;
    if (cn.hutool.core.util.ObjectUtil.equals(newMovement, oldMovement)) {
      return this;
    }
    addPropertyChange(MOVEMENT_PROPERTY, oldMovement, newMovement);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TransportTaskTrack orderByMovement(boolean asc) {
    doAddOrderBy(MOVEMENT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMovementCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOVEMENT_PROPERTY, operator, parameters);
  }

  public TransportTaskTrack ignoreMovementCriteria() {
    super.ignoreSearchProperty(MOVEMENT_PROPERTY);
    return this;
  }

  public TransportTaskTrack addMovementCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMovementCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMovement(TransportTask movement) {
    if (movement != null) {
      updateMovement(movement);
    }
  }

  public TransportTaskTrack updateMovementByReferenceId(String movementId) {
    updateMovement(TransportTask.refById(movementId));
    return this;
  }

  public void clearMovement() {
    setMovement(null);
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

  public TransportTaskTrack updateVersion(int version) {
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

  public TransportTaskTrack orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public TransportTaskTrack ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public TransportTaskTrack addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getMovement(), internalType);
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
    appendKeyValuePair(result, TRACK_TIME_PROPERTY, getTrackTime());
    appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
    appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
    appendKeyValuePair(result, MOVEMENT_PROPERTY, getMovement());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof TransportTaskTrack) {

      TransportTaskTrack dest = (TransportTaskTrack) baseDest;

      dest.setId(getId());
      dest.setTrackTime(getTrackTime());
      dest.setLatitude(getLatitude());
      dest.setLongitude(getLongitude());
      dest.setMovement(getMovement());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof TransportTaskTrack) {

      TransportTaskTrack source = (TransportTaskTrack) sourceEntity;

      mergeId(source.getId());
      mergeTrackTime(source.getTrackTime());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeMovement(source.getMovement());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof TransportTaskTrack) {

      TransportTaskTrack source = (TransportTaskTrack) sourceEntity;

      mergeId(source.getId());
      mergeTrackTime(source.getTrackTime());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getTrackTime(), getLatitude(), getLongitude(), getMovement(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    TransportTaskTrack checkTransportTaskTrack =
        Q.transportTaskTrackWithIdField().filterById(id).execute(ctx);

    return checkTransportTaskTrack != null
        && !checkTransportTaskTrack.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public TransportTaskTrack save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("TransportTaskTrack{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\ttrackTime='" + getTrackTime() + "';");
    stringBuilder.append("\tlatitude='" + getLatitude() + "';");
    stringBuilder.append("\tlongitude='" + getLongitude() + "';");
    if (getMovement() != null) {
      stringBuilder.append("\tmovement='TransportTask(" + getMovement().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
