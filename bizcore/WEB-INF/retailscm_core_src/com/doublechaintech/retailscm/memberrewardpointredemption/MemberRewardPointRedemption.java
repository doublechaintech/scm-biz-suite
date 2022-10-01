package com.doublechaintech.retailscm.memberrewardpointredemption;

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

@JsonSerialize(using = MemberRewardPointRedemptionSerializer.class)
public class MemberRewardPointRedemption extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(MemberRewardPointRedemption target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String POINT_PROPERTY = "point";
  public static final String OWNER_PROPERTY = "owner";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "MemberRewardPointRedemption";

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
        MemberMetaInfo.defineBy(POINT_PROPERTY, "point", "点").withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_member", "业主")
            .withType("retail_store_member", RetailStoreMember.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, NAME_PROPERTY, POINT_PROPERTY, OWNER_PROPERTY, VERSION_PROPERTY
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
  public MemberRewardPointRedemption want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public MemberRewardPointRedemption wants(Class<? extends BaseEntity>... classes) {
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
  protected int point;
  protected RetailStoreMember owner;
  protected int version;

  public MemberRewardPointRedemption() {
    // lazy load for all the properties
  }

  public static MemberRewardPointRedemption withId(String id) {
    MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
    memberRewardPointRedemption.setId(id);
    memberRewardPointRedemption.setVersion(Integer.MAX_VALUE);
    memberRewardPointRedemption.setChecked(true);
    return memberRewardPointRedemption;
  }

  public static MemberRewardPointRedemption refById(String id) {
    return withId(id);
  }

  public MemberRewardPointRedemption limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public MemberRewardPointRedemption limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static MemberRewardPointRedemption searchExample() {
    MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
    memberRewardPointRedemption.setPoint(UNSET_INT);
    memberRewardPointRedemption.setVersion(UNSET_INT);

    return memberRewardPointRedemption;
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
    if (POINT_PROPERTY.equals(property)) {
      changePointProperty(newValueExpr);
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

  protected void changePointProperty(String newValueExpr) {

    int oldValue = getPoint();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updatePoint(newValue);
    this.onChangeProperty(POINT_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (POINT_PROPERTY.equals(property)) {
      return getPoint();
    }
    if (OWNER_PROPERTY.equals(property)) {
      return getOwner();
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

  public MemberRewardPointRedemption updateId(String id) {
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

  public MemberRewardPointRedemption orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public MemberRewardPointRedemption ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemption addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public MemberRewardPointRedemption updateName(String name) {
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

  public MemberRewardPointRedemption orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public MemberRewardPointRedemption ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemption addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setPoint(int point) {
    int oldPoint = this.point;
    int newPoint = point;
    this.point = newPoint;
  }

  public int point() {
    doLoad();
    return getPoint();
  }

  public int getPoint() {
    return this.point;
  }

  public MemberRewardPointRedemption updatePoint(int point) {
    int oldPoint = this.point;
    int newPoint = point;
    if (!shouldReplaceBy(newPoint, oldPoint)) {
      return this;
    }
    this.point = newPoint;
    if (cn.hutool.core.util.ObjectUtil.equals(newPoint, oldPoint)) {
      return this;
    }
    addPropertyChange(POINT_PROPERTY, oldPoint, newPoint);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public MemberRewardPointRedemption orderByPoint(boolean asc) {
    doAddOrderBy(POINT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPointCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(POINT_PROPERTY, operator, parameters);
  }

  public MemberRewardPointRedemption ignorePointCriteria() {
    super.ignoreSearchProperty(POINT_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemption addPointCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPointCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePoint(int point) {
    updatePoint(point);
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

  public MemberRewardPointRedemption updateOwner(RetailStoreMember owner) {
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

  public MemberRewardPointRedemption orderByOwner(boolean asc) {
    doAddOrderBy(OWNER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OWNER_PROPERTY, operator, parameters);
  }

  public MemberRewardPointRedemption ignoreOwnerCriteria() {
    super.ignoreSearchProperty(OWNER_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemption addOwnerCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOwnerCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOwner(RetailStoreMember owner) {
    if (owner != null) {
      updateOwner(owner);
    }
  }

  public MemberRewardPointRedemption updateOwnerByReferenceId(String ownerId) {
    updateOwner(RetailStoreMember.refById(ownerId));
    return this;
  }

  public void clearOwner() {
    setOwner(null);
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

  public MemberRewardPointRedemption updateVersion(int version) {
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

  public MemberRewardPointRedemption orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public MemberRewardPointRedemption ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemption addVersionCriteria(
      QueryOperator operator, Object... parameters) {
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
    appendKeyValuePair(result, POINT_PROPERTY, getPoint());
    appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof MemberRewardPointRedemption) {

      MemberRewardPointRedemption dest = (MemberRewardPointRedemption) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setPoint(getPoint());
      dest.setOwner(getOwner());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof MemberRewardPointRedemption) {

      MemberRewardPointRedemption source = (MemberRewardPointRedemption) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergePoint(source.getPoint());
      mergeOwner(source.getOwner());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof MemberRewardPointRedemption) {

      MemberRewardPointRedemption source = (MemberRewardPointRedemption) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergePoint(source.getPoint());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getName(), getPoint(), getOwner(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    MemberRewardPointRedemption checkMemberRewardPointRedemption =
        Q.memberRewardPointRedemptionWithIdField().filterById(id).execute(ctx);

    return checkMemberRewardPointRedemption != null
        && !checkMemberRewardPointRedemption.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public MemberRewardPointRedemption save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("MemberRewardPointRedemption{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tpoint='" + getPoint() + "';");
    if (getOwner() != null) {
      stringBuilder.append("\towner='RetailStoreMember(" + getOwner().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increasePoint(int incPoint) {
    updatePoint(this.point + incPoint);
  }

  public void decreasePoint(int decPoint) {
    updatePoint(this.point - decPoint);
  }
}
