package com.doublechaintech.retailscm.warehouseasset;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.warehouse.Warehouse;

@JsonSerialize(using = WarehouseAssetSerializer.class)
public class WarehouseAsset extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(WarehouseAsset target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String POSITION_PROPERTY = "position";
  public static final String OWNER_PROPERTY = "owner";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "WarehouseAsset";

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
        MemberMetaInfo.defineBy(POSITION_PROPERTY, "position", "位置")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(OWNER_PROPERTY, "warehouse", "业主")
            .withType("warehouse", Warehouse.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
            .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      POSITION_PROPERTY,
      OWNER_PROPERTY,
      LAST_UPDATE_TIME_PROPERTY,
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
    parents.put(OWNER_PROPERTY, Warehouse.class);

    return parents;
  }
  /*
  public WarehouseAsset want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public WarehouseAsset wants(Class<? extends BaseEntity>... classes) {
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
  protected String position;
  protected Warehouse owner;
  protected DateTime lastUpdateTime;
  protected int version;

  public WarehouseAsset() {
    // lazy load for all the properties
  }

  public static WarehouseAsset withId(String id) {
    WarehouseAsset warehouseAsset = new WarehouseAsset();
    warehouseAsset.setId(id);
    warehouseAsset.setVersion(Integer.MAX_VALUE);
    warehouseAsset.setChecked(true);
    return warehouseAsset;
  }

  public static WarehouseAsset refById(String id) {
    return withId(id);
  }

  public WarehouseAsset limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public WarehouseAsset limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static WarehouseAsset searchExample() {
    WarehouseAsset warehouseAsset = new WarehouseAsset();
    warehouseAsset.setVersion(UNSET_INT);

    return warehouseAsset;
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
    if (POSITION_PROPERTY.equals(property)) {
      changePositionProperty(newValueExpr);
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

  protected void changePositionProperty(String newValueExpr) {

    String oldValue = getPosition();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updatePosition(newValue);
    this.onChangeProperty(POSITION_PROPERTY, oldValue, newValue);
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
    if (POSITION_PROPERTY.equals(property)) {
      return getPosition();
    }
    if (OWNER_PROPERTY.equals(property)) {
      return getOwner();
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      return getLastUpdateTime();
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

  public WarehouseAsset updateId(String id) {
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

  public WarehouseAsset orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public WarehouseAsset ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public WarehouseAsset addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public WarehouseAsset updateName(String name) {
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

  public WarehouseAsset orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public WarehouseAsset ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public WarehouseAsset addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setPosition(String position) {
    String oldPosition = this.position;
    String newPosition = trimString(position);
    this.position = newPosition;
  }

  public String position() {
    doLoad();
    return getPosition();
  }

  public String getPosition() {
    return this.position;
  }

  public WarehouseAsset updatePosition(String position) {
    String oldPosition = this.position;
    String newPosition = trimString(position);
    if (!shouldReplaceBy(newPosition, oldPosition)) {
      return this;
    }
    this.position = newPosition;
    if (cn.hutool.core.util.ObjectUtil.equals(newPosition, oldPosition)) {
      return this;
    }
    addPropertyChange(POSITION_PROPERTY, oldPosition, newPosition);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public WarehouseAsset orderByPosition(boolean asc) {
    doAddOrderBy(POSITION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPositionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(POSITION_PROPERTY, operator, parameters);
  }

  public WarehouseAsset ignorePositionCriteria() {
    super.ignoreSearchProperty(POSITION_PROPERTY);
    return this;
  }

  public WarehouseAsset addPositionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPositionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePosition(String position) {
    if (position != null) {
      updatePosition(position);
    }
  }

  public void setOwner(Warehouse owner) {
    Warehouse oldOwner = this.owner;
    Warehouse newOwner = owner;
    this.owner = newOwner;
  }

  public Warehouse owner() {
    doLoad();
    return getOwner();
  }

  public Warehouse getOwner() {
    return this.owner;
  }

  public WarehouseAsset updateOwner(Warehouse owner) {
    Warehouse oldOwner = this.owner;
    Warehouse newOwner = owner;
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

  public WarehouseAsset orderByOwner(boolean asc) {
    doAddOrderBy(OWNER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OWNER_PROPERTY, operator, parameters);
  }

  public WarehouseAsset ignoreOwnerCriteria() {
    super.ignoreSearchProperty(OWNER_PROPERTY);
    return this;
  }

  public WarehouseAsset addOwnerCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOwnerCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOwner(Warehouse owner) {
    if (owner != null) {
      updateOwner(owner);
    }
  }

  public WarehouseAsset updateOwnerByReferenceId(String ownerId) {
    updateOwner(Warehouse.refById(ownerId));
    return this;
  }

  public void clearOwner() {
    setOwner(null);
    this.changed = true;
    setChecked(false);
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

  public WarehouseAsset updateLastUpdateTime(DateTime lastUpdateTime) {
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

  public WarehouseAsset orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public WarehouseAsset ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public WarehouseAsset addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
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

  public WarehouseAsset updateVersion(int version) {
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

  public WarehouseAsset orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public WarehouseAsset ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public WarehouseAsset addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getOwner(), internalType);
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
    appendKeyValuePair(result, POSITION_PROPERTY, getPosition());
    appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
    appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof WarehouseAsset) {

      WarehouseAsset dest = (WarehouseAsset) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setPosition(getPosition());
      dest.setOwner(getOwner());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof WarehouseAsset) {

      WarehouseAsset source = (WarehouseAsset) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergePosition(source.getPosition());
      mergeOwner(source.getOwner());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof WarehouseAsset) {

      WarehouseAsset source = (WarehouseAsset) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergePosition(source.getPosition());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getName(), getPosition(), getOwner(), getLastUpdateTime(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    WarehouseAsset checkWarehouseAsset = Q.warehouseAssetWithIdField().filterById(id).execute(ctx);

    return checkWarehouseAsset != null
        && !checkWarehouseAsset.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public WarehouseAsset save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("WarehouseAsset{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tposition='" + getPosition() + "';");
    if (getOwner() != null) {
      stringBuilder.append("\towner='Warehouse(" + getOwner().getId() + ")';");
    }
    stringBuilder.append("\tlastUpdateTime='" + getLastUpdateTime() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
