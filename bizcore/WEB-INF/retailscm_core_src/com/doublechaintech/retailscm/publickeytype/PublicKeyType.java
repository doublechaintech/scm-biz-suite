package com.doublechaintech.retailscm.publickeytype;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.userdomain.UserDomain;

@JsonSerialize(using = PublicKeyTypeSerializer.class)
public class PublicKeyType extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(PublicKeyType target) {
    if (target == null) {
      return;
    }
    target.addKeyPairIdentityList(this.getKeyPairIdentityList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String KEY_ALG_PROPERTY = "keyAlg";
  public static final String SIGN_ALG_PROPERTY = "signAlg";
  public static final String DOMAIN_PROPERTY = "domain";
  public static final String VERSION_PROPERTY = "version";

  public static final String KEY_PAIR_IDENTITY_LIST = "keyPairIdentityList";

  public static final String INTERNAL_TYPE = "PublicKeyType";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(KEY_ALG_PROPERTY, "key_alg", "键 ALG")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SIGN_ALG_PROPERTY, "sign_alg", "Alg迹象")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DOMAIN_PROPERTY, "user_domain", "域")
            .withType("user_domain", UserDomain.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(KEY_PAIR_IDENTITY_LIST, "keyType", "密钥对身份列表")
            .withType("key_pair_identity", KeyPairIdentity.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, KEY_ALG_PROPERTY, SIGN_ALG_PROPERTY, DOMAIN_PROPERTY, VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(KEY_PAIR_IDENTITY_LIST, "keyType");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(KEY_PAIR_IDENTITY_LIST, KeyPairIdentity.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(DOMAIN_PROPERTY, UserDomain.class);

    return parents;
  }
  /*
  public PublicKeyType want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public PublicKeyType wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getKeyAlg();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String keyAlg;
  protected String signAlg;
  protected UserDomain domain;
  protected int version;

  protected SmartList<KeyPairIdentity> mKeyPairIdentityList;

  public PublicKeyType() {
    // lazy load for all the properties
  }

  public static PublicKeyType withId(String id) {
    PublicKeyType publicKeyType = new PublicKeyType();
    publicKeyType.setId(id);
    publicKeyType.setVersion(Integer.MAX_VALUE);
    publicKeyType.setChecked(true);
    return publicKeyType;
  }

  public static PublicKeyType refById(String id) {
    return withId(id);
  }

  public PublicKeyType limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public PublicKeyType limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static PublicKeyType searchExample() {
    PublicKeyType publicKeyType = new PublicKeyType();
    publicKeyType.setVersion(UNSET_INT);

    return publicKeyType;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setDomain( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (KEY_ALG_PROPERTY.equals(property)) {
      changeKeyAlgProperty(newValueExpr);
    }
    if (SIGN_ALG_PROPERTY.equals(property)) {
      changeSignAlgProperty(newValueExpr);
    }
  }

  protected void changeKeyAlgProperty(String newValueExpr) {

    String oldValue = getKeyAlg();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateKeyAlg(newValue);
    this.onChangeProperty(KEY_ALG_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeSignAlgProperty(String newValueExpr) {

    String oldValue = getSignAlg();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateSignAlg(newValue);
    this.onChangeProperty(SIGN_ALG_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (KEY_ALG_PROPERTY.equals(property)) {
      return getKeyAlg();
    }
    if (SIGN_ALG_PROPERTY.equals(property)) {
      return getSignAlg();
    }
    if (DOMAIN_PROPERTY.equals(property)) {
      return getDomain();
    }
    if (KEY_PAIR_IDENTITY_LIST.equals(property)) {
      List<BaseEntity> list =
          getKeyPairIdentityList().stream().map(item -> item).collect(Collectors.toList());
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

  public PublicKeyType updateId(String id) {
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

  public PublicKeyType orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public PublicKeyType ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public PublicKeyType addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setKeyAlg(String keyAlg) {
    String oldKeyAlg = this.keyAlg;
    String newKeyAlg = trimString(keyAlg);
    this.keyAlg = newKeyAlg;
  }

  public String keyAlg() {
    doLoad();
    return getKeyAlg();
  }

  public String getKeyAlg() {
    return this.keyAlg;
  }

  public PublicKeyType updateKeyAlg(String keyAlg) {
    String oldKeyAlg = this.keyAlg;
    String newKeyAlg = trimString(keyAlg);
    if (!shouldReplaceBy(newKeyAlg, oldKeyAlg)) {
      return this;
    }
    this.keyAlg = newKeyAlg;
    if (cn.hutool.core.util.ObjectUtil.equals(newKeyAlg, oldKeyAlg)) {
      return this;
    }
    addPropertyChange(KEY_ALG_PROPERTY, oldKeyAlg, newKeyAlg);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public PublicKeyType orderByKeyAlg(boolean asc) {
    doAddOrderBy(KEY_ALG_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createKeyAlgCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(KEY_ALG_PROPERTY, operator, parameters);
  }

  public PublicKeyType ignoreKeyAlgCriteria() {
    super.ignoreSearchProperty(KEY_ALG_PROPERTY);
    return this;
  }

  public PublicKeyType addKeyAlgCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createKeyAlgCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeKeyAlg(String keyAlg) {
    if (keyAlg != null) {
      updateKeyAlg(keyAlg);
    }
  }

  public void setSignAlg(String signAlg) {
    String oldSignAlg = this.signAlg;
    String newSignAlg = trimString(signAlg);
    this.signAlg = newSignAlg;
  }

  public String signAlg() {
    doLoad();
    return getSignAlg();
  }

  public String getSignAlg() {
    return this.signAlg;
  }

  public PublicKeyType updateSignAlg(String signAlg) {
    String oldSignAlg = this.signAlg;
    String newSignAlg = trimString(signAlg);
    if (!shouldReplaceBy(newSignAlg, oldSignAlg)) {
      return this;
    }
    this.signAlg = newSignAlg;
    if (cn.hutool.core.util.ObjectUtil.equals(newSignAlg, oldSignAlg)) {
      return this;
    }
    addPropertyChange(SIGN_ALG_PROPERTY, oldSignAlg, newSignAlg);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public PublicKeyType orderBySignAlg(boolean asc) {
    doAddOrderBy(SIGN_ALG_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSignAlgCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SIGN_ALG_PROPERTY, operator, parameters);
  }

  public PublicKeyType ignoreSignAlgCriteria() {
    super.ignoreSearchProperty(SIGN_ALG_PROPERTY);
    return this;
  }

  public PublicKeyType addSignAlgCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSignAlgCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSignAlg(String signAlg) {
    if (signAlg != null) {
      updateSignAlg(signAlg);
    }
  }

  public void setDomain(UserDomain domain) {
    UserDomain oldDomain = this.domain;
    UserDomain newDomain = domain;
    this.domain = newDomain;
  }

  public UserDomain domain() {
    doLoad();
    return getDomain();
  }

  public UserDomain getDomain() {
    return this.domain;
  }

  public PublicKeyType updateDomain(UserDomain domain) {
    UserDomain oldDomain = this.domain;
    UserDomain newDomain = domain;
    if (!shouldReplaceBy(newDomain, oldDomain)) {
      return this;
    }
    this.domain = newDomain;
    if (cn.hutool.core.util.ObjectUtil.equals(newDomain, oldDomain)) {
      return this;
    }
    addPropertyChange(DOMAIN_PROPERTY, oldDomain, newDomain);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public PublicKeyType orderByDomain(boolean asc) {
    doAddOrderBy(DOMAIN_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDomainCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DOMAIN_PROPERTY, operator, parameters);
  }

  public PublicKeyType ignoreDomainCriteria() {
    super.ignoreSearchProperty(DOMAIN_PROPERTY);
    return this;
  }

  public PublicKeyType addDomainCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDomainCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDomain(UserDomain domain) {
    if (domain != null) {
      updateDomain(domain);
    }
  }

  public PublicKeyType updateDomainByReferenceId(String domainId) {
    updateDomain(UserDomain.refById(domainId));
    return this;
  }

  public void clearDomain() {
    setDomain(null);
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

  public PublicKeyType updateVersion(int version) {
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

  public PublicKeyType orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public PublicKeyType ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public PublicKeyType addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<KeyPairIdentity> getKeyPairIdentityList() {
    if (this.mKeyPairIdentityList == null) {
      this.mKeyPairIdentityList = new SmartList<KeyPairIdentity>();
      this.mKeyPairIdentityList.setListInternalName(KEY_PAIR_IDENTITY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mKeyPairIdentityList;
  }

  public SmartList<KeyPairIdentity> keyPairIdentityList() {

    doLoadChild(KEY_PAIR_IDENTITY_LIST);

    return getKeyPairIdentityList();
  }

  public void setKeyPairIdentityList(SmartList<KeyPairIdentity> keyPairIdentityList) {
    for (KeyPairIdentity keyPairIdentity : keyPairIdentityList) {
      keyPairIdentity.setKeyType(this);
    }

    this.mKeyPairIdentityList = keyPairIdentityList;
    this.mKeyPairIdentityList.setListInternalName(KEY_PAIR_IDENTITY_LIST);
  }

  public PublicKeyType addKeyPairIdentity(KeyPairIdentity keyPairIdentity) {
    keyPairIdentity.updateKeyType(this);
    getKeyPairIdentityList().add(keyPairIdentity);
    return this;
  }

  public PublicKeyType addKeyPairIdentityList(SmartList<KeyPairIdentity> keyPairIdentityList) {
    for (KeyPairIdentity keyPairIdentity : keyPairIdentityList) {
      keyPairIdentity.updateKeyType(this);
    }

    Map<String, KeyPairIdentity> mapById = keyPairIdentityList.mapWithId();
    getKeyPairIdentityList().removeIf(item -> mapById.get(item.getId()) != null);
    getKeyPairIdentityList().addAll(keyPairIdentityList);
    return this;
  }

  public void mergeKeyPairIdentityList(SmartList<KeyPairIdentity> keyPairIdentityList) {
    if (keyPairIdentityList == null) {
      return;
    }
    if (keyPairIdentityList.isEmpty()) {
      return;
    }
    addKeyPairIdentityList(keyPairIdentityList);
  }

  public KeyPairIdentity removeKeyPairIdentity(KeyPairIdentity keyPairIdentityIndex) {

    int index = getKeyPairIdentityList().indexOf(keyPairIdentityIndex);
    if (index < 0) {
      String message =
          "KeyPairIdentity("
              + keyPairIdentityIndex.getId()
              + ") with version='"
              + keyPairIdentityIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    KeyPairIdentity keyPairIdentity = getKeyPairIdentityList().get(index);
    // keyPairIdentity.clearKeyType(); //disconnect with KeyType
    keyPairIdentity.clearFromAll(); // disconnect with KeyType

    boolean result = getKeyPairIdentityList().planToRemove(keyPairIdentity);
    if (!result) {
      String message =
          "KeyPairIdentity("
              + keyPairIdentityIndex.getId()
              + ") with version='"
              + keyPairIdentityIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return keyPairIdentity;
  }
  // 断舍离
  public void breakWithKeyPairIdentity(KeyPairIdentity keyPairIdentity) {

    if (keyPairIdentity == null) {
      return;
    }
    keyPairIdentity.setKeyType(null);
    // getKeyPairIdentityList().remove();

  }

  public boolean hasKeyPairIdentity(KeyPairIdentity keyPairIdentity) {

    return getKeyPairIdentityList().contains(keyPairIdentity);
  }

  public void copyKeyPairIdentityFrom(KeyPairIdentity keyPairIdentity) {

    KeyPairIdentity keyPairIdentityInList = findTheKeyPairIdentity(keyPairIdentity);
    KeyPairIdentity newKeyPairIdentity = new KeyPairIdentity();
    keyPairIdentityInList.copyTo(newKeyPairIdentity);
    newKeyPairIdentity.setVersion(0); // will trigger copy
    getKeyPairIdentityList().add(newKeyPairIdentity);
    addItemToFlexiableObject(COPIED_CHILD, newKeyPairIdentity);
  }

  public KeyPairIdentity findTheKeyPairIdentity(KeyPairIdentity keyPairIdentity) {

    int index = getKeyPairIdentityList().indexOf(keyPairIdentity);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "KeyPairIdentity("
              + keyPairIdentity.getId()
              + ") with version='"
              + keyPairIdentity.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getKeyPairIdentityList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpKeyPairIdentityList() {
    getKeyPairIdentityList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getDomain(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getKeyPairIdentityList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getKeyPairIdentityList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, KEY_ALG_PROPERTY, getKeyAlg());
    appendKeyValuePair(result, SIGN_ALG_PROPERTY, getSignAlg());
    appendKeyValuePair(result, DOMAIN_PROPERTY, getDomain());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, KEY_PAIR_IDENTITY_LIST, getKeyPairIdentityList());
    if (!getKeyPairIdentityList().isEmpty()) {
      appendKeyValuePair(result, "keyPairIdentityCount", getKeyPairIdentityList().getTotalCount());
      appendKeyValuePair(
          result,
          "keyPairIdentityCurrentPageNumber",
          getKeyPairIdentityList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof PublicKeyType) {

      PublicKeyType dest = (PublicKeyType) baseDest;

      dest.setId(getId());
      dest.setKeyAlg(getKeyAlg());
      dest.setSignAlg(getSignAlg());
      dest.setDomain(getDomain());
      dest.setVersion(getVersion());
      dest.setKeyPairIdentityList(getKeyPairIdentityList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof PublicKeyType) {

      PublicKeyType source = (PublicKeyType) sourceEntity;

      mergeId(source.getId());
      mergeKeyAlg(source.getKeyAlg());
      mergeSignAlg(source.getSignAlg());
      mergeDomain(source.getDomain());
      mergeVersion(source.getVersion());
      mergeKeyPairIdentityList(source.getKeyPairIdentityList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof PublicKeyType) {

      PublicKeyType source = (PublicKeyType) sourceEntity;

      mergeId(source.getId());
      mergeKeyAlg(source.getKeyAlg());
      mergeSignAlg(source.getSignAlg());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getKeyAlg(), getSignAlg(), getDomain(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    PublicKeyType checkPublicKeyType =
        Q.publicKeyTypeWithIdField()
            .filterById(id)
            .selectKeyPairIdentityList(Q.keyPairIdentityWithIdField().limit(0, 1))
            .execute(ctx);

    return checkPublicKeyType != null
        && !checkPublicKeyType.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public PublicKeyType save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("PublicKeyType{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tkeyAlg='" + getKeyAlg() + "';");
    stringBuilder.append("\tsignAlg='" + getSignAlg() + "';");
    if (getDomain() != null) {
      stringBuilder.append("\tdomain='UserDomain(" + getDomain().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
