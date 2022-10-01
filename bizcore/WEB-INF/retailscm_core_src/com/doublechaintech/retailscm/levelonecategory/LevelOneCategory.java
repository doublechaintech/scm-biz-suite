package com.doublechaintech.retailscm.levelonecategory;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.catalog.Catalog;

@JsonSerialize(using = LevelOneCategorySerializer.class)
public class LevelOneCategory extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(LevelOneCategory target) {
    if (target == null) {
      return;
    }
    target.addLevelTwoCategoryList(this.getLevelTwoCategoryList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String CATALOG_PROPERTY = "catalog";
  public static final String NAME_PROPERTY = "name";
  public static final String VERSION_PROPERTY = "version";

  public static final String LEVEL_TWO_CATEGORY_LIST = "levelTwoCategoryList";

  public static final String INTERNAL_TYPE = "LevelOneCategory";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CATALOG_PROPERTY, "catalog", "目录")
            .withType("catalog", Catalog.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(LEVEL_TWO_CATEGORY_LIST, "parentCategory", "二级类别列表")
            .withType("level_two_category", LevelTwoCategory.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {ID_PROPERTY, CATALOG_PROPERTY, NAME_PROPERTY, VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(LEVEL_TWO_CATEGORY_LIST, "parentCategory");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(LEVEL_TWO_CATEGORY_LIST, LevelTwoCategory.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(CATALOG_PROPERTY, Catalog.class);

    return parents;
  }
  /*
  public LevelOneCategory want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public LevelOneCategory wants(Class<? extends BaseEntity>... classes) {
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
  protected Catalog catalog;
  protected String name;
  protected int version;

  protected SmartList<LevelTwoCategory> mLevelTwoCategoryList;

  public LevelOneCategory() {
    // lazy load for all the properties
  }

  public static LevelOneCategory withId(String id) {
    LevelOneCategory levelOneCategory = new LevelOneCategory();
    levelOneCategory.setId(id);
    levelOneCategory.setVersion(Integer.MAX_VALUE);
    levelOneCategory.setChecked(true);
    return levelOneCategory;
  }

  public static LevelOneCategory refById(String id) {
    return withId(id);
  }

  public LevelOneCategory limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public LevelOneCategory limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static LevelOneCategory searchExample() {
    LevelOneCategory levelOneCategory = new LevelOneCategory();
    levelOneCategory.setVersion(UNSET_INT);

    return levelOneCategory;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setCatalog( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
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

  public Object propertyOf(String property) {

    if (CATALOG_PROPERTY.equals(property)) {
      return getCatalog();
    }
    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (LEVEL_TWO_CATEGORY_LIST.equals(property)) {
      List<BaseEntity> list =
          getLevelTwoCategoryList().stream().map(item -> item).collect(Collectors.toList());
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

  public LevelOneCategory updateId(String id) {
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

  public LevelOneCategory orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public LevelOneCategory ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public LevelOneCategory addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setCatalog(Catalog catalog) {
    Catalog oldCatalog = this.catalog;
    Catalog newCatalog = catalog;
    this.catalog = newCatalog;
  }

  public Catalog catalog() {
    doLoad();
    return getCatalog();
  }

  public Catalog getCatalog() {
    return this.catalog;
  }

  public LevelOneCategory updateCatalog(Catalog catalog) {
    Catalog oldCatalog = this.catalog;
    Catalog newCatalog = catalog;
    if (!shouldReplaceBy(newCatalog, oldCatalog)) {
      return this;
    }
    this.catalog = newCatalog;
    if (cn.hutool.core.util.ObjectUtil.equals(newCatalog, oldCatalog)) {
      return this;
    }
    addPropertyChange(CATALOG_PROPERTY, oldCatalog, newCatalog);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public LevelOneCategory orderByCatalog(boolean asc) {
    doAddOrderBy(CATALOG_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCatalogCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CATALOG_PROPERTY, operator, parameters);
  }

  public LevelOneCategory ignoreCatalogCriteria() {
    super.ignoreSearchProperty(CATALOG_PROPERTY);
    return this;
  }

  public LevelOneCategory addCatalogCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCatalogCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCatalog(Catalog catalog) {
    if (catalog != null) {
      updateCatalog(catalog);
    }
  }

  public LevelOneCategory updateCatalogByReferenceId(String catalogId) {
    updateCatalog(Catalog.refById(catalogId));
    return this;
  }

  public void clearCatalog() {
    setCatalog(null);
    this.changed = true;
    setChecked(false);
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

  public LevelOneCategory updateName(String name) {
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

  public LevelOneCategory orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public LevelOneCategory ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public LevelOneCategory addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
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

  public LevelOneCategory updateVersion(int version) {
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

  public LevelOneCategory orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public LevelOneCategory ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public LevelOneCategory addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<LevelTwoCategory> getLevelTwoCategoryList() {
    if (this.mLevelTwoCategoryList == null) {
      this.mLevelTwoCategoryList = new SmartList<LevelTwoCategory>();
      this.mLevelTwoCategoryList.setListInternalName(LEVEL_TWO_CATEGORY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mLevelTwoCategoryList;
  }

  public SmartList<LevelTwoCategory> levelTwoCategoryList() {

    doLoadChild(LEVEL_TWO_CATEGORY_LIST);

    return getLevelTwoCategoryList();
  }

  public void setLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList) {
    for (LevelTwoCategory levelTwoCategory : levelTwoCategoryList) {
      levelTwoCategory.setParentCategory(this);
    }

    this.mLevelTwoCategoryList = levelTwoCategoryList;
    this.mLevelTwoCategoryList.setListInternalName(LEVEL_TWO_CATEGORY_LIST);
  }

  public LevelOneCategory addLevelTwoCategory(LevelTwoCategory levelTwoCategory) {
    levelTwoCategory.updateParentCategory(this);
    getLevelTwoCategoryList().add(levelTwoCategory);
    return this;
  }

  public LevelOneCategory addLevelTwoCategoryList(
      SmartList<LevelTwoCategory> levelTwoCategoryList) {
    for (LevelTwoCategory levelTwoCategory : levelTwoCategoryList) {
      levelTwoCategory.updateParentCategory(this);
    }

    Map<String, LevelTwoCategory> mapById = levelTwoCategoryList.mapWithId();
    getLevelTwoCategoryList().removeIf(item -> mapById.get(item.getId()) != null);
    getLevelTwoCategoryList().addAll(levelTwoCategoryList);
    return this;
  }

  public void mergeLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList) {
    if (levelTwoCategoryList == null) {
      return;
    }
    if (levelTwoCategoryList.isEmpty()) {
      return;
    }
    addLevelTwoCategoryList(levelTwoCategoryList);
  }

  public LevelTwoCategory removeLevelTwoCategory(LevelTwoCategory levelTwoCategoryIndex) {

    int index = getLevelTwoCategoryList().indexOf(levelTwoCategoryIndex);
    if (index < 0) {
      String message =
          "LevelTwoCategory("
              + levelTwoCategoryIndex.getId()
              + ") with version='"
              + levelTwoCategoryIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    LevelTwoCategory levelTwoCategory = getLevelTwoCategoryList().get(index);
    // levelTwoCategory.clearParentCategory(); //disconnect with ParentCategory
    levelTwoCategory.clearFromAll(); // disconnect with ParentCategory

    boolean result = getLevelTwoCategoryList().planToRemove(levelTwoCategory);
    if (!result) {
      String message =
          "LevelTwoCategory("
              + levelTwoCategoryIndex.getId()
              + ") with version='"
              + levelTwoCategoryIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return levelTwoCategory;
  }
  // 断舍离
  public void breakWithLevelTwoCategory(LevelTwoCategory levelTwoCategory) {

    if (levelTwoCategory == null) {
      return;
    }
    levelTwoCategory.setParentCategory(null);
    // getLevelTwoCategoryList().remove();

  }

  public boolean hasLevelTwoCategory(LevelTwoCategory levelTwoCategory) {

    return getLevelTwoCategoryList().contains(levelTwoCategory);
  }

  public void copyLevelTwoCategoryFrom(LevelTwoCategory levelTwoCategory) {

    LevelTwoCategory levelTwoCategoryInList = findTheLevelTwoCategory(levelTwoCategory);
    LevelTwoCategory newLevelTwoCategory = new LevelTwoCategory();
    levelTwoCategoryInList.copyTo(newLevelTwoCategory);
    newLevelTwoCategory.setVersion(0); // will trigger copy
    getLevelTwoCategoryList().add(newLevelTwoCategory);
    addItemToFlexiableObject(COPIED_CHILD, newLevelTwoCategory);
  }

  public LevelTwoCategory findTheLevelTwoCategory(LevelTwoCategory levelTwoCategory) {

    int index = getLevelTwoCategoryList().indexOf(levelTwoCategory);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "LevelTwoCategory("
              + levelTwoCategory.getId()
              + ") with version='"
              + levelTwoCategory.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getLevelTwoCategoryList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpLevelTwoCategoryList() {
    getLevelTwoCategoryList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCatalog(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getLevelTwoCategoryList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getLevelTwoCategoryList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, CATALOG_PROPERTY, getCatalog());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, LEVEL_TWO_CATEGORY_LIST, getLevelTwoCategoryList());
    if (!getLevelTwoCategoryList().isEmpty()) {
      appendKeyValuePair(
          result, "levelTwoCategoryCount", getLevelTwoCategoryList().getTotalCount());
      appendKeyValuePair(
          result,
          "levelTwoCategoryCurrentPageNumber",
          getLevelTwoCategoryList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof LevelOneCategory) {

      LevelOneCategory dest = (LevelOneCategory) baseDest;

      dest.setId(getId());
      dest.setCatalog(getCatalog());
      dest.setName(getName());
      dest.setVersion(getVersion());
      dest.setLevelTwoCategoryList(getLevelTwoCategoryList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof LevelOneCategory) {

      LevelOneCategory source = (LevelOneCategory) sourceEntity;

      mergeId(source.getId());
      mergeCatalog(source.getCatalog());
      mergeName(source.getName());
      mergeVersion(source.getVersion());
      mergeLevelTwoCategoryList(source.getLevelTwoCategoryList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof LevelOneCategory) {

      LevelOneCategory source = (LevelOneCategory) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getCatalog(), getName(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    LevelOneCategory checkLevelOneCategory =
        Q.levelOneCategoryWithIdField()
            .filterById(id)
            .selectLevelTwoCategoryList(Q.levelTwoCategoryWithIdField().limit(0, 1))
            .execute(ctx);

    return checkLevelOneCategory != null
        && !checkLevelOneCategory.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public LevelOneCategory save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("LevelOneCategory{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getCatalog() != null) {
      stringBuilder.append("\tcatalog='Catalog(" + getCatalog().getId() + ")';");
    }
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
