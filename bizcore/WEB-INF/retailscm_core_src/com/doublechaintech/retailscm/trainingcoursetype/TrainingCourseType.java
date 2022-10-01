package com.doublechaintech.retailscm.trainingcoursetype;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

@JsonSerialize(using = TrainingCourseTypeSerializer.class)
public class TrainingCourseType extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(TrainingCourseType target) {
    if (target == null) {
      return;
    }
    target.addCompanyTrainingList(this.getCompanyTrainingList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String CODE_PROPERTY = "code";
  public static final String COMPANY_PROPERTY = "company";
  public static final String NAME_PROPERTY = "name";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String VERSION_PROPERTY = "version";

  public static final String COMPANY_TRAINING_LIST = "companyTrainingList";

  public static final String INTERNAL_TYPE = "TrainingCourseType";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CODE_PROPERTY, "code", "代码").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COMPANY_PROPERTY, "retail_store_country_center", "公司")
            .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(COMPANY_TRAINING_LIST, "trainingCourseType", "公司培训名单")
            .withType("company_training", CompanyTraining.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      CODE_PROPERTY,
      COMPANY_PROPERTY,
      NAME_PROPERTY,
      DESCRIPTION_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(COMPANY_TRAINING_LIST, "trainingCourseType");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(COMPANY_TRAINING_LIST, CompanyTraining.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }
  /*
  public TrainingCourseType want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public TrainingCourseType wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getCode();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String code;
  protected RetailStoreCountryCenter company;
  protected String name;
  protected String description;
  protected int version;

  protected SmartList<CompanyTraining> mCompanyTrainingList;

  public TrainingCourseType() {
    // lazy load for all the properties
  }

  public static TrainingCourseType withId(String id) {
    TrainingCourseType trainingCourseType = new TrainingCourseType();
    trainingCourseType.setId(id);
    trainingCourseType.setVersion(Integer.MAX_VALUE);
    trainingCourseType.setChecked(true);
    return trainingCourseType;
  }

  public static TrainingCourseType refById(String id) {
    return withId(id);
  }

  public TrainingCourseType limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public TrainingCourseType limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static TrainingCourseType searchExample() {
    TrainingCourseType trainingCourseType = new TrainingCourseType();
    trainingCourseType.setVersion(UNSET_INT);

    return trainingCourseType;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setCompany( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (CODE_PROPERTY.equals(property)) {
      changeCodeProperty(newValueExpr);
    }
    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      changeDescriptionProperty(newValueExpr);
    }
  }

  protected void changeCodeProperty(String newValueExpr) {

    String oldValue = getCode();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateCode(newValue);
    this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
    return;
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

    if (CODE_PROPERTY.equals(property)) {
      return getCode();
    }
    if (COMPANY_PROPERTY.equals(property)) {
      return getCompany();
    }
    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (COMPANY_TRAINING_LIST.equals(property)) {
      List<BaseEntity> list =
          getCompanyTrainingList().stream().map(item -> item).collect(Collectors.toList());
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

  public TrainingCourseType updateId(String id) {
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

  public TrainingCourseType orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public TrainingCourseType ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public TrainingCourseType addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setCode(String code) {
    String oldCode = this.code;
    String newCode = trimString(code);
    this.code = newCode;
  }

  public String code() {
    doLoad();
    return getCode();
  }

  public String getCode() {
    return this.code;
  }

  public TrainingCourseType updateCode(String code) {
    String oldCode = this.code;
    String newCode = trimString(code);
    if (!shouldReplaceBy(newCode, oldCode)) {
      return this;
    }
    this.code = newCode;
    if (cn.hutool.core.util.ObjectUtil.equals(newCode, oldCode)) {
      return this;
    }
    addPropertyChange(CODE_PROPERTY, oldCode, newCode);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TrainingCourseType orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public TrainingCourseType ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public TrainingCourseType addCodeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCode(String code) {
    if (code != null) {
      updateCode(code);
    }
  }

  public void setCompany(RetailStoreCountryCenter company) {
    RetailStoreCountryCenter oldCompany = this.company;
    RetailStoreCountryCenter newCompany = company;
    this.company = newCompany;
  }

  public RetailStoreCountryCenter company() {
    doLoad();
    return getCompany();
  }

  public RetailStoreCountryCenter getCompany() {
    return this.company;
  }

  public TrainingCourseType updateCompany(RetailStoreCountryCenter company) {
    RetailStoreCountryCenter oldCompany = this.company;
    RetailStoreCountryCenter newCompany = company;
    if (!shouldReplaceBy(newCompany, oldCompany)) {
      return this;
    }
    this.company = newCompany;
    if (cn.hutool.core.util.ObjectUtil.equals(newCompany, oldCompany)) {
      return this;
    }
    addPropertyChange(COMPANY_PROPERTY, oldCompany, newCompany);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public TrainingCourseType orderByCompany(boolean asc) {
    doAddOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMPANY_PROPERTY, operator, parameters);
  }

  public TrainingCourseType ignoreCompanyCriteria() {
    super.ignoreSearchProperty(COMPANY_PROPERTY);
    return this;
  }

  public TrainingCourseType addCompanyCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCompanyCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCompany(RetailStoreCountryCenter company) {
    if (company != null) {
      updateCompany(company);
    }
  }

  public TrainingCourseType updateCompanyByReferenceId(String companyId) {
    updateCompany(RetailStoreCountryCenter.refById(companyId));
    return this;
  }

  public void clearCompany() {
    setCompany(null);
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

  public TrainingCourseType updateName(String name) {
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

  public TrainingCourseType orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public TrainingCourseType ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public TrainingCourseType addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
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

  public TrainingCourseType updateDescription(String description) {
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

  public TrainingCourseType orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public TrainingCourseType ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public TrainingCourseType addDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDescription(String description) {
    if (description != null) {
      updateDescription(description);
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

  public TrainingCourseType updateVersion(int version) {
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

  public TrainingCourseType orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public TrainingCourseType ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public TrainingCourseType addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<CompanyTraining> getCompanyTrainingList() {
    if (this.mCompanyTrainingList == null) {
      this.mCompanyTrainingList = new SmartList<CompanyTraining>();
      this.mCompanyTrainingList.setListInternalName(COMPANY_TRAINING_LIST);
      // 有名字，便于做权限控制
    }

    return this.mCompanyTrainingList;
  }

  public SmartList<CompanyTraining> companyTrainingList() {

    doLoadChild(COMPANY_TRAINING_LIST);

    return getCompanyTrainingList();
  }

  public void setCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList) {
    for (CompanyTraining companyTraining : companyTrainingList) {
      companyTraining.setTrainingCourseType(this);
    }

    this.mCompanyTrainingList = companyTrainingList;
    this.mCompanyTrainingList.setListInternalName(COMPANY_TRAINING_LIST);
  }

  public TrainingCourseType addCompanyTraining(CompanyTraining companyTraining) {
    companyTraining.updateTrainingCourseType(this);
    getCompanyTrainingList().add(companyTraining);
    return this;
  }

  public TrainingCourseType addCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList) {
    for (CompanyTraining companyTraining : companyTrainingList) {
      companyTraining.updateTrainingCourseType(this);
    }

    Map<String, CompanyTraining> mapById = companyTrainingList.mapWithId();
    getCompanyTrainingList().removeIf(item -> mapById.get(item.getId()) != null);
    getCompanyTrainingList().addAll(companyTrainingList);
    return this;
  }

  public void mergeCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList) {
    if (companyTrainingList == null) {
      return;
    }
    if (companyTrainingList.isEmpty()) {
      return;
    }
    addCompanyTrainingList(companyTrainingList);
  }

  public CompanyTraining removeCompanyTraining(CompanyTraining companyTrainingIndex) {

    int index = getCompanyTrainingList().indexOf(companyTrainingIndex);
    if (index < 0) {
      String message =
          "CompanyTraining("
              + companyTrainingIndex.getId()
              + ") with version='"
              + companyTrainingIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    CompanyTraining companyTraining = getCompanyTrainingList().get(index);
    // companyTraining.clearTrainingCourseType(); //disconnect with TrainingCourseType
    companyTraining.clearFromAll(); // disconnect with TrainingCourseType

    boolean result = getCompanyTrainingList().planToRemove(companyTraining);
    if (!result) {
      String message =
          "CompanyTraining("
              + companyTrainingIndex.getId()
              + ") with version='"
              + companyTrainingIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return companyTraining;
  }
  // 断舍离
  public void breakWithCompanyTraining(CompanyTraining companyTraining) {

    if (companyTraining == null) {
      return;
    }
    companyTraining.setTrainingCourseType(null);
    // getCompanyTrainingList().remove();

  }

  public boolean hasCompanyTraining(CompanyTraining companyTraining) {

    return getCompanyTrainingList().contains(companyTraining);
  }

  public void copyCompanyTrainingFrom(CompanyTraining companyTraining) {

    CompanyTraining companyTrainingInList = findTheCompanyTraining(companyTraining);
    CompanyTraining newCompanyTraining = new CompanyTraining();
    companyTrainingInList.copyTo(newCompanyTraining);
    newCompanyTraining.setVersion(0); // will trigger copy
    getCompanyTrainingList().add(newCompanyTraining);
    addItemToFlexiableObject(COPIED_CHILD, newCompanyTraining);
  }

  public CompanyTraining findTheCompanyTraining(CompanyTraining companyTraining) {

    int index = getCompanyTrainingList().indexOf(companyTraining);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "CompanyTraining("
              + companyTraining.getId()
              + ") with version='"
              + companyTraining.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getCompanyTrainingList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpCompanyTrainingList() {
    getCompanyTrainingList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCompany(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getCompanyTrainingList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getCompanyTrainingList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, CODE_PROPERTY, getCode());
    appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, COMPANY_TRAINING_LIST, getCompanyTrainingList());
    if (!getCompanyTrainingList().isEmpty()) {
      appendKeyValuePair(result, "companyTrainingCount", getCompanyTrainingList().getTotalCount());
      appendKeyValuePair(
          result,
          "companyTrainingCurrentPageNumber",
          getCompanyTrainingList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof TrainingCourseType) {

      TrainingCourseType dest = (TrainingCourseType) baseDest;

      dest.setId(getId());
      dest.setCode(getCode());
      dest.setCompany(getCompany());
      dest.setName(getName());
      dest.setDescription(getDescription());
      dest.setVersion(getVersion());
      dest.setCompanyTrainingList(getCompanyTrainingList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof TrainingCourseType) {

      TrainingCourseType source = (TrainingCourseType) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeCompany(source.getCompany());
      mergeName(source.getName());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
      mergeCompanyTrainingList(source.getCompanyTrainingList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof TrainingCourseType) {

      TrainingCourseType source = (TrainingCourseType) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeName(source.getName());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getCode(), getCompany(), getName(), getDescription(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    TrainingCourseType checkTrainingCourseType =
        Q.trainingCourseTypeWithIdField()
            .filterById(id)
            .selectCompanyTrainingList(Q.companyTrainingWithIdField().limit(0, 1))
            .execute(ctx);

    return checkTrainingCourseType != null
        && !checkTrainingCourseType.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public TrainingCourseType save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("TrainingCourseType{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    if (getCompany() != null) {
      stringBuilder.append("\tcompany='RetailStoreCountryCenter(" + getCompany().getId() + ")';");
    }
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
