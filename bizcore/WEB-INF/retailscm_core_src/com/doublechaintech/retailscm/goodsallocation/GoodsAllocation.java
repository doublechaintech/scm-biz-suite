package com.doublechaintech.retailscm.goodsallocation;

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
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

@JsonSerialize(using = GoodsAllocationSerializer.class)
public class GoodsAllocation extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(GoodsAllocation target) {
    if (target == null) {
      return;
    }
    target.addGoodsList(this.getGoodsList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String LOCATION_PROPERTY = "location";
  public static final String LATITUDE_PROPERTY = "latitude";
  public static final String LONGITUDE_PROPERTY = "longitude";
  public static final String GOODS_SHELF_PROPERTY = "goodsShelf";
  public static final String VERSION_PROPERTY = "version";

  public static final String GOODS_LIST = "goodsList";

  public static final String INTERNAL_TYPE = "GoodsAllocation";

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
        MemberMetaInfo.defineBy(LATITUDE_PROPERTY, "latitude", "纬度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LONGITUDE_PROPERTY, "longitude", "经度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(GOODS_SHELF_PROPERTY, "goods_shelf", "货架")
            .withType("goods_shelf", GoodsShelf.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(GOODS_LIST, "goodsAllocation", "商品列表")
            .withType("goods", Goods.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      LOCATION_PROPERTY,
      LATITUDE_PROPERTY,
      LONGITUDE_PROPERTY,
      GOODS_SHELF_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(GOODS_LIST, "goodsAllocation");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(GOODS_LIST, Goods.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(GOODS_SHELF_PROPERTY, GoodsShelf.class);

    return parents;
  }
  /*
  public GoodsAllocation want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public GoodsAllocation wants(Class<? extends BaseEntity>... classes) {
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
  protected BigDecimal latitude;
  protected BigDecimal longitude;
  protected GoodsShelf goodsShelf;
  protected int version;

  protected SmartList<Goods> mGoodsList;

  public GoodsAllocation() {
    // lazy load for all the properties
  }

  public static GoodsAllocation withId(String id) {
    GoodsAllocation goodsAllocation = new GoodsAllocation();
    goodsAllocation.setId(id);
    goodsAllocation.setVersion(Integer.MAX_VALUE);
    goodsAllocation.setChecked(true);
    return goodsAllocation;
  }

  public static GoodsAllocation refById(String id) {
    return withId(id);
  }

  public GoodsAllocation limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public GoodsAllocation limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static GoodsAllocation searchExample() {
    GoodsAllocation goodsAllocation = new GoodsAllocation();
    goodsAllocation.setVersion(UNSET_INT);

    return goodsAllocation;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setGoodsShelf( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (LOCATION_PROPERTY.equals(property)) {
      changeLocationProperty(newValueExpr);
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      changeLatitudeProperty(newValueExpr);
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      changeLongitudeProperty(newValueExpr);
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

    if (LOCATION_PROPERTY.equals(property)) {
      return getLocation();
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      return getLatitude();
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      return getLongitude();
    }
    if (GOODS_SHELF_PROPERTY.equals(property)) {
      return getGoodsShelf();
    }
    if (GOODS_LIST.equals(property)) {
      List<BaseEntity> list =
          getGoodsList().stream().map(item -> item).collect(Collectors.toList());
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

  public GoodsAllocation updateId(String id) {
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

  public GoodsAllocation orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public GoodsAllocation ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public GoodsAllocation addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public GoodsAllocation updateLocation(String location) {
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

  public GoodsAllocation orderByLocation(boolean asc) {
    doAddOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLocationCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LOCATION_PROPERTY, operator, parameters);
  }

  public GoodsAllocation ignoreLocationCriteria() {
    super.ignoreSearchProperty(LOCATION_PROPERTY);
    return this;
  }

  public GoodsAllocation addLocationCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLocationCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLocation(String location) {
    if (location != null) {
      updateLocation(location);
    }
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

  public GoodsAllocation updateLatitude(BigDecimal latitude) {
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

  public GoodsAllocation orderByLatitude(boolean asc) {
    doAddOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLatitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LATITUDE_PROPERTY, operator, parameters);
  }

  public GoodsAllocation ignoreLatitudeCriteria() {
    super.ignoreSearchProperty(LATITUDE_PROPERTY);
    return this;
  }

  public GoodsAllocation addLatitudeCriteria(QueryOperator operator, Object... parameters) {
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

  public GoodsAllocation updateLongitude(BigDecimal longitude) {
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

  public GoodsAllocation orderByLongitude(boolean asc) {
    doAddOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLongitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LONGITUDE_PROPERTY, operator, parameters);
  }

  public GoodsAllocation ignoreLongitudeCriteria() {
    super.ignoreSearchProperty(LONGITUDE_PROPERTY);
    return this;
  }

  public GoodsAllocation addLongitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLongitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLongitude(BigDecimal longitude) {
    updateLongitude(longitude);
  }

  public void setGoodsShelf(GoodsShelf goodsShelf) {
    GoodsShelf oldGoodsShelf = this.goodsShelf;
    GoodsShelf newGoodsShelf = goodsShelf;
    this.goodsShelf = newGoodsShelf;
  }

  public GoodsShelf goodsShelf() {
    doLoad();
    return getGoodsShelf();
  }

  public GoodsShelf getGoodsShelf() {
    return this.goodsShelf;
  }

  public GoodsAllocation updateGoodsShelf(GoodsShelf goodsShelf) {
    GoodsShelf oldGoodsShelf = this.goodsShelf;
    GoodsShelf newGoodsShelf = goodsShelf;
    if (!shouldReplaceBy(newGoodsShelf, oldGoodsShelf)) {
      return this;
    }
    this.goodsShelf = newGoodsShelf;
    if (cn.hutool.core.util.ObjectUtil.equals(newGoodsShelf, oldGoodsShelf)) {
      return this;
    }
    addPropertyChange(GOODS_SHELF_PROPERTY, oldGoodsShelf, newGoodsShelf);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsAllocation orderByGoodsShelf(boolean asc) {
    doAddOrderBy(GOODS_SHELF_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createGoodsShelfCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(GOODS_SHELF_PROPERTY, operator, parameters);
  }

  public GoodsAllocation ignoreGoodsShelfCriteria() {
    super.ignoreSearchProperty(GOODS_SHELF_PROPERTY);
    return this;
  }

  public GoodsAllocation addGoodsShelfCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createGoodsShelfCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeGoodsShelf(GoodsShelf goodsShelf) {
    if (goodsShelf != null) {
      updateGoodsShelf(goodsShelf);
    }
  }

  public GoodsAllocation updateGoodsShelfByReferenceId(String goodsShelfId) {
    updateGoodsShelf(GoodsShelf.refById(goodsShelfId));
    return this;
  }

  public void clearGoodsShelf() {
    setGoodsShelf(null);
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

  public GoodsAllocation updateVersion(int version) {
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

  public GoodsAllocation orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public GoodsAllocation ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public GoodsAllocation addVersionCriteria(QueryOperator operator, Object... parameters) {
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
      goods.setGoodsAllocation(this);
    }

    this.mGoodsList = goodsList;
    this.mGoodsList.setListInternalName(GOODS_LIST);
  }

  public GoodsAllocation addGoods(Goods goods) {
    goods.updateGoodsAllocation(this);
    getGoodsList().add(goods);
    return this;
  }

  public GoodsAllocation addGoodsList(SmartList<Goods> goodsList) {
    for (Goods goods : goodsList) {
      goods.updateGoodsAllocation(this);
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
    // goods.clearGoodsAllocation(); //disconnect with GoodsAllocation
    goods.clearFromAll(); // disconnect with GoodsAllocation

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
    goods.setGoodsAllocation(null);
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

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getGoodsShelf(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getGoodsList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getGoodsList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
    appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
    appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
    appendKeyValuePair(result, GOODS_SHELF_PROPERTY, getGoodsShelf());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, GOODS_LIST, getGoodsList());
    if (!getGoodsList().isEmpty()) {
      appendKeyValuePair(result, "goodsCount", getGoodsList().getTotalCount());
      appendKeyValuePair(result, "goodsCurrentPageNumber", getGoodsList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof GoodsAllocation) {

      GoodsAllocation dest = (GoodsAllocation) baseDest;

      dest.setId(getId());
      dest.setLocation(getLocation());
      dest.setLatitude(getLatitude());
      dest.setLongitude(getLongitude());
      dest.setGoodsShelf(getGoodsShelf());
      dest.setVersion(getVersion());
      dest.setGoodsList(getGoodsList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof GoodsAllocation) {

      GoodsAllocation source = (GoodsAllocation) sourceEntity;

      mergeId(source.getId());
      mergeLocation(source.getLocation());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeGoodsShelf(source.getGoodsShelf());
      mergeVersion(source.getVersion());
      mergeGoodsList(source.getGoodsList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof GoodsAllocation) {

      GoodsAllocation source = (GoodsAllocation) sourceEntity;

      mergeId(source.getId());
      mergeLocation(source.getLocation());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getLocation(), getLatitude(), getLongitude(), getGoodsShelf(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    GoodsAllocation checkGoodsAllocation =
        Q.goodsAllocationWithIdField()
            .filterById(id)
            .selectGoodsList(Q.goodsWithIdField().limit(0, 1))
            .execute(ctx);

    return checkGoodsAllocation != null
        && !checkGoodsAllocation.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public GoodsAllocation save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("GoodsAllocation{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tlocation='" + getLocation() + "';");
    stringBuilder.append("\tlatitude='" + getLatitude() + "';");
    stringBuilder.append("\tlongitude='" + getLongitude() + "';");
    if (getGoodsShelf() != null) {
      stringBuilder.append("\tgoodsShelf='GoodsShelf(" + getGoodsShelf().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
