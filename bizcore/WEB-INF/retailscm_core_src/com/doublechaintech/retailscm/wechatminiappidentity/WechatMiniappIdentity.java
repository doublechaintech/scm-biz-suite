package com.doublechaintech.retailscm.wechatminiappidentity;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.secuser.SecUser;

@JsonSerialize(using = WechatMiniappIdentitySerializer.class)
public class WechatMiniappIdentity extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(WechatMiniappIdentity target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String OPEN_ID_PROPERTY = "openId";
  public static final String APP_ID_PROPERTY = "appId";
  public static final String UNION_ID_PROPERTY = "unionId";
  public static final String SEC_USER_PROPERTY = "secUser";
  public static final String CREATE_TIME_PROPERTY = "createTime";
  public static final String LAST_LOGIN_TIME_PROPERTY = "lastLoginTime";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "WechatMiniappIdentity";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(OPEN_ID_PROPERTY, "open_id", "开放Id")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(APP_ID_PROPERTY, "app_id", "应用程序Id")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(UNION_ID_PROPERTY, "union_id", "联盟Id")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SEC_USER_PROPERTY, "sec_user", "安全用户")
            .withType("sec_user", SecUser.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CREATE_TIME_PROPERTY, "create_time", "创建于")
            .withType("date_time_create", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_LOGIN_TIME_PROPERTY, "last_login_time", "最后登录时间")
            .withType("date_time", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      OPEN_ID_PROPERTY,
      APP_ID_PROPERTY,
      UNION_ID_PROPERTY,
      SEC_USER_PROPERTY,
      CREATE_TIME_PROPERTY,
      LAST_LOGIN_TIME_PROPERTY,
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
    parents.put(SEC_USER_PROPERTY, SecUser.class);

    return parents;
  }
  /*
  public WechatMiniappIdentity want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public WechatMiniappIdentity wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getOpenId();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String openId;
  protected String appId;
  protected String unionId;
  protected SecUser secUser;
  protected DateTime createTime;
  protected DateTime lastLoginTime;
  protected int version;

  public WechatMiniappIdentity() {
    // lazy load for all the properties
  }

  public static WechatMiniappIdentity withId(String id) {
    WechatMiniappIdentity wechatMiniappIdentity = new WechatMiniappIdentity();
    wechatMiniappIdentity.setId(id);
    wechatMiniappIdentity.setVersion(Integer.MAX_VALUE);
    wechatMiniappIdentity.setChecked(true);
    return wechatMiniappIdentity;
  }

  public static WechatMiniappIdentity refById(String id) {
    return withId(id);
  }

  public WechatMiniappIdentity limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public WechatMiniappIdentity limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static WechatMiniappIdentity searchExample() {
    WechatMiniappIdentity wechatMiniappIdentity = new WechatMiniappIdentity();
    wechatMiniappIdentity.setVersion(UNSET_INT);

    return wechatMiniappIdentity;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setSecUser( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (OPEN_ID_PROPERTY.equals(property)) {
      changeOpenIdProperty(newValueExpr);
    }
    if (APP_ID_PROPERTY.equals(property)) {
      changeAppIdProperty(newValueExpr);
    }
    if (UNION_ID_PROPERTY.equals(property)) {
      changeUnionIdProperty(newValueExpr);
    }
    if (CREATE_TIME_PROPERTY.equals(property)) {
      changeCreateTimeProperty(newValueExpr);
    }
    if (LAST_LOGIN_TIME_PROPERTY.equals(property)) {
      changeLastLoginTimeProperty(newValueExpr);
    }
  }

  protected void changeOpenIdProperty(String newValueExpr) {

    String oldValue = getOpenId();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateOpenId(newValue);
    this.onChangeProperty(OPEN_ID_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAppIdProperty(String newValueExpr) {

    String oldValue = getAppId();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAppId(newValue);
    this.onChangeProperty(APP_ID_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeUnionIdProperty(String newValueExpr) {

    String oldValue = getUnionId();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateUnionId(newValue);
    this.onChangeProperty(UNION_ID_PROPERTY, oldValue, newValue);
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

  protected void changeLastLoginTimeProperty(String newValueExpr) {

    DateTime oldValue = getLastLoginTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLastLoginTime(newValue);
    this.onChangeProperty(LAST_LOGIN_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (OPEN_ID_PROPERTY.equals(property)) {
      return getOpenId();
    }
    if (APP_ID_PROPERTY.equals(property)) {
      return getAppId();
    }
    if (UNION_ID_PROPERTY.equals(property)) {
      return getUnionId();
    }
    if (SEC_USER_PROPERTY.equals(property)) {
      return getSecUser();
    }
    if (CREATE_TIME_PROPERTY.equals(property)) {
      return getCreateTime();
    }
    if (LAST_LOGIN_TIME_PROPERTY.equals(property)) {
      return getLastLoginTime();
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

  public WechatMiniappIdentity updateId(String id) {
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

  public WechatMiniappIdentity orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public WechatMiniappIdentity ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public WechatMiniappIdentity addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setOpenId(String openId) {
    String oldOpenId = this.openId;
    String newOpenId = trimString(openId);
    this.openId = newOpenId;
  }

  public String openId() {
    doLoad();
    return getOpenId();
  }

  public String getOpenId() {
    return this.openId;
  }

  public WechatMiniappIdentity updateOpenId(String openId) {
    String oldOpenId = this.openId;
    String newOpenId = trimString(openId);
    if (!shouldReplaceBy(newOpenId, oldOpenId)) {
      return this;
    }
    this.openId = newOpenId;
    if (cn.hutool.core.util.ObjectUtil.equals(newOpenId, oldOpenId)) {
      return this;
    }
    addPropertyChange(OPEN_ID_PROPERTY, oldOpenId, newOpenId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public WechatMiniappIdentity orderByOpenId(boolean asc) {
    doAddOrderBy(OPEN_ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOpenIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OPEN_ID_PROPERTY, operator, parameters);
  }

  public WechatMiniappIdentity ignoreOpenIdCriteria() {
    super.ignoreSearchProperty(OPEN_ID_PROPERTY);
    return this;
  }

  public WechatMiniappIdentity addOpenIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOpenIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOpenId(String openId) {
    if (openId != null) {
      updateOpenId(openId);
    }
  }

  public void setAppId(String appId) {
    String oldAppId = this.appId;
    String newAppId = trimString(appId);
    this.appId = newAppId;
  }

  public String appId() {
    doLoad();
    return getAppId();
  }

  public String getAppId() {
    return this.appId;
  }

  public WechatMiniappIdentity updateAppId(String appId) {
    String oldAppId = this.appId;
    String newAppId = trimString(appId);
    if (!shouldReplaceBy(newAppId, oldAppId)) {
      return this;
    }
    this.appId = newAppId;
    if (cn.hutool.core.util.ObjectUtil.equals(newAppId, oldAppId)) {
      return this;
    }
    addPropertyChange(APP_ID_PROPERTY, oldAppId, newAppId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public WechatMiniappIdentity orderByAppId(boolean asc) {
    doAddOrderBy(APP_ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAppIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(APP_ID_PROPERTY, operator, parameters);
  }

  public WechatMiniappIdentity ignoreAppIdCriteria() {
    super.ignoreSearchProperty(APP_ID_PROPERTY);
    return this;
  }

  public WechatMiniappIdentity addAppIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAppIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAppId(String appId) {
    if (appId != null) {
      updateAppId(appId);
    }
  }

  public void setUnionId(String unionId) {
    String oldUnionId = this.unionId;
    String newUnionId = trimString(unionId);
    this.unionId = newUnionId;
  }

  public String unionId() {
    doLoad();
    return getUnionId();
  }

  public String getUnionId() {
    return this.unionId;
  }

  public WechatMiniappIdentity updateUnionId(String unionId) {
    String oldUnionId = this.unionId;
    String newUnionId = trimString(unionId);
    if (!shouldReplaceBy(newUnionId, oldUnionId)) {
      return this;
    }
    this.unionId = newUnionId;
    if (cn.hutool.core.util.ObjectUtil.equals(newUnionId, oldUnionId)) {
      return this;
    }
    addPropertyChange(UNION_ID_PROPERTY, oldUnionId, newUnionId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public WechatMiniappIdentity orderByUnionId(boolean asc) {
    doAddOrderBy(UNION_ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createUnionIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(UNION_ID_PROPERTY, operator, parameters);
  }

  public WechatMiniappIdentity ignoreUnionIdCriteria() {
    super.ignoreSearchProperty(UNION_ID_PROPERTY);
    return this;
  }

  public WechatMiniappIdentity addUnionIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createUnionIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeUnionId(String unionId) {
    if (unionId != null) {
      updateUnionId(unionId);
    }
  }

  public void setSecUser(SecUser secUser) {
    SecUser oldSecUser = this.secUser;
    SecUser newSecUser = secUser;
    this.secUser = newSecUser;
  }

  public SecUser secUser() {
    doLoad();
    return getSecUser();
  }

  public SecUser getSecUser() {
    return this.secUser;
  }

  public WechatMiniappIdentity updateSecUser(SecUser secUser) {
    SecUser oldSecUser = this.secUser;
    SecUser newSecUser = secUser;
    if (!shouldReplaceBy(newSecUser, oldSecUser)) {
      return this;
    }
    this.secUser = newSecUser;
    if (cn.hutool.core.util.ObjectUtil.equals(newSecUser, oldSecUser)) {
      return this;
    }
    addPropertyChange(SEC_USER_PROPERTY, oldSecUser, newSecUser);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public WechatMiniappIdentity orderBySecUser(boolean asc) {
    doAddOrderBy(SEC_USER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSecUserCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SEC_USER_PROPERTY, operator, parameters);
  }

  public WechatMiniappIdentity ignoreSecUserCriteria() {
    super.ignoreSearchProperty(SEC_USER_PROPERTY);
    return this;
  }

  public WechatMiniappIdentity addSecUserCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSecUserCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSecUser(SecUser secUser) {
    if (secUser != null) {
      updateSecUser(secUser);
    }
  }

  public WechatMiniappIdentity updateSecUserByReferenceId(String secUserId) {
    updateSecUser(SecUser.refById(secUserId));
    return this;
  }

  public void clearSecUser() {
    setSecUser(null);
    this.changed = true;
    setChecked(false);
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

  public WechatMiniappIdentity updateCreateTime(DateTime createTime) {
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

  public WechatMiniappIdentity orderByCreateTime(boolean asc) {
    doAddOrderBy(CREATE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCreateTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CREATE_TIME_PROPERTY, operator, parameters);
  }

  public WechatMiniappIdentity ignoreCreateTimeCriteria() {
    super.ignoreSearchProperty(CREATE_TIME_PROPERTY);
    return this;
  }

  public WechatMiniappIdentity addCreateTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCreateTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCreateTime(DateTime createTime) {
    updateCreateTime(createTime);
  }

  public void setLastLoginTime(DateTime lastLoginTime) {
    DateTime oldLastLoginTime = this.lastLoginTime;
    DateTime newLastLoginTime = lastLoginTime;
    this.lastLoginTime = newLastLoginTime;
  }

  public DateTime lastLoginTime() {
    doLoad();
    return getLastLoginTime();
  }

  public DateTime getLastLoginTime() {
    return this.lastLoginTime;
  }

  public WechatMiniappIdentity updateLastLoginTime(DateTime lastLoginTime) {
    DateTime oldLastLoginTime = this.lastLoginTime;
    DateTime newLastLoginTime = lastLoginTime;
    if (!shouldReplaceBy(newLastLoginTime, oldLastLoginTime)) {
      return this;
    }
    this.lastLoginTime = newLastLoginTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newLastLoginTime, oldLastLoginTime)) {
      return this;
    }
    addPropertyChange(LAST_LOGIN_TIME_PROPERTY, oldLastLoginTime, newLastLoginTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public WechatMiniappIdentity orderByLastLoginTime(boolean asc) {
    doAddOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastLoginTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_LOGIN_TIME_PROPERTY, operator, parameters);
  }

  public WechatMiniappIdentity ignoreLastLoginTimeCriteria() {
    super.ignoreSearchProperty(LAST_LOGIN_TIME_PROPERTY);
    return this;
  }

  public WechatMiniappIdentity addLastLoginTimeCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLastLoginTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLastLoginTime(DateTime lastLoginTime) {
    updateLastLoginTime(lastLoginTime);
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

  public WechatMiniappIdentity updateVersion(int version) {
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

  public WechatMiniappIdentity orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public WechatMiniappIdentity ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public WechatMiniappIdentity addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getSecUser(), internalType);
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
    appendKeyValuePair(result, OPEN_ID_PROPERTY, getOpenId());
    appendKeyValuePair(result, APP_ID_PROPERTY, getAppId());
    appendKeyValuePair(result, UNION_ID_PROPERTY, getUnionId());
    appendKeyValuePair(result, SEC_USER_PROPERTY, getSecUser());
    appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
    appendKeyValuePair(result, LAST_LOGIN_TIME_PROPERTY, getLastLoginTime());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof WechatMiniappIdentity) {

      WechatMiniappIdentity dest = (WechatMiniappIdentity) baseDest;

      dest.setId(getId());
      dest.setOpenId(getOpenId());
      dest.setAppId(getAppId());
      dest.setUnionId(getUnionId());
      dest.setSecUser(getSecUser());
      dest.setCreateTime(getCreateTime());
      dest.setLastLoginTime(getLastLoginTime());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof WechatMiniappIdentity) {

      WechatMiniappIdentity source = (WechatMiniappIdentity) sourceEntity;

      mergeId(source.getId());
      mergeOpenId(source.getOpenId());
      mergeAppId(source.getAppId());
      mergeUnionId(source.getUnionId());
      mergeSecUser(source.getSecUser());
      mergeCreateTime(source.getCreateTime());
      mergeLastLoginTime(source.getLastLoginTime());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof WechatMiniappIdentity) {

      WechatMiniappIdentity source = (WechatMiniappIdentity) sourceEntity;

      mergeId(source.getId());
      mergeOpenId(source.getOpenId());
      mergeAppId(source.getAppId());
      mergeUnionId(source.getUnionId());
      mergeCreateTime(source.getCreateTime());
      mergeLastLoginTime(source.getLastLoginTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getOpenId(),
      getAppId(),
      getUnionId(),
      getSecUser(),
      getCreateTime(),
      getLastLoginTime(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    WechatMiniappIdentity checkWechatMiniappIdentity =
        Q.wechatMiniappIdentityWithIdField().filterById(id).execute(ctx);

    return checkWechatMiniappIdentity != null
        && !checkWechatMiniappIdentity.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public WechatMiniappIdentity save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("WechatMiniappIdentity{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\topenId='" + getOpenId() + "';");
    stringBuilder.append("\tappId='" + getAppId() + "';");
    stringBuilder.append("\tunionId='" + getUnionId() + "';");
    if (getSecUser() != null) {
      stringBuilder.append("\tsecUser='SecUser(" + getSecUser().getId() + ")';");
    }
    stringBuilder.append("\tcreateTime='" + getCreateTime() + "';");
    stringBuilder.append("\tlastLoginTime='" + getLastLoginTime() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
