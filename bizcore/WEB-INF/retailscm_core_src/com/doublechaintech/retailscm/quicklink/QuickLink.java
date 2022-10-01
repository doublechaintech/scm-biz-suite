package com.doublechaintech.retailscm.quicklink;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.userapp.UserApp;

@JsonSerialize(using = QuickLinkSerializer.class)
public class QuickLink extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(QuickLink target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String ICON_PROPERTY = "icon";
  public static final String IMAGE_PATH_PROPERTY = "imagePath";
  public static final String LINK_TARGET_PROPERTY = "linkTarget";
  public static final String CREATE_TIME_PROPERTY = "createTime";
  public static final String APP_PROPERTY = "app";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "QuickLink";

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
        MemberMetaInfo.defineBy(ICON_PROPERTY, "icon", "图标").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(IMAGE_PATH_PROPERTY, "image_path", "图片路径")
            .withType("string_image", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LINK_TARGET_PROPERTY, "link_target", "链接的目标")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CREATE_TIME_PROPERTY, "create_time", "创建于")
            .withType("date_time_create", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(APP_PROPERTY, "user_app", "应用程序")
            .withType("user_app", UserApp.class));
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
      ICON_PROPERTY,
      IMAGE_PATH_PROPERTY,
      LINK_TARGET_PROPERTY,
      CREATE_TIME_PROPERTY,
      APP_PROPERTY,
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
    parents.put(APP_PROPERTY, UserApp.class);

    return parents;
  }
  /*
  public QuickLink want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public QuickLink wants(Class<? extends BaseEntity>... classes) {
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
  protected String icon;
  protected String imagePath;
  protected String linkTarget;
  protected DateTime createTime;
  protected UserApp app;
  protected int version;

  public QuickLink() {
    // lazy load for all the properties
  }

  public static QuickLink withId(String id) {
    QuickLink quickLink = new QuickLink();
    quickLink.setId(id);
    quickLink.setVersion(Integer.MAX_VALUE);
    quickLink.setChecked(true);
    return quickLink;
  }

  public static QuickLink refById(String id) {
    return withId(id);
  }

  public QuickLink limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public QuickLink limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static QuickLink searchExample() {
    QuickLink quickLink = new QuickLink();
    quickLink.setVersion(UNSET_INT);

    return quickLink;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setApp( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (ICON_PROPERTY.equals(property)) {
      changeIconProperty(newValueExpr);
    }
    if (IMAGE_PATH_PROPERTY.equals(property)) {
      changeImagePathProperty(newValueExpr);
    }
    if (LINK_TARGET_PROPERTY.equals(property)) {
      changeLinkTargetProperty(newValueExpr);
    }
    if (CREATE_TIME_PROPERTY.equals(property)) {
      changeCreateTimeProperty(newValueExpr);
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

  protected void changeIconProperty(String newValueExpr) {

    String oldValue = getIcon();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateIcon(newValue);
    this.onChangeProperty(ICON_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeImagePathProperty(String newValueExpr) {

    String oldValue = getImagePath();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateImagePath(newValue);
    this.onChangeProperty(IMAGE_PATH_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLinkTargetProperty(String newValueExpr) {

    String oldValue = getLinkTarget();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLinkTarget(newValue);
    this.onChangeProperty(LINK_TARGET_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeCreateTimeProperty(String newValueExpr) {

    DateTime oldValue = getCreateTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateCreateTime(newValue);
    this.onChangeProperty(CREATE_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (ICON_PROPERTY.equals(property)) {
      return getIcon();
    }
    if (IMAGE_PATH_PROPERTY.equals(property)) {
      return getImagePath();
    }
    if (LINK_TARGET_PROPERTY.equals(property)) {
      return getLinkTarget();
    }
    if (CREATE_TIME_PROPERTY.equals(property)) {
      return getCreateTime();
    }
    if (APP_PROPERTY.equals(property)) {
      return getApp();
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

  public QuickLink updateId(String id) {
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

  public QuickLink orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public QuickLink ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public QuickLink addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public QuickLink updateName(String name) {
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

  public QuickLink orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public QuickLink ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public QuickLink addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setIcon(String icon) {
    String oldIcon = this.icon;
    String newIcon = trimString(icon);
    this.icon = newIcon;
  }

  public String icon() {
    doLoad();
    return getIcon();
  }

  public String getIcon() {
    return this.icon;
  }

  public QuickLink updateIcon(String icon) {
    String oldIcon = this.icon;
    String newIcon = trimString(icon);
    if (!shouldReplaceBy(newIcon, oldIcon)) {
      return this;
    }
    this.icon = newIcon;
    if (cn.hutool.core.util.ObjectUtil.equals(newIcon, oldIcon)) {
      return this;
    }
    addPropertyChange(ICON_PROPERTY, oldIcon, newIcon);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public QuickLink orderByIcon(boolean asc) {
    doAddOrderBy(ICON_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIconCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ICON_PROPERTY, operator, parameters);
  }

  public QuickLink ignoreIconCriteria() {
    super.ignoreSearchProperty(ICON_PROPERTY);
    return this;
  }

  public QuickLink addIconCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIconCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeIcon(String icon) {
    if (icon != null) {
      updateIcon(icon);
    }
  }

  public void setImagePath(String imagePath) {
    String oldImagePath = this.imagePath;
    String newImagePath = trimString(encodeUrl(imagePath));
    ;
    this.imagePath = newImagePath;
  }

  public String imagePath() {
    doLoad();
    return getImagePath();
  }

  public String getImagePath() {
    return this.imagePath;
  }

  public QuickLink updateImagePath(String imagePath) {
    String oldImagePath = this.imagePath;
    String newImagePath = trimString(encodeUrl(imagePath));
    ;
    if (!shouldReplaceBy(newImagePath, oldImagePath)) {
      return this;
    }
    this.imagePath = newImagePath;
    if (cn.hutool.core.util.ObjectUtil.equals(newImagePath, oldImagePath)) {
      return this;
    }
    addPropertyChange(IMAGE_PATH_PROPERTY, oldImagePath, newImagePath);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public QuickLink orderByImagePath(boolean asc) {
    doAddOrderBy(IMAGE_PATH_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createImagePathCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(IMAGE_PATH_PROPERTY, operator, parameters);
  }

  public QuickLink ignoreImagePathCriteria() {
    super.ignoreSearchProperty(IMAGE_PATH_PROPERTY);
    return this;
  }

  public QuickLink addImagePathCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createImagePathCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeImagePath(String imagePath) {
    if (imagePath != null) {
      updateImagePath(imagePath);
    }
  }

  public void setLinkTarget(String linkTarget) {
    String oldLinkTarget = this.linkTarget;
    String newLinkTarget = trimString(linkTarget);
    this.linkTarget = newLinkTarget;
  }

  public String linkTarget() {
    doLoad();
    return getLinkTarget();
  }

  public String getLinkTarget() {
    return this.linkTarget;
  }

  public QuickLink updateLinkTarget(String linkTarget) {
    String oldLinkTarget = this.linkTarget;
    String newLinkTarget = trimString(linkTarget);
    if (!shouldReplaceBy(newLinkTarget, oldLinkTarget)) {
      return this;
    }
    this.linkTarget = newLinkTarget;
    if (cn.hutool.core.util.ObjectUtil.equals(newLinkTarget, oldLinkTarget)) {
      return this;
    }
    addPropertyChange(LINK_TARGET_PROPERTY, oldLinkTarget, newLinkTarget);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public QuickLink orderByLinkTarget(boolean asc) {
    doAddOrderBy(LINK_TARGET_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLinkTargetCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LINK_TARGET_PROPERTY, operator, parameters);
  }

  public QuickLink ignoreLinkTargetCriteria() {
    super.ignoreSearchProperty(LINK_TARGET_PROPERTY);
    return this;
  }

  public QuickLink addLinkTargetCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLinkTargetCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLinkTarget(String linkTarget) {
    if (linkTarget != null) {
      updateLinkTarget(linkTarget);
    }
  }

  public void setCreateTime(DateTime createTime) {
    DateTime oldCreateTime = this.createTime;
    DateTime newCreateTime = createTime;
    this.createTime = newCreateTime;
  }

  public DateTime createTime() {
    doLoad();
    return getCreateTime();
  }

  public DateTime getCreateTime() {
    return this.createTime;
  }

  public QuickLink updateCreateTime(DateTime createTime) {
    DateTime oldCreateTime = this.createTime;
    DateTime newCreateTime = createTime;
    if (!shouldReplaceBy(newCreateTime, oldCreateTime)) {
      return this;
    }
    this.createTime = newCreateTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newCreateTime, oldCreateTime)) {
      return this;
    }
    addPropertyChange(CREATE_TIME_PROPERTY, oldCreateTime, newCreateTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public QuickLink orderByCreateTime(boolean asc) {
    doAddOrderBy(CREATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCreateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CREATE_TIME_PROPERTY, operator, parameters);
  }

  public QuickLink ignoreCreateTimeCriteria() {
    super.ignoreSearchProperty(CREATE_TIME_PROPERTY);
    return this;
  }

  public QuickLink addCreateTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCreateTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCreateTime(DateTime createTime) {
    updateCreateTime(createTime);
  }

  public void setApp(UserApp app) {
    UserApp oldApp = this.app;
    UserApp newApp = app;
    this.app = newApp;
  }

  public UserApp app() {
    doLoad();
    return getApp();
  }

  public UserApp getApp() {
    return this.app;
  }

  public QuickLink updateApp(UserApp app) {
    UserApp oldApp = this.app;
    UserApp newApp = app;
    if (!shouldReplaceBy(newApp, oldApp)) {
      return this;
    }
    this.app = newApp;
    if (cn.hutool.core.util.ObjectUtil.equals(newApp, oldApp)) {
      return this;
    }
    addPropertyChange(APP_PROPERTY, oldApp, newApp);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public QuickLink orderByApp(boolean asc) {
    doAddOrderBy(APP_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAppCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(APP_PROPERTY, operator, parameters);
  }

  public QuickLink ignoreAppCriteria() {
    super.ignoreSearchProperty(APP_PROPERTY);
    return this;
  }

  public QuickLink addAppCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAppCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeApp(UserApp app) {
    if (app != null) {
      updateApp(app);
    }
  }

  public QuickLink updateAppByReferenceId(String appId) {
    updateApp(UserApp.refById(appId));
    return this;
  }

  public void clearApp() {
    setApp(null);
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

  public QuickLink updateVersion(int version) {
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

  public QuickLink orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public QuickLink ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public QuickLink addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getApp(), internalType);
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
    appendKeyValuePair(result, ICON_PROPERTY, getIcon());
    appendKeyValuePair(result, IMAGE_PATH_PROPERTY, getImagePath());
    appendKeyValuePair(result, LINK_TARGET_PROPERTY, getLinkTarget());
    appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
    appendKeyValuePair(result, APP_PROPERTY, getApp());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof QuickLink) {

      QuickLink dest = (QuickLink) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setIcon(getIcon());
      dest.setImagePath(getImagePath());
      dest.setLinkTarget(getLinkTarget());
      dest.setCreateTime(getCreateTime());
      dest.setApp(getApp());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof QuickLink) {

      QuickLink source = (QuickLink) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeIcon(source.getIcon());
      mergeImagePath(source.getImagePath());
      mergeLinkTarget(source.getLinkTarget());
      mergeCreateTime(source.getCreateTime());
      mergeApp(source.getApp());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof QuickLink) {

      QuickLink source = (QuickLink) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeIcon(source.getIcon());
      mergeImagePath(source.getImagePath());
      mergeLinkTarget(source.getLinkTarget());
      mergeCreateTime(source.getCreateTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getName(),
      getIcon(),
      getImagePath(),
      getLinkTarget(),
      getCreateTime(),
      getApp(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    QuickLink checkQuickLink = Q.quickLinkWithIdField().filterById(id).execute(ctx);

    return checkQuickLink != null
        && !checkQuickLink.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public QuickLink save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("QuickLink{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\ticon='" + getIcon() + "';");
    stringBuilder.append("\timagePath='" + getImagePath() + "';");
    stringBuilder.append("\tlinkTarget='" + getLinkTarget() + "';");
    stringBuilder.append("\tcreateTime='" + getCreateTime() + "';");
    if (getApp() != null) {
      stringBuilder.append("\tapp='UserApp(" + getApp().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
