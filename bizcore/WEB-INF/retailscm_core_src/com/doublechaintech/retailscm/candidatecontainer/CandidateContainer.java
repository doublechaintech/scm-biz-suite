package com.doublechaintech.retailscm.candidatecontainer;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.candidateelement.CandidateElement;

@JsonSerialize(using = CandidateContainerSerializer.class)
public class CandidateContainer extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(CandidateContainer target) {
    if (target == null) {
      return;
    }
    target.addCandidateElementList(this.getCandidateElementList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String VERSION_PROPERTY = "version";

  public static final String CANDIDATE_ELEMENT_LIST = "candidateElementList";

  public static final String INTERNAL_TYPE = "CandidateContainer";

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
        MemberMetaInfo.referBy(CANDIDATE_ELEMENT_LIST, "container", "候选人元素列表")
            .withType("candidate_element", CandidateElement.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {ID_PROPERTY, NAME_PROPERTY, VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(CANDIDATE_ELEMENT_LIST, "container");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(CANDIDATE_ELEMENT_LIST, CandidateElement.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();

    return parents;
  }
  /*
  public CandidateContainer want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public CandidateContainer wants(Class<? extends BaseEntity>... classes) {
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

  protected SmartList<CandidateElement> mCandidateElementList;

  public CandidateContainer() {
    // lazy load for all the properties
  }

  public static CandidateContainer withId(String id) {
    CandidateContainer candidateContainer = new CandidateContainer();
    candidateContainer.setId(id);
    candidateContainer.setVersion(Integer.MAX_VALUE);
    candidateContainer.setChecked(true);
    return candidateContainer;
  }

  public static CandidateContainer refById(String id) {
    return withId(id);
  }

  public CandidateContainer limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public CandidateContainer limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static CandidateContainer searchExample() {
    CandidateContainer candidateContainer = new CandidateContainer();
    candidateContainer.setVersion(UNSET_INT);

    return candidateContainer;
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
    if (CANDIDATE_ELEMENT_LIST.equals(property)) {
      List<BaseEntity> list =
          getCandidateElementList().stream().map(item -> item).collect(Collectors.toList());
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

  public CandidateContainer updateId(String id) {
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

  public CandidateContainer orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public CandidateContainer ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public CandidateContainer addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public CandidateContainer updateName(String name) {
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

  public CandidateContainer orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public CandidateContainer ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public CandidateContainer addNameCriteria(QueryOperator operator, Object... parameters) {
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

  public CandidateContainer updateVersion(int version) {
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

  public CandidateContainer orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public CandidateContainer ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public CandidateContainer addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<CandidateElement> getCandidateElementList() {
    if (this.mCandidateElementList == null) {
      this.mCandidateElementList = new SmartList<CandidateElement>();
      this.mCandidateElementList.setListInternalName(CANDIDATE_ELEMENT_LIST);
      // 有名字，便于做权限控制
    }

    return this.mCandidateElementList;
  }

  public SmartList<CandidateElement> candidateElementList() {

    doLoadChild(CANDIDATE_ELEMENT_LIST);

    return getCandidateElementList();
  }

  public void setCandidateElementList(SmartList<CandidateElement> candidateElementList) {
    for (CandidateElement candidateElement : candidateElementList) {
      candidateElement.setContainer(this);
    }

    this.mCandidateElementList = candidateElementList;
    this.mCandidateElementList.setListInternalName(CANDIDATE_ELEMENT_LIST);
  }

  public CandidateContainer addCandidateElement(CandidateElement candidateElement) {
    candidateElement.updateContainer(this);
    getCandidateElementList().add(candidateElement);
    return this;
  }

  public CandidateContainer addCandidateElementList(
      SmartList<CandidateElement> candidateElementList) {
    for (CandidateElement candidateElement : candidateElementList) {
      candidateElement.updateContainer(this);
    }

    Map<String, CandidateElement> mapById = candidateElementList.mapWithId();
    getCandidateElementList().removeIf(item -> mapById.get(item.getId()) != null);
    getCandidateElementList().addAll(candidateElementList);
    return this;
  }

  public void mergeCandidateElementList(SmartList<CandidateElement> candidateElementList) {
    if (candidateElementList == null) {
      return;
    }
    if (candidateElementList.isEmpty()) {
      return;
    }
    addCandidateElementList(candidateElementList);
  }

  public CandidateElement removeCandidateElement(CandidateElement candidateElementIndex) {

    int index = getCandidateElementList().indexOf(candidateElementIndex);
    if (index < 0) {
      String message =
          "CandidateElement("
              + candidateElementIndex.getId()
              + ") with version='"
              + candidateElementIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    CandidateElement candidateElement = getCandidateElementList().get(index);
    // candidateElement.clearContainer(); //disconnect with Container
    candidateElement.clearFromAll(); // disconnect with Container

    boolean result = getCandidateElementList().planToRemove(candidateElement);
    if (!result) {
      String message =
          "CandidateElement("
              + candidateElementIndex.getId()
              + ") with version='"
              + candidateElementIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return candidateElement;
  }
  // 断舍离
  public void breakWithCandidateElement(CandidateElement candidateElement) {

    if (candidateElement == null) {
      return;
    }
    candidateElement.setContainer(null);
    // getCandidateElementList().remove();

  }

  public boolean hasCandidateElement(CandidateElement candidateElement) {

    return getCandidateElementList().contains(candidateElement);
  }

  public void copyCandidateElementFrom(CandidateElement candidateElement) {

    CandidateElement candidateElementInList = findTheCandidateElement(candidateElement);
    CandidateElement newCandidateElement = new CandidateElement();
    candidateElementInList.copyTo(newCandidateElement);
    newCandidateElement.setVersion(0); // will trigger copy
    getCandidateElementList().add(newCandidateElement);
    addItemToFlexiableObject(COPIED_CHILD, newCandidateElement);
  }

  public CandidateElement findTheCandidateElement(CandidateElement candidateElement) {

    int index = getCandidateElementList().indexOf(candidateElement);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "CandidateElement("
              + candidateElement.getId()
              + ") with version='"
              + candidateElement.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getCandidateElementList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpCandidateElementList() {
    getCandidateElementList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {}

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getCandidateElementList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getCandidateElementList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, CANDIDATE_ELEMENT_LIST, getCandidateElementList());
    if (!getCandidateElementList().isEmpty()) {
      appendKeyValuePair(
          result, "candidateElementCount", getCandidateElementList().getTotalCount());
      appendKeyValuePair(
          result,
          "candidateElementCurrentPageNumber",
          getCandidateElementList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof CandidateContainer) {

      CandidateContainer dest = (CandidateContainer) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setVersion(getVersion());
      dest.setCandidateElementList(getCandidateElementList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof CandidateContainer) {

      CandidateContainer source = (CandidateContainer) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeVersion(source.getVersion());
      mergeCandidateElementList(source.getCandidateElementList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof CandidateContainer) {

      CandidateContainer source = (CandidateContainer) sourceEntity;

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
    CandidateContainer checkCandidateContainer =
        Q.candidateContainerWithIdField()
            .filterById(id)
            .selectCandidateElementList(Q.candidateElementWithIdField().limit(0, 1))
            .execute(ctx);

    return checkCandidateContainer != null
        && !checkCandidateContainer.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public CandidateContainer save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("CandidateContainer{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
