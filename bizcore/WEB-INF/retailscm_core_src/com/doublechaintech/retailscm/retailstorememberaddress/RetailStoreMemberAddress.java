package com.doublechaintech.retailscm.retailstorememberaddress;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

@JsonSerialize(using = RetailStoreMemberAddressSerializer.class)
public class RetailStoreMemberAddress extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(RetailStoreMemberAddress target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String OWNER_PROPERTY = "owner";
  public static final String MOBILE_PHONE_PROPERTY = "mobilePhone";
  public static final String ADDRESS_PROPERTY = "address";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "RetailStoreMemberAddress";

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
        MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_member", "业主")
            .withType("retail_store_member", RetailStoreMember.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(MOBILE_PHONE_PROPERTY, "mobile_phone", "移动电话")
            .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ADDRESS_PROPERTY, "address", "地址")
            .withType("string", String.class));
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
      OWNER_PROPERTY,
      MOBILE_PHONE_PROPERTY,
      ADDRESS_PROPERTY,
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
    parents.put(OWNER_PROPERTY, RetailStoreMember.class);

    return parents;
  }
  /*
  public RetailStoreMemberAddress want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreMemberAddress wants(Class<? extends BaseEntity>... classes) {
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
  protected RetailStoreMember owner;
  protected String mobilePhone;
  protected String address;
  protected int version;

  public RetailStoreMemberAddress() {
    // lazy load for all the properties
  }

  public static RetailStoreMemberAddress withId(String id) {
    RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
    retailStoreMemberAddress.setId(id);
    retailStoreMemberAddress.setVersion(Integer.MAX_VALUE);
    retailStoreMemberAddress.setChecked(true);
    return retailStoreMemberAddress;
  }

  public static RetailStoreMemberAddress refById(String id) {
    return withId(id);
  }

  public RetailStoreMemberAddress limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreMemberAddress limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreMemberAddress searchExample() {
    RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
    retailStoreMemberAddress.setVersion(UNSET_INT);

    return retailStoreMemberAddress;
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
    if (MOBILE_PHONE_PROPERTY.equals(property)) {
      changeMobilePhoneProperty(newValueExpr);
    }
    if (ADDRESS_PROPERTY.equals(property)) {
      changeAddressProperty(newValueExpr);
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

  protected void changeMobilePhoneProperty(String newValueExpr) {

    String oldValue = getMobilePhone();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateMobilePhone(newValue);
    this.onChangeProperty(MOBILE_PHONE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAddressProperty(String newValueExpr) {

    String oldValue = getAddress();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAddress(newValue);
    this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (OWNER_PROPERTY.equals(property)) {
      return getOwner();
    }
    if (MOBILE_PHONE_PROPERTY.equals(property)) {
      return getMobilePhone();
    }
    if (ADDRESS_PROPERTY.equals(property)) {
      return getAddress();
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

  public RetailStoreMemberAddress updateId(String id) {
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

  public RetailStoreMemberAddress orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public RetailStoreMemberAddress ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddress addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public RetailStoreMemberAddress updateName(String name) {
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

  public RetailStoreMemberAddress orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public RetailStoreMemberAddress ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddress addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setOwner(RetailStoreMember owner) {
    RetailStoreMember oldOwner = this.owner;
    RetailStoreMember newOwner = owner;
    this.owner = newOwner;
  }

  public RetailStoreMember owner() {
    doLoad();
    return getOwner();
  }

  public RetailStoreMember getOwner() {
    return this.owner;
  }

  public RetailStoreMemberAddress updateOwner(RetailStoreMember owner) {
    RetailStoreMember oldOwner = this.owner;
    RetailStoreMember newOwner = owner;
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

  public RetailStoreMemberAddress orderByOwner(boolean asc) {
    doAddOrderBy(OWNER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OWNER_PROPERTY, operator, parameters);
  }

  public RetailStoreMemberAddress ignoreOwnerCriteria() {
    super.ignoreSearchProperty(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddress addOwnerCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOwnerCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOwner(RetailStoreMember owner) {
    if (owner != null) {
      updateOwner(owner);
    }
  }

  public RetailStoreMemberAddress updateOwnerByReferenceId(String ownerId) {
    updateOwner(RetailStoreMember.refById(ownerId));
    return this;
  }

  public void clearOwner() {
    setOwner(null);
    this.changed = true;
    setChecked(false);
  }

  public void setMobilePhone(String mobilePhone) {
    String oldMobilePhone = this.mobilePhone;
    String newMobilePhone = trimString(mobilePhone);
    this.mobilePhone = newMobilePhone;
  }

  public String mobilePhone() {
    doLoad();
    return getMobilePhone();
  }

  public String getMobilePhone() {
    return this.mobilePhone;
  }

  public RetailStoreMemberAddress updateMobilePhone(String mobilePhone) {
    String oldMobilePhone = this.mobilePhone;
    String newMobilePhone = trimString(mobilePhone);
    if (!shouldReplaceBy(newMobilePhone, oldMobilePhone)) {
      return this;
    }
    this.mobilePhone = newMobilePhone;
    if (cn.hutool.core.util.ObjectUtil.equals(newMobilePhone, oldMobilePhone)) {
      return this;
    }
    addPropertyChange(MOBILE_PHONE_PROPERTY, oldMobilePhone, newMobilePhone);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreMemberAddress orderByMobilePhone(boolean asc) {
    doAddOrderBy(MOBILE_PHONE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMobilePhoneCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOBILE_PHONE_PROPERTY, operator, parameters);
  }

  public RetailStoreMemberAddress ignoreMobilePhoneCriteria() {
    super.ignoreSearchProperty(MOBILE_PHONE_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddress addMobilePhoneCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMobilePhoneCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMobilePhone(String mobilePhone) {
    if (mobilePhone != null) {
      updateMobilePhone(mobilePhone);
    }
  }

  public String getMaskedMobilePhone() {
    String mobilePhoneNumber = getMobilePhone();
    return maskChinaMobileNumber(mobilePhoneNumber);
  }

  public void setAddress(String address) {
    String oldAddress = this.address;
    String newAddress = trimString(address);
    this.address = newAddress;
  }

  public String address() {
    doLoad();
    return getAddress();
  }

  public String getAddress() {
    return this.address;
  }

  public RetailStoreMemberAddress updateAddress(String address) {
    String oldAddress = this.address;
    String newAddress = trimString(address);
    if (!shouldReplaceBy(newAddress, oldAddress)) {
      return this;
    }
    this.address = newAddress;
    if (cn.hutool.core.util.ObjectUtil.equals(newAddress, oldAddress)) {
      return this;
    }
    addPropertyChange(ADDRESS_PROPERTY, oldAddress, newAddress);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreMemberAddress orderByAddress(boolean asc) {
    doAddOrderBy(ADDRESS_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAddressCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ADDRESS_PROPERTY, operator, parameters);
  }

  public RetailStoreMemberAddress ignoreAddressCriteria() {
    super.ignoreSearchProperty(ADDRESS_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddress addAddressCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAddressCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAddress(String address) {
    if (address != null) {
      updateAddress(address);
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

  public RetailStoreMemberAddress updateVersion(int version) {
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

  public RetailStoreMemberAddress orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public RetailStoreMemberAddress ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddress addVersionCriteria(QueryOperator operator, Object... parameters) {
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
    appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
    appendKeyValuePair(result, MOBILE_PHONE_PROPERTY, getMaskedMobilePhone());
    appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof RetailStoreMemberAddress) {

      RetailStoreMemberAddress dest = (RetailStoreMemberAddress) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setOwner(getOwner());
      dest.setMobilePhone(getMobilePhone());
      dest.setAddress(getAddress());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof RetailStoreMemberAddress) {

      RetailStoreMemberAddress source = (RetailStoreMemberAddress) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeOwner(source.getOwner());
      mergeMobilePhone(source.getMobilePhone());
      mergeAddress(source.getAddress());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof RetailStoreMemberAddress) {

      RetailStoreMemberAddress source = (RetailStoreMemberAddress) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeMobilePhone(source.getMobilePhone());
      mergeAddress(source.getAddress());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getName(), getOwner(), getMobilePhone(), getAddress(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    RetailStoreMemberAddress checkRetailStoreMemberAddress =
        Q.retailStoreMemberAddressWithIdField().filterById(id).execute(ctx);

    return checkRetailStoreMemberAddress != null
        && !checkRetailStoreMemberAddress.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public RetailStoreMemberAddress save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("RetailStoreMemberAddress{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    if (getOwner() != null) {
      stringBuilder.append("\towner='RetailStoreMember(" + getOwner().getId() + ")';");
    }
    stringBuilder.append("\tmobilePhone='" + getMobilePhone() + "';");
    stringBuilder.append("\taddress='" + getAddress() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
