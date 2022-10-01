package com.doublechaintech.retailscm.goodsshelf;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

@JsonSerialize(using = GoodsShelfSerializer.class)
public class GoodsShelf extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(GoodsShelf target) {
    if (target == null) {
      return;
    }
    target.addGoodsShelfStockCountList(this.getGoodsShelfStockCountList());
    target.addGoodsAllocationList(this.getGoodsAllocationList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String LOCATION_PROPERTY = "location";
  public static final String STORAGE_SPACE_PROPERTY = "storageSpace";
  public static final String SUPPLIER_SPACE_PROPERTY = "supplierSpace";
  public static final String DAMAGE_SPACE_PROPERTY = "damageSpace";
  public static final String LAST_UPDATE_TIME_PROPERTY = "lastUpdateTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String GOODS_SHELF_STOCK_COUNT_LIST = "goodsShelfStockCountList";
  public static final String GOODS_ALLOCATION_LIST = "goodsAllocationList";

  public static final String INTERNAL_TYPE = "GoodsShelf";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LOCATION_PROPERTY, "location", "位置")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(STORAGE_SPACE_PROPERTY, "storage_space", "存货区")
            .withType("storage_space", StorageSpace.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SUPPLIER_SPACE_PROPERTY, "supplier_space", "供应商的空间")
            .withType("supplier_space", SupplierSpace.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DAMAGE_SPACE_PROPERTY, "damage_space", "残次货物存放区")
            .withType("damage_space", DamageSpace.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
            .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(GOODS_SHELF_STOCK_COUNT_LIST, "shelf", "库存盘点清单")
            .withType("goods_shelf_stock_count", GoodsShelfStockCount.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(GOODS_ALLOCATION_LIST, "goodsShelf", "货物分配列表")
            .withType("goods_allocation", GoodsAllocation.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      LOCATION_PROPERTY,
      STORAGE_SPACE_PROPERTY,
      SUPPLIER_SPACE_PROPERTY,
      DAMAGE_SPACE_PROPERTY,
      LAST_UPDATE_TIME_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(GOODS_SHELF_STOCK_COUNT_LIST, "shelf");

    refers.put(GOODS_ALLOCATION_LIST, "goodsShelf");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(GOODS_SHELF_STOCK_COUNT_LIST, GoodsShelfStockCount.class);

    refers.put(GOODS_ALLOCATION_LIST, GoodsAllocation.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(STORAGE_SPACE_PROPERTY, StorageSpace.class);
    parents.put(SUPPLIER_SPACE_PROPERTY, SupplierSpace.class);
    parents.put(DAMAGE_SPACE_PROPERTY, DamageSpace.class);

    return parents;
  }
  /*
  public GoodsShelf want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public GoodsShelf wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getLocation();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String location;
  protected StorageSpace storageSpace;
  protected SupplierSpace supplierSpace;
  protected DamageSpace damageSpace;
  protected DateTime lastUpdateTime;
  protected int version;

  protected SmartList<GoodsShelfStockCount> mGoodsShelfStockCountList;
  protected SmartList<GoodsAllocation> mGoodsAllocationList;

  public GoodsShelf() {
    // lazy load for all the properties
  }

  public static GoodsShelf withId(String id) {
    GoodsShelf goodsShelf = new GoodsShelf();
    goodsShelf.setId(id);
    goodsShelf.setVersion(Integer.MAX_VALUE);
    goodsShelf.setChecked(true);
    return goodsShelf;
  }

  public static GoodsShelf refById(String id) {
    return withId(id);
  }

  public GoodsShelf limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public GoodsShelf limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static GoodsShelf searchExample() {
    GoodsShelf goodsShelf = new GoodsShelf();
    goodsShelf.setVersion(UNSET_INT);

    return goodsShelf;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setStorageSpace( null );
  	setSupplierSpace( null );
  	setDamageSpace( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (LOCATION_PROPERTY.equals(property)) {
      changeLocationProperty(newValueExpr);
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      changeLastUpdateTimeProperty(newValueExpr);
    }
  }

  protected void changeLocationProperty(String newValueExpr) {

    String oldValue = getLocation();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLocation(newValue);
    this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
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

    if (LOCATION_PROPERTY.equals(property)) {
      return getLocation();
    }
    if (STORAGE_SPACE_PROPERTY.equals(property)) {
      return getStorageSpace();
    }
    if (SUPPLIER_SPACE_PROPERTY.equals(property)) {
      return getSupplierSpace();
    }
    if (DAMAGE_SPACE_PROPERTY.equals(property)) {
      return getDamageSpace();
    }
    if (LAST_UPDATE_TIME_PROPERTY.equals(property)) {
      return getLastUpdateTime();
    }
    if (GOODS_SHELF_STOCK_COUNT_LIST.equals(property)) {
      List<BaseEntity> list =
          getGoodsShelfStockCountList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (GOODS_ALLOCATION_LIST.equals(property)) {
      List<BaseEntity> list =
          getGoodsAllocationList().stream().map(item -> item).collect(Collectors.toList());
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

  public GoodsShelf updateId(String id) {
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

  public GoodsShelf orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public GoodsShelf ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public GoodsShelf addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setLocation(String location) {
    String oldLocation = this.location;
    String newLocation = trimString(location);
    this.location = newLocation;
  }

  public String location() {
    doLoad();
    return getLocation();
  }

  public String getLocation() {
    return this.location;
  }

  public GoodsShelf updateLocation(String location) {
    String oldLocation = this.location;
    String newLocation = trimString(location);
    if (!shouldReplaceBy(newLocation, oldLocation)) {
      return this;
    }
    this.location = newLocation;
    if (cn.hutool.core.util.ObjectUtil.equals(newLocation, oldLocation)) {
      return this;
    }
    addPropertyChange(LOCATION_PROPERTY, oldLocation, newLocation);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsShelf orderByLocation(boolean asc) {
    doAddOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLocationCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LOCATION_PROPERTY, operator, parameters);
  }

  public GoodsShelf ignoreLocationCriteria() {
    super.ignoreSearchProperty(LOCATION_PROPERTY);
    return this;
  }

  public GoodsShelf addLocationCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLocationCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLocation(String location) {
    if (location != null) {
      updateLocation(location);
    }
  }

  public void setStorageSpace(StorageSpace storageSpace) {
    StorageSpace oldStorageSpace = this.storageSpace;
    StorageSpace newStorageSpace = storageSpace;
    this.storageSpace = newStorageSpace;
  }

  public StorageSpace storageSpace() {
    doLoad();
    return getStorageSpace();
  }

  public StorageSpace getStorageSpace() {
    return this.storageSpace;
  }

  public GoodsShelf updateStorageSpace(StorageSpace storageSpace) {
    StorageSpace oldStorageSpace = this.storageSpace;
    StorageSpace newStorageSpace = storageSpace;
    if (!shouldReplaceBy(newStorageSpace, oldStorageSpace)) {
      return this;
    }
    this.storageSpace = newStorageSpace;
    if (cn.hutool.core.util.ObjectUtil.equals(newStorageSpace, oldStorageSpace)) {
      return this;
    }
    addPropertyChange(STORAGE_SPACE_PROPERTY, oldStorageSpace, newStorageSpace);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsShelf orderByStorageSpace(boolean asc) {
    doAddOrderBy(STORAGE_SPACE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createStorageSpaceCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(STORAGE_SPACE_PROPERTY, operator, parameters);
  }

  public GoodsShelf ignoreStorageSpaceCriteria() {
    super.ignoreSearchProperty(STORAGE_SPACE_PROPERTY);
    return this;
  }

  public GoodsShelf addStorageSpaceCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createStorageSpaceCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeStorageSpace(StorageSpace storageSpace) {
    if (storageSpace != null) {
      updateStorageSpace(storageSpace);
    }
  }

  public GoodsShelf updateStorageSpaceByReferenceId(String storageSpaceId) {
    updateStorageSpace(StorageSpace.refById(storageSpaceId));
    return this;
  }

  public void clearStorageSpace() {
    setStorageSpace(null);
    this.changed = true;
    setChecked(false);
  }

  public void setSupplierSpace(SupplierSpace supplierSpace) {
    SupplierSpace oldSupplierSpace = this.supplierSpace;
    SupplierSpace newSupplierSpace = supplierSpace;
    this.supplierSpace = newSupplierSpace;
  }

  public SupplierSpace supplierSpace() {
    doLoad();
    return getSupplierSpace();
  }

  public SupplierSpace getSupplierSpace() {
    return this.supplierSpace;
  }

  public GoodsShelf updateSupplierSpace(SupplierSpace supplierSpace) {
    SupplierSpace oldSupplierSpace = this.supplierSpace;
    SupplierSpace newSupplierSpace = supplierSpace;
    if (!shouldReplaceBy(newSupplierSpace, oldSupplierSpace)) {
      return this;
    }
    this.supplierSpace = newSupplierSpace;
    if (cn.hutool.core.util.ObjectUtil.equals(newSupplierSpace, oldSupplierSpace)) {
      return this;
    }
    addPropertyChange(SUPPLIER_SPACE_PROPERTY, oldSupplierSpace, newSupplierSpace);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsShelf orderBySupplierSpace(boolean asc) {
    doAddOrderBy(SUPPLIER_SPACE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSupplierSpaceCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SUPPLIER_SPACE_PROPERTY, operator, parameters);
  }

  public GoodsShelf ignoreSupplierSpaceCriteria() {
    super.ignoreSearchProperty(SUPPLIER_SPACE_PROPERTY);
    return this;
  }

  public GoodsShelf addSupplierSpaceCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSupplierSpaceCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSupplierSpace(SupplierSpace supplierSpace) {
    if (supplierSpace != null) {
      updateSupplierSpace(supplierSpace);
    }
  }

  public GoodsShelf updateSupplierSpaceByReferenceId(String supplierSpaceId) {
    updateSupplierSpace(SupplierSpace.refById(supplierSpaceId));
    return this;
  }

  public void clearSupplierSpace() {
    setSupplierSpace(null);
    this.changed = true;
    setChecked(false);
  }

  public void setDamageSpace(DamageSpace damageSpace) {
    DamageSpace oldDamageSpace = this.damageSpace;
    DamageSpace newDamageSpace = damageSpace;
    this.damageSpace = newDamageSpace;
  }

  public DamageSpace damageSpace() {
    doLoad();
    return getDamageSpace();
  }

  public DamageSpace getDamageSpace() {
    return this.damageSpace;
  }

  public GoodsShelf updateDamageSpace(DamageSpace damageSpace) {
    DamageSpace oldDamageSpace = this.damageSpace;
    DamageSpace newDamageSpace = damageSpace;
    if (!shouldReplaceBy(newDamageSpace, oldDamageSpace)) {
      return this;
    }
    this.damageSpace = newDamageSpace;
    if (cn.hutool.core.util.ObjectUtil.equals(newDamageSpace, oldDamageSpace)) {
      return this;
    }
    addPropertyChange(DAMAGE_SPACE_PROPERTY, oldDamageSpace, newDamageSpace);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsShelf orderByDamageSpace(boolean asc) {
    doAddOrderBy(DAMAGE_SPACE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDamageSpaceCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DAMAGE_SPACE_PROPERTY, operator, parameters);
  }

  public GoodsShelf ignoreDamageSpaceCriteria() {
    super.ignoreSearchProperty(DAMAGE_SPACE_PROPERTY);
    return this;
  }

  public GoodsShelf addDamageSpaceCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDamageSpaceCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDamageSpace(DamageSpace damageSpace) {
    if (damageSpace != null) {
      updateDamageSpace(damageSpace);
    }
  }

  public GoodsShelf updateDamageSpaceByReferenceId(String damageSpaceId) {
    updateDamageSpace(DamageSpace.refById(damageSpaceId));
    return this;
  }

  public void clearDamageSpace() {
    setDamageSpace(null);
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

  public GoodsShelf updateLastUpdateTime(DateTime lastUpdateTime) {
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

  public GoodsShelf orderByLastUpdateTime(boolean asc) {
    doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
  }

  public GoodsShelf ignoreLastUpdateTimeCriteria() {
    super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public GoodsShelf addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters) {
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

  public GoodsShelf updateVersion(int version) {
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

  public GoodsShelf orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public GoodsShelf ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public GoodsShelf addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<GoodsShelfStockCount> getGoodsShelfStockCountList() {
    if (this.mGoodsShelfStockCountList == null) {
      this.mGoodsShelfStockCountList = new SmartList<GoodsShelfStockCount>();
      this.mGoodsShelfStockCountList.setListInternalName(GOODS_SHELF_STOCK_COUNT_LIST);
      // 有名字，便于做权限控制
    }

    return this.mGoodsShelfStockCountList;
  }

  public SmartList<GoodsShelfStockCount> goodsShelfStockCountList() {

    doLoadChild(GOODS_SHELF_STOCK_COUNT_LIST);

    return getGoodsShelfStockCountList();
  }

  public void setGoodsShelfStockCountList(
      SmartList<GoodsShelfStockCount> goodsShelfStockCountList) {
    for (GoodsShelfStockCount goodsShelfStockCount : goodsShelfStockCountList) {
      goodsShelfStockCount.setShelf(this);
    }

    this.mGoodsShelfStockCountList = goodsShelfStockCountList;
    this.mGoodsShelfStockCountList.setListInternalName(GOODS_SHELF_STOCK_COUNT_LIST);
  }

  public GoodsShelf addGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount) {
    goodsShelfStockCount.updateShelf(this);
    getGoodsShelfStockCountList().add(goodsShelfStockCount);
    return this;
  }

  public GoodsShelf addGoodsShelfStockCountList(
      SmartList<GoodsShelfStockCount> goodsShelfStockCountList) {
    for (GoodsShelfStockCount goodsShelfStockCount : goodsShelfStockCountList) {
      goodsShelfStockCount.updateShelf(this);
    }

    Map<String, GoodsShelfStockCount> mapById = goodsShelfStockCountList.mapWithId();
    getGoodsShelfStockCountList().removeIf(item -> mapById.get(item.getId()) != null);
    getGoodsShelfStockCountList().addAll(goodsShelfStockCountList);
    return this;
  }

  public void mergeGoodsShelfStockCountList(
      SmartList<GoodsShelfStockCount> goodsShelfStockCountList) {
    if (goodsShelfStockCountList == null) {
      return;
    }
    if (goodsShelfStockCountList.isEmpty()) {
      return;
    }
    addGoodsShelfStockCountList(goodsShelfStockCountList);
  }

  public GoodsShelfStockCount removeGoodsShelfStockCount(
      GoodsShelfStockCount goodsShelfStockCountIndex) {

    int index = getGoodsShelfStockCountList().indexOf(goodsShelfStockCountIndex);
    if (index < 0) {
      String message =
          "GoodsShelfStockCount("
              + goodsShelfStockCountIndex.getId()
              + ") with version='"
              + goodsShelfStockCountIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    GoodsShelfStockCount goodsShelfStockCount = getGoodsShelfStockCountList().get(index);
    // goodsShelfStockCount.clearShelf(); //disconnect with Shelf
    goodsShelfStockCount.clearFromAll(); // disconnect with Shelf

    boolean result = getGoodsShelfStockCountList().planToRemove(goodsShelfStockCount);
    if (!result) {
      String message =
          "GoodsShelfStockCount("
              + goodsShelfStockCountIndex.getId()
              + ") with version='"
              + goodsShelfStockCountIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return goodsShelfStockCount;
  }
  // 断舍离
  public void breakWithGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount) {

    if (goodsShelfStockCount == null) {
      return;
    }
    goodsShelfStockCount.setShelf(null);
    // getGoodsShelfStockCountList().remove();

  }

  public boolean hasGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount) {

    return getGoodsShelfStockCountList().contains(goodsShelfStockCount);
  }

  public void copyGoodsShelfStockCountFrom(GoodsShelfStockCount goodsShelfStockCount) {

    GoodsShelfStockCount goodsShelfStockCountInList =
        findTheGoodsShelfStockCount(goodsShelfStockCount);
    GoodsShelfStockCount newGoodsShelfStockCount = new GoodsShelfStockCount();
    goodsShelfStockCountInList.copyTo(newGoodsShelfStockCount);
    newGoodsShelfStockCount.setVersion(0); // will trigger copy
    getGoodsShelfStockCountList().add(newGoodsShelfStockCount);
    addItemToFlexiableObject(COPIED_CHILD, newGoodsShelfStockCount);
  }

  public GoodsShelfStockCount findTheGoodsShelfStockCount(
      GoodsShelfStockCount goodsShelfStockCount) {

    int index = getGoodsShelfStockCountList().indexOf(goodsShelfStockCount);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "GoodsShelfStockCount("
              + goodsShelfStockCount.getId()
              + ") with version='"
              + goodsShelfStockCount.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getGoodsShelfStockCountList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpGoodsShelfStockCountList() {
    getGoodsShelfStockCountList().clear();
  }

  public SmartList<GoodsAllocation> getGoodsAllocationList() {
    if (this.mGoodsAllocationList == null) {
      this.mGoodsAllocationList = new SmartList<GoodsAllocation>();
      this.mGoodsAllocationList.setListInternalName(GOODS_ALLOCATION_LIST);
      // 有名字，便于做权限控制
    }

    return this.mGoodsAllocationList;
  }

  public SmartList<GoodsAllocation> goodsAllocationList() {

    doLoadChild(GOODS_ALLOCATION_LIST);

    return getGoodsAllocationList();
  }

  public void setGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList) {
    for (GoodsAllocation goodsAllocation : goodsAllocationList) {
      goodsAllocation.setGoodsShelf(this);
    }

    this.mGoodsAllocationList = goodsAllocationList;
    this.mGoodsAllocationList.setListInternalName(GOODS_ALLOCATION_LIST);
  }

  public GoodsShelf addGoodsAllocation(GoodsAllocation goodsAllocation) {
    goodsAllocation.updateGoodsShelf(this);
    getGoodsAllocationList().add(goodsAllocation);
    return this;
  }

  public GoodsShelf addGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList) {
    for (GoodsAllocation goodsAllocation : goodsAllocationList) {
      goodsAllocation.updateGoodsShelf(this);
    }

    Map<String, GoodsAllocation> mapById = goodsAllocationList.mapWithId();
    getGoodsAllocationList().removeIf(item -> mapById.get(item.getId()) != null);
    getGoodsAllocationList().addAll(goodsAllocationList);
    return this;
  }

  public void mergeGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList) {
    if (goodsAllocationList == null) {
      return;
    }
    if (goodsAllocationList.isEmpty()) {
      return;
    }
    addGoodsAllocationList(goodsAllocationList);
  }

  public GoodsAllocation removeGoodsAllocation(GoodsAllocation goodsAllocationIndex) {

    int index = getGoodsAllocationList().indexOf(goodsAllocationIndex);
    if (index < 0) {
      String message =
          "GoodsAllocation("
              + goodsAllocationIndex.getId()
              + ") with version='"
              + goodsAllocationIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    GoodsAllocation goodsAllocation = getGoodsAllocationList().get(index);
    // goodsAllocation.clearGoodsShelf(); //disconnect with GoodsShelf
    goodsAllocation.clearFromAll(); // disconnect with GoodsShelf

    boolean result = getGoodsAllocationList().planToRemove(goodsAllocation);
    if (!result) {
      String message =
          "GoodsAllocation("
              + goodsAllocationIndex.getId()
              + ") with version='"
              + goodsAllocationIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return goodsAllocation;
  }
  // 断舍离
  public void breakWithGoodsAllocation(GoodsAllocation goodsAllocation) {

    if (goodsAllocation == null) {
      return;
    }
    goodsAllocation.setGoodsShelf(null);
    // getGoodsAllocationList().remove();

  }

  public boolean hasGoodsAllocation(GoodsAllocation goodsAllocation) {

    return getGoodsAllocationList().contains(goodsAllocation);
  }

  public void copyGoodsAllocationFrom(GoodsAllocation goodsAllocation) {

    GoodsAllocation goodsAllocationInList = findTheGoodsAllocation(goodsAllocation);
    GoodsAllocation newGoodsAllocation = new GoodsAllocation();
    goodsAllocationInList.copyTo(newGoodsAllocation);
    newGoodsAllocation.setVersion(0); // will trigger copy
    getGoodsAllocationList().add(newGoodsAllocation);
    addItemToFlexiableObject(COPIED_CHILD, newGoodsAllocation);
  }

  public GoodsAllocation findTheGoodsAllocation(GoodsAllocation goodsAllocation) {

    int index = getGoodsAllocationList().indexOf(goodsAllocation);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "GoodsAllocation("
              + goodsAllocation.getId()
              + ") with version='"
              + goodsAllocation.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getGoodsAllocationList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpGoodsAllocationList() {
    getGoodsAllocationList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getStorageSpace(), internalType);
    addToEntityList(this, entityList, getSupplierSpace(), internalType);
    addToEntityList(this, entityList, getDamageSpace(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getGoodsShelfStockCountList(), internalType);
    collectFromList(this, entityList, getGoodsAllocationList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getGoodsShelfStockCountList());
    listOfList.add(getGoodsAllocationList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
    appendKeyValuePair(result, STORAGE_SPACE_PROPERTY, getStorageSpace());
    appendKeyValuePair(result, SUPPLIER_SPACE_PROPERTY, getSupplierSpace());
    appendKeyValuePair(result, DAMAGE_SPACE_PROPERTY, getDamageSpace());
    appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, GOODS_SHELF_STOCK_COUNT_LIST, getGoodsShelfStockCountList());
    if (!getGoodsShelfStockCountList().isEmpty()) {
      appendKeyValuePair(
          result, "goodsShelfStockCountCount", getGoodsShelfStockCountList().getTotalCount());
      appendKeyValuePair(
          result,
          "goodsShelfStockCountCurrentPageNumber",
          getGoodsShelfStockCountList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, GOODS_ALLOCATION_LIST, getGoodsAllocationList());
    if (!getGoodsAllocationList().isEmpty()) {
      appendKeyValuePair(result, "goodsAllocationCount", getGoodsAllocationList().getTotalCount());
      appendKeyValuePair(
          result,
          "goodsAllocationCurrentPageNumber",
          getGoodsAllocationList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof GoodsShelf) {

      GoodsShelf dest = (GoodsShelf) baseDest;

      dest.setId(getId());
      dest.setLocation(getLocation());
      dest.setStorageSpace(getStorageSpace());
      dest.setSupplierSpace(getSupplierSpace());
      dest.setDamageSpace(getDamageSpace());
      dest.setLastUpdateTime(getLastUpdateTime());
      dest.setVersion(getVersion());
      dest.setGoodsShelfStockCountList(getGoodsShelfStockCountList());
      dest.setGoodsAllocationList(getGoodsAllocationList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof GoodsShelf) {

      GoodsShelf source = (GoodsShelf) sourceEntity;

      mergeId(source.getId());
      mergeLocation(source.getLocation());
      mergeStorageSpace(source.getStorageSpace());
      mergeSupplierSpace(source.getSupplierSpace());
      mergeDamageSpace(source.getDamageSpace());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
      mergeGoodsShelfStockCountList(source.getGoodsShelfStockCountList());
      mergeGoodsAllocationList(source.getGoodsAllocationList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof GoodsShelf) {

      GoodsShelf source = (GoodsShelf) sourceEntity;

      mergeId(source.getId());
      mergeLocation(source.getLocation());
      mergeLastUpdateTime(source.getLastUpdateTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getLocation(),
      getStorageSpace(),
      getSupplierSpace(),
      getDamageSpace(),
      getLastUpdateTime(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    GoodsShelf checkGoodsShelf =
        Q.goodsShelfWithIdField()
            .filterById(id)
            .selectGoodsShelfStockCountList(Q.goodsShelfStockCountWithIdField().limit(0, 1))
            .selectGoodsAllocationList(Q.goodsAllocationWithIdField().limit(0, 1))
            .execute(ctx);

    return checkGoodsShelf != null
        && !checkGoodsShelf.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public GoodsShelf save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("GoodsShelf{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tlocation='" + getLocation() + "';");
    if (getStorageSpace() != null) {
      stringBuilder.append("\tstorageSpace='StorageSpace(" + getStorageSpace().getId() + ")';");
    }
    if (getSupplierSpace() != null) {
      stringBuilder.append("\tsupplierSpace='SupplierSpace(" + getSupplierSpace().getId() + ")';");
    }
    if (getDamageSpace() != null) {
      stringBuilder.append("\tdamageSpace='DamageSpace(" + getDamageSpace().getId() + ")';");
    }
    stringBuilder.append("\tlastUpdateTime='" + getLastUpdateTime() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
