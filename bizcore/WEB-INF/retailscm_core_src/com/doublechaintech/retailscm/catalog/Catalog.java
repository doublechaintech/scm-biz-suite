package com.doublechaintech.retailscm.catalog;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

@JsonSerialize(using = CatalogSerializer.class)
public class Catalog extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(Catalog target) {
    if (target == null) {
      return;
    }
    target.addLevelOneCategoryList(this.getLevelOneCategoryList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String OWNER_PROPERTY = "owner";
  public static final String SUB_COUNT_PROPERTY = "subCount";
  public static final String AMOUNT_PROPERTY = "amount";
  public static final String VERSION_PROPERTY = "version";

  public static final String LEVEL_ONE_CATEGORY_LIST = "levelOneCategoryList";

  public static final String INTERNAL_TYPE = "Catalog";

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
        MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_country_center", "业主")
            .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SUB_COUNT_PROPERTY, "sub_count", "子数").withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额").withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(LEVEL_ONE_CATEGORY_LIST, "catalog", "一级类别列表")
            .withType("level_one_category", LevelOneCategory.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      OWNER_PROPERTY,
      SUB_COUNT_PROPERTY,
      AMOUNT_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(LEVEL_ONE_CATEGORY_LIST, "catalog");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(LEVEL_ONE_CATEGORY_LIST, LevelOneCategory.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(OWNER_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }
  /*
  public Catalog want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Catalog wants(Class<? extends BaseEntity>... classes) {
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
  protected RetailStoreCountryCenter owner;
  protected int subCount;
  protected BigDecimal amount;
  protected int version;

  protected SmartList<LevelOneCategory> mLevelOneCategoryList;

  public Catalog() {
    // lazy load for all the properties
  }

  public static Catalog withId(String id) {
    Catalog catalog = new Catalog();
    catalog.setId(id);
    catalog.setVersion(Integer.MAX_VALUE);
    catalog.setChecked(true);
    return catalog;
  }

  public static Catalog refById(String id) {
    return withId(id);
  }

  public Catalog limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public Catalog limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static Catalog searchExample() {
    Catalog catalog = new Catalog();
    catalog.setSubCount(UNSET_INT);
    catalog.setVersion(UNSET_INT);

    return catalog;
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
    if (SUB_COUNT_PROPERTY.equals(property)) {
      changeSubCountProperty(newValueExpr);
    }
    if (AMOUNT_PROPERTY.equals(property)) {
      changeAmountProperty(newValueExpr);
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

  protected void changeSubCountProperty(String newValueExpr) {

    int oldValue = getSubCount();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateSubCount(newValue);
    this.onChangeProperty(SUB_COUNT_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAmountProperty(String newValueExpr) {

    BigDecimal oldValue = getAmount();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAmount(newValue);
    this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (OWNER_PROPERTY.equals(property)) {
      return getOwner();
    }
    if (SUB_COUNT_PROPERTY.equals(property)) {
      return getSubCount();
    }
    if (AMOUNT_PROPERTY.equals(property)) {
      return getAmount();
    }
    if (LEVEL_ONE_CATEGORY_LIST.equals(property)) {
      List<BaseEntity> list =
          getLevelOneCategoryList().stream().map(item -> item).collect(Collectors.toList());
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

  public Catalog updateId(String id) {
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

  public Catalog orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public Catalog ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public Catalog addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public Catalog updateName(String name) {
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

  public Catalog orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public Catalog ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public Catalog addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setOwner(RetailStoreCountryCenter owner) {
    RetailStoreCountryCenter oldOwner = this.owner;
    RetailStoreCountryCenter newOwner = owner;
    this.owner = newOwner;
  }

  public RetailStoreCountryCenter owner() {
    doLoad();
    return getOwner();
  }

  public RetailStoreCountryCenter getOwner() {
    return this.owner;
  }

  public Catalog updateOwner(RetailStoreCountryCenter owner) {
    RetailStoreCountryCenter oldOwner = this.owner;
    RetailStoreCountryCenter newOwner = owner;
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

  public Catalog orderByOwner(boolean asc) {
    doAddOrderBy(OWNER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OWNER_PROPERTY, operator, parameters);
  }

  public Catalog ignoreOwnerCriteria() {
    super.ignoreSearchProperty(OWNER_PROPERTY);
    return this;
  }

  public Catalog addOwnerCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOwnerCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOwner(RetailStoreCountryCenter owner) {
    if (owner != null) {
      updateOwner(owner);
    }
  }

  public Catalog updateOwnerByReferenceId(String ownerId) {
    updateOwner(RetailStoreCountryCenter.refById(ownerId));
    return this;
  }

  public void clearOwner() {
    setOwner(null);
    this.changed = true;
    setChecked(false);
  }

  public void setSubCount(int subCount) {
    int oldSubCount = this.subCount;
    int newSubCount = subCount;
    this.subCount = newSubCount;
  }

  public int subCount() {
    doLoad();
    return getSubCount();
  }

  public int getSubCount() {
    return this.subCount;
  }

  public Catalog updateSubCount(int subCount) {
    int oldSubCount = this.subCount;
    int newSubCount = subCount;
    if (!shouldReplaceBy(newSubCount, oldSubCount)) {
      return this;
    }
    this.subCount = newSubCount;
    if (cn.hutool.core.util.ObjectUtil.equals(newSubCount, oldSubCount)) {
      return this;
    }
    addPropertyChange(SUB_COUNT_PROPERTY, oldSubCount, newSubCount);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Catalog orderBySubCount(boolean asc) {
    doAddOrderBy(SUB_COUNT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSubCountCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SUB_COUNT_PROPERTY, operator, parameters);
  }

  public Catalog ignoreSubCountCriteria() {
    super.ignoreSearchProperty(SUB_COUNT_PROPERTY);
    return this;
  }

  public Catalog addSubCountCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSubCountCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSubCount(int subCount) {
    updateSubCount(subCount);
  }

  public void setAmount(BigDecimal amount) {
    BigDecimal oldAmount = this.amount;
    BigDecimal newAmount = amount;
    this.amount = newAmount;
  }

  public BigDecimal amount() {
    doLoad();
    return getAmount();
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public Catalog updateAmount(BigDecimal amount) {
    BigDecimal oldAmount = this.amount;
    BigDecimal newAmount = amount;
    if (!shouldReplaceBy(newAmount, oldAmount)) {
      return this;
    }
    this.amount = newAmount;
    if (cn.hutool.core.util.ObjectUtil.equals(newAmount, oldAmount)) {
      return this;
    }
    addPropertyChange(AMOUNT_PROPERTY, oldAmount, newAmount);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Catalog orderByAmount(boolean asc) {
    doAddOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(AMOUNT_PROPERTY, operator, parameters);
  }

  public Catalog ignoreAmountCriteria() {
    super.ignoreSearchProperty(AMOUNT_PROPERTY);
    return this;
  }

  public Catalog addAmountCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAmountCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAmount(BigDecimal amount) {
    updateAmount(amount);
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

  public Catalog updateVersion(int version) {
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

  public Catalog orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public Catalog ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public Catalog addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<LevelOneCategory> getLevelOneCategoryList() {
    if (this.mLevelOneCategoryList == null) {
      this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();
      this.mLevelOneCategoryList.setListInternalName(LEVEL_ONE_CATEGORY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mLevelOneCategoryList;
  }

  public SmartList<LevelOneCategory> levelOneCategoryList() {

    doLoadChild(LEVEL_ONE_CATEGORY_LIST);

    return getLevelOneCategoryList();
  }

  public void setLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList) {
    for (LevelOneCategory levelOneCategory : levelOneCategoryList) {
      levelOneCategory.setCatalog(this);
    }

    this.mLevelOneCategoryList = levelOneCategoryList;
    this.mLevelOneCategoryList.setListInternalName(LEVEL_ONE_CATEGORY_LIST);
  }

  public Catalog addLevelOneCategory(LevelOneCategory levelOneCategory) {
    levelOneCategory.updateCatalog(this);
    getLevelOneCategoryList().add(levelOneCategory);
    return this;
  }

  public Catalog addLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList) {
    for (LevelOneCategory levelOneCategory : levelOneCategoryList) {
      levelOneCategory.updateCatalog(this);
    }

    Map<String, LevelOneCategory> mapById = levelOneCategoryList.mapWithId();
    getLevelOneCategoryList().removeIf(item -> mapById.get(item.getId()) != null);
    getLevelOneCategoryList().addAll(levelOneCategoryList);
    return this;
  }

  public void mergeLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList) {
    if (levelOneCategoryList == null) {
      return;
    }
    if (levelOneCategoryList.isEmpty()) {
      return;
    }
    addLevelOneCategoryList(levelOneCategoryList);
  }

  public LevelOneCategory removeLevelOneCategory(LevelOneCategory levelOneCategoryIndex) {

    int index = getLevelOneCategoryList().indexOf(levelOneCategoryIndex);
    if (index < 0) {
      String message =
          "LevelOneCategory("
              + levelOneCategoryIndex.getId()
              + ") with version='"
              + levelOneCategoryIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    LevelOneCategory levelOneCategory = getLevelOneCategoryList().get(index);
    // levelOneCategory.clearCatalog(); //disconnect with Catalog
    levelOneCategory.clearFromAll(); // disconnect with Catalog

    boolean result = getLevelOneCategoryList().planToRemove(levelOneCategory);
    if (!result) {
      String message =
          "LevelOneCategory("
              + levelOneCategoryIndex.getId()
              + ") with version='"
              + levelOneCategoryIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return levelOneCategory;
  }
  // 断舍离
  public void breakWithLevelOneCategory(LevelOneCategory levelOneCategory) {

    if (levelOneCategory == null) {
      return;
    }
    levelOneCategory.setCatalog(null);
    // getLevelOneCategoryList().remove();

  }

  public boolean hasLevelOneCategory(LevelOneCategory levelOneCategory) {

    return getLevelOneCategoryList().contains(levelOneCategory);
  }

  public void copyLevelOneCategoryFrom(LevelOneCategory levelOneCategory) {

    LevelOneCategory levelOneCategoryInList = findTheLevelOneCategory(levelOneCategory);
    LevelOneCategory newLevelOneCategory = new LevelOneCategory();
    levelOneCategoryInList.copyTo(newLevelOneCategory);
    newLevelOneCategory.setVersion(0); // will trigger copy
    getLevelOneCategoryList().add(newLevelOneCategory);
    addItemToFlexiableObject(COPIED_CHILD, newLevelOneCategory);
  }

  public LevelOneCategory findTheLevelOneCategory(LevelOneCategory levelOneCategory) {

    int index = getLevelOneCategoryList().indexOf(levelOneCategory);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "LevelOneCategory("
              + levelOneCategory.getId()
              + ") with version='"
              + levelOneCategory.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getLevelOneCategoryList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpLevelOneCategoryList() {
    getLevelOneCategoryList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getOwner(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getLevelOneCategoryList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getLevelOneCategoryList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
    appendKeyValuePair(result, SUB_COUNT_PROPERTY, getSubCount());
    appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, LEVEL_ONE_CATEGORY_LIST, getLevelOneCategoryList());
    if (!getLevelOneCategoryList().isEmpty()) {
      appendKeyValuePair(
          result, "levelOneCategoryCount", getLevelOneCategoryList().getTotalCount());
      appendKeyValuePair(
          result,
          "levelOneCategoryCurrentPageNumber",
          getLevelOneCategoryList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof Catalog) {

      Catalog dest = (Catalog) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setOwner(getOwner());
      dest.setSubCount(getSubCount());
      dest.setAmount(getAmount());
      dest.setVersion(getVersion());
      dest.setLevelOneCategoryList(getLevelOneCategoryList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof Catalog) {

      Catalog source = (Catalog) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeOwner(source.getOwner());
      mergeSubCount(source.getSubCount());
      mergeAmount(source.getAmount());
      mergeVersion(source.getVersion());
      mergeLevelOneCategoryList(source.getLevelOneCategoryList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof Catalog) {

      Catalog source = (Catalog) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeSubCount(source.getSubCount());
      mergeAmount(source.getAmount());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getName(), getOwner(), getSubCount(), getAmount(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    Catalog checkCatalog =
        Q.catalogWithIdField()
            .filterById(id)
            .selectLevelOneCategoryList(Q.levelOneCategoryWithIdField().limit(0, 1))
            .execute(ctx);

    return checkCatalog != null
        && !checkCatalog.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public Catalog save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("Catalog{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    if (getOwner() != null) {
      stringBuilder.append("\towner='RetailStoreCountryCenter(" + getOwner().getId() + ")';");
    }
    stringBuilder.append("\tsubCount='" + getSubCount() + "';");
    stringBuilder.append("\tamount='" + getAmount() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increaseSubCount(int incSubCount) {
    updateSubCount(this.subCount + incSubCount);
  }

  public void decreaseSubCount(int decSubCount) {
    updateSubCount(this.subCount - decSubCount);
  }
}
