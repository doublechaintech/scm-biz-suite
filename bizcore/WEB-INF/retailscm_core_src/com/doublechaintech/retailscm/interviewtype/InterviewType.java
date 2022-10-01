package com.doublechaintech.retailscm.interviewtype;

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
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;

@JsonSerialize(using = InterviewTypeSerializer.class)
public class InterviewType extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(InterviewType target) {
    if (target == null) {
      return;
    }
    target.addEmployeeInterviewList(this.getEmployeeInterviewList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String CODE_PROPERTY = "code";
  public static final String COMPANY_PROPERTY = "company";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String DETAIL_DESCRIPTION_PROPERTY = "detailDescription";
  public static final String VERSION_PROPERTY = "version";

  public static final String EMPLOYEE_INTERVIEW_LIST = "employeeInterviewList";

  public static final String INTERNAL_TYPE = "InterviewType";

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
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DETAIL_DESCRIPTION_PROPERTY, "detail_description", "详细描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_INTERVIEW_LIST, "interviewType", "员工面试名单")
            .withType("employee_interview", EmployeeInterview.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      CODE_PROPERTY,
      COMPANY_PROPERTY,
      DESCRIPTION_PROPERTY,
      DETAIL_DESCRIPTION_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(EMPLOYEE_INTERVIEW_LIST, "interviewType");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(EMPLOYEE_INTERVIEW_LIST, EmployeeInterview.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }
  /*
  public InterviewType want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public InterviewType wants(Class<? extends BaseEntity>... classes) {
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
  protected String description;
  protected String detailDescription;
  protected int version;

  protected SmartList<EmployeeInterview> mEmployeeInterviewList;

  public InterviewType() {
    // lazy load for all the properties
  }

  public static InterviewType withId(String id) {
    InterviewType interviewType = new InterviewType();
    interviewType.setId(id);
    interviewType.setVersion(Integer.MAX_VALUE);
    interviewType.setChecked(true);
    return interviewType;
  }

  public static InterviewType refById(String id) {
    return withId(id);
  }

  public InterviewType limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public InterviewType limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static InterviewType searchExample() {
    InterviewType interviewType = new InterviewType();
    interviewType.setVersion(UNSET_INT);

    return interviewType;
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
    if (DESCRIPTION_PROPERTY.equals(property)) {
      changeDescriptionProperty(newValueExpr);
    }
    if (DETAIL_DESCRIPTION_PROPERTY.equals(property)) {
      changeDetailDescriptionProperty(newValueExpr);
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

  protected void changeDetailDescriptionProperty(String newValueExpr) {

    String oldValue = getDetailDescription();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDetailDescription(newValue);
    this.onChangeProperty(DETAIL_DESCRIPTION_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (CODE_PROPERTY.equals(property)) {
      return getCode();
    }
    if (COMPANY_PROPERTY.equals(property)) {
      return getCompany();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (DETAIL_DESCRIPTION_PROPERTY.equals(property)) {
      return getDetailDescription();
    }
    if (EMPLOYEE_INTERVIEW_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeInterviewList().stream().map(item -> item).collect(Collectors.toList());
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

  public InterviewType updateId(String id) {
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

  public InterviewType orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public InterviewType ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public InterviewType addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public InterviewType updateCode(String code) {
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

  public InterviewType orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public InterviewType ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public InterviewType addCodeCriteria(QueryOperator operator, Object... parameters) {
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

  public InterviewType updateCompany(RetailStoreCountryCenter company) {
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

  public InterviewType orderByCompany(boolean asc) {
    doAddOrderBy(COMPANY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMPANY_PROPERTY, operator, parameters);
  }

  public InterviewType ignoreCompanyCriteria() {
    super.ignoreSearchProperty(COMPANY_PROPERTY);
    return this;
  }

  public InterviewType addCompanyCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCompanyCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCompany(RetailStoreCountryCenter company) {
    if (company != null) {
      updateCompany(company);
    }
  }

  public InterviewType updateCompanyByReferenceId(String companyId) {
    updateCompany(RetailStoreCountryCenter.refById(companyId));
    return this;
  }

  public void clearCompany() {
    setCompany(null);
    this.changed = true;
    setChecked(false);
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

  public InterviewType updateDescription(String description) {
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

  public InterviewType orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public InterviewType ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public InterviewType addDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDescription(String description) {
    if (description != null) {
      updateDescription(description);
    }
  }

  public void setDetailDescription(String detailDescription) {
    String oldDetailDescription = this.detailDescription;
    String newDetailDescription = trimString(detailDescription);
    this.detailDescription = newDetailDescription;
  }

  public String detailDescription() {
    doLoad();
    return getDetailDescription();
  }

  public String getDetailDescription() {
    return this.detailDescription;
  }

  public InterviewType updateDetailDescription(String detailDescription) {
    String oldDetailDescription = this.detailDescription;
    String newDetailDescription = trimString(detailDescription);
    if (!shouldReplaceBy(newDetailDescription, oldDetailDescription)) {
      return this;
    }
    this.detailDescription = newDetailDescription;
    if (cn.hutool.core.util.ObjectUtil.equals(newDetailDescription, oldDetailDescription)) {
      return this;
    }
    addPropertyChange(DETAIL_DESCRIPTION_PROPERTY, oldDetailDescription, newDetailDescription);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public InterviewType orderByDetailDescription(boolean asc) {
    doAddOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDetailDescriptionCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(DETAIL_DESCRIPTION_PROPERTY, operator, parameters);
  }

  public InterviewType ignoreDetailDescriptionCriteria() {
    super.ignoreSearchProperty(DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public InterviewType addDetailDescriptionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDetailDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDetailDescription(String detailDescription) {
    if (detailDescription != null) {
      updateDetailDescription(detailDescription);
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

  public InterviewType updateVersion(int version) {
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

  public InterviewType orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public InterviewType ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public InterviewType addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<EmployeeInterview> getEmployeeInterviewList() {
    if (this.mEmployeeInterviewList == null) {
      this.mEmployeeInterviewList = new SmartList<EmployeeInterview>();
      this.mEmployeeInterviewList.setListInternalName(EMPLOYEE_INTERVIEW_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEmployeeInterviewList;
  }

  public SmartList<EmployeeInterview> employeeInterviewList() {

    doLoadChild(EMPLOYEE_INTERVIEW_LIST);

    return getEmployeeInterviewList();
  }

  public void setEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList) {
    for (EmployeeInterview employeeInterview : employeeInterviewList) {
      employeeInterview.setInterviewType(this);
    }

    this.mEmployeeInterviewList = employeeInterviewList;
    this.mEmployeeInterviewList.setListInternalName(EMPLOYEE_INTERVIEW_LIST);
  }

  public InterviewType addEmployeeInterview(EmployeeInterview employeeInterview) {
    employeeInterview.updateInterviewType(this);
    getEmployeeInterviewList().add(employeeInterview);
    return this;
  }

  public InterviewType addEmployeeInterviewList(
      SmartList<EmployeeInterview> employeeInterviewList) {
    for (EmployeeInterview employeeInterview : employeeInterviewList) {
      employeeInterview.updateInterviewType(this);
    }

    Map<String, EmployeeInterview> mapById = employeeInterviewList.mapWithId();
    getEmployeeInterviewList().removeIf(item -> mapById.get(item.getId()) != null);
    getEmployeeInterviewList().addAll(employeeInterviewList);
    return this;
  }

  public void mergeEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList) {
    if (employeeInterviewList == null) {
      return;
    }
    if (employeeInterviewList.isEmpty()) {
      return;
    }
    addEmployeeInterviewList(employeeInterviewList);
  }

  public EmployeeInterview removeEmployeeInterview(EmployeeInterview employeeInterviewIndex) {

    int index = getEmployeeInterviewList().indexOf(employeeInterviewIndex);
    if (index < 0) {
      String message =
          "EmployeeInterview("
              + employeeInterviewIndex.getId()
              + ") with version='"
              + employeeInterviewIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    EmployeeInterview employeeInterview = getEmployeeInterviewList().get(index);
    // employeeInterview.clearInterviewType(); //disconnect with InterviewType
    employeeInterview.clearFromAll(); // disconnect with InterviewType

    boolean result = getEmployeeInterviewList().planToRemove(employeeInterview);
    if (!result) {
      String message =
          "EmployeeInterview("
              + employeeInterviewIndex.getId()
              + ") with version='"
              + employeeInterviewIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return employeeInterview;
  }
  // 断舍离
  public void breakWithEmployeeInterview(EmployeeInterview employeeInterview) {

    if (employeeInterview == null) {
      return;
    }
    employeeInterview.setInterviewType(null);
    // getEmployeeInterviewList().remove();

  }

  public boolean hasEmployeeInterview(EmployeeInterview employeeInterview) {

    return getEmployeeInterviewList().contains(employeeInterview);
  }

  public void copyEmployeeInterviewFrom(EmployeeInterview employeeInterview) {

    EmployeeInterview employeeInterviewInList = findTheEmployeeInterview(employeeInterview);
    EmployeeInterview newEmployeeInterview = new EmployeeInterview();
    employeeInterviewInList.copyTo(newEmployeeInterview);
    newEmployeeInterview.setVersion(0); // will trigger copy
    getEmployeeInterviewList().add(newEmployeeInterview);
    addItemToFlexiableObject(COPIED_CHILD, newEmployeeInterview);
  }

  public EmployeeInterview findTheEmployeeInterview(EmployeeInterview employeeInterview) {

    int index = getEmployeeInterviewList().indexOf(employeeInterview);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "EmployeeInterview("
              + employeeInterview.getId()
              + ") with version='"
              + employeeInterview.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEmployeeInterviewList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEmployeeInterviewList() {
    getEmployeeInterviewList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getCompany(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getEmployeeInterviewList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getEmployeeInterviewList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, CODE_PROPERTY, getCode());
    appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, DETAIL_DESCRIPTION_PROPERTY, getDetailDescription());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, EMPLOYEE_INTERVIEW_LIST, getEmployeeInterviewList());
    if (!getEmployeeInterviewList().isEmpty()) {
      appendKeyValuePair(
          result, "employeeInterviewCount", getEmployeeInterviewList().getTotalCount());
      appendKeyValuePair(
          result,
          "employeeInterviewCurrentPageNumber",
          getEmployeeInterviewList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof InterviewType) {

      InterviewType dest = (InterviewType) baseDest;

      dest.setId(getId());
      dest.setCode(getCode());
      dest.setCompany(getCompany());
      dest.setDescription(getDescription());
      dest.setDetailDescription(getDetailDescription());
      dest.setVersion(getVersion());
      dest.setEmployeeInterviewList(getEmployeeInterviewList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof InterviewType) {

      InterviewType source = (InterviewType) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeCompany(source.getCompany());
      mergeDescription(source.getDescription());
      mergeDetailDescription(source.getDetailDescription());
      mergeVersion(source.getVersion());
      mergeEmployeeInterviewList(source.getEmployeeInterviewList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof InterviewType) {

      InterviewType source = (InterviewType) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeDescription(source.getDescription());
      mergeDetailDescription(source.getDetailDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getCode(), getCompany(), getDescription(), getDetailDescription(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    InterviewType checkInterviewType =
        Q.interviewTypeWithIdField()
            .filterById(id)
            .selectEmployeeInterviewList(Q.employeeInterviewWithIdField().limit(0, 1))
            .execute(ctx);

    return checkInterviewType != null
        && !checkInterviewType.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public InterviewType save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("InterviewType{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    if (getCompany() != null) {
      stringBuilder.append("\tcompany='RetailStoreCountryCenter(" + getCompany().getId() + ")';");
    }
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tdetailDescription='" + getDetailDescription() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
