package com.doublechaintech.retailscm.userdomain;

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
import com.doublechaintech.retailscm.userallowlist.UserAllowList;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

@JsonSerialize(using = UserDomainSerializer.class)
public class UserDomain extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(UserDomain target) {
    if (target == null) {
      return;
    }
    target.addUserAllowListList(this.getUserAllowListList());
    target.addSecUserList(this.getSecUserList());
    target.addPublicKeyTypeList(this.getPublicKeyTypeList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String VERSION_PROPERTY = "version";

  public static final String USER_ALLOW_LIST_LIST = "userAllowListList";
  public static final String SEC_USER_LIST = "secUserList";
  public static final String PUBLIC_KEY_TYPE_LIST = "publicKeyTypeList";

  public static final String INTERNAL_TYPE = "UserDomain";

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
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(USER_ALLOW_LIST_LIST, "domain", "用户允许列表")
            .withType("user_allow_list", UserAllowList.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(SEC_USER_LIST, "domain", "安全用户列表")
            .withType("sec_user", SecUser.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(PUBLIC_KEY_TYPE_LIST, "domain", "公钥类型列表")
            .withType("public_key_type", PublicKeyType.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {ID_PROPERTY, NAME_PROPERTY, VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(USER_ALLOW_LIST_LIST, "domain");

    refers.put(SEC_USER_LIST, "domain");

    refers.put(PUBLIC_KEY_TYPE_LIST, "domain");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(USER_ALLOW_LIST_LIST, UserAllowList.class);

    refers.put(SEC_USER_LIST, SecUser.class);

    refers.put(PUBLIC_KEY_TYPE_LIST, PublicKeyType.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();

    return parents;
  }
  /*
  public UserDomain want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public UserDomain wants(Class<? extends BaseEntity>... classes) {
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
  protected int version;

  protected SmartList<UserAllowList> mUserAllowListList;
  protected SmartList<SecUser> mSecUserList;
  protected SmartList<PublicKeyType> mPublicKeyTypeList;

  public UserDomain() {
    // lazy load for all the properties
  }

  public static UserDomain withId(String id) {
    UserDomain userDomain = new UserDomain();
    userDomain.setId(id);
    userDomain.setVersion(Integer.MAX_VALUE);
    userDomain.setChecked(true);
    return userDomain;
  }

  public static UserDomain refById(String id) {
    return withId(id);
  }

  public UserDomain limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public UserDomain limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static UserDomain searchExample() {
    UserDomain userDomain = new UserDomain();
    userDomain.setVersion(UNSET_INT);

    return userDomain;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){

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

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (USER_ALLOW_LIST_LIST.equals(property)) {
      List<BaseEntity> list =
          getUserAllowListList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (SEC_USER_LIST.equals(property)) {
      List<BaseEntity> list =
          getSecUserList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (PUBLIC_KEY_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getPublicKeyTypeList().stream().map(item -> item).collect(Collectors.toList());
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

  public UserDomain updateId(String id) {
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

  public UserDomain orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public UserDomain ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public UserDomain addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public UserDomain updateName(String name) {
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

  public UserDomain orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public UserDomain ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public UserDomain addNameCriteria(QueryOperator operator, Object... parameters) {
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

  public UserDomain updateVersion(int version) {
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

  public UserDomain orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public UserDomain ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public UserDomain addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<UserAllowList> getUserAllowListList() {
    if (this.mUserAllowListList == null) {
      this.mUserAllowListList = new SmartList<UserAllowList>();
      this.mUserAllowListList.setListInternalName(USER_ALLOW_LIST_LIST);
      // 有名字，便于做权限控制
    }

    return this.mUserAllowListList;
  }

  public SmartList<UserAllowList> userAllowListList() {

    doLoadChild(USER_ALLOW_LIST_LIST);

    return getUserAllowListList();
  }

  public void setUserAllowListList(SmartList<UserAllowList> userAllowListList) {
    for (UserAllowList userAllowList : userAllowListList) {
      userAllowList.setDomain(this);
    }

    this.mUserAllowListList = userAllowListList;
    this.mUserAllowListList.setListInternalName(USER_ALLOW_LIST_LIST);
  }

  public UserDomain addUserAllowList(UserAllowList userAllowList) {
    userAllowList.updateDomain(this);
    getUserAllowListList().add(userAllowList);
    return this;
  }

  public UserDomain addUserAllowListList(SmartList<UserAllowList> userAllowListList) {
    for (UserAllowList userAllowList : userAllowListList) {
      userAllowList.updateDomain(this);
    }

    Map<String, UserAllowList> mapById = userAllowListList.mapWithId();
    getUserAllowListList().removeIf(item -> mapById.get(item.getId()) != null);
    getUserAllowListList().addAll(userAllowListList);
    return this;
  }

  public void mergeUserAllowListList(SmartList<UserAllowList> userAllowListList) {
    if (userAllowListList == null) {
      return;
    }
    if (userAllowListList.isEmpty()) {
      return;
    }
    addUserAllowListList(userAllowListList);
  }

  public UserAllowList removeUserAllowList(UserAllowList userAllowListIndex) {

    int index = getUserAllowListList().indexOf(userAllowListIndex);
    if (index < 0) {
      String message =
          "UserAllowList("
              + userAllowListIndex.getId()
              + ") with version='"
              + userAllowListIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    UserAllowList userAllowList = getUserAllowListList().get(index);
    // userAllowList.clearDomain(); //disconnect with Domain
    userAllowList.clearFromAll(); // disconnect with Domain

    boolean result = getUserAllowListList().planToRemove(userAllowList);
    if (!result) {
      String message =
          "UserAllowList("
              + userAllowListIndex.getId()
              + ") with version='"
              + userAllowListIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return userAllowList;
  }
  // 断舍离
  public void breakWithUserAllowList(UserAllowList userAllowList) {

    if (userAllowList == null) {
      return;
    }
    userAllowList.setDomain(null);
    // getUserAllowListList().remove();

  }

  public boolean hasUserAllowList(UserAllowList userAllowList) {

    return getUserAllowListList().contains(userAllowList);
  }

  public void copyUserAllowListFrom(UserAllowList userAllowList) {

    UserAllowList userAllowListInList = findTheUserAllowList(userAllowList);
    UserAllowList newUserAllowList = new UserAllowList();
    userAllowListInList.copyTo(newUserAllowList);
    newUserAllowList.setVersion(0); // will trigger copy
    getUserAllowListList().add(newUserAllowList);
    addItemToFlexiableObject(COPIED_CHILD, newUserAllowList);
  }

  public UserAllowList findTheUserAllowList(UserAllowList userAllowList) {

    int index = getUserAllowListList().indexOf(userAllowList);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "UserAllowList("
              + userAllowList.getId()
              + ") with version='"
              + userAllowList.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getUserAllowListList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpUserAllowListList() {
    getUserAllowListList().clear();
  }

  public SmartList<SecUser> getSecUserList() {
    if (this.mSecUserList == null) {
      this.mSecUserList = new SmartList<SecUser>();
      this.mSecUserList.setListInternalName(SEC_USER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mSecUserList;
  }

  public SmartList<SecUser> secUserList() {

    doLoadChild(SEC_USER_LIST);

    return getSecUserList();
  }

  public void setSecUserList(SmartList<SecUser> secUserList) {
    for (SecUser secUser : secUserList) {
      secUser.setDomain(this);
    }

    this.mSecUserList = secUserList;
    this.mSecUserList.setListInternalName(SEC_USER_LIST);
  }

  public UserDomain addSecUser(SecUser secUser) {
    secUser.updateDomain(this);
    getSecUserList().add(secUser);
    return this;
  }

  public UserDomain addSecUserList(SmartList<SecUser> secUserList) {
    for (SecUser secUser : secUserList) {
      secUser.updateDomain(this);
    }

    Map<String, SecUser> mapById = secUserList.mapWithId();
    getSecUserList().removeIf(item -> mapById.get(item.getId()) != null);
    getSecUserList().addAll(secUserList);
    return this;
  }

  public void mergeSecUserList(SmartList<SecUser> secUserList) {
    if (secUserList == null) {
      return;
    }
    if (secUserList.isEmpty()) {
      return;
    }
    addSecUserList(secUserList);
  }

  public SecUser removeSecUser(SecUser secUserIndex) {

    int index = getSecUserList().indexOf(secUserIndex);
    if (index < 0) {
      String message =
          "SecUser("
              + secUserIndex.getId()
              + ") with version='"
              + secUserIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    SecUser secUser = getSecUserList().get(index);
    // secUser.clearDomain(); //disconnect with Domain
    secUser.clearFromAll(); // disconnect with Domain

    boolean result = getSecUserList().planToRemove(secUser);
    if (!result) {
      String message =
          "SecUser("
              + secUserIndex.getId()
              + ") with version='"
              + secUserIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return secUser;
  }
  // 断舍离
  public void breakWithSecUser(SecUser secUser) {

    if (secUser == null) {
      return;
    }
    secUser.setDomain(null);
    // getSecUserList().remove();

  }

  public boolean hasSecUser(SecUser secUser) {

    return getSecUserList().contains(secUser);
  }

  public void copySecUserFrom(SecUser secUser) {

    SecUser secUserInList = findTheSecUser(secUser);
    SecUser newSecUser = new SecUser();
    secUserInList.copyTo(newSecUser);
    newSecUser.setVersion(0); // will trigger copy
    getSecUserList().add(newSecUser);
    addItemToFlexiableObject(COPIED_CHILD, newSecUser);
  }

  public SecUser findTheSecUser(SecUser secUser) {

    int index = getSecUserList().indexOf(secUser);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "SecUser(" + secUser.getId() + ") with version='" + secUser.getVersion() + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getSecUserList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpSecUserList() {
    getSecUserList().clear();
  }

  public SmartList<PublicKeyType> getPublicKeyTypeList() {
    if (this.mPublicKeyTypeList == null) {
      this.mPublicKeyTypeList = new SmartList<PublicKeyType>();
      this.mPublicKeyTypeList.setListInternalName(PUBLIC_KEY_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mPublicKeyTypeList;
  }

  public SmartList<PublicKeyType> publicKeyTypeList() {

    doLoadChild(PUBLIC_KEY_TYPE_LIST);

    return getPublicKeyTypeList();
  }

  public void setPublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList) {
    for (PublicKeyType publicKeyType : publicKeyTypeList) {
      publicKeyType.setDomain(this);
    }

    this.mPublicKeyTypeList = publicKeyTypeList;
    this.mPublicKeyTypeList.setListInternalName(PUBLIC_KEY_TYPE_LIST);
  }

  public UserDomain addPublicKeyType(PublicKeyType publicKeyType) {
    publicKeyType.updateDomain(this);
    getPublicKeyTypeList().add(publicKeyType);
    return this;
  }

  public UserDomain addPublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList) {
    for (PublicKeyType publicKeyType : publicKeyTypeList) {
      publicKeyType.updateDomain(this);
    }

    Map<String, PublicKeyType> mapById = publicKeyTypeList.mapWithId();
    getPublicKeyTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getPublicKeyTypeList().addAll(publicKeyTypeList);
    return this;
  }

  public void mergePublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList) {
    if (publicKeyTypeList == null) {
      return;
    }
    if (publicKeyTypeList.isEmpty()) {
      return;
    }
    addPublicKeyTypeList(publicKeyTypeList);
  }

  public PublicKeyType removePublicKeyType(PublicKeyType publicKeyTypeIndex) {

    int index = getPublicKeyTypeList().indexOf(publicKeyTypeIndex);
    if (index < 0) {
      String message =
          "PublicKeyType("
              + publicKeyTypeIndex.getId()
              + ") with version='"
              + publicKeyTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    PublicKeyType publicKeyType = getPublicKeyTypeList().get(index);
    // publicKeyType.clearDomain(); //disconnect with Domain
    publicKeyType.clearFromAll(); // disconnect with Domain

    boolean result = getPublicKeyTypeList().planToRemove(publicKeyType);
    if (!result) {
      String message =
          "PublicKeyType("
              + publicKeyTypeIndex.getId()
              + ") with version='"
              + publicKeyTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return publicKeyType;
  }
  // 断舍离
  public void breakWithPublicKeyType(PublicKeyType publicKeyType) {

    if (publicKeyType == null) {
      return;
    }
    publicKeyType.setDomain(null);
    // getPublicKeyTypeList().remove();

  }

  public boolean hasPublicKeyType(PublicKeyType publicKeyType) {

    return getPublicKeyTypeList().contains(publicKeyType);
  }

  public void copyPublicKeyTypeFrom(PublicKeyType publicKeyType) {

    PublicKeyType publicKeyTypeInList = findThePublicKeyType(publicKeyType);
    PublicKeyType newPublicKeyType = new PublicKeyType();
    publicKeyTypeInList.copyTo(newPublicKeyType);
    newPublicKeyType.setVersion(0); // will trigger copy
    getPublicKeyTypeList().add(newPublicKeyType);
    addItemToFlexiableObject(COPIED_CHILD, newPublicKeyType);
  }

  public PublicKeyType findThePublicKeyType(PublicKeyType publicKeyType) {

    int index = getPublicKeyTypeList().indexOf(publicKeyType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "PublicKeyType("
              + publicKeyType.getId()
              + ") with version='"
              + publicKeyType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getPublicKeyTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpPublicKeyTypeList() {
    getPublicKeyTypeList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {}

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getUserAllowListList(), internalType);
    collectFromList(this, entityList, getSecUserList(), internalType);
    collectFromList(this, entityList, getPublicKeyTypeList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getUserAllowListList());
    listOfList.add(getSecUserList());
    listOfList.add(getPublicKeyTypeList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, USER_ALLOW_LIST_LIST, getUserAllowListList());
    if (!getUserAllowListList().isEmpty()) {
      appendKeyValuePair(result, "userAllowListCount", getUserAllowListList().getTotalCount());
      appendKeyValuePair(
          result, "userAllowListCurrentPageNumber", getUserAllowListList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, SEC_USER_LIST, getSecUserList());
    if (!getSecUserList().isEmpty()) {
      appendKeyValuePair(result, "secUserCount", getSecUserList().getTotalCount());
      appendKeyValuePair(
          result, "secUserCurrentPageNumber", getSecUserList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, PUBLIC_KEY_TYPE_LIST, getPublicKeyTypeList());
    if (!getPublicKeyTypeList().isEmpty()) {
      appendKeyValuePair(result, "publicKeyTypeCount", getPublicKeyTypeList().getTotalCount());
      appendKeyValuePair(
          result, "publicKeyTypeCurrentPageNumber", getPublicKeyTypeList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof UserDomain) {

      UserDomain dest = (UserDomain) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setVersion(getVersion());
      dest.setUserAllowListList(getUserAllowListList());
      dest.setSecUserList(getSecUserList());
      dest.setPublicKeyTypeList(getPublicKeyTypeList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof UserDomain) {

      UserDomain source = (UserDomain) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeVersion(source.getVersion());
      mergeUserAllowListList(source.getUserAllowListList());
      mergeSecUserList(source.getSecUserList());
      mergePublicKeyTypeList(source.getPublicKeyTypeList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof UserDomain) {

      UserDomain source = (UserDomain) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getName(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    UserDomain checkUserDomain =
        Q.userDomainWithIdField()
            .filterById(id)
            .selectUserAllowListList(Q.userAllowListWithIdField().limit(0, 1))
            .selectSecUserList(Q.secUserWithIdField().limit(0, 1))
            .selectPublicKeyTypeList(Q.publicKeyTypeWithIdField().limit(0, 1))
            .execute(ctx);

    return checkUserDomain != null
        && !checkUserDomain.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public UserDomain save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("UserDomain{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
