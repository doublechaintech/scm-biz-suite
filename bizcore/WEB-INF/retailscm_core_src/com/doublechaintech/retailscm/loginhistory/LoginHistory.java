package com.doublechaintech.retailscm.loginhistory;

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

@JsonSerialize(using = LoginHistorySerializer.class)
public class LoginHistory extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(LoginHistory target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String LOGIN_TIME_PROPERTY = "loginTime";
  public static final String FROM_IP_PROPERTY = "fromIp";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String SEC_USER_PROPERTY = "secUser";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "LoginHistory";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LOGIN_TIME_PROPERTY, "login_time", "登录时间")
            .withType("date_time_create", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FROM_IP_PROPERTY, "from_ip", "从IP")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SEC_USER_PROPERTY, "sec_user", "安全用户")
            .withType("sec_user", SecUser.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      LOGIN_TIME_PROPERTY,
      FROM_IP_PROPERTY,
      DESCRIPTION_PROPERTY,
      SEC_USER_PROPERTY,
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
  public LoginHistory want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public LoginHistory wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getFromIp();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected DateTime loginTime;
  protected String fromIp;
  protected String description;
  protected SecUser secUser;
  protected int version;

  public LoginHistory() {
    // lazy load for all the properties
  }

  public static LoginHistory withId(String id) {
    LoginHistory loginHistory = new LoginHistory();
    loginHistory.setId(id);
    loginHistory.setVersion(Integer.MAX_VALUE);
    loginHistory.setChecked(true);
    return loginHistory;
  }

  public static LoginHistory refById(String id) {
    return withId(id);
  }

  public LoginHistory limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public LoginHistory limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static LoginHistory searchExample() {
    LoginHistory loginHistory = new LoginHistory();
    loginHistory.setVersion(UNSET_INT);

    return loginHistory;
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

    if (LOGIN_TIME_PROPERTY.equals(property)) {
      changeLoginTimeProperty(newValueExpr);
    }
    if (FROM_IP_PROPERTY.equals(property)) {
      changeFromIpProperty(newValueExpr);
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      changeDescriptionProperty(newValueExpr);
    }
  }

  protected void changeLoginTimeProperty(String newValueExpr) {

    DateTime oldValue = getLoginTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLoginTime(newValue);
    this.onChangeProperty(LOGIN_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeFromIpProperty(String newValueExpr) {

    String oldValue = getFromIp();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateFromIp(newValue);
    this.onChangeProperty(FROM_IP_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDescriptionProperty(String newValueExpr) {

    String oldValue = getDescription();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDescription(newValue);
    this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (LOGIN_TIME_PROPERTY.equals(property)) {
      return getLoginTime();
    }
    if (FROM_IP_PROPERTY.equals(property)) {
      return getFromIp();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (SEC_USER_PROPERTY.equals(property)) {
      return getSecUser();
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

  public LoginHistory updateId(String id) {
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

  public LoginHistory orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public LoginHistory ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public LoginHistory addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setLoginTime(DateTime loginTime) {
    DateTime oldLoginTime = this.loginTime;
    DateTime newLoginTime = loginTime;
    this.loginTime = newLoginTime;
  }

  public DateTime loginTime() {
    doLoad();
    return getLoginTime();
  }

  public DateTime getLoginTime() {
    return this.loginTime;
  }

  public LoginHistory updateLoginTime(DateTime loginTime) {
    DateTime oldLoginTime = this.loginTime;
    DateTime newLoginTime = loginTime;
    if (!shouldReplaceBy(newLoginTime, oldLoginTime)) {
      return this;
    }
    this.loginTime = newLoginTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newLoginTime, oldLoginTime)) {
      return this;
    }
    addPropertyChange(LOGIN_TIME_PROPERTY, oldLoginTime, newLoginTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public LoginHistory orderByLoginTime(boolean asc) {
    doAddOrderBy(LOGIN_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLoginTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LOGIN_TIME_PROPERTY, operator, parameters);
  }

  public LoginHistory ignoreLoginTimeCriteria() {
    super.ignoreSearchProperty(LOGIN_TIME_PROPERTY);
    return this;
  }

  public LoginHistory addLoginTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLoginTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLoginTime(DateTime loginTime) {
    updateLoginTime(loginTime);
  }

  public void setFromIp(String fromIp) {
    String oldFromIp = this.fromIp;
    String newFromIp = trimString(fromIp);
    this.fromIp = newFromIp;
  }

  public String fromIp() {
    doLoad();
    return getFromIp();
  }

  public String getFromIp() {
    return this.fromIp;
  }

  public LoginHistory updateFromIp(String fromIp) {
    String oldFromIp = this.fromIp;
    String newFromIp = trimString(fromIp);
    if (!shouldReplaceBy(newFromIp, oldFromIp)) {
      return this;
    }
    this.fromIp = newFromIp;
    if (cn.hutool.core.util.ObjectUtil.equals(newFromIp, oldFromIp)) {
      return this;
    }
    addPropertyChange(FROM_IP_PROPERTY, oldFromIp, newFromIp);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public LoginHistory orderByFromIp(boolean asc) {
    doAddOrderBy(FROM_IP_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFromIpCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FROM_IP_PROPERTY, operator, parameters);
  }

  public LoginHistory ignoreFromIpCriteria() {
    super.ignoreSearchProperty(FROM_IP_PROPERTY);
    return this;
  }

  public LoginHistory addFromIpCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFromIpCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFromIp(String fromIp) {
    if (fromIp != null) {
      updateFromIp(fromIp);
    }
  }

  public void setDescription(String description) {
    String oldDescription = this.description;
    String newDescription = trimString(description);
    this.description = newDescription;
  }

  public String description() {
    doLoad();
    return getDescription();
  }

  public String getDescription() {
    return this.description;
  }

  public LoginHistory updateDescription(String description) {
    String oldDescription = this.description;
    String newDescription = trimString(description);
    if (!shouldReplaceBy(newDescription, oldDescription)) {
      return this;
    }
    this.description = newDescription;
    if (cn.hutool.core.util.ObjectUtil.equals(newDescription, oldDescription)) {
      return this;
    }
    addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public LoginHistory orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public LoginHistory ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public LoginHistory addDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDescription(String description) {
    if (description != null) {
      updateDescription(description);
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

  public LoginHistory updateSecUser(SecUser secUser) {
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

  public LoginHistory orderBySecUser(boolean asc) {
    doAddOrderBy(SEC_USER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSecUserCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SEC_USER_PROPERTY, operator, parameters);
  }

  public LoginHistory ignoreSecUserCriteria() {
    super.ignoreSearchProperty(SEC_USER_PROPERTY);
    return this;
  }

  public LoginHistory addSecUserCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSecUserCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSecUser(SecUser secUser) {
    if (secUser != null) {
      updateSecUser(secUser);
    }
  }

  public LoginHistory updateSecUserByReferenceId(String secUserId) {
    updateSecUser(SecUser.refById(secUserId));
    return this;
  }

  public void clearSecUser() {
    setSecUser(null);
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

  public LoginHistory updateVersion(int version) {
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

  public LoginHistory orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public LoginHistory ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public LoginHistory addVersionCriteria(QueryOperator operator, Object... parameters) {
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
    appendKeyValuePair(result, LOGIN_TIME_PROPERTY, getLoginTime());
    appendKeyValuePair(result, FROM_IP_PROPERTY, getFromIp());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, SEC_USER_PROPERTY, getSecUser());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof LoginHistory) {

      LoginHistory dest = (LoginHistory) baseDest;

      dest.setId(getId());
      dest.setLoginTime(getLoginTime());
      dest.setFromIp(getFromIp());
      dest.setDescription(getDescription());
      dest.setSecUser(getSecUser());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof LoginHistory) {

      LoginHistory source = (LoginHistory) sourceEntity;

      mergeId(source.getId());
      mergeLoginTime(source.getLoginTime());
      mergeFromIp(source.getFromIp());
      mergeDescription(source.getDescription());
      mergeSecUser(source.getSecUser());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof LoginHistory) {

      LoginHistory source = (LoginHistory) sourceEntity;

      mergeId(source.getId());
      mergeLoginTime(source.getLoginTime());
      mergeFromIp(source.getFromIp());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getLoginTime(), getFromIp(), getDescription(), getSecUser(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    LoginHistory checkLoginHistory = Q.loginHistoryWithIdField().filterById(id).execute(ctx);

    return checkLoginHistory != null
        && !checkLoginHistory.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public LoginHistory save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("LoginHistory{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tloginTime='" + getLoginTime() + "';");
    stringBuilder.append("\tfromIp='" + getFromIp() + "';");
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    if (getSecUser() != null) {
      stringBuilder.append("\tsecUser='SecUser(" + getSecUser().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
