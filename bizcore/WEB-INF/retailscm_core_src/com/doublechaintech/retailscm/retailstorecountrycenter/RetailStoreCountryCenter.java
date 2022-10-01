package com.doublechaintech.retailscm.retailstorecountrycenter;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.accountset.AccountSet;

@JsonSerialize(using = RetailStoreCountryCenterSerializer.class)
public class RetailStoreCountryCenter extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(RetailStoreCountryCenter target) {
    if (target == null) {
      return;
    }
    target.addCatalogList(this.getCatalogList());
    target.addRetailStoreProvinceCenterList(this.getRetailStoreProvinceCenterList());
    target.addRetailStoreList(this.getRetailStoreList());
    target.addRetailStoreMemberList(this.getRetailStoreMemberList());
    target.addGoodsSupplierList(this.getGoodsSupplierList());
    target.addSupplyOrderList(this.getSupplyOrderList());
    target.addRetailStoreOrderList(this.getRetailStoreOrderList());
    target.addWarehouseList(this.getWarehouseList());
    target.addTransportFleetList(this.getTransportFleetList());
    target.addAccountSetList(this.getAccountSetList());
    target.addLevelOneDepartmentList(this.getLevelOneDepartmentList());
    target.addSkillTypeList(this.getSkillTypeList());
    target.addResponsibilityTypeList(this.getResponsibilityTypeList());
    target.addTerminationReasonList(this.getTerminationReasonList());
    target.addTerminationTypeList(this.getTerminationTypeList());
    target.addOccupationTypeList(this.getOccupationTypeList());
    target.addLeaveTypeList(this.getLeaveTypeList());
    target.addSalaryGradeList(this.getSalaryGradeList());
    target.addInterviewTypeList(this.getInterviewTypeList());
    target.addTrainingCourseTypeList(this.getTrainingCourseTypeList());
    target.addPublicHolidayList(this.getPublicHolidayList());
    target.addEmployeeList(this.getEmployeeList());
    target.addInstructorList(this.getInstructorList());
    target.addCompanyTrainingList(this.getCompanyTrainingList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String SERVICE_NUMBER_PROPERTY = "serviceNumber";
  public static final String FOUNDED_PROPERTY = "founded";
  public static final String WEB_SITE_PROPERTY = "webSite";
  public static final String ADDRESS_PROPERTY = "address";
  public static final String OPERATED_BY_PROPERTY = "operatedBy";
  public static final String LEGAL_REPRESENTATIVE_PROPERTY = "legalRepresentative";
  public static final String DESCRIPTION_PROPERTY = "description";
  public static final String VERSION_PROPERTY = "version";

  public static final String CATALOG_LIST = "catalogList";
  public static final String RETAIL_STORE_PROVINCE_CENTER_LIST = "retailStoreProvinceCenterList";
  public static final String RETAIL_STORE_LIST = "retailStoreList";
  public static final String RETAIL_STORE_MEMBER_LIST = "retailStoreMemberList";
  public static final String GOODS_SUPPLIER_LIST = "goodsSupplierList";
  public static final String SUPPLY_ORDER_LIST = "supplyOrderList";
  public static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
  public static final String WAREHOUSE_LIST = "warehouseList";
  public static final String TRANSPORT_FLEET_LIST = "transportFleetList";
  public static final String ACCOUNT_SET_LIST = "accountSetList";
  public static final String LEVEL_ONE_DEPARTMENT_LIST = "levelOneDepartmentList";
  public static final String SKILL_TYPE_LIST = "skillTypeList";
  public static final String RESPONSIBILITY_TYPE_LIST = "responsibilityTypeList";
  public static final String TERMINATION_REASON_LIST = "terminationReasonList";
  public static final String TERMINATION_TYPE_LIST = "terminationTypeList";
  public static final String OCCUPATION_TYPE_LIST = "occupationTypeList";
  public static final String LEAVE_TYPE_LIST = "leaveTypeList";
  public static final String SALARY_GRADE_LIST = "salaryGradeList";
  public static final String INTERVIEW_TYPE_LIST = "interviewTypeList";
  public static final String TRAINING_COURSE_TYPE_LIST = "trainingCourseTypeList";
  public static final String PUBLIC_HOLIDAY_LIST = "publicHolidayList";
  public static final String EMPLOYEE_LIST = "employeeList";
  public static final String INSTRUCTOR_LIST = "instructorList";
  public static final String COMPANY_TRAINING_LIST = "companyTrainingList";

  public static final String INTERNAL_TYPE = "RetailStoreCountryCenter";

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
        MemberMetaInfo.defineBy(SERVICE_NUMBER_PROPERTY, "service_number", "服务号码")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FOUNDED_PROPERTY, "founded", "成立").withType("date_past", "Date"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(WEB_SITE_PROPERTY, "web_site", "网站")
            .withType("string_url", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ADDRESS_PROPERTY, "address", "地址")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(OPERATED_BY_PROPERTY, "operated_by", "由")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LEGAL_REPRESENTATIVE_PROPERTY, "legal_representative", "法定代表人")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(CATALOG_LIST, "owner", "目录列表").withType("catalog", Catalog.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(RETAIL_STORE_PROVINCE_CENTER_LIST, "country", "零售门店省中心名单")
            .withType("retail_store_province_center", RetailStoreProvinceCenter.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(RETAIL_STORE_LIST, "retailStoreCountryCenter", "零售门店列表")
            .withType("retail_store", RetailStore.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(RETAIL_STORE_MEMBER_LIST, "owner", "零售店会员名单")
            .withType("retail_store_member", RetailStoreMember.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(GOODS_SUPPLIER_LIST, "belongTo", "货物供应商列表")
            .withType("goods_supplier", GoodsSupplier.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(SUPPLY_ORDER_LIST, "buyer", "供应订单列表")
            .withType("supply_order", SupplyOrder.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(RETAIL_STORE_ORDER_LIST, "seller", "零售店订购单")
            .withType("retail_store_order", RetailStoreOrder.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(WAREHOUSE_LIST, "owner", "仓库列表")
            .withType("warehouse", Warehouse.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(TRANSPORT_FLEET_LIST, "owner", "运输舰队列表")
            .withType("transport_fleet", TransportFleet.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(ACCOUNT_SET_LIST, "countryCenter", "帐户设置列表")
            .withType("account_set", AccountSet.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(LEVEL_ONE_DEPARTMENT_LIST, "belongsTo", "一级部门名单")
            .withType("level_one_department", LevelOneDepartment.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(SKILL_TYPE_LIST, "company", "技能类型列表")
            .withType("skill_type", SkillType.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(RESPONSIBILITY_TYPE_LIST, "company", "责任类型列表")
            .withType("responsibility_type", ResponsibilityType.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(TERMINATION_REASON_LIST, "company", "终止原因列表")
            .withType("termination_reason", TerminationReason.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(TERMINATION_TYPE_LIST, "company", "终止类型列表")
            .withType("termination_type", TerminationType.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(OCCUPATION_TYPE_LIST, "company", "职业类型列表")
            .withType("occupation_type", OccupationType.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(LEAVE_TYPE_LIST, "company", "离开类型列表")
            .withType("leave_type", LeaveType.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(SALARY_GRADE_LIST, "company", "工资等级表")
            .withType("salary_grade", SalaryGrade.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(INTERVIEW_TYPE_LIST, "company", "面试类型列表")
            .withType("interview_type", InterviewType.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(TRAINING_COURSE_TYPE_LIST, "company", "培训课程类别表")
            .withType("training_course_type", TrainingCourseType.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(PUBLIC_HOLIDAY_LIST, "company", "公共假期列表")
            .withType("public_holiday", PublicHoliday.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_LIST, "company", "员工列表")
            .withType("employee", Employee.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(INSTRUCTOR_LIST, "company", "导师名单")
            .withType("instructor", Instructor.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(COMPANY_TRAINING_LIST, "company", "公司培训名单")
            .withType("company_training", CompanyTraining.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      SERVICE_NUMBER_PROPERTY,
      FOUNDED_PROPERTY,
      WEB_SITE_PROPERTY,
      ADDRESS_PROPERTY,
      OPERATED_BY_PROPERTY,
      LEGAL_REPRESENTATIVE_PROPERTY,
      DESCRIPTION_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(CATALOG_LIST, "owner");

    refers.put(RETAIL_STORE_PROVINCE_CENTER_LIST, "country");

    refers.put(RETAIL_STORE_LIST, "retailStoreCountryCenter");

    refers.put(RETAIL_STORE_MEMBER_LIST, "owner");

    refers.put(GOODS_SUPPLIER_LIST, "belongTo");

    refers.put(SUPPLY_ORDER_LIST, "buyer");

    refers.put(RETAIL_STORE_ORDER_LIST, "seller");

    refers.put(WAREHOUSE_LIST, "owner");

    refers.put(TRANSPORT_FLEET_LIST, "owner");

    refers.put(ACCOUNT_SET_LIST, "countryCenter");

    refers.put(LEVEL_ONE_DEPARTMENT_LIST, "belongsTo");

    refers.put(SKILL_TYPE_LIST, "company");

    refers.put(RESPONSIBILITY_TYPE_LIST, "company");

    refers.put(TERMINATION_REASON_LIST, "company");

    refers.put(TERMINATION_TYPE_LIST, "company");

    refers.put(OCCUPATION_TYPE_LIST, "company");

    refers.put(LEAVE_TYPE_LIST, "company");

    refers.put(SALARY_GRADE_LIST, "company");

    refers.put(INTERVIEW_TYPE_LIST, "company");

    refers.put(TRAINING_COURSE_TYPE_LIST, "company");

    refers.put(PUBLIC_HOLIDAY_LIST, "company");

    refers.put(EMPLOYEE_LIST, "company");

    refers.put(INSTRUCTOR_LIST, "company");

    refers.put(COMPANY_TRAINING_LIST, "company");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(CATALOG_LIST, Catalog.class);

    refers.put(RETAIL_STORE_PROVINCE_CENTER_LIST, RetailStoreProvinceCenter.class);

    refers.put(RETAIL_STORE_LIST, RetailStore.class);

    refers.put(RETAIL_STORE_MEMBER_LIST, RetailStoreMember.class);

    refers.put(GOODS_SUPPLIER_LIST, GoodsSupplier.class);

    refers.put(SUPPLY_ORDER_LIST, SupplyOrder.class);

    refers.put(RETAIL_STORE_ORDER_LIST, RetailStoreOrder.class);

    refers.put(WAREHOUSE_LIST, Warehouse.class);

    refers.put(TRANSPORT_FLEET_LIST, TransportFleet.class);

    refers.put(ACCOUNT_SET_LIST, AccountSet.class);

    refers.put(LEVEL_ONE_DEPARTMENT_LIST, LevelOneDepartment.class);

    refers.put(SKILL_TYPE_LIST, SkillType.class);

    refers.put(RESPONSIBILITY_TYPE_LIST, ResponsibilityType.class);

    refers.put(TERMINATION_REASON_LIST, TerminationReason.class);

    refers.put(TERMINATION_TYPE_LIST, TerminationType.class);

    refers.put(OCCUPATION_TYPE_LIST, OccupationType.class);

    refers.put(LEAVE_TYPE_LIST, LeaveType.class);

    refers.put(SALARY_GRADE_LIST, SalaryGrade.class);

    refers.put(INTERVIEW_TYPE_LIST, InterviewType.class);

    refers.put(TRAINING_COURSE_TYPE_LIST, TrainingCourseType.class);

    refers.put(PUBLIC_HOLIDAY_LIST, PublicHoliday.class);

    refers.put(EMPLOYEE_LIST, Employee.class);

    refers.put(INSTRUCTOR_LIST, Instructor.class);

    refers.put(COMPANY_TRAINING_LIST, CompanyTraining.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();

    return parents;
  }
  /*
  public RetailStoreCountryCenter want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreCountryCenter wants(Class<? extends BaseEntity>... classes) {
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
  protected String serviceNumber;
  protected Date founded;
  protected String webSite;
  protected String address;
  protected String operatedBy;
  protected String legalRepresentative;
  protected String description;
  protected int version;

  protected SmartList<Catalog> mCatalogList;
  protected SmartList<RetailStoreProvinceCenter> mRetailStoreProvinceCenterList;
  protected SmartList<RetailStore> mRetailStoreList;
  protected SmartList<RetailStoreMember> mRetailStoreMemberList;
  protected SmartList<GoodsSupplier> mGoodsSupplierList;
  protected SmartList<SupplyOrder> mSupplyOrderList;
  protected SmartList<RetailStoreOrder> mRetailStoreOrderList;
  protected SmartList<Warehouse> mWarehouseList;
  protected SmartList<TransportFleet> mTransportFleetList;
  protected SmartList<AccountSet> mAccountSetList;
  protected SmartList<LevelOneDepartment> mLevelOneDepartmentList;
  protected SmartList<SkillType> mSkillTypeList;
  protected SmartList<ResponsibilityType> mResponsibilityTypeList;
  protected SmartList<TerminationReason> mTerminationReasonList;
  protected SmartList<TerminationType> mTerminationTypeList;
  protected SmartList<OccupationType> mOccupationTypeList;
  protected SmartList<LeaveType> mLeaveTypeList;
  protected SmartList<SalaryGrade> mSalaryGradeList;
  protected SmartList<InterviewType> mInterviewTypeList;
  protected SmartList<TrainingCourseType> mTrainingCourseTypeList;
  protected SmartList<PublicHoliday> mPublicHolidayList;
  protected SmartList<Employee> mEmployeeList;
  protected SmartList<Instructor> mInstructorList;
  protected SmartList<CompanyTraining> mCompanyTrainingList;

  public RetailStoreCountryCenter() {
    // lazy load for all the properties
  }

  public static RetailStoreCountryCenter withId(String id) {
    RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
    retailStoreCountryCenter.setId(id);
    retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
    retailStoreCountryCenter.setChecked(true);
    return retailStoreCountryCenter;
  }

  public static RetailStoreCountryCenter refById(String id) {
    return withId(id);
  }

  public RetailStoreCountryCenter limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreCountryCenter limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreCountryCenter searchExample() {
    RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
    retailStoreCountryCenter.setVersion(UNSET_INT);

    return retailStoreCountryCenter;
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
    if (SERVICE_NUMBER_PROPERTY.equals(property)) {
      changeServiceNumberProperty(newValueExpr);
    }
    if (FOUNDED_PROPERTY.equals(property)) {
      changeFoundedProperty(newValueExpr);
    }
    if (WEB_SITE_PROPERTY.equals(property)) {
      changeWebSiteProperty(newValueExpr);
    }
    if (ADDRESS_PROPERTY.equals(property)) {
      changeAddressProperty(newValueExpr);
    }
    if (OPERATED_BY_PROPERTY.equals(property)) {
      changeOperatedByProperty(newValueExpr);
    }
    if (LEGAL_REPRESENTATIVE_PROPERTY.equals(property)) {
      changeLegalRepresentativeProperty(newValueExpr);
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      changeDescriptionProperty(newValueExpr);
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

  protected void changeServiceNumberProperty(String newValueExpr) {

    String oldValue = getServiceNumber();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateServiceNumber(newValue);
    this.onChangeProperty(SERVICE_NUMBER_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeFoundedProperty(String newValueExpr) {

    Date oldValue = getFounded();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateFounded(newValue);
    this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeWebSiteProperty(String newValueExpr) {

    String oldValue = getWebSite();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateWebSite(newValue);
    this.onChangeProperty(WEB_SITE_PROPERTY, oldValue, newValue);
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

  protected void changeOperatedByProperty(String newValueExpr) {

    String oldValue = getOperatedBy();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateOperatedBy(newValue);
    this.onChangeProperty(OPERATED_BY_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLegalRepresentativeProperty(String newValueExpr) {

    String oldValue = getLegalRepresentative();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLegalRepresentative(newValue);
    this.onChangeProperty(LEGAL_REPRESENTATIVE_PROPERTY, oldValue, newValue);
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

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (SERVICE_NUMBER_PROPERTY.equals(property)) {
      return getServiceNumber();
    }
    if (FOUNDED_PROPERTY.equals(property)) {
      return getFounded();
    }
    if (WEB_SITE_PROPERTY.equals(property)) {
      return getWebSite();
    }
    if (ADDRESS_PROPERTY.equals(property)) {
      return getAddress();
    }
    if (OPERATED_BY_PROPERTY.equals(property)) {
      return getOperatedBy();
    }
    if (LEGAL_REPRESENTATIVE_PROPERTY.equals(property)) {
      return getLegalRepresentative();
    }
    if (DESCRIPTION_PROPERTY.equals(property)) {
      return getDescription();
    }
    if (CATALOG_LIST.equals(property)) {
      List<BaseEntity> list =
          getCatalogList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (RETAIL_STORE_PROVINCE_CENTER_LIST.equals(property)) {
      List<BaseEntity> list =
          getRetailStoreProvinceCenterList().stream()
              .map(item -> item)
              .collect(Collectors.toList());
      return list;
    }
    if (RETAIL_STORE_LIST.equals(property)) {
      List<BaseEntity> list =
          getRetailStoreList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (RETAIL_STORE_MEMBER_LIST.equals(property)) {
      List<BaseEntity> list =
          getRetailStoreMemberList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (GOODS_SUPPLIER_LIST.equals(property)) {
      List<BaseEntity> list =
          getGoodsSupplierList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (SUPPLY_ORDER_LIST.equals(property)) {
      List<BaseEntity> list =
          getSupplyOrderList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (RETAIL_STORE_ORDER_LIST.equals(property)) {
      List<BaseEntity> list =
          getRetailStoreOrderList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (WAREHOUSE_LIST.equals(property)) {
      List<BaseEntity> list =
          getWarehouseList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (TRANSPORT_FLEET_LIST.equals(property)) {
      List<BaseEntity> list =
          getTransportFleetList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (ACCOUNT_SET_LIST.equals(property)) {
      List<BaseEntity> list =
          getAccountSetList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (LEVEL_ONE_DEPARTMENT_LIST.equals(property)) {
      List<BaseEntity> list =
          getLevelOneDepartmentList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (SKILL_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getSkillTypeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (RESPONSIBILITY_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getResponsibilityTypeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (TERMINATION_REASON_LIST.equals(property)) {
      List<BaseEntity> list =
          getTerminationReasonList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (TERMINATION_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getTerminationTypeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (OCCUPATION_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getOccupationTypeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (LEAVE_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getLeaveTypeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (SALARY_GRADE_LIST.equals(property)) {
      List<BaseEntity> list =
          getSalaryGradeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (INTERVIEW_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getInterviewTypeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (TRAINING_COURSE_TYPE_LIST.equals(property)) {
      List<BaseEntity> list =
          getTrainingCourseTypeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (PUBLIC_HOLIDAY_LIST.equals(property)) {
      List<BaseEntity> list =
          getPublicHolidayList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (EMPLOYEE_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (INSTRUCTOR_LIST.equals(property)) {
      List<BaseEntity> list =
          getInstructorList().stream().map(item -> item).collect(Collectors.toList());
      return list;
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

  public RetailStoreCountryCenter updateId(String id) {
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

  public RetailStoreCountryCenter orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addIdCriteria(QueryOperator operator, Object... parameters) {
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

  public RetailStoreCountryCenter updateName(String name) {
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

  public RetailStoreCountryCenter orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setServiceNumber(String serviceNumber) {
    String oldServiceNumber = this.serviceNumber;
    String newServiceNumber = trimString(serviceNumber);
    this.serviceNumber = newServiceNumber;
  }

  public String serviceNumber() {
    doLoad();
    return getServiceNumber();
  }

  public String getServiceNumber() {
    return this.serviceNumber;
  }

  public RetailStoreCountryCenter updateServiceNumber(String serviceNumber) {
    String oldServiceNumber = this.serviceNumber;
    String newServiceNumber = trimString(serviceNumber);
    if (!shouldReplaceBy(newServiceNumber, oldServiceNumber)) {
      return this;
    }
    this.serviceNumber = newServiceNumber;
    if (cn.hutool.core.util.ObjectUtil.equals(newServiceNumber, oldServiceNumber)) {
      return this;
    }
    addPropertyChange(SERVICE_NUMBER_PROPERTY, oldServiceNumber, newServiceNumber);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreCountryCenter orderByServiceNumber(boolean asc) {
    doAddOrderBy(SERVICE_NUMBER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createServiceNumberCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SERVICE_NUMBER_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreServiceNumberCriteria() {
    super.ignoreSearchProperty(SERVICE_NUMBER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addServiceNumberCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createServiceNumberCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeServiceNumber(String serviceNumber) {
    if (serviceNumber != null) {
      updateServiceNumber(serviceNumber);
    }
  }

  public void setFounded(Date founded) {
    Date oldFounded = this.founded;
    Date newFounded = founded;
    this.founded = newFounded;
  }

  public Date founded() {
    doLoad();
    return getFounded();
  }

  public Date getFounded() {
    return this.founded;
  }

  public RetailStoreCountryCenter updateFounded(Date founded) {
    Date oldFounded = this.founded;
    Date newFounded = founded;
    if (!shouldReplaceBy(newFounded, oldFounded)) {
      return this;
    }
    this.founded = newFounded;
    if (cn.hutool.core.util.ObjectUtil.equals(newFounded, oldFounded)) {
      return this;
    }
    addPropertyChange(FOUNDED_PROPERTY, oldFounded, newFounded);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreCountryCenter orderByFounded(boolean asc) {
    doAddOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFoundedCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FOUNDED_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreFoundedCriteria() {
    super.ignoreSearchProperty(FOUNDED_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addFoundedCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFoundedCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFounded(Date founded) {
    updateFounded(founded);
  }

  public void setWebSite(String webSite) {
    String oldWebSite = this.webSite;
    String newWebSite = trimString(encodeUrl(webSite));
    ;
    this.webSite = newWebSite;
  }

  public String webSite() {
    doLoad();
    return getWebSite();
  }

  public String getWebSite() {
    return this.webSite;
  }

  public RetailStoreCountryCenter updateWebSite(String webSite) {
    String oldWebSite = this.webSite;
    String newWebSite = trimString(encodeUrl(webSite));
    ;
    if (!shouldReplaceBy(newWebSite, oldWebSite)) {
      return this;
    }
    this.webSite = newWebSite;
    if (cn.hutool.core.util.ObjectUtil.equals(newWebSite, oldWebSite)) {
      return this;
    }
    addPropertyChange(WEB_SITE_PROPERTY, oldWebSite, newWebSite);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreCountryCenter orderByWebSite(boolean asc) {
    doAddOrderBy(WEB_SITE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createWebSiteCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(WEB_SITE_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreWebSiteCriteria() {
    super.ignoreSearchProperty(WEB_SITE_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addWebSiteCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createWebSiteCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeWebSite(String webSite) {
    if (webSite != null) {
      updateWebSite(webSite);
    }
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

  public RetailStoreCountryCenter updateAddress(String address) {
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

  public RetailStoreCountryCenter orderByAddress(boolean asc) {
    doAddOrderBy(ADDRESS_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAddressCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ADDRESS_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreAddressCriteria() {
    super.ignoreSearchProperty(ADDRESS_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addAddressCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAddressCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAddress(String address) {
    if (address != null) {
      updateAddress(address);
    }
  }

  public void setOperatedBy(String operatedBy) {
    String oldOperatedBy = this.operatedBy;
    String newOperatedBy = trimString(operatedBy);
    this.operatedBy = newOperatedBy;
  }

  public String operatedBy() {
    doLoad();
    return getOperatedBy();
  }

  public String getOperatedBy() {
    return this.operatedBy;
  }

  public RetailStoreCountryCenter updateOperatedBy(String operatedBy) {
    String oldOperatedBy = this.operatedBy;
    String newOperatedBy = trimString(operatedBy);
    if (!shouldReplaceBy(newOperatedBy, oldOperatedBy)) {
      return this;
    }
    this.operatedBy = newOperatedBy;
    if (cn.hutool.core.util.ObjectUtil.equals(newOperatedBy, oldOperatedBy)) {
      return this;
    }
    addPropertyChange(OPERATED_BY_PROPERTY, oldOperatedBy, newOperatedBy);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreCountryCenter orderByOperatedBy(boolean asc) {
    doAddOrderBy(OPERATED_BY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createOperatedByCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(OPERATED_BY_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreOperatedByCriteria() {
    super.ignoreSearchProperty(OPERATED_BY_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addOperatedByCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createOperatedByCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeOperatedBy(String operatedBy) {
    if (operatedBy != null) {
      updateOperatedBy(operatedBy);
    }
  }

  public void setLegalRepresentative(String legalRepresentative) {
    String oldLegalRepresentative = this.legalRepresentative;
    String newLegalRepresentative = trimString(legalRepresentative);
    this.legalRepresentative = newLegalRepresentative;
  }

  public String legalRepresentative() {
    doLoad();
    return getLegalRepresentative();
  }

  public String getLegalRepresentative() {
    return this.legalRepresentative;
  }

  public RetailStoreCountryCenter updateLegalRepresentative(String legalRepresentative) {
    String oldLegalRepresentative = this.legalRepresentative;
    String newLegalRepresentative = trimString(legalRepresentative);
    if (!shouldReplaceBy(newLegalRepresentative, oldLegalRepresentative)) {
      return this;
    }
    this.legalRepresentative = newLegalRepresentative;
    if (cn.hutool.core.util.ObjectUtil.equals(newLegalRepresentative, oldLegalRepresentative)) {
      return this;
    }
    addPropertyChange(
        LEGAL_REPRESENTATIVE_PROPERTY, oldLegalRepresentative, newLegalRepresentative);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public RetailStoreCountryCenter orderByLegalRepresentative(boolean asc) {
    doAddOrderBy(LEGAL_REPRESENTATIVE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLegalRepresentativeCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(LEGAL_REPRESENTATIVE_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreLegalRepresentativeCriteria() {
    super.ignoreSearchProperty(LEGAL_REPRESENTATIVE_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addLegalRepresentativeCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLegalRepresentativeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLegalRepresentative(String legalRepresentative) {
    if (legalRepresentative != null) {
      updateLegalRepresentative(legalRepresentative);
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

  public RetailStoreCountryCenter updateDescription(String description) {
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

  public RetailStoreCountryCenter orderByDescription(boolean asc) {
    doAddOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreDescriptionCriteria() {
    super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addDescriptionCriteria(
      QueryOperator operator, Object... parameters) {
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

  public RetailStoreCountryCenter updateVersion(int version) {
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

  public RetailStoreCountryCenter orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public RetailStoreCountryCenter ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenter addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<Catalog> getCatalogList() {
    if (this.mCatalogList == null) {
      this.mCatalogList = new SmartList<Catalog>();
      this.mCatalogList.setListInternalName(CATALOG_LIST);
      // 有名字，便于做权限控制
    }

    return this.mCatalogList;
  }

  public SmartList<Catalog> catalogList() {

    doLoadChild(CATALOG_LIST);

    return getCatalogList();
  }

  public void setCatalogList(SmartList<Catalog> catalogList) {
    for (Catalog catalog : catalogList) {
      catalog.setOwner(this);
    }

    this.mCatalogList = catalogList;
    this.mCatalogList.setListInternalName(CATALOG_LIST);
  }

  public RetailStoreCountryCenter addCatalog(Catalog catalog) {
    catalog.updateOwner(this);
    getCatalogList().add(catalog);
    return this;
  }

  public RetailStoreCountryCenter addCatalogList(SmartList<Catalog> catalogList) {
    for (Catalog catalog : catalogList) {
      catalog.updateOwner(this);
    }

    Map<String, Catalog> mapById = catalogList.mapWithId();
    getCatalogList().removeIf(item -> mapById.get(item.getId()) != null);
    getCatalogList().addAll(catalogList);
    return this;
  }

  public void mergeCatalogList(SmartList<Catalog> catalogList) {
    if (catalogList == null) {
      return;
    }
    if (catalogList.isEmpty()) {
      return;
    }
    addCatalogList(catalogList);
  }

  public Catalog removeCatalog(Catalog catalogIndex) {

    int index = getCatalogList().indexOf(catalogIndex);
    if (index < 0) {
      String message =
          "Catalog("
              + catalogIndex.getId()
              + ") with version='"
              + catalogIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Catalog catalog = getCatalogList().get(index);
    // catalog.clearOwner(); //disconnect with Owner
    catalog.clearFromAll(); // disconnect with Owner

    boolean result = getCatalogList().planToRemove(catalog);
    if (!result) {
      String message =
          "Catalog("
              + catalogIndex.getId()
              + ") with version='"
              + catalogIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return catalog;
  }
  // 断舍离
  public void breakWithCatalog(Catalog catalog) {

    if (catalog == null) {
      return;
    }
    catalog.setOwner(null);
    // getCatalogList().remove();

  }

  public boolean hasCatalog(Catalog catalog) {

    return getCatalogList().contains(catalog);
  }

  public void copyCatalogFrom(Catalog catalog) {

    Catalog catalogInList = findTheCatalog(catalog);
    Catalog newCatalog = new Catalog();
    catalogInList.copyTo(newCatalog);
    newCatalog.setVersion(0); // will trigger copy
    getCatalogList().add(newCatalog);
    addItemToFlexiableObject(COPIED_CHILD, newCatalog);
  }

  public Catalog findTheCatalog(Catalog catalog) {

    int index = getCatalogList().indexOf(catalog);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Catalog(" + catalog.getId() + ") with version='" + catalog.getVersion() + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getCatalogList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpCatalogList() {
    getCatalogList().clear();
  }

  public SmartList<RetailStoreProvinceCenter> getRetailStoreProvinceCenterList() {
    if (this.mRetailStoreProvinceCenterList == null) {
      this.mRetailStoreProvinceCenterList = new SmartList<RetailStoreProvinceCenter>();
      this.mRetailStoreProvinceCenterList.setListInternalName(RETAIL_STORE_PROVINCE_CENTER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mRetailStoreProvinceCenterList;
  }

  public SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList() {

    doLoadChild(RETAIL_STORE_PROVINCE_CENTER_LIST);

    return getRetailStoreProvinceCenterList();
  }

  public void setRetailStoreProvinceCenterList(
      SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList) {
    for (RetailStoreProvinceCenter retailStoreProvinceCenter : retailStoreProvinceCenterList) {
      retailStoreProvinceCenter.setCountry(this);
    }

    this.mRetailStoreProvinceCenterList = retailStoreProvinceCenterList;
    this.mRetailStoreProvinceCenterList.setListInternalName(RETAIL_STORE_PROVINCE_CENTER_LIST);
  }

  public RetailStoreCountryCenter addRetailStoreProvinceCenter(
      RetailStoreProvinceCenter retailStoreProvinceCenter) {
    retailStoreProvinceCenter.updateCountry(this);
    getRetailStoreProvinceCenterList().add(retailStoreProvinceCenter);
    return this;
  }

  public RetailStoreCountryCenter addRetailStoreProvinceCenterList(
      SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList) {
    for (RetailStoreProvinceCenter retailStoreProvinceCenter : retailStoreProvinceCenterList) {
      retailStoreProvinceCenter.updateCountry(this);
    }

    Map<String, RetailStoreProvinceCenter> mapById = retailStoreProvinceCenterList.mapWithId();
    getRetailStoreProvinceCenterList().removeIf(item -> mapById.get(item.getId()) != null);
    getRetailStoreProvinceCenterList().addAll(retailStoreProvinceCenterList);
    return this;
  }

  public void mergeRetailStoreProvinceCenterList(
      SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList) {
    if (retailStoreProvinceCenterList == null) {
      return;
    }
    if (retailStoreProvinceCenterList.isEmpty()) {
      return;
    }
    addRetailStoreProvinceCenterList(retailStoreProvinceCenterList);
  }

  public RetailStoreProvinceCenter removeRetailStoreProvinceCenter(
      RetailStoreProvinceCenter retailStoreProvinceCenterIndex) {

    int index = getRetailStoreProvinceCenterList().indexOf(retailStoreProvinceCenterIndex);
    if (index < 0) {
      String message =
          "RetailStoreProvinceCenter("
              + retailStoreProvinceCenterIndex.getId()
              + ") with version='"
              + retailStoreProvinceCenterIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    RetailStoreProvinceCenter retailStoreProvinceCenter =
        getRetailStoreProvinceCenterList().get(index);
    // retailStoreProvinceCenter.clearCountry(); //disconnect with Country
    retailStoreProvinceCenter.clearFromAll(); // disconnect with Country

    boolean result = getRetailStoreProvinceCenterList().planToRemove(retailStoreProvinceCenter);
    if (!result) {
      String message =
          "RetailStoreProvinceCenter("
              + retailStoreProvinceCenterIndex.getId()
              + ") with version='"
              + retailStoreProvinceCenterIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return retailStoreProvinceCenter;
  }
  // 断舍离
  public void breakWithRetailStoreProvinceCenter(
      RetailStoreProvinceCenter retailStoreProvinceCenter) {

    if (retailStoreProvinceCenter == null) {
      return;
    }
    retailStoreProvinceCenter.setCountry(null);
    // getRetailStoreProvinceCenterList().remove();

  }

  public boolean hasRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter) {

    return getRetailStoreProvinceCenterList().contains(retailStoreProvinceCenter);
  }

  public void copyRetailStoreProvinceCenterFrom(
      RetailStoreProvinceCenter retailStoreProvinceCenter) {

    RetailStoreProvinceCenter retailStoreProvinceCenterInList =
        findTheRetailStoreProvinceCenter(retailStoreProvinceCenter);
    RetailStoreProvinceCenter newRetailStoreProvinceCenter = new RetailStoreProvinceCenter();
    retailStoreProvinceCenterInList.copyTo(newRetailStoreProvinceCenter);
    newRetailStoreProvinceCenter.setVersion(0); // will trigger copy
    getRetailStoreProvinceCenterList().add(newRetailStoreProvinceCenter);
    addItemToFlexiableObject(COPIED_CHILD, newRetailStoreProvinceCenter);
  }

  public RetailStoreProvinceCenter findTheRetailStoreProvinceCenter(
      RetailStoreProvinceCenter retailStoreProvinceCenter) {

    int index = getRetailStoreProvinceCenterList().indexOf(retailStoreProvinceCenter);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "RetailStoreProvinceCenter("
              + retailStoreProvinceCenter.getId()
              + ") with version='"
              + retailStoreProvinceCenter.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getRetailStoreProvinceCenterList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpRetailStoreProvinceCenterList() {
    getRetailStoreProvinceCenterList().clear();
  }

  public SmartList<RetailStore> getRetailStoreList() {
    if (this.mRetailStoreList == null) {
      this.mRetailStoreList = new SmartList<RetailStore>();
      this.mRetailStoreList.setListInternalName(RETAIL_STORE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mRetailStoreList;
  }

  public SmartList<RetailStore> retailStoreList() {

    doLoadChild(RETAIL_STORE_LIST);

    return getRetailStoreList();
  }

  public void setRetailStoreList(SmartList<RetailStore> retailStoreList) {
    for (RetailStore retailStore : retailStoreList) {
      retailStore.setRetailStoreCountryCenter(this);
    }

    this.mRetailStoreList = retailStoreList;
    this.mRetailStoreList.setListInternalName(RETAIL_STORE_LIST);
  }

  public RetailStoreCountryCenter addRetailStore(RetailStore retailStore) {
    retailStore.updateRetailStoreCountryCenter(this);
    getRetailStoreList().add(retailStore);
    return this;
  }

  public RetailStoreCountryCenter addRetailStoreList(SmartList<RetailStore> retailStoreList) {
    for (RetailStore retailStore : retailStoreList) {
      retailStore.updateRetailStoreCountryCenter(this);
    }

    Map<String, RetailStore> mapById = retailStoreList.mapWithId();
    getRetailStoreList().removeIf(item -> mapById.get(item.getId()) != null);
    getRetailStoreList().addAll(retailStoreList);
    return this;
  }

  public void mergeRetailStoreList(SmartList<RetailStore> retailStoreList) {
    if (retailStoreList == null) {
      return;
    }
    if (retailStoreList.isEmpty()) {
      return;
    }
    addRetailStoreList(retailStoreList);
  }

  public RetailStore removeRetailStore(RetailStore retailStoreIndex) {

    int index = getRetailStoreList().indexOf(retailStoreIndex);
    if (index < 0) {
      String message =
          "RetailStore("
              + retailStoreIndex.getId()
              + ") with version='"
              + retailStoreIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    RetailStore retailStore = getRetailStoreList().get(index);
    // retailStore.clearRetailStoreCountryCenter(); //disconnect with RetailStoreCountryCenter
    retailStore.clearFromAll(); // disconnect with RetailStoreCountryCenter

    boolean result = getRetailStoreList().planToRemove(retailStore);
    if (!result) {
      String message =
          "RetailStore("
              + retailStoreIndex.getId()
              + ") with version='"
              + retailStoreIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return retailStore;
  }
  // 断舍离
  public void breakWithRetailStore(RetailStore retailStore) {

    if (retailStore == null) {
      return;
    }
    retailStore.setRetailStoreCountryCenter(null);
    // getRetailStoreList().remove();

  }

  public boolean hasRetailStore(RetailStore retailStore) {

    return getRetailStoreList().contains(retailStore);
  }

  public void copyRetailStoreFrom(RetailStore retailStore) {

    RetailStore retailStoreInList = findTheRetailStore(retailStore);
    RetailStore newRetailStore = new RetailStore();
    retailStoreInList.copyTo(newRetailStore);
    newRetailStore.setVersion(0); // will trigger copy
    getRetailStoreList().add(newRetailStore);
    addItemToFlexiableObject(COPIED_CHILD, newRetailStore);
  }

  public RetailStore findTheRetailStore(RetailStore retailStore) {

    int index = getRetailStoreList().indexOf(retailStore);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "RetailStore("
              + retailStore.getId()
              + ") with version='"
              + retailStore.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getRetailStoreList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpRetailStoreList() {
    getRetailStoreList().clear();
  }

  public SmartList<RetailStoreMember> getRetailStoreMemberList() {
    if (this.mRetailStoreMemberList == null) {
      this.mRetailStoreMemberList = new SmartList<RetailStoreMember>();
      this.mRetailStoreMemberList.setListInternalName(RETAIL_STORE_MEMBER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mRetailStoreMemberList;
  }

  public SmartList<RetailStoreMember> retailStoreMemberList() {

    doLoadChild(RETAIL_STORE_MEMBER_LIST);

    return getRetailStoreMemberList();
  }

  public void setRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList) {
    for (RetailStoreMember retailStoreMember : retailStoreMemberList) {
      retailStoreMember.setOwner(this);
    }

    this.mRetailStoreMemberList = retailStoreMemberList;
    this.mRetailStoreMemberList.setListInternalName(RETAIL_STORE_MEMBER_LIST);
  }

  public RetailStoreCountryCenter addRetailStoreMember(RetailStoreMember retailStoreMember) {
    retailStoreMember.updateOwner(this);
    getRetailStoreMemberList().add(retailStoreMember);
    return this;
  }

  public RetailStoreCountryCenter addRetailStoreMemberList(
      SmartList<RetailStoreMember> retailStoreMemberList) {
    for (RetailStoreMember retailStoreMember : retailStoreMemberList) {
      retailStoreMember.updateOwner(this);
    }

    Map<String, RetailStoreMember> mapById = retailStoreMemberList.mapWithId();
    getRetailStoreMemberList().removeIf(item -> mapById.get(item.getId()) != null);
    getRetailStoreMemberList().addAll(retailStoreMemberList);
    return this;
  }

  public void mergeRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList) {
    if (retailStoreMemberList == null) {
      return;
    }
    if (retailStoreMemberList.isEmpty()) {
      return;
    }
    addRetailStoreMemberList(retailStoreMemberList);
  }

  public RetailStoreMember removeRetailStoreMember(RetailStoreMember retailStoreMemberIndex) {

    int index = getRetailStoreMemberList().indexOf(retailStoreMemberIndex);
    if (index < 0) {
      String message =
          "RetailStoreMember("
              + retailStoreMemberIndex.getId()
              + ") with version='"
              + retailStoreMemberIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    RetailStoreMember retailStoreMember = getRetailStoreMemberList().get(index);
    // retailStoreMember.clearOwner(); //disconnect with Owner
    retailStoreMember.clearFromAll(); // disconnect with Owner

    boolean result = getRetailStoreMemberList().planToRemove(retailStoreMember);
    if (!result) {
      String message =
          "RetailStoreMember("
              + retailStoreMemberIndex.getId()
              + ") with version='"
              + retailStoreMemberIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return retailStoreMember;
  }
  // 断舍离
  public void breakWithRetailStoreMember(RetailStoreMember retailStoreMember) {

    if (retailStoreMember == null) {
      return;
    }
    retailStoreMember.setOwner(null);
    // getRetailStoreMemberList().remove();

  }

  public boolean hasRetailStoreMember(RetailStoreMember retailStoreMember) {

    return getRetailStoreMemberList().contains(retailStoreMember);
  }

  public void copyRetailStoreMemberFrom(RetailStoreMember retailStoreMember) {

    RetailStoreMember retailStoreMemberInList = findTheRetailStoreMember(retailStoreMember);
    RetailStoreMember newRetailStoreMember = new RetailStoreMember();
    retailStoreMemberInList.copyTo(newRetailStoreMember);
    newRetailStoreMember.setVersion(0); // will trigger copy
    getRetailStoreMemberList().add(newRetailStoreMember);
    addItemToFlexiableObject(COPIED_CHILD, newRetailStoreMember);
  }

  public RetailStoreMember findTheRetailStoreMember(RetailStoreMember retailStoreMember) {

    int index = getRetailStoreMemberList().indexOf(retailStoreMember);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "RetailStoreMember("
              + retailStoreMember.getId()
              + ") with version='"
              + retailStoreMember.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getRetailStoreMemberList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpRetailStoreMemberList() {
    getRetailStoreMemberList().clear();
  }

  public SmartList<GoodsSupplier> getGoodsSupplierList() {
    if (this.mGoodsSupplierList == null) {
      this.mGoodsSupplierList = new SmartList<GoodsSupplier>();
      this.mGoodsSupplierList.setListInternalName(GOODS_SUPPLIER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mGoodsSupplierList;
  }

  public SmartList<GoodsSupplier> goodsSupplierList() {

    doLoadChild(GOODS_SUPPLIER_LIST);

    return getGoodsSupplierList();
  }

  public void setGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList) {
    for (GoodsSupplier goodsSupplier : goodsSupplierList) {
      goodsSupplier.setBelongTo(this);
    }

    this.mGoodsSupplierList = goodsSupplierList;
    this.mGoodsSupplierList.setListInternalName(GOODS_SUPPLIER_LIST);
  }

  public RetailStoreCountryCenter addGoodsSupplier(GoodsSupplier goodsSupplier) {
    goodsSupplier.updateBelongTo(this);
    getGoodsSupplierList().add(goodsSupplier);
    return this;
  }

  public RetailStoreCountryCenter addGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList) {
    for (GoodsSupplier goodsSupplier : goodsSupplierList) {
      goodsSupplier.updateBelongTo(this);
    }

    Map<String, GoodsSupplier> mapById = goodsSupplierList.mapWithId();
    getGoodsSupplierList().removeIf(item -> mapById.get(item.getId()) != null);
    getGoodsSupplierList().addAll(goodsSupplierList);
    return this;
  }

  public void mergeGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList) {
    if (goodsSupplierList == null) {
      return;
    }
    if (goodsSupplierList.isEmpty()) {
      return;
    }
    addGoodsSupplierList(goodsSupplierList);
  }

  public GoodsSupplier removeGoodsSupplier(GoodsSupplier goodsSupplierIndex) {

    int index = getGoodsSupplierList().indexOf(goodsSupplierIndex);
    if (index < 0) {
      String message =
          "GoodsSupplier("
              + goodsSupplierIndex.getId()
              + ") with version='"
              + goodsSupplierIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    GoodsSupplier goodsSupplier = getGoodsSupplierList().get(index);
    // goodsSupplier.clearBelongTo(); //disconnect with BelongTo
    goodsSupplier.clearFromAll(); // disconnect with BelongTo

    boolean result = getGoodsSupplierList().planToRemove(goodsSupplier);
    if (!result) {
      String message =
          "GoodsSupplier("
              + goodsSupplierIndex.getId()
              + ") with version='"
              + goodsSupplierIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return goodsSupplier;
  }
  // 断舍离
  public void breakWithGoodsSupplier(GoodsSupplier goodsSupplier) {

    if (goodsSupplier == null) {
      return;
    }
    goodsSupplier.setBelongTo(null);
    // getGoodsSupplierList().remove();

  }

  public boolean hasGoodsSupplier(GoodsSupplier goodsSupplier) {

    return getGoodsSupplierList().contains(goodsSupplier);
  }

  public void copyGoodsSupplierFrom(GoodsSupplier goodsSupplier) {

    GoodsSupplier goodsSupplierInList = findTheGoodsSupplier(goodsSupplier);
    GoodsSupplier newGoodsSupplier = new GoodsSupplier();
    goodsSupplierInList.copyTo(newGoodsSupplier);
    newGoodsSupplier.setVersion(0); // will trigger copy
    getGoodsSupplierList().add(newGoodsSupplier);
    addItemToFlexiableObject(COPIED_CHILD, newGoodsSupplier);
  }

  public GoodsSupplier findTheGoodsSupplier(GoodsSupplier goodsSupplier) {

    int index = getGoodsSupplierList().indexOf(goodsSupplier);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "GoodsSupplier("
              + goodsSupplier.getId()
              + ") with version='"
              + goodsSupplier.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getGoodsSupplierList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpGoodsSupplierList() {
    getGoodsSupplierList().clear();
  }

  public SmartList<SupplyOrder> getSupplyOrderList() {
    if (this.mSupplyOrderList == null) {
      this.mSupplyOrderList = new SmartList<SupplyOrder>();
      this.mSupplyOrderList.setListInternalName(SUPPLY_ORDER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mSupplyOrderList;
  }

  public SmartList<SupplyOrder> supplyOrderList() {

    doLoadChild(SUPPLY_ORDER_LIST);

    return getSupplyOrderList();
  }

  public void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList) {
    for (SupplyOrder supplyOrder : supplyOrderList) {
      supplyOrder.setBuyer(this);
    }

    this.mSupplyOrderList = supplyOrderList;
    this.mSupplyOrderList.setListInternalName(SUPPLY_ORDER_LIST);
  }

  public RetailStoreCountryCenter addSupplyOrder(SupplyOrder supplyOrder) {
    supplyOrder.updateBuyer(this);
    getSupplyOrderList().add(supplyOrder);
    return this;
  }

  public RetailStoreCountryCenter addSupplyOrderList(SmartList<SupplyOrder> supplyOrderList) {
    for (SupplyOrder supplyOrder : supplyOrderList) {
      supplyOrder.updateBuyer(this);
    }

    Map<String, SupplyOrder> mapById = supplyOrderList.mapWithId();
    getSupplyOrderList().removeIf(item -> mapById.get(item.getId()) != null);
    getSupplyOrderList().addAll(supplyOrderList);
    return this;
  }

  public void mergeSupplyOrderList(SmartList<SupplyOrder> supplyOrderList) {
    if (supplyOrderList == null) {
      return;
    }
    if (supplyOrderList.isEmpty()) {
      return;
    }
    addSupplyOrderList(supplyOrderList);
  }

  public SupplyOrder removeSupplyOrder(SupplyOrder supplyOrderIndex) {

    int index = getSupplyOrderList().indexOf(supplyOrderIndex);
    if (index < 0) {
      String message =
          "SupplyOrder("
              + supplyOrderIndex.getId()
              + ") with version='"
              + supplyOrderIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    SupplyOrder supplyOrder = getSupplyOrderList().get(index);
    // supplyOrder.clearBuyer(); //disconnect with Buyer
    supplyOrder.clearFromAll(); // disconnect with Buyer

    boolean result = getSupplyOrderList().planToRemove(supplyOrder);
    if (!result) {
      String message =
          "SupplyOrder("
              + supplyOrderIndex.getId()
              + ") with version='"
              + supplyOrderIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return supplyOrder;
  }
  // 断舍离
  public void breakWithSupplyOrder(SupplyOrder supplyOrder) {

    if (supplyOrder == null) {
      return;
    }
    supplyOrder.setBuyer(null);
    // getSupplyOrderList().remove();

  }

  public boolean hasSupplyOrder(SupplyOrder supplyOrder) {

    return getSupplyOrderList().contains(supplyOrder);
  }

  public void copySupplyOrderFrom(SupplyOrder supplyOrder) {

    SupplyOrder supplyOrderInList = findTheSupplyOrder(supplyOrder);
    SupplyOrder newSupplyOrder = new SupplyOrder();
    supplyOrderInList.copyTo(newSupplyOrder);
    newSupplyOrder.setVersion(0); // will trigger copy
    getSupplyOrderList().add(newSupplyOrder);
    addItemToFlexiableObject(COPIED_CHILD, newSupplyOrder);
  }

  public SupplyOrder findTheSupplyOrder(SupplyOrder supplyOrder) {

    int index = getSupplyOrderList().indexOf(supplyOrder);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "SupplyOrder("
              + supplyOrder.getId()
              + ") with version='"
              + supplyOrder.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getSupplyOrderList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpSupplyOrderList() {
    getSupplyOrderList().clear();
  }

  public SmartList<RetailStoreOrder> getRetailStoreOrderList() {
    if (this.mRetailStoreOrderList == null) {
      this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
      this.mRetailStoreOrderList.setListInternalName(RETAIL_STORE_ORDER_LIST);
      // 有名字，便于做权限控制
    }

    return this.mRetailStoreOrderList;
  }

  public SmartList<RetailStoreOrder> retailStoreOrderList() {

    doLoadChild(RETAIL_STORE_ORDER_LIST);

    return getRetailStoreOrderList();
  }

  public void setRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList) {
    for (RetailStoreOrder retailStoreOrder : retailStoreOrderList) {
      retailStoreOrder.setSeller(this);
    }

    this.mRetailStoreOrderList = retailStoreOrderList;
    this.mRetailStoreOrderList.setListInternalName(RETAIL_STORE_ORDER_LIST);
  }

  public RetailStoreCountryCenter addRetailStoreOrder(RetailStoreOrder retailStoreOrder) {
    retailStoreOrder.updateSeller(this);
    getRetailStoreOrderList().add(retailStoreOrder);
    return this;
  }

  public RetailStoreCountryCenter addRetailStoreOrderList(
      SmartList<RetailStoreOrder> retailStoreOrderList) {
    for (RetailStoreOrder retailStoreOrder : retailStoreOrderList) {
      retailStoreOrder.updateSeller(this);
    }

    Map<String, RetailStoreOrder> mapById = retailStoreOrderList.mapWithId();
    getRetailStoreOrderList().removeIf(item -> mapById.get(item.getId()) != null);
    getRetailStoreOrderList().addAll(retailStoreOrderList);
    return this;
  }

  public void mergeRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList) {
    if (retailStoreOrderList == null) {
      return;
    }
    if (retailStoreOrderList.isEmpty()) {
      return;
    }
    addRetailStoreOrderList(retailStoreOrderList);
  }

  public RetailStoreOrder removeRetailStoreOrder(RetailStoreOrder retailStoreOrderIndex) {

    int index = getRetailStoreOrderList().indexOf(retailStoreOrderIndex);
    if (index < 0) {
      String message =
          "RetailStoreOrder("
              + retailStoreOrderIndex.getId()
              + ") with version='"
              + retailStoreOrderIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    RetailStoreOrder retailStoreOrder = getRetailStoreOrderList().get(index);
    // retailStoreOrder.clearSeller(); //disconnect with Seller
    retailStoreOrder.clearFromAll(); // disconnect with Seller

    boolean result = getRetailStoreOrderList().planToRemove(retailStoreOrder);
    if (!result) {
      String message =
          "RetailStoreOrder("
              + retailStoreOrderIndex.getId()
              + ") with version='"
              + retailStoreOrderIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return retailStoreOrder;
  }
  // 断舍离
  public void breakWithRetailStoreOrder(RetailStoreOrder retailStoreOrder) {

    if (retailStoreOrder == null) {
      return;
    }
    retailStoreOrder.setSeller(null);
    // getRetailStoreOrderList().remove();

  }

  public boolean hasRetailStoreOrder(RetailStoreOrder retailStoreOrder) {

    return getRetailStoreOrderList().contains(retailStoreOrder);
  }

  public void copyRetailStoreOrderFrom(RetailStoreOrder retailStoreOrder) {

    RetailStoreOrder retailStoreOrderInList = findTheRetailStoreOrder(retailStoreOrder);
    RetailStoreOrder newRetailStoreOrder = new RetailStoreOrder();
    retailStoreOrderInList.copyTo(newRetailStoreOrder);
    newRetailStoreOrder.setVersion(0); // will trigger copy
    getRetailStoreOrderList().add(newRetailStoreOrder);
    addItemToFlexiableObject(COPIED_CHILD, newRetailStoreOrder);
  }

  public RetailStoreOrder findTheRetailStoreOrder(RetailStoreOrder retailStoreOrder) {

    int index = getRetailStoreOrderList().indexOf(retailStoreOrder);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "RetailStoreOrder("
              + retailStoreOrder.getId()
              + ") with version='"
              + retailStoreOrder.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getRetailStoreOrderList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpRetailStoreOrderList() {
    getRetailStoreOrderList().clear();
  }

  public SmartList<Warehouse> getWarehouseList() {
    if (this.mWarehouseList == null) {
      this.mWarehouseList = new SmartList<Warehouse>();
      this.mWarehouseList.setListInternalName(WAREHOUSE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mWarehouseList;
  }

  public SmartList<Warehouse> warehouseList() {

    doLoadChild(WAREHOUSE_LIST);

    return getWarehouseList();
  }

  public void setWarehouseList(SmartList<Warehouse> warehouseList) {
    for (Warehouse warehouse : warehouseList) {
      warehouse.setOwner(this);
    }

    this.mWarehouseList = warehouseList;
    this.mWarehouseList.setListInternalName(WAREHOUSE_LIST);
  }

  public RetailStoreCountryCenter addWarehouse(Warehouse warehouse) {
    warehouse.updateOwner(this);
    getWarehouseList().add(warehouse);
    return this;
  }

  public RetailStoreCountryCenter addWarehouseList(SmartList<Warehouse> warehouseList) {
    for (Warehouse warehouse : warehouseList) {
      warehouse.updateOwner(this);
    }

    Map<String, Warehouse> mapById = warehouseList.mapWithId();
    getWarehouseList().removeIf(item -> mapById.get(item.getId()) != null);
    getWarehouseList().addAll(warehouseList);
    return this;
  }

  public void mergeWarehouseList(SmartList<Warehouse> warehouseList) {
    if (warehouseList == null) {
      return;
    }
    if (warehouseList.isEmpty()) {
      return;
    }
    addWarehouseList(warehouseList);
  }

  public Warehouse removeWarehouse(Warehouse warehouseIndex) {

    int index = getWarehouseList().indexOf(warehouseIndex);
    if (index < 0) {
      String message =
          "Warehouse("
              + warehouseIndex.getId()
              + ") with version='"
              + warehouseIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Warehouse warehouse = getWarehouseList().get(index);
    // warehouse.clearOwner(); //disconnect with Owner
    warehouse.clearFromAll(); // disconnect with Owner

    boolean result = getWarehouseList().planToRemove(warehouse);
    if (!result) {
      String message =
          "Warehouse("
              + warehouseIndex.getId()
              + ") with version='"
              + warehouseIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return warehouse;
  }
  // 断舍离
  public void breakWithWarehouse(Warehouse warehouse) {

    if (warehouse == null) {
      return;
    }
    warehouse.setOwner(null);
    // getWarehouseList().remove();

  }

  public boolean hasWarehouse(Warehouse warehouse) {

    return getWarehouseList().contains(warehouse);
  }

  public void copyWarehouseFrom(Warehouse warehouse) {

    Warehouse warehouseInList = findTheWarehouse(warehouse);
    Warehouse newWarehouse = new Warehouse();
    warehouseInList.copyTo(newWarehouse);
    newWarehouse.setVersion(0); // will trigger copy
    getWarehouseList().add(newWarehouse);
    addItemToFlexiableObject(COPIED_CHILD, newWarehouse);
  }

  public Warehouse findTheWarehouse(Warehouse warehouse) {

    int index = getWarehouseList().indexOf(warehouse);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Warehouse("
              + warehouse.getId()
              + ") with version='"
              + warehouse.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getWarehouseList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpWarehouseList() {
    getWarehouseList().clear();
  }

  public SmartList<TransportFleet> getTransportFleetList() {
    if (this.mTransportFleetList == null) {
      this.mTransportFleetList = new SmartList<TransportFleet>();
      this.mTransportFleetList.setListInternalName(TRANSPORT_FLEET_LIST);
      // 有名字，便于做权限控制
    }

    return this.mTransportFleetList;
  }

  public SmartList<TransportFleet> transportFleetList() {

    doLoadChild(TRANSPORT_FLEET_LIST);

    return getTransportFleetList();
  }

  public void setTransportFleetList(SmartList<TransportFleet> transportFleetList) {
    for (TransportFleet transportFleet : transportFleetList) {
      transportFleet.setOwner(this);
    }

    this.mTransportFleetList = transportFleetList;
    this.mTransportFleetList.setListInternalName(TRANSPORT_FLEET_LIST);
  }

  public RetailStoreCountryCenter addTransportFleet(TransportFleet transportFleet) {
    transportFleet.updateOwner(this);
    getTransportFleetList().add(transportFleet);
    return this;
  }

  public RetailStoreCountryCenter addTransportFleetList(
      SmartList<TransportFleet> transportFleetList) {
    for (TransportFleet transportFleet : transportFleetList) {
      transportFleet.updateOwner(this);
    }

    Map<String, TransportFleet> mapById = transportFleetList.mapWithId();
    getTransportFleetList().removeIf(item -> mapById.get(item.getId()) != null);
    getTransportFleetList().addAll(transportFleetList);
    return this;
  }

  public void mergeTransportFleetList(SmartList<TransportFleet> transportFleetList) {
    if (transportFleetList == null) {
      return;
    }
    if (transportFleetList.isEmpty()) {
      return;
    }
    addTransportFleetList(transportFleetList);
  }

  public TransportFleet removeTransportFleet(TransportFleet transportFleetIndex) {

    int index = getTransportFleetList().indexOf(transportFleetIndex);
    if (index < 0) {
      String message =
          "TransportFleet("
              + transportFleetIndex.getId()
              + ") with version='"
              + transportFleetIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    TransportFleet transportFleet = getTransportFleetList().get(index);
    // transportFleet.clearOwner(); //disconnect with Owner
    transportFleet.clearFromAll(); // disconnect with Owner

    boolean result = getTransportFleetList().planToRemove(transportFleet);
    if (!result) {
      String message =
          "TransportFleet("
              + transportFleetIndex.getId()
              + ") with version='"
              + transportFleetIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return transportFleet;
  }
  // 断舍离
  public void breakWithTransportFleet(TransportFleet transportFleet) {

    if (transportFleet == null) {
      return;
    }
    transportFleet.setOwner(null);
    // getTransportFleetList().remove();

  }

  public boolean hasTransportFleet(TransportFleet transportFleet) {

    return getTransportFleetList().contains(transportFleet);
  }

  public void copyTransportFleetFrom(TransportFleet transportFleet) {

    TransportFleet transportFleetInList = findTheTransportFleet(transportFleet);
    TransportFleet newTransportFleet = new TransportFleet();
    transportFleetInList.copyTo(newTransportFleet);
    newTransportFleet.setVersion(0); // will trigger copy
    getTransportFleetList().add(newTransportFleet);
    addItemToFlexiableObject(COPIED_CHILD, newTransportFleet);
  }

  public TransportFleet findTheTransportFleet(TransportFleet transportFleet) {

    int index = getTransportFleetList().indexOf(transportFleet);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "TransportFleet("
              + transportFleet.getId()
              + ") with version='"
              + transportFleet.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getTransportFleetList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpTransportFleetList() {
    getTransportFleetList().clear();
  }

  public SmartList<AccountSet> getAccountSetList() {
    if (this.mAccountSetList == null) {
      this.mAccountSetList = new SmartList<AccountSet>();
      this.mAccountSetList.setListInternalName(ACCOUNT_SET_LIST);
      // 有名字，便于做权限控制
    }

    return this.mAccountSetList;
  }

  public SmartList<AccountSet> accountSetList() {

    doLoadChild(ACCOUNT_SET_LIST);

    return getAccountSetList();
  }

  public void setAccountSetList(SmartList<AccountSet> accountSetList) {
    for (AccountSet accountSet : accountSetList) {
      accountSet.setCountryCenter(this);
    }

    this.mAccountSetList = accountSetList;
    this.mAccountSetList.setListInternalName(ACCOUNT_SET_LIST);
  }

  public RetailStoreCountryCenter addAccountSet(AccountSet accountSet) {
    accountSet.updateCountryCenter(this);
    getAccountSetList().add(accountSet);
    return this;
  }

  public RetailStoreCountryCenter addAccountSetList(SmartList<AccountSet> accountSetList) {
    for (AccountSet accountSet : accountSetList) {
      accountSet.updateCountryCenter(this);
    }

    Map<String, AccountSet> mapById = accountSetList.mapWithId();
    getAccountSetList().removeIf(item -> mapById.get(item.getId()) != null);
    getAccountSetList().addAll(accountSetList);
    return this;
  }

  public void mergeAccountSetList(SmartList<AccountSet> accountSetList) {
    if (accountSetList == null) {
      return;
    }
    if (accountSetList.isEmpty()) {
      return;
    }
    addAccountSetList(accountSetList);
  }

  public AccountSet removeAccountSet(AccountSet accountSetIndex) {

    int index = getAccountSetList().indexOf(accountSetIndex);
    if (index < 0) {
      String message =
          "AccountSet("
              + accountSetIndex.getId()
              + ") with version='"
              + accountSetIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    AccountSet accountSet = getAccountSetList().get(index);
    // accountSet.clearCountryCenter(); //disconnect with CountryCenter
    accountSet.clearFromAll(); // disconnect with CountryCenter

    boolean result = getAccountSetList().planToRemove(accountSet);
    if (!result) {
      String message =
          "AccountSet("
              + accountSetIndex.getId()
              + ") with version='"
              + accountSetIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return accountSet;
  }
  // 断舍离
  public void breakWithAccountSet(AccountSet accountSet) {

    if (accountSet == null) {
      return;
    }
    accountSet.setCountryCenter(null);
    // getAccountSetList().remove();

  }

  public boolean hasAccountSet(AccountSet accountSet) {

    return getAccountSetList().contains(accountSet);
  }

  public void copyAccountSetFrom(AccountSet accountSet) {

    AccountSet accountSetInList = findTheAccountSet(accountSet);
    AccountSet newAccountSet = new AccountSet();
    accountSetInList.copyTo(newAccountSet);
    newAccountSet.setVersion(0); // will trigger copy
    getAccountSetList().add(newAccountSet);
    addItemToFlexiableObject(COPIED_CHILD, newAccountSet);
  }

  public AccountSet findTheAccountSet(AccountSet accountSet) {

    int index = getAccountSetList().indexOf(accountSet);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "AccountSet("
              + accountSet.getId()
              + ") with version='"
              + accountSet.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getAccountSetList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpAccountSetList() {
    getAccountSetList().clear();
  }

  public SmartList<LevelOneDepartment> getLevelOneDepartmentList() {
    if (this.mLevelOneDepartmentList == null) {
      this.mLevelOneDepartmentList = new SmartList<LevelOneDepartment>();
      this.mLevelOneDepartmentList.setListInternalName(LEVEL_ONE_DEPARTMENT_LIST);
      // 有名字，便于做权限控制
    }

    return this.mLevelOneDepartmentList;
  }

  public SmartList<LevelOneDepartment> levelOneDepartmentList() {

    doLoadChild(LEVEL_ONE_DEPARTMENT_LIST);

    return getLevelOneDepartmentList();
  }

  public void setLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList) {
    for (LevelOneDepartment levelOneDepartment : levelOneDepartmentList) {
      levelOneDepartment.setBelongsTo(this);
    }

    this.mLevelOneDepartmentList = levelOneDepartmentList;
    this.mLevelOneDepartmentList.setListInternalName(LEVEL_ONE_DEPARTMENT_LIST);
  }

  public RetailStoreCountryCenter addLevelOneDepartment(LevelOneDepartment levelOneDepartment) {
    levelOneDepartment.updateBelongsTo(this);
    getLevelOneDepartmentList().add(levelOneDepartment);
    return this;
  }

  public RetailStoreCountryCenter addLevelOneDepartmentList(
      SmartList<LevelOneDepartment> levelOneDepartmentList) {
    for (LevelOneDepartment levelOneDepartment : levelOneDepartmentList) {
      levelOneDepartment.updateBelongsTo(this);
    }

    Map<String, LevelOneDepartment> mapById = levelOneDepartmentList.mapWithId();
    getLevelOneDepartmentList().removeIf(item -> mapById.get(item.getId()) != null);
    getLevelOneDepartmentList().addAll(levelOneDepartmentList);
    return this;
  }

  public void mergeLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList) {
    if (levelOneDepartmentList == null) {
      return;
    }
    if (levelOneDepartmentList.isEmpty()) {
      return;
    }
    addLevelOneDepartmentList(levelOneDepartmentList);
  }

  public LevelOneDepartment removeLevelOneDepartment(LevelOneDepartment levelOneDepartmentIndex) {

    int index = getLevelOneDepartmentList().indexOf(levelOneDepartmentIndex);
    if (index < 0) {
      String message =
          "LevelOneDepartment("
              + levelOneDepartmentIndex.getId()
              + ") with version='"
              + levelOneDepartmentIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    LevelOneDepartment levelOneDepartment = getLevelOneDepartmentList().get(index);
    // levelOneDepartment.clearBelongsTo(); //disconnect with BelongsTo
    levelOneDepartment.clearFromAll(); // disconnect with BelongsTo

    boolean result = getLevelOneDepartmentList().planToRemove(levelOneDepartment);
    if (!result) {
      String message =
          "LevelOneDepartment("
              + levelOneDepartmentIndex.getId()
              + ") with version='"
              + levelOneDepartmentIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return levelOneDepartment;
  }
  // 断舍离
  public void breakWithLevelOneDepartment(LevelOneDepartment levelOneDepartment) {

    if (levelOneDepartment == null) {
      return;
    }
    levelOneDepartment.setBelongsTo(null);
    // getLevelOneDepartmentList().remove();

  }

  public boolean hasLevelOneDepartment(LevelOneDepartment levelOneDepartment) {

    return getLevelOneDepartmentList().contains(levelOneDepartment);
  }

  public void copyLevelOneDepartmentFrom(LevelOneDepartment levelOneDepartment) {

    LevelOneDepartment levelOneDepartmentInList = findTheLevelOneDepartment(levelOneDepartment);
    LevelOneDepartment newLevelOneDepartment = new LevelOneDepartment();
    levelOneDepartmentInList.copyTo(newLevelOneDepartment);
    newLevelOneDepartment.setVersion(0); // will trigger copy
    getLevelOneDepartmentList().add(newLevelOneDepartment);
    addItemToFlexiableObject(COPIED_CHILD, newLevelOneDepartment);
  }

  public LevelOneDepartment findTheLevelOneDepartment(LevelOneDepartment levelOneDepartment) {

    int index = getLevelOneDepartmentList().indexOf(levelOneDepartment);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "LevelOneDepartment("
              + levelOneDepartment.getId()
              + ") with version='"
              + levelOneDepartment.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getLevelOneDepartmentList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpLevelOneDepartmentList() {
    getLevelOneDepartmentList().clear();
  }

  public SmartList<SkillType> getSkillTypeList() {
    if (this.mSkillTypeList == null) {
      this.mSkillTypeList = new SmartList<SkillType>();
      this.mSkillTypeList.setListInternalName(SKILL_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mSkillTypeList;
  }

  public SmartList<SkillType> skillTypeList() {

    doLoadChild(SKILL_TYPE_LIST);

    return getSkillTypeList();
  }

  public void setSkillTypeList(SmartList<SkillType> skillTypeList) {
    for (SkillType skillType : skillTypeList) {
      skillType.setCompany(this);
    }

    this.mSkillTypeList = skillTypeList;
    this.mSkillTypeList.setListInternalName(SKILL_TYPE_LIST);
  }

  public RetailStoreCountryCenter addSkillType(SkillType skillType) {
    skillType.updateCompany(this);
    getSkillTypeList().add(skillType);
    return this;
  }

  public RetailStoreCountryCenter addSkillTypeList(SmartList<SkillType> skillTypeList) {
    for (SkillType skillType : skillTypeList) {
      skillType.updateCompany(this);
    }

    Map<String, SkillType> mapById = skillTypeList.mapWithId();
    getSkillTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getSkillTypeList().addAll(skillTypeList);
    return this;
  }

  public void mergeSkillTypeList(SmartList<SkillType> skillTypeList) {
    if (skillTypeList == null) {
      return;
    }
    if (skillTypeList.isEmpty()) {
      return;
    }
    addSkillTypeList(skillTypeList);
  }

  public SkillType removeSkillType(SkillType skillTypeIndex) {

    int index = getSkillTypeList().indexOf(skillTypeIndex);
    if (index < 0) {
      String message =
          "SkillType("
              + skillTypeIndex.getId()
              + ") with version='"
              + skillTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    SkillType skillType = getSkillTypeList().get(index);
    // skillType.clearCompany(); //disconnect with Company
    skillType.clearFromAll(); // disconnect with Company

    boolean result = getSkillTypeList().planToRemove(skillType);
    if (!result) {
      String message =
          "SkillType("
              + skillTypeIndex.getId()
              + ") with version='"
              + skillTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return skillType;
  }
  // 断舍离
  public void breakWithSkillType(SkillType skillType) {

    if (skillType == null) {
      return;
    }
    skillType.setCompany(null);
    // getSkillTypeList().remove();

  }

  public boolean hasSkillType(SkillType skillType) {

    return getSkillTypeList().contains(skillType);
  }

  public void copySkillTypeFrom(SkillType skillType) {

    SkillType skillTypeInList = findTheSkillType(skillType);
    SkillType newSkillType = new SkillType();
    skillTypeInList.copyTo(newSkillType);
    newSkillType.setVersion(0); // will trigger copy
    getSkillTypeList().add(newSkillType);
    addItemToFlexiableObject(COPIED_CHILD, newSkillType);
  }

  public SkillType findTheSkillType(SkillType skillType) {

    int index = getSkillTypeList().indexOf(skillType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "SkillType("
              + skillType.getId()
              + ") with version='"
              + skillType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getSkillTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpSkillTypeList() {
    getSkillTypeList().clear();
  }

  public SmartList<ResponsibilityType> getResponsibilityTypeList() {
    if (this.mResponsibilityTypeList == null) {
      this.mResponsibilityTypeList = new SmartList<ResponsibilityType>();
      this.mResponsibilityTypeList.setListInternalName(RESPONSIBILITY_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mResponsibilityTypeList;
  }

  public SmartList<ResponsibilityType> responsibilityTypeList() {

    doLoadChild(RESPONSIBILITY_TYPE_LIST);

    return getResponsibilityTypeList();
  }

  public void setResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList) {
    for (ResponsibilityType responsibilityType : responsibilityTypeList) {
      responsibilityType.setCompany(this);
    }

    this.mResponsibilityTypeList = responsibilityTypeList;
    this.mResponsibilityTypeList.setListInternalName(RESPONSIBILITY_TYPE_LIST);
  }

  public RetailStoreCountryCenter addResponsibilityType(ResponsibilityType responsibilityType) {
    responsibilityType.updateCompany(this);
    getResponsibilityTypeList().add(responsibilityType);
    return this;
  }

  public RetailStoreCountryCenter addResponsibilityTypeList(
      SmartList<ResponsibilityType> responsibilityTypeList) {
    for (ResponsibilityType responsibilityType : responsibilityTypeList) {
      responsibilityType.updateCompany(this);
    }

    Map<String, ResponsibilityType> mapById = responsibilityTypeList.mapWithId();
    getResponsibilityTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getResponsibilityTypeList().addAll(responsibilityTypeList);
    return this;
  }

  public void mergeResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList) {
    if (responsibilityTypeList == null) {
      return;
    }
    if (responsibilityTypeList.isEmpty()) {
      return;
    }
    addResponsibilityTypeList(responsibilityTypeList);
  }

  public ResponsibilityType removeResponsibilityType(ResponsibilityType responsibilityTypeIndex) {

    int index = getResponsibilityTypeList().indexOf(responsibilityTypeIndex);
    if (index < 0) {
      String message =
          "ResponsibilityType("
              + responsibilityTypeIndex.getId()
              + ") with version='"
              + responsibilityTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    ResponsibilityType responsibilityType = getResponsibilityTypeList().get(index);
    // responsibilityType.clearCompany(); //disconnect with Company
    responsibilityType.clearFromAll(); // disconnect with Company

    boolean result = getResponsibilityTypeList().planToRemove(responsibilityType);
    if (!result) {
      String message =
          "ResponsibilityType("
              + responsibilityTypeIndex.getId()
              + ") with version='"
              + responsibilityTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return responsibilityType;
  }
  // 断舍离
  public void breakWithResponsibilityType(ResponsibilityType responsibilityType) {

    if (responsibilityType == null) {
      return;
    }
    responsibilityType.setCompany(null);
    // getResponsibilityTypeList().remove();

  }

  public boolean hasResponsibilityType(ResponsibilityType responsibilityType) {

    return getResponsibilityTypeList().contains(responsibilityType);
  }

  public void copyResponsibilityTypeFrom(ResponsibilityType responsibilityType) {

    ResponsibilityType responsibilityTypeInList = findTheResponsibilityType(responsibilityType);
    ResponsibilityType newResponsibilityType = new ResponsibilityType();
    responsibilityTypeInList.copyTo(newResponsibilityType);
    newResponsibilityType.setVersion(0); // will trigger copy
    getResponsibilityTypeList().add(newResponsibilityType);
    addItemToFlexiableObject(COPIED_CHILD, newResponsibilityType);
  }

  public ResponsibilityType findTheResponsibilityType(ResponsibilityType responsibilityType) {

    int index = getResponsibilityTypeList().indexOf(responsibilityType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "ResponsibilityType("
              + responsibilityType.getId()
              + ") with version='"
              + responsibilityType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getResponsibilityTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpResponsibilityTypeList() {
    getResponsibilityTypeList().clear();
  }

  public SmartList<TerminationReason> getTerminationReasonList() {
    if (this.mTerminationReasonList == null) {
      this.mTerminationReasonList = new SmartList<TerminationReason>();
      this.mTerminationReasonList.setListInternalName(TERMINATION_REASON_LIST);
      // 有名字，便于做权限控制
    }

    return this.mTerminationReasonList;
  }

  public SmartList<TerminationReason> terminationReasonList() {

    doLoadChild(TERMINATION_REASON_LIST);

    return getTerminationReasonList();
  }

  public void setTerminationReasonList(SmartList<TerminationReason> terminationReasonList) {
    for (TerminationReason terminationReason : terminationReasonList) {
      terminationReason.setCompany(this);
    }

    this.mTerminationReasonList = terminationReasonList;
    this.mTerminationReasonList.setListInternalName(TERMINATION_REASON_LIST);
  }

  public RetailStoreCountryCenter addTerminationReason(TerminationReason terminationReason) {
    terminationReason.updateCompany(this);
    getTerminationReasonList().add(terminationReason);
    return this;
  }

  public RetailStoreCountryCenter addTerminationReasonList(
      SmartList<TerminationReason> terminationReasonList) {
    for (TerminationReason terminationReason : terminationReasonList) {
      terminationReason.updateCompany(this);
    }

    Map<String, TerminationReason> mapById = terminationReasonList.mapWithId();
    getTerminationReasonList().removeIf(item -> mapById.get(item.getId()) != null);
    getTerminationReasonList().addAll(terminationReasonList);
    return this;
  }

  public void mergeTerminationReasonList(SmartList<TerminationReason> terminationReasonList) {
    if (terminationReasonList == null) {
      return;
    }
    if (terminationReasonList.isEmpty()) {
      return;
    }
    addTerminationReasonList(terminationReasonList);
  }

  public TerminationReason removeTerminationReason(TerminationReason terminationReasonIndex) {

    int index = getTerminationReasonList().indexOf(terminationReasonIndex);
    if (index < 0) {
      String message =
          "TerminationReason("
              + terminationReasonIndex.getId()
              + ") with version='"
              + terminationReasonIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    TerminationReason terminationReason = getTerminationReasonList().get(index);
    // terminationReason.clearCompany(); //disconnect with Company
    terminationReason.clearFromAll(); // disconnect with Company

    boolean result = getTerminationReasonList().planToRemove(terminationReason);
    if (!result) {
      String message =
          "TerminationReason("
              + terminationReasonIndex.getId()
              + ") with version='"
              + terminationReasonIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return terminationReason;
  }
  // 断舍离
  public void breakWithTerminationReason(TerminationReason terminationReason) {

    if (terminationReason == null) {
      return;
    }
    terminationReason.setCompany(null);
    // getTerminationReasonList().remove();

  }

  public boolean hasTerminationReason(TerminationReason terminationReason) {

    return getTerminationReasonList().contains(terminationReason);
  }

  public void copyTerminationReasonFrom(TerminationReason terminationReason) {

    TerminationReason terminationReasonInList = findTheTerminationReason(terminationReason);
    TerminationReason newTerminationReason = new TerminationReason();
    terminationReasonInList.copyTo(newTerminationReason);
    newTerminationReason.setVersion(0); // will trigger copy
    getTerminationReasonList().add(newTerminationReason);
    addItemToFlexiableObject(COPIED_CHILD, newTerminationReason);
  }

  public TerminationReason findTheTerminationReason(TerminationReason terminationReason) {

    int index = getTerminationReasonList().indexOf(terminationReason);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "TerminationReason("
              + terminationReason.getId()
              + ") with version='"
              + terminationReason.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getTerminationReasonList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpTerminationReasonList() {
    getTerminationReasonList().clear();
  }

  public SmartList<TerminationType> getTerminationTypeList() {
    if (this.mTerminationTypeList == null) {
      this.mTerminationTypeList = new SmartList<TerminationType>();
      this.mTerminationTypeList.setListInternalName(TERMINATION_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mTerminationTypeList;
  }

  public SmartList<TerminationType> terminationTypeList() {

    doLoadChild(TERMINATION_TYPE_LIST);

    return getTerminationTypeList();
  }

  public void setTerminationTypeList(SmartList<TerminationType> terminationTypeList) {
    for (TerminationType terminationType : terminationTypeList) {
      terminationType.setCompany(this);
    }

    this.mTerminationTypeList = terminationTypeList;
    this.mTerminationTypeList.setListInternalName(TERMINATION_TYPE_LIST);
  }

  public RetailStoreCountryCenter addTerminationType(TerminationType terminationType) {
    terminationType.updateCompany(this);
    getTerminationTypeList().add(terminationType);
    return this;
  }

  public RetailStoreCountryCenter addTerminationTypeList(
      SmartList<TerminationType> terminationTypeList) {
    for (TerminationType terminationType : terminationTypeList) {
      terminationType.updateCompany(this);
    }

    Map<String, TerminationType> mapById = terminationTypeList.mapWithId();
    getTerminationTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getTerminationTypeList().addAll(terminationTypeList);
    return this;
  }

  public void mergeTerminationTypeList(SmartList<TerminationType> terminationTypeList) {
    if (terminationTypeList == null) {
      return;
    }
    if (terminationTypeList.isEmpty()) {
      return;
    }
    addTerminationTypeList(terminationTypeList);
  }

  public TerminationType removeTerminationType(TerminationType terminationTypeIndex) {

    int index = getTerminationTypeList().indexOf(terminationTypeIndex);
    if (index < 0) {
      String message =
          "TerminationType("
              + terminationTypeIndex.getId()
              + ") with version='"
              + terminationTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    TerminationType terminationType = getTerminationTypeList().get(index);
    // terminationType.clearCompany(); //disconnect with Company
    terminationType.clearFromAll(); // disconnect with Company

    boolean result = getTerminationTypeList().planToRemove(terminationType);
    if (!result) {
      String message =
          "TerminationType("
              + terminationTypeIndex.getId()
              + ") with version='"
              + terminationTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return terminationType;
  }
  // 断舍离
  public void breakWithTerminationType(TerminationType terminationType) {

    if (terminationType == null) {
      return;
    }
    terminationType.setCompany(null);
    // getTerminationTypeList().remove();

  }

  public boolean hasTerminationType(TerminationType terminationType) {

    return getTerminationTypeList().contains(terminationType);
  }

  public void copyTerminationTypeFrom(TerminationType terminationType) {

    TerminationType terminationTypeInList = findTheTerminationType(terminationType);
    TerminationType newTerminationType = new TerminationType();
    terminationTypeInList.copyTo(newTerminationType);
    newTerminationType.setVersion(0); // will trigger copy
    getTerminationTypeList().add(newTerminationType);
    addItemToFlexiableObject(COPIED_CHILD, newTerminationType);
  }

  public TerminationType findTheTerminationType(TerminationType terminationType) {

    int index = getTerminationTypeList().indexOf(terminationType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "TerminationType("
              + terminationType.getId()
              + ") with version='"
              + terminationType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getTerminationTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpTerminationTypeList() {
    getTerminationTypeList().clear();
  }

  public SmartList<OccupationType> getOccupationTypeList() {
    if (this.mOccupationTypeList == null) {
      this.mOccupationTypeList = new SmartList<OccupationType>();
      this.mOccupationTypeList.setListInternalName(OCCUPATION_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mOccupationTypeList;
  }

  public SmartList<OccupationType> occupationTypeList() {

    doLoadChild(OCCUPATION_TYPE_LIST);

    return getOccupationTypeList();
  }

  public void setOccupationTypeList(SmartList<OccupationType> occupationTypeList) {
    for (OccupationType occupationType : occupationTypeList) {
      occupationType.setCompany(this);
    }

    this.mOccupationTypeList = occupationTypeList;
    this.mOccupationTypeList.setListInternalName(OCCUPATION_TYPE_LIST);
  }

  public RetailStoreCountryCenter addOccupationType(OccupationType occupationType) {
    occupationType.updateCompany(this);
    getOccupationTypeList().add(occupationType);
    return this;
  }

  public RetailStoreCountryCenter addOccupationTypeList(
      SmartList<OccupationType> occupationTypeList) {
    for (OccupationType occupationType : occupationTypeList) {
      occupationType.updateCompany(this);
    }

    Map<String, OccupationType> mapById = occupationTypeList.mapWithId();
    getOccupationTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getOccupationTypeList().addAll(occupationTypeList);
    return this;
  }

  public void mergeOccupationTypeList(SmartList<OccupationType> occupationTypeList) {
    if (occupationTypeList == null) {
      return;
    }
    if (occupationTypeList.isEmpty()) {
      return;
    }
    addOccupationTypeList(occupationTypeList);
  }

  public OccupationType removeOccupationType(OccupationType occupationTypeIndex) {

    int index = getOccupationTypeList().indexOf(occupationTypeIndex);
    if (index < 0) {
      String message =
          "OccupationType("
              + occupationTypeIndex.getId()
              + ") with version='"
              + occupationTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    OccupationType occupationType = getOccupationTypeList().get(index);
    // occupationType.clearCompany(); //disconnect with Company
    occupationType.clearFromAll(); // disconnect with Company

    boolean result = getOccupationTypeList().planToRemove(occupationType);
    if (!result) {
      String message =
          "OccupationType("
              + occupationTypeIndex.getId()
              + ") with version='"
              + occupationTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return occupationType;
  }
  // 断舍离
  public void breakWithOccupationType(OccupationType occupationType) {

    if (occupationType == null) {
      return;
    }
    occupationType.setCompany(null);
    // getOccupationTypeList().remove();

  }

  public boolean hasOccupationType(OccupationType occupationType) {

    return getOccupationTypeList().contains(occupationType);
  }

  public void copyOccupationTypeFrom(OccupationType occupationType) {

    OccupationType occupationTypeInList = findTheOccupationType(occupationType);
    OccupationType newOccupationType = new OccupationType();
    occupationTypeInList.copyTo(newOccupationType);
    newOccupationType.setVersion(0); // will trigger copy
    getOccupationTypeList().add(newOccupationType);
    addItemToFlexiableObject(COPIED_CHILD, newOccupationType);
  }

  public OccupationType findTheOccupationType(OccupationType occupationType) {

    int index = getOccupationTypeList().indexOf(occupationType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "OccupationType("
              + occupationType.getId()
              + ") with version='"
              + occupationType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getOccupationTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpOccupationTypeList() {
    getOccupationTypeList().clear();
  }

  public SmartList<LeaveType> getLeaveTypeList() {
    if (this.mLeaveTypeList == null) {
      this.mLeaveTypeList = new SmartList<LeaveType>();
      this.mLeaveTypeList.setListInternalName(LEAVE_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mLeaveTypeList;
  }

  public SmartList<LeaveType> leaveTypeList() {

    doLoadChild(LEAVE_TYPE_LIST);

    return getLeaveTypeList();
  }

  public void setLeaveTypeList(SmartList<LeaveType> leaveTypeList) {
    for (LeaveType leaveType : leaveTypeList) {
      leaveType.setCompany(this);
    }

    this.mLeaveTypeList = leaveTypeList;
    this.mLeaveTypeList.setListInternalName(LEAVE_TYPE_LIST);
  }

  public RetailStoreCountryCenter addLeaveType(LeaveType leaveType) {
    leaveType.updateCompany(this);
    getLeaveTypeList().add(leaveType);
    return this;
  }

  public RetailStoreCountryCenter addLeaveTypeList(SmartList<LeaveType> leaveTypeList) {
    for (LeaveType leaveType : leaveTypeList) {
      leaveType.updateCompany(this);
    }

    Map<String, LeaveType> mapById = leaveTypeList.mapWithId();
    getLeaveTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getLeaveTypeList().addAll(leaveTypeList);
    return this;
  }

  public void mergeLeaveTypeList(SmartList<LeaveType> leaveTypeList) {
    if (leaveTypeList == null) {
      return;
    }
    if (leaveTypeList.isEmpty()) {
      return;
    }
    addLeaveTypeList(leaveTypeList);
  }

  public LeaveType removeLeaveType(LeaveType leaveTypeIndex) {

    int index = getLeaveTypeList().indexOf(leaveTypeIndex);
    if (index < 0) {
      String message =
          "LeaveType("
              + leaveTypeIndex.getId()
              + ") with version='"
              + leaveTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    LeaveType leaveType = getLeaveTypeList().get(index);
    // leaveType.clearCompany(); //disconnect with Company
    leaveType.clearFromAll(); // disconnect with Company

    boolean result = getLeaveTypeList().planToRemove(leaveType);
    if (!result) {
      String message =
          "LeaveType("
              + leaveTypeIndex.getId()
              + ") with version='"
              + leaveTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return leaveType;
  }
  // 断舍离
  public void breakWithLeaveType(LeaveType leaveType) {

    if (leaveType == null) {
      return;
    }
    leaveType.setCompany(null);
    // getLeaveTypeList().remove();

  }

  public boolean hasLeaveType(LeaveType leaveType) {

    return getLeaveTypeList().contains(leaveType);
  }

  public void copyLeaveTypeFrom(LeaveType leaveType) {

    LeaveType leaveTypeInList = findTheLeaveType(leaveType);
    LeaveType newLeaveType = new LeaveType();
    leaveTypeInList.copyTo(newLeaveType);
    newLeaveType.setVersion(0); // will trigger copy
    getLeaveTypeList().add(newLeaveType);
    addItemToFlexiableObject(COPIED_CHILD, newLeaveType);
  }

  public LeaveType findTheLeaveType(LeaveType leaveType) {

    int index = getLeaveTypeList().indexOf(leaveType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "LeaveType("
              + leaveType.getId()
              + ") with version='"
              + leaveType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getLeaveTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpLeaveTypeList() {
    getLeaveTypeList().clear();
  }

  public SmartList<SalaryGrade> getSalaryGradeList() {
    if (this.mSalaryGradeList == null) {
      this.mSalaryGradeList = new SmartList<SalaryGrade>();
      this.mSalaryGradeList.setListInternalName(SALARY_GRADE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mSalaryGradeList;
  }

  public SmartList<SalaryGrade> salaryGradeList() {

    doLoadChild(SALARY_GRADE_LIST);

    return getSalaryGradeList();
  }

  public void setSalaryGradeList(SmartList<SalaryGrade> salaryGradeList) {
    for (SalaryGrade salaryGrade : salaryGradeList) {
      salaryGrade.setCompany(this);
    }

    this.mSalaryGradeList = salaryGradeList;
    this.mSalaryGradeList.setListInternalName(SALARY_GRADE_LIST);
  }

  public RetailStoreCountryCenter addSalaryGrade(SalaryGrade salaryGrade) {
    salaryGrade.updateCompany(this);
    getSalaryGradeList().add(salaryGrade);
    return this;
  }

  public RetailStoreCountryCenter addSalaryGradeList(SmartList<SalaryGrade> salaryGradeList) {
    for (SalaryGrade salaryGrade : salaryGradeList) {
      salaryGrade.updateCompany(this);
    }

    Map<String, SalaryGrade> mapById = salaryGradeList.mapWithId();
    getSalaryGradeList().removeIf(item -> mapById.get(item.getId()) != null);
    getSalaryGradeList().addAll(salaryGradeList);
    return this;
  }

  public void mergeSalaryGradeList(SmartList<SalaryGrade> salaryGradeList) {
    if (salaryGradeList == null) {
      return;
    }
    if (salaryGradeList.isEmpty()) {
      return;
    }
    addSalaryGradeList(salaryGradeList);
  }

  public SalaryGrade removeSalaryGrade(SalaryGrade salaryGradeIndex) {

    int index = getSalaryGradeList().indexOf(salaryGradeIndex);
    if (index < 0) {
      String message =
          "SalaryGrade("
              + salaryGradeIndex.getId()
              + ") with version='"
              + salaryGradeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    SalaryGrade salaryGrade = getSalaryGradeList().get(index);
    // salaryGrade.clearCompany(); //disconnect with Company
    salaryGrade.clearFromAll(); // disconnect with Company

    boolean result = getSalaryGradeList().planToRemove(salaryGrade);
    if (!result) {
      String message =
          "SalaryGrade("
              + salaryGradeIndex.getId()
              + ") with version='"
              + salaryGradeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return salaryGrade;
  }
  // 断舍离
  public void breakWithSalaryGrade(SalaryGrade salaryGrade) {

    if (salaryGrade == null) {
      return;
    }
    salaryGrade.setCompany(null);
    // getSalaryGradeList().remove();

  }

  public boolean hasSalaryGrade(SalaryGrade salaryGrade) {

    return getSalaryGradeList().contains(salaryGrade);
  }

  public void copySalaryGradeFrom(SalaryGrade salaryGrade) {

    SalaryGrade salaryGradeInList = findTheSalaryGrade(salaryGrade);
    SalaryGrade newSalaryGrade = new SalaryGrade();
    salaryGradeInList.copyTo(newSalaryGrade);
    newSalaryGrade.setVersion(0); // will trigger copy
    getSalaryGradeList().add(newSalaryGrade);
    addItemToFlexiableObject(COPIED_CHILD, newSalaryGrade);
  }

  public SalaryGrade findTheSalaryGrade(SalaryGrade salaryGrade) {

    int index = getSalaryGradeList().indexOf(salaryGrade);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "SalaryGrade("
              + salaryGrade.getId()
              + ") with version='"
              + salaryGrade.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getSalaryGradeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpSalaryGradeList() {
    getSalaryGradeList().clear();
  }

  public SmartList<InterviewType> getInterviewTypeList() {
    if (this.mInterviewTypeList == null) {
      this.mInterviewTypeList = new SmartList<InterviewType>();
      this.mInterviewTypeList.setListInternalName(INTERVIEW_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mInterviewTypeList;
  }

  public SmartList<InterviewType> interviewTypeList() {

    doLoadChild(INTERVIEW_TYPE_LIST);

    return getInterviewTypeList();
  }

  public void setInterviewTypeList(SmartList<InterviewType> interviewTypeList) {
    for (InterviewType interviewType : interviewTypeList) {
      interviewType.setCompany(this);
    }

    this.mInterviewTypeList = interviewTypeList;
    this.mInterviewTypeList.setListInternalName(INTERVIEW_TYPE_LIST);
  }

  public RetailStoreCountryCenter addInterviewType(InterviewType interviewType) {
    interviewType.updateCompany(this);
    getInterviewTypeList().add(interviewType);
    return this;
  }

  public RetailStoreCountryCenter addInterviewTypeList(SmartList<InterviewType> interviewTypeList) {
    for (InterviewType interviewType : interviewTypeList) {
      interviewType.updateCompany(this);
    }

    Map<String, InterviewType> mapById = interviewTypeList.mapWithId();
    getInterviewTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getInterviewTypeList().addAll(interviewTypeList);
    return this;
  }

  public void mergeInterviewTypeList(SmartList<InterviewType> interviewTypeList) {
    if (interviewTypeList == null) {
      return;
    }
    if (interviewTypeList.isEmpty()) {
      return;
    }
    addInterviewTypeList(interviewTypeList);
  }

  public InterviewType removeInterviewType(InterviewType interviewTypeIndex) {

    int index = getInterviewTypeList().indexOf(interviewTypeIndex);
    if (index < 0) {
      String message =
          "InterviewType("
              + interviewTypeIndex.getId()
              + ") with version='"
              + interviewTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    InterviewType interviewType = getInterviewTypeList().get(index);
    // interviewType.clearCompany(); //disconnect with Company
    interviewType.clearFromAll(); // disconnect with Company

    boolean result = getInterviewTypeList().planToRemove(interviewType);
    if (!result) {
      String message =
          "InterviewType("
              + interviewTypeIndex.getId()
              + ") with version='"
              + interviewTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return interviewType;
  }
  // 断舍离
  public void breakWithInterviewType(InterviewType interviewType) {

    if (interviewType == null) {
      return;
    }
    interviewType.setCompany(null);
    // getInterviewTypeList().remove();

  }

  public boolean hasInterviewType(InterviewType interviewType) {

    return getInterviewTypeList().contains(interviewType);
  }

  public void copyInterviewTypeFrom(InterviewType interviewType) {

    InterviewType interviewTypeInList = findTheInterviewType(interviewType);
    InterviewType newInterviewType = new InterviewType();
    interviewTypeInList.copyTo(newInterviewType);
    newInterviewType.setVersion(0); // will trigger copy
    getInterviewTypeList().add(newInterviewType);
    addItemToFlexiableObject(COPIED_CHILD, newInterviewType);
  }

  public InterviewType findTheInterviewType(InterviewType interviewType) {

    int index = getInterviewTypeList().indexOf(interviewType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "InterviewType("
              + interviewType.getId()
              + ") with version='"
              + interviewType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getInterviewTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpInterviewTypeList() {
    getInterviewTypeList().clear();
  }

  public SmartList<TrainingCourseType> getTrainingCourseTypeList() {
    if (this.mTrainingCourseTypeList == null) {
      this.mTrainingCourseTypeList = new SmartList<TrainingCourseType>();
      this.mTrainingCourseTypeList.setListInternalName(TRAINING_COURSE_TYPE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mTrainingCourseTypeList;
  }

  public SmartList<TrainingCourseType> trainingCourseTypeList() {

    doLoadChild(TRAINING_COURSE_TYPE_LIST);

    return getTrainingCourseTypeList();
  }

  public void setTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList) {
    for (TrainingCourseType trainingCourseType : trainingCourseTypeList) {
      trainingCourseType.setCompany(this);
    }

    this.mTrainingCourseTypeList = trainingCourseTypeList;
    this.mTrainingCourseTypeList.setListInternalName(TRAINING_COURSE_TYPE_LIST);
  }

  public RetailStoreCountryCenter addTrainingCourseType(TrainingCourseType trainingCourseType) {
    trainingCourseType.updateCompany(this);
    getTrainingCourseTypeList().add(trainingCourseType);
    return this;
  }

  public RetailStoreCountryCenter addTrainingCourseTypeList(
      SmartList<TrainingCourseType> trainingCourseTypeList) {
    for (TrainingCourseType trainingCourseType : trainingCourseTypeList) {
      trainingCourseType.updateCompany(this);
    }

    Map<String, TrainingCourseType> mapById = trainingCourseTypeList.mapWithId();
    getTrainingCourseTypeList().removeIf(item -> mapById.get(item.getId()) != null);
    getTrainingCourseTypeList().addAll(trainingCourseTypeList);
    return this;
  }

  public void mergeTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList) {
    if (trainingCourseTypeList == null) {
      return;
    }
    if (trainingCourseTypeList.isEmpty()) {
      return;
    }
    addTrainingCourseTypeList(trainingCourseTypeList);
  }

  public TrainingCourseType removeTrainingCourseType(TrainingCourseType trainingCourseTypeIndex) {

    int index = getTrainingCourseTypeList().indexOf(trainingCourseTypeIndex);
    if (index < 0) {
      String message =
          "TrainingCourseType("
              + trainingCourseTypeIndex.getId()
              + ") with version='"
              + trainingCourseTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    TrainingCourseType trainingCourseType = getTrainingCourseTypeList().get(index);
    // trainingCourseType.clearCompany(); //disconnect with Company
    trainingCourseType.clearFromAll(); // disconnect with Company

    boolean result = getTrainingCourseTypeList().planToRemove(trainingCourseType);
    if (!result) {
      String message =
          "TrainingCourseType("
              + trainingCourseTypeIndex.getId()
              + ") with version='"
              + trainingCourseTypeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return trainingCourseType;
  }
  // 断舍离
  public void breakWithTrainingCourseType(TrainingCourseType trainingCourseType) {

    if (trainingCourseType == null) {
      return;
    }
    trainingCourseType.setCompany(null);
    // getTrainingCourseTypeList().remove();

  }

  public boolean hasTrainingCourseType(TrainingCourseType trainingCourseType) {

    return getTrainingCourseTypeList().contains(trainingCourseType);
  }

  public void copyTrainingCourseTypeFrom(TrainingCourseType trainingCourseType) {

    TrainingCourseType trainingCourseTypeInList = findTheTrainingCourseType(trainingCourseType);
    TrainingCourseType newTrainingCourseType = new TrainingCourseType();
    trainingCourseTypeInList.copyTo(newTrainingCourseType);
    newTrainingCourseType.setVersion(0); // will trigger copy
    getTrainingCourseTypeList().add(newTrainingCourseType);
    addItemToFlexiableObject(COPIED_CHILD, newTrainingCourseType);
  }

  public TrainingCourseType findTheTrainingCourseType(TrainingCourseType trainingCourseType) {

    int index = getTrainingCourseTypeList().indexOf(trainingCourseType);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "TrainingCourseType("
              + trainingCourseType.getId()
              + ") with version='"
              + trainingCourseType.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getTrainingCourseTypeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpTrainingCourseTypeList() {
    getTrainingCourseTypeList().clear();
  }

  public SmartList<PublicHoliday> getPublicHolidayList() {
    if (this.mPublicHolidayList == null) {
      this.mPublicHolidayList = new SmartList<PublicHoliday>();
      this.mPublicHolidayList.setListInternalName(PUBLIC_HOLIDAY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mPublicHolidayList;
  }

  public SmartList<PublicHoliday> publicHolidayList() {

    doLoadChild(PUBLIC_HOLIDAY_LIST);

    return getPublicHolidayList();
  }

  public void setPublicHolidayList(SmartList<PublicHoliday> publicHolidayList) {
    for (PublicHoliday publicHoliday : publicHolidayList) {
      publicHoliday.setCompany(this);
    }

    this.mPublicHolidayList = publicHolidayList;
    this.mPublicHolidayList.setListInternalName(PUBLIC_HOLIDAY_LIST);
  }

  public RetailStoreCountryCenter addPublicHoliday(PublicHoliday publicHoliday) {
    publicHoliday.updateCompany(this);
    getPublicHolidayList().add(publicHoliday);
    return this;
  }

  public RetailStoreCountryCenter addPublicHolidayList(SmartList<PublicHoliday> publicHolidayList) {
    for (PublicHoliday publicHoliday : publicHolidayList) {
      publicHoliday.updateCompany(this);
    }

    Map<String, PublicHoliday> mapById = publicHolidayList.mapWithId();
    getPublicHolidayList().removeIf(item -> mapById.get(item.getId()) != null);
    getPublicHolidayList().addAll(publicHolidayList);
    return this;
  }

  public void mergePublicHolidayList(SmartList<PublicHoliday> publicHolidayList) {
    if (publicHolidayList == null) {
      return;
    }
    if (publicHolidayList.isEmpty()) {
      return;
    }
    addPublicHolidayList(publicHolidayList);
  }

  public PublicHoliday removePublicHoliday(PublicHoliday publicHolidayIndex) {

    int index = getPublicHolidayList().indexOf(publicHolidayIndex);
    if (index < 0) {
      String message =
          "PublicHoliday("
              + publicHolidayIndex.getId()
              + ") with version='"
              + publicHolidayIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    PublicHoliday publicHoliday = getPublicHolidayList().get(index);
    // publicHoliday.clearCompany(); //disconnect with Company
    publicHoliday.clearFromAll(); // disconnect with Company

    boolean result = getPublicHolidayList().planToRemove(publicHoliday);
    if (!result) {
      String message =
          "PublicHoliday("
              + publicHolidayIndex.getId()
              + ") with version='"
              + publicHolidayIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return publicHoliday;
  }
  // 断舍离
  public void breakWithPublicHoliday(PublicHoliday publicHoliday) {

    if (publicHoliday == null) {
      return;
    }
    publicHoliday.setCompany(null);
    // getPublicHolidayList().remove();

  }

  public boolean hasPublicHoliday(PublicHoliday publicHoliday) {

    return getPublicHolidayList().contains(publicHoliday);
  }

  public void copyPublicHolidayFrom(PublicHoliday publicHoliday) {

    PublicHoliday publicHolidayInList = findThePublicHoliday(publicHoliday);
    PublicHoliday newPublicHoliday = new PublicHoliday();
    publicHolidayInList.copyTo(newPublicHoliday);
    newPublicHoliday.setVersion(0); // will trigger copy
    getPublicHolidayList().add(newPublicHoliday);
    addItemToFlexiableObject(COPIED_CHILD, newPublicHoliday);
  }

  public PublicHoliday findThePublicHoliday(PublicHoliday publicHoliday) {

    int index = getPublicHolidayList().indexOf(publicHoliday);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "PublicHoliday("
              + publicHoliday.getId()
              + ") with version='"
              + publicHoliday.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getPublicHolidayList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpPublicHolidayList() {
    getPublicHolidayList().clear();
  }

  public SmartList<Employee> getEmployeeList() {
    if (this.mEmployeeList == null) {
      this.mEmployeeList = new SmartList<Employee>();
      this.mEmployeeList.setListInternalName(EMPLOYEE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEmployeeList;
  }

  public SmartList<Employee> employeeList() {

    doLoadChild(EMPLOYEE_LIST);

    return getEmployeeList();
  }

  public void setEmployeeList(SmartList<Employee> employeeList) {
    for (Employee employee : employeeList) {
      employee.setCompany(this);
    }

    this.mEmployeeList = employeeList;
    this.mEmployeeList.setListInternalName(EMPLOYEE_LIST);
  }

  public RetailStoreCountryCenter addEmployee(Employee employee) {
    employee.updateCompany(this);
    getEmployeeList().add(employee);
    return this;
  }

  public RetailStoreCountryCenter addEmployeeList(SmartList<Employee> employeeList) {
    for (Employee employee : employeeList) {
      employee.updateCompany(this);
    }

    Map<String, Employee> mapById = employeeList.mapWithId();
    getEmployeeList().removeIf(item -> mapById.get(item.getId()) != null);
    getEmployeeList().addAll(employeeList);
    return this;
  }

  public void mergeEmployeeList(SmartList<Employee> employeeList) {
    if (employeeList == null) {
      return;
    }
    if (employeeList.isEmpty()) {
      return;
    }
    addEmployeeList(employeeList);
  }

  public Employee removeEmployee(Employee employeeIndex) {

    int index = getEmployeeList().indexOf(employeeIndex);
    if (index < 0) {
      String message =
          "Employee("
              + employeeIndex.getId()
              + ") with version='"
              + employeeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Employee employee = getEmployeeList().get(index);
    // employee.clearCompany(); //disconnect with Company
    employee.clearFromAll(); // disconnect with Company

    boolean result = getEmployeeList().planToRemove(employee);
    if (!result) {
      String message =
          "Employee("
              + employeeIndex.getId()
              + ") with version='"
              + employeeIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return employee;
  }
  // 断舍离
  public void breakWithEmployee(Employee employee) {

    if (employee == null) {
      return;
    }
    employee.setCompany(null);
    // getEmployeeList().remove();

  }

  public boolean hasEmployee(Employee employee) {

    return getEmployeeList().contains(employee);
  }

  public void copyEmployeeFrom(Employee employee) {

    Employee employeeInList = findTheEmployee(employee);
    Employee newEmployee = new Employee();
    employeeInList.copyTo(newEmployee);
    newEmployee.setVersion(0); // will trigger copy
    getEmployeeList().add(newEmployee);
    addItemToFlexiableObject(COPIED_CHILD, newEmployee);
  }

  public Employee findTheEmployee(Employee employee) {

    int index = getEmployeeList().indexOf(employee);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Employee("
              + employee.getId()
              + ") with version='"
              + employee.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEmployeeList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEmployeeList() {
    getEmployeeList().clear();
  }

  public SmartList<Instructor> getInstructorList() {
    if (this.mInstructorList == null) {
      this.mInstructorList = new SmartList<Instructor>();
      this.mInstructorList.setListInternalName(INSTRUCTOR_LIST);
      // 有名字，便于做权限控制
    }

    return this.mInstructorList;
  }

  public SmartList<Instructor> instructorList() {

    doLoadChild(INSTRUCTOR_LIST);

    return getInstructorList();
  }

  public void setInstructorList(SmartList<Instructor> instructorList) {
    for (Instructor instructor : instructorList) {
      instructor.setCompany(this);
    }

    this.mInstructorList = instructorList;
    this.mInstructorList.setListInternalName(INSTRUCTOR_LIST);
  }

  public RetailStoreCountryCenter addInstructor(Instructor instructor) {
    instructor.updateCompany(this);
    getInstructorList().add(instructor);
    return this;
  }

  public RetailStoreCountryCenter addInstructorList(SmartList<Instructor> instructorList) {
    for (Instructor instructor : instructorList) {
      instructor.updateCompany(this);
    }

    Map<String, Instructor> mapById = instructorList.mapWithId();
    getInstructorList().removeIf(item -> mapById.get(item.getId()) != null);
    getInstructorList().addAll(instructorList);
    return this;
  }

  public void mergeInstructorList(SmartList<Instructor> instructorList) {
    if (instructorList == null) {
      return;
    }
    if (instructorList.isEmpty()) {
      return;
    }
    addInstructorList(instructorList);
  }

  public Instructor removeInstructor(Instructor instructorIndex) {

    int index = getInstructorList().indexOf(instructorIndex);
    if (index < 0) {
      String message =
          "Instructor("
              + instructorIndex.getId()
              + ") with version='"
              + instructorIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Instructor instructor = getInstructorList().get(index);
    // instructor.clearCompany(); //disconnect with Company
    instructor.clearFromAll(); // disconnect with Company

    boolean result = getInstructorList().planToRemove(instructor);
    if (!result) {
      String message =
          "Instructor("
              + instructorIndex.getId()
              + ") with version='"
              + instructorIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return instructor;
  }
  // 断舍离
  public void breakWithInstructor(Instructor instructor) {

    if (instructor == null) {
      return;
    }
    instructor.setCompany(null);
    // getInstructorList().remove();

  }

  public boolean hasInstructor(Instructor instructor) {

    return getInstructorList().contains(instructor);
  }

  public void copyInstructorFrom(Instructor instructor) {

    Instructor instructorInList = findTheInstructor(instructor);
    Instructor newInstructor = new Instructor();
    instructorInList.copyTo(newInstructor);
    newInstructor.setVersion(0); // will trigger copy
    getInstructorList().add(newInstructor);
    addItemToFlexiableObject(COPIED_CHILD, newInstructor);
  }

  public Instructor findTheInstructor(Instructor instructor) {

    int index = getInstructorList().indexOf(instructor);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Instructor("
              + instructor.getId()
              + ") with version='"
              + instructor.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getInstructorList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpInstructorList() {
    getInstructorList().clear();
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
      companyTraining.setCompany(this);
    }

    this.mCompanyTrainingList = companyTrainingList;
    this.mCompanyTrainingList.setListInternalName(COMPANY_TRAINING_LIST);
  }

  public RetailStoreCountryCenter addCompanyTraining(CompanyTraining companyTraining) {
    companyTraining.updateCompany(this);
    getCompanyTrainingList().add(companyTraining);
    return this;
  }

  public RetailStoreCountryCenter addCompanyTrainingList(
      SmartList<CompanyTraining> companyTrainingList) {
    for (CompanyTraining companyTraining : companyTrainingList) {
      companyTraining.updateCompany(this);
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
    // companyTraining.clearCompany(); //disconnect with Company
    companyTraining.clearFromAll(); // disconnect with Company

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
    companyTraining.setCompany(null);
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
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {}

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getCatalogList(), internalType);
    collectFromList(this, entityList, getRetailStoreProvinceCenterList(), internalType);
    collectFromList(this, entityList, getRetailStoreList(), internalType);
    collectFromList(this, entityList, getRetailStoreMemberList(), internalType);
    collectFromList(this, entityList, getGoodsSupplierList(), internalType);
    collectFromList(this, entityList, getSupplyOrderList(), internalType);
    collectFromList(this, entityList, getRetailStoreOrderList(), internalType);
    collectFromList(this, entityList, getWarehouseList(), internalType);
    collectFromList(this, entityList, getTransportFleetList(), internalType);
    collectFromList(this, entityList, getAccountSetList(), internalType);
    collectFromList(this, entityList, getLevelOneDepartmentList(), internalType);
    collectFromList(this, entityList, getSkillTypeList(), internalType);
    collectFromList(this, entityList, getResponsibilityTypeList(), internalType);
    collectFromList(this, entityList, getTerminationReasonList(), internalType);
    collectFromList(this, entityList, getTerminationTypeList(), internalType);
    collectFromList(this, entityList, getOccupationTypeList(), internalType);
    collectFromList(this, entityList, getLeaveTypeList(), internalType);
    collectFromList(this, entityList, getSalaryGradeList(), internalType);
    collectFromList(this, entityList, getInterviewTypeList(), internalType);
    collectFromList(this, entityList, getTrainingCourseTypeList(), internalType);
    collectFromList(this, entityList, getPublicHolidayList(), internalType);
    collectFromList(this, entityList, getEmployeeList(), internalType);
    collectFromList(this, entityList, getInstructorList(), internalType);
    collectFromList(this, entityList, getCompanyTrainingList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getCatalogList());
    listOfList.add(getRetailStoreProvinceCenterList());
    listOfList.add(getRetailStoreList());
    listOfList.add(getRetailStoreMemberList());
    listOfList.add(getGoodsSupplierList());
    listOfList.add(getSupplyOrderList());
    listOfList.add(getRetailStoreOrderList());
    listOfList.add(getWarehouseList());
    listOfList.add(getTransportFleetList());
    listOfList.add(getAccountSetList());
    listOfList.add(getLevelOneDepartmentList());
    listOfList.add(getSkillTypeList());
    listOfList.add(getResponsibilityTypeList());
    listOfList.add(getTerminationReasonList());
    listOfList.add(getTerminationTypeList());
    listOfList.add(getOccupationTypeList());
    listOfList.add(getLeaveTypeList());
    listOfList.add(getSalaryGradeList());
    listOfList.add(getInterviewTypeList());
    listOfList.add(getTrainingCourseTypeList());
    listOfList.add(getPublicHolidayList());
    listOfList.add(getEmployeeList());
    listOfList.add(getInstructorList());
    listOfList.add(getCompanyTrainingList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, NAME_PROPERTY, getName());
    appendKeyValuePair(result, SERVICE_NUMBER_PROPERTY, getServiceNumber());
    appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
    appendKeyValuePair(result, WEB_SITE_PROPERTY, getWebSite());
    appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
    appendKeyValuePair(result, OPERATED_BY_PROPERTY, getOperatedBy());
    appendKeyValuePair(result, LEGAL_REPRESENTATIVE_PROPERTY, getLegalRepresentative());
    appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, CATALOG_LIST, getCatalogList());
    if (!getCatalogList().isEmpty()) {
      appendKeyValuePair(result, "catalogCount", getCatalogList().getTotalCount());
      appendKeyValuePair(
          result, "catalogCurrentPageNumber", getCatalogList().getCurrentPageNumber());
    }
    appendKeyValuePair(
        result, RETAIL_STORE_PROVINCE_CENTER_LIST, getRetailStoreProvinceCenterList());
    if (!getRetailStoreProvinceCenterList().isEmpty()) {
      appendKeyValuePair(
          result,
          "retailStoreProvinceCenterCount",
          getRetailStoreProvinceCenterList().getTotalCount());
      appendKeyValuePair(
          result,
          "retailStoreProvinceCenterCurrentPageNumber",
          getRetailStoreProvinceCenterList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, RETAIL_STORE_LIST, getRetailStoreList());
    if (!getRetailStoreList().isEmpty()) {
      appendKeyValuePair(result, "retailStoreCount", getRetailStoreList().getTotalCount());
      appendKeyValuePair(
          result, "retailStoreCurrentPageNumber", getRetailStoreList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, RETAIL_STORE_MEMBER_LIST, getRetailStoreMemberList());
    if (!getRetailStoreMemberList().isEmpty()) {
      appendKeyValuePair(
          result, "retailStoreMemberCount", getRetailStoreMemberList().getTotalCount());
      appendKeyValuePair(
          result,
          "retailStoreMemberCurrentPageNumber",
          getRetailStoreMemberList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, GOODS_SUPPLIER_LIST, getGoodsSupplierList());
    if (!getGoodsSupplierList().isEmpty()) {
      appendKeyValuePair(result, "goodsSupplierCount", getGoodsSupplierList().getTotalCount());
      appendKeyValuePair(
          result, "goodsSupplierCurrentPageNumber", getGoodsSupplierList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, SUPPLY_ORDER_LIST, getSupplyOrderList());
    if (!getSupplyOrderList().isEmpty()) {
      appendKeyValuePair(result, "supplyOrderCount", getSupplyOrderList().getTotalCount());
      appendKeyValuePair(
          result, "supplyOrderCurrentPageNumber", getSupplyOrderList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, RETAIL_STORE_ORDER_LIST, getRetailStoreOrderList());
    if (!getRetailStoreOrderList().isEmpty()) {
      appendKeyValuePair(
          result, "retailStoreOrderCount", getRetailStoreOrderList().getTotalCount());
      appendKeyValuePair(
          result,
          "retailStoreOrderCurrentPageNumber",
          getRetailStoreOrderList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, WAREHOUSE_LIST, getWarehouseList());
    if (!getWarehouseList().isEmpty()) {
      appendKeyValuePair(result, "warehouseCount", getWarehouseList().getTotalCount());
      appendKeyValuePair(
          result, "warehouseCurrentPageNumber", getWarehouseList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, TRANSPORT_FLEET_LIST, getTransportFleetList());
    if (!getTransportFleetList().isEmpty()) {
      appendKeyValuePair(result, "transportFleetCount", getTransportFleetList().getTotalCount());
      appendKeyValuePair(
          result,
          "transportFleetCurrentPageNumber",
          getTransportFleetList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, ACCOUNT_SET_LIST, getAccountSetList());
    if (!getAccountSetList().isEmpty()) {
      appendKeyValuePair(result, "accountSetCount", getAccountSetList().getTotalCount());
      appendKeyValuePair(
          result, "accountSetCurrentPageNumber", getAccountSetList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, LEVEL_ONE_DEPARTMENT_LIST, getLevelOneDepartmentList());
    if (!getLevelOneDepartmentList().isEmpty()) {
      appendKeyValuePair(
          result, "levelOneDepartmentCount", getLevelOneDepartmentList().getTotalCount());
      appendKeyValuePair(
          result,
          "levelOneDepartmentCurrentPageNumber",
          getLevelOneDepartmentList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, SKILL_TYPE_LIST, getSkillTypeList());
    if (!getSkillTypeList().isEmpty()) {
      appendKeyValuePair(result, "skillTypeCount", getSkillTypeList().getTotalCount());
      appendKeyValuePair(
          result, "skillTypeCurrentPageNumber", getSkillTypeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, RESPONSIBILITY_TYPE_LIST, getResponsibilityTypeList());
    if (!getResponsibilityTypeList().isEmpty()) {
      appendKeyValuePair(
          result, "responsibilityTypeCount", getResponsibilityTypeList().getTotalCount());
      appendKeyValuePair(
          result,
          "responsibilityTypeCurrentPageNumber",
          getResponsibilityTypeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, TERMINATION_REASON_LIST, getTerminationReasonList());
    if (!getTerminationReasonList().isEmpty()) {
      appendKeyValuePair(
          result, "terminationReasonCount", getTerminationReasonList().getTotalCount());
      appendKeyValuePair(
          result,
          "terminationReasonCurrentPageNumber",
          getTerminationReasonList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, TERMINATION_TYPE_LIST, getTerminationTypeList());
    if (!getTerminationTypeList().isEmpty()) {
      appendKeyValuePair(result, "terminationTypeCount", getTerminationTypeList().getTotalCount());
      appendKeyValuePair(
          result,
          "terminationTypeCurrentPageNumber",
          getTerminationTypeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, OCCUPATION_TYPE_LIST, getOccupationTypeList());
    if (!getOccupationTypeList().isEmpty()) {
      appendKeyValuePair(result, "occupationTypeCount", getOccupationTypeList().getTotalCount());
      appendKeyValuePair(
          result,
          "occupationTypeCurrentPageNumber",
          getOccupationTypeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, LEAVE_TYPE_LIST, getLeaveTypeList());
    if (!getLeaveTypeList().isEmpty()) {
      appendKeyValuePair(result, "leaveTypeCount", getLeaveTypeList().getTotalCount());
      appendKeyValuePair(
          result, "leaveTypeCurrentPageNumber", getLeaveTypeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, SALARY_GRADE_LIST, getSalaryGradeList());
    if (!getSalaryGradeList().isEmpty()) {
      appendKeyValuePair(result, "salaryGradeCount", getSalaryGradeList().getTotalCount());
      appendKeyValuePair(
          result, "salaryGradeCurrentPageNumber", getSalaryGradeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, INTERVIEW_TYPE_LIST, getInterviewTypeList());
    if (!getInterviewTypeList().isEmpty()) {
      appendKeyValuePair(result, "interviewTypeCount", getInterviewTypeList().getTotalCount());
      appendKeyValuePair(
          result, "interviewTypeCurrentPageNumber", getInterviewTypeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, TRAINING_COURSE_TYPE_LIST, getTrainingCourseTypeList());
    if (!getTrainingCourseTypeList().isEmpty()) {
      appendKeyValuePair(
          result, "trainingCourseTypeCount", getTrainingCourseTypeList().getTotalCount());
      appendKeyValuePair(
          result,
          "trainingCourseTypeCurrentPageNumber",
          getTrainingCourseTypeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, PUBLIC_HOLIDAY_LIST, getPublicHolidayList());
    if (!getPublicHolidayList().isEmpty()) {
      appendKeyValuePair(result, "publicHolidayCount", getPublicHolidayList().getTotalCount());
      appendKeyValuePair(
          result, "publicHolidayCurrentPageNumber", getPublicHolidayList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
    if (!getEmployeeList().isEmpty()) {
      appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
      appendKeyValuePair(
          result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, INSTRUCTOR_LIST, getInstructorList());
    if (!getInstructorList().isEmpty()) {
      appendKeyValuePair(result, "instructorCount", getInstructorList().getTotalCount());
      appendKeyValuePair(
          result, "instructorCurrentPageNumber", getInstructorList().getCurrentPageNumber());
    }
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
    if (baseDest instanceof RetailStoreCountryCenter) {

      RetailStoreCountryCenter dest = (RetailStoreCountryCenter) baseDest;

      dest.setId(getId());
      dest.setName(getName());
      dest.setServiceNumber(getServiceNumber());
      dest.setFounded(getFounded());
      dest.setWebSite(getWebSite());
      dest.setAddress(getAddress());
      dest.setOperatedBy(getOperatedBy());
      dest.setLegalRepresentative(getLegalRepresentative());
      dest.setDescription(getDescription());
      dest.setVersion(getVersion());
      dest.setCatalogList(getCatalogList());
      dest.setRetailStoreProvinceCenterList(getRetailStoreProvinceCenterList());
      dest.setRetailStoreList(getRetailStoreList());
      dest.setRetailStoreMemberList(getRetailStoreMemberList());
      dest.setGoodsSupplierList(getGoodsSupplierList());
      dest.setSupplyOrderList(getSupplyOrderList());
      dest.setRetailStoreOrderList(getRetailStoreOrderList());
      dest.setWarehouseList(getWarehouseList());
      dest.setTransportFleetList(getTransportFleetList());
      dest.setAccountSetList(getAccountSetList());
      dest.setLevelOneDepartmentList(getLevelOneDepartmentList());
      dest.setSkillTypeList(getSkillTypeList());
      dest.setResponsibilityTypeList(getResponsibilityTypeList());
      dest.setTerminationReasonList(getTerminationReasonList());
      dest.setTerminationTypeList(getTerminationTypeList());
      dest.setOccupationTypeList(getOccupationTypeList());
      dest.setLeaveTypeList(getLeaveTypeList());
      dest.setSalaryGradeList(getSalaryGradeList());
      dest.setInterviewTypeList(getInterviewTypeList());
      dest.setTrainingCourseTypeList(getTrainingCourseTypeList());
      dest.setPublicHolidayList(getPublicHolidayList());
      dest.setEmployeeList(getEmployeeList());
      dest.setInstructorList(getInstructorList());
      dest.setCompanyTrainingList(getCompanyTrainingList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof RetailStoreCountryCenter) {

      RetailStoreCountryCenter source = (RetailStoreCountryCenter) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeServiceNumber(source.getServiceNumber());
      mergeFounded(source.getFounded());
      mergeWebSite(source.getWebSite());
      mergeAddress(source.getAddress());
      mergeOperatedBy(source.getOperatedBy());
      mergeLegalRepresentative(source.getLegalRepresentative());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
      mergeCatalogList(source.getCatalogList());
      mergeRetailStoreProvinceCenterList(source.getRetailStoreProvinceCenterList());
      mergeRetailStoreList(source.getRetailStoreList());
      mergeRetailStoreMemberList(source.getRetailStoreMemberList());
      mergeGoodsSupplierList(source.getGoodsSupplierList());
      mergeSupplyOrderList(source.getSupplyOrderList());
      mergeRetailStoreOrderList(source.getRetailStoreOrderList());
      mergeWarehouseList(source.getWarehouseList());
      mergeTransportFleetList(source.getTransportFleetList());
      mergeAccountSetList(source.getAccountSetList());
      mergeLevelOneDepartmentList(source.getLevelOneDepartmentList());
      mergeSkillTypeList(source.getSkillTypeList());
      mergeResponsibilityTypeList(source.getResponsibilityTypeList());
      mergeTerminationReasonList(source.getTerminationReasonList());
      mergeTerminationTypeList(source.getTerminationTypeList());
      mergeOccupationTypeList(source.getOccupationTypeList());
      mergeLeaveTypeList(source.getLeaveTypeList());
      mergeSalaryGradeList(source.getSalaryGradeList());
      mergeInterviewTypeList(source.getInterviewTypeList());
      mergeTrainingCourseTypeList(source.getTrainingCourseTypeList());
      mergePublicHolidayList(source.getPublicHolidayList());
      mergeEmployeeList(source.getEmployeeList());
      mergeInstructorList(source.getInstructorList());
      mergeCompanyTrainingList(source.getCompanyTrainingList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof RetailStoreCountryCenter) {

      RetailStoreCountryCenter source = (RetailStoreCountryCenter) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeServiceNumber(source.getServiceNumber());
      mergeFounded(source.getFounded());
      mergeWebSite(source.getWebSite());
      mergeAddress(source.getAddress());
      mergeOperatedBy(source.getOperatedBy());
      mergeLegalRepresentative(source.getLegalRepresentative());
      mergeDescription(source.getDescription());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getName(),
      getServiceNumber(),
      getFounded(),
      getWebSite(),
      getAddress(),
      getOperatedBy(),
      getLegalRepresentative(),
      getDescription(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    RetailStoreCountryCenter checkRetailStoreCountryCenter =
        Q.retailStoreCountryCenterWithIdField()
            .filterById(id)
            .selectCatalogList(Q.catalogWithIdField().limit(0, 1))
            .selectRetailStoreProvinceCenterList(
                Q.retailStoreProvinceCenterWithIdField().limit(0, 1))
            .selectRetailStoreList(Q.retailStoreWithIdField().limit(0, 1))
            .selectRetailStoreMemberList(Q.retailStoreMemberWithIdField().limit(0, 1))
            .selectGoodsSupplierList(Q.goodsSupplierWithIdField().limit(0, 1))
            .selectSupplyOrderList(Q.supplyOrderWithIdField().limit(0, 1))
            .selectRetailStoreOrderList(Q.retailStoreOrderWithIdField().limit(0, 1))
            .selectWarehouseList(Q.warehouseWithIdField().limit(0, 1))
            .selectTransportFleetList(Q.transportFleetWithIdField().limit(0, 1))
            .selectAccountSetList(Q.accountSetWithIdField().limit(0, 1))
            .selectLevelOneDepartmentList(Q.levelOneDepartmentWithIdField().limit(0, 1))
            .selectSkillTypeList(Q.skillTypeWithIdField().limit(0, 1))
            .selectResponsibilityTypeList(Q.responsibilityTypeWithIdField().limit(0, 1))
            .selectTerminationReasonList(Q.terminationReasonWithIdField().limit(0, 1))
            .selectTerminationTypeList(Q.terminationTypeWithIdField().limit(0, 1))
            .selectOccupationTypeList(Q.occupationTypeWithIdField().limit(0, 1))
            .selectLeaveTypeList(Q.leaveTypeWithIdField().limit(0, 1))
            .selectSalaryGradeList(Q.salaryGradeWithIdField().limit(0, 1))
            .selectInterviewTypeList(Q.interviewTypeWithIdField().limit(0, 1))
            .selectTrainingCourseTypeList(Q.trainingCourseTypeWithIdField().limit(0, 1))
            .selectPublicHolidayList(Q.publicHolidayWithIdField().limit(0, 1))
            .selectEmployeeList(Q.employeeWithIdField().limit(0, 1))
            .selectInstructorList(Q.instructorWithIdField().limit(0, 1))
            .selectCompanyTrainingList(Q.companyTrainingWithIdField().limit(0, 1))
            .execute(ctx);

    return checkRetailStoreCountryCenter != null
        && !checkRetailStoreCountryCenter.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public RetailStoreCountryCenter save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("RetailStoreCountryCenter{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tserviceNumber='" + getServiceNumber() + "';");
    stringBuilder.append("\tfounded='" + getFounded() + "';");
    stringBuilder.append("\twebSite='" + getWebSite() + "';");
    stringBuilder.append("\taddress='" + getAddress() + "';");
    stringBuilder.append("\toperatedBy='" + getOperatedBy() + "';");
    stringBuilder.append("\tlegalRepresentative='" + getLegalRepresentative() + "';");
    stringBuilder.append("\tdescription='" + getDescription() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
