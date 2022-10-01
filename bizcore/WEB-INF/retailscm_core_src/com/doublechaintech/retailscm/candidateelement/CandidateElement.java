package com.doublechaintech.retailscm.candidateelement;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;

@JsonSerialize(using = CandidateElementSerializer.class)
public class CandidateElement extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(CandidateElement target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String TYPE_PROPERTY = "type";
  public static final String IMAGE_PROPERTY = "image";
  public static final String CONTAINER_PROPERTY = "container";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "CandidateElement";

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
        MemberMetaInfo.defineBy(TYPE_PROPERTY, "type", "类型").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(IMAGE_PROPERTY, "image", "图片")
            .withType("string_image", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CONTAINER_PROPERTY, "candidate_container", "容器")
            .withType("candidate_container", CandidateContainer.class));
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
      TYPE_PROPERTY,
      IMAGE_PROPERTY,
      CONTAINER_PROPERTY,
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
    parents.put(CONTAINER_PROPERTY, CandidateContainer.class);

    return parents;
  }
  /*
  public CandidateElement want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public CandidateElement wants(Class<? extends BaseEntity>... classes) {
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
  protected String type;
  protected String image;
  protected CandidateContainer container;
  protected int version;

  public CandidateElement() {
    // lazy load for all the properties
  }

  public static CandidateElement withId(String id) {
    CandidateElement candidateElement = new CandidateElement();
    candidateElement.setId(id);
    candidateElement.setVersion(Integer.MAX_VALUE);
    candidateElement.setChecked(true);
    return candidateElement;
  }

  public static CandidateElement refById(String id) {
    return withId(id);
  }

  public CandidateElement limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public CandidateElement limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static CandidateElement searchExample() {
    CandidateElement candidateElement = new CandidateElement();
    candidateElement.setVersion(UNSET_INT);

    return candidateElement;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setContainer( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (TYPE_PROPERTY.equals(property)) {
      changeTypeProperty(newValueExpr);
    }
    if (IMAGE_PROPERTY.equals(property)) {
      changeImageProperty(newValueExpr);
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

  protected void changeTypeProperty(String newValueExpr) {

    String oldValue = getType();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateType(newValue);
    this.onChangeProperty(TYPE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeImageProperty(String newValueExpr) {

    String oldValue = getImage();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateImage(newValue);
    this.onChangeProperty(IMAGE_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (TYPE_PROPERTY.equals(property)) {
      return getType();
    }
    if (IMAGE_PROPERTY.equals(property)) {
      return getImage();
    }
    if (CONTAINER_PROPERTY.equals(property)) {
      return getContainer();
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

  public CandidateElement updateId(String id) {
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

  public CandidateElement orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public CandidateElement ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public CandidateElement addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public CandidateElement updateName(String name) {
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

  public CandidateElement orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public CandidateElement ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public CandidateElement addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setType(String type) {
    String oldType = this.type;
    String newType = trimString(type);
    this.type = newType;
  }

  public String type() {
    doLoad();
    return getType();
  }

  public String getType() {
    return this.type;
  }

  public CandidateElement updateType(String type) {
    String oldType = this.type;
    String newType = trimString(type);
    if (!shouldReplaceBy(newType, oldType)) {
      return this;
    }
    this.type = newType;
    if (cn.hutool.core.util.ObjectUtil.equals(newType, oldType)) {
      return this;
    }
    addPropertyChange(TYPE_PROPERTY, oldType, newType);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CandidateElement orderByType(boolean asc) {
    doAddOrderBy(TYPE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTypeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TYPE_PROPERTY, operator, parameters);
  }

  public CandidateElement ignoreTypeCriteria() {
    super.ignoreSearchProperty(TYPE_PROPERTY);
    return this;
  }

  public CandidateElement addTypeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTypeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeType(String type) {
    if (type != null) {
      updateType(type);
    }
  }

  public void setImage(String image) {
    String oldImage = this.image;
    String newImage = trimString(encodeUrl(image));
    ;
    this.image = newImage;
  }

  public String image() {
    doLoad();
    return getImage();
  }

  public String getImage() {
    return this.image;
  }

  public CandidateElement updateImage(String image) {
    String oldImage = this.image;
    String newImage = trimString(encodeUrl(image));
    ;
    if (!shouldReplaceBy(newImage, oldImage)) {
      return this;
    }
    this.image = newImage;
    if (cn.hutool.core.util.ObjectUtil.equals(newImage, oldImage)) {
      return this;
    }
    addPropertyChange(IMAGE_PROPERTY, oldImage, newImage);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CandidateElement orderByImage(boolean asc) {
    doAddOrderBy(IMAGE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createImageCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(IMAGE_PROPERTY, operator, parameters);
  }

  public CandidateElement ignoreImageCriteria() {
    super.ignoreSearchProperty(IMAGE_PROPERTY);
    return this;
  }

  public CandidateElement addImageCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createImageCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeImage(String image) {
    if (image != null) {
      updateImage(image);
    }
  }

  public void setContainer(CandidateContainer container) {
    CandidateContainer oldContainer = this.container;
    CandidateContainer newContainer = container;
    this.container = newContainer;
  }

  public CandidateContainer container() {
    doLoad();
    return getContainer();
  }

  public CandidateContainer getContainer() {
    return this.container;
  }

  public CandidateElement updateContainer(CandidateContainer container) {
    CandidateContainer oldContainer = this.container;
    CandidateContainer newContainer = container;
    if (!shouldReplaceBy(newContainer, oldContainer)) {
      return this;
    }
    this.container = newContainer;
    if (cn.hutool.core.util.ObjectUtil.equals(newContainer, oldContainer)) {
      return this;
    }
    addPropertyChange(CONTAINER_PROPERTY, oldContainer, newContainer);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public CandidateElement orderByContainer(boolean asc) {
    doAddOrderBy(CONTAINER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createContainerCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CONTAINER_PROPERTY, operator, parameters);
  }

  public CandidateElement ignoreContainerCriteria() {
    super.ignoreSearchProperty(CONTAINER_PROPERTY);
    return this;
  }

  public CandidateElement addContainerCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createContainerCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeContainer(CandidateContainer container) {
    if (container != null) {
      updateContainer(container);
    }
  }

  public CandidateElement updateContainerByReferenceId(String containerId) {
    updateContainer(CandidateContainer.refById(containerId));
    return this;
  }

  public void clearContainer() {
    setContainer(null);
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

  public CandidateElement updateVersion(int version) {
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

  public CandidateElement orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public CandidateElement ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public CandidateElement addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getContainer(), internalType);
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
    appendKeyValuePair(result, TYPE_PROPERTY, getType());
    appendKeyValuePair(result, IMAGE_PROPERTY, getImage());
    appendKeyValuePair(result, CONTAINER_PROPERTY, getContainer());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof CandidateElement) {

      CandidateElement dest = (CandidateElement) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setType(getType());
      dest.setImage(getImage());
      dest.setContainer(getContainer());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof CandidateElement) {

      CandidateElement source = (CandidateElement) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeType(source.getType());
      mergeImage(source.getImage());
      mergeContainer(source.getContainer());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof CandidateElement) {

      CandidateElement source = (CandidateElement) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeType(source.getType());
      mergeImage(source.getImage());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getName(), getType(), getImage(), getContainer(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    CandidateElement checkCandidateElement =
        Q.candidateElementWithIdField().filterById(id).execute(ctx);

    return checkCandidateElement != null
        && !checkCandidateElement.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public CandidateElement save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("CandidateElement{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\ttype='" + getType() + "';");
    stringBuilder.append("\timage='" + getImage() + "';");
    if (getContainer() != null) {
      stringBuilder.append("\tcontainer='CandidateContainer(" + getContainer().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
